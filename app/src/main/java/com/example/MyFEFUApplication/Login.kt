package com.example.MyFEFUApplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class Login : AppCompatActivity(), View.OnClickListener {
    lateinit var backButton: ImageButton
    lateinit var loginButton: Button
    lateinit var emptyStateIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login)

        findViewById<TextView>(R.id.title).text = getString(R.string.login_page)

        backButton = findViewById(R.id.back_button)
        backButton.setOnClickListener(this)

        loginButton = findViewById(R.id.login_button)
        loginButton.setOnClickListener(this)

        emptyStateIntent = Intent(this, EmptyState::class.java)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.back_button) {
            finish()
        }
        if (view.id == R.id.login_button) {
            startActivity(emptyStateIntent)
            finish()

        }
    }
}