package ir.sharif.vamdeh.helper

import android.content.Context
import android.widget.Toast
import es.dmoral.toasty.Toasty
import org.jetbrains.anko.longToast

/**
 * Created by mahdihs76 on 12/14/18.
 */

fun Context.toastInvalidPhone() = longToast("InvalidPhoneNumber")
fun Context.toastInvalidPassword() = longToast("InvalidPassword")
fun Context.toastLoginFailed()= longToast("LoginFailed")

fun Context.toastError(text:String) = Toasty.error(this, text, Toast.LENGTH_SHORT, true).show()

fun Context.toastWarning(text:String) = Toasty.warning(this, text, Toast.LENGTH_SHORT, true).show()

fun Context.toastSuccess(text:String) = Toasty.success(this, text, Toast.LENGTH_SHORT, true).show()
