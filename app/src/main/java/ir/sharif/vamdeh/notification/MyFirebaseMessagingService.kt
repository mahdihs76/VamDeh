package ir.sharif.vamdeh.notification

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)
        Log.d("TAG", "firebase message: $p0 - ${p0.data}")

        // type:1 - trusted_info: User Model
    }
}