package com.csis365.assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    private lateinit var userName: EditText
    private lateinit var password: EditText
    private lateinit var showHideBtn: Button
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        userName = findViewById(R.id.userName)
        password = findViewById(R.id.password)
        showHideBtn = findViewById(R.id.showHideBtn)
        btnLogin = findViewById(R.id.btnLogin)

        showHideBtn.setOnClickListener {
            if(showHideBtn.text.toString().equals("Show")){
                password.transformationMethod = HideReturnsTransformationMethod.getInstance()
                showHideBtn.text = "Hide"
            } else{
                password.transformationMethod = PasswordTransformationMethod.getInstance()
                showHideBtn.text = "Show"
            }
        }

        btnLogin.setOnClickListener {
            Log.d("Login", "Button has been pressed.")
            Log.i("Login", "UserName is " + userName.text.toString())
            Log.v("Login", "Password is ${password.text}")

            if (password.text.toString() == "1111"
                && userName.length() > 4) {

                val intentListFruit = Intent(this, ListFruit::class.java)
                intentListFruit.putExtra("value", userName.text.toString())
                startActivity(intentListFruit)
            }
        }
    }
}