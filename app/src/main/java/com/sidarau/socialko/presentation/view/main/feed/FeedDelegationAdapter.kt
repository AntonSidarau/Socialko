package com.sidarau.socialko.presentation.view.main.feed

import com.hannesdorfmann.adapterdelegates3.AdapterDelegate
import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter
import com.sidarau.socialko.core.Constants.Companion.EMPTY_STRING
import com.sidarau.socialko.models.presentation.feed.AddPostModel

/**
 * @author Anton Sidorov
 */
class FeedDelegationAdapter : ListDelegationAdapter<MutableList<Any>>() {

    init {
        items = mutableListOf()
        items.add(AddPostModel(EMPTY_STRING))
    }

    override fun setItems(data: MutableList<Any>?) {
        items.clear()
        data?.let {
            items.add(AddPostModel(EMPTY_STRING))
            items.addAll(it)
        }

        notifyDataSetChanged()
    }

    fun addDelegate(delegate: AdapterDelegate<MutableList<Any>>) {
        delegatesManager.addDelegate(delegate)
        notifyDataSetChanged()
    }
}