package ir.sharif.vamdeh.helper

import android.app.Activity
import android.content.Context
import android.view.ViewGroup
import com.irozon.sneaker.Sneaker
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.utils.getAppTypeface
import org.jetbrains.anko.longToast

/**
 * Created by mahdihs76 on 12/14/18.
 */

fun Context.toastInvalidPhone() = longToast("InvalidPhoneNumber")
fun Context.toastInvalidPassword() = longToast("InvalidPassword")
fun Context.toastLoginFailed()= longToast("LoginFailed")

fun Activity.toastError(text:String) = Sneaker.with(this)
        .setTitle(getString(R.string.error))
        .setHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
        .setMessage(text)
        .setTypeface(getAppTypeface()).sneakWarning()
