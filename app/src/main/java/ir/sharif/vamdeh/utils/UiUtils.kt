package ir.sharif.vamdeh.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import ir.sharif.vamdeh.view.edittext.UnoOneDigitEditText

/**
 * Created by mahdihs76 on 12/14/18.
 */

class UnoTextWatcher(private val length: Int, private val nextEditText: EditText) : TextWatcher {
    override fun afterTextChanged(s: Editable?) {}
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (s?.length == length) nextEditText.requestFocus()
    }
}

fun handleInLineEditTextFocus(length: Int, editTexts: Array<UnoOneDigitEditText>) {
    for ((index, editText) in editTexts.withIndex()) {
        if (index != editTexts.lastIndex) editText.addTextChangedListener(UnoTextWatcher(length, editTexts[index + 1]))
    }
}

fun getInLineEditTexts(editTexts: Array<UnoOneDigitEditText>) = editTexts.fold("") { result, item -> result.plus(item.text.toString()) }

fun convert2PersianDigits(number: String) =
        number.fold("") { result, c -> result.plus(if (c in '0'..'9') ('۰' + c.toInt() - '0').toChar() else c) }