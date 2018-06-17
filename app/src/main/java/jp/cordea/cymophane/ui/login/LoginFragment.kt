package jp.cordea.cymophane.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import jp.cordea.cymophane.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View =
            FragmentLoginBinding.inflate(inflater, container, false).also {
                it.vm = ViewModelProviders.of(activity!!).get(LoginViewModel::class.java)
            }.root
}
