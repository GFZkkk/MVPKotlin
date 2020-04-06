package com.gfz.mvp.model.bean

/**
 * created by gfz on 2020/4/6
 **/
data class BaseCalendarBean(val date: IntArray) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BaseCalendarBean

        if (!date.contentEquals(other.date)) return false

        return true
    }

    override fun hashCode(): Int {
        return date.contentHashCode()
    }
}