package com.sidarau.socialko.presentation.view.main.feed.delegate

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate
import com.sidarau.socialko.R
import com.sidarau.socialko.core.extensions.inflate
import com.sidarau.socialko.models.domain.feed.Post
import kotlinx.android.synthetic.main.post_layout_item.view.*

/**
 * @author Anton Sidorov
 */
class PostDelegate : AdapterDelegate<MutableList<Any>>() {

    override fun isForViewType(items: MutableList<Any>, position: Int) =
            items[position] is Post

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
            ViewHolder(parent.inflate(R.layout.post_layout_item))

    override fun onBindViewHolder(
            items: MutableList<Any>,
            position: Int,
            holder: RecyclerView.ViewHolder,
            payloads: MutableList<Any>
    ) = (holder as ViewHolder).bind(items[position] as Post)

    private inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(post: Post) {
            with(itemView) {
                nameTextView.text = post.personName
                bodyTextView.text = post.body
                likeCounterTextView.text = post.likes.toString()
            }
        }
    }
}