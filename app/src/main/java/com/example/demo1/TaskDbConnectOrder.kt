package com.example.demo1

import android.app.Activity

open class TaskDbConnectOrder(act : Activity) : AsyncTaskOrder() {
    override var activity: Activity? = null
    init {
        activity = act
    }
}