package com.bayu.linierlayout;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
public class RelativeActivity extends AppCompatActivity {
    DatePickerDialog picker;
    EditText eText;
    Button btnGet;
    TextView tvw;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvw = (TextView)findViewById(R.id.textView1);
        eText = (EditText) findViewById(R.id.EditText);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v){
               final Calendar cldr = Calendar.getInstance();
               int day = cldr.get(Calendar.DAY_OF_MONTH);
               int month = cldr.get(Calendar.MONTH);
               int year = cldr.get(Calendar.YEAR);
               // date picker dialog
               picker = new DatePickerDialog(RelativeActivity.this, new DatePickerDialog.OnDateSetListener() {
                   @Override
                   public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                       eText.setText(dayOfMonth  + "/" + (monthOfYear+1)+ "/" + year);
                   }
               }, year, month, day);
               picker.show();
           }
        });
        btnGet = (Button)findViewById(R.id.button1);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvw.setText("Selected Date: "+ eText.getText());
            }
        });
    }
}
