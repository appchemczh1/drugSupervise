/*******************************************************
 *
 * 使用此JS脚本之前请先仔细阅读mToken KEY帮助文档
 * 
 * @author longmai 
 * @version 4.1.22.802
 * @date 2022/8/8 
 * @explanation	 mToken Plugin 支持各浏览器
 *
**********************************************************/

var token = new mToken("mTokenPlugin");
//动态添加option选项
function addOption(optionStr, selectID, flag) {
    if (flag == 1) {
        for (var i = 0; i < optionStr.length; ++i)
            selectID.options.add(new Option(optionStr[i], i));
    }
    if (flag == 2) {
        for (var i = 0; i < optionStr.length; ++i) {
            selectID.options.add(new Option(optionStr[i][1], i));
        }
    }
}

//枚举当前设备
function enumDevice() {
    var slectType = document.getElementById("platform").value;
    var ret = 0;
    var selectID = document.getElementById("sele_devices");
    selectID.options.length = 0;

    if (slectType == "GM3000PCSC")
        ret = token.SOF_LoadLibrary(token.GM3000PCSC);
    else if (slectType == "GM3000")
        ret = token.SOF_LoadLibrary(token.GM3000);
    else if (slectType == "K7")
        ret = token.SOF_LoadLibrary(token.K7);
    else if (slectType == "TF")
        ret = token.SOF_LoadLibrary(token.TF);
    else
        ret = token.SOF_LoadLibrary(token.K5);
    if (ret != 0) {
        alert("加载控件失败,错误码:" + token.SOF_GetLastError());
        return;
    }
    var deviceName = token.SOF_EnumDevice();

    if (deviceName != null) {
        addOption(deviceName, selectID, 1);
    }
    else {
        alert("未找到任何key");
    }
    //绑定应用
    var objS = document.getElementById("sele_devices");
    var deviceNameOne = objS.options[objS.selectedIndex].text;
    var selectID = document.getElementById("sele_devices");
    var cerlistID = document.getElementById("sele_contentList");
    cerlistID.options.length = 0;
    var index = selectID.selectedIndex;
    if (index < 0) {
        alert("请选中列表中设备后操作");
        return;
    }

    var ret = token.SOF_GetDeviceInstance(deviceNameOne, "");

    if (ret != 0) {
        alert("绑定应用失败，确定是否初始化Key,错误码:" + token.SOF_GetLastError());
        return;
    }

}

function gradeChange() {
    var objS = document.getElementById("sele_devices");
    var grade = objS.options[objS.selectedIndex].text;

    //绑定应用
    var selectID = document.getElementById("sele_devices");
    var cerlistID = document.getElementById("sele_contentList");
    cerlistID.options.length = 0;
    var index = selectID.selectedIndex;
    if (index < 0) {
        alert("请选中列表中设备后操作");
        return;
    }


    var ret = token.SOF_GetDeviceInstance(grade, "");

    if (ret != 0) {
        alert("绑定应用失败，确定是否初始化Key,错误码:" + token.SOF_GetLastError());
        return;
    }
}
//获取证书列表
function getUserList() {

    var cerlistID = document.getElementById("sele_contentList");
    var cerList = token.SOF_EnumCertContiner().split("||");
    cerlistID.options.length = 0;

    if (cerList != null && cerList.length > 0)
        addOption(cerList, cerlistID, 1);
}

//验证管理密码
function verifyAdminPin() {
    var soPin = document.getElementById("txt_AdminPwd").value;
    var ret = token.SOF_LoginSoPin(soPin);
    if (ret != 0) {
        alert("验证管理员密码失败，错误码：" + token.SOF_GetLastError());
        return;
    }
    else {
        alert("验证管理员密码成功。");
    }
}

//验证用户密码
function verifyUserPin() {
    //绑定应用
    var selectID = document.getElementById("sele_devices");
    var cerlistID = document.getElementById("sele_contentList");
    cerlistID.options.length = 0;
    var index = selectID.selectedIndex;
    if (index < 0) {
        alert("请选中列表中设备后操作");
        return;
    }

    var deviceName = selectID.options[index].text;

    var ret = token.SOF_GetDeviceInstance(deviceName, "");

    if (ret != 0) {
        alert("绑定应用失败，确定是否初始化Key,错误码:" + token.SOF_GetLastError());
        return;
    }


    var ret = 0;
    var strRes = "";
    //获取UKey的类型，并按UKey类型来提示验证身份
    var hwType = token.SOF_GetHardwareType();
    if (hwType == token.TYPE_FPKEY) {	//验证用户指纹
        //请在这里，替换更友善的用户提示...
        //开始“用户验证指纹”的提示

        var VarRet = 0;  //此值在mtoken.js 中做了判断
        alert("当指纹KEY上的指示灯开始闪烁时，请按压手指以验证指纹......"); //Longmai的示例提示方式
        VarRet = token.SOF_VerifyFingerprintEx();

        //结束“用户验证指纹”的提示
        var lastErr = token.SOF_GetLastError();
        if (lastErr != 0) {
            if (lastErr == 0xB000040) {
                strRes = "等待指纹验证超时，请重新认证";
            }
            else {
                strRes = "验证用户指纹失败。" + "剩余次数：" + VarRet;
            }

        }
        else {
            strRes = "验证用户指纹成功。" + "指纹ID = " + VarRet;
        }
    }
    else {//验证用户密码
        var pin = document.getElementById("txt_pwd").value;
        ret = token.SOF_Login(pin);
        if (ret != 0) {
            strRes = "验证用户密码失败";
        }
        else {
            strRes = "验证用户密码成功。";
        }
    }

    if (ret != 0) {
        var lastErr = token.SOF_GetLastError();
        var retryCount = token.SOF_GetPinRetryCount();
        document.getElementById("tryCount").value = "剩余次数：" + retryCount;

        alert(strRes + " 错误码:" + lastErr);
        return;
    }
    else {
        document.getElementById("tryCount").value = "";
        alert(strRes);
    }

}

//登出
function btnLoginOut() {
    var Ret = token.SOF_LogOut();
    if (Ret != 0)
        alert("登出失败,错误码:" + token.SOF_GetLastError());
    else
        alert("登出成功");
}

//修改密码
function changeUserPin() {
    var pin = document.getElementById("txt_pwd").value;
    var resetPin = document.getElementById("txt_Changepwd").value;
    if (resetPin == "") {
        alert("请输入要修改的用户密码！");
        return;
    }
    var ret = token.SOF_ChangePassWd(pin, resetPin);
    if (ret != 0)
        alert("密码修改失败,错误码:" + token.SOF_GetLastError());
    else
        alert("密码修改成功");
}

//获取PIN码剩余验证次数
function getRetryCount() {
    var ret = token.SOF_GetPinRetryCount();
    if (ret != 0) {
        alert("用户PIN剩余重试次数:" + ret);
    }
}

//获取UserPin 最大重试次数
function getMaxRetryCount() {
    var ret = token.SOF_GetPinMaxRetryCount();
    if (ret != 0) {
        alert("用户PIN最大重试次数为:" + ret);
    }
}

