package ir.sharif.vamdeh.activity

import org.greenrobot.eventbus.EventBus

/**
 * Created by mahdihs76 on 11/22/18.
 */
open class BaseActivityJobSupport : BaseActivity() {

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this);
    }

    public override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }
}