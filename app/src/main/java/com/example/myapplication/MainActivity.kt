package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.entrance.AuthActivity
import com.example.myapplication.registration.RegistrationActivity

class MainActivity : AppCompatActivity() {
    // Добавление объектов в код
    private lateinit var enter_btn : Button
    private lateinit var reg_btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Инициализация объектов !!!!
        enter_btn=findViewById(R.id.enter)
        reg_btn=findViewById<Button?>(R.id.Reg)
        // Переходы по кнопкам
        enter_btn.setOnClickListener(){
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent) }
        reg_btn.setOnClickListener(){
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent) }
    }
}