package id.anugerah.bagaszulfan.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.anugerah.bagaszulfan.network.CosmeticApi
import id.anugerah.bagaszulfan.network.CosmeticPhotos
import kotlinx.coroutines.launch

enum class CosmeticApiStatus { LOADING, ERROR, DONE }

class OverviewViewModel : ViewModel() {

    // objek berisi status pengambilan data melalui internet
    private val _status = MutableLiveData<CosmeticApiStatus>()
    val status: LiveData<CosmeticApiStatus> = _status

    // pengambilan daftar data URL di masukan ke list melalui objek _photos
    private val _photos = MutableLiveData<List<CosmeticPhotos>>()
    val photos: LiveData<List<CosmeticPhotos>> = _photos

    // proses pemanggilan fungsi dari getCosmeticsPhotos() ke dalam fungsi init
    init {
        getCosmeticsPhotos()
    }

    // pengambilan data gambar Kosmetik melalui servis API retrofit
    private fun getCosmeticsPhotos() {

        viewModelScope.launch {
            // menampilkan status loading
            _status.value = CosmeticApiStatus.LOADING
            try {
                // jika tidak ada error
                _photos.value = CosmeticApi.retrofitService.getCosmetics()
                _status.value = CosmeticApiStatus.DONE
            } catch (e: Exception) {
                // jika Error
                _status.value = CosmeticApiStatus.ERROR
                _photos.value = listOf()
            }
        }
    }
}