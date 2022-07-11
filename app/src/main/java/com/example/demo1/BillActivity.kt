/*******************************************************************
 ***  File Name		: BillActivity.kt
 ***  Version		: V5.0
 ***  Designer		: 藤原　達也
 ***  Date			: 2022.07.10
 ***  Purpose       : 会計処理
 ***
 *******************************************************************/
/*
*** Revision :
*** V1.0 : 藤原　達也, 2022.06.07
*** V2.0 : 藤原　達也, 2022.06.14
*** V3.0 : 藤原　達也, 2022.06.23
*** V4.0 : 藤原　達也, 2022.07.01
*** V5.0 : 藤原　達也, 2022.07.10
*/

package com.example.demo1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class BillActivity : AppCompatActivity() , View.OnClickListener{

    var nStr : String = ""             //数字を文字列として保存
    var payment : Int = 0              //お預かり
    var ch : Int = 0                   //おつり
    var bill : Int = 0                 //合計金額
    var str : String = "￥"            //"￥"マーク
    var ordercontent : String = ""     //注文商品と価格を格納
    var totaltext : String = ""        //合計金額を別途格納
    var pd : String = ""               //お預かり金額を別途格納
    var cg : String = ""               //おつり金額を別途格納

    //会計画面表示開始時の初期設定
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill)

        //前アクティビティからデータを受けとる
        val total = intent.getStringExtra("Total")          //合計金額
        val order = intent.getStringExtra("ordercontent")   //注文商品と価格
        if (total != null) {
            bill = total.toInt()
        }
        if (order != null) {
            ordercontent = order
        }

        //各ボタンを表す変数
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
        val clear : Button = findViewById(R.id.clear)
        val BillFin : Button = findViewById(R.id.BillFin)

        //各テキストフィールドを表す変数
        val menuview : TextView = findViewById(R.id.menuview)
        val total_print : TextView = findViewById(R.id.total_print)

        //各ボタンのクリックイベントを登録
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
        clear.setOnClickListener(this)
        BillFin.setOnClickListener(this)

        //前アクティビティから受け取ったデータを出力
        totaltext += "$str$bill"
        total_print.text = totaltext    //合計金額
        menuview.text = ordercontent    //注文商品と価格
    }

    //各ボタンのクリックイベント設定
    @SuppressLint("SetTextI18n")
    override fun onClick(view: View) {
        //各テキストフィールドを表す変数
        val formula : TextView = findViewById(R.id.formula)
        val paid : TextView = findViewById(R.id.paid)
        val change : TextView = findViewById(R.id.change_print)

        when(view.id){
            R.id.num0 -> { //0ボタン押下時
                formula.text = "${formula.text}0" //表示する数式に0を追加
                nStr += "0"                       //数字の文字列に0を追加
            }
            R.id.num1 -> { //1ボタン押下時
                formula.text = "${formula.text}1" //表示する数式に1を追加
                nStr += "1"                       //数字の文字列に1を追加
            }
            R.id.num2 -> { //2ボタン押下時
                formula.text = "${formula.text}2" //表示する数式に2を追加
                nStr += "2"                       //数字の文字列に2を追加
            }
            R.id.num3 -> { //3ボタン押下時
                formula.text = "${formula.text}3" //表示する数式に3を追加
                nStr += "3"                       //数字の文字列に3を追加
            }
            R.id.num4 -> { //4ボタン押下時
                formula.text = "${formula.text}4" //表示する数式に4を追加
                nStr += "4"                       //数字の文字列に4を追加
            }
            R.id.num5 -> { //5ボタン押下時
                formula.text = "${formula.text}5" //表示する数式に5を追加
                nStr += "5"                       //数字の文字列に5を追加
            }
            R.id.num6 -> { //6ボタン押下時
                formula.text = "${formula.text}6" //表示する数式に6を追加
                nStr += "6"                       //数字の文字列に6を追加
            }
            R.id.num7 -> { //7ボタン押下時
                formula.text = "${formula.text}7" //表示する数式に7を追加
                nStr += "7"                       //数字の文字列に7を追加
            }
            R.id.num8 -> { //8ボタン押下時
                formula.text = "${formula.text}8" //表示する数式に8を追加
                nStr += "8"                       //数字の文字列に8を追加
            }
            R.id.num9 -> { //9ボタン押下時
                formula.text = "${formula.text}9" //表示する数式に9を追加
                nStr += "9"                       //数字の文字列に9を追加
            }
            R.id.ok -> { //OKボタン押下時
                payment += nStr.toInt() //数字の文字列を整数に変換
                str += payment.toString()
                pd = str
                paid.text = str //paymentをお預かりに送信
                str = "￥"
                ch = payment - bill //おつりを計算
                str += ch.toString()
                cg = str
                change.text = str     //おつりを文字列に変換して表示
                formula.text = ""     //数式クリア
                nStr = ""             //数字の文字列クリア
                str = "￥"
            }
            R.id.clear -> { //Cボタン押下時
                formula.text = ""
                nStr = ""
            }
            R.id.BillFin -> { //会計完了ボタン押下時
                //QR画面への遷移
                val intent = Intent(this@BillActivity, QrActivity::class.java)
                //次アクティビティにデータを送る
                intent.putExtra("total", totaltext)        //合計金額
                intent.putExtra("change", cg)              //おつり金額
                intent.putExtra("payment", pd)             //お預かり金額
                intent.putExtra("menuview", ordercontent)  //注文商品と価格
                startActivity(intent)
            }
        }
    }
}