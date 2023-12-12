package com.example.myapplication.service

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ServiceActivity : AppCompatActivity() {

    private lateinit var databaseReference: DatabaseReference
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        databaseReference = FirebaseDatabase.getInstance().reference.child("Auto/marka")
        databaseReference.addValueEventListener(object : ValueEventListener {
            val textView = findViewById<TextView>(R.id.textView)
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue(String::class.java)
                Log.d("activity_service", "Значение: $value")
                textView.text = value
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w("activity_service", "Ошибка чтения данных", error.toException())
            }
        })

    }


}