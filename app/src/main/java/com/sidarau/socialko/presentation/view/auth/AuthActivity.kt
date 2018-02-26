package com.sidarau.socialko.presentation.view.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.sidarau.socialko.R
import com.sidarau.socialko.presentation.view.auth.login.LoginFragment
import com.sidarau.socialko.presentation.view.auth.register.RegistrationFragment
import com.sidarau.socialko.presentation.view.core.BaseActivity


/**
 *
 * @author Anton Sidorov
 */
class AuthActivity : BaseActivity(), LoginFragment.OnRegisterClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        savedInstanceState ?: run {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container_layout, LoginFragment.newInstance())
                    .commit()
        }
    }

    override val layoutRes: Int
        get() = R.layout.container_activity

    override fun onRegisterClick() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container_layout, RegistrationFragment.newInstance())
                .addToBackStack(RegistrationFragment.TAG)
                .commit()
    }

    companion object {
        fun newIntent(context: Context) =
                Intent(context, AuthActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                }
    }
}