package com.example.pinsmvvm

import android.app.Application
import androidx.core.content.ContextCompat
import com.scwang.smart.refresh.footer.BallPulseFooter
import com.scwang.smart.refresh.header.MaterialHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout

class App : Application() {
    companion object {
        lateinit var application: App
    }

    override fun onCreate() {
        super.onCreate()
        application = this

        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
            MaterialHeader(context).setColorSchemeColors(
                ContextCompat.getColor(
                    context,
                    R.color.colorPrimary
                )
            )
        }
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout ->
            BallPulseFooter(context).apply {
                setNormalColor(
                    ContextCompat.getColor(
                        context,
                        R.color.colorPrimary
                    )
                )
                setAnimatingColor(
                    ContextCompat.getColor(
                        context,
                        R.color.colorPrimary
                    )
                )
            }
        }
    }
}