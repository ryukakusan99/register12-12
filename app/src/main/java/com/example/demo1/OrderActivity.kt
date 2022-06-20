package com.example.demo1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class OrderActivity : AppCompatActivity() , View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val order : Button = findViewById(R.id.order)
        val billstart : Button = findViewById(R.id.billstart)
        val menu1 : Button = findViewById(R.id.menu1)
        val menu2 : Button = findViewById(R.id.menu2)
        val menu3 : Button = findViewById(R.id.menu3)
        val menu4 : Button = findViewById(R.id.menu4)
        val menu5 : Button = findViewById(R.id.menu5)
        val menu6 : Button = findViewById(R.id.menu6)
        val menu7 : Button = findViewById(R.id.menu7)
        val menu8 : Button = findViewById(R.id.menu8)
        val menu9 : Button = findViewById(R.id.menu9)
        val menu10 : Button = findViewById(R.id.menu10)

        order.setOnClickListener(this)
        billstart.setOnClickListener(this)
        menu1.setOnClickListener(this)
        menu2.setOnClickListener(this)
        menu3.setOnClickListener(this)
        menu4.setOnClickListener(this)
        menu5.setOnClickListener(this)
        menu6.setOnClickListener(this)
        menu7.setOnClickListener(this)
        menu8.setOnClickListener(this)
        menu9.setOnClickListener(this)
        menu10.setOnClickListener(this)

    }

    override fun onClick(view: View){
        when(view.id){
            R.id.billstart -> { //会計画面へ遷移
                val intent = Intent(this@OrderActivity, BillActivity::class.java)
                startActivity(intent)
            }
            R.id.order -> {
                //サーバに注文情報を送信
            }
        }
    }

}