/*******************************************************************
***  File Name		: QrActivity
***  Version		: V2.0
***  Designer		: 島田 靖大
***  Date			: 2022.07.08
***  Purpose       : レシートを表示
***
*******************************************************************/
/*
*** Revision :
*** V1.0 : 島田　靖大, 2022.06.23
*** V2.0 : 島田　靖大, 2022.07.08
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
    //文字列宣言
    var mstr : String = ""
    var cal =" kcal"
    var catext:String=""
    var mstr2 : String = ""
    //DB接続
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
                    //受け取り変数宣言
                    //商品名
                    val menuname = rs.getString(2)
                    //値段
                    val nedan = rs.getInt(3)
                    //カロリー
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

    inner class TaskMenuConnect(act : Activity) : AsyncTaskOrder() {
        override var activity: Activity? = null
        init {
            activity = act
        }

        override fun onPostExecute(result: String) {
            this@QrActivity.mstr2 = result
        }
    }

    //画面との接続宣言
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calorie)
        var task1 = this.TaskOrderConnect(this)
        task1.execute()
        val hideButton : Button = findViewById(R.id.button2)//戻るボタン宣言
        hideButton.setOnClickListener(this)
        val viewButton : Button = findViewById(R.id.view)//表示ボタン宣言
        viewButton.setOnClickListener(this)
        var task2 = this.TaskMenuConnect(this)
        task2.execute()
    }

    //表示ボタンが押された時の処理
    @SuppressLint("SetTextI18n")
    override fun onClick(view: View) {
        val menu: TextView = findViewById(R.id.Menu)//商品名の宣言
        val goukei: TextView = findViewById(R.id.Goukei)//合計金額の宣言
        val adzukari: TextView = findViewById(R.id.adzukari)//預かり金額の宣言
        val otsuri:TextView=findViewById(R.id.otsuri)//おつりの宣言
        val calorie:TextView=findViewById(R.id.calorie)//カロリーの宣言
        var ca=0.00//合計カロリーの宣言
        when (view.id) {
            //表示選択処理
            R.id.view -> {
                var task1 = this.TaskOrderConnect(this)
                task1.execute()

                menu.text=intent.getStringExtra("menuview")//会計画面から商品名を取得
                goukei.text = intent.getStringExtra("total")//会計画面から合計金額を取得
                adzukari.text = intent.getStringExtra("payment")//会計画面から預かり金額を取得
                otsuri.text = intent.getStringExtra("change")//会計画面からおつりを取得
                //会計画面から商品名をとってきたのをスペースで分解
                val a=menu.text.split("\r\n")
                //DBからとってきたのをスペースで分解
                val b=mstr.split("\r\n")

                var zx=0
                //会計画面からのメニュ分for分を回す
                //DBの商品名と会計画面からの商品名が同じときカロリーを足す
                for(i in 0 until a.size-1) {
                    //DBの商品名1つ目
                    if (b[0].contains(a[i])) {
                        val c = b[0].split(" ")
                        ca += c[2].toDouble()
                    }
                    else if (b[1].contains(a[i])) {
                        //DBの商品名2つ目
                        val c = b[1].split(" ")
                        ca += c[2].toDouble()
                    }
                    else if (b[2].contains(a[i])) {
                        //DBの商品名3つ目
                        val c = b[2].split(" ")
                        ca += c[2].toDouble()
                    }
                    else if (b[3].contains(a[i])) {
                        //DBの商品名4つ目
                        val c = b[3].split(" ")
                        ca += c[2].toDouble()
                    }
                    else if (b[4].contains(a[i])) {
                        //DBの商品名5つ目
                        val c = b[4].split(" ")
                        ca += c[2].toDouble()
                    }
                    else if (b[5].contains(a[i])) {
                        //DBの商品名6つ目
                        val c = b[5].split(" ")
                        ca += c[2].toDouble()
                    }
                    else if (b[6].contains(a[i])) {
                        //DBの商品名7つ目
                        val c = b[6].split(" ")
                        ca += c[2].toDouble()
                    }
                    else if (b[7].contains(a[i])) {
                        //DBの商品名8つ目
                        val c = b[7].split(" ")
                        ca += c[2].toDouble()
                    }
                    else if (b[8].contains(a[i])) {
                        //DBの商品名9つ目
                        val c = b[8].split(" ")
                        ca += c[2].toDouble()
                    }
                    else if (b[9].contains(a[i])) {
                        //DBの商品名10つ目
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
                var task = this.TaskMenuConnect(this)
                task.execute()
                val intent = Intent(this@QrActivity, OrderActivity::class.java)
                intent.putExtra("Menu", mstr2)//注文画面にメニュー情報を送る
                startActivity(intent)

            }

        }

    }

}

