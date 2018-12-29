package ir.sharif.vamdeh.helper

import android.app.Activity
import android.content.Intent
import android.provider.ContactsContract

/**
 * Created by mahdihs76 on 12/25/18.
 */
fun Activity.openContacts() = startActivityForResult(Intent(Intent.ACTION_PICK,  ContactsContract.Contacts.CONTENT_URI), 0)