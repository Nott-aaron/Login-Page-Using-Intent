package com.example.intentdemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Receive data from MainActivity
        val username = intent.getStringExtra("username")
        val password = intent.getStringExtra("password")

        val usernameText = findViewById<TextView>(R.id.usernameText)
        val passwordText = findViewById<TextView>(R.id.passwordText)
        val logoutButton = findViewById<Button>(R.id.logoutButton)

        // Display received details
        usernameText.text = "Username: $username"
        passwordText.text = "Password: $password"

        // Logout button
        logoutButton.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)

            // Remove the current Activity from the stack
            intent.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TOP or
                        Intent.FLAG_ACTIVITY_SINGLE_TOP

            startActivity(intent)

            finish()
        }
    }
}