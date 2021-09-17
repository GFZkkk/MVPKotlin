package com.gfz.lab.ext

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.gfz.lab.base.recyclerview.adapter.BaseRecyclerViewHolder
import com.gfz.lab.ui.base.BaseFragment
import com.gfz.lab.utils.ScreenUtil

/**
 * 根据资源id获取颜色
 */
fun Context.getCompatColor(resId: Int) = ContextCompat.getColor(this, resId)
fun BaseFragment.getColor(resId: Int) = context?.getCompatColor(resId)
fun BaseRecyclerViewHolder<*>.getColor(resId: Int) = context.getCompatColor(resId)

/**
 * 根据资源id获取图片
 */
fun Context.getCompatDrawable(resId: Int) = ContextCompat.getDrawable(this, resId)
fun BaseRecyclerViewHolder<*>.getDrawable(resId: Int) = context.getCompatDrawable(resId)

fun Context.getDrawableWithBounds(resId: Int): Drawable? {
    val drawable = getCompatDrawable(resId)
    drawable?.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
    return drawable
}

fun Context.getScreenWidth() = ScreenUtil.getScreenWidth(this)

fun Context.getScreenHeight() = ScreenUtil.getScreenHeight(this)
