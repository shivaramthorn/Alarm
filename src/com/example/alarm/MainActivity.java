package com.example.alarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.style.BulletSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TimePicker;


public class MainActivity extends Activity {

	Button b1;
	TimePicker t;
	AlarmManager al;
    @SuppressWarnings("deprecation")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = (TimePicker) findViewById (R.id.timePicker1);
        b1 = (Button) findViewById (R.id.button1);
       
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent alramIntent = new Intent(MainActivity.this, Reciver.class);
		        PendingIntent pin = PendingIntent.getBroadcast(getApplicationContext(), 1, alramIntent,PendingIntent.FLAG_UPDATE_CURRENT);
		        al = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
		        al.set(AlarmManager.RTC_WAKEUP,t.getCurrentHour().intValue(), pin);
				
		        Toast.makeText(getApplicationContext(), "Alarm Set "+String.valueOf(t.getCurrentHour().intValue()), Toast.LENGTH_LONG).show();
			}
		});
        
    }
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
