package ir.sharif.vamdeh.enum

import android.content.res.Resources
import ir.sharif.vamdeh.ApplicationContext
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.utils.string

/**
 * Created by mahdihs76 on 9/11/18.
 */

enum class MenuItem(val index: Int, val text: String, val icon: Int) {
    INSTALLMENT(0, R.string.installment_page.string(), R.drawable.installment_page),
    CERTIFIED(1, R.string.certified.string(), R.drawable.certified),
    TRUSTED(2, R.string.trusted.string(), R.drawable.trusted),
    APPLY_LOAN(3, R.string.apply_loan.string(), R.drawable.apply_loan),
    LEND_LOAN(4, R.string.lend_loan.string(), R.drawable.lend_loan);
}

fun getMenuItem(index: Int) = MenuItem.values().toList().find { item -> item.index == index }

