package com.akshit.clunochallenge.detail

import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.akshit.clunochallenge.model.Image
import com.squareup.picasso.Picasso

class ImagePagerAdapter(val images: List<Image>) : PagerAdapter() {

    override fun isViewFromObject(view: View, p1: Any): Boolean {
        return view == p1 as ImageView
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(container.context)
        Picasso.get().load(images[position].src).into(imageView)
        (container as ViewPager).addView(imageView, 0)

        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ImageView)
    }

    override fun getCount(): Int = images.size
}