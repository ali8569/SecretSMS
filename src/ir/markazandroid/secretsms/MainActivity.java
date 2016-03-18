package ir.markazandroid.secretsms;

import ir.markazandroid.db.SmsSource;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	static TextView tv;
	static Context cntx;
	EditText phone, matn;
	Button bt, button1;
	TextView inbox, sqlview;
	SmsManager smsmanager;
	SmsSource ss;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		varibales();
		cntx = this;
		ss = new SmsSource(MainActivity.this);
		ss.open();
		Toast.makeText(this, "create db", Toast.LENGTH_LONG).show();;
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ss.close();
	}

	private void varibales() {
		phone = (EditText) findViewById(R.id.phone);
		matn = (EditText) findViewById(R.id.matn);
		bt = (Button) findViewById(R.id.bt);
		bt.setOnClickListener(this);
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(this);
		sqlview = (TextView) findViewById(R.id.sqlview);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.bt:
			smsmanager = SmsManager.getDefault();
			String text = matn.getText().toString();
			String phone = this.phone.getText().toString();
			if (!phone.isEmpty() && !text.isEmpty())
				smsmanager.sendTextMessage(phone, null, text, null, null);
			break;
		case R.id.button1:
			Intent intent = new Intent(this, Inbox.class);
			startActivity(intent);
			break;
		}
	}
}