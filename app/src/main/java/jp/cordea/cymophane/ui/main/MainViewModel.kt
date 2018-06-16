package jp.cordea.cymophane.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import jp.cordea.cymophane.data.Photo

class MainViewModel : ViewModel() {
    companion object {
        private const val SIZE = 10
    }

    private val dataSource = CatDataSourceFactory()

    val photos: LiveData<PagedList<Photo>> =
            LivePagedListBuilder(dataSource, SIZE).build()
}
