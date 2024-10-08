package org.jeecg.modules.demo.dzzz.util;
import org.jeecg.common.util.StringUtils;

import java.util.Random;

public class LicenseUtils {

    /**
     * 生成随机数字和字母组合 20 位数
     * 湖北省电子证照库平台接入指南（征求意见稿）
     * @param length
     * [生成随机数的长度]
     * @return
     */
    public static String getRandomNickname(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 输出字母还是数字
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // 字符串
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 取得大写字母还是小写字母
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (choice + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val.toUpperCase();  //唯一标识 没有小写
    }

    /**
     * 创建证照唯一标识
     * @param licenseTypeCode
     * @param issueUnit
     * @param version
     * @return
     */
    public static String createCertificateSourceId(String licenseTypeCode, String issueUnit, String version) {
        String CertificateSourceId = "";
        // 电子证照根代码 OID
        String licenseOID = "1.2.156.3005.2";
        // 流水号(随机 20 位数字和大写字母的组合)
        String serialNumber = LicenseUtils.getRandomNickname(20);
        // 版本号（3 位阿拉伯数字）,将 license 的字段 version 转为 3 位数
        Integer ver = StringUtils.isEmpty(version) ? 1 : Integer.valueOf(version);
        String newVersion = String.format("%03d", ver);
        // 校验位
        String waitCheckStr = licenseTypeCode + issueUnit + serialNumber + newVersion;
        String checkDigit = ISO7064Util.computeCheckCharacter(waitCheckStr,ISO7064Util.Designation.ISO_7064_MOD_37_HYBRID_36);
        // 电子证照根代码.证照类型代码.证照颁发机构代码.流水号.版本号.检验位
        CertificateSourceId = licenseOID + "." + licenseTypeCode + "." + issueUnit + "." + serialNumber +
                "." + newVersion + "." + checkDigit;
        return CertificateSourceId;
    }

    //根据发证机关id 查询社会信用代码
//    public String getOrgCode(String grantOrgId) {
//        if(StringUtils.isNotEmpty(grantOrgId)){
//            SysDept dept = SpringBootBeanUtil.getBean(SysDeptServiceImpl.class).selectDeptById(grantOrgId);
//            if(dept !=null && StringUtils.isNotEmpty(dept.getVar2())){
//                return dept.getVar2();
//            }
//        }
//        return GlobalContent.grantOgBfjgdm;   //返回默认的颁发机构代码
//    }

    public static void main(String[] args) {
        String randomNickname = getRandomNickname(20);
        System.out.println(randomNickname);
        System.out.println(createCertificateSourceId("11100000MB0341032Y002", "11420503087246977F", "1"));
    }

}
