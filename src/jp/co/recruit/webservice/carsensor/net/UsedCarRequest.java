package jp.co.recruit.webservice.carsensor.net;

import java.net.URISyntaxException;
import java.util.ArrayList;

import org.ngsdev.android.net.URLRequestParams;
import org.ngsdev.android.util.ArrayUtil;
import org.ngsdev.android.util.FieldUtil;

import android.content.Context;
import jp.co.recruit.webservice.net.RWSRequest;
import jp.co.recruit.webservice.carsensor.data.DatumType;
import jp.co.recruit.webservice.carsensor.data.MissionType;
import jp.co.recruit.webservice.carsensor.data.OrderBy;

public class UsedCarRequest extends RWSRequest {
	public static final String API_DIR = "/carsensor/usedcar/v1/";
	/**
	 * 物件ID
	 */
	public ArrayList<String> ids = null;
	/**
	 * ブランドコード
	 */
	public ArrayList<String> brandCodes = null;
	/**
	 * 車種名
	 */
	public String modelName = "";
	/**
	 * 国コード ( ブランドの代表国 )
	 */
	public ArrayList<String> countryCodes = null;
	/**
	 * 中古車店の所在エリア
	 */
	public ArrayList<String> largeAreaCodes = null;
	/**
	 * 中古車店の所在都道府県
	 */
	public ArrayList<String> prefectureCodes = null;
	/**
	 * ボディタイプコード
	 */
	public ArrayList<String> bodyTypeCodes = null;
	/**
	 * 定員
	 */
	public int person = 0;
	/**
	 * カラーコード
	 */
	public ArrayList<String> colorCodes = null;
	/**
	 * 最低価格
	 */
	public int priceMin = 0;
	/**
	 * 最高価格
	 */
	public int priceMax = 0;
	/**
	 * キーワード
	 */
	public String keyword = "";
	/**
	 * 緯度
	 */
	public double lat = Double.NaN;
	/**
	 * 経度
	 */
	public double lng = Double.NaN;
	/**
	 * 検索範囲
	 */
	public int range = 0;
	/**
	 * 検索範囲
	 */
	public DatumType datum = DatumType.WORLD;
	/**
	 * ミッション種類
	 */
	public MissionType mission = MissionType.NONE;

	/**
	 * 禁煙車
	 */
	public boolean nonSmoking = false;

	/**
	 * 本革シート
	 */
	public boolean leather = false;

	/**
	 * 福祉車両
	 */
	public boolean welfare = false;
	/**
	 * 登録年式(古い)
	 */
	public int yearOld = 0;
	/**
	 * 登録年式(新しい)
	 */
	public int yearNew = 0;
	/**
	 * 走行距離(最短)
	 */
	public int oddMin = 0;
	/**
	 * 走行距離(最長)
	 */
	public int oddMax = 0;
	/**
	 * ソート順
	 */
	public OrderBy order = OrderBy.BRAND;
	public UsedCarRequest(Context context) throws URISyntaxException {
		super(context, API_DIR);
	}

	public boolean useGeo() {
		return !Double.isNaN(this.lat) && !Double.isNaN(this.lng);
	}

	@Override
	public boolean send(RequestListener listener) {
		this.response = new UsedCarResponse();
		return super.send(listener);
	}

	@Override
	public URLRequestParams getURLRequestParams() {
		URLRequestParams params = super.getURLRequestParams();
		
		if (ArrayUtil.isArrayWithAnyItems(this.brandCodes))
			params.setParameter("brand", this.brandCodes);
		if (FieldUtil.isStringWithAnyText(this.modelName))
			params.setParameter("model", this.modelName);
		if (ArrayUtil.isArrayWithAnyItems(this.countryCodes))
			params.setParameter("country", this.countryCodes);
		if (ArrayUtil.isArrayWithAnyItems(this.largeAreaCodes))
			params.setParameter("large_area", this.largeAreaCodes);
		if (ArrayUtil.isArrayWithAnyItems(this.prefectureCodes))
			params.setParameter("pref", this.prefectureCodes);
		if (ArrayUtil.isArrayWithAnyItems(this.bodyTypeCodes))
			params.setParameter("body", this.bodyTypeCodes);
		if (this.person > 0)
			params.setIntParameter("person", person);
		if (ArrayUtil.isArrayWithAnyItems(this.colorCodes))
			params.setParameter("color", this.colorCodes);
		if (this.priceMin > 0)
			params.setIntParameter("price_min", this.priceMin);
		if (this.priceMax > 0)
			params.setIntParameter("price_max", this.priceMax);
		if (FieldUtil.isStringWithAnyText(this.keyword))
			params.setParameter("keyword", this.keyword);
		if (this.useGeo()) {
			params.setDoubleParameter("lat", this.lat);
			params.setDoubleParameter("lng", this.lng);
			params.setParameter("datum", this.datum.toString());
			params.setIntParameter("range", this.range > 1 ? this.range : 1);
		} else {
			params.setIntParameter("order", this.order.toInt());
		}
		if (this.mission != MissionType.NONE)
			params.setIntParameter("mission", this.mission.toInt());
		params.setFlagParameter("nonsmoking", this.nonSmoking);
		params.setFlagParameter("leather", this.leather);
		params.setFlagParameter("welfare", this.welfare);
		if (this.yearNew > 0)
			params.setIntParameter("year_new", this.yearNew);
		if (this.yearOld > 0)
			params.setIntParameter("year_old", this.yearOld);
		if (this.oddMin > 0)
			params.setIntParameter("odd_min", this.oddMin);
		if (this.oddMax > 0)
			params.setIntParameter("odd_max", this.oddMax);
		return params;
	}
}
