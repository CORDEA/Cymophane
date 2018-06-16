package jp.cordea.cymophane.data

import com.squareup.moshi.Json

data class Search(
        val page: Int,
        @Json(name = "per_page") val perPage: Int,
        @Json(name = "total_results") val totalResults: Long,
        val url: String,
        @Json(name = "next_page") val nextPage: String,
        val photos: List<Photo>
)

data class Photo(
        val width: Int,
        val height: Int,
        val url: String,
        val photographer: String,
        val src: Src
)

data class Src(
        val original: String,
        val large: String,
        val large2x: String,
        val medium: String,
        val small: String,
        val portrait: String,
        val landscape: String,
        val tiny: String
)
