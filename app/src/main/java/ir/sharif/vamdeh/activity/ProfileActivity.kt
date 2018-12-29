package ir.sharif.vamdeh.activity


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ir.sharif.vamdeh.ApplicationContext
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.activity.base.BaseActivity
import kotlinx.android.synthetic.main.activity_profile.*
import org.jetbrains.anko.sdk27.coroutines.onClick


class ProfileActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initializeViews()

        profileSubmitButton.onClick {  }
    }

    private fun initializeViews() {
        initializeProfileImage()
        initializeEditTexts()
    }

    private fun initializeProfileImage() {
        val profileImageView = findViewById<ImageView>(R.id.profileImageView)
        Glide.with(ApplicationContext.context)
                .load(R.mipmap.me)
                .apply(RequestOptions().circleCrop())
                .into(profileImageView)
    }

    private fun initializeEditTexts() {
        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val nameHintTextView = findViewById<TextView>(R.id.nameHintTextView)
        initThisEditText(nameEditText, nameHintTextView)
        val phoneNumberEditText = findViewById<EditText>(R.id.phoneNumberEditText)
        val phoneNumberHintTextView = findViewById<TextView>(R.id.phoneNumberHintTextView)
        initThisEditText(phoneNumberEditText, phoneNumberHintTextView)
        val creditNumberEditText = findViewById<EditText>(R.id.creditNumberEditText)
        val creditNumberHintTextView = findViewById<TextView>(R.id.creditNumberHintTextView)
        initThisEditText(creditNumberEditText, creditNumberHintTextView)
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val emailHintTextView = findViewById<TextView>(R.id.emailHintTextView)
        initThisEditText(emailEditText, emailHintTextView)
        val addressEditText = findViewById<EditText>(R.id.addressEditText)
        val addressHintTextView = findViewById<TextView>(R.id.addressHintTextView)
        initThisEditText(addressEditText, addressHintTextView)

    }

    private fun initThisEditText(editText: EditText, hintTextView: TextView) {
        hintTextView.bringToFront()
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.length > 0) {
                    hintTextView.visibility = View.VISIBLE
                } else {
                    hintTextView.visibility = View.GONE
                }
            }

            override fun afterTextChanged(editable: Editable) {

            }
        })
    }

}
