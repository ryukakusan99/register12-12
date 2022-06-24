package com.example.demo1

import android.R
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class QrActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.demo1.R.layout.activity_calorie)
        imageDisplayInitialize()

    }


    // 表示非表示ボタンの実装
    private fun imageDisplayInitialize() {
        //クリックイベントを取得するボタン
        val displayButton = findViewById<View>(R.id.button1) as Button
        val hideButton = findViewById<View>(R.id.button2) as Button

        //画像表示
        val imageView = findViewById<ImageView>(com.example.demo1.R.id.Image)
        imageView.setImageResource(R.drawable.stat_sys_data_bluetooth)

        //ボタンにOnClickListenerインターフェースを実装
        //表示用ボタンの機能実装
        displayButton.setOnClickListener {
            imageView.visibility = View.VISIBLE
        }
        //非表示用ボタンの機能実装
        hideButton.setOnClickListener {
            imageView.visibility = View.INVISIBLE
        }
    }
}

