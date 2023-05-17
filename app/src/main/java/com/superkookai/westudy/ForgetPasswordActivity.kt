package com.superkookai.westudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ForgetPasswordActivity : AppCompatActivity() {

    lateinit var txtEmailForget: EditText
    lateinit var buttonReset: Button
    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        txtEmailForget = findViewById(R.id.emailForget)
        buttonReset = findViewById(R.id.btnReset)

        mAuth = FirebaseAuth.getInstance()

        buttonReset.setOnClickListener {
            val email =txtEmailForget.text.toString()

            if(TextUtils.isEmpty(email)){
                Toast.makeText(applicationContext, "Please Enter your Email!", Toast.LENGTH_SHORT).show()
            }else{
                mAuth.sendPasswordResetEmail(email).addOnCompleteListener {
                        task -> if (task.isSuccessful){
                    Toast.makeText(this@ForgetPasswordActivity, "Please Check your Email", Toast.LENGTH_SHORT).show()
                    val gotoLogin = Intent(this, LoginActivity::class.java)
                    startActivity(gotoLogin)
                }else{
                    Toast.makeText(this@ForgetPasswordActivity, "Fail to send reset password email!", Toast.LENGTH_SHORT).show()
                }
                }
            }

        }
    }
}