package ir.sharif.vamdeh.helper

import android.app.Activity
import android.content.Context
import android.content.Intent
import ir.sharif.vamdeh.activity.*
import org.jetbrains.anko.makeCall
import org.jetbrains.anko.startActivity

/**
 * Created by mahdihs76 on 9/10/18.
 */

const val KEY_PHONE = "key_phone"

fun Context.gotoActivation() = startActivity<ActivationActivity>()
fun Context.gotoActivation(phone:String) = startActivity<ActivationActivity>(KEY_PHONE to phone)
fun Context.gotoMainPage() = startActivity<MainActivity>()
fun Context.gotoLoans() = startActivity<LoansActivity>()
fun Context.gotoProfile() = startActivity<ProfileActivity>()
fun Context.gotoLending() = startActivity<LendingActivity>()
fun Context.gotoLoanRequest() = startActivity<LoanRequestActivity>()

