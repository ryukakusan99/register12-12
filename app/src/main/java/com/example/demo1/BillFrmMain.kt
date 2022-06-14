package com.example.demo1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity()  , View.OnClickListener{

    var nStr : String = ""  //数字を文字列として保存する
    var payment : Int = 0   //お預かり
    var ch : Int = 0        //おつり
    var bill : Int = 0      //合計金額

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num0 : Button = findViewById(R.id.num0)
        val num1 : Button = findViewById(R.id.num1)
        val num2 : Button = findViewById(R.id.num2)
        val num3 : Button = findViewById(R.id.num3)
        val num4 : Button = findViewById(R.id.num4)
        val num5 : Button = findViewById(R.id.num5)
        val num6 : Button = findViewById(R.id.num6)
        val num7 : Button = findViewById(R.id.num7)
        val num8 : Button = findViewById(R.id.num8)
        val num9 : Button = findViewById(R.id.num9)
        val ok : Button = findViewById(R.id.ok)

        num0.setOnClickListener(this)
        num1.setOnClickListener(this)
        num2.setOnClickListener(this)
        num3.setOnClickListener(this)
        num4.setOnClickListener(this)
        num5.setOnClickListener(this)
        num6.setOnClickListener(this)
        num7.setOnClickListener(this)
        num8.setOnClickListener(this)
        num9.setOnClickListener(this)
        ok.setOnClickListener(this)


    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View) {
        val formula : TextView = findViewById(R.id.formula)
        val paid : TextView = findViewById(R.id.paid)
        val change : TextView = findViewById(R.id.change_print)
        when(view.id){
            R.id.num0 -> {
                formula.text = "${formula.text}0" //表示する数式に0を追加
                nStr += "0"                       //数字の文字列に0を追加
            }
            R.id.num1 -> {
                formula.text = "${formula.text}1" //表示する数式に1を追加
                nStr += "1"                       //数字の文字列に1を追加
            }
            R.id.num2 -> {
                formula.text = "${formula.text}2" //表示する数式に2を追加
                nStr += "2"                       //数字の文字列に2を追加
            }
            R.id.num3 -> {
                formula.text = "${formula.text}3" //表示する数式に3を追加
                nStr += "3"                       //数字の文字列に3を追加
            }
            R.id.num4 -> {
                formula.text = "${formula.text}4" //表示する数式に4を追加
                nStr += "4"                       //数字の文字列に4を追加
            }
            R.id.num5 -> {
                formula.text = "${formula.text}5" //表示する数式に5を追加
                nStr += "5"                       //数字の文字列に5を追加
            }
            R.id.num6 -> {
                formula.text = "${formula.text}6" //表示する数式に6を追加
                nStr += "6"                       //数字の文字列に6を追加
            }
            R.id.num7 -> {
                formula.text = "${formula.text}7" //表示する数式に7を追加
                nStr += "7"                       //数字の文字列に7を追加
            }
            R.id.num8 -> {
                formula.text = "${formula.text}8" //表示する数式に8を追加
                nStr += "8"                       //数字の文字列に8を追加
            }
            R.id.num9 -> {
                formula.text = "${formula.text}9" //表示する数式に9を追加
                nStr += "9"                       //数字の文字列に9を追加
            }
            R.id.ok -> {
                payment += nStr.toInt()         //数字の文字列を整数に変換
                paid.text = payment.toString()  //paymentをお預かりに送信
                ch = payment - bill             //おつりを計算
                change.text = ch.toString()     //おつりを文字列に変換して表示
                formula.text = ""               //数式クリア
                nStr = ""                       //数字の文字列クリア
            }
        }
    }


    //fun TablefrmOut(view: View) {
        //テーブル画面出力モジュールに移行
    //}
}