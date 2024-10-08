package org.jeecg.common.util;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

/**
 * <p>Created by Raofeicheng on 2018/2/7.</p>
 * @author Raofeicheng
 * @version 1.0
 */
public class OkHttpUtils {

	public static final String CONTENT_TYPE_APP_JSON = "application/json; charset=UTF-8";
	public static final String CONTENT_TYPE_TEXT_JSON = "text/json; charset=UTF-8";

	public static String getJson(String url) {
		return getJson(url, new HashMap<>());
	}

	public static String getJson(String url, Map<String, String> queryParams) {
		return get(url, queryParams, CONTENT_TYPE_APP_JSON, null);
	}

	public static String get(String url) {
		return get(url, null, null, null);
	}

	public static String get(String url, Map<String, String> header) {
		return get(url, null, null, header);
	}

	public static String get(String url, Map<String, String> queryParams, String contentType, Map<String, String> header) {
		try {
			Response response = getResponse(HttpMethod.GET, url, queryParams, contentType, header);
			return getResponseString(response);
		} catch (Exception e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	public static String post(String url, Map<String, String> queryParams) {
		return post(url, queryParams, null, null);
	}

	public static String post(String url, Map<String, String> queryParams, String contentType, Map<String, String> header) {
		try {
			Response response = getResponse(HttpMethod.POST, url, queryParams, contentType, header);
			return getResponseString(response);
		} catch (Exception e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	public static InputStream download(String url) {
		return download(HttpMethod.GET, url, null, null);
	}

	public static InputStream download(HttpMethod method, String url, Map<String, String> queryParams, Map<String, String> header) {
		try {
			Response response = getResponse(method, url, queryParams, null, header);
			ResponseBody body = response.body();
			return null != body ? body.byteStream() : null;
		} catch (Exception e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	public static Response getResponse(HttpMethod method, String url, Map<String, String> queryParams, String contentType, Map<String, String> header) {
		if (!okhttp3.internal.http.HttpMethod.permitsRequestBody(method.name()) && MapUtils.isNotEmpty(queryParams)) {
			List<String> list = new ArrayList<>();
			for (Map.Entry<String, String> entry : queryParams.entrySet()) {
				list.add(String.format("%s=%s", CommonUtils.urlEncode(entry.getKey()), CommonUtils.urlEncode(entry.getValue())));
			}
			if (!list.isEmpty()) url = String.format("%s%s%s", url, StringUtils.contains(url, "?") ? "&" : "?", StringUtils.join(list, "&"));
		}
		Request.Builder request = new Request.Builder();
		if (okhttp3.internal.http.HttpMethod.permitsRequestBody(method.name()) && MapUtils.isNotEmpty(queryParams)) {
			FormBody.Builder builder = new FormBody.Builder();
			for (Map.Entry<String, String> entry : queryParams.entrySet()) builder.add(entry.getKey(), entry.getValue());
			request.method(method.name(), builder.build());
		}
		Set<String> existsHeader = new HashSet<>();
		request.url(url);
		if (MapUtils.isNotEmpty(header)) {
			for (Map.Entry<String, String> entry : header.entrySet()) {
				request.addHeader(entry.getKey(), entry.getValue());
				existsHeader.add(entry.getKey().toLowerCase());
			}
		}
		if (!existsHeader.contains("accept") && StringUtils.isNotBlank(contentType)) request.addHeader("Accept", contentType);
		if (!existsHeader.contains("accept-language")) request.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
		if (!existsHeader.contains("user-agent"))
			request.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko)" +
				" Chrome/58.0.3029.110 Safari/537.36 SE 2.X MetaSr 1.0");
		try {
			return httpClient.newCall(request.build()).execute();
		} catch (Exception e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	public static String post(String url, String content, String contentType, Map<String, String> header) {
		if (null == header) header = new HashMap<>();
		contentType = StringUtils.defaultIfBlank(contentType, CONTENT_TYPE_APP_JSON);
		Request.Builder request = new Request.Builder();
		request.url(url);
		for (Map.Entry<String, String> entry : header.entrySet()) request.addHeader(entry.getKey(), entry.getValue());
		request.post(FormBody.create(content, MediaType.parse(contentType)));
		try {
			Response response = httpClient.newCall(request.build()).execute();
			return getResponseString(response);
		} catch (Exception e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	protected static String getResponseString(Response response) throws IOException {
		ResponseBody body = response.body();
		return null != body ? body.string() : "";
	}

	private static OkHttpClient httpClient;

	static {
		try {
			X509TrustManager manager = new X509TrustManager() {
				public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
				}

				public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
				}

				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return new java.security.cert.X509Certificate[]{};
				}
			};
			TrustManager[] trustAllCerts = new TrustManager[]{manager};
			SSLContext sslContext = SSLContext.getInstance("SSL");
			sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
			httpClient = new OkHttpClient.Builder()
				//.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8888)))
				//.cookieJar(new CookieJarImpl(new MemoryCookieStore()))
				.sslSocketFactory(sslContext.getSocketFactory(), manager)
				.hostnameVerifier((s, sslSession) -> true)
				.build();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		Map<String, String> header = new LinkedHashMap<>();
		header.put("Accept", CONTENT_TYPE_TEXT_JSON);
		header.put("userName", "xinfang");
		header.put("password", "######$$$$$$");//	xfhh1234
		String str = post("http://rao-pc:9527/gxmzxf/admin/login", "{sd:''}", CONTENT_TYPE_TEXT_JSON, header);
		System.out.println(str);
		header.clear();
		header.put("username", "admin");
		header.put("password", "admin");
		str = getJson("http://rao-pc:9527/gxmzxf/admin/login", header);
		System.out.println(str);
	}

}
