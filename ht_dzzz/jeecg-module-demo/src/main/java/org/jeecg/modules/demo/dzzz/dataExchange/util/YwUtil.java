package org.jeecg.modules.demo.dzzz.dataExchange.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.unfbx.chatgpt.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.jeecg.modules.demo.dzzz.dataExchange.exception.ErrorMsg;
import org.jeecg.modules.demo.dzzz.dataExchange.exception.ErrorUtil;
import org.jeecg.modules.demo.dzzz.dept.entity.SDept;
import org.jeecg.modules.demo.dzzz.dept.service.ISDeptService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class YwUtil {

    /**
     * 证书类型转换
     */
    public static Integer zslxConvert(Integer zslx) {
        /**
         * 传入证书类型：
         *      14、药品经营许可证（零售）        15、药品经营许可证（零售连锁门店）
         *      16、第三类医疗器械经营许可证(批发) 17、第三类医疗器械经营许可证(零售)
         * 系统证书类型：
         *      12、药品经营许可证(零售)         13、药品经营许可证（零售连锁门店）
         *      14、第三类医疗器械经营许可证(批发) 15、第三类医疗器械经营许可证(零售)
         */
        switch (zslx) {
            case 14:
                return 12;
            case 15:
                return 13;
            case 16:
                return 14;
            case 17:
                return 15;
            default:
                return 0;
        }
    }

    /**
     * dateStr不大于当前日期
     *
     * @param dateStr
     * @return
     */
    public static boolean DateStrNotMoreThanCurrentDate(String dateStr) {
        LocalDate now = LocalDate.now();
        LocalDate localDate = LocalDate.parse(dateStr);
        log.info("当前日期：{}, 发证日期：{}", now, localDate);
        if (localDate.compareTo(now) > 0) {
            return false;
        }
        return true;
    }

    /**
     * timestamp不大于当前日期
     *
     * @param timestamp
     * @return
     */
    public static boolean DateNotMoreThanCurrentDate(long timestamp) {
        LocalDate now = LocalDate.now();
        LocalDate localDate = new Date(timestamp).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        log.info("当前日期：{}, 发证日期：{}", now, localDate);
        if (localDate.compareTo(now) > 0) {
            return false;
        }
        return true;
    }

    /**
     * dateStr不小于当前日期
     *
     * @param dateStr
     * @return
     */
    public static boolean DateStrNotLessThanCurrentDate(String dateStr) {
        LocalDate now = LocalDate.now();
        LocalDate localDate = LocalDate.parse(dateStr);
        log.info("当前日期：{}, 有效期至日期：{}", now, localDate);
        if (localDate.compareTo(now) < 0) {
            return false;
        }
        return true;
    }

    /**
     * timestamp不小于当前日期
     *
     * @param timestamp
     * @return
     */
    public static boolean DateNotLessThanCurrentDate(long timestamp) {
        LocalDate now = LocalDate.now();
        LocalDate localDate = new Date(timestamp).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        log.info("当前日期：{}, 有效期至日期：{}", now, localDate);
        if (localDate.compareTo(now) < 0) {
            return false;
        }
        return true;
    }

    /**
     * 字符串转为日期
     *
     * @param str
     * @param format
     * @return
     */
    public static Date strToDate(String str, String format) {
        SimpleDateFormat dtFormat = null;
        try {
            if (StringUtils.isNotBlank(str)) {
                dtFormat = new SimpleDateFormat(format);
                return dtFormat.parse(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 校验日期
     *
     * @param date
     * @return
     */
    public static boolean checkDate(String date) {
        String rexp = "^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
        Pattern pat = Pattern.compile(rexp);
        Matcher mat = pat.matcher(date);
        return mat.matches();
    }

    /**
     * 发证机关校验，并返回发证机关ID
     *
     * @param fzjg
     * @return
     */
    public static String fzjgValid(String fzjg, ISDeptService deptService) {
        // 对发证机构校验
        SDept dept = deptService.getDeptByName(fzjg);
        ErrorUtil.assertFailure(null == dept, String.format(ErrorMsg.FZ_JG_ERROR, fzjg));
        return dept.getDeptId();
    }

    /**
     * 证书有效状态转换
     */
    public static String zsYxZtConvert(String yxZt) {
        switch (yxZt) {
            case "10":
                return "有效";
            case "50":
                return "注销";
            case "60":
                return "过期";
            case "70":
                return "吊销";
            case "80":
                return "撤销";
            case "99":
                return "作废";
            default:
                return "";
        }
    }

    /**
     * 执业药师（执业类别：1.药学；2.中药学；3.药学与中药学）
     */
    public static String zyYsZyLbConvert(String zylb) {
        switch (zylb) {
            case "1":
                return "药学";
            case "2":
                return "中药学";
            case "3":
                return "药学与中药学";
            default:
                return zylb;
        }
    }

    /**
     * 执业药师（执业范围：1.生产；2.批发；3.零售；4.使用；5.互联网药品第三方交易平台；6.其他）
     */
    public static String zyYsZyFwConvert(String zyfw) {
        switch (zyfw) {
            case "1":
                return "生产";
            case "2":
                return "批发";
            case "3":
                return "零售";
            case "4":
                return "使用";
            case "5":
                return "互联网药品第三方交易平台";
            case "6":
                return "其他";
            default:
                return zyfw;
        }
    }

    /**
     * 生成二维码(ofd)
     *
     * @param text
     * @param width
     * @param height
     * @return
     * @throws WriterException
     * @throws IOException
     */
    public static String generateQRCodeImageOfd(String text, int width, int height) throws WriterException, IOException {
        // 设置二维码的参数
        Map<EncodeHintType, Object> hints = new EnumMap<>(EncodeHintType.class);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        // 指定纠错等级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        //设置二维码边的空度，非负数
        hints.put(EncodeHintType.MARGIN, 0);
        // 生成二维码
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);

        // 将BitMatrix转换为BufferedImage
        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);

        // 将BufferedImage写入ByteArrayOutputStream
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "PNG", baos);

        byte[] imageBytes = baos.toByteArray();
        String base64Image = Base64.getEncoder().encodeToString(imageBytes);

        return base64Image;
    }

    /**
     * 生成二维码(doc)
     *
     * @param text
     * @param width
     * @param height
     * @return
     * @throws WriterException
     * @throws IOException
     */
    public static byte[] generateQRCodeImageByteDoc(String text, int width, int height) throws WriterException, IOException {
        // 设置二维码的参数
        Map<EncodeHintType, Object> hints = new EnumMap<>(EncodeHintType.class);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        // 指定纠错等级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        //设置二维码边的空度，非负数
        hints.put(EncodeHintType.MARGIN, 0);
        // 生成二维码
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);

        // 将BitMatrix转换为BufferedImage
        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);

        // 将BufferedImage写入ByteArrayOutputStream
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "PNG", baos);

        byte[] imageBytes = baos.toByteArray();
