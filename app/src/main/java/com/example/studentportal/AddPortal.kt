package com.example.studentportal

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_add_portal.*
import kotlinx.android.synthetic.main.content_add_portal.*

const val EXTRA_REMINDER = "EXTRA_REMINDER"

class AddPortal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_portal)
        setSupportActionBar(toolbar)

        initViews()

    }

    private fun initViews() {
        fab.setOnClickListener { onSaveClick() }
    }

    private fun onSaveClick() {
        if (etAddPortalTitle.text.toString().isNotBlank() && etAddPortalUrl.text.toString().isNotBlank()) {
            val reminder = Portal(etAddPortalTitle.text.toString(), etAddPortalUrl.text.toString())
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_REMINDER, reminder)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            if (!etAddPortalTitle.text.toString().isNotBlank()) {
                Toast.makeText(this,"Title cannot be empty"
                    , Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"Url cannot be empty"
                    , Toast.LENGTH_SHORT).show()
            }

        }
    }

}
