package com.example.demo1

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.sql.DriverManager

class OrderActivity : AppCompatActivity() , View.OnClickListener {

    var m1 : String = ""    //m1-m10はメニュー名
    var m2 : String = ""
    var m3 : String = "ホットケーキ"
    var m4 : String = "オレンジジュース"
    var m5 : String = ""
    var m6 : String = ""
    var m7 : String = ""
    var m8 : String = ""
    var m9 : String = ""
    var m10 : String = ""
    var m1_price : String = ""  //m1-m10_priceは価格
    var m2_price : String = ""
    var m3_price : String = "300"
    var m4_price : String = "200"
    var m5_price : String = ""
    var m6_price : String = ""
    var m7_price : String = ""
    var m8_price : String = ""
    var m9_price : String = ""
    var m10_price : String = ""
    var m1_id : String = ""  //m1-m10_idは商品ID
    var m2_id : String = ""
    var m3_id : String = ""
    var m4_id : String = ""
    var m5_id : String = ""
    var m6_id : String = ""
    var m7_id : String = ""
    var m8_id : String = ""
    var m9_id : String = ""
    var m10_id : String = ""
    var total_bill : Int = 0    //合計金額
    var str : String = "￥"     //合計金額表示用文字列
    var mstr : String = ""

    inner class TaskOrderConnect(act : Activity) : AsyncTaskOrder() {
        override var activity: Activity? = null
        init {
            activity = act
        }

        override fun onPostExecute(result: String) {
            this@OrderActivity.mstr = result
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        var task1 = this.TaskOrderConnect(this)
        task1.execute()

        val billstart : Button = findViewById(R.id.billstart)
        val cancel : Button = findViewById(R.id.cancel)
        val menuget : Button = findViewById(R.id.menuget)
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

        billstart.setOnClickListener(this)
        cancel.setOnClickListener(this)
        menuget.setOnClickListener(this)
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

        if(m1.isNullOrBlank()){ menu1.text = "なし" }
        if(m2.isNullOrBlank()){ menu2.text = "なし" }
        if(m3.isNullOrBlank()){ menu3.text = "なし" }
        if(m4.isNullOrBlank()){ menu4.text = "なし" }
        if(m5.isNullOrBlank()){ menu5.text = "なし" }
        if(m6.isNullOrBlank()){ menu6.text = "なし" }
        if(m7.isNullOrBlank()){ menu7.text = "なし" }
        if(m8.isNullOrBlank()){ menu8.text = "なし" }
        if(m9.isNullOrBlank()){ menu9.text = "なし" }
        if(m10.isNullOrBlank()){ menu10.text = "なし" }

    }

    override fun onClick(view: View){
        val ordered1 : TextView = findViewById(R.id.ordered1)
        val ordered2 : TextView = findViewById(R.id.ordered2)
        val ordered3 : TextView = findViewById(R.id.ordered3)
        val ordered4 : TextView = findViewById(R.id.ordered4)
        val ordered5 : TextView = findViewById(R.id.ordered5)
        val ordered6 : TextView = findViewById(R.id.ordered6)
        val ordered7 : TextView = findViewById(R.id.ordered7)
        val ordered8 : TextView = findViewById(R.id.ordered8)
        val ordered9 : TextView = findViewById(R.id.ordered9)
        val ordered10 : TextView = findViewById(R.id.ordered10)
        val ordertotal : TextView = findViewById(R.id.ordertotal)

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

        when(view.id){
            R.id.billstart -> { //サーバに商品を送信した後、会計画面へ遷移
                val intent = Intent(this@OrderActivity, BillActivity::class.java)
                intent.putExtra("Total", total_bill.toString())
                startActivity(intent)
            }
            R.id.cancel -> {
                println("cancel")
                ordered1.text = ""
                ordered2.text = ""
                ordered3.text = ""
                ordered4.text = ""
                ordered5.text = ""
                ordered6.text = ""
                ordered7.text = ""
                ordered8.text = ""
                ordered9.text = ""
                ordered10.text = ""
                ordertotal.text = ""
                total_bill = 0
                str = "￥"

                println("cancel finish")
            }
            R.id.menuget -> {
                println("menuget start")

                var task1 = this.TaskOrderConnect(this)
                task1.execute()
                println(mstr)

                val arr1 = mstr.split("\r\n")
                if(!arr1[0].isNullOrBlank()){menu1.text = arr1[0]}
                if(!arr1[1].isNullOrBlank()){menu2.text = arr1[1]}
                if(!arr1[2].isNullOrBlank()){menu3.text = arr1[2]}
                if(!arr1[3].isNullOrBlank()){menu4.text = arr1[3]}
                if(!arr1[4].isNullOrBlank()){menu5.text = arr1[4]}
                if(!arr1[5].isNullOrBlank()){menu6.text = arr1[5]}
                if(!arr1[6].isNullOrBlank()){menu7.text = arr1[6]}
                if(!arr1[7].isNullOrBlank()){menu8.text = arr1[7]}
                if(!arr1[8].isNullOrBlank()){menu9.text = arr1[8]}
                if(!arr1[9].isNullOrBlank()){menu10.text = arr1[9]}

                if(!menu1.text.equals("なし")){
                    val str1 = menu1.text.split(" ￥")
                    m1 = str1[0]
                    m1_price = str1[1]
                    println(str1)
                }
                if(!menu2.text.equals("なし")){
                    var str = menu2.text.split(" ￥")
                    m2 = str[0]
                    m2_price = str[1]
                }
                if(!menu3.text.equals("なし")){
                    var str = menu3.text.split(" ￥")
                    m3 = str[0]
                    m3_price = str[1]
                }
                if(!menu4.text.equals("なし")){
                    var str = menu4.text.split(" ￥")
                    m4 = str[0]
                    m4_price = str[1]
                }
                if(!menu5.text.equals("なし")){
                    var str = menu5.text.split(" ￥")
                    m5 = str[0]
                    m5_price = str[1]
                }
                if(!menu6.text.equals("なし")){
                    var str = menu6.text.split(" ￥")
                    m6 = str[0]
                    m6_price = str[1]
                }
                if(!menu7.text.equals("なし")){
                    var str = menu7.text.split(" ￥")
                    m7 = str[0]
                    m7_price = str[1]
                }
                if(!menu8.text.equals("なし")){
                    var str = menu8.text.split(" ￥")
                    m8 = str[0]
                    m8_price = str[1]
                }
                if(!menu9.text.equals("なし")){
                    var str = menu9.text.split(" ￥")
                    m9 = str[0]
                    m9_price = str[1]
                }
                if(!menu10.text.equals("なし")){
                    var str = menu10.text.split(" ￥")
                    m10 = str[0]
                    m10_price = str[1]
                }
            }
            R.id.menu1 -> {
                if(!menu1.text.equals("なし")) {
                    if (ordered1.text.isNullOrBlank()) {
                        ordered1.text = m1
                    } else if (ordered2.text.isNullOrBlank()) {
                        ordered2.text = m1
                    } else if (ordered3.text.isNullOrBlank()) {
                        ordered3.text = m1
                    } else if (ordered4.text.isNullOrBlank()) {
                        ordered4.text = m1
                    } else if (ordered5.text.isNullOrBlank()) {
                        ordered5.text = m1
                    } else if (ordered6.text.isNullOrBlank()) {
                        ordered6.text = m1
                    } else if (ordered7.text.isNullOrBlank()) {
                        ordered7.text = m1
                    } else if (ordered8.text.isNullOrBlank()) {
                        ordered8.text = m1
                    } else if (ordered9.text.isNullOrBlank()) {
                        ordered9.text = m1
                    } else if (ordered10.text.isNullOrBlank()) {
                        ordered10.text = m1
                    }
                    total_bill += m1_price.toInt()
                    str += total_bill.toString()
                    ordertotal.text = str
                    str = "￥"
                }
            }
            R.id.menu2 -> {
                if(!menu2.text.equals("なし")) {
                    if (ordered1.text.isNullOrBlank()) {
                        ordered1.text = m2
                    } else if (ordered2.text.isNullOrBlank()) {
                        ordered2.text = m2
                    } else if (ordered3.text.isNullOrBlank()) {
                        ordered3.text = m2
                    } else if (ordered4.text.isNullOrBlank()) {
                        ordered4.text = m2
                    } else if (ordered5.text.isNullOrBlank()) {
                        ordered5.text = m2
                    } else if (ordered6.text.isNullOrBlank()) {
                        ordered6.text = m2
                    } else if (ordered7.text.isNullOrBlank()) {
                        ordered7.text = m2
                    } else if (ordered8.text.isNullOrBlank()) {
                        ordered8.text = m2
                    } else if (ordered9.text.isNullOrBlank()) {
                        ordered9.text = m2
                    } else if (ordered10.text.isNullOrBlank()) {
                        ordered10.text = m2
                    }
                    total_bill += m2_price.toInt()
                    str += total_bill.toString()
                    ordertotal.text = str
                    str = "￥"
                }
            }
            R.id.menu3 -> {
                if(!menu3.text.equals("なし")) {
                    if (ordered1.text.isNullOrBlank()) {
                        ordered1.text = m3
                    } else if (ordered2.text.isNullOrBlank()) {
                        ordered2.text = m3
                    } else if (ordered3.text.isNullOrBlank()) {
                        ordered3.text = m3
                    } else if (ordered4.text.isNullOrBlank()) {
                        ordered4.text = m3
                    } else if (ordered5.text.isNullOrBlank()) {
                        ordered5.text = m3
                    } else if (ordered6.text.isNullOrBlank()) {
                        ordered6.text = m3
                    } else if (ordered7.text.isNullOrBlank()) {
                        ordered7.text = m3
                    } else if (ordered8.text.isNullOrBlank()) {
                        ordered8.text = m3
                    } else if (ordered9.text.isNullOrBlank()) {
                        ordered9.text = m3
                    } else if (ordered10.text.isNullOrBlank()) {
                        ordered10.text = m3
                    }
                    total_bill += m3_price.toInt()
                    str += total_bill.toString()
                    ordertotal.text = str
                    str = "￥"
                }
            }
            R.id.menu4 -> {
                if(!menu4.text.equals("なし")) {
                    if (ordered1.text.isNullOrBlank()) {
                        ordered1.text = m4
                    } else if (ordered2.text.isNullOrBlank()) {
                        ordered2.text = m4
                    } else if (ordered3.text.isNullOrBlank()) {
                        ordered3.text = m4
                    } else if (ordered4.text.isNullOrBlank()) {
                        ordered4.text = m4
                    } else if (ordered5.text.isNullOrBlank()) {
                        ordered5.text = m4
                    } else if (ordered6.text.isNullOrBlank()) {
                        ordered6.text = m4
                    } else if (ordered7.text.isNullOrBlank()) {
                        ordered7.text = m4
                    } else if (ordered8.text.isNullOrBlank()) {
                        ordered8.text = m4
                    } else if (ordered9.text.isNullOrBlank()) {
                        ordered9.text = m4
                    } else if (ordered10.text.isNullOrBlank()) {
                        ordered10.text = m4
                    }
                    total_bill += m4_price.toInt()
                    str += total_bill.toString()
                    ordertotal.text = str
                    str = "￥"
                }
            }
            R.id.menu5 -> {
                if(!menu5.text.equals("なし")) {
                    if (ordered1.text.isNullOrBlank()) {
                        ordered1.text = m5
                    } else if (ordered2.text.isNullOrBlank()) {
                        ordered2.text = m5
                    } else if (ordered3.text.isNullOrBlank()) {
                        ordered3.text = m5
                    } else if (ordered4.text.isNullOrBlank()) {
                        ordered4.text = m5
                    } else if (ordered5.text.isNullOrBlank()) {
                        ordered5.text = m5
                    } else if (ordered6.text.isNullOrBlank()) {
                        ordered6.text = m5
                    } else if (ordered7.text.isNullOrBlank()) {
                        ordered7.text = m5
                    } else if (ordered8.text.isNullOrBlank()) {
                        ordered8.text = m5
                    } else if (ordered9.text.isNullOrBlank()) {
                        ordered9.text = m5
                    } else if (ordered10.text.isNullOrBlank()) {
                        ordered10.text = m5
                    }
                    total_bill += m5_price.toInt()
                    str += total_bill.toString()
                    ordertotal.text = str
                    str = "￥"
                }
            }
            R.id.menu6 -> {
                if(!menu6.text.equals("なし")) {
                    if (ordered1.text.isNullOrBlank()) {
                        ordered1.text = m6
                    } else if (ordered2.text.isNullOrBlank()) {
                        ordered2.text = m6
                    } else if (ordered3.text.isNullOrBlank()) {
                        ordered3.text = m6
                    } else if (ordered4.text.isNullOrBlank()) {
                        ordered4.text = m6
                    } else if (ordered5.text.isNullOrBlank()) {
                        ordered5.text = m6
                    } else if (ordered6.text.isNullOrBlank()) {
                        ordered6.text = m6
                    } else if (ordered7.text.isNullOrBlank()) {
                        ordered7.text = m6
                    } else if (ordered8.text.isNullOrBlank()) {
                        ordered8.text = m6
                    } else if (ordered9.text.isNullOrBlank()) {
                        ordered9.text = m6
                    } else if (ordered10.text.isNullOrBlank()) {
                        ordered10.text = m6
                    }
                    total_bill += m6_price.toInt()
                    str += total_bill.toString()
                    ordertotal.text = str
                    str = "￥"
                }
            }
            R.id.menu7 -> {
                if(!menu7.text.equals("なし")) {
                    if (ordered1.text.isNullOrBlank()) {
                        ordered1.text = m7
                    } else if (ordered2.text.isNullOrBlank()) {
                        ordered2.text = m7
                    } else if (ordered3.text.isNullOrBlank()) {
                        ordered3.text = m7
                    } else if (ordered4.text.isNullOrBlank()) {
                        ordered4.text = m7
                    } else if (ordered5.text.isNullOrBlank()) {
                        ordered5.text = m7
                    } else if (ordered6.text.isNullOrBlank()) {
                        ordered6.text = m7
                    } else if (ordered7.text.isNullOrBlank()) {
                        ordered7.text = m7
                    } else if (ordered8.text.isNullOrBlank()) {
                        ordered8.text = m7
                    } else if (ordered9.text.isNullOrBlank()) {
                        ordered9.text = m7
                    } else if (ordered10.text.isNullOrBlank()) {
                        ordered10.text = m7
                    }
                    total_bill += m7_price.toInt()
                    str += total_bill.toString()
                    ordertotal.text = str
                    str = "￥"
                }
            }
            R.id.menu8 -> {
                if(!menu8.text.equals("なし")) {
                    if (ordered1.text.isNullOrBlank()) {
                        ordered1.text = m8
                    } else if (ordered2.text.isNullOrBlank()) {
                        ordered2.text = m8
                    } else if (ordered3.text.isNullOrBlank()) {
                        ordered3.text = m8
                    } else if (ordered4.text.isNullOrBlank()) {
                        ordered4.text = m8
                    } else if (ordered5.text.isNullOrBlank()) {
                        ordered5.text = m8
                    } else if (ordered6.text.isNullOrBlank()) {
                        ordered6.text = m8
                    } else if (ordered7.text.isNullOrBlank()) {
                        ordered7.text = m8
                    } else if (ordered8.text.isNullOrBlank()) {
                        ordered8.text = m8
                    } else if (ordered9.text.isNullOrBlank()) {
                        ordered9.text = m8
                    } else if (ordered10.text.isNullOrBlank()) {
                        ordered10.text = m8
                    }
                    total_bill += m8_price.toInt()
                    str += total_bill.toString()
                    ordertotal.text = str
                    str = "￥"
                }
            }
            R.id.menu9 -> {
                if(!menu9.text.equals("なし")) {
                    if (ordered1.text.isNullOrBlank()) {
                        ordered1.text = m9
                    } else if (ordered2.text.isNullOrBlank()) {
                        ordered2.text = m9
                    } else if (ordered3.text.isNullOrBlank()) {
                        ordered3.text = m9
                    } else if (ordered4.text.isNullOrBlank()) {
                        ordered4.text = m9
                    } else if (ordered5.text.isNullOrBlank()) {
                        ordered5.text = m9
                    } else if (ordered6.text.isNullOrBlank()) {
                        ordered6.text = m9
                    } else if (ordered7.text.isNullOrBlank()) {
                        ordered7.text = m9
                    } else if (ordered8.text.isNullOrBlank()) {
                        ordered8.text = m9
                    } else if (ordered9.text.isNullOrBlank()) {
                        ordered9.text = m9
                    } else if (ordered10.text.isNullOrBlank()) {
                        ordered10.text = m9
                    }
                    total_bill += m9_price.toInt()
                    str += total_bill.toString()
                    ordertotal.text = str
                    str = "￥"
                }
            }
            R.id.menu10 -> {
                if(!menu10.text.equals("なし")) {
                    if (ordered1.text.isNullOrBlank()) {
                        ordered1.text = m10
                    } else if (ordered2.text.isNullOrBlank()) {
                        ordered2.text = m10
                    } else if (ordered3.text.isNullOrBlank()) {
                        ordered3.text = m10
                    } else if (ordered4.text.isNullOrBlank()) {
                        ordered4.text = m10
                    } else if (ordered5.text.isNullOrBlank()) {
                        ordered5.text = m10
                    } else if (ordered6.text.isNullOrBlank()) {
                        ordered6.text = m10
                    } else if (ordered7.text.isNullOrBlank()) {
                        ordered7.text = m10
                    } else if (ordered8.text.isNullOrBlank()) {
                        ordered8.text = m10
                    } else if (ordered9.text.isNullOrBlank()) {
                        ordered9.text = m10
                    } else if (ordered10.text.isNullOrBlank()) {
                        ordered10.text = m10
                    }
                    total_bill += m10_price.toInt()
                    str += total_bill.toString()
                    ordertotal.text = str
                    str = "￥"
                }
            }
        }
    }
}