package ir.markazandroid.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SmsHelper extends SQLiteOpenHelper {
	
	public SmsHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

	// TABLE
	public static final String TABLE_SMS = "SMS";
	public static final String COLUMN_ID = "_ID";
	public static final String COLUMN_NAME = "NAME";
	public static final String COLUMN_MUMBER = "MUMBER";
	public static final String COLUMN_DATE = "DATE";
	public static final String COLUMN_SEND = "SEND";
	public static final String COLUMN_RECIVE = "RECIVE";
	public static final String COLUMN_DRAFT = "DERAFT";
	public static final String COLUMN_DELIVERD = "DELIVERD";

	// DATABASE
	private static final String DB_NAME = "sms.db";
	private static final int DB_VERSION = 1;
	private static final String DB_CREATE = "CREATE TABLE " + TABLE_SMS + " ("
			+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME
			+ " TEXT, " + COLUMN_MUMBER + " TEXT, " + COLUMN_DATE + " TEXT, "
			+ COLUMN_SEND + " TEXT, " + COLUMN_RECIVE + " TEXT, "
			+ COLUMN_DRAFT + " TEXT, " + COLUMN_DELIVERD + " TEXT )";

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DB_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	}
}
