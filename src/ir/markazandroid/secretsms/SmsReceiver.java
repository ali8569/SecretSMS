package ir.markazandroid.secretsms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {
	String addr = "";

	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle bundle = intent.getExtras();
		if (bundle != null) {
			// get sms objects
			Object[] pdus = (Object[]) bundle.get("pdus");
			if (pdus.length == 0) {
				return;
			}
			// large message might be broken into many
			SmsMessage[] messages = new SmsMessage[pdus.length];
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < pdus.length; i++) {
				messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
				sb.append(messages[i].getMessageBody());
			}
			final String sender = messages[0].getOriginatingAddress();
			final String message = sb.toString();
			Toast.makeText(context, message + "  " + sender, Toast.LENGTH_SHORT)
					.show();
			abortBroadcast();
			// prevent any other broadcast receivers from receiving broadcast
			// abortBroadcast();
		}
	}
}