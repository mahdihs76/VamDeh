package ir.sharif.vamdeh.helper

import android.content.Context
import org.jetbrains.anko.longToast

/**
 * Created by mahdihs76 on 12/14/18.
 */

fun Context.toastInvalidPhone() = longToast("InvalidPhoneNumber")
fun Context.toastInvalidPassword() = longToast("InvalidPassword")
fun Context.toastLoginFailed()= longToast("LoginFailed")
