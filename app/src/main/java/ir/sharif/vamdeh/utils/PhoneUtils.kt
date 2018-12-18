package ir.sharif.vamdeh.utils

/**
 * Created by mahdihs76 on 12/14/18.
 */

fun isValidPhone(phone: String) = Regex(IRANIAN_PHONE_REGEX).matches(phone)
