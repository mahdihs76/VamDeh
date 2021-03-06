package ir.sharif.vamdeh.helper

import com.evernote.android.job.JobRequest
import com.evernote.android.job.util.support.PersistableBundleCompat
import ir.sharif.vamdeh.task.JobConstants

/**
 * Created by mahdihs76 on 12/16/18.
 */

fun scheduleJob(tag: String) = JobRequest.Builder(tag)
        .startNow()
        .build()
        .schedule()

fun scheduleJob(tag: String, extras: PersistableBundleCompat) = JobRequest.Builder(tag)
        .addExtras(extras)
        .startNow()
        .build()
        .schedule()

// need refactor

fun getPhoneExtras(phone: String) = PersistableBundleCompat().apply { putString(JobConstants.PHONE_NUMBER, phone) }
fun getPasswordExtras(password: String) = PersistableBundleCompat().apply { putString(JobConstants.PASSWORD, password) }
fun getRegistrationExtras(code: String, password: String) = PersistableBundleCompat().apply {
    putString(JobConstants.VERIFICATION_CODE, code)
    putString(JobConstants.PASSWORD, password)
}
fun getMyLoanExtras(amount: Int, timeToReturnMoney: Int, status: String) = PersistableBundleCompat().apply {
    putInt(JobConstants.AMOUNT, amount)
    putInt(JobConstants.TIME_TO_RETURN_MONEY, timeToReturnMoney)
    putString(JobConstants.STATUS, status)
}
fun getPhoneAndCodeExtras(phone: String, code: String) = PersistableBundleCompat().apply {
    putString(JobConstants.PHONE_NUMBER, phone)
    putString(JobConstants.VERIFICATION_CODE, code)
}

fun getTrustRequestExtras(phone: String, trustValue: Int) = PersistableBundleCompat().apply {
    putString(JobConstants.PHONE_NUMBER, phone)
    putInt(JobConstants.TRUST_VALUE, trustValue)
}

fun getCreateProfileExtras(fullName: String, nationalCode: String, accountNo: String, cardNo: String, shebaNo: String) = PersistableBundleCompat().apply {
    putString(JobConstants.FULL_NAME, fullName)
    putString(JobConstants.NATIONAL_CODE, nationalCode)
    putString(JobConstants.ACCOUNT_NO, accountNo)
    putString(JobConstants.CARD_NO, cardNo)
    putString(JobConstants.SHEBA_NO, shebaNo)
}
