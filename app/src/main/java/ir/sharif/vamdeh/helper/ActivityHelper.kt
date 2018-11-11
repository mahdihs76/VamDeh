package ir.sharif.vamdeh.helper

import android.app.Activity
import android.content.Context
import android.content.Intent
import ir.sharif.vamdeh.activity.*

/**
 * Created by mahdihs76 on 9/10/18.
 */
fun Context.gotoActivation() = gotoWithoutAnimation(ActivationActivity::class.java)
fun Context.gotoMainPage() = gotoWithoutAnimation(MainActivity::class.java)
fun Context.gotoLoans() = gotoWithoutAnimation(LoansActivity::class.java)
fun Context.gotoProfile() = gotoWithoutAnimation(ProfileActivity::class.java)
fun Context.gotoLending() = gotoWithoutAnimation(LendingActivity::class.java)
fun Context.gotoLoanRequest() = gotoWithoutAnimation(LoanRequestActivity::class.java)
fun Context.gotoWithoutAnimation(clazz: Class<*>) = startActivity(Intent(this, clazz))