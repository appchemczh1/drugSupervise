package org.jeecg.modules.demo.dzzz.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZzkConstant {

    /** 省局单位统一社会信用代码 **/
    public static final String SJ_SHXYDM = "11420000MB15291767";

    /** 证照库证书类型ID **/
    public static List<String> ZZK_CERTTYPEID = new ArrayList<>();

    static {
        ZZK_CERTTYPEID = Arrays.asList(
                "d2dd9f71f5f34145af595fd79504e683",// 药品经营许可证（零售连锁门店）
                "343af983fcf4449e863277f0f5498a0d",// 药品经营许可证（零售连锁总部）
                "eb436e84a16b4fbbaec251c1abf1a339",// 药品经营许可证（批发）
                "4e7ff714f0cf4f81b46eb16c1155744f",// 药品经营许可证(零售)
                "76d0e6250ee54a9db032da22c95af5e8",// 药品生产许可证
                "2c0fef3cada14372859b7c5a2798edeb",// 医疗机构制剂许可证
                "35676f5e5381406d91ddc16391673698",// 麻醉药品、第一类精神药品运输证明
                "e857a80febc34556a5f68445221e6aed",// 化妆品生产许可证
                "93f116242ece4bc2b670961fdd314a28",// 互联网药品信息服务资格证书
                "f45a7f934d4245d2a2a595365ebfd175",// 放射性药品使用许可证
                "18d8c52f34fc4096b61c53e3ac50e6b9",// 放射性药品生产许可证
                "cf8ffc2aa62646acad30c3f8790441eb",// 放射性药品经营许可证
                "96ea1381b969417482ca9bf962267bc8",// 第一类医疗器械生产备案
                "a7a0ec011cbf499983f1959349e7a79c",// 第二类医疗器械注册证
                "e060f441873e41dba90394267b32a224",// 第二类体外诊断试剂注册证
                "bf79efa1352a43b691aae25cbec58ced",// 第二、三类医疗器械生产许可证
                "4957bebb1de340cc90502265a456d303",// 第三类医疗器械经营许可证(批发)
                "5102457a62a04aee8c93ea0873c8a39e",// 第三类医疗器械经营许可证(零售)
                "a27e1ace479c4cef90bce24007cb7046",// 医疗机构应用传统工艺配制中药制剂首次备案
                "29d3e61e5561488ca2410ed653d0350a",// 药品出口销售证明已在中国批准上市药品的未注册规格
                "0cfb0d0d33a641f0aa0a9592a37c2cbe"// 药品出口销售证明已在中国批准上市药品
        );

    }

}
