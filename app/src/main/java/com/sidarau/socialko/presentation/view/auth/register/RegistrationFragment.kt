package com.sidarau.socialko.presentation.view.auth.register

import android.os.Bundle
import android.view.View
import com.sidarau.socialko.R
import com.sidarau.socialko.presentation.BaseFragment
import kotlinx.android.synthetic.main.registration_fragment.*

/**
 * @author Anton Sidorov
 */
class RegistrationFragment : BaseFragment() {

    override val layoutRes: Int
        get() = R.layout.registration_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnRegister.setOnClickListener {
            //do smth
        }
    }

    companion object {
        const val TAG = "RegistrationFragment"

        fun newInstance() = RegistrationFragment()
    }
}