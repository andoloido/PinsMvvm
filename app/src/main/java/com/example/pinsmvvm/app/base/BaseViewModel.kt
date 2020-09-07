package com.example.pinsmvvm.app.base

import androidx.lifecycle.*
import com.example.pinsmvvm.app.network.HttpResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

//定义网络请求状态(密封类扩展性更好)
sealed class RequestActionEvent

object RequestState : RequestActionEvent()

object SuccessState : RequestActionEvent()

class ErrorState(val message: String?) : RequestActionEvent()

open class BaseViewModel : ViewModel() {
    /**
     *  通用事件模型驱动(如：显示对话框、取消对话框、错误提示)
     */
    val mStateLiveData = MutableLiveData<RequestActionEvent>()

    /**
     * 网络请求
     */
    fun <T> request(block: suspend () -> HttpResponse<T>): LiveData<T> = liveData {
        runCatching {
            mStateLiveData.value = RequestState
            val result = block()
            if (result.success) {
                mStateLiveData.value = SuccessState
                emit(result.data)
            } else {
                mStateLiveData.value = ErrorState(result.message)
            }
        }.onFailure {
            mStateLiveData.value = ErrorState(it.message)
        }
    }
}
