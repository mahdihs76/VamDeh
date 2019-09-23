package ir.sharif.vamdeh.helper

import android.content.Intent
import android.content.Context
import android.net.Uri
import android.provider.ContactsContract
import ir.sharif.vamdeh.model.PhoneContact
import android.system.Os.close
import android.net.Uri.withAppendedPath




fun Context.fetchContact(data: Intent): PhoneContact {
    val cursor = contentResolver.query(data.data!!, null, null, null, null)
    var id = ""
    var name = ""
    var phoneNumber = ""
    if (cursor != null && cursor.moveToFirst()) {
        id = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts._ID))
        name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME))
        val hasPhone = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))
        if (hasPhone == "1") {
            val phones = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id, null, null)
            if (phones != null && phones.moveToFirst()) {
                phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                phones.close()
            }

        }

        cursor.close()
    }
    return PhoneContact(id, name, phoneNumber)
}

fun Context.getContactName(phoneNumber: String): String {

    val uri = withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(phoneNumber))

    val projection = arrayOf(ContactsContract.PhoneLookup.DISPLAY_NAME)

    var contactName = ""
    val cursor = contentResolver.query(uri, projection, null, null, null)

    if (cursor != null) {
        if (cursor.moveToFirst()) {
            contactName = cursor.getString(0)
        }
        cursor.close()
    }

    return contactName
}