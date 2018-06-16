package jp.cordea.cymophane.ui.main

import androidx.paging.PageKeyedDataSource
import jp.cordea.cymophane.PexelsApiClient
import jp.cordea.cymophane.data.Photo
import jp.cordea.cymophane.data.Search
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatDataSource : PageKeyedDataSource<Int, Photo>() {
    companion object {
        private const val query = "cat"
    }

    override fun loadInitial(
            params: LoadInitialParams<Int>,
            callback: LoadInitialCallback<Int, Photo>
    ) {
        PexelsApiClient.search(
                query,
                params.requestedLoadSize,
                0
        ).enqueue(object : Callback<Search> {
            override fun onFailure(call: Call<Search>, t: Throwable) {
            }

            override fun onResponse(call: Call<Search>, response: Response<Search>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        callback.onResult(it.photos, -1, 1)
                    }
                }
            }
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Photo>) {
        PexelsApiClient.search(
                query,
                params.requestedLoadSize,
                params.key
        ).enqueue(object : Callback<Search> {
            override fun onFailure(call: Call<Search>, t: Throwable) {
            }

            override fun onResponse(call: Call<Search>, response: Response<Search>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        callback.onResult(it.photos, params.key + 1)
                    }
                }
            }
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Photo>) {
        // do nothing
    }
}
