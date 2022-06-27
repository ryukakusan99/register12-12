/*******************************************************************
 ***  File Name		: LoginActivity
 ***  Version		: V1.0
 ***  Designer		: 島田 靖大
 ***  Date			: 2022.06.24
 ***  Purpose       : ログイン画面のUI処理
 ***
 *******************************************************************/
/*
*** Revision :
*** V1.0 : 島田　靖大, 2022.06.23
*/

package com.example.demo1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.EditText

class MainActivity : AppCompatActivity()  ,View.OnClickListener{
    //ログイン画面


     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_rogin)
         val button: Button = findViewById(R.id.login)//ボタン宣言
         button.setOnClickListener(this)
     }
    //入力確認
    @SuppressLint("SetTextI18n")
    override fun onClick(view: View) {
        val username: EditText = findViewById(R.id.username)//ID宣言
        val password: EditText = findViewById(R.id.password)//パスワード宣言
        when(view.id) {
            R.id.login -> {
                if (username.text.isNullOrBlank() && password.text.isNullOrBlank()) {
                    Toast.makeText(this, "IDとパスワードを入力してください。", Toast.LENGTH_SHORT).show()
                } else if(username.text.isNullOrBlank()){
                    Toast.makeText(this, "IDを入力してください。", Toast.LENGTH_SHORT).show()
                } else if(password.text.isNullOrBlank()) {
                    Toast.makeText(this, "パスワードを入力してください。", Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(this, "ログイン", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@MainActivity, OrderActivity::class.java)
                    startActivity(intent)
                }
            }
        }
     }
}

