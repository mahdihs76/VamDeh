package ir.sharif.vamdeh.activity.operations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.model.TrustedPerson
import ir.sharif.vamdeh.view.adapter.TrustedPersonAdapter
import kotlinx.android.synthetic.main.activity_trusted.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class TrustedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trusted)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TrustedPersonAdapter(arrayOf(TrustedPerson("مهدی حسن زاده", "09150773830", "97/08/09")))

        backImageView.onClick { onBackPressed() }
    }
}
