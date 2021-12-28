package id.anugerah.bagaszulfan.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import id.anugerah.bagaszulfan.databinding.FragmentOverviewBinding

class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)

        // akses data binding untuk LiveData
        binding.lifecycleOwner = this

        // akses binding ke OverviewViewModel
        binding.viewModel = viewModel

        // setting adapter dari photosgrid
        binding.photosGrid.adapter = PhotoGridAdapter()

        return binding.root
    }
}