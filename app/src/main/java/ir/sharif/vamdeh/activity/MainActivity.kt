package ir.sharif.vamdeh.activity

import android.os.Bundle
import android.view.View
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.enum.MenuItem
import ir.sharif.vamdeh.helper.*
import ir.sharif.vamdeh.utils.generateCircularItem
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initCircularMenu()
        profile_image.onClick { startLoansFragment() }
    }

    private fun initCircularMenu() = enumValues<MenuItem>().forEach { circularLayout.addView(generateCircularItem(it)) }

    private fun startLoansFragment() {
        gotoLoanRequest()
    }


}
