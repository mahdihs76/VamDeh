package ir.sharif.vamdeh.activity.operations


import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.activity.base.BaseActivityJobSupport
import ir.sharif.vamdeh.helper.getMyLoanExtras
import ir.sharif.vamdeh.helper.gotoMainPage
import ir.sharif.vamdeh.helper.scheduleJob
import ir.sharif.vamdeh.helper.toastSuccess
import ir.sharif.vamdeh.task.events.CreateMyLoanEvent
import ir.sharif.vamdeh.task.jobs.CreateMyLoanJob
import ir.sharif.vamdeh.utils.string
import kotlinx.android.synthetic.main.activity_loan_request.*
import kotlinx.android.synthetic.main.amount_slider_layout.*
import me.tankery.lib.circularseekbar.CircularSeekBar
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.textColor

class LoanRequestActivity : BaseActivityJobSupport(), CircularSeekBar.OnCircularSeekBarChangeListener {

    private lateinit var buttons: Array<Button>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loan_request)
        initUi()
        seekBar.setOnSeekBarChangeListener(this)
        backImageView.setOnClickListener { onBackPressed() }

        requestLoanButton.setOnClickListener {
            createMyLoan(amountTextView.text.toString().toInt(),
                    getTimeToReturnMoney(),
                    descriptionEditText.text.toString())
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


    private fun createMyLoan(amount: Int, timeToReturnMoney: Int, status: String) =
            scheduleJob(CreateMyLoanJob.TAG, getMyLoanExtras(amount, timeToReturnMoney, status))

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: CreateMyLoanEvent) = toastSuccess(getString(R.string.create_loan_request_success)).also {
        Handler().postDelayed({ gotoMainPage() }, 2000)
    }

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
