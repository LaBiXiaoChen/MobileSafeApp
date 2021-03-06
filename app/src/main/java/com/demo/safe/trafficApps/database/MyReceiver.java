
package com.demo.safe.trafficApps.database;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.TrafficStats;
import android.util.Log;

import com.demo.safe.trafficApps.activity.Showmain;


/**
 *
 */
public class MyReceiver extends BroadcastReceiver {

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.content.BroadcastReceiver#onReceive(android.content.Context,
	 * android.content.Intent)
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		DataSupport minsert = new DataSupport(context);
		long g3_down_total = TrafficStats.getMobileRxBytes(); // 获取通过Mobile连接收到的字节总数，这里Android123提示大家不包含WiFi
		long g3_up_total = TrafficStats.getMobileTxBytes(); // Mobile发送的总字节数
		long mrdown_total = TrafficStats.getTotalRxBytes(); // 获取总的接受字节数，包含Mobile和WiFi等
		long mtup_total = TrafficStats.getTotalTxBytes(); // 总的发送字节数，包含Mobile和WiFi等

		minsert.insertNow(g3_down_total, Showmain.RXG, Showmain.RX3G,
				Showmain.SHUTDOWN);
		minsert.insertNow(g3_up_total, Showmain.TXG, Showmain.TX3G,
				Showmain.SHUTDOWN);
		minsert.insertNow(mrdown_total, Showmain.RX, Showmain.RXT,
				Showmain.SHUTDOWN);
		minsert.insertNow(mtup_total, Showmain.TX, Showmain.TXT,
				Showmain.SHUTDOWN);
		if (Showmain.isLog) {
			Log.i("liuliang", "shutdown>>>>>>>>>start");
		}
	}

}