//设置mToken名称
function btnSetLabel() {
    var label = document.getElementById("txt_Lable").value;
    var ret = token.SOF_SetLabel(label);
    if (ret != 0) {
        alert("设置mToken名称失败,错误码：" + token.SOF_GetLastError());
        return;
    }
    else {
        alert("设置mToken名称成功。");
    }
}

//创建容器
function CrateContainer() {
    var retVal = 0;
    var container = document.getElementById("txt_createCon").value;
    if (container == "") {
        alert("容器名称不能为空");
        return;
    }

    retVal = token.SOF_CreateContainer(container);
    if (retVal != 0) {
        alert("创建容器失败！错误码：" + token.SOF_GetLastError());
        return;
    }
    alert("创建成功");
}

//控件版本信息
function getVersion() {
    var version = token.SOF_GetVersion();
    document.getElementById("contorlInfo").value = version;
}


//生成P10请求
function btn_P10_request() {
    var container = document.getElementById("sele_contentList");
    if (container.selectedIndex < 0) {
        alert("请先枚举容器后操作");
        return;
    }

    var containerName = container.options[container.selectedIndex].text;
    if (containerName == null || containerName == "") {
        alert("请选择容器操作");
        return;
    }
    //DN
    var dn = document.getElementById("txt_DN").value;
    //算法
    var selectID = document.getElementById("txt_asymAlg");
    var nAsymAlgTx = selectID.options[selectID.selectedIndex].text;
    var nAsymAlg = token.SGD_SM2_1;
    if (nAsymAlgTx == "SGD_RSA") //SGD_SM2_1
    {

        nAsymAlg = token.SGD_RSA; //此值使用mToken.js中的定义 0x00010000
    }
    //签名
    var keySpec = document.getElementById("txt_keySpec").value;
    //秘钥长度
    var keyLength = document.getElementById("txt_keyLength").value;
    if (container == "" || dn == "" || nAsymAlg == "" || keySpec == "" || keyLength == "") {
        alert("请确保各个参数是否为空！");
        return;
    }
    var selectID = document.getElementById("sele_devices");
    var index = selectID.selectedIndex;
    if (index < 0) {
        alert("请选中列表中设备后操作");
        return;
    }
    token.SOF_SetDigestMethod(Number(0));
    var deviceName = selectID.options[index].text;
    var p10Req = token.SOF_GenerateP10Request(deviceName, containerName, dn, nAsymAlg, keySpec, keyLength);
    if (p10Req == "" || p10Req == null) {
        alert("生成失败！错误码：" + token.SOF_GetLastError());
        return;
    }
    document.getElementById("P10_requestData").innerHTML = p10Req;
    //开发发送到服务器，发送方式和之前一致。

}


//导入签名证书
function btn_importSignCert() {
    var container = document.getElementById("txt_ContainerName").value;
    if (container == "") {
        alert("容器名称不能为空");
        return;
    }

    var cert = document.getElementById("txt_SignCertData").value;
    if (cert.length < 256) {
        alert("无效的签名证书数据。");
        return;
    }
    var retVal = 0;
    retVal = token.SOF_ImportCert(container, cert, 1); //0:OK
    if (retVal != 0) {
        alert("导入失败！错误码：" + token.SOF_GetLastError());
        return;
    }
    alert("导入成功")
    //开发发送到服务器，发送方式和之前一致。
}


//导出证书信息
function exportUserCert() {
    document.getElementById("cerInfo").value = "";

    var container = document.getElementById("sele_contentList");
    if (container.selectedIndex < 0) {
        alert("请选择容器操作");
        return;
    }

    var selectType = document.getElementById("sele_cerType");
    var containerName = container.options[container.selectedIndex].text;
    if (containerName == null || containerName == "") {
        alert("请选择容器操作");
        return;
    }

    var cerType = selectType.options[selectType.selectedIndex].value;
    var cert = token.SOF_ExportUserCert(containerName, cerType);
    if (cert != null && cert != "") {
        document.getElementById("cerInfo").value = cert;
    }
    else
        alert("获取证书信息失败,错误码:" + token.SOF_GetLastError());
}

//获取证书信息
function getCertInfo() {
    signCert = document.getElementById("cerInfo").value;
    if (signCert == "") {
        alert("请先导出证书");
        return;
    }
    var showCer = document.getElementById("showcerInfo");

    showCer.value = "";
    var cerInfo = "";
    var str;

    str = token.SOF_GetCertInfoByOid(signCert, "2.5.29.14");
    cerInfo += "Issuer: " + str + "\r";

    str = token.SOF_GetCertInfo(signCert, token.SGD_CERT_ISSUER_CN);
    cerInfo += "Issuer: " + str + "\r";

    str = token.SOF_GetCertInfo(signCert, token.SGD_CERT_SUBJECT);
    cerInfo += "Subject: " + str + "\r";
    str = token.SOF_GetCertInfo(signCert, token.SGD_CERT_SUBJECT_CN);
    cerInfo += "Subject_CN: " + str + "\r";
    str = token.SOF_GetCertInfo(signCert, token.SGD_CERT_SUBJECT_EMALL);
    cerInfo += "Subject_EMail: " + str + "\r";
    str = token.SOF_GetCertInfo(signCert, token.SGD_CERT_SERIAL);
    cerInfo += "Serial: " + str + "\r";
    str = token.SOF_GetCertInfo(signCert, token.SGD_CERT_CRL);
    cerInfo += "cRLDistributionPoints: " + str + "\r";

    str = token.SOF_GetCertInfo(signCert, token.SGD_CERT_NOT_BEFORE);
    cerInfo += "not before: " + str + "\r";

    str = token.SOF_GetCertInfo(signCert, token.SGD_CERT_VALID_TIME);
    cerInfo += "validTimeTo: " + str + "\r";

    cerInfo += "如需获取更多信息请查看帮助文档";

    showCer.value = cerInfo;
}

//获取设备信息
function getDeviceInfo() {
    var deviceInfo = document.getElementById("deviceInfo");
    deviceInfo.value = "";
    var strInfo;
    var str = token.SOF_GetDeviceInfo(token.SGD_DEVICE_NAME);
    strInfo = "Device name: " + str + "\r";

    var str = token.SOF_GetDeviceInfo(token.SGD_DEVICE_SUPPORT_STORANGE_SPACE);
    strInfo += "Device total space: " + str + "\r";

    var str = token.SOF_GetDeviceInfo(token.SGD_DEVICE_SUPPORT_FREE_SAPCE);
    strInfo += "Device free space: " + str + "\r";

    var str = token.SOF_GetDeviceInfo(token.SGD_DEVICE_HARDWARE_VERSION);
    strInfo += "Hardware version: " + str + "\r";

    var str = token.SOF_GetDeviceInfo(token.SGD_DEVICE_SERIAL_NUMBER);
    strInfo += "Device serial number: " + str + "\r";

    var str = token.SOF_GetDeviceInfo(token.SGD_DEVICE_MANUFACTURER);
    strInfo += "Device manufacturer: " + str + "\r";

    strInfo += "如需获取更多信息请查看帮助文档";

    deviceInfo.value = strInfo;
}


