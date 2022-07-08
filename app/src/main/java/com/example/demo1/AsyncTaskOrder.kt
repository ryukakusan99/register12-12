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
            str = result
        }
    }

    fun execute(/*vararg params: String*/){
        //strParams = params[0]
        val executorService = Executors.newSingleThreadExecutor()
        executorService.submit(AsyncRunnable())
    }

    fun returnData():String{
        return str
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
        println(text1)
        return text1
        //return ""
    }

    fun onPostExecute(result: String) {
        //var str : String = ""
        val arr1 = result.split("\r\n")
        println(arr1)
        //return arr1
        //println(result)
        val tv1 = activity!!.findViewById<View>(R.id.menu1) as Button
        val tv2 = activity!!.findViewById<View>(R.id.menu2) as Button
        val tv3 = activity!!.findViewById<View>(R.id.menu3) as Button
        val tv4 = activity!!.findViewById<View>(R.id.menu4) as Button
        val tv5 = activity!!.findViewById<View>(R.id.menu5) as Button
        val tv6 = activity!!.findViewById<View>(R.id.menu6) as Button
        val tv7 = activity!!.findViewById<View>(R.id.menu7) as Button
        val tv8 = activity!!.findViewById<View>(R.id.menu8) as Button
        val tv9 = activity!!.findViewById<View>(R.id.menu9) as Button
        //val tv10 = activity!!.findViewById<View>(R.id.menu10) as Button

        if(!arr1[0].isNullOrBlank()){tv1.text = arr1[0]}
        if(!arr1[1].isNullOrBlank()){tv2.text = arr1[1]}
        if(!arr1[2].isNullOrBlank()){tv3.text = arr1[2]}
        if(!arr1[3].isNullOrBlank()){tv4.text = arr1[3]}
        if(!arr1[4].isNullOrBlank()){tv5.text = arr1[4]}
        if(!arr1[5].isNullOrBlank()){tv6.text = arr1[5]}
        if(!arr1[6].isNullOrBlank()){tv7.text = arr1[6]}
        if(!arr1[7].isNullOrBlank()){tv8.text = arr1[7]}
        if(!arr1[8].isNullOrBlank()){tv9.text = arr1[8]}
        //if(!arr1[9].isNullOrBlank()){tv10.text = arr1[9]}
        //tv.text = result
        println(tv1.text)
        println(tv2.text)
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

    /*protected open fun doInBackground(vararg params: Void): String? {
        TODO("Not yet implemented")
    }*/
}