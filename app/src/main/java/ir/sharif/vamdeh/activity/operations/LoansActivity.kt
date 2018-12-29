package ir.sharif.vamdeh.activity.operations


import android.os.Bundle

import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.activity.base.BaseActivity
import kotlinx.android.synthetic.main.activity_loans.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class LoansActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loans)
        backImageView.onClick { onBackPressed() }
    }

}
