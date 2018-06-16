package jp.cordea.cymophane.ui.main

import android.arch.paging.DataSource
import jp.cordea.cymophane.data.Photo

class CatDataSourceFactory : DataSource.Factory<Int, Photo>() {
    override fun create(): DataSource<Int, Photo> = CatDataSource()
}
