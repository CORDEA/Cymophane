package jp.cordea.cymophane.ui.main

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.view.ViewGroup
import jp.cordea.cymophane.data.Photo

class CatAdapter : PagedListAdapter<Photo, CatViewHolder>(
        object : DiffUtil.ItemCallback<Photo>() {
            override fun areItemsTheSame(p0: Photo, p1: Photo): Boolean =
                    p0.url == p1.url

            override fun areContentsTheSame(p0: Photo, p1: Photo): Boolean =
                    p0 == p1
        }
) {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): CatViewHolder =
            CatViewHolder(viewGroup)

    override fun onBindViewHolder(viewHolder: CatViewHolder, position: Int) {
        viewHolder.bind(getItem(position)!!)
    }
}
