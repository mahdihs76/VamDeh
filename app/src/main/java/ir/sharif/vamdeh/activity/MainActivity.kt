package ir.sharif.vamdeh.activity

import android.os.Bundle
import android.view.View
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.enum.MenuItem
import ir.sharif.vamdeh.helper.*
import ir.sharif.vamdeh.utils.generateCircularItem
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import java.nio.file.Files.size
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.content.Intent
import java.nio.file.Files.size





class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initCircularMenu()
        profile_image.onClick { gotoProfile() }
    }

    private fun initCircularMenu() = enumValues<MenuItem>().forEach {circularLayout.addView(generateCircularItem(it))}

}
