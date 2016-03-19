package ir.markazandroid.secretsms;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import ir.markazandroid.adaptor.ListAdaptor;
import ir.markazandroid.adaptor.Messages;
import ir.markazandroid.sms.SMSrsr;

import java.util.ArrayList;

public class ListSms extends ListActivity implements OnItemClickListener,
		OnItemLongClickListener {

	ListAdapter adapter;
	Intent in;
	ArrayList<Messages> listMessage;
	ArrayList<String> messages;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SMSrsr.setCr(this.getContentResolver());
		SMSrsr.readInbox();
		listMessage = new ArrayList<Messages>();
		messages= new ArrayList<String>();
		// listNumbers = (String[])SMSrsr.numbers.toArray();
		// listMessage= (String[]) SMSrsr.bodys.toArray();

		for (int i = 0; i < SMSrsr.numbers.size(); i++) {
			listMessage.add(new Messages(SMSrsr.numbers.get(i),SMSrsr.bodys.get(i)));
		}
		adapter = new ListAdaptor(this,listMessage);
		setListAdapter(adapter);
		ListView listView = getListView();
		listView.setOnItemClickListener(this);
		listView.setOnItemLongClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View arg1, int position,
			long arg3) {
		// TODO Auto-generated method stub
		Messages item = (Messages)parent.getItemAtPosition(position);

				Message.setNumber(item.getNumber());
				Message.setMessage(item.getMassages(0));
				in = new Intent(this, Message.class);
				startActivity(in);

	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View arg1,
			int position, long arg3) {
		// TODO Auto-generated method stub
		String item = parent.getItemAtPosition(position).toString();
		Toast.makeText(this, "OnItemLongClick:" + item, Toast.LENGTH_SHORT)
				.show();
		return false;
	}
}
