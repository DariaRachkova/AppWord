package com.daria.appword

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(banner: Banner) {
        val bannerImageView: ImageView = itemView.findViewById(R.id.banner_image_view)

        bannerImageView.setImageDrawable(itemView.context.getDrawable(banner.imageRes))
    }
}