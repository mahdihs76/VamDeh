package ir.sharif.vamdeh.view.button

import android.content.Context
import android.util.AttributeSet
import android.view.ViewManager
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.view.edittext.UnoOneDigitEditText
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.dip

/**
 * Created by mahdihs76 on 9/10/18.
 */
class UnoSumbitButton : UnoButton {

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    init {
        text = context.getString(R.string.submit)
    }
}