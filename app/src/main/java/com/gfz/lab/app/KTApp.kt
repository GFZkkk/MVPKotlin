package com.gfz.lab.app

import com.gfz.common.KTCatchException
import com.gfz.common.base.BaseApplication
import com.gfz.common.utils.SpUtil
import com.gfz.common.utils.TopLog


/**
 * created by gaofengze on 2020-01-19
 */

class KTApp : BaseApplication() {

    companion object {
        const val test = true
    }

    override fun init() {
        TopLog.init(test)
        KTCatchException.init(this)
        SpUtil.init(appContext)
//        FlutterInjector.instance().flutterLoader().startInitialization(this)
//        FlutterBoost.instance().setup(this, MyFlutterBoostDelegate()) { engine: FlutterEngine? -> }
    }
}