//        String base64Image = Base64.getEncoder().encodeToString(imageBytes);

        return imageBytes;
    }

    /**
     * 获取二维码地址
     *
     * @param licenseId
     * @param serverUrl
     * @return
     */
    public static String getQrCodeValue(String licenseId, String serverUrl) {
        if (org.apache.commons.lang.StringUtils.isBlank(licenseId)) {
            throw new BaseException(String.format("生成二维码地址失败：licenseId=%s", licenseId));
        }
        return String.format(serverUrl, licenseId);
    }

    /**
     * 当前日期的往前、往后几天
     * @param day 天
     * @param pattern 格式
     * @return
     */
    public static String getDateStrByDay(int day, String pattern) {
        String date = "";
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + day);
            pattern = StringUtils.isEmpty(pattern) ? "yyyy-MM-dd" : pattern;
            date = new SimpleDateFormat(pattern).format(calendar.getTime());
        } catch (Exception e) {
            log.error("日期转换异常：{}", e);
        }
        return date;
    }

    /**
     * 得到当前日期格式化后的字符串，格式：yyyy-MM-dd(年-月-日)
     * @return 当前日期格式化后的字符串
     */
    public static String getTodayStr(){
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date()) ;
    }

    /**
     * 日期截取
     * @param dateStr
     * @return
     */
    public static String dateSubStr(String dateStr){
        if (StringUtils.isNotEmpty(dateStr) && dateStr.length() > 10) {
            dateStr = dateStr.substring(0, 10);
        }
        return dateStr;
    }

    public static void main(String[] args) {
        String url = "https://zsgs.hubyjj.cn:8096/prod-api/dzzz/ZscxAction.do?operate=searchZsxxInfoByQrcode&operPage=zsxx_view&gyEntcardprint.id=253b623753944f0badb266f93f3d8f94&gyEntcardprint.cardtype=13";
        try {
            Integer width = 100;
            Integer height = 100;

            Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
//            hints.put(EncodeHintType.MARGIN, 0);
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height, hints);
            MatrixToImageWriter.writeToStream(bitMatrix, "png", new FileOutputStream("d:/你好.png"));
        } catch (WriterException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 这里可以处理baos，比如写入文件或发送到客户端

    }

}
