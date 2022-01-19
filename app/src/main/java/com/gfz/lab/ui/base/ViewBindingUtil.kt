package com.gfz.lab.ui.base

import androidx.appcompat.app.AppCompatActivity
import android.app.Dialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.gfz.lab.app.KTApp

/**
 *
 * created by gaofengze on 2021/1/27
 */

inline fun <reified VB : ViewBinding> AppCompatActivity.viewBind() = lazy {
    inflateBinding<VB>(layoutInflater).apply {
        setContentView(root)
    }
}

inline fun <reified VB : ViewBinding> Dialog.viewBind() = lazy {
    inflateBinding<VB>(layoutInflater).apply { setContentView(root) }
}

inline fun <reified VB : ViewBinding> viewBind(parent: ViewGroup): VB {
    val method = VB::class.java.getMethod(
        "inflate",
        LayoutInflater::class.java,
        ViewGroup::class.java,
        Boolean::class.java
    )
    return method.invoke(null, LayoutInflater.from(parent.context), parent, false) as VB
}

inline fun <reified VB : ViewBinding> viewBind(): VB {
    val method = VB::class.java.getMethod("inflate", LayoutInflater::class.java)
    return method.invoke(null, LayoutInflater.from(KTApp.appContext)) as VB
}

@Suppress("UNCHECKED_CAST")
inline fun <reified VB : ViewBinding> inflateBinding(layoutInflater: LayoutInflater) =
    VB::class.java.getMethod("inflate", LayoutInflater::class.java)
        .invoke(null, layoutInflater) as VB