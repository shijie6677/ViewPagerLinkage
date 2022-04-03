package com.roger.viewpagerlinkage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.roger.viewpagerlinkage.R
import com.roger.viewpagerlinkage.adapter.MyPagerAdapter.ViewHolder
import com.roger.viewpagerlinkage.databinding.ItemMyPagerBinding

class MyPagerAdapter : RecyclerView.Adapter<ViewHolder>() {

    private val array = arrayListOf(
        R.mipmap.dz01,
        R.mipmap.dz02,
        R.mipmap.dz03,
        R.mipmap.dz04,
        R.mipmap.dz05,
        R.mipmap.dz06,
    )

    class ViewHolder private constructor(
        private val binding: ItemMyPagerBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): ViewHolder = ViewHolder(
                ItemMyPagerBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }

        fun bind(@DrawableRes imageSrc : Int) {
            binding.mImage.setImageResource(imageSrc)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(array[position])
    }

    override fun getItemCount() = array.size
}