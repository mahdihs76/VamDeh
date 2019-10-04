package ir.sharif.vamdeh.activity.operations


import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.activity.base.BaseActivity
import ir.sharif.vamdeh.activity.base.BaseActivityJobSupport
import ir.sharif.vamdeh.helper.*
import kotlinx.android.synthetic.main.activity_loan_request.*
import kotlinx.android.synthetic.main.amount_slider_layout.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.tankery.lib.circularseekbar.CircularSeekBar
import org.jetbrains.anko.textColor

class LoanRequestActivity : BaseActivity(), CircularSeekBar.OnCircularSeekBarChangeListener {

    private lateinit var buttons: Array<Button>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loan_request)
        initUi()
        seekBar.setOnSeekBarChangeListener(this)
        backImageView.setOnClickListener { onBackPressed() }

        requestLoanButton.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                spinKit.visibility = View.VISIBLE
                requestLoanButton.visibility = View.INVISIBLE
                callWebservice {
                    getServices().createDirectLoan(phoneNumber.text.toString(),
                            amountTextView.text.toString().toInt(),
                            getTimeToReturnMoney(), "empty")
                }?.run {
                    spinKit.visibility = View.INVISIBLE
                    requestLoanButton.visibility = View.VISIBLE
                    toastSuccess("وام مستقیم شما با موفقیت ثبت شد")
                    Handler().postDelayed(::onBackPressed, 1000)
                }
            }
        }
    }

    override fun onProgressChanged(circularSeekBar: CircularSeekBar?, progress: Float, fromUser: Boolean) {
        amountTextView.text = circularSeekBar?.progress!!.toInt().toString()
        updateMonthlyAmount(getTimeToReturnMoney())
    }

    private fun getTimeToReturnMoney() =
            buttons.find { button -> if (button.tag == null) false else button.tag as Boolean }?.toNumber()!!

    override fun onStartTrackingTouch(seekBar: CircularSeekBar?) {}

    override fun onStopTrackingTouch(seekBar: CircularSeekBar?) {}

    private fun initUi() {
        buttons = arrayOf(oneMonth, threeMonth, sixMonth, twelveMonth)

        for ((index, button) in buttons.withIndex()) {
            button.setOnClickListener {
                changeButtonBackground(index, buttons)
                updateMonthlyAmount(button.toNumber())
            }
        }

        changeButtonBackground(0, buttons)
        updateMonthlyAmount(buttons[0].toNumber())

    }

    private fun updateMonthlyAmount(number: Int) {
        val monthlyAmount = amountTextView.text.toString().toInt() / number
        monthlyAmountTextView.text = String.format(getString(R.string.toman_format), monthlyAmount)
    }

    private fun Button.toNumber() = when (id) {
        R.id.twelveMonth -> 12
        R.id.sixMonth -> 6
        R.id.threeMonth -> 3
        R.id.oneMonth -> 1
        else -> 0
    }

    private fun changeButtonBackground(i: Int, buttons: Array<Button>) {
        for ((index, button) in buttons.withIndex()) {
            if (index == i) {
                button.setBackgroundResource(R.drawable.payment_button_selected_background)
                button.tag = true
                button.textColor = R.color.lightGreen
            } else {
                button.setBackgroundResource(R.drawable.payment_button_background)
                button.tag = false
                button.textColor = Color.WHITE
            }
        }
    }

}
