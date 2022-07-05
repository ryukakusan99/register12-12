package com.example.demo1;

import java.sql.*;
import java.util.*;
import java.lang.String;

import android.app.Activity;
import android.os.AsyncTask;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class DBQr extends AsyncTask<String, Void, Integer> {

    Activity activity = null;
    private QrActivity activ;

    public DBQr(Activity act) {
        activity = act;
    }

    // @Override
    protected Integer doInBackground(String... params) {


        Integer okane=0;
        Integer calorie=0;


        int flag = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://160.16.141.77:51200/test001", "android", "12han");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from shouhin");

            System.out.println("While no mae");

            while (rs.next()) {
                String dMenu = rs.getString(1);
                String dnedan = rs.getString(2);
                String dazukari =rs.getString(3);
                String dosturi = rs.getString(4);
                String dCalory = rs.getString(5);
                System.out.println(dMenu);
                okane=okane+Integer.parseInt(dnedan);
                calorie=calorie+Integer.parseInt(dCalory);
                System.out.println(dazukari);
                System.out.println(dosturi);

            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    protected void onPostExecute(Integer result) {

        TextView tv =(TextView) activity.findViewById(R.id.Menu);
        tv.setText(result);
            //Toast.makeText(activity, "ログイン", Toast.LENGTH_SHORT).show();
            //Intent intent = new Intent(activity, OrderActivity.class);
           // activity.startActivity(intent);

            //Toast.makeText(activity, "IDかパスワードが違います", Toast.LENGTH_SHORT).show();
        //}
    }
}
