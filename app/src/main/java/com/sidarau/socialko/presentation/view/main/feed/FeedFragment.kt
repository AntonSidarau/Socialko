package com.sidarau.socialko.presentation.view.main.feed

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.sidarau.socialko.R
import com.sidarau.socialko.models.presentation.Response
import com.sidarau.socialko.presentation.view.core.BaseFragment
import com.sidarau.socialko.presentation.view.main.feed.delegate.AddPostDelegate
import com.sidarau.socialko.presentation.view.main.feed.delegate.PostDelegate
import com.sidarau.socialko.presentation.vm.main.FeedViewModel
import kotlinx.android.synthetic.main.feed_fragment.*
import javax.inject.Inject

/**
 * @author Anton Sidorov
 */
class FeedFragment : BaseFragment() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: FeedViewModel
    private val adapter = FeedDelegationAdapter()

    override val layoutRes: Int = R.layout.feed_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter.addDelegate(AddPostDelegate())
        adapter.addDelegate(PostDelegate())
    }

    override fun initViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(FeedViewModel::class.java)
    }

    override fun observeLiveData() {
        viewModel.liveData.observe(this, Observer {
            it?.let {
                when (it) {
                    is Response.Success<*> -> adapter.items = it as MutableList<Any>
                    is Response.Progress -> showProgressDialog(it.progress)
                    is Response.Error -> {
                        showSnackMessage(getString(R.string.registration_fail))
                        Log.e(TAG, "Failure", it.e)
                    }
                }
            }
        })
    }

    companion object {
        const val TAG = "FeedFragment"

        fun newInstance() = FeedFragment()
    }
}