package com.gfz.lab.ui.base

import androidx.viewbinding.ViewBinding

/**
 * Created by xueya on 2022/1/27
 */
abstract class BaseVMActivity<VM: BaseViewModel, VB: ViewBinding> : BaseVBActivity<VB>(){
    abstract val viewModel: VM
}