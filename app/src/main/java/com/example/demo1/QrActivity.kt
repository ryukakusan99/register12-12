/*******************************************************************
***  File Name		: QrActivity
***  Version		: V1.0
***  Designer		: 島田 靖大
***  Date			: 2022.06.24
***  Purpose       : レシートを表示
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
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.sql.DriverManager


class QrActivity : AppCompatActivity() ,View.OnClickListener {
    var mstr : String = ""
    var cal =" kcal"
    var catext:String=""
    inner class TaskOrderConnect(act : Activity) : AsyncTaskOrder() {
        override var activity: Activity? = null
        init {
            activity = act
        }
        override fun doInBackground(): String {
            var text1 = ""
            var str = "￥"
            var sp = " "
            try {
                println("Qrok1")
                Class.forName("com.mysql.jdbc.Driver").newInstance()
                val conn = DriverManager.getConnection(
                    "jdbc:mysql://160.16.141.77:51200/shop",
                    "android",
                    "12han"
                )
                val stmt = conn.createStatement()
                val rs = stmt.executeQuery("Select * from shouhin ")
                while (rs.next()) {
                    val menuname = rs.getString(2)
                    val nedan = rs.getInt(3)
                    val calorie = rs.getDouble(4)
                    text1 += "$menuname$sp$str$nedan$sp$calorie\r\n"
                }
            } catch (e: Exception) {
                text1 = e.message.toString()
            }
            return text1
        }
        override fun onPostExecute(result: String) {
            this@QrActivity.mstr = result
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calorie)
        var task1 = this.TaskOrderConnect(this)
        task1.execute()
        val hideButton : Button = findViewById(R.id.button2)//戻るボタン宣言
        hideButton.setOnClickListener(this)
        val viewButton : Button = findViewById(R.id.view)//戻るボタン宣言
        viewButton.setOnClickListener(this)


    }



    @SuppressLint("SetTextI18n")
    override fun onClick(view: View) {
        val menu: TextView = findViewById(R.id.Menu)//ID宣言
        val goukei: TextView = findViewById(R.id.Goukei)//ID宣言
        val adzukari: TextView = findViewById(R.id.adzukari)//ID宣言
        val otsuri:TextView=findViewById(R.id.otsuri)
        val calorie:TextView=findViewById(R.id.calorie)
        var ca=0.00
        when (view.id) {
            //表示選択処理
            R.id.view -> {
                var task1 = this.TaskOrderConnect(this)
                task1.execute()

                menu.text=intent.getStringExtra("menuview")
                goukei.text = intent.getStringExtra("total")
                adzukari.text = intent.getStringExtra("payment")
                otsuri.text = intent.getStringExtra("change")
                val a=menu.text.split("\r\n")
                val b=mstr.split("\r\n")

                var zx=0
                for(i in 0 until a.size-1) {
                    if (b[0].contains(a[i])) {
                        val c = b[0].split(" ")
                        ca += c[2].toDouble()
                        //println(ca)
                        //println(1)
                    }
                    else if (b[1].contains(a[i])) {
                        val c = b[1].split(" ")
                        ca += c[2].toDouble()
                        //println(ca)
                        //println(2)
                    }
                    else if (b[2].contains(a[i])) {
                        val c = b[2].split(" ")
                        ca += c[2].toDouble()
                    }
                    else if (b[3].contains(a[i])) {
                        val c = b[3].split(" ")
                        ca += c[2].toDouble()
                    }
                    else if (b[4].contains(a[i])) {
                        val c = b[4].split(" ")
                        ca += c[2].toDouble()
                    }
                    else if (b[5].contains(a[i])) {
                        val c = b[5].split(" ")
                        ca += c[2].toDouble()
                    }
                    else if (b[6].contains(a[i])) {
                        val c = b[6].split(" ")
                        ca += c[2].toDouble()
                    }
                    else if (b[7].contains(a[i])) {
                        val c = b[7].split(" ")
                        ca += c[2].toDouble()
                    }
                    else if (b[8].contains(a[i])) {
                        val c = b[8].split(" ")
                        ca += c[2].toDouble()
                    }
                    else if (b[9].contains(a[i])) {
                        val c = b[9].split(" ")
                        ca += c[2].toDouble()
                    }
                    zx +=1
                }
               // println(ca)
                println(zx)
                catext+="$ca$cal"

                calorie.text=catext
            }
            //戻る選択処理
            R.id.button2 -> {
                val intent = Intent(this@QrActivity, OrderActivity::class.java)
                startActivity(intent)

            }

        }

    }

}

