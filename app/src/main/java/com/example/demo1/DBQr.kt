/*******************************************************************
 ***  File Name		: DBQr
 ***  Version		: V1.0
 ***  Designer		: 島田 靖大
 ***  Date			: 2022.06.23
 ***  Purpose       : レシートDBサイド
 ***
 *******************************************************************/
/*
*** Revision :
*** V1.0 : 島田　靖大, 2022.06.23
*/

package com.example.demo1;

import android.app.Activity
import android.view.View
import android.widget.TextView
import java.sql.DriverManager


open class DBQr(act : Activity) : AsyncTaskBill() {
        override var activity: Activity? = null
        override fun doInBackground(vararg params: Void): String? {
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
        }
/*
        override fun onPostExecute(result: String?) {
                val tv = activity!!.findViewById<View>(R.id.Menu) as TextView
                tv.text = result
        }*/
       // setContentView(R.layout.);

        // text_view： activity_main.xml の TextView の id
       // TextView textView = findViewById(R.id.text_view);

        // テキストを設定
        // R.string.textは"Test TextView"のこと
       // textView.setText(R.string.text);

}
/*
        init {
        activity = act
        }
        }

 */