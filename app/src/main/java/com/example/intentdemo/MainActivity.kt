package com.example.intentdemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {

            val user = username.text.toString()
            val pass = password.text.toString()

            if (user.isEmpty() || pass.isEmpty()) {

                Toast.makeText(
                    this,
                    "Please enter username and password",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                // Create explicit Intent
                val intent = Intent(this, SecondActivity::class.java)

                // Pass data to SecondActivity
                intent.putExtra("username", user)
                intent.putExtra("password", pass)

                // Start Second Activity
                startActivity(intent)
            }
        }
    }
}