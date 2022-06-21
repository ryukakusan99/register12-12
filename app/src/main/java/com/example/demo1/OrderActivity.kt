package com.example.demo1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class OrderActivity : AppCompatActivity() , View.OnClickListener{

    var m1 : String = ""    //m1-m10はメニュー名
    var m2 : String = ""
    var m3 : String = ""
    var m4 : String = ""
    var m5 : String = ""
    var m6 : String = ""
    var m7 : String = ""
    var m8 : String = ""
    var m9 : String = ""
    var m10 : String = ""
    var m1_price : String = ""  //m1-m10_priceは価格
    var m2_price : String = ""
    var m3_price : String = ""
    var m4_price : String = ""
    var m5_price : String = ""
    var m6_price : String = ""
    var m7_price : String = ""
    var m8_price : String = ""
    var m9_price : String = ""
    var m10_price : String = ""
    var total_bill : Int = 0    //合計金額
    var str : String = "￥"     //合計金額表示用文字列

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val order : Button = findViewById(R.id.order)
        val billstart : Button = findViewById(R.id.billstart)
        val cancel : Button = findViewById(R.id.cancel)
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

        order.setOnClickListener(this)
        billstart.setOnClickListener(this)
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

        when(view.id){
            R.id.billstart -> { //会計画面へ遷移
                val intent = Intent(this@OrderActivity, BillActivity::class.java)
                startActivity(intent)
            }
            R.id.order -> {
                //サーバに注文情報を送信
            }
            R.id.cancel -> {
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
            }
            R.id.menu1 -> {
                if(ordered1.text.equals("")){
                    ordered1.text = m1
                } else if(ordered2.text.equals("")){
                    ordered2.text = m1
                } else if(ordered3.text.equals("")){
                    ordered3.text = m1
                } else if(ordered4.text.equals("")){
                    ordered4.text = m1
                } else if(ordered5.text.equals("")){
                    ordered5.text = m1
                } else if(ordered6.text.equals("")){
                    ordered6.text = m1
                } else if(ordered7.text.equals("")){
                    ordered7.text = m1
                } else if(ordered8.text.equals("")){
                    ordered8.text = m1
                } else if(ordered9.text.equals("")){
                    ordered9.text = m1
                } else if(ordered10.text.equals("")){
                    ordered10.text = m1
                }
                total_bill += m1_price.toInt()
                str += total_bill.toString()
                ordertotal.text = str
                str = "￥"
            }
            R.id.menu2 -> {
                if(ordered1.text.equals("")){
                    ordered1.text = m2
                } else if(ordered2.text.equals("")){
                    ordered2.text = m2
                } else if(ordered3.text.equals("")){
                    ordered3.text = m2
                } else if(ordered4.text.equals("")){
                    ordered4.text = m2
                } else if(ordered5.text.equals("")){
                    ordered5.text = m2
                } else if(ordered6.text.equals("")){
                    ordered6.text = m2
                } else if(ordered7.text.equals("")){
                    ordered7.text = m2
                } else if(ordered8.text.equals("")){
                    ordered8.text = m2
                } else if(ordered9.text.equals("")){
                    ordered9.text = m2
                } else if(ordered10.text.equals("")){
                    ordered10.text = m2
                }
                total_bill += m2_price.toInt()
                str += total_bill.toString()
                ordertotal.text = str
                str = "￥"
            }
            R.id.menu3 -> {
                if(ordered1.text.equals("")){
                    ordered1.text = m3
                } else if(ordered2.text.equals("")){
                    ordered2.text = m3
                } else if(ordered3.text.equals("")){
                    ordered3.text = m3
                } else if(ordered4.text.equals("")){
                    ordered4.text = m3
                } else if(ordered5.text.equals("")){
                    ordered5.text = m3
                } else if(ordered6.text.equals("")){
                    ordered6.text = m3
                } else if(ordered7.text.equals("")){
                    ordered7.text = m3
                } else if(ordered8.text.equals("")){
                    ordered8.text = m3
                } else if(ordered9.text.equals("")){
                    ordered9.text = m3
                } else if(ordered10.text.equals("")){
                    ordered10.text = m3
                }
                total_bill += m3_price.toInt()
                str += total_bill.toString()
                ordertotal.text = str
                str = "￥"
            }
            R.id.menu4 -> {
                if(ordered1.text.equals("")){
                    ordered1.text = m4
                } else if(ordered2.text.equals("")){
                    ordered2.text = m4
                } else if(ordered3.text.equals("")){
                    ordered3.text = m4
                } else if(ordered4.text.equals("")){
                    ordered4.text = m4
                } else if(ordered5.text.equals("")){
                    ordered5.text = m4
                } else if(ordered6.text.equals("")){
                    ordered6.text = m4
                } else if(ordered7.text.equals("")){
                    ordered7.text = m4
                } else if(ordered8.text.equals("")){
                    ordered8.text = m4
                } else if(ordered9.text.equals("")){
                    ordered9.text = m4
                } else if(ordered10.text.equals("")){
                    ordered10.text = m4
                }
                total_bill += m4_price.toInt()
                str += total_bill.toString()
                ordertotal.text = str
                str = "￥"
            }
            R.id.menu5 -> {
                if(ordered1.text.equals("")){
                    ordered1.text = m5
                } else if(ordered2.text.equals("")){
                    ordered2.text = m5
                } else if(ordered3.text.equals("")){
                    ordered3.text = m5
                } else if(ordered4.text.equals("")){
                    ordered4.text = m5
                } else if(ordered5.text.equals("")){
                    ordered5.text = m5
                } else if(ordered6.text.equals("")){
                    ordered6.text = m5
                } else if(ordered7.text.equals("")){
                    ordered7.text = m5
                } else if(ordered8.text.equals("")){
                    ordered8.text = m5
                } else if(ordered9.text.equals("")){
                    ordered9.text = m5
                } else if(ordered10.text.equals("")){
                    ordered10.text = m5
                }
                total_bill += m5_price.toInt()
                str += total_bill.toString()
                ordertotal.text = str
                str = "￥"
            }
            R.id.menu6 -> {
                if(ordered1.text.equals("")){
                    ordered1.text = m6
                } else if(ordered2.text.equals("")){
                    ordered2.text = m6
                } else if(ordered3.text.equals("")){
                    ordered3.text = m6
                } else if(ordered4.text.equals("")){
                    ordered4.text = m6
                } else if(ordered5.text.equals("")){
                    ordered5.text = m6
                } else if(ordered6.text.equals("")){
                    ordered6.text = m6
                } else if(ordered7.text.equals("")){
                    ordered7.text = m6
                } else if(ordered8.text.equals("")){
                    ordered8.text = m6
                } else if(ordered9.text.equals("")){
                    ordered9.text = m6
                } else if(ordered10.text.equals("")){
                    ordered10.text = m6
                }
                total_bill += m6_price.toInt()
                str += total_bill.toString()
                ordertotal.text = str
                str = "￥"
            }
            R.id.menu7 -> {
                if(ordered1.text.equals("")){
                    ordered1.text = m7
                } else if(ordered2.text.equals("")){
                    ordered2.text = m7
                } else if(ordered3.text.equals("")){
                    ordered3.text = m7
                } else if(ordered4.text.equals("")){
                    ordered4.text = m7
                } else if(ordered5.text.equals("")){
                    ordered5.text = m7
                } else if(ordered6.text.equals("")){
                    ordered6.text = m7
                } else if(ordered7.text.equals("")){
                    ordered7.text = m7
                } else if(ordered8.text.equals("")){
                    ordered8.text = m7
                } else if(ordered9.text.equals("")){
                    ordered9.text = m7
                } else if(ordered10.text.equals("")){
                    ordered10.text = m7
                }
                total_bill += m7_price.toInt()
                str += total_bill.toString()
                ordertotal.text = str
                str = "￥"
            }
            R.id.menu8 -> {
                if(ordered1.text.equals("")){
                    ordered1.text = m8
                } else if(ordered2.text.equals("")){
                    ordered2.text = m8
                } else if(ordered3.text.equals("")){
                    ordered3.text = m8
                } else if(ordered4.text.equals("")){
                    ordered4.text = m8
                } else if(ordered5.text.equals("")){
                    ordered5.text = m8
                } else if(ordered6.text.equals("")){
                    ordered6.text = m8
                } else if(ordered7.text.equals("")){
                    ordered7.text = m8
                } else if(ordered8.text.equals("")){
                    ordered8.text = m8
                } else if(ordered9.text.equals("")){
                    ordered9.text = m8
                } else if(ordered10.text.equals("")){
                    ordered10.text = m8
                }
                total_bill += m8_price.toInt()
                str += total_bill.toString()
                ordertotal.text = str
                str = "￥"
            }
            R.id.menu9 -> {
                if(ordered1.text.equals("")){
                    ordered1.text = m9
                } else if(ordered2.text.equals("")){
                    ordered2.text = m9
                } else if(ordered3.text.equals("")){
                    ordered3.text = m9
                } else if(ordered4.text.equals("")){
                    ordered4.text = m9
                } else if(ordered5.text.equals("")){
                    ordered5.text = m9
                } else if(ordered6.text.equals("")){
                    ordered6.text = m9
                } else if(ordered7.text.equals("")){
                    ordered7.text = m9
                } else if(ordered8.text.equals("")){
                    ordered8.text = m9
                } else if(ordered9.text.equals("")){
                    ordered9.text = m9
                } else if(ordered10.text.equals("")){
                    ordered10.text = m9
                }
                total_bill += m9_price.toInt()
                str += total_bill.toString()
                ordertotal.text = str
                str = "￥"
            }
            R.id.menu10 -> {
                if(ordered1.text.equals("")){
                    ordered1.text = m10
                } else if(ordered2.text.equals("")){
                    ordered2.text = m10
                } else if(ordered3.text.equals("")){
                    ordered3.text = m10
                } else if(ordered4.text.equals("")){
                    ordered4.text = m10
                } else if(ordered5.text.equals("")){
                    ordered5.text = m10
                } else if(ordered6.text.equals("")){
                    ordered6.text = m10
                } else if(ordered7.text.equals("")){
                    ordered7.text = m10
                } else if(ordered8.text.equals("")){
                    ordered8.text = m10
                } else if(ordered9.text.equals("")){
                    ordered9.text = m10
                } else if(ordered10.text.equals("")){
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