package ir.sharif.vamdeh.activity

import android.os.Bundle
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.helper.gotoMainPage
import ir.sharif.vamdeh.view.button.unoSumbitButton
import ir.sharif.vamdeh.view.edittext.unoOneDigitEditText
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class ActivationActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivationActivityUI().setContentView(this)
    }

    fun checkActivationCode(code: String) {
        gotoMainPage()
    }

}

class ActivationActivityUI : AnkoComponent<ActivationActivity> {
    override fun createView(ui: AnkoContext<ActivationActivity>) = with(ui) {

        relativeLayout {
            backgroundResource = R.mipmap.background

            linearLayout {
                addOneDigitEditText()
                addOneDigitEditText()
                addOneDigitEditText()
                addOneDigitEditText()
            }.lparams {
                centerHorizontally()
                topMargin = dip(100)
            }

            unoSumbitButton().lparams {
                width = dip(220)
                height = dip(50)
                alignParentBottom()
                centerHorizontally()
                bottomMargin = dip(80)
            }.onClick { ui.owner.checkActivationCode("") }
        }

    }.view()

    private fun @AnkoViewDslMarker _LinearLayout.addOneDigitEditText() {
        unoOneDigitEditText { lparams(width = dip(50), height = dip(50)) { leftMargin = dip(10) } }
    }
}