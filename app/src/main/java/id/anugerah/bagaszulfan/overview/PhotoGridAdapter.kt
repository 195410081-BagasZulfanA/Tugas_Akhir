package id.anugerah.bagaszulfan.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import id.anugerah.bagaszulfan.databinding.GridViewItemBinding
import id.anugerah.bagaszulfan.network.CosmeticPhotos

// adapter tampilan grid
class PhotoGridAdapter :
    ListAdapter<CosmeticPhotos, PhotoGridAdapter.CosmeticPhotosViewHolder>(DiffCallback) {

    // class viewHolder
    class CosmeticPhotosViewHolder(
        private var binding: GridViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(CosmeticPhotos: CosmeticPhotos) {
            binding.photo = CosmeticPhotos
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }

    // untuk download dan ditampilkan pada tampilan.
    companion object DiffCallback : DiffUtil.ItemCallback<CosmeticPhotos>() {
        override fun areItemsTheSame(oldItem: CosmeticPhotos, newItem: CosmeticPhotos): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CosmeticPhotos, newItem: CosmeticPhotos): Boolean {
            return oldItem.imgUrl == newItem.imgUrl
        }
    }

    // untuk binding data ke tampilan
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CosmeticPhotosViewHolder {
        return CosmeticPhotosViewHolder(
            GridViewItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    // binding adapter terhubung ke view holder dengan data Kosmetik
    override fun onBindViewHolder(holder: CosmeticPhotosViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }
}