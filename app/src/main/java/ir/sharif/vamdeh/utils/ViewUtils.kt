package ir.sharif.vamdeh.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.enum.MenuItem
import kotlinx.android.synthetic.main.circle_menu_item.view.*

/**
 * Created by mahdihs76 on 9/11/18.
 */
fun Context.generateCircularItem(item: MenuItem): View? {
    val view = LayoutInflater.from(this).inflate(R.layout.circle_menu_item, null)
    view.image.setImageResource(item.icon)
    view.title.text = item.text
    return view
}