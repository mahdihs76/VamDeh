package ir.sharif.vamdeh.utils

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.enum.MenuItem
import ir.sharif.vamdeh.helper.gotoLending
import ir.sharif.vamdeh.helper.gotoLoanRequest
import ir.sharif.vamdeh.helper.gotoLoans
import ir.sharif.vamdeh.helper.gotoMainPage
import kotlinx.android.synthetic.main.circle_menu_item.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

/**
 * Created by mahdihs76 on 9/11/18.
 */
fun Context.generateCircularItem(activity: Activity, item: MenuItem): View? {
    val view = LayoutInflater.from(this).inflate(R.layout.circle_menu_item, null)
    view.image.setImageResource(item.icon)
    view.title.text = item.text
    view.setTapActionToItem(activity, item)
    return view
}

private fun View.setTapActionToItem(activity: Activity, it: MenuItem) {
    when (it) {
        MenuItem.LEND_LOAN -> onClick { activity.gotoLending() }
        MenuItem.APPLY_LOAN -> onClick { activity.gotoLoanRequest() }
        MenuItem.INSTALLMENT -> onClick { activity.gotoLoans() }
        MenuItem.TRUSTED, MenuItem.CERTIFIED -> onClick { activity.gotoMainPage() }
    }
}