//数据签名
function signData() {
    var selectType = document.getElementById("sele_cerType");
    var cerType = selectType.options[selectType.selectedIndex].value;
    if (cerType == 0) {
        alert("请选择签名密钥进行签名");
        return;
    }
    var DigestMethod = document.getElementById("mech").value;
    var userID = document.getElementById("userID").value;
    var inData = document.getElementById("originalData").value;
    var ret = token.SOF_SetDigestMethod(Number(DigestMethod));
    ret = token.SOF_SetUserID(userID);

    var container = document.getElementById("sele_contentList");
    if (container.selectedIndex < 0) {
        alert("请先枚举容器后操作");
        return;
    }

    var containerName = container.options[container.selectedIndex].text;
    if (containerName == null || containerName == "") {
        alert("请选择容器操作");
        return;
    }

    //0预处理，1不做预处理

    var signed = token.SOF_SignData(containerName, cerType, _Base64encode(inData), inData.length, 0);
    if (signed != null && signed != "")
        document.getElementById("signedData").value = signed;
    else
        alert("签名失败,错误码:" + token.SOF_GetLastError());
}


var signed;
//数据签名
function signData_P7() {
    var selectType = document.getElementById("sele_cerType");
    var cerType = selectType.options[selectType.selectedIndex].value;
    if (cerType == 0) {
        alert("请选择签名密钥进行签名");
        return;
    }
    var DigestMethod = document.getElementById("mech").value;
    var userID = document.getElementById("userID").value;
    var inData = document.getElementById("originalData").value;
    var ret = token.SOF_SetDigestMethod(Number(DigestMethod));
    ret = token.SOF_SetUserID(userID);

    var container = document.getElementById("sele_contentList");
    if (container.selectedIndex < 0) {
        alert("请先枚举容器后操作");
        return;
    }

    var containerName = container.options[container.selectedIndex].text;
    if (containerName == null || containerName == "") {
        alert("请选择容器操作");
        return;
    }

    signed = token.SOF_SignDataToPKCS7(containerName, cerType, _Base64encode(inData), 0);
    if (signed != null && signed != "")
        document.getElementById("signedData").value = signed;
    else
        alert("签名失败,错误码:" + token.SOF_GetLastError());
}

//文件签名
function signFile() {
    var selectType = document.getElementById("sele_cerType");
    var cerType = selectType.options[selectType.selectedIndex].value;
    if (cerType == 0) {
        alert("请选择签名密钥进行签名");
        return;
    }
    var DigestMethod = document.getElementById("mech").value;
    var userID = document.getElementById("userID").value;
    var inFile = document.getElementById("signFile").value;
    var ret = token.SOF_SetDigestMethod(Number(DigestMethod));
    ret = token.SOF_SetUserID(userID);

    var container = document.getElementById("sele_contentList");
    if (container.selectedIndex < 0) {
        alert("请先枚举容器后操作");
        return;
    }

    var containerName = container.options[container.selectedIndex].text;
    if (containerName == null || containerName == "") {
        alert("请选择容器操作");
        return;
    }

    var signed = token.SOF_SignFileToPKCS7(containerName, cerType, inFile);
    if (signed != null && signed != "")
        document.getElementById("signedData").value = signed;
    else
        alert("签名失败,错误码:" + token.SOF_GetLastError());
}

//数据验签
function verifySignFile() {
    var selectType = document.getElementById("sele_cerType");
    var cerType = selectType.options[selectType.selectedIndex].value;
    if (cerType == 0) {
        alert("请选择签名密钥进行签名");
        return;
    }
    var DigestMethod = document.getElementById("mech").value;
    var userID = document.getElementById("userID").value;
    var inFile = document.getElementById("signFile").value;
    var signed = document.getElementById("signedData").value;
    if (signed == null || signed.length <= 0) {
        alert("请先签名后操作");
        return;
    }

    var container = document.getElementById("sele_contentList");
    if (container.selectedIndex < 0) {
        alert("请选择容器操作");
        return;
    }

    var selectType = document.getElementById("sele_cerType");
    var containerName = container.options[container.selectedIndex].text;
    if (containerName == null || containerName == "") {
        alert("请选择容器操作");
        return;
    }

    var cert = token.SOF_ExportUserCert(containerName, cerType);

    var ret = token.SOF_SetDigestMethod(Number(DigestMethod));
    ret = token.SOF_SetUserID(userID);
    ret = token.SOF_VerifyFileToPKCS7(signed, inFile);
    if (ret != 0)
        alert("验签失败,错误码:" + token.SOF_GetLastError());
    else
        alert("验签成功");
}

//数据验签
function verifySign() {
    var DigestMethod = document.getElementById("mech").value;
    var userID = document.getElementById("userID").value;
    var inData = document.getElementById("originalData").value;
    var signed = document.getElementById("signedData").value;
    if (signed == null || signed.length <= 0) {
        alert("请先签名后操作");
        return;
    }

    var container = document.getElementById("sele_contentList");
    if (container.selectedIndex < 0) {
        alert("请选择容器操作");
        return;
    }

    var selectType = document.getElementById("sele_cerType");
    var containerName = container.options[container.selectedIndex].text;
    if (containerName == null || containerName == "") {
        alert("请选择容器操作");
        return;
    }

    var cerType = selectType.options[selectType.selectedIndex].value;
    var cert = document.getElementById("cerInfo").value;
    if (cert == "") {
        cert = token.SOF_ExportUserCert(containerName, cerType);
    }

    var ret = token.SOF_SetUserID(userID);
    ret = token.SOF_VerifySignedData(cert, Number(DigestMethod), _Base64encode(inData), signed);
    if (ret != 0)
        alert("验签失败,错误码:" + token.SOF_GetLastError());
    else
        alert("验签成功");
}

//数据验签
function verifySign_P7() {
    var DigestMethod = document.getElementById("mech").value;
    var userID = document.getElementById("userID").value;
    var inData = document.getElementById("originalData").value;
    var signed = document.getElementById("signedData").value;
    if (signed == null || signed.length <= 0) {
        alert("请先签名后操作");
        return;
    }

    var container = document.getElementById("sele_contentList");
    if (container.selectedIndex < 0) {
        alert("请选择容器操作");
        return;
    }

    var selectType = document.getElementById("sele_cerType");
    var containerName = container.options[container.selectedIndex].text;
    if (containerName == null || containerName == "") {
        alert("请选择容器操作");
        return;
    }

    var cerType = selectType.options[selectType.selectedIndex].value;
    var cert = token.SOF_ExportUserCert(containerName, cerType);

    var ret = token.SOF_SetDigestMethod(Number(DigestMethod));
    ret = token.SOF_SetUserID(userID);
    ret = token.SOF_VerifyDataToPKCS7(signed, _Base64encode(inData), 0);
    if (ret != 0)
        alert("验签失败,错误码:" + token.SOF_GetLastError());
    else
        alert("验签成功");
}
//数据加密
function encryptData() {
    var selectType = document.getElementById("sele_cerType");
    var cerType = selectType.options[selectType.selectedIndex].value;
    if (cerType == 1) {
        alert("请选择加密证书进行加密");
        return;
    }
    var EncryptMethod = document.getElementById("encrymech").value;
    var iv = document.getElementById("iv").value;
    var inData = document.getElementById("enData").value;

    var container = document.getElementById("sele_contentList");
    if (container.selectedIndex < 0) {
        alert("请选择容器操作");
        return;
    }


    var containerName = container.options[container.selectedIndex].text;
    if (containerName == null || containerName == "") {
        alert("请选择容器操作");
        return;
    }


    var cert = token.SOF_ExportUserCert(containerName, cerType);
    token.SOF_SetEncryptMethodAndIV(EncryptMethod, _Base64encode(iv));

    var encrypedData = token.SOF_EncryptDataPKCS7EX(cert, _Base64encode(inData), inData.length);
    if (encrypedData != null || encrypedData == "")
        document.getElementById("enedData").value = encrypedData;
    else
        alert("加密失败,错误码:" + token.SOF_GetLastError());
}


