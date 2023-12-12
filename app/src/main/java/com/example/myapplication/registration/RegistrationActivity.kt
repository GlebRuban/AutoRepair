package com.example.myapplication.registration

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class RegistrationActivity : AppCompatActivity() {
    // Добавление объектов в код
    private lateinit var auth: FirebaseAuth
    private lateinit var registration_btn: Button
    private lateinit var emailEditText : TextView
    private lateinit var passwordEditText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        // Инициализация объектов !!!!
        emailEditText=findViewById(R.id.editEmailAddress)
        passwordEditText=findViewById(R.id.editPassword)
        registration_btn=findViewById(R.id.reg_btn)
        auth = Firebase.auth
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        // Переход на главную странцу где пользователь может перейти на вход !!!!
        registration_btn.setOnClickListener()
        {

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Регистрация успешна", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(
                            this,
                            "Ошибка регистрации: ${task.exception?.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }











}