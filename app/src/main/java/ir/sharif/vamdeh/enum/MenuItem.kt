package ir.sharif.vamdeh.enum

import android.content.res.Resources
import ir.sharif.vamdeh.ApplicationContext
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.utils.string

/**
 * Created by mahdihs76 on 9/11/18.
 */
enum class MenuItem(val text: String, val icon: Int) {
    INSTALLMENT(R.string.installment_page.string(), R.drawable.installment_page),
    CERTIFIED(R.string.certified.string(), R.drawable.certified),
    TRUSTED(R.string.trusted.string(), R.drawable.trusted),
    APPLY_LOAN(R.string.apply_loan.string(), R.drawable.apply_loan),
    LEND_LOAN(R.string.lend_loan.string(), R.drawable.lend_loan)
}
