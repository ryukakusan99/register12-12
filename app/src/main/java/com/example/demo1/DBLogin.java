package com.example.demo1;

import java.sql.*;
import android.app.Activity;
import android.os.AsyncTask;
import android.content.Intent;


public class DBLogin extends AsyncTask<String, Void, Integer>{
    Activity activity = null;
    private MainActivity activ;

    public DBLogin(Activity act){
        activity = act;
    }

    // @Override
    protected Integer doInBackground(String... params) {
        String text1=params[0];
        // String text2=params[1];
        int flag = 0;

        System.out.println("try try");

        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://160.16.141.77:51200/test001", "android","12han");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("Select * from shouhin");

            System.out.println("While no mae");

            while(rs.next()) {
                String id = rs.getString(1);
                String password = rs.getString(2);
                System.out.println(params[0]);
                System.out.println(params[1]);
                System.out.println(password);
                System.out.println("CHECK TEXT");

                if (params[0] == id && params[1] == password) {
                    flag = 1;
                }
                System.out.println(flag);
            }

            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    protected void onPostExecute(Integer result){

        if( result == 1) {

            super.onPostExecute(result);
            activ.set(result);


            //Intent intent = new Intent(this, MainActivity.class);
            //startActivity(intent);
        }
        // TextView tv = (TextView)activity.findViewById(R.id.textview1);
        // tv.setText(result);
    }
}
