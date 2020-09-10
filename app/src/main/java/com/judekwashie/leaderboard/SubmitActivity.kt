package com.judekwashie.leaderboard

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.judekwashie.leaderboard.api.SubmitApi
import kotlinx.android.synthetic.main.activity_submit.*
import kotlinx.android.synthetic.main.custom_dialog_submit.view.*
import kotlinx.android.synthetic.main.toolbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SubmitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)


        back_arrow.setOnClickListener {
            onBackPressed()
        }
        submit_button.setOnClickListener {
            hideActivityViews()
            showDialog()
        }

    }

    private fun showDialog() {
        val submitDialogView =
            LayoutInflater.from(this).inflate(R.layout.custom_dialog_submit, null)
        val dialogBuilder = AlertDialog.Builder(this, R.style.DialogStyle)
            .setView(submitDialogView)
        val submitDialog = dialogBuilder.show()

        submitDialogView.yes_button.setOnClickListener {
            hideActivityViews()
            postToApi(submitDialog)
        }

        submitDialogView.close_button.setOnClickListener {
            submitDialog.dismiss()
        }
    }

    private fun postToApi(submitDialog: AlertDialog) {
        val firstName = firstNameEditText.text.toString()
        val lastName = lastNameEditText.text.toString()
        val email = emailEditText.text.toString()
        val linkToProject = projectLinkEditText.text.toString()
        val retrofit = RetrofitHelper.getInstance()
        retrofit.create(SubmitApi::class.java)
            .submitWork(email, firstName, lastName, linkToProject)
            .enqueue(object : Callback<ProjectDetails> {
                override fun onFailure(call: Call<ProjectDetails>, t: Throwable) {
                    AlertDialog.Builder(this@SubmitActivity, R.style.DialogStyle)
                        .setView(R.layout.dialog_unsuccessful).show()
                    Toast.makeText(
                        this@SubmitActivity,
                        "something went wrong ${t.message}",
                        Toast.LENGTH_LONG
                    ).show()
                    submitDialog.dismiss()
                }

                override fun onResponse(
                    call: Call<ProjectDetails>,
                    response: Response<ProjectDetails>
                ) {
                    if (!response.isSuccessful) {
                        Toast.makeText(
                            this@SubmitActivity,
                            "something went wrong${response.code()}",
                            Toast.LENGTH_LONG
                        ).show()
                        return
                    }
                    AlertDialog.Builder(this@SubmitActivity, R.style.DialogStyle)
                        .setView(R.layout.dialog_successful).show()
                    submitDialog.dismiss()

                }
            })
    }

    private fun hideActivityViews() {
        firstNameEditText.visibility = View.GONE
        lastNameEditText.visibility = View.GONE
        emailEditText.visibility = View.GONE
        projectLinkEditText.visibility = View.GONE
        submit_button.visibility = View.GONE
    }

    private fun showActivityViews() {
        firstNameEditText.visibility = View.VISIBLE
        lastNameEditText.visibility = View.VISIBLE
        emailEditText.visibility = View.VISIBLE
        projectLinkEditText.visibility = View.VISIBLE
        submit_button.visibility = View.VISIBLE
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            showActivityViews()
        } else {
            hideActivityViews()
        }
    }

    override fun onPause() {
        super.onPause()
        showActivityViews()
    }

}
