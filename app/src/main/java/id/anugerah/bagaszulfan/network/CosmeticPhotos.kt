package id.anugerah.bagaszulfan.network

import com.squareup.moshi.Json

// class objek data
data class CosmeticPhotos (
    val id: String,
    @Json(name = "image_link") val imgUrl: String
)