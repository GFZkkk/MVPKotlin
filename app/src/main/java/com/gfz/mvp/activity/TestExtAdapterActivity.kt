package com.gfz.mvp.activity

import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.gfz.mvp.R
import com.gfz.mvp.adapter.TestExtAdapter
import com.gfz.mvp.base.BaseActivity
import com.gfz.mvp.databinding.ActivityExtlayoutBinding
import com.gfz.mvp.databinding.LayoutHeaderTestBinding
import com.gfz.mvp.utils.inflateBinding
import com.gfz.mvp.utils.viewBind
import java.util.*

/**
 *
 * created by gaofengze on 2021/2/22
 */
class TestExtAdapterActivity : BaseActivity() {

    private val binding: ActivityExtlayoutBinding by viewBind()

    override fun initData() {

        binding.apply {
            val adapter = TestExtAdapter()
            rvList.adapter = adapter
            rvList.layoutManager = LinearLayoutManager(this@TestExtAdapterActivity)
            adapter.refresh(listOf(1,2,3,4))
            val headerBinding: LayoutHeaderTestBinding = viewBind(rvList)
            adapter.headerViewBinding = headerBinding
            headerBinding.tvHeader.text = "测试"

        }
    }
}