//数据加密
function encryptFile() {
    var selectType = document.getElementById("sele_cerType");
    var cerType = selectType.options[selectType.selectedIndex].value;
    if (cerType == 1) {
        alert("请选择加密证书进行加密");
        return;
    }
    var EncryptMethod = document.getElementById("encrymech").value;
    var iv = document.getElementById("iv").value;
    var inData = document.getElementById("enFile").value;
    var OutData = document.getElementById("enDstFile").value;

    var container = document.getElementById("sele_contentList");
    if (container.selectedIndex < 0) {
        alert("请选择容器操作");
        return;
    }

    var containerName = container.options[container.selectedIndex].text;
    if (containerName == null || containerName == "") {
        alert("请选择容器操作");
        return;
    }



    var cert = token.SOF_ExportUserCert(containerName, cerType);

    token.SOF_SetEncryptMethodAndIV(EncryptMethod, _Base64encode(iv));

    var envelopData = token.SOF_EncryptFileToPKCS7(cert, inData, OutData, 1);
    if (envelopData != null)
        document.getElementById("enedData").value = envelopData;
    else
        alert("加密失败,错误码:" + token.SOF_GetLastError());
}

function decryptFile() {
    var EncryptMethod = document.getElementById("encrymech").value;
    var iv = document.getElementById("iv").value;
    var outFile = document.getElementById("enFile").value;
    var inData = document.getElementById("enDstFile").value;
    var encrypedData = document.getElementById("enedData").value;
    if (encrypedData == null || encrypedData.length <= 0) {
        alert("请先加密后操作");
        return;
    }

    var container = document.getElementById("sele_contentList");
    if (container.selectedIndex < 0) {
        alert("请选择容器操作");
        return;
    }

    var containerName = container.options[container.selectedIndex].text;
    if (containerName == null || containerName == "") {
        alert("请选择容器操作");
        return;
    }

    token.SOF_SetEncryptMethodAndIV(EncryptMethod, _Base64encode(iv));

    var selectType = document.getElementById("sele_cerType");
    var cerType = selectType.options[selectType.selectedIndex].value;

    outFile = outFile + ".plainText";
    decryptedData = token.SOF_DecryptFileToPKCS7(containerName, cerType, encrypedData, inData, outFile, 1);
    if (decryptedData != 0)
        alert("解密失败,错误码:" + token.SOF_GetLastError());
    else {
        document.getElementById("deData").value = outFile;
        alert("解密文件成功，目标文件:" + outFile);
    }
}

//数据解密
function decryptData() {
    var EncryptMethod = document.getElementById("encrymech").value;
    var iv = document.getElementById("iv").value;
    var encrypedData = document.getElementById("enedData").value;
    if (encrypedData == null || encrypedData.length <= 0) {
        alert("请先加密后操作");
        return;
    }

    var container = document.getElementById("sele_contentList");
    if (container.selectedIndex < 0) {
        alert("请选择容器操作");
        return;
    }

    var containerName = container.options[container.selectedIndex].text;
    if (containerName == null || containerName == "") {
        alert("请选择容器操作");
        return;
    }

    token.SOF_SetEncryptMethodAndIV(EncryptMethod, _Base64encode(iv));

    var selectType = document.getElementById("sele_cerType");
    var cerType = selectType.options[selectType.selectedIndex].value;

    decryptedData = token.SOF_DecryptDataPKCS7EX(containerName, cerType, encrypedData);
    if (decryptedData != null && decryptedData != "")
        document.getElementById("deData").value = _Base64decode(decryptedData);
    else
        alert("解密失败,错误码:" + token.SOF_GetLastError());
}
//SM3 不做预处理
function digestSM3Data() {
    var DigestMethod = document.getElementById("digestmech").value;
    var inData = document.getElementById("digestData").value;
    var userID = document.getElementById("userID").value;
    token.SOF_SetDigestMethod(1);
    ret = token.SOF_SetUserID(userID);

    var container = document.getElementById("sele_contentList");
    if (container.selectedIndex < 0) {
        alert("请选择容器操作");
        return;
    }

    var containerName = container.options[container.selectedIndex].text;
    if (containerName == null || containerName == "") {
        alert("请选择容器操作");
        return;
    }

    digest = token.SOF_DigestData("", _Base64encode(inData), inData.length);
    if (digest != null)
        document.getElementById("digestedData").value = digest;
    else
        alert("数据摘要失败,错误码:" + token.SOF_GetLastError());
}
//对数据做摘要
function digestData() {
    var DigestMethod = document.getElementById("digestmech").value;
    var inData = document.getElementById("digestData").value;
    var userID = document.getElementById("userID").value;
    token.SOF_SetDigestMethod(DigestMethod);
    ret = token.SOF_SetUserID(userID);

    var container = document.getElementById("sele_contentList");
    if (container.selectedIndex < 0) {
        alert("请选择容器操作");
        return;
    }

    var containerName = container.options[container.selectedIndex].text;
    if (containerName == null || containerName == "") {
        alert("请选择容器操作");
        return;
    }

    digest = token.SOF_DigestData(containerName, _Base64encode(inData), inData.length);
    if (digest != null)
        document.getElementById("digestedData").value = digest;
    else
        alert("数据摘要失败,错误码:" + token.SOF_GetLastError());
}


function GenRemoteUnlockPin() {
    var request = token.SOF_GenRemoteUnblockRequest();
    if (request == null || request == "") {
        alert("生成解锁请求失败");
        return;
    }

    document.getElementById("remoteUnlockPin").value = request;
}

function GenUnlockPinResponse() {
    var encrypedData = document.getElementById("remoteUnlockPin").value;
    var SoPinData = document.getElementById("SoPinData").value;
    var UserData = document.getElementById("newPinData").value;
    var request = token.SOF_GenResetpwdResponse(encrypedData, SoPinData, UserData);
    if (request == null || request == "") {
        alert("生成解锁请求失败");
        return;
    }

    document.getElementById("remoteUnlockPin").value = request;
}


