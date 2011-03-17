package jp.co.recruit.webservice.layout;

import jp.co.recruit.webservice.data.RWSItem;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import org.ngsdev.android.adapter.URLRequestAdapter;
import org.ngsdev.android.adapter.URLRequestAdapter.Item;

public class SimpleAdapterItem extends TextView
		implements
			URLRequestAdapter.ItemView {

	public SimpleAdapterItem(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public SimpleAdapterItem(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public SimpleAdapterItem(Context context) {
		super(context);
	}

	public void setItem(Item item) {
		if (RWSItem.class.isInstance(item))
			this.setText(((RWSItem) item).name);
	}

}
