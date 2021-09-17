package com.gfz.lab.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.gfz.lab.R
import com.gfz.lab.base.recyclerview.adapter.BaseCalendarAdapter
import com.gfz.lab.base.recyclerview.adapter.BaseRecyclerViewHolder
import com.gfz.lab.base.recyclerview.adapter.BaseVBRecyclerViewHolder
import com.gfz.lab.databinding.ItemCalendarBinding
import com.gfz.lab.ext.getColor
import com.gfz.lab.model.bean.EventCalendarBean

/**
 * created by gfz on 2020/4/6
 **/
class TestCalendarAdapter(sDate: String, eDate: String):
    BaseCalendarAdapter<EventCalendarBean>(sDate, eDate){

    override fun getCalendarBean(year: Int, month: Int, day: Int): EventCalendarBean {

        val date = intArrayOf(year,month,day)
        val event: CharSequence = if (date.isToday() == MMDateEnum.SAME) "今天是个好日子" else ""

        return EventCalendarBean(event, date)
    }

    override fun onCreateViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewHolder<EventCalendarBean> {
        return ViewHolder(ItemCalendarBinding.inflate(layoutInflater, parent,false))
    }

    inner class ViewHolder(binding: ItemCalendarBinding): BaseVBRecyclerViewHolder<EventCalendarBean, ItemCalendarBinding>(binding){

        override fun onBindViewHolder(data: EventCalendarBean, position: Int) {
            binding.tvDate.text = data.date.getDay().toString()
            binding.tvDate.setTextColor(getColor(
                when(data.date.isToday()){
                    MMDateEnum.SAME -> R.color.col_00b19b
                    MMDateEnum.BEFORE -> R.color.col_94949B
                    MMDateEnum.AFTER -> R.color.col_323640
                }
            ))
        }

    }



}