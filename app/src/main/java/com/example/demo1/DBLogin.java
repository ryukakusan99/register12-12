/*******************************************************************
 ***  File Name		: DBLogin
 ***  Version		: V1.0
 ***  Designer		: 仲村　友杜
 ***  Date			: 2022.06.23
 ***  Purpose       : ログイン DBサイド
 ***
 *******************************************************************/
/*
 *** Revision :
 *** V1.0 : 仲村　友杜, 2022.06.23
 */

package com.example.demo1;

import java.sql.*;
import java.util.*;
import java.lang.String;

import android.app.Activity;
import android.os.AsyncTask;
import android.content.Intent;
import android.widget.Toast;


// public class DBLogin extends AsyncTask<String, Void, Integer>{
public class DBLogin extends AsyncTask<String, Void, Integer> {

    Activity activity = null;
    private MainActivity activ;

    public DBLogin(Activity act) {
        activity = act;
    }

    // @Override
    protected Integer doInBackground(String... params) {
        String text1 = params[0];
        String text2 = params[1];
        int flag = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://160.16.141.77:51200/shop", "android", "12han");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from tennin");

            while (rs.next()) {
                String id = rs.getString(1);
                String password = rs.getString(3);
                if (text1.equals(id) && text2.equals(password)) {
                    flag = 1;
                }
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
//ログインが押された時の処理
    protected void onPostExecute(Integer result) {

        if (result == 1) {
            System.out.println("result: " + result);

            Toast.makeText(activity, "ログイン", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(activity, OrderActivity.class);
            activity.startActivity(intent);
        } else {
            Toast.makeText(activity, "IDかパスワードが違います", Toast.LENGTH_SHORT).show();
        }

    }
}
