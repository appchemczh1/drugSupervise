package org.jeecg.modules.demo.dzzz.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @description:签章系统配置
 * @author: 刘枫
 * @date: 2021-1-27
 */
@Configuration
@ConfigurationProperties(prefix = "signature")
public class Signature {
    
    private static String qrcode;
    
    private static String serverUrl;
    
    private static String pdfViewUrl;
    
    private static String makedeptHbsypjdglj;
    
    private static String makedeptHbsspypjdglj;
    
    private static String makedeptHbsscjdglj;
    
    private static String cardtypeVm;
    
    private static String qrcodeXYcardtype;
    
    public static String getQrcodeXYcardtype() {
        return qrcodeXYcardtype;
    }
    
    public void setQrcodeXYcardtype(String qrcodeXYcardtype) {
        Signature.qrcodeXYcardtype = qrcodeXYcardtype;
    }
    
    public static String getCardtypeVm() {
        return cardtypeVm;
    }
    
    public void setCardtypeVm(String cardtypeVm) {
        Signature.cardtypeVm = cardtypeVm;
    }
    
    public static String getQrcode() {
        return qrcode;
    }
    
    public void setQrcode(String qrcode) {
        Signature.qrcode = qrcode;
    }
    
    public static String getServerUrl() {
        return serverUrl;
    }
    
    public void setServerUrl(String serverUrl) {
        Signature.serverUrl = serverUrl;
    }
    
    public static String getPdfViewUrl() {
        return pdfViewUrl;
    }
    
    public void setPdfViewUrl(String pdfViewUrl) {
        Signature.pdfViewUrl = pdfViewUrl;
    }
    
    public static String getMakedeptHbsypjdglj() {
        return makedeptHbsypjdglj;
    }
    
    public void setMakedeptHbsypjdglj(String makedeptHbsypjdglj) {
        Signature.makedeptHbsypjdglj = makedeptHbsypjdglj;
    }
    
    public static String getMakedeptHbsspypjdglj() {
        return makedeptHbsspypjdglj;
    }
    
    public void setMakedeptHbsspypjdglj(String makedeptHbsspypjdglj) {
        Signature.makedeptHbsspypjdglj = makedeptHbsspypjdglj;
    }
    
    public static String getMakedeptHbsscjdglj() {
        return makedeptHbsscjdglj;
    }
    
    public void setMakedeptHbsscjdglj(String makedeptHbsscjdglj) {
        Signature.makedeptHbsscjdglj = makedeptHbsscjdglj;
    }
}
