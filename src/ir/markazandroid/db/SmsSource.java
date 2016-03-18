package ir.markazandroid.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SmsSource {

	private SQLiteDatabase mDatabase;
	private SmsHelper mSmsHelper;
	private Context mContext;

	public SmsSource(Context context) {
		mContext = context;
		mSmsHelper=new SmsHelper(mContext);
	}
	
    public void open() throws SQLException {
        mDatabase = mSmsHelper.getWritableDatabase();
    }

    public void close() {
        mDatabase.close();
    }
    
	//insert
	
	//select
	
	//update
	
	//delete
	
}
