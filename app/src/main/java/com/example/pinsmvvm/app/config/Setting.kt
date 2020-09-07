package com.example.pinsmvvm.app.config

import com.example.pinsmvvm.app.config.Constant.Account.AUTHORIZATION
import com.example.pinsmvvm.app.config.Constant.Account.DEVICE_ID
import com.example.pinsmvvm.app.config.Constant.Account.LOGIN_NAME
import com.example.pinsmvvm.app.config.Constant.Account.USER_ID
import com.example.pinsmvvm.app.utils.SpUtil

object Setting {
    var authorization by SpUtil(AUTHORIZATION, "")
    var loginName by SpUtil(LOGIN_NAME, "")
    var userId by SpUtil(USER_ID, "")
    var deviceId by SpUtil(DEVICE_ID, "")
}