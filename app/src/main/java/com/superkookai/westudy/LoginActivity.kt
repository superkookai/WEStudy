package com.superkookai.westudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase

class LoginActivity : AppCompatActivity() {

    lateinit var btnForget: Button
    lateinit var btnLogin: Button
    lateinit var btnRegister: Button
    lateinit var inputEmail: EditText
    lateinit var inputPassword: EditText

    lateinit var email: String
    lateinit var password: String
    private lateinit var mAuth: FirebaseAuth
    lateinit var firebaseDatabase: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin = findViewById<Button>(R.id.btnLogin)
        btnForget = findViewById<Button>(R.id.btnForget)
        btnRegister = findViewById<Button>(R.id.btnRegister)
        inputEmail = findViewById<EditText>(R.id.inputEmail)
        inputPassword = findViewById<EditText>(R.id.inputPassword)

        mAuth = FirebaseAuth.getInstance()
        firebaseDatabase = FirebaseDatabase.getInstance()

        btnLogin.setOnClickListener {
            loginEmail()
        }

        btnRegister.setOnClickListener {
            val gotoCreate = Intent(this, SignupActivity::class.java)
            startActivity(gotoCreate)
        }

        btnForget.setOnClickListener {
            val gotoForget = Intent(this,ForgetPasswordActivity::class.java)
            startActivity(gotoForget)
        }
    }

    private fun loginEmail() {
        email = inputEmail.text.toString()
        password = inputPassword.text.toString()

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) { task -> if(task.isSuccessful){
            Log.d("MyApp", "Login Success!")
            val user = mAuth.currentUser
            updateUI(user)
        } else{
            Log.w("MyApp", "Failure Process!", task.exception)
            Toast.makeText(this@LoginActivity, "Authentication Failed.", Toast.LENGTH_SHORT).show()
            updateUI(null)
        }
        }
    }

    override fun onStart() {
        super.onStart()

        val currentUser = mAuth.currentUser
        updateUI(currentUser)

    }

    private fun updateUI(user: FirebaseUser?) {
        if(user != null){
            val uid = user.uid
            val email = user.email

            val intentSession = Intent(this, MainActivity::class.java)
            startActivity(intentSession)
        }
    }
}