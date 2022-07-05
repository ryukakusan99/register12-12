package com.example.demo1

import android.app.Activity
import android.view.View
import android.widget.TextView
import java.sql.DriverManager


open class TaskDbConnectBill(act : Activity) : AsyncTaskBill() {
    override var activity: Activity? = null
    /*override fun doInBackground(vararg params: Void): String? {
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
    }*/

    /*override fun onPostExecute(result: String?) {
        val tv = activity!!.findViewById<View>(R.id.textview1) as TextView
        tv.text = result
    }*/

    init {
        activity = act
    }
}