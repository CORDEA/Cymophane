package jp.cordea.cymophane.ui.login

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _shouldGoToMain = MutableLiveData<String>()
    val shouldGoToMain: LiveData<String> = _shouldGoToMain

    var key: String = ""

    val onClick = View.OnClickListener {
        _shouldGoToMain.value = key
    }
}
