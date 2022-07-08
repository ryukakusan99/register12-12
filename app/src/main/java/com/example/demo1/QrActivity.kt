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
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.sql.DriverManager


class QrActivity : AppCompatActivity() ,View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calorie)

        val hideButton : Button = findViewById(R.id.button2)//戻るボタン宣言
        hideButton.setOnClickListener(this)
    }

    fun doInBackground(): String {
        var text1 = ""
        try {
            println("OK1")
            Class.forName("com.mysql.jdbc.Driver").newInstance()
            val conn = DriverManager.getConnection(
                "jdbc:mysql://160.16.141.77:51200/test001",
                "android",
                "12han"
            )
            val stmt = conn.createStatement()
            val rs = stmt.executeQuery("Select * from shouhin")
            while (rs.next()) {
                val id = rs.getInt(1)
                val name = rs.getString(2)
                val nedan = rs.getInt(3)
                text1 += "$id $name $nedan \r\n"
            }
        } catch (e: Exception) {
            text1 = e.message.toString()
        }
        return text1
        //return ""
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View) {
        val menu: TextView = findViewById(R.id.Menu)//ID宣言
        val goukei: TextView = findViewById(R.id.Goukei)//ID宣言
        val adzukari: TextView = findViewById(R.id.adzukari)//ID宣言
        val otsuri:TextView=findViewById(R.id.otsuri)
        val calorie:TextView=findViewById(R.id.calorie)
       // binding.textView.text = binding.TextView.text.toString()
        //val task = DBQr(this@QrActivity)
       // task.execute()

        //戻る選択処理
        when (view.id) {
            R.id.button2 -> {
                val intent = Intent(this@QrActivity, OrderActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

