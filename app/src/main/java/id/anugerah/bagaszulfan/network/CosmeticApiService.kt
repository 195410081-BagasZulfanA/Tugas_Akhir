package id.anugerah.bagaszulfan.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// objek BASE_URL
private const val BASE_URL = "https://makeup-api.herokuapp.com"

// objek moshi untuk retrofit
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// objek retrofit yang diperoleh dari moshi converter
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface CosmeticApiService {
    // pengambilan data melalui url dari BASE_URL
    @GET("/api/v1/products.json?brand=maybelline")
    suspend fun getCosmetics(): List<CosmeticPhotos>
}

object CosmeticApi {
    val retrofitService: CosmeticApiService by lazy { retrofit.create(CosmeticApiService::class.java) }
}