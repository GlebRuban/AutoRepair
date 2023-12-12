package com.example.myapplication.entrance

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.service.ServiceActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class AuthActivity : AppCompatActivity() {
    // Добавление объектов в код
    private lateinit var auth: FirebaseAuth
    private lateinit var entrance_button : Button
    private lateinit var emailEditText : TextView
    private lateinit var passwordEditText : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrance)
        // Инициализация объектов !!!!
        entrance_button=findViewById(R.id.Entrance)
        emailEditText=findViewById(R.id.AuthEmailAddress)
        passwordEditText=findViewById(R.id.AuthPassword)
        auth = Firebase.auth
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        // Вход в сервисы после входа !!!!
        entrance_button.setOnClickListener(){
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Вход успешен", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, ServiceActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Ошибка входа: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}