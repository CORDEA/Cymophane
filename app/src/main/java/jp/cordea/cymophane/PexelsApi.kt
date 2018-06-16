package jp.cordea.cymophane

import jp.cordea.cymophane.data.Search
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PexelsApi {

    @GET("v1/search")
    fun search(
            @Query("query") query: String,
            @Query("per_page") perPage: Int,
            @Query("page") page: Int
    ): Call<Search>
}
