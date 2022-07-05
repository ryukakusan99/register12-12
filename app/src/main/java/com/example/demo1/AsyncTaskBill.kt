package com.example.demo1

import android.app.Activity
import android.os.Looper
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.TextView
import java.sql.DriverManager
import java.util.concurrent.Executors

open class AsyncTaskBill() : Parcelable {
    lateinit var strParams: String
    open var activity: Activity? = null
    /*constructor(parcel: Parcel) : this() {
        strParams = parcel.readString().toString()
    }*/

    inner class AsyncRunnable : Runnable {
        private lateinit var result: String
        var handler = android.os.Handler(Looper.getMainLooper())
        override fun run() {
            // ここにバックグラウンド処理を書く
            result = doInBackground()
            handler.post { onPostExecute(result) }
        }
    }

    fun execute(/*vararg params: String*/) {
        //strParams = params[0]
        val executorService = Executors.newSingleThreadExecutor()
        executorService.submit(AsyncRunnable())
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

    fun onPostExecute(result: String) {
        val tv = activity!!.findViewById<View>(R.id.menuview) as TextView
        tv.text = result
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        //parcel.writeString(strParams)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AsyncTaskBill> {
        override fun createFromParcel(parcel: Parcel): AsyncTaskBill {
            return AsyncTaskBill()
        }

        override fun newArray(size: Int): Array<AsyncTaskBill?> {
            return arrayOfNulls(size)
        }
    }

    protected open fun doInBackground(vararg params: Void): String? {
        TODO("Not yet implemented")
    }
}