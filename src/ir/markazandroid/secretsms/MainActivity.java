package ir.markazandroid.secretsms;

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

import ir.markazandroid.contacts.Contact;

public class MainActivity extends Activity implements OnClickListener {

	static TextView tv;
	static Context cntx;
	EditText phone, matn;
	Button bt, button1,contact;
	TextView inbox;
	TextView smsBody;
	SmsManager smsmanager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		varibales();
		cntx = this;
	}

	private void varibales() {
		phone = (EditText) findViewById(R.id.phone);
		matn = (EditText) findViewById(R.id.matn);
		bt = (Button) findViewById(R.id.bt);
		bt.setOnClickListener(this);
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(this);
		smsBody = (TextView) findViewById(R.id.smsbody);
		contact = (Button) findViewById(R.id.contactbutt);
		contact.setOnClickListener(this);


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
		case R.id.contactbutt:
			Intent intent2 = new Intent(this, Contact.class);
			startActivity(intent2);
			break;
		}
		}
	}
