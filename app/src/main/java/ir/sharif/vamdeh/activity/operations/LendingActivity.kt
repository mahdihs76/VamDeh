package ir.sharif.vamdeh.activity.operations


import android.os.Bundle
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.activity.base.BaseActivity
import kotlinx.android.synthetic.main.activity_lending.*
import kotlinx.android.synthetic.main.amount_slider_layout.*
import me.tankery.lib.circularseekbar.CircularSeekBar
import org.jetbrains.anko.sdk27.coroutines.onClick

class LendingActivity : BaseActivity(), CircularSeekBar.OnCircularSeekBarChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lending)

        seekBar.setOnSeekBarChangeListener(this)
        backImageView.setOnClickListener { onBackPressed() }
    }

    override fun onProgressChanged(circularSeekBar: CircularSeekBar?, progress: Float, fromUser: Boolean) {
        amountTextView.text = circularSeekBar?.progress!!.toInt().toString()
    }

    override fun onStartTrackingTouch(seekBar: CircularSeekBar?) {}

    override fun onStopTrackingTouch(seekBar: CircularSeekBar?) {}
}
