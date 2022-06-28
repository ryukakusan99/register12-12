/*******************************************************************
***  File Name		: Qrctivity
***  Version		: V1.0
***  Designer		: 島田 靖大
***  Date			: 2022.06.24
***  Purpose       : QR写真を入力する
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

        //val displayButton : Button = findViewById(R.id.button1)//ボタン宣言
        val hideButton : Button = findViewById(R.id.button2)//ボタン宣言
        //displayButton.setOnClickListener(this)
        hideButton.setOnClickListener(this)

    }

    //ボタンにOnClickListenerインターフェースを実装
    //表示用ボタンの機能実装

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View) {
        val imageView = findViewById<ImageView>(R.id.Image)//写真宣言
       imageView.setImageResource(R.drawable.test)
        when (view.id) {

            //戻る選択
            R.id.button2 -> {
                val intent = Intent(this@QrActivity, OrderActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