function RemoteUnlockPin() {
    var encrypedData = document.getElementById("remoteUnlockPin").value;
    var request = token.SOF_RemoteUnblockPIN(encrypedData);
    if (request != 0) {
        alert("解锁失败");
        return;
    }
    else {
        alert("解锁成功");
    }
}
//导出公钥
function exportPubKey() {
    document.getElementById("PubKey").value = "";

    var container = document.getElementById("sele_contentList");
    if (container.selectedIndex < 0) {
        alert("请选择容器操作");
        return;
    }

    var selectType = document.getElementById("sele_cerType");
    var containerName = container.options[container.selectedIndex].text;
    if (containerName == null || containerName == "") {
        alert("请选择容器操作");
        return;
    }

    var cerType = selectType.options[selectType.selectedIndex].value;
    var strPubKey = token.SOF_ExportPubKey(containerName, cerType, 1);
    if (strPubKey != null && strPubKey != "") {
        document.getElementById("PubKey").value = strPubKey;
    }
    else
        alert("获取公钥失败,错误码:" + token.SOF_GetLastError());
}
//公钥验签
function publicVerify() {
    //原文
    var originalData = document.getElementById("originalData").value;
    var originalDataBase64 = _Base64encode(originalData);
    //公钥
    var publicKey = document.getElementById("PubKey").value;
    if (publicKey == "") {
        alert("请先导出公钥！");
        return;
    }
    //签名值
    var signature = document.getElementById("signedData").value;
    if (signature == "") {
        alert("请先做签名！");
        return;
    }
    var digestMethod = document.getElementById("mech").value;
    var Rtn = token.SOF_PublicVerify(publicKey, originalDataBase64, signature, digestMethod);
    if (Rtn != 0) {
        alert("验签失败！错误码:" + token.SOF_GetLastError());
        return;
    }
    alert("验签成功。");

}

function encryptbyPubKey() {
    var strPubKey = document.getElementById("PubKey").value;
    var strInput = document.getElementById("AsymPlain").value;

    var selectType = document.getElementById("sele_cerType");
    var cerType = selectType.options[selectType.selectedIndex].value;

    var strAsymCipher = token.SOF_EncryptByPubKey(strPubKey, _Base64encode(strInput), cerType);
    if (strAsymCipher != null && strAsymCipher != "") {
        document.getElementById("AsymCipher").value = strAsymCipher;
    }
    else
        alert("公钥加密失败,错误码:" + token.SOF_GetLastError());
}

function decryptbyPrvKey() {
    var container = document.getElementById("sele_contentList");
    if (container.selectedIndex < 0) {
        alert("请选择容器操作");
        return;
    }

    var selectType = document.getElementById("sele_cerType");
    var containerName = container.options[container.selectedIndex].text;
    if (containerName == null || containerName == "") {
        alert("请选择容器操作");
        return;
    }

    var cerType = selectType.options[selectType.selectedIndex].value;

    var strAsymCipher = document.getElementById("AsymCipher").value;

    var strAsymPlain = token.SOF_DecryptByPrvKey(containerName, cerType, strAsymCipher);
    if (strAsymPlain != null) {
        document.getElementById("AsymPlain").value = _Base64decode(strAsymPlain);
    }
    else
        alert("私钥解密失败,错误码:" + token.SOF_GetLastError());
}


//数据签名---所见即所签--交易签名
function TransSignData() {
    var selectType = document.getElementById("sele_cerType");
    var cerType = selectType.options[selectType.selectedIndex].value;
    if (cerType == 0) {
        alert("请选择签名密钥进行签名");
        return;
    }
    var DigestMethod = document.getElementById("TransDigestmech").value;
    var userID = document.getElementById("userID").value;
    var inData = document.getElementById("TransPacket").value;
    var ret = token.SOF_SetDigestMethod(Number(DigestMethod));
    ret = token.SOF_SetUserID(userID);

    var container = document.getElementById("sele_contentList");
    if (container.selectedIndex < 0) {
        alert("请先枚举容器后操作");
        return;
    }

    var containerName = container.options[container.selectedIndex].text;
    if (containerName == null || containerName == "") {
        alert("请选择容器操作");
        return;
    }

    alert("提示： 当K5上显示灯闪烁时，请在60秒以内及时按下签名按钮……");
    var signed = token.SOF_SignDataInteractive(containerName, cerType, _Base64encode(inData), inData.length);
    if (signed != null && signed != "")
        document.getElementById("TransSignedData").value = signed;
    else
        alert("签名失败,错误码:" + token.SOF_GetLastError());
}

//数据验签---所见即所签--交易签名验证
function TransVerifySignature() {
    var DigestMethod = document.getElementById("TransDigestmech").value;
    var userID = document.getElementById("userID").value;
    var inData = document.getElementById("TransPacket").value;
    var signed = document.getElementById("TransSignedData").value;
    if (signed == null || signed.length <= 0) {
        alert("请先签名后操作");
        return;
    }

    var container = document.getElementById("sele_contentList");
    if (container.selectedIndex < 0) {
        alert("请选择容器操作");
        return;
    }

    var selectType = document.getElementById("sele_cerType");
    var containerName = container.options[container.selectedIndex].text;
    if (containerName == null || containerName == "") {
        alert("请选择容器操作");
        return;
    }

    var cerType = selectType.options[selectType.selectedIndex].value;
    var cert = token.SOF_ExportUserCert(containerName, cerType);

    var ret = token.SOF_SetUserID(userID);
    ret = token.SOF_VerifySignedData(cert, Number(DigestMethod), _Base64encode(inData), signed);
    if (ret != 0)
        alert("验签失败,错误码:" + token.SOF_GetLastError());
    else
        alert("验签成功");
}

//数据签名----按键Key签名
function BB_signData() {
    var selectType = document.getElementById("sele_cerType");
    var cerType = selectType.options[selectType.selectedIndex].value;
    if (cerType == 0) {
        alert("请选择签名密钥进行签名");
        return;
    }
    var DigestMethod = document.getElementById("BB_mech").value;
    var userID = document.getElementById("BB_userID").value;
    var inData = document.getElementById("BB_originalData").value;
    var ret = token.SOF_SetDigestMethod(Number(DigestMethod));
    ret = token.SOF_SetUserID(userID);

    var container = document.getElementById("sele_contentList");
    if (container.selectedIndex < 0) {
        alert("请先枚举容器后操作");
        return;
    }

    var containerName = container.options[container.selectedIndex].text;
    if (containerName == null || containerName == "") {
        alert("请选择容器操作");
        return;
    }

    alert("提示： 当K5上显示灯闪烁时，请在20秒以内及时按下签名按钮……");

    var signed = token.SOF_SignDataInteractive(containerName, cerType, _Base64encode(inData), inData.length);
    if (signed != null && signed != "")
        document.getElementById("BB_signedData").value = signed;
    else
        alert("签名失败,错误码:" + token.SOF_GetLastError());
}

