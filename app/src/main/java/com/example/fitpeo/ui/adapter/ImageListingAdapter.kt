package com.example.fitpeo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitpeo.models.PhotoRes
import com.example.fitpeo.utils.OnAdapterClick
import com.example.pitpeo.databinding.RowImageGridBinding
import com.squareup.picasso.Picasso

class RVImageListingViewHolder(val binding: RowImageGridBinding) :
    RecyclerView.ViewHolder(binding.root)

class RVImageListingAdapter(
    private val images: List<PhotoRes>,
    private val onTap: OnAdapterClick
) :
    RecyclerView.Adapter<RVImageListingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVImageListingViewHolder {
        val binding =
            RowImageGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RVImageListingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RVImageListingViewHolder, position: Int) {
        Picasso.get().load(images[position].thumbnailUrl).into(holder.binding.image);
        holder.binding.tvTitle.text = images[position].title
        holder.binding.root.setOnClickListener {
            onTap.onItemClickListener(images[position],position)
        }
    }

    override fun getItemCount(): Int = images.size
}