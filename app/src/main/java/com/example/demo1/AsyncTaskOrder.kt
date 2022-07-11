/************************************************************************
 ***  File Name		: AsyncTaskOrder.kt
 ***  Version		: V3.0
 ***  Designer		: 藤原　達也
 ***  Date			: 2022.07.08
 ***  Purpose       : データベース接続、および商品テーブル参照
                      各アクティビティにおけるデータベース関連の処理のための雛形
                      各アクティビティでは当クラスを拡張して利用する
 ***
 **********************************************************************/
/*
*** Revision :
*** V1.0 : 藤原　達也, 2022.07.04
*** V2.0 : 藤原　達也, 2022.07.06
*** V3.0 : 藤原　達也, 2022.07.08
*/

package com.example.demo1

import android.app.Activity
import android.os.Looper
import java.sql.DriverManager
import java.util.concurrent.Executors

open class AsyncTaskOrder {
    open var activity: Activity? = null

    //スレッド内の処理を示す内部クラス
    inner class AsyncRunnable : Runnable {
        private lateinit var result: String
        var handler = android.os.Handler(Looper.getMainLooper())
        override fun run() {
            result = doInBackground()               //バックグラウンド処理の結果
            handler.post { onPostExecute(result) }  //バックグラウンド処理後に実行する処理
        }
    }

    //内部クラスを呼び出し，バックグラウンド処理起動
    fun execute(){
        val executorService = Executors.newSingleThreadExecutor()
        executorService.submit(AsyncRunnable())
    }

    //データベースへの接続＆商品テーブル上のデータ取得(バックグラウンド処理)
    open fun doInBackground(): String {
        var text1 = ""
        var str = "￥"
        var sp = " "
        try {
            //データベースへの接続
            Class.forName("com.mysql.jdbc.Driver").newInstance()
            val conn = DriverManager.getConnection(
                "jdbc:mysql://160.16.141.77:51200/shop",
                "android",
                "12han"
            )
            //商品テーブル上のデータを取得
            val stmt = conn.createStatement()
            val rs = stmt.executeQuery("Select * from shouhin")
            while (rs.next()) {
                val name = rs.getString(2) //商品名
                val nedan = rs.getInt(3)   //価格
                text1 += "$name$sp$str$nedan\r\n"
            }
        } catch (e: Exception) {
            text1 = e.message.toString()
        }
        return text1    //取得したデータを返す
    }

    //バックグラウンド処理終了後に実行される処理
    open fun onPostExecute(result: String) {
        //ここでは暫定的に、任意文字列にデータベースから取得したデータを格納している
        //この部分は各アクティビティでオーバライド＆再定義を行って利用する
        val str = result
    }
}