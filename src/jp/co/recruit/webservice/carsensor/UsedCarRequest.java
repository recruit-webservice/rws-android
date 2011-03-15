package jp.co.recruit.webservice.carsensor;

import java.net.URISyntaxException;

import org.ngsdev.android.net.URLRequestParams;
import org.ngsdev.android.util.FieldUtil;

import android.content.Context;
import jp.co.recruit.webservice.net.RWSRequest;

public class UsedCarRequest extends RWSRequest {

	public static enum DatumType {
		WORLD, TOKYO
	};

	/**
	 * ミッション種類
	 */
	public static enum MissionType {
		NONE, AT, MT
	};
	/**
	 * ソート順
	 */
	public static enum OrderBy {
		/**
		 * ブランド順
		 */
		BRAND,
		/**
		 * 価格安い順
		 */
		PRICE_ASC,
		/**
		 * 価格高い順
		 */
		PRICE_DESC,
		/**
		 * 車種名順
		 */
		MODEL_NAME,
		/**
		 * 年式古い順
		 */
		YEAR_ASC,
		/**
		 * 年式新しい順
		 */
		YEAR_DESC,
		/**
		 * 走行距離少ない順
		 */
		ODD
	};
	public static final String API_DIR = "/carsensor/usedcar/v1/";
	/**
	 * 物件ID
	 */
	public String id = "";
	/**
	 * ブランドコード
	 */
	public String brandCode = "";
	/**
	 * 車種名
	 */
	public String modelName = "";
	/**
	 * 国コード ( ブランドの代表国 )
	 */
	public String countryCode = "";
	/**
	 * 中古車店の所在エリア
	 */
	public String largeAreaCode = "";
	/**
	 * 中古車店の所在都道府県
	 */
	public String prefectureCode = "";
	/**
	 * ボディタイプコード
	 */
	public String bodyCode = "";
	/**
	 * 定員
	 */
	public int person = 0;
	/**
	 * カラーコード
	 */
	public String colorCode = "";
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
	public UsedCarRequest(Context context) throws URISyntaxException {
		super(context, API_DIR);
	}

	public boolean useGeo() {
		return this.lat != Double.NaN && this.lng != Double.NaN;
	}

	@Override
	public URLRequestParams getURLRequestParams() {
		URLRequestParams params = super.getURLRequestParams();
		if (FieldUtil.isStringWithAnyText(this.brandCode))
			params.setParameter("brand", this.brandCode);
		if (FieldUtil.isStringWithAnyText(this.modelName))
			params.setParameter("model", this.modelName);
		if (FieldUtil.isStringWithAnyText(this.countryCode))
			params.setParameter("country", this.countryCode);
		if (FieldUtil.isStringWithAnyText(this.largeAreaCode))
			params.setParameter("large_area", this.largeAreaCode);
		if (FieldUtil.isStringWithAnyText(this.prefectureCode))
			params.setParameter("pref", this.prefectureCode);
		if (FieldUtil.isStringWithAnyText(this.bodyCode))
			params.setParameter("body", this.bodyCode);
		if (this.person > 0)
			params.setIntParameter("person", person);
		if (FieldUtil.isStringWithAnyText(this.colorCode))
			params.setParameter("color", this.colorCode);
		if (this.priceMin > 0)
			params.setIntParameter("price_min", this.priceMin);
		if (this.priceMax > 0)
			params.setIntParameter("price_max", this.priceMax);
		if (FieldUtil.isStringWithAnyText(this.keyword))
			params.setParameter("keyword", this.keyword);
		if (this.useGeo()) {
			params.setDoubleParameter("lat", this.lat);
			params.setDoubleParameter("lng", this.lng);
			params.setConditionParameter("datum",
					this.datum == DatumType.TOKYO, "tokyo", "world");
			params.setIntParameter("range", this.range > 1 ? this.range : 1);
		}
		if (this.mission != MissionType.NONE)
			params.setConditionParameter("mission",
					this.mission == MissionType.AT, "1", "2");
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
