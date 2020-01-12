package com.example.notes_app;

/*import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;





public class Splash extends Activity {

    private final int SPLASH_LENGTH=3000;
    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sharedPreferences = getApplicationContext().getSharedPreferences("key",0);
                //final SharedPreferences.Editor ed= sharedPreferences.edit();
                String value=sharedPreferences.getString("ID","null");

                Log.d("check",value);

                if(value.equals("null"))
                {


                    Intent intent =new Intent(Splash.this,Login.class);
                    Splash.this.startActivity(intent);
                    Splash.this.finish();
                }
                else{
                    Intent intent =new Intent(Splash.this,MainActivity.class);

                    Splash.this.startActivity(intent);
                    Splash.this.finish();
                }

            }
        },SPLASH_LENGTH);

    }
}*/


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class Splash extends Activity {

    private final int SPLASH_LENGTH=3000;
    //SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               // sharedPreferences =getApplication().getSharedPreferences("key",0);
                //final SharedPreferences.Editor ed= sharedPreferences.edit();
                //String value=sharedPreferences.getString("ID","null");
                //Log.d("check",value);

              ////  if(value.equals("null"))
                //{


                  //  Intent intent =new Intent(Splash.this,Login.class);
                    //Splash.this.startActivity(intent);
                    ///Splash.this.finish();
                //}
                //else{
                    Intent intent =new Intent(Splash.this,MainActivity.class);
                    Splash.this.startActivity(intent);
                    Splash.this.finish();
                }

           // }
        },SPLASH_LENGTH);

    }
}






