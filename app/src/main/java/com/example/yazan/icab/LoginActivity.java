package com.example.yazan.icab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by Yazan on 12/16/2015.
 */
public class LoginActivity extends AppCompatActivity {

    boolean isNet=false;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        // TODO Auto-generated method stub
        /*requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logindialog);

        Button doneLogin= (Button) findViewById(R.id.doneloginbtn);
        doneLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText user = (EditText) findViewById(R.id.usersigninet);
                EditText pass = (EditText) findViewById(R.id.passsigninet);
                if (!isOnline())
                    Toast.makeText(getBaseContext(), "please check your internet connection", Toast.LENGTH_LONG).show();

                else if (user.getText().toString().length() == 0) {
                    Toast.makeText(getBaseContext(), "please enter username", Toast.LENGTH_LONG).show();
                } else if (pass.getText().toString().length() == 0) {
                    Toast.makeText(getBaseContext(), "please enter password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

    public boolean isOnline() {

        Runtime runtime = Runtime.getRuntime();
        try {

            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int     exitValue = ipProcess.waitFor();
            if (exitValue == 0)isNet=true;
            else isNet=false;
            return (exitValue == 0);

        } catch (IOException e)          { e.printStackTrace(); }
        catch (InterruptedException e) { e.printStackTrace(); }

        return false;
    }


}
