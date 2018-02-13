package com.sidarau.socialko.presentation.view.auth.login

import android.content.Context
import android.os.Bundle
import android.view.View
import com.sidarau.socialko.R
import com.sidarau.socialko.presentation.BaseFragment
import kotlinx.android.synthetic.main.login_fragment.*

/**
 * @author Anton Sidorov
 */
class LoginFragment : BaseFragment() {

    private var listener: OnRegisterClickListener? = null

    override val layoutRes: Int
        get() = R.layout.login_fragment

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = context as OnRegisterClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogin.setOnClickListener {
            //do smth
        }

        btnRegister.setOnClickListener {
            listener?.onRegisterClick()
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnRegisterClickListener {
        fun onRegisterClick()
    }

    companion object {
        const val TAG = "LoginFragment"

        fun newInstance() = LoginFragment()
    }
}