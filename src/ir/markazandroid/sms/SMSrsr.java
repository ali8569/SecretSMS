package ir.markazandroid.sms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

public class SMSrsr {

	private static ContentResolver cr;
	public static List<String> numbers = new ArrayList<String>();
	public static List<String> bodys = new ArrayList<String>();

	public static ContentResolver getCr() {
		return cr;
	}

	public static void setCr(ContentResolver cr) {
		SMSrsr.cr = cr;
	}

	public static void readInbox() {

		Cursor cursor = getCr().query(Uri.parse("content://sms/inbox"), null,
				null, null, null);
		if (cursor.moveToFirst()) { // must check the result to prevent
									// exception
			do {
				String body = cursor.getString(
						cursor.getColumnIndexOrThrow("body")).toString();
				if (!body.equals(null))
					bodys.add(body);
				String number = cursor.getString(
						cursor.getColumnIndexOrThrow("address")).toString();
				if (!number.equals(null))
					numbers.add(number);
			} while (cursor.moveToNext());
		} else {
		}
	}

}
