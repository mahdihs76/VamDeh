package ir.sharif.vamdeh.helper

import android.app.Activity
import ir.sharif.vamdeh.activity.*
import ir.sharif.vamdeh.activity.before_main.ActivationActivity
import ir.sharif.vamdeh.activity.before_main.PhoneActivity
import ir.sharif.vamdeh.activity.before_main.RegisterActivity
import ir.sharif.vamdeh.activity.operations.*
import org.jetbrains.anko.startActivity

/**
 * Created by mahdihs76 on 9/10/18.
 */

const val KEY_PHONE = "key_phone"

fun Activity.gotoActivation() = startActivity<ActivationActivity>()
fun Activity.gotoActivation(phone:String) = startActivity<ActivationActivity>(KEY_PHONE to phone)
fun Activity.gotoMainPage() = startActivity<MainActivity>().apply { finish() }
fun Activity.gotoLoans() = startActivity<LoansActivity>()
fun Activity.gotoProfile() = startActivity<ProfileActivity>()
fun Activity.gotoLending() = startActivity<LendingActivity>()
fun Activity.gotoLoanRequest() = startActivity<LoanRequestActivity>()
fun Activity.gotoRegister() = startActivity<RegisterActivity>()
fun Activity.gotoPhonePage() = startActivity<PhoneActivity>().apply { finish() }
fun Activity.gotoCertifiedPage() = startActivity<CertifiedActivity>()
fun Activity.gotoTrustedPage() = startActivity<TrustedActivity>()


