package jp.co.recruit.webservice.adapter;

import java.util.ArrayList;

import jp.co.recruit.webservice.net.RWSRequest;
import jp.co.recruit.webservice.net.RWSResponse;
import jp.co.recruit.webservice.data.RWSItem;

import org.ngsdev.android.adapter.URLRequestAdapter;

import android.content.Context;
import android.view.View;

public class RWSRequestAdapter extends URLRequestAdapter {

	private ArrayList<RWSItem> items;
	private int start;
	private int total;

	public RWSRequestAdapter(Context c, RWSRequest request) {
		super(c, request);
	}

	@Override
	public void createDataSource() {
		RWSRequest req = (RWSRequest) this.getRequest();
		RWSResponse res = (RWSResponse) req.response;
		this.total = res.getTotal();
		for (RWSItem item : res.getItems()) {
			this.items.add(item);
		}
	}

	@Override
	public ArrayList<? extends Item> getItems() {
		return items;
	}

	@Override
	public boolean load(boolean more) {
		RWSRequest req = (RWSRequest) this.getRequest();
		if (more) {
			start += this.getCountPerRequest();
			req.start = start;
		} else {
			items = new ArrayList<RWSItem>();
			start = 1;
		}
		return super.load(more);
	}

	@Override
	public int getTotal() {
		return total;
	}

	@Override
	public View getViewForItem(Item item) {
		return null;
	}

}
