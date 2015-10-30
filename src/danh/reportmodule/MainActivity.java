package danh.reportmodule;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.text.method.DateTimeKeyListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;


public class MainActivity extends Activity {
	Button startDateButton;
	Button endDateButton;
	
	// Declare starting date
	int start_year;
	int start_month;
	int start_day;
	// Declare ending date
	int end_year;
	int end_month;
	int end_day;
	Date date;
	// Dat - Using above variable to compare with date in database
	
	static final int DILOG_ID_START = 0;
	static final int DILOG_ID_END = 1;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Danh
        showDialogOnButtonClick();
    }
    
    public void showDialogOnButtonClick() {
    	startDateButton = (Button)findViewById(R.id.startDateButton);
    	endDateButton = (Button)findViewById(R.id.endDateButton);
    	
    	// Danh - Click on startDateButton to show Date dialog
    	startDateButton.setOnClickListener(
    		new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					showDialog(DILOG_ID_START);
				}
			}
    	);
    	
    	// Danh - Click on endDateButton to show Date dialog
    	endDateButton.setOnClickListener(
    		new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					showDialog(DILOG_ID_END);
				}
			}
        );
    }
    
    @Override
    protected Dialog onCreateDialog(int id) {
    	if (id == DILOG_ID_START) {
    		Calendar c = Calendar.getInstance();
    		
    		return new DatePickerDialog(this, datePickerListenerStart, 
    				c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
    	}
    	
    	if (id == DILOG_ID_END) {
    		Calendar c = Calendar.getInstance();
    		
    		return new DatePickerDialog(this, datePickerListenerEnd, 
    				c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
    	}
    	
    	return null;
    }
    
    private DatePickerDialog.OnDateSetListener datePickerListenerStart
    	= new DatePickerDialog.OnDateSetListener() {
			
			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				start_year = year;
				start_month = monthOfYear;
				start_day = dayOfMonth;
				
				//Toast.makeText(MainActivity.this, start_year + "/" + start_month + "/" + start_day, Toast.LENGTH_LONG).show();
				
				startDateButton = (Button)findViewById(R.id.startDateButton);
				
				startDateButton.setText(start_day + "/" + start_month + "/" + start_year);
			}
		};
		
	private DatePickerDialog.OnDateSetListener datePickerListenerEnd
		= new DatePickerDialog.OnDateSetListener() {
			
			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				end_year = year;
				end_month = monthOfYear;
				end_day = dayOfMonth;
				
				//Toast.makeText(MainActivity.this, start_year + "/" + start_month + "/" + start_day, Toast.LENGTH_LONG).show();
				
				endDateButton = (Button)findViewById(R.id.endDateButton);
				
				endDateButton.setText(end_day + "/" + end_month + "/" + end_year);
			}
	};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