//数据验签----按键Key验证签名
function BB_verifySign() {
    var DigestMethod = document.getElementById("BB_mech").value;
    var userID = document.getElementById("BB_userID").value;
    var inData = document.getElementById("BB_originalData").value;
    var signed = document.getElementById("BB_signedData").value;
    if (signed == null || signed.length <= 0) {
        alert("请先签名后操作");
        return;
    }

    var container = document.getElementById("sele_contentList");
    if (container.selectedIndex < 0) {
        alert("请选择容器操作");
        return;
    }

    var selectType = document.getElementById("sele_cerType");
    var containerName = container.options[container.selectedIndex].text;
    if (containerName == null || containerName == "") {
        alert("请选择容器操作");
        return;
    }

    var cerType = selectType.options[selectType.selectedIndex].value;
    var cert = token.SOF_ExportUserCert(containerName, cerType);

    var ret = token.SOF_SetUserID(userID);
    ret = token.SOF_VerifySignedData(cert, Number(DigestMethod), _Base64encode(inData), signed);
    if (ret != 0)
        alert("验签失败,错误码:" + token.SOF_GetLastError());
    else
        alert("验签成功");
}

////////////////////////////////////////////////////////////////////////////////
//数据对称加密
function SymEncryptData() {
    var EncryptMethod = document.getElementById("Sym_encrymech").value;
    var sessionKey = document.getElementById("Sym_SessionKey").value;
    var iv = document.getElementById("Sym_iv").value;
    var inData = document.getElementById("Sym_InData").value;

    token.SOF_SetEncryptMethodAndIV(EncryptMethod, _Base64encode(iv));
    //对输入数据、会话密钥进行Base64编码
    var encrypedData = token.SOF_SymEncryptData(_Base64encode(sessionKey), _Base64encode(inData));
    if (encrypedData != null || encrypedData == "")
        document.getElementById("Sym_enedData").value = encrypedData;
    else
        alert("加密失败,错误码:" + token.SOF_GetLastError());
}
//数据对称解密
function SymDecryptData() {
    var EncryptMethod = document.getElementById("Sym_encrymech").value;
    var sessionKey = document.getElementById("Sym_SessionKey").value;
    var iv = document.getElementById("Sym_iv").value;

    var inData = document.getElementById("Sym_enedData").value;

    token.SOF_SetEncryptMethodAndIV(EncryptMethod, _Base64encode(iv));

    //对会话密钥进行Base64编码
    decryptedData = token.SOF_SymDecryptData(_Base64encode(sessionKey), inData);
    if (decryptedData != null && decryptedData != "")
        document.getElementById("Sym_deData").value = _Base64decode(decryptedData);
    else
        alert("解密失败,错误码:" + token.SOF_GetLastError());
}
//文件对称加密
function SymEncryptFile() {
    var EncryptMethod = document.getElementById("Sym_encrymech").value;
    var sessionKey = document.getElementById("Sym_SessionKey").value;
    var iv = document.getElementById("Sym_iv").value;
    var inFile = document.getElementById("Sym_srcFile").value;
    var outFile = document.getElementById("Sym_DstFile").value;

    token.SOF_SetEncryptMethodAndIV(EncryptMethod, _Base64encode(iv));
    //对会话密钥进行Base64编码
    var ret = token.SOF_SymEncryptFile(_Base64encode(sessionKey), inFile, outFile, 1);
    if (ret == 0)
        alert("加密完成，加密后的文件路径：" + outFile);
    else
        alert("加密失败,错误码:" + token.SOF_GetLastError());

}
//文件对称解密
function SymDecryptFile() {
    var EncryptMethod = document.getElementById("Sym_encrymech").value;
    var sessionKey = document.getElementById("Sym_SessionKey").value;
    var iv = document.getElementById("Sym_iv").value;
    var inFile = document.getElementById("Sym_DstFile").value;
    var outFile = document.getElementById("Sym_decDstFile").value;

    token.SOF_SetEncryptMethodAndIV(EncryptMethod, _Base64encode(iv));
    //对会话密钥进行Base64编码
    var ret = token.SOF_SymDecryptFile(_Base64encode(sessionKey), inFile, outFile, 1);
    if (ret == 0)
        alert("解密完成，解密后的文件路径：" + outFile);
    else
        alert("解密失败,错误码:" + token.SOF_GetLastError());
}

//创建文件，读写权限都是用户权限
function btnCreateFile() {
    var fileName = document.getElementById("Create_text").value;
    //36930为创建文件大小
    var Rtn = token.SOF_CreateFile(fileName, 36930, 16, 16);
    if (Rtn != 0) {
        alert("创建文件失败！错误码：" + token.SOF_GetLastError());
        return;
    }
    alert("创建成功");
}

function btnEnumFiles() {
    var selectID = document.getElementById("sel_fileList");
    selectID.options.length = 0;
    var fileList = token.SOF_EnumFiles();
    addOption(fileList, selectID, 1);

}

function btnReadFile() {
    var selectID = document.getElementById("sel_fileList");
    var index = selectID.selectedIndex;
    if (index < 0) {
        alert("请选中列表中设备后操作");
        return;
    }

    var fileName = selectID.options[index].text;
    var fileData = token.SOF_ReadFile(fileName, 0, 0); //read all data
    if (fileData == "" || fileData == null || fileData == undefined) {
        alert("读取失败,错误码:" + token.SOF_GetLastError());
        return;
    }
    document.getElementById("file_data").value = _Base64decode(fileData);

}

function btnWriteFile() {
    var selectID = document.getElementById("sel_fileList");
    var index = selectID.selectedIndex;

    var fileName = selectID.options[index].text;
    var fileData = document.getElementById("file_data").value;

    var ret = token.SOF_WriteFile(fileName, 0, _Base64encode(fileData)); //read all data
    if (ret != 0) {
        alert("写入失败,错误码:" + token.SOF_GetLastError());
        return;
    }
    alert("写入成功");

}

function btnWriteFile_Img() {
    var selectID = document.getElementById("sel_fileList");
    var index = selectID.selectedIndex;

    var fileName = selectID.options[index].text;
    var fileData = document.getElementById("base64_output").value;

    var ret = token.SOF_WriteFile(fileName, 0, _Base64encode(fileData)); //read all data
    if (ret != 0) {
        alert("写入失败,错误码:" + token.SOF_GetLastError());
        return;
    }
    alert("写入成功");
}


function btnReadFile_Img() {
    document.getElementById("base64_output").value = "";
    var selectID = document.getElementById("sel_fileList");
    var index = selectID.selectedIndex;
    if (index < 0) {
        alert("请选中列表中设备后操作");
        return;
    }

    var fileName = selectID.options[index].text;
    var fileData = token.SOF_ReadFile(fileName, 0, 0); //read all data
    if (fileData == "" || fileData == null || fileData == undefined) {
        alert("读取失败,错误码:" + token.SOF_GetLastError());
        return;
    }
    document.getElementById("base64_output").value = _Base64decode(fileData);

}

function SetCrossAccess() {
    var test = token.SOF_SetCrossAccess("TRUE");

}

