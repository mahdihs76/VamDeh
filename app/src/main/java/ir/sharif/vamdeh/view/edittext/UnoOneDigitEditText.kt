package ir.sharif.vamdeh.view.edittext

import android.content.Context
import android.graphics.Typeface
import android.graphics.Typeface.DEFAULT_BOLD
import android.text.InputFilter
import android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.Gravity.CENTER
import android.view.ViewManager
import android.widget.EditText
import ir.sharif.vamdeh.R
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.backgroundResource
import org.jetbrains.anko.custom.ankoView

/**
 * Created by mahdihs76 on 9/10/18.
 */

class UnoOneDigitEditText(context: Context, attributeSet: AttributeSet) : EditText(context, attributeSet) {

    init {
        backgroundResource = R.drawable.digit_edit_text_bg
        gravity = CENTER
        textSize = 22F
        inputType = TYPE_NUMBER_FLAG_DECIMAL
        filters = arrayOf(InputFilter.LengthFilter(1))
    }

}