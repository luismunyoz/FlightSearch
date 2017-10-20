package com.luismunyoz.flightsearch.ui.util

import android.databinding.BindingAdapter
import android.databinding.ViewDataBinding
import android.graphics.drawable.Drawable
import android.support.graphics.drawable.VectorDrawableCompat
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.luismunyoz.flightsearch.BR


/**
 * Created by llco on 12/09/2017.
 */
class DataBindingViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Any, listener: Any){
        binding.setVariable(BR.item, item)
        //binding.setVariable(BR.listener, listener)
        binding.executePendingBindings()
    }

    companion object {

        @JvmStatic
        @BindingAdapter("app:srcCompat")
        fun setImage(imageView: ImageView, resourceId: Int){
            val drawable : Drawable? = VectorDrawableCompat.create(imageView.resources, resourceId, imageView.context.theme)
            imageView.setImageDrawable(drawable)
        }

        @JvmStatic
        @BindingAdapter("app:srcCompat")
        fun setImage(imageView: ImageView, drawable: Drawable){
            imageView.setImageDrawable(drawable)
        }

        @JvmStatic
        @BindingAdapter("app:imageUrl")
        fun loadImage(imageView: ImageView, url: String){
            Glide.with(imageView.context).load(url).into(imageView)
        }
    }
}