package com.example.egehaneralp.challenge1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences spre;
    SharedPreferences.Editor editor;
    static  int counter;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.tv1);
        spre=getPreferences(MODE_PRIVATE);
        editor=spre.edit();
        counter=spre.getInt("a",0);

        Log.d("mesaj","crate");
    }


    @Override
    protected void onStop() {
        super.onStop();
        counter++;
        tv1.setText(String.valueOf(counter));

        Log.d("mesaj","stop");
    }


    @Override
    protected void onPause() {
        super.onPause();
        tv1.setText(String.valueOf(counter));
        Log.d("mesaj","pause");
    }

    @Override
    protected void onResume() {//****
        super.onResume();
        tv1.setText(String.valueOf(counter));
        Log.d("mesaj","resume");
    }


    @Override
    protected void onUserLeaveHint() { //********
        super.onUserLeaveHint();
        editor.putInt("a",counter+1);
        editor.commit();

    }
}
