package jp.cordea.cymophane.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import jp.cordea.cymophane.data.Photo

class MainViewModel : ViewModel() {
    companion object {
        private const val SIZE = 10
    }

    private val dataSource = CatDataSourceFactory()

    val photos: LiveData<PagedList<Photo>> =
            LivePagedListBuilder(dataSource, SIZE).build()
}
