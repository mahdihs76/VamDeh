package ir.sharif.vamdeh.activity.operations


import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import com.github.florent37.androidslidr.Slidr
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.activity.base.BaseActivityJobSupport
import ir.sharif.vamdeh.helper.getMyLoanExtras
import ir.sharif.vamdeh.helper.gotoMainPage
import ir.sharif.vamdeh.helper.scheduleJob
import ir.sharif.vamdeh.task.events.CreateMyLoanEvent
import ir.sharif.vamdeh.task.jobs.CreateMyLoanJob
import ir.sharif.vamdeh.utils.convert2PersianDigits
import kotlinx.android.synthetic.main.activity_loan_request.*
import kotlinx.android.synthetic.main.amount_slider_layout.*
import me.tankery.lib.circularseekbar.CircularSeekBar
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.sdk27.coroutines.onClick
import java.util.*

class LoanRequestActivity : BaseActivityJobSupport(), CircularSeekBar.OnCircularSeekBarChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loan_request)
        initUi()
        seekBar.setOnSeekBarChangeListener(this)
        backImageView.onClick { onBackPressed() }

        requestLoanButton.onClick { createMyLoan(amountTextView.text.toString().toInt(), 3 ,descriptionEditText.text.toString()) }
    }
    override fun onProgressChanged(circularSeekBar: CircularSeekBar?, progress: Float, fromUser: Boolean) {
        amountTextView.text = circularSeekBar?.progress!!.toInt().toString()
    }

    override fun onStartTrackingTouch(seekBar: CircularSeekBar?) {}

    override fun onStopTrackingTouch(seekBar: CircularSeekBar?) {}


    private fun createMyLoan(amount: Int, timeToReturnMoney: Int, status: String) =
            scheduleJob(CreateMyLoanJob.TAG, getMyLoanExtras(amount, timeToReturnMoney, status))

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: CreateMyLoanEvent) = gotoMainPage()

    private fun initUi() {
        val buttons = ArrayList<Button>()
        buttons.add(_12monthsPaymentButton)
        buttons.add(_6monthsPaymentButton)
        buttons.add(_3monthsPaymentButton)
        buttons.add(otherPaymentButton)
        _12monthsPaymentButton.onClick { changeButtonBackground(0, buttons) }
        _6monthsPaymentButton.onClick { changeButtonBackground(1, buttons) }
        _3monthsPaymentButton.onClick { changeButtonBackground(2, buttons) }
        otherPaymentButton.onClick { changeButtonBackground(3, buttons) }

//        loanAmountSlider.max = 1000f
//        loanAmountSlider.setMin(0f)
//        loanAmountSlider.currentValue = 333f
//        val progress = loanAmountSlider.currentValue.toInt()
//        seekBarAmountTextView.text = String.format(getString(R.string.loanAmount), convert2PersianDigits(progress.toString()))
//        loanAmountSlider.setListener(object : Slidr.Listener {
//            override fun valueChanged(slidr: Slidr, currentValue: Float) {
//                val value = currentValue.toInt()
//                seekBarAmountTextView.text = String.format(getString(R.string.loanAmount), convert2PersianDigits(value.toString()))
//            }
//
//            override fun bubbleClicked(slidr: Slidr) {
//
//            }
//        })
    }

    @SuppressLint("ResourceAsColor")
    private fun changeButtonBackground(i: Int, buttons: ArrayList<Button>) {
        for (j in 0..3) {
            val button = buttons[j]
            if (j == i) {
                button.setBackgroundResource(R.drawable.payment_button_selected_background)
                button.setTextColor(R.color.lightGreen)
            } else {
                button.setBackgroundResource(R.drawable.payment_button_background)
                button.setTextColor(Color.WHITE)
            }
        }
    }

}
