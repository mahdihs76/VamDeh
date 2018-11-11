package ir.sharif.vamdeh.activity


import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

import com.github.florent37.androidslidr.Slidr

import java.util.ArrayList

import ir.sharif.vamdeh.R

class LoanRequestActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loan_request)
        initializeView()
    }

    private fun initializeView() {
        initializePaymentButtons()
        val seekBarAmountTextView = findViewById<TextView>(R.id.seekBarAmountTextView)
        val slider = findViewById<Slidr>(R.id.loanAmountSlider)
        val maxValue = 1000f
        val minValue = 0f
        val currentValue = 333f
        slider.max = maxValue
        slider.setMin(minValue)
        slider.currentValue = currentValue
        val progress = slider.currentValue.toInt()
        seekBarAmountTextView.text = String.format(getString(R.string.loanAmount), changeNumberToPersian(progress.toString()))
        slider.setListener(object : Slidr.Listener {
            override fun valueChanged(slidr: Slidr, currentValue: Float) {
                val value = currentValue.toInt()
                seekBarAmountTextView.text = String.format(getString(R.string.loanAmount), changeNumberToPersian(value.toString()))
            }

            override fun bubbleClicked(slidr: Slidr) {

            }
        })
    }

    private fun changeNumberToPersian(number: String): String {
        val result = StringBuilder()
        for (i in 0 until number.length) {
            val c = number[i]
            if (c <= '9' && c >= '0') {
                result.append(('۰' + c.toInt() - '0').toChar())
            } else
                result.append(c)
        }
        return result.toString()
    }

    private fun initializePaymentButtons() {
        val buttons = ArrayList<Button>()
        val _12monthsPaymentButton = findViewById<Button>(R.id._12monthsPaymentButton)
        val _6monthsPaymentButton = findViewById<Button>(R.id._6monthsPaymentButton)
        val _3monthsPaymentButton = findViewById<Button>(R.id._3monthsPaymentButton)
        val otherPaymentButton = findViewById<Button>(R.id.otherPaymentButton)
        buttons.add(_12monthsPaymentButton)
        buttons.add(_6monthsPaymentButton)
        buttons.add(_3monthsPaymentButton)
        buttons.add(otherPaymentButton)
        _12monthsPaymentButton.setOnClickListener { changeButtonBackground(0, buttons) }
        _6monthsPaymentButton.setOnClickListener { changeButtonBackground(1, buttons) }
        _3monthsPaymentButton.setOnClickListener { changeButtonBackground(2, buttons) }
        otherPaymentButton.setOnClickListener { changeButtonBackground(3, buttons) }
    }

    @SuppressLint("ResourceAsColor")
    private fun changeButtonBackground(i: Int, buttons: ArrayList<Button>) {
        for (j in 0..3) {
            val button = buttons[j]
            if (j == i) {
                button.setBackgroundResource(R.drawable.payment_button_selected_background)
                button.setTextColor(R.color.paymentButtonSelectedTextColor)
            } else {
                button.setBackgroundResource(R.drawable.payment_button_background)
                button.setTextColor(Color.WHITE)
            }
        }
    }

}
