package id.anugerah.bagaszulfan

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import id.anugerah.bagaszulfan.network.CosmeticPhotos
import id.anugerah.bagaszulfan.overview.CosmeticApiStatus
import id.anugerah.bagaszulfan.overview.PhotoGridAdapter

// adapter binding data melalui photoGridAdapter
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<CosmeticPhotos>?) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    // menampilkan data
    adapter.submitList(data)
}

// adapter untuk membinding data gambar
@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        // konfigurasi akses ke data
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        // proses download resource
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

// adapter untuk membinding data status koneksi
@BindingAdapter("cosmeticApiStatus")
fun bindStatus(statusImageView: ImageView, status: CosmeticApiStatus?) {
    when (status) {
        CosmeticApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        CosmeticApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        CosmeticApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}