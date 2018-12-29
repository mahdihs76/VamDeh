package ir.sharif.vamdeh.view.button

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import androidx.core.content.ContextCompat
import android.util.AttributeSet
import android.widget.Button
import ir.sharif.vamdeh.R

/**
 * Created by mahdihs76 on 9/10/18.
 */
open class UnoButton : Button {
    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    init {
        background = ContextCompat.getDrawable(context, R.drawable.button_bg)
        textSize = 22F
        setTextColor(Color.WHITE)
        setTypeface(typeface, Typeface.BOLD)
    }
}