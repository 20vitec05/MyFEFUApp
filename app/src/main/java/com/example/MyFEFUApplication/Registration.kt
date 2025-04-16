package com.example.MyFEFUApplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class Registration : AppCompatActivity(), View.OnClickListener {
    lateinit var backButton: ImageButton
    lateinit var RegistrationButton: Button
    lateinit var emptyStateIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.registration)

        findViewById<TextView>(R.id.title).text = getString(R.string.registration_page)

        backButton = findViewById(R.id.back_button)
        backButton.setOnClickListener(this)

        RegistrationButton = findViewById(R.id.registration_button)
        RegistrationButton.setOnClickListener(this)

        emptyStateIntent = Intent(this, EmptyState::class.java)

    }


    override fun onClick(view: View) {
        if (view.id == R.id.back_button) {
            finish()
        }
        if (view.id == R.id.registration_button) {
            startActivity(emptyStateIntent)
            finish()
        }
    }
}