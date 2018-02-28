package com.sidarau.socialko.presentation.view.main.feed.delegate

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate
import com.sidarau.socialko.R
import com.sidarau.socialko.core.extensions.inflate
import com.sidarau.socialko.models.presentation.feed.AddPostModel

/**
 * @author Anton Sidorov
 */
class AddPostDelegate : AdapterDelegate<MutableList<Any>>() {

    override fun isForViewType(items: MutableList<Any>, position: Int) =
            items[position] is AddPostModel

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
            ViewHolder(parent.inflate(R.layout.add_post_layout_item))

    override fun onBindViewHolder(items: MutableList<Any>,
                                  position: Int,
                                  holder: RecyclerView.ViewHolder,
                                  payloads: MutableList<Any>) =
            (holder as ViewHolder).bind()


    private inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind() {
            //TODO handle input and click
        }
    }
}