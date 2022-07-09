package com.example.demo1

import android.app.Activity
import android.os.Looper
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.sql.DriverManager
import java.util.concurrent.Executors

open class AsyncTaskOrder : Parcelable {
    var str : String = ""
    lateinit var strParams: String
    open var activity: Activity? = null

    inner class AsyncRunnable : Runnable {
        private lateinit var result: String
        var handler = android.os.Handler(Looper.getMainLooper())
        override fun run() {
            // ここにバックグラウンド処理を書く
            result = doInBackground()
            handler.post { onPostExecute(result) }
        }
    }

    fun execute(){
        val executorService = Executors.newSingleThreadExecutor()
        executorService.submit(AsyncRunnable())
    }

    open fun doInBackground(): String {
        var text1 = ""
        var str = "￥"
        var sp = " "
        try {
            println("OK1")
            Class.forName("com.mysql.jdbc.Driver").newInstance()
            val conn = DriverManager.getConnection(
                "jdbc:mysql://160.16.141.77:51200/shop",
                "android",
                "12han"
            )
            val stmt = conn.createStatement()
            val rs = stmt.executeQuery("Select * from shouhin")
            while (rs.next()) {
                val id = rs.getInt(1)
                val name = rs.getString(2)
                val nedan = rs.getInt(3)
                text1 += "$name$sp$str$nedan\r\n"
            }
        } catch (e: Exception) {
            text1 = e.message.toString()
        }
        return text1
    }

    open fun onPostExecute(result: String) {
        val str = result
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        //parcel.writeString(strParams)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AsyncTaskOrder> {
        override fun createFromParcel(parcel: Parcel): AsyncTaskOrder {
            return AsyncTaskOrder()
        }

        override fun newArray(size: Int): Array<AsyncTaskOrder?> {
            return arrayOfNulls(size)
        }
    }

    /*protected open fun doInBackground(vararg params: Void): String? {
        TODO("Not yet implemented")
    }*/
}