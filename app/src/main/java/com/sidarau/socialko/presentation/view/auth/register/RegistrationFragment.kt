package com.sidarau.socialko.presentation.view.auth.register

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.sidarau.socialko.R
import com.sidarau.socialko.models.presentation.Response
import com.sidarau.socialko.presentation.view.core.BaseFragment
import com.sidarau.socialko.presentation.vm.auth.register.RegisterViewModel
import kotlinx.android.synthetic.main.registration_fragment.*
import javax.inject.Inject

/**
 * @author Anton Sidorov
 */
class RegistrationFragment : BaseFragment() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: RegisterViewModel

    override val layoutRes: Int
        get() = R.layout.registration_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnRegister.setOnClickListener {
            viewModel.validate(etFirstName.text.toString(), etLastName.text.toString(),
                    etEmail.text.toString(), etPassword.text.toString())
        }

        cbAgreement.setOnCheckedChangeListener { _, checked ->
            viewModel.agreementLiveData.setValue(checked)
        }
    }

    override fun initViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(RegisterViewModel::class.java)
    }

    override fun observeLiveData() {
        viewModel.agreementLiveData.observe(this, Observer {
            btnRegister.isEnabled = it ?: false
        })

        viewModel.validateLiveData.observe(this, Observer {
            it?.let {
                if (it.isEmpty()) {
                    viewModel.register(etFirstName.text.toString(), etLastName.text.toString(),
                            etEmail.text.toString(), etPassword.text.toString())
                } else showSnackMessage(it.joinToString("\n"))
            }
        })

        viewModel.liveData.observe(this, Observer {
            it?.let {
                when (it) {
                    is Response.Error -> showSnackMessage(getString(R.string.registration_fail))
                    is Response.Success<*> -> fragmentManager?.popBackStack()
                    is Response.Progress -> showProgressDialog(it.progress)
                }
            }
        })
    }

    companion object {
        const val TAG = "RegistrationFragment"

        fun newInstance() = RegistrationFragment()
    }
}