package ir.sharif.vamdeh.utils

/**
 * Created by mahdihs76 on 12/14/18.
 */

const val IRANIAN_PRE_CODE = "98"

fun isValidPhone(phone: String) = Regex(IRANIAN_PHONE_REGEX).matches(phone)
fun normalizePhone(phone: String) =
        if (isValidPhone(phone).not() || phone.startsWith(IRANIAN_PRE_CODE)) phone
        else IRANIAN_PRE_CODE.plus(phone.trimStart('0'))