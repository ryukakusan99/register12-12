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

        order.setOnClickListener(this)
        billstart.setOnClickListener(this)

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