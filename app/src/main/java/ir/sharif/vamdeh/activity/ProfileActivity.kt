package ir.sharif.vamdeh.activity


import android.os.Bundle
import android.os.Handler
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
import ir.sharif.vamdeh.activity.base.BaseActivityJobSupport
import ir.sharif.vamdeh.helper.*
import ir.sharif.vamdeh.task.events.GetMyScoresEvent
import ir.sharif.vamdeh.task.jobs.CreateProfileErrorEvent
import ir.sharif.vamdeh.task.jobs.CreateProfileEvent
import ir.sharif.vamdeh.task.jobs.CreateProfileJob
import kotlinx.android.synthetic.main.activity_profile.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class ProfileActivity : BaseActivityJobSupport() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initializeViews()
        profileImageView.setOnClickListener {}
        profileSubmitButton.setOnClickListener {
            scheduleJob(CreateProfileJob.TAG, getCreateProfileExtras(
                    fullName.text.toString(),
                    nationalCode.text.toString(),
                    accountNo.text.toString(),
                    cardNo.text.toString(),
                    shebaNo.text.toString()
            ))
        }
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
        initThisEditText(fullName, nameHintTextView)
        initThisEditText(nationalCode, phoneNumberHintTextView)
        initThisEditText(accountNo, creditNumberHintTextView)
        initThisEditText(cardNo, emailHintTextView)
        initThisEditText(shebaNo, addressHintTextView)
    }

    private fun initThisEditText(editText: EditText, hintTextView: TextView) {
        hintTextView.bringToFront()
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.isNotEmpty()) {
                    hintTextView.visibility = View.VISIBLE
                } else {
                    hintTextView.visibility = View.GONE
                }
            }

            override fun afterTextChanged(editable: Editable) {

            }
        })
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: CreateProfileEvent) = toastSuccess("پروفایل شما با موفقیت ایجاد شد").also {
        Handler().postDelayed({ gotoMainPage() }, 2000)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: CreateProfileErrorEvent) = toastError(event.error)
}
