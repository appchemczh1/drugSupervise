package org.jeecg.modules.demo.dzzz.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.jeecg.common.util.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.RectangleReadOnly;
import com.itextpdf.text.pdf.PdfWriter;
import com.suwell.ofd.custom.wrapper.io.IOTools;

/**
 * @Author lanhezhong
 * @Date 2022/3/14
 */
public class ImgToPdfUtil {

	private static final Logger log = LoggerFactory.getLogger(ImgToPdfUtil.class);

	public static String imageToPdf(String source, String target, String paperType, int maxWidth, int maxHeight) {
		FileOutputStream out = null;
		try {
			Image img;
			byte[] bytes = scaleToBytes(source, maxWidth, maxHeight);
			if (null != bytes) img = Image.getInstance(bytes);
			else img = Image.getInstance(source);
			// pdf最大的尺寸，超过该尺寸itextpdf会报错 new RectangleReadOnly(14400F, 14400F)
			Rectangle size = img.getScaledWidth() > img.getScaledHeight() ? new RectangleReadOnly(842, 595) : PageSize.A4;
			if (StringUtils.equalsAnyIgnoreCase(paperType, "1", "A3"))
				size = img.getScaledWidth() > img.getScaledHeight() ? new RectangleReadOnly(1191, 842) : PageSize.A3;
			if (img.getScaledWidth() > size.getWidth() || img.getScaledHeight() > size.getHeight())
				img.scaleToFit(size);
			float x = (size.getWidth() - img.getScaledWidth()) / 2,
				y = (size.getHeight() - img.getScaledHeight()) / 2;
			img.setAbsolutePosition(x, y);
			img.setScaleToFitHeight(false);
			Document doc = new Document(size, 0, 0, 0, 0);
			out = new FileOutputStream(target);
			PdfWriter.getInstance(doc, out);
			doc.open();
			doc.newPage();
			doc.add(img);
			doc.close();
			out.flush();
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
			return StringUtils.defaultIfBlank(e.getMessage(), "图片转pdf失败");
		} finally {
			IOTools.closeQuietly(out);
		}
		return null;
	}

	public static byte[] scaleToBytes(String source, int maxWidth, int maxHeight) {
		try (FileInputStream in = new FileInputStream(source); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			BufferedImage originalImage = ImageIO.read(in);
			if (maxWidth >= originalImage.getWidth() && maxHeight >= originalImage.getHeight()) return null;
			double ratioX = maxWidth * 1.0 / originalImage.getWidth(), ratioY = maxHeight * 1.0 / originalImage.getHeight(),
				ratio = Math.min(ratioX, ratioY);
			int w = (int) Math.ceil(originalImage.getWidth() * ratio),
				h = (int) Math.ceil(originalImage.getHeight() * ratio);
			BufferedImage thumbnail = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = thumbnail.createGraphics();
			// 设置高质量的插值方法
			g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.drawImage(originalImage, 0, 0, w, h, null);
			g2d.dispose();
			ImageIO.write(thumbnail, "jpg", out);
			return out.toByteArray();
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
			throw ExceptionUtils.unchecked(e);
		}
	}

	/**
	 * 支持png jpg
	 * @param source
	 * @param target
	 * @return
	 */
	public static boolean imgToPdf(String source, String target) {
		Document document = new Document();
		// 设置文档页边距
		document.setMargins(0, 0, 0, 0);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(target);
			PdfWriter.getInstance(document, fos);
			// 打开文档
			document.open();
			// 获取图片的宽高
			Image image = Image.getInstance(source);
			float imageHeight = image.getScaledHeight();
			float imageWidth = image.getScaledWidth();
			// 设置页面宽高与图片一致
			Rectangle rectangle = new Rectangle(imageWidth, imageHeight);
			document.setPageSize(rectangle);
			// 图片居中
			image.setAlignment(Image.ALIGN_CENTER);
			// 新建一页添加图片
			document.newPage();
			document.add(image);
		} catch (Exception ioe) {
			log.error("图片转PDF失败，" + source + "-->" + target, ioe);
			return false;
		} finally {
			// 关闭文档
			try {
				document.close();
				fos.flush();
				fos.close();
			} catch (IOException e) {
				log.error("图片转PDF关闭文档失败，" + source + "-->" + target, e);
			}
		}
		return true;
	}

}