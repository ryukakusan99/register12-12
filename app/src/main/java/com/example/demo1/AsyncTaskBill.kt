/************************************************************************
 ***  File Name		: AsyncTaskBill.kt
 ***  Version		: V1.0
 ***  Designer		: 藤原　達也
 ***  Date			: 2022.07.04
 ***  Purpose       : データベース接続、および商品テーブル参照
                      各アクティビティにおけるデータベース関連の処理のための雛形
                      各アクティビティでは当クラスを拡張して利用する
 ***
 **********************************************************************/
/*
*** Revision :
*** V1.0 : 藤原　達也, 2022.07.04
*/

package com.example.demo1

import android.app.Activity
import android.os.Looper
import android.os.Parcel
import android.os.Parcelable
import java.sql.DriverManager
import java.util.concurrent.Executors

open class AsyncTaskBill() : Parcelable {
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
    fun execute() {
        val executorService = Executors.newSingleThreadExecutor()
        executorService.submit(AsyncRunnable())
    }

    //データベースへの接続＆商品テーブル上のデータ取得(バックグラウンド処理)
    open fun doInBackground(): String {
        var text1 = ""
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
                val id = rs.getInt(1)       //商品ID
                val name = rs.getString(2)  //商品名
                val nedan = rs.getInt(3)    //価格
                text1 += "$id $name $nedan \r\n"
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

    //メンバ保存
    override fun writeToParcel(parcel: Parcel, flags: Int) {
    }

    //Parcelableインタフェース使用時のメソッド配置を示す
    override fun describeContents(): Int {
        return 0
    }

    //当クラスにおけるParcelableインタフェースの使用宣言
    companion object CREATOR : Parcelable.Creator<AsyncTaskBill> {
        override fun createFromParcel(parcel: Parcel): AsyncTaskBill {
            return AsyncTaskBill()
        }

        override fun newArray(size: Int): Array<AsyncTaskBill?> {
            return arrayOfNulls(size)
        }
    }

    //サブクラスからのアクセスを可能にする
    protected open fun doInBackground(vararg params: Void): String? {
        TODO("Not yet implemented")
    }
}