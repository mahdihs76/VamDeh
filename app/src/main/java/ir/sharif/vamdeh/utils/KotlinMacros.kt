package ir.sharif.vamdeh.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import ir.sharif.vamdeh.ApplicationContext

/**
 * Created by mahdihs76 on 9/11/18.
 */

fun Int.string() = ApplicationContext.context.getString(this)

fun EditText.addOnTextChangedListener(function: (text: CharSequence) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {}

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            if (p0.isNullOrEmpty()) return
            function(p0)
        }
    })
}
