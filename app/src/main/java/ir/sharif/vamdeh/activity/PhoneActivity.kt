package ir.sharif.vamdeh.activity

import android.os.Bundle
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.helper.gotoActivation
import kotlinx.android.synthetic.main.activity_phone.*

class PhoneActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)

        submit.setOnClickListener { login(phone_number.text.toString()) }
    }

    private fun login(phone: String) = gotoActivation()

}