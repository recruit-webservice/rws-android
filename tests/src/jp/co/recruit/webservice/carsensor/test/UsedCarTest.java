package jp.co.recruit.webservice.carsensor.test;

import jp.co.recruit.webservice.carsensor.net.UsedCarRequest;
import jp.co.recruit.webservice.carsensor.net.UsedCarResponse;
import jp.co.recruit.webservice.carsensor.data.DatumType;
import jp.co.recruit.webservice.carsensor.data.MissionType;
import jp.co.recruit.webservice.carsensor.data.OrderBy;
import jp.co.recruit.webservice.carsensor.data.UsedCar;
import jp.co.recruit.webservice.net.RWSRequest;

import java.net.URISyntaxException;
import java.util.ArrayList;

import org.ngsdev.android.util.FileUtil;
import org.ngsdev.android.util.Log20;

import android.test.InstrumentationTestCase;

public class UsedCarTest extends InstrumentationTestCase {
	private static final String TAG = "UsedCarTest";

	protected void setUp() throws Exception {
		Log20.enable = true;
		Log20.Tag = TAG;
		RWSRequest.defaultApiKey = "2e9f07a047728523";
	}

	public void testRequest() throws URISyntaxException {
		UsedCarRequest req = new UsedCarRequest(this.getInstrumentation()
				.getContext());
		String qstr = null;
		//
		assertFalse(req.useGeo());
		req.lat = 35.669220;
		req.lng = 139.761457;
		req.datum = DatumType.TOKYO;
		req.order = OrderBy.PRICE_ASC;
		qstr = req.getURLRequestParams().toQueryString();
		assertTrue(req.useGeo());
		assertTrue(qstr.contains("lat=35.66922&"));
		assertTrue(qstr.contains("lng=139.761457&"));
		assertTrue(qstr.contains("datum=tokyo&"));
		assertTrue(qstr.contains("range=1&"));
		assertFalse(qstr.contains("order="));
		//
		req = new UsedCarRequest(this.getInstrumentation().getContext());
		req.start = 2;
		req.count = 10;
		req.mission = MissionType.MT;
		req.order = OrderBy.PRICE_DESC;
		req.bodyTypeCodes = new ArrayList<String>();
		req.bodyTypeCodes.add("C");
		req.bodyTypeCodes.add("S");
		req.countryCodes = new ArrayList<String>();
		req.countryCodes.add("JPN");
		req.countryCodes.add("GBR");
		req.modelName = "インプレッサ";
		req.keyword = "きれい\\\\&&&";
		req.prefectureCodes = new ArrayList<String>();
		req.prefectureCodes.add("1");
		req.prefectureCodes.add("13");
		req.person = 5;
		req.yearNew = 2001;
		req.yearOld = 1998;
		req.priceMin = 100000;
		req.priceMax = 1900000;
		req.oddMin = 150000;
		req.oddMax = 200000;
		req.nonSmoking = true;
		req.leather = true;
		req.welfare = true;
		qstr = req.getURLRequestParams().toQueryString();
		assertFalse(qstr.contains("datum="));
		assertFalse(qstr.contains("range="));
		assertTrue(qstr.contains("mission=2&"));
		assertTrue(qstr.contains("order=2&"));
		assertTrue(qstr.contains("start=2&"));
		assertTrue(qstr.contains("count=10&"));
		assertTrue(qstr.contains("body=C%2CS&"));
		assertTrue(qstr.contains("country=JPN%2CGBR&"));
		assertTrue(qstr.contains("model=%E3%82%A4%E3%83%B3%E3%83%97%E3%83%AC%E3%83%83%E3%82%B5&"));
		assertTrue(qstr.contains("keyword=%E3%81%8D%E3%82%8C%E3%81%84%5C%5C%26%26%26&"));
		assertTrue(qstr.contains("pref=1%2C13&"));
		assertTrue(qstr.contains("person=5&"));
		assertTrue(qstr.contains("year_new=2001&"));
		assertTrue(qstr.contains("year_old=1998&"));
		assertTrue(qstr.contains("price_min=100000&"));
		assertTrue(qstr.contains("price_max=1900000&"));
		assertTrue(qstr.contains("odd_min=150000&"));
		assertTrue(qstr.contains("odd_max=200000&"));
		assertTrue(qstr.contains("nonsmoking=1&"));
		assertTrue(qstr.contains("leather=1&"));
		assertTrue(qstr.contains("welfare=1&"));
		Log20.d(qstr);
	}

	public void testResponse() throws Exception {
		UsedCarResponse res = new UsedCarResponse();
		res.processResponse(FileUtil.getBytesFromAssetName(this
				.getInstrumentation().getContext(),
				"carsensor_usedcar_test1.json"));
		assertEquals(res.getCount(), 50);
		assertEquals(res.getTotal(), 787);
		assertEquals(res.getStart(), 11);
		assertEquals(res.getApiVersion(), "1.01");
		//
		UsedCar car = null;
		car = (UsedCar) res.getItems().get(0);
		assertNotNull(car);
		assertEquals(car.code, "CU0320776360");
		assertEquals(car.model, "ミト");
		assertEquals(car.grade, "クアドリフォリオ ヴェルデ");
		assertEquals(car.brand.code, "AF");
		assertEquals(car.brand.name, "アルファ　ロメオ");
		assertEquals(car.mobileURL,
				"http://mob.carsensor.net/c/ld.cgi?EK=59&BK=CU0320776360&vos=csr145");
		assertEquals(
				car.pcURL,
				"http://www.carsensor.net/usedcar/detail.php?STID=CS210840&BKKN=CU0320776360&vos=ncsrapis00001");
		assertEquals(
				car.qrCodeURL,
				"http://webservice.recruit.co.jp/common/qr?url=http%3A%2F%2Fmob.carsensor.net%2Fc%2Fld.cgi%3FEK%3D59%26BK%3DCU0320776360%26vos%3Dcsr146");
		assertEquals(car.bodyType.name, "ハッチバック");
		assertEquals(car.bodyType.code, "D");
		assertEquals(car.color, "パステルブラック");
		assertEquals(car.description,
				"☆試乗車ございます。一味違うクワドリフォリオヴェルデをご堪能下さい☆左ハンドル即納車ございます。");
		assertEquals(car.maintenance, "法定整備付");
		assertEquals(car.subPhotos.size(), 7);
		assertEquals(
				car.mainPhoto.largeURL,
				"http://www.carsensor.net/CSphoto/bkkn/362/879/U00005362879/U00005362879_001L.JPG");
		assertEquals(
				car.mainPhoto.smallURL,
				"http://www.carsensor.net/CSphoto/bkkn/362/879/U00005362879/U00005362879_001S.JPG");
		assertEquals(car.mainPhoto.caption, "車の写真");
		assertEquals(car.recycle, "リ未");
		assertEquals(car.engine, "ガソリン");
		assertEquals(car.odd, "20km");
		assertEquals(car.price, 3280000);
		assertEquals(car.inspection, "新車未登録");
		assertEquals(car.year, 2012);
		assertEquals(car.warranty, "保証付");
		//
		car = (UsedCar) res.getItems().get(1);
		assertNotNull(car);
		assertEquals(car.price, -1);
		assertEquals(car.priceMessage, "応談");
	}

}
