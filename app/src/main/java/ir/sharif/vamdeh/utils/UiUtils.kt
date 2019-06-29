package ir.sharif.vamdeh.utils

import android.app.Activity
import ir.sharif.vamdeh.view.edittext.UnoOneDigitEditText

fun Activity.handleInLineEditTextFocus(length: Int, editTexts: Array<UnoOneDigitEditText>) {
    for ((index, editText) in editTexts.withIndex()) {
        editText.addOnTextChangedListener { text ->
            if (index != editTexts.lastIndex && text.length == length) editTexts[index + 1].requestFocus()
            else if (text.length == length) hideKeyboard()
        }
    }
}

fun getInLineEditTexts(editTexts: Array<UnoOneDigitEditText>) = editTexts.fold("") { result, item -> result.plus(item.text.toString()) }

fun convert2PersianDigits(number: String) =
        number.fold("") { result, c -> result.plus(if (c in '0'..'9') ('۰' + c.toInt() - '0').toChar() else c) }