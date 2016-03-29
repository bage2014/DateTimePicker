package com.bage.datetimepicker;

import com.bage.datepicker.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class MainActivity extends Activity implements OnDateChangedListener, OnTimeChangedListener, OnClickListener, OnDateSetListener, OnTimeSetListener {

	private DatePicker dp_date;
	private TimePicker tp_time;
	private EditText et_date;
	private EditText et_time;
	private DatePickerDialog dp_date2;
	private TimePickerDialog tp_time2;
	
    @SuppressLint("NewApi") @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        dp_date = (DatePicker) findViewById(R.id.acmain_dp_date);
        tp_time = (TimePicker) findViewById(R.id.acmain_tp_time);
        et_date = (EditText) findViewById(R.id.acmain_et_date);
        et_time = (EditText) findViewById(R.id.acmain_et_time);
        dp_date.init(2015, 8, 20, this);
        dp_date.setCalendarViewShown(false);
        tp_time.setOnTimeChangedListener(this);
        tp_time.setIs24HourView(true);
        
        et_date.setOnClickListener(this);
        et_time.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onDateChanged(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
		System.out.println("date:"+dp_date.getYear()+":"+(dp_date.getMonth()+1)+":"+dp_date.getDayOfMonth());
		
	}


	@Override
	public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
		System.out.println("time:"+tp_time.getCurrentHour()+":"+tp_time.getCurrentMinute());
	}


	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.acmain_et_time:
			tp_time2 = new TimePickerDialog(this, this, 0, 0, true);
			tp_time2.setTitle("请选择时间");
			
			tp_time2.setIcon(R.drawable.ic_launcher);
			tp_time2.setCancelable(true);
			
			tp_time2.show();
			break;
			
		case R.id.acmain_et_date:
			dp_date2 = new DatePickerDialog(this, this , 2000, 1, 1);
			dp_date2.setTitle("请选择日期");
			
			dp_date2.setIcon(R.drawable.ic_launcher);
			dp_date2.show();
			break;

		default:
			break;
		}
		
	}


	@SuppressLint("NewApi") @Override
	public void onDateSet(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
		System.out.println("nemdate:"+dp_date2.getDatePicker().getYear()+":"+(dp_date2.getDatePicker().getMonth()+1)+":"+dp_date2.getDatePicker().getDayOfMonth());
		
	}


	@Override
	public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
		System.out.println("newtime:"+hourOfDay+":"+minute);
		
	}
    
}
