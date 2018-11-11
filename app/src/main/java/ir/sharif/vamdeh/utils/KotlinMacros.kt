package ir.sharif.vamdeh.utils

import ir.sharif.vamdeh.ApplicationContext

/**
 * Created by mahdihs76 on 9/11/18.
 */

fun Int.string() = ApplicationContext.context.getString(this)