//验证用户密码
function QueryGingerID() {
    var ret = 0;
    var strRes = "";
    //获取指纹ID
    var hwType = token.SOF_GetHardwareType();
    if (hwType == token.TYPE_FPKEY) {//开始“用户验证指纹”的提示

        var nRet = 0;
        alert("获取指纹ID，当指纹KEY上的指示灯开始闪烁时，请按压手指以验证指纹......");
        nRet = token.SOF_QueryFinger("K9");
        var lastErr = token.SOF_GetLastError();
        if (lastErr != 0) {
            if (lastErr == 0xB000040) {
                strRes = "等待指纹验证超时，请重新认证";
            }
            else {
                strRes = "验证用户指纹失败。" + "错误码：" + lastErr;
            }
        }
        else {
            strRes = "验证用户指纹成功，" + "指纹ID = " + nRet;
        }
        alert(strRes);
    }
    else {
        alert("不支持的设备类型，请更换设备测试");
    }
}

function btnDigestInit() {
    var nRet = 0;
    var mode = 1;   //1， SM3 ECC摘要，预处理，需要传入公钥 和User ID

    if (mode) {
        var pubKey = document.getElementById("DigestInit_pubKey").value;
        var userID = "1234567812345678";

        nRet = token.SOF_SetUserID(userID);
        if (nRet != 0) {
            alert("设置UserID 错误" + token.SOF_GetLastError());
            return;
        }
    }

    var DigestMethod = document.getElementById("digestmech").value;
    var ret = token.SOF_SetDigestMethod(Number(DigestMethod)); // 指定摘要算法

    nRet = token.SOF_DigestInit(pubKey, mode);
    if (nRet != 0) {
        alert("摘要初始化失败" + token.SOF_GetLastError());
        return;
    }
}

function btnDigestUpdate() {
    var nRet = 0;
    var digestData = document.getElementById("DigestUpdate_data").value;

    nRet = token.SOF_DigestUpdate(_Base64encode(digestData));
    if (nRet != 0) {
        alert("摘要数据Update失败" + token.SOF_GetLastError());
        return;
    }
}

function btnDigestFinal() {
    var digestValue = "";
    digestValue = token.SOF_DigestFinal();
    if (digestValue == "") {
        alert("摘要Final 失败" + token.SOF_GetLastError());
        return;
    }

    document.getElementById("Digest_Value").value = digestValue;
}

function btnDigestToSigned() {
    //获取容器名称
    var container = document.getElementById("sele_contentList");
    if (container.selectedIndex < 0) {
        alert("请选择容器操作");
        return;
    }
    var containerName = container.options[container.selectedIndex].text;
    if (containerName == null || containerName == "") {
        alert("容器名称为空，请选择需要签名的容器！");
        return;
    }

    //容器类型
    var selectType = document.getElementById("sele_cerType");
    var cerType = selectType.options[selectType.selectedIndex].value;
    if (cerType == 0) {
        alert("请选择签名密钥进行签名");
        return;
    }

    //获取已经处理摘要的数据值，摘要值经过Base64编码
    var digestData = document.getElementById("Digest_Value").value;
    if (digestData == "") {
        alert("摘要值不能为空，请填写摘要值");
        return;
    }
    var signedType = "P7";   //P1：签名出来的数据是P1格式, P7：签名出来的数据是P7格式
    var signedValue = token.SOF_DigestToSignData(containerName, cerType, signedType, digestData);
    if (signedValue == "") {
        alert("使用摘要值签名数据失败" + token.SOF_GetLastError());
        return;
    }

    document.getElementById("Signed_Value").value = signedValue;
}
function btnAuthDevCode() {
    //选择指定的设备认证
    var selectID = document.getElementById("sele_devices");
    var cerlistID = document.getElementById("sele_contentList");
    cerlistID.options.length = 0;
    var index = selectID.selectedIndex;
    if (index < 0) {
        alert("请选中设备列表中设备后操作");
        return;
    }

    var deviceName = selectID.options[index].text;


    //获取设备认证码
    var nRet = 0;
    var authDevCode = document.getElementById("authDevCode").value;

    nRet = token.SOF_DevAuth(deviceName, authDevCode);
    if (nRet != 0) {
        alert("设备认证失败" + token.SOF_GetLastError());
        return;
    }
    else {
        alert("设备认证成功");
    }
}

function btnChangeAuthDevCode() {
    //获取新设备认证码
    var nRet = 0;
    var authDevCode = document.getElementById("authDevCode_New").value;
    if (authDevCode == "" || authDevCode == null) {
        alert("请填写要修改的设备认证密钥！");
        return;
    }
    nRet = token.SOF_ChangeDevAuthKey(authDevCode);
    if (nRet != 0) {
        alert("修改设备认证密钥失败" + token.SOF_GetLastError());
        return;
    }
    else {
        alert("修改设备认证密钥成功");
    }
}

function btnCreatAppName() {
    //获取新设备认证码
    var nRet = 0;
    var appName = document.getElementById("AppName").value; //应用名称
    var adminPin = document.getElementById("adminPin").value; //管理员密码
    var adminPinRetryCount = document.getElementById("adminPinRetryCount").value;                           //管理员密码最大重试次数
    var userPin = document.getElementById("userPin").value;//用户密码
    var userPinRetryCount = document.getElementById("userPinRetryCount").value;//用户密码最大重试次数

    //0x00000000	//不允许
    //0x00000001	//管理员权限
    //0x00000010	//用户权限
    //0x000000FF	//任何人
    var fileRights = document.getElementById("AppfileRights").value;
    nRet = token.SOF_CreateApplication(appName, adminPin, adminPinRetryCount, userPin, userPinRetryCount, fileRights);
    if (nRet != 0) {
        alert("应用创建失败" + token.SOF_GetLastError());
        return;
    }
    else {
        alert("应用创建成功");
    }
}

function btnGetAppNameList() {
    //列举应用名称

    var selectID = document.getElementById("sele_devices");

    var appNameListID = document.getElementById("sele_appNameList");
    appNameListID.options.length = 0;

    var index = selectID.selectedIndex;
    if (index < 0) {
        alert("请选择‘设备列表’中设备后操作");
        return;
    }

    var deviceName = selectID.options[index].text;


    var appNameList = token.SOF_GetApplicationList(deviceName);

    if (appNameList != null && appNameList.length > 0)
        addOption(appNameList, appNameListID, 1);
}


function btnDeleteAppName() {
    //删除指定应用名称
    var nRet = 0;

    //选择将要删除的应用名称	
    var selectID = document.getElementById("sele_appNameList");
    var index = selectID.selectedIndex;
    if (index < 0) {
        alert("请先获取应用");
        return;
    }

    var appName = selectID.options[index].text;

    nRet = token.SOF_DeleteApplication(appName);
    if (nRet != 0) {
        alert("删除应用失败" + token.SOF_GetLastError());
        return;
    }
    else {
        alert("删除应用成功");
    }
}

