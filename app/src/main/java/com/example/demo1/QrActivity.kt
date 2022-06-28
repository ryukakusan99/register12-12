/*******************************************************************
***  File Name		: QrActivity
***  Version		: V1.0
***  Designer		: 島田 靖大
***  Date			: 2022.06.24
***  Purpose       : QR写真を表示
***
*******************************************************************/
/*
*** Revision :
*** V1.0 : 島田　靖大, 2022.06.23
*/
package com.example.demo1


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class QrActivity : AppCompatActivity() ,View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calorie)

        val hideButton : Button = findViewById(R.id.button2)//戻るボタン宣言
        hideButton.setOnClickListener(this)
    }


    @SuppressLint("SetTextI18n")
    override fun onClick(view: View) {
        val imageView = findViewById<ImageView>(R.id.Image)//写真宣言
        imageView.setImageResource(R.drawable.test)
        //戻る選択処理
        when (view.id) {
            R.id.button2 -> {
                val intent = Intent(this@QrActivity, OrderActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

