package ir.sharif.vamdeh

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("StaticFieldLeak")
object ApplicationContext {

    lateinit var context: Context

    fun initialize(context: Context) {
        this.context = context
    }

}