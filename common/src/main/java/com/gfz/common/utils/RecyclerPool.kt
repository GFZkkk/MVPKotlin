package com.gfz.common.utils

import android.util.SparseArray

/**
 *
 * created by xueya on 2022/3/28
 */
class RecyclerPool(initialCapacity: Int = 10) {
    val pool = SparseArray<Any>(initialCapacity)
    var showLog = false
    var total = 0
    var success = 0
    inline fun <reified T> get(key: Int, create: () -> T): T {
        val data = pool[key]
        total++
        return if (data is T) {
            success++
            log()
            data
        } else {
            log()
            create.invoke().apply {
                pool.append(key, this)
            }
        }
    }

    fun log() {
        if (!showLog) return
        TopLog.e("success:$success | total:$total | ${1f * success / total}")
    }
}