package com.example.fitpeo.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fitpeo.AppApplication
import com.example.fitpeo.models.PhotoRes
import com.example.fitpeo.ui.adapter.RVImageListingAdapter
import com.example.fitpeo.utils.BaseFragment
import com.example.fitpeo.utils.OnAdapterClick
import com.example.fitpeo.viewmodels.PhotoViewModel
import com.example.fitpeo.viewmodels.PhotoViewModelFactory
import com.example.pitpeo.R
import com.example.pitpeo.databinding.PhotoListFragmentBinding
import javax.inject.Inject

class PhotoListFragment : BaseFragment(R.layout.photo_list_fragment) , OnAdapterClick {

    lateinit var photoListFragment: PhotoListFragmentBinding
    lateinit var viewModel: PhotoViewModel

    @Inject
    lateinit var viewModelFactory: PhotoViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        photoListFragment =
            PhotoListFragmentBinding.inflate(inflater, container, false)
        viewInitialize()
        initializeViewModel()

        return photoListFragment.root
    }



    private fun viewInitialize() {
        (requireActivity().application as AppApplication).appComponents.inject(this)
        photoListFragment.rvList.layoutManager = GridLayoutManager(requireActivity(),2)
    }

    private fun initializeViewModel() {
        viewModel = ViewModelProvider(this,viewModelFactory).get(PhotoViewModel::class.java)

        viewModel.photoList.observe(viewLifecycleOwner, Observer {
                if (it.size>0){
                photoListFragment.rvList.show()
                photoListFragment.tvEmptyView.hide()
                photoListFragment.progressCircular.hide()
                photoListFragment.rvList.adapter = RVImageListingAdapter(it,this)
            }else{
                photoListFragment.rvList.hide()
                photoListFragment.tvEmptyView.show()
                photoListFragment.progressCircular.hide()
            }
        })
    }

    override fun onItemClickListener(o: Any?, position: Int?) {
        var data = o as PhotoRes
        findNavController().navigate(
            R.id.list_To_Detail,
            bundleOf("data" to data)
        )
    }
}


