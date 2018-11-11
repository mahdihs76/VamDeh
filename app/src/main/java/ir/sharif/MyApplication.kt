package ir.sharif

import android.app.Application
import ir.sharif.vamdeh.ApplicationContext
/**
 *
 * Created by mahdihs76 on 9/11/18.
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ApplicationContext.initialize(this)
    }
}