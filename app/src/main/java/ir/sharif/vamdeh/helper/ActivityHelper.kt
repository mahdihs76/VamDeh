package ir.sharif.vamdeh.helper

import android.app.Activity
import android.content.Intent
import ir.sharif.vamdeh.activity.*

/**
 * Created by mahdihs76 on 9/10/18.
 */
fun Activity.gotoActivation() = gotoWithoutAnimation(ActivationActivity::class.java)
fun Activity.gotoMainPage() = gotoWithoutAnimation(MainActivity::class.java)
fun Activity.gotoLoans() = gotoWithoutAnimation(LoansActivity::class.java)
fun Activity.gotoProfile() = gotoWithoutAnimation(ProfileActivity::class.java)
fun Activity.gotoLending() = gotoWithoutAnimation(LendingActivity::class.java)
fun Activity.gotoLoanRequest() = gotoWithoutAnimation(LoanRequestActivity::class.java)
fun Activity.gotoWithoutAnimation(clazz: Class<*>) = startActivity(Intent(this, clazz))