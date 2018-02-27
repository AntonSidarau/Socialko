package com.sidarau.socialko.presentation.view.auth.login

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.util.Log
import com.sidarau.socialko.R
import com.sidarau.socialko.models.presentation.Response
import com.sidarau.socialko.presentation.view.core.BaseFragment
import com.sidarau.socialko.presentation.view.main.MainActivity
import com.sidarau.socialko.presentation.vm.auth.login.LoginViewModel
import kotlinx.android.synthetic.main.login_fragment.*
import javax.inject.Inject

/**
 * @author Anton Sidorov
 */
class LoginFragment : BaseFragment() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: LoginViewModel
    private var listener: OnRegisterClickListener? = null

    override val layoutRes: Int
        get() = R.layout.login_fragment

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = context as OnRegisterClickListener
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnLogin.setOnClickListener {
            viewModel.validate(etLogin.text.toString(), etPassword.text.toString())
        }

        btnRegister.setOnClickListener {
            listener?.onRegisterClick()
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun initViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
    }

    override fun observeLiveData() {
        viewModel.validateLiveData.observe(this, Observer {
            it?.let {
                if (it.isEmpty()) {
                    viewModel.login(etLogin.text.toString(), etPassword.text.toString())
                } else showSnackMessage(it.joinToString("\n"))
            }
        })

        viewModel.liveData.observe(this, Observer {
            it?.let {
                when (it) {
                    is Response.Error -> {
                        showSnackMessage(getString(R.string.login_fail))
                        Log.e(TAG, "Failure", it.e)
                    }
                    is Response.Success<*> -> context?.let { startActivity(MainActivity.newIntent(it)) }
                    is Response.Progress -> showProgressDialog(it.progress)
                }
            }
        })
    }

    interface OnRegisterClickListener {
        fun onRegisterClick()
    }

    companion object {
        const val TAG = "LoginFragment"

        fun newInstance() = LoginFragment()
    }
}