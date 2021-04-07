package com.gfz.mvp.utils

import android.os.SystemClock
import android.util.SparseArray

class TimeCell(size: Int = 10) {

    private val timeArray: SparseArray<Long> by lazy {
        SparseArray<Long>(size)
    }

    private var lastTime = 0L

    /**
     * 是否是重复点击
     */
    fun fastClick(tag: Int = 0, dur: Long): Boolean {
        val now = getNowTime()
        val last = getLastTime(tag)
        if (!overTimeInterval(now, last, dur)) {
            return true
        }
        saveLastTime(tag, now)
        return false
    }

    /**
     * 开始计时
     */
    fun start(tag: Int = 0) {
        saveLastTime(tag, getNowTime())
    }

    /**
     * 是否超时
     */
    fun overTime(tag: Int = 0, dur: Long): Boolean {
        return overTimeInterval(getNowTime(), getLastTime(tag), dur)
    }

    fun isNewTag(tag: Int): Boolean {
        return if (tag == 0) {
            lastTime == 0L
        } else {
            timeArray.indexOfKey(tag) < 0
        }
    }

    /**
     * 判断两个时间的间隔是否已经超过条件
     */
    private fun overTimeInterval(now: Long, last: Long, dur: Long): Boolean {
        return now - last > dur
    }

    /**
     * 获取当前时间
     */
    private fun getNowTime(): Long {
        return SystemClock.elapsedRealtime()
    }

    /**
     * 获取上一次记录时间
     */
    private fun getLastTime(tag: Int): Long {
        return if (tag == 0) {
            lastTime
        } else {
            timeArray[tag, 0L]
        }
    }

    /**
     * 保存记录时间
     */
    private fun saveLastTime(tag: Int, now: Long) {
        if (tag == 0) {
            lastTime = now
        } else {
            timeArray.append(tag, now)
        }
    }
}