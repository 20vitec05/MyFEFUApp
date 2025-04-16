package com.example.MyFEFUApplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class Welcome : AppCompatActivity(), View.OnClickListener {
    lateinit var registrationIntent: Intent
    lateinit var loginIntent: Intent

    lateinit var registrationButton: Button
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.welcome)

        registrationIntent = Intent(this, Registration::class.java)
        loginIntent = Intent(this, Login::class.java)

        registrationButton = findViewById(R.id.registration_button)
        registrationButton.setOnClickListener(this)

        loginButton = findViewById(R.id.login_button)
        loginButton.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.registration_button) {
            startActivity(registrationIntent)
        }
        if (view.id == R.id.login_button) {
            startActivity(loginIntent)
        }
    }
}