var bCheckTimer;
var CheckDeviceName = "";
function btnCheckExist() {
    //将定时按钮禁用
    document.getElementById("btn_Timer").disabled = true;
    var nRet = 0;
    //选择指定的设备进行定时检测
    if (CheckDeviceName == "") {
        var selectID = document.getElementById("sele_devices");
        var cerlistID = document.getElementById("sele_contentList");
        cerlistID.options.length = 0;
        var index = selectID.selectedIndex;
        if (index < 0) {
            alert("请选中设备列表中设备后操作");
            document.getElementById("btn_Timer").disabled = false;
            return;
        }

        CheckDeviceName = selectID.options[index].text;
    }

    nRet = token.SOF_CheckExists(CheckDeviceName);
    if (nRet == 1) {
        alert("检测到KEY正常插入 ID = " + CheckDeviceName);
    }
    else {
        alert("检测KEY存在异常，错误码=" + token.SOF_GetLastError());
        CheckDeviceName = token.SOF_EnumDevice();
    }

    bCheckTimer = setTimeout("btnCheckExist()", 3000);
}
//停止定时
function btnStopExist() {
    //将定时按钮启用
    document.getElementById("btn_Timer").disabled = false;
    clearTimeout(bCheckTimer);
}
/**
 * 给按钮添加等待特效
 * @param {*按钮ID} btnId 
 * @param {*方法的名称} funName 
 */
function btnLodingStyle(btnId, funName) {
    document.getElementById(btnId).style.backgroundImage = "url(images/loding.gif)";
    document.getElementById(btnId).style.backgroundRepeat = "no-repeat";
    document.getElementById(btnId).style.backgroundPosition = "10% 40%";
    document.getElementById(btnId).style.backgroundSize = "15% 80%";
    //为了特效展示，添加延迟执行
    setTimeout(funName, 500);
}
/**
 * 去掉按钮等待特效
 * @param {*按钮ID} btnId 
 */
function btnLodingStyleStop(btnId) {
    document.getElementById(btnId).style.backgroundImage = "";
    document.getElementById(btnId).style.backgroundRepeat = "";
    document.getElementById(btnId).style.backgroundPosition = "";
    document.getElementById(btnId).style.backgroundSize = "";
}
function btn_SelCert() {
    //给按钮添加等待特效，并执行查找容器的方法
    btnLodingStyle("btn_FindCon", btn_FindContainer);
}
//根据证书序列号查找容器
function btn_FindContainer() {
    var array = new Array();
    var arraySucc = new Array();
    var certNumberStr = document.getElementById("certId").value;
    if (certNumberStr == "") {
        alert("请输入要查询的证书序列号，多个序列号请以 ',' 逗号分隔！");
        btnLodingStyleStop("btn_FindCon");
        return;
    }
    array = certNumberStr.split(',');
    for (var i = 0; i < array.length; i++) {
        var nRet = token.SOF_FindContainer(array[i]);
        if (nRet == "" || nRet == undefined) {
            btnLodingStyleStop("btn_FindCon");
            alert("查询失败，错误码：" + token.SOF_GetLastError());
            return;
        }
        arraySucc[i] = nRet;
    }
    document.getElementById("certId").value = "查询的容器名为：\n";
    for (var j = 0; j < arraySucc.length; j++) {
        document.getElementById("certId").value += arraySucc[j] + "\n";
    }
    btnLodingStyleStop("btn_FindCon");
}

function btn_deleCon() {
    //给按钮添加等待特效，并执行删除容器的方法
    btnLodingStyle("btn_deleCon_ID", deleCon);
}
//根据证书序列号删除容器
function deleCon() {
    var txt_certNumber = document.getElementById("txt_certNumber").value;
    if (txt_certNumber == "") {
        alert("请输入要删除的证书序列号！");
        btnLodingStyleStop("btn_deleCon_ID");
        return;
    }
    var nRet = token.SOF_DeleteContainer(txt_certNumber);
    if (nRet != 0) {
        alert("删除容器失败！错误码：" + token.SOF_GetLastError());
        btnLodingStyleStop("btn_deleCon_ID");
        return;
    } else {
        alert("删除成功。");
        btnLodingStyleStop("btn_deleCon_ID");
    }
}

function OnGenerateAgreementDataWithECC() {

    var container = document.getElementById("sele_contentList");
    if (container.selectedIndex < 0) {
        alert("请选择容器操作");
        return;
    }
    var selectType = document.getElementById("sele_cerType");
    var containerName = container.options[container.selectedIndex].text;
    if (containerName == null || containerName == "") {
        alert("请选择容器操作");
        return;
    }

    var strAgreemntAlgID = document.getElementById("slect_agreemntAlgID").value;
    var strSponsorID = document.getElementById("txt_SponsorID").value;

    var temmPubKey = token.SOF_GenerateAgreementDataWithECC(containerName, strAgreemntAlgID, _Base64encode(strSponsorID));
    if (temmPubKey != null && temmPubKey != "") {
        document.getElementById("txt_tempECCPubKeyBlob").value = temmPubKey;
    }
    else {
        alert("发起方密钥协商请求失败,错误码:" + token.SOF_GetLastError());
    }

}

function OnGenerateKeyWithECC() {
    //获取发起方密钥协商请求句柄
    var hAgreementHandle = token.SOF_GetAgreementDataWithECCHandle();

    var strResponseECCPubKeyBlob = document.getElementById("txt_ResponseECCPubKeyBlob").value;
    var strResponseTempECCPubKeyBlob = document.getElementById("txt_ResponseTempECCPubKeyBlob").value;
    var strResponseID = document.getElementById("txt_ResponseID").value;

    var hKeyHandle = token.SOF_GenerateKeyWithECC(hAgreementHandle, strResponseECCPubKeyBlob, strResponseTempECCPubKeyBlob, _Base64encode(strResponseID));
    if (hKeyHandle != 0) {
        document.getElementById("txt_AgreementKeyHandle").value = hKeyHandle;
    }
    else {
        alert("密钥协商失败,错误码:" + token.SOF_GetLastError());
    }
}

function OnAgreementEncrypted() {
    var hAgreementKeyHandle = document.getElementById("txt_AgreementKeyHandle").value;
    var strAgreementEncrypteData = document.getElementById("txt_AgreementEncrypteData").value;


    var encrypedData = token.SOF_EncryptWithSessionKey(hAgreementKeyHandle, _Base64encode(strAgreementEncrypteData));
    if (encrypedData != null || encrypedData == "")
        document.getElementById("txt_AgreementCiphertextData").value = encrypedData;
    else
        alert("加密失败,错误码:" + token.SOF_GetLastError());

}

function OnAgreementDecrypted() {
    var hAgreementKeyHandle = document.getElementById("txt_AgreementKeyHandle").value;
    var strAgreementDerypteData = document.getElementById("txt_AgreementEncrypteData").value;

    var decrypedData = token.SOF_DecryptWithSessionKey(hAgreementKeyHandle, strAgreementDerypteData);
    if (decrypedData != null || decrypedData == "")
        document.getElementById("txt_AgreementCiphertextData").value = decrypedData;
    else
        alert("解密失败,错误码:" + token.SOF_GetLastError());
}














