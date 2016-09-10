package jp.techacademy.nonomurar.y.aisatsuapp;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView text;
  private  Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.text = (TextView) findViewById(R.id.editText);
        this.button = (Button) findViewById(R.id.button1);
        this.button.setOnClickListener(this);
    }

        @Override
    public void onClick(View v) {
            Calendar calendar = Calendar.getInstance();
            // 現在の時間の取得
           int curHourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
            // 現在の分の取得
            int curMinute = calendar.get(Calendar.MINUTE);
            TimePickerDialog timePikerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));

                            if (2 <= hourOfDay && hourOfDay <= 9) {
                                text.setText("おはよう");
                            } else if (10 <= hourOfDay && hourOfDay <= 17) {
                                text.setText("こんにちは");
                            } else {
                                text.setText("こんばんは");
                            }
                        }
                    },curHourOfDay,curMinute,true
            );
            timePikerDialog.show();
        }
}







