package com.example.result_activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    var txt:TextView?=null

    val resultContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result: ActivityResult? ->
        if(result?.resultCode == Activity.RESULT_OK){
            txt?.text="We get the result"
        }
        else{
            txt?.text="Failed to get result"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt=findViewById(R.id.txt)
        var btn=findViewById<Button>(R.id.btn)
        btn.setOnClickListener {

            var i= Intent(applicationContext,Resultactivity::class.java)
            resultContract.launch(i)

        }
    }
}