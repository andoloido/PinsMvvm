package com.example.pinsmvvm.app.network

object RemoteSettingUtils {
    var testMode: Boolean = false
    lateinit var updateInfoUrl: String
    lateinit var mainUrl: String
    lateinit var remotectrlUrl: String
    lateinit var agoraAppId: String
    lateinit var remotectrlMqttTag: String
    lateinit var sensorUrl: String

    init {
        testConfig()
        devConfig()
    }

    private fun testConfig() {
        testMode = true
        updateInfoUrl =
            "http://pins-app-resources.oss-cn-qingdao.aliyuncs.com/publish/pinslife_test/com.pinsmedical.pinslife2"
        mainUrl = "http://dev.helloparkin.com:58090/" //外网映射
        remotectrlUrl = "http://192.168.1.207:8080/"
        agoraAppId = "f7a36a08769548b79bd168c016066c81"
        remotectrlMqttTag = "pinstest"
        sensorUrl =
            "https://pinchijiankang.datasink.sensorsdata.cn/sa?project=default&token=123dc90c4fa7cb5e"
    }

    private fun devConfig() {
        testMode = true
        updateInfoUrl =
            "http://pins-app-resources.oss-cn-qingdao.aliyuncs.com/publish/pinslife_test/com.pinsmedical.pinslife2"
        mainUrl = "http://dev.helloparkin.com:58080/" //外网映射
        remotectrlUrl = "http://192.168.1.222:8086/"
        agoraAppId = "f7a36a08769548b79bd168c016066c81"
        remotectrlMqttTag = "pinsdev"
        sensorUrl =
            "https://pinchijiankang.datasink.sensorsdata.cn/sa?project=default&token=123dc90c4fa7cb5e"
    }

}