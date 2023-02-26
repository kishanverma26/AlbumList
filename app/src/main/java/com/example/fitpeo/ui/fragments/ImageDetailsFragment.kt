package com.example.fitpeo.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitpeo.models.PhotoRes
import com.example.fitpeo.utils.BaseFragment
import com.example.pitpeo.R
import com.example.pitpeo.databinding.ImageDetailsBinding
import com.squareup.picasso.Picasso

class ImageDetailsFragment : BaseFragment(R.layout.image_details) {
    private lateinit var binding: ImageDetailsBinding
    private lateinit var dataPhoto: PhotoRes

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            ImageDetailsBinding.inflate(inflater, container, false)
        setDataUI()

        return binding.root
    }

    private fun setDataUI() {
        dataPhoto = arguments?.get("data") as PhotoRes

        binding.tvExplanation.text = dataPhoto.title
        Picasso.get().load(dataPhoto.url).into(binding.image);

    }


}