package org.jeecg.modules.demo.dzzz.homepage.util.zzUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpRequestApi {

    public String sendRequest(Map<String,String> map) throws IOException {
        URL url = new URL(map.get("apiUrl"));
        StringBuilder response = new StringBuilder();

        // 打开连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // 设置请求方法为POST
        connection.setRequestMethod("POST");

        // 设置请求头
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("accessKey", map.get("accessKey"));
        connection.setRequestProperty("accessSecret", map.get("accessSecret"));

        // 启用输入输出
        connection.setDoOutput(true);

        // 将JSON对象转换为字节数组并发送请求体
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = map.get("jsonObject").toString().getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // 获取响应代码
        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            // 读取响应内容
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;


                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }
        } else {
            throw new IOException("HTTP POST request failed with response code: " + responseCode);
        }


        return response.toString();
    }

}
