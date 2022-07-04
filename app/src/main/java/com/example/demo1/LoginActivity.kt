/*******************************************************************
 ***  File Name		: LoginActivity
 ***  Version		: V2.0
 ***  Designer		: 島田 靖大
 ***  Date			: 2022.07.04
 ***  Purpose       : ログイン
 ***
 *******************************************************************/
/*
*** Revision :
*** V1.0 : 島田　靖大, 2022.06.23
*** V2.0 : 島田　靖大, 2022.07.04
*/

package com.example.demo1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


//ログイン画面
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var i: Int? = 0

    //宣言
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rogin)
        val button: Button = findViewById(R.id.login)//ログインボタン宣言
        button.setOnClickListener(this)
    }

    public fun set(i: Int) {
        this.i = i;
    }

    //入力確認
    @SuppressLint("SetTextI18n")
    override fun onClick(view: View) {
        val username: EditText = findViewById(R.id.username)//ID宣言
        val password: EditText = findViewById(R.id.password)//パスワード宣言
        //ログインボタンが押された処理
        when (view.id) {
            R.id.login -> {

                if (username.text.isNullOrBlank() && password.text.isNullOrBlank()) {
                    Toast.makeText(this, "IDとパスワードを入力してください。", Toast.LENGTH_SHORT).show()
                } else if (username.text.isNullOrBlank()) {
                    Toast.makeText(this, "IDを入力してください。", Toast.LENGTH_SHORT).show()
                } else if (password.text.isNullOrBlank()) {
                    Toast.makeText(this, "パスワードを入力してください。", Toast.LENGTH_SHORT).show()
                } else {

                    // val a = arrayOf(username, password)
                    val b: String = username.text.toString()
                    val task = DBLogin(this@MainActivity)
                    task.execute(b)
                    val str : String = this.i.toString();
                    Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
                }
                if (this.i == 1) {
                    Toast.makeText(this, "ログイン", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@MainActivity, OrderActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "IDかパスワードが違います", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
//}

