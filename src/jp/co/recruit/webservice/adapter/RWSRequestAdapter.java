package jp.co.recruit.webservice.adapter;

import java.util.ArrayList;

import jp.co.recruit.webservice.net.RWSRequest;
import jp.co.recruit.webservice.net.RWSResponse;
import jp.co.recruit.webservice.data.RWSItem;

import org.ngsdev.android.adapter.URLRequestAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
		RWSItem unspecifyItem = getUnspecifyItem();
		if (unspecifyItem != null) {
			this.total++;
			this.items.add(unspecifyItem);
		}
		for (RWSItem item : res.getItems()) {
			this.items.add(item);
		}
	}

	public RWSItem getUnspecifyItem() {
		if (this.getUnspecifyItemName() > 0) {
			RWSItem unspecifyItem = new RWSItem() {
				@Override
				public String detailUriFormat() {
					return null;
				}
			};
			unspecifyItem.name = this.getContext().getString(
					this.getUnspecifyItemName());
			return unspecifyItem;
		}
		return null;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = super.getView(position, convertView, parent);
		Item item = this.getItem(position);
		if (!URLRequestAdapter.ItemView.class.isInstance(item)
				&& TextView.class.isInstance(v)
				&& RWSItem.class.isInstance(item))
			((TextView) v).setText(((RWSItem) item).name);
		return v;
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

	public int getUnspecifyItemName() {
		return 0;
	}

	@Override
	public View getViewForItem(Item item) {
		return View.inflate(this.getContext(),
				jp.co.recruit.webservice.R.layout.simple_adapter_item, null);
	}

}
