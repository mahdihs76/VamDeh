package ir.sharif.vamdeh.utils

import android.app.Activity
import ir.sharif.vamdeh.enum.MenuItem
import ir.sharif.vamdeh.helper.*

/**
 * Created by mahdihs76 on 9/11/18.
 */

fun MenuItem?.action(activity: Activity) {
    when (this) {
        MenuItem.LEND_LOAN -> activity.gotoLending()
        MenuItem.APPLY_LOAN ->activity.gotoLoanRequest()
        MenuItem.INSTALLMENT -> activity.gotoLoans()
        MenuItem.TRUSTED-> activity.gotoTrustedPage()
        MenuItem.CERTIFIED -> activity.gotoCertifiedPage()
    }
}