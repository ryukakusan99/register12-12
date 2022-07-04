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
/*
    public void LoadAsync(MainActivity activ) {
        this.activ = activ;
    }

 */

    public DBLogin(Activity act) {
        activity = act;
    }

    // @Override
    protected Integer doInBackground(String... params) {
        // String text1 = params.get(0);
        // String text2=params[1];

        String text1 = params[0];
        String text2 = params[1];
        //text1 = params.substring(0, 1);
        //text1 = params.charAt(0, 1);
        //String text2 = "";
        int flag = 0;

        /*
        for (int i=0; i<1; i++){
            text1 += params[i];

        }
        for (int i=1; i<7; i++){
            text2 += params[i];
        }

*/

        System.out.println("try try");

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://160.16.141.77:51200/test001", "android", "12han");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from shouhin");

            System.out.println("While no mae");

            while (rs.next()) {
                String id = rs.getString(1);
                String password = rs.getString(2);
                System.out.println(params[0]);
                System.out.println(params[1]);
                System.out.println(id);
                System.out.println(password);
                System.out.println("CHECK TEXT");

                if (text1.equals(id) && text2.equals(password)) {
                    flag = 1;
                }
                System.out.println("flag: " + flag);
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    protected void onPostExecute(Integer result) {

        if (result == 1) {
            System.out.println("result: " + result);
            // super.onPostExecute(result);
            // activ.set(result);

            Toast.makeText(activity, "ログイン", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(activity, OrderActivity.class);
            activity.startActivity(intent);
        } else {
            Toast.makeText(activity, "IDかパスワードが違います", Toast.LENGTH_SHORT).show();
        }
        // TextView tv = (TextView)activity.findViewById(R.id.textview1);
        // tv.setText(result);
    }
}
