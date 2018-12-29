package ir.sharif.vamdeh.activity.operations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.helper.openContacts
import ir.sharif.vamdeh.model.CertifiedPerson
import ir.sharif.vamdeh.view.adapter.CertifiedPersonAdapter
import kotlinx.android.synthetic.main.activity_certified.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class CertifiedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certified)

        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = CertifiedPersonAdapter(arrayOf(CertifiedPerson("مهدی حسن زاده", R.mipmap.me),CertifiedPerson("مهدی حسن زاده", R.mipmap.me),CertifiedPerson("مهدی حسن زاده", R.mipmap.me),CertifiedPerson("مهدی حسن زاده", R.mipmap.me),CertifiedPerson("مهدی حسن زاده", R.mipmap.me),CertifiedPerson("مهدی حسن زاده", R.mipmap.me),CertifiedPerson("مهدی حسن زاده", R.mipmap.me)))

        addPerson.onClick { openContacts() }
        backImageView.onClick { onBackPressed() }
    }
}
