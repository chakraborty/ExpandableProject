package com.icddrb.app.demographicses.questions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ViewFlipper;
import com.icddrb.app.demographicses.R;
import com.icddrb.app.demographicses.BaseActivity;
import com.icddrb.app.demographicses.CommonStaticClass;
import com.icddrb.app.demographicses.Options;
import com.icddrb.app.demographicses.Search.SearchLayout;
import com.icddrb.app.demographicses.Viewall.Viewall;
import com.icddrb.app.demographicses.adapters.SpinAdapter;

public class ParentActivity extends BaseActivity implements FormListener {

	//
	static ParentActivity thisactivity;

	// frmaddress part
	private EditText txtHoldingNo, txtPara, txtVillage, txtunion, txtupazila,
			txtDistrict, txtPhone1, txtPhone2;
	private TextView qqq, lblHoldingNo, lblPara, lblVillage, lblUnion,
			lblUpazilla, lblDistrict, lblPhone1, lblPhone2;
	private String resHHno, resPara, resVillage, resUnion, resUpazilla,
			resDistrict, resPhone1, resPhone2;
	private Button btnPrev, btnNext, btnClear, notesButton;
	private String qName = "";
	static Typeface font;

	// frmmultiplechecktext
	private EditText editText1, editText2, editText3, editText4;
	private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5,
			checkBox6;
	// frmcombobox part
	private Button prevButton, saveNxtButton, clButton;
	private LinearLayout checkBoxHolder;
	private Options op;
	ArrayList<String> users = new ArrayList<String>();
	ArrayList<String> userIDs = new ArrayList<String>();
	ArrayAdapter adapterForCombo, adapterForCombo2, adapterForCombo3;
	private String sResCode = "";

	// frmdate part
	private EditText pickDate;
	static final int DATE_DIALOG = 1, DOB_DIALOG = 4;
	private int dateYear;
	private int dateMonth;
	private int dateDay;

	private int dobYear;
	private int dobMonth;
	private int dobDay;

	// frmfamilymember part

	private TextView lblSL;

	private Button btnsaveNxt;

	private Spinner spinnerSL, spinnerSex, spinnermedicine, spinnercategory,
			spinneritem;
	private String sex = "";
	String mydata = "";
	private Options opSex;
	boolean insertMore = false;
	boolean IsFirstTime = true;
	private ArrayList<String> memberIDs, medicineIDs;
	private ArrayAdapter adapterSl, adapterSex, adaptercategory, adapteritem;
	private String memberID;
	// frmgpsdatacollection part
	protected LocationManager locationManager;
	protected Button getGPSDataButton;
	protected EditText txtLongitute, txtLatitue;

	// frmhhid part
	static final int DATE_DIALOG_ID = 3;
	private int mYear;
	private int mMonth;
	private int mDay;
	private String hospital = "", ward = "";

	private ArrayAdapter adapterHospital, adapterWard;

	ArrayList<String> wardList = new ArrayList<String>();
	ArrayList<String> hospitalList = new ArrayList<String>();

	EditText etyearmonth, etpid;

	private EditText txtschoolID, txtID, txtschoolIDRe, txtIDRe;
	private String schoolid = "", id = "", schoolidre = "", idre = "";
	private ProgressDialog progressDialog;
	private static final int UPDATEDONE = 900, FILEREADFAILED = 1000,
			FILECONTENTMISSING = 1100;
	private String line = "";
	private Button genButton, confButton;
	// frommessage part

	// frmmultiplecheckcombo
	private ArrayList<String> optionList1 = null, optionList2 = null,
			optionList3 = null;
	private ArrayList<Integer> optionCodeList1 = null, optionCodeList2 = null,
			optionCodeList3 = null;
	DisplayMetrics dm;
	private ArrayList<Integer> aaa = new ArrayList<Integer>();

	private ArrayList<String> listvalues = new ArrayList<String>();

	private boolean spinnerOK = true;
	// frmmultiplechoice
	private LinkedHashMap<Integer, EditText> edList = new LinkedHashMap<Integer, EditText>();

	// frmmultiplecombo
	private LinearLayout LinearLayout1, LinearLayout2, LinearLayout3;
	private TextView lbl1st, lbl2nd, lbl3rd;
	private Spinner spinner1st, spinner2nd, spinner3rd;
	private String res1st = "", res2nd = "", res3rd = "", res1stother = "",
			res2ndother = "", res3rdother = "";
	private Options op1st, op2nd, op3rd;
	private ArrayAdapter adapter1st, adapter2nd, adapter3rd;
	private boolean IsMismatch_1_1_8 = false;
	private boolean IsMismatch_1_1_9 = false;
	private boolean IsFirstTime1 = true;
	private boolean IsFirstTime2 = true;
	private boolean IsFirstTime3 = true;

	private boolean IsVisited1st = true;
	private boolean IsVisited2nd = true;
	private boolean IsVisited3rd = true;

	private boolean ShouldSkipfor1st = true;
	private boolean ShouldSkipfor2nd = true;
	private boolean ShouldSkipfor3rd = true;

	// frmnotes
	private EditText infoText;
	private Button btnCancel, btnSave;

	// frmnumeric

	// frmnumericTwo
	private TextView num1, num2;
	private EditText infoText1, infoText2;
	private String qName1, qName2;
	private Calendar dsDate = Calendar.getInstance();
	// frmreasoning
	private TextView lbla, lblb, lblc, lbld, lble, lblf, lblg, lblh, lbli,
			lblj;
	private CheckBox chka1, chka2, chka3, chkb1, chkb2, chkb3, chkc1, chkc2,
			chkc3, chkd1, chkd2, chkd3, chke1, chke2, chke3, chkf1, chkf2,
			chkf3, chkg1, chkg2, chkg3, chkh1, chkh2, chkh3, chki1, chki2,
			chki3, chkj1, chkj2, chkj3;
	private int a1 = 0, a2 = 0, a3 = 0, b1 = 0, b2 = 0, b3 = 0, c1 = 0, c2 = 0,
			c3 = 0, d1 = 0, d2 = 0, d3 = 0, e1 = 0, e2 = 0, e3 = 0, f1 = 0,
			f2 = 0, f3 = 0, g1 = 0, g2 = 0, g3 = 0, h1 = 0, h2 = 0, h3 = 0,
			i1 = 0, i2 = 0, i3 = 0, j1 = 0, j2 = 0, j3 = 0;
	private String other1 = "", other2 = "", other3 = "";
	// frmsinglechoice
	private RadioGroup mRadioGroup;
	int code, qWhen;
	String nextToGo;
	private int idIfEdit = -1;
	// frmtime
	private EditText pickTime;
	static final int TIME_DIALOG = 2;

	private int TimeHour;
	private int TimeMinute;

	// fromyeartomin
	private EditText yearBox, monthBox, weekBox, dayBox, hourBox, minBox;
	private TextView yearText, monthText, weekText, dayText, hourText, minText;
	private LinearLayout yearHolder, monthHolder, weekHolder, dayHolder,
			hourHolder, minHolder;
	private String year = "", month = "", week = "", day = "", hour = "",
			min = "";

	// frmNumeric_with_unknown_decline
	RadioGroup radioGroup;
	RadioButton radio1, radio2;

	// this activity part
	private ViewFlipper formFlipper;
	private Context con;
	private ViewGroup frmdataid, frmcombobox, frmdate, frmfamilymember,
			frmhhid, frmmessage, frmmultiplecheckcombo, frmmultiplechoice,
			frmmultiplecombo, frmnotes, frmnumeric, frmnumericoption,
			frmreasoning, frmsinglechoice, frmtext, frmtime, frmyeartomin,
			gpsdatacollection, frmnumerictwo, frmnumericwithunknowndecline,
			frmcomboswitheditspiner, frmmultiplecheckcombotwo,
			frmmultiplechoiceradio, frmmultiple, frmq124,
			frmmultiplechecknumeric, frmmultiplecheckdate, frmpatientdetail,
			frmweight, frmdiarrhea, frmvomiting, frmors, frmchildren,
			frmhouseholdfoodconsumption, frmmultiplechecktexttwo, frmlandused,
			frmcropproduction, frmfishproduction, frmcropfishproductioncost,
			frmcropcultivationreserve, frmwatermanagementproblem,
			frmproductionmarketinglivestock, frmlivestockproducts,
			frmvulnarable;

	private int lastIndexBeforeFraNotes;
	private TextView dataidViewer;

	// Multiple check combo two
	private ArrayList<Integer> aaachecklist = new ArrayList<Integer>();
	private ArrayList<String> mEditStrings = new ArrayList<String>();
	private ArrayList<String> mEditStrings2 = new ArrayList<String>();
	private ArrayList<String> mEditStrings3 = new ArrayList<String>();

	private ArrayList<Integer> aaa1 = new ArrayList<Integer>();
	private ArrayList<Integer> aaa2 = new ArrayList<Integer>();
	private ArrayList<Integer> aaa3 = new ArrayList<Integer>();
	// frmMultiple
	private String chk1_1 = "2", chk2_1 = "2", chk2_2 = "2", chk2_3 = "2",
			chk2_4 = "2", chk2_5 = "2", et2_5_other = "", chk3_1 = "2",
			chk3_2 = "2", chk3_3 = "2", et3_3_other = "", chk4_1 = "2",
			chk4_2 = "2", chk5_1 = "2", chk5_2 = "2", chk5_3 = "2",
			chk5_4 = "2", chk5_5 = "2", et5_5_other = "", chk6_1 = "2",
			chk6_2 = "2", chk7_1 = "2", chk7_2 = "2", chk7_3 = "2",
			chk7_4 = "2", chk7_5 = "2", chk7_6 = "2", chk7_7 = "2",
			et7_6_other = "", chk8_1 = "2", chk8_2 = "2", chk8_3 = "2",
			chk8_4 = "2", chk8_5 = "2", chk8_6 = "2", et8_6_other = "",
			chk9_1 = "2", chk9_2 = "2", chk9_3 = "2", chk10_1 = "2",
			chk11_1 = "2", chk12_1 = "2", chk12_2 = "2", chk12_3 = "2",
			et12_3_other = "", chk13_1 = "2", chk13_2 = "2", chk13_3 = "2",
			chk13_4 = "2", chk13_5 = "2", chk13_6 = "2", chk13_7 = "2",
			et13_7_other = "", chk14_1 = "2", chk14_2 = "2", chk14_3 = "2",
			et14_3_other = "", chk15_1 = "2", chk15_2 = "2", chk15_3 = "2",
			chk16_1 = "2", chk16_2 = "2", chk16_3 = "2", chk16_4 = "2",
			chk16_5 = "2", chk17_1 = "2", chk17_2 = "2", chk17_3 = "2",
			chk17_4 = "2", chk18_1 = "2", chk18_2 = "2", et19_1 = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parentlayout);
		thisactivity = this;
		con = this;
		dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);

		font = Typeface.createFromAsset(getAssets(), "Siyam Rupali ANSI.ttf");

		loadParentUI();
		this.gotoForm(CommonStaticClass.questionMap.get(
				CommonStaticClass.currentSLNo).getFormname());
		// motion();
	}

	private String q4_a2 = "";
	private String q4_b2 = "";
	private String q4_c2 = "";
	private String q4_d2 = "";
	private String q4_e2 = "";
	private String q4_f2 = "";
	private String q4_g2 = "";
	private String q4_h2 = "";
	private String q4_i2 = "";
	private String q4_j2 = "";
	private String q4_k2 = "";
	private String q4_l2 = "";
	private String q4_m2 = "";
	private String q4_n2 = "";
	private String q4_o2 = "";
	private String q4_p2 = "";
	private String q4_q2 = "";
	private String q4_r2 = "";
	private String q4_s2 = "";
	private String q4_t2 = "";

	private void populateSpinnerListFrmCombosWithEditSpinner(Options op, int l,
			ArrayList<String> list, ArrayList<Integer> ll) {
		for (int i = 0; i < op.qidList.size(); i++) {
			if (l == 1 && op.qidList.get(i).contains("1_1")) {
				if (CommonStaticClass.langBng) {
					list.add(op.capBngList.get(i));
				} else {
					list.add(op.capEngList.get(i));
				}
				ll.add(op.codeList.get(i));
			} else if (l == 3 && op.qidList.get(i).contains("1_2")) {
				if (CommonStaticClass.langBng) {
					list.add(op.capBngList.get(i));
				} else {
					list.add(op.capEngList.get(i));
				}
				ll.add(op.codeList.get(i));
			}
		}
	}

	private boolean CheckColumnThreeForQuestionNo4_2() {

		if (!q4_a2.equalsIgnoreCase("-1") && q4_a2.length() > 0) {
			if (q4_a2.equalsIgnoreCase("1") || q4_a2.equalsIgnoreCase("2")) {
			} else {
				Toast.makeText(con, "Value on third Column Should be 1 OR 2",
						10000).show();
				return false;
			}
		}
		if (!q4_b2.equalsIgnoreCase("-1") && q4_b2.length() > 0) {
			if (q4_b2.equalsIgnoreCase("1") || q4_b2.equalsIgnoreCase("2")) {
			} else {
				Toast.makeText(con, "Value on third Column Should be 1 OR 2",
						10000).show();
				return false;
			}
		}
		if (!q4_c2.equalsIgnoreCase("-1") && q4_c2.length() > 0) {
			if (q4_c2.equalsIgnoreCase("1") || q4_c2.equalsIgnoreCase("2")) {
			} else {
				Toast.makeText(con, "Value on third Column Should be 1 OR 2",
						10000).show();
				return false;
			}
		}
		if (!q4_d2.equalsIgnoreCase("-1") && q4_d2.length() > 0) {
			if (q4_d2.equalsIgnoreCase("1") || q4_d2.equalsIgnoreCase("2")) {
			} else {
				Toast.makeText(con, "Value on third Column Should be 1 OR 2",
						10000).show();
				return false;
			}
		}
		if (!q4_e2.equalsIgnoreCase("-1") && q4_e2.length() > 0) {
			if (q4_e2.equalsIgnoreCase("1") || q4_e2.equalsIgnoreCase("2")) {
			} else {
				Toast.makeText(con, "Value on third Column Should be 1 OR 2",
						10000).show();
				return false;
			}
		}
		if (!q4_f2.equalsIgnoreCase("-1") && q4_f2.length() > 0) {
			if (q4_f2.equalsIgnoreCase("1") || q4_f2.equalsIgnoreCase("2")) {
			} else {
				Toast.makeText(con, "Value on third Column Should be 1 OR 2",
						10000).show();
				return false;
			}
		}
		if (!q4_g2.equalsIgnoreCase("-1") && q4_g2.length() > 0) {
			if (q4_g2.equalsIgnoreCase("1") || q4_g2.equalsIgnoreCase("2")) {
			} else {
				Toast.makeText(con, "Value on third Column Should be 1 OR 2",
						10000).show();
				return false;
			}
		}
		if (!q4_h2.equalsIgnoreCase("-1") && q4_h2.length() > 0) {
			if (q4_h2.equalsIgnoreCase("1") || q4_h2.equalsIgnoreCase("2")) {
			} else {
				Toast.makeText(con, "Value on third Column Should be 1 OR 2",
						10000).show();
				return false;
			}
		}
		if (!q4_i2.equalsIgnoreCase("-1") && q4_i2.length() > 0) {
			if (q4_i2.equalsIgnoreCase("1") || q4_i2.equalsIgnoreCase("2")) {
			} else {
				Toast.makeText(con, "Value on third Column Should be 1 OR 2",
						10000).show();
				return false;
			}
		}
		if (!q4_j2.equalsIgnoreCase("-1") && q4_j2.length() > 0) {
			if (q4_j2.equalsIgnoreCase("1") || q4_j2.equalsIgnoreCase("2")) {
			} else {
				Toast.makeText(con, "Value on third Column Should be 1 OR 2",
						10000).show();
				return false;
			}
		}
		if (!q4_k2.equalsIgnoreCase("-1") && q4_k2.length() > 0) {
			if (q4_k2.equalsIgnoreCase("1") || q4_k2.equalsIgnoreCase("2")) {
			} else {
				Toast.makeText(con, "Value on third Column Should be 1 OR 2",
						10000).show();
				return false;
			}
		}
		if (!q4_l2.equalsIgnoreCase("-1") && q4_l2.length() > 0) {
			if (q4_l2.equalsIgnoreCase("1") || q4_l2.equalsIgnoreCase("2")) {
			} else {
				Toast.makeText(con, "Value on third Column Should be 1 OR 2",
						10000).show();
				return false;
			}
		}
		if (!q4_m2.equalsIgnoreCase("-1") && q4_m2.length() > 0) {
			if (q4_m2.equalsIgnoreCase("1") || q4_m2.equalsIgnoreCase("2")) {
			} else {
				Toast.makeText(con, "Value on third Column Should be 1 OR 2",
						10000).show();
				return false;
			}
		}
		if (!q4_n2.equalsIgnoreCase("-1") && q4_n2.length() > 0) {
			if (q4_n2.equalsIgnoreCase("1") || q4_n2.equalsIgnoreCase("2")) {
			} else {
				Toast.makeText(con, "Value on third Column Should be 1 OR 2",
						10000).show();
				return false;
			}
		}
		if (!q4_o2.equalsIgnoreCase("-1") && q4_o2.length() > 0) {
			if (q4_o2.equalsIgnoreCase("1") || q4_o2.equalsIgnoreCase("2")) {
			} else {
				Toast.makeText(con, "Value on third Column Should be 1 OR 2",
						10000).show();
				return false;
			}
		}
		if (!q4_p2.equalsIgnoreCase("-1") && q4_p2.length() > 0) {
			if (q4_p2.equalsIgnoreCase("1") || q4_p2.equalsIgnoreCase("2")) {
			} else {
				Toast.makeText(con, "Value on third Column Should be 1 OR 2",
						10000).show();
				return false;
			}
		}
		if (!q4_q2.equalsIgnoreCase("-1") && q4_q2.length() > 0) {
			if (q4_q2.equalsIgnoreCase("1") || q4_q2.equalsIgnoreCase("2")) {
			} else {
				Toast.makeText(con, "Value on third Column Should be 1 OR 2",
						10000).show();
				return false;
			}
		}
		if (!q4_r2.equalsIgnoreCase("-1") && q4_r2.length() > 0) {
			if (q4_r2.equalsIgnoreCase("1") || q4_r2.equalsIgnoreCase("2")) {
			} else {
				Toast.makeText(con, "Value on third Column Should be 1 OR 2",
						10000).show();
				return false;
			}
		}
		if (!q4_s2.equalsIgnoreCase("-1") && q4_s2.length() > 0) {
			if (q4_s2.equalsIgnoreCase("1") || q4_s2.equalsIgnoreCase("2")) {
			} else {
				Toast.makeText(con, "Value on third Column Should be 1 OR 2",
						10000).show();
				return false;
			}

		}
		if (!q4_t2.equalsIgnoreCase("-1") && q4_t2.length() > 0) {
			if (q4_t2.equalsIgnoreCase("1") || q4_t2.equalsIgnoreCase("2")) {
			} else {
				Toast.makeText(con, "Value on third Column Should be 1 OR 2",
						10000).show();
				return false;
			}
		}

		/*
		 * , q4_b3, q4_c3, q4_d3, q4_e3, q4_f3, q4_g3, q4_h3, q4_i3, q4_j3,
		 * q4_k3, q4_l3, q4_m3, q4_n3, q4_o3, q4_p3, q4_q3, q4_r3, q4_s3, q4_t3)
		 */
		return true;
	}

	private boolean FileRead() {
		InputStream instream = null;

		try {
			String path = "/mnt/sdcard/Android/AssetID.txt";
			Log.e("path", "" + path);
			File f = new File(path);
			instream = new FileInputStream(f);// openFileInput("/mnt/sdcard/Android/AssetID.txt");

			// if file the available for reading
			if (instream != null) {
				// prepare the file for reading
				InputStreamReader inputreader = new InputStreamReader(instream);
				BufferedReader buffreader = new BufferedReader(inputreader);

				// read every line of the file into the line-variable, on line
				// at the time
				line = buffreader.readLine();
				Log.e("line", "" + line);
				if (line == null || !(line.length() > 1)) {

					Message msg = new Message();
					msg.what = FILECONTENTMISSING;
					handler.sendMessage(msg);
					return false;
				} else {
					CommonStaticClass.AssetID = line;
					return true;
				}
				// runOnUiThread(new Runnable() {
				//
				// public void run() {
				// // TODO Auto-generated method stub
				// Toast.makeText(con, line, 10000);
				// }
				// });

				// while (buffreader.readLine() != null) {
				// do something with the settings from the file
			}

			// close the file again

		} catch (Exception ex) {
			ex.printStackTrace();
			Message msg = new Message();
			msg.what = FILEREADFAILED;
			handler.sendMessage(msg);
			return false;
		} finally {
			if (instream != null) {
				try {
					instream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	// End Angsuman
	public boolean onCreateOptionsMenu(final Menu menu) {
		final MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.lang_menu, menu);
		return true;
	}

	public boolean onOptionsItemSelected(final MenuItem item) {
		switch (item.getItemId()) {

		case R.id.BNGMenuItem:
			CommonStaticClass.langBng = true;
			this.gotoForm(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getFormname());
			return true;
		case R.id.ENGMenuItem:
			CommonStaticClass.langBng = false;
			this.gotoForm(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getFormname());
			return true;

			/*
			 * case R.id.search: CommonStaticClass.mode = ""; Intent int_b = new
			 * Intent(getApplicationContext(), SearchLayout.class);
			 * startActivity(int_b); return true;
			 */

		case R.id.GotoHomeItem:
			CommonStaticClass.mode = "";
			finish();
			return true;

			/*
			 * case R.id.viewall:
			 * 
			 * CommonStaticClass.mode = ""; int_b = new
			 * Intent(getApplicationContext(), Viewall.class);
			 * startActivity(int_b); return true;
			 */

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void loadParentUI() {
		// TODO Auto-generated method stub
		dataidViewer = (TextView) findViewById(R.id.dataidViewer);
		formFlipper = (ViewFlipper) findViewById(R.id.formFlipper);

		frmdataid = (ViewGroup) findViewById(R.id.frmdataid);

		// (ViewGroup) findViewById(R.id.frmchoiceone);
		frmcombobox = (ViewGroup) findViewById(R.id.frmcombobox);

		frmdate = (ViewGroup) findViewById(R.id.frmdate);
		frmfamilymember = (ViewGroup) findViewById(R.id.frmfamilymember);
		frmhhid = (ViewGroup) findViewById(R.id.frmhhid);
		frmmessage = (ViewGroup) findViewById(R.id.frmmessage);

		frmmultiplecheckcombo = (ViewGroup) findViewById(R.id.frmmultiplecheckcombo);
		frmmultiplechoice = (ViewGroup) findViewById(R.id.frmmultiplechoice);
		frmmultiplecombo = (ViewGroup) findViewById(R.id.frmmultiplecombo);

		frmnotes = (ViewGroup) findViewById(R.id.frmnotes);
		frmnumeric = (ViewGroup) findViewById(R.id.frmnumeric);
		frmnumericoption = (ViewGroup) findViewById(R.id.frmnumericoption);

		frmreasoning = (ViewGroup) findViewById(R.id.frmreasoning);
		frmsinglechoice = (ViewGroup) findViewById(R.id.frmsinglechoice);
		frmtext = (ViewGroup) findViewById(R.id.frmtext);

		frmtime = (ViewGroup) findViewById(R.id.frmtime);
		frmyeartomin = (ViewGroup) findViewById(R.id.frmyeartomin);
		gpsdatacollection = (ViewGroup) findViewById(R.id.gpsdatacollection);
		frmnumerictwo = (ViewGroup) findViewById(R.id.frmnumerictwo);
		frmnumericwithunknowndecline = (ViewGroup) findViewById(R.id.frmnumericwithunknowndecline);
		// frmmultiplechecktext = (ViewGroup)
		// findViewById(R.id.frmmultiplechecktext);
		frmcomboswitheditspiner = (ViewGroup) findViewById(R.id.frmcomboswitheditspiner);
		frmmultiplecheckcombotwo = (ViewGroup) findViewById(R.id.frmmultiplecheckcombotwo);
		frmmultiplechoiceradio = (ViewGroup) findViewById(R.id.frmmultiplechoiceradio);
		frmmultiple = (ViewGroup) findViewById(R.id.frmmultiple);
		frmq124 = (ViewGroup) findViewById(R.id.frmq124);
		frmmultiplechecknumeric = (ViewGroup) findViewById(R.id.frmmultiplechecknumeric);
		frmmultiplecheckdate = (ViewGroup) findViewById(R.id.frmmultiplecheckdate);
		frmpatientdetail = (ViewGroup) findViewById(R.id.frmpatientdetail);
		frmweight = (ViewGroup) findViewById(R.id.frmweight);
		frmdiarrhea = (ViewGroup) findViewById(R.id.frmdiarrhea);
		frmvomiting = (ViewGroup) findViewById(R.id.frmvomiting);
		frmors = (ViewGroup) findViewById(R.id.frmors);
		frmchildren = (ViewGroup) findViewById(R.id.frmchildren);

		frmhouseholdfoodconsumption = (ViewGroup) findViewById(R.id.frmhouseholdfoodconsumption);
		frmmultiplechecktexttwo = (ViewGroup) findViewById(R.id.frmmultiplechecktexttwo);

		frmlandused = (ViewGroup) findViewById(R.id.frmlandused);

		frmcropproduction = (ViewGroup) findViewById(R.id.frmcropproduction);
		frmfishproduction = (ViewGroup) findViewById(R.id.frmfishproduction);
		frmcropfishproductioncost = (ViewGroup) findViewById(R.id.frmcropfishproductioncost);
		frmcropcultivationreserve = (ViewGroup) findViewById(R.id.frmcropcultivationreserve);

		frmwatermanagementproblem = (ViewGroup) findViewById(R.id.frmwatermanagementproblem);

		frmproductionmarketinglivestock = (ViewGroup) findViewById(R.id.frmproductionmarketinglivestock);
		frmlivestockproducts = (ViewGroup) findViewById(R.id.frmlivestockproducts);
		frmvulnarable = (ViewGroup) findViewById(R.id.frmvulnarable);
	}

	protected void FraNotes() {
		// TODO Auto-generated method stub
		this.gotoForm("FrmNotes");
	}

	// FrmMultipleCheckText
	public custom_class cls = new custom_class();

	private void loadGuiFrmMultipleChoiceRadio(final ViewGroup v) {

		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		ArrayList<String> spinnervalues = new ArrayList<String>();
		ArrayList<String> spinnervalues2 = new ArrayList<String>();
		ArrayList<String> spinnervalues3 = new ArrayList<String>();

		spinnervalues.add("");
		spinnervalues.add("1:Yes Eaten");
		spinnervalues.add("0:No");
		spinnervalues.add("66:Eaten, don’t know how many days ");
		spinnervalues.add("99:Don’t know if eaten or not");
		// spinnervalues.add("77:If others, What type?");

		spinnervalues2.add("");
		spinnervalues2.add("1:Yes Eaten");
		spinnervalues2.add("0:No");
		spinnervalues2.add("66:Eaten, don’t know how many days ");
		spinnervalues2.add("99:Don’t know if eaten or not");

		spinnervalues3.add("");
		spinnervalues3.add("00:00");
		spinnervalues3.add("88:88");

		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();
		qqq = (TextView) v.findViewById(R.id.qqq);

		((EditText) v.findViewById(R.id.day1)).setVisibility(View.GONE);
		((EditText) v.findViewById(R.id.day2)).setVisibility(View.GONE);
		((EditText) v.findViewById(R.id.day3)).setVisibility(View.GONE);
		((EditText) v.findViewById(R.id.day4)).setVisibility(View.GONE);
		((EditText) v.findViewById(R.id.day61)).setVisibility(View.GONE);

		((EditText) v.findViewById(R.id.et1)).setVisibility(View.GONE);
		((EditText) v.findViewById(R.id.et3)).setVisibility(View.GONE);
		((EditText) v.findViewById(R.id.et4)).setVisibility(View.GONE);
		((EditText) v.findViewById(R.id.et6)).setVisibility(View.GONE);

		adapterForCombo = new ArrayAdapter(this,
				android.R.layout.simple_spinner_item, spinnervalues);
		adapterForCombo
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		adapterForCombo2 = new ArrayAdapter(this,
				android.R.layout.simple_spinner_item, spinnervalues2);
		adapterForCombo2
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		adapterForCombo3 = new ArrayAdapter(this,
				android.R.layout.simple_spinner_item, spinnervalues3);
		adapterForCombo3
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		((Spinner) v.findViewById(R.id.spinner1)).setAdapter(adapterForCombo);
		((Spinner) v.findViewById(R.id.spinner2)).setAdapter(adapterForCombo2);
		((Spinner) v.findViewById(R.id.spinner3)).setAdapter(adapterForCombo);
		((Spinner) v.findViewById(R.id.spinner4)).setAdapter(adapterForCombo);
		((Spinner) v.findViewById(R.id.spinner5)).setAdapter(adapterForCombo3);
		((Spinner) v.findViewById(R.id.spinner6)).setAdapter(adapterForCombo2);

		((Spinner) v.findViewById(R.id.spinner1)).setVisibility(View.GONE);
		((Spinner) v.findViewById(R.id.spinner2)).setVisibility(View.GONE);
		((Spinner) v.findViewById(R.id.spinner3)).setVisibility(View.GONE);
		((Spinner) v.findViewById(R.id.spinner4)).setVisibility(View.GONE);
		((Spinner) v.findViewById(R.id.spinner5)).setVisibility(View.GONE);
		((Spinner) v.findViewById(R.id.spinner6)).setVisibility(View.GONE);

		((Spinner) v.findViewById(R.id.spinner1))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> parent,
							View view, int pos, long id) {

						if (parent.getItemAtPosition(pos).toString().length() > 0) {

							sResCode = parent
									.getItemAtPosition(pos)
									.toString()
									.substring(
											0,
											(parent.getItemAtPosition(pos)
													.toString()
													.lastIndexOf(":")));

							cls.setQ612_1(Integer.parseInt(sResCode));

							if (sResCode.equalsIgnoreCase("1")) {
								((EditText) v.findViewById(R.id.day1))
										.setVisibility(View.VISIBLE);
							} else if (sResCode.equalsIgnoreCase("77")) {
								((EditText) v.findViewById(R.id.et1))
										.setVisibility(View.VISIBLE);
							} else {
								((EditText) v.findViewById(R.id.day1))
										.setText("");
								((EditText) v.findViewById(R.id.day1))
										.setVisibility(View.GONE);
								/*
								 * ((EditText) v.findViewById(R.id.et1))
								 * .setText(""); ((EditText)
								 * v.findViewById(R.id.et1))
								 * .setVisibility(View.GONE);
								 */
							}

						}

					}

					public void onNothingSelected(AdapterView<?> arg0) {

					}
				});

		((Spinner) v.findViewById(R.id.spinner2))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> parent,
							View view, int pos, long id) {

						if (parent.getItemAtPosition(pos).toString().length() > 0) {

							/*
							 * ((EditText)
							 * v.findViewById(R.id.day2)).setText("");
							 * ((EditText) v.findViewById(R.id.day2))
							 * .setVisibility(View.GONE);
							 */

							sResCode = parent
									.getItemAtPosition(pos)
									.toString()
									.substring(
											0,
											(parent.getItemAtPosition(pos)
													.toString()
													.lastIndexOf(":")));

							cls.setQ612_2(Integer.parseInt(sResCode));

							if (sResCode.equalsIgnoreCase("1")) {
								((EditText) v.findViewById(R.id.day2))
										.setVisibility(View.VISIBLE);

							} else {
								((EditText) v.findViewById(R.id.day2))
										.setText("");
								((EditText) v.findViewById(R.id.day2))
										.setVisibility(View.GONE);
							}

						}

					}

					public void onNothingSelected(AdapterView<?> arg0) {

					}
				});

		((Spinner) v.findViewById(R.id.spinner3))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> parent,
							View view, int pos, long id) {

						if (parent.getItemAtPosition(pos).toString().length() > 0) {

							sResCode = parent
									.getItemAtPosition(pos)
									.toString()
									.substring(
											0,
											(parent.getItemAtPosition(pos)
													.toString()
													.lastIndexOf(":")));

							cls.setQ612_3(Integer.parseInt(sResCode));

							if (sResCode.equalsIgnoreCase("1")) {
								((EditText) v.findViewById(R.id.day3))
										.setVisibility(View.VISIBLE);
							} else if (sResCode.equalsIgnoreCase("77")) {
								((EditText) v.findViewById(R.id.et3))
										.setVisibility(View.VISIBLE);
							} else {
								((EditText) v.findViewById(R.id.day3))
										.setText("");
								((EditText) v.findViewById(R.id.day3))
										.setVisibility(View.GONE);
								/*
								 * ((EditText) v.findViewById(R.id.et3))
								 * .setText(""); ((EditText)
								 * v.findViewById(R.id.et3))
								 * .setVisibility(View.GONE);
								 */
							}

						}

					}

					public void onNothingSelected(AdapterView<?> arg0) {

					}
				});

		((Spinner) v.findViewById(R.id.spinner4))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> parent,
							View view, int pos, long id) {

						if (parent.getItemAtPosition(pos).toString().length() > 0) {

							sResCode = parent
									.getItemAtPosition(pos)
									.toString()
									.substring(
											0,
											(parent.getItemAtPosition(pos)
													.toString()
													.lastIndexOf(":")));

							cls.setQ612_4(Integer.parseInt(sResCode));

							if (sResCode.equalsIgnoreCase("1")) {
								((EditText) v.findViewById(R.id.day4))
										.setVisibility(View.VISIBLE);
							} else if (sResCode.equalsIgnoreCase("77")) {
								((EditText) v.findViewById(R.id.et4))
										.setVisibility(View.VISIBLE);
							} else {
								((EditText) v.findViewById(R.id.day4))
										.setText("");
								((EditText) v.findViewById(R.id.day4))
										.setVisibility(View.GONE);
								/*
								 * ((EditText) v.findViewById(R.id.et4))
								 * .setText(""); ((EditText)
								 * v.findViewById(R.id.et4))
								 * .setVisibility(View.GONE);
								 */
							}

						}

					}

					public void onNothingSelected(AdapterView<?> arg0) {

					}
				});

		((Spinner) v.findViewById(R.id.spinner5))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> parent,
							View view, int pos, long id) {

						if (parent.getItemAtPosition(pos).toString().length() > 0) {

							sResCode = parent
									.getItemAtPosition(pos)
									.toString()
									.substring(
											0,
											(parent.getItemAtPosition(pos)
													.toString()
													.lastIndexOf(":")));

							cls.setQ612_5(Integer.parseInt(sResCode));

						}

					}

					public void onNothingSelected(AdapterView<?> arg0) {

					}
				});

		((Spinner) v.findViewById(R.id.spinner6))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> parent,
							View view, int pos, long id) {

						if (parent.getItemAtPosition(pos).toString().length() > 0) {

							sResCode = parent
									.getItemAtPosition(pos)
									.toString()
									.substring(
											0,
											(parent.getItemAtPosition(pos)
													.toString()
													.lastIndexOf(":")));

							cls.setQ612_6(Integer.parseInt(sResCode));

							if (sResCode.equalsIgnoreCase("1")) {
								((EditText) v.findViewById(R.id.day61))
										.setVisibility(View.VISIBLE);
							} else if (sResCode.equalsIgnoreCase("77")) {
								((EditText) v.findViewById(R.id.et6))
										.setVisibility(View.VISIBLE);
							} else {
								((EditText) v.findViewById(R.id.day61))
										.setText("");
								((EditText) v.findViewById(R.id.day61))
										.setVisibility(View.GONE);
								// ((EditText) v.findViewById(R.id.et6))
								// .setText("");
								// ((EditText) v.findViewById(R.id.et6))
								// .setVisibility(View.GONE);
							}

						}

					}

					public void onNothingSelected(AdapterView<?> arg0) {

					}
				});

		((CheckBox) v.findViewById(R.id.chk1))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {

						if (isChecked) {
							((Spinner) v.findViewById(R.id.spinner1))
									.setVisibility(View.VISIBLE);

						} else {
							((Spinner) v.findViewById(R.id.spinner1))
									.setVisibility(View.GONE);
						}

					}
				});

		((CheckBox) v.findViewById(R.id.chk2))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {

						if (isChecked)
							((Spinner) v.findViewById(R.id.spinner2))
									.setVisibility(View.VISIBLE);
						else
							((Spinner) v.findViewById(R.id.spinner2))
									.setVisibility(View.GONE);

					}
				});

		((CheckBox) v.findViewById(R.id.chk3))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {

						if (isChecked)
							((Spinner) v.findViewById(R.id.spinner3))
									.setVisibility(View.VISIBLE);
						else
							((Spinner) v.findViewById(R.id.spinner3))
									.setVisibility(View.GONE);

					}
				});

		((CheckBox) v.findViewById(R.id.chk4))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {

						if (isChecked)
							((Spinner) v.findViewById(R.id.spinner4))
									.setVisibility(View.VISIBLE);
						else
							((Spinner) v.findViewById(R.id.spinner4))
									.setVisibility(View.GONE);

					}
				});

		((CheckBox) v.findViewById(R.id.chk5))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {

						if (isChecked)
							((Spinner) v.findViewById(R.id.spinner5))
									.setVisibility(View.VISIBLE);
						else
							((Spinner) v.findViewById(R.id.spinner5))
									.setVisibility(View.GONE);

					}
				});

		((CheckBox) v.findViewById(R.id.chk6))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {

						if (isChecked)
							((Spinner) v.findViewById(R.id.spinner6))
									.setVisibility(View.VISIBLE);
						else
							((Spinner) v.findViewById(R.id.spinner6))
									.setVisibility(View.GONE);

					}
				});

		((CheckBox) v.findViewById(R.id.checkBox1))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {

						if (isChecked)
							((EditText) v.findViewById(R.id.et1))
									.setVisibility(View.VISIBLE);
						else
							((EditText) v.findViewById(R.id.et1))
									.setVisibility(View.GONE);

					}
				});

		((CheckBox) v.findViewById(R.id.checkBox2))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {

						if (isChecked)
							((EditText) v.findViewById(R.id.et3))
									.setVisibility(View.VISIBLE);
						else
							((EditText) v.findViewById(R.id.et3))
									.setVisibility(View.GONE);

					}
				});
		((CheckBox) v.findViewById(R.id.checkBox3))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {

						if (isChecked)
							((EditText) v.findViewById(R.id.et4))
									.setVisibility(View.VISIBLE);
						else
							((EditText) v.findViewById(R.id.et4))
									.setVisibility(View.GONE);

					}
				});
		((CheckBox) v.findViewById(R.id.checkBox4))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {

						if (isChecked)
							((EditText) v.findViewById(R.id.et6))
									.setVisibility(View.VISIBLE);
						else
							((EditText) v.findViewById(R.id.et6))
									.setVisibility(View.GONE);

					}
				});
		btnPrev = (Button) v.findViewById(R.id.prevButton);
		btnPrev.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		btnNext = (Button) v.findViewById(R.id.saveNxtButton);

		btnNext.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				if (((EditText) findViewById(R.id.day1)).getVisibility() == View.VISIBLE) {
					if (((EditText) findViewById(R.id.day1)).getText()
							.toString().length() == 0) {
						CommonStaticClass.showMyAlert(con, "Message",
								"Number should be between 1 to 7");
						return;
					}

					if (!(Integer.parseInt(((EditText) findViewById(R.id.day1))
							.getText().toString()) >= 1)
							|| !(Integer
									.parseInt(((EditText) findViewById(R.id.day1))
											.getText().toString()) <= 7))

					{
						CommonStaticClass.showMyAlert(con, "Message",
								"Number should be between 1 to 7");
						return;
					}

					cls.setQ612_1_day(Integer
							.parseInt((((EditText) findViewById(R.id.day1))
									.getText().toString())));
				} else {
					cls.setQ612_1_day(-1);
				}

				if (((EditText) findViewById(R.id.day2)).getVisibility() == View.VISIBLE) {

					if (((EditText) findViewById(R.id.day2)).getText()
							.toString().length() == 0) {
						CommonStaticClass.showMyAlert(con, "Message",
								"Number should be between 1 to 7");
						return;
					}

					if (!(Integer.parseInt(((EditText) findViewById(R.id.day2))
							.getText().toString()) >= 1)
							|| !(Integer
									.parseInt(((EditText) findViewById(R.id.day2))
											.getText().toString()) <= 7))

					{
						CommonStaticClass.showMyAlert(con, "Message",
								"Number should be between 1 to 7");
						return;
					}

					cls.setQ612_2_day(Integer
							.parseInt((((EditText) findViewById(R.id.day2))
									.getText().toString())));
				} else {
					cls.setQ612_2_day(-1);
				}

				if (((EditText) findViewById(R.id.day3)).getVisibility() == View.VISIBLE) {

					if (((EditText) findViewById(R.id.day3)).getText()
							.toString().length() == 0) {
						CommonStaticClass.showMyAlert(con, "Message",
								"Number should be between 1 to 7");
						return;
					}

					if (!(Integer.parseInt(((EditText) findViewById(R.id.day3))
							.getText().toString()) >= 1)
							|| !(Integer
									.parseInt(((EditText) findViewById(R.id.day3))
											.getText().toString()) <= 7))

					{
						CommonStaticClass.showMyAlert(con, "Message",
								"Number should be between 1 to 7");
						return;
					}

					cls.setQ612_3_day(Integer
							.parseInt((((EditText) findViewById(R.id.day3))
									.getText().toString())));
				} else {
					cls.setQ612_3_day(-1);
				}
				if (((EditText) findViewById(R.id.day4)).getVisibility() == View.VISIBLE) {

					if (((EditText) findViewById(R.id.day4)).getText()
							.toString().length() == 0) {
						CommonStaticClass.showMyAlert(con, "Message",
								"Number should be between 1 to 7");
						return;
					}

					if (!(Integer.parseInt(((EditText) findViewById(R.id.day4))
							.getText().toString()) >= 1)
							|| !(Integer
									.parseInt(((EditText) findViewById(R.id.day4))
											.getText().toString()) <= 7))

					{
						CommonStaticClass.showMyAlert(con, "Message",
								"Number should be between 1 to 7");
						return;
					}

					cls.setQ612_4_day(Integer
							.parseInt((((EditText) findViewById(R.id.day4))
									.getText().toString())));
				} else {
					cls.setQ612_4_day(-1);
				}
				if (((EditText) findViewById(R.id.day61)).getVisibility() == View.VISIBLE) {
					if (((EditText) findViewById(R.id.day61)).getText()
							.toString().length() == 0) {
						CommonStaticClass.showMyAlert(con, "Message",
								"Number should be between 1 to 7");
						return;
					}

					if (!(Integer
							.parseInt(((EditText) findViewById(R.id.day61))
									.getText().toString()) >= 1)
							|| !(Integer
									.parseInt(((EditText) findViewById(R.id.day61))
											.getText().toString()) <= 7))

					{
						CommonStaticClass.showMyAlert(con, "Message",
								"Number should be between 1 to 7");
						return;
					}
					cls.setQ612_6_day(Integer
							.parseInt((((EditText) findViewById(R.id.day61))
									.getText().toString())));
				} else {
					cls.setQ612_6_day(-1);
				}
				if (((EditText) findViewById(R.id.et1)).getVisibility() == View.VISIBLE) {
					cls.setq612_1_other((((EditText) findViewById(R.id.et1))
							.getText().toString()));
				} else {
					cls.setq612_1_other("");
				}

				if (((EditText) findViewById(R.id.et3)).getVisibility() == View.VISIBLE) {
					cls.setq612_3_other((((EditText) findViewById(R.id.et3))
							.getText().toString()));
				} else {
					cls.setq612_3_other("");
				}

				if (((EditText) findViewById(R.id.et4)).getVisibility() == View.VISIBLE) {
					cls.setq612_4_other((((EditText) findViewById(R.id.et4))
							.getText().toString()));
				} else {
					cls.setq612_4_other("");
				}
				if (((EditText) findViewById(R.id.et6)).getVisibility() == View.VISIBLE) {
					cls.setq612_6_other((((EditText) findViewById(R.id.et6))
							.getText().toString()));
				} else {
					cls.setq612_6_other("");
				}
				updateTableDataFrmMultipleChoiceRadio(cls);
			}

		});
		btnClear = (Button) v.findViewById(R.id.clButton);
		btnClear.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) v);
			}

		});

		cls = new custom_class();
		cls = cls.GetRecords(dbHelper);

		if (cls.getQ612_1() >= 0) {
			((CheckBox) v.findViewById(R.id.chk1)).setChecked(true);
			((Spinner) v.findViewById(R.id.spinner1))
					.setVisibility(View.VISIBLE);

			switch (cls.getQ612_1()) {
			case 1:
				((Spinner) v.findViewById(R.id.spinner1)).setSelection(1);
				((EditText) v.findViewById(R.id.day1))
						.setVisibility(View.VISIBLE);
				((EditText) v.findViewById(R.id.day1)).setText(String
						.valueOf(cls.getQ612_1_day()));
				break;

			case 0:
				((Spinner) v.findViewById(R.id.spinner1)).setSelection(2);
				break;

			case 66:
				((Spinner) v.findViewById(R.id.spinner1)).setSelection(3);
				break;

			case 99:
				((Spinner) v.findViewById(R.id.spinner1)).setSelection(4);
				break;

			case 77:
				((Spinner) v.findViewById(R.id.spinner1)).setSelection(5);

				break;

			default:
				break;
			}

		}
		if (cls.getq612_1_other() != null) {
			if (cls.getq612_1_other().toString().length() > 0) {

				((CheckBox) v.findViewById(R.id.checkBox1)).setChecked(true);
				((EditText) v.findViewById(R.id.et1))
						.setVisibility(View.VISIBLE);
				((EditText) v.findViewById(R.id.et1)).setText(cls
						.getq612_1_other());
			}
		}

		if (cls.getQ612_2() >= 0) {
			((CheckBox) v.findViewById(R.id.chk2)).setChecked(true);
			((Spinner) v.findViewById(R.id.spinner2))
					.setVisibility(View.VISIBLE);
			switch (cls.getQ612_2()) {
			case 1:
				((Spinner) v.findViewById(R.id.spinner2)).setSelection(1);
				((EditText) v.findViewById(R.id.day2)).setText(String
						.valueOf(cls.getQ612_2_day()));
				break;

			case 0:
				((Spinner) v.findViewById(R.id.spinner2)).setSelection(2);
				break;

			case 66:
				((Spinner) v.findViewById(R.id.spinner2)).setSelection(3);
				break;

			case 99:
				((Spinner) v.findViewById(R.id.spinner2)).setSelection(4);
				break;

			case 77:
				((Spinner) v.findViewById(R.id.spinner2)).setSelection(5);

				break;

			default:
				break;
			}

		}
		if (cls.getQ612_3() >= 0) {
			((CheckBox) v.findViewById(R.id.chk3)).setChecked(true);
			((Spinner) v.findViewById(R.id.spinner3))
					.setVisibility(View.VISIBLE);
			switch (cls.getQ612_3()) {
			case 1:
				((Spinner) v.findViewById(R.id.spinner3)).setSelection(1);
				((EditText) v.findViewById(R.id.day3)).setText(String
						.valueOf(cls.getQ612_3_day()));
				break;

			case 0:
				((Spinner) v.findViewById(R.id.spinner3)).setSelection(2);
				break;

			case 66:
				((Spinner) v.findViewById(R.id.spinner3)).setSelection(3);
				break;

			case 99:
				((Spinner) v.findViewById(R.id.spinner3)).setSelection(4);
				break;

			case 77:
				((Spinner) v.findViewById(R.id.spinner3)).setSelection(5);
				/*
				 * ((EditText) v.findViewById(R.id.et3)).setText(cls
				 * .getq612_3_other());
				 */
				break;

			default:
				break;
			}

		}

		if (cls.getq612_3_other() != null) {
			if (cls.getq612_3_other().toString().length() > 0) {

				((CheckBox) v.findViewById(R.id.checkBox2)).setChecked(true);
				((EditText) v.findViewById(R.id.et3))
						.setVisibility(View.VISIBLE);
				((EditText) v.findViewById(R.id.et3)).setText(cls
						.getq612_3_other());
			}
		}
		if (cls.getQ612_4() >= 0) {
			((CheckBox) v.findViewById(R.id.chk4)).setChecked(true);
			((Spinner) v.findViewById(R.id.spinner4))
					.setVisibility(View.VISIBLE);
			switch (cls.getQ612_4()) {
			case 1:
				((Spinner) v.findViewById(R.id.spinner4)).setSelection(1);
				((EditText) v.findViewById(R.id.day4)).setText(String
						.valueOf(cls.getQ612_4_day()));
				break;

			case 0:
				((Spinner) v.findViewById(R.id.spinner4)).setSelection(2);
				break;

			case 66:
				((Spinner) v.findViewById(R.id.spinner4)).setSelection(3);
				break;

			case 99:
				((Spinner) v.findViewById(R.id.spinner4)).setSelection(4);
				break;

			case 77:
				((Spinner) v.findViewById(R.id.spinner4)).setSelection(5);

				break;

			default:
				break;
			}

		}

		if (cls.getq612_3_other() != null) {
			if (cls.getq612_3_other().toString().length() > 0) {

				((CheckBox) v.findViewById(R.id.checkBox3)).setChecked(true);
				((EditText) v.findViewById(R.id.et4))
						.setVisibility(View.VISIBLE);
				((EditText) v.findViewById(R.id.et4)).setText(cls
						.getq612_3_other());

			}
		}
		if (cls.getQ612_5() >= 0) {
			((CheckBox) v.findViewById(R.id.chk5)).setChecked(true);
			((Spinner) v.findViewById(R.id.spinner5))
					.setVisibility(View.VISIBLE);
			switch (cls.getQ612_5()) {
			case 00:
				((Spinner) v.findViewById(R.id.spinner5)).setSelection(1);

				break;

			case 88:
				((Spinner) v.findViewById(R.id.spinner5)).setSelection(2);
				break;

			default:
				break;
			}

		}

		if (cls.getQ612_6() >= 0) {
			((CheckBox) v.findViewById(R.id.chk6)).setChecked(true);
			((Spinner) v.findViewById(R.id.spinner6))
					.setVisibility(View.VISIBLE);
			switch (cls.getQ612_6()) {
			case 1:
				((Spinner) v.findViewById(R.id.spinner6)).setSelection(1);
				((EditText) v.findViewById(R.id.day61)).setText(String
						.valueOf(cls.getQ612_6_day()));
				break;

			case 0:
				((Spinner) v.findViewById(R.id.spinner6)).setSelection(2);
				break;

			case 66:
				((Spinner) v.findViewById(R.id.spinner6)).setSelection(3);
				break;

			case 99:
				((Spinner) v.findViewById(R.id.spinner6)).setSelection(4);
				break;

			case 77:
				((Spinner) v.findViewById(R.id.spinner6)).setSelection(5);
				/*
				 * ((EditText) v.findViewById(R.id.et6)).setText(cls
				 * .getq612_6_other());
				 */
				break;

			default:
				break;
			}

		}

		if (cls.getq612_6_other() != null) {
			if (cls.getq612_6_other().toString().length() > 0) {

				((CheckBox) v.findViewById(R.id.checkBox4)).setChecked(true);
				((EditText) v.findViewById(R.id.et6))
						.setVisibility(View.VISIBLE);
				((EditText) v.findViewById(R.id.et6)).setText(cls
						.getq612_6_other());
			}
		}
		if (CommonStaticClass.langBng) {
			setfonttobangla(v);
		}

	}

	private void setfonttobangla(ViewGroup v) {
		((CheckBox) findViewById(R.id.chk1))
				.setText("wkï Lv`¨ †hgb j¨vK‡Uv‡Rb A_ev bvb A_ev ev‡qvwgj,gvBeq Ab¨vb¨?");
		((CheckBox) findViewById(R.id.chk1)).setTypeface(font);

		((CheckBox) findViewById(R.id.chk2))
				.setText("cvwb‡Z ev `y‡a wm× Kiv km¨ RvZxq Lvevi †hgb: mywR A_ev Ab¨vb¨ Lvevi hv f~Æv&i ˆZix, †h¸‡jv †`vKv‡b wKb‡Z cvIqv hvq?");
		((CheckBox) findViewById(R.id.chk2)).setTypeface(font);

		((CheckBox) findViewById(R.id.chk3))
				.setText("A_ev wkï‡`i Lv`¨ km¨ †hgb †m‡ijvK?");
		((CheckBox) findViewById(R.id.chk3)).setTypeface(font);

		((CheckBox) findViewById(R.id.chk4))
				.setText("cywóKYv, gwbwg• wgwkªZ Lvevi [¸ov ev gvB‡µvwbDwUª‡qÛ `vbv hv evRv‡i cvIqv hvq]?");
		((CheckBox) findViewById(R.id.chk4)).setTypeface(font);

		((CheckBox) findViewById(R.id.chk5))
				.setText("‡mvbvgwb hv Avgv‡`i ‡_‡K †c‡q‡Qb? hw` Iqvk-‡ewbwdU G Aš�?f©~³ nIqvi úi úi nq Zvn‡j “00�?  †KvW Kiæb | hw` wkïwUi eqm 6 gv‡mi †ekx  nq Ges †m Iqvk-‡ewbwdU †_‡K †Kvb LNS bv ‡c‡q _v‡K  Zvn‡j “88�? †KvW Kiæb |");
		((CheckBox) findViewById(R.id.chk4)).setTypeface(font);

		((CheckBox) findViewById(R.id.chk6))
				.setText("Ab¨ ‡h †Kvb (Gj Gb Gm) ev m¤ú~iK cywó/cywó c¨v‡KU?");
		((CheckBox) findViewById(R.id.chk6)).setTypeface(font);

	}

	private void updateTableDataFrmMultipleChoiceRadio(custom_class c) {

		if (c.save(c)) {
			CommonStaticClass.findOutNextSLNo(
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar(),
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQnext1());
			CommonStaticClass.nextQuestion(ParentActivity.this);
		}

	}

	/*
	 * private boolean ValidActivity(View v) {
	 * 
	 * int nrOfChildren = ((GridView) v).getChildCount(); boolean alltrue =
	 * true; for (int i = 0; i < nrOfChildren; i++) { View view =
	 * v.getChildAt(i);
	 * 
	 * if (view instanceof EditText) { if (!(((EditText)
	 * view).getText().toString().length() > 0)) {
	 * 
	 * if (view.getVisibility() == View.GONE) { continue; } switch
	 * (view.getId()) { case R.id.q6:
	 * 
	 * if (((EditText) view).getText().toString().length() <= 0) { return
	 * alltrue = false;
	 * 
	 * } break; case R.id.q7:
	 * 
	 * if (((EditText) view).getText().toString().length() <= 0) { return
	 * alltrue = false;
	 * 
	 * } break;
	 * 
	 * case R.id.q8:
	 * 
	 * if (((EditText) view).getText().toString().length() <= 0) { return
	 * alltrue = false;
	 * 
	 * } break;
	 * 
	 * case R.id.q11:
	 * 
	 * if (((EditText) view).getText().toString().length() <= 0) { return
	 * alltrue = false;
	 * 
	 * } break;
	 * 
	 * case R.id.q13:
	 * 
	 * if (((EditText) view).getText().toString().length() <= 0) { return
	 * alltrue = false;
	 * 
	 * } break;
	 * 
	 * case R.id.q15:
	 * 
	 * if (((EditText) view).getText().toString().length() <= 0) { return
	 * alltrue = false;
	 * 
	 * } break; case R.id.q16:
	 * 
	 * if (((EditText) view).getText().toString().length() <= 0) { return
	 * alltrue = false;
	 * 
	 * } break; default: break; } } }
	 * 
	 * 
	 * else if (view instanceof RadioButton) {
	 * 
	 * switch (view.getId()) { case R.id.q9: if (rdoq26Dontknow.isChecked() ==
	 * false) { if (q26dayset.getText().toString().length() <= 0 ||
	 * q26monthset.getText().toString().length() <= 0)
	 * 
	 * { return alltrue = false; }
	 * 
	 * } break; } }
	 * 
	 * 
	 * else if (view instanceof RadioGroup) {
	 * 
	 * if (view.getVisibility() == View.GONE) { continue; }
	 * 
	 * switch (view.getId()) { case R.id.q9: if (((RadioGroup)
	 * findViewById(R.id.q9)) .getCheckedRadioButtonId() == -1) return alltrue =
	 * false; break;
	 * 
	 * case R.id.q10: if (((RadioGroup) findViewById(R.id.q10))
	 * .getCheckedRadioButtonId() == -1) return alltrue = false; break;
	 * 
	 * case R.id.q12: if (((RadioGroup) findViewById(R.id.q12))
	 * .getCheckedRadioButtonId() == -1) return alltrue = false; break;
	 * 
	 * case R.id.q14: if (((RadioGroup) findViewById(R.id.q14))
	 * .getCheckedRadioButtonId() == -1) { if (q10.equalsIgnoreCase("1") &&
	 * q12.equalsIgnoreCase("1")) {
	 * 
	 * } else { if (((RadioGroup) findViewById(R.id.q14)) .getVisibility() ==
	 * View.GONE) {
	 * 
	 * } else { if (((RadioGroup) findViewById(R.id.q14))
	 * .getCheckedRadioButtonId() == -1) { return alltrue = false; }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * break;
	 * 
	 * default: break; } }
	 * 
	 * } return alltrue; }
	 */

	private void updateTableDataFrmMultipleCheckText() {
		// TODO Auto-generated method stub
		if (!checkBox1.isChecked() && !checkBox2.isChecked()
				&& !checkBox3.isChecked() && !checkBox4.isChecked()
				&& !checkBox5.isChecked() && !checkBox6.isChecked()) {
			CommonStaticClass.showMyAlert(con, "Message",
					"Please fill at least one single box");
			return;
		} else {
			if (checkBox1.isChecked()
					&& !(editText1.getText().toString().length() > 0)) {
				CommonStaticClass.showMyAlert(con, "Message",
						"Please fill at least one single box");
				return;
			}
			if (checkBox2.isChecked()
					&& !(editText2.getText().toString().length() > 0)) {
				CommonStaticClass.showMyAlert(con, "Message",
						"Please fill at least one single box");
				return;
			}
			if (checkBox3.isChecked()
					&& !(editText3.getText().toString().length() > 0)) {
				CommonStaticClass.showMyAlert(con, "Message",
						"Please fill at least one single box");
				return;
			}

			if (checkBox4.isChecked()
					&& !(editText4.getText().toString().length() > 0)) {
				CommonStaticClass.showMyAlert(con, "Message",
						"Please fill at least one single box");
				return;
			}

		}

		String V5 = (checkBox5.isChecked()) ? "1" : "";
		String V6 = (checkBox6.isChecked()) ? "1" : "";
		String sql = String
				.format("Update tblMainQuesMc SET q4_5_1 ='%s', q4_5_2 ='%s' , q4_5_3 ='%s' , q4_5_4 ='%s' , q4_5_5 ='%s' , q4_5_6 ='%s' WHERE dataid='%s'",
						editText1.getText().toString(), editText2.getText()
								.toString(), editText3.getText().toString(),
						editText4.getText().toString(), V5, V6,
						CommonStaticClass.dataId);

		if (dbHelper.executeDMLQuery(sql)) {
			// preserveState();
			CommonStaticClass.findOutNextSLNo(
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar(),
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQnext1());
			CommonStaticClass.nextQuestion(ParentActivity.this);
		}

	}

	// method to load FrmAddress GUI and data
	private void Load_UIFrmAddress(final ViewGroup v) {
		// TODO Auto-generated method stub

		// checkDbHasPreviousDataForThisHouseHold();

		// Load Question
		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();
		qqq = (TextView) v.findViewById(R.id.qqq);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		/*
		 * txtHoldingNo = (EditText) v.findViewById(R.id.txtholdingNo); txtPara
		 * = (EditText) v.findViewById(R.id.txtPara);
		 */
		txtVillage = (EditText) v.findViewById(R.id.txtVillage);
		txtunion = (EditText) v.findViewById(R.id.txtUnion);
		txtupazila = (EditText) v.findViewById(R.id.txtUpazila);
		txtDistrict = (EditText) v.findViewById(R.id.txtDistrict);
		txtPhone1 = (EditText) v.findViewById(R.id.txtPhone1);
		txtPhone2 = (EditText) v.findViewById(R.id.txtPhone2);

		// Define lebel of the answers
		Fill_labelFrmAddress(v);

		btnPrev = (Button) v.findViewById(R.id.prevButton);
		btnPrev.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		btnNext = (Button) v.findViewById(R.id.saveNxtButton);

		btnNext.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateTableDataFrmAddress();
			}

		});
		btnClear = (Button) v.findViewById(R.id.clButton);
		btnClear.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) v);
			}

		});
		notesButton = (Button) v.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});

	}

	// Populate the controls
	private void doFillFrmAddress(Cursor mCursor1) {
		// TODO Auto-generated method stub
		if (mCursor1.moveToFirst()) {
			do {
				String columnhhno = "holdnumber";
				String columnPara = "para";
				String columnVillage = "village";
				String columnUnion = "unionward";
				String columnUpazilla = "upazilla";
				String columnDistrict = "district";
				String columnphone1 = "phone1";
				String columnphone2 = "phone2";
				String a = "";

				if (mCursor1.getColumnIndex(columnhhno) != -1) {
					a = mCursor1.getString(mCursor1.getColumnIndex(columnhhno))
							+ "";
					txtHoldingNo.setText((a.length() > 0
							&& (!a.equalsIgnoreCase("-1")) && (!a
							.equalsIgnoreCase("null"))) ? a : "");
					a = "";
				}
				if (mCursor1.getColumnIndex(columnPara) != -1) {
					a = mCursor1.getString(mCursor1.getColumnIndex(columnPara))
							+ "";
					txtPara.setText((a.length() > 0
							&& (!a.equalsIgnoreCase("-1")) && (!a
							.equalsIgnoreCase("null"))) ? a : "");
					a = "";
				}
				if (mCursor1.getColumnIndex(columnVillage) != -1) {
					a = mCursor1.getString(mCursor1
							.getColumnIndex(columnVillage)) + "";
					txtVillage.setText((a.length() > 0
							&& (!a.equalsIgnoreCase("-1")) && (!a
							.equalsIgnoreCase("null"))) ? a : "");
					a = "";
				}
				if (mCursor1.getColumnIndex(columnUnion) != -1) {
					a = mCursor1
							.getString(mCursor1.getColumnIndex(columnUnion))
							+ "";
					txtunion.setText((a.length() > 0
							&& (!a.equalsIgnoreCase("-1")) && (!a
							.equalsIgnoreCase("null"))) ? a : "");
					a = "";
				}
				if (mCursor1.getColumnIndex(columnUpazilla) != -1) {
					a = mCursor1.getString(mCursor1
							.getColumnIndex(columnUpazilla)) + "";
					txtupazila.setText((a.length() > 0
							&& (!a.equalsIgnoreCase("-1")) && (!a
							.equalsIgnoreCase("null"))) ? a : "");
					a = "";
				}
				if (mCursor1.getColumnIndex(columnDistrict) != -1) {
					a = mCursor1.getString(mCursor1
							.getColumnIndex(columnDistrict)) + "";
					txtDistrict.setText((a.length() > 0
							&& (!a.equalsIgnoreCase("-1")) && (!a
							.equalsIgnoreCase("null"))) ? a : "");
					a = "";
				}
				if (mCursor1.getColumnIndex(columnphone1) != -1) {
					a = mCursor1.getString(mCursor1
							.getColumnIndex(columnphone1)) + "";
					txtPhone1.setText((a.length() > 0
							&& (!a.equalsIgnoreCase("-1")) && (!a
							.equalsIgnoreCase("null"))) ? a : "");
					a = "";
				}
				if (mCursor1.getColumnIndex(columnphone2) != -1) {
					a = mCursor1.getString(mCursor1
							.getColumnIndex(columnphone2)) + "";
					txtPhone2.setText((a.length() > 0
							&& (!a.equalsIgnoreCase("-1")) && (!a
							.equalsIgnoreCase("null"))) ? a : "");
					a = "";
				}

			} while (mCursor1.moveToNext());
		}
	}

	private void updateTableDataFrmAddress() {
		// TODO Auto-generated method stub
		resHHno = txtHoldingNo.getText().toString();
		resPara = txtPara.getText().toString();
		resVillage = txtVillage.getText().toString();
		resUnion = txtunion.getText().toString();
		resUpazilla = txtupazila.getText().toString();
		resDistrict = txtDistrict.getText().toString();
		resPhone1 = txtPhone1.getText().toString();
		resPhone2 = txtPhone2.getText().toString();

		// Check Validation
		if (!IsvalidFrmAddress())
			return;

		try {

			String sql = "UPDATE "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " SET  holdnumber='" + resHHno + "',para='" + resPara
					+ "', village='" + resVillage + "',unionward='" + resUnion
					+ "',upazilla='" + resUpazilla + "',district='"
					+ resDistrict + "',phone1='" + resPhone1 + "',phone2='"
					+ resPhone2 + "' where dataid='" + CommonStaticClass.dataId
					+ "'";
			// Update the table if success full go to the next question
			if (dbHelper.executeDMLQuery(sql)) {
				CommonStaticClass.findOutNextSLNo(
						qName,
						CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getQnext1());
				CommonStaticClass.nextQuestion(ParentActivity.this);
			}
		} catch (Exception e) {
			CommonStaticClass.showMyAlert(con, "Exception", e.toString());
		}

	}

	private void showUserFinishDialogFrmAddress() {
		// get prompts.xml view
		LayoutInflater li = LayoutInflater.from(con);
		LinearLayout promptsView = (LinearLayout) li.inflate(R.layout.prompts,
				null);

		promptsView.removeView((EditText) promptsView
				.findViewById(R.id.editTextDialogUserInput));

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(con);

		// set prompts.xml to alertdialog builder
		alertDialogBuilder.setView(promptsView);

		final TextView textInfo = (TextView) promptsView
				.findViewById(R.id.textView1);
		textInfo.setText("Do u want to finish this cycle?");

		// set dialog message
		alertDialogBuilder
				.setCancelable(false)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

						CommonStaticClass.findOutNextSLNo(
								qName,
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQnext1());
						CommonStaticClass.nextQuestion(ParentActivity.this);

					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();
	}

	private boolean IsvalidFrmAddress() {
		boolean Isvalid = false;

		if (resPara.length() == 0) {
			CommonStaticClass.showMyAlert(con, "Error", "Para Name is Empty");
			return Isvalid;
		}
		if (resVillage.length() == 0) {
			CommonStaticClass
					.showMyAlert(con, "Error", "Village Name is Empty");
			return Isvalid;
		}
		if (resUnion.length() == 0) {
			CommonStaticClass.showMyAlert(con, "Error", "Union Name is Empty");
			return Isvalid;
		}
		if (resUpazilla.length() == 0) {
			CommonStaticClass.showMyAlert(con, "Error",
					"Upazilla Name is Empty");
			return Isvalid;
		}
		if (resDistrict.length() == 0) {
			CommonStaticClass.showMyAlert(con, "Error",
					"District Name is Empty");
			return Isvalid;
		}
		if (resPhone1.length() == 0) {
			CommonStaticClass.showMyAlert(con, "Error", "Phone Name is Empty");
			return Isvalid;
		} else {
			if (!resPhone1.startsWith("01")) {
				CommonStaticClass.showMyAlert(con, "Error",
						"Wrong combination of phone no.");
				return Isvalid;
			}
			if (resPhone1.length() > 11 || resPhone1.length() < 11) {
				CommonStaticClass.showMyAlert(con, "Error",
						"Please inser 11 digit phone no.");
				return Isvalid;
			}

		}

		return true;

	}

	private void Fill_labelFrmAddress(ViewGroup v) {
		lblHoldingNo = (TextView) v.findViewById(R.id.lblholdingNo);
		lblPara = (TextView) v.findViewById(R.id.lblPara);
		lblVillage = (TextView) v.findViewById(R.id.lblVillage);
		lblUnion = (TextView) v.findViewById(R.id.lblUnion);
		lblUpazilla = (TextView) v.findViewById(R.id.lblUpazila);
		lblDistrict = (TextView) v.findViewById(R.id.lblDistrict);
		lblPhone1 = (TextView) v.findViewById(R.id.lblPhone1);
		lblPhone2 = (TextView) v.findViewById(R.id.lblPhone2);

		if (CommonStaticClass.langBng) {

			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				qqq.setTypeface(font);
			}
			;
			lblHoldingNo.setTypeface(font);
			lblHoldingNo.setText(con.getResources().getString(
					R.string.lblHoldingNoBN));
			lblPara.setTypeface(font);
			lblPara.setText(con.getResources().getString(R.string.lblParaBN));
			lblVillage.setTypeface(font);
			lblVillage.setText(con.getResources().getString(
					R.string.lblVillageBN));
			lblUnion.setTypeface(font);
			lblUnion.setText(con.getResources().getString(R.string.lblUnionBN));
			lblUpazilla.setTypeface(font);
			lblUpazilla.setText(con.getResources().getString(
					R.string.lblUpazillaBN));
			lblDistrict.setTypeface(font);
			lblDistrict.setText(con.getResources().getString(
					R.string.lblDistrictBN));
			lblPhone1.setTypeface(font);
			lblPhone1
					.setText(con.getResources().getString(R.string.lblPhoneBN));
			lblPhone2.setTypeface(font);
			lblPhone2
					.setText(con.getResources().getString(R.string.lblPhoneBN));

			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			lblHoldingNo.setTypeface(null);

			lblPara.setTypeface(null);

			lblVillage.setTypeface(null);

			lblUnion.setTypeface(null);

			lblUpazilla.setTypeface(null);

			lblDistrict.setTypeface(null);

			lblPhone1.setTypeface(null);

			lblPhone2.setTypeface(null);

			lblHoldingNo.setText("Holding Number (if any):  ");

			lblPara.setText("Para / mahalla");

			lblVillage.setText("Village");

			lblUnion.setText("Union / ward");

			lblUpazilla.setText("Upazilla / Municipality / CC");

			lblDistrict.setText("District");

			lblPhone1.setText("Phone number 1: ");

			lblPhone2.setText("Phone number 2: ");

			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

	}

	private void Load_DataFrmAddress() {
		String sql = "Select * from "
				+ CommonStaticClass.questionMap.get(
						CommonStaticClass.currentSLNo).getTablename()
				+ " where dataid='" + CommonStaticClass.dataId + "'";
		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				doFillFrmAddress(mCursor1);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}
	}

	private boolean characterCheckingFrmAddress(String qAns) {
		boolean allch = true;
		String a = qAns.toLowerCase();
		char[] cArray = a.toCharArray();
		for (char c : cArray) {
			if (c == ' ' || c == '.') {
				continue;
			}
			if (c < 'a' || c > 'z') {
				allch = false;
				return allch;
			}
		}
		return allch;
	}

	// frmcombobox part
	private void Load_UIFrmComboBox(final ViewGroup v) {
		if (users != null && users.size() > 0) {
			users.clear();
		}
		if (userIDs != null && userIDs.size() > 0) {
			userIDs.clear();
		}
		// TODO Auto-generated method stub
		qqq = (TextView) v.findViewById(R.id.qqq);
		op = new Options();

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		checkBoxHolder = (LinearLayout) v.findViewById(R.id.checkBoxHolder);
		checkBoxHolder.removeAllViews();
		LinearLayout.LayoutParams lnlParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		LinearLayout.LayoutParams layoutParamForSpin = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);

		LinearLayout ln = new LinearLayout(this);
		ln.setOrientation(LinearLayout.HORIZONTAL);

		// Add spinner control
		final Spinner spinner = new Spinner(this);
		layoutParamForSpin.weight = 1;
		ln.addView(spinner, 0, layoutParamForSpin);
		// added by zaman

		if (CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo)
				.getQvar().equalsIgnoreCase("userid")
				|| CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar()
						.equalsIgnoreCase("memberid")
				|| CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar()
						.equalsIgnoreCase("q1_2")

				|| CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar()
						.equalsIgnoreCase("q1_3")

				|| CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar()
						.equalsIgnoreCase("q1_4")

				|| CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar()
						.equalsIgnoreCase("q1_5")

				|| CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar()
						.equalsIgnoreCase("q1_7")) {
			// for Reading data from a specific table like user, member etc.
			Cursor mCursor = null;
			String sql = "";
			users = new ArrayList<String>();
			users.add("");
			userIDs = new ArrayList<String>();
			userIDs.add("");

			try {
				if (CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar()
						.equalsIgnoreCase("q1_7"))
					sql = String.format("Select * from tblUser");
				else if (CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar()
						.equalsIgnoreCase("q10a"))
					sql = String.format("Select * from tblAntibiotics");

				else if (CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar()
						.equalsIgnoreCase("q1_3"))

					/*
					 * sql = String.format(
					 * "select * from tblCluster where Clusterid = (select clusterid from tblMainQues where dataid =  '%s')"
					 * ,CommonStaticClass.dataId);
					 */
					sql = String
							.format("select * from tblDistrict Order By DistName");

				else if (CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar()
						.equalsIgnoreCase("q1_4"))

					/*
					 * sql = String.format(
					 * "select * from tblCluster where Clusterid = (select clusterid from tblMainQues where dataid =  '%s')"
					 * ,CommonStaticClass.dataId);
					 */
					sql = String
							.format("select * from tblUpazila where Distcode = (select q1_3 from tblMainQues where dataid =  '%s')",
									CommonStaticClass.dataId);

				else if (CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar()
						.equalsIgnoreCase("q1_2"))
					sql = "Select * from tblCluster";
				/*
				 * sql = String.format("select * from tblOccupation",
				 * CommonStaticClass.dataId);
				 */

				mCursor = dbHelper.getQueryCursor(sql);
				if (mCursor.moveToFirst()) {
					do {
						if (CommonStaticClass.questionMap
								.get(CommonStaticClass.currentSLNo).getQvar()
								.equalsIgnoreCase("q1_7"))

						{
							users.add(mCursor.getString(mCursor
									.getColumnIndex("ID"))
									+ " : "
									+ mCursor.getString(mCursor
											.getColumnIndex("Name")));
							userIDs.add(mCursor.getString(mCursor
									.getColumnIndex("ID")));

						} else if (CommonStaticClass.questionMap
								.get(CommonStaticClass.currentSLNo).getQvar()
								.equalsIgnoreCase("memberid")) {
							users.add(mCursor.getString(mCursor
									.getColumnIndex("memberid"))
									+ " : "
									+ mCursor.getString(mCursor
											.getColumnIndex("mname")));
							userIDs.add(mCursor.getString(mCursor
									.getColumnIndex("memberid")));

						}

						// for question 1_2 to 1_6

						else if (CommonStaticClass.questionMap
								.get(CommonStaticClass.currentSLNo).getQvar()
								.equalsIgnoreCase("q1_2")) {
							users.add(mCursor.getString(mCursor
									.getColumnIndex("Clusterid"))
									+ " : "
									+ mCursor.getString(mCursor
											.getColumnIndex("Clusterid")));
							userIDs.add(mCursor.getString(mCursor
									.getColumnIndex("Clusterid")));

						} else if (CommonStaticClass.questionMap
								.get(CommonStaticClass.currentSLNo).getQvar()
								.equalsIgnoreCase("q1_3")
								|| CommonStaticClass.questionMap
										.get(CommonStaticClass.currentSLNo)
										.getQvar().equalsIgnoreCase("q12a")) {
							users.add(mCursor.getString(mCursor
									.getColumnIndex("Distcode"))
									+ " : "
									+ mCursor.getString(mCursor
											.getColumnIndex("DistName")));
							userIDs.add(mCursor.getString(mCursor
									.getColumnIndex("Distcode")));

						} else if (CommonStaticClass.questionMap
								.get(CommonStaticClass.currentSLNo).getQvar()
								.equalsIgnoreCase("q1_4")) {
							users.add(mCursor.getString(mCursor
									.getColumnIndex("UpazilaCode"))
									+ " : "
									+ mCursor.getString(mCursor
											.getColumnIndex("UpazilaName")));
							userIDs.add(mCursor.getString(mCursor
									.getColumnIndex("UpazilaCode")));

						} else if (CommonStaticClass.questionMap
								.get(CommonStaticClass.currentSLNo).getQvar()
								.equalsIgnoreCase("c1_8")) {

							if (CommonStaticClass.langBng) {
								users.add(mCursor.getString(mCursor
										.getColumnIndex("Code"))
										+ " : "
										+ mCursor.getString(mCursor
												.getColumnIndex("OccupationBng")));

							} else {
								users.add(mCursor.getString(mCursor
										.getColumnIndex("Code"))
										+ " : "
										+ mCursor.getString(mCursor
												.getColumnIndex("Occupation")));
							}

							userIDs.add(mCursor.getString(mCursor
									.getColumnIndex("Code")));

						}
					} while (mCursor.moveToNext());
				}
				adapterForCombo = new ArrayAdapter(this,
						android.R.layout.simple_spinner_item, users);
				adapterForCombo
						.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				// adapterForCombo.setDropDownViewResource(R.layout.checkedspintextview);
				spinner.setAdapter(adapterForCombo);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (mCursor != null)
					mCursor.close();
			}

		} else // applicable when Spinner is loaded from options table
		{
			op = CommonStaticClass.findOptionsForThisQuestion(
					dbHelper,
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar());
			op.capBngList.add(0, "");
			op.capEngList.add(0, "");
			op.codeList.add(0, -1);

			if (CommonStaticClass.langBng) {
				adapterForCombo = new SpinAdapter(this, op.capBngList, true);

			} else {
				adapterForCombo = new ArrayAdapter(this,
						android.R.layout.simple_spinner_item, op.capEngList);

			}
			adapterForCombo
					.setDropDownViewResource(CommonStaticClass.langBng ? R.layout.checkedspintextview
							: android.R.layout.simple_spinner_dropdown_item);
			spinner.setAdapter(adapterForCombo);
			// spinner.setOnItemSelectedListener(new spinItemSelectListener());

		}
		// Slected Index change event of Spinner
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				// TODO Auto-generated method stub
				if (parent.getItemAtPosition(pos).toString().length() > 0) {
					if (CommonStaticClass.questionMap
							.get(CommonStaticClass.currentSLNo).getQvar()
							.equalsIgnoreCase("userid")
							|| CommonStaticClass.questionMap
									.get(CommonStaticClass.currentSLNo)
									.getQvar().equalsIgnoreCase("q1_7")

							|| CommonStaticClass.questionMap
									.get(CommonStaticClass.currentSLNo)
									.getQvar().equalsIgnoreCase("q1_2")
							|| CommonStaticClass.questionMap
									.get(CommonStaticClass.currentSLNo)
									.getQvar().equalsIgnoreCase("q1_3")
							|| CommonStaticClass.questionMap
									.get(CommonStaticClass.currentSLNo)
									.getQvar().equalsIgnoreCase("q1_4")
							|| CommonStaticClass.questionMap
									.get(CommonStaticClass.currentSLNo)
									.getQvar().equalsIgnoreCase("c1_8")
							|| CommonStaticClass.questionMap
									.get(CommonStaticClass.currentSLNo)
									.getQvar().equalsIgnoreCase("c1_10"))
						sResCode = parent
								.getItemAtPosition(pos)
								.toString()
								.substring(
										0,
										(parent.getItemAtPosition(pos)
												.toString().lastIndexOf(":") - 1));
					else
						sResCode = op.codeList.get(pos).toString();
				}

			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		// if(CommonStaticClass.mode.equalsIgnoreCase(CommonStaticClass.EDITMODE)){
		// String sql =
		// "Select "+CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo).getQvar()+" from "+CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo).getTablename()+" where dataid='"+CommonStaticClass.dataId+"'";

		// Data Load
		String sql = "";
		if (CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo)
				.getQvar().equalsIgnoreCase("memberid"))
			sql = "Select * from tblFamilyMember where dataid='"
					+ CommonStaticClass.dataId + "'";// As data should be loaded
														// from family member
														// table
		else {
			sql = "Select * from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId + "'";
			Cursor mCursor1 = null;
			int index = -1;
			try {
				mCursor1 = dbHelper.getQueryCursor(sql);
				if (mCursor1.moveToFirst()) {
					do {
						String column = CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getQvar();

						if (mCursor1.getColumnIndex(column) != -1) {
							String a = mCursor1.getString(mCursor1
									.getColumnIndex(column)) + "";

							if (CommonStaticClass.questionMap
									.get(CommonStaticClass.currentSLNo)
									.getQvar().equalsIgnoreCase("userid")
									|| CommonStaticClass.questionMap
											.get(CommonStaticClass.currentSLNo)
											.getQvar().equalsIgnoreCase("q1_7")

									|| CommonStaticClass.questionMap
											.get(CommonStaticClass.currentSLNo)
											.getQvar().equalsIgnoreCase("q1_2")
									|| CommonStaticClass.questionMap
											.get(CommonStaticClass.currentSLNo)
											.getQvar().equalsIgnoreCase("q1_3")
									|| CommonStaticClass.questionMap
											.get(CommonStaticClass.currentSLNo)
											.getQvar().equalsIgnoreCase("q1_4")

									|| CommonStaticClass.questionMap
											.get(CommonStaticClass.currentSLNo)
											.getQvar().equalsIgnoreCase("c1_8")

									|| CommonStaticClass.questionMap
											.get(CommonStaticClass.currentSLNo)
											.getQvar()
											.equalsIgnoreCase("c1_10"))

								index = CommonStaticClass
										.GetIndexFromCollection(userIDs, a);
							else
								index = CommonStaticClass
										.GetIndexFromCollection(op.codeList, a);

							if (index != -1)
								spinner.setSelection(index);

						}
					} while (mCursor1.moveToNext());
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				if (mCursor1 != null)
					mCursor1.close();
			}
		}
		// }
		// End of addition

		checkBoxHolder.addView(ln, 0, lnlParams);

		prevButton = (Button) v.findViewById(R.id.prevButton);
		prevButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		saveNxtButton = (Button) v.findViewById(R.id.saveNxtButton);
		saveNxtButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateTableDataFrmComboBox();
				// preserveState();
			}

		});

		clButton = (Button) v.findViewById(R.id.clButton);
		clButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) v);
			}

		});
		notesButton = (Button) v.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});

	}

	private void updateTableDataFrmComboBox() {
		// TODO Auto-generated method stub
		try {
			if (sResCode.length() == 0) {
				CommonStaticClass.showMyAlert(con, "Notification",
						"Please select.");
				return;
			}
			String sql = "";
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQvar()
					.equalsIgnoreCase("memberid")) {
				String entryBy = CommonStaticClass.userSpecificId;
				Date d = new Date(System.currentTimeMillis());
				String entryDate = "dd-mmm-yy";
				entryDate = d.toLocaleString();

				String sqlCheck = "Select * from "
						+ CommonStaticClass
								.GetTableName(CommonStaticClass.questionMap
										.get(CommonStaticClass.currentSLNo)
										.getQvar()) + " where dataid='"
						+ CommonStaticClass.dataId + "' and memberid="
						+ sResCode;
				Cursor mCursor1 = null;
				try {
					mCursor1 = dbHelper.getQueryCursor(sqlCheck);
					if (mCursor1.getCount() == 0)
						sql = "Insert into "
								+ CommonStaticClass
										.GetTableName(CommonStaticClass.questionMap
												.get(CommonStaticClass.currentSLNo)
												.getQvar())
								+ "(dataid,memberid,EntryBy,EntryDate) values('"
								+ CommonStaticClass.dataId + "'," + sResCode
								+ ",'" + entryBy + "','" + entryDate + "')";

				} catch (Exception e) {
				} finally {
					if (mCursor1 != null)
						mCursor1.close();
				}

				CommonStaticClass.isMember = false;
				// CommonStaticClass.memberID = sResCode;

				// SKIP ADDITION
				CommonStaticClass.qskipList.clear();
				String sql1 = "";
				sql1 = "Select * from tblFamilyMember where dataid='"
						+ CommonStaticClass.dataId + "' and memberid="
						+ CommonStaticClass.memberID;
				mCursor1 = null;
				try {
					mCursor1 = dbHelper.getQueryCursor(sql1);
					if (mCursor1.moveToFirst()) {
						do {
							String column1 = "anysick";
							String column2 = "visitdoc";
							String column3 = "hospitalized";

							String a = mCursor1.getString(mCursor1
									.getColumnIndex(column1)) + "";
							String b = mCursor1.getString(mCursor1
									.getColumnIndex(column2)) + "";
							String c = mCursor1.getString(mCursor1
									.getColumnIndex(column3)) + "";

							if (a.equalsIgnoreCase("0")
									|| a.equalsIgnoreCase("99")) {
								CommonStaticClass.qskipList.add("SecP1");
								nullifyWithInRange("SecP1", "SecP2");
							}
							if (b.equalsIgnoreCase("0")
									|| b.equalsIgnoreCase("99")) {
								CommonStaticClass.qskipList.add("SecP2");
								nullifyWithInRange("SecP2", "SecP3");
							}
							if (c.equalsIgnoreCase("0")
									|| c.equalsIgnoreCase("99")) {
								CommonStaticClass.qskipList.add("SecP3");
								nullifyWithInRange("SecP3", "p3_5");
							}

						} while (mCursor1.moveToNext());

						if (CommonStaticClass.qskipList.contains("SecP1")
								&& CommonStaticClass.qskipList
										.contains("SecP2")
								&& CommonStaticClass.qskipList
										.contains("SecP3")) {
							CommonStaticClass
									.showMyAlert(con, "Notification",
											"Nothing to proceed for the selected member, please select another memeber");
							return;
						}

					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					if (mCursor1 != null)
						mCursor1.close();
				}

			} else if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQvar()
					.equalsIgnoreCase("cropfishcode")) {
				String entryBy = CommonStaticClass.userSpecificId;
				Date d = new Date(System.currentTimeMillis());
				String entryDate = "dd-mmm-yy";
				entryDate = d.toLocaleString();

				String sqlCheck = "Select * from tblAgrcultureFishMarket where dataid='"
						+ CommonStaticClass.dataId
						+ "' and cropfishcode="
						+ sResCode;
				Cursor mCursor1 = null;
				try {
					mCursor1 = dbHelper.getQueryCursor(sqlCheck);
					if (mCursor1.getCount() == 0)
						sql = "Insert into "
								+ CommonStaticClass
										.GetTableName(CommonStaticClass.questionMap
												.get(CommonStaticClass.currentSLNo)
												.getQvar())
								+ "(dataid,cropfishcode,EntryBy,EntryDate) values('"
								+ CommonStaticClass.dataId + "'," + sResCode
								+ ",'" + entryBy + "','" + entryDate + "')";

				} catch (Exception e) {
				} finally {
					if (mCursor1 != null)
						mCursor1.close();
				}

				CommonStaticClass.isMember = true;
				CommonStaticClass.cropfishcode = Integer.parseInt(sResCode);
			} else if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQvar()
					.equalsIgnoreCase("cropfishcode1")) {
				String entryBy = CommonStaticClass.userSpecificId;
				Date d = new Date(System.currentTimeMillis());
				String entryDate = "dd-mmm-yy";
				entryDate = d.toLocaleString();

				String sqlCheck = "Select * from tblContractAgreement where dataid='"
						+ CommonStaticClass.dataId
						+ "' and cropfishcode="
						+ sResCode;
				Cursor mCursor1 = null;
				try {
					mCursor1 = dbHelper.getQueryCursor(sqlCheck);
					if (mCursor1.getCount() == 0)
						sql = "Insert into "
								+ CommonStaticClass
										.GetTableName(CommonStaticClass.questionMap
												.get(CommonStaticClass.currentSLNo)
												.getQvar())
								+ "(dataid,cropfishcode,EntryBy,EntryDate) values('"
								+ CommonStaticClass.dataId + "'," + sResCode
								+ ",'" + entryBy + "','" + entryDate + "')";

				} catch (Exception e) {
				} finally {
					if (mCursor1 != null)
						mCursor1.close();
				}

				CommonStaticClass.isMember = true;
				CommonStaticClass.cropfishcode = Integer.parseInt(sResCode);
			} else if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQvar()
					.equalsIgnoreCase("cropfishcode2")) {
				String entryBy = CommonStaticClass.userSpecificId;
				Date d = new Date(System.currentTimeMillis());
				String entryDate = "dd-mmm-yy";
				entryDate = d.toLocaleString();

				String sqlCheck = "Select * from tblSpotMarket where dataid='"
						+ CommonStaticClass.dataId + "' and cropfishcode="
						+ sResCode;
				Cursor mCursor1 = null;
				try {
					mCursor1 = dbHelper.getQueryCursor(sqlCheck);
					if (mCursor1.getCount() == 0)
						sql = "Insert into "
								+ CommonStaticClass
										.GetTableName(CommonStaticClass.questionMap
												.get(CommonStaticClass.currentSLNo)
												.getQvar())
								+ "(dataid,cropfishcode,EntryBy,EntryDate) values('"
								+ CommonStaticClass.dataId + "'," + sResCode
								+ ",'" + entryBy + "','" + entryDate + "')";

				} catch (Exception e) {
				} finally {
					if (mCursor1 != null)
						mCursor1.close();
				}

				CommonStaticClass.isMember = true;
				CommonStaticClass.cropfishcode = Integer.parseInt(sResCode);
			}

			else
				sql = "Update "
						+ CommonStaticClass
								.GetTableName(CommonStaticClass.questionMap
										.get(CommonStaticClass.currentSLNo)
										.getQvar())
						+ " set "
						+ CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getQvar() + "='"
						+ sResCode + "' Where DataID='"
						+ CommonStaticClass.dataId + "'";

			dbHelper.executeDMLQuery(sql);
			sResCode = "";
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQvar()
					.equalsIgnoreCase("q9")) {
				String val = dbHelper.GetSingleColumnData("q9");
				if (val.equalsIgnoreCase("99")) {
					CommonStaticClass.findOutNextSLNo(
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQvar(),
							"q9_other");
					CommonStaticClass.nextQuestion(ParentActivity.this);
					return;
				}
			}
			CommonStaticClass.findOutNextSLNo(
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar(),
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQnext1());
			CommonStaticClass.nextQuestion(ParentActivity.this);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			dateYear = year;
			dateMonth = monthOfYear;
			dateDay = dayOfMonth;

			dobYear = year;
			dobMonth = monthOfYear;
			dobDay = dayOfMonth;

			updateDisplay("date");
		}
	};

	private void loadGuiFrmDate(final ViewGroup v) {
		// TODO Auto-generated method stub
		qqq = (TextView) v.findViewById(R.id.qqq);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		pickDate = (EditText) v.findViewById(R.id.pickDate);

		String sql = "Select * from "
				+ CommonStaticClass.questionMap.get(
						CommonStaticClass.currentSLNo).getTablename()
				+ " where dataid='" + CommonStaticClass.dataId + "'";
		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.moveToFirst()) {
				do {
					String column = CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar();

					if (mCursor1.getColumnIndex(column.toLowerCase()) != -1) {
						String val = mCursor1.getString(mCursor1
								.getColumnIndex(column.toLowerCase())) + "";
						pickDate.setText((val.length() > 0 && !val
								.equalsIgnoreCase("null")) ? val : "");
					}
				} while (mCursor1.moveToNext());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}

		pickDate.setOnTouchListener(new View.OnTouchListener() {

			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				showDialog(DATE_DIALOG);
				return false;
			}
		});

		final Calendar c = Calendar.getInstance();
		dateYear = c.get(Calendar.YEAR);
		dateMonth = c.get(Calendar.MONTH);
		dateDay = c.get(Calendar.DAY_OF_MONTH);

		if (!(pickDate.getText().toString().length() > 0))
			updateDisplay("date");

		prevButton = (Button) v.findViewById(R.id.prevButton);
		prevButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		saveNxtButton = (Button) v.findViewById(R.id.saveNxtButton);

		saveNxtButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateTableDataFrmDate();
			}

		});
		clButton = (Button) v.findViewById(R.id.clButton);
		clButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) v);
			}

		});
		notesButton = (Button) v.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});

	}

	/*
	 * private void updateDisplay(String dt) {
	 * 
	 * if (dt.contains("time")) { String time = new StringBuilder() // Month is
	 * 0 based so add 1
	 * .append(TimeHour).append(":").append(TimeMinute).toString(); //
	 * Log.d("Date: ",date); pickTime.setText(time); }
	 * 
	 * if (dt.contains("date")) { String date = new StringBuilder() // Month is
	 * 0 based so add 1 .append(dateDay).append(" ") .append(GetMonth(dateMonth
	 * + 1)).append(" ") .append(dateYear).toString(); // Log.d("Date: ",date);
	 * pickDate.setText(date); }
	 * 
	 * }
	 */
	EditText etpickdate;

	private void updateDisplayfrmfamily(String dt, EditText et) {

		if (dt.contains("date")) {
			String date = new StringBuilder()
					// Month is 0 based so add 1
					.append(dateDay).append(" ")
					.append(GetMonth(dateMonth + 1)).append(" ")
					.append(dateYear).toString();
			// Log.d("Date: ",date);
			et.setText(date);
		}

	}

	private void updateDisplay(String dt) {

		String time = new StringBuilder()

		.append(TimeHour).append(":")
		// .append(TimeMinute).toString();
				.append(String.format("%02d", TimeMinute)).toString();
		if (dt.contains("time")) {
			// Log.d("Date: ",date);
			/*
			 * if (ettime != null) { if (CommonStaticClass.currentSLNo == 2 ||
			 * CommonStaticClass.currentSLNo == 6 ||
			 * CommonStaticClass.currentSLNo == 4) {
			 * 
			 * ettime.setText(time); return;
			 * 
			 * } }
			 */
			if (pickTime != null)
				pickTime.setText(time);
		}

		if (dt.contains("date")) {
			String date = new StringBuilder()
					// Month is 0 based so add 1
					.append(dateDay).append(" ")
					.append(GetMonth(dateMonth + 1)).append(" ")
					.append(dateYear).toString();
			// Log.d("Date: ",date);
			/*
			 * if (qName.equalsIgnoreCase("PatientID")) { {
			 * 
			 * if (touchedBox != null) { touchedBox.setText(date);
			 * //listvalues.set(touchedBox.getId(), date); return; }
			 * 
			 * } }
			 */

			/*
			 * if (CommonStaticClass.currentSLNo == 1) {
			 * 
			 * int localMonth = (dateMonth + 1);
			 * 
			 * String monthString = localMonth < 10 ? "0" + localMonth :
			 * Integer.toString(localMonth); String localYear =
			 * Integer.toString(dateYear).substring(2);
			 * 
			 * etyearmonth.setText(new StringBuilder() // Month is 0 based so
			 * add 1 .append(localYear).append("/").append(monthString)
			 * .append("/").append(dateDay).append(" "));
			 * showDialog(DATE_DIALOG_ID); return;
			 * 
			 * }
			 */

			/*
			 * if (CommonStaticClass.currentSLNo == 2 ||
			 * CommonStaticClass.currentSLNo == 6 ||
			 * CommonStaticClass.currentSLNo == 4) {
			 * 
			 * if (etyearmonth.isFocused()) { int localMonth = (dateMonth + 1);
			 * 
			 * String monthString = localMonth < 10 ? "0" + localMonth :
			 * Integer.toString(localMonth);
			 * 
			 * String localYear = Integer.toString(dateYear);
			 * 
			 * etyearmonth.setText(new StringBuilder().append(dateDay)
			 * .append("/").append(monthString).append("/") .append(localYear));
			 * // showDialog(DATE_DIALOG_ID); }
			 */
			if (pickDate != null) {
				if (pickDate.isFocused()) {
					int localMonth = (dateMonth + 1);

					String monthString = localMonth < 10 ? "0" + localMonth
							: Integer.toString(localMonth);

					String localYear = Integer.toString(dateYear);

					if (pickDate != null) {
						pickDate.setText(new StringBuilder().append(dateDay)
								.append("/").append(monthString).append("/")
								.append(localYear));
					}
				}
			}

			// return;

			// }

			/*
			 * if (pickDate != null) { pickDate.setText(date); }
			 */
		}

	}

	private void updateTableDataFrmDate() {
		// TODO Auto-generated method stub
		String qAns = pickDate.getText().toString();
		try {
			String currentQuestion = CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQvar();
			if (qAns.length() > 0) {

				if (futureDateValidator(dateYear, dateMonth, dateDay)) {
					CommonStaticClass
							.showMyAlert(con, "Not Correct",
									"You are putting future date which is not acceptable");
					return;
				}

				String sql = "UPDATE "
						+ CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getTablename()
						+ " SET " + currentQuestion + "='" + qAns
						+ "' where dataid='" + CommonStaticClass.dataId + "'";
				if (dbHelper.executeDMLQuery(sql)) {
					// preserveState();
					CommonStaticClass.findOutNextSLNo(
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQvar(),
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQnext1());
					CommonStaticClass.nextQuestion(ParentActivity.this);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private String GetMonth(int month) {
		String sMonth = "";

		switch (month) {
		case 1:
			sMonth = "Jan";
			break;
		case 2:
			sMonth = "Feb";
			break;
		case 3:
			sMonth = "Mar";
			break;
		case 4:
			sMonth = "Apr";
			break;
		case 5:
			sMonth = "May";
			break;
		case 6:
			sMonth = "Jun";
			break;
		case 7:
			sMonth = "Jul";
			break;
		case 8:
			sMonth = "Aug";
			break;
		case 9:
			sMonth = "Sep";
			break;
		case 10:
			sMonth = "Oct";
			break;
		case 11:
			sMonth = "Nov";
			break;
		case 12:
			sMonth = "Dec";
			break;

		default:
			sMonth = " ";
			break;

		}

		return sMonth;

	}

	// frmfamilymember part
	private void loadGuiFrmFamilyMember(final ViewGroup vg) {
		// TODO Auto-generated method stub
		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();
		loadAllUiViewsFrmFamilyMember(vg);

		memberIDs = new ArrayList<String>();

		opSex = CommonStaticClass.findOptionsForThisQuestion(dbHelper, "hhead");

		// loading all options
		op = CommonStaticClass.findOptionsForEducation(dbHelper, "qroster");

		filllAllSpinnerDataFrmFamilyMember(vg);

		btnPrev = (Button) vg.findViewById(R.id.prevButton);
		btnPrev.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		btnsaveNxt = (Button) vg.findViewById(R.id.saveNxtButton);
		btnsaveNxt.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateTableDataFrmFamilyMember(vg);
			}

		});
		btnClear = (Button) vg.findViewById(R.id.clButton);
		btnClear.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) vg);
			}

		});
		notesButton = (Button) vg.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});
	}

	// frmproductionmarketinglivestock11`

	private void loadGuiFrmproductionmarketinglivestock(final ViewGroup vg) {
		// TODO Auto-generated method stub
		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();

		loadAllUiViewsFrmproductionmarketinglivestock(vg);

		((TextView) vg.findViewById(R.id.lblcol5_2))
				.setVisibility(View.VISIBLE);
		((EditText) vg.findViewById(R.id.txtcol5_2))
				.setVisibility(View.VISIBLE);
		((TextView) vg.findViewById(R.id.lblcol6)).setVisibility(View.VISIBLE);
		((Spinner) vg.findViewById(R.id.spcol6)).setVisibility(View.VISIBLE);
		((EditText) vg.findViewById(R.id.txtcol6other))
				.setVisibility(View.VISIBLE);
		((TextView) vg.findViewById(R.id.lblcol7_1))
				.setVisibility(View.VISIBLE);
		((Spinner) vg.findViewById(R.id.spcol7_1)).setVisibility(View.VISIBLE);
		((TextView) vg.findViewById(R.id.lblcol7_2))
				.setVisibility(View.VISIBLE);
		((Spinner) vg.findViewById(R.id.spcol7_2)).setVisibility(View.VISIBLE);

		((Spinner) vg.findViewById(R.id.spcol1))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {

						String val = ((Spinner) vg.findViewById(R.id.spcol1))
								.getSelectedItem().toString();
						if (val.length() > 0) {
							val = CommonStaticClass
									.GetSpinnerValue(((Spinner) vg
											.findViewById(R.id.spcol1)));
							if (val.equalsIgnoreCase("11")) {
								((EditText) vg.findViewById(R.id.txtcol1other))
										.setVisibility(View.VISIBLE);
							} else {
								((EditText) vg.findViewById(R.id.txtcol1other))
										.setVisibility(View.GONE);
							}

							findDataForThisSelectionFrmproductionmarketinglivestock(vg);

						}

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}

				});

		((Spinner) vg.findViewById(R.id.spcol6))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {

						String val = ((Spinner) vg.findViewById(R.id.spcol6))
								.getSelectedItem().toString();
						if (val.length() > 0) {
							val = CommonStaticClass
									.GetSpinnerValue(((Spinner) vg
											.findViewById(R.id.spcol6)));
							if (val.equalsIgnoreCase("4")) {
								((EditText) vg.findViewById(R.id.txtcol6other))
										.setVisibility(View.VISIBLE);
							} else {
								((EditText) vg.findViewById(R.id.txtcol6other))
										.setVisibility(View.GONE);
							}

						}

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}

				});

		((EditText) vg.findViewById(R.id.txtcol5_1))
				.addTextChangedListener(new TextWatcher() {

					@Override
					public void onTextChanged(CharSequence arg0, int arg1,
							int arg2, int arg3) {
						String v = arg0.toString();
						if (v.length() > 0) {
							if (v.equalsIgnoreCase("0")) {
								((TextView) vg.findViewById(R.id.lblcol5_2))
										.setVisibility(View.GONE);
								((EditText) vg.findViewById(R.id.txtcol5_2))
										.setVisibility(View.GONE);
								((EditText) vg.findViewById(R.id.txtcol5_2))
										.setText("");
								((TextView) vg.findViewById(R.id.lblcol6))
										.setVisibility(View.GONE);
								((Spinner) vg.findViewById(R.id.spcol6))
										.setVisibility(View.GONE);
								((EditText) vg.findViewById(R.id.txtcol6other))
										.setVisibility(View.GONE);
								((EditText) vg.findViewById(R.id.txtcol6other))
										.setText("");
								((TextView) vg.findViewById(R.id.lblcol7_1))
										.setVisibility(View.GONE);
								((Spinner) vg.findViewById(R.id.spcol7_1))
										.setVisibility(View.GONE);
								((TextView) vg.findViewById(R.id.lblcol7_2))
										.setVisibility(View.GONE);
								((Spinner) vg.findViewById(R.id.spcol7_2))
										.setVisibility(View.GONE);
							}
						} else {
							((TextView) vg.findViewById(R.id.lblcol5_2))
									.setVisibility(View.VISIBLE);
							((EditText) vg.findViewById(R.id.txtcol5_2))
									.setVisibility(View.VISIBLE);
							((TextView) vg.findViewById(R.id.lblcol6))
									.setVisibility(View.VISIBLE);
							((Spinner) vg.findViewById(R.id.spcol6))
									.setVisibility(View.VISIBLE);
							((EditText) vg.findViewById(R.id.txtcol6other))
									.setVisibility(View.VISIBLE);
							((TextView) vg.findViewById(R.id.lblcol7_1))
									.setVisibility(View.VISIBLE);
							((Spinner) vg.findViewById(R.id.spcol7_1))
									.setVisibility(View.VISIBLE);
							((TextView) vg.findViewById(R.id.lblcol7_2))
									.setVisibility(View.VISIBLE);
							((Spinner) vg.findViewById(R.id.spcol7_2))
									.setVisibility(View.VISIBLE);

						}

					}

					@Override
					public void beforeTextChanged(CharSequence arg0, int arg1,
							int arg2, int arg3) {
						((TextView) vg.findViewById(R.id.lblcol5_2))
								.setVisibility(View.VISIBLE);
						((EditText) vg.findViewById(R.id.txtcol5_2))
								.setVisibility(View.VISIBLE);
						((TextView) vg.findViewById(R.id.lblcol6))
								.setVisibility(View.VISIBLE);
						((Spinner) vg.findViewById(R.id.spcol6))
								.setVisibility(View.VISIBLE);
						((EditText) vg.findViewById(R.id.txtcol6other))
								.setVisibility(View.VISIBLE);
						((TextView) vg.findViewById(R.id.lblcol7_1))
								.setVisibility(View.VISIBLE);
						((Spinner) vg.findViewById(R.id.spcol7_1))
								.setVisibility(View.VISIBLE);
						((TextView) vg.findViewById(R.id.lblcol7_2))
								.setVisibility(View.VISIBLE);
						((Spinner) vg.findViewById(R.id.spcol7_2))
								.setVisibility(View.VISIBLE);

					}

					@Override
					public void afterTextChanged(Editable arg0) {

					}
				});

		btnPrev = (Button) vg.findViewById(R.id.prevButton);
		btnPrev.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		btnsaveNxt = (Button) vg.findViewById(R.id.saveNxtButton);
		btnsaveNxt.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateTableDataFrmproductionmarketinglivestock(vg);
			}

		});
		btnClear = (Button) vg.findViewById(R.id.clButton);
		btnClear.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) vg);
			}

		});
		notesButton = (Button) vg.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});
	}

	// frmlivestockproducts

	private void loadGuifrmlivestockproducts(final ViewGroup vg) {
		// TODO Auto-generated method stub
		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();
		loadAllUiViewsfrmlivestockproducts(vg);

		((Spinner) vg.findViewById(R.id.spcol1))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {

						String val = ((Spinner) vg.findViewById(R.id.spcol1))
								.getSelectedItem().toString();
						if (val.length() > 0) {
							val = CommonStaticClass
									.GetSpinnerValue(((Spinner) vg
											.findViewById(R.id.spcol1)));
							if (val.equalsIgnoreCase("5")) {
								((EditText) vg.findViewById(R.id.txtcol1other))
										.setVisibility(View.VISIBLE);
							} else {
								((EditText) vg.findViewById(R.id.txtcol1other))
										.setVisibility(View.GONE);
							}
							findDataForThisSelectionfrmlivestockproducts(vg);

						}

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}

				});

		((Spinner) vg.findViewById(R.id.spcol7))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {

						String val = ((Spinner) vg.findViewById(R.id.spcol7))
								.getSelectedItem().toString();
						if (val.length() > 0) {
							val = CommonStaticClass
									.GetSpinnerValue(((Spinner) vg
											.findViewById(R.id.spcol7)));
							if (val.equalsIgnoreCase("7")) {
								((EditText) vg.findViewById(R.id.txtcol7other))
										.setVisibility(View.VISIBLE);
							} else {
								((EditText) vg.findViewById(R.id.txtcol7other))
										.setVisibility(View.GONE);
							}

						}

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}

				});

		((EditText) vg.findViewById(R.id.txtcol6))
				.addTextChangedListener(new TextWatcher() {

					@Override
					public void onTextChanged(CharSequence arg0, int arg1,
							int arg2, int arg3) {
						// TODO Auto-generated method stub
						String val = arg0.toString();
						if (val.length() > 0) {

							if (val.equalsIgnoreCase("0")) {

								((TextView) vg.findViewById(R.id.lblcol7))
										.setVisibility(View.GONE);
								((Spinner) vg.findViewById(R.id.spcol7))
										.setVisibility(View.GONE);
								((EditText) vg.findViewById(R.id.txtcol7other))
										.setVisibility(View.GONE);
								((TextView) vg.findViewById(R.id.lblcol8))
										.setVisibility(View.GONE);
								((EditText) vg.findViewById(R.id.txtcol8))
										.setVisibility(View.GONE);
								((TextView) vg.findViewById(R.id.lblcol9))
										.setVisibility(View.GONE);
								((Spinner) vg.findViewById(R.id.spcol9))
										.setVisibility(View.GONE);
								((TextView) vg.findViewById(R.id.lblcol10))
										.setVisibility(View.GONE);
								((Spinner) vg.findViewById(R.id.spcol10))
										.setVisibility(View.GONE);

								((Spinner) vg.findViewById(R.id.spcol7))
										.setVisibility(View.GONE);
								((EditText) vg.findViewById(R.id.txtcol7other))
										.setVisibility(View.GONE);
								((TextView) vg.findViewById(R.id.lblcol7))
										.setVisibility(View.GONE);
							} else {

								((TextView) vg.findViewById(R.id.lblcol7))
										.setVisibility(View.VISIBLE);
								((Spinner) vg.findViewById(R.id.spcol7))
										.setVisibility(View.VISIBLE);
								((EditText) vg.findViewById(R.id.txtcol7other))
										.setVisibility(View.VISIBLE);
								((TextView) vg.findViewById(R.id.lblcol8))
										.setVisibility(View.VISIBLE);
								((EditText) vg.findViewById(R.id.txtcol8))
										.setVisibility(View.VISIBLE);
								((TextView) vg.findViewById(R.id.lblcol9))
										.setVisibility(View.VISIBLE);
								((Spinner) vg.findViewById(R.id.spcol9))
										.setVisibility(View.VISIBLE);
								((TextView) vg.findViewById(R.id.lblcol10))
										.setVisibility(View.VISIBLE);
								((Spinner) vg.findViewById(R.id.spcol10))
										.setVisibility(View.VISIBLE);

								((Spinner) vg.findViewById(R.id.spcol7))
										.setVisibility(View.VISIBLE);
								((EditText) vg.findViewById(R.id.txtcol7other))
										.setVisibility(View.VISIBLE);
								((TextView) vg.findViewById(R.id.lblcol7))
										.setVisibility(View.VISIBLE);

							}
						}

					}

					@Override
					public void beforeTextChanged(CharSequence arg0, int arg1,
							int arg2, int arg3) {
						// TODO Auto-generated method stub

					}

					@Override
					public void afterTextChanged(Editable arg0) {
						String val = arg0.toString();
						if (val.length() > 0) {

						} else {

						}

					}
				});

		btnPrev = (Button) vg.findViewById(R.id.prevButton);
		btnPrev.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		btnsaveNxt = (Button) vg.findViewById(R.id.saveNxtButton);
		btnsaveNxt.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateTableDataFrmlivestockproducts(vg);
			}

		});
		btnClear = (Button) vg.findViewById(R.id.clButton);
		btnClear.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) vg);
			}

		});
		notesButton = (Button) vg.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});
	}

	// frmfishproduction

	private void loadGuiFrmFishProduction(final ViewGroup vg) {
		// TODO Auto-generated method stub
		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();
		loadAllUiViewsFrmFishProduction(vg);

		((Spinner) vg.findViewById(R.id.spcol1))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {

						String val = ((Spinner) vg.findViewById(R.id.spcol1))
								.getSelectedItem().toString();
						if (val.length() > 0) {
							val = CommonStaticClass
									.GetSpinnerValue(((Spinner) vg
											.findViewById(R.id.spcol1)));
							if (val.equalsIgnoreCase("218")) {
								((EditText) vg.findViewById(R.id.txtother))
										.setVisibility(View.VISIBLE);
							} else {
								((EditText) vg.findViewById(R.id.txtother))
										.setVisibility(View.GONE);
							}
							findDataForThisSelectionFrmFishProduction(vg);

						}

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}

				});

		btnPrev = (Button) vg.findViewById(R.id.prevButton);
		btnPrev.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		btnsaveNxt = (Button) vg.findViewById(R.id.saveNxtButton);
		btnsaveNxt.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateTableDataFrmFishProduction(vg);
			}

		});
		btnClear = (Button) vg.findViewById(R.id.clButton);
		btnClear.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) vg);
			}

		});
		notesButton = (Button) vg.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});
	}

	// frmcropcultivationreserve
	private void loadGuiFrmCropCultivationReserve(final ViewGroup vg) {

		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();
		loadAllUiViewsFrmCropCultivationReserve(vg);

		
		((CheckBox)vg.findViewById(R.id.chkcol8)).setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				
				if(isChecked == true)
					((EditText)vg.findViewById(R.id.txtcol8)).setVisibility(View.GONE);
				else
					((EditText)vg.findViewById(R.id.txtcol8)).setVisibility(View.VISIBLE);
				
			}
		});
		
		
		((CheckBox)vg.findViewById(R.id.chkcol14)).setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				
				if(isChecked == true)
					((EditText)vg.findViewById(R.id.txtcol14)).setVisibility(View.GONE);
				else
					((EditText)vg.findViewById(R.id.txtcol14)).setVisibility(View.VISIBLE);
				
			}
		});
		
		((Spinner) vg.findViewById(R.id.txtcol10))
		.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				String val = ((Spinner) vg.findViewById(R.id.txtcol10))
						.getSelectedItem().toString();
				if (val.length() > 0) {
					val = CommonStaticClass
							.GetSpinnerValue(((Spinner) vg
									.findViewById(R.id.txtcol10)));
					
					
					if (val.equalsIgnoreCase("0")) {
						((Spinner) vg.findViewById(R.id.txtcol11)).setVisibility(View.GONE);
						((Spinner) vg.findViewById(R.id.txtcol12)).setVisibility(View.GONE);
						((EditText)vg.findViewById(R.id.txtcol12other)).setVisibility(View.GONE);
						
					} else {
						((Spinner) vg.findViewById(R.id.txtcol11)).setVisibility(View.VISIBLE);
						((Spinner) vg.findViewById(R.id.txtcol12)).setVisibility(View.VISIBLE);
						((EditText)vg.findViewById(R.id.txtcol12other)).setVisibility(View.GONE);
					}
					

				}

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
		
		
		
		
		((Spinner) vg.findViewById(R.id.txtcol16))
		.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				String val = ((Spinner) vg.findViewById(R.id.txtcol16))
						.getSelectedItem().toString();
				if (val.length() > 0) {
					val = CommonStaticClass
							.GetSpinnerValue(((Spinner) vg
									.findViewById(R.id.txtcol16)));
					
					
					if (val.equalsIgnoreCase("0")) {
						((Spinner) vg.findViewById(R.id.txtcol17)).setVisibility(View.GONE);
						((Spinner) vg.findViewById(R.id.txtcol18)).setVisibility(View.GONE);
						((EditText)vg.findViewById(R.id.txtcol12other)).setVisibility(View.GONE);
						
					} else {
						((Spinner) vg.findViewById(R.id.txtcol17)).setVisibility(View.VISIBLE);
						((Spinner) vg.findViewById(R.id.txtcol18)).setVisibility(View.VISIBLE);
						((EditText)vg.findViewById(R.id.txtcol12other)).setVisibility(View.GONE);
					}
					

				}

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
		
		
		((Spinner) vg.findViewById(R.id.txtcol18))
		.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				String val = ((Spinner) vg.findViewById(R.id.txtcol18))
						.getSelectedItem().toString();
				if (val.length() > 0) {
					val = CommonStaticClass
							.GetSpinnerValue(((Spinner) vg
									.findViewById(R.id.txtcol18)));
					if (val.equalsIgnoreCase("777")) {
						((EditText) vg.findViewById(R.id.txtcol18other))
								.setVisibility(View.VISIBLE);
					} else {
						((EditText) vg.findViewById(R.id.txtcol18other))
								.setVisibility(View.GONE);
					}
					

				}

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
		
		
		((Spinner) vg.findViewById(R.id.txtcol12))
		.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				String val = ((Spinner) vg.findViewById(R.id.txtcol12))
						.getSelectedItem().toString();
				if (val.length() > 0) {
					val = CommonStaticClass
							.GetSpinnerValue(((Spinner) vg
									.findViewById(R.id.txtcol12)));
					if (val.equalsIgnoreCase("777")) {
						((EditText) vg.findViewById(R.id.txtcol12other))
								.setVisibility(View.VISIBLE);
					} else {
						((EditText) vg.findViewById(R.id.txtcol12other))
								.setVisibility(View.GONE);
					}
					

				}

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
		
		((Spinner) vg.findViewById(R.id.txtcol2))
		.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				String val = ((Spinner) vg.findViewById(R.id.txtcol2))
						.getSelectedItem().toString();
				if (val.length() > 0) {
					val = CommonStaticClass
							.GetSpinnerValue(((Spinner) vg
									.findViewById(R.id.txtcol2)));
					if (val.equalsIgnoreCase("777")) {
						((EditText) vg.findViewById(R.id.txtcol2other))
								.setVisibility(View.VISIBLE);
					} else {
						((EditText) vg.findViewById(R.id.txtcol2other))
								.setVisibility(View.GONE);
					}
					//findDataForThisSelectionFrmCropFishProductionReserve(vg);

				}

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
		
		
			
		((Spinner) vg.findViewById(R.id.spcol1))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {

						String val = ((Spinner) vg.findViewById(R.id.spcol1))
								.getSelectedItem().toString();
						if (val.length() > 0) {
							val = CommonStaticClass
									.GetSpinnerValueFromString(((Spinner) vg
											.findViewById(R.id.spcol1)));
							
							findDataForThisSelectionFrmCropFishProductionReserve(vg);

						}

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

		((Spinner) vg.findViewById(R.id.txtcol6))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {

						String val = ((Spinner) vg.findViewById(R.id.txtcol6))
								.getSelectedItem().toString();
						if (val.length() > 0) {
							val = CommonStaticClass
									.GetSpinnerValue(((Spinner) vg
											.findViewById(R.id.txtcol6)));
							if (!val.equalsIgnoreCase("2")) {
								((TextView) vg.findViewById(R.id.lblcol7))
										.setVisibility(View.GONE);
								((Spinner) vg.findViewById(R.id.txtcol7))
										.setVisibility(View.GONE);
							} else {
								((TextView) vg.findViewById(R.id.lblcol7))
										.setVisibility(View.VISIBLE);
								((Spinner) vg.findViewById(R.id.txtcol7))
										.setVisibility(View.VISIBLE);
							}
							

						}

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

		btnPrev = (Button) vg.findViewById(R.id.prevButton);
		btnPrev.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		btnsaveNxt = (Button) vg.findViewById(R.id.saveNxtButton);
		btnsaveNxt.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateTableDataFrmCropFishProductionReserve(vg);
			}

		});
		btnClear = (Button) vg.findViewById(R.id.clButton);
		btnClear.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) vg);
			}

		});
		notesButton = (Button) vg.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});
	}

	// frmwatermanagementproblem
	private void loadGuiFrmWaterManagementProblem(final ViewGroup vg) {
		// TODO Auto-generated method stub
		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();
		loadAllUiViewsFrmWaterManagementProblem(vg);

		btnPrev = (Button) vg.findViewById(R.id.prevButton);
		btnPrev.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		btnsaveNxt = (Button) vg.findViewById(R.id.saveNxtButton);
		btnsaveNxt.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateTableDataFrmWaterManagementProblem(vg);
			}

		});
		btnClear = (Button) vg.findViewById(R.id.clButton);
		btnClear.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) vg);
			}

		});
		notesButton = (Button) vg.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});
	}

	// cropfishproductioncost
	private void loadGuiFrmCropFishProductionCost(final ViewGroup vg) {
		// TODO Auto-generated method stub
		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();
		loadAllUiViewsFrmCropFishProductionCost(vg);

		((Spinner) vg.findViewById(R.id.spcol1))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						if (qName.equalsIgnoreCase("qlivestockproductioncost")) {

							if (((Spinner) vg.findViewById(R.id.spcol1))
									.getSelectedItem().toString().length() > 0) {
								String val = CommonStaticClass
										.GetSpinnerValue(((Spinner) vg
												.findViewById(R.id.spcol1)));
								if (val.length() > 0) {
									if (val.equalsIgnoreCase("5")) {
										((EditText) vg
												.findViewById(R.id.txtothercol1))
												.setVisibility(View.VISIBLE);
									} else {
										((EditText) vg
												.findViewById(R.id.txtothercol1))
												.setVisibility(View.GONE);
									}
									findDataForThisSelectionFrmCropFishProductionCost(vg);
								}

							}
						} else {
							if (((Spinner) vg.findViewById(R.id.spcol1))
									.getSelectedItem().toString().length() > 0) {
								String val = CommonStaticClass
										.GetSpinnerValue(((Spinner) vg
												.findViewById(R.id.spcol1)));
								if (val.length() > 0) {
									if (val.equalsIgnoreCase("10")) {
										((EditText) vg
												.findViewById(R.id.txtothercol1))
												.setVisibility(View.VISIBLE);
									} else {
										((EditText) vg
												.findViewById(R.id.txtothercol1))
												.setVisibility(View.GONE);
									}
									findDataForThisSelectionFrmCropFishProductionCost(vg);
								}

							}
						}
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

		((Spinner) vg.findViewById(R.id.spcol2))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {

						if (((Spinner) vg.findViewById(R.id.spcol2))
								.getSelectedItem().toString().length() > 0) {
							String val = CommonStaticClass
									.GetSpinnerValue(((Spinner) vg
											.findViewById(R.id.spcol2)));

							if (val.equalsIgnoreCase("6")) {
								((EditText) vg.findViewById(R.id.txtothercol2))
										.setVisibility(View.VISIBLE);
							} else {
								((EditText) vg.findViewById(R.id.txtothercol2))
										.setVisibility(View.GONE);
							}
						}
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

		btnPrev = (Button) vg.findViewById(R.id.prevButton);
		btnPrev.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		btnsaveNxt = (Button) vg.findViewById(R.id.saveNxtButton);
		btnsaveNxt.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateTableDataFrmCropFishProductionCost(vg);
			}

		});
		btnClear = (Button) vg.findViewById(R.id.clButton);
		btnClear.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) vg);
			}

		});
		notesButton = (Button) vg.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});
	}

	private void loadAllUiViewsFrmCropProduction(ViewGroup v) {
		// TODO Auto-generated method stub

		qqq = (TextView) v.findViewById(R.id.qqq);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		// lblSL = (TextView) v.findViewById(R.id.lblPlot);

		/*
		 * spinnerSL = (Spinner) v.findViewById(R.id.spinnerMember);
		 * 
		 * spinnerSL.setFocusableInTouchMode(true); spinnerSL.requestFocus();
		 */

		if (CommonStaticClass.langBng) {

			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				qqq.setTypeface(font);
			}
			;
			// lblSL.setTypeface(font);

			((TextView) v.findViewById(R.id.lblPlot)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblplotname)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcrop)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblSeason)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblMonth)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblkg)).setTypeface(font);

			((TextView) v.findViewById(R.id.lblPlot)).setText("Rwg");
			((TextView) v.findViewById(R.id.lblplotname)).setText("bvgt");
			((TextView) v.findViewById(R.id.lblcrop)).setText("dmj †KvW");

			((TextView) v.findViewById(R.id.lblSeason)).setText("†gŠmyg");
			((TextView) v.findViewById(R.id.lblMonth)).setText("মাস");

			((TextView) v.findViewById(R.id.lblkg)).setText("কেজি");

			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());

			ArrayList<String> ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : Rwg 1");
			ids.add("2 : Rwg 2");
			ids.add("3 : Rwg 3");
			ids.add("4 : Rwg 4");
			ids.add("5 : Rwg 5");
			ids.add("6 : Rwg 6");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spinnerplot)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("11 : avb");
			ids.add("12 : Mg");
			ids.add("13 : fzÆv");
			ids.add("14 : Ab¨vb¨ Lv`¨kl¨");
			ids.add("21 : cvU");
			ids.add("22 : Zzjv");
			ids.add("23 : Othe");
			ids.add("31 : gm~i");
			ids.add("32 : Mung");
			ids.add("33 : KjvB");
			ids.add("34 : †Qvjv");
			ids.add("35 : gUi");
			ids.add("36 : Ab¨vb¨ Wvj");
			ids.add("41 : mwilv");
			ids.add("42 : mqvweb");
			ids.add("43 : wZwm exR");
			ids.add("44 : Ab¨vb¨ ˆZjexR");
			ids.add("51 : imyb");
			ids.add("52 : gwiP");
			ids.add("53 : †cuqvR");
			ids.add("54 : njy`");
			ids.add("55 : awbqv");
			ids.add("56 : Ab¨vb¨ gkjv");
			ids.add("61 : Kzgov");
			ids.add("62 : †e¸b");
			ids.add("63 : mxg");
			ids.add("64 : ZigyR");
			ids.add("65 : Kijv");
			ids.add("66 : jvB");
			ids.add("65 : dzjKwc");
			ids.add("66 : U‡g‡Uv");
			ids.add("67 : wSOv");
			ids.add("68 : Snak");
			ids.add("69 : cUj");
			ids.add("70 : KPz");
			ids.add("71 : ‡`kx mxg");
			ids.add("72 : KvuPKjv");
			ids.add("73 : WvUv");
			ids.add("74 : kkv");
			ids.add("75 : Pvj");
			ids.add("76 : kvjMg");
			ids.add("77 : Ab¨vb¨ mewR");
			ids.add("81 : jvjkvK");
			ids.add("82 : WvUv kvK");
			ids.add("83 : cvjs kvK");
			ids.add("84 : evuavKwc");
			ids.add("85 : Kjwg kvK");
			ids.add("86 : Ab¨vb¨ kvK");
			ids.add("91 : †cu‡c");
			ids.add("92 : Kjv");
			ids.add("93 : Kzj");
			ids.add("94 : Avg");
			ids.add("95 : m‡e`v");
			ids.add("96 : Avbvim");
			ids.add("97 : RjcvB");
			ids.add("98 : evZvwe‡jey / †jey");
			ids.add("99 : ZigyR");
			ids.add("100 : Ab¨vb¨ dj");
			ids.add("101 : Avjy");
			ids.add("102 : wgw÷ Avjy");
			ids.add("103 : AvL / B¶z");
			ids.add("104 : ZvgvK");
			ids.add("105 : mycvwi");
			ids.add("106 : dz‡ji evMvb");
			ids.add("107 : Ab¨vb¨ kl¨");
			/*
			 * ids.add("11 : Rice"); ids.add("12	: Wheat");
			 * ids.add("13	: Maize"); ids.add("14	: Other cereals");
			 * ids.add("21	: Jute"); ids.add("22	: Cotton");
			 * ids.add("23	: Other fiber crop"); ids.add("31	: Lentil");
			 * ids.add("32	: Mung"); ids.add("33	: Black gram");
			 * ids.add("34	: Chick Pea"); ids.add("35	: Cow Pea");
			 * ids.add("36	: Other Pulses"); ids.add("41	: Mustard");
			 * ids.add("42	: Soy Bean"); ids.add("43	: Linseed");
			 * ids.add("44	: Other oilseed"); ids.add("51	: Garlic");
			 * ids.add("52	: Chilli"); ids.add("53	: Onion");
			 * ids.add("54	: Turmeric"); ids.add("55	: Coriander");
			 * ids.add("56	: other spices"); ids.add("61	: Pumpkin");
			 * ids.add("62	: Bringal (eggplant)");
			 * ids.add("63	: Yard long Bean"); ids.add("64	: Water Gourd");
			 * ids.add("65	: Bitter Gourd"); ids.add("66	: Sweet Gourd");
			 * ids.add("65	: Cauliflower"); ids.add("66	: Tomato");
			 * ids.add("67	: Ridge Gourd"); ids.add("68	: Snake Gourd");
			 * ids.add("69	: Patal"); ids.add("70	: Arum");
			 * ids.add("71	: Country Bean"); ids.add("72	: Green banana");
			 * ids.add("73	: Yam stem"); ids.add("74	: Cucumber");
			 * ids.add("75	: Ash Gourd"); ids.add("76	: Turnip");
			 * ids.add("77	: Other vegetables"); ids.add("81	: Lal shak");
			 * ids.add("82	: Danta shak"); ids.add("83	: Palang shak");
			 * ids.add("84	: Cabbage"); ids.add("85	: Kalmi Shak");
			 * ids.add("86	: Other Leafy Vegetables"); ids.add("91	: Papaya");
			 * ids.add("92	: Banana"); ids.add("93	: Jujubee");
			 * ids.add("94	: Mango"); ids.add("95	: Shobeda (Sapodilla Plum)");
			 * ids.add("96	: Pineapple"); ids.add("97	: Olive");
			 * ids.add("98	: Shaddock (pomelo)"); ids.add("99	: Water Melon");
			 * ids.add("100 : Other fruits"); ids.add("101 : Potato");
			 * ids.add("102 : Sweet potato"); ids.add("103 : Sugarcane");
			 * ids.add("104 : Tobacco"); ids.add("105 : Beetlenut");
			 * ids.add("106 : Cut flower"); ids.add("107 : Other crops");
			 */

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spinnercrop)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : জান�?য়ারী");
			ids.add("2 : ফেব�?র�?য়ারি");
			ids.add("3 : মার�?চ");
			ids.add("4 : �?প�?রিল");
			ids.add("5 : মে");
			ids.add("6 : জ�?ন");
			ids.add("7 : জ�?লাই");
			ids.add("8 : অগাস�?ট");
			ids.add("9 : সেপ�?টেম�?বর");
			ids.add("10 : অক�?টোবর");
			ids.add("11 : নভেম�?বর");
			ids.add("12 : ডিসেম�?বর");
			/*
			 * ids.add("1 : January"); ids.add("2 : February");
			 * ids.add("3 : March"); ids.add("4 : April"); ids.add("5 : May");
			 * ids.add("6 : June"); ids.add("7 : July"); ids.add("8 : August");
			 * ids.add("9 : September"); ids.add("10	: October");
			 * ids.add("11 : November"); ids.add("12 : December");
			 */

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spinnerMonth)));

			((TextView) v.findViewById(R.id.lblMonth)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblkg)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblPlot)).setText("cøU bs");
			((TextView) v.findViewById(R.id.lblplotname)).setText("bvg");
			((TextView) v.findViewById(R.id.lblcrop)).setText("dmj †KvW");

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : †gŠmyg 1");
			ids.add("2 : †gŠmyg 2");
			ids.add("3 : †gŠmyg 3");
			ids.add("4 : †gŠmyg 4");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spinnerSeason)));

		} else {

			// ((TextView) v.findViewById(R.id.lblplo)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblPlot)).setTypeface(null);
			ArrayList<String> ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : Plot 1");
			ids.add("2 : Plot 2");
			ids.add("3 : Plot 3");
			ids.add("4 : Plot 4");
			ids.add("5 : Plot 5");
			ids.add("6 : Plot 6");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spinnerplot)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("11 : Rice");
			ids.add("12	: Wheat");
			ids.add("13	: Maize");
			ids.add("14	: Other cereals");
			ids.add("21	: Jute");
			ids.add("22	: Cotton");
			ids.add("23	: Other fiber crop");
			ids.add("31	: Lentil");
			ids.add("32	: Mung");
			ids.add("33	: Black gram");
			ids.add("34	: Chick Pea");
			ids.add("35	: Cow Pea");
			ids.add("36	: Other Pulses");
			ids.add("41	: Mustard");
			ids.add("42	: Soy Bean");
			ids.add("43	: Linseed");
			ids.add("44	: Other oilseed");
			ids.add("51	: Garlic");
			ids.add("52	: Chilli");
			ids.add("53	: Onion");
			ids.add("54	: Turmeric");
			ids.add("55	: Coriander");
			ids.add("56	: other spices");
			ids.add("61	: Pumpkin");
			ids.add("62	: Bringal (eggplant)");
			ids.add("63	: Yard long Bean");
			ids.add("64	: Water Gourd");
			ids.add("65	: Bitter Gourd");
			ids.add("66	: Sweet Gourd");
			ids.add("65	: Cauliflower");
			ids.add("66	: Tomato");
			ids.add("67	: Ridge Gourd");
			ids.add("68	: Snake Gourd");
			ids.add("69	: Patal");
			ids.add("70	: Arum");
			ids.add("71	: Country Bean");
			ids.add("72	: Green banana");
			ids.add("73	: Yam stem");
			ids.add("74	: Cucumber");
			ids.add("75	: Ash Gourd");
			ids.add("76	: Turnip");
			ids.add("77	: Other vegetables");
			ids.add("81	: Lal shak");
			ids.add("82	: Danta shak");
			ids.add("83	: Palang shak");
			ids.add("84	: Cabbage");
			ids.add("85	: Kalmi Shak");
			ids.add("86	: Other Leafy Vegetables");
			ids.add("91	: Papaya");
			ids.add("92	: Banana");
			ids.add("93	: Jujubee");
			ids.add("94	: Mango");
			ids.add("95	: Shobeda (Sapodilla Plum)");
			ids.add("96	: Pineapple");
			ids.add("97	: Olive");
			ids.add("98	: Shaddock (pomelo)");
			ids.add("99	: Water Melon");
			ids.add("100 : Other fruits");
			ids.add("101 : Potato");
			ids.add("102 : Sweet potato");
			ids.add("103 : Sugarcane");
			ids.add("104 : Tobacco");
			ids.add("105 : Beetlenut");
			ids.add("106 : Cut flower");
			ids.add("107 : Other crops");
			((TextView) v.findViewById(R.id.lblplotname)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcrop)).setTypeface(null);

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spinnercrop)));

			((TextView) v.findViewById(R.id.lblSeason)).setTypeface(null);

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : January");
			ids.add("2 : February");
			ids.add("3 : March");
			ids.add("4 : April");
			ids.add("5 : May");
			ids.add("6 : June");
			ids.add("7 : July");
			ids.add("8 : August");
			ids.add("9 : September");
			ids.add("10	: October");
			ids.add("11 : November");
			ids.add("12 : December");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spinnerMonth)));

			((TextView) v.findViewById(R.id.lblMonth)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblkg)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblPlot)).setText("Plot");
			((TextView) v.findViewById(R.id.lblplotname)).setText("Name");
			((TextView) v.findViewById(R.id.lblcrop)).setText("Crop Code");

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : Season 1");
			ids.add("2 : Season 2");
			ids.add("3 : Season 3");
			ids.add("4 : Season 4");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spinnerSeason)));

			((TextView) v.findViewById(R.id.lblSeason)).setText("Season");
			((TextView) v.findViewById(R.id.lblMonth)).setText("Month");

			((TextView) v.findViewById(R.id.lblkg)).setText("Kg");

			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());

		}

	}

	private void loadAllUiViewsFrmVulnarable(ViewGroup v) {
		// TODO Auto-generated method stub

		qqq = (TextView) v.findViewById(R.id.qqq);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		if (CommonStaticClass.langBng) {

			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				qqq.setTypeface(font);
			}
			;
			// lblSL.setTypeface(font);

			((TextView) v.findViewById(R.id.lblcol1)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol2)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol3)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol4)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol5)).setTypeface(font);

			((TextView) v.findViewById(R.id.lblcol1)).setText("NUbv");
			((TextView) v.findViewById(R.id.lblcol2))
					.setText("weMZ 24 gv‡m wK Avcbvi Lvbv †Kvb ai‡bi [NUbvq] ¶wZMÖ¯— n‡q‡Q?");
			((TextView) v.findViewById(R.id.lblcol3))
					.setText("n¨vu n‡j, me©†kl KZ Av‡M GB NUbv N‡U? (gvm)");

			((TextView) v.findViewById(R.id.lblcol4)).setText("cÖfve");
			((TextView) v.findViewById(R.id.lblcol5))
					.setText("GB NUbvi mv‡_ wKfv‡e Lvc LvB‡q‡Qb?");

			((CheckBox) v.findViewById(R.id.txtcol5_1)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol5_2)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol5_3)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol5_4)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol5_5)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol5_6)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol5_7)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol5_8)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol5_9)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol5_10)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol5_11)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol5_12)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol5_13)).setTypeface(font);

			((CheckBox) v.findViewById(R.id.txtcol5_1))
					.setText("0 : wKQzB K‡ibwb");
			((CheckBox) v.findViewById(R.id.txtcol5_2))
					.setText("1 : †fvM e¨q Kwg‡q");
			((CheckBox) v.findViewById(R.id.txtcol5_3))
					.setText("2 : mÂq e¨envi K‡i");
			((CheckBox) v.findViewById(R.id.txtcol5_4))
					.setText("3 : m¤c` weµq K‡i");
			((CheckBox) v.findViewById(R.id.txtcol5_5))
					.setText("4 : mš—vb †K A‡b¨i evwo‡Z cvwV‡q");
			((CheckBox) v.findViewById(R.id.txtcol5_6))
					.setText("5 : mš—vb‡K (14 eQ‡ii Kg) Kv‡R cvwV‡q");
			((CheckBox) v.findViewById(R.id.txtcol5_7))
					.setText("6 : c~‡e© KvR K‡ibwb GiKg Lvbv m`m¨ †K Kv‡R cvwV‡q");
			((CheckBox) v.findViewById(R.id.txtcol5_8)).setText("7 : wf¶ve„wË");
			((CheckBox) v.findViewById(R.id.txtcol5_9)).setText("8 : avi K‡i");
			((CheckBox) v.findViewById(R.id.txtcol5_10))
					.setText("9 : AwMÖg kªg w`‡q");
			((CheckBox) v.findViewById(R.id.txtcol5_11))
					.setText("10 : wiwjd mnvqZv");
			((CheckBox) v.findViewById(R.id.txtcol5_12))
					.setText("11 : eÜy / Av�?xq ¯^Rb‡`i KvQ †_‡K mnvqZv");
			((CheckBox) v.findViewById(R.id.txtcol5_13))
					.setText("12 : Ab¨vb¨ (wbw`©ó Ki“b)");

			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());

			ArrayList<String> ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : eb¨v");
			ids.add("2 : Liv");
			ids.add("3 : mvB‡K¬vb");
			ids.add("4 : b`xfv½b");
			ids.add("5 : AwZe„wó");
			ids.add("6 : f’wgØm");
			ids.add("7 : AwZ evZvm");
			ids.add("8 : dmj nvwb");
			ids.add("9 : cÖvK…wZK `y‡h©v‡Mi d‡j †cvëªx/cïm¤c`/ grm¨ m¤c‡`i ¶wZ");
			ids.add("10 : K…wl dmjnvbx");
			ids.add("11 : Ab¨vb¨ mgm¨v");
			ids.add("12 : KvR K‡g hvIqv");
			ids.add("13 : Lvbvi DcvR©b A¶g m`†m¨i gviv�?K Amy¯’Zv");
			ids.add("14 : Lvbvi DcvR©bKvix m`‡m¨i g„Z¨y");
			ids.add("15 : Lvbvi DcvR©b A¶g m`†m¨i g„Z¨y");
			ids.add("16 : Lvbvi Ab¨vb¨ m`‡m¨i gviv�?K Amy¯’Zv");
			ids.add("17 : Lvbv m`‡m¨i weevn");
			ids.add("18 : ZvjvK");
			ids.add("19 : Lvbvi DcvR©bKvix m`‡m¨i ¶wZ");
			ids.add("20 : D‡�?Q`");
			ids.add("21 : welwµqv / A‡b¨i Øviv cïm¤c‡`i ¶wZ");
			ids.add("22 : AvBbx gvgjv (wjM¨vj †Km) / Ø›Ø");
			ids.add("23 : Pzwi");
			ids.add("24 : Pzwi/WvKvwZ");
			ids.add("25 : Pjv‡divq gvbylR‡bi evav");
			ids.add("26 : cvwievwiK wbh©vZb/mwnsmZv");
			ids.add("27 : ivR‰bwZK Aw¯’wZkxjZv");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol1)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : n¨vu");
			ids.add("0 : bv (cieZ©x NUbvq hvb)");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol2)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : 1");
			ids.add("2 : 2");
			ids.add("3 : 3");
			ids.add("4 : 4");
			ids.add("5 : 5");
			ids.add("6 : 6");
			ids.add("7 : 7");
			ids.add("8 : 8");
			ids.add("9 : 9");
			ids.add("10 : 10");
			ids.add("11 : 11");
			ids.add("12 : 12");
			ids.add("13 : 13");
			ids.add("14 : 14");
			ids.add("15 : 15");
			ids.add("16 : 16");
			ids.add("17 : 17");
			ids.add("18 : 18");
			ids.add("19 : 19");
			ids.add("20 : 20");

			ids.add("21 : 21");
			ids.add("22 : 22");
			ids.add("23 : 23");
			ids.add("24 : 24");
			ids.add("25 : 25");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol3)));

			ids = new ArrayList<String>();
			ids.add("");

			ids.add("1 : Lvbv m`‡m¨i Rxebnvbx");
			ids.add("2 : Kg©w`em nviv‡bv");
			ids.add("3 : Ni-evwo m¤c~Y© webó nIq");
			ids.add("4 : Ni evwoi AvswkK ¶wZ");
			ids.add("5 : Mevw`cïi Avkªq m¤cyb© webó nIqv");
			ids.add("6 : Mevw`cïi Avkªq AvswkK ¶wZMÖ¯— nIqv");
			ids.add("7 : †cvëªx I cïm¤c‡`i ¶wZ");
			ids.add("8 : Avw_©K ¶wZ");
			ids.add("9 : dmj Drcv`b nªvm cvIqv");
			ids.add("10 : grm¨ Drcv`b nªvm cvIqv");
			ids.add("11 :  Ab¨vb¨ (wbw`©ó Ki“b)");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol4)));

		} else {

			// ((TextView) v.findViewById(R.id.lblplo)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblcol1)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol1)).setText("Event");
			ArrayList<String> ids = new ArrayList<String>();
			ids.add("");

			ids.add("1 : Flood");
			ids.add("2 : Drought");
			ids.add("3 : Cyclone");
			ids.add("4 : River erosion");
			ids.add("5 : Excessive rain");
			ids.add("6 : Land slide");
			ids.add("7 : Wind damage");
			ids.add("8 : crop lost");
			ids.add("9 : Damage of poultry/livestock/fisheries due to natural disaster");
			ids.add("10 : Agriculture Crop Failure");
			ids.add("11 : Other problems");
			ids.add("12	: Loss of employment");
			ids.add("13	: Serious illness of non-income earning HH member");
			ids.add("14	: Income earning household member passed away");
			ids.add("15	: Non-Income earning household member passed away");
			ids.add("16	: Serious illness of other HH member");
			ids.add("17	: Marriage of  household member");
			ids.add("18	: Divorce");
			ids.add("19	: Loss of income earning household member");
			ids.add("20	: Eviction");
			ids.add("21	: Poisoning/damaging livestock by others");
			ids.add("22	: Legal Case/dispute");
			ids.add("23	: Theft");
			ids.add("24	: Mugging/robbery");
			ids.add("25	: People restricting movement");
			ids.add("26	: Domestic violence");
			ids.add("27	: Political unrest");

			/**/

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol1)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : Yes");
			ids.add("0 : No");

			((TextView) v.findViewById(R.id.lblcol2)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol2))
					.setText("Was your household affected by [event] in the past 24 months?");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol2)));

			((TextView) v.findViewById(R.id.lblcol3)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol3))
					.setText("If yes, how long ago did this event occur for the last time?(in months)");

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : 1");
			ids.add("2 : 2");
			ids.add("3 : 3");
			ids.add("4 : 4");
			ids.add("5 : 5");
			ids.add("6 : 6");
			ids.add("7 : 7");
			ids.add("8 : 8");
			ids.add("9 : 9");
			ids.add("10	: 10");
			ids.add("11 : 11");
			ids.add("12 : 12");
			ids.add("13 : 13");
			ids.add("14 : 14");
			ids.add("15 : 15");
			ids.add("16 : 16");
			ids.add("17 : 17");
			ids.add("18 : 18");
			ids.add("19 : 19");
			ids.add("20 : 20");
			ids.add("21 : 21");
			ids.add("22	: 22");
			ids.add("23 : 23");
			ids.add("24 : 24");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol3)));

			((TextView) v.findViewById(R.id.lblcol4)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol5)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblcol4)).setText("Effect");
			((TextView) v.findViewById(R.id.lblcol5))
					.setText("How did you cope with this event? (could be multiple answer) (look up code)");

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : Loss of life of HH members");
			ids.add("2 : Loss of working day");
			ids.add("3 : Damaged house fully");
			ids.add("4 : Damaged house partially");
			ids.add("5 : Damaged cattle shelter fully");
			ids.add("6 : Damaged cattle shelter partially");
			ids.add("7 : Damaged poultry & livestock");
			ids.add("8 : loss of income");
			ids.add("9 : reduced crop production");
			ids.add("10 : reduced aquaculture production");
			ids.add("11 : Other (specify)");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol4)));

			((CheckBox) v.findViewById(R.id.txtcol5_1)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol5_2)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol5_3)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol5_4)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol5_5)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol5_6)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol5_7)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol5_8)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol5_9)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol5_10)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol5_11)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol5_12)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol5_13)).setTypeface(null);

			((CheckBox) v.findViewById(R.id.txtcol5_1))
					.setText("0 : did nothing");
			((CheckBox) v.findViewById(R.id.txtcol5_2))
					.setText("1 : Reduce Consumption Expenditure");
			((CheckBox) v.findViewById(R.id.txtcol5_3))
					.setText("2 : Use savings");
			((CheckBox) v.findViewById(R.id.txtcol5_4))
					.setText("3 : Asset sale");
			((CheckBox) v.findViewById(R.id.txtcol5_5))
					.setText("4 : Sending child to other household");
			((CheckBox) v.findViewById(R.id.txtcol5_6))
					.setText("5 : Sending child (less than 14) to work");
			((CheckBox) v.findViewById(R.id.txtcol5_7))
					.setText("6 : Sending previously non-working adult HH member to work");
			((CheckBox) v.findViewById(R.id.txtcol5_8)).setText("7 : Begging");
			((CheckBox) v.findViewById(R.id.txtcol5_9))
					.setText("8 : Borrowing");
			((CheckBox) v.findViewById(R.id.txtcol5_10))
					.setText("9 : Sell Advance Labor");
			((CheckBox) v.findViewById(R.id.txtcol5_11))
					.setText("10 : Relief Aid");
			((CheckBox) v.findViewById(R.id.txtcol5_12))
					.setText("11 : Transfer from friend/ relative");
			((CheckBox) v.findViewById(R.id.txtcol5_13))
					.setText("12 : Others, specify");

			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());

		}

	}

	// frmCrop Production
	private void loadGuiFrmCropProduction(final ViewGroup vg) {
		// TODO Auto-generated method stub
		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();
		loadAllUiViewsFrmCropProduction(vg);

		/*
		 * ((Button) vg.findViewById(R.id.btnRefresh)) .setOnClickListener(new
		 * View.OnClickListener() {
		 * 
		 * @Override public void onClick(View arg0) {
		 * 
		 * findDataForThisSelectionFrmCropProduction(vg); } });
		 */

		((Spinner) vg.findViewById(R.id.spinnercrop))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {

						String val = ((Spinner) vg
								.findViewById(R.id.spinnercrop))
								.getSelectedItem().toString();

						if (val.length() > 0) {
							val = CommonStaticClass
									.GetSpinnerValue(((Spinner) vg
											.findViewById(R.id.spinnercrop)));
							if (val.equalsIgnoreCase("14")
									|| val.equalsIgnoreCase("23")
									|| val.equalsIgnoreCase("36")
									|| val.equalsIgnoreCase("44")
									|| val.equalsIgnoreCase("56")

									|| val.equalsIgnoreCase("77")

									|| val.equalsIgnoreCase("86")

									|| val.equalsIgnoreCase("100")

									|| val.equalsIgnoreCase("107")

							) {
								((EditText) vg.findViewById(R.id.txtother))
										.setVisibility(View.VISIBLE);
							} else {
								((EditText) vg.findViewById(R.id.txtother))
										.setVisibility(View.GONE);
							}

						}
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

		((Spinner) vg.findViewById(R.id.spinnerMonth))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub

						String val = ((Spinner) vg
								.findViewById(R.id.spinnercrop))
								.getSelectedItem().toString();

						if (val.length() > 0) {
							val = ((Spinner) vg.findViewById(R.id.spinnerplot))
									.getSelectedItem().toString();

							if (val.length() > 0) {
								val = ((Spinner) vg
										.findViewById(R.id.spinnerSeason))
										.getSelectedItem().toString();

								if (val.length() > 0) {
									val = ((Spinner) vg
											.findViewById(R.id.spinnerMonth))
											.getSelectedItem().toString();
									if (val.length() > 0) {
										findDataForThisSelectionFrmCropProduction(vg);
									}
								}
							}
						}

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

		btnPrev = (Button) vg.findViewById(R.id.prevButton);
		btnPrev.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		btnsaveNxt = (Button) vg.findViewById(R.id.saveNxtButton);
		btnsaveNxt.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateTableDataFrmCropProduction(vg);
			}

		});
		btnClear = (Button) vg.findViewById(R.id.clButton);
		btnClear.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) vg);
			}

		});
		notesButton = (Button) vg.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});
	}

	// frmvulnarable Production
	private void loadGuiFrmVulnarable(final ViewGroup vg) {
		// TODO Auto-generated method stub
		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();
		loadAllUiViewsFrmVulnarable(vg);

		((Spinner) vg.findViewById(R.id.spcol1))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {

						String val = ((Spinner) vg.findViewById(R.id.spcol1))
								.getSelectedItem().toString();

						if (val.length() > 0) {
							findDataForThisSelectionFrmVulnarable(vg);
							val = CommonStaticClass
									.GetSpinnerValue(((Spinner) vg
											.findViewById(R.id.spcol1)));
							if (val.equalsIgnoreCase("11")) {
								((EditText) vg.findViewById(R.id.txtcol1other))
										.setVisibility(View.VISIBLE);
							} else {
								((EditText) vg.findViewById(R.id.txtcol1other))
										.setVisibility(View.GONE);
							}

						}
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

		((Spinner) vg.findViewById(R.id.spcol2))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub

						String val = ((Spinner) vg.findViewById(R.id.spcol2))
								.getSelectedItem().toString();

						if (val.length() > 0) {
							val = CommonStaticClass
									.GetSpinnerValue(((Spinner) vg
											.findViewById(R.id.spcol2)));

							if (val.length() > 0) {

								if (val.equalsIgnoreCase("0")) {

									((TextView) vg.findViewById(R.id.lblcol3))
											.setVisibility(View.GONE);
									((TextView) vg.findViewById(R.id.lblcol4))
											.setVisibility(View.GONE);
									((TextView) vg.findViewById(R.id.lblcol5))
											.setVisibility(View.GONE);

									((Spinner) vg.findViewById(R.id.spcol3))
											.setVisibility(View.GONE);
									((Spinner) vg.findViewById(R.id.spcol4))
											.setVisibility(View.GONE);

									((CheckBox) vg.findViewById(R.id.txtcol5_1))
											.setVisibility(View.GONE);
									((CheckBox) vg.findViewById(R.id.txtcol5_2))
											.setVisibility(View.GONE);
									((CheckBox) vg.findViewById(R.id.txtcol5_3))
											.setVisibility(View.GONE);
									((CheckBox) vg.findViewById(R.id.txtcol5_4))
											.setVisibility(View.GONE);
									((CheckBox) vg.findViewById(R.id.txtcol5_5))
											.setVisibility(View.GONE);
									((CheckBox) vg.findViewById(R.id.txtcol5_6))
											.setVisibility(View.GONE);
									((CheckBox) vg.findViewById(R.id.txtcol5_7))
											.setVisibility(View.GONE);
									((CheckBox) vg.findViewById(R.id.txtcol5_8))
											.setVisibility(View.GONE);
									((CheckBox) vg.findViewById(R.id.txtcol5_9))
											.setVisibility(View.GONE);
									((CheckBox) vg
											.findViewById(R.id.txtcol5_10))
											.setVisibility(View.GONE);
									((CheckBox) vg
											.findViewById(R.id.txtcol5_11))
											.setVisibility(View.GONE);
									((CheckBox) vg
											.findViewById(R.id.txtcol5_12))
											.setVisibility(View.GONE);
									((CheckBox) vg
											.findViewById(R.id.txtcol5_13))
											.setVisibility(View.GONE);
								} else if (val.equalsIgnoreCase("1")) {
									((TextView) vg.findViewById(R.id.lblcol3))
											.setVisibility(View.VISIBLE);
									((TextView) vg.findViewById(R.id.lblcol4))
											.setVisibility(View.VISIBLE);
									((TextView) vg.findViewById(R.id.lblcol5))
											.setVisibility(View.VISIBLE);
									((Spinner) vg.findViewById(R.id.spcol3))
											.setVisibility(View.VISIBLE);

									((Spinner) vg.findViewById(R.id.spcol4))
											.setVisibility(View.VISIBLE);

									((CheckBox) vg.findViewById(R.id.txtcol5_1))
											.setVisibility(View.VISIBLE);
									((CheckBox) vg.findViewById(R.id.txtcol5_2))
											.setVisibility(View.VISIBLE);
									((CheckBox) vg.findViewById(R.id.txtcol5_3))
											.setVisibility(View.VISIBLE);
									((CheckBox) vg.findViewById(R.id.txtcol5_4))
											.setVisibility(View.VISIBLE);
									((CheckBox) vg.findViewById(R.id.txtcol5_5))
											.setVisibility(View.VISIBLE);
									((CheckBox) vg.findViewById(R.id.txtcol5_6))
											.setVisibility(View.VISIBLE);
									((CheckBox) vg.findViewById(R.id.txtcol5_7))
											.setVisibility(View.VISIBLE);
									((CheckBox) vg.findViewById(R.id.txtcol5_8))
											.setVisibility(View.VISIBLE);
									((CheckBox) vg.findViewById(R.id.txtcol5_9))
											.setVisibility(View.VISIBLE);
									((CheckBox) vg
											.findViewById(R.id.txtcol5_10))
											.setVisibility(View.VISIBLE);
									((CheckBox) vg
											.findViewById(R.id.txtcol5_11))
											.setVisibility(View.VISIBLE);
									((CheckBox) vg
											.findViewById(R.id.txtcol5_12))
											.setVisibility(View.VISIBLE);
									((CheckBox) vg
											.findViewById(R.id.txtcol5_13))
											.setVisibility(View.VISIBLE);
								}
							}
						}

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

		((Spinner) vg.findViewById(R.id.spcol4))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {

						String val = ((Spinner) vg.findViewById(R.id.spcol4))
								.getSelectedItem().toString();

						if (val.length() > 0) {
							// findDataForThisSelectionFrmVulnarable(vg);
							val = CommonStaticClass
									.GetSpinnerValue(((Spinner) vg
											.findViewById(R.id.spcol4)));
							if (val.equalsIgnoreCase("11")) {
								((EditText) vg.findViewById(R.id.txtcol4other))
										.setVisibility(View.VISIBLE);
							} else {
								((EditText) vg.findViewById(R.id.txtcol4other))
										.setVisibility(View.GONE);
							}

						}
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

		((CheckBox) vg.findViewById(R.id.txtcol5_13))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						if (arg1 == true) {
							((EditText) vg.findViewById(R.id.txtcol5other))
									.setVisibility(View.VISIBLE);
						} else {
							((EditText) vg.findViewById(R.id.txtcol5other))
									.setVisibility(View.GONE);
						}

					}
				});

		btnPrev = (Button) vg.findViewById(R.id.prevButton);
		btnPrev.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		btnsaveNxt = (Button) vg.findViewById(R.id.saveNxtButton);
		btnsaveNxt.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateTableDataFrmVulnarable(vg);
			}

		});
		btnClear = (Button) vg.findViewById(R.id.clButton);
		btnClear.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) vg);
			}

		});
		notesButton = (Button) vg.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});
	}

	private void updateTableDataFrmCropProduction(final ViewGroup v) {
		// TODO Auto-generated method stub

		/*
		 * if (!IsValidFrmFamilyMember(v)) return;
		 */
		// else {
		if (CheckEmptyViewGroup(v) == false) {
			CommonStaticClass
					.showMyAlert(con, "Error", "Please fill all field");
			return;
		}
		Date d = new Date(System.currentTimeMillis());
		String entryDate = "dd-mmm-yy";
		entryDate = d.toLocaleString();

		String s1 = "Insert into tblcropproduction (dataid,plotid,plotname,cropcode,season, mon, kg, other, EntryBy,EntryDate) "
				+ "    values('"
				+ CommonStaticClass.dataId
				+ "','"
				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spinnerplot)))
				+ "','"

				+ ((EditText) v.findViewById(R.id.txtplotname)).getText()
						.toString()
				+ "','"

				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spinnercrop)))
				+ "','"
				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spinnerSeason)))
				+ "','"
				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spinnerMonth)))
				+ "','"

				+ ((EditText) v.findViewById(R.id.txtkg)).getText().toString()
				+ "','"
				+ ((EditText) v.findViewById(R.id.txtother)).getText()
						.toString()
				+ "','"

				+ CommonStaticClass.userSpecificId
				+ "','"
				+ CommonStaticClass.GetCurrentDate() + "')";
		if (dbHelper.executeDMLQuery(s1)) {

		} else {
			String sqlUp = String
					.format("Update tblcropproduction Set kg='%s', other='%s'"
							+ "where dataid='%s' AND plotid='%s' AND plotname='%s' AND cropcode='%s' AND season='%s'AND mon ='%s'",

					((EditText) v.findViewById(R.id.txtkg)).getText()
							.toString(),

					((EditText) v.findViewById(R.id.txtother)).getText()
							.toString(),

					CommonStaticClass.dataId,

					CommonStaticClass.GetSpinnerValue(((Spinner) v
							.findViewById(R.id.spinnerplot))),

					((EditText) v.findViewById(R.id.txtplotname)).getText()
							.toString(),

					CommonStaticClass.GetSpinnerValue(((Spinner) v
							.findViewById(R.id.spinnercrop))),
							CommonStaticClass.GetSpinnerValue(((Spinner) v
									.findViewById(R.id.spinnerSeason))),
							CommonStaticClass.GetSpinnerValue(((Spinner) v
									.findViewById(R.id.spinnerMonth))));

			dbHelper.executeDMLQuery(sqlUp);
		}

		/*
		 * if (memberIDs.contains((Integer.parseInt(memberID) + 1) + "")) {
		 * 
		 * insertMoreFrmLandUsed(v, false); CommonStaticClass.totalHHMember =
		 * Integer.parseInt(memberID); //
		 * spinnerSL.setSelection(Integer.parseInt(memberID));
		 * 
		 * } else {
		 */
		new AlertDialog.Builder(con)
				.setTitle("Data updated")
				.setMessage("Do you want to insert more data?")
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								dialog.dismiss();
								btnClear.performClick();
								// insertMoreFrmLandUsed(v, true);
							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						dialog.dismiss();
						CommonStaticClass.findOutNextSLNo(
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQvar(),
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQnext1());
						CommonStaticClass.nextQuestion(ParentActivity.this);
						// insertMoreFrmLandUsed(v, false);
						/*
						 * CommonStaticClass.totalHHMember = Integer
						 * .parseInt(memberID);
						 */
					}
				}).setCancelable(false).show();

	}

	// frmlandused part
	private void loadGuiFrmLandUsed(final ViewGroup vg) {
		// TODO Auto-generated method stub
		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();
		loadAllUiViewsFrmLandUsed(vg);

		spinnerSL.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {

				// if (parent == spinnerSL) {
				if (spinnerSL.getItemAtPosition(pos).toString().length() > 0) {
					memberID = spinnerSL.getItemAtPosition(pos).toString();
					findDataForThisSelectionFrmLandUsed(memberID, vg);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		/*
		 * memberIDs = new ArrayList<String>(); adapterSl = new
		 * ArrayAdapter(this, android.R.layout.simple_spinner_item, memberIDs);
		 * adapterSl
		 * .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item
		 * ); spinnerSL.setAdapter(adapterSl);
		 * spinnerSL.setOnItemSelectedListener(new OnItemSelectedListener() {
		 * 
		 * @Override public void onItemSelected(AdapterView<?> arg0, View arg1,
		 * int pos, long arg3) {
		 * 
		 * // if (parent == spinnerSL) { if
		 * (spinnerSL.getItemAtPosition(pos).toString().length() > 0) { memberID
		 * = spinnerSL.getItemAtPosition(pos).toString();
		 * findDataForThisSelectionFrmLandUsed(memberID, vg); } }
		 * 
		 * @Override public void onNothingSelected(AdapterView<?> arg0) { //
		 * TODO Auto-generated method stub
		 * 
		 * }
		 * 
		 * });
		 */

		((Spinner) vg.findViewById(R.id.sprelation))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {

						if (((Spinner) vg.findViewById(R.id.sprelation))
								.getSelectedItem().toString().length() > 0) {
							if (CommonStaticClass
									.GetSpinnerValue(
											((Spinner) vg
													.findViewById(R.id.sprelation)))
									.equalsIgnoreCase("777")) {
								((EditText) vg
										.findViewById(R.id.txtrelationother))
										.setVisibility(View.VISIBLE);
							} else {

								((EditText) vg
										.findViewById(R.id.txtrelationother))
										.setVisibility(View.GONE);
							}

						} else {

							((EditText) vg.findViewById(R.id.txtrelationother))
									.setVisibility(View.GONE);
						}

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

		((Spinner) vg.findViewById(R.id.spoccupation))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {

						if (((Spinner) vg.findViewById(R.id.spoccupation))
								.getSelectedItem().toString().length() > 0) {
							if (CommonStaticClass.GetSpinnerValue(
									((Spinner) vg
											.findViewById(R.id.spoccupation)))
									.equalsIgnoreCase("777")) {
								((EditText) vg
										.findViewById(R.id.txtoccupationother))
										.setVisibility(View.VISIBLE);
							} else {
								((EditText) vg
										.findViewById(R.id.txtoccupationother))
										.setVisibility(View.GONE);
							}
						} else {
							((EditText) vg
									.findViewById(R.id.txtoccupationother))
									.setVisibility(View.GONE);
						}

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

		((Spinner) vg.findViewById(R.id.spdisability))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {

						if (((Spinner) vg.findViewById(R.id.spdisability))
								.getSelectedItem().toString().length() > 0) {
							if (CommonStaticClass.GetSpinnerValue(
									((Spinner) vg
											.findViewById(R.id.spdisability)))
									.equalsIgnoreCase("1")) {
								((Spinner) vg
										.findViewById(R.id.sptypeofdisability))
										.setVisibility(View.VISIBLE);

								((TextView) vg
										.findViewById(R.id.lbltypeofdisability))
										.setVisibility(View.VISIBLE);
							} else {
								((Spinner) vg
										.findViewById(R.id.sptypeofdisability))
										.setVisibility(View.GONE);
								((TextView) vg
										.findViewById(R.id.lbltypeofdisability))
										.setVisibility(View.GONE);
							}

						} else {
							((Spinner) vg.findViewById(R.id.sptypeofdisability))
									.setVisibility(View.GONE);
							((TextView) vg
									.findViewById(R.id.lbltypeofdisability))
									.setVisibility(View.GONE);
						}

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

		((Spinner) vg.findViewById(R.id.sptypeofdisability))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {

						if (((Spinner) vg.findViewById(R.id.sptypeofdisability))
								.getSelectedItem().toString().length() > 0) {
							if (CommonStaticClass
									.GetSpinnerValue(
											((Spinner) vg
													.findViewById(R.id.sptypeofdisability)))
									.equalsIgnoreCase("777")) {
								((EditText) vg
										.findViewById(R.id.txttypeofdisabilityother))
										.setVisibility(View.VISIBLE);
							} else {
								((EditText) vg
										.findViewById(R.id.txttypeofdisabilityother))
										.setVisibility(View.GONE);
							}

						} else {
							((EditText) vg
									.findViewById(R.id.txttypeofdisabilityother))
									.setVisibility(View.GONE);
						}

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

		btnPrev = (Button) vg.findViewById(R.id.prevButton);
		btnPrev.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		btnsaveNxt = (Button) vg.findViewById(R.id.saveNxtButton);
		btnsaveNxt.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateTableDataFrmLandUsed(vg);
			}

		});
		btnClear = (Button) vg.findViewById(R.id.clButton);
		btnClear.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) vg);
			}

		});
		notesButton = (Button) vg.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});
	}

	// frmhousehold food consumption part
	private void loadGuiFrmHouseholdFoodCompumption(final ViewGroup vg) {
		final ViewGroup v = vg;
		// TODO Auto-generated method stub
		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();
		qqq = ((TextView) vg.findViewById(R.id.qqq));
		// loadAllUiViewsFrmHouseHoldFoodConsumption(v);

		if (CommonStaticClass.langBng) {

			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				qqq.setTypeface(font);
			}
			;
			// lblSL.setTypeface(font);
			// lblSL.setText(con.getResources().getString(R.string.lblMmberIDBN));

			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());

			((TextView) v.findViewById(R.id.lblcategory)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcategory)).setText("cKvi");
			((TextView) v.findViewById(R.id.lblitem)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblitem)).setText("Lv`¨");
			((TextView) v.findViewById(R.id.lblcol2)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol2))
					.setText("weMZ 7 w`‡b wK Avcbvi Lvbvi m`m¨iv [Lv`¨] †L‡q‡Q?");

			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol2))
					.findViewById(R.id.radio0)).setTypeface(font);
			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol2))
					.findViewById(R.id.radio1)).setTypeface(font);

			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol2))
					.findViewById(R.id.radio0)).setText("n¨vu");
			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol2))
					.findViewById(R.id.radio1)).setText("bv");
			((TextView) v.findViewById(R.id.lblCol3)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblCol3)).setText("cwigvY Gi GKK");

			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol3))
					.findViewById(R.id.radio0)).setTypeface(font);
			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol3))
					.findViewById(R.id.radio1)).setTypeface(font);
			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol3))
					.findViewById(R.id.radio2)).setTypeface(font);

			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol3))
					.findViewById(R.id.radio0)).setText("MÖvg");
			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol3))
					.findViewById(R.id.radio1)).setText("†mw›UwjUvi");
			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol3))
					.findViewById(R.id.radio2)).setText("msL¨v");

			((TextView) v.findViewById(R.id.lblCol4)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblCol4))
					.setText("eZ©gv‡b GB c‡Y¨i cÖwZ GK‡Ki (col. 3 †`Lyb) µqg~j¨ KZ? (UvKvq)");

			((TextView) v.findViewById(R.id.lblCol5)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblCol5))
					.setText("weMZ 7 w`‡b evwo‡Z Drcv`b e¨ZxZ wK cwigvY †fvM Kiv n‡q‡Q?");

			((TextView) v.findViewById(R.id.lblCol6)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblCol6))
					.setText("weMZ 7 w`‡b µq Kiv e¨ZxZ wK cwigvY †fvM Kiv n‡q‡Q?");

			((TextView) v.findViewById(R.id.lblCol7)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblCol7))
					.setText("weMZ 7 w`‡b Ab¨vb¨ Drm †_‡K cÖvß wK cwigvY †fvM Kiv n‡q‡Q? (†hgb-Dcnvi)");

			((TextView) v.findViewById(R.id.lblcol8)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol8))
					.setText("MZKvj Avcbvi Lvbvi †Kvb m`m¨I wK Lv`¨ MÖnY K‡i‡Q?");

			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol8))
					.findViewById(R.id.radio0)).setTypeface(font);
			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol8))
					.findViewById(R.id.radio1)).setTypeface(font);

			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol8))
					.findViewById(R.id.radio0)).setText("n¨vu");
			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol8))
					.findViewById(R.id.radio1)).setText("bv");
		} else {

			// lblSL.setTypeface(null);

			// lblSL.setText("Episode No.");

			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());

			((TextView) v.findViewById(R.id.lblcategory)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcategory)).setText("Category");
			((TextView) v.findViewById(R.id.lblitem)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblitem)).setText("Item");
			((TextView) v.findViewById(R.id.lblcol2)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol2))
					.setText("In the past seven days, did members of your household eat [item]");

			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol2))
					.findViewById(R.id.radio0)).setTypeface(null);
			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol2))
					.findViewById(R.id.radio1)).setTypeface(null);

			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol2))
					.findViewById(R.id.radio0)).setText("Yes");
			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol2))
					.findViewById(R.id.radio1)).setText("No");
			((TextView) v.findViewById(R.id.lblCol3)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblCol3))
					.setText("Unit of quantity");

			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol3))
					.findViewById(R.id.radio0)).setTypeface(null);
			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol3))
					.findViewById(R.id.radio1)).setTypeface(null);
			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol3))
					.findViewById(R.id.radio2)).setTypeface(null);

			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol3))
					.findViewById(R.id.radio0)).setText("Grams");
			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol3))
					.findViewById(R.id.radio1)).setText("Centilitres");
			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol3))
					.findViewById(R.id.radio2)).setText("Numbers");

			((TextView) v.findViewById(R.id.lblCol4)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblCol4))
					.setText("What is the current price per unit (see col. 3) for which you could buy this product?(in taka)");

			((TextView) v.findViewById(R.id.lblCol5)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblCol5))
					.setText("In the past 7 days, what quantity was consumed out of home production?");

			((TextView) v.findViewById(R.id.lblCol6)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblCol6))
					.setText("In the past 7 days, what quantity was consumed out of purchases?");

			((TextView) v.findViewById(R.id.lblCol7)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblCol7))
					.setText("In the past 7 days, what quantity was consumed from other sources? (e.g. gifts)");

			((TextView) v.findViewById(R.id.lblcol8)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol8))
					.setText("Did any member of your household also consumed [item] yesterday?");

			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol8))
					.findViewById(R.id.radio0)).setTypeface(null);
			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol8))
					.findViewById(R.id.radio1)).setTypeface(null);

			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol8))
					.findViewById(R.id.radio0)).setText("Yes");
			((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol8))
					.findViewById(R.id.radio1)).setText("No");
		}

		((RadioGroup) vg.findViewById(R.id.radioGroupCol2))
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					public void onCheckedChanged(final RadioGroup group,
							int checkedId) {
						// TODO Auto-generated method stub

						if (((RadioButton) ((RadioGroup) vg
								.findViewById(R.id.radioGroupCol2))
								.findViewById(R.id.radio0)).isChecked()) {
							((LinearLayout) vg.findViewById(R.id.lndata))
									.setVisibility(View.VISIBLE);
						} else {
							((LinearLayout) vg.findViewById(R.id.lndata))
									.setVisibility(View.GONE);

						}

					}
				});

		filllAllSpinnerDataFrmHouseHoldFoodConsumption(v);

		btnPrev = (Button) v.findViewById(R.id.prevButton);
		btnPrev.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		btnsaveNxt = (Button) v.findViewById(R.id.saveNxtButton);
		btnsaveNxt.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				UpdatetableFrmFoodConsumption(vg);
			}

		});
		btnClear = (Button) v.findViewById(R.id.clButton);
		btnClear.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) v);
			}

		});
		notesButton = (Button) v.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});
	}

	private void filllAllSpinnerDataFrmFamilyMember(final ViewGroup v) {
		// TODO Auto-generated method stub
		if (CommonStaticClass.langBng) {
			adapterSex = new SpinAdapter(this, opSex.capBngList, true);
			adapteritem = new SpinAdapter(this, op.capBngList, true);

			// adapterMonth = new SpinAdapter(this,opMonth.capBngList, true);
			// adapterYear = new SpinAdapter(this,opYear.capBngList, true);

		} else {
			adapterSex = new ArrayAdapter(this,
					android.R.layout.simple_spinner_item, opSex.capEngList);
			adapteritem = new ArrayAdapter(this,
					android.R.layout.simple_spinner_item, op.capEngList);
		}

		adapterSex
				.setDropDownViewResource(CommonStaticClass.langBng ? R.layout.checkedspintextview
						: android.R.layout.simple_spinner_dropdown_item);
		adapteritem
				.setDropDownViewResource(CommonStaticClass.langBng ? R.layout.checkedspintextview
						: android.R.layout.simple_spinner_dropdown_item);
		spinnerSex.setAdapter(adapterSex);
		spinneritem.setAdapter(adapteritem);
		/*
		 * spinnerSex .setOnItemSelectedListener(new
		 * spinItemSelectListenerFrmFamilyMember());
		 */

		adapterSl = new ArrayAdapter(this,
				android.R.layout.simple_spinner_item, memberIDs);
		adapterSl
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerSL.setAdapter(adapterSl);
		spinnerSL.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {

				// if (parent == spinnerSL) {
				if (spinnerSL.getItemAtPosition(pos).toString().length() > 0) {
					memberID = spinnerSL.getItemAtPosition(pos).toString();
					findDataForThisSelectionFrmFamilyMember(memberID, v);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		spinneritem.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {

				if (spinneritem.getSelectedItem().toString().length() > 0) {
					if (CommonStaticClass.GetSpinnerValue(spinneritem)
							.equalsIgnoreCase("99")) {
						((EditText) v.findViewById(R.id.txtother))
								.setVisibility(View.VISIBLE);
					} else {
						((EditText) v.findViewById(R.id.txtother))
								.setVisibility(View.GONE);
					}

				} else {
					((EditText) v.findViewById(R.id.txtother))
							.setVisibility(View.GONE);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});
		// .setOnItemSelectedListener(new
		// spinItemSelectListenerFrmFamilyMember());

		checkDataBaseHasLinesOrNotFrmFamilyMember();

	}

	private void filllAllSpinnerDataFrmLandUsed(final ViewGroup v) {
		// TODO Auto-generated method stub

		if (CommonStaticClass.langBng) {

			ArrayList<String> ids = new ArrayList<String>();

			ids.add("1 : 15 wgwb‡Ui Kg");

			ids.add("2 : 15-30 wgwbU");

			ids.add("3 : 30-60 wgwbU");

			ids.add("4 : 1-2 N›Uv");

			ids.add("5 : 2 N›Uvi †ewk");
			/*
			 * CommonStaticClass.FillCombo(thisactivity, ids, ((Spinner)
			 * v.findViewById(R.id.sp4)));
			 */

			ids = new ArrayList<String>();
			ids.add("1 : Askx`vix Avev`");
			ids.add("2 : eM©v †bqv");
			ids.add("3 : †hŠ");
			ids.add("4 : wbR¯^");
			ids.add("5 : eÜK †bqv");
			ids.add("6 : Ab¨vb¨");
			/*
			 * CommonStaticClass.FillCombo(thisactivity, ids, ((Spinner)
			 * v.findViewById(R.id.sp5)));
			 */

			// Column 7

			ids = new ArrayList<String>();
			ids.add("1 : K…wl");
			ids.add("2 : grm¨");
			ids.add("3 : cïcvjb");
			ids.add("4 : emZ-evwo");
			ids.add("5 : †SvcSvo");
			ids.add("6 : Ab¨vb¨evwYwR¨K e¨envi");
			ids.add("7 : Abvev`x / cwZZ Rwg");
			ids.add("8 : Ab¨vb¨");
			/*
			 * CommonStaticClass.FillCombo(thisactivity, ids, ((Spinner)
			 * v.findViewById(R.id.sp7)));
			 */
			// Column 8
			ids = new ArrayList<String>();
			ids.add("1 : †mP");
			ids.add("2 : e„wói cvwb");
			ids.add("3 : Rjvf’wg");
			ids.add("4 : Mfxi bjK’c");
			ids.add("5 : AMfxi bjK’c");
			ids.add("6 : evjwZ w`‡q");
			ids.add("7 : Wb");
			ids.add("8 : K’c");
			ids.add("9 : cv PvwjZ cv¤c");
			ids.add("10 : cvIqvi cv¤^c");
			ids.add("11 : ‡jv wjdU cv¤ú");
			ids.add("12 : Ab¨vb¨ †mP e¨e¯’v");
			ids.add("88 : cÖ‡hvR¨ bq");
			/*
			 * CommonStaticClass.FillCombo(thisactivity, ids, ((Spinner)
			 * v.findViewById(R.id.sp8)));
			 */

			// Column 9
			ids = new ArrayList<String>();
			ids.add("1 : Lvbvi cyi“l m`m¨");
			ids.add("2 : Lvbvi gwnjv/bvix m`m¨");
			ids.add("3 : cyiæl I gwnjv Dfq m`m¨");
			ids.add("88 : cÖ‡hvR¨ bq");
			/*
			 * CommonStaticClass.FillCombo(thisactivity, ids, ((Spinner)
			 * v.findViewById(R.id.sp9)));
			 */

		} else {

			// column 4
			ArrayList<String> ids = new ArrayList<String>();

			ids.add("1 : less than 15 minutes");
			ids.add("2 : 15-30 minutes");
			ids.add("3 : 30-60 minutes");
			ids.add("4 : 1-2 hours");
			ids.add("5 : more than 2 hours");

			/*
			 * CommonStaticClass.FillCombo(thisactivity, ids, ((Spinner)
			 * v.findViewById(R.id.sp4)));
			 */

			// Column 5
			ids = new ArrayList<String>();
			ids.add("1 : share cropping");
			ids.add("2 : leasing in");
			ids.add("3 : joint");
			ids.add("4 : owned");
			ids.add("5 : Lent in");
			ids.add("6 : Other");

			/*
			 * CommonStaticClass.FillCombo(thisactivity, ids, ((Spinner)
			 * v.findViewById(R.id.sp5)));
			 */

			// Column 7
			ids = new ArrayList<String>();
			ids.add("1 : agriculture");
			ids.add("2 : fisheries");
			ids.add("3 : grazing");
			ids.add("4 : homestead");
			ids.add("5 : bush");
			ids.add("6 : other commercial use");
			ids.add("7 : fallow");
			ids.add("8 : other");

			/*
			 * CommonStaticClass.FillCombo(thisactivity, ids, ((Spinner)
			 * v.findViewById(R.id.sp7)));
			 */

			// Column 8
			ids = new ArrayList<String>();
			ids.add("1 : Canal Irrigation");
			ids.add("2 : Rain-fed");
			ids.add("3 : swamp /wetland");
			ids.add("4 : Deep Tubewell");
			ids.add("5 : Shallow Tubewell");
			ids.add("6 : Swing basket");
			ids.add("7 : Don");
			ids.add("8 : Dugwell");
			ids.add("9 : Treadle Pump");
			ids.add("10 : Rower Pump");
			ids.add("11 : Low lift Pump");
			ids.add("12 : other type of irrigation");
			ids.add("88 : Not Applicable");

			/*
			 * CommonStaticClass.FillCombo(thisactivity, ids, ((Spinner)
			 * v.findViewById(R.id.sp8)));
			 */
			// Column 9
			ids = new ArrayList<String>();
			ids.add("1 : Male Member");
			ids.add("2 : Female Member");
			ids.add("3 : Both");
			ids.add("88 : Not Applicable");
			/*
			 * CommonStaticClass.FillCombo(thisactivity, ids, ((Spinner)
			 * v.findViewById(R.id.sp9)));
			 */

		}

		/*
		 * adapterSl = new ArrayAdapter(this,
		 * android.R.layout.simple_spinner_item, memberIDs); adapterSl
		 * .setDropDownViewResource
		 * (android.R.layout.simple_spinner_dropdown_item);
		 * spinnerSL.setAdapter(adapterSl);
		 * spinnerSL.setOnItemSelectedListener(new OnItemSelectedListener() {
		 * 
		 * @Override public void onItemSelected(AdapterView<?> arg0, View arg1,
		 * int pos, long arg3) {
		 * 
		 * // if (parent == spinnerSL) { if
		 * (spinnerSL.getItemAtPosition(pos).toString().length() > 0) { memberID
		 * = spinnerSL.getItemAtPosition(pos).toString();
		 * findDataForThisSelectionFrmLandUsed(memberID, v); } }
		 * 
		 * @Override public void onNothingSelected(AdapterView<?> arg0) { //
		 * TODO Auto-generated method stub
		 * 
		 * }
		 * 
		 * });
		 */
		// .setOnItemSelectedListener(new
		// spinItemSelectListenerFrmFamilyMember());

		checkDataBaseHasLinesOrNotFrmFamilyMember();

	}

	private void filllAllSpinnerDataFrmHouseHoldFoodConsumption(
			final ViewGroup v) {
		// TODO Auto-generated method stub
		String sql = "";

		try {
			if (!CommonStaticClass.langBng) {
				sql = "SELECT (" + "" + "CategoryID" + "" + "|| " + ""
						+ "' : '" + " || " + "CategoryDescriptionEng" + ") AS "
						+ "D" + " from Category ORDER BY CategoryID" + "";
			} else {
				sql = "SELECT (" + "" + "CategoryID" + "" + "|| " + ""
						+ "' : '" + " || " + "CategoryDescriptionBng" + ") AS "
						+ "D" + " from Category ORDER BY CategoryID" + "";
			}

			CommonStaticClass.FillCombo(thisactivity, dbHelper, sql,
					((Spinner) v.findViewById(R.id.spcategory)));

			((Spinner) v.findViewById(R.id.spcategory))
					.setOnItemSelectedListener(new OnItemSelectedListener()

					{

						@Override
						public void onItemSelected(AdapterView<?> arg0,
								View arg1, int arg2, long arg3) {
							String sql = "";
							if (!CommonStaticClass.langBng) {

								sql = "SELECT ("
										+ ""
										+ "ItemID"
										+ ""
										+ "|| "
										+ ""
										+ "' : '"
										+ " || "
										+ "ItemDescriptionEng"
										+ ") AS "
										+ "D"
										+ " from Item  WHERE CategoryID = '"
										+ CommonStaticClass.GetSpinnerValue(((Spinner) v
												.findViewById(R.id.spcategory)))
										+ "' ORDER BY ItemID" + "";
							} else {
								sql = "SELECT ("
										+ ""
										+ "ItemID"
										+ ""
										+ "|| "
										+ ""
										+ "' : '"
										+ " || "
										+ "ItemDescriptionBng"
										+ ") AS "
										+ "D"
										+ " from Item  WHERE CategoryID = '"
										+ CommonStaticClass.GetSpinnerValue(((Spinner) v
												.findViewById(R.id.spcategory)))
										+ "' ORDER BY ItemID" + "";
							}

							CommonStaticClass.FillCombo(thisactivity, dbHelper,
									sql, ((Spinner) v
											.findViewById(R.id.spitemcolumn)));

						}

						@Override
						public void onNothingSelected(AdapterView<?> arg0) {
							// TODO Auto-generated method stub

						}
					});

			((Spinner) v.findViewById(R.id.spitemcolumn))
					.setOnItemSelectedListener(new OnItemSelectedListener() {

						@Override
						public void onItemSelected(AdapterView<?> arg0,
								View arg1, int arg2, long arg3) {
							String sql = "SELECT * FROM tblFoodConsumption WHERE dataid='"
									+ CommonStaticClass.dataId
									+ "' AND CategoryID = '"
									+ CommonStaticClass.GetSpinnerValue(((Spinner) v
											.findViewById(R.id.spcategory)))
									+ "' AND ItemID = '"
									+ CommonStaticClass.GetSpinnerValue(((Spinner) v
											.findViewById(R.id.spitemcolumn)))
									+ "'";

							Cursor mCursor = null;

							mCursor = dbHelper.getQueryCursor(sql);

							if (mCursor.getCount() > 0) {

								if (mCursor.moveToFirst()) {

									do {
										if (CommonStaticClass.GetCursorValue(
												mCursor, "col2") != null) {
											if (CommonStaticClass
													.GetCursorValue(mCursor,
															"col2") != "") {

												if (CommonStaticClass
														.GetCursorValue(
																mCursor, "col2")
														.equalsIgnoreCase("1")) {
													((RadioButton) ((RadioGroup) v
															.findViewById(R.id.radioGroupCol2))
															.findViewById(R.id.radio0))
															.setChecked(true);
												} else if (CommonStaticClass
														.GetCursorValue(
																mCursor, "col2")
														.equalsIgnoreCase("2")) {
													((RadioButton) ((RadioGroup) v
															.findViewById(R.id.radioGroupCol2))
															.findViewById(R.id.radio1))
															.setChecked(true);
												}

											}
										}

										if (CommonStaticClass.GetCursorValue(
												mCursor, "col3") != null) {
											if (CommonStaticClass
													.GetCursorValue(mCursor,
															"col3") != "") {

												if (CommonStaticClass
														.GetCursorValue(
																mCursor, "col3")
														.equalsIgnoreCase("1")) {
													((RadioButton) ((RadioGroup) v
															.findViewById(R.id.radioGroupCol3))
															.findViewById(R.id.radio0))
															.setChecked(true);
												} else if (CommonStaticClass
														.GetCursorValue(
																mCursor, "col3")
														.equalsIgnoreCase("2")) {
													((RadioButton) ((RadioGroup) v
															.findViewById(R.id.radioGroupCol3))
															.findViewById(R.id.radio1))
															.setChecked(true);
												} else if (CommonStaticClass
														.GetCursorValue(
																mCursor, "col3")
														.equalsIgnoreCase("3")) {
													((RadioButton) ((RadioGroup) v
															.findViewById(R.id.radioGroupCol3))
															.findViewById(R.id.radio2))
															.setChecked(true);
												}
											}
										}

										if (CommonStaticClass.GetCursorValue(
												mCursor, "col4") != null) {
											if (CommonStaticClass
													.GetCursorValue(mCursor,
															"col4") != "") {

												((EditText) v
														.findViewById(R.id.etcol4))
														.setText(CommonStaticClass
																.GetCursorValue(
																		mCursor,
																		"col4"));
											}
										}

										if (CommonStaticClass.GetCursorValue(
												mCursor, "col5") != null) {
											if (CommonStaticClass
													.GetCursorValue(mCursor,
															"col5") != "") {

												((EditText) v
														.findViewById(R.id.etcol5))
														.setText(CommonStaticClass
																.GetCursorValue(
																		mCursor,
																		"col5"));
											}
										}

										if (CommonStaticClass.GetCursorValue(
												mCursor, "col6") != null) {
											if (CommonStaticClass
													.GetCursorValue(mCursor,
															"col6") != "") {

												((EditText) v
														.findViewById(R.id.etcol6))
														.setText(CommonStaticClass
																.GetCursorValue(
																		mCursor,
																		"col6"));
											}
										}

										if (CommonStaticClass.GetCursorValue(
												mCursor, "col7") != null) {
											if (CommonStaticClass
													.GetCursorValue(mCursor,
															"col7") != "") {

												((EditText) v
														.findViewById(R.id.etcol7))
														.setText(CommonStaticClass
																.GetCursorValue(
																		mCursor,
																		"col7"));
											}
										}

										if (CommonStaticClass.GetCursorValue(
												mCursor, "col8") != "") {

											if (CommonStaticClass
													.GetCursorValue(mCursor,
															"col8")
													.equalsIgnoreCase("1")) {
												((RadioButton) ((RadioGroup) v
														.findViewById(R.id.radioGroupCol8))
														.findViewById(R.id.radio0))
														.setChecked(true);
											} else if (CommonStaticClass
													.GetCursorValue(mCursor,
															"col8")
													.equalsIgnoreCase("2")) {
												((RadioButton) ((RadioGroup) v
														.findViewById(R.id.radioGroupCol8))
														.findViewById(R.id.radio1))
														.setChecked(true);
											}

										}

									} while (mCursor.moveToNext());

								}
							} else {

								((RadioGroup) v
										.findViewById(R.id.radioGroupCol3))
										.clearCheck();

								((EditText) v.findViewById(R.id.etcol4))
										.setText("");

								((EditText) v.findViewById(R.id.etcol5))
										.setText("");

								((EditText) v.findViewById(R.id.etcol6))
										.setText("");

								((EditText) v.findViewById(R.id.etcol7))
										.setText("");

								((RadioGroup) v
										.findViewById(R.id.radioGroupCol8))
										.clearCheck();
								((RadioGroup) v
										.findViewById(R.id.radioGroupCol3))
										.clearCheck();
								((RadioGroup) v
										.findViewById(R.id.radioGroupCol2))
										.clearCheck();

							}
						}

						// resetViewGroup(v);

						@Override
						public void onNothingSelected(AdapterView<?> arg0) {
							// TODO Auto-generated method stub

						}
					});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void filllAllSpinnerDataq124() {
		// TODO Auto-generated method stub
		if (CommonStaticClass.langBng) {
			adapterSex = new SpinAdapter(this, opSex.capBngList, true);
			// adapterMonth = new SpinAdapter(this,opMonth.capBngList, true);
			// adapterYear = new SpinAdapter(this,opYear.capBngList, true);

		} else {
			adapterSex = new ArrayAdapter(this,
					android.R.layout.simple_spinner_item, opSex.capEngList);
		}

		adapterSex
				.setDropDownViewResource(CommonStaticClass.langBng ? R.layout.checkedspintextview
						: android.R.layout.simple_spinner_dropdown_item);
		spinnerc2.setAdapter(adapterSex);
		// spinnerc2.setOnItemSelectedListener(new
		// spinItemSelectListenerq124());

		adapterSl = new ArrayAdapter(this,
				android.R.layout.simple_spinner_item, memberIDs);
		adapterSl
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerc1.setAdapter(adapterSl);
		// spinnerc1.setOnItemSelectedListener(new
		// spinItemSelectListenerq124());

		checkDataBaseHasLinesOrNotq124();

	}

	private void checkDataBaseHasLinesOrNotFrmFamilyMember() {
		// TODO Auto-generated method stub
		// String sql = "Select * from '%s' where dataid = '"
		// + CommonStaticClass.dataId + "'";

		String sql = String.format("Select * from '%s' where dataid = '%s'",
				CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getTablename(),
				CommonStaticClass.dataId);

		Cursor mCursor1 = null;
		String serialNo = "";
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				if (!memberIDs.isEmpty()) {
					memberIDs.clear();
				}
				int i = 1;
				if (mCursor1.moveToFirst()) {
					do {

						serialNo = String.valueOf(i);
						memberIDs.add(serialNo);

						if (i != (mCursor1.getCount() + 1)) {
							i++;
						}

					} while (mCursor1.moveToNext());

					adapterSl.notifyDataSetChanged();
					spinnerSL.setSelection(0);
				}
			} else {
				memberIDs.add("1");
				adapterSl.notifyDataSetChanged();
				spinnerSL.setSelection(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}
	}

	private void checkDataBaseHasLinesOrNotq124() {
		// TODO Auto-generated method stub
		String sql = "Select * from tblTravel where dataid = '"
				+ CommonStaticClass.dataId + "'";
		Cursor mCursor1 = null;
		String serialNo = "";
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				if (!memberIDs.isEmpty()) {
					memberIDs.clear();
				}
				int i = 1;
				if (mCursor1.moveToFirst()) {
					do {
						serialNo = String.valueOf(i);
						memberIDs.add(serialNo);

						/*
						 * memberIDs.add(CommonStaticClass.dataId.substring(0,
						 * 5) + serialNo.substring(serialNo.length() - 2,
						 * serialNo.length()));
						 */
						if (i != (mCursor1.getCount() + 1)) {
							i++;
						}

					} while (mCursor1.moveToNext());

					adapterSl.notifyDataSetChanged();
					spinnerc1.setSelection(0);
				}
			} else {
				memberIDs.add("1");
				adapterSl.notifyDataSetChanged();
				spinnerc1.setSelection(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}
	}

	/*
	 * class spinItemSelectListenerFrmFamilyMember(ViewGroup v) implements
	 * OnItemSelectedListener {
	 * 
	 * public void onItemSelected(AdapterView<?> parent, View arg1, int pos,
	 * long arg3) { // TODO Auto-generated method stub if (parent == spinnerSL)
	 * { if (parent.getItemAtPosition(pos).toString().length() > 0) { memberID =
	 * parent.getItemAtPosition(pos).toString();
	 * findDataForThisSelectionFrmFamilyMember(memberID); } } else if (parent ==
	 * spinnerSex) { if (parent.getItemAtPosition(pos).toString().length() > 0)
	 * { sex = opSex.codeList.get(pos) + ""; } }
	 * 
	 * }
	 */

	/*
	 * public void onNothingSelected(AdapterView<?> arg0) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 */

	// }

	/*
	 * class spinItemSelectListenerq124 implements OnItemSelectedListener {
	 * 
	 * public void onItemSelected(AdapterView<?> parent, View arg1, int pos,
	 * long arg3) { // TODO Auto-generated method stub if (parent == spinnerc1)
	 * { if (parent.getItemAtPosition(pos).toString().length() > 0) { memberID =
	 * parent.getItemAtPosition(pos).toString();
	 * findDataForThisSelectionq124(memberID); } } else if (parent == spinnerc2)
	 * { if (parent.getItemAtPosition(pos).toString().length() > 0) { sex =
	 * opSex.codeList.get(pos) + ""; if (pos == 2) { ((EditText)
	 * findViewById(R.id.etother)) .setVisibility(View.VISIBLE); } else {
	 * ((EditText) findViewById(R.id.etother)) .setVisibility(View.GONE); } } }
	 * 
	 * }
	 * 
	 * public void onNothingSelected(AdapterView<?> arg0) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 */// }
	private void UpdatetableFrmFoodConsumption(ViewGroup v) {

		if (CheckEmptyViewGroup(v) == false) {
			CommonStaticClass.showMyAlert(con, "Error", "Fill all fields");
			return;
		}

		String col2 = "", col3 = "", col4 = "", col5 = "", col6 = "", col7 = "", col8 = "";
		if (((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol2))
				.findViewById(R.id.radio0)).isChecked()) {
			col2 = "1";
		} else if (((RadioButton) ((RadioGroup) v
				.findViewById(R.id.radioGroupCol2)).findViewById(R.id.radio1))
				.isChecked()) {
			col2 = "2";
			col3 = "";
			col4 = "";
			col5 = "";
			col6 = "";
			col7 = "";
			col8 = "";
		}

		if (((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol3))
				.findViewById(R.id.radio0)).isChecked()) {
			col3 = "1";
		} else if (((RadioButton) ((RadioGroup) v
				.findViewById(R.id.radioGroupCol3)).findViewById(R.id.radio1))
				.isChecked()) {
			col3 = "2";
		} else if (((RadioButton) ((RadioGroup) v
				.findViewById(R.id.radioGroupCol3)).findViewById(R.id.radio2))
				.isChecked()) {
			col3 = "3";
		}
		col4 = ((EditText) v.findViewById(R.id.etcol4)).getText().toString();
		col5 = ((EditText) v.findViewById(R.id.etcol5)).getText().toString();
		col6 = ((EditText) v.findViewById(R.id.etcol6)).getText().toString();
		col7 = ((EditText) v.findViewById(R.id.etcol7)).getText().toString();

		if (((RadioButton) ((RadioGroup) v.findViewById(R.id.radioGroupCol8))
				.findViewById(R.id.radio0)).isChecked()) {
			col8 = "1";
		} else if (((RadioButton) ((RadioGroup) v
				.findViewById(R.id.radioGroupCol8)).findViewById(R.id.radio1))
				.isChecked()) {
			col8 = "2";
		}

		String sql = String
				.format("INSERT INTO tblFoodConsumption (dataid,CategoryID,ItemID, Col2,Col3,Col4,Col5,Col6,Col7,Col8, EntryBy, EntryDate)"
						+ " VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
						CommonStaticClass.dataId, CommonStaticClass
								.GetSpinnerValue((Spinner) v
										.findViewById(R.id.spcategory)),
						CommonStaticClass.GetSpinnerValue((Spinner) v
								.findViewById(R.id.spitemcolumn)), col2, col3,
						col4, col5, col6, col7, col8,
						CommonStaticClass.userSpecificId, CommonStaticClass
								.GetCurrentDate());

		if (dbHelper.executeDMLQuery(sql))

		{
			resetViewGroup(v);
		} else {
			sql = String
					.format("Update tblFoodConsumption SET Col2='%s',Col3='%s',Col4='%s',Col5='%s',Col6='%s',Col7='%s',Col8='%s' WHERE"
							+ " dataid = '%s' AND CategoryID = '%s' AND ItemID = '%s' ",
							col2, col3, col4, col5, col6, col7, col8,
							CommonStaticClass.dataId, CommonStaticClass
									.GetSpinnerValue((Spinner) v
											.findViewById(R.id.spcategory)),
							CommonStaticClass.GetSpinnerValue((Spinner) v
									.findViewById(R.id.spitemcolumn)));
			dbHelper.executeDMLQuery(sql);
		}

		new AlertDialog.Builder(con)
				.setTitle("Data updated")
				.setMessage("Do you want to insert more data?")
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								/*
								 * ((RadioButton) ((RadioGroup) v
								 * .findViewById(R.id.radioGroupCol2))
								 * .findViewById
								 * (R.id.radio0)).setChecked(false);
								 * 
								 * ((RadioButton) ((RadioGroup) v
								 * .findViewById(R.id.radioGroupCol2))
								 * .findViewById
								 * (R.id.radio1)).setChecked(false);
								 * 
								 * ((RadioButton) ((RadioGroup) v
								 * .findViewById(R.id.radioGroupCol3))
								 * .findViewById
								 * (R.id.radio0)).setChecked(false);
								 * 
								 * ((RadioButton) ((RadioGroup) v
								 * .findViewById(R.id.radioGroupCol3))
								 * .findViewById
								 * (R.id.radio1)).setChecked(false);
								 * 
								 * ((RadioButton) ((RadioGroup) v
								 * .findViewById(R.id.radioGroupCol3))
								 * .findViewById
								 * (R.id.radio2)).setChecked(false);
								 * 
								 * ((EditText)
								 * v.findViewById(R.id.etcol4)).setText("");
								 * 
								 * ((EditText)
								 * v.findViewById(R.id.etcol5)).setText("");
								 * 
								 * ((EditText)
								 * v.findViewById(R.id.etcol6)).setText("");
								 * 
								 * ((EditText)
								 * v.findViewById(R.id.etcol7)).setText("");
								 * 
								 * ((RadioButton) ((RadioGroup) v
								 * .findViewById(R.id.radioGroupCol2))
								 * .findViewById
								 * (R.id.radio0)).setChecked(false);
								 * 
								 * ((RadioButton) ((RadioGroup) v
								 * .findViewById(R.id.radioGroupCol8))
								 * .findViewById
								 * (R.id.radio1)).setChecked(false);
								 */
								dialog.dismiss();

							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						dialog.dismiss();
						CommonStaticClass.findOutNextSLNo(
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQvar(),
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQnext1());
						CommonStaticClass.nextQuestion(ParentActivity.this);

					}
				}).setCancelable(false).show();
	}

	private boolean IsValidFrmFamilyMember(ViewGroup v) {
		boolean IsValid = false;

		sex = opSex.codeList.get(spinnerSex.getSelectedItemPosition())
				.toString();

		if (((EditText) v.findViewById(R.id.txtdob)).getText().toString()
				.length() == 0) {
			CommonStaticClass.showMyAlert(con, "Error", "Age is Empty.");
			return IsValid;
		}
		if (((Spinner) v.findViewById(R.id.spinnerEducation)).getSelectedItem()
				.toString().length() == 0) {
			CommonStaticClass.showMyAlert(con, "Error",
					"Please select Education.");
			return IsValid;
		}
		if (((EditText) v.findViewById(R.id.txtchildname)).getText().toString()
				.length() == 0) {
			CommonStaticClass.showMyAlert(con, "Error",
					"Please Enter Child Name.");
			return IsValid;
		}
		if (sex.length() == 0) {
			CommonStaticClass.showMyAlert(con, "Error", "Please Enter Gender.");
			return IsValid;
		}
		/*
		 * if (relation.length() == 0) { CommonStaticClass.showMyAlert(con,
		 * "Error", "Relation is empty."); return IsValid; }
		 */
		/*
		 * if (Integer.parseInt(AgeMonth) > 12) {
		 * CommonStaticClass.showMyAlert(con, "Error",
		 * "Age Month  must be less than 12."); return IsValid; }
		 */
		/*
		 * f if (Integer.parseInt(AgeMonth) > 100) {
		 * CommonStaticClass.showMyAlert(con, "Error",
		 * "Age Month  must be less than 100."); return IsValid; }
		 */
		return true;
	}

	private void updateTableDataFrmproductionmarketinglivestock(
			final ViewGroup v) {

		if (CommonStaticClass.GetSpinnerValue(
				((Spinner) v.findViewById(R.id.spcol1))).equalsIgnoreCase("12")) {

			String s1 = "Insert into tblproductionmarketinglivestock (dataid,code,col2,col3,col4a,col4b,col5a,col5b,col6,col7a,col7b,col1other,col6other,EntryBy,EntryDate) "
					+ "    values('"
					+ CommonStaticClass.dataId
					+ "','"
					+ CommonStaticClass.GetSpinnerValue(((Spinner) v
							.findViewById(R.id.spcol1)))
					+ "','"

					+ "','"

					+ "','"

					+ "','"

					+ "','"

					+ "','"

					+ "','"

					+ "','"

					+ "','"

					+ "','"

					+ "','"

					+ "','"

					+ CommonStaticClass.userSpecificId
					+ "','"
					+ CommonStaticClass.GetCurrentDate() + "')";
			if (dbHelper.executeDMLQuery(s1)) {

			} else {
				String sqlUp = String
						.format("Update tblproductionmarketinglivestock Set col2='%s',col3='%s',col4a='%s',col4b='%s',col5a='%s',col5b='%s',col6='%s',col7a='%s',col7b='%s',col1other='%s',col6other='%s'"
								+ " where dataid='%s' AND code='%s'",

						"''",

						"''",

						"''",

						"''",

						"''",

						"''",

						"''",

						"''",

						"''",

						"''",

						"''",

						CommonStaticClass.dataId,

						CommonStaticClass.GetSpinnerValue(((Spinner) v
								.findViewById(R.id.spcol1)))

						);

				dbHelper.executeDMLQuery(sqlUp);

			}
			CommonStaticClass.findOutNextSLNo(
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar(),
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQnext1());
			CommonStaticClass.nextQuestion(ParentActivity.this);
			return;
		}

		if (CheckEmptyViewGroup(v) == false) {
			CommonStaticClass.showMyAlert(con, "Error", "Fill all fields");
			return;
		}

		String s1 = "Insert into tblproductionmarketinglivestock (dataid,code,col2,col3,col4a,col4b,col5a,col5b,col6,col7a,col7b,col1other,col6other,EntryBy,EntryDate) "
				+ "    values('"
				+ CommonStaticClass.dataId
				+ "','"
				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spcol1)))
				+ "','"

				+ ((EditText) v.findViewById(R.id.txtcol2)).getText()
						.toString()
				+ "','"

				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spcol3)))
				+ "','"

				+ ((EditText) v.findViewById(R.id.txtcol4_1)).getText()
						.toString()
				+ "','"

				+ ((EditText) v.findViewById(R.id.txtcol4_2)).getText()
						.toString()
				+ "','"

				+ ((EditText) v.findViewById(R.id.txtcol5_1)).getText()
						.toString()
				+ "','"

				+ ((EditText) v.findViewById(R.id.txtcol5_2)).getText()
						.toString()
				+ "','"

				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spcol6)))
				+ "','"

				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spcol7_1)))
				+ "','"

				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spcol7_2)))
				+ "','"

				+ ((EditText) v.findViewById(R.id.txtcol1other)).getText()
						.toString()
				+ "','"

				+ ((EditText) v.findViewById(R.id.txtcol6other)).getText()
						.toString()
				+ "','"

				+ CommonStaticClass.userSpecificId
				+ "','"
				+ CommonStaticClass.GetCurrentDate() + "')";
		if (dbHelper.executeDMLQuery(s1)) {

		} else {
			String sqlUp = String
					.format("Update tblproductionmarketinglivestock Set col2='%s',col3='%s',col4a='%s',col4b='%s',col5a='%s',col5b='%s',col6='%s',col7a='%s',col7b='%s',col1other='%s',col6other='%s'"
							+ " where dataid='%s' AND code='%s'",

					((EditText) v.findViewById(R.id.txtcol2)).getText()
							.toString(),

					CommonStaticClass.GetSpinnerValue((Spinner) v
							.findViewById(R.id.spcol3)),

					((EditText) v.findViewById(R.id.txtcol4_1)).getText()
							.toString(),

					((EditText) v.findViewById(R.id.txtcol4_2)).getText()
							.toString(),

					((EditText) v.findViewById(R.id.txtcol5_1)).getText()
							.toString(),

					((EditText) v.findViewById(R.id.txtcol5_2)).getText()
							.toString(),

					CommonStaticClass.GetSpinnerValue((Spinner) v
							.findViewById(R.id.spcol6)),

					CommonStaticClass.GetSpinnerValue((Spinner) v
							.findViewById(R.id.spcol7_1)),

					CommonStaticClass.GetSpinnerValue((Spinner) v
							.findViewById(R.id.spcol7_2)),

					((EditText) v.findViewById(R.id.txtcol1other)).getText()
							.toString(), ((EditText) v
							.findViewById(R.id.txtcol6other)).getText()
							.toString(),

					CommonStaticClass.dataId,

					CommonStaticClass.GetSpinnerValue(((Spinner) v
							.findViewById(R.id.spcol1)))

					);

			dbHelper.executeDMLQuery(sqlUp);

		}

		new AlertDialog.Builder(con)
				.setTitle("Data updated")
				.setMessage("Do you want to insert more data?")
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								dialog.dismiss();
								btnClear.performClick();
							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						dialog.dismiss();
						CommonStaticClass.findOutNextSLNo(
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQvar(),
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQnext1());
						CommonStaticClass.nextQuestion(ParentActivity.this);

					}
				}).setCancelable(false).show();

	}

	// frmlivestockproducts
	private void updateTableDataFrmlivestockproducts(final ViewGroup v) {
		// TODO Auto-generated method stub

		if (CommonStaticClass.GetSpinnerValue(
				((Spinner) v.findViewById(R.id.spcol1))).equalsIgnoreCase("6")) {

			String s1 = "Insert into tbllivestockproducts (dataid,code,col2,col3,col4,col5,col6,col7,col8,col9,col10,col1other,col7other,EntryBy,EntryDate) "
					+ "    values('"
					+ CommonStaticClass.dataId
					+ "','"

					+ "','"

					+ "','"

					+ "','"

					+ "','"

					+ "','"

					+ "','"

					+ "','"

					+ "','"

					+ "','"

					+ "','"

					+ "','"

					+ "','"

					+ CommonStaticClass.userSpecificId
					+ "','"
					+ CommonStaticClass.GetCurrentDate() + "')";
			if (dbHelper.executeDMLQuery(s1)) {

			} else {
				String sqlUp = String
						.format("Update tbllivestockproducts Set col2='%s',col3='%s',col4='%s',col5='%s',col6='%s',col7='%s',col8='%s',col9='%s',col10='%s',col1other='%s',col7other='%s'"
								+ " where dataid='%s' AND code='%s'",

						"''",

						"''",

						"''",

						"''",

						"''",

						"''",

						"''",

						"''",

						"''",

						"''",

						"''",

						CommonStaticClass.dataId,

						CommonStaticClass.GetSpinnerValue(((Spinner) v
								.findViewById(R.id.spcol1)))

						);

				dbHelper.executeDMLQuery(sqlUp);
			}

			CommonStaticClass.findOutNextSLNo(
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar(),
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQnext1());
			CommonStaticClass.nextQuestion(ParentActivity.this);
			return;
		}

		if (CheckEmptyViewGroup(v) == false) {
			CommonStaticClass.showMyAlert(con, "Error", "Fill all fields");
			return;
		}

		String s1 = "Insert into tbllivestockproducts (dataid,code,col2,col3,col4,col5,col6,col7,col8,col9,col10,col1other,col7other,EntryBy,EntryDate) "
				+ "    values('"
				+ CommonStaticClass.dataId
				+ "','"
				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spcol1)))
				+ "','"

				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spcol2)))
				+ "','"

				+ ((EditText) v.findViewById(R.id.txtcol3)).getText()
						.toString()
				+ "','"

				+ ((EditText) v.findViewById(R.id.txtcol4)).getText()
						.toString()
				+ "','"

				+ ((EditText) v.findViewById(R.id.txtcol5)).getText()
						.toString()
				+ "','"

				+ ((EditText) v.findViewById(R.id.txtcol6)).getText()
						.toString()
				+ "','"

				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spcol7)))
				+ "','"

				+ ((EditText) v.findViewById(R.id.txtcol8)).getText()
						.toString()
				+ "','"

				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spcol9)))
				+ "','"

				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spcol10)))
				+ "','"

				+ ((EditText) v.findViewById(R.id.txtcol1other)).getText()
						.toString()
				+ "','"

				+ ((EditText) v.findViewById(R.id.txtcol7other)).getText()
						.toString()
				+ "','"

				+ CommonStaticClass.userSpecificId
				+ "','"
				+ CommonStaticClass.GetCurrentDate() + "')";
		if (dbHelper.executeDMLQuery(s1)) {

		} else {
			String sqlUp = String
					.format("Update tbllivestockproducts Set col2='%s',col3='%s',col4='%s',col5='%s',col6='%s',col7='%s',col8='%s',col9='%s',col10='%s',col1other='%s',col7other='%s'"
							+ " where dataid='%s' AND code='%s'",

					CommonStaticClass.GetSpinnerValue(((Spinner) v
							.findViewById(R.id.spcol2))),

					((EditText) v.findViewById(R.id.txtcol3)).getText()
							.toString(),

					((EditText) v.findViewById(R.id.txtcol4)).getText()
							.toString(),

					((EditText) v.findViewById(R.id.txtcol5)).getText()
							.toString(),

					((EditText) v.findViewById(R.id.txtcol6)).getText()
							.toString(),

					CommonStaticClass.GetSpinnerValue(((Spinner) v
							.findViewById(R.id.spcol7))),

					((EditText) v.findViewById(R.id.txtcol8)).getText()
							.toString(),

					CommonStaticClass.GetSpinnerValue(((Spinner) v
							.findViewById(R.id.spcol9))),

					CommonStaticClass.GetSpinnerValue(((Spinner) v
							.findViewById(R.id.spcol10))),

					((EditText) v.findViewById(R.id.txtcol1other)).getText()
							.toString(),

					((EditText) v.findViewById(R.id.txtcol7other)).getText()
							.toString(),

					CommonStaticClass.dataId,

					CommonStaticClass.GetSpinnerValue(((Spinner) v
							.findViewById(R.id.spcol1)))

					);

			dbHelper.executeDMLQuery(sqlUp);
		}

		new AlertDialog.Builder(con)
				.setTitle("Data updated")
				.setMessage("Do you want to insert more data?")
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								dialog.dismiss();

								btnClear.performClick();
								// insertMoreFrmLandUsed(v, true);
							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						dialog.dismiss();
						CommonStaticClass.findOutNextSLNo(
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQvar(),
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQnext1());
						CommonStaticClass.nextQuestion(ParentActivity.this);

					}
				}).setCancelable(false).show();

	}

	private void updateTableDataFrmFishProduction(final ViewGroup v) {
		// TODO Auto-generated method stub

		/*
		 * if (!IsValidFrmFamilyMember(v)) return;
		 */
		// else {

		if (CheckEmptyViewGroup(v) == false) {
			CommonStaticClass.showMyAlert(con, "Error", "Fill all fields");
			return;
		}
		Date d = new Date(System.currentTimeMillis());
		String entryDate = "dd-mmm-yy";
		entryDate = d.toLocaleString();

		String s1 = "Insert into tblfishproduction (dataid,fishcode,col2,col3,col4, other, EntryBy,EntryDate) "
				+ "    values('"
				+ CommonStaticClass.dataId
				+ "','"
				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spcol1)))
				+ "','"

				+ ((EditText) v.findViewById(R.id.txtcol2)).getText()
						.toString()
				+ "','"

				+ ((EditText) v.findViewById(R.id.txtcol3)).getText()
						.toString()
				+ "','"

				+ ((EditText) v.findViewById(R.id.txtcol4)).getText()
						.toString()
				+ "','"
				+ ((EditText) v.findViewById(R.id.txtother)).getText()
						.toString()
				+ "','"

				+ CommonStaticClass.userSpecificId
				+ "','"
				+ CommonStaticClass.GetCurrentDate() + "')";
		if (dbHelper.executeDMLQuery(s1)) {

		} else {
			String sqlUp = String.format(
					"Update tblfishproduction Set col2='%s', col3='%s', col4='%s' ,  other ='%s'"
							+ " where dataid='%s' AND fishcode='%s'",

					((EditText) v.findViewById(R.id.txtcol2)).getText()
							.toString(),

					((EditText) v.findViewById(R.id.txtcol3)).getText()
							.toString(),

					((EditText) v.findViewById(R.id.txtcol4)).getText()
							.toString(),

					((EditText) v.findViewById(R.id.txtother)).getText()
							.toString(),

					CommonStaticClass.dataId,

					CommonStaticClass.GetSpinnerValue(((Spinner) v
							.findViewById(R.id.spcol1)))

			);

			dbHelper.executeDMLQuery(sqlUp);
		}

		new AlertDialog.Builder(con)
				.setTitle("Data updated")
				.setMessage("Do you want to insert more data?")
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								dialog.dismiss();

								((EditText) v.findViewById(R.id.txtcol2))
										.setText("");
								((EditText) v.findViewById(R.id.txtcol3))
										.setText("");
								((EditText) v.findViewById(R.id.txtcol4))
										.setText("");
								btnClear.performClick();
								// insertMoreFrmLandUsed(v, true);
							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						dialog.dismiss();
						CommonStaticClass.findOutNextSLNo(
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQvar(),
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQnext1());
						CommonStaticClass.nextQuestion(ParentActivity.this);
						// insertMoreFrmLandUsed(v, false);
						/*
						 * CommonStaticClass.totalHHMember = Integer
						 * .parseInt(memberID);
						 */
					}
				}).setCancelable(false).show();

	}

	private void updateTableDataFrmCropFishProductionReserve(final ViewGroup v) {
		// TODO Auto-generated method stub

		/*
		 * if (!IsValidFrmFamilyMember(v)) return;
		 */
		// else {

		
		if (CheckEmptyViewGroup(v) == false) {
			CommonStaticClass.showMyAlert(con, "Error",
					"Please Fill All Fields");
			return;
		}

		Date d = new Date(System.currentTimeMillis());
		String entryDate = "dd-mmm-yy";
		entryDate = d.toLocaleString();

		String col8 = "", col14="";
		if(((CheckBox)v.findViewById(R.id.chkcol8)).isChecked())
		{
			col8 = "999";
			
		}
		else
		{
			col8 = null;
		}
		
		
		if(((CheckBox)v.findViewById(R.id.chkcol14)).isChecked())
		{
			col14 = "999";
			
		}
		else
		{
			col14 = null;
		}
		
		
		String s1 = String.format("Insert into tblConstructionRepair (dataid, latrineno, col2,col2other,col3,col4,col5,col6,col7,col8,othercol8,col9,col10,col11,col12,othercol12,col13,col14,col14other, col15,col16,col17,col18,col18other,VersionNo,assetid,EntryBy,EntryDate) VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')", 
				CommonStaticClass.dataId, 
				CommonStaticClass.GetSpinnerValueFromString(((Spinner) v.findViewById(R.id.spcol1))),
				CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol2))), 
				((EditText)v.findViewById(R.id.txtcol2other)).getText().toString(),
				 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol3))),
				 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol4))),
				 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol5))),
				 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol6))),
				 CommonStaticClass.GetSpinnerValueFromString(((Spinner) v.findViewById(R.id.txtcol7))),
				 col8,
				 ((EditText)v.findViewById(R.id.txtcol8)).getText().toString(),
				 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol9))),
				 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol10))),
				 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol11))),
				 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol12))),
				 ((EditText)v.findViewById(R.id.txtcol12other)).getText().toString(),
				 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol13))),
				 col14, 
				 ((EditText)v.findViewById(R.id.txtcol14)).getText().toString(),
				 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol15))),
				 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol16))),
				 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol17))),
				 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol18))),
				 ((EditText)v.findViewById(R.id.txtcol18other)).getText().toString(),
				 CommonStaticClass.VersionNo, 
				 CommonStaticClass.AssetID, 
				 CommonStaticClass.userSpecificId, 
				 CommonStaticClass.GetDate());
		if (dbHelper.executeDMLQuery(s1)) {

		} else {
			String sqlUp = String
					.format("Update tblConstructionRepair Set col2= '%s',col2other= '%s',col3= '%s',col4= '%s',col5= '%s',col6= '%s',col7= '%s',col8= '%s',othercol8= '%s',col9= '%s',col10= '%s',col11= '%s',col12= '%s',othercol12= '%s',col13= '%s',col14= '%s',col14other= '%s', col15= '%s',col16= '%s',col17= '%s',col18= '%s',col18other= '%s',EditBy= '%s', EditDate= '%s'"
							+ " where dataid='%s' AND latrineno='%s'",

							CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol2))), 
							((EditText)v.findViewById(R.id.txtcol2other)).getText().toString(),
							 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol3))),
							 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol4))),
							 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol5))),
							 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol6))),
							 CommonStaticClass.GetSpinnerValueFromString(((Spinner) v.findViewById(R.id.txtcol7))),
							 col8,
							 ((EditText)v.findViewById(R.id.txtcol8)).getText().toString(),
							 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol9))),
							 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol10))),
							 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol11))),
							 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol12))),
							 ((EditText)v.findViewById(R.id.txtcol12other)).getText().toString(),
							 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol13))),
							 col14, 
							 ((EditText)v.findViewById(R.id.txtcol14)).getText().toString(),
							 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol15))),
							 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol16))),
							 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol17))),
							 CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol18))),
							 ((EditText)v.findViewById(R.id.txtcol18other)).getText().toString(),
							 CommonStaticClass.userSpecificId, CommonStaticClass.GetDate(),
							 CommonStaticClass.dataId, 
							 CommonStaticClass.GetSpinnerValueFromString(((Spinner) v.findViewById(R.id.spcol1)))
					);

			dbHelper.executeDMLQuery(sqlUp);
		}

		new AlertDialog.Builder(con)
				.setTitle("Data updated")
				.setMessage("Do you want to insert more data?")
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								dialog.dismiss();
								btnClear.performClick();
							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						dialog.dismiss();
						CommonStaticClass.findOutNextSLNo(
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQvar(),
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQnext1());
						CommonStaticClass.nextQuestion(ParentActivity.this);

					}
				}).setCancelable(false).show();

	}

	// frmwatermanagementproblem
	private void updateTableDataFrmWaterManagementProblem(final ViewGroup v) {
		// TODO Auto-generated method stub

		if (((Spinner) v.findViewById(R.id.spcol2)).getSelectedItem()
				.toString().length() > 0) {
			if (CommonStaticClass.GetSpinnerValue(
					((Spinner) v.findViewById(R.id.spcol2))).equalsIgnoreCase(
					"0")) {

				String s1 = "Insert into tblwatermanagement (dataid, code, col2, EntryBy,EntryDate) "
						+ "    values('"
						+ CommonStaticClass.dataId
						+ "','"
						+ CommonStaticClass.GetSpinnerValue(((Spinner) v
								.findViewById(R.id.spcol1)))
						+ "','"

						+ CommonStaticClass.GetSpinnerValue(((Spinner) v
								.findViewById(R.id.spcol2)))
						+ "','"

						+ CommonStaticClass.userSpecificId
						+ "','"
						+ CommonStaticClass.GetCurrentDate() + "')";
				if (dbHelper.executeDMLQuery(s1)) {

				}
				new AlertDialog.Builder(con)
						.setTitle("Data updated")
						.setMessage("Do you want to insert more data?")
						.setPositiveButton("Yes",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int whichButton) {
										dialog.dismiss();
										btnClear.performClick();

									}
								})
						.setNegativeButton("No",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int whichButton) {
										dialog.dismiss();
										CommonStaticClass
												.findOutNextSLNo(
														CommonStaticClass.questionMap
																.get(CommonStaticClass.currentSLNo)
																.getQvar(),
														CommonStaticClass.questionMap
																.get(CommonStaticClass.currentSLNo)
																.getQnext1());
										CommonStaticClass
												.nextQuestion(ParentActivity.this);

									}
								}).setCancelable(false).show();

			} else {
				if (CheckEmptyViewGroup(v) == false) {
					CommonStaticClass.showMyAlert(con, "Error",
							"Please Fill All Fields");
					return;
				}

				if (((CheckBox) v.findViewById(R.id.txtcol5_1)).isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol5_2))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol5_3))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol5_4))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol5_5))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol5_6))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol5_7))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol5_8))
								.isChecked() == false) {
					CommonStaticClass.showMyAlert(con, "Error",
							"Please Fill All Fields");
					return;
				}

				if (((CheckBox) v.findViewById(R.id.txtcol3_1)).isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol3_2))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol3_3))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol3_4))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol3_5))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol3_6))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol3_7))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol3_8))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol3_9))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol3_10))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol3_11))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol3_12))
								.isChecked() == false) {
					CommonStaticClass.showMyAlert(con, "Error",
							"Please Fill All Fields");
					return;
				}

				if (((CheckBox) v.findViewById(R.id.txtcol6_1)).isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol6_2))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol6_3))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol6_4))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol6_5))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol6_6))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol6_7))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol6_8))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol6_9))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol6_10))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol6_11))
								.isChecked() == false) {
					CommonStaticClass.showMyAlert(con, "Error",
							"Please Fill All Fields");
					return;
				}

				String s1 = "Insert into tblwatermanagement (dataid, code, col2, col4_1, col4_2, col4_3, col4_4, col5_1, col5_2, col5_3, col5_4, col5_5, col5_6, col5_7, col5_8, col5other, col6_1, col6_2, col6_3, col6_4, col6_5, col6_6, col6_7, col6_8, col6_9, col6_10, col6_11, col6other, col1other, "
						+ " col3_1, col3_2, col3_3, col3_4, col3_5, col3_6, col3_7, col3_8, col3_9, col3_10, col3_11, col3_12, EntryBy,EntryDate) "
						+ "    values('"
						+ CommonStaticClass.dataId
						+ "','"
						+ CommonStaticClass.GetSpinnerValue(((Spinner) v
								.findViewById(R.id.spcol1)))
						+ "','"

						+ CommonStaticClass.GetSpinnerValue(((Spinner) v
								.findViewById(R.id.spcol2)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol4_1)))
						+ "','"
						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol4_2)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol4_3)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol4_4)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol5_1)))
						+ "','"
						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol5_2)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol5_3)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol5_4)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol5_5)))
						+ "','"
						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol5_6)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol5_7)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol5_8)))
						+ "','"

						+ ((EditText) v.findViewById(R.id.txtcol5other))
								.getText().toString()
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol6_1)))
						+ "','"
						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol6_2)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol6_3)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol6_4)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol6_5)))
						+ "','"
						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol6_6)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol6_7)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol6_8)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol6_9)))
						+ "','"
						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol6_10)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol6_11)))
						+ "','"

						+ ((EditText) v.findViewById(R.id.txtcol6other))
								.getText().toString()
						+ "','"

						+ ((EditText) v.findViewById(R.id.txtothercol1))
								.getText().toString()
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol3_1)))
						+ "','"
						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol3_2)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol3_3)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol3_4)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol3_5)))
						+ "','"
						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol3_6)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol3_7)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol3_8)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol3_9)))
						+ "','"
						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol3_10)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol3_11)))
						+ "','"
						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol3_12)))
						+ "','"
						+ CommonStaticClass.userSpecificId
						+ "','"
						+ CommonStaticClass.GetCurrentDate() + "')";
				if (dbHelper.executeDMLQuery(s1)) {

				} else {
					String sqlUp = String
							.format("Update tblwatermanagement Set col2='%s', col4_1='%s', col4_2='%s', col4_3='%s', col4_4='%s', col5_1='%s', col5_2='%s', col5_3='%s', col5_4='%s', col5_5='%s', col5_6='%s', col5_7='%s', col5_8='%s', col5other='%s', col6_1='%s', col6_2='%s', col6_3='%s', col6_4='%s', col6_5='%s', col6_6='%s', col6_7='%s', col6_8='%s', col6_9='%s', col6_10='%s', col6_11='%s', col6other='%s', col1other='%s'"
									+ ", col3_1='%s', col3_2='%s', col3_3='%s', col3_4='%s', col3_5='%s', col3_6='%s', col3_7='%s', col3_8='%s', col3_9='%s', col3_10='%s', col3_11='%s', col3_12='%s' where dataid='%s' AND code='%s'",

									CommonStaticClass.GetSpinnerValue(((Spinner) v
											.findViewById(R.id.spcol2))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol4_1))),
									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol4_2))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol4_3))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol4_4))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol5_1))),
									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol5_2))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol5_3))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol5_4))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol5_5))),
									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol5_6))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol5_7))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol5_8)))

									,
									((EditText) v
											.findViewById(R.id.txtcol5other))
											.getText().toString(),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol6_1))),
									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol6_2))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol6_3))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol6_4))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol6_5))),
									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol6_6))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol6_7))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol6_8))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol6_9))),
									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol6_10))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol6_11))),

									((EditText) v
											.findViewById(R.id.txtcol6other))
											.getText().toString(),

									((EditText) v
											.findViewById(R.id.txtothercol1))
											.getText().toString(),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol3_1))),
									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol3_2))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol3_3))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol3_4))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol3_5))),
									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol3_6))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol3_7))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol3_8))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol3_9))),
									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol3_10))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol3_11))),
									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol3_12))),

									CommonStaticClass.dataId,

									CommonStaticClass.GetSpinnerValue(((Spinner) v
											.findViewById(R.id.spcol1)))

							);

					dbHelper.executeDMLQuery(sqlUp);
				}

				new AlertDialog.Builder(con)
						.setTitle("Data updated")
						.setMessage("Do you want to insert more data?")
						.setPositiveButton("Yes",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int whichButton) {
										dialog.dismiss();
										btnClear.performClick();

									}
								})
						.setNegativeButton("No",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int whichButton) {
										dialog.dismiss();
										CommonStaticClass
												.findOutNextSLNo(
														CommonStaticClass.questionMap
																.get(CommonStaticClass.currentSLNo)
																.getQvar(),
														CommonStaticClass.questionMap
																.get(CommonStaticClass.currentSLNo)
																.getQnext1());
										CommonStaticClass
												.nextQuestion(ParentActivity.this);

									}
								}).setCancelable(false).show();

			}
		}
	}

	private void updateTableDataFrmVulnarable(final ViewGroup v) {
		// TODO Auto-generated method stub

		if (((Spinner) v.findViewById(R.id.spcol2)).getSelectedItem()
				.toString().length() > 0) {
			if (CommonStaticClass.GetSpinnerValue(
					((Spinner) v.findViewById(R.id.spcol2))).equalsIgnoreCase(
					"0")) {

				String s1 = "Insert into tblvulnarable (dataid, code, col2, EntryBy,EntryDate) "
						+ "    values('"
						+ CommonStaticClass.dataId
						+ "','"
						+ CommonStaticClass.GetSpinnerValue(((Spinner) v
								.findViewById(R.id.spcol1)))
						+ "','"

						+ CommonStaticClass.GetSpinnerValue(((Spinner) v
								.findViewById(R.id.spcol2)))
						+ "','"

						+ CommonStaticClass.userSpecificId
						+ "','"
						+ CommonStaticClass.GetCurrentDate() + "')";
				if (dbHelper.executeDMLQuery(s1)) {

				}
				new AlertDialog.Builder(con)
						.setTitle("Data updated")
						.setMessage("Do you want to insert more data?")
						.setPositiveButton("Yes",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int whichButton) {
										dialog.dismiss();
										btnClear.performClick();

									}
								})
						.setNegativeButton("No",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int whichButton) {
										dialog.dismiss();
										CommonStaticClass
												.findOutNextSLNo(
														CommonStaticClass.questionMap
																.get(CommonStaticClass.currentSLNo)
																.getQvar(),
														CommonStaticClass.questionMap
																.get(CommonStaticClass.currentSLNo)
																.getQnext1());
										CommonStaticClass
												.nextQuestion(ParentActivity.this);

									}
								}).setCancelable(false).show();

			} else {
				if (CheckEmptyViewGroup(v) == false) {
					CommonStaticClass.showMyAlert(con, "Error",
							"Please Fill All Fields");
					return;
				}

				if (((CheckBox) v.findViewById(R.id.txtcol5_1)).isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol5_2))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol5_3))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol5_4))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol5_5))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol5_6))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol5_7))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol5_8))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol5_9))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol5_10))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol5_11))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol5_12))
								.isChecked() == false
						&& ((CheckBox) v.findViewById(R.id.txtcol5_13))
								.isChecked() == false) {
					CommonStaticClass.showMyAlert(con, "Error",
							"Please Fill All Fields");
					return;
				}

				String s1 = "Insert into tblvulnarable (dataid, code, col2, col3, col4, col5_1, col5_2, col5_3, col5_4, col5_5, col5_6, col5_7, col5_8, col5_9, col5_10, col5_11, col5_12, col5_13, col1other, col4other, col5other,EntryBy,EntryDate) values('"
						+ CommonStaticClass.dataId
						+ "','"
						+ CommonStaticClass.GetSpinnerValue(((Spinner) v
								.findViewById(R.id.spcol1)))
						+ "','"

						+ CommonStaticClass.GetSpinnerValue(((Spinner) v
								.findViewById(R.id.spcol2)))
						+ "','"

						+ CommonStaticClass.GetSpinnerValue(((Spinner) v
								.findViewById(R.id.spcol3)))
						+ "','"
						+ CommonStaticClass.GetSpinnerValue(((Spinner) v
								.findViewById(R.id.spcol4)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol5_1)))
						+ "','"
						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol5_2)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol5_3)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol5_4)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol5_5)))
						+ "','"
						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol5_6)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol5_7)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol5_8)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol5_9)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol5_10)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol5_11)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol5_12)))
						+ "','"

						+ CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
								.findViewById(R.id.txtcol5_13)))
						+ "','"

						+ ((EditText) v.findViewById(R.id.txtcol1other))
								.getText().toString()
						+ "','"
						+ ((EditText) v.findViewById(R.id.txtcol4other))
								.getText().toString()
						+ "','"
						+ ((EditText) v.findViewById(R.id.txtcol5other))
								.getText().toString()

						+ "','"
						+ CommonStaticClass.userSpecificId
						+ "','"
						+ CommonStaticClass.GetCurrentDate() + "')";
				if (dbHelper.executeDMLQuery(s1)) {

				} else {
					String sqlUp = String
							.format("Update tblvulnarable Set col2='%s', col3='%s', col4='%s', col5_1='%s', col5_2='%s', col5_3='%s', col5_4='%s', col5_5='%s', col5_6='%s', col5_7='%s', col5_8='%s', , col5_9='%s' ,  col5_10='%s', col5_11='%s', col5_12='%s', col5_13='%s', col1other='%s', col4other='%s', col5other='%s'"
									+ " where dataid='%s' AND code='%s'",

									CommonStaticClass.GetSpinnerValue(((Spinner) v
											.findViewById(R.id.spcol2))),

									CommonStaticClass.GetSpinnerValue(((Spinner) v
											.findViewById(R.id.spcol3))),

									CommonStaticClass.GetSpinnerValue(((Spinner) v
											.findViewById(R.id.spcol4))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol5_1))),
									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol5_2))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol5_3))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol5_4))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol5_5))),
									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol5_6))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol5_7))),

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol5_8)))

									,

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol5_9)))

									,

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol5_10)))

									,

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol5_11)))

									,

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol5_12)))

									,

									CommonStaticClass.IsCheckBoxChecked(((CheckBox) v
											.findViewById(R.id.txtcol5_13)))

									,
									((EditText) v
											.findViewById(R.id.txtcol1other))
											.getText().toString(),

									((EditText) v
											.findViewById(R.id.txtcol4other))
											.getText().toString(),

									((EditText) v
											.findViewById(R.id.txtcol5other))
											.getText().toString(),

									CommonStaticClass.dataId,

									CommonStaticClass.GetSpinnerValue(((Spinner) v
											.findViewById(R.id.spcol1)))

							);

					dbHelper.executeDMLQuery(sqlUp);
				}

				new AlertDialog.Builder(con)
						.setTitle("Data updated")
						.setMessage("Do you want to insert more data?")
						.setPositiveButton("Yes",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int whichButton) {
										dialog.dismiss();
										btnClear.performClick();

									}
								})
						.setNegativeButton("No",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int whichButton) {
										dialog.dismiss();
										CommonStaticClass
												.findOutNextSLNo(
														CommonStaticClass.questionMap
																.get(CommonStaticClass.currentSLNo)
																.getQvar(),
														CommonStaticClass.questionMap
																.get(CommonStaticClass.currentSLNo)
																.getQnext1());
										CommonStaticClass
												.nextQuestion(ParentActivity.this);

									}
								}).setCancelable(false).show();

			}
		}
	}

	// frmcropproduction
	private void updateTableDataFrmCropFishProductionCost(final ViewGroup v) {
		// TODO Auto-generated method stub

		if (CheckEmptyViewGroup(v) == false) {
			CommonStaticClass.showMyAlert(con, "Error",
					"Please fill all fields");
			return;
		}
		Date d = new Date(System.currentTimeMillis());
		String entryDate = "dd-mmm-yy";
		entryDate = d.toLocaleString();

		String s1 = "Insert into  "
				+ CommonStaticClass.questionMap.get(
						CommonStaticClass.currentSLNo).getTablename()
				+ " (dataid,expcode,col2,col3,col4, othercol1, othercol2, EntryBy,EntryDate) "
				+ "    values("

				+ " '"
				+ CommonStaticClass.dataId
				+ "','"
				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spcol1)))
				+ "','"

				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spcol2)))
				+ "','"

				+ ((EditText) v.findViewById(R.id.txtcol3)).getText()
						.toString()
				+ "','"

				+ ((EditText) v.findViewById(R.id.txtcol4)).getText()
						.toString()
				+ "','"
				+ ((EditText) v.findViewById(R.id.txtothercol1)).getText()
						.toString()
				+ "','"

				+ ((EditText) v.findViewById(R.id.txtothercol2)).getText()
						.toString() + "','"

				+ CommonStaticClass.userSpecificId + "','"
				+ CommonStaticClass.GetCurrentDate() + "')";
		if (dbHelper.executeDMLQuery(s1)) {

		} else {
			String sqlUp = String
					.format("Update %s Set col2='%s', col3='%s', col4='%s' ,  othercol1 ='%s',  othercol2 ='%s'"
							+ " where dataid='%s' AND expcode='%s'",

							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo)
									.getTablename(), CommonStaticClass
									.GetSpinnerValue(((Spinner) v
											.findViewById(R.id.spcol2))),

							((EditText) v.findViewById(R.id.txtcol3)).getText()
									.toString(),

							((EditText) v.findViewById(R.id.txtcol4)).getText()
									.toString(),

							((EditText) v.findViewById(R.id.txtothercol1))
									.getText().toString(), ((EditText) v
									.findViewById(R.id.txtothercol2)).getText()
									.toString(), CommonStaticClass.dataId,

							CommonStaticClass.GetSpinnerValue(((Spinner) v
									.findViewById(R.id.spcol1)))

					);

			dbHelper.executeDMLQuery(sqlUp);
		}

		new AlertDialog.Builder(con)
				.setTitle("Data updated")
				.setMessage("Do you want to insert more data?")
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								dialog.dismiss();

								btnClear.performClick();

							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						dialog.dismiss();
						CommonStaticClass.findOutNextSLNo(
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQvar(),
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQnext1());
						CommonStaticClass.nextQuestion(ParentActivity.this);

					}
				}).setCancelable(false).show();

	}

	// frmlandused
	private void updateTableDataFrmLandUsed(final ViewGroup v) {
		// TODO Auto-generated method stub

		if (CheckEmptyViewGroup(v) == false) {
			CommonStaticClass.showMyAlert(con, "Error",
					"Please fill all fields");
			return;
		}

		qqq.setText(CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQdescbng()
				: CommonStaticClass.questionMap.get(
						CommonStaticClass.currentSLNo).getQdesceng());

		String s1 = "Insert into tblfamilymember (dataid,col1,col2,col3, col4, col4_other, col5, col6, col6_other, col7, col8, col8_other, col9,col10, EntryBy,EntryDate, othermember) "
				+ "    values('"
				+ CommonStaticClass.dataId
				+ "','"
				+ CommonStaticClass.GetSpinnerValueFromString((Spinner) v
						.findViewById(R.id.spinnerMember))
				+ "','"
				+ ((EditText) v.findViewById(R.id.txtage)).getText().toString()
				+ "','"

				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spsex)))
				+ "','"
				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.sprelation)))
				+ "','"
				+ ((EditText) v.findViewById(R.id.txtrelationother)).getText()
						.toString()
				+ "','"

				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.speducation)))
				+ "','"
				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spoccupation)))
				+ "','"

				+ ((EditText) v.findViewById(R.id.txtoccupationother))
						.getText().toString()
				+ "','"
				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spdisability)))

				+ "','"
				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.sptypeofdisability)))
				+ "','"

				+ ((EditText) v.findViewById(R.id.txttypeofdisabilityother))
						.getText().toString()
				+ "','"

				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spranking)))
				+ "','"
				+ CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spmonthsworked)))
				+ "','"
				+ CommonStaticClass.userSpecificId
				+ "','"
				+ CommonStaticClass.GetCurrentDate()
				+ "','"
				+ String.valueOf(((CheckBox) v
						.findViewById(R.id.chkothermember)).isChecked() ? "1"
						: "0") + "')";
		if (dbHelper.executeDMLQuery(s1)) {

		} else {
			String sqlUp = String
					.format("Update tblfamilymember Set col2 = '%s',col3= '%s', col4= '%s', col4_other= '%s', col5= '%s', col6= '%s', col6_other= '%s', col7= '%s', col8= '%s', col8_other= '%s', col9= '%s',col10= '%s', othermember='%s'"
							+ "where dataid='%s' AND col1='%s' ",

							((EditText) v.findViewById(R.id.txtage)).getText()
									.toString(),

							CommonStaticClass.GetSpinnerValue(((Spinner) v
									.findViewById(R.id.spsex))),

							CommonStaticClass.GetSpinnerValue(((Spinner) v
									.findViewById(R.id.sprelation))),
							((EditText) v.findViewById(R.id.txtrelationother))
									.getText().toString(),

							CommonStaticClass.GetSpinnerValue(((Spinner) v
									.findViewById(R.id.speducation))),
							CommonStaticClass.GetSpinnerValue(((Spinner) v
									.findViewById(R.id.spoccupation))),

							((EditText) v.findViewById(R.id.txtoccupationother))
									.getText().toString(),
							CommonStaticClass.GetSpinnerValue(((Spinner) v
									.findViewById(R.id.spdisability))),

							CommonStaticClass.GetSpinnerValue(((Spinner) v
									.findViewById(R.id.sptypeofdisability))),

							((EditText) v
									.findViewById(R.id.txttypeofdisabilityother))
									.getText().toString(), CommonStaticClass
									.GetSpinnerValue(((Spinner) v
											.findViewById(R.id.spranking))),

							CommonStaticClass.GetSpinnerValue(((Spinner) v
									.findViewById(R.id.spmonthsworked))),
							String.valueOf(((CheckBox) v
									.findViewById(R.id.chkothermember))
									.isChecked() ? "1" : "0")

							, CommonStaticClass.dataId, CommonStaticClass
									.GetSpinnerValueFromString((Spinner) v
											.findViewById(R.id.spinnerMember)));

			dbHelper.executeDMLQuery(sqlUp);
		}

		new AlertDialog.Builder(con)
				.setTitle("Data updated")
				.setMessage("Do you want to insert more data?")
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								dialog.dismiss();

								btnClear.performClick();
								// insertMoreFrmLandUsed(v, true);
							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						dialog.dismiss();
						// insertMoreFrmLandUsed(v, false);
						CommonStaticClass.findOutNextSLNo(
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQvar(),
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQnext1());
						CommonStaticClass.nextQuestion(ParentActivity.this);

					}
				}).setCancelable(false).show();

		/*
		 * if (memberIDs.contains((Integer.parseInt(memberID) + 1) + "")) {
		 * 
		 * insertMoreFrmLandUsed(v, false); CommonStaticClass.totalHHMember =
		 * Integer.parseInt(memberID); //
		 * spinnerSL.setSelection(Integer.parseInt(memberID));
		 * 
		 * } else { new AlertDialog.Builder(con) .setTitle("Data updated")
		 * .setMessage("Do you want to insert more data?")
		 * .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
		 * public void onClick(DialogInterface dialog, int whichButton) {
		 * dialog.dismiss(); insertMoreFrmLandUsed(v, true); } })
		 * .setNegativeButton("No", new DialogInterface.OnClickListener() {
		 * public void onClick(DialogInterface dialog, int whichButton) {
		 * dialog.dismiss(); insertMoreFrmLandUsed(v, false);
		 * CommonStaticClass.totalHHMember = Integer .parseInt(memberID); }
		 * }).setCancelable(false).show(); }
		 */

	}

	// }

	private void updateTableDataFrmFamilyMember(final ViewGroup v) {
		// TODO Auto-generated method stub
		boolean proceed = true;
		if (!IsValidFrmFamilyMember(v))
			return;
		else {
			Date d = new Date(System.currentTimeMillis());
			String entryDate = "dd-mmm-yy";
			entryDate = d.toLocaleString();

			String s1 = "Insert into tblhouseholdroster (dataid,memid,Age,Sex,education, EntryBy,EntryDate, membername, other) "
					+ "    values('"
					+ CommonStaticClass.dataId
					+ "','"
					+ memberIDs.get(spinnerSL.getSelectedItemPosition())
					+ "','"
					+ ((EditText) v.findViewById(R.id.txtdob)).getText()
							.toString()
					+ "','"
					+ CommonStaticClass.GetSpinnerValue(((Spinner) v
							.findViewById(R.id.spinnerSex)))
					+ "','"

					+ CommonStaticClass.GetSpinnerValue(((Spinner) v
							.findViewById(R.id.spinnerEducation)))
					+ "','"

					+ CommonStaticClass.userSpecificId
					+ "','"
					+ CommonStaticClass.GetCurrentDate()
					+ "','"
					+ ((EditText) v.findViewById(R.id.txtchildname)).getText()
							.toString()

					+ "','"
					+ ((EditText) v.findViewById(R.id.txtother)).getText()
							.toString() +

					"')";
			if (dbHelper.executeDMLQuery(s1)) {

			} else {
				String sqlUp = String
						.format("Update tblhouseholdroster Set Sex='%s', Age='%s', education='%s', membername='%s', other='%s' where dataid='%s' AND memid='%s'  ",
								opSex.codeList.get(spinnerSex
										.getSelectedItemPosition()),
								((EditText) v.findViewById(R.id.txtdob))
										.getText().toString(),
								CommonStaticClass.GetSpinnerValue(((Spinner) v
										.findViewById(R.id.spinnerEducation))),
								((EditText) v.findViewById(R.id.txtchildname))
										.getText().toString(), ((EditText) v
										.findViewById(R.id.txtother)).getText()
										.toString(), CommonStaticClass.dataId,
								memberIDs.get(spinnerSL
										.getSelectedItemPosition()));

				dbHelper.executeDMLQuery(sqlUp);
			}

			if (memberIDs.contains((Integer.parseInt(memberID) + 1) + "")) {

				insertMoreFrmFamilyMember(v, false);
				CommonStaticClass.totalHHMember = Integer.parseInt(memberID);
				// spinnerSL.setSelection(Integer.parseInt(memberID));

			} else {
				new AlertDialog.Builder(con)
						.setTitle("Data updated")
						.setMessage("Do you want to insert more data?")
						.setPositiveButton("Yes",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int whichButton) {
										dialog.dismiss();
										insertMoreFrmFamilyMember(v, true);
									}
								})
						.setNegativeButton("No",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int whichButton) {
										dialog.dismiss();
										insertMoreFrmFamilyMember(v, false);
										CommonStaticClass.totalHHMember = Integer
												.parseInt(memberID);
									}
								}).setCancelable(false).show();
			}

		}
	}

	// q124
	private void updateTableDataq124() {
		if (!IsValidq124())
			return;
		else {
			Date d = new Date(System.currentTimeMillis());
			String entryDate = "dd-mmm-yy";
			entryDate = d.toLocaleString();

			String v = getSkip("q123", "tblMainQues");
			if (v != null) {
				if (v.length() > 0) {
					if (spinnerc1.getCount() > Integer.parseInt(v)) {
						CommonStaticClass.showMyAlert(con, "Message",
								"You have reached the maximum number.");
						CommonStaticClass.findOutNextSLNo(
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQvar(),
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQnext1());
						CommonStaticClass.nextQuestion(ParentActivity.this);
						return;
					}
				}
			}

			String s1 = String
					.format("Insert into tblTravel (dataid, slno, c2, c2_other, c3,c4,c5,c5_2,c5_3,c5_4,c6,EntryBy,EntryDate) "
							+ "VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
							CommonStaticClass.dataId,
							memberIDs.get(spinnerc1.getSelectedItemPosition()),
							sex, etother.getText(), etc3.getText(),
							etc4.getText(), etc5.getText(), etc5_2.getText(),
							etc5_3.getText(), etc5_4.getText(), etc6.getText(),
							CommonStaticClass.userSpecificId, entryDate);

			/*
			 * + "    values('" + CommonStaticClass.dataId + "','" +
			 * memberIDs.get(spinnerSL.getSelectedItemPosition()) + "','" +
			 * AgeYear + "','" + sex + "','" + CommonStaticClass.userSpecificId
			 * + "','" + entryDate + "')";
			 */
			if (dbHelper.executeDMLQuery(s1)) {

			} else {

				/*
				 * c2, c2_other, c3, c4, c5, c5_2, c5_3, c5_4, c6, EntryBy,
				 * EntryDate
				 */

				String sqlUp = String
						.format("Update tblTravel SET c2='%s', c2_other='%s',c3='%s',c4='%s',c5='%s',c5_2='%s',c5_3='%s',c5_4='%s',c6='%s' WHERE dataid='%s' AND slno ='%s'",
								sex, etother.getText(), etc3.getText(), etc4
										.getText(), etc5.getText(), etc5_2
										.getText(), etc5_3.getText(), etc5_4
										.getText(), etc6.getText(),
								CommonStaticClass.dataId, memberIDs
										.get(spinnerc1
												.getSelectedItemPosition()));

				dbHelper.executeDMLQuery(sqlUp);
			}

			/*
			 * if (memberIDs.contains((Integer.parseInt(memberID) + 1) + "")) {
			 * 
			 * insertMoreFrmFamilyMember(false); CommonStaticClass.totalHHMember
			 * = Integer.parseInt(memberID); //
			 * spinnerSL.setSelection(Integer.parseInt(memberID));
			 * 
			 * }
			 */

			// memberID = String.valueOf(spinnerc1.getSelectedItemPosition());
			if (memberIDs.contains((Integer.parseInt(memberID) + 1) + "")) {

				insertMoreq124(false);
				CommonStaticClass.totalHHMember = Integer.parseInt(memberID);
				// spinnerSL.setSelection(Integer.parseInt(memberID));

			} else {
				new AlertDialog.Builder(con)
						.setTitle("Data updated")
						.setMessage("Do you want to insert more data?")
						.setPositiveButton("Yes",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int whichButton) {
										dialog.dismiss();
										insertMoreq124(true);
									}
								})
						.setNegativeButton("No",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int whichButton) {
										dialog.dismiss();
										insertMoreq124(false);
										CommonStaticClass.totalHHMember = Integer
												.parseInt(memberID);
									}
								}).setCancelable(false).show();
			}

		}
	}

	private void promptUserForInputFrmFamilyMember(final Spinner spinner) {
		// get prompts.xml view
		mydata = getOtherDataFrmFamilyMember();
		LayoutInflater li = LayoutInflater.from(con);
		View promptsView = li.inflate(R.layout.prompts, null);

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(con);

		// set prompts.xml to alertdialog builder
		alertDialogBuilder.setView(promptsView);

		final EditText userInput = (EditText) promptsView
				.findViewById(R.id.editTextDialogUserInput);
		if (mydata != null && mydata.length() > 0) {
			userInput.setText(mydata);
		}
		// set dialog message
		alertDialogBuilder
				.setCancelable(false)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// get user input and set it to result
						// edit text
						// insertDataToRelationOther(userInput.getText().toString());
						mydata = userInput.getText().toString();
					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
								spinner.setSelection(0);
							}
						});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();
	}

	private String getOtherDataFrmFamilyMember() {
		String sql = "Select relationother from tblfamilyMember where dataid='"
				+ CommonStaticClass.dataId + "' and memberid="
				+ memberIDs.get(spinnerSL.getSelectedItemPosition());
		String data = "";
		Cursor mCursor = null;
		try {
			mCursor = dbHelper.getQueryCursor(sql);
			if (mCursor.getCount() > 0) {
				if (mCursor.moveToFirst()) {
					do {
						data = mCursor.getString(mCursor
								.getColumnIndex("relationother"));
					} while (mCursor.moveToNext());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (mCursor != null)
				mCursor.close();
		}
		return data;
	}

	public void insertDataToRelationOtherFrmFamilyMember(String data) {
		// TODO Auto-generated method stub
		if (data.length() > 0) {
			String sql = "UPDATE tblfamilyMember SET relationother ='" + data
					+ "' where dataid='" + CommonStaticClass.dataId
					+ "' and memberid="
					+ memberIDs.get(spinnerSL.getSelectedItemPosition());
			if (dbHelper.executeDMLQuery(sql)) {
				Log.e("relationother ", "Update");
			}
		}
	}

	public void findDataForThisSelectionFrmFamilyMember(String memberid,
			ViewGroup v) {

		String sql = String.format(
				"Select * from '%s' where dataid = '%s' AND memid = '%s'",
				CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getTablename(),
				CommonStaticClass.dataId, memberid);

		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {

				doFillFrmFamilyMember(mCursor1, v);
			} else if (CommonStaticClass.previousDataFound) {

				sql = String
						.format("Select * from '%s' where dataid = '%s' AND memid = '%s'",
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getTablename(),
								CommonStaticClass.dataId, memberid);
				mCursor1 = dbHelper.getQueryCursor(sql);
				if (mCursor1.getCount() > 0) {
					doFillFrmFamilyMember(mCursor1, v);
				}
			} else {
				resetViewsFrmFamilyMember(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}
	}

	public void findDataForThisSelectionFrmproductionmarketinglivestock(
			ViewGroup v) {

		String sql = String.format(
				"Select * from '%s' where dataid = '%s' AND code='%s'",
				CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getTablename(),
				CommonStaticClass.dataId,
				CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spcol1))));

		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				if (mCursor1.moveToFirst()) {
					do {

						if (mCursor1.getString(mCursor1
								.getColumnIndex("col1other")) != null) {
							((EditText) v.findViewById(R.id.txtcol1other))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("col1other")));
						}

						if (mCursor1.getString(mCursor1.getColumnIndex("col2")) != null) {
							((EditText) v.findViewById(R.id.txtcol2))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("col2")));
						}

						if (mCursor1.getString(mCursor1.getColumnIndex("col3")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.spcol3)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col3")));
						}

						if (mCursor1
								.getString(mCursor1.getColumnIndex("col4a")) != null) {

							((EditText) v.findViewById(R.id.txtcol4_1))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("col4a")));

						}

						if (mCursor1
								.getString(mCursor1.getColumnIndex("col4b")) != null) {
							((EditText) v.findViewById(R.id.txtcol4_2))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("col4b")));
						}

						if (mCursor1
								.getString(mCursor1.getColumnIndex("col5a")) != null) {
							((EditText) v.findViewById(R.id.txtcol5_1))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("col5a")));
						}

						if (mCursor1
								.getString(mCursor1.getColumnIndex("col5b")) != null) {
							((EditText) v.findViewById(R.id.txtcol5_2))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("col5b")));
						}

						if (mCursor1.getString(mCursor1.getColumnIndex("col6")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.spcol6)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col6")));
						}

						if (mCursor1
								.getString(mCursor1.getColumnIndex("col7a")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.spcol7_1)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col7a")));
						}

						if (mCursor1
								.getString(mCursor1.getColumnIndex("col7b")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.spcol7_2)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col7b")));
						}

						if (mCursor1.getString(mCursor1
								.getColumnIndex("col6other")) != null) {
							((EditText) v.findViewById(R.id.txtcol6other))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("col6other")));
						}

					} while (mCursor1.moveToNext());
				}
			} else {

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}
	}

	public void findDataForThisSelectionfrmlivestockproducts(ViewGroup v) {

		String sql = String.format(
				"Select * from '%s' where dataid = '%s' AND code='%s'",
				CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getTablename(),
				CommonStaticClass.dataId,
				CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spcol1))));

		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				if (mCursor1.moveToFirst()) {
					do {

						if (mCursor1.getString(mCursor1
								.getColumnIndex("col1other")) != null) {
							((EditText) v.findViewById(R.id.txtcol1other))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("col1other")));
						}

						if (mCursor1.getString(mCursor1.getColumnIndex("col2")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.spcol2)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col2")));
						}

						if (mCursor1.getString(mCursor1.getColumnIndex("col3")) != null) {
							((EditText) v.findViewById(R.id.txtcol3))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("col3")));
						}

						if (mCursor1.getString(mCursor1.getColumnIndex("col4")) != null) {

							((EditText) v.findViewById(R.id.txtcol4))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("col4")));

						}

						if (mCursor1.getString(mCursor1.getColumnIndex("col5")) != null) {
							((EditText) v.findViewById(R.id.txtcol5))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("col5")));
						}

						if (mCursor1.getString(mCursor1.getColumnIndex("col6")) != null) {
							((EditText) v.findViewById(R.id.txtcol6))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("col6")));
						}

						if (mCursor1.getString(mCursor1.getColumnIndex("col7")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.spcol7)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col7")));
						}

						if (mCursor1.getString(mCursor1.getColumnIndex("col8")) != null) {
							((EditText) v.findViewById(R.id.txtcol8))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("col8")));
						}

						if (mCursor1.getString(mCursor1.getColumnIndex("col9")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.spcol9)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col9")));
						}

						if (mCursor1
								.getString(mCursor1.getColumnIndex("col10")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.spcol10)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col10")));
						}

						if (mCursor1.getString(mCursor1
								.getColumnIndex("col7other")) != null) {
							((EditText) v.findViewById(R.id.txtcol7other))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("col7other")));
						}

					} while (mCursor1.moveToNext());
				}
			} else {

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}
	}

	public void findDataForThisSelectionFrmFishProduction(ViewGroup v) {

		String sql = String.format(
				"Select * from '%s' where dataid = '%s' AND fishcode='%s'",
				CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getTablename(),
				CommonStaticClass.dataId,
				CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spcol1))));

		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				if (mCursor1.moveToFirst()) {
					do {
						if (mCursor1.getString(mCursor1.getColumnIndex("col2")) != null) {
							((EditText) v.findViewById(R.id.txtcol2))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("col2")));
						}
						if (mCursor1.getString(mCursor1.getColumnIndex("col3")) != null) {
							((EditText) v.findViewById(R.id.txtcol3))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("col3")));
						}
						if (mCursor1.getString(mCursor1.getColumnIndex("col4")) != null) {
							((EditText) v.findViewById(R.id.txtcol4))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("col4")));
						}

						if (mCursor1
								.getString(mCursor1.getColumnIndex("other")) != null) {
							((EditText) v.findViewById(R.id.txtother))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("other")));
						}

					} while (mCursor1.moveToNext());
				}
			} else {

				// btnClear.performClick();
				// resetViewsFrmLandUsed(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}
	}

	public void findDataForThisSelectionFrmCropFishProductionCost(ViewGroup v) {

		String sql = String.format(
				"Select * from '%s' where dataid = '%s' AND expcode='%s'",
				CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getTablename(),
				CommonStaticClass.dataId,
				CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spcol1))));

		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				if (mCursor1.moveToFirst()) {
					do {
						if (mCursor1.getString(mCursor1.getColumnIndex("col2")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.spcol2)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col2")));
						}
						if (mCursor1.getString(mCursor1.getColumnIndex("col3")) != null) {
							((EditText) v.findViewById(R.id.txtcol3))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("col3")));
						}
						if (mCursor1.getString(mCursor1.getColumnIndex("col4")) != null) {
							((EditText) v.findViewById(R.id.txtcol4))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("col4")));
						}

						if (mCursor1.getString(mCursor1
								.getColumnIndex("othercol1")) != null) {
							((EditText) v.findViewById(R.id.txtothercol1))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("othercol1")));
						}

						if (mCursor1.getString(mCursor1
								.getColumnIndex("othercol2")) != null) {
							((EditText) v.findViewById(R.id.txtothercol2))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("othercol2")));
						}

					} while (mCursor1.moveToNext());
				}
			} else {

				resetViewsFrmLandUsed(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}
	}

	private String GetSumofKg(String code) {
		String sql = String
				.format("Select SUM(kg) AS kg from tblcropproduction where dataid = '%s' AND cropcode='%s'",

				CommonStaticClass.dataId, code);

		String cropproductionkg = "";
		Cursor c1 = null;
		try {
			c1 = dbHelper.getQueryCursor(sql);
			if (c1.getCount() > 0) {
				if (c1.moveToFirst()) {
					do {

						cropproductionkg = CommonStaticClass.GetCursorValue(c1,
								"kg");
					} while (c1.moveToNext());
				}
			} else {

				// resetViewsFrmLandUsed(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (c1 != null)
				c1.close();
		}

		// fishproduction kg
		sql = String
				.format("Select SUM(col2) AS col2, SUM(col3) AS col3,SUM(col4) AS col4 from tblfishproduction where dataid = '%s' AND fishcode='%s'",

				CommonStaticClass.dataId, code);

		String fishproductionkg1 = "";
		String fishproductionkg2 = "";
		String fishproductionkg3 = "";
		Cursor c2 = null;
		try {
			c2 = dbHelper.getQueryCursor(sql);
			if (c2.getCount() > 0) {
				if (c2.moveToFirst()) {
					do {

						fishproductionkg1 = CommonStaticClass.GetCursorValue(
								c2, "col2");
						fishproductionkg2 = CommonStaticClass.GetCursorValue(
								c2, "col3");
						fishproductionkg3 = CommonStaticClass.GetCursorValue(
								c2, "col4");
					} while (c2.moveToNext());
				}
			} else {

				// resetViewsFrmLandUsed(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (c2 != null)
				c2.close();
		}

		Float val1 = 0.0f;
		Float val2 = 0.0f;
		Float val3 = 0.0f;
		Float val4 = 0.0f;
		if (fishproductionkg1 != "") {
			val1 = Float.parseFloat(fishproductionkg1);
		}

		if (fishproductionkg2 != "") {
			val2 = Float.parseFloat(fishproductionkg2);
		}
		if (fishproductionkg3 != "") {
			val3 = Float.parseFloat(fishproductionkg3);
		}

		if (cropproductionkg != "") {
			val4 = Float.parseFloat(cropproductionkg);
		}

		return String.valueOf(val1 + val2 + val3 + val4);
	}

	public void findDataForThisSelectionFrmCropFishProductionReserve(ViewGroup v) {

				String sql = String.format(
				"Select * from '%s' where dataid = '%s' AND latrineno='%s'",
				CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getTablename(),
				CommonStaticClass.dataId,
				CommonStaticClass.GetSpinnerValueFromString(((Spinner) v
						.findViewById(R.id.spcol1))));

		Cursor mCursor1 = null;
		
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				if (mCursor1.moveToFirst()) {
					do {

						if (mCursor1.getString(mCursor1.getColumnIndex("col2")) != null) {
						CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.txtcol2)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col2")));
						}
						
						if (mCursor1.getString(mCursor1.getColumnIndex("col2other")) != null) {
							((EditText) v.findViewById(R.id.txtcol2other))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("col2other")));
						} 						

						if (mCursor1.getString(mCursor1.getColumnIndex("col3")) != null) {
							
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.txtcol3)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col3")));
							
							
						}
						if (mCursor1.getString(mCursor1.getColumnIndex("col4")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.txtcol4)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col4")));
						}

						if (mCursor1.getString(mCursor1.getColumnIndex("col5")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.txtcol5)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col5")));
						}

						if (mCursor1.getString(mCursor1.getColumnIndex("col6")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.txtcol6)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col6")));
						}

						if (mCursor1.getString(mCursor1.getColumnIndex("col7")) != null) {
							CommonStaticClass.SetSpinnerValueFrmString(thisactivity,
									((Spinner) v.findViewById(R.id.txtcol7)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col7")));
						}
						
						
						if (mCursor1.getString(mCursor1
								.getColumnIndex("othercol8")) != null) {
							((EditText) v.findViewById(R.id.txtcol8))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("othercol8")));
							
							
						}
						
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col8")) != null) {
							
							if (mCursor1.getString(mCursor1
									.getColumnIndex("col8")).equalsIgnoreCase("999")) {
								((CheckBox)v.findViewById(R.id.chkcol8)).setChecked(true);
								
							}
							else
							{
								((CheckBox)v.findViewById(R.id.chkcol8)).setChecked(false);
							}
							
						}
						
						if (mCursor1.getString(mCursor1.getColumnIndex("col9")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.txtcol9)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col9")));
						}
						
						if (mCursor1.getString(mCursor1.getColumnIndex("col10")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.txtcol10)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col10")));
						}
						
						if (mCursor1.getString(mCursor1.getColumnIndex("col11")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.txtcol11)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col11")));
						}
						
						if (mCursor1.getString(mCursor1.getColumnIndex("col12")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.txtcol12)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col12")));
							
							if(CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol12))).equalsIgnoreCase("777"))
							{
								((EditText) v.findViewById(R.id.txtcol12other)).setText(mCursor1.getString(mCursor1.getColumnIndex("othercol12")));
							}
						}
						
						
						if (mCursor1.getString(mCursor1.getColumnIndex("col13")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.txtcol13)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col13")));
						}

						if (mCursor1.getString(mCursor1
								.getColumnIndex("col14other")) != null) {
							((EditText) v.findViewById(R.id.txtcol14))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("col14other")));
							
							
						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col14")) != null) {
						
							if (mCursor1.getString(mCursor1
									.getColumnIndex("col14")).equalsIgnoreCase("999")) {
									
								((CheckBox)v.findViewById(R.id.chkcol14)).setChecked(true);
							}
							else
							{
								((CheckBox)v.findViewById(R.id.chkcol14)).setChecked(false);
							}
						}
						
						
						if (mCursor1.getString(mCursor1.getColumnIndex("col15")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.txtcol15)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col15")));
						}
						
						
						if (mCursor1.getString(mCursor1.getColumnIndex("col16")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.txtcol16)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col16")));
						}
						
						if (mCursor1.getString(mCursor1.getColumnIndex("col17")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.txtcol17)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col17")));
						}
						
						if (mCursor1.getString(mCursor1.getColumnIndex("col18")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.txtcol18)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col18")));
							
							
							if(CommonStaticClass.GetSpinnerValue(((Spinner) v.findViewById(R.id.txtcol18))).equalsIgnoreCase("777"))
							{
								((EditText) v.findViewById(R.id.txtcol18other)).setText(mCursor1.getString(mCursor1.getColumnIndex("col18other")));
							}
						}
						
					} while (mCursor1.moveToNext());
				}
			} else {

				// resetViewsFrmLandUsed(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}
	}

	public void findDataForThisSelectionFrmVulnarable(ViewGroup v) {

		String sql = String.format(
				"Select * from '%s' where dataid = '%s' AND code='%s'",
				CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getTablename(),
				CommonStaticClass.dataId,
				CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spcol1))));

		((EditText) v.findViewById(R.id.txtcol1other)).setVisibility(View.GONE);
		((EditText) v.findViewById(R.id.txtcol4other)).setVisibility(View.GONE);
		((EditText) v.findViewById(R.id.txtcol5other)).setVisibility(View.GONE);

		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				if (mCursor1.moveToFirst()) {
					do {
						if (mCursor1.getString(mCursor1.getColumnIndex("col2")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.spcol2)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col2")));

						}

						if (mCursor1.getString(mCursor1.getColumnIndex("col3")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.spcol3)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col3")));

						}

						if (mCursor1.getString(mCursor1.getColumnIndex("col4")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.spcol4)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col4")));

							((EditText) v.findViewById(R.id.txtcol4other))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("col4other")));

						}

						if (mCursor1.getString(mCursor1.getColumnIndex("col2")) != null) {

							((EditText) v.findViewById(R.id.txtcol1other))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("col1other")));
						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col5_1")) != null) {

							if (mCursor1.getString(
									mCursor1.getColumnIndex("col5_1"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol5_1))
										.setChecked(true);
							}

						}

						if (mCursor1.getString(mCursor1
								.getColumnIndex("col5_2")) != null) {

							if (mCursor1.getString(
									mCursor1.getColumnIndex("col5_2"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol5_2))
										.setChecked(true);
							}

						}

						if (mCursor1.getString(mCursor1
								.getColumnIndex("col5_3")) != null) {

							if (mCursor1.getString(
									mCursor1.getColumnIndex("col5_3"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol5_3))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col5_4")) != null) {

							if (mCursor1.getString(
									mCursor1.getColumnIndex("col5_4"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol5_4))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col5_5")) != null) {

							if (mCursor1.getString(
									mCursor1.getColumnIndex("col5_5"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol5_5))
										.setChecked(true);
							}

						}

						if (mCursor1.getString(mCursor1
								.getColumnIndex("col5_6")) != null) {

							if (mCursor1.getString(
									mCursor1.getColumnIndex("col5_6"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol5_6))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col5_7")) != null) {

							if (mCursor1.getString(
									mCursor1.getColumnIndex("col5_7"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol5_7))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col5_8")) != null) {

							if (mCursor1.getString(
									mCursor1.getColumnIndex("col5_8"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol5_8))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col5_9")) != null) {

							if (mCursor1.getString(
									mCursor1.getColumnIndex("col5_9"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol5_9))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col5_10")) != null) {

							if (mCursor1.getString(
									mCursor1.getColumnIndex("col5_10"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol5_10))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col5_11")) != null) {

							if (mCursor1.getString(
									mCursor1.getColumnIndex("col5_11"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol5_11))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col5_12")) != null) {

							if (mCursor1.getString(
									mCursor1.getColumnIndex("col5_12"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol5_12))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col5_13")) != null) {
							if (mCursor1.getString(
									mCursor1.getColumnIndex("col5_13"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol5_13))
										.setChecked(true);
								((EditText) v.findViewById(R.id.txtcol5other))
										.setText("col5other");
							}

						}

					} while (mCursor1.moveToNext());
				}
			} else {

				((TextView) v.findViewById(R.id.lblcol3))
						.setVisibility(View.VISIBLE);
				((TextView) v.findViewById(R.id.lblcol4))
						.setVisibility(View.VISIBLE);
				((TextView) v.findViewById(R.id.lblcol5))
						.setVisibility(View.VISIBLE);
				((Spinner) v.findViewById(R.id.spcol3))
						.setVisibility(View.VISIBLE);

				((Spinner) v.findViewById(R.id.spcol4))
						.setVisibility(View.VISIBLE);

				((CheckBox) v.findViewById(R.id.txtcol5_1))
						.setVisibility(View.VISIBLE);
				((CheckBox) v.findViewById(R.id.txtcol5_2))
						.setVisibility(View.VISIBLE);
				((CheckBox) v.findViewById(R.id.txtcol5_3))
						.setVisibility(View.VISIBLE);
				((CheckBox) v.findViewById(R.id.txtcol5_4))
						.setVisibility(View.VISIBLE);
				((CheckBox) v.findViewById(R.id.txtcol5_5))
						.setVisibility(View.VISIBLE);
				((CheckBox) v.findViewById(R.id.txtcol5_6))
						.setVisibility(View.VISIBLE);
				((CheckBox) v.findViewById(R.id.txtcol5_7))
						.setVisibility(View.VISIBLE);
				((CheckBox) v.findViewById(R.id.txtcol5_8))
						.setVisibility(View.VISIBLE);
				((CheckBox) v.findViewById(R.id.txtcol5_9))
						.setVisibility(View.VISIBLE);
				((CheckBox) v.findViewById(R.id.txtcol5_10))
						.setVisibility(View.VISIBLE);
				((CheckBox) v.findViewById(R.id.txtcol5_11))
						.setVisibility(View.VISIBLE);
				((CheckBox) v.findViewById(R.id.txtcol5_12))
						.setVisibility(View.VISIBLE);
				((CheckBox) v.findViewById(R.id.txtcol5_13))
						.setVisibility(View.VISIBLE);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}
	}

	// frmwatermanagementproblem
	public void findDataForThisSelectionFrmWaterManagementProblem(ViewGroup v) {

		String sql = String.format(
				"Select * from '%s' where dataid = '%s' AND code='%s'",
				CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getTablename(),
				CommonStaticClass.dataId,
				CommonStaticClass.GetSpinnerValue(((Spinner) v
						.findViewById(R.id.spcol1))));

		((EditText) v.findViewById(R.id.txtcol5other)).setVisibility(View.GONE);
		((EditText) v.findViewById(R.id.txtcol6other)).setVisibility(View.GONE);

		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				if (mCursor1.moveToFirst()) {
					do {
						if (mCursor1.getString(mCursor1.getColumnIndex("col2")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v.findViewById(R.id.spcol2)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col2")));

						}

						if (mCursor1.getString(mCursor1.getColumnIndex("col2")) != null) {

							((EditText) v.findViewById(R.id.txtothercol1))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("col1other")));
						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col3_1")) != null) {

							if (mCursor1.getString(
									mCursor1.getColumnIndex("col3_1"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol3_1))
										.setChecked(true);
							}

						}

						if (mCursor1.getString(mCursor1
								.getColumnIndex("col3_2")) != null) {

							if (mCursor1.getString(
									mCursor1.getColumnIndex("col3_2"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol3_2))
										.setChecked(true);
							}

						}

						if (mCursor1.getString(mCursor1
								.getColumnIndex("col3_3")) != null) {

							if (mCursor1.getString(
									mCursor1.getColumnIndex("col3_3"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol3_3))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col3_4")) != null) {

							if (mCursor1.getString(
									mCursor1.getColumnIndex("col3_4"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol3_4))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col3_5")) != null) {

							if (mCursor1.getString(
									mCursor1.getColumnIndex("col3_5"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol3_5))
										.setChecked(true);
							}

						}

						if (mCursor1.getString(mCursor1
								.getColumnIndex("col3_6")) != null) {

							if (mCursor1.getString(
									mCursor1.getColumnIndex("col3_6"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol3_6))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col3_7")) != null) {

							if (mCursor1.getString(
									mCursor1.getColumnIndex("col3_7"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol3_7))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col3_8")) != null) {

							if (mCursor1.getString(
									mCursor1.getColumnIndex("col3_8"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol3_8))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col3_9")) != null) {

							if (mCursor1.getString(
									mCursor1.getColumnIndex("col3_9"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol3_9))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col3_10")) != null) {

							if (mCursor1.getString(
									mCursor1.getColumnIndex("col3_10"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol3_10))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col3_11")) != null) {

							if (mCursor1.getString(
									mCursor1.getColumnIndex("col3_11"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol3_11))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col3_12")) != null) {

							if (mCursor1.getString(
									mCursor1.getColumnIndex("col3_12"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol3_12))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col4_1")) != null) {
							if (mCursor1.getString(
									mCursor1.getColumnIndex("col4_1"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol4_1))
										.setChecked(true);
							}

						}

						if (mCursor1.getString(mCursor1
								.getColumnIndex("col4_2")) != null) {
							if (mCursor1.getString(
									mCursor1.getColumnIndex("col4_2"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol4_2))
										.setChecked(true);
							}

						}

						if (mCursor1.getString(mCursor1
								.getColumnIndex("col4_3")) != null) {
							if (mCursor1.getString(
									mCursor1.getColumnIndex("col4_3"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol4_3))
										.setChecked(true);
							}

						}

						if (mCursor1.getString(mCursor1
								.getColumnIndex("col4_4")) != null) {
							if (mCursor1.getString(
									mCursor1.getColumnIndex("col4_4"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol4_4))
										.setChecked(true);
							}

						}

						// column 5
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col5_1")) != null) {
							if (mCursor1.getString(
									mCursor1.getColumnIndex("col5_1"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol5_1))
										.setChecked(true);
							}

						}

						if (mCursor1.getString(mCursor1
								.getColumnIndex("col5_2")) != null) {
							if (mCursor1.getString(
									mCursor1.getColumnIndex("col5_2"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol5_2))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col5_3")) != null) {
							if (mCursor1.getString(
									mCursor1.getColumnIndex("col5_3"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol5_3))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col5_4")) != null) {
							if (mCursor1.getString(
									mCursor1.getColumnIndex("col5_4"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol5_4))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col5_5")) != null) {
							if (mCursor1.getString(
									mCursor1.getColumnIndex("col5_5"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol5_5))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col5_6")) != null) {
							if (mCursor1.getString(
									mCursor1.getColumnIndex("col5_6"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol5_6))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col5_7")) != null) {
							if (mCursor1.getString(
									mCursor1.getColumnIndex("col5_7"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol5_7))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col5_8")) != null) {
							if (mCursor1.getString(
									mCursor1.getColumnIndex("col5_8"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol5_8))
										.setChecked(true);
								((EditText) v.findViewById(R.id.txtcol5other))
										.setText(mCursor1.getString(mCursor1
												.getColumnIndex("col5other")));
								((EditText) v.findViewById(R.id.txtcol5other))
										.setVisibility(View.VISIBLE);
							} else {
								((EditText) v.findViewById(R.id.txtcol5other))
										.setVisibility(View.GONE);
							}
						} else {
							((EditText) v.findViewById(R.id.txtcol5other))
									.setVisibility(View.GONE);
						}

						// column 6
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col6_1")) != null) {
							if (mCursor1.getString(
									mCursor1.getColumnIndex("col6_1"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol6_1))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col6_2")) != null) {
							if (mCursor1.getString(
									mCursor1.getColumnIndex("col6_2"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol6_2))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col6_3")) != null) {
							if (mCursor1.getString(
									mCursor1.getColumnIndex("col6_3"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol6_3))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col6_4")) != null) {
							if (mCursor1.getString(
									mCursor1.getColumnIndex("col6_4"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol6_4))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col6_5")) != null) {
							if (mCursor1.getString(
									mCursor1.getColumnIndex("col6_5"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol6_5))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col6_6")) != null) {
							if (mCursor1.getString(
									mCursor1.getColumnIndex("col6_6"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol6_6))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col6_7")) != null) {
							if (mCursor1.getString(
									mCursor1.getColumnIndex("col6_7"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol6_7))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col6_8")) != null) {
							if (mCursor1.getString(
									mCursor1.getColumnIndex("col6_8"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol6_8))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col6_9")) != null) {
							if (mCursor1.getString(
									mCursor1.getColumnIndex("col6_9"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol6_9))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col6_10")) != null) {
							if (mCursor1.getString(
									mCursor1.getColumnIndex("col6_10"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol6_10))
										.setChecked(true);
							}

						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("col6_11")) != null) {
							if (mCursor1.getString(
									mCursor1.getColumnIndex("col6_11"))
									.equalsIgnoreCase("1")) {
								((CheckBox) v.findViewById(R.id.txtcol6_11))
										.setChecked(true);
								((EditText) v.findViewById(R.id.txtcol6other))
										.setVisibility(View.VISIBLE);
								((EditText) v.findViewById(R.id.txtcol6other))
										.setText(mCursor1.getString(mCursor1
												.getColumnIndex("col6other")));
							} else {
								((EditText) v.findViewById(R.id.txtcol6other))
										.setVisibility(View.GONE);
							}
						} else {
							((EditText) v.findViewById(R.id.txtcol6other))
									.setVisibility(View.GONE);
						}

					} while (mCursor1.moveToNext());
				}
			} else {

				// resetViewsFrmLandUsed(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}
	}

	public void findDataForThisSelectionFrmCropProduction(ViewGroup v) {

		String sql = String
				.format("Select * from '%s' where dataid = '%s' AND plotid='%s' AND cropcode='%s' AND season='%s' AND  mon ='%s'",
						CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getTablename(),
						CommonStaticClass.dataId, CommonStaticClass
								.GetSpinnerValue(((Spinner) v
										.findViewById(R.id.spinnerplot))),
						CommonStaticClass.GetSpinnerValue(((Spinner) v
								.findViewById(R.id.spinnercrop))),
						CommonStaticClass.GetSpinnerValue(((Spinner) v
								.findViewById(R.id.spinnerSeason))),
						CommonStaticClass.GetSpinnerValue(((Spinner) v
								.findViewById(R.id.spinnerMonth))));

		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				if (mCursor1.moveToFirst()) {
					do {
						if (mCursor1.getString(mCursor1.getColumnIndex("kg")) != null) {
							((EditText) v.findViewById(R.id.txtkg))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("kg")));
						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("plotid")) != null) {
							CommonStaticClass
									.SetSpinnerValue(thisactivity, ((Spinner) v
											.findViewById(R.id.spinnerplot)),
											mCursor1.getString(mCursor1
													.getColumnIndex("plotid")));
						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("plotname")) != null) {
							((EditText) v.findViewById(R.id.txtplotname))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("plotname")));
						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("cropcode")) != null) {
							CommonStaticClass
									.SetSpinnerValue(
											thisactivity,
											((Spinner) v
													.findViewById(R.id.spinnercrop)),
											mCursor1.getString(mCursor1
													.getColumnIndex("cropcode")));
						}
						if (mCursor1.getString(mCursor1
								.getColumnIndex("season")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v
											.findViewById(R.id.spinnerSeason)),
									mCursor1.getString(mCursor1
											.getColumnIndex("season")));
						}
						if (mCursor1.getString(mCursor1.getColumnIndex("mon")) != null) {
							CommonStaticClass.SetSpinnerValue(thisactivity,
									((Spinner) v
											.findViewById(R.id.spinnerMonth)),
									mCursor1.getString(mCursor1
											.getColumnIndex("mon")));
						}
						if (mCursor1
								.getString(mCursor1.getColumnIndex("other")) != null) {
							((EditText) v.findViewById(R.id.txtother))
									.setText(mCursor1.getString(mCursor1
											.getColumnIndex("other")));
						}
					} while (mCursor1.moveToNext());
				}
			} else {

				// resetViewsFrmLandUsed(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}
	}

	public void findDataForThisSelectionFrmLandUsed(String memberid, ViewGroup v) {

		String sql = String.format(
				"Select * from '%s' where dataid = '%s' AND col1 = '%s'",
				CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getTablename(),
				CommonStaticClass.dataId, memberid);

		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {

				doFillFrmLandUsed(mCursor1, v);
			} else if (CommonStaticClass.previousDataFound) {
				sql = String
						.format("Select * from '%s' where dataid = '%s' AND col1 = '%s'",
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getTablename(),
								CommonStaticClass.dataId, memberid);
				mCursor1 = dbHelper.getQueryCursor(sql);
				if (mCursor1.getCount() > 0) {
					doFillFrmLandUsed(mCursor1, v);
				}
			} else {
				// resetViewsFrmLandUsed(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}
	}

	public void findDataForThisSelectionq124(String memberid) {
		// TODO Auto-generated method stub
		String sql = "Select * from tblTravel where dataid = '"
				+ CommonStaticClass.dataId + "' AND slno='" + memberID + "'";
		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				doFillq124(mCursor1);
			} else if (CommonStaticClass.previousDataFound) {
				sql = "Select * from tblTravel where dataid = '"
						+ CommonStaticClass.previoushouseHoldDatatId
						+ "' AND slno='" + memberID + "'";
				mCursor1 = dbHelper.getQueryCursor(sql);
				if (mCursor1.getCount() > 0) {
					doFillq124(mCursor1);
				}
			} else {
				resetViewsq124();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}
	}

	private void doFillFrmFamilyMember(Cursor mCursor1, ViewGroup v) {
		// TODO Auto-generated method stub
		if (mCursor1.moveToFirst()) {
			do {

				spinnerSex.setSelection(opSex.codeList.indexOf(Integer
						.parseInt(mCursor1.getString(mCursor1
								.getColumnIndex("Sex")))));
				spinneritem.setSelection(op.codeList.indexOf(Integer
						.parseInt(mCursor1.getString(mCursor1
								.getColumnIndex("Education")))));

				((EditText) v.findViewById(R.id.txtchildname)).setText(mCursor1
						.getString(mCursor1.getColumnIndex("membername")));

				((EditText) v.findViewById(R.id.txtdob)).setText(mCursor1
						.getString(mCursor1.getColumnIndex("Age")));
				((EditText) v.findViewById(R.id.txtother)).setText(mCursor1
						.getString(mCursor1.getColumnIndex("other")));

			} while (mCursor1.moveToNext());
		}
	}

	private void doFillFrmLandUsed(Cursor mCursor1, ViewGroup v) {
		// TODO Auto-generated method stub
		try {
			if (mCursor1.moveToFirst()) {
				do {

					if (mCursor1.getString(mCursor1
							.getColumnIndex("othermember")) != null) {
						if (mCursor1.getString(
								mCursor1.getColumnIndex("othermember"))
								.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chkothermember))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chkothermember))
									.setChecked(false);
						}
					} else {
						((CheckBox) v.findViewById(R.id.chkothermember))
								.setChecked(false);
					}

					((EditText) v.findViewById(R.id.txtage)).setText(mCursor1
							.getString(mCursor1.getColumnIndex("col2")));

					CommonStaticClass
							.SetSpinnerValue(thisactivity, ((Spinner) v
									.findViewById(R.id.spsex)), mCursor1
									.getString(mCursor1.getColumnIndex("col3")));

					CommonStaticClass
							.SetSpinnerValue(thisactivity, ((Spinner) v
									.findViewById(R.id.sprelation)), mCursor1
									.getString(mCursor1.getColumnIndex("col4")));

					((EditText) v.findViewById(R.id.txtrelationother))
							.setText(mCursor1.getString(mCursor1
									.getColumnIndex("col4_other")));

					CommonStaticClass
							.SetSpinnerValue(thisactivity, ((Spinner) v
									.findViewById(R.id.speducation)), mCursor1
									.getString(mCursor1.getColumnIndex("col5")));

					CommonStaticClass
							.SetSpinnerValue(thisactivity, ((Spinner) v
									.findViewById(R.id.spoccupation)), mCursor1
									.getString(mCursor1.getColumnIndex("col6")));

					((EditText) v.findViewById(R.id.txtoccupationother))
							.setText(mCursor1.getString(mCursor1
									.getColumnIndex("col6_other")));

					CommonStaticClass
							.SetSpinnerValue(thisactivity, ((Spinner) v
									.findViewById(R.id.spdisability)), mCursor1
									.getString(mCursor1.getColumnIndex("col7")));

					CommonStaticClass
							.SetSpinnerValue(thisactivity, ((Spinner) v
									.findViewById(R.id.sptypeofdisability)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col8")));

					((EditText) v.findViewById(R.id.txttypeofdisabilityother))
							.setText(mCursor1.getString(mCursor1
									.getColumnIndex("col8_other")));

					CommonStaticClass
							.SetSpinnerValue(thisactivity, ((Spinner) v
									.findViewById(R.id.spranking)), mCursor1
									.getString(mCursor1.getColumnIndex("col9")));

					CommonStaticClass
							.SetSpinnerValue(thisactivity, ((Spinner) v
									.findViewById(R.id.spmonthsworked)),
									mCursor1.getString(mCursor1
											.getColumnIndex("col10")));

				} while (mCursor1.moveToNext());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doFillq124(Cursor mCursor1) {
		// TODO Auto-generated method stub
		if (mCursor1.moveToFirst()) {
			do {
				/*
				 * txtMname.setText(mCursor1.getString(mCursor1
				 * .getColumnIndex("Name")));
				 */
				spinnerc2.setSelection(opSex.codeList.indexOf(Integer
						.parseInt(mCursor1.getString(mCursor1
								.getColumnIndex("c2")))));

				etc3.setText(mCursor1.getString(mCursor1.getColumnIndex("c3")));

				etc4.setText(mCursor1.getString(mCursor1.getColumnIndex("c4")));

				etc5.setText(mCursor1.getString(mCursor1.getColumnIndex("c5")));

				etc5_2.setText(mCursor1.getString(mCursor1
						.getColumnIndex("c5_2")));

				etc5_3.setText(mCursor1.getString(mCursor1
						.getColumnIndex("c5_3")));

				etc5_4.setText(mCursor1.getString(mCursor1
						.getColumnIndex("c5_4")));

				etc6.setText(mCursor1.getString(mCursor1.getColumnIndex("c6")));

				etother.setText(mCursor1.getString(mCursor1
						.getColumnIndex("c2_other")));

			} while (mCursor1.moveToNext());
		}
	}

	private void resetViewsq124() {
		spinnerc1.setSelection(0);
		spinnerc2.setSelection(0);
		adapterSl.notifyDataSetChanged();
		spinnerc1.setSelection(memberIDs.size() - 1);
		etc3.setText("");
		etc4.setText("");
		etc5.setText("");
		etc5_2.setText("");
		etc5_3.setText("");
		etc5_4.setText("");
		etc6.setText("");
		etother.setText("");

	}

	private void resetViewsFrmFamilyMember(ViewGroup v) {
		spinnerSL.setSelection(0);
		spinnerSex.setSelection(0);
		adapterSl.notifyDataSetChanged();
		spinnerSL.setSelection(memberIDs.size() - 1);
		((EditText) v.findViewById(R.id.txtdob)).setText("");
		((EditText) v.findViewById(R.id.txtchildname)).setText("");
		((EditText) v.findViewById(R.id.txtother)).setText("");
		((Spinner) v.findViewById(R.id.spinnerEducation)).setSelection(0);

	}

	private void resetViewsFrmLandUsed(ViewGroup v) {
		// spinnerSL.setSelection(0);
		// spinnerSex.setSelection(0);
		// adapterSl.notifyDataSetChanged();
		// spinnerSL.setSelection(memberIDs.size() - 1);

		((EditText) v.findViewById(R.id.txtage)).setText("");

		((Spinner) v.findViewById(R.id.spsex)).setSelection(0);

		((Spinner) v.findViewById(R.id.sprelation)).setSelection(0);
		((EditText) v.findViewById(R.id.txtrelationother)).setText("");

		((Spinner) v.findViewById(R.id.speducation)).setSelection(0);
		((Spinner) v.findViewById(R.id.spoccupation)).setSelection(0);

		((EditText) v.findViewById(R.id.txtoccupationother)).setText("");
		((Spinner) v.findViewById(R.id.spdisability)).setSelection(0);

		((Spinner) v.findViewById(R.id.sptypeofdisability)).setSelection(0);

		((EditText) v.findViewById(R.id.txttypeofdisabilityother)).setText("");
		((Spinner) v.findViewById(R.id.spranking)).setSelection(0);

		((Spinner) v.findViewById(R.id.spmonthsworked)).setSelection(0);

	}

	private void insertMoreFrmFamilyMember(ViewGroup v, boolean b) {
		// TODO Auto-generated method stub
		if (b) {

			memberIDs
					.add((Integer.parseInt(memberIDs.get(memberIDs.size() - 1)) + 1)
							+ "");

			resetViewsFrmFamilyMember(v);
		} else {
			// String sq =
			// "UPDATE tblMainQues SET q10='"+q101+"' where dataid='"+CommonStaticClass.dataId+"'";
			// if(dbHelper.executeDMLQuery(sq)){
			// preserveState();
			CommonStaticClass.findOutNextSLNo(
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar(),
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQnext1());
			CommonStaticClass.nextQuestion(ParentActivity.this);
			// }
		}
	}

	private void insertMoreFrmLandUsed(ViewGroup v, boolean b) {
		// TODO Auto-generated method stub
		if (b) {

			memberIDs
					.add((Integer.parseInt(memberIDs.get(memberIDs.size() - 1)) + 1)
							+ "");

			resetViewsFrmLandUsed(v);
		} else {

			CommonStaticClass.findOutNextSLNo(
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar(),
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQnext1());
			CommonStaticClass.nextQuestion(ParentActivity.this);

		}
	}

	private void insertMoreq124(boolean b) {
		// TODO Auto-generated method stub
		if (b) {

			memberIDs
					.add((Integer.parseInt(memberIDs.get(memberIDs.size() - 1)) + 1)
							+ "");

			resetViewsq124();
		} else {
			// String sq =
			// "UPDATE tblMainQues SET q10='"+q101+"' where dataid='"+CommonStaticClass.dataId+"'";
			// if(dbHelper.executeDMLQuery(sq)){
			// preserveState();
			CommonStaticClass.findOutNextSLNo(
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar(),
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQnext1());
			CommonStaticClass.nextQuestion(ParentActivity.this);
			// }
		}
	}

	private boolean valueInFrmFamilyMember2(String column1, String column2) {
		String sql = "Select " + column1 + "," + column2
				+ " from tblMainQues where dataid='" + CommonStaticClass.dataId
				+ "'";
		Cursor mCursor = null;
		try {
			mCursor = dbHelper.getQueryCursor(sql);
			if (mCursor.getCount() > 0) {
				if (mCursor.moveToFirst()) {
					do {
						String val1 = mCursor.getString(mCursor
								.getColumnIndex(column1));
						String val2 = mCursor.getString(mCursor
								.getColumnIndex(column2));
						if (val1.length() > 0 || val2.length() > 0) {
							return true;
						}
					} while (mCursor.moveToNext());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	private boolean valueInFrmFamilyMember(String column1) {
		String sql = "Select " + column1 + " from tblMainQues where dataid='"
				+ CommonStaticClass.dataId + "'";
		Cursor mCursor = null;
		try {
			mCursor = dbHelper.getQueryCursor(sql);
			if (mCursor.getCount() > 0) {
				if (mCursor.moveToFirst()) {
					do {
						String val1 = mCursor.getString(mCursor
								.getColumnIndex(column1));

						if (val1.length() > 0) {
							return true;
						}
					} while (mCursor.moveToNext());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	private boolean valueInFrmFamilyMember(String column1, String column2) {
		String sql = "Select " + column1 + "," + column2
				+ " from tblMainQues where dataid='" + CommonStaticClass.dataId
				+ "'";
		Cursor mCursor = null;
		try {
			mCursor = dbHelper.getQueryCursor(sql);
			if (mCursor.getCount() > 0) {
				if (mCursor.moveToFirst()) {
					do {
						String val1 = mCursor.getString(mCursor
								.getColumnIndex(column1));
						String val2 = mCursor.getString(mCursor
								.getColumnIndex(column2));
						if (val1.length() > 0 || val2.length() > 0) {
							return true;
						}
					} while (mCursor.moveToNext());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	private boolean IsValidq124() {
		boolean IsValid = false;

		sex = opSex.codeList.get(spinnerc2.getSelectedItemPosition())
				.toString();
		if (((EditText) findViewById(R.id.c3)).getText().length() <= 0
				&& ((EditText) findViewById(R.id.c4)).getText().length() <= 0) {
			CommonStaticClass.showMyAlert(con, "Error",
					"Specify hour/day spent");
			return IsValid;
		}

		if (((EditText) findViewById(R.id.c6)).getText().length() <= 0) {
			CommonStaticClass.showMyAlert(con, "Error", "Specify Distance");
			return IsValid;
		}

		return true;
	}

	/*
	 * private void HideFamily(ViewGroup v) { ((EditText)
	 * v.findViewById(R.id.ettime)).setVisibility(View.GONE); ((EditText)
	 * v.findViewById(R.id.ettablet)).setVisibility(View.GONE);
	 * 
	 * ((CheckBox) v.findViewById(R.id.chkcapsule)).setVisibility(View.GONE);
	 * ((CheckBox) v.findViewById(R.id.chkdrops)).setVisibility(View.GONE);
	 * ((CheckBox) v.findViewById(R.id.chkspoon)).setVisibility(View.GONE);
	 * 
	 * ((EditText) v.findViewById(R.id.etMedicineOther))
	 * .setVisibility(View.GONE);
	 * 
	 * }
	 */

	EditText ettime;

	private void loadAllUiViewsFrmFamilyMember(ViewGroup v) {
		// TODO Auto-generated method stub

		qqq = (TextView) v.findViewById(R.id.qqq);
		/*
		 * txtMonth = (EditText) v.findViewById(R.id.txtMonth); txtdob =
		 * (EditText) v.findViewById(R.id.txtdob); txtchildname = (EditText)
		 * v.findViewById(R.id.txtchildname);
		 */

		final Calendar c = Calendar.getInstance();
		dateYear = c.get(Calendar.YEAR);
		dateMonth = c.get(Calendar.MONTH);
		dateDay = c.get(Calendar.DAY_OF_MONTH);

		/*
		 * if (!(txtdob.getText().toString().length() > 0))
		 * updateDisplay("date");
		 */

		/*
		 * txtdob.setOnTouchListener(new View.OnTouchListener() {
		 * 
		 * public boolean onTouch(View v, MotionEvent event) { // TODO
		 * Auto-generated method stub showDialog(DATE_DIALOG); return false; }
		 * });
		 */

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		lblSL = (TextView) v.findViewById(R.id.lblMemberID);
		// lblMName = (TextView) v.findViewById(R.id.lblMName);
		/*
		 * lblAge = (TextView) v.findViewById(R.id.lblAge); lblSex = (TextView)
		 * v.findViewById(R.id.lblSex); lblchildname = (TextView)
		 * v.findViewById(R.id.lblchildname);
		 */
		// lblRel = (TextView) v.findViewById(R.id.lblRel);

		spinnerSL = (Spinner) v.findViewById(R.id.spinnerMember);
		spinnerSex = (Spinner) v.findViewById(R.id.spinnerSex);
		spinneritem = (Spinner) v.findViewById(R.id.spinnerEducation);
		spinnerSL.setFocusableInTouchMode(true);
		spinnerSL.requestFocus();

		if (CommonStaticClass.langBng) {

			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				qqq.setTypeface(font);
			}
			;
			lblSL.setTypeface(font);
			// lblSL.setText(con.getResources().getString(R.string.lblMmberIDBN));
			/*
			 * lblMName.setTypeface(font); lblMName.setText(con.getResources()
			 * .getString(R.string.lblMemeberBN));
			 */
			((TextView) v.findViewById(R.id.lblMemberID)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblchildname)).setTypeface(font);
			((TextView) v.findViewById(R.id.lbldob)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblSex)).setTypeface(font);
			((TextView) v.findViewById(R.id.lbleducation)).setTypeface(font);

			((TextView) v.findViewById(R.id.lblMemberID))
					.setText("Lvbv m`m¨†`i jvBb  bs");
			((TextView) v.findViewById(R.id.lblchildname)).setText("bvg");
			((TextView) v.findViewById(R.id.lbldob)).setText("eqm(c~Y© eQ†i)");
			((TextView) v.findViewById(R.id.lblSex))
					.setText("wj½ (†KvW e¨envi Ki“b)");
			((TextView) v.findViewById(R.id.lbleducation))
					.setText("m‡e©v�?P wk¶v(wb‡P D‡j­wLZ †KvW e¨envi Ki“b)");

			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {

			((TextView) v.findViewById(R.id.lblMemberID)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblchildname)).setTypeface(null);
			((TextView) v.findViewById(R.id.lbldob)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblSex)).setTypeface(null);
			((TextView) v.findViewById(R.id.lbleducation)).setTypeface(null);

			// lblSL.setTypeface(null);

			// lblMName.setTypeface(null);

			/*
			 * lblAge.setTypeface(null);
			 * 
			 * lblSex.setTypeface(null); lblchildname.setTypeface(null);
			 * 
			 * // lblRel.setTypeface(null);
			 */
			// lblSL.setText("Member Sl No.");

			// lblMName.setText("Name");

			/*
			 * lblAge.setText("Age (Month)");
			 * 
			 * lblSex.setText("Sex"); lblchildname.setText("Child Name");
			 */

			// lblRel.setText("Relationship");

			((TextView) v.findViewById(R.id.lblMemberID))
					.setText("Line No. for HH members");
			((TextView) v.findViewById(R.id.lblchildname)).setText("Name");
			((TextView) v.findViewById(R.id.lbldob)).setText("Age");
			((TextView) v.findViewById(R.id.lblSex)).setText("Gender");
			((TextView) v.findViewById(R.id.lbleducation))
					.setText("Highest level of Education");

			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());

		}

	}

	private void loadAllUiViewsFrmproductionmarketinglivestock(ViewGroup v) {
		// TODO Auto-generated method stub

		qqq = (TextView) v.findViewById(R.id.qqq);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		if (CommonStaticClass.langBng) {

			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				qqq.setTypeface(font);
			}
			;
			// lblSL.setTypeface(font);

			((TextView) v.findViewById(R.id.lblcol1)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol2)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol3)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol4)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol4_1)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol4_2)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol5)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol5_1)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol5_2)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol6)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol7_1)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol7_2)).setTypeface(font);

			((TextView) v.findViewById(R.id.lblcol1)).setText("cÖKvi");
			((TextView) v.findViewById(R.id.lblcol2))
					.setText("evwo‡Z / Lvgv‡i eZ©gvb msL¨v");
			((TextView) v.findViewById(R.id.lblcol3)).setText("gvwjKvbv");
			((TextView) v.findViewById(R.id.lblcol4))
					.setText("weMZ 12 gv‡m KqwU […]  µq Kiv n‡q‡Q?");
			((TextView) v.findViewById(R.id.lblcol4_1)).setText("µqK…ZmsL¨v");
			((TextView) v.findViewById(R.id.lblcol4_2))
					.setText("†gvU µqg~j¨UvKv");
			((TextView) v.findViewById(R.id.lblcol5))
					.setText("weMZ 12 gv‡m KqwU […]  weµq Kiv n‡q‡Q?");
			((TextView) v.findViewById(R.id.lblcol5_1)).setText("wewµZmsL¨v");
			((TextView) v.findViewById(R.id.lblcol5_2))
					.setText("†gvU weµqg~j¨UvKv");
			((TextView) v.findViewById(R.id.lblcol6))
					.setText("†Kv_vq wewµ K‡i‡Qb? […]");
			((TextView) v.findViewById(R.id.lblcol7_1))
					.setText("weµ‡qi wm×vš— wb‡qwQ‡jb †K?");
			((TextView) v.findViewById(R.id.lblcol7_2))
					.setText("wewµi UvKv Kvi wbqš¿b G _v‡K?");

			/*
			 * qqq.setText(CommonStaticClass.questionMap
			 * .get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ?
			 * CommonStaticClass.questionMap
			 * .get(CommonStaticClass.currentSLNo).getQdescbng() :
			 * CommonStaticClass.questionMap.get(
			 * CommonStaticClass.currentSLNo).getQdesceng());
			 */

			ArrayList<String> ids = new ArrayList<String>();
			ids.add("");

			ids.add("1 : lvo/ej`");
			ids.add("2 : Mvfx");
			ids.add("3 : gwnl");
			ids.add("4 : Mvav");
			ids.add("5 : L�?Pi/‡Nvov");
			ids.add("6 : ïKi ");
			ids.add("7 : QvMj");
			ids.add("8 : †fov");
			ids.add("9 : gyiMx");
			ids.add("10 : nvum ");
			ids.add("11 : Ab¨vb¨ (wbw`©ó Ki“b)");
			ids.add("12 : †KvbwU bq");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol1)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : wbR");
			ids.add("2 : †hŠ_");
			ids.add("3 : ivLv, wKš‘ wb‡Ri bq");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol3)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : Lvgvi †_‡K/Lvgvi `iRvq");
			ids.add("2 : MÖv‡gi / kn‡ii evRv‡i");
			ids.add("3 : mgev‡qi Kv‡Q/gva¨‡g");
			ids.add("4 : Ab¨vb¨ (wbw`©ó Ki“b)");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol6)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : cyi“l m`m¨");
			ids.add("2 : bvix m`m¨");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol7_1)));

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol7_2)));

		} else {

			ArrayList<String> ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : Bullock");
			ids.add("2 : Milk cow");
			ids.add("3 : Buffalo");
			ids.add("4 : Donkey");
			ids.add("5 : Mule / Horse");
			ids.add("6 : Pig");
			ids.add("7 : Goat");
			ids.add("8 : Sheep");
			ids.add("9 : Hen");
			ids.add("10 : Duck");
			ids.add("11 : Other (specify)");
			ids.add("12 : None of the above");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol1)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : own");
			ids.add("2 : shared");
			ids.add("3 : kept, but not owned");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol3)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : farm gate");
			ids.add("2 : village or town market");
			ids.add("3 : to or via cooperative");
			ids.add("4 : others (Specify)");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol6)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : male member");
			ids.add("2 : female member");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol7_1)));

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol7_2)));

			((TextView) v.findViewById(R.id.lblcol1)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol2)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol3)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol4)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol4_1)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol4_2)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol5)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol5_1)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol5_2)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol6)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol7_1)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol7_2)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblcol1)).setText("Type");
			((TextView) v.findViewById(R.id.lblcol2))
					.setText("How many are present at your home / farm?");
			((TextView) v.findViewById(R.id.lblcol3)).setText("Ownership");
			((TextView) v.findViewById(R.id.lblcol4))
					.setText("Did you buy any […] during the last 12 months?");
			((TextView) v.findViewById(R.id.lblcol4_1))
					.setText("Number bought");
			((TextView) v.findViewById(R.id.lblcol4_2))
					.setText("Total purchase value BTks");
			((TextView) v.findViewById(R.id.lblcol5))
					.setText("How many […] were sold during the past 12 months ?");
			((TextView) v.findViewById(R.id.lblcol5_1)).setText("Number sold");
			((TextView) v.findViewById(R.id.lblcol5_2))
					.setText("Total value of sales BTks");
			((TextView) v.findViewById(R.id.lblcol6))
					.setText("Where did you sell […]?");
			((TextView) v.findViewById(R.id.lblcol7_1))
					.setText("Who decided to sell?");
			((TextView) v.findViewById(R.id.lblcol7_2))
					.setText("Who controls the money from the sale?");

			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());

		}

	}

	private void loadAllUiViewsfrmlivestockproducts(ViewGroup v) {
		// TODO Auto-generated method stub

		qqq = (TextView) v.findViewById(R.id.qqq);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		if (CommonStaticClass.langBng) {

			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				qqq.setTypeface(font);
			}
			;
			// lblSL.setTypeface(font);

			((TextView) v.findViewById(R.id.lblcol1)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol2)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol3)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol4)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol4)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol5)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol6)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol7)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol8)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol9)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol10)).setTypeface(font);

			((TextView) v.findViewById(R.id.lblcol1)).setText("c†b¨i aiY");
			((TextView) v.findViewById(R.id.lblcol2)).setText("GKK †KvW");
			((TextView) v.findViewById(R.id.lblcol3))
					.setText("MZ gv‡m Avcwb wK cwigvb Drcv`b K‡i‡Qb?");
			((TextView) v.findViewById(R.id.lblcol4))
					.setText("MZ gv‡m Avcwb wK cwigvb †fvM K‡i‡Qb?");
			((TextView) v.findViewById(R.id.lblcol5))
					.setText("MZ gv‡m Avcwb wK cwigvY KvD‡K w`‡q‡Qb?");
			((TextView) v.findViewById(R.id.lblcol6))
					.setText("MZ gv‡m Avcwb wK cwigvY weµq K‡i‡Qb?");
			((TextView) v.findViewById(R.id.lblcol7))
					.setText("weµq K‡i _vK‡j, †Kv_vq?");
			((TextView) v.findViewById(R.id.lblcol8))
					.setText("MZ gv‡mi weµ‡qi †gvU g~j¨");
			((TextView) v.findViewById(R.id.lblcol9))
					.setText("weµ‡qi wmavš— †K †bb?");
			((TextView) v.findViewById(R.id.lblcol10))
					.setText("weµqjä A_© †K wbqš¿b K‡ib?");

			ArrayList<String> ids = new ArrayList<String>();
			ids.add("");

			ids.add("1 : `ya");
			ids.add("2 : wWg");
			ids.add("3 : †cvëªx");
			ids.add("4 : ˆRe mvi");
			ids.add("5 : Ab¨vb¨ (wbw`©ó Ki“b)");
			ids.add("6 : †KvbwU bq");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol1)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : wjUvi");
			ids.add("2 : msL¨v");
			ids.add("3 : wK‡jvMÖvg");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol2)));

			ids = new ArrayList<String>();
			ids.add("");

			ids.add("1 : Lvgvi `iRvq");
			ids.add("2 : MÖv‡gi evRv‡i");
			ids.add("3 :  kn‡ii evRv‡i");
			ids.add("4 : mgev‡qi Kv‡Q/gva¨‡g");
			ids.add("5 : mycvigv‡K©U");
			ids.add("6 : Pzw³i gva¨‡g");
			ids.add("7 : Ab¨vb¨");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol7)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : cyi“l m`m¨");
			ids.add("2 : bvix m`m¨");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol9)));

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol10)));

		} else {

			ArrayList<String> ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : Milk");
			ids.add("2 : Eggs");
			ids.add("3 : poultry");
			ids.add("4 : Manure");
			ids.add("5 : Other [SPECIFY]");
			ids.add("6 : None of the above");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol1)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : liter");
			ids.add("2 : number");
			ids.add("3 : kilograms");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol2)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : farm gate");
			ids.add("2 : village market");
			ids.add("3 :  town market");
			ids.add("4 : to or via cooperative");
			ids.add("5 : supermarket");
			ids.add("6 : via contract");
			ids.add("7 : other");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol7)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : male member");
			ids.add("2 : female member");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol9)));

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol10)));

			((TextView) v.findViewById(R.id.lblcol1)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol2)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol3)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol4)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol5)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol6)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol7)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol8)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol9)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol10)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblcol1)).setText("Product type");
			((TextView) v.findViewById(R.id.lblcol2)).setText("Unit code");
			((TextView) v.findViewById(R.id.lblcol3))
					.setText("How much did you produce in the last  month?");
			((TextView) v.findViewById(R.id.lblcol4))
					.setText("How much did you consume in last month?");

			((TextView) v.findViewById(R.id.lblcol5))
					.setText("How much did you give away in last month?");
			((TextView) v.findViewById(R.id.lblcol6))
					.setText("How much did you sell in last  month?");

			((TextView) v.findViewById(R.id.lblcol7)).setText("If sold, where");
			((TextView) v.findViewById(R.id.lblcol8))
					.setText("Total value of sales in last months");

			((TextView) v.findViewById(R.id.lblcol9))
					.setText("Who decides to sell?");
			((TextView) v.findViewById(R.id.lblcol10))
					.setText("Who controls the money from the sale ?");

			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());

		}

	}

	private void loadAllUiViewsFrmFishProduction(ViewGroup v) {
		// TODO Auto-generated method stub

		qqq = (TextView) v.findViewById(R.id.qqq);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		if (CommonStaticClass.langBng) {

			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				qqq.setTypeface(font);
			}
			;
			// lblSL.setTypeface(font);

			((TextView) v.findViewById(R.id.lblcol1)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol2)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol3)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol4)).setTypeface(font);

			((TextView) v.findViewById(R.id.lblcol1))
					.setText("gv‡Qi cÖRvwZ (†KvW)");
			((TextView) v.findViewById(R.id.lblcol2))
					.setText("cøvweZ f’wg (†KwR)");
			((TextView) v.findViewById(R.id.lblcol3))
					.setText("Mfxi cyKzi (†KwR)");

			((TextView) v.findViewById(R.id.lblcol4))
					.setText("mvgvwRK/‡hŠ_ Rjvkq (†KwR)");

			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());

			ArrayList<String> ids = new ArrayList<String>();
			ids.add("");
			ids.add("201 : evM`v");
			ids.add("202 : Mj`v");
			ids.add("203 : †Zjvwcqv");
			ids.add("204 : cvi‡k");
			ids.add("205 : nvwibv");
			ids.add("206 : Ruhu Fish");
			ids.add("207 : cv½vm");

			ids.add("208 : iyB");
			ids.add("209 : KvZjv");
			ids.add("210 : g„‡Mj");
			ids.add("211 : Kvd©z");
			ids.add("212 : Bwjk");
			ids.add("213 : wmjfvi Kvc©");
			ids.add("214 : cywU/kicywU");

			ids.add("215 : KB");
			ids.add("216 : †kvj/MRvj/UvwK");
			ids.add("217 : †Usiv/evBb");
			ids.add("218 : Ab¨vb¨ gvQ");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol1)));

		} else {

			ArrayList<String> ids = new ArrayList<String>();
			ids.add("");
			ids.add("201 : Black tiger shrimp (bagda)");
			ids.add("202 : Fresh Water Prawn (Golda)");
			ids.add("203 : Tilapia");
			ids.add("204 : Parshae");
			ids.add("205 : Harina/Brawn Shrimp");
			ids.add("206 : Ruhu Fish");
			ids.add("207 : Pangash");

			ids.add("208 : Rui");
			ids.add("209 : Katla");
			ids.add("210 : Mrigel");
			ids.add("211 : Karfu");
			ids.add("212 : Ilish/ hilsha");
			ids.add("213 : Silver Carp");
			ids.add("214 : Puti/Swarputi");

			ids.add("215 : Koi");
			ids.add("216 : Shol/Gajar/Taki");
			ids.add("217 : Tengra/Baim");
			ids.add("218 : Other Fish");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol1)));

			((TextView) v.findViewById(R.id.lblcol1)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol2)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblcol3)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblcol4)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblcol1))
					.setText("Fish species (code)");
			((TextView) v.findViewById(R.id.lblcol2))
					.setText("Inundated plots (kg)");
			((TextView) v.findViewById(R.id.lblcol3))
					.setText("Deep ponds (kg)");
			((TextView) v.findViewById(R.id.lblcol4))
					.setText("Communal waters (kg)");

			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());

		}

	}

	private void loadAllUiViewsFrmCropFishProductionCost(ViewGroup v) {
		// TODO Auto-generated method stub

		qqq = (TextView) v.findViewById(R.id.qqq);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		if (CommonStaticClass.langBng) {

			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				qqq.setTypeface(font);
			}

			// lblSL.setTypeface(font);

			((TextView) v.findViewById(R.id.lblcol1)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol2)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol3)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol4)).setTypeface(font);

			((TextView) v.findViewById(R.id.lblcol1)).setText("LiP");
			((TextView) v.findViewById(R.id.lblcol2)).setText("GKK");
			((TextView) v.findViewById(R.id.lblcol3))
					.setText("GKKcÖwZ LiP (UvKv/GKK)");

			((TextView) v.findViewById(R.id.lblcol4))
					.setText("weMZ 12 gv‡m †gvU LiP (UvKv)");

			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());

			ArrayList<String> ids = new ArrayList<String>();

			ids.add("");
			if (qName.equalsIgnoreCase("qlivestockproductioncost")) {
				ids.add("1 : gRyi wb‡qvM (bM` A_© I Lv`¨ UvKvq)");
				ids.add("2 : Mevw`cïi Lv`¨");
				ids.add("3 : cï wPwKrmv mvgMÖx");
				ids.add("4 : cï wPwKrmv welqK civgk©");
				ids.add("5 : Ab¨vb¨ (wbw`©ó Ki“b)");

			} else {
				ids.add("1 : gRyi wb‡qvM (bM` A_© I Lv`¨ - UvKvq)");
				ids.add("2 : exR / Pviv");
				ids.add("3 : ˆRe mvi");
				ids.add("4 : ivmvqwbK mvi");
				ids.add("5 : KxUbvkK");
				ids.add("6 : †mP");
				ids.add("7 : gv‡Qi †cvbv");
				ids.add("8 : cïwPwKZmv mvgMÖx");
				ids.add("9 : gv‡Qi Lvevi");
				ids.add("10 : Ab¨vb¨ LiP (wbw`©ó Ki“b)");
			}
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol1)));

			ids = new ArrayList<String>();
			ids.add("");

			ids.add("1 : w`b");
			ids.add("2 : †KwR");
			ids.add("3 : wjUvi");
			ids.add("4 : Ask/UzKiv/LÛ");
			ids.add("5 : NÈv");
			ids.add("6 : Ab¨vb¨ (wbw`©ó Ki“b");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol2)));

		} else {

			ArrayList<String> ids = new ArrayList<String>();
			ids.add("");

			if (qName.equalsIgnoreCase("qlivestockproductioncost")) {
				ids.add("1 : Hired labour (cash plus food in Taka)");
				ids.add("2 : Fodder, animal feed");
				ids.add("3 : Veterinary products");
				ids.add("4 : Veterinary advice");
				ids.add("5 : Other (specify)");

			} else {
				ids.add("1 : Hired labour (cash plus food in Taka)");
				ids.add("2 : Seed / plants");
				ids.add("3 : Organic fertiliser");
				ids.add("4 : Chemical fertiliser");
				ids.add("5 : Pesticide");
				ids.add("6 : Irrigation costs");
				ids.add("7 : Fingerlings");
				ids.add("8 : Veterinary products");
				ids.add("9 : Fish Feed");
				ids.add("10 : Other costs (specify)");
			}
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol1)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : day");
			ids.add("2 : kg");
			ids.add("3 : liter");
			ids.add("4 : pieces");
			ids.add("5 : hour");
			ids.add("6 : other (specify)");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol2)));

			((TextView) v.findViewById(R.id.lblcol1)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol2)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblcol3)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblcol4)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblcol1)).setText("Expenditure");
			((TextView) v.findViewById(R.id.lblcol2)).setText("Units");
			((TextView) v.findViewById(R.id.lblcol3))
					.setText("Unit costs (Taka / unit)");
			((TextView) v.findViewById(R.id.lblcol4))
					.setText("Total costs (Taka) in the past 12 months");

			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());

		}

	}

	private void loadAllUiViewsFrmCropCultivationReserve(ViewGroup v) {
		// TODO Auto-generated method stub

		qqq = (TextView) v.findViewById(R.id.qqq);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		if (CommonStaticClass.langBng) {

			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				qqq.setTypeface(font);
			}

			// lblSL.setTypeface(font);

			((TextView) v.findViewById(R.id.lblcol1)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol2)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol3)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol4)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol5)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol6)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol7)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol8)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol9)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol10)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol11)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol12)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol13)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol14)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol15)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol16)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol17)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol18)).setTypeface(font);
			
			
			
			((TextView) v.findViewById(R.id.lblcol1)).setText("cvqLvbv bs");

			((TextView) v.findViewById(R.id.lblcol2))
					.setText("cwiev‡i e¨ven«Z  cvqLvbvi aiY");

			((TextView) v.findViewById(R.id.lblcol3))
					.setText("cvqLvbvi  Kvh©KixZv");

			((TextView) v.findViewById(R.id.lblcol4))
					.setText("Avcbvi cwiev‡ii †Kvb m`m¨ wK wbqwgZ GB cvqLvbv e¨envi K‡i?");

			((TextView) v.findViewById(R.id.lblcol5))
					.setText("cvqLvbvi gvwjKvbv");

			((TextView) v.findViewById(R.id.lblcol6))
					.setText("cvqLvbvi e¨enviKvix");

			((TextView) v.findViewById(R.id.lblcol7))
					.setText("Askx`vix cvqLvbv n‡j, KZ¸‡jv Lvbv wg‡j Zv e¨envi K‡i ?");

			((TextView) v.findViewById(R.id.lblcol8))
					.setText("cvqLvbvwU †Kvb eQi/gv‡m wbg©vb Kiv n‡qwQj?");
			((TextView) v.findViewById(R.id.lblcol9))
					.setText("cvqLvbvwU wbg©v‡b cwiev‡ii †Kvb †jvK kvixwiK cwikÖg K‡iwQj wKbv?");
			((TextView) v.findViewById(R.id.lblcol10))
					.setText("cvqLvbvwU wbg©v‡b mnvqZv MÖn‡bi Ae¯’v");
			((TextView) v.findViewById(R.id.lblcol11))
					.setText("cvqLvbvwU wbg©v‡b ‡Kvb ai‡Yi mnvqZv wQj?");
			((TextView) v.findViewById(R.id.lblcol12))
					.setText("cvqLvbvwU wbg©v‡b mnvqZvKvix cÖwZôvb †KvbwU?");
			((TextView) v.findViewById(R.id.lblcol13))
					.setText("cvqLvbvwU wbg©v‡bi c‡i  Ghver ‡givgZ Kiv n‡qwQj wKbv?");
			((TextView) v.findViewById(R.id.lblcol14))
					.setText("cvqLvbvwU †Kvb eQi/ gv‡m me©‡kl ‡givgZ Kiv n‡qwQj?");
			((TextView) v.findViewById(R.id.lblcol15))
					.setText("cvqLvbvwU me©‡kl ‡givg‡Zi mgq cwiev‡ii †Kvb †jvK kvixwiK cwikÖg K‡iwQj vKbv?");
			((TextView) v.findViewById(R.id.lblcol16))
					.setText("cvqLvbvwU me©‡kl ‡givg‡Zi mgq mnvqZv MÖn‡bi Ae¯’v");
			((TextView) v.findViewById(R.id.lblcol17))
					.setText("cvqLvbvwU me©‡kl ‡givg‡Zi mgq ‡Kvb ai‡Yi mnvqZv wQj?");
			((TextView) v.findViewById(R.id.lblcol18))
					.setText("cvqLvbvwU me©‡kl ‡givg‡Zi mgq mnvqZvKvix cÖwZôvb †KvbwU?");

			((CheckBox) v.findViewById(R.id.chkcol8)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.chkcol14)).setTypeface(font);
			
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());

			ArrayList<String> ids = new ArrayList<String>();
			ids.add("");
			ids.add("1");
			ids.add("2");
			ids.add("3");
			ids.add("4");
			ids.add("5");
			ids.add("6");
			ids.add("7");
			ids.add("8");
			ids.add("9");
			ids.add("10");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol1)));

			ids = new ArrayList<String>();
			ids.add("1 : d¬vk K‡i ev cvwb †X‡j cvqLvbv `~‡i wc‡Ui g‡a¨ mwi‡q †`qv hvq");
			ids.add("2 : Uq‡jwU‡Z †mcwUK U¨vsK emv‡bv Av‡Q");
			ids.add("3 : Uq‡jwU‡Z cqtwb®‹vkb cvB‡ci mv‡_ ev Ab¨ †Kv_vI ms‡hvM K‡i ‡`qv");
			ids.add("4 : wcU-Uq‡jU (¯øve Ges IqvUvi wmj Av‡Q)");
			ids.add("5 : evqy PjvPj Dc‡hvMx DbœZ  j¨vwUªb");
			ids.add("6 : Kg‡cvwós Uq‡jU(cvqLvbv Ges cÖmªve Kivi Rb¨ Avjv`v Avjv`v Ni Ges mv‡_ Avjv`v ‡Kv_vI cvwbi e¨ve¯’v Av‡Q)");
			ids.add("7 : wcU/MZ© cvqLvbv, ¯øve ‡bB Ges †hLvb †_‡K gkv/gvwQ hvIqv Avmv Ki‡Z cv‡i Ges `~M©Ü Qovq");
			ids.add("8 : SzjšÍ cvqLvbv");
			ids.add("9 : ‡Kvb cvqLvbv †bB/R½‡j/‡Sv‡c Sv‡o/ †Lvjv RvqMvq");
			ids.add("777 : Ab¨vb¨ (wbw`©ó K‡i wjLyb)");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol2)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("0 : AKvh©Ki");
			ids.add("1 : Kvh©Ki");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol3)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("0 : bv");
			ids.add("1 : nu¨v");
			ids.add("999 : Rvwb bv");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol4)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : ïaygvÎ H Lvbvi Rb¨");
			ids.add("2 : K‡qK Ni wg‡j/ Askx`vi");
			ids.add("3 : cvewjK");
			ids.add("888 : cÖ‡hvR¨ bq");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol5)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : ïaygvÎ H Lvbvi");
			ids.add("2 : K‡qKwU Lvbv wg‡j/ Askx`vi");
			ids.add("3 : cvewjK");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol6)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1");
			ids.add("2");
			ids.add("3");
			ids.add("4");
			ids.add("5");
			ids.add("6");
			ids.add("7");
			ids.add("8");
			ids.add("9");
			ids.add("10");
			ids.add("11");
			ids.add("12");
			ids.add("13");
			ids.add("14");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol7)));

			((CheckBox) v.findViewById(R.id.chkcol8)).setText("Rvwb bv");
			((CheckBox) v.findViewById(R.id.chkcol14)).setText("Rvwb bv");
			
			ids = new ArrayList<String>();
			ids.add("");
			ids.add("0 : bv");
			ids.add("1 : nu¨v");
			ids.add("999 : Rvwb bv");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol9)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("0 : ‡Kvb mnvqZv wQjbv/ wbR D‡`¨v‡M");
			ids.add("1 : mnvqZv wQj");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol10)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : Aby`vb");
			ids.add("2 : Fb mnvqZv");
			ids.add("3 : cyb© DcKiY mnvqZv");
			ids.add("4 : AvswkK DcKiY mnvqZv");
			ids.add("5 : kªg mnvqZv");
			ids.add("6 : Aby`vb I DcKiY mnvqZv");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol11)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : eªvK");
			ids.add("2 : Dc‡Rjv dvÛ (miKvix )");
			ids.add("777 : Ab¨vb¨ dvÛ");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol12)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("0 : bv");
			ids.add("1 : nu¨v");
			ids.add("999 : Rvwb bv");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol13)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("0 : bv");
			ids.add("1 : nu¨v");
			ids.add("999 : Rvwb bv");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol15)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("0 : ‡Kvb mnvqZv wQjbv/ wbR D‡`¨v‡M");
			ids.add("1 : mnvqZv wQj");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol16)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : Aby`vb");
			ids.add("2 : Fb mnvqZv");
			ids.add("3 : cyb© DcKiY mnvqZv");
			ids.add("4 : AvswkK DcKiY mnvqZv");
			ids.add("5 : kªg mnvqZv");
			ids.add("6 : Aby`vb I DcKiY mnvqZv");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol17)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : eªvK");
			ids.add("2 : Dc‡Rjv dvÛ (miKvix )");
			ids.add("777 : Ab¨vb¨ dvÛ");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol18)));

		} else {

			ArrayList<String> ids = new ArrayList<String>();
			ids.add("");
			ids.add("1");
			ids.add("2");
			ids.add("3");
			ids.add("4");
			ids.add("5");
			ids.add("6");
			ids.add("7");
			ids.add("8");
			ids.add("9");
			ids.add("10");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol1)));

			ids = new ArrayList<String>();
			ids.add("1 : Flush to pit");
			ids.add("2 : Flush to Septic tank");
			ids.add("3 : Piped sewer system/ Flush to elsewhere");
			ids.add("4 : Pit latrine with slab & water seal");
			ids.add("5 : Ventilated Improved Pit (VIP) latrine");
			ids.add("6 : Composting toilet, (Composting toilet ensure separation of urine, water and excreta)");
			ids.add("7 : Open pit latrine");
			ids.add("8 : Hanging toilet/latrine");
			ids.add("9 : No facility/bush/field");
			ids.add("777 : Others Specify");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol2)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("0 : Non-functional");
			ids.add("1 : Functional");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol3)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("0 : No");
			ids.add("1 : Yes");
			ids.add("999 : Dont know");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol4)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : Only for the household");
			ids.add("2 : Shared");
			ids.add("3 : Public");
			ids.add("888 : Not applicable");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol5)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : Only for the household");
			ids.add("2 : Shared");
			ids.add("3 : Public");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol6)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1");
			ids.add("2");
			ids.add("3");
			ids.add("4");
			ids.add("5");
			ids.add("6");
			ids.add("7");
			ids.add("8");
			ids.add("9");
			ids.add("10");
			ids.add("11");
			ids.add("12");
			ids.add("13");
			ids.add("14");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol7)));

			((CheckBox) v.findViewById(R.id.chkcol8)).setText("Dont know");

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("0 : No");
			ids.add("1 : Yes");
			ids.add("999 : Dont know");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol9)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("0 : self financed");
			ids.add("1 : Received outside assistance");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol10)));

			ids = new ArrayList<String>();
			ids.add("");

			ids.add("1 : voucher/ subsidy");
			ids.add("2 : loan");
			ids.add("3 : Full supplies");
			ids.add("4 : Partial supplies");
			ids.add("5 : labor");
			ids.add("6 : both subsidy & supplies");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol11)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : BRAC");
			ids.add("2 : Upazila fund (govt.)");
			ids.add("777 : other fund (specify)");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol12)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("0 : No");
			ids.add("1 : Yes");
			ids.add("999 : Dont know");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol13)));

			((CheckBox) v.findViewById(R.id.chkcol14)).setText("Dont know");

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("0 : No");
			ids.add("1 : Yes");
			ids.add("999 : Dont know");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol15)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("0 : Self (assistance)");
			ids.add("1 : Received outside assistance");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol16)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : voucher/ subsidy");
			ids.add("2 : loan");
			ids.add("3 : Full supplies");
			ids.add("4 : Partial supplies");
			ids.add("5 : labor");
			ids.add("6 : both subsidy & supplies");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol17)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : BRAC");
			ids.add("2 : Upazila fund (govt.)");
			ids.add("777 : other fund (specify)");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.txtcol18)));

			((TextView) v.findViewById(R.id.lblcol1)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol2)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblcol3)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblcol4)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblcol5)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol6)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol7)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol8)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol9)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblcol10)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblcol11)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblcol12)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol13)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol14)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblcol15)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol16)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblcol17)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblcol18)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chkcol14)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chkcol8)).setTypeface(null);
			
			
			
			((TextView) v.findViewById(R.id.lblcol1)).setText("Latrine #");

			((TextView) v.findViewById(R.id.lblcol2))
					.setText("Type of toilet facility");

			((TextView) v.findViewById(R.id.lblcol3))
					.setText("Functionality status of  toilet");

			((TextView) v.findViewById(R.id.lblcol4))
					.setText("Does any member of your household use this latrine on a regular basis (defined as more than 3 days per week)?");

			((TextView) v.findViewById(R.id.lblcol5))
					.setText("Ownership of the toilet facility");

			((TextView) v.findViewById(R.id.lblcol6))
					.setText("Users of the toilet facility");

			((TextView) v.findViewById(R.id.lblcol7))
					.setText("If shared, how many households sharing the toilet facility?");
			
			
			((TextView) v.findViewById(R.id.lblcol8)).setText("In what month and year was the latrine originally constructed?");
			((TextView) v.findViewById(R.id.lblcol9)).setText("Did someone from your household contribute labor for construction of the latrine?");
			((TextView) v.findViewById(R.id.lblcol10)).setText("Status of outside assistance for original construction of  the latrine");
			((TextView) v.findViewById(R.id.lblcol11)).setText("If outside assistance, what type of assistance received for originally construction");
			((TextView) v.findViewById(R.id.lblcol12)).setText("Which entity provided the assistance for latrine construction");
			((TextView) v.findViewById(R.id.lblcol13)).setText("Has this latrine been repaired since it was originally constructed?");
			((TextView) v.findViewById(R.id.lblcol14)).setText("In what month and year was the latrine most recently repaired?");
			((TextView) v.findViewById(R.id.lblcol15)).setText("Did someone from your household contribute labor for most recent repairing of the latrine?");
			((TextView) v.findViewById(R.id.lblcol16)).setText("Status of outside assistance for most recent repairing of  the latrine");
			((TextView) v.findViewById(R.id.lblcol17)).setText("If outside assistance, what type of assistance received for most recent repairing of  the latrine");
			((TextView) v.findViewById(R.id.lblcol18)).setText("Which entity provided the assistance for most recent repair of the latrine");
			

			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());

		}

	}

	private void loadAllUiViewsFrmWaterManagementProblem(final ViewGroup v) {
		// TODO Auto-generated method stub

		qqq = (TextView) v.findViewById(R.id.qqq);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		if (CommonStaticClass.langBng) {

			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				qqq.setTypeface(font);
			}

			// lblSL.setTypeface(font);

			((TextView) v.findViewById(R.id.lblcol1)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol2)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol3)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol4)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol5)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblcol6)).setTypeface(font);

			((TextView) v.findViewById(R.id.lblcol1))
					.setText("cvwb e¨e¯’vcbv welqK mgm¨v");

			((TextView) v.findViewById(R.id.lblcol2))
					.setText("Avcbvi Lvbv wK ¶wZMÖ¯— n‡qwQj? (mgm¨vi Kvi‡Y)?");

			((TextView) v.findViewById(R.id.lblcol3))
					.setText("†Kvb †Kvb gv‡m Avcwb mgm¨vi m¤§yLxb n‡q‡Qb?");

			((TextView) v.findViewById(R.id.lblcol4))
					.setText("(GKvwaK DËi n‡Z cv‡i)(†gŠmy‡gi ZvwjKv e¨envi Ki“b)");

			((TextView) v.findViewById(R.id.lblcol5))
					.setText("(wb‡æv³ †KvW e¨envi Ki“b)");

			((TextView) v.findViewById(R.id.lblcol6))
					.setText("(wb‡æv³ †KvW e¨envi Ki“b)(GKvwaK DËi n‡Z cv‡i)");

			((CheckBox) v.findViewById(R.id.txtcol4_1)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol4_2)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol4_3)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol4_4)).setTypeface(font);

			((CheckBox) v.findViewById(R.id.txtcol4_1)).setText("1 = AvDk");
			((CheckBox) v.findViewById(R.id.txtcol4_2)).setText("2 = Avgb");
			((CheckBox) v.findViewById(R.id.txtcol4_3)).setText("3 = †ev‡iv");
			((CheckBox) v.findViewById(R.id.txtcol4_4)).setText("4 = iwe");

			((CheckBox) v.findViewById(R.id.txtcol5_1)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol5_2)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol5_3)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol5_4)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol5_5)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol5_6)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol5_7)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol5_8)).setTypeface(font);

			// txtcol3

			((CheckBox) v.findViewById(R.id.txtcol3_1)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol3_2)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol3_3)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol3_4)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol3_5)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol3_6)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol3_7)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol3_8)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol3_9)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol3_10)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol3_11)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol3_12)).setTypeface(font);

			((CheckBox) v.findViewById(R.id.txtcol3_1))
					.setText("1 : জান�?য়ারী");
			((CheckBox) v.findViewById(R.id.txtcol3_2))
					.setText("2 : ফেব�?র�?য়ারি");
			((CheckBox) v.findViewById(R.id.txtcol3_3)).setText("3 : মার�?চ");
			((CheckBox) v.findViewById(R.id.txtcol3_4)).setText("4 : �?প�?রিল");
			((CheckBox) v.findViewById(R.id.txtcol3_5)).setText("5 :  মে");
			((CheckBox) v.findViewById(R.id.txtcol3_6)).setText("6 : জ�?ন");
			((CheckBox) v.findViewById(R.id.txtcol3_7)).setText("7 : জ�?লাই");
			((CheckBox) v.findViewById(R.id.txtcol3_8)).setText("8 : অগাস�?ট");
			((CheckBox) v.findViewById(R.id.txtcol3_9))
					.setText("9 : সেপ�?টেম�?বর");
			((CheckBox) v.findViewById(R.id.txtcol3_10))
					.setText("10 : অক�?টোবর");
			((CheckBox) v.findViewById(R.id.txtcol3_11))
					.setText("11 : নভেম�?বর");
			((CheckBox) v.findViewById(R.id.txtcol3_12))
					.setText("12 : ডিসেম�?বর");

			((CheckBox) v.findViewById(R.id.txtcol5_1))
					.setText("1 = (ch©vß) cvwb e¨e¯’vcbv AeKvVv‡gvi Afve");
			((CheckBox) v.findViewById(R.id.txtcol5_2))
					.setText("2 =  cvwb e¨e¯’vcbv AeKvVv‡gvi ¶q¶wZ");
			((CheckBox) v.findViewById(R.id.txtcol5_3))
					.setText("3 =  cvwb e¨e¯’vcbv AeKvVv‡gvq bvkKZv/AvNvZ");
			((CheckBox) v.findViewById(R.id.txtcol5_4))
					.setText("4 =  cvwb e¨e¯’vcbv `j KZ©…K M„nxZ wm×vš—");
			((CheckBox) v.findViewById(R.id.txtcol5_5)).setText("5 =  Liv");
			((CheckBox) v.findViewById(R.id.txtcol5_6)).setText("6 =  AwZe„wó");
			((CheckBox) v.findViewById(R.id.txtcol5_7))
					.setText("7 =   wbw`©ó †Kvb KviY †bB");
			((CheckBox) v.findViewById(R.id.txtcol5_8)).setText("8 =  Ab¨vb¨");

			((CheckBox) v.findViewById(R.id.txtcol6_1)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol6_2)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol6_3)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol6_4)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol6_5)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol6_6)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol6_7)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol6_8)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol6_9)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol6_10)).setTypeface(font);
			((CheckBox) v.findViewById(R.id.txtcol6_11)).setTypeface(font);

			((CheckBox) v.findViewById(R.id.txtcol6_1))
					.setText("1 = dmj Drcv`b nªvm †c‡q‡Q");
			((CheckBox) v.findViewById(R.id.txtcol6_2))
					.setText("2 = (cÖvq) mg¯— dmj m¤cyb© webó n‡q‡Q");
			((CheckBox) v.findViewById(R.id.txtcol6_3))
					.setText("3 = dmj AvswkK webó n‡q‡Q");
			((CheckBox) v.findViewById(R.id.txtcol6_4))
					.setText("4 =dmj †ivcb evavMÖ¯— n‡q‡Q");
			((CheckBox) v.findViewById(R.id.txtcol6_5))
					.setText("5 = cy‡iv †gŠmy‡g dmj Drcv`b Kiv hvqwb");
			((CheckBox) v.findViewById(R.id.txtcol6_6))
					.setText("6 = weMZ cy‡iv eQ‡i (cÖvq) GB Rwg‡Z dmj Drcv`b Kiv hvqwb");
			((CheckBox) v.findViewById(R.id.txtcol6_7))
					.setText("7 = grm¨ Drcv`b ¶wZMÖ¯— n‡q‡Q");
			((CheckBox) v.findViewById(R.id.txtcol6_8))
					.setText("8 = cïm¤c`/Mevw`cï Drcv`b ¶wZMÖ¯— n‡q‡Q");
			((CheckBox) v.findViewById(R.id.txtcol6_9))
					.setText("9 =cvbxq R‡ji Drm ¶wZMÖ¯— n‡q‡Q");
			((CheckBox) v.findViewById(R.id.txtcol6_10))
					.setText("10 = †Kvb fqven/¸i“Zi ¶wZ nqwb");
			((CheckBox) v.findViewById(R.id.txtcol6_11)).setText("11= Ab¨vb¨");

			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());

			ArrayList<String> ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : cvwb míZv");
			ids.add("2 : eb¨v");
			ids.add("3 : Rjve×Zv");
			ids.add("4 : jebv³Zv");
			ids.add("5 : Ab¨vb¨ (wbw`©ó Ki“b)");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol1)));

			ids = new ArrayList<String>();
			ids.add("1 : n¨vu");
			ids.add("0 : bv (bv n‡j cieZ©x jvBb/NUbvq hvb)");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol2)));

		} else {

			ArrayList<String> ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : Lack of water");
			ids.add("2 : Flooding");
			ids.add("3 : Water logging");
			ids.add("4 : Salinity");
			ids.add("5 : Other (specify)");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol1)));

			ids = new ArrayList<String>();
			ids.add("1 : Yes");
			ids.add("0 : No (If no, go to next event)");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spcol2)));

			((TextView) v.findViewById(R.id.lblcol1)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol2)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblcol3)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblcol4)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblcol5)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblcol6)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblcol1))
					.setText("Water related problem");

			((TextView) v.findViewById(R.id.lblcol2))
					.setText("In the past 12 months was your household affected by [problem]?");

			((TextView) v.findViewById(R.id.lblcol3))
					.setText("In how many of the past 12 months did you experience [problem]?");

			((TextView) v.findViewById(R.id.lblcol4))
					.setText("In which season/months? (multiple answers possible)(Use season list)");

			((TextView) v.findViewById(R.id.lblcol5))
					.setText("What was the cause");

			((TextView) v.findViewById(R.id.lblcol6))
					.setText("What was the consequence?");

			((CheckBox) v.findViewById(R.id.txtcol4_1)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol4_2)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol4_3)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol4_4)).setTypeface(null);

			((CheckBox) v.findViewById(R.id.txtcol4_1)).setText("1 = Aush");
			((CheckBox) v.findViewById(R.id.txtcol4_2)).setText("2 = Amon");
			((CheckBox) v.findViewById(R.id.txtcol4_3)).setText("3 = Boro");
			((CheckBox) v.findViewById(R.id.txtcol4_4)).setText("4 = Robi");

			((CheckBox) v.findViewById(R.id.txtcol5_1)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol5_2)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol5_3)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol5_4)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol5_5)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol5_6)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol5_7)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol5_8)).setTypeface(null);

			((CheckBox) v.findViewById(R.id.txtcol5_1))
					.setText("1 = absence of (sufficient) water infrastructure");
			((CheckBox) v.findViewById(R.id.txtcol5_2))
					.setText("2 = deterioration of water infrastructure");
			((CheckBox) v.findViewById(R.id.txtcol5_3))
					.setText("3 = sabotage of water infrastructure");
			((CheckBox) v.findViewById(R.id.txtcol5_4))
					.setText("4 = decision by water management group");
			((CheckBox) v.findViewById(R.id.txtcol5_5)).setText("5 = drought");
			((CheckBox) v.findViewById(R.id.txtcol5_6))
					.setText("6 = (excessive) rainfall");
			((CheckBox) v.findViewById(R.id.txtcol5_7))
					.setText("7 =  no specific cause");
			((CheckBox) v.findViewById(R.id.txtcol5_8)).setText("8 = other");

			((CheckBox) v.findViewById(R.id.txtcol6_1)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol6_2)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol6_3)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol6_4)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol6_5)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol6_6)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol6_7)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol6_8)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol6_9)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol6_10)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol6_11)).setTypeface(null);

			((CheckBox) v.findViewById(R.id.txtcol6_1))
					.setText("1 = crop yields were reduced");
			((CheckBox) v.findViewById(R.id.txtcol6_2))
					.setText("2 = (almost) all crops were totally destroyed");
			((CheckBox) v.findViewById(R.id.txtcol6_3))
					.setText("3 = crops were partially destroyed");
			((CheckBox) v.findViewById(R.id.txtcol6_4))
					.setText("4 = planting of crops was postponed");
			((CheckBox) v.findViewById(R.id.txtcol6_5))
					.setText("5 = land could not be used for crop production for entire season");
			((CheckBox) v.findViewById(R.id.txtcol6_6))
					.setText("6 = land could not be used for crop production for (almost) the entire past year");
			((CheckBox) v.findViewById(R.id.txtcol6_7))
					.setText("7 = fishery/aquaculture production was affected");
			((CheckBox) v.findViewById(R.id.txtcol6_8))
					.setText("8 = livestock production was affected");
			((CheckBox) v.findViewById(R.id.txtcol6_9))
					.setText("9 = source of drinking water was affected");
			((CheckBox) v.findViewById(R.id.txtcol6_10))
					.setText("10 = no serious consequences");
			((CheckBox) v.findViewById(R.id.txtcol6_11)).setText("11= other");

			((CheckBox) v.findViewById(R.id.txtcol3_1)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol3_2)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol3_3)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol3_4)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol3_5)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol3_6)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol3_7)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol3_8)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol3_9)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol3_10)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol3_11)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.txtcol3_12)).setTypeface(null);

			((CheckBox) v.findViewById(R.id.txtcol3_1)).setText("January");
			((CheckBox) v.findViewById(R.id.txtcol3_2)).setText("February");
			((CheckBox) v.findViewById(R.id.txtcol3_3)).setText("March");
			((CheckBox) v.findViewById(R.id.txtcol3_4)).setText("April");
			((CheckBox) v.findViewById(R.id.txtcol3_5)).setText("May");
			((CheckBox) v.findViewById(R.id.txtcol3_6)).setText("June");
			((CheckBox) v.findViewById(R.id.txtcol3_7)).setText("July");
			((CheckBox) v.findViewById(R.id.txtcol3_8)).setText("August");
			((CheckBox) v.findViewById(R.id.txtcol3_9)).setText("September");
			((CheckBox) v.findViewById(R.id.txtcol3_10)).setText("October");
			((CheckBox) v.findViewById(R.id.txtcol3_11)).setText("November");
			((CheckBox) v.findViewById(R.id.txtcol3_12)).setText("December");
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());

		}

		((EditText) v.findViewById(R.id.txtcol5other)).setVisibility(View.GONE);
		((EditText) v.findViewById(R.id.txtcol6other)).setVisibility(View.GONE);

		((Spinner) v.findViewById(R.id.spcol1))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {

						String val = ((Spinner) v.findViewById(R.id.spcol1))
								.getSelectedItem().toString();
						if (val.length() > 0) {
							val = CommonStaticClass
									.GetSpinnerValue(((Spinner) v
											.findViewById(R.id.spcol1)));
							if (val.equalsIgnoreCase("5")) {
								((EditText) v.findViewById(R.id.txtothercol1))
										.setVisibility(View.VISIBLE);
							} else {
								((EditText) v.findViewById(R.id.txtothercol1))
										.setVisibility(View.GONE);
							}
							findDataForThisSelectionFrmWaterManagementProblem(v);

						}

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

		((CheckBox) v.findViewById(R.id.txtcol5_8))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						if (arg1 == true) {
							((EditText) v.findViewById(R.id.txtcol5other))
									.setVisibility(View.VISIBLE);
						} else {
							((EditText) v.findViewById(R.id.txtcol5other))
									.setVisibility(View.GONE);
						}

					}
				});

		/*
		 * ((CheckBox) v.findViewById(R.id.txtcol6_11))
		 * .setOnCheckedChangeListener(new OnCheckedChangeListener() {
		 * 
		 * @Override public void onCheckedChanged(CompoundButton arg0, boolean
		 * arg1) { if (arg1 == true) { ((EditText)
		 * v.findViewById(R.id.txtcol6other)) .setVisibility(View.VISIBLE); }
		 * else { ((EditText) v.findViewById(R.id.txtcol6other))
		 * .setVisibility(View.GONE); }
		 * 
		 * } });
		 */

		((CheckBox) v.findViewById(R.id.txtcol5_7))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						if (arg1 == true) {
							((CheckBox) v.findViewById(R.id.txtcol5_1))
									.setChecked(false);
							((CheckBox) v.findViewById(R.id.txtcol5_2))
									.setChecked(false);
							((CheckBox) v.findViewById(R.id.txtcol5_3))
									.setChecked(false);
							((CheckBox) v.findViewById(R.id.txtcol5_4))
									.setChecked(false);
							((CheckBox) v.findViewById(R.id.txtcol5_5))
									.setChecked(false);
							((CheckBox) v.findViewById(R.id.txtcol5_6))
									.setChecked(false);
							((CheckBox) v.findViewById(R.id.txtcol5_8))
									.setChecked(false);

						} else {

						}

					}
				});

		((CheckBox) v.findViewById(R.id.txtcol6_10))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						if (arg1 == true) {
							((CheckBox) v.findViewById(R.id.txtcol6_1))
									.setChecked(false);
							((CheckBox) v.findViewById(R.id.txtcol6_2))
									.setChecked(false);
							((CheckBox) v.findViewById(R.id.txtcol6_3))
									.setChecked(false);
							((CheckBox) v.findViewById(R.id.txtcol6_4))
									.setChecked(false);
							((CheckBox) v.findViewById(R.id.txtcol6_5))
									.setChecked(false);
							((CheckBox) v.findViewById(R.id.txtcol6_6))
									.setChecked(false);
							((CheckBox) v.findViewById(R.id.txtcol6_7))
									.setChecked(false);
							((CheckBox) v.findViewById(R.id.txtcol6_8))
									.setChecked(false);
							((CheckBox) v.findViewById(R.id.txtcol6_9))
									.setChecked(false);
							((CheckBox) v.findViewById(R.id.txtcol6_11))
									.setChecked(false);

						} else {

						}

					}
				});

		((CheckBox) v.findViewById(R.id.txtcol5_1))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						if (arg1 == true) {
							CommonStaticClass.UnCheckCheckBox(((CheckBox) v
									.findViewById(R.id.txtcol5_7)));
						}

					}
				});

		((CheckBox) v.findViewById(R.id.txtcol5_2))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						if (arg1 == true) {
							CommonStaticClass.UnCheckCheckBox(((CheckBox) v
									.findViewById(R.id.txtcol5_7)));
						}

					}
				});
		((CheckBox) v.findViewById(R.id.txtcol5_3))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						if (arg1 == true) {
							CommonStaticClass.UnCheckCheckBox(((CheckBox) v
									.findViewById(R.id.txtcol5_7)));
						}

					}
				});
		((CheckBox) v.findViewById(R.id.txtcol5_4))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						if (arg1 == true) {
							CommonStaticClass.UnCheckCheckBox(((CheckBox) v
									.findViewById(R.id.txtcol5_7)));
						}

					}
				});
		((CheckBox) v.findViewById(R.id.txtcol5_5))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						if (arg1 == true) {
							CommonStaticClass.UnCheckCheckBox(((CheckBox) v
									.findViewById(R.id.txtcol5_7)));
						}

					}
				});
		((CheckBox) v.findViewById(R.id.txtcol5_6))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						if (arg1 == true) {
							CommonStaticClass.UnCheckCheckBox(((CheckBox) v
									.findViewById(R.id.txtcol5_7)));
						}

					}
				});

		((CheckBox) v.findViewById(R.id.txtcol5_8))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						if (arg1 == true) {
							CommonStaticClass.UnCheckCheckBox(((CheckBox) v
									.findViewById(R.id.txtcol5_7)));
						}
						if (arg1 == true) {
							((EditText) v.findViewById(R.id.txtcol5other))
									.setVisibility(View.VISIBLE);
						} else {
							((EditText) v.findViewById(R.id.txtcol5other))
									.setVisibility(View.GONE);
						}

					}
				});

		((CheckBox) v.findViewById(R.id.txtcol6_1))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						if (arg1 == true) {
							CommonStaticClass.UnCheckCheckBox(((CheckBox) v
									.findViewById(R.id.txtcol6_10)));
						}

					}
				});
		((CheckBox) v.findViewById(R.id.txtcol6_2))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						if (arg1 == true) {
							CommonStaticClass.UnCheckCheckBox(((CheckBox) v
									.findViewById(R.id.txtcol6_10)));
						}

					}
				});
		((CheckBox) v.findViewById(R.id.txtcol6_3))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						if (arg1 == true) {
							CommonStaticClass.UnCheckCheckBox(((CheckBox) v
									.findViewById(R.id.txtcol6_10)));
						}

					}
				});
		((CheckBox) v.findViewById(R.id.txtcol6_4))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						if (arg1 == true) {
							CommonStaticClass.UnCheckCheckBox(((CheckBox) v
									.findViewById(R.id.txtcol6_10)));
						}

					}
				});
		((CheckBox) v.findViewById(R.id.txtcol6_5))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						if (arg1 == true) {
							CommonStaticClass.UnCheckCheckBox(((CheckBox) v
									.findViewById(R.id.txtcol6_10)));
						}

					}
				});
		((CheckBox) v.findViewById(R.id.txtcol6_6))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						if (arg1 == true) {
							CommonStaticClass.UnCheckCheckBox(((CheckBox) v
									.findViewById(R.id.txtcol6_10)));
						}

					}
				});
		((CheckBox) v.findViewById(R.id.txtcol6_7))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						if (arg1 == true) {
							CommonStaticClass.UnCheckCheckBox(((CheckBox) v
									.findViewById(R.id.txtcol6_10)));
						}

					}
				});
		((CheckBox) v.findViewById(R.id.txtcol6_8))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						if (arg1 == true) {
							CommonStaticClass.UnCheckCheckBox(((CheckBox) v
									.findViewById(R.id.txtcol6_10)));
						}

					}
				});
		((CheckBox) v.findViewById(R.id.txtcol6_9))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						if (arg1 == true) {
							CommonStaticClass.UnCheckCheckBox(((CheckBox) v
									.findViewById(R.id.txtcol6_10)));
						}

					}
				});
		((CheckBox) v.findViewById(R.id.txtcol6_11))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						if (arg1 == true) {
							CommonStaticClass.UnCheckCheckBox(((CheckBox) v
									.findViewById(R.id.txtcol6_10)));
						}

						if (arg1 == true) {
							((EditText) v.findViewById(R.id.txtcol6other))
									.setVisibility(View.VISIBLE);
						} else {
							((EditText) v.findViewById(R.id.txtcol6other))
									.setVisibility(View.GONE);
						}
					}
				});

	}

	private void loadAllUiViewsFrmLandUsed(ViewGroup v) {
		// TODO Auto-generated method stub

		qqq = (TextView) v.findViewById(R.id.qqq);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		lblSL = (TextView) v.findViewById(R.id.lblMemberID);

		spinnerSL = (Spinner) v.findViewById(R.id.spinnerMember);

		spinnerSL.setFocusableInTouchMode(true);
		spinnerSL.requestFocus();

		if (CommonStaticClass.langBng) {

			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				qqq.setTypeface(font);
			}
			;
			// lblSL.setTypeface(font);

			/* ((TextView) v.findViewById(R.id.lblMemberID)).setTypeface(font); */
			((CheckBox) v.findViewById(R.id.chkothermember)).setTypeface(font);

			((TextView) v.findViewById(R.id.lblAge)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblSex)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblrelation)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblnumberofyears))
					.setTypeface(font);
			((TextView) v.findViewById(R.id.lbloccupation)).setTypeface(font);
			((TextView) v.findViewById(R.id.lbldisability)).setTypeface(font);
			((TextView) v.findViewById(R.id.lbltypeofdisability))
					.setTypeface(font);

			((TextView) v.findViewById(R.id.lblranking)).setTypeface(font);
			((TextView) v.findViewById(R.id.lblmonthsworked)).setTypeface(font);

			// ((TextView)
			// v.findViewById(R.id.lblMemberID)).setText("Rwg AvB wW");

			((CheckBox) v.findViewById(R.id.chkothermember))
					.setText("Lvbvi m`m¨/ m`m¨v Qvov  †jvKRb");
			((TextView) v.findViewById(R.id.lblAge))
					.setText("eqm(eo †_‡K †QvU µgvbymv‡i)");

			((TextView) v.findViewById(R.id.lblSex)).setText("wjsM");
			((TextView) v.findViewById(R.id.lblrelation))
					.setText("Lvbv cÖav‡bi mv‡_ m¤úK");
			((TextView) v.findViewById(R.id.lblnumberofyears))
					.setText("cÖvwZôvwbK wkÿv (m¤ú~Y©) m¤úbœ eQi");
			((TextView) v.findViewById(R.id.lbloccupation)).setText("‡ckv");
			((TextView) v.findViewById(R.id.lbldisability)).setText("AÿgZv");
			((TextView) v.findViewById(R.id.lbltypeofdisability))
					.setText("hw` n¨uv nq, AÿgZvi aiY (UNDP Gi msMvbyhvqx)");

			((TextView) v.findViewById(R.id.lblranking))
					.setText("cvwievwiK Av‡q Ae`vb (‡hgb,1g= ‡ekxifvM,2q=¯^í cwigvb)");
			((TextView) v.findViewById(R.id.lblmonthsworked))
					.setText("MZ 12 gv‡m KZ gvm KvR K‡iwQ‡jb?");

			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());

			ArrayList<String> ids = new ArrayList<String>();
			ids.add("");
			ids.add("1");
			ids.add("2");
			ids.add("3");
			ids.add("4");
			ids.add("5");
			ids.add("6");
			ids.add("7");

			CommonStaticClass.FillCombo(thisactivity, ids, spinnerSL);

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : cyiyl");
			ids.add("0 : gwnjv");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spsex)));

			ids = new ArrayList<String>();
			ids.add("");

			ids.add("01 : Lvbv cªavb wb‡RB");
			ids.add("02 : ¯¿x/¯^vgx");
			ids.add("03 : ‡Q‡j/‡g‡q");
			ids.add("04 : RvgvB/cyÎeay");
			ids.add("05 : bvwZ/bvZbx");
			ids.add("06 : wcZv/gvZv");
			ids.add("07 : RvgvB/cyÎeaiy wcZv/gvZv");
			ids.add("08 : fvB/‡evb");
			ids.add("09 : Ab¨vb¨ AvZ¡xq");
			ids.add("10 : AbvAvZ¡xq");
			ids.add("777 : Ab¨vb¨, D‡jøL Kiyb");
			ids.add("999 : Rvwb bv");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.sprelation)));

			ids = new ArrayList<String>();
			ids.add("");

			ids.add("1 : 1");
			ids.add("2 : 2");
			ids.add("3 : 3");
			ids.add("4 : 4");
			ids.add("5 : 5");
			ids.add("6 : 6");
			ids.add("7 : 7");
			ids.add("8 : 8");
			ids.add("9 : 9");
			ids.add("10 : 10");
			ids.add("11 : 11");
			ids.add("12 : 12");
			ids.add("13 : 13");
			ids.add("14 : 14");
			ids.add("15 : 15");
			ids.add("16 : 16");
			ids.add("17 : 17");
			ids.add("18 : 18");
			ids.add("19 : 19");
			ids.add("20 : 20");
			ids.add("888 : 888");
			ids.add("999 : 999");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.speducation)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("01 : K…lK");
			ids.add("02 : N‡i KvR K‡i");
			ids.add("03 : K…wl kªwgK");
			ids.add("04 : kªwgK (K…wl kªwgK Qvov)");
			ids.add("05 : ‡eZbfy³ Kg©Pvix (miKvix/cÖvB‡fU/Gb : wR : I)");
			ids.add("06 : ivRwg¯¿x");
			ids.add("07 : KvV wg¯¿x");
			ids.add("08 : f¨vb/wiKkv PvjK");
			ids.add("09 : ‡R‡j");
			ids.add("10 : ‡bŠKv PvjK/gvwS");
			ids.add("11 : Kg©Kvi");
			ids.add("12 : ¯^Y©Kvi");
			ids.add("13 : Kzgvi/Kz¤¢Kvi");
			ids.add("14 : gywP");
			ids.add("15 : ‡`vKvb`vi");
			ids.add("16 : ‡dwiIqvjv");
			ids.add("17 : ¶y`ª e¨emvqx (g~jab <=10000)");
			ids.add("18 : e¨emvqx (g~jab >10000)");
			ids.add("19 : `wR©");
			ids.add("20 : WªvBfvi");
			ids.add("21 : KzwUi wkí");
			ids.add("22 : ‡cvjwUª/ e¨emvi Rb¨ cï jvjb-cvjbKvix");
			ids.add("23 : ‰e`y¨wZK wg¯¿x");
			ids.add("24 : ‡nvwgIc¨vw_ Wv³vi");
			ids.add("25 : Ava¨vwZK wPwKrmK/ KweivR/ ISuv");
			ids.add("26 : ‡ckv`vi (Wv³vi/DwKj/ mvsevw`K)");
			ids.add("27 : Bgvg/ ag©hvRK");
			ids.add("28 : AemicÖvß PvKzixRxwe");
			ids.add("29 : QvÎ");
			ids.add("30 : ‡eKvi");
			ids.add("31 : A¶g");
			ids.add("32 : Kv‡Ri †jvK");
			ids.add("33 : Rwg`vi (km¨ Drcv`b A_ev Ab¨ †Kvb Kv‡R K…lK‡`i Rwg eM©v †`q)");
			ids.add("34 : we‡`‡k _v‡K");
			ids.add("35 : g„Z/wb‡LuvR");
			ids.add("36 : wf¶zK");
			ids.add("37 : wk¶K");
			ids.add("777 : Ab¨vb¨ (eY©bv wjLyb)");
			ids.add("999 : Rvwbbv");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spoccupation)));

			ids = new ArrayList<String>();
			ids.add("");

			ids.add("0 : bv");
			ids.add("1 : n¨v");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spdisability)));

			ids = new ArrayList<String>();
			ids.add("");

			ids.add("1 : cwjIi Kvi‡b AÿgZv");
			ids.add("2 : Rb¥MZ fv‡e cv‡qi cvZv evuKv n‡q _vKv");
			ids.add("3 : Kzô †iv‡Mi cÖfv‡e");
			ids.add("4 : gw¯Í‡®‹i AvNvZ RwbZ Ges R‡b¥i mgq †eªB‡bi AvNv‡Zi Kvi‡b m„ó ¯œvqy mgm¨v");

			ids.add("5 : ‡giæ`Û evKvu n‡q hvIqv");
			ids.add("6 : ‡giæ`‡Û AvNvZ");
			ids.add("7 : cÖmeKvjxb m„ó ÎæwU");
			ids.add("8 : evgyb ev Le©Kvq Ges wekvj ev AwZKvq AvK…wZ");
			ids.add("9 : AvNvZ, †cvov Ges A½nvwb");
			ids.add("10 : ‡giæ`‡Ûi ÎæwU ev ‡giæ`Û evuKv n‡q _vKv (‡giæ`‡Û ‡dvjvRwbZ †ivM)");
			ids.add("11 : ‡ckxi AÿgZv Ges †ckx ïwK‡q hvIqv (‡ckx‡Z Ges kix‡i µgea©gvb `ye©jZv)");

			ids.add("12 : ‡QvU‡`i wM‡Ui †ivM, evZRwbZ †ivM Ges Ab¨vb¨ wM‡Ui e¨v_v");
			ids.add("13 : nv‡oi msµgb (†giæ`‡Û hÿvmn)");
			ids.add("14 : wnc/‡Kvg‡oi wb‡Pi mgm¨v");
			ids.add("15 : ‡Mv` ‡ivM");
			ids.add("777 : Ab¨vb¨ wewfbœ ai‡bi AÿgZv (D‡jøL Kiæb)");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.sptypeofdisability)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : 1g= ‡ekxifvM");
			ids.add("2 : 2q=¯^í cwigvb");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spranking)));

			ids = new ArrayList<String>();
			ids.add("");

			ids.add("1 : 1");
			ids.add("2 : 2");
			ids.add("3 : 3");
			ids.add("4 : 4");
			ids.add("5 : 5");
			ids.add("6 : 6");
			ids.add("7 : 7");
			ids.add("8 : 8");
			ids.add("9 : 9");
			ids.add("10 : 10");
			ids.add("11 : 11");
			ids.add("12 : 12");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spmonthsworked)));

		} else {

			((CheckBox) v.findViewById(R.id.chkothermember)).setTypeface(null);

			((TextView) v.findViewById(R.id.lblAge)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblSex)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblrelation)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblnumberofyears))
					.setTypeface(null);
			((TextView) v.findViewById(R.id.lbloccupation)).setTypeface(null);
			((TextView) v.findViewById(R.id.lbldisability)).setTypeface(null);
			((TextView) v.findViewById(R.id.lbltypeofdisability))
					.setTypeface(null);

			((TextView) v.findViewById(R.id.lblranking)).setTypeface(null);
			((TextView) v.findViewById(R.id.lblmonthsworked)).setTypeface(null);

			((CheckBox) v.findViewById(R.id.chkothermember))
					.setText("Include other people not in the hh");

			((TextView) v.findViewById(R.id.lblAge))
					.setText("Age(Start from elderly to younger)");
			((TextView) v.findViewById(R.id.lblSex)).setText("Sex");
			((TextView) v.findViewById(R.id.lblrelation))
					.setText("Relation with HHH");
			((TextView) v.findViewById(R.id.lblnumberofyears))
					.setText("Number of years of formal Education");
			((TextView) v.findViewById(R.id.lbloccupation))
					.setText("Occupation");
			((TextView) v.findViewById(R.id.lbldisability))
					.setText("Disability");
			((TextView) v.findViewById(R.id.lbltypeofdisability))
					.setText("If yes,Type of disablity (According to **UNDP defination)");

			((TextView) v.findViewById(R.id.lblranking))
					.setText("Ranking of contribution to household income (i.e, 1st= major, 2nd = less contribution then the major contributer etc. )");
			((TextView) v.findViewById(R.id.lblmonthsworked))
					.setText("How many months worked in last 12 months?");
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());

			ArrayList<String> ids = new ArrayList<String>();
			ids.add("");
			ids.add("1");
			ids.add("2");
			ids.add("3");
			ids.add("4");
			ids.add("5");
			ids.add("6");
			ids.add("7");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spinnerMember)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : Male");
			ids.add("0 : Female");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spsex)));

			ids = new ArrayList<String>();
			ids.add("");

			ids.add("01 : HHH");
			ids.add("02 : Spouse");
			ids.add("03 : Son/daughter");
			ids.add("04 : Son-in law/dauther-in-law");
			ids.add("05 : Grandchild");
			ids.add("06 : Parent");
			ids.add("07 : Parent-in-law");
			ids.add("08 : Sibling");
			ids.add("09 : Other relative");
			ids.add("10 : Not related");
			ids.add("777 : Other, specify");
			ids.add("999 : Dont know");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.sprelation)));

			ids = new ArrayList<String>();
			ids.add("");

			ids.add("1 : 1");
			ids.add("2 : 2");
			ids.add("3 : 3");
			ids.add("4 : 4");
			ids.add("5 : 5");
			ids.add("6 : 6");
			ids.add("7 : 7");
			ids.add("8 : 8");
			ids.add("9 : 9");
			ids.add("10 : 10");
			ids.add("11 : 11");
			ids.add("12 : 12");
			ids.add("13 : 13");
			ids.add("14 : 14");
			ids.add("15 : 15");
			ids.add("16 : 16");
			ids.add("17 : 17");
			ids.add("18 : 18");
			ids.add("19 : 19");
			ids.add("20 : 20");
			ids.add("888 : 888");
			ids.add("999 : 999");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.speducation)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("01 : Farmer/Cultivator");
			ids.add("02 : Homemaker");
			ids.add("03 : Agri-labor");
			ids.add("04 : Non-agri labor");
			ids.add("05 : Salaried job (Govt : /Private/NGO)");
			ids.add("06 : Mason (Rajmistri)");
			ids.add("07 : Carpenter");
			ids.add("08 : Van/Rickshaw puller");
			ids.add("09 : Fisherman");
			ids.add("10 : Boatman");
			ids.add("11 : Blacksmith");
			ids.add("12 : Goldsmith");
			ids.add("13 : Potter (soil smith)");
			ids.add("14 : Shoe polish /maker");
			ids.add("15 : Shopkeeper");
			ids.add("16 : Vendor (Feriwala/howker)");
			ids.add("17 : Petty trader, capital <=10000");
			ids.add("18 : Business,  capital >10000");
			ids.add("19 : Tailor");
			ids.add("20 : Driver");
			ids.add("21 : Cottage industry");
			ids.add("22 : Poultry /livestock rearer");
			ids.add("23 : Electrician");
			ids.add("24 : Homeopath");
			ids.add("25 : Spiritual healer/kabiraj/ Ojha");
			ids.add("26 : Professional practitioner (Doctor/lawyer)");
			ids.add("27 : Imam/priest");
			ids.add("28 : Retired service holder");
			ids.add("29 : Student");
			ids.add("30 : Unemployed");
			ids.add("31 : Disabled");
			ids.add("32 : Domestic maid / servant");
			ids.add("33 : Landlord (Provide land for farmers for sharecropping or others)");
			ids.add("34 : Staying abroad");
			ids.add("35 : Died/untraced");
			ids.add("36 : Begger");
			ids.add("37 : Teacher");
			ids.add("777 : Others (specify)");
			ids.add("999 : Dont know");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spoccupation)));

			ids = new ArrayList<String>();
			ids.add("");

			ids.add("0 : bv");
			ids.add("1 : n¨v");
			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spdisability)));

			ids = new ArrayList<String>();
			ids.add("");

			ids.add("1 : cwjIi Kvi‡b AÿgZv");
			ids.add("2 : Rb¥MZ fv‡e cv‡qi cvZv evuKv n‡q _vKv");
			ids.add("3 : Kzô †iv‡Mi cÖfv‡e");
			ids.add("4 : gw¯Í‡®‹i AvNvZ RwbZ Ges R‡b¥i mgq †eªB‡bi AvNv‡Zi Kvi‡b m„ó ¯œvqy mgm¨v");

			ids.add("5 : ‡giæ`Û evKvu n‡q hvIqv");
			ids.add("6 : ‡giæ`‡Û AvNvZ");
			ids.add("7 : cÖmeKvjxb m„ó ÎæwU");
			ids.add("8 : evgyb ev Le©Kvq Ges wekvj ev AwZKvq AvK…wZ");
			ids.add("9 : AvNvZ, †cvov Ges A½nvwb");
			ids.add("10 : ‡giæ`‡Ûi ÎæwU ev ‡giæ`Û evuKv n‡q _vKv (‡giæ`‡Û ‡dvjvRwbZ †ivM)");
			ids.add("11 : ‡ckxi AÿgZv Ges †ckx ïwK‡q hvIqv (‡ckx‡Z Ges kix‡i µgea©gvb `ye©jZv)");

			ids.add("12 : ‡QvU‡`i wM‡Ui †ivM, evZRwbZ †ivM Ges Ab¨vb¨ wM‡Ui e¨v_v");
			ids.add("13 : nv‡oi msµgb (†giæ`‡Û hÿvmn)");
			ids.add("14 : wnc/‡Kvg‡oi wb‡Pi mgm¨v");
			ids.add("15 : ‡Mv` ‡ivM");
			ids.add("777 : Ab¨vb¨ wewfbœ ai‡bi AÿgZv (D‡jøL Kiæb)");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.sptypeofdisability)));

			ids = new ArrayList<String>();
			ids.add("");
			ids.add("1 : 1g= ‡ekxifvM");
			ids.add("2 : 2q=¯^í cwigvb");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spranking)));

			ids = new ArrayList<String>();
			ids.add("");

			ids.add("1 : 1");
			ids.add("2 : 2");
			ids.add("3 : 3");
			ids.add("4 : 4");
			ids.add("5 : 5");
			ids.add("6 : 6");
			ids.add("7 : 7");
			ids.add("8 : 8");
			ids.add("9 : 9");
			ids.add("10 : 10");
			ids.add("11 : 11");
			ids.add("12 : 12");

			CommonStaticClass.FillCombo(thisactivity, ids,
					((Spinner) v.findViewById(R.id.spmonthsworked)));

		}

	}

	private void loadAllUiViewsFrmHouseHoldFoodConsumption(final ViewGroup v) {

		// HideFamily(v);

		/*
		 * qqq = (TextView) v.findViewById(R.id.qqq);
		 * 
		 * if (CommonStaticClass.langBng) { if (CommonStaticClass.questionMap
		 * .get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
		 * Typeface font = Typeface.createFromAsset(getAssets(),
		 * "Siyam Rupali ANSI.ttf"); qqq.setTypeface(font); } ;
		 * qqq.setText(CommonStaticClass.questionMap
		 * .get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ?
		 * CommonStaticClass.questionMap
		 * .get(CommonStaticClass.currentSLNo).getQdescbng() :
		 * CommonStaticClass.questionMap.get(
		 * CommonStaticClass.currentSLNo).getQdesceng()); } else {
		 * qqq.setTypeface(null); qqq.setText(CommonStaticClass.questionMap.get(
		 * CommonStaticClass.currentSLNo).getQdesceng()); }
		 */

		// lblSL = (TextView) v.findViewById(R.id.lblMemberID);

		/*
		 * spinnercategory = (Spinner) v.findViewById(R.id.spcategory);
		 * spinneritem = (Spinner) v.findViewById(R.id.spitemcolumn);
		 * spinnercategory.setFocusableInTouchMode(true);
		 * spinnercategory.requestFocus();
		 */

	}

	// FrmGPSDataCollection part
	private void Load_UIFrmGPSDataCollection(final ViewGroup v) {
		txtLongitute = (EditText) v.findViewById(R.id.txtLongitude);
		txtLatitue = (EditText) v.findViewById(R.id.txtLatitude);

		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();
		qqq = (TextView) v.findViewById(R.id.qqq);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		getGPSDataButton = (Button) v.findViewById(R.id.btnGetGPS);
		getGPSDataButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				try {
					locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

					locationManager.requestLocationUpdates(
							LocationManager.GPS_PROVIDER, 100, 1,
							new MyLocationListener());

					/*
					 * locationManager = (LocationManager)
					 * getSystemService(Context.LOCATION_SERVICE);
					 * 
					 * locationManager.requestLocationUpdates(
					 * LocationManager.GPS_PROVIDER, 100, 1, new
					 * MyLocationListenerFrmGPSDataCollection());
					 */
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		prevButton = (Button) v.findViewById(R.id.prevButton);
		prevButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		saveNxtButton = (Button) v.findViewById(R.id.saveNxtButton);
		saveNxtButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateTableDataFrmGPSDataCollection();
				// preserveState();
			}

		});
		clButton = (Button) v.findViewById(R.id.clButton);
		clButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) v);
			}

		});
		notesButton = (Button) v.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});

	}

	private class MyLocationListener implements LocationListener {

		public void onLocationChanged(Location location) {
			txtLongitute.setText(String.valueOf(location.getLongitude()));
			txtLatitue.setText(String.valueOf(location.getLatitude()));
			/*
			 * Toast.makeText(con, "GPS Location Changed", Toast.LENGTH_SHORT)
			 * .show();
			 */
			// txtLongitute.setText(String.format("%1$s",location.getLongitude()));
			// txtLatitue.setText(String.format("%1$s",location.getLatitude()));
		}

		public void onStatusChanged(String s, int i, Bundle b) {

		}

		public void onProviderDisabled(String s) {

		}

		public void onProviderEnabled(String s) {

		}

	}

	private void updateTableDataFrmGPSDataCollection() {
		// TODO Auto-generated method stub
		String sLongitude = txtLongitute.getText().toString();
		String sLatitude = txtLatitue.getText().toString();

		if (sLongitude.length() > 0 && sLatitude.length() > 0) {
			String sql = "UPDATE "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " SET Longitude='" + sLongitude + "',Latitude='"
					+ sLatitude + "' where dataid='" + CommonStaticClass.dataId
					+ "'";

			if (dbHelper.executeDMLQuery(sql)) {

				CommonStaticClass.findOutNextSLNo(
						CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getQvar(),
						CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getQnext1());
				CommonStaticClass.nextQuestion(ParentActivity.this);
			}
		}
	}

	protected void showCurrentLocationFrmGPSDataCollection() {

		try {
			Location location = locationManager
					.getLastKnownLocation(LocationManager.GPS_PROVIDER);

			if (location != null) {

				txtLongitute.setText(String.format("%1$s",
						location.getLongitude()));
				txtLatitue
						.setText(String.format("%1$s", location.getLatitude()));

			}
		} catch (Exception e) {
			Toast.makeText(con, e.toString(), 0);
		}

	}

	private class MyLocationListenerFrmGPSDataCollection implements
			LocationListener {

		public void onLocationChanged(Location location) {
			txtLongitute
					.setText(String.format("%1$s", location.getLongitude()));
			txtLatitue.setText(String.format("%1$s", location.getLatitude()));
		}

		public void onStatusChanged(String s, int i, Bundle b) {

		}

		public void onProviderDisabled(String s) {

		}

		public void onProviderEnabled(String s) {

		}

	}

	private void Load_DataFrmGPSDataCollection() {
		String sql = "Select * from "
				+ CommonStaticClass.questionMap.get(
						CommonStaticClass.currentSLNo).getTablename()
				+ " where dataid='" + CommonStaticClass.dataId + "'";
		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.moveToFirst()) {
				do {
					String column1 = "Longitude";
					String column2 = "Latitude";

					if (mCursor1.getColumnIndex(column1) != -1) {
						String a = mCursor1.getString(mCursor1
								.getColumnIndex(column1)) + "";
						String b = mCursor1.getString(mCursor1
								.getColumnIndex(column2)) + "";

						txtLongitute.setText(a.toString());
						txtLatitue.setText(b.toString());

					}
				} while (mCursor1.moveToNext());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}

	}

	// FrmHHID part

	private void loadGuiFrmMultiple(ViewGroup v) {
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		// ((EditText) v.findViewById(R.id.et1_1)).setVisibility(View.GONE);
		((EditText) v.findViewById(R.id.et2_5)).setVisibility(View.GONE);
		((EditText) v.findViewById(R.id.et3_3)).setVisibility(View.GONE);
		((EditText) v.findViewById(R.id.et5_5)).setVisibility(View.GONE);
		((EditText) v.findViewById(R.id.et7_6)).setVisibility(View.GONE);
		((EditText) v.findViewById(R.id.et8_6)).setVisibility(View.GONE);
		((EditText) v.findViewById(R.id.et12_3)).setVisibility(View.GONE);
		((EditText) v.findViewById(R.id.et13_7)).setVisibility(View.GONE);
		((EditText) v.findViewById(R.id.et14_3)).setVisibility(View.GONE);

		((CheckBox) v.findViewById(R.id.chk1_1))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk1_1 = (ischecked == true) ? "1" : "2";
						/*
						 * ((EditText) findViewById(R.id.et1_1))
						 * .setVisibility(View.VISIBLE);
						 */
					}
				});

		/*
		 * ((EditText) v.findViewById(R.id.et1_1)) .addTextChangedListener(new
		 * TextWatcher() {
		 * 
		 * public void onTextChanged(CharSequence s, int start, int before, int
		 * count) {
		 * 
		 * }
		 * 
		 * public void beforeTextChanged(CharSequence s, int start, int count,
		 * int after) { // TODO Auto-generated method stub
		 * 
		 * }
		 * 
		 * public void afterTextChanged(Editable s) { if (s.toString().length()
		 * > 0) { et1_1_other = s.toString(); }
		 * 
		 * } });
		 */

		((CheckBox) v.findViewById(R.id.chk2_1))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk2_1 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk2_2))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk2_2 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk2_3))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk2_3 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk2_4))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk2_4 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk2_5))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk2_5 = (ischecked == true) ? "1" : "2";

					}
				});

		((EditText) v.findViewById(R.id.et2_5))
				.addTextChangedListener(new TextWatcher() {

					public void onTextChanged(CharSequence s, int start,
							int before, int count) {

					}

					public void beforeTextChanged(CharSequence s, int start,
							int count, int after) {
						// TODO Auto-generated method stub

					}

					public void afterTextChanged(Editable s) {
						if (s.toString().length() > 0) {
							et2_5_other = s.toString();
						}

					}
				});

		((CheckBox) v.findViewById(R.id.chk3_1))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk3_1 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk3_2))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk3_2 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk3_3))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk3_3 = (ischecked == true) ? "1" : "2";
						((EditText) findViewById(R.id.et3_3))
								.setVisibility(View.VISIBLE);

					}
				});

		((EditText) v.findViewById(R.id.et3_3))
				.addTextChangedListener(new TextWatcher() {

					public void onTextChanged(CharSequence s, int start,
							int before, int count) {

					}

					public void beforeTextChanged(CharSequence s, int start,
							int count, int after) {
						// TODO Auto-generated method stub

					}

					public void afterTextChanged(Editable s) {
						if (s.toString().length() > 0) {
							et3_3_other = s.toString();
						}

					}
				});

		((CheckBox) v.findViewById(R.id.chk4_1))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk4_1 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk4_2))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk4_2 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk5_1))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk5_1 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk5_2))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk5_2 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk5_3))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk5_3 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk5_4))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk5_4 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk5_5))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk5_5 = (ischecked == true) ? "1" : "2";
						((EditText) findViewById(R.id.et5_5))
								.setVisibility(View.VISIBLE);
					}
				});

		((EditText) v.findViewById(R.id.et5_5))
				.addTextChangedListener(new TextWatcher() {

					public void onTextChanged(CharSequence s, int start,
							int before, int count) {

					}

					public void beforeTextChanged(CharSequence s, int start,
							int count, int after) {
						// TODO Auto-generated method stub

					}

					public void afterTextChanged(Editable s) {
						if (s.toString().length() > 0) {
							et5_5_other = s.toString();
						}

					}
				});

		((CheckBox) v.findViewById(R.id.chk6_1))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk6_1 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk6_2))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk6_2 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk7_1))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk7_1 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk7_2))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk7_2 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk7_3))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk7_3 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk7_4))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk7_4 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk7_5))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk7_5 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk7_7))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk7_7 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk7_6))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk7_6 = (ischecked == true) ? "1" : "2";
						((EditText) findViewById(R.id.et7_6))
								.setVisibility(View.VISIBLE);
					}
				});

		((EditText) v.findViewById(R.id.et7_6))
				.addTextChangedListener(new TextWatcher() {

					public void onTextChanged(CharSequence s, int start,
							int before, int count) {

					}

					public void beforeTextChanged(CharSequence s, int start,
							int count, int after) {
						// TODO Auto-generated method stub

					}

					public void afterTextChanged(Editable s) {
						if (s.toString().length() > 0) {
							et7_6_other = s.toString();
						}

					}
				});

		((CheckBox) v.findViewById(R.id.chk8_1))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk8_1 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk8_2))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk8_2 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk8_3))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk8_3 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk8_4))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk8_4 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk8_5))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk8_5 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk8_6))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk8_6 = (ischecked == true) ? "1" : "2";
						((EditText) findViewById(R.id.et8_6))
								.setVisibility(View.VISIBLE);
					}
				});

		((EditText) v.findViewById(R.id.et8_6))
				.addTextChangedListener(new TextWatcher() {

					public void onTextChanged(CharSequence s, int start,
							int before, int count) {

					}

					public void beforeTextChanged(CharSequence s, int start,
							int count, int after) {
						// TODO Auto-generated method stub

					}

					public void afterTextChanged(Editable s) {
						if (s.toString().length() > 0) {
							et8_6_other = s.toString();
						}

					}
				});

		((CheckBox) v.findViewById(R.id.chk9_1))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk9_1 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk9_2))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk9_2 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk9_3))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk9_3 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk10_1))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk10_1 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk11_1))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk11_1 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk12_1))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk12_1 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk12_2))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk12_2 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk12_3))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk12_3 = (ischecked == true) ? "1" : "2";
						((EditText) findViewById(R.id.et12_3))
								.setVisibility(View.VISIBLE);
					}
				});

		((EditText) v.findViewById(R.id.et12_3))
				.addTextChangedListener(new TextWatcher() {

					public void onTextChanged(CharSequence s, int start,
							int before, int count) {

					}

					public void beforeTextChanged(CharSequence s, int start,
							int count, int after) {
						// TODO Auto-generated method stub

					}

					public void afterTextChanged(Editable s) {
						if (s.toString().length() > 0) {
							et12_3_other = s.toString();
						}

					}
				});

		((CheckBox) v.findViewById(R.id.chk13_1))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk13_1 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk13_2))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk13_2 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk13_3))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk13_3 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk13_4))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk13_4 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk13_5))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk13_5 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk13_6))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk13_6 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk13_7))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk13_7 = (ischecked == true) ? "1" : "2";
						((EditText) findViewById(R.id.et13_7))
								.setVisibility(View.VISIBLE);
					}
				});

		((EditText) v.findViewById(R.id.et13_7))
				.addTextChangedListener(new TextWatcher() {

					public void onTextChanged(CharSequence s, int start,
							int before, int count) {

					}

					public void beforeTextChanged(CharSequence s, int start,
							int count, int after) {
						// TODO Auto-generated method stub

					}

					public void afterTextChanged(Editable s) {
						if (s.toString().length() > 0) {
							et13_7_other = s.toString();
						}

					}
				});

		((CheckBox) v.findViewById(R.id.chk14_1))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk14_1 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk14_2))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk14_2 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk14_3))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk14_3 = (ischecked == true) ? "1" : "2";
						((EditText) findViewById(R.id.et14_3))
								.setVisibility(View.VISIBLE);
					}
				});

		((EditText) v.findViewById(R.id.et14_3))
				.addTextChangedListener(new TextWatcher() {

					public void onTextChanged(CharSequence s, int start,
							int before, int count) {

					}

					public void beforeTextChanged(CharSequence s, int start,
							int count, int after) {
						// TODO Auto-generated method stub

					}

					public void afterTextChanged(Editable s) {
						if (s.toString().length() > 0) {
							et14_3_other = s.toString();
						}

					}
				});

		((CheckBox) v.findViewById(R.id.chk15_1))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk15_1 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk15_2))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk15_2 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk15_3))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk15_3 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk16_1))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk16_1 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk16_2))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk16_2 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk16_3))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk16_3 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk16_4))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk16_4 = (ischecked == true) ? "1" : "2";

					}
				});
		((CheckBox) v.findViewById(R.id.chk16_5))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk16_5 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk17_1))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk17_1 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk17_2))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk17_2 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk17_3))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk17_3 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk17_4))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk17_4 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk18_1))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk18_1 = (ischecked == true) ? "1" : "2";

					}
				});

		((CheckBox) v.findViewById(R.id.chk18_2))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton arg0,
							boolean ischecked) {
						chk18_2 = (ischecked == true) ? "1" : "2";

					}
				});
		((EditText) v.findViewById(R.id.et19_1))
				.addTextChangedListener(new TextWatcher() {

					public void onTextChanged(CharSequence s, int start,
							int before, int count) {

					}

					public void beforeTextChanged(CharSequence s, int start,
							int count, int after) {
						// TODO Auto-generated method stub

					}

					public void afterTextChanged(Editable s) {
						if (s.toString().length() > 0) {
							et19_1 = s.toString();
						}

					}
				});

		String sql = "";

		sql = "Select c609_1_1,c609_2_1,c609_2_2,c609_2_3,c609_2_4,c609_2_5,c609_2_5_other,c609_3_1,c609_3_2,c609_3_3,c609_3_3_other,c609_4_1,c609_4_2,"
				+ "c609_5_1,c609_5_2,c609_5_3,c609_5_4,c609_5_5,c609_5_5_other,c609_6_1,c609_6_2,c609_7_1,c609_7_2,c609_7_3,c609_7_4,c609_7_5,c609_7_6, c609_7_7,c609_7_6_other,"
				+ "c609_8_1,c609_8_2,c609_8_3,c609_8_4,c609_8_5,c609_8_6,c609_8_6_other,c609_9_1,c609_9_2,c609_9_3,c609_10_1,c609_11_1,c609_12_1,c609_12_2,"
				+ "c609_12_3,c609_12_3_other ,c609_13_1,c609_13_2,c609_13_3,c609_13_4,c609_13_5,c609_13_6,c609_13_7,c609_13_7_other ,c609_14_1,c609_14_2,c609_14_3,"
				+ "c609_14_3_other ,c609_15_1,c609_15_2,c609_15_3,c609_16_1,c609_16_2,c609_16_3,c609_16_4, c609_16_5, c609_17_1,c609_17_2,c609_17_3, c609_17_4, c609_18_1,c609_18_2,c609_19_1 from "
				+ CommonStaticClass.questionMap.get(
						CommonStaticClass.currentSLNo).getTablename()
				+ " where dataid='" + CommonStaticClass.dataId + "'";

		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				if (mCursor1.moveToFirst()) {
					do {

						chk1_1 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_1_1")) + "";
						if (chk1_1.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk1_1))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk1_1))
									.setChecked(false);
						}

						/*
						 * et1_1_other = mCursor1.getString(mCursor1
						 * .getColumnIndex("c609_1_1_other")) + "";
						 * 
						 * if (et1_1_other.length() > 0 &&
						 * !et1_1_other.equalsIgnoreCase("null")) { ((EditText)
						 * findViewById(R.id.et1_1))
						 * .setVisibility(View.VISIBLE); ((EditText)
						 * findViewById(R.id.et1_1)) .setText(et1_1_other);
						 * 
						 * }
						 */

						chk2_1 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_2_1")) + "";

						if (chk2_1.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk2_1))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk2_1))
									.setChecked(false);
						}

						chk2_2 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_2_2")) + "";

						if (chk2_2.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk2_2))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk2_2))
									.setChecked(false);
						}

						chk2_3 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_2_3")) + "";
						if (chk2_3.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk2_3))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk2_3))
									.setChecked(false);
						}

						chk2_4 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_2_4")) + "";
						if (chk2_4.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk2_4))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk2_4))
									.setChecked(false);
						}

						chk2_5 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_2_5")) + "";
						if (chk2_5.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk2_5))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk2_5))
									.setChecked(false);
						}

						et2_5_other = mCursor1.getString(mCursor1
								.getColumnIndex("c609_2_5_other")) + "";
						((EditText) findViewById(R.id.et2_5))
								.setText(et2_5_other);

						if (et2_5_other.length() > 0
								&& !et2_5_other.equalsIgnoreCase("null")) {
							((EditText) findViewById(R.id.et2_5))
									.setVisibility(View.VISIBLE);
						}

						chk3_1 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_3_1")) + "";
						if (chk3_1.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk3_1))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk3_1))
									.setChecked(false);
						}

						chk3_2 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_3_2")) + "";
						if (chk3_2.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk3_2))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk3_2))
									.setChecked(false);
						}
						chk3_3 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_3_3")) + "";
						if (chk3_3.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk3_3))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk3_3))
									.setChecked(false);
						}
						et3_3_other = mCursor1.getString(mCursor1
								.getColumnIndex("c609_3_3_other")) + "";
						((EditText) findViewById(R.id.et3_3))
								.setText(et3_3_other);

						if (et3_3_other.length() > 0
								&& !et3_3_other.equalsIgnoreCase("null")) {
							((EditText) findViewById(R.id.et3_3))
									.setVisibility(View.VISIBLE);
						}

						chk4_1 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_4_1")) + "";
						if (chk4_1.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk4_1))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk4_1))
									.setChecked(false);
						}
						chk4_2 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_4_2")) + "";
						if (chk4_2.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk4_2))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk4_2))
									.setChecked(false);
						}

						chk5_1 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_5_1")) + "";
						if (chk5_1.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk5_1))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk5_1))
									.setChecked(false);
						}

						chk5_2 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_5_2")) + "";
						if (chk5_2.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk5_2))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk5_2))
									.setChecked(false);
						}

						chk5_3 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_5_3")) + "";
						if (chk5_3.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk5_3))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk5_3))
									.setChecked(false);
						}

						chk5_4 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_5_4")) + "";
						if (chk5_4.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk5_4))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk5_4))
									.setChecked(false);
						}
						chk5_5 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_5_5")) + "";
						if (chk5_5.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk5_5))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk5_5))
									.setChecked(false);
						}

						et5_5_other = mCursor1.getString(mCursor1
								.getColumnIndex("c609_5_5_other")) + "";
						((EditText) findViewById(R.id.et5_5))
								.setText(et5_5_other);

						if (et5_5_other.length() > 0
								&& !et5_5_other.equalsIgnoreCase("null")) {
							((EditText) findViewById(R.id.et5_5))
									.setVisibility(View.VISIBLE);
						}

						chk6_1 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_6_1")) + "";
						if (chk6_1.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk6_1))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk6_1))
									.setChecked(false);
						}
						chk6_2 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_6_2")) + "";
						if (chk6_2.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk6_2))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk6_2))
									.setChecked(false);
						}
						chk7_1 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_7_1")) + "";
						if (chk7_1.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk7_1))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk7_1))
									.setChecked(false);
						}
						chk7_2 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_7_2")) + "";
						if (chk7_2.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk7_2))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk7_2))
									.setChecked(false);
						}
						chk7_3 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_7_3")) + "";
						if (chk7_3.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk7_3))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk7_3))
									.setChecked(false);
						}
						chk7_4 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_7_4")) + "";
						if (chk7_4.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk7_4))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk7_4))
									.setChecked(false);
						}
						chk7_5 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_7_5")) + "";
						if (chk7_5.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk7_5))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk7_5))
									.setChecked(false);
						}

						chk7_7 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_7_7")) + "";
						if (chk7_7.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk7_7))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk7_7))
									.setChecked(false);
						}

						chk7_6 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_7_6")) + "";
						if (chk7_6.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk7_6))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk7_6))
									.setChecked(false);
						}
						et7_6_other = mCursor1.getString(mCursor1
								.getColumnIndex("c609_7_6_other")) + "";
						((EditText) findViewById(R.id.et7_6))
								.setText(et7_6_other);

						if (et7_6_other.length() > 0
								&& !et7_6_other.equalsIgnoreCase("null")) {
							((EditText) findViewById(R.id.et7_6))
									.setVisibility(View.VISIBLE);
						}

						chk8_1 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_8_1")) + "";
						if (chk8_1.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk8_1))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk8_1))
									.setChecked(false);
						}
						chk8_2 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_8_2")) + "";
						if (chk8_2.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk8_2))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk8_2))
									.setChecked(false);
						}
						chk8_3 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_8_3")) + "";
						if (chk8_3.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk8_3))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk8_3))
									.setChecked(false);
						}
						chk8_4 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_8_4")) + "";
						if (chk8_4.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk8_4))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk8_4))
									.setChecked(false);
						}
						chk8_5 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_8_5")) + "";
						if (chk8_5.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk8_5))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk8_5))
									.setChecked(false);
						}
						chk8_6 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_8_6")) + "";
						if (chk8_6.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk8_6))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk8_6))
									.setChecked(false);
						}
						et8_6_other = mCursor1.getString(mCursor1
								.getColumnIndex("c609_8_6_other")) + "";
						((EditText) findViewById(R.id.et8_6))
								.setText(et8_6_other);

						if (et8_6_other.length() > 0
								&& !et8_6_other.equalsIgnoreCase("null")) {
							((EditText) findViewById(R.id.et8_6))
									.setVisibility(View.VISIBLE);
						}

						chk9_1 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_9_1")) + "";
						if (chk9_1.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk9_1))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk9_1))
									.setChecked(false);
						}
						chk9_2 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_9_2")) + "";
						if (chk9_2.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk9_2))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk9_2))
									.setChecked(false);
						}
						chk9_3 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_9_3")) + "";
						if (chk9_3.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk9_3))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk9_3))
									.setChecked(false);
						}
						chk10_1 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_10_1")) + "";
						if (chk10_1.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk10_1))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk10_1))
									.setChecked(false);
						}
						chk11_1 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_11_1")) + "";
						if (chk11_1.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk11_1))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk11_1))
									.setChecked(false);
						}
						chk12_1 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_12_1")) + "";
						if (chk12_1.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk12_1))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk12_1))
									.setChecked(false);
						}
						chk12_2 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_12_2")) + "";
						if (chk12_2.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk12_2))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk12_2))
									.setChecked(false);
						}
						chk12_3 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_12_3")) + "";
						if (chk12_3.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk12_3))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk12_3))
									.setChecked(false);
						}
						et12_3_other = mCursor1.getString(mCursor1
								.getColumnIndex("c609_12_3_other")) + "";
						((EditText) findViewById(R.id.et12_3))
								.setText(et12_3_other);

						if (et12_3_other.length() > 0
								&& !et12_3_other.equalsIgnoreCase("null")) {
							((EditText) findViewById(R.id.et12_3))
									.setVisibility(View.VISIBLE);
						}

						chk13_1 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_13_1")) + "";
						if (chk13_1.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk13_1))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk13_1))
									.setChecked(false);
						}
						chk13_2 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_13_2")) + "";
						if (chk13_2.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk13_2))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk13_2))
									.setChecked(false);
						}
						chk13_3 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_13_3")) + "";
						if (chk13_3.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk13_3))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk13_3))
									.setChecked(false);
						}
						chk13_4 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_13_4")) + "";
						if (chk13_4.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk13_4))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk2_1))
									.setChecked(false);
						}
						chk13_5 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_13_5")) + "";
						if (chk13_5.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk13_5))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk13_5))
									.setChecked(false);
						}
						chk13_6 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_13_6")) + "";
						if (chk13_6.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk13_6))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk13_6))
									.setChecked(false);
						}
						chk13_7 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_13_7")) + "";
						if (chk13_7.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk13_7))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk13_7))
									.setChecked(false);
						}
						et13_7_other = mCursor1.getString(mCursor1
								.getColumnIndex("c609_13_7_other")) + "";
						((EditText) findViewById(R.id.et13_7))
								.setText(et13_7_other);

						if (et13_7_other.length() > 0
								&& !et13_7_other.equalsIgnoreCase("null")) {
							((EditText) findViewById(R.id.et13_7))
									.setVisibility(View.VISIBLE);
						}

						chk14_1 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_14_1")) + "";
						if (chk14_1.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk14_1))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk14_1))
									.setChecked(false);
						}
						chk14_2 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_14_2")) + "";
						if (chk14_2.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk14_2))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk14_2))
									.setChecked(false);
						}
						chk14_3 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_14_3")) + "";
						if (chk14_3.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk14_3))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk14_3))
									.setChecked(false);
						}
						et14_3_other = mCursor1.getString(mCursor1
								.getColumnIndex("c609_14_3_other")) + "";
						((EditText) findViewById(R.id.et14_3))
								.setText(et14_3_other);

						if (et14_3_other.length() > 0
								&& !et14_3_other.equalsIgnoreCase("null")) {
							((EditText) findViewById(R.id.et14_3))
									.setVisibility(View.VISIBLE);
						}

						chk15_1 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_15_1")) + "";
						if (chk15_1.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk15_1))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk15_1))
									.setChecked(false);
						}
						chk15_2 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_15_2")) + "";
						if (chk15_2.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk15_2))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk15_2))
									.setChecked(false);
						}
						chk15_3 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_15_3")) + "";
						if (chk15_3.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk15_3))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk15_3))
									.setChecked(false);
						}
						chk16_1 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_16_1")) + "";
						if (chk16_1.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk16_1))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk16_1))
									.setChecked(false);
						}
						chk16_2 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_16_2")) + "";
						if (chk16_2.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk16_2))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk16_2))
									.setChecked(false);
						}
						chk16_3 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_16_3")) + "";
						if (chk16_3.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk16_3))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk16_3))
									.setChecked(false);
						}
						chk16_4 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_16_4")) + "";
						if (chk16_4.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk16_4))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk16_4))
									.setChecked(false);
						}

						chk16_5 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_16_5")) + "";
						if (chk16_5.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk16_5))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk16_5))
									.setChecked(false);
						}

						chk17_1 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_17_1")) + "";
						if (chk17_1.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk17_1))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk17_1))
									.setChecked(false);
						}
						chk17_2 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_17_2")) + "";
						if (chk17_2.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk17_2))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk17_2))
									.setChecked(false);
						}
						chk17_3 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_17_3")) + "";
						if (chk17_3.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk17_3))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk17_3))
									.setChecked(false);
						}

						chk17_4 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_17_4")) + "";
						if (chk17_4.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk17_4))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk17_4))
									.setChecked(false);
						}

						chk18_1 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_18_1")) + "";
						if (chk18_1.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk18_1))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk18_1))
									.setChecked(false);
						}
						chk18_2 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_18_2")) + "";
						if (chk18_2.equalsIgnoreCase("1")) {
							((CheckBox) v.findViewById(R.id.chk18_2))
									.setChecked(true);
						} else {
							((CheckBox) v.findViewById(R.id.chk18_2))
									.setChecked(false);
						}
						et19_1 = mCursor1.getString(mCursor1
								.getColumnIndex("c609_19_1")) + "";

						((EditText) findViewById(R.id.et19_1)).setText((et19_1
								.length() > 0
								&& (!et19_1.equalsIgnoreCase("-1")) && (!et19_1
								.equalsIgnoreCase("null"))) ? et19_1 : "");

						// seeting if null text
						if ((((EditText) findViewById(R.id.et2_5)).getText()
								.toString().equalsIgnoreCase("null"))) {
							((EditText) findViewById(R.id.et2_5)).setText("");
						}

						if ((((EditText) findViewById(R.id.et3_3)).getText()
								.toString().equalsIgnoreCase("null"))) {
							((EditText) findViewById(R.id.et3_3)).setText("");
						}

						if ((((EditText) findViewById(R.id.et5_5)).getText()
								.toString().equalsIgnoreCase("null"))) {
							((EditText) findViewById(R.id.et5_5)).setText("");
						}

						if ((((EditText) findViewById(R.id.et7_6)).getText()
								.toString().equalsIgnoreCase("null"))) {
							((EditText) findViewById(R.id.et7_6)).setText("");
						}

						if ((((EditText) findViewById(R.id.et8_6)).getText()
								.toString().equalsIgnoreCase("null"))) {
							((EditText) findViewById(R.id.et8_6)).setText("");
						}

						if ((((EditText) findViewById(R.id.et12_3)).getText()
								.toString().equalsIgnoreCase("null"))) {
							((EditText) findViewById(R.id.et12_3)).setText("");
						}

						if ((((EditText) findViewById(R.id.et13_7)).getText()
								.toString().equalsIgnoreCase("null"))) {
							((EditText) findViewById(R.id.et13_7)).setText("");
						}

						if ((((EditText) findViewById(R.id.et14_3)).getText()
								.toString().equalsIgnoreCase("null"))) {
							((EditText) findViewById(R.id.et14_3)).setText("");
						}
					} while (mCursor1.moveToNext());
				}
				// doFillFrmMultiple(mCursor1,v);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}

		saveNxtButton = (Button) v.findViewById(R.id.saveNxtButton);
		saveNxtButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				updatemultiple();
			}

		});
		btnPrev = (Button) v.findViewById(R.id.prevButton);
		btnPrev.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		btnClear = (Button) v.findViewById(R.id.clButton);
		btnClear.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) vv);
			}

		});
		notesButton = (Button) v.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});

		if (CommonStaticClass.langBng) {
			setfonttobanglamultiple(v);
		} else {
			((TextView) v.findViewById(R.id.textView2)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk1_1)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk2_1)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk2_2)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk2_3)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk2_4)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk2_5)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk3_1)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk3_2)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk3_3)).setTypeface(null);

			((CheckBox) v.findViewById(R.id.chk4_1)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk4_2)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk5_1)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk5_2)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk5_3)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk5_4)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk5_5)).setTypeface(null);

			((CheckBox) v.findViewById(R.id.chk6_1)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk6_2)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk7_1)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk7_2)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk7_3)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk7_4)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk7_5)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk7_7)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk7_6)).setTypeface(null);

			((CheckBox) v.findViewById(R.id.chk8_1)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk8_2)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk8_3)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk8_4)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk8_5)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk8_6)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk9_1)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk9_2)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk9_3)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk10_1)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk11_1)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk12_1)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk12_2)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk12_3)).setTypeface(null);

			((CheckBox) v.findViewById(R.id.chk13_1)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk13_2)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk13_3)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk13_4)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk13_5)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk13_6)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk13_7)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk14_1)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk14_2)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk14_3)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk15_1)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk15_2)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk15_3)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk16_1)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk16_2)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk16_3)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk16_4)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk16_5)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk17_1)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk17_2)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk17_3)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk17_4)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk18_1)).setTypeface(null);
			((CheckBox) v.findViewById(R.id.chk18_2)).setTypeface(null);

			// setting text to english
			((CheckBox) v.findViewById(R.id.chk1_1)).setText("Khichuri");
			((CheckBox) v.findViewById(R.id.chk2_1)).setText("Porridge");
			((CheckBox) v.findViewById(R.id.chk2_2)).setText("Rice");
			((CheckBox) v.findViewById(R.id.chk2_3)).setText("Bread/Roti");
			((CheckBox) v.findViewById(R.id.chk2_4)).setText("Noodles");
			((CheckBox) v.findViewById(R.id.chk2_5))
					.setText("Other foods made by grain");
			((CheckBox) v.findViewById(R.id.chk3_1)).setText("Pumpkin");
			((CheckBox) v.findViewById(R.id.chk3_2)).setText("Carrots");
			((CheckBox) v.findViewById(R.id.chk3_3))
					.setText("Other yellow vegetable");

			((CheckBox) v.findViewById(R.id.chk4_1)).setText("Potato");
			((CheckBox) v.findViewById(R.id.chk4_2))
					.setText("White sweet potato");
			((CheckBox) v.findViewById(R.id.chk5_1)).setText("Pumpkin leaves");
			((CheckBox) v.findViewById(R.id.chk5_2)).setText("Mustard leaves");
			((CheckBox) v.findViewById(R.id.chk5_3)).setText("Bean leaves");
			((CheckBox) v.findViewById(R.id.chk5_4))
					.setText("Pigeon pea/Motoshuti leaves");
			((CheckBox) v.findViewById(R.id.chk5_5))
					.setText("other dark green leaves");

			((CheckBox) v.findViewById(R.id.chk6_1)).setText("Ripe mango");
			((CheckBox) v.findViewById(R.id.chk6_2)).setText("Ripe papaya");
			((CheckBox) v.findViewById(R.id.chk7_1)).setText("Banana");
			((CheckBox) v.findViewById(R.id.chk7_2)).setText("Pineapple");
			((CheckBox) v.findViewById(R.id.chk7_3)).setText("Guava");
			((CheckBox) v.findViewById(R.id.chk7_4)).setText("Apple");
			((CheckBox) v.findViewById(R.id.chk7_5)).setText("Grape");
			((CheckBox) v.findViewById(R.id.chk7_7)).setText("Orange");
			((CheckBox) v.findViewById(R.id.chk7_6)).setText("Other fruit");

			((CheckBox) v.findViewById(R.id.chk8_1)).setText("Tomato");
			((CheckBox) v.findViewById(R.id.chk8_2)).setText("Onion");
			((CheckBox) v.findViewById(R.id.chk8_3)).setText("Mushroom");
			((CheckBox) v.findViewById(R.id.chk8_4)).setText("Lady's finger");
			((CheckBox) v.findViewById(R.id.chk8_5))
					.setText("Fresh bean/motorshuti");
			((CheckBox) v.findViewById(R.id.chk8_6)).setText("Other vegetable");
			((CheckBox) v.findViewById(R.id.chk9_1)).setText("Liver");
			((CheckBox) v.findViewById(R.id.chk9_2)).setText("Kidney");
			((CheckBox) v.findViewById(R.id.chk9_3)).setText("Heart");
			((CheckBox) v.findViewById(R.id.chk10_1))
					.setText("Any type of meat/flesh,including from birds and animals");
			((CheckBox) v.findViewById(R.id.chk11_1))
					.setText("Any type of egg");
			((CheckBox) v.findViewById(R.id.chk12_1)).setText("Fresh fish");
			((CheckBox) v.findViewById(R.id.chk12_2)).setText("Dried fish");
			((CheckBox) v.findViewById(R.id.chk12_3))
					.setText("Other fish / seafood");

			((CheckBox) v.findViewById(R.id.chk13_1)).setText("Beans");
			((CheckBox) v.findViewById(R.id.chk13_2)).setText("Peas/Lentils");
			((CheckBox) v.findViewById(R.id.chk13_3)).setText("Soya");
			((CheckBox) v.findViewById(R.id.chk13_4)).setText("Groundnut");
			((CheckBox) v.findViewById(R.id.chk13_5)).setText("Cashew");
			((CheckBox) v.findViewById(R.id.chk13_6))
					.setText("Pounded groundnut");
			((CheckBox) v.findViewById(R.id.chk13_7))
					.setText("Anyother legume or nut");
			((CheckBox) v.findViewById(R.id.chk14_1)).setText("Cheese");
			((CheckBox) v.findViewById(R.id.chk14_2)).setText("Yogurt");
			((CheckBox) v.findViewById(R.id.chk14_3))
					.setText("Other milk products");
			((CheckBox) v.findViewById(R.id.chk15_1)).setText("Vegetable oil");
			((CheckBox) v.findViewById(R.id.chk15_2)).setText("Animal fat");
			((CheckBox) v.findViewById(R.id.chk15_3)).setText("Margarine");
			((CheckBox) v.findViewById(R.id.chk16_1)).setText("Chocolate");
			((CheckBox) v.findViewById(R.id.chk16_2)).setText("Sweets/candies");
			((CheckBox) v.findViewById(R.id.chk16_3)).setText("Cake");
			((CheckBox) v.findViewById(R.id.chk16_4))
					.setText("Cookies/sweet biscuits");
			((CheckBox) v.findViewById(R.id.chk16_5)).setText("Sugar");
			((CheckBox) v.findViewById(R.id.chk17_1)).setText("Seasonings");
			((CheckBox) v.findViewById(R.id.chk17_2)).setText("Garlic");
			((CheckBox) v.findViewById(R.id.chk17_3)).setText("Spices");
			((CheckBox) v.findViewById(R.id.chk17_4)).setText("Salt");
			((CheckBox) v.findViewById(R.id.chk18_1)).setText("Prawns");
			((CheckBox) v.findViewById(R.id.chk18_2)).setText("Crab");
			((TextView) v.findViewById(R.id.textView2))
					.setText("If not on list above, write food(s) here");
		}

	}

	private void setfonttobanglamultiple(ViewGroup v) {

		((CheckBox) v.findViewById(R.id.chk1_1))
				.setText("wLPzox( wLPzox wK wK w`‡q ivbœv n‡q‡Q †R‡b wb‡q dzW MÖc Abyhvqx bx‡P †KvW Kiyb)");
		/*
		 * ((TextView) v.findViewById(R.id.textView3)) .setText(
		 * "cvwb‡Z ev `y‡a wm× Kiv km¨ RvZxq Lvevi †hgb: mywR,fvZ, iywU, byWzjm,  Ab¨vb¨  km¨ RvZxq `vbv`vi Lv`¨"
		 * );
		 */

		((CheckBox) v.findViewById(R.id.chk2_1)).setText("mywR");
		((CheckBox) v.findViewById(R.id.chk2_2)).setText("fvZ");
		((CheckBox) v.findViewById(R.id.chk2_3)).setText("iywU");
		((CheckBox) v.findViewById(R.id.chk2_4)).setText("byWzjm");
		((CheckBox) v.findViewById(R.id.chk2_5))
				.setText("Ab¨vb¨  km¨ RvZxq `vbv`vi Lv`¨");

		((CheckBox) v.findViewById(R.id.chk3_1)).setText("wgwó Kzgov");

		((CheckBox) v.findViewById(R.id.chk3_2)).setText("MvRi");

		((CheckBox) v.findViewById(R.id.chk3_3)).setText("Ab¨vb¨ njy` meRx");

		((CheckBox) v.findViewById(R.id.chk4_1)).setText("Avjy");

		((CheckBox) v.findViewById(R.id.chk4_2)).setText("mv`v wgwó Avjy");

		((CheckBox) v.findViewById(R.id.chk5_1)).setText("wgwó Kzgov kvK");

		((CheckBox) v.findViewById(R.id.chk5_2)).setText("mwilv kvK");

		((CheckBox) v.findViewById(R.id.chk5_3)).setText("gUi ïwU kvK");

		((CheckBox) v.findViewById(R.id.chk5_4))
				.setText("gUi ïwU kvK,  cyBu kvK");

		((CheckBox) v.findViewById(R.id.chk5_5)).setText("Ab¨vb¨ Mvp meyR kvK");

		((CheckBox) v.findViewById(R.id.chk6_1)).setText("cvKv Avg");

		((CheckBox) v.findViewById(R.id.chk6_2)).setText("cvKv †cu‡cu");

		((CheckBox) v.findViewById(R.id.chk7_1)).setText("Kjv");

		((CheckBox) v.findViewById(R.id.chk7_2)).setText("Avbvim");

		((CheckBox) v.findViewById(R.id.chk7_3)).setText("‡cqviv");

		((CheckBox) v.findViewById(R.id.chk7_4)).setText("Av‡cj");

		((CheckBox) v.findViewById(R.id.chk7_5)).setText("Av½yi");

		((CheckBox) v.findViewById(R.id.chk7_7)).setText("Kgjv");

		((CheckBox) v.findViewById(R.id.chk7_6)).setText("Ab¨vb¨ dj");

		((CheckBox) v.findViewById(R.id.chk8_1)).setText("U‡g‡Uv");

		((CheckBox) v.findViewById(R.id.chk8_2)).setText("wcuqvR");

		((CheckBox) v.findViewById(R.id.chk8_3)).setText("gvkiyg");

		((CheckBox) v.findViewById(R.id.chk8_4)).setText("‡pom");

		((CheckBox) v.findViewById(R.id.chk8_5)).setText("ZvRv mxg/gUi ïwU");

		((CheckBox) v.findViewById(R.id.chk8_6)).setText("Ab¨vb¨ mewR");

		((CheckBox) v.findViewById(R.id.chk9_1)).setText(" KwjRv");

		((CheckBox) v.findViewById(R.id.chk9_2)).setText("wMjv");

		((CheckBox) v.findViewById(R.id.chk9_3)).setText("Heart");

		((CheckBox) v.findViewById(R.id.chk10_1))
				.setText("†h †Kvb gvsm ,cï cvwLmn");

		((CheckBox) v.findViewById(R.id.chk11_1)).setText("†h †Kvb ai‡Yi wWg");

		((CheckBox) v.findViewById(R.id.chk12_1)).setText("ZvRv  gvQ");

		((CheckBox) v.findViewById(R.id.chk12_2)).setText("ïUwK gvQ");

		((CheckBox) v.findViewById(R.id.chk12_3))
				.setText("Ab¨vb¨ gvQ / mvgyw`ªK Lvevi");

		((CheckBox) v.findViewById(R.id.chk13_1)).setText("mxg");

		((CheckBox) v.findViewById(R.id.chk13_2)).setText("Wvj");

		((CheckBox) v.findViewById(R.id.chk13_3)).setText("mqv");

		((CheckBox) v.findViewById(R.id.chk13_4)).setText("Pxbvev`vg");

		((CheckBox) v.findViewById(R.id.chk13_5)).setText("†Kki");

		((CheckBox) v.findViewById(R.id.chk13_6)).setText("fvix Pxbvev`vg");

		((CheckBox) v.findViewById(R.id.chk13_7))
				.setText("Ab¨vb¨ †h †Kvb Wvj ev ev`vg RvZxq");

		((CheckBox) v.findViewById(R.id.chk14_1)).setText("cwbi");

		((CheckBox) v.findViewById(R.id.chk14_2)).setText("`B");

		((CheckBox) v.findViewById(R.id.chk14_3))
				.setText("Ab¨vb¨ `ya RvZxq Lv`¨");

		((CheckBox) v.findViewById(R.id.chk15_1)).setText("Dw™¢¾ ‡Zj (WvjWv)");

		((CheckBox) v.findViewById(R.id.chk15_2)).setText("cïi Pwe");

		((CheckBox) v.findViewById(R.id.chk15_3)).setText("GK ai‡bi gvLb");

		((CheckBox) v.findViewById(R.id.chk16_1)).setText("PK‡jU");

		((CheckBox) v.findViewById(R.id.chk16_2)).setText("wgwó/ K¨vwÛ");

		((CheckBox) v.findViewById(R.id.chk16_3)).setText("wcVv");

		((CheckBox) v.findViewById(R.id.chk16_4)).setText("wgwó we¯‹zU");

		((CheckBox) v.findViewById(R.id.chk16_5)).setText("wPwb");

		((CheckBox) v.findViewById(R.id.chk17_1)).setText("¯^v` e„w× KviK");

		((CheckBox) v.findViewById(R.id.chk17_2)).setText("imyb");

		((CheckBox) v.findViewById(R.id.chk17_3)).setText("gmjv");
		((CheckBox) v.findViewById(R.id.chk17_4)).setText("jeb");

		((CheckBox) v.findViewById(R.id.chk18_1)).setText("wPswo");

		((CheckBox) v.findViewById(R.id.chk18_2)).setText("KvKov");

		((TextView) v.findViewById(R.id.textView2))
				.setText("hw` Lv`¨ ZvwjKvq bv _v‡K Zvn‡j wb‡P Lvev‡ii bvg wjLyb|");

		((TextView) v.findViewById(R.id.textView2)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk1_1)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk2_1)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk2_2)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk2_3)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk2_4)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk2_5)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk3_1)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk3_2)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk3_3)).setTypeface(font);

		((CheckBox) v.findViewById(R.id.chk4_1)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk4_2)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk5_1)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk5_2)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk5_3)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk5_4)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk5_5)).setTypeface(font);

		((CheckBox) v.findViewById(R.id.chk6_1)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk6_2)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk7_1)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk7_2)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk7_3)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk7_4)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk7_5)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk7_7)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk7_6)).setTypeface(font);

		((CheckBox) v.findViewById(R.id.chk8_1)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk8_2)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk8_3)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk8_4)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk8_5)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk8_6)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk9_1)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk9_2)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk9_3)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk10_1)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk11_1)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk12_1)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk12_2)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk12_3)).setTypeface(font);

		((CheckBox) v.findViewById(R.id.chk13_1)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk13_2)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk13_3)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk13_4)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk13_5)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk13_6)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk13_7)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk14_1)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk14_2)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk14_3)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk15_1)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk15_2)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk15_3)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk16_1)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk16_2)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk16_3)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk16_4)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk16_5)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk17_1)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk17_2)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk17_3)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk17_4)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk18_1)).setTypeface(font);
		((CheckBox) v.findViewById(R.id.chk18_2)).setTypeface(font);

	}

	private static void setviewfonttobangla(View view) {

		if (view instanceof CheckBox) {
			((CheckBox) view).setTypeface(font);
		}

		if (view instanceof TextView) {
			((TextView) view).setTypeface(font);
		}
	}

	private void updatemultiple() {

		String sql = "";

		sql = String
				.format("UPDATE tblMainQues SET c609_1_1='%s', c609_2_1='%s', c609_2_2='%s', c609_2_3='%s', c609_2_4='%s', c609_2_5='%s', c609_2_5_other='%s',"
						+ "c609_3_1='%s', c609_3_2='%s', c609_3_3='%s', c609_3_3_other='%s', c609_4_1='%s', c609_4_2='%s', c609_5_1='%s', c609_5_2='%s', c609_5_3='%s',"
						+ "c609_5_4='%s', c609_5_5='%s', c609_5_5_other='%s', c609_6_1='%s', c609_6_2='%s', c609_7_1='%s', c609_7_2='%s', c609_7_3='%s', c609_7_4='%s',"
						+ "c609_7_5='%s', c609_7_6='%s', c609_7_6_other='%s', c609_8_1='%s', c609_8_2='%s', c609_8_3='%s', c609_8_4='%s', c609_8_5='%s', c609_8_6='%s',"
						+ "c609_8_6_other='%s', c609_9_1='%s', c609_9_2='%s', c609_9_3='%s', c609_10_1='%s', c609_11_1='%s', c609_12_1='%s', c609_12_2='%s', c609_12_3='%s',"
						+ "c609_12_3_other='%s', c609_13_1='%s', c609_13_2='%s', c609_13_3='%s', c609_13_4='%s', c609_13_5='%s', c609_13_6='%s', c609_13_7='%s', c609_13_7_other='%s',"
						+ "c609_14_1='%s', c609_14_2='%s', c609_14_3='%s', c609_14_3_other='%s', c609_15_1='%s', c609_15_2='%s', c609_15_3='%s', c609_16_1='%s', c609_16_2='%s', c609_16_3='%s',"
						+ "c609_16_4='%s', c609_17_1='%s', c609_17_2='%s', c609_17_3='%s', c609_18_1='%s', c609_18_2='%s', c609_19_1='%s', c609_7_7='%s', "
						+ "c609_17_4='%s', c609_16_5='%s' where dataid = '%s'",

				chk1_1, chk2_1, chk2_2, chk2_3, chk2_4, chk2_5, et2_5_other,
						chk3_1, chk3_2, chk3_3, et3_3_other, chk4_1, chk4_2,
						chk5_1, chk5_2, chk5_3, chk5_4, chk5_5, et5_5_other,
						chk6_1, chk6_2, chk7_1, chk7_2, chk7_3, chk7_4, chk7_5,
						chk7_6, et7_6_other, chk8_1, chk8_2, chk8_3, chk8_4,
						chk8_5, chk8_6, et8_6_other, chk9_1, chk9_2, chk9_3,
						chk10_1, chk11_1, chk12_1, chk12_2, chk12_3,
						et12_3_other, chk13_1, chk13_2, chk13_3, chk13_4,
						chk13_5, chk13_6, chk13_7, et13_7_other, chk14_1,
						chk14_2, chk14_3, et14_3_other, chk15_1, chk15_2,
						chk15_3, chk16_1, chk16_2, chk16_3, chk16_4, chk17_1,
						chk17_2, chk17_3, chk18_1, chk18_2, et19_1, chk7_7,
						chk17_4, chk16_5, CommonStaticClass.dataId);

		if (dbHelper.executeDMLQuery(sql)) {
			CommonStaticClass.findOutNextSLNo(
					qName,
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQnext1());
			CommonStaticClass.nextQuestion(ParentActivity.this);

		} else if (CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQnext1()
				.equalsIgnoreCase("END")) {
			showUserFinishDialogFrmText();
		}

	}

	boolean datasaved = false;

	@Override
	public void onStart() {
		super.onStart(); // Always call the superclass method first

		checksession();

	}

	private void checksession() {
		if (CommonStaticClass.userSpecificId.length() == 0) {

			new AlertDialog.Builder(con)
					.setTitle("Session Expired")
					.setMessage(
							"You've been inactive for a long while. Please exit and re-login")
					.setPositiveButton("Ok",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {

									int pid = 0;
									ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
									List<ActivityManager.RunningAppProcessInfo> pids = am
											.getRunningAppProcesses();
									for (int i = 0; i < pids.size(); i++) {
										ActivityManager.RunningAppProcessInfo info = pids
												.get(i);
										String p = getApplicationContext()
												.getPackageName();
										if (info.processName
												.equalsIgnoreCase(p)) {
											pid = info.pid;
											android.os.Process.killProcess(pid);

										}
									}

									dialog.dismiss();

								}
							})

					.setCancelable(false).show();

		}

	}

	/*
	 * class DataIDSpinnerListener implements OnItemSelectedListener {
	 * 
	 * public void onItemSelected(AdapterView<?> parent, View arg1, int pos,
	 * long arg3) { // TODO Auto-generated method stub if (parent ==
	 * spinnerhospital) { if (parent.getItemAtPosition(pos).toString().length()
	 * > 0) { hospital = "5";// = String.valueOf(pos + 1);
	 * 
	 * } } else if (parent == spinnerward) { if
	 * (parent.getItemAtPosition(pos).toString().length() > 0) { ward =
	 * String.valueOf(pos);
	 * 
	 * } }
	 * 
	 * }
	 * 
	 * public void onNothingSelected(AdapterView<?> arg0) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 * 
	 * }
	 */

	private void loadGuiFrmHHID(ViewGroup v) {
		// TODO Auto-generated method stub

		qqq = (TextView) v.findViewById(R.id.qqq);

		if (CommonStaticClass.langBng) {
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdescbng());
			((TextView) v.findViewById(R.id.q11))
					.setText(CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdescbng());
		} else {
			qqq.setTypeface(null);
			((TextView) v.findViewById(R.id.q11)).setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
			((TextView) v.findViewById(R.id.q11))
					.setText(CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		}

		txtschoolID = (EditText) v.findViewById(R.id.txtschoolID);
		txtschoolID.requestFocus();
		// txtID = (EditText)v.findViewById(R.id.txtID);

		txtschoolIDRe = (EditText) v.findViewById(R.id.txtschoolIDRe);
		// txtIDRe = (EditText)v.findViewById(R.id.txtIDRe);

		confButton = (Button) v.findViewById(R.id.confButton);
		confButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				// updateTableData();

				schoolid = txtschoolID.getText().toString();
				// id = txtID.getText().toString();

				schoolidre = txtschoolIDRe.getText().toString();
				// idre = txtIDRe.getText().toString();

				// ValidateInput();

				if ((schoolid.length() < 4 || !schoolid
						.equalsIgnoreCase(schoolidre))) {
					CommonStaticClass.showFinalAlert(con,
							"Data ID is inconsistent");
					return;
				}

				/*
				 * CommonStaticClass.ClusterId = schoolid.subSequence(0, 3)
				 * .toString();
				 */

				/*
				 * CommonStaticClass.ClusterId = schoolid.subSequence(0, 3)
				 * .toString(); CommonStaticClass.MotherID =
				 * schoolid.subSequence(3, 5) .toString(); if
				 * (Integer.parseInt(CommonStaticClass.MotherID) > 8) {
				 * CommonStaticClass.showMyAlert(con, "Invalid Mother ID",
				 * "Mother ID can not be greater than 8."); return; }
				 * 
				 * if (CommonStaticClass.ClusterId.length() < 3) {
				 * CommonStaticClass.showMyAlert(con, "Invalid Cluster ID",
				 * "Invalid cluster id."); return; } if
				 * (IsValidClusterID(CommonStaticClass.ClusterId)) {
				 * 
				 * } else { CommonStaticClass.showMyAlert(con,
				 * "Invalid Cluster ID", "Invalid cluster id."); return; }
				 */
				CommonStaticClass.dataId = schoolid;

				if (CommonStaticClass.dataId.length() > 0) {
					progressDialog = ProgressDialog.show(con, "Wait",
							"Please wait while processing next question");

					new Thread() {

						public void run() {
							try {
								Looper.prepare();
								if (FileRead()) {

									if (CommonStaticClass.userSpecificId
											.length() == 0
											|| CommonStaticClass.AssetID
													.length() == 0) {

										return;
									}

									updateTableDataFrmHHID();
									// preserveState();
									Message msg = new Message();
									msg.what = UPDATEDONE;
									handlerFrmHHID.sendMessage(msg);
								} else {
									progressDialog.dismiss();
									CommonStaticClass.showFinalAlert(con,
											"Ensure your Asset ID");

								}
							} catch (Exception lg) {
								progressDialog.dismiss();
								CommonStaticClass.showFinalAlert(con,
										"Ensure your Asset ID");

							} finally {

							}
							Looper.loop();
						}

					}.start();
				} else {
					CommonStaticClass
							.showFinalAlert(con,
									"Please confirm data id is generated by clicking GENERATE");
				}
			}

		});
	}

	private String GetPatientID() {
		if (FileRead()) {

			String s = String.format(
					"SELECT * from tblSetup WHERE AssetID = '%s'",
					CommonStaticClass.AssetID);

			Cursor mCursor = null;

			try {

				mCursor = dbHelper.getQueryCursor(s);

				if (mCursor.getCount() > 0) {

					if (mCursor.moveToFirst()) {

						do {

							CommonStaticClass.HosCode = mCursor
									.getString(mCursor
											.getColumnIndex("HosCode"));
							CommonStaticClass.LastPatientID = mCursor
									.getString(mCursor
											.getColumnIndex("LastPatientID"));

							CommonStaticClass.LastPatientID = String
									.valueOf(Integer
											.parseInt(CommonStaticClass.LastPatientID) + 1);

							CommonStaticClass.LastPatientID = String
									.format("%06d",
											Integer.parseInt(CommonStaticClass.LastPatientID));

						} while (mCursor.moveToNext());

					} else
						return null;

				} else
					return null;

			} catch (Exception e) {

			}

		}
		return null;
	}

	private boolean IsValidDataIDUserInput() {

		if (etpid.length() == 0) {
			return false;
		}
		if (etyearmonth.getText().toString().length() == 0) {
			return false;
		}

		return true;
	}

	private void updateTableDataFrmHHID() {
		// TODO Auto-generated method stub
		Cursor cursor = null;
		try {
			String sql = "Select * from  "
					+ CommonStaticClass
							.GetTableName(CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQvar())
					+ " Where dataid='" + CommonStaticClass.dataId
					+ "' and AssetID = '" + CommonStaticClass.AssetID + "'";
			String sqlSc, sqlMc;

			cursor = dbHelper.getQueryCursor(sql);

			if (cursor.getCount() != 0) {
				// CommonStaticClass.showMyAlert(con, "Id exist",
				// "This id is already exist!");
				CommonStaticClass.mode = CommonStaticClass.EDITMODE;
				CommonStaticClass.findOutNextSLNo(
						CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getQvar(),
						CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getQnext1());
				CommonStaticClass.nextQuestion(ParentActivity.this);

			} else {

				/*
				 * String entryDate = "dd-mmm-yyyy"; Date d = new
				 * Date(System.currentTimeMillis()); entryDate = "dd-mmm-yyyy";
				 * entryDate = d.toLocaleString();
				 */

				sql = String
						.format("Insert into %s (dataid,EntryBy,EntryDate,AssetId,VersionNo) VALUES('%s','%s','%s','%s','%s')",
								CommonStaticClass
										.GetTableName(CommonStaticClass.questionMap
												.get(CommonStaticClass.currentSLNo)
												.getQvar()),
								CommonStaticClass.dataId,
								CommonStaticClass.userSpecificId,
								CommonStaticClass.GetDate(),
								CommonStaticClass.AssetID,
								CommonStaticClass.VersionNo);

				/*
				 * sqlMc =
				 * "Insert into tblMainQuesMc (dataid,EntryBy,EntryDate) values('"
				 * + CommonStaticClass.dataId + "','" +
				 * CommonStaticClass.userSpecificId + "','" + entryDate + "')";
				 * 
				 * sqlSc =
				 * "Insert into tblMainQuesSc (dataid,EntryBy,EntryDate) values('"
				 * + CommonStaticClass.dataId + "','" +
				 * CommonStaticClass.userSpecificId + "','" + entryDate + "')";
				 */

				if (dbHelper.executeDMLQuery(sql)
				/*
				 * && dbHelper.executeDMLQuery(sqlMc) &&
				 * dbHelper.executeDMLQuery(sqlSc)
				 */) {

					CommonStaticClass.findOutNextSLNo(
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQvar(),
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQnext1());
					CommonStaticClass.nextQuestion(ParentActivity.this);
					CommonStaticClass.addCycleStarted = true;

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cursor != null)
				cursor.close();
		}
	}

	protected boolean doesExist(String dataid2) {
		String id = "";
		String sql = "Select * from tblMainQues where dataid='" + dataid2 + "'";
		Cursor mCursor = null;
		try {
			mCursor = dbHelper.getQueryCursor(sql);
			if (mCursor.moveToFirst()) {
				do {
					id = mCursor.getString(mCursor.getColumnIndex("dataid"));
					if (id != null && id.length() > 0) {
						return true;
					}
				} while (mCursor.moveToNext());
			}
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("cursor", "is null");
		} finally {
			if (mCursor != null)
				mCursor.close();
		}
		return false;
	}

	protected String getRandomId(String sampleid) {
		String randomID = "";
		String sql = "Select randomid from tblSamplesInfo where sampleid='"
				+ sampleid + "'";
		Cursor mCursor = null;
		try {
			mCursor = dbHelper.getQueryCursor(sql);
			if (mCursor.moveToFirst()) {
				do {
					randomID = mCursor.getString(mCursor
							.getColumnIndex("randomid"));
				} while (mCursor.moveToNext());
			}
		} catch (Exception e) { // TODO: handle exception
			Log.e("cursor", "is null");
		} finally {
			if (mCursor != null)
				mCursor.close();
		}
		return randomID;
	}

	private boolean IsValidClusterID(String ClusterID) {
		String id = "";
		String sql = "Select * from tblSamplesinfo where clusterid='"
				+ Integer.parseInt(ClusterID) + "'";
		Cursor mCursor = null;
		try {
			mCursor = dbHelper.getQueryCursor(sql);
			if (mCursor.moveToFirst()) {
				do {
					id = mCursor.getString(mCursor.getColumnIndex("clusterid"));
					if (id != null && id.length() > 0) {
						return true;
					}
				} while (mCursor.moveToNext());
			}
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("cursor", "is null");
		} finally {
			if (mCursor != null)
				mCursor.close();
		}
		return false;
	}

	protected void checkThisIdIsAlreadyExistFrmHHID(String dataId) {
		// TODO Auto-generated method stub
		String sql = "Select dataid from "
				+ CommonStaticClass.GetTableName(CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar())
				+ " where dataid = '" + CommonStaticClass.dataId + "'";
		Cursor mCursor = null;
		try {
			mCursor = dbHelper.getQueryCursor(sql);
			if (mCursor.getCount() > 0) {
				CommonStaticClass.showMyAlert(con, "Id exist",
						"This id is already exist please GENERATE another");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (mCursor != null)
				mCursor.close();
		}
	}

	private Handler handlerFrmHHID = new Handler() {

		public void handleMessage(Message msg) {
			switch (msg.what) {
			case UPDATEDONE:
				progressDialog.dismiss();
				break;
			}

		}
	};

	// FrmMessage part
	private void loadGuiFrmMessage(final ViewGroup v) {
		// TODO Auto-generated method stub
		qqq = (TextView) v.findViewById(R.id.qqq);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}

			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? Html
					.fromHtml(CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdescbng())
					: Html.fromHtml(CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng()));
			/*
			 * qqq.setText(CommonStaticClass.questionMap
			 * .get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ?
			 * CommonStaticClass.questionMap
			 * .get(CommonStaticClass.currentSLNo).getQdescbng() :
			 * CommonStaticClass.questionMap.get(
			 * CommonStaticClass.currentSLNo).getQdesceng());
			 */

		} else {
			qqq.setTypeface(null);
			qqq.setText(Html.fromHtml(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng()));
			/*
			 * qqq.setText(CommonStaticClass.questionMap.get(
			 * CommonStaticClass.currentSLNo).getQdesceng());
			 */

			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQvar()
					.equalsIgnoreCase("q9day1")) {

				String val = CommonStaticClass.getSkip("sampleid", "tblDay1",
						dbHelper);

				qqq.setText(qqq.getText() + val);
			}

			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQvar()
					.equalsIgnoreCase("q10day1")) {

				String val = CommonStaticClass.getSkip("randomid", "tblDay1",
						dbHelper);

				qqq.setText(qqq.getText() + val);
			}

			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQvar()
					.equalsIgnoreCase("q9day2")) {

				String val = CommonStaticClass.getSkip("sampleid", "tblDay2",
						dbHelper);

				qqq.setText(qqq.getText() + val);
			}

			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQvar()
					.equalsIgnoreCase("q10day2")) {

				String val = CommonStaticClass.getSkip("randomid", "tblDay2",
						dbHelper);

				qqq.setText(qqq.getText() + val);
			}

		}

		prevButton = (Button) v.findViewById(R.id.prevButton);
		prevButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		saveNxtButton = (Button) v.findViewById(R.id.saveNxtButton);

		saveNxtButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateTableDataFrmMessage();

			}

		});
		clButton = (Button) v.findViewById(R.id.clButton);
		clButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) v);
			}

		});
	}

	private void updateTableDataFrmMessage() {
		// TODO Auto-generated method stub
		CommonStaticClass.findOutNextSLNo(
				CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar(),
				CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQnext1());
		CommonStaticClass.nextQuestion(ParentActivity.this);
	}

	// FrmMultipleCheckCombo part
	private void loadGuiFrmMultipleCheckCombo(final ViewGroup v) {
		// TODO Auto-generated method stub
		// checkDbHasPreviousDataForThisHouseHold();
		if (aaa != null && aaa.size() > 0) {
			aaa.clear();
		}
		optionList1 = new ArrayList<String>();
		optionCodeList1 = new ArrayList<Integer>();
		qqq = (TextView) v.findViewById(R.id.qqq);
		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		checkBoxHolder = (LinearLayout) v.findViewById(R.id.checkBoxHolder);
		checkBoxHolder.removeAllViews();

		if (qName.equalsIgnoreCase("DS23"))
			op = CommonStaticClass.findOptionsForScvb(
					dbHelper,
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar());
		else
			op = CommonStaticClass.findOptionsForThisQuestion(
					dbHelper,
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar());

		LinearLayout.LayoutParams lnlParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		LinearLayout.LayoutParams layoutParamForcheck = new LinearLayout.LayoutParams(
				((dm.widthPixels - 65) / 3) * 2,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		LinearLayout.LayoutParams layoutParamForSpin = new LinearLayout.LayoutParams(
				((dm.widthPixels + 65) / 3),
				LinearLayout.LayoutParams.WRAP_CONTENT);

		optionList1.add("");
		optionCodeList1.add(-1);
		for (int i = 0; i < op.codeList.size(); i++) {

			if (op.qidList.get(i).contains("Options")) {
				Log.e("op.qidList.get(i)", op.qidList.get(i));
				if (CommonStaticClass.langBng) {
					optionList1.add(op.capBngList.get(i));
				} else {
					optionList1.add(op.capEngList.get(i));
				}
				optionCodeList1.add(op.codeList.get(i));
				continue;
			}
			aaa.add(-1);
		}
		// op.codeList.toArray().
		for (int i = 0; i < op.codeList.size(); i++) {

			Log.e("op.qidList.get(i)", op.qidList.get(i));
			if (op.qidList.get(i).contains("Options")) {
				continue;
			}
			LinearLayout ln = new LinearLayout(this);
			ln.setOrientation(LinearLayout.HORIZONTAL);
			final CheckBox checkButton = new CheckBox(this);

			if (qName.equalsIgnoreCase("DS23"))
				if (CommonStaticClass.langBng) {
					checkButton.setTypeface(font);
					checkButton
							.setText(op.capBngList.get(i).length() > 0 ? op.capBngList
									.get(i) : op.capEngList.get(i));
				} else {
					checkButton.setTypeface(null);
					checkButton.setText(op.capEngList.get(i));
				}
			checkButton.setId(i);
			final Spinner spinner = new Spinner(this);
			layoutParamForSpin.weight = 1;
			ln.addView(spinner, 0, layoutParamForSpin);
			spinner.setVisibility(View.INVISIBLE);
			ln.addView(checkButton, 0, layoutParamForcheck);

			ArrayAdapter adapter1;

			if (CommonStaticClass.langBng) {
				adapter1 = new SpinAdapter(this, optionList1, true);
			} else {
				adapter1 = new ArrayAdapter(this,
						android.R.layout.simple_spinner_item, optionList1);
			}

			adapter1.setDropDownViewResource(CommonStaticClass.langBng ? R.layout.checkedspintextview
					: android.R.layout.simple_spinner_dropdown_item);

			spinner.setAdapter(adapter1);
			spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

				public void onItemSelected(AdapterView<?> parent, View view,
						int pos, long id) {
					// TODO Auto-generated method stub

					aaa.set(checkButton.getId(), optionCodeList1.get(pos));
				}

				public void onNothingSelected(AdapterView<?> arg0) {
				}

			});
			checkBoxHolder.addView(ln, 0, lnlParams);

			checkButton
					.setOnCheckedChangeListener(new OnCheckedChangeListener() {

						public void onCheckedChanged(CompoundButton buttonView,
								boolean isChecked) {
							// TODO Auto-generated method stub
							if (isChecked) {
								Log.e("id :", "" + checkButton.getId());
								spinner.setSelection(0);
								spinner.setVisibility(View.VISIBLE);
							} else {
								aaa.set(checkButton.getId(), -1);// added by me
								spinner.setVisibility(View.INVISIBLE);
							}
						}
					});
			selectCheckAndComboFrmMultipleCheckCombo(op.qidList.get(i),
					checkButton, spinner);

		}

		prevButton = (Button) v.findViewById(R.id.prevButton);
		prevButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vb) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});

		saveNxtButton = (Button) v.findViewById(R.id.saveNxtButton);

		saveNxtButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				updateTableDataFrmMultipleCheckCombo(v);

			}

		});
		clButton = (Button) v.findViewById(R.id.clButton);
		clButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) v);
			}

		});
		notesButton = (Button) v.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});
	}

	private void loadGuiFrmMultipleCheckNumeric(final ViewGroup v) {
		// TODO Auto-generated method stub
		// checkDbHasPreviousDataForThisHouseHold();
		if (listvalues != null && listvalues.size() > 0) {
			listvalues.clear();
		}
		optionList1 = new ArrayList<String>();
		optionCodeList1 = new ArrayList<Integer>();
		qqq = (TextView) v.findViewById(R.id.qqq);
		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		checkBoxHolder = (LinearLayout) v.findViewById(R.id.checkBoxHolder);
		checkBoxHolder.removeAllViews();
		int maxLength = 0;

		if (qName.equalsIgnoreCase("AgeYr")) {
			op = CommonStaticClass.findOptionsForScvb(
					dbHelper,
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar());
			maxLength = 2;
		} else if (qName.equalsIgnoreCase("WT")) {
			op = CommonStaticClass.findOptionsForScvb(
					dbHelper,
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar());
			maxLength = 6;
		} else if (qName.equalsIgnoreCase("HH")) {
			op = CommonStaticClass.findOptionsForScvb(
					dbHelper,
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar());
			maxLength = 11;
		} else if (qName.equalsIgnoreCase("RespondentName")) {
			op = CommonStaticClass.findOptionsForThisQuestion(
					dbHelper,
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar());
			maxLength = 200;
		} else if (qName.equalsIgnoreCase("g5116")) {
			op = CommonStaticClass.findOptionsForThisQuestion(
					dbHelper,
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar());
			maxLength = 6;
		}

		else if (qName.equalsIgnoreCase("DS36")) {
			op = CommonStaticClass.findOptionsForScvb(
					dbHelper,
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar());
			maxLength = 5;
		}

		else {
			op = CommonStaticClass.findOptionsForThisQuestion(
					dbHelper,
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar());
			maxLength = 6;
		}

		LinearLayout.LayoutParams lnlParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		LinearLayout.LayoutParams layoutParamForcheck = new LinearLayout.LayoutParams(
				((dm.widthPixels - 65) / 3) * 2, (dm.widthPixels - 65) / 3);
		LinearLayout.LayoutParams layoutParamForSpin = new LinearLayout.LayoutParams(
				((dm.widthPixels + 65) / 3),
				LinearLayout.LayoutParams.WRAP_CONTENT);

		for (int i = 0; i < op.codeList.size(); i++) {

			listvalues.add("");
		}

		for (int i = 0; i < op.codeList.size(); i++) {

			Log.e("op.qidList.get(i)", op.qidList.get(i));

			LinearLayout ln = new LinearLayout(this);
			ln.setOrientation(LinearLayout.HORIZONTAL);

			ln.setPadding(0, 0, 0, 40);

			final CheckBox checkButton = new CheckBox(this);
			if (CommonStaticClass.langBng) {
				checkButton.setTypeface(font);
				checkButton
						.setText(op.capBngList.get(i).length() > 0 ? op.capBngList
								.get(i) : op.capEngList.get(i));
			} else {
				checkButton.setTypeface(null);
				checkButton.setText(op.capEngList.get(i));
			}
			checkButton.setId(i);

			final EditText et = new EditText(this);

			if (qName.equalsIgnoreCase("RespondentName"))
				et.setInputType(InputType.TYPE_CLASS_TEXT);
			else if (qName.equalsIgnoreCase("WT")
					|| qName.equalsIgnoreCase("DS36"))
				et.setInputType(InputType.TYPE_CLASS_NUMBER
						| InputType.TYPE_NUMBER_FLAG_DECIMAL);

			et.setFilters(new InputFilter[] { new InputFilter.LengthFilter(
					maxLength) });

			layoutParamForSpin.weight = 1;
			ln.addView(et, 0, layoutParamForSpin);
			et.setVisibility(View.INVISIBLE);
			ln.addView(checkButton, 0, layoutParamForcheck);

			et.addTextChangedListener(new TextWatcher() {

				public void onTextChanged(CharSequence s, int start,
						int before, int count) {
					// TODO Auto-generated method stub

				}

				public void beforeTextChanged(CharSequence s, int start,
						int count, int after) {
					// TODO Auto-generated method stub

				}

				public void afterTextChanged(Editable s) {

					if (checkButton.isChecked()) {
						if (s.toString().length() > 0) {

							listvalues.set(checkButton.getId(), s.toString());

						}
					}
				}
			});

			checkBoxHolder.addView(ln, 0, lnlParams);

			checkButton
					.setOnCheckedChangeListener(new OnCheckedChangeListener() {

						public void onCheckedChanged(CompoundButton buttonView,
								boolean isChecked) {
							// TODO Auto-generated method stub
							if (isChecked) {
								Log.e("id :", "" + checkButton.getId());
								listvalues.set(checkButton.getId(), "");
								/*
								 * if (qName.equalsIgnoreCase("q37c1") ||
								 * qName.equalsIgnoreCase("q37c2")
								 * ||qName.equalsIgnoreCase("q37c3") ||
								 * qName.equalsIgnoreCase("q37c4") ||
								 * qName.equalsIgnoreCase("q37c5") ||
								 * qName.equalsIgnoreCase("q37c6") ||
								 * qName.equalsIgnoreCase("q37c7")) {
								 * 
								 * if (checkButton.getId()==6) {
								 * 
								 * 
								 * if (checkButton.getText().toString()
								 * .toLowerCase().contains("others") ||
								 * checkButton .getText().toString().trim(
								 * ).toLowerCase() .contains("Ab¨vb¨: wjLyb")) {
								 * 
								 * 
								 * //listvalues.set(checkButton.getId(), 1);
								 * et.setVisibility(View.INVISIBLE); return; } }
								 * else { //listvalues.set(checkButton.getId(),
								 * 1); et.setVisibility(View.VISIBLE); }
								 */
								et.setVisibility(View.VISIBLE);

							} else {
								listvalues.set(checkButton.getId(), "");
								et.setVisibility(View.INVISIBLE);
							}
						}
					});
			selectCheckAndComboFrmMultipleCheckNumeric(op.qidList.get(i),
					checkButton, et);

		}

		prevButton = (Button) v.findViewById(R.id.prevButton);
		prevButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vb) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});

		saveNxtButton = (Button) v.findViewById(R.id.saveNxtButton);

		saveNxtButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				updateTableDataFrmMultipleCheckNumeric(v);

			}

		});
		clButton = (Button) v.findViewById(R.id.clButton);
		clButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) v);
			}

		});
		notesButton = (Button) v.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});
	}

	private void selectCheckAndComboFrmMultipleCheckCombo(String inColumn,
			CheckBox checkButton, Spinner spinner) {
		// TODO Auto-generated method stub
		String sql = "";
		if (!CommonStaticClass.isMember)
			sql = "Select "
					+ inColumn
					+ " from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId + "'";
		else
			sql = "Select "
					+ inColumn
					+ " from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId
					+ "' and memberid=" + CommonStaticClass.memberID;

		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				doFill1FrmMultipleCheckCombo(mCursor1, inColumn, checkButton,
						spinner);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}

	}

	private void selectCheckAndComboFrmMultipleCheckNumeric(String inColumn,
			CheckBox checkButton, EditText et) {
		// TODO Auto-generated method stub
		String sql = "";
		if (!CommonStaticClass.isMember)
			sql = "Select "
					+ inColumn
					+ " from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId + "'";
		else if (qName.equalsIgnoreCase("g5116")
				|| qName.equalsIgnoreCase("g51211")
				|| qName.equalsIgnoreCase("g52314")
				|| qName.equalsIgnoreCase("g52316")
				|| qName.equalsIgnoreCase("g52321")) {
			sql = "Select "
					+ inColumn
					+ " from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId
					+ "' and cropfishcode=" + CommonStaticClass.cropfishcode;
		} else
			sql = "Select "
					+ inColumn
					+ " from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId
					+ "' and memberid=" + CommonStaticClass.memberID;

		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				doFillFrmMultipleCheckNumeric(mCursor1, inColumn, checkButton,
						et);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}

	}

	private boolean doFill1FrmMultipleCheckCombo(Cursor mCursor1,
			String inColumn, CheckBox checkButton, Spinner spinner) {
		boolean dataOk = false;
		if (mCursor1.moveToFirst()) {
			do {
				if (mCursor1.getColumnIndexOrThrow(inColumn) != -1) {
					Log.e("column", "exist column:" + inColumn);
					try {
						checkButton.setChecked(true);
						String a = mCursor1.getString(mCursor1
								.getColumnIndex(inColumn));
						Log.e("a", a + "   lklklk");

						if (optionCodeList1.contains(Integer.parseInt(a))
								&& Integer.parseInt(a) != -1) {

							int pos = optionCodeList1.indexOf(Integer
									.parseInt(a));

							checkButton.setChecked(true);
							spinner.setSelection(pos);
							dataOk = true;

						}

					} catch (Exception e) {
						// TODO: handle exception
					}

				}

			} while (mCursor1.moveToNext());
		}

		return dataOk;
	}

	private boolean doFillFrmMultipleCheckNumeric(Cursor mCursor1,
			String inColumn, CheckBox checkButton, EditText et) {
		boolean dataOk = false;
		if (mCursor1.moveToFirst()) {
			do {
				if (mCursor1.getColumnIndexOrThrow(inColumn) != -1) {

					// checkButton.setEnabled(false);
					checkButton.setTextColor(Color.BLACK);
					Log.e("column", "exist column:" + inColumn);
					try {
						String a = mCursor1.getString(mCursor1
								.getColumnIndex(inColumn));
						Log.e("a", a + "   lklklk");

						if (a.length() > 0 && !a.equalsIgnoreCase("")) {
							checkButton.setChecked(true);
							et.setText(a);
							dataOk = true;
						}

					} catch (Exception e) {

					}
				}

			} while (mCursor1.moveToNext());
		}

		return dataOk;
	}

	private String getSkip(String column, String tablename) {

		String GtSkip = "";
		String sql = "";

		if (!CommonStaticClass.isMember)

			sql = "Select " + column + " from " + tablename + " where dataid='"
					+ CommonStaticClass.dataId + "'";

		// String data ="";

		Cursor mCursor = null;

		try {

			mCursor = dbHelper.getQueryCursor(sql);

			if (mCursor.getCount() > 0) {

				if (mCursor.moveToFirst()) {

					do {

						GtSkip = mCursor.getString(mCursor
								.getColumnIndex(column));

					} while (mCursor.moveToNext());

				}

			}

		} catch (Exception e) {

			// TODO: handle exception

		}

		return GtSkip;

	}

	private void updateTableDataFrmMultipleCheckCombo(ViewGroup v) {
		// TODO Auto-generated method stub
		spinnerOK = true;
		CheckBoxNotSeletedFrmMultipleCheckCombo();
		if (spinnerOK) {
			spinnerVisibleButNotSeletedFrmMultipleCheckCombo((ViewGroup) v);
		}
		String sql = "";
		// spinnerOK = true;
		if (spinnerOK) {

			sql = "UPDATE "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " SET ";
			for (int i = 0; i < op.codeList.size(); i++) {
				if (op.qidList.get(i).contains("Options")) {
					continue;
				}
				if (op.qidList.get(i + 1).contains("Options")) {
					sql += op.qidList.get(i) + " = '" + aaa.get(i) + "'";
					break;
				}
				sql += op.qidList.get(i) + " = '" + aaa.get(i) + "',";
			}
			if (!CommonStaticClass.isMember)
				sql += "where dataid='" + CommonStaticClass.dataId + "'";
			else
				// added later 7 aug 2012
				sql += "where dataid='" + CommonStaticClass.dataId
						+ "' and memberid=" + CommonStaticClass.memberID;

			if (checkIfSingleOptionIsCheckedFrmMultipleCheckCombo()) {

				if (dbHelper.executeDMLQuery(sql)) {
					// if (!gotoskip()) {

					CommonStaticClass.findOutNextSLNo(
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQvar(),
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQnext1());
					CommonStaticClass.nextQuestion(ParentActivity.this);
					// }
				}
			}

			/*
			 * else { if (CommonStaticClass.questionMap
			 * .get(CommonStaticClass.currentSLNo).getQvar()
			 * .equalsIgnoreCase("p3_1")) { if (dbHelper.executeDMLQuery(sql)) {
			 * showUserFinishDialogFrmMultipleCheckCombo();
			 * 
			 * } else {
			 * 
			 * CommonStaticClass } .showMyAlert(con, "Please check one!!!",
			 * "You didn't checked any answer please select one to preceed"); }
			 * } }
			 */
		} else {
			CommonStaticClass.showMyAlert(con, "Please select item!!!",
					"Please select an item from combo.");
		}

	}

	private void updateTableDataFrmMultipleCheckNumeric(ViewGroup v) {
		// TODO Auto-generated method stub

		/*
		 * spinnerOK = true; CheckBoxNotSeletedFrmMultipleCheckCombo(); if
		 * (spinnerOK) {
		 * spinnerVisibleButNotSeletedFrmMultipleCheckCombo((ViewGroup) v); }
		 */

		String sql = "";
		// spinnerOK = true;
		// if (spinnerOK) {

		sql = "UPDATE "
				+ CommonStaticClass.questionMap.get(
						CommonStaticClass.currentSLNo).getTablename() + " SET ";
		for (int i = 0; i < op.codeList.size(); i++) {
			/*
			 * if (op.qidList.get(i).contains("Options")) { continue; } if
			 * (op.qidList.get(i + 1).contains("Options")) { sql +=
			 * op.qidList.get(i) + " = '" + aaa.get(i) + "'"; break; }
			 */
			sql += op.qidList.get(i) + " = '" + listvalues.get(i) + "',";
		}
		sql = (String) sql.subSequence(0, sql.length() - 1);

		if (!CommonStaticClass.isMember)
			sql += " where dataid='" + CommonStaticClass.dataId + "'";
		else if (qName.equalsIgnoreCase("g5116")
				|| qName.equalsIgnoreCase("g51211")
				|| qName.equalsIgnoreCase("g52314")
				|| qName.equalsIgnoreCase("g52316")
				|| qName.equalsIgnoreCase("g52321"))
			sql += " where dataid='" + CommonStaticClass.dataId
					+ "' and cropfishcode=" + CommonStaticClass.cropfishcode;
		else
			// added later 7 aug 2012
			sql += " where dataid='" + CommonStaticClass.dataId
					+ "' and memberid=" + CommonStaticClass.memberID;

		if (checkIfSingleOptionIsCheckedFrmMultipleCheckNumeric()) {

			if (dbHelper.executeDMLQuery(sql)) {

				// Newly Added
				CommonStaticClass.findOutNextSLNo(
						CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getQvar(),
						CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getQnext1());
				CommonStaticClass.nextQuestion(ParentActivity.this);
			}

		} else
			CommonStaticClass
					.showMyAlert(con, "Please check one!!!",
							"You didn't checked any answer please select one to preceed");

	}

	private void showUserFinishDialogFrmMultipleCheckCombo() {
		// get prompts.xml view
		LayoutInflater li = LayoutInflater.from(con);
		LinearLayout promptsView = (LinearLayout) li.inflate(R.layout.prompts,
				null);

		promptsView.removeView((EditText) promptsView
				.findViewById(R.id.editTextDialogUserInput));

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(con);

		// set prompts.xml to alertdialog builder
		alertDialogBuilder.setView(promptsView);

		final TextView textInfo = (TextView) promptsView
				.findViewById(R.id.textView1);
		textInfo.setText("Do u want to proceed without giving input?");

		// set dialog message
		alertDialogBuilder
				.setCancelable(false)
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {

								CommonStaticClass.findOutNextSLNo(
										CommonStaticClass.questionMap.get(
												CommonStaticClass.currentSLNo)
												.getQvar(),
										CommonStaticClass.questionMap.get(
												CommonStaticClass.currentSLNo)
												.getQnext1());
								CommonStaticClass
										.nextQuestion(ParentActivity.this);

							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();
	}

	private void CheckBoxNotSeletedFrmMultipleCheckCombo() {
		if (qName.equalsIgnoreCase("q608") || qName.equalsIgnoreCase("q612")
				|| qName.equalsIgnoreCase("q611")) {
			for (int i = 0; i < aaa.size(); i++) {
				if (aaa.get(i) != -1) {
					spinnerOK = true;
					return;
				} else {

					spinnerOK = false;

					if (qName.equalsIgnoreCase("q61")) {
						spinnerOK = true;
					}
				}
			}
		} else if (aaa.contains(-1)) {
			spinnerOK = false;

		}
	}

	private void spinnerVisibleButNotSeletedFrmMultipleCheckCombo(
			ViewGroup viewGroup) {
		int nrOfChildren = viewGroup.getChildCount();
		for (int i = 0; i < nrOfChildren; i++) {
			View view = viewGroup.getChildAt(i);

			if (view instanceof Spinner
					&& (view.getVisibility() == View.VISIBLE)) {
				if (((Spinner) view).getSelectedItemPosition() == 0) {
					spinnerOK = false;
				}
			}
			if (view instanceof ViewGroup) {
				spinnerVisibleButNotSeletedFrmMultipleCheckCombo((ViewGroup) view);
			}
		}
	}

	private boolean checkIfSingleOptionIsCheckedFrmMultipleCheckCombo() {
		for (int i = 0; i < aaa.size(); i++) {
			if (!(aaa.get(i) == -1)) {
				return true;
			}

		}
		return false;
	}

	private boolean checkIfSingleOptionIsCheckedFrmMultipleCheckNumeric() {
		for (int i = 0; i < listvalues.size(); i++) {
			if (!(listvalues.get(i) == "-1")) {
				return true;
			}

		}
		return false;
	}

	// FrmMultipleChoice part
	private void loadGuiFrmMultipleChoice(final ViewGroup v) {
		// TODO Auto-generated method stub
		if (aaa != null && aaa.size() > 0) {
			aaa.clear();
		}
		qqq = (TextView) v.findViewById(R.id.qqq);
		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				font = Typeface.createFromAsset(con.getAssets(),
						"Siyam Rupali ANSI.ttf");

				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		checkBoxHolder = (LinearLayout) v.findViewById(R.id.checkBoxHolder);
		checkBoxHolder.removeAllViews();

		if (qName.equalsIgnoreCase("q17hmd1")
				|| qName.equalsIgnoreCase("q18md1")
				|| qName.equalsIgnoreCase("q17hmd2")
				|| qName.equalsIgnoreCase("q18md2")) {
			/*
			 * op = CommonStaticClass.findOptionsForMedicineList( dbHelper,
			 * CommonStaticClass.questionMap.get(
			 * CommonStaticClass.currentSLNo).getQvar());
			 */
		} else {
			op = CommonStaticClass.findOptionsForThisQuestion(
					dbHelper,
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar());
		}

		Collections.reverse(op.capBngList);
		Collections.reverse(op.capEngList);
		Collections.reverse(op.codeList);
		Collections.reverse(op.qidList);
		Collections.reverse(op.qnList);

		LinearLayout.LayoutParams lnlParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		LinearLayout.LayoutParams layoutParamForcheck = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);

		for (int i = 0; i < op.codeList.size(); i++) {
			aaa.add(-1);
		}

		LinearLayout.LayoutParams layoutParamForTextBox = new LinearLayout.LayoutParams(
				(dm.widthPixels / 3), LinearLayout.LayoutParams.WRAP_CONTENT);

		for (int i = 0; i < op.codeList.size(); i++) {
			final LinearLayout ln = new LinearLayout(this);
			ln.setOrientation(LinearLayout.HORIZONTAL);
			final CheckBox checkButton = new CheckBox(this);
			if (CommonStaticClass.langBng) {
				checkButton.setTypeface(font);
				checkButton
						.setText(op.capBngList.get(i).length() > 0 ? op.capBngList
								.get(i) : op.capEngList.get(i));
			} else {
				checkButton.setTypeface(null);
				checkButton.setText(op.capEngList.get(i));
			}

			checkButton.setId(op.codeList.get(i));

			if (op.qnList.get(i).length() > 1) {
				ln.setWeightSum((float) 2.0);
				final EditText edbox = new EditText(this);
				edbox.setId(i);
				edList.put(i, edbox);
				layoutParamForcheck.weight = 1;
				layoutParamForTextBox.weight = 1;

				ln.addView(edbox, 0, layoutParamForTextBox);
				edbox.setVisibility(View.INVISIBLE);
				/*
				 * if (CommonStaticClass.mode
				 * .equalsIgnoreCase(CommonStaticClass.EDITMODE) ||
				 * CommonStaticClass.mode
				 * .equalsIgnoreCase(CommonStaticClass.ADDMODE) ||
				 * CommonStaticClass.mode.equalsIgnoreCase("")) {
				 */
				// checkEdboxHasDataFrmMultipleChoice(edbox, op.qnList.get(i));
				// }

				/*
				 * if (CommonStaticClass.mode
				 * .equalsIgnoreCase(CommonStaticClass.EDITMODE)) {
				 */
				checkEdboxHasDataFrmMultipleChoice(edbox, op.qnList.get(i));
				// }

			}

			ln.setId(i);
			ln.addView(checkButton, 0, layoutParamForcheck);

			checkBoxHolder.addView(ln, 0, lnlParams);

			checkButton
					.setOnCheckedChangeListener(new OnCheckedChangeListener() {

						public void onCheckedChanged(CompoundButton buttonView,
								boolean isChecked) {
							// TODO Auto-generated method stub
							if (isChecked) {

								if (qName.equalsIgnoreCase("q6_1")
										|| qName.equalsIgnoreCase("q6_2")) {
									if (checkButton.getText().toString()
											.equalsIgnoreCase("Don’t need")
											|| checkButton
													.getText()
													.toString()
													.equalsIgnoreCase(
															"15 cÖ‡qvRb g‡b Kwibv")) {
										String t = CommonStaticClass.langBng ? "15 cÖ‡qvRb g‡b Kwibv"
												: "Don’t need";
										uncheckAllFrmMultipleChoice(
												(ViewGroup) v, t);
									} else {
										String t = CommonStaticClass.langBng ? "15 cÖ‡qvRb g‡b Kwibv"
												: "Don’t need";
										uncheckExceptALLFrmMultipleChoice(
												(ViewGroup) v, t);
									}
								}

								if (qName.equalsIgnoreCase("q6_1")
										|| qName.equalsIgnoreCase("q6_2")) {
									if (checkButton
											.getText()
											.toString()
											.equalsIgnoreCase(
													"Don’t wash hands")
											|| checkButton
													.getText()
													.toString()
													.equalsIgnoreCase(
															"16 nvZ ayB bv")) {
										String t = CommonStaticClass.langBng ? "16 nvZ ayB bv"
												: "Don’t wash hands";
										uncheckAllFrmMultipleChoice(
												(ViewGroup) v, t);
									} else {
										String t = CommonStaticClass.langBng ? "16 nvZ ayB bv"
												: "Don’t wash hands";
										uncheckExceptALLFrmMultipleChoice(
												(ViewGroup) v, t);
									}
								}

								if (qName.equalsIgnoreCase("q3_4")
										|| qName.equalsIgnoreCase("q3_10")
										|| qName.equalsIgnoreCase("q3_16")) {
									if (checkButton
											.getText()
											.toString()
											.equalsIgnoreCase(
													"555. Can’t remember")
											|| checkButton
													.getText()
													.toString()
													.equalsIgnoreCase(
															"555. g‡b Ki‡Z cv‡i bv")) {
										String t = CommonStaticClass.langBng ? "555. g‡b Ki‡Z cv‡i bv"
												: "555. Can’t remember";
										uncheckAllFrmMultipleChoice(
												(ViewGroup) v, t);
									} else {
										String t = CommonStaticClass.langBng ? "555. g‡b Ki‡Z cv‡i bv"
												: "555. Can’t remember";
										uncheckExceptALLFrmMultipleChoice(
												(ViewGroup) v, t);
									}
								}

								if (qName.equalsIgnoreCase("q3_8")) {

									if (checkButton.getText().toString()
											.equalsIgnoreCase("888. N/A")
											|| checkButton
													.getText()
													.toString()
													.equalsIgnoreCase(
															"888. cÖ‡hvR¨ bq")) {
										String t = CommonStaticClass.langBng ? "888. cÖ‡hvR¨ b"
												: "888. N/A";
										uncheckAllFrmMultipleChoice(
												(ViewGroup) v, t);
									} else {
										String t = CommonStaticClass.langBng ? "888. cÖ‡hvR¨ b"
												: "888. N/A";
										uncheckExceptALLFrmMultipleChoice(
												(ViewGroup) v, t);
									}

									if (checkButton
											.getText()
											.toString()
											.equalsIgnoreCase(
													"555. Can’t remember")
											|| checkButton
													.getText()
													.toString()
													.equalsIgnoreCase(
															"555. g‡b Ki‡Z cv‡i bv")) {
										String t = CommonStaticClass.langBng ? "555. g‡b Ki‡Z cv‡i bv"
												: "555. Can’t remember";
										uncheckAllFrmMultipleChoice(
												(ViewGroup) v, t);
									} else {
										String t = CommonStaticClass.langBng ? "555. g‡b Ki‡Z cv‡i bv"
												: "555. Can’t remember";
										uncheckExceptALLFrmMultipleChoice(
												(ViewGroup) v, t);
									}
								}

								// 6_4
								if (qName.equalsIgnoreCase("q6_4")) {

									if (checkButton.getText().toString()
											.equalsIgnoreCase("N/A")
											|| checkButton
													.getText()
													.toString()
													.equalsIgnoreCase(
															"888 cÖ‡hvR¨ bq")) {
										String t = CommonStaticClass.langBng ? "888 cÖ‡hvR¨ bq"
												: "N/A";
										uncheckAllFrmMultipleChoice(
												(ViewGroup) v, t);
									} else {
										String t = CommonStaticClass.langBng ? "888 cÖ‡hvR¨ bq"
												: "N/A";
										uncheckExceptALLFrmMultipleChoice(
												(ViewGroup) v, t);
									}

									if (checkButton
											.getText()
											.toString()
											.equalsIgnoreCase(
													"555. Can’t remember")
											|| checkButton
													.getText()
													.toString()
													.equalsIgnoreCase(
															"555. g‡b Ki‡Z cv‡i bv")) {
										String t = CommonStaticClass.langBng ? "555. g‡b Ki‡Z cv‡i bv"
												: "555. Can’t remember";
										uncheckAllFrmMultipleChoice(
												(ViewGroup) v, t);
									} else {
										String t = CommonStaticClass.langBng ? "555. g‡b Ki‡Z cv‡i bv"
												: "555. Can’t remember";
										uncheckExceptALLFrmMultipleChoice(
												(ViewGroup) v, t);
									}
								}

								// 9_6
								if (qName.equalsIgnoreCase("q9_6")) {

									if (checkButton
											.getText()
											.toString()
											.equalsIgnoreCase(
													"None of the above")
											|| checkButton
													.getText()
													.toString()
													.equalsIgnoreCase(
															"9 Dc‡ii †KvbwUB bv")) {
										String t = CommonStaticClass.langBng ? "9 Dc‡ii †KvbwUB bv"
												: "None of the above";
										uncheckAllFrmMultipleChoice(
												(ViewGroup) v, t);
									} else {
										String t = CommonStaticClass.langBng ? "9 Dc‡ii †KvbwUB bv"
												: "None of the above";
										uncheckExceptALLFrmMultipleChoice(
												(ViewGroup) v, t);
									}

									if (checkButton
											.getText()
											.toString()
											.equalsIgnoreCase(
													"No available water")
											|| checkButton
													.getText()
													.toString()
													.equalsIgnoreCase(
															"10 cvwb wQj bv")) {
										String t = CommonStaticClass.langBng ? "10 cvwb wQj bv"
												: "No available water";
										uncheckAllFrmMultipleChoice(
												(ViewGroup) v, t);
									} else {
										String t = CommonStaticClass.langBng ? "10 cvwb wQj bv"
												: "No available water";
										uncheckExceptALLFrmMultipleChoice(
												(ViewGroup) v, t);
									}

								}
								// 10_4
								if (qName.equalsIgnoreCase("q10_4")) {

									if (checkButton.getText().toString()
											.equalsIgnoreCase("Found clean")
											|| checkButton
													.getText()
													.toString()
													.equalsIgnoreCase(
															"K. gqjv bvB")) {
										String t = CommonStaticClass.langBng ? "K. gqjv bvB"
												: "Found clean";
										uncheckAllFrmMultipleChoice(
												(ViewGroup) v, t);
									} else {
										String t = CommonStaticClass.langBng ? "K. gqjv bvB"
												: "Found clean";
										uncheckExceptALLFrmMultipleChoice(
												(ViewGroup) v, t);
									}

								}

								// Zoonotic
								// q40

								if (qName.equalsIgnoreCase("q40")) {

									if (checkButton
											.getText()
											.toString()
											.equalsIgnoreCase(
													"9. None of the above")
											|| checkButton
													.getText()
													.toString()
													.equalsIgnoreCase(
															"9. cÖ‡hvR¨ bq (hw` †KD ¯ck© K‡i bv _v‡K)")) {
										String t = CommonStaticClass.langBng ? "9. cÖ‡hvR¨ bq (hw` †KD ¯ck© K‡i bv _v‡K)"
												: "9. None of the above";
										uncheckAllFrmMultipleChoice(
												(ViewGroup) v, t);
									} else {
										String t = CommonStaticClass.langBng ? "9. cÖ‡hvR¨ bq (hw` †KD ¯ck© K‡i bv _v‡K)"
												: "9. None of the above";
										uncheckExceptALLFrmMultipleChoice(
												(ViewGroup) v, t);
									}

								}
								// q45
								if (qName.equalsIgnoreCase("q45")) {

									if (checkButton
											.getText()
											.toString()
											.equalsIgnoreCase(
													"None of the above")
											|| checkButton
													.getText()
													.toString()
													.equalsIgnoreCase(
															"8. cÖ‡hvR¨ bq (hw` †KD ¯ck© K‡i bv _v‡K)")) {
										String t = CommonStaticClass.langBng ? "8. cÖ‡hvR¨ bq (hw` †KD ¯ck© K‡i bv _v‡K)"
												: "None of the above";
										uncheckAllFrmMultipleChoice(
												(ViewGroup) v, t);
									} else {
										String t = CommonStaticClass.langBng ? "8. cÖ‡hvR¨ bq (hw` †KD ¯ck© K‡i bv _v‡K)"
												: "None of the above";
										uncheckExceptALLFrmMultipleChoice(
												(ViewGroup) v, t);
									}
								}

								// q49
								if (qName.equalsIgnoreCase("q49")) {

									if (checkButton.getText().toString()
											.equalsIgnoreCase("3.Dont know")
											|| checkButton
													.getText()
													.toString()
													.equalsIgnoreCase(
															"৩. জানিনা")) {
										String t = CommonStaticClass.langBng ? "৩. জানিনা"
												: "3.Dont know";
										uncheckAllFrmMultipleChoice(
												(ViewGroup) v, t);
									} else {
										String t = CommonStaticClass.langBng ? "৩. জানিনা"
												: "3.Dont know";
										uncheckExceptALLFrmMultipleChoice(
												(ViewGroup) v, t);
									}
								}

								if (qName.equalsIgnoreCase("q67")) {

									if (checkButton
											.getText()
											.toString()
											.equalsIgnoreCase(
													"5. Didn’t clean the processing place")
											|| checkButton
													.getText()
													.toString()
													.equalsIgnoreCase(
															"5. cwi®‹vi Kiv nqwb")) {
										String t = CommonStaticClass.langBng ? "5. cwi®‹vi Kiv nqwb"
												: "5. Didn’t clean the processing place";
										uncheckAllFrmMultipleChoice(
												(ViewGroup) v, t);
									} else {
										String t = CommonStaticClass.langBng ? "5. cwi®‹vi Kiv nqwb"
												: "5. Didn’t clean the processing place";
										uncheckExceptALLFrmMultipleChoice(
												(ViewGroup) v, t);
									}
								}

								if (qName.equalsIgnoreCase("q79")) {

									if (checkButton.getText().toString()
											.equalsIgnoreCase("8. Don’t know")
											|| checkButton
													.getText()
													.toString()
													.equalsIgnoreCase(
															"8. Rvwbbv")) {
										String t = CommonStaticClass.langBng ? "8. Rvwbbv"
												: "8. Don’t know";
										uncheckAllFrmMultipleChoice(
												(ViewGroup) v, t);
									} else {
										String t = CommonStaticClass.langBng ? "8. Rvwbbv"
												: "8. Don’t know";
										uncheckExceptALLFrmMultipleChoice(
												(ViewGroup) v, t);
									}
								}

								// q103a

								if (qName.equalsIgnoreCase("q103a")
										|| qName.equalsIgnoreCase("q103b")) {

									if (checkButton.getText().toString()
											.equalsIgnoreCase("Never Seen")
											|| checkButton
													.getText()
													.toString()
													.equalsIgnoreCase(
															"KL‡bv †`wLbvB")) {
										String t = CommonStaticClass.langBng ? "KL‡bv †`wLbvB"
												: "Never Seen";
										uncheckAllFrmMultipleChoice(
												(ViewGroup) v, t);
									} else {
										String t = CommonStaticClass.langBng ? "KL‡bv †`wLbvB"
												: "Never Seen";
										uncheckExceptALLFrmMultipleChoice(
												(ViewGroup) v, t);
									}
								}
								// q111
								if (qName.equalsIgnoreCase("q111")) {

									if (checkButton
											.getText()
											.toString()
											.equalsIgnoreCase("12.  Don’t know")
											|| checkButton
													.getText()
													.toString()
													.equalsIgnoreCase(
															"12. Rvwbbv")) {
										String t = CommonStaticClass.langBng ? "12. Rvwbbv"
												: "12.  Don’t know";
										uncheckAllFrmMultipleChoice(
												(ViewGroup) v, t);
									} else {
										String t = CommonStaticClass.langBng ? "12. Rvwbbv"
												: "12.  Don’t know";
										uncheckExceptALLFrmMultipleChoice(
												(ViewGroup) v, t);
									}
								}

								// q118_R1_C3
								if (qName.equalsIgnoreCase("q118_R1_C3")
										|| qName.equalsIgnoreCase("q118_R2_C3")
										|| qName.equalsIgnoreCase("q118_R3_C3")
										|| qName.equalsIgnoreCase("q118_R4_C3")
										|| qName.equalsIgnoreCase("q118_R5_C3")
										|| qName.equalsIgnoreCase("q118_R6_C3")) {

									if (checkButton
											.getText()
											.toString()
											.equalsIgnoreCase("11.  Don’t know")
											|| checkButton
													.getText()
													.toString()
													.equalsIgnoreCase(
															"11. Rvwbbv")) {
										String t = CommonStaticClass.langBng ? "11. Rvwbbv"
												: "11.  Don’t know";
										uncheckAllFrmMultipleChoice(
												(ViewGroup) v, t);
									} else {
										String t = CommonStaticClass.langBng ? "11. Rvwbbv"
												: "11.  Don’t know";
										uncheckExceptALLFrmMultipleChoice(
												(ViewGroup) v, t);
									}
								}

								// q121
								if (qName.equalsIgnoreCase("q121A")) {

									if (checkButton.getText().toString()
											.equalsIgnoreCase("6. Don’t know")
											|| checkButton
													.getText()
													.toString()
													.equalsIgnoreCase(
															"6. Rvwbbv")) {
										String t = CommonStaticClass.langBng ? "6. Rvwbbv"
												: "6. Don’t know";
										uncheckAllFrmMultipleChoice(
												(ViewGroup) v, t);
									} else {
										String t = CommonStaticClass.langBng ? "6. Rvwbbv"
												: "6. Don’t know";
										uncheckExceptALLFrmMultipleChoice(
												(ViewGroup) v, t);
									}
								}

								// q126
								if (qName.equalsIgnoreCase("q126")) {

									if (checkButton
											.getText()
											.toString()
											.equalsIgnoreCase("11.  Don’t know")
											|| checkButton
													.getText()
													.toString()
													.equalsIgnoreCase(
															"11. Rvwbbv")) {
										String t = CommonStaticClass.langBng ? "11. Rvwbbv"
												: "11.  Don’t know";
										uncheckAllFrmMultipleChoice(
												(ViewGroup) v, t);
									} else {
										String t = CommonStaticClass.langBng ? "11. Rvwbbv"
												: "11.  Don’t know";
										uncheckExceptALLFrmMultipleChoice(
												(ViewGroup) v, t);
									}
								}

								Log.e("id :", "" + checkButton.getId());
								if (edList.containsKey(ln.getId())) {
									edList.get(ln.getId()).setVisibility(
											View.VISIBLE);
								}
								aaa.set(ln.getId(), checkButton.getId());
							} else {
								aaa.set(ln.getId(), -1);
								if (edList.containsKey(ln.getId())) {
									edList.get(ln.getId()).setVisibility(
											View.INVISIBLE);
								}
							}
						}
					});

			/*
			 * if (CommonStaticClass.mode
			 * .equalsIgnoreCase(CommonStaticClass.EDITMODE)) {
			 */
			checkIfChckButtonShouldBeCheckedFrmMultipleChoice(checkButton,
					op.qidList.get(i));
			// }
		}

		prevButton = (Button) v.findViewById(R.id.prevButton);
		prevButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		saveNxtButton = (Button) v.findViewById(R.id.saveNxtButton);

		saveNxtButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				updateTableDataFrmMultipleChoice();

			}

		});
		clButton = (Button) v.findViewById(R.id.clButton);
		clButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) v);
			}

		});
		notesButton = (Button) v.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});
	}

	protected void uncheckOtherCheckBoxFrmMultipleChoice(ViewGroup group,
			String t) {
		// TODO Auto-generated method stub
		int nrOfChildren = group.getChildCount();
		for (int i = 0; i < nrOfChildren; i++) {
			View view = group.getChildAt(i);
			if (view instanceof CheckBox) {
				if (((CheckBox) view).getText().toString().equalsIgnoreCase(t)) {
					uncheckThisCheckButtonFrmMultipleChoice(view);
				}
			}
			if (view instanceof ViewGroup) {
				uncheckOtherCheckBoxFrmMultipleChoice((ViewGroup) view, t);
			}
		}
	}

	protected void unccheckDontknowCheckBoxFrmMultipleChoice(ViewGroup group,
			String t) {
		// TODO Auto-generated method stub
		int nrOfChildren = group.getChildCount();
		for (int i = 0; i < nrOfChildren; i++) {
			View view = group.getChildAt(i);
			if (view instanceof CheckBox) {
				if (((CheckBox) view).getText().toString().equalsIgnoreCase(t)) {
					uncheckThisCheckButtonFrmMultipleChoice(view);
				}
			}
			if (view instanceof ViewGroup) {
				unccheckDontknowCheckBoxFrmMultipleChoice((ViewGroup) view, t);
			}
		}
	}

	protected void uncheckExceptALLFrmMultipleChoice(ViewGroup group, String t) {
		// TODO Auto-generated method stub
		int nrOfChildren = group.getChildCount();
		for (int i = 0; i < nrOfChildren; i++) {
			View view = group.getChildAt(i);
			if (view instanceof CheckBox) {
				if (((CheckBox) view).getText().toString().equalsIgnoreCase(t)) {
					uncheckThisCheckButtonFrmMultipleChoice(view);
				}
			}
			if (view instanceof ViewGroup) {
				uncheckExceptALLFrmMultipleChoice((ViewGroup) view, t);
			}
		}
	}

	protected void uncheckAllFrmMultipleChoice(ViewGroup group, String t) {
		// TODO Auto-generated method stub
		int nrOfChildren = group.getChildCount();
		for (int i = 0; i < nrOfChildren; i++) {
			View view = group.getChildAt(i);
			if (view instanceof CheckBox) {
				if (!((CheckBox) view).getText().toString().equalsIgnoreCase(t)) {
					uncheckThisCheckButtonFrmMultipleChoice(view);
				}
			}
			if (view instanceof ViewGroup) {
				uncheckAllFrmMultipleChoice((ViewGroup) view, t);
			}
		}
	}

	private void uncheckThisCheckButtonFrmMultipleChoice(View v) {
		((CheckBox) v).setChecked(false);
	}

	private void checkEdboxHasDataFrmMultipleChoice(EditText edbox,
			String inColumn) {
		String sql = "";
		if (!CommonStaticClass.isMember)
			sql = "Select "
					+ inColumn
					+ " from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId + "'";
		else if (qName.equalsIgnoreCase("g5117a")
				|| qName.equalsIgnoreCase("g5118a")
				|| qName.equalsIgnoreCase("g51212a")
				|| qName.equalsIgnoreCase("g51213a"))
			sql = "Select "
					+ inColumn
					+ " from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId
					+ "' and cropfishcode=" + CommonStaticClass.cropfishcode;

		else
			sql = "Select "
					+ inColumn
					+ " from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId
					+ "' and memberid=" + CommonStaticClass.memberID;
		Cursor c = null;
		try {

			c = dbHelper.getQueryCursor(sql);
			if (c.getCount() > 0) {
				doFill1FrmMultipleChoice(c, edbox, inColumn);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (c != null)
				c.close();
		}
	}

	private boolean doFill1FrmMultipleChoice(Cursor c, EditText edbox,
			String inColumn) {
		// TODO Auto-generated method stub
		boolean dataOk = false;
		if (c.moveToFirst()) {
			do {
				if (c.getColumnIndex(inColumn) != -1) {
					String a = c.getString(c.getColumnIndex(inColumn));
					if (a != null && a.length() > 0) {
						edbox.setText(a);
						dataOk = true;
					}
				}
			} while (c.moveToNext());
		}
		return dataOk;
	}

	private void checkIfChckButtonShouldBeCheckedFrmMultipleChoice(
			CheckBox checkButton, String inColumn) {
		String sql = "";
		if (!CommonStaticClass.isMember)
			sql = "Select "
					+ inColumn
					+ " from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId + "'";
		else if (qName.equalsIgnoreCase("g5117a")
				|| qName.equalsIgnoreCase("g5118a")
				|| qName.equalsIgnoreCase("g51212a")
				|| qName.equalsIgnoreCase("g51213a"))
			sql = "Select "
					+ inColumn
					+ " from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId
					+ "' and cropfishcode=" + CommonStaticClass.cropfishcode;
		else
			sql = "Select "
					+ inColumn
					+ " from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId
					+ "' and memberid=" + CommonStaticClass.memberID;
		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				doFill2FrmMultipleChoice(mCursor1, checkButton, inColumn);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}
	}

	private boolean doFill2FrmMultipleChoice(Cursor mCursor1,
			CheckBox checkButton, String inColumn) {
		// TODO Auto-generated method stub
		boolean dataOk = false;
		if (mCursor1.moveToFirst()) {
			do {
				if (mCursor1.getColumnIndex(inColumn) != -1) {
					int a = mCursor1.getInt(mCursor1.getColumnIndex(inColumn));
					if (a == 1) {
						checkButton.setChecked(true);
						dataOk = true;
					}
				}
			} while (mCursor1.moveToNext());
		}
		return dataOk;
	}

	private void updateTableDataFrmMultipleChoice() {

		if (checkIfSingleOptionIsCheckedFrmMultipleChoice())

		{

			Iterator it = edList.entrySet().iterator();
			while (it.hasNext()) {
				LinkedHashMap.Entry<Integer, EditText> pairs = (LinkedHashMap.Entry<Integer, EditText>) it
						.next();
				if (pairs.getValue().getVisibility() == View.VISIBLE) {
					if (pairs.getValue().getText().toString().length() > 0) {
						String sq = "";
						if (!CommonStaticClass.isMember)
							sq = "UPDATE "
									+ CommonStaticClass.questionMap.get(
											CommonStaticClass.currentSLNo)
											.getTablename() + " SET "
									+ op.qnList.get(pairs.getKey()) + " = '"
									+ pairs.getValue().getText().toString()
									+ "' where dataid='"
									+ CommonStaticClass.dataId + "'";
						else if (qName.equalsIgnoreCase("g5117a")
								|| qName.equalsIgnoreCase("g5118a")
								|| qName.equalsIgnoreCase("g51212a")
								|| qName.equalsIgnoreCase("g51213a"))
							sq = "UPDATE "
									+ CommonStaticClass.questionMap.get(
											CommonStaticClass.currentSLNo)
											.getTablename() + " SET "
									+ op.qnList.get(pairs.getKey()) + " = '"
									+ pairs.getValue().getText().toString()
									+ "' where dataid='"
									+ CommonStaticClass.dataId
									+ "' and cropfishcode="
									+ CommonStaticClass.cropfishcode;
						else
							sq = "UPDATE "
									+ CommonStaticClass.questionMap.get(
											CommonStaticClass.currentSLNo)
											.getTablename() + " SET "
									+ op.qnList.get(pairs.getKey()) + " = '"
									+ pairs.getValue().getText().toString()
									+ "' where dataid='"
									+ CommonStaticClass.dataId
									+ "' and memberid="
									+ CommonStaticClass.memberID;
						dbHelper.executeDMLQuery(sq);
					} /*
					 * else { CommonStaticClass .showMyAlert(con,
					 * "Field is empty",
					 * "Please put correct information in field to proceed");
					 * return; }
					 */
				}
			}

			String sql = "UPDATE "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " SET ";
			for (int i = 0; i < op.codeList.size(); i++) {
				if (i == (op.codeList.size() - 1)) {
					sql += op.qidList.get(i) + " = '" + aaa.get(i) + "'";
					break;
				}
				sql += op.qidList.get(i) + " = '" + aaa.get(i) + "',";
			}
			if (!CommonStaticClass.isMember)
				sql += " where dataid='" + CommonStaticClass.dataId + "'";
			else if (qName.equalsIgnoreCase("g5117a")
					|| qName.equalsIgnoreCase("g5118a")
					|| qName.equalsIgnoreCase("g51212a")
					|| qName.equalsIgnoreCase("g51213a"))
				sql += " where dataid='" + CommonStaticClass.dataId
						+ "' and cropfishcode="
						+ CommonStaticClass.cropfishcode;

			else
				sql += " where dataid='" + CommonStaticClass.dataId
						+ "' and memberid=" + CommonStaticClass.memberID;

			if (dbHelper.executeDMLQuery(sql)) {

				if (!gotoskip()) {

					CommonStaticClass.findOutNextSLNo(
							qName,
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQnext1());
					CommonStaticClass.nextQuestion(ParentActivity.this);

				}

			}

			else {
				CommonStaticClass
						.showMyAlert(con, "Please check one!!!",
								"You didn't checked any answer please select one to preceed");
			}
		} else {
			CommonStaticClass
					.showMyAlert(con, "Please check one!!!",
							"You didn't checked any answer please select one to preceed");
		}

	}

	private boolean IfCompletedAllMembersFrmMultipleChoice() {
		boolean IsCompleted = true;
		String sql1 = "Select * from tblMainQues  where dataid='"
				+ CommonStaticClass.dataId + "'";
		String sql2 = "Select * from tblFamilyMember  where dataid='"
				+ CommonStaticClass.dataId
				+ "' and (anysick=1 or visitdoc=1 or hospitalized=1)";
		Cursor mCursor1 = null;
		Cursor mCursor2 = null;
		try {

			mCursor1 = dbHelper.getQueryCursor(sql1);
			mCursor2 = dbHelper.getQueryCursor(sql2);

			int a = mCursor1.getCount();
			int b = mCursor2.getCount();
			String x = Integer.toString(a);
			String y = Integer.toString(b);
			if (x.equalsIgnoreCase(y))
				IsCompleted = true;
			else
				IsCompleted = false;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}

		return IsCompleted;
	}

	private void showUserFinishDialogFrmMultipleChoice() {
		// get prompts.xml view
		LayoutInflater li = LayoutInflater.from(con);
		LinearLayout promptsView = (LinearLayout) li.inflate(R.layout.prompts,
				null);

		promptsView.removeView((EditText) promptsView
				.findViewById(R.id.editTextDialogUserInput));

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(con);

		// set prompts.xml to alertdialog builder
		alertDialogBuilder.setView(promptsView);

		final TextView textInfo = (TextView) promptsView
				.findViewById(R.id.textView1);
		textInfo.setText("Do u want to finish this cycle?");

		// set dialog message
		alertDialogBuilder
				.setCancelable(false)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

						CommonStaticClass.findOutNextSLNo(qName, "END");
						CommonStaticClass.nextQuestion(ParentActivity.this);

					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();
	}

	private boolean checkIfSingleOptionIsCheckedFrmMultipleChoice() {
		for (int i = 0; i < aaa.size(); i++) {
			if (!(aaa.get(i) == -1)) {
				return true;
			}
		}

		return false;
	}

	// FrmMultipleCombo part
	private void Load_UIFrmMultipleCombo(final ViewGroup v) {
		// TODO Auto-generated method stub
		loadAllUiViewsFrmMultipleCombo(v);

		// loading all options// need to give field name for every spinner
		if (CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo)
				.getQvar().equalsIgnoreCase("p1_10")) {
			op1st = CommonStaticClass.findOptionsForThisQuestion(dbHelper,
					"p1_10v1");
			op2nd = CommonStaticClass.findOptionsForThisQuestion(dbHelper,
					"p1_10v2");
			op3rd = CommonStaticClass.findOptionsForThisQuestion(dbHelper,
					"p1_10v3");

			op1st.qidList.add(0, "p1_10v1");
			op1st.codeList.add(0, -1);
			op1st.capBngList.add(0, "");
			op1st.capEngList.add(0, "");

			op2nd.qidList.add(0, "p1_10v2");
			op2nd.codeList.add(0, -1);
			op2nd.capBngList.add(0, "");
			op2nd.capEngList.add(0, "");

			op3rd.qidList.add(0, "p1_10v3");
			op3rd.codeList.add(0, -1);
			op3rd.capBngList.add(0, "");
			op3rd.capEngList.add(0, "");

		} else if (CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar()
				.equalsIgnoreCase("p2_8")) {
			op1st = CommonStaticClass.findOptionsForThisQuestion(dbHelper,
					"p2_8v1");
			op2nd = CommonStaticClass.findOptionsForThisQuestion(dbHelper,
					"p2_8v2");
			op3rd = CommonStaticClass.findOptionsForThisQuestion(dbHelper,
					"p2_8v3");

			op1st.qidList.add(0, "p2_8v1");
			op1st.codeList.add(0, -1);
			op1st.capBngList.add(0, "");
			op1st.capEngList.add(0, "");

			op2nd.qidList.add(0, "p2_8v2");
			op2nd.codeList.add(0, -1);
			op2nd.capBngList.add(0, "");
			op2nd.capEngList.add(0, "");

			op3rd.qidList.add(0, "p2_8v3");
			op3rd.codeList.add(0, -1);
			op3rd.capBngList.add(0, "");
			op3rd.capEngList.add(0, "");
		}

		filllAllSpinnerDataFrmMultipleCombo();

		btnPrev = (Button) v.findViewById(R.id.prevButton);
		btnPrev.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		btnsaveNxt = (Button) v.findViewById(R.id.saveNxtButton);
		btnsaveNxt.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateTableDataFrmMultipleCombo();

			}

		});
		btnClear = (Button) v.findViewById(R.id.clButton);
		btnClear.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) v);
			}

		});
		notesButton = (Button) v.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});
	}

	private void filllAllSpinnerDataFrmMultipleCombo() {
		// TODO Auto-generated method stub
		if (CommonStaticClass.langBng) {
			adapter1st = new SpinAdapter(this, op1st.capBngList, true);
			adapter2nd = new SpinAdapter(this, op2nd.capBngList, true);
			adapter3rd = new SpinAdapter(this, op3rd.capBngList, true);

		} else {
			adapter1st = new ArrayAdapter(this,
					android.R.layout.simple_spinner_item, op1st.capEngList);
			adapter2nd = new ArrayAdapter(this,
					android.R.layout.simple_spinner_item, op2nd.capEngList);
			adapter3rd = new ArrayAdapter(this,
					android.R.layout.simple_spinner_item, op3rd.capEngList);

		}
		adapter1st
				.setDropDownViewResource(CommonStaticClass.langBng ? R.layout.checkedspintextview
						: android.R.layout.simple_spinner_dropdown_item);
		spinner1st.setAdapter(adapter1st);
		spinner1st
				.setOnItemSelectedListener(new spinItemSelectListenerFrmMultipleCombo());

		adapter2nd
				.setDropDownViewResource(CommonStaticClass.langBng ? R.layout.checkedspintextview
						: android.R.layout.simple_spinner_dropdown_item);
		spinner2nd.setAdapter(adapter2nd);
		spinner2nd
				.setOnItemSelectedListener(new spinItemSelectListenerFrmMultipleCombo());

		adapter3rd
				.setDropDownViewResource(CommonStaticClass.langBng ? R.layout.checkedspintextview
						: android.R.layout.simple_spinner_dropdown_item);
		spinner3rd.setAdapter(adapter3rd);
		spinner3rd
				.setOnItemSelectedListener(new spinItemSelectListenerFrmMultipleCombo());

	}

	class spinItemSelectListenerFrmMultipleCombo implements
			OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View arg1, int pos,
				long arg3) {
			// TODO Auto-generated method stub

			if (parent == spinner1st) {
				if (parent.getItemAtPosition(pos).toString().length() > 0) {
					res1st = op1st.codeList.get(pos) + "";

					// Need to add condition here for all questions applied
					if (CommonStaticClass.questionMap
							.get(CommonStaticClass.currentSLNo).getQvar()
							.equalsIgnoreCase("p1_10")) {
						if (res1st.equalsIgnoreCase("77")) {
							if (!IsFirstTime1)
								promptUserForInputFrmMultipleCombo(spinner1st,
										"p1_10v1other");

						} else
							res1stother = "";
						IsFirstTime1 = false;
					} else if (CommonStaticClass.questionMap
							.get(CommonStaticClass.currentSLNo).getQvar()
							.equalsIgnoreCase("p2_8")) {
						if (res1st.equalsIgnoreCase("77")) {
							if (!IsFirstTime1)
								promptUserForInputFrmMultipleCombo(spinner1st,
										"p2_8v1other");
						} else
							res1stother = "";
						IsFirstTime1 = false;
					}

				}
			} else if (parent == spinner2nd) {
				if (parent.getItemAtPosition(pos).toString().length() > 0) {
					res2nd = op2nd.codeList.get(pos) + "";

					// Need to add condition here for all questions applied
					if (CommonStaticClass.questionMap
							.get(CommonStaticClass.currentSLNo).getQvar()
							.equalsIgnoreCase("p1_10")) {
						if (res2nd.equalsIgnoreCase("77")) {
							if (!IsFirstTime2)
								promptUserForInputFrmMultipleCombo(spinner2nd,
										"p1_10v2other");
						} else
							res2ndother = "";
						IsFirstTime2 = false;
					} else if (CommonStaticClass.questionMap
							.get(CommonStaticClass.currentSLNo).getQvar()
							.equalsIgnoreCase("p2_8")) {
						if (res2nd.equalsIgnoreCase("77")) {
							if (!IsFirstTime2)
								promptUserForInputFrmMultipleCombo(spinner2nd,
										"p2_8v2other");

						} else
							res2ndother = "";
						IsFirstTime2 = false;
					}

				}
			} else if (parent == spinner3rd) {
				if (parent.getItemAtPosition(pos).toString().length() > 0) {
					res3rd = op3rd.codeList.get(pos) + "";

					// Need to add condition here for all questions applied
					if (CommonStaticClass.questionMap
							.get(CommonStaticClass.currentSLNo).getQvar()
							.equalsIgnoreCase("p1_10")) {
						if (res3rd.equalsIgnoreCase("77")) {
							if (!IsFirstTime3)
								promptUserForInputFrmMultipleCombo(spinner3rd,
										"p1_10v3other");

						} else
							res3rdother = "";
						IsFirstTime3 = false;
					} else if (CommonStaticClass.questionMap
							.get(CommonStaticClass.currentSLNo).getQvar()
							.equalsIgnoreCase("p2_8")) {
						if (res3rd.equalsIgnoreCase("77")) {
							if (!IsFirstTime3)
								promptUserForInputFrmMultipleCombo(spinner3rd,
										"p2_8v3other");

						} else
							res3rdother = "";
						IsFirstTime3 = false;
					}

				}
			}
		}

		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub

		}

	}

	private void updateTableDataFrmMultipleCombo() {
		if (!IsValidFrmMultipleCombo())
			return;
		else {
			try {
				Date d = new Date(System.currentTimeMillis());
				d.toLocaleString();
				String sqlUp = "";
				// This section is for consistency check specilly for this
				// project
				if (CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar()
						.equalsIgnoreCase("p1_10")) {
					CheckNUpdateFrmMultipleCombo();
					// Skip Addition
					AddSkipFrmMultipleCombo();
				}

				sqlUp = "Update "
						+ CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getTablename()
						+ " Set " + op1st.qidList.get(0) + "=" + res1st + ","
						+ op2nd.qidList.get(0) + "=" + res2nd + ","
						+ op3rd.qidList.get(0) + "=" + res3rd;

				if (CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar()
						.equalsIgnoreCase("p1_10")) {
					sqlUp = sqlUp + ",p1_10v1other='" + res1stother + "'"
							+ ",p1_10v2other='" + res2ndother + "'"
							+ ",p1_10v3other='" + res3rdother + "'";
				}
				if (CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar()
						.equalsIgnoreCase("p2_8")) {
					sqlUp = sqlUp + ",p2_8v1other='" + res1stother + "'"
							+ ",p2_8v2other='" + res2ndother + "'"
							+ ",p2_8v3other='" + res3rdother + "'";
				}
				// for other questions have to add other conditions

				if (!CommonStaticClass.isMember)
					sqlUp = sqlUp + " Where dataid='"
							+ CommonStaticClass.dataId + "'";
				else
					sqlUp = sqlUp + " Where dataid='"
							+ CommonStaticClass.dataId + "' and memberid='"
							+ CommonStaticClass.memberID + "'";
				if (dbHelper.executeDMLQuery(sqlUp)) {
					// preserveState();
					CommonStaticClass.findOutNextSLNo(
							qName,
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQnext1());
					CommonStaticClass.nextQuestion(ParentActivity.this);
				}
			} catch (Exception e) {
			}
		}
	}

	private void CheckNUpdateFrmMultipleCombo() {
		IsInfomationMismatchingFrmMultipleCombo();

		if (IsMismatch_1_1_8) {

			CommonStaticClass.showMyAlert(con, "Updating",
					"memeber Visited doctor information is updating");
			UpdatePreviousDataFrmMultipleCombo("visitdoc");
			if (CommonStaticClass.qskipList.contains("SecP2"))
				;
			CommonStaticClass.qskipList.remove("SecP2");

		}
		if (IsMismatch_1_1_9) {
			CommonStaticClass.showMyAlert(con, "Updating",
					"Hospitalization information is updating");
			UpdatePreviousDataFrmMultipleCombo("hospitalized");
			if (CommonStaticClass.qskipList.contains("SecP3"))
				;
			CommonStaticClass.qskipList.remove("SecP3");

		}

	}

	private void AddSkipFrmMultipleCombo() {
		IsVisited1st = true;
		IsVisited2nd = true;
		IsVisited3rd = true;

		ShouldSkipfor1st = true;
		ShouldSkipfor2nd = true;
		ShouldSkipfor3rd = true;

		if (res1st.length() > 0
				&& (res1st.equalsIgnoreCase("-1")
						|| res1st.equalsIgnoreCase("2") || res1st
							.equalsIgnoreCase("99"))) {
			IsVisited1st = false;
		}
		if (res2nd.length() > 0
				&& (res2nd.equalsIgnoreCase("-1")
						|| res2nd.equalsIgnoreCase("2") || res2nd
							.equalsIgnoreCase("99"))) {
			IsVisited2nd = false;
		}
		if (res3rd.length() > 0
				&& (res3rd.equalsIgnoreCase("-1")
						|| res3rd.equalsIgnoreCase("2") || res3rd
							.equalsIgnoreCase("99"))) {
			IsVisited3rd = false;
		}

		if (res1st.length() > 0
				&& (res1st.equalsIgnoreCase("2") || res1st
						.equalsIgnoreCase("77"))) {
			ShouldSkipfor1st = false;
		}
		if (res2nd.length() > 0
				&& (res2nd.equalsIgnoreCase("2") || res2nd
						.equalsIgnoreCase("77"))) {
			ShouldSkipfor2nd = false;
		}

		if (res3rd.length() > 0
				&& (res3rd.equalsIgnoreCase("2") || res3rd
						.equalsIgnoreCase("77"))) {
			ShouldSkipfor3rd = false;
		}

		if (CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo)
				.getQvar().equalsIgnoreCase("p1_10")) {
			if (CommonStaticClass.qskipList.contains("p1_11"))
				CommonStaticClass.qskipList.remove("p1_11");
			if (CommonStaticClass.qskipList.contains("p1_12"))
				CommonStaticClass.qskipList.remove("p1_12");

			if (!IsVisited1st && !IsVisited2nd && !IsVisited3rd) {
				CommonStaticClass.qskipList.add("p1_11");
				nullifyWithInRange("p1_10", "p1_12");
			}
			String SQL = "";
			if (!IsVisited1st) {
				SQL = "Update tblMainQues set p1_11av1=-1,p1_11bv1=-1,p1_11cv1=-1,p1_11dv1=-1,p1_11ev1=-1,p1_11fv1=-1,p1_11gv1=-1,p1_11hv1=-1,p1_11iv1=-1,p1_11jv1=-1,p1_11v1other='' Where dataid='"
						+ CommonStaticClass.dataId
						+ "' and memberid="
						+ CommonStaticClass.memberID;
				dbHelper.executeDMLQuery(SQL);

			}
			if (!IsVisited2nd) {
				SQL = "Update tblMainQues set p1_11av2=-1,p1_11bv2=-1,p1_11cv2=-1,p1_11dv2=-1,p1_11ev2=-1,p1_11fv2=-1,p1_11gv2=-1,p1_11hv2=-1,p1_11iv2=-1,p1_11jv2=-1,p1_11v2other='' Where dataid='"
						+ CommonStaticClass.dataId
						+ "' and memberid="
						+ CommonStaticClass.memberID;
				dbHelper.executeDMLQuery(SQL);

			}
			if (!IsVisited3rd) {
				SQL = "Update tblMainQues set p1_11av3=-1,p1_11bv3=-1,p1_11cv3=-1,p1_11dv3=-1,p1_11ev3=-1,p1_11fv3=-1,p1_11gv3=-1,p1_11hv3=-1,p1_11iv3=-1,p1_11jv3=-1,p1_11v3other='' Where dataid='"
						+ CommonStaticClass.dataId
						+ "' and memberid="
						+ CommonStaticClass.memberID;
				dbHelper.executeDMLQuery(SQL);

			}

			if (res1st.equalsIgnoreCase("-1") && res2nd.equalsIgnoreCase("-1")
					&& res3rd.equalsIgnoreCase("-1")) {
				// No skip
			} else if (ShouldSkipfor1st && ShouldSkipfor2nd && ShouldSkipfor3rd) {
				CommonStaticClass.qskipList.add("p1_12");
				nullifyWithInRange("p1_11", "SecP2");
			}
		}

	}

	private void UpdatePreviousDataFrmMultipleCombo(String QVar) {
		try {
			String sql = "";

			if (QVar.equalsIgnoreCase("visitdoc"))
				sql = "Update tblFamilymember set visitdoc=1 Where dataid='"
						+ CommonStaticClass.dataId + "' and memberid='"
						+ CommonStaticClass.memberID + "'";
			else if (QVar.equalsIgnoreCase("hospitalized"))
				sql = "Update tblFamilymember set hospitalized=1 Where dataid='"
						+ CommonStaticClass.dataId
						+ "' and memberid='"
						+ CommonStaticClass.memberID + "'";
			dbHelper.executeDMLQuery(sql);
		} catch (Exception e) {

		}
	}

	private void promptUserForInputFrmMultipleCombo(final Spinner spinner,
			String ColumnName) {
		// get prompts.xml view

		LayoutInflater li = LayoutInflater.from(con);
		View promptsView = li.inflate(R.layout.prompts, null);

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(con);

		// set prompts.xml to alertdialog builder
		alertDialogBuilder.setView(promptsView);

		final EditText userInput = (EditText) promptsView
				.findViewById(R.id.editTextDialogUserInput);

		if (spinner == spinner1st) {
			res1stother = getOtherDataFrmMultipleCombo(ColumnName);
			if (res1stother != null && res1stother.length() > 0) {
				userInput.setText(res1stother);
			}
		} else if (spinner == spinner2nd) {
			res2ndother = getOtherDataFrmMultipleCombo(ColumnName);
			if (res2ndother != null && res2ndother.length() > 0) {
				userInput.setText(res2ndother);
			}
		} else if (spinner == spinner3rd) {
			res3rdother = getOtherDataFrmMultipleCombo(ColumnName);
			if (res3rdother != null && res3rdother.length() > 0) {
				userInput.setText(res3rdother);
			}
		}

		// set dialog message
		alertDialogBuilder
				.setCancelable(false)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// get user input and set it to result
						// edit text
						// insertDataToRelationOther(userInput.getText().toString());
						if (spinner == spinner1st)
							res1stother = userInput.getText().toString();
						else if (spinner == spinner2nd)
							res2ndother = userInput.getText().toString();
						else if (spinner == spinner3rd)
							res3rdother = userInput.getText().toString();

					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
								spinner.setSelection(0);
							}
						});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();
	}

	private String getOtherDataFrmMultipleCombo(String column) {
		String sql = "";
		if (!CommonStaticClass.isMember)
			sql = "Select "
					+ column
					+ " from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId + "'";
		else
			sql = "Select "
					+ column
					+ " from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId
					+ "' and memberid='" + CommonStaticClass.memberID + "'";

		String data = "";
		Cursor mCursor = null;
		try {
			mCursor = dbHelper.getQueryCursor(sql);
			if (mCursor.getCount() > 0) {
				if (mCursor.moveToFirst()) {
					do {
						data = mCursor
								.getString(mCursor.getColumnIndex(column));
					} while (mCursor.moveToNext());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (mCursor != null)
				mCursor.close();
		}
		return data;
	}

	public void LoadDataFrmMultipleCombo() {
		// TODO Auto-generated method stub
		String sql = "";
		if (!CommonStaticClass.isMember)
			sql = "Select * from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ "  where dataid = '" + CommonStaticClass.dataId + "'";
		else
			sql = "Select * from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ "  where dataid = '" + CommonStaticClass.dataId
					+ "' AND memberid='" + CommonStaticClass.memberID + "'";
		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				doFillFrmMultipleCombo(mCursor1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}
	}

	private void doFillFrmMultipleCombo(Cursor mCursor1) {
		// TODO Auto-generated method stub
		if (mCursor1.moveToFirst()) {
			do {
				spinner1st.setSelection(op1st.codeList.indexOf(Integer
						.parseInt(mCursor1.getString(mCursor1
								.getColumnIndex(op1st.qidList.get(0))))));
				spinner2nd.setSelection(op2nd.codeList.indexOf(Integer
						.parseInt(mCursor1.getString(mCursor1
								.getColumnIndex(op2nd.qidList.get(0))))));
				spinner3rd.setSelection(op3rd.codeList.indexOf(Integer
						.parseInt(mCursor1.getString(mCursor1
								.getColumnIndex(op3rd.qidList.get(0))))));

			} while (mCursor1.moveToNext());
		}
	}

	private void resetViewsFrmMultipleCombo() {
		spinner1st.setSelection(0);
		spinner2nd.setSelection(0);
		spinner3rd.setSelection(0);

	}

	private boolean IsValidFrmMultipleCombo() {
		boolean IsValid = false;

		res1st = op1st.codeList.get(spinner1st.getSelectedItemPosition())
				.toString();
		res2nd = op2nd.codeList.get(spinner2nd.getSelectedItemPosition())
				.toString();
		res3rd = op3rd.codeList.get(spinner3rd.getSelectedItemPosition())
				.toString();

		// Have to add question specific condition
		if (CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo)
				.getQvar().equalsIgnoreCase("p1_10")) {
			if (res1st.equalsIgnoreCase("77")
					&& res1stother.equalsIgnoreCase(""))
				res1stother = getOtherDataFrmMultipleCombo("p1_10v1other");
			if (res2nd.equalsIgnoreCase("77")
					&& res2ndother.equalsIgnoreCase(""))
				res2ndother = getOtherDataFrmMultipleCombo("p1_10v2other");
			if (res3rd.equalsIgnoreCase("77")
					&& res3rdother.equalsIgnoreCase(""))
				res3rdother = getOtherDataFrmMultipleCombo("p1_10v3other");
		}
		if (CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo)
				.getQvar().equalsIgnoreCase("p2_8")) {
			if (res1st.equalsIgnoreCase("77")
					&& res1stother.equalsIgnoreCase(""))
				res1stother = getOtherDataFrmMultipleCombo("p2_8v1other");
			if (res2nd.equalsIgnoreCase("77")
					&& res2ndother.equalsIgnoreCase(""))
				res2ndother = getOtherDataFrmMultipleCombo("p2_8v2other");
			if (res3rd.equalsIgnoreCase("77")
					&& res3rdother.equalsIgnoreCase(""))
				res3rdother = getOtherDataFrmMultipleCombo("p2_8v3other");
		}

		if (res1st.length() == 0) {
			CommonStaticClass.showMyAlert(con, "Error",
					"Please select 1st Visited");
			return IsValid;
		}
		if (res2nd.length() == 0) {
			CommonStaticClass.showMyAlert(con, "Error",
					"Please select 2nd Visited");
			return IsValid;
		}
		if (res3rd.length() == 0) {
			CommonStaticClass.showMyAlert(con, "Error",
					"Please select 3rd Visited");
			return IsValid;
		}
		return true;
	}

	private void IsInfomationMismatchingFrmMultipleCombo() {
		String sql = "";
		IsMismatch_1_1_8 = false;
		IsMismatch_1_1_9 = false;

		sql = "Select * from tblFamilyMember  where dataid = '"
				+ CommonStaticClass.dataId + "' AND memberid='"
				+ CommonStaticClass.memberID + "'";
		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				if (mCursor1.moveToFirst()) {
					do {
						// String
						// q1_1_7=mCursor1.getString(mCursor1.getColumnIndex("anysick"));
						String q1_1_8 = mCursor1.getString(mCursor1
								.getColumnIndex("visitdoc"));
						String q1_1_9 = mCursor1.getString(mCursor1
								.getColumnIndex("hospitalized"));

						if (!res1st.equalsIgnoreCase("-1")
								&& !res1st.equalsIgnoreCase("2")
								&& !res1st.equalsIgnoreCase("77")
								&& !res1st.equalsIgnoreCase("99")
								&& !q1_1_8.equalsIgnoreCase("1"))
							IsMismatch_1_1_8 = true;
						if (!res2nd.equalsIgnoreCase("-1")
								&& !res2nd.equalsIgnoreCase("2")
								&& !res2nd.equalsIgnoreCase("77")
								&& !res2nd.equalsIgnoreCase("99")
								&& !q1_1_8.equalsIgnoreCase("1"))
							IsMismatch_1_1_8 = true;
						if (!res3rd.equalsIgnoreCase("-1")
								&& !res3rd.equalsIgnoreCase("2")
								&& !res3rd.equalsIgnoreCase("77")
								&& !res3rd.equalsIgnoreCase("99")
								&& !q1_1_8.equalsIgnoreCase("1"))
							IsMismatch_1_1_8 = true;

						if ((res1st.equalsIgnoreCase("1") || res1st
								.equalsIgnoreCase("3"))
								&& !q1_1_9.equalsIgnoreCase("1"))
							IsMismatch_1_1_9 = true;
						if ((res2nd.equalsIgnoreCase("1") || res2nd
								.equalsIgnoreCase("3"))
								&& !q1_1_9.equalsIgnoreCase("1"))
							IsMismatch_1_1_9 = true;
						if ((res3rd.equalsIgnoreCase("1") || res3rd
								.equalsIgnoreCase("3"))
								&& !q1_1_9.equalsIgnoreCase("1"))
							IsMismatch_1_1_9 = true;

					} while (mCursor1.moveToNext());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}

	}

	private void loadAllUiViewsFrmMultipleCombo(ViewGroup v) {
		// TODO Auto-generated method stub

		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();

		qqq = (TextView) v.findViewById(R.id.qqq);

		lbl1st = (TextView) v.findViewById(R.id.lbl1st);
		lbl2nd = (TextView) v.findViewById(R.id.lbl2nd);
		lbl3rd = (TextView) v.findViewById(R.id.lbl3rd);

		spinner1st = (Spinner) v.findViewById(R.id.spinner1st);
		spinner2nd = (Spinner) v.findViewById(R.id.spinner2nd);
		spinner3rd = (Spinner) v.findViewById(R.id.spinner3rd);

		spinner1st.setFocusableInTouchMode(true);
		spinner1st.requestFocus();

		if (CommonStaticClass.langBng) {

			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				qqq.setTypeface(font);
			}
			;
			lbl1st.setTypeface(font);
			lbl1st.setText(con.getResources().getString(R.string.lbl1stVBN));
			lbl2nd.setTypeface(font);
			lbl2nd.setText(con.getResources().getString(R.string.lbl2VBN));
			lbl3rd.setTypeface(font);
			lbl3rd.setText(con.getResources().getString(R.string.lbl3VBN));

			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			lbl1st.setTypeface(null);

			lbl2nd.setTypeface(null);

			lbl3rd.setTypeface(null);

			lbl1st.setText("1st Visited care provider");

			lbl2nd.setText("2nd Visited care provider");

			lbl3rd.setText("3rd Visited care provider");

			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

	}

	// FrmNotes part
	private void loadGuiFrmNotes(ViewGroup v) {
		// TODO Auto-generated method stub

		// checkDbHasPreviousDataForThisHouseHold();

		infoText = (EditText) v.findViewById(R.id.infoText);
		String sql = "";
		if (!CommonStaticClass.isMember)
			sql = "Select notes from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId + "'";
		else
			sql = "Select notes from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId
					+ "' and memberid=" + CommonStaticClass.memberID;
		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				doFillFrmNotes(mCursor1, infoText);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}

		btnCancel = (Button) v.findViewById(R.id.btnCancel);
		btnCancel.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				// System.exit(0);
				ParentActivity.this.formFlipper
						.setDisplayedChild(lastIndexBeforeFraNotes);// gotoForm(CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo).getFormname());
			}

		});
		btnSave = (Button) v.findViewById(R.id.btnSave);
		btnSave.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateTableDataFrmNotes();
				ParentActivity.this.formFlipper
						.setDisplayedChild(lastIndexBeforeFraNotes);
				// System.exit(0);
				// ParentActivity.this.gotoForm(CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo).getFormname());
			}

		});

	}

	private void doFillFrmNotes(Cursor mCursor1, EditText infoText) {
		// TODO Auto-generated method stub
		if (mCursor1.moveToFirst()) {
			do {
				String column = "notes";

				if (mCursor1.getColumnIndex(column) != -1) {
					String a = mCursor1.getString(mCursor1
							.getColumnIndex(column)) + "";
					infoText.setText((a.length() > 0
							&& (!a.equalsIgnoreCase("-1")) && (!a
							.equalsIgnoreCase("null"))) ? a : "");
				}
			} while (mCursor1.moveToNext());
		}
	}

	private void updateTableDataFrmNotes() {
		// TODO Auto-generated method stub
		String qAns = infoText.getText().toString();
		if (qAns.length() > 0) {

			String sql = "";
			if (!CommonStaticClass.isMember)
				sql = "UPDATE "
						+ CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getTablename()
						+ " set notes='" + qAns + "' where dataid='"
						+ CommonStaticClass.dataId + "'";
			else
				sql = "UPDATE "
						+ CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getTablename()
						+ " set notes='" + qAns + "' where dataid='"
						+ CommonStaticClass.dataId + "' and memeberid="
						+ CommonStaticClass.memberID;
			dbHelper.executeDMLQuery(sql);

		}
	}

	private void doFill(Cursor mCursor1, EditText infoText2) {
		// TODO Auto-generated method stub
		if (mCursor1.moveToFirst()) {
			do {
				if (mCursor1.getColumnIndex(qName.toLowerCase()) != -1) {
					String a = mCursor1.getString(mCursor1.getColumnIndex(qName
							.toLowerCase())) + "";
					if (a.length() > 0 && (!a.equalsIgnoreCase("-1"))
							&& (!a.equalsIgnoreCase("null"))) {
						if (a.equalsIgnoreCase("555")) {
							((RadioButton) findViewById(R.id.radio2))
									.setChecked(true);

						} else if (a.equalsIgnoreCase("777")) {
							((RadioButton) findViewById(R.id.radio1))
									.setChecked(true);
						} else {
							infoText.setText(a);

						}
					}

				}
			} while (mCursor1.moveToNext());
		}
	}

	private void loadGuiFrmNumericWithUnknowDecline(final ViewGroup v) {

		qqq = (TextView) v.findViewById(R.id.qqq);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		// TODO Auto-generated method stub
		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();

		// qqq = (TextView) findViewById(R.id.qqq);

		// checkDbHasPreviousDataForThisHouseHold();

		((RadioGroup) findViewById(R.id.radioGroup1)).clearCheck();

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);

				((RadioButton) findViewById(R.id.radio1)).setTypeface(font);
				((RadioButton) findViewById(R.id.radio2)).setTypeface(font);
				((RadioButton) findViewById(R.id.radio1))
						.setText("	Ab¨vb¨ (wbw`©ó K‡i wjLyb)");
				((RadioButton) findViewById(R.id.radio2))
						.setText("g‡b Ki‡Z cv‡i bv");
			}
		}

		infoText = (EditText) findViewById(R.id.frmnumericwithunknowndecline)
				.findViewById(R.id.infoText);

		String sql = "";

		sql = "Select "
				+ qName
				+ " from "
				+ CommonStaticClass.questionMap.get(
						CommonStaticClass.currentSLNo).getTablename()
				+ " where dataid='" + CommonStaticClass.dataId + "'";
		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				doFill(mCursor1, infoText);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}

		prevButton = (Button) v.findViewById(R.id.prevButton);
		prevButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		saveNxtButton = (Button) v.findViewById(R.id.saveNxtButton);

		saveNxtButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				updateTableDataFrmNumericwithunknowDecline();
			}

		});
		clButton = (Button) v.findViewById(R.id.clButton);
		clButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) v);
			}

		});
		notesButton = (Button) v.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});

		((RadioGroup) findViewById(R.id.radioGroup1))
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					public void onCheckedChanged(RadioGroup group, int checkedId) {
						// ((EditText) findViewById(R.id.infoText)).setText("");
						infoText.setText("");
						InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
						imm.hideSoftInputFromWindow(infoText.getWindowToken(),
								0);

					}
				});

		infoText.setOnTouchListener(new OnTouchListener() {

			public boolean onTouch(View v, MotionEvent event) {
				((RadioButton) findViewById(R.id.radio1)).setChecked(false);
				((RadioButton) findViewById(R.id.radio2)).setChecked(false);

				if (((RadioGroup) findViewById(R.id.radioGroup1))
						.getCheckedRadioButtonId() != -1) {
					((RadioGroup) findViewById(R.id.radioGroup1)).clearCheck();
				}
				getWindow()
						.setSoftInputMode(
								WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
				return false;
			}
		});

		if (qName.equalsIgnoreCase("q5")) {
			((RadioButton) findViewById(R.id.radio2)).setVisibility(View.GONE);
		} else {
			((RadioButton) findViewById(R.id.radio2))
					.setVisibility(View.VISIBLE);
		}
	}

	private void updateTableDataFrmNumericwithunknowDecline() {
		// TODO Auto-generated method stub
		String qAns = ((EditText) findViewById(
				R.id.frmnumericwithunknowndecline).findViewById(R.id.infoText))
				.getText().toString();// infoText.getText().toString();
		String currentQuestion = qName;
		/*
		 * if (!IsValid()) { CommonStaticClass.showMyAlert(con, "Not Correct",
		 * "Cluster ID is mismatching"); return; }
		 */

		int id = ((RadioGroup) findViewById(R.id.radioGroup1))
				.getCheckedRadioButtonId();
		if (id != -1) {
			if (id == R.id.radio1) {
				qAns = "777";

			}
			if (id == R.id.radio2) {
				qAns = "555";

			}
		}

		if (qAns.length() > 0) {

			if (qName.equalsIgnoreCase("q19") && Integer.parseInt(qAns) > 999) {
				CommonStaticClass.showMyAlert(con, "Message", "Invalid");
				return;
			}

			if (qName.equalsIgnoreCase("q29")) {
				if (Integer.parseInt(qAns) > 0) {
					if (Integer.parseInt(qAns) < 14) {

					} else {
						if (((EditText) findViewById(R.id.infoText)).getText()
								.toString().length() > 0) {
							CommonStaticClass.showMyAlert(con, "Message",
									"Invalid Days(Valid value is 1 To 13)");
							return;
						}

					}
				} else {
					if (((EditText) findViewById(R.id.infoText)).getText()
							.toString().length() > 0) {
						CommonStaticClass.showMyAlert(con, "Message",
								"Invalid Days(Valid value is 1 To 13)");
						return;
					}
				}
			}

			// Validation & skip definition
			String sql = "";

			sql = "UPDATE "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " SET " + currentQuestion + "='" + qAns
					+ "' where dataid='" + CommonStaticClass.dataId + "'";

			if (dbHelper.executeDMLQuery(sql)) {

				CommonStaticClass.findOutNextSLNo(
						CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getQvar(),
						CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getQnext1());
				resetViewGroup((ViewGroup) (findViewById(R.id.linearLayout1)));

				if (qName.equalsIgnoreCase("q3_28")) {
					if (qAns.equalsIgnoreCase("777")) {
						CommonStaticClass.findOutNextSLNo(
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQvar(), "q3_28_other");
					}

				} else if (qName.equalsIgnoreCase("q3_29")) {
					if (qAns.equalsIgnoreCase("777")) {
						CommonStaticClass.findOutNextSLNo(
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQvar(), "q3_29_other");
					}
				}

				CommonStaticClass.nextQuestion(ParentActivity.this);

			}

		} else {
			CommonStaticClass.showMyAlert(con, "Not Correct",
					"Please put correct information in the field");
		}
	}

	public static long daysBetween(Calendar startDate, Calendar endDate) {
		Calendar date = (Calendar) startDate.clone();
		long daysBetween = 0;
		while (date.before(endDate)) {
			date.add(Calendar.DAY_OF_MONTH, 1);
			daysBetween++;
		}
		return daysBetween;
	}

	public Date getDate() {

		Date d = null;

		String sql = String.format(
				"SELECT q7 FROM tblFormB WHERE dataid='%s' ",
				CommonStaticClass.dataId);

		Cursor mCursor = null;
		try {
			mCursor = dbHelper.getQueryCursor(sql);
			if (mCursor.moveToFirst()) {
				do {
					String sDate = mCursor.getString(mCursor
							.getColumnIndex("q7"));

					String sday = sDate.substring(0, 2).trim();
					String smonth = sDate.substring(2, 6).trim();
					String sYear = sDate.substring(6, sDate.length()).trim();

					d = new Date(Integer.parseInt(sYear), GetMonth(smonth) - 1,
							Integer.parseInt(sday));

				} while (mCursor.moveToNext());
			}
		} catch (Exception e) {

		} finally {
			if (mCursor != null)
				mCursor.close();
		}
		return d;

	}

	private int GetMonth(String month) {
		int sMonth = 0;

		if (month.equalsIgnoreCase("Jan")) {
			sMonth = 1;
		} else if (month.equalsIgnoreCase("Feb")) {
			sMonth = 2;
		} else if (month.equalsIgnoreCase("Mar")) {
			sMonth = 3;
		} else if (month.equalsIgnoreCase("Apr")) {
			sMonth = 4;
		} else if (month.equalsIgnoreCase("May")) {
			sMonth = 5;
		} else if (month.equalsIgnoreCase("Jun")) {
			sMonth = 6;
		} else if (month.equalsIgnoreCase("Jul")) {
			sMonth = 7;
		} else if (month.equalsIgnoreCase("Aug")) {
			sMonth = 8;
		} else if (month.equalsIgnoreCase("Sep")) {
			sMonth = 9;
		} else if (month.equalsIgnoreCase("Oct")) {
			sMonth = 10;
		} else if (month.equalsIgnoreCase("Nov")) {
			sMonth = 11;
		} else if (month.equalsIgnoreCase("Dec")) {
			sMonth = 12;
		}

		return sMonth;

	}

	// FrmNumeric part

	private void loadGuiFrmNumeric(final ViewGroup v) {
		// TODO Auto-generated method stub

		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();

		qqq = (TextView) v.findViewById(R.id.qqq);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		infoText = (EditText) v.findViewById(R.id.infoText);
		// infoText.setText("");
		infoText.addTextChangedListener(new TextWatcher() {

			public void afterTextChanged(Editable s) {

				/*
				 * if (qName.equalsIgnoreCase("q5")) { String lineNumber =
				 * s.toString(); if (lineNumber.length() > 2) {
				 * CommonStaticClass.showMyAlert(con, "Message",
				 * "Number should be in two digit"); infoText.setText("");
				 * return; } }
				 */

				/*
				 * if (qName.equalsIgnoreCase("c610a")) { String lineNumber =
				 * s.toString(); if (lineNumber.length() > 2) {
				 * 
				 * CommonStaticClass.showMyAlert(con, "Message",
				 * "Number should be in two digit"); return;
				 * 
				 * } }
				 */

			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}
		});

		String sql = "";

		if (qName.equalsIgnoreCase("g5113a")
				|| qName.equalsIgnoreCase("g5114b")
				|| qName.equalsIgnoreCase("g51210a")
				|| qName.equalsIgnoreCase("g52313a")
				|| qName.equalsIgnoreCase("g52315a")
				|| qName.equalsIgnoreCase("g52317")
				|| qName.equalsIgnoreCase("g52318")
				|| qName.equalsIgnoreCase("g52319a")
				|| qName.equalsIgnoreCase("g52322")
				|| qName.equalsIgnoreCase("g52323")) {
			sql = "Select "
					+ qName
					+ " from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId
					+ "' and cropfishcode='" + CommonStaticClass.cropfishcode
					+ "'";
		} else if (!CommonStaticClass.isMember)
			sql = "Select "
					+ qName
					+ " from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId + "'";
		else
			sql = "Select "
					+ qName
					+ " from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId
					+ "' and memberid=" + CommonStaticClass.memberID;
		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				doFillFrmNumeric(mCursor1, infoText);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}

		prevButton = (Button) v.findViewById(R.id.prevButton);
		prevButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		saveNxtButton = (Button) v.findViewById(R.id.saveNxtButton);

		saveNxtButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				updateTableDataFrmNumeric();

			}

		});
		clButton = (Button) v.findViewById(R.id.clButton);
		clButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) v);
			}

		});
		notesButton = (Button) v.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});

	}

	private void doFillFrmNumeric(Cursor mCursor1, EditText infoText2) {
		// TODO Auto-generated method stub
		/*
		 * if (mCursor1.moveToFirst()) { do { if
		 * (mCursor1.getColumnIndex(qName.toLowerCase()) != -1) { String a =
		 * mCursor1.getString(mCursor1.getColumnIndex(qName .toLowerCase())) +
		 * ""; infoText2.setText((a.length() > 0 && (!a.equalsIgnoreCase("-1"))
		 * && (!a .equalsIgnoreCase("null"))) ? a : ""); } } while
		 * (mCursor1.moveToNext()); }
		 */
		infoText.setText("");
		if (mCursor1.moveToFirst()) {
			do {
				if (mCursor1.getColumnIndex(qName) != -1) {
					String a = mCursor1.getString(mCursor1
							.getColumnIndex(qName)) + "";
					// infoText.setText((a.length() > 0 &&
					// (!a.equalsIgnoreCase("-1")) &&
					// (!a.equalsIgnoreCase("null"))) ? a : "");
					infoText.setText((a.length() > 0
							&& (!a.equalsIgnoreCase("-1")) && (!a
							.equalsIgnoreCase("null"))) ? a : "");

					if (qName.equalsIgnoreCase("q8")) {
						if ((a.length() > 0 && (!a.equalsIgnoreCase("-1")) && (!a
								.equalsIgnoreCase("null")))) {
							infoText.setText(a);
						} else {
							Calendar dobCalender = Calendar.getInstance();

							Date d = getDate();
							dobCalender.set(d.getYear(), d.getMonth(),
									d.getDate());
							infoText.setText(String.valueOf(daysBetween(dsDate,
									dobCalender)));

						}

					}

				}
			} while (mCursor1.moveToNext());
		}
	}

	private void doFillFrmMultiple(Cursor mCursor1, ViewGroup v) {

		if (mCursor1.moveToFirst()) {
			do {

				chk1_1 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_1_1")) + "";
				((CheckBox) v.findViewById(R.id.chk1_1))
						.setChecked(chk1_1 == "1" ? true : false);

				chk2_1 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_2_1")) + "";
				((CheckBox) v.findViewById(R.id.chk2_1))
						.setChecked(chk2_1 == "1" ? true : false);

				chk2_2 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_2_2")) + "";
				((CheckBox) findViewById(R.id.chk2_2))
						.setChecked(chk2_2 == "1" ? true : false);

				chk2_3 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_2_3")) + "";
				((CheckBox) findViewById(R.id.chk2_3))
						.setChecked(chk2_3 == "1" ? true : false);

				chk2_4 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_2_4")) + "";
				((CheckBox) findViewById(R.id.chk2_4))
						.setChecked(chk2_4 == "1" ? true : false);

				chk2_5 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_2_5")) + "";
				((CheckBox) findViewById(R.id.chk2_5))
						.setChecked(chk2_5 == "1" ? true : false);

				et2_5_other = mCursor1.getString(mCursor1
						.getColumnIndex("c609_2_5_other")) + "";
				((EditText) findViewById(R.id.et2_5)).setText(et2_5_other);

				chk3_1 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_3_1")) + "";
				((CheckBox) findViewById(R.id.chk3_1))
						.setChecked(chk3_1 == "1" ? true : false);

				chk3_2 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_3_2")) + "";
				((CheckBox) findViewById(R.id.chk3_2))
						.setChecked(chk3_2 == "1" ? true : false);

				chk3_3 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_3_3")) + "";
				((CheckBox) findViewById(R.id.chk3_3))
						.setChecked(chk3_3 == "1" ? true : false);

				et3_3_other = mCursor1.getString(mCursor1
						.getColumnIndex("chk3_3_other")) + "";
				((EditText) findViewById(R.id.et3_3)).setText(et3_3_other);

				chk4_1 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_4_1")) + "";
				((CheckBox) findViewById(R.id.chk4_1))
						.setChecked(chk4_1 == "1" ? true : false);

				chk4_2 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_4_2")) + "";
				((CheckBox) findViewById(R.id.chk4_2))
						.setChecked(chk4_2 == "1" ? true : false);

				chk5_1 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_5_1")) + "";
				((CheckBox) findViewById(R.id.chk5_1))
						.setChecked(chk5_1 == "1" ? true : false);

				chk5_2 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_5_2")) + "";
				((CheckBox) findViewById(R.id.chk5_2))
						.setChecked(chk5_2 == "1" ? true : false);

				chk5_3 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_5_3")) + "";
				((CheckBox) findViewById(R.id.chk5_3))
						.setChecked(chk5_3 == "1" ? true : false);

				chk5_4 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_5_4")) + "";
				((CheckBox) findViewById(R.id.chk5_4))
						.setChecked(chk5_4 == "1" ? true : false);

				chk5_5 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_5_5")) + "";
				((CheckBox) findViewById(R.id.chk5_5))
						.setChecked(chk5_5 == "1" ? true : false);

				et5_5_other = mCursor1.getString(mCursor1
						.getColumnIndex("et5_5_other")) + "";
				((EditText) findViewById(R.id.et5_5)).setText(et5_5_other);
				chk6_1 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_6_1")) + "";
				((CheckBox) findViewById(R.id.chk6_1))
						.setChecked(chk6_1 == "1" ? true : false);
				chk6_2 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_6_2")) + "";
				((CheckBox) findViewById(R.id.chk6_2))
						.setChecked(chk6_2 == "1" ? true : false);
				chk7_1 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_7_1")) + "";
				((CheckBox) findViewById(R.id.chk7_1))
						.setChecked(chk7_1 == "1" ? true : false);
				chk7_2 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_7_2")) + "";
				((CheckBox) findViewById(R.id.chk7_2))
						.setChecked(chk7_2 == "1" ? true : false);
				chk7_3 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_7_3")) + "";
				((CheckBox) findViewById(R.id.chk7_3))
						.setChecked(chk7_3 == "1" ? true : false);
				chk7_4 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_7_4")) + "";
				((CheckBox) findViewById(R.id.chk7_4))
						.setChecked(chk7_4 == "1" ? true : false);
				chk7_5 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_7_5")) + "";
				((CheckBox) findViewById(R.id.chk7_5))
						.setChecked(chk7_5 == "1" ? true : false);

				chk7_7 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_7_7")) + "";
				((CheckBox) findViewById(R.id.chk7_7))
						.setChecked(chk7_7 == "1" ? true : false);

				chk7_6 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_7_6")) + "";
				((CheckBox) findViewById(R.id.chk7_6))
						.setChecked(chk7_6 == "1" ? true : false);
				et7_6_other = mCursor1.getString(mCursor1
						.getColumnIndex("c609_7_6_other")) + "";
				((EditText) findViewById(R.id.et7_6)).setText(et7_6_other);
				chk8_1 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_8_1")) + "";
				((CheckBox) findViewById(R.id.chk8_1))
						.setChecked(chk8_1 == "1" ? true : false);
				chk8_2 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_8_2")) + "";
				((CheckBox) findViewById(R.id.chk8_2))
						.setChecked(chk8_2 == "1" ? true : false);
				chk8_3 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_8_3")) + "";
				((CheckBox) findViewById(R.id.chk8_3))
						.setChecked(chk8_3 == "1" ? true : false);
				chk8_4 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_8_4")) + "";
				((CheckBox) findViewById(R.id.chk8_4))
						.setChecked(chk8_4 == "1" ? true : false);
				chk8_5 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_8_5")) + "";
				((CheckBox) findViewById(R.id.chk8_5))
						.setChecked(chk8_5 == "1" ? true : false);
				chk8_6 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_8_6")) + "";
				((CheckBox) findViewById(R.id.chk8_6))
						.setChecked(chk8_6 == "1" ? true : false);
				et8_6_other = mCursor1.getString(mCursor1
						.getColumnIndex("c609_8_6_other")) + "";
				((EditText) findViewById(R.id.et8_6)).setText(et8_6_other);
				chk9_1 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_9_1")) + "";
				((CheckBox) findViewById(R.id.chk9_1))
						.setChecked(chk9_1 == "1" ? true : false);
				chk9_2 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_9_2")) + "";
				((CheckBox) findViewById(R.id.chk9_2))
						.setChecked(chk9_2 == "1" ? true : false);
				chk9_3 = mCursor1
						.getString(mCursor1.getColumnIndex("c609_9_3")) + "";
				((CheckBox) findViewById(R.id.chk9_3))
						.setChecked(chk9_3 == "1" ? true : false);
				chk10_1 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_10_1")) + "";
				((CheckBox) findViewById(R.id.chk10_1))
						.setChecked(chk10_1 == "1" ? true : false);
				chk11_1 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_11_1")) + "";
				((CheckBox) findViewById(R.id.chk11_1))
						.setChecked(chk11_1 == "1" ? true : false);
				chk12_1 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_12_1")) + "";
				((CheckBox) findViewById(R.id.chk12_1))
						.setChecked(chk12_1 == "1" ? true : false);
				chk12_2 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_12_2")) + "";
				((CheckBox) findViewById(R.id.chk12_2))
						.setChecked(chk12_2 == "1" ? true : false);
				chk12_3 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_12_3")) + "";
				((CheckBox) findViewById(R.id.chk12_3))
						.setChecked(chk12_3 == "1" ? true : false);
				et12_3_other = mCursor1.getString(mCursor1
						.getColumnIndex("c609_12_3_other")) + "";
				((EditText) findViewById(R.id.et12_3)).setText(et12_3_other);
				chk13_1 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_13_1")) + "";
				((CheckBox) findViewById(R.id.chk13_1))
						.setChecked(chk13_1 == "1" ? true : false);
				chk13_2 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_13_2")) + "";
				((CheckBox) findViewById(R.id.chk13_2))
						.setChecked(chk13_2 == "1" ? true : false);
				chk13_3 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_13_3")) + "";
				((CheckBox) findViewById(R.id.chk13_3))
						.setChecked(chk13_3 == "1" ? true : false);
				chk13_4 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_13_4")) + "";
				((CheckBox) findViewById(R.id.chk13_4))
						.setChecked(chk13_4 == "1" ? true : false);
				chk13_5 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_13_5")) + "";
				((CheckBox) findViewById(R.id.chk13_5))
						.setChecked(chk13_5 == "1" ? true : false);
				chk13_6 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_13_6")) + "";
				((CheckBox) findViewById(R.id.chk13_6))
						.setChecked(chk13_6 == "1" ? true : false);
				chk13_7 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_13_7")) + "";
				((CheckBox) findViewById(R.id.chk13_7))
						.setChecked(chk13_7 == "1" ? true : false);
				et13_7_other = mCursor1.getString(mCursor1
						.getColumnIndex("c609_13_7_other")) + "";
				((EditText) findViewById(R.id.et13_7)).setText(et13_7_other);
				chk14_1 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_14_1")) + "";
				((CheckBox) findViewById(R.id.chk14_1))
						.setChecked(chk14_1 == "1" ? true : false);
				chk14_2 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_14_2")) + "";
				((CheckBox) findViewById(R.id.chk14_2))
						.setChecked(chk14_2 == "1" ? true : false);
				chk14_3 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_14_3")) + "";
				((CheckBox) findViewById(R.id.chk14_3))
						.setChecked(chk14_3 == "1" ? true : false);
				et14_3_other = mCursor1.getString(mCursor1
						.getColumnIndex("c609_14_3_other")) + "";
				((EditText) findViewById(R.id.et14_3)).setText(et14_3_other);
				chk15_1 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_15_1")) + "";
				((CheckBox) findViewById(R.id.chk15_1))
						.setChecked(chk15_1 == "1" ? true : false);
				chk15_2 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_15_2")) + "";
				((CheckBox) findViewById(R.id.chk15_2))
						.setChecked(chk15_2 == "1" ? true : false);
				chk15_3 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_15_3")) + "";
				((CheckBox) findViewById(R.id.chk15_3))
						.setChecked(chk15_3 == "1" ? true : false);
				chk16_1 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_16_1")) + "";
				((CheckBox) findViewById(R.id.chk16_1))
						.setChecked(chk16_1 == "1" ? true : false);
				chk16_2 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_16_2")) + "";
				((CheckBox) findViewById(R.id.chk16_2))
						.setChecked(chk16_2 == "1" ? true : false);
				chk16_3 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_16_3")) + "";
				((CheckBox) findViewById(R.id.chk16_3))
						.setChecked(chk16_3 == "1" ? true : false);
				chk16_4 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_16_4")) + "";
				((CheckBox) findViewById(R.id.chk16_4))
						.setChecked(chk16_4 == "1" ? true : false);
				chk17_1 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_17_1")) + "";
				((CheckBox) findViewById(R.id.chk17_1))
						.setChecked(chk17_1 == "1" ? true : false);
				chk17_2 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_17_2")) + "";
				((CheckBox) findViewById(R.id.chk17_2))
						.setChecked(chk17_2 == "1" ? true : false);
				chk17_3 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_17_3")) + "";
				((CheckBox) findViewById(R.id.chk17_3))
						.setChecked(chk17_3 == "1" ? true : false);
				chk18_1 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_18_1")) + "";
				((CheckBox) findViewById(R.id.chk18_1))
						.setChecked(chk18_1 == "1" ? true : false);
				chk18_2 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_18_2")) + "";
				((CheckBox) findViewById(R.id.chk18_2))
						.setChecked(chk18_2 == "1" ? true : false);
				et19_1 = mCursor1.getString(mCursor1
						.getColumnIndex("c609_19_1")) + "";

				((EditText) findViewById(R.id.et19_1))
						.setText((et19_1.length() > 0
								&& (!et19_1.equalsIgnoreCase("-1")) && (!et19_1
								.equalsIgnoreCase("null"))) ? et19_1 : "");

			} while (mCursor1.moveToNext());
		}
	}

	private float dataFromFrmNumeric(String sql, String columnName) {
		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.moveToFirst()) {
				do {
					String column = columnName;

					if (mCursor1.getColumnIndex(column) != -1) {
						String val = mCursor1.getString(mCursor1
								.getColumnIndex(column));
						Log.e("val", val + "");
						if (val.length() > 0 && !val.equalsIgnoreCase("0")
								&& !val.equalsIgnoreCase("-1")) {
							float a = Float.parseFloat(val);
							return a;
						}
					}
				} while (mCursor1.moveToNext());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}
		return 0;
	}

	private void updateTableDataFrmNumeric() {
		// TODO Auto-generated method stub

		String qAns = infoText.getText().toString();
		String currentQuestion = qName;
		if (!IsValidFrmNumeric()) {
			CommonStaticClass.showMyAlert(con, "Not Correct",
					"Cluster ID is mismatching");
			return;
		}

		if (qAns.length() > 0 || qName.equalsIgnoreCase("HH")
				|| qName.equalsIgnoreCase("SL")
				|| qName.equalsIgnoreCase("PID")) {
			if (qName.equalsIgnoreCase("mobileno")) {
				if (!qAns.startsWith("01")) {
					if (!qAns.equalsIgnoreCase("0")) {
						CommonStaticClass
								.showMyAlert(con, "Message",
										"Invalid Mobile Number. Number should start with 01");
						return;
					}
				} else if (qAns.equalsIgnoreCase("0")) {

				}
				/*
				 * else { CommonStaticClass.showMyAlert(con,
				 * "Message","Invalid Mobile Number."); return;
				 * 
				 * }
				 */

				else {
					if (qAns.length() < 11 || qAns.length() > 11) {
						CommonStaticClass.showMyAlert(con, "Message",
								"Invalid Mobile Number.");
						return;
					}
				}

			}

			if (qName.equalsIgnoreCase("c1_6")) {

				if (qAns.length() > 2) {

					CommonStaticClass.showMyAlert(con, "Message",
							"Number should be in two digit");
					return;
				}

				if (Integer.parseInt(qAns) >= 12
						&& Integer.parseInt(qAns) <= 99) {

				} else {
					CommonStaticClass.showMyAlert(con, "Message",
							"Number should be between 12 to 99");
					return;
				}

			}
			if (qName.equalsIgnoreCase("c613_days")) {

				if (qAns.length() > 1) {

					CommonStaticClass.showMyAlert(con, "Message",
							"Number should be in two digit");
					return;
				}

				if (Integer.parseInt(qAns) >= 1 && Integer.parseInt(qAns) <= 7) {

				} else {
					CommonStaticClass.showMyAlert(con, "Message",
							"Number should be between 1 to 7");
					return;
				}

			}

			// for two digit check only
			if (qName.equalsIgnoreCase("c607")
					|| qName.equalsIgnoreCase("c610a")
					|| qName.equalsIgnoreCase("q1_5")
					|| qName.equalsIgnoreCase("q1_6")) {
				String lineNumber = qAns.toString();
				if (lineNumber.length() > 2) {

					CommonStaticClass.showMyAlert(con, "Message",
							"Number should be in two digit");
					return;

				}
			}

			if (qName.equalsIgnoreCase("c607c_days")) {

				String lineNumber = qAns.toString();

				if (Integer.parseInt(lineNumber) <= 0
						|| Integer.parseInt(lineNumber) > 7) {

					CommonStaticClass.showMyAlert(con, "Message",
							"Number should be between 0 to 7");
					return;

				}
			}

			// Validation & skip definition
			String sql = "";

			if (qName.equalsIgnoreCase("g5113a")
					|| qName.equalsIgnoreCase("g5114b")
					|| qName.equalsIgnoreCase("g51210a")
					|| qName.equalsIgnoreCase("g52313a")
					|| qName.equalsIgnoreCase("g52315a")
					|| qName.equalsIgnoreCase("g52317")
					|| qName.equalsIgnoreCase("g52318")
					|| qName.equalsIgnoreCase("g52319a")
					|| qName.equalsIgnoreCase("g52322")
					|| qName.equalsIgnoreCase("g52323")) {
				sql = "UPDATE "
						+ CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getTablename()
						+ " SET " + currentQuestion + "='" + qAns
						+ "' where dataid='" + CommonStaticClass.dataId
						+ "'and cropfishcode='"
						+ CommonStaticClass.cropfishcode + "'";
			} else if (!CommonStaticClass.isMember)
				sql = "UPDATE "
						+ CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getTablename()
						+ " SET " + currentQuestion + "='" + qAns
						+ "' where dataid='" + CommonStaticClass.dataId + "'";
			else
				sql = "UPDATE "
						+ CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getTablename()
						+ " SET " + currentQuestion + "='" + qAns
						+ "' where dataid='" + CommonStaticClass.dataId
						+ "' and memberid=" + CommonStaticClass.memberID;

			if (dbHelper.executeDMLQuery(sql)) {

				/*
				 * if(qName.equalsIgnoreCase("g5113a")) {
				 * if(CommonStaticClass.g5113a ==0) {
				 * CommonStaticClass.findOutNextSLNo(qName, "cropfishcode"); }
				 * else{
				 * CommonStaticClass.findOutNextSLNo(CommonStaticClass.questionMap
				 * .
				 * get(CommonStaticClass.currentSLNo).getQvar(),CommonStaticClass
				 * .questionMap.get(CommonStaticClass.currentSLNo).getQnext1());
				 * } }
				 */

				if (qName.equalsIgnoreCase("AgeYr")) {
					if (Integer.parseInt(qAns) > 5) {
						CommonStaticClass.qskipList.add("DS60");
						CommonStaticClass.qskipList.add("DS61");
						CommonStaticClass.qskipList.add("DS62");
						CommonStaticClass.qskipList.add("DS63");
						CommonStaticClass.qskipList.add("DS64");
						CommonStaticClass.qskipList.add("DS65");
						CommonStaticClass.qskipList.add("DS66");
						CommonStaticClass.qskipList.add("DS67");
						CommonStaticClass.qskipList.add("DS68");
						CommonStaticClass.qskipList.add("DS69");

					} else {
						CommonStaticClass.qskipList.remove("DS60");
						CommonStaticClass.qskipList.remove("DS61");
						CommonStaticClass.qskipList.remove("DS62");
						CommonStaticClass.qskipList.remove("DS63");
						CommonStaticClass.qskipList.remove("DS64");
						CommonStaticClass.qskipList.remove("DS65");
						CommonStaticClass.qskipList.remove("DS66");
						CommonStaticClass.qskipList.remove("DS67");
						CommonStaticClass.qskipList.remove("DS68");
						CommonStaticClass.qskipList.remove("DS69");

					}
				}

				else if (qName.equalsIgnoreCase("g5113a")) {

					if (qAns.equalsIgnoreCase("0")) {

						CommonStaticClass.findOutNextSLNo(
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQvar(), "cropfishcode");
						CommonStaticClass.nextQuestion(ParentActivity.this);
						return;

					} else {
						CommonStaticClass.findOutNextSLNo(
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQvar(),
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQnext1());
						CommonStaticClass.nextQuestion(ParentActivity.this);
					}

				} else {
					CommonStaticClass.findOutNextSLNo(
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQvar(),
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQnext1());
					CommonStaticClass.nextQuestion(ParentActivity.this);
				}
			}
		} else {
			CommonStaticClass.showMyAlert(con, "Not Correct",
					"Please put correct information in the field");
		}
	}

	private boolean IsValidFrmNumeric() {
		String sql = "";
		Cursor mCursor1 = null;
		if (CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo)
				.getQvar().equalsIgnoreCase("clusterid")) {
			String ClusterID = CommonStaticClass.dataId.substring(2, 5);
			if (!ClusterID.equalsIgnoreCase(infoText.getText().toString()))
				return false;
		}
		if (CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo)
				.getQvar().equalsIgnoreCase("q29")
				|| CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar()
						.equalsIgnoreCase("q30")) {
			sql = "select * from tblMainQues where dataid='"
					+ CommonStaticClass.dataId + "'";
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQvar()
					.equalsIgnoreCase("q30")) {
				if (Integer.parseInt(infoText.getText().toString()) >= Integer
						.parseInt(mCursor1.getString(mCursor1
								.getColumnIndex("q12")))) {
					CommonStaticClass.showMyAlert(con, "Not Correct",
							"Wrong year, must be less than worker/member age.");
					return false;
				}
			} else if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQvar()
					.equalsIgnoreCase("HH")) {
				if (Integer.parseInt(infoText.getText().toString()) == 0) {

					return true;
				}
			}
		}

		return true;
	}

	private boolean alliszeroFrmNumeric(String qAns) {
		try {
			if (Integer.parseInt(qAns) == 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	// start-FrmNumericTwo
	private void loadGuiFrmNumericTwo(final ViewGroup v) {
		// TODO Auto-generated method stub
		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();
		qqq = (TextView) v.findViewById(R.id.qqq);
		num1 = (TextView) v.findViewById(R.id.lblNum1e);
		num2 = (TextView) v.findViewById(R.id.lblNum2e);

		num1.setText("");
		num2.setText("");
		// checkDbHasPreviousDataForThisHouseHold();

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");

				qqq.setTypeface(font);
				num1.setTypeface(font);
				num2.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());

			if (qName.equalsIgnoreCase("q2_6a")
					|| qName.equalsIgnoreCase("q2_6b")
					|| qName.equalsIgnoreCase("q2_6c")
					|| qName.equalsIgnoreCase("q2_6d")) {
				num1.setText("c~iæl");
				num2.setText("gwnjv");
			} else if (qName.equalsIgnoreCase("q310")) {
				num1.setText("cÖwZw`b Lvevi cvwb msMÖn Kivi msL¨v ");
				num2.setText("cÖwZw`b GKzqvU¨ve e¨envi Kivi msL¨v ");
			} else if (qName.equalsIgnoreCase("q621")
					|| qName.equalsIgnoreCase("q622")) {
				num1.setText("wbw`©ó Lvbv");
				num2.setText("Ab¨vb¨ Lvbv ");
			} else if (qName.equalsIgnoreCase("q615")) {
				num1.setText("cÖwZw`b Lvevi cvwb msMÖn Kivi msL¨v ");
				num2.setText("cÖwZw`b GKzqvU¨ve e¨envi Kivi msL¨v ");
			}
			if (qName.equalsIgnoreCase("q1_12_1")
					|| qName.equalsIgnoreCase("q1_12_2")) {
				num1.setText("QvÎ");
				num2.setText("QvÎx");
			}
			if (qName.equalsIgnoreCase("DS18H")) {
				num1.setText("wk¶K");
				num2.setText("wkw¶Kv");
			}

		} else {
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
			num1.setTypeface(null);
			num2.setTypeface(null);
			if (qName.equalsIgnoreCase("q2_6a")
					|| qName.equalsIgnoreCase("q2_6b")
					|| qName.equalsIgnoreCase("q2_6c")
					|| qName.equalsIgnoreCase("q2_6d")) {
				num1.setText("Male");
				num2.setText("Female");
			} else if (qName.equalsIgnoreCase("q310")
					|| qName.equalsIgnoreCase("q615")) {
				num1.setText("collect drinking water daily");
				num2.setText("Use aquatab daily");
			}

			else if (qName.equalsIgnoreCase("DS28H")
					|| qName.equalsIgnoreCase("DS18H")
					|| qName.equalsIgnoreCase("DS32H")
					|| qName.equalsIgnoreCase("DS35H")) {
				num1.setText("Hours");
				num2.setText("Days");
			}

			else {
				if (qName.equalsIgnoreCase("q1_12_1")
						|| qName.equalsIgnoreCase("q1_12_2")) {
					num1.setText("Boy");
					num2.setText("Girls");
				}

			}
		}

		infoText1 = (EditText) v.findViewById(R.id.txtNum1);
		infoText2 = (EditText) v.findViewById(R.id.txtNum2);

		qName1 = qName + "_a";
		qName2 = qName + "_b";

		String sql = "Select "
				+ qName1
				+ ","
				+ qName2
				+ " from "
				+ CommonStaticClass.questionMap.get(
						CommonStaticClass.currentSLNo).getTablename()
				+ " where dataid='" + CommonStaticClass.dataId + "'";
		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				doFillFrmNumericTwo(mCursor1, infoText1, infoText2);
			}
			if (!(infoText1.getText().toString().length() > 0)) {
				if (CommonStaticClass.previousDataFound) {
					if (CommonStaticClass.previousqlist.contains(qName)) {
						sql = "Select "
								+ qName1
								+ ","
								+ qName2
								+ " from "
								+ CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getTablename() + " where dataid='"
								+ CommonStaticClass.previoushouseHoldDatatId
								+ "'";
						mCursor1 = dbHelper.getQueryCursor(sql);
						if (mCursor1.getCount() > 0) {
							doFillFrmNumericTwo(mCursor1, infoText1, infoText2);
						}
					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}

		prevButton = (Button) v.findViewById(R.id.prevButton);
		prevButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		saveNxtButton = (Button) v.findViewById(R.id.saveNxtButton);

		saveNxtButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateTableDataFrmNumericTwo();
			}

		});
		clButton = (Button) v.findViewById(R.id.clButton);
		clButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) v);
			}

		});
		notesButton = (Button) v.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub

				// TODO Auto-generated method stub
				FraNotes();

			}

		});

	}

	private void doFillFrmNumericTwo(Cursor mCursor1, EditText infoText1,
			EditText infoText2) {
		// TODO Auto-generated method stub
		infoText1.setText("");
		infoText2.setText("");
		if (mCursor1.moveToFirst()) {
			do {
				if (mCursor1.getColumnIndex(qName1) != -1) {
					String a = mCursor1.getString(mCursor1
							.getColumnIndex(qName1)) + "";
					infoText1.setText((a.length() > 0
							&& (!a.equalsIgnoreCase("-1")) && (!a
							.equalsIgnoreCase("null"))) ? a : "");
				}
				if (mCursor1.getColumnIndex(qName2) != -1) {
					String a = mCursor1.getString(mCursor1
							.getColumnIndex(qName2)) + "";
					infoText2.setText((a.length() > 0
							&& (!a.equalsIgnoreCase("-1")) && (!a
							.equalsIgnoreCase("null"))) ? a : "");
				}
			} while (mCursor1.moveToNext());
		}
	}

	protected boolean checkForNoneFrmNumericTwo(String lineNumber) {
		String sql = "Select q101,q101a from tblHousehold where dataid='"
				+ CommonStaticClass.dataId + "'";
		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.moveToFirst()) {
				do {
					String lNo = mCursor1.getString(mCursor1
							.getColumnIndex("q101"));
					String typeNo = mCursor1.getString(mCursor1
							.getColumnIndex("q101a"));
					if (lNo.equalsIgnoreCase(lineNumber)) {
						if (Integer.parseInt(typeNo) == 4) {
							return true;
						}
					}
				} while (mCursor1.moveToNext());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}
		return false;
	}

	private void setDataFromFrmNumericTwo(EditText infoText, String qq,
			String table) {
		// TODO Auto-generated method stub
		String sql = "Select " + qq + "_Years from " + table
				+ " where dataid='" + CommonStaticClass.dataId + "'";
		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.moveToFirst()) {
				do {
					String column = qq + "_Years";

					if (mCursor1.getColumnIndex(column) != -1) {
						int yr = mCursor1.getInt(mCursor1
								.getColumnIndex(column));
						final Calendar c = Calendar.getInstance();
						int dateYear = c.get(Calendar.YEAR);
						// int dateMonth = c.get(Calendar.MONTH);
						// int dateDay = c.get(Calendar.DAY_OF_MONTH);
						if (yr != 8888) {
							infoText.setText((dateYear - yr) + "");
						} else {
							infoText.setText(88 + "");
						}
					}
				} while (mCursor1.moveToNext());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}

	}

	private void setDataFromFrmNumericTwo(EditText infoText, String q1,
			String q2, String table) {
		// TODO Auto-generated method stub
		String sql1 = "Select " + q1 + " from " + table + " where dataid='"
				+ CommonStaticClass.dataId + "'";
		String sql2 = "Select " + q2 + " from " + table + " where dataid='"
				+ CommonStaticClass.dataId + "'";
		float value = dataFromFrmNumericTwo(sql1, q1)
				- dataFromFrmNumericTwo(sql2, q2);
		infoText.setText(value + "");

	}

	// Get specific column value corresponding to SQL Query

	private float dataFromFrmNumericTwo(String sql, String columnName) {
		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.moveToFirst()) {
				do {
					String column = columnName;

					if (mCursor1.getColumnIndex(column) != -1) {
						String val = mCursor1.getString(mCursor1
								.getColumnIndex(column));
						Log.e("val", val + "");
						if (val.length() > 0 && !val.equalsIgnoreCase("0")
								&& !val.equalsIgnoreCase("-1")) {
							float a = Float.parseFloat(val);
							return a;
						}
					}
				} while (mCursor1.moveToNext());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}
		return 0;
	}

	private void updateTableDataFrmNumericTwo() {
		// TODO Auto-generated method stub
		String qAns1 = infoText1.getText().toString(), qAns2 = infoText2
				.getText().toString();
		if (!IsValidFrmNumericTwo()) {
			CommonStaticClass.showMyAlert(con, "Not Correct",
					"Cluster ID is mismatching");
			return;
		}
		if (qAns1.length() > 0 && qAns2.length() > 0) {

			// Validation & skip definition

			String sql = "UPDATE "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " SET " + qName1 + "='" + qAns1 + "'," + qName2 + "='"
					+ qAns2 + "' where dataid='" + CommonStaticClass.dataId
					+ "'";
			if (dbHelper.executeDMLQuery(sql)) {

				CommonStaticClass.findOutNextSLNo(
						CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getQvar(),
						CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getQnext1());
				CommonStaticClass.nextQuestion(ParentActivity.this);
			}
		} else {
			CommonStaticClass.showMyAlert(con, "Not Correct",
					"Please put correct information in the field");
		}
	}

	private boolean IsValidFrmNumericTwo() {
		if (infoText1.getText().toString() == "") {
			return false;
		}

		else {
			return true;
		}
	}

	private boolean alliszeroFrmNumericTwo(String qAns) {
		try {
			if (Integer.parseInt(qAns) == 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	// end-frmNumericTwo

	// FrmReasoning part
	private void Load_UIFrmReasoning(final ViewGroup v) {
		// TODO Auto-generated method stub

		// Enabling & disabling the controls
		Load_ControlsFrmReasoning(v);

		chka1 = (CheckBox) v.findViewById(R.id.chka1);
		chkb1 = (CheckBox) v.findViewById(R.id.chkb1);
		chkc1 = (CheckBox) v.findViewById(R.id.chkc1);
		chkd1 = (CheckBox) v.findViewById(R.id.chkd1);
		chke1 = (CheckBox) v.findViewById(R.id.chke1);
		chkf1 = (CheckBox) v.findViewById(R.id.chkf1);
		chkg1 = (CheckBox) v.findViewById(R.id.chkg1);
		chkh1 = (CheckBox) v.findViewById(R.id.chkh1);
		chki1 = (CheckBox) v.findViewById(R.id.chki1);
		chkj1 = (CheckBox) v.findViewById(R.id.chkj1);

		chka2 = (CheckBox) v.findViewById(R.id.chka2);
		chkb2 = (CheckBox) v.findViewById(R.id.chkb2);
		chkc2 = (CheckBox) v.findViewById(R.id.chkc2);
		chkd2 = (CheckBox) v.findViewById(R.id.chkd2);
		chke2 = (CheckBox) v.findViewById(R.id.chke2);
		chkf2 = (CheckBox) v.findViewById(R.id.chkf2);
		chkg2 = (CheckBox) v.findViewById(R.id.chkg2);
		chkh2 = (CheckBox) v.findViewById(R.id.chkh2);
		chki2 = (CheckBox) v.findViewById(R.id.chki2);
		chkj2 = (CheckBox) v.findViewById(R.id.chkj2);

		chka3 = (CheckBox) v.findViewById(R.id.chka3);
		chkb3 = (CheckBox) v.findViewById(R.id.chkb3);
		chkc3 = (CheckBox) v.findViewById(R.id.chkc3);
		chkd3 = (CheckBox) v.findViewById(R.id.chkd3);
		chke3 = (CheckBox) v.findViewById(R.id.chke3);
		chkf3 = (CheckBox) v.findViewById(R.id.chkf3);
		chkg3 = (CheckBox) v.findViewById(R.id.chkg3);
		chkh3 = (CheckBox) v.findViewById(R.id.chkh3);
		chki3 = (CheckBox) v.findViewById(R.id.chki3);
		chkj3 = (CheckBox) v.findViewById(R.id.chkj3);

		chka1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					a1 = 1;
				else
					a1 = 0;
			}
		});
		chkb1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					b1 = 1;
				else
					b1 = 0;
			}
		});
		chkc1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					c1 = 1;
				else
					c1 = 0;
			}
		});
		chkd1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					d1 = 1;
				else
					d1 = 0;
			}
		});
		chke1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					e1 = 1;
					if (!IsFirstTime1)
						promptUserForInputFrmReasoning(chke1, "p1_11v1other");
				} else {
					e1 = 0;
					other1 = "";
				}
				IsFirstTime1 = false;
			}
		});
		chkf1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					f1 = 1;
				else
					f1 = 0;
			}
		});
		chkg1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					g1 = 1;
				else
					g1 = 0;
			}
		});
		chkh1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					h1 = 1;
				else
					h1 = 0;
			}
		});
		chki1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					i1 = 1;
				else
					i1 = 0;
			}
		});
		chkj1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					j1 = 1;
				else
					j1 = 0;
			}
		});

		chka2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					a2 = 1;
				else
					a2 = 0;
			}
		});
		chkb2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					b2 = 1;
				else
					b2 = 0;
			}
		});
		chkc2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					c2 = 1;
				else
					c2 = 0;
			}
		});
		chkd2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					d2 = 1;
				else
					d2 = 0;
			}
		});
		chke2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					e2 = 1;
					if (!IsFirstTime2)
						promptUserForInputFrmReasoning(chke2, "p1_11v2other");
				} else {
					e2 = 0;
					other2 = "";

				}
				IsFirstTime2 = false;
			}
		});
		chkf2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					f2 = 1;
				else
					f2 = 0;
			}
		});
		chkg2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					g2 = 1;
				else
					g2 = 0;
			}
		});
		chkh2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					h2 = 1;
				else
					h2 = 0;
			}
		});
		chki2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					i2 = 1;
				else
					i2 = 0;
			}
		});
		chkj2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					j2 = 1;
				else
					j2 = 0;
			}
		});
		chka3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					a3 = 1;
				else
					a3 = 0;
			}
		});
		chkb3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					b3 = 1;
				else
					b3 = 0;
			}
		});
		chkc3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					c3 = 1;
				else
					c3 = 0;
			}
		});
		chkd3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					d3 = 1;
				else
					d3 = 0;
			}
		});
		chke3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					e3 = 1;
					if (!IsFirstTime3)
						promptUserForInputFrmReasoning(chke3, "p1_11v3other");
				} else {
					e3 = 0;
					other3 = "";
				}
				IsFirstTime3 = false;
			}
		});
		chkf3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					f3 = 1;
				else
					f3 = 0;
			}
		});
		chkg3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					g3 = 1;
				else
					g3 = 0;
			}
		});
		chkh3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					h3 = 1;
				else
					h3 = 0;
			}
		});
		chki3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					i3 = 1;
				else
					i3 = 0;
			}
		});
		chkj3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					j3 = 1;
				else
					j3 = 0;
			}
		});

		btnPrev = (Button) v.findViewById(R.id.prevButton);
		btnPrev.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		btnsaveNxt = (Button) v.findViewById(R.id.saveNxtButton);
		btnsaveNxt.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateTableDataFrmReasoning();
			}

		});
		btnClear = (Button) v.findViewById(R.id.clButton);
		btnClear.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) v);
			}

		});
		notesButton = (Button) v.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});
	}

	private void Load_ControlsFrmReasoning(ViewGroup v) {
		LinearLayout1 = (LinearLayout) v.findViewById(R.id.linearLayoutR1);
		LinearLayout2 = (LinearLayout) v.findViewById(R.id.linearLayoutR2);
		LinearLayout3 = (LinearLayout) v.findViewById(R.id.linearLayoutR3);

		qqq = (TextView) v.findViewById(R.id.qqq);

		lbla = (TextView) v.findViewById(R.id.lbla);
		lblb = (TextView) v.findViewById(R.id.lblb);
		lblc = (TextView) v.findViewById(R.id.lblc);
		lbld = (TextView) v.findViewById(R.id.lbld);
		lble = (TextView) v.findViewById(R.id.lble);
		lblf = (TextView) v.findViewById(R.id.lblf);
		lblg = (TextView) v.findViewById(R.id.lblg);
		lblh = (TextView) v.findViewById(R.id.lblh);
		lbli = (TextView) v.findViewById(R.id.lbli);
		lblj = (TextView) v.findViewById(R.id.lblj);

		if (CommonStaticClass.langBng) {

			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				qqq.setTypeface(font);
			}
			;
			lbla.setTypeface(font);
			lbla.setText(con.getResources().getString(R.string.lblaBN));
			lblb.setTypeface(font);
			lblb.setText(con.getResources().getString(R.string.lblbBN));
			lblc.setTypeface(font);
			lblc.setText(con.getResources().getString(R.string.lblcBN));
			lbld.setTypeface(font);
			lbld.setText(con.getResources().getString(R.string.lbldBN));
			lble.setTypeface(font);
			lble.setText(con.getResources().getString(R.string.lbleBN));
			lblf.setTypeface(font);
			lblf.setText(con.getResources().getString(R.string.lblfBN));
			lblg.setTypeface(font);
			lblg.setText(con.getResources().getString(R.string.lblgBN));
			lblh.setTypeface(font);
			lblh.setText(con.getResources().getString(R.string.lblhBN));
			lbli.setTypeface(font);
			lbli.setText(con.getResources().getString(R.string.lbliBN));
			lblj.setTypeface(font);
			lblj.setText(con.getResources().getString(R.string.lbljBN));

			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {

			lbla.setTypeface(null);

			lblb.setTypeface(null);

			lblc.setTypeface(null);

			lbld.setTypeface(null);

			lble.setTypeface(null);

			lblf.setTypeface(null);

			lblg.setTypeface(null);

			lblh.setTypeface(null);

			lbli.setTypeface(null);

			lblj.setTypeface(null);

			lbla.setText("a.Good treatment");

			lblb.setText("b. Good behaviour of health provider");

			lblc.setText("c.See patients with attention & time");

			lbld.setText("d.Do not know");

			lble.setText("e.Others");

			lblf.setText("f.Close distance from house");

			lblg.setText("g.Low cost");

			lblh.setText("h.Doctors available");

			lbli.setText("i.Drugs available/");
			lblj.setText("j.Familiar doctor/treatment place");

			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		String sql = "Select * from tblMainQues where dataid='"
				+ CommonStaticClass.dataId + "' and memberid='"
				+ CommonStaticClass.memberID + "'";
		Cursor mCursor = null;
		try {
			mCursor = dbHelper.getQueryCursor(sql);
			if (mCursor.getCount() > 0) {
				if (mCursor.moveToFirst()) {
					do {
						String val1 = mCursor.getString(mCursor
								.getColumnIndex("p1_10v1"));
						String val2 = mCursor.getString(mCursor
								.getColumnIndex("p1_10v2"));
						String val3 = mCursor.getString(mCursor
								.getColumnIndex("p1_10v3"));
						if (val1.length() > 0
								&& (val1.equalsIgnoreCase("-1")
										|| val1.equalsIgnoreCase("2") || val1
											.equalsIgnoreCase("99"))) {
							LinearLayout1.setVisibility(View.GONE);
							IsVisited1st = false;
						}
						if (val2.length() > 0
								&& (val2.equalsIgnoreCase("-1")
										|| val2.equalsIgnoreCase("2") || val2
											.equalsIgnoreCase("99"))) {
							LinearLayout2.setVisibility(View.GONE);
							IsVisited2nd = false;
						}
						if (val3.length() > 0
								&& (val3.equalsIgnoreCase("-1")
										|| val3.equalsIgnoreCase("2") || val3
											.equalsIgnoreCase("99"))) {
							LinearLayout3.setVisibility(View.GONE);
							IsVisited3rd = false;
						}
					} while (mCursor.moveToNext());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			mCursor.close();
			mCursor = null;
		}

	}

	private void updateTableDataFrmReasoning() {
		try {
			if (chke1.isChecked() && other1 == "") {
				other1 = dbHelper.GetSingleColumnData("p1_11v1other");
			}
			if (chke2.isChecked() && other2 == "") {
				other2 = dbHelper.GetSingleColumnData("p1_11v2other");
			}
			if (chke3.isChecked() && other3 == "") {
				other3 = dbHelper.GetSingleColumnData("p1_11v3other");
			}

			if (!IsValidFrmReasoning()) {
				CommonStaticClass.showMyAlert(con, "Error",
						"Please check the options");
				return;
			}

			String SQL = "Update tblMainQues set p1_11av1=" + a1 + ",p1_11bv1="
					+ b1 + ",p1_11cv1=" + c1 + ",p1_11dv1=" + d1 + ",p1_11ev1="
					+ e1 + ",p1_11fv1=" + f1 + ",p1_11gv1=" + g1 + ",p1_11hv1="
					+ h1 + ",p1_11iv1=" + i1 + ",p1_11jv1=" + j1 + ",p1_11av2="
					+ a2 + ",p1_11bv2=" + b2 + ",p1_11cv2=" + c2 + ",p1_11dv2="
					+ d2 + ",p1_11ev2=" + e2 + ",p1_11fv2=" + f2 + ",p1_11gv2="
					+ g2 + ",p1_11hv2=" + h2 + ",p1_11iv2=" + i2 + ",p1_11jv2="
					+ j2 + ",p1_11av3=" + a3 + ",p1_11bv3=" + b3 + ",p1_11cv3="
					+ c3 + ",p1_11dv3=" + d3 + ",p1_11ev3=" + e3 + ",p1_11fv3="
					+ f3 + ",p1_11gv3=" + g3 + ",p1_11hv3=" + h3 + ",p1_11iv3="
					+ i3 + ",p1_11jv3=" + j3 + ",p1_11v1other='" + other1
					+ "',p1_11v2other='" + other2 + "',p1_11v3other='" + other3
					+ "' Where dataid='" + CommonStaticClass.dataId
					+ "' and memberid=" + CommonStaticClass.memberID;
			if (dbHelper.executeDMLQuery(SQL)) {
				// preserveState();
				CommonStaticClass.findOutNextSLNo(
						CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getQvar(),
						CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getQnext1());
				CommonStaticClass.nextQuestion(ParentActivity.this);
			}
		} catch (Exception e) {

		} finally {

		}

	}

	private boolean IsValidFrmReasoning() {
		boolean vaild = false;
		if (IsVisited1st) {
			if (!chka1.isChecked() && !chkb1.isChecked() && !chkc1.isChecked()
					&& !chkd1.isChecked() && !chke1.isChecked()
					&& !chkf1.isChecked() && !chkg1.isChecked()
					&& !chkh1.isChecked() && !chki1.isChecked()
					&& !chkj1.isChecked())
				return vaild;
			if (chke1.isChecked() && other1 == "")
				return vaild;
		}
		if (IsVisited2nd) {
			if (!chka2.isChecked() && !chkb2.isChecked() && !chkc2.isChecked()
					&& !chkd2.isChecked() && !chke2.isChecked()
					&& !chkf2.isChecked() && !chkg2.isChecked()
					&& !chkh2.isChecked() && !chki2.isChecked()
					&& !chkj2.isChecked())
				return vaild;
			if (chke2.isChecked() && other2 == "")
				return vaild;

		}
		if (IsVisited3rd) {
			if (!chka3.isChecked() && !chkb3.isChecked() && !chkc3.isChecked()
					&& !chkd3.isChecked() && !chke3.isChecked()
					&& !chkf3.isChecked() && !chkg3.isChecked()
					&& !chkh3.isChecked() && !chki3.isChecked()
					&& !chkj3.isChecked())
				return vaild;
			if (chke3.isChecked() && other3 == "")
				return vaild;

		}

		return true;

	}

	private void Load_DataFrmReasoning() {

		String sql = "Select * from tblMainQues where dataid='"
				+ CommonStaticClass.dataId + "' and memberid='"
				+ CommonStaticClass.memberID + "'";
		Cursor mCursor = null;
		String inColumnFirst = "p1_11";
		String inColumnMiddle = "";
		String inColumnLast = "";
		try {
			mCursor = dbHelper.getQueryCursor(sql);
			if (mCursor.getCount() > 0) {
				if (mCursor.moveToFirst()) {
					do {
						for (int i = 1; i <= 3; i++) {
							if (i == 1)
								inColumnLast = "v1";
							else if (i == 2)
								inColumnLast = "v2";
							else if (i == 3)
								inColumnLast = "v3";
							for (int j = 1; j <= 10; j++) {
								if (j == 1)
									inColumnMiddle = "a";
								else if (j == 2)
									inColumnMiddle = "b";
								else if (j == 3)
									inColumnMiddle = "c";
								else if (j == 4)
									inColumnMiddle = "d";
								else if (j == 5)
									inColumnMiddle = "e";
								else if (j == 6)
									inColumnMiddle = "f";
								else if (j == 7)
									inColumnMiddle = "g";
								else if (j == 8)
									inColumnMiddle = "h";
								else if (j == 9)
									inColumnMiddle = "i";
								else if (j == 10)
									inColumnMiddle = "j";

								inColumnFirst = "p1_11";
								inColumnFirst = inColumnFirst + inColumnMiddle
										+ inColumnLast;

								if (mCursor.getColumnIndex(inColumnFirst) != -1) {
									int a = mCursor.getInt(mCursor
											.getColumnIndex(inColumnFirst));
									if (i == 1 && j == 1 && a == 1)
										chka1.setChecked(true);
									else if (i == 1 && j == 2 && a == 1)
										chkb1.setChecked(true);
									else if (i == 1 && j == 3 && a == 1)
										chkc1.setChecked(true);
									else if (i == 1 && j == 4 && a == 1)
										chkd1.setChecked(true);
									else if (i == 1 && j == 5 && a == 1)
										chke1.setChecked(true);
									else if (i == 1 && j == 6 && a == 1)
										chkf1.setChecked(true);
									else if (i == 1 && j == 7 && a == 1)
										chkg1.setChecked(true);
									else if (i == 1 && j == 8 && a == 1)
										chkh1.setChecked(true);
									else if (i == 1 && j == 9 && a == 1)
										chki1.setChecked(true);
									else if (i == 1 && j == 10 && a == 1)
										chkj1.setChecked(true);

									else if (i == 2 && j == 1 && a == 1)
										chka2.setChecked(true);
									else if (i == 2 && j == 2 && a == 1)
										chkb2.setChecked(true);
									else if (i == 2 && j == 3 && a == 1)
										chkc2.setChecked(true);
									else if (i == 2 && j == 4 && a == 1)
										chkd2.setChecked(true);
									else if (i == 2 && j == 5 && a == 1)
										chke2.setChecked(true);
									else if (i == 2 && j == 6 && a == 1)
										chkf2.setChecked(true);
									else if (i == 2 && j == 7 && a == 1)
										chkg2.setChecked(true);
									else if (i == 2 && j == 8 && a == 1)
										chkh2.setChecked(true);
									else if (i == 2 && j == 9 && a == 1)
										chki2.setChecked(true);
									else if (i == 2 && j == 10 && a == 1)
										chkj2.setChecked(true);

									else if (i == 3 && j == 1 && a == 1)
										chka3.setChecked(true);
									else if (i == 3 && j == 2 && a == 1)
										chkb3.setChecked(true);
									else if (i == 3 && j == 3 && a == 1)
										chkc3.setChecked(true);
									else if (i == 3 && j == 4 && a == 1)
										chkd3.setChecked(true);
									else if (i == 3 && j == 5 && a == 1)
										chke3.setChecked(true);
									else if (i == 3 && j == 6 && a == 1)
										chkf3.setChecked(true);
									else if (i == 3 && j == 7 && a == 1)
										chkg3.setChecked(true);
									else if (i == 3 && j == 8 && a == 1)
										chkh3.setChecked(true);
									else if (i == 3 && j == 9 && a == 1)
										chki3.setChecked(true);
									else if (i == 3 && j == 10 && a == 1)
										chkj3.setChecked(true);

								}
							}
						}
					} while (mCursor.moveToNext());
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void promptUserForInputFrmReasoning(final CheckBox checkbox,
			String ColumnName) {
		// get prompts.xml view

		LayoutInflater li = LayoutInflater.from(con);
		View promptsView = li.inflate(R.layout.prompts, null);

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(con);

		// set prompts.xml to alertdialog builder
		alertDialogBuilder.setView(promptsView);

		final EditText userInput = (EditText) promptsView
				.findViewById(R.id.editTextDialogUserInput);

		if (checkbox == chke1) {
			other1 = dbHelper.GetSingleColumnData(ColumnName);
			if (other1 != null && other1.length() > 0) {
				userInput.setText(other1);
			}
		} else if (checkbox == chke2) {
			other2 = dbHelper.GetSingleColumnData(ColumnName);
			if (other2 != null && other2.length() > 0) {
				userInput.setText(other2);
			}
		} else if (checkbox == chke3) {
			other3 = dbHelper.GetSingleColumnData(ColumnName);
			if (other3 != null && other3.length() > 0) {
				userInput.setText(other3);
			}
		}

		// set dialog message
		alertDialogBuilder
				.setCancelable(false)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// get user input and set it to result
						// edit text
						// insertDataToRelationOther(userInput.getText().toString());
						if (checkbox == chke1)
							other1 = userInput.getText().toString();
						else if (checkbox == chke2)
							other2 = userInput.getText().toString();
						else if (checkbox == chke3)
							other3 = userInput.getText().toString();

					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();

							}
						});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();
	}

	// frmsinglechoice part
	private void Load_UIFrmSingleChoice(final ViewGroup v) {
		// TODO Auto-generated method stub
		code = -1;
		qqq = (TextView) v.findViewById(R.id.qqq);

		// checkDbHasPreviousDataForThisHouseHold();

		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();

		op = CommonStaticClass.findOptionsForThisQuestion(dbHelper, qName);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");

				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		prevButton = (Button) v.findViewById(R.id.prevButton);
		prevButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		saveNxtButton = (Button) v.findViewById(R.id.saveNxtButton);

		saveNxtButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				if (code == -1) {
					CommonStaticClass.showMyAlert(con, "Error",
							"Please select one before going to next question");
				} else {
					progressDialog = ProgressDialog.show(con, "Wait",
							"Please wait while processing next question");
					new Thread() {

						public void run() {
							Looper.prepare();
							updateTableDataFrmSingleChoice();

							Message msg = new Message();
							msg.what = UPDATEDONE;
							handler.sendMessage(msg);
							Looper.loop();
						}
					}.start();
				}
			}

		});

		String sql = "";
		if (!CommonStaticClass.isMember)
			sql = "Select "
					+ qName
					+ " from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId + "'";
		else if (qName.equalsIgnoreCase("g5113b")
				|| qName.equalsIgnoreCase("g5114a")
				|| qName.equalsIgnoreCase("g5115")
				|| qName.equalsIgnoreCase("g5117")
				|| qName.equalsIgnoreCase("g5118")
				|| qName.equalsIgnoreCase("g5119")
				|| qName.equalsIgnoreCase("g511More")
				|| qName.equalsIgnoreCase("g51210")
				|| qName.equalsIgnoreCase("g51212")
				|| qName.equalsIgnoreCase("g51213")
				|| qName.equalsIgnoreCase("g51214")
				|| qName.equalsIgnoreCase("g512More")
				|| qName.equalsIgnoreCase("g52313")
				|| qName.equalsIgnoreCase("g52315")
				|| qName.equalsIgnoreCase("g52319")
				|| qName.equalsIgnoreCase("g52320")
				|| qName.equalsIgnoreCase("g523More"))
			sql = "Select "
					+ qName
					+ " from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId
					+ "' and cropfishcode='" + CommonStaticClass.cropfishcode
					+ "'";
		else
			sql = "Select "
					+ qName
					+ " from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId
					+ "' and memberid='" + CommonStaticClass.memberID + "'";
		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				doFill(mCursor1);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			idIfEdit = -1;
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}

		/*
		 * if(mRadioGroup!=null) { mRadioGroup. mRadioGroup.clearCheck(); }
		 */

		mRadioGroup = (RadioGroup) v.findViewById(R.id.sigleChoice);
		mRadioGroup.removeAllViews();
		Log.e("size", "" + op.codeList.size());
		mRadioGroup
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					public void onCheckedChanged(final RadioGroup group,
							int checkedId) {
						// TODO Auto-generated method stub

						code = group.getCheckedRadioButtonId();
						nextToGo = op.qnList.get(op.codeList.indexOf(code));

						Log.e("next to go", nextToGo);

						RadioButton checkedRadioButton = (RadioButton) group
								.findViewById(checkedId);

						if (checkedRadioButton != null) {

							if (String.valueOf(code) != null) {
								checkedRadioButton.setChecked(true);
								// group.check(checkedId);
							}

							/*
							 * Toast.makeText(getApplicationContext(),
							 * String.valueOf(code).toString(),
							 * Toast.LENGTH_SHORT).show();
							 */

						}
					}
				});

		/*
		 * for (int i = 0; i < op.codeList.size(); i++) {
		 * 
		 * RadioButton newRadioButton = new RadioButton(this); if
		 * (CommonStaticClass.langBng) { if (op.capBngList.get(i).length() > 0)
		 * { Typeface font = Typeface.createFromAsset(getAssets(),
		 * "Siyam Rupali ANSI.ttf"); newRadioButton.setTypeface(font); } ;
		 * newRadioButton .setText(op.capBngList.get(i).length() > 0 ?
		 * op.capBngList .get(i) : op.capEngList.get(i));
		 * 
		 * } else { newRadioButton.setTypeface(null);
		 * newRadioButton.setText(op.capEngList.get(i));
		 * 
		 * } newRadioButton.setId(op.codeList.get(i)); //
		 * if(CommonStaticClass.mode
		 * .equalsIgnoreCase(CommonStaticClass.EDITMODE)){ if (idIfEdit ==
		 * op.codeList.get(i)) { newRadioButton.setChecked(true); code =
		 * idIfEdit; } // } LinearLayout.LayoutParams layoutParams = new
		 * RadioGroup.LayoutParams( RadioGroup.LayoutParams.WRAP_CONTENT,
		 * RadioGroup.LayoutParams.WRAP_CONTENT);
		 * mRadioGroup.addView(newRadioButton, i, layoutParams); }
		 */

		for (int i = 0; i < op.codeList.size(); i++) {

			RadioButton newRadioButton = new RadioButton(this);
			if (CommonStaticClass.langBng) {
				if (op.capBngList.get(i).length() > 0) {
					Typeface font = Typeface.createFromAsset(getAssets(),
							"Siyam Rupali ANSI.ttf");
					newRadioButton.setTypeface(font);
				}
				;
				newRadioButton.setText(op.capBngList.get(i).length() > 0 ? Html
						.fromHtml(op.capBngList.get(i)) : Html
						.fromHtml(op.capEngList.get(i)));

			} else {
				newRadioButton.setText(Html.fromHtml(op.capEngList.get(i)));

			}
			newRadioButton.setId(op.codeList.get(i));
			// if(CommonStaticClass.mode.equalsIgnoreCase(CommonStaticClass.EDITMODE)){
			if (idIfEdit == op.codeList.get(i)) {
				newRadioButton.setChecked(true);
				code = idIfEdit;
			}
			// }
			LinearLayout.LayoutParams layoutParams = new RadioGroup.LayoutParams(
					RadioGroup.LayoutParams.WRAP_CONTENT,
					RadioGroup.LayoutParams.WRAP_CONTENT);

			mRadioGroup.addView(newRadioButton, i, layoutParams);
		}

		clButton = (Button) v.findViewById(R.id.clButton);
		clButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				code = -1;
				resetViewGroup((ViewGroup) v);
			}

		});
		notesButton = (Button) v.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});
	}

	private boolean doFill(Cursor mCursor1) {
		// TODO Auto-generated method stub
		boolean dataOk = false;
		if (mCursor1.moveToFirst()) {
			do {
				if (mCursor1.getColumnIndex(qName) != -1) {
					// Log.e("frmSingle",mCursor1.getString(mCursor1.getColumnIndex(CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo).getQvar())));
					String a = mCursor1.getString(mCursor1
							.getColumnIndex(qName)) + "";
					Log.e("aaaa", a + "");
					idIfEdit = (a.length() > 0 && !a.equalsIgnoreCase("null")) ? Integer
							.parseInt(a) : -1;
					if (op.codeList.contains(idIfEdit)) {
						dataOk = true;
					}
				}
			} while (mCursor1.moveToNext());
		}
		return dataOk;
	}

	private void SaveFamilyInfoFrmSingleChoice() {
		String entryBy = CommonStaticClass.userSpecificId;
		Date d = new Date(System.currentTimeMillis());
		String entryDate = "dd-mmm-yy";
		entryDate = d.toString();

		String sql = "", vName = "", vAge = "", vSex = "";
		Cursor cursor = null;
		sql = "Select * from  tblFamilyInfo Where  memid='"
				+ CommonStaticClass.dataId + "'";
		cursor = dbHelper.getQueryCursor(sql);
		if (cursor.getCount() == 0) {
			sql = "Select tblMainQues.q10,tblMainQues.q12,tblMainQuesSc.q13 from  tblMainQues inner join tblMainQuesSc on tblMainQues.dataid=tblMainQuesSc.dataid Where  tblMainQues.dataid='"
					+ CommonStaticClass.dataId + "'";
			cursor = dbHelper.getQueryCursor(sql);
			if (cursor.moveToFirst()) {
				vName = cursor.getString(cursor.getColumnIndex("q10"));
				vAge = cursor.getString(cursor.getColumnIndex("q12"));
				vSex = cursor.getString(cursor.getColumnIndex("q13"));
			}
			sql = "insert into tblFamilyInfo (dataid, memid, Name, Age_Year,Sex,EntryBy,EntryDate) values ('"
					+ CommonStaticClass.dataId.substring(0, 5)
					+ "00', '"
					+ CommonStaticClass.dataId
					+ "','"
					+ vName
					+ "',"
					+ vAge
					+ "," + vSex + ",'" + entryBy + "','" + entryDate + "')";
			if (dbHelper.executeDMLQuery(sql)) {
				sql = "update  tblMainQues set q15=q15+1 Where dataid='"
						+ CommonStaticClass.dataId.substring(0, 5) + "00'";
				if (dbHelper.executeDMLQuery(sql)) {

				}
			}
		}
	}

	private void updateTableDataFrmSingleChoice() {
		// TODO Auto-generated method stub
		// CommonStaticClass.findskiplistfromDB("q2_1c", "q2_1c", dbHelper);
		String sql = "";
		String qtoGo = "";
		if (nextToGo == null) {
			nextToGo = "";
		}

		nextToGo = nextToGo.length() > 0 ? nextToGo
				: CommonStaticClass.questionMap.get(
						CommonStaticClass.currentSLNo).getQnext1();

		try {

			if (code != -1) {
				if (!CommonStaticClass.isMember)
					sql = "UPDATE "
							+ CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo)
									.getTablename()
							+ " SET "
							+ CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQvar()
							+ "='" + code + "' where dataid='"
							+ CommonStaticClass.dataId + "'";
				else if (qName.equalsIgnoreCase("g5113b")
						|| qName.equalsIgnoreCase("g5114a")
						|| qName.equalsIgnoreCase("g5115")
						|| qName.equalsIgnoreCase("g5117")
						|| qName.equalsIgnoreCase("g5118")
						|| qName.equalsIgnoreCase("g5119")
						|| qName.equalsIgnoreCase("g511More")
						|| qName.equalsIgnoreCase("g51210")
						|| qName.equalsIgnoreCase("g51212")
						|| qName.equalsIgnoreCase("g51213")
						|| qName.equalsIgnoreCase("g51214")
						|| qName.equalsIgnoreCase("g512More")
						|| qName.equalsIgnoreCase("g52313")
						|| qName.equalsIgnoreCase("g52315")
						|| qName.equalsIgnoreCase("g52319")
						|| qName.equalsIgnoreCase("g52320")
						|| qName.equalsIgnoreCase("g523More")
						|| qName.equalsIgnoreCase("g52313")
						|| qName.equalsIgnoreCase("g52315")
						|| qName.equalsIgnoreCase("g52319")
						|| qName.equalsIgnoreCase("g52320")
						|| qName.equalsIgnoreCase("g523More"))
					sql = "UPDATE "
							+ CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo)
									.getTablename()
							+ " SET "
							+ CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQvar()
							+ "='" + code + "' where dataid='"
							+ CommonStaticClass.dataId + "' and cropfishcode='"
							+ CommonStaticClass.cropfishcode + "'";

				else
					sql = "UPDATE "
							+ CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo)
									.getTablename()
							+ " SET "
							+ CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQvar()
							+ "='" + code + "' where dataid='"
							+ CommonStaticClass.dataId + "'";

				if (dbHelper.executeDMLQuery(sql)) {

					if (qtoGo != null && qtoGo != ""
							&& !nextToGo.equalsIgnoreCase("END")) {
						CommonStaticClass.currentSLNo = CommonStaticClass
								.giveTheSLNo(qtoGo) - 1;
						CommonStaticClass.findOutNextSLNo(
								qName,
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQnext1());
						CommonStaticClass.nextQuestion(ParentActivity.this);

						return;

					}

					if (CommonStaticClass.questionMap
							.get(CommonStaticClass.currentSLNo).getQvar()
							.equalsIgnoreCase("DS17")) {

						if (code == 1) {
							CommonStaticClass.qskipList.add("DS18D");
							CommonStaticClass.qskipList.add("DS18H");
							CommonStaticClass.qskipList.add("DS19");
							CommonStaticClass.qskipList.add("DS20");
							CommonStaticClass.qskipList.add("DS21");
							CommonStaticClass.qskipList.add("DS22");
							CommonStaticClass.qskipList.add("DS23");
							CommonStaticClass.qskipList.add("DS24");
							CommonStaticClass.qskipList.add("DS25");

						} else {

							CommonStaticClass.qskipList.remove("DS18D");
							CommonStaticClass.qskipList.remove("DS18H");
							CommonStaticClass.qskipList.remove("DS19");
							CommonStaticClass.qskipList.remove("DS20");
							CommonStaticClass.qskipList.remove("DS21");
							CommonStaticClass.qskipList.remove("DS22");
							CommonStaticClass.qskipList.remove("DS23");
							CommonStaticClass.qskipList.remove("DS24");
							CommonStaticClass.qskipList.remove("DS25");

						}
					}
					if (CommonStaticClass.questionMap
							.get(CommonStaticClass.currentSLNo).getQvar()
							.equalsIgnoreCase("DS31")) {

						if (code == 1) {

							CommonStaticClass.qskipList.add("DS32D");
							CommonStaticClass.qskipList.add("DS32H");

						} else {

							CommonStaticClass.qskipList.remove("DS32D");
							CommonStaticClass.qskipList.remove("DS32H");

						}
					}
					if (CommonStaticClass.questionMap
							.get(CommonStaticClass.currentSLNo).getQvar()
							.equalsIgnoreCase("g523More")) {

						if (code == 0) {
							CommonStaticClass.isMember = false;
						}
					}

					if (CommonStaticClass.questionMap
							.get(CommonStaticClass.currentSLNo).getQvar()
							.equalsIgnoreCase("DS41")) {

						if (code == 1) {

							CommonStaticClass.qskipList.add("DS42");

						} else {

							CommonStaticClass.qskipList.remove("DS42");

						}
					}

					// End Angsuman
					if (CommonStaticClass.questionMap
							.get(CommonStaticClass.currentSLNo).getQnext1()
							.equalsIgnoreCase("SecP3")) {
						if (CommonStaticClass.qskipList.contains("SecP3")) {
							if (IfCompletedAllMembersFrmSingleChoice())
								showUserFinishDialogFrmSingleChoice();
							else {
								CommonStaticClass.currentSLNo = 31;
								CommonStaticClass
										.nextQuestion(ParentActivity.this);
							}
						} else {
							CommonStaticClass.findOutNextSLNo(
									qName,
									CommonStaticClass.questionMap.get(
											CommonStaticClass.currentSLNo)
											.getQnext1());
							CommonStaticClass.nextQuestion(ParentActivity.this);

						}
					} else if (nextToGo.equalsIgnoreCase("END")) {
						Message msg = new Message();
						msg.what = UPDATEDONE;
						handler.sendMessage(msg);
						if (IfCompletedAllMembersFrmSingleChoice())
							showUserFinishDialogFrmSingleChoice();
						else {
							CommonStaticClass.currentSLNo = 31;
							CommonStaticClass.nextQuestion(ParentActivity.this);
						}
					} else {
						/*
						 * if (CommonStaticClass.questionMap
						 * .get(CommonStaticClass.currentSLNo).getQvar()
						 * .equalsIgnoreCase("q13") && code == 1) { if
						 * (dbHelper.GetSingleColumnData("q4")
						 * .equalsIgnoreCase("3")) {
						 * CommonStaticClass.qskipList.add("q13a");
						 * CommonStaticClass.qskipList.add("q14");
						 * nullifyWithInRange("q13", "q15"); nextToGo = "q16"; }
						 * }
						 */
						if (CommonStaticClass.questionMap
								.get(CommonStaticClass.currentSLNo).getQvar()
								.equalsIgnoreCase("q8_3a")) {

							if (dbHelper
									.IsDataExistsAndNotNull(String
											.format("SELECT COUNT(*) FROM tblMainQuesSc WHERE (q8_3='0' OR q8_3='888') AND q8_3a ='0'  AND dataid = '%s'",
													CommonStaticClass.dataId))) {
								// CommonStaticClass.qskipList.add("q14");
								nullifyWithInRange("q8_4_1", "q8_4_8");
								nextToGo = "q9_Message";
							}
						}

						if (CommonStaticClass.questionMap
								.get(CommonStaticClass.currentSLNo).getQvar()
								.equalsIgnoreCase("q25")
								&& CommonStaticClass.dataId.substring(5, 7)
										.equalsIgnoreCase("00")) {
							sql = "UPDATE tblMainQuesMc SET q26_b=NULL,q26_c=NULL,q26_i=NULL,q26_d=NULL,q26_p=NULL,q26_o=NULL, q26Other=NULL,q29years=NULL,q29months=NULL,q29days=NULL,q30years=NULL,q30months=NULL,q30days=NULL,q31_tp=NULL,q31_fp=NULL,q31_cf=NULL,q31_cw=NULL,q31_sp=NULL,q31_dp=NULL,q31_ep=NULL,q31_ctf=NULL,q31_cfk=NULL,q32_pa=NULL,q32_g=NULL,q32_dc=NULL,q32_m=NULL,q32_b=NULL "
									+ CommonStaticClass.questionMap.get(
											CommonStaticClass.currentSLNo)
											.getQvar()
									+ "='"
									+ code
									+ "' where dataid='"
									+ CommonStaticClass.dataId + "'";
							if (dbHelper.executeDMLQuery(sql)) {
								nextToGo = "END";
							}
						}
						CommonStaticClass.findOutNextSLNo(qName, nextToGo);
						CommonStaticClass.nextQuestion(ParentActivity.this);
					}
				}
			}
		} catch (Exception ex) {
			// CommonStaticClass.showMyAlert(con, "Exception",
			// ex.getMessage().toString());
		}

	}

	private void updateq7() {

		try {

			CommonStaticClass.qskipList.add("q7_1_b");
			CommonStaticClass.qskipList.add("q7_1_c");
			CommonStaticClass.qskipList.add("q7_1_d");
			CommonStaticClass.qskipList.add("q7_2_a");
			CommonStaticClass.qskipList.add("q7_2_b");
			CommonStaticClass.qskipList.add("q7_2_c");
			CommonStaticClass.qskipList.add("q7_2_d");
			CommonStaticClass.qskipList.add("q7_3_a");
			CommonStaticClass.qskipList.add("q7_3_b");
			CommonStaticClass.qskipList.add("q7_3_c");
			CommonStaticClass.qskipList.add("q7_3_d");
			CommonStaticClass.qskipList.add("q7_4_a");
			CommonStaticClass.qskipList.add("q7_4_b");
			CommonStaticClass.qskipList.add("q7_4_c");
			CommonStaticClass.qskipList.add("q7_4_d");

		} catch (Exception e) {
			Log.e("updateq7", e.toString());
		}

	}

	private void Load_DataFrmSingleChoice() {

	}

	private boolean IfCompletedAllMembersFrmSingleChoice() {
		boolean IsCompleted = true;
		String sql1 = "Select * from tblMainQues  where dataid='"
				+ CommonStaticClass.dataId + "'";
		String sql2 = "Select * from tblFamilyMember  where dataid='"
				+ CommonStaticClass.dataId
				+ "' and (anysick=1 or visitdoc=1 or hospitalized=1)";
		Cursor mCursor1 = null;
		Cursor mCursor2 = null;
		try {

			mCursor1 = dbHelper.getQueryCursor(sql1);
			mCursor2 = dbHelper.getQueryCursor(sql2);

			int a = mCursor1.getCount();
			int b = mCursor2.getCount();
			String x = Integer.toString(a);
			String y = Integer.toString(b);
			if (x.equalsIgnoreCase(y))
				IsCompleted = true;
			else
				IsCompleted = false;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}

		return IsCompleted;
	}

	private void showUserFinishDialogFrmSingleChoice() {
		// get prompts.xml view
		LayoutInflater li = LayoutInflater.from(con);
		LinearLayout promptsView = (LinearLayout) li.inflate(R.layout.prompts,
				null);

		promptsView.removeView((EditText) promptsView
				.findViewById(R.id.editTextDialogUserInput));

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(con);

		// set prompts.xml to alertdialog builder
		alertDialogBuilder.setView(promptsView);

		final TextView textInfo = (TextView) promptsView
				.findViewById(R.id.textView1);
		textInfo.setText("Do u want to finish this cycle?");

		// set dialog message
		alertDialogBuilder
				.setCancelable(false)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						Log.e("qName: ", "qName: " + qName);
						if (qName.equalsIgnoreCase("q4_2")) {
							nullifyq4_3();
						}
						CommonStaticClass.findOutNextSLNo(qName, "END");
						CommonStaticClass.nextQuestion(ParentActivity.this);

					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();
	}

	private Handler handler = new Handler() {

		public void handleMessage(Message msg) {
			switch (msg.what) {
			case UPDATEDONE:
				progressDialog.dismiss();
				break;
			}

		}
	};

	// FrmText part
	private void loadGuiFrmText(final ViewGroup v) {
		// TODO Auto-generated method stub

		// checkDbHasPreviousDataForThisHouseHold();

		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();
		qqq = (TextView) v.findViewById(R.id.qqq);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		infoText = (EditText) v.findViewById(R.id.infoText);
		infoText.requestFocus();
		String sql = "";
		if (qName.equalsIgnoreCase("g51212aOther")
				|| qName.equalsIgnoreCase("g51213aOther")) {
			sql = "Select "
					+ qName
					+ " from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId
					+ "' and cropfishcode='" + CommonStaticClass.cropfishcode
					+ "'";
		} else if (!CommonStaticClass.isMember)
			sql = "Select "
					+ qName
					+ " from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId + "'";
		else
			sql = "Select "
					+ qName
					+ " from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId
					+ "' and memberid=" + CommonStaticClass.memberID;
		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				doFillFrmText(mCursor1, infoText);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}

		prevButton = (Button) v.findViewById(R.id.prevButton);
		prevButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		saveNxtButton = (Button) v.findViewById(R.id.saveNxtButton);

		saveNxtButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				updateTableDataFrmText();

			}

		});
		clButton = (Button) v.findViewById(R.id.clButton);
		clButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) v);
			}

		});
		notesButton = (Button) v.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});

	}

	private void doFillFrmText(Cursor mCursor1, EditText infoText) {
		// TODO Auto-generated method stub
		if (mCursor1.moveToFirst()) {
			do {
				String column = qName;

				if (mCursor1.getColumnIndex(column) != -1) {
					String a = mCursor1.getString(mCursor1
							.getColumnIndex(qName)) + "";

					/*
					 * if (qName.equalsIgnoreCase("q1_3")) { if
					 * (a.equalsIgnoreCase("null")) {
					 * infoText.setText(dbHelper.GetSingleColumnData("q3")); }
					 * else { infoText.setText(dbHelper
					 * .GetSingleColumnData("q1_3"));
					 * 
					 * }
					 * 
					 * } else
					 */
					infoText.setText((a.length() > 0
							&& (!a.equalsIgnoreCase("-1")) && (!a
							.equalsIgnoreCase("null"))) ? a : "");

				}
			} while (mCursor1.moveToNext());
		}
	}

	private void updateTableDataFrmText() {
		// TODO Auto-generated method stub
		String qAns = infoText.getText().toString().trim();
		if (qAns.length() > 0) {

			if (qName.equalsIgnoreCase("c1_2"))
				setTitle("Child Name :: " + qAns);

			String sql = "";
			if (qName.equalsIgnoreCase("g51212aOther")
					|| qName.equalsIgnoreCase("g51213aOther")) {
				sql = "UPDATE "
						+ CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getTablename()
						+ " SET " + qName + "='" + qAns + "' where dataid='"
						+ CommonStaticClass.dataId + "'and cropfishcode='"
						+ CommonStaticClass.cropfishcode + "'";
			} else if (!CommonStaticClass.isMember)
				sql = "UPDATE "
						+ CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getTablename()
						+ " SET " + qName + "='" + qAns + "' where dataid='"
						+ CommonStaticClass.dataId + "'";
			else
				sql = "UPDATE "
						+ CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getTablename()
						+ " SET " + qName + "='" + qAns + "' where dataid='"
						+ CommonStaticClass.dataId + "' and memberid="
						+ CommonStaticClass.memberID;
			if (dbHelper.executeDMLQuery(sql)) {
				if (CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar()
						.equalsIgnoreCase("GISID")) {

					showUserFinishDialogFrmText();

				} else if (CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQnext1()
						.equalsIgnoreCase("END")) {
					showUserFinishDialogFrmText();
				} else {
					// preserveState();
					CommonStaticClass.findOutNextSLNo(
							qName,
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQnext1());
					CommonStaticClass.nextQuestion(ParentActivity.this);
				}
			}
		} else {
			CommonStaticClass.showMyAlert(con, "Message", "Please input data.");
		}
	}

	private boolean IfCompletedAllMembersFrmText() {
		boolean IsCompleted = true;
		String sql1 = "Select * from tblMainQues  where dataid='"
				+ CommonStaticClass.dataId + "'";
		String sql2 = "Select * from tblFamilyMember  where dataid='"
				+ CommonStaticClass.dataId
				+ "' and (anysick=1 or visitdoc=1 or hospitalized=1)";
		Cursor mCursor1 = null;
		Cursor mCursor2 = null;
		try {

			mCursor1 = dbHelper.getQueryCursor(sql1);
			mCursor2 = dbHelper.getQueryCursor(sql2);

			int a = mCursor1.getCount();
			int b = mCursor2.getCount();
			String x = Integer.toString(a);
			String y = Integer.toString(b);
			if (x.equalsIgnoreCase(y))
				IsCompleted = true;
			else
				IsCompleted = false;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}

		return IsCompleted;
	}

	private void showUserFinishDialogFrmText() {
		// get prompts.xml view
		LayoutInflater li = LayoutInflater.from(con);
		LinearLayout promptsView = (LinearLayout) li.inflate(R.layout.prompts,
				null);

		promptsView.removeView((EditText) promptsView
				.findViewById(R.id.editTextDialogUserInput));

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(con);

		// set prompts.xml to alertdialog builder
		alertDialogBuilder.setView(promptsView);

		final TextView textInfo = (TextView) promptsView
				.findViewById(R.id.textView1);
		textInfo.setText("Do u want to finish this cycle?");

		// set dialog message
		alertDialogBuilder
				.setCancelable(false)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

						CommonStaticClass.findOutNextSLNo(
								qName,
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQnext1());
						CommonStaticClass.nextQuestion(ParentActivity.this);

					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();
	}

	private boolean characterCheckingFrmText(String qAns) {
		boolean allch = true;
		String a = qAns.toLowerCase();
		char[] cArray = a.toCharArray();
		for (char c : cArray) {
			if (c == ' ' || c == '.') {
				continue;
			}
			if (c < 'a' || c > 'z') {
				allch = false;
				return allch;
			}
		}
		return allch;
	}

	// FrmTime part
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case TIME_DIALOG:
			return new TimePickerDialog(this, timeSetListener, TimeHour,
					TimeMinute, true);
		case DATE_DIALOG:
			return new DatePickerDialog(this, dateSetListener, dateYear,
					dateMonth, dateDay);

		case DOB_DIALOG:
			return new DatePickerDialog(this, dateSetListener, dobYear,
					dobMonth, dobDay);

		case DATE_DIALOG_ID:

			DatePickerDialog datePickerDialog = this.customDatePicker();
			return datePickerDialog;

			/*
			 * return new DatePickerDialog(this, dateSetListener, dateYear,
			 * dateMonth, dateDay);
			 */

		}

		return null;
	}

	private DatePickerDialog customDatePicker() {
		DatePickerDialog dpd = new DatePickerDialog(this, dateSetListener,
				dateYear, dateMonth, dateDay);
		try {

			Field[] datePickerDialogFields = dpd.getClass().getDeclaredFields();
			for (Field datePickerDialogField : datePickerDialogFields) {
				if (datePickerDialogField.getName().equals("mDatePicker")) {
					datePickerDialogField.setAccessible(true);
					DatePicker datePicker = (DatePicker) datePickerDialogField
							.get(dpd);
					Field datePickerFields[] = datePickerDialogField.getType()
							.getDeclaredFields();
					for (Field datePickerField : datePickerFields) {
						if ("mDayPicker".equals(datePickerField.getName())
								|| "mDaySpinner".equals(datePickerField
										.getName())) {
							datePickerField.setAccessible(true);
							Object dayPicker = new Object();
							dayPicker = datePickerField.get(datePicker);
							((View) dayPicker).setVisibility(View.GONE);
						}
					}
				}

			}
		} catch (Exception ex) {
		}
		return dpd;
	}

	protected void onPrepareDialog(int id, Dialog dialog) {
		switch (id) {
		case TIME_DIALOG:
			((TimePickerDialog) dialog).updateTime(TimeHour, TimeMinute);
			break;
		case DATE_DIALOG:
			((DatePickerDialog) dialog)
					.updateDate(dateYear, dateMonth, dateDay);

		case DATE_DIALOG_ID:
			((DatePickerDialog) dialog)
					.updateDate(dateYear, dateMonth, dateDay);

			break;
		}
	}

	private TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {

		public void onTimeSet(TimePicker view, int hour, int minute) {
			TimeHour = hour;
			TimeMinute = minute;
			if (qName.length() > 0) {
				if (qName.equalsIgnoreCase("q17hmd1")
						|| qName.equalsIgnoreCase("q18md1")
						|| qName.equalsIgnoreCase("q17hmd2")
						|| qName.equalsIgnoreCase("q18md2")) {
					// updateDisplayfrmfamily("time");
					return;
				}
			}

			updateDisplay("time");
		}
	};

	private void loadGuiFrmTime(final ViewGroup v) {
		// TODO Auto-generated method stub
		qqq = (TextView) v.findViewById(R.id.qqq);

		// Load Question
		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		pickTime = (EditText) v.findViewById(R.id.pickTime);

		final Calendar c = Calendar.getInstance();
		TimeHour = c.get(Calendar.HOUR_OF_DAY);
		TimeMinute = c.get(Calendar.MINUTE);
		updateDisplay("time");

		prevButton = (Button) v.findViewById(R.id.prevButton);
		prevButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});

		// if(CommonStaticClass.mode.equalsIgnoreCase(CommonStaticClass.EDITMODE)){
		// String sql =
		// "Select "+CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo).getQvar()+" from "+CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo).getTablename()+" where dataid='"+CommonStaticClass.dataId+"'";
		String sql = "";
		if (!CommonStaticClass.isMember)
			sql = "Select * from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId + "'";
		else
			sql = "Select * from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId
					+ "' and memberid=" + CommonStaticClass.memberID;

		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.moveToFirst()) {
				do {
					String column = CommonStaticClass.questionMap
							.get(CommonStaticClass.currentSLNo).getQvar()
							.toLowerCase();
					if (mCursor1.getColumnIndex(column) != -1) {
						String res = mCursor1.getString(mCursor1
								.getColumnIndex(column));
						pickTime.setText((res.length() > 0 && !res
								.equalsIgnoreCase("null")) ? res : "");
					}
				} while (mCursor1.moveToNext());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}
		// }

		pickTime.setOnTouchListener(new View.OnTouchListener() {

			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				showDialog(TIME_DIALOG);
				return false;
			}
		});

		saveNxtButton = (Button) v.findViewById(R.id.saveNxtButton);

		saveNxtButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateTableDataFrmTime();
				// preserveState();
			}

		});
		clButton = (Button) v.findViewById(R.id.clButton);
		clButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) v);
			}

		});
		notesButton = (Button) v.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});

	}

	private void updateTableDataFrmTime() {
		// TODO Auto-generated method stub
		String qAns = pickTime.getText().toString();
		String currentQuestion = CommonStaticClass.questionMap.get(
				CommonStaticClass.currentSLNo).getQvar();
		if (qAns.length() > 0) {

			// if(futureDateValidator(dateYear, dateMonth, dateDay)){
			// CommonStaticClass.showMyAlert(con, "Not Correct",
			// "You are putting future date which is not acceptable");
			// return;
			// }

			String sql = "";
			if (!CommonStaticClass.isMember)
				sql = "UPDATE "
						+ CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getTablename()
						+ " SET " + currentQuestion + "='" + qAns
						+ "' where dataid='" + CommonStaticClass.dataId + "'";
			else
				sql = "UPDATE "
						+ CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getTablename()
						+ " SET " + currentQuestion + "='" + qAns
						+ "' where dataid='" + CommonStaticClass.dataId
						+ "' and memberid=" + CommonStaticClass.memberID;

			if (dbHelper.executeDMLQuery(sql)) {
				CommonStaticClass.findOutNextSLNo(
						CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getQvar(),
						CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getQnext1());
				CommonStaticClass.nextQuestion(ParentActivity.this);
			}
		}
	}

	// FrmYearToMin part
	private void loadGuiFrmYearToMin(final ViewGroup v) {
		// TODO Auto-generated method stub
		qqq = (TextView) v.findViewById(R.id.qqq);
		yearText = (TextView) v.findViewById(R.id.yearText);
		monthText = (TextView) v.findViewById(R.id.monthText);
		weekText = (TextView) v.findViewById(R.id.weekText);
		dayText = (TextView) v.findViewById(R.id.dayText);
		hourText = (TextView) v.findViewById(R.id.hourText);
		minText = (TextView) v.findViewById(R.id.minText);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
				yearText.setTypeface(font);
				monthText.setTypeface(font);
				weekText.setTypeface(font);
				dayText.setTypeface(font);
				hourText.setTypeface(font);
				minText.setTypeface(font);

				weekText.setText("mßvn");
				yearText.setText("eQi");
				monthText.setText("gvm");
				dayText.setText("w`b");
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {

			yearText.setText("Year");
			monthText.setText("Months");
			dayText.setText("Days");
			weekText.setText("Weeks");
			yearText.setTypeface(null);
			monthText.setTypeface(null);
			weekText.setTypeface(null);
			dayText.setTypeface(null);
			hourText.setTypeface(null);
			minText.setTypeface(null);
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		prevButton = (Button) v.findViewById(R.id.prevButton);
		prevButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		saveNxtButton = (Button) v.findViewById(R.id.saveNxtButton);

		saveNxtButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				// if(IsValid())
				updateTableDataFrmYearToMin();

			}

		});
		clButton = (Button) v.findViewById(R.id.clButton);

		clButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) v);
			}

		});
		notesButton = (Button) v.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});

		yearHolder = (LinearLayout) v.findViewById(R.id.yearHolder);
		monthHolder = (LinearLayout) v.findViewById(R.id.monthHolder);
		weekHolder = (LinearLayout) v.findViewById(R.id.weekHolder);
		dayHolder = (LinearLayout) v.findViewById(R.id.dayHolder);
		hourHolder = (LinearLayout) v.findViewById(R.id.hourHolder);
		minHolder = (LinearLayout) v.findViewById(R.id.minHolder);

		yearBox = (EditText) v.findViewById(R.id.yearBox);
		monthBox = (EditText) v.findViewById(R.id.monthBox);
		weekBox = (EditText) v.findViewById(R.id.weekBox);
		dayBox = (EditText) v.findViewById(R.id.dayBox);
		hourBox = (EditText) v.findViewById(R.id.hourBox);
		minBox = (EditText) v.findViewById(R.id.minBox);

		String sql = "Select * from "
				+ CommonStaticClass.questionMap.get(
						CommonStaticClass.currentSLNo).getTablename()
				+ " where dataid='" + CommonStaticClass.dataId + "'";
		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.moveToFirst()) {
				do {
					String weekColumn = CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar()
							+ "weeks";

					String yearColumn = CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar()
							+ "years";
					String monthColumn = CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar()
							+ "months";
					String dayColumn = CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar()
							+ "days";
					String hourColumn = CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar()
							+ "hours";
					String minColumn = CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar()
							+ "mins";

					if (mCursor1.getColumnIndex(weekColumn) != -1) {
						weekHolder.setVisibility(View.VISIBLE);
						int y = mCursor1.getInt(mCursor1
								.getColumnIndex(CommonStaticClass.questionMap
										.get(CommonStaticClass.currentSLNo)
										.getQvar()
										+ "weeks"));
						if (y > 0) {
							weekBox.setText(y + "");
						} else {
							weekBox.setText("0");
						}
					}

					if (mCursor1.getColumnIndex(yearColumn) != -1) {
						yearHolder.setVisibility(View.VISIBLE);
						int y = mCursor1.getInt(mCursor1
								.getColumnIndex(CommonStaticClass.questionMap
										.get(CommonStaticClass.currentSLNo)
										.getQvar()
										+ "years"));
						if (y > 0) {
							yearBox.setText(y + "");
						} else {
							yearBox.setText("");
						}
					}
					if (mCursor1.getColumnIndex(monthColumn) != -1) {
						monthHolder.setVisibility(View.VISIBLE);
						int m = mCursor1.getInt(mCursor1
								.getColumnIndex(CommonStaticClass.questionMap
										.get(CommonStaticClass.currentSLNo)
										.getQvar()
										+ "months"));
						if (m > 0) {
							monthBox.setText(m + "");
						} else {
							monthBox.setText("");
						}
					}
					if (mCursor1.getColumnIndex(dayColumn) != -1) {
						int d = mCursor1.getInt(mCursor1
								.getColumnIndex(CommonStaticClass.questionMap
										.get(CommonStaticClass.currentSLNo)
										.getQvar()
										+ "days"));
						if (d > 0) {
							dayBox.setText(d + "");
						} else {
							dayBox.setText("");
						}
					}
					if (mCursor1.getColumnIndex(hourColumn) != -1) {
						int h = mCursor1.getInt(mCursor1
								.getColumnIndex(CommonStaticClass.questionMap
										.get(CommonStaticClass.currentSLNo)
										.getQvar()
										+ "hours"));
						if (h > 0) {
							hourBox.setText(h + "");
						} else {
							hourBox.setText("");
						}
					}
					if (mCursor1.getColumnIndex(minColumn) != -1) {
						int m = mCursor1.getInt(mCursor1
								.getColumnIndex(CommonStaticClass.questionMap
										.get(CommonStaticClass.currentSLNo)
										.getQvar()
										+ "mins"));
						if (m > 0) {
							minBox.setText(m + "");
						} else {
							minBox.setText("");
						}
					}

					/*
					 * if (!CommonStaticClass.questionMap
					 * .get(CommonStaticClass.currentSLNo).getQvar()
					 * .equalsIgnoreCase("c1_3")) {
					 * 
					 * monthHolder.setVisibility(View.VISIBLE);
					 * dayHolder.setVisibility(View.VISIBLE); }
					 * 
					 * if (CommonStaticClass.questionMap
					 * .get(CommonStaticClass.currentSLNo).getQvar()
					 * .equalsIgnoreCase("c1_3")) {
					 * monthHolder.setVisibility(View.VISIBLE);
					 * dayHolder.setVisibility(View.VISIBLE);
					 * 
					 * }
					 */
					// yearHolder.setVisibility(View.VISIBLE);
				} while (mCursor1.moveToNext());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}

		op = CommonStaticClass.findOptionsForThisQuestion(dbHelper,
				CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar());

		for (int i = 0; i < op.capEngList.size(); i++) {
			if (op.qidList.get(i).contains("weeks")) {
				weekHolder.setVisibility(View.VISIBLE);
				if (CommonStaticClass.langBng) {
					weekText.setText(op.capBngList.get(i).length() > 0 ? op.capBngList
							.get(i) : op.capEngList.get(i));
				} else {
					weekText.setText(op.capEngList.get(i));
				}
			}

			if (op.qidList.get(i).contains("years")) {
				yearHolder.setVisibility(View.VISIBLE);
				if (CommonStaticClass.langBng) {
					yearText.setText(op.capBngList.get(i).length() > 0 ? op.capBngList
							.get(i) : op.capEngList.get(i));
				} else {
					yearText.setText(op.capEngList.get(i));
				}
			}
			if (op.qidList.get(i).contains("months")) {
				monthHolder.setVisibility(View.VISIBLE);
				if (CommonStaticClass.langBng) {
					monthText
							.setText(op.capBngList.get(i).length() > 0 ? op.capBngList
									.get(i) : op.capEngList.get(i));
				} else {
					monthText.setText(op.capEngList.get(i));
				}
			}
			if (op.qidList.get(i).contains("weeks")) {
				weekHolder.setVisibility(View.VISIBLE);
				if (CommonStaticClass.langBng) {
					weekText.setText(op.capBngList.get(i).length() > 0 ? op.capBngList
							.get(i) : op.capEngList.get(i));
				} else {
					weekText.setText(op.capEngList.get(i));
				}
			}
			if (op.qidList.get(i).contains("days")) {
				dayHolder.setVisibility(View.VISIBLE);
				if (CommonStaticClass.langBng) {
					dayText.setText(op.capBngList.get(i).length() > 0 ? op.capBngList
							.get(i) : op.capEngList.get(i));
				} else {
					dayText.setText(op.capEngList.get(i));
				}
			}
			if (op.qidList.get(i).contains("hours")) {
				hourHolder.setVisibility(View.VISIBLE);
				if (CommonStaticClass.langBng) {
					hourText.setText(op.capBngList.get(i).length() > 0 ? op.capBngList
							.get(i) : op.capEngList.get(i));
				} else {
					hourText.setText(op.capEngList.get(i));
				}
			}
			if (op.qidList.get(i).contains("mins")) {
				minHolder.setVisibility(View.VISIBLE);

				if (CommonStaticClass.langBng) {
					minText.setText(op.capBngList.get(i).length() > 0 ? op.capBngList
							.get(i) : op.capEngList.get(i));
				} else {
					minText.setText(op.capEngList.get(i));
				}
			}
		}

		// c606

		if (CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo)
				.getQvar().equalsIgnoreCase("q4")) {
			monthBox.addTextChangedListener(new TextWatcher() {

				public void onTextChanged(CharSequence s, int start,
						int before, int count) {

					if (s.length() > 0) {
						if (s.toString() != "") {
							yearBox.setText("");
						}
					}

				}

				public void beforeTextChanged(CharSequence s, int start,
						int count, int after) { // TODO Auto-generated method
												// stub

				}

				public void afterTextChanged(Editable s) { // TODO
															// Auto-generated

				}
			});

			yearBox.addTextChangedListener(new TextWatcher() {

				public void onTextChanged(CharSequence s, int start,
						int before, int count) {

					if (s.length() > 0) {
						if (s.toString() != "") {
							monthBox.setText("");
						}
					}

				}

				public void beforeTextChanged(CharSequence s, int start,
						int count, int after) { // TODO Auto-generated method
												// stub

				}

				public void afterTextChanged(Editable s) { // TODO
															// Auto-generated

				}
			});

		}

		//
		if (CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo)
				.getQvar().equalsIgnoreCase("c607b")) {
			monthBox.addTextChangedListener(new TextWatcher() {

				public void onTextChanged(CharSequence s, int start,
						int before, int count) {

					if (s.length() > 0) {
						if (s.toString() != "") {
							dayBox.setText("");
						}
					}

				}

				public void beforeTextChanged(CharSequence s, int start,
						int count, int after) {
					// TODO Auto-generated method stub

				}

				public void afterTextChanged(Editable s) {
					// TODO Auto-generated method stub

				}
			});

			dayBox.addTextChangedListener(new TextWatcher() {

				public void onTextChanged(CharSequence s, int start,
						int before, int count) {

					if (s.length() > 0) {
						if (s.toString() != "") {
							monthBox.setText("");
						}
					}

				}

				public void beforeTextChanged(CharSequence s, int start,
						int count, int after) {
					// TODO Auto-generated method stub

				}

				public void afterTextChanged(Editable s) {
					// TODO Auto-generated method stub

				}
			});

		}

		// q1_3
		if (CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo)
				.getQvar().equalsIgnoreCase("c1_3")) {
			monthBox.addTextChangedListener(new TextWatcher() {

				public void onTextChanged(CharSequence s, int start,
						int before, int count) {

					/*
					 * if (s.length() > 0) { if (s.toString() != "") {
					 * dayBox.setText(""); if(Integer.parseInt(s.toString())>=1
					 * && Integer.parseInt(s.toString())<=36) {
					 * 
					 * } else { if(s.toString().length()==2) {
					 * CommonStaticClass.showMyAlert(con, "Message",
					 * "Month should be between 1 to 36"); monthBox.setText("");
					 * monthBox.requestFocus(); return; } } } }
					 */

				}

				public void beforeTextChanged(CharSequence s, int start,
						int count, int after) {
					// TODO Auto-generated method stub

				}

				public void afterTextChanged(Editable s) {

				}
			});

			dayBox.addTextChangedListener(new TextWatcher() {

				public void onTextChanged(CharSequence s, int start,
						int before, int count) {

					/*
					 * if (s.length() > 0) { if (s.toString() != "") {
					 * monthBox.setText("");
					 * 
					 * if(Integer.parseInt(s.toString())>=1 &&
					 * Integer.parseInt(s.toString())<=30) {
					 * 
					 * } else { if(s.toString().length()==2) {
					 * CommonStaticClass.showMyAlert(con, "Message",
					 * "Day should be between 1 to 30"); dayBox.setText("");
					 * dayBox.requestFocus(); return; } }
					 * 
					 * } }
					 */

				}

				public void beforeTextChanged(CharSequence s, int start,
						int count, int after) {
					// TODO Auto-generated method stub

				}

				public void afterTextChanged(Editable s) {

				}
			});

		}
	}

	private boolean IsValidFrmYearToMin() {
		String sql = "";
		Cursor mCursor1 = null;

		if (CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo)
				.getQvar().equalsIgnoreCase("q29")
				|| CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar()
						.equalsIgnoreCase("q30")) {

			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQvar()
					.equalsIgnoreCase("q29")) {
				sql = "select * from tblMainQues where dataid='"
						+ CommonStaticClass.dataId + "'";
				mCursor1 = dbHelper.getQueryCursor(sql);
				CommonStaticClass
						.showMyAlert(
								con,
								"Not Correct",
								""
										+ mCursor1.getString(mCursor1
												.getColumnIndex("q12")));

			} else if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQvar()
					.equalsIgnoreCase("q30")) {
				sql = "select * from tblMainQuesMc where dataid='"
						+ CommonStaticClass.dataId + "'";
				mCursor1 = dbHelper.getQueryCursor(sql);
				// CommonStaticClass.showMyAlert(con, "Not Correct",
				// "Wrong year, must be less than qustion 29."+
				// yearBox.getText().toString());
				if (Integer.parseInt(yearBox.getText().toString()) >= Integer
						.parseInt(mCursor1.getString(mCursor1
								.getColumnIndex("q29years")))) {
					CommonStaticClass.showMyAlert(con, "Not Correct",
							"Wrong year, must be less than qustion 29.");
					return false;
				}
			}
		}

		return true;
	}

	private void updateTableDataFrmYearToMin() {
		Cursor mCursor = null;
		// TODO Auto-generated method stub
		/*
		 * if (yearHolder.getVisibility() == View.VISIBLE) { if
		 * (!(yearBox.getText().toString().length() > 0)) {
		 * CommonStaticClass.showMyAlert(con, "Error",
		 * "You must provide correct data to proceed"); return; } }
		 */

		if ((yearBox.getText().toString().length() <= 0)
				&& (monthBox.getText().toString().length() <= 0)) {
			CommonStaticClass.showMyAlert(con, "Error",
					"You must provide correct data to proceed");
			return;
		}

		if (CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo)
				.getQvar().equalsIgnoreCase("c1_3")) {

			if (monthBox.getText().toString().length() == 0
					&& dayBox.getText().toString().length() == 0) {
				CommonStaticClass.showMyAlert(con, "Message",
						"You must provide correct data to proceed");
				monthBox.requestFocus();
				return;
			}
			/*
			 * if (monthHolder.getVisibility() == View.VISIBLE) { if
			 * ((monthBox.getText().toString().length() > 0)) {
			 * 
			 * CommonStaticClass.showMyAlert(con, "Error",
			 * "You must provide correct data to proceed"); return; }
			 * 
			 * 
			 * if (Integer.parseInt(monthBox.getText().toString()) >= 1 &&
			 * Integer.parseInt(monthBox.getText().toString()) <= 36) {
			 * 
			 * } else { CommonStaticClass.showMyAlert(con, "Message",
			 * "Month should be between 1 to 36"); monthBox.setText("");
			 * monthBox.requestFocus(); return; } }
			 * 
			 * }
			 */

			if (dayHolder.getVisibility() == View.VISIBLE) {
				if ((dayBox.getText().toString().length() > 0)) {
					/*
					 * CommonStaticClass.showMyAlert(con, "Error",
					 * "You must provide correct data to proceed"); return; }
					 */

					if (Integer.parseInt(dayBox.getText().toString()) >= 1
							&& Integer.parseInt(dayBox.getText().toString()) <= 30) {

					} else {
						CommonStaticClass.showMyAlert(con, "Message",
								"Day should be between 1 to 30");
						dayBox.setText("");
						dayBox.requestFocus();
						return;
					}
				}
			}

		}

		if (CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo)
				.getQvar().equalsIgnoreCase("c607b")) {

			if (monthHolder.getVisibility() == View.VISIBLE
					|| dayHolder.getVisibility() == View.VISIBLE) {
				if (!(monthBox.getText().toString().length() > 0)
						&& !(dayBox.getText().toString().length() > 0)) {
					CommonStaticClass.showMyAlert(con, "Error",
							"You must provide correct data to proceed");
					return;
				}

				if (monthHolder.getVisibility() == View.VISIBLE) {
					if ((monthBox.getText().toString().length() > 0)) {
						/*
						 * CommonStaticClass.showMyAlert(con, "Error",
						 * "You must provide correct data to proceed"); return;
						 * }
						 */

						if ((Integer.parseInt(monthBox.getText().toString()) >= 1 && Integer
								.parseInt(monthBox.getText().toString()) <= 36)
								|| Integer.parseInt(monthBox.getText()
										.toString()) == 99) {

						} else {
							CommonStaticClass.showMyAlert(con, "Message",
									"Month should be between 1 to 36");
							monthBox.setText("");
							monthBox.requestFocus();
							return;
						}
					}

				}

				if (dayHolder.getVisibility() == View.VISIBLE) {
					if ((dayBox.getText().toString().length() > 0)) {
						/*
						 * CommonStaticClass.showMyAlert(con, "Error",
						 * "You must provide correct data to proceed"); return;
						 * }
						 */

						if ((Integer.parseInt(dayBox.getText().toString()) >= 1 && Integer
								.parseInt(dayBox.getText().toString()) <= 30)
								|| Integer
										.parseInt(dayBox.getText().toString()) == 99) {

						} else {
							CommonStaticClass.showMyAlert(con, "Message",
									"Day should be between 1 to 30");
							dayBox.setText("");
							dayBox.requestFocus();
							return;
						}
					}
				}

			}

		}

		if (monthHolder.getVisibility() == View.VISIBLE) {
			if ((monthBox.getText().toString().length() > 0)) {

				if ((Integer.parseInt(monthBox.getText().toString()) >= 0 && Integer
						.parseInt(monthBox.getText().toString()) <= 48)) {

				} else {
					CommonStaticClass.showMyAlert(con, "Message",
							"Month should be between 1 to 48");
					monthBox.setText("");
					monthBox.requestFocus();
					return;
				}
			}

		}

		if (yearHolder.getVisibility() == View.VISIBLE) {
			if ((yearBox.getText().toString().length() > 0)) {

				if ((Integer.parseInt(yearBox.getText().toString()) >= 5 && Integer
						.parseInt(yearBox.getText().toString()) <= 99)) {

				} else {
					CommonStaticClass.showMyAlert(con, "Message",
							"Year should be between 5 to 99");
					yearBox.setText("");
					yearBox.requestFocus();
					return;
				}
			}

		}

		// c606
		if (CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo)
				.getQvar().equalsIgnoreCase("c606")) {

			if (monthHolder.getVisibility() == View.VISIBLE
					|| dayHolder.getVisibility() == View.VISIBLE) {
				if (!(monthBox.getText().toString().length() > 0)
						&& !(dayBox.getText().toString().length() > 0)) {
					CommonStaticClass.showMyAlert(con, "Error",
							"You must provide correct data to proceed");
					return;
				}

				if (monthHolder.getVisibility() == View.VISIBLE) {
					if ((monthBox.getText().toString().length() > 0)) {

						if ((Integer.parseInt(monthBox.getText().toString()) >= 1 && Integer
								.parseInt(monthBox.getText().toString()) <= 36)
								|| Integer.parseInt(monthBox.getText()
										.toString()) == 99) {

						} else {
							CommonStaticClass.showMyAlert(con, "Message",
									"Month should be between 1 to 36");
							monthBox.setText("");
							monthBox.requestFocus();
							return;
						}
					}

				}

				if (dayHolder.getVisibility() == View.VISIBLE) {
					if ((dayBox.getText().toString().length() > 0)) {

						if ((Integer.parseInt(dayBox.getText().toString()) >= 0 && Integer
								.parseInt(dayBox.getText().toString()) <= 29)
								|| Integer
										.parseInt(dayBox.getText().toString()) == 99) {

						} else {
							CommonStaticClass.showMyAlert(con, "Message",
									"Day should be between 1 to 30");
							dayBox.setText("");
							dayBox.requestFocus();
							return;
						}
					}
				}

			}

		}

		if (weekHolder.getVisibility() == View.VISIBLE) {
			if (!(weekBox.getText().toString().length() > 0)) {
				CommonStaticClass.showMyAlert(con, "Error",
						"You must provide correct data to proceed");
				return;
			}
		}
		if (hourHolder.getVisibility() == View.VISIBLE) {
			if (!(hourBox.getText().toString().length() > 0)) {
				CommonStaticClass.showMyAlert(con, "Error",
						"You must provide correct data to proceed");
				return;
			}
		}
		if (minHolder.getVisibility() == View.VISIBLE) {
			if (!(minBox.getText().toString().length() > 0)) {
				CommonStaticClass.showMyAlert(con, "Error",
						"You must provide correct data to proceed");
				return;
			}
		}
		String qName = CommonStaticClass.questionMap.get(
				CommonStaticClass.currentSLNo).getQvar();
		if (qName.equalsIgnoreCase("q201")) {
			if (!(yearBox.getText().toString().length() > 0)
					&& !(monthBox.getText().toString().length() > 0)) {
				CommonStaticClass.showMyAlert(con, "Error",
						"You must give data to proceed");
				return;
			}
		}
		if (qName.equalsIgnoreCase("q204")) {
			if (!(dayBox.getText().toString().length() > 0)
					&& !(yearBox.getText().toString().length() > 0)
					&& !(monthBox.getText().toString().length() > 0)) {
				CommonStaticClass.showMyAlert(con, "Error",
						"You must give data to proceed");
				return;
			}
		}
		String sql = "";

		sql = "UPDATE "
				+ CommonStaticClass.questionMap.get(
						CommonStaticClass.currentSLNo).getTablename() + " SET ";
		int i = 0;
		// +CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo).getQvar()+"='"+code+"' where dataid='"+CommonStaticClass.dataId+"'";
		if (yearHolder.getVisibility() == View.VISIBLE) {
			year = yearBox.getText().toString();
			sql += CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQvar()
					+ "years = '" + year + "'";
			i++;
		}
		if (monthHolder.getVisibility() == View.VISIBLE) {
			month = monthBox.getText().toString();
			if (month.equalsIgnoreCase("88") && qName.equalsIgnoreCase("q221")) {
				CommonStaticClass.qskipList.add("q1003");
			}
			sql += (i > 0 ? "," : "")
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar()
					+ "months = '" + month + "'";
			i++;
		}
		if (weekHolder.getVisibility() == View.VISIBLE) {
			week = weekBox.getText().toString();
			sql += (i > 0 ? "," : "")
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar()
					+ "weeks = '" + week + "'";
			i++;
		}
		if (dayHolder.getVisibility() == View.VISIBLE) {
			day = dayBox.getText().toString();
			sql += (i > 0 ? "," : "")
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar()
					+ "days = '" + day + "'";
			i++;
		}
		if (hourHolder.getVisibility() == View.VISIBLE) {
			hour = hourBox.getText().toString();
			sql += (i > 0 ? "," : "")
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar()
					+ "hours = '" + hour + "'";
			i++;
		}
		if (minHolder.getVisibility() == View.VISIBLE) {
			min = minBox.getText().toString();
			sql += (i > 0 ? "," : "")
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar()
					+ "mins = '" + min + "'";
			i++;
		}
		sql += "where dataid='" + CommonStaticClass.dataId + "'";

		if (qName.equalsIgnoreCase("q30")) {
			mCursor = dbHelper.getQueryCursor(sql);
			if (mCursor.moveToFirst()) {
				if (Integer.parseInt(year) > Integer.parseInt(mCursor
						.getString(mCursor.getColumnIndex("q29years")))) {
					CommonStaticClass.showMyAlert(con, "Error",
							"Wrong year, must be less than qustion 29");
				} else if (Integer.parseInt(year) == Integer.parseInt(mCursor
						.getString(mCursor.getColumnIndex("q29years")))
						&& Integer.parseInt(month) > Integer
								.parseInt(mCursor.getString(mCursor
										.getColumnIndex("q29months")))) {
					CommonStaticClass.showMyAlert(con, "Error",
							"Wrong year, must be less than qustion 29");
				} else if (Integer.parseInt(year) == Integer.parseInt(mCursor
						.getString(mCursor.getColumnIndex("q29years")))
						&& Integer.parseInt(month) == Integer
								.parseInt(mCursor.getString(mCursor
										.getColumnIndex("q29months")))
						&& Integer.parseInt(day) > Integer.parseInt(mCursor
								.getString(mCursor.getColumnIndex("q29days")))) {
					CommonStaticClass.showMyAlert(con, "Error",
							"Wrong year, must be less than qustion 29");
				}
			}
		}

		if (dbHelper.executeDMLQuery(sql)) {

			monthText.setText("");
			dayText.setText("");
			CommonStaticClass.findOutNextSLNo(
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQvar(),
					CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQnext1());
			CommonStaticClass.nextQuestion(ParentActivity.this);
		}

	}

	private static void resetViewGroup(ViewGroup viewGroup) {
		int nrOfChildren = viewGroup.getChildCount();
		for (int i = 0; i < nrOfChildren; i++) {
			View view = viewGroup.getChildAt(i);
			resetView(view);
			if (view instanceof ViewGroup) {
				resetViewGroup((ViewGroup) view);
			}
			if (view instanceof RadioGroup) {
				((RadioGroup) view).clearCheck();
			}
		}

	}

	private static void resetView(View view) {

		if (view instanceof Spinner) {
			((Spinner) view).setSelection(0);
		}

		if (view instanceof RadioButton) {
			((RadioButton) view).setChecked(false);
		}
		if (view instanceof CheckBox) {
			((CheckBox) view).setChecked(false);
		}
		if (view instanceof EditText) {
			((EditText) view).setText("");
		}
		if (view instanceof RadioGroup) {
			((RadioGroup) view).clearCheck();
		}
	}

	// Check for empty Field
	private static boolean CheckEmptyViewGroup(ViewGroup viewGroup) {
		int nrOfChildren = viewGroup.getChildCount();
		for (int i = 0; i < nrOfChildren; i++) {
			View view = viewGroup.getChildAt(i);
			if (view.getVisibility() == view.GONE)
				continue;

			if (CheckView(view) == false) {
				return false;
			}
			if (view instanceof ViewGroup) {
				if (CheckEmptyViewGroup((ViewGroup) view) == false) {
					return false;
				}
			}
			if (view instanceof RadioGroup) {
				if (((RadioGroup) view).getCheckedRadioButtonId() == -1) {
					return false;
				}

			}
		}
		return true;

	}

	private static boolean CheckView(View view) {

		if (view.getVisibility() == view.GONE)
			return true;

		if (view instanceof Spinner) {
			if (((Spinner) view).getSelectedItem().toString().length() == 0) {
				return false;

			}
		}

		/*
		 * if (view instanceof RadioButton) { ((RadioButton)
		 * view).setChecked(false); } if (view instanceof CheckBox) {
		 * ((CheckBox) view).setChecked(false); }
		 */
		if (view instanceof EditText) {
			if (((EditText) view).getText().length() == 0) {
				return false;
			}
		}

		return true;
	}

	boolean adjustForEdit = false;
	boolean adjustForSpinner = false;
	int allchecked = 0;

	private void CreateMultipleCheckCombotwoHeader1(final ViewGroup v) {
		// setting up the width for column header
		/*
		 * if (qName.equalsIgnoreCase("q65")) { ((TextView)
		 * v.findViewById(R.id.txtcustom1)) .setWidth((dm.widthPixels / 4) * 2);
		 * ((TextView) v.findViewById(R.id.txtcustom2))
		 * .setWidth((dm.widthPixels / 4)); ((TextView)
		 * v.findViewById(R.id.txtcustom3)) .setWidth((dm.widthPixels / 4)); //
		 * if (CommonStaticClass.langBng) { ((TextView)
		 * v.findViewById(R.id.txtcustom1)) .setText("RvqMvi bvg"); ((TextView)
		 * v.findViewById(R.id.txtcustom1)).setTypeface(font); ((TextView)
		 * v.findViewById(R.id.txtcustom2)) .setText("RevB Kiv"); ((TextView)
		 * v.findViewById(R.id.txtcustom2)).setTypeface(font); ((TextView)
		 * v.findViewById(R.id.txtcustom3)) .setText("c«wµqvRvZKib");
		 * ((TextView) v.findViewById(R.id.txtcustom3)).setTypeface(font); }
		 * else { ((TextView) v.findViewById(R.id.txtcustom1))
		 * .setText("Location"); ((TextView)
		 * v.findViewById(R.id.txtcustom1)).setTypeface(null); ((TextView)
		 * v.findViewById(R.id.txtcustom2)) .setText("Slaughtered"); ((TextView)
		 * v.findViewById(R.id.txtcustom2)).setTypeface(null); ((TextView)
		 * v.findViewById(R.id.txtcustom3)) .setText("Processed"); ((TextView)
		 * v.findViewById(R.id.txtcustom3)).setTypeface(null); } }
		 */

	}

	private void CreateMultipleCheckCombotwoHeader(final ViewGroup v) {
		// setting up the width for column header
		if (qName.equalsIgnoreCase("qincome")) {
			((TextView) v.findViewById(R.id.txtcustom1))
					.setWidth((dm.widthPixels / 5) * 2);
			((TextView) v.findViewById(R.id.txtcustom2))
					.setWidth((dm.widthPixels / 4));
			((TextView) v.findViewById(R.id.txtcustom3))
					.setWidth((dm.widthPixels / 4));
			((TextView) v.findViewById(R.id.txtcustom4))
					.setWidth((dm.widthPixels / 4));
			//
			if (CommonStaticClass.langBng) {
				((TextView) v.findViewById(R.id.txtcustom1)).setText("Drm");
				((TextView) v.findViewById(R.id.txtcustom1)).setTypeface(font);
				((TextView) v.findViewById(R.id.txtcustom2))
						.setText("gRyix kªg?");
				((TextView) v.findViewById(R.id.txtcustom2)).setTypeface(font);
				((TextView) v.findViewById(R.id.txtcustom3)).setText("KZw`b?");
				((TextView) v.findViewById(R.id.txtcustom3)).setTypeface(font);
				((TextView) v.findViewById(R.id.txtcustom4))
						.setText("Mo Avq ?");
				((TextView) v.findViewById(R.id.txtcustom4)).setTypeface(font);
			} else {
				((TextView) v.findViewById(R.id.txtcustom1)).setText("SOURCE");
				((TextView) v.findViewById(R.id.txtcustom1)).setTypeface(null);
				((TextView) v.findViewById(R.id.txtcustom2))
						.setText("WAGE LABOUR?");
				((TextView) v.findViewById(R.id.txtcustom2)).setTypeface(null);
				((TextView) v.findViewById(R.id.txtcustom3)).setText("DAYS?");
				((TextView) v.findViewById(R.id.txtcustom3)).setTypeface(null);
				((TextView) v.findViewById(R.id.txtcustom4)).setText("RATE?");
				((TextView) v.findViewById(R.id.txtcustom4)).setTypeface(null);
			}
		}

		if (qName.equalsIgnoreCase("qownedassets")) {
			((TextView) v.findViewById(R.id.txtcustom1))
					.setWidth((dm.widthPixels / 5) * 2);
			((TextView) v.findViewById(R.id.txtcustom2))
					.setWidth((dm.widthPixels / 4));
			((TextView) v.findViewById(R.id.txtcustom3))
					.setWidth((dm.widthPixels / 4));
			((TextView) v.findViewById(R.id.txtcustom4))
					.setWidth((dm.widthPixels / 4));
			//
			if (CommonStaticClass.langBng) {
				((TextView) v.findViewById(R.id.txtcustom1))
						.setText("m¤c‡`i bvg");
				((TextView) v.findViewById(R.id.txtcustom1)).setTypeface(font);
				((TextView) v.findViewById(R.id.txtcustom2))
						.setText("m¤c` Av‡Q?");
				((TextView) v.findViewById(R.id.txtcustom2)).setTypeface(font);
				((TextView) v.findViewById(R.id.txtcustom3)).setText("cwigvY");
				((TextView) v.findViewById(R.id.txtcustom3)).setTypeface(font);
				((TextView) v.findViewById(R.id.txtcustom4))
						.setText("Lvbvi Ask (kZvs‡k)");
				((TextView) v.findViewById(R.id.txtcustom4)).setTypeface(font);
			} else {
				((TextView) v.findViewById(R.id.txtcustom1))
						.setText("Name of asset");
				((TextView) v.findViewById(R.id.txtcustom1)).setTypeface(null);
				((TextView) v.findViewById(R.id.txtcustom2))
						.setText("have asset?");
				((TextView) v.findViewById(R.id.txtcustom2)).setTypeface(null);
				((TextView) v.findViewById(R.id.txtcustom3))
						.setText("Quantity");
				((TextView) v.findViewById(R.id.txtcustom3)).setTypeface(null);
				((TextView) v.findViewById(R.id.txtcustom4))
						.setText("share in %");
				((TextView) v.findViewById(R.id.txtcustom4)).setTypeface(null);
			}
		}
		if (qName.equalsIgnoreCase("qsavingsandloan")) {
			((TextView) v.findViewById(R.id.txtcustom1))
					.setWidth((dm.widthPixels / 5) * 2);
			((TextView) v.findViewById(R.id.txtcustom2))
					.setWidth((dm.widthPixels / 4));
			((TextView) v.findViewById(R.id.txtcustom3))
					.setWidth((dm.widthPixels / 4));
			((TextView) v.findViewById(R.id.txtcustom4))
					.setWidth((dm.widthPixels / 4));
			//
			if (CommonStaticClass.langBng) {
				((TextView) v.findViewById(R.id.txtcustom1))
						.setText("mÂq I FY");
				((TextView) v.findViewById(R.id.txtcustom1)).setTypeface(font);
				((TextView) v.findViewById(R.id.txtcustom2))
						.setText("mÂq/FY Av‡Q?");
				((TextView) v.findViewById(R.id.txtcustom2)).setTypeface(font);
				((TextView) v.findViewById(R.id.txtcustom3))
						.setText("mÂq/FY K‡iwQ‡jv?");
				((TextView) v.findViewById(R.id.txtcustom3)).setTypeface(font);
				((TextView) v.findViewById(R.id.txtcustom4))
						.setText("cwigvY KZ (UvKv)?");
				((TextView) v.findViewById(R.id.txtcustom4)).setTypeface(font);
			} else {
				((TextView) v.findViewById(R.id.txtcustom1))
						.setText("SAVINGS AND LOANS");
				((TextView) v.findViewById(R.id.txtcustom1)).setTypeface(null);
				((TextView) v.findViewById(R.id.txtcustom2))
						.setText("any savings/loan");
				((TextView) v.findViewById(R.id.txtcustom2)).setTypeface(null);
				((TextView) v.findViewById(R.id.txtcustom3))
						.setText("who saved/ lent");
				((TextView) v.findViewById(R.id.txtcustom3)).setTypeface(null);
				((TextView) v.findViewById(R.id.txtcustom4))
						.setText("amount in taka");
				((TextView) v.findViewById(R.id.txtcustom4)).setTypeface(null);
			}
		}

		if (qName.equalsIgnoreCase("qcurrentownedland")) {
			((TextView) v.findViewById(R.id.txtcustom1))
					.setWidth((dm.widthPixels / 5) * 2);
			((TextView) v.findViewById(R.id.txtcustom2))
					.setWidth((dm.widthPixels / 4));
			((TextView) v.findViewById(R.id.txtcustom3))
					.setWidth((dm.widthPixels / 4));
			//
			if (CommonStaticClass.langBng) {
				((TextView) v.findViewById(R.id.txtcustom1)).setText("");
				((TextView) v.findViewById(R.id.txtcustom1)).setTypeface(font);
				((TextView) v.findViewById(R.id.txtcustom2))
						.setText("Lvbvi wb‡Ri e¨eüZ");
				((TextView) v.findViewById(R.id.txtcustom2)).setTypeface(font);
				((TextView) v.findViewById(R.id.txtcustom3))
						.setText("evB‡ii Kv‡iv Kv‡Q fvov / wjR †`qv");
				((TextView) v.findViewById(R.id.txtcustom3)).setTypeface(font);
			} else {
				((TextView) v.findViewById(R.id.txtcustom1)).setText("");
				((TextView) v.findViewById(R.id.txtcustom1)).setTypeface(null);
				((TextView) v.findViewById(R.id.txtcustom2))
						.setText("Used by own household");
				((TextView) v.findViewById(R.id.txtcustom2)).setTypeface(null);
				((TextView) v.findViewById(R.id.txtcustom3))
						.setText("Leased out");
				((TextView) v.findViewById(R.id.txtcustom3)).setTypeface(null);
			}
		}

		if (qName.equalsIgnoreCase("k1") || qName.equalsIgnoreCase("k2")
				|| qName.equalsIgnoreCase("k3") || qName.equalsIgnoreCase("k4")
				|| qName.equalsIgnoreCase("k5") || qName.equalsIgnoreCase("k6")) {
			((TextView) v.findViewById(R.id.txtcustom1))
					.setWidth((dm.widthPixels / 4) * 2);
			((TextView) v.findViewById(R.id.txtcustom2))
					.setWidth((dm.widthPixels / 4));
			((TextView) v.findViewById(R.id.txtcustom3))
					.setWidth((dm.widthPixels / 4));
			//
			if (CommonStaticClass.langBng) {
				((TextView) v.findViewById(R.id.txtcustom1))
						.setText("RvqMvi bvg");
				((TextView) v.findViewById(R.id.txtcustom1)).setTypeface(font);
				((TextView) v.findViewById(R.id.txtcustom2))
						.setText("RevB Kiv");
				((TextView) v.findViewById(R.id.txtcustom2)).setTypeface(font);
				((TextView) v.findViewById(R.id.txtcustom3))
						.setText("c«wµqvRvZKib");
				((TextView) v.findViewById(R.id.txtcustom3)).setTypeface(font);
			} else {
				((TextView) v.findViewById(R.id.txtcustom1)).setText("");
				((TextView) v.findViewById(R.id.txtcustom1)).setTypeface(null);
				((TextView) v.findViewById(R.id.txtcustom2)).setText("");
				((TextView) v.findViewById(R.id.txtcustom2)).setTypeface(null);
				((TextView) v.findViewById(R.id.txtcustom3)).setText("Bizarre");
				((TextView) v.findViewById(R.id.txtcustom3)).setTypeface(null);
			}
		}

	}

	private void loadGuiMultipleCheckCombotwo(final ViewGroup v) {
		// TODO Auto-generated method stub
		// checkDbHasPreviousDataForThisHouseHold();

		adjustForSpinner = false;
		adjustForEdit = false;
		aaa1.clear();
		aaa2.clear();
		aaa3.clear();
		aaachecklist.clear();
		mEditStrings.clear();

		optionList1 = new ArrayList<String>();
		optionCodeList1 = new ArrayList<Integer>();

		optionList2 = new ArrayList<String>();
		optionCodeList2 = new ArrayList<Integer>();

		optionList3 = new ArrayList<String>();
		optionCodeList3 = new ArrayList<Integer>();

		qqq = (TextView) v.findViewById(R.id.qqq);

		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();
		if (qName.equalsIgnoreCase("qincome")
				|| qName.equalsIgnoreCase("qownedassets")
				|| qName.equalsIgnoreCase("qsavingsandloan")
				|| qName.equalsIgnoreCase("p87d")
				|| qName.equalsIgnoreCase("p87e")) {// put the name of question
													// from
			// qvar
			adjustForEdit = true;
		}
		if (qName.equalsIgnoreCase("")) { // put the name of question from
											// qvar
			adjustForSpinner = true;
		} else {
			adjustForSpinner = false;
		}
		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				qqq.setTypeface(font);
			}

			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());

		} else {
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
			qqq.setTypeface(null);
		}

		checkBoxHolder = (LinearLayout) v.findViewById(R.id.checkBoxHolder);
		checkBoxHolder.removeAllViews();

		op = CommonStaticClass.findOptionsForThisQuestion(dbHelper,
				CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar());

		LinearLayout.LayoutParams lnlParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);

		LinearLayout.LayoutParams layoutParamForcheck = new LinearLayout.LayoutParams(
				(dm.widthPixels / 4) * 2,
				LinearLayout.LayoutParams.WRAP_CONTENT);

		LinearLayout.LayoutParams layoutParamForSpin1 = new LinearLayout.LayoutParams(
				(dm.widthPixels / 4), LinearLayout.LayoutParams.WRAP_CONTENT);

		LinearLayout.LayoutParams layoutParamForSpin2 = new LinearLayout.LayoutParams(
				(dm.widthPixels / 4), LinearLayout.LayoutParams.WRAP_CONTENT);

		LinearLayout.LayoutParams layoutParamForEditOrSpinner = new LinearLayout.LayoutParams(
				(dm.widthPixels / 4), LinearLayout.LayoutParams.WRAP_CONTENT);

		CreateMultipleCheckCombotwoHeader(v);

		optionList1.add("");
		optionCodeList1.add(-1);

		optionList2.add("");
		optionCodeList2.add(-1);

		optionList3.add("");
		optionCodeList3.add(-1);

		for (int i = 0; i < op.codeList.size(); i++) {

			if (op.qidList.get(i).contains("_Options_1")) {
				Log.e("op.qidList.get(i)", op.qidList.get(i));
				if (CommonStaticClass.langBng) {
					optionList1.add(op.capBngList.get(i));
				} else {
					optionList1.add(op.capEngList.get(i));
				}
				optionCodeList1.add(op.codeList.get(i));
				continue;
			} else if (op.qidList.get(i).contains("_Options_2")) {

				if (CommonStaticClass.langBng) {
					optionList2.add(op.capBngList.get(i));
				} else {
					optionList2.add(op.capEngList.get(i));
				}
				optionCodeList2.add(op.codeList.get(i));
				continue;
			} else if (op.qidList.get(i).contains("_Options_3")) {

				if (CommonStaticClass.langBng) {
					optionList3.add(op.capBngList.get(i));
				} else {
					optionList3.add(op.capEngList.get(i));
				}
				optionCodeList3.add(op.codeList.get(i));
				continue;
			}

			aaa1.add(-1);
			aaa2.add(-1);
			aaa3.add(-1);
			aaachecklist.add(-1);
			if (adjustForEdit)
				mEditStrings.add("-1");
		}

		for (int i = 0; i < op.codeList.size(); i++) {

			Log.e("op.qidList.get(i)", op.qidList.get(i));
			if (op.qidList.get(i).contains("_Options_1")
					|| op.qidList.get(i).contains("_Options_2")
					|| op.qidList.get(i).contains("_Options_3")) {
				continue;
			}
			LinearLayout ln = new LinearLayout(this);
			ln.setOrientation(LinearLayout.HORIZONTAL);
			final CheckBox checkButton = new CheckBox(this);
			if (CommonStaticClass.langBng) {
				checkButton.setTypeface(font);
				checkButton
						.setText(op.capBngList.get(i).length() > 0 ? op.capBngList
								.get(i) : op.capEngList.get(i));
			} else {
				checkButton.setText(op.capEngList.get(i));
			}
			checkButton.setId(i);
			final Spinner spinner1 = new Spinner(this);
			final Spinner spinner2 = new Spinner(this);
			final Spinner spinner3 = new Spinner(this);
			final EditText editforwater = new EditText(this);

			editforwater.setTag(i);
			layoutParamForSpin1.weight = 1;
			if (adjustForEdit) {
				layoutParamForEditOrSpinner.weight = 1;
			}
			if (adjustForSpinner) {
				layoutParamForEditOrSpinner.weight = 1;
			}
			layoutParamForSpin2.weight = 1;

			if (adjustForSpinner) {
				ln.addView(spinner3, 0, layoutParamForEditOrSpinner);
			}
			if (adjustForEdit) {

				if (qName.equalsIgnoreCase("qownedassets")
						|| qName.equalsIgnoreCase("qsavingsandloan")) {
					editforwater.setRawInputType(InputType.TYPE_CLASS_NUMBER);
					int maxLength = 0;
					// editforwater.getText().l

				} else {
					editforwater.setRawInputType(InputType.TYPE_CLASS_TEXT);
				}
				ln.addView(editforwater, 0, layoutParamForEditOrSpinner);

			}
			if (!qName.equalsIgnoreCase("p87b"))
				ln.addView(spinner2, 0, layoutParamForSpin2);

			ln.addView(spinner1, 0, layoutParamForSpin1);

			ln.addView(checkButton, 0, layoutParamForcheck);

			// checkButton.setEnabled(false);
			ArrayAdapter adapter1, adapter2, adapter3 = null;

			if (CommonStaticClass.langBng) {
				adapter1 = new SpinAdapter(this, optionList1, true);
				adapter2 = new SpinAdapter(this, optionList2, true);
				if (adjustForSpinner) {
					adapter3 = new SpinAdapter(this, optionList3, true);
				}
			} else {
				adapter1 = new ArrayAdapter(this,
						android.R.layout.simple_spinner_item, optionList1);
				adapter2 = new ArrayAdapter(this,
						android.R.layout.simple_spinner_item, optionList2);
				if (adjustForSpinner) {
					adapter3 = new ArrayAdapter(this,
							android.R.layout.simple_spinner_item, optionList3);
				}
			}

			adapter1.setDropDownViewResource(CommonStaticClass.langBng ? R.layout.checkedspintextview
					: android.R.layout.simple_spinner_dropdown_item);

			adapter2.setDropDownViewResource(CommonStaticClass.langBng ? R.layout.checkedspintextview
					: android.R.layout.simple_spinner_dropdown_item);
			if (adjustForSpinner) {
				adapter3.setDropDownViewResource(CommonStaticClass.langBng ? R.layout.checkedspintextview
						: android.R.layout.simple_spinner_dropdown_item);
			}

			spinner1.setAdapter(adapter1);
			spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {

				public void onItemSelected(AdapterView<?> parent, View view,
						int pos, long id) {
					// TODO Auto-generated method stub
					if (optionCodeList1.size() > pos) {
						aaa1.set(checkButton.getId(), optionCodeList1.get(pos));
						/*
						 * editforwater.setVisibility(View.VISIBLE);
						 * spinner2.setVisibility(View.VISIBLE);
						 * spinner3.setVisibility(View.VISIBLE);
						 */

						if (qName.equalsIgnoreCase("qincome")
								|| qName.equalsIgnoreCase("qownedassets")
								|| qName.equalsIgnoreCase("qsavingsandloan")) {
							if (spinner1.getSelectedItem().toString()
									.contains("1")) {
								editforwater.setVisibility(View.VISIBLE);
								spinner2.setVisibility(View.VISIBLE);
								spinner3.setVisibility(View.VISIBLE);
							} else {
								editforwater.setVisibility(View.INVISIBLE);
								spinner2.setVisibility(View.INVISIBLE);
								spinner3.setVisibility(View.INVISIBLE);
							}

						} else {

							editforwater.setVisibility(View.INVISIBLE);
							spinner2.setVisibility(View.INVISIBLE);
							spinner3.setVisibility(View.INVISIBLE);

						}
					} else {
						/*
						 * editforwater.setVisibility(View.INVISIBLE);
						 * spinner2.setVisibility(View.INVISIBLE);
						 * spinner3.setVisibility(View.INVISIBLE);
						 */
					}
				}

				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					// aaa.set(checkButton.getId(), -1);
					/*
					 * editforwater.setVisibility(View.INVISIBLE);
					 * spinner2.setVisibility(View.INVISIBLE);
					 * spinner3.setVisibility(View.INVISIBLE);
					 */
				}

			});

			if (spinner2.getVisibility() == View.VISIBLE) {
				spinner2.setAdapter(adapter2);
				spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> parent,
							View view, int pos, long id) {
						// TODO Auto-generated method stub
						if (optionCodeList2.size() > pos)
							aaa2.set(checkButton.getId(),
									optionCodeList2.get(pos));

					}

					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
						// aaa.set(checkButton.getId(), -1);
					}

				});
			}

			if (adjustForSpinner) {
				spinner3.setAdapter(adapter3);
				spinner3.setOnItemSelectedListener(new OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> parent,
							View view, int pos, long id) {
						// TODO Auto-generated method stub
						if (optionCodeList3.size() > pos)
							aaa3.set(checkButton.getId(),
									optionCodeList3.get(pos));

					}

					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
						// aaa.set(checkButton.getId(), -1);
					}

				});
			}
			if (adjustForEdit) {
				editforwater.addTextChangedListener(new TextWatcher() {

					public void onTextChanged(CharSequence arg0, int arg1,
							int arg2, int arg3) {
						// TODO Auto-generated method stub

					}

					public void beforeTextChanged(CharSequence arg0, int arg1,
							int arg2, int arg3) {
						// TODO Auto-generated method stub

					}

					public void afterTextChanged(Editable arg0) {
						// TODO Auto-generated method stub
						mEditStrings.set((Integer) editforwater.getTag(),
								arg0.toString());
					}
				});
			}

			checkBoxHolder.addView(ln, 0, lnlParams);

			checkButton
					.setOnCheckedChangeListener(new OnCheckedChangeListener() {

						public void onCheckedChanged(CompoundButton buttonView,
								boolean isChecked) {
							// TODO Auto-generated method stub
							if (isChecked) {
								Log.e("id :", "" + checkButton.getId());
								aaachecklist.set(checkButton.getId(), 1);
								// allchecked = allchecked+1;
								spinner1.setVisibility(View.VISIBLE);
								if (!qName.equalsIgnoreCase("qincome")) {
									// spinner2.setVisibility(View.VISIBLE);
								}

								if (adjustForSpinner) {
									spinner3.setVisibility(View.VISIBLE);
								}
								if (adjustForEdit) {
									// editforwater.setVisibility(View.VISIBLE);
									if (editforwater.getVisibility() == View.VISIBLE) {
										mEditStrings.set(
												(Integer) editforwater.getTag(),
												"::");
									}
								}

							} else {
								aaachecklist.set(checkButton.getId(), -1);
								spinner1.setVisibility(View.INVISIBLE);
								if (!qName.equalsIgnoreCase("qincome")) {
									// spinner2.setVisibility(View.INVISIBLE);
								}
								if (adjustForSpinner) {
									spinner3.setVisibility(View.INVISIBLE);
								}
								if (adjustForEdit) {
									// editforwater.setVisibility(View.INVISIBLE);
									mEditStrings.set(
											(Integer) editforwater.getTag(),
											"::");
								}
							}
						}
					});

			spinner1.setVisibility(View.INVISIBLE);
			if (!qName.equalsIgnoreCase("p87b")) {
				spinner2.setVisibility(View.INVISIBLE);
			}
			if (adjustForSpinner) {
				spinner3.setVisibility(View.INVISIBLE);
			}
			if (adjustForEdit) {
				editforwater.setVisibility(View.INVISIBLE);
			}

			if (adjustForEdit) {
				selectCheckAndCombo(op.qidList.get(i), checkButton, spinner1,
						editforwater, spinner2);
			} else {

				if (adjustForSpinner) {
					selectCheckAndCombo(op.qidList.get(i), checkButton,
							spinner1, spinner2, spinner3);
				} else {
					selectCheckAndCombo(op.qidList.get(i), checkButton,
							spinner1, spinner2);
				}
			}
			checkButton.setChecked(true);
			checkButton.setEnabled(false);
		}

		prevButton = (Button) v.findViewById(R.id.prevButton);
		prevButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vvv) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		saveNxtButton = (Button) v.findViewById(R.id.saveNxtButton);

		saveNxtButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vvv) {
				// TODO Auto-generated method stub
				updateTableMultipleCheckComboTwo(checkBoxHolder, adjustForEdit,
						adjustForSpinner);

			}

		});
		clButton = (Button) v.findViewById(R.id.clButton);
		clButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vvv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) v.findViewById(R.id.rootView));
			}

		});
		notesButton = (Button) v.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View vvv) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});
	}

	// for frmmultiplecheckcombotext
	private void loadGuiMultipleChecktexttwo(final ViewGroup v) {
		// This form will contain two dynaic text column

		mEditStrings.clear();
		mEditStrings2.clear();
		// mEditStrings3.clear();

		optionList1 = new ArrayList<String>();
		optionCodeList1 = new ArrayList<Integer>();

		/*
		 * optionList2 = new ArrayList<String>(); optionCodeList2 = new
		 * ArrayList<Integer>();
		 * 
		 * optionList3 = new ArrayList<String>(); optionCodeList3 = new
		 * ArrayList<Integer>();
		 */
		qqq = (TextView) v.findViewById(R.id.qqq);

		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();
		/*
		 * if (qName.equalsIgnoreCase("qincome") ||
		 * qName.equalsIgnoreCase("qownedassets") ||
		 * qName.equalsIgnoreCase("qcurrentownedland") ||
		 * qName.equalsIgnoreCase("p87e")) {
		 * 
		 * adjustForEdit = true; }
		 */
		/*
		 * if (qName.equalsIgnoreCase("")) { // put the name of question from //
		 * qvar adjustForSpinner = true; } else { adjustForSpinner = false; }
		 */

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				qqq.setTypeface(font);
			}

			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());

		} else {
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
			qqq.setTypeface(null);
		}

		checkBoxHolder = (LinearLayout) v.findViewById(R.id.checkBoxHolder);
		checkBoxHolder.removeAllViews();

		op = CommonStaticClass.findOptionsForThisQuestion(dbHelper,
				CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar());

		LinearLayout.LayoutParams lnlParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);

		LinearLayout.LayoutParams layoutParamForcheck = new LinearLayout.LayoutParams(
				(dm.widthPixels / 5) * 2,
				LinearLayout.LayoutParams.WRAP_CONTENT);

		/*
		 * LinearLayout.LayoutParams layoutParamForSpin1 = new
		 * LinearLayout.LayoutParams( (dm.widthPixels / 4),
		 * LinearLayout.LayoutParams.WRAP_CONTENT);
		 * 
		 * LinearLayout.LayoutParams layoutParamForSpin2 = new
		 * LinearLayout.LayoutParams( (dm.widthPixels / 6),
		 * LinearLayout.LayoutParams.WRAP_CONTENT);
		 * 
		 * LinearLayout.LayoutParams layoutParamForEditOrSpinner = new
		 * LinearLayout.LayoutParams( (dm.widthPixels / 6),
		 * LinearLayout.LayoutParams.WRAP_CONTENT);
		 */

		LinearLayout.LayoutParams layoutParamForEditOrSpinner1 = new LinearLayout.LayoutParams(
				(dm.widthPixels / 5), LinearLayout.LayoutParams.WRAP_CONTENT);

		LinearLayout.LayoutParams layoutParamForEditOrSpinner2 = new LinearLayout.LayoutParams(
				(dm.widthPixels / 5), LinearLayout.LayoutParams.WRAP_CONTENT);

		CreateMultipleCheckCombotwoHeader(v);

		optionList1.add("");
		optionCodeList1.add(-1);

		/*
		 * optionList2.add(""); optionCodeList2.add(-1);
		 * 
		 * optionList3.add(""); optionCodeList3.add(-1);
		 */
		for (int i = 0; i < op.codeList.size(); i++) {

			/*
			 * if (op.qidList.get(i).contains("_Options_1")) {
			 * Log.e("op.qidList.get(i)", op.qidList.get(i)); if
			 * (CommonStaticClass.langBng) {
			 * optionList1.add(op.capBngList.get(i)); } else {
			 * optionList1.add(op.capEngList.get(i)); }
			 * optionCodeList1.add(op.codeList.get(i)); continue; }
			 */

			/*
			 * else if (op.qidList.get(i).contains("_Options_2")) {
			 * 
			 * if (CommonStaticClass.langBng) {
			 * optionList2.add(op.capBngList.get(i)); } else {
			 * optionList2.add(op.capEngList.get(i)); }
			 * optionCodeList2.add(op.codeList.get(i)); continue; } else if
			 * (op.qidList.get(i).contains("_Options_3")) {
			 * 
			 * if (CommonStaticClass.langBng) {
			 * optionList3.add(op.capBngList.get(i)); } else {
			 * optionList3.add(op.capEngList.get(i)); }
			 * optionCodeList3.add(op.codeList.get(i)); continue; }
			 */

			// aaa1.add(-1);
			aaachecklist.add(-1);
			/*
			 * aaa2.add(-1); aaa3.add(-1); aaachecklist.add(-1); if
			 * (adjustForEdit) { mEditStrings.add("-1");
			 * mEditStrings2.add("-1"); mEditStrings3.add("-1"); }
			 */
			// if (adjustForEdit) {
			mEditStrings.add("-1");
			mEditStrings2.add("-1");
			// mEditStrings3.add("-1");
			// }
		}

		for (int i = 0; i < op.codeList.size(); i++) {

			Log.e("op.qidList.get(i)", op.qidList.get(i));
			/*
			 * if (op.qidList.get(i).contains("_Options_1") ||
			 * op.qidList.get(i).contains("_Options_2") ||
			 * op.qidList.get(i).contains("_Options_3")) { continue; }
			 */
			LinearLayout ln = new LinearLayout(this);
			ln.setOrientation(LinearLayout.HORIZONTAL);
			final CheckBox checkButton = new CheckBox(this);
			if (CommonStaticClass.langBng) {
				checkButton.setTypeface(font);
				checkButton
						.setText(op.capBngList.get(i).length() > 0 ? op.capBngList
								.get(i) : op.capEngList.get(i));
			} else {
				checkButton.setText(op.capEngList.get(i));
			}

			checkButton.setId(i);
			/*
			 * final Spinner spinner1 = new Spinner(this); final Spinner
			 * spinner2 = new Spinner(this); final Spinner spinner3 = new
			 * Spinner(this);
			 */
			final EditText et1 = new EditText(this);
			final EditText et2 = new EditText(this);
			// final EditText et3 = new EditText(this);

			et1.setTag(i);
			et2.setTag(i);
			// et3.setTag(i + 2);

			layoutParamForEditOrSpinner1.weight = 1;
			layoutParamForEditOrSpinner2.weight = 1;
			/*
			 * layoutParamForSpin1.weight = 1; if (adjustForEdit) {
			 * layoutParamForEditOrSpinner.weight = 3; } if (adjustForSpinner) {
			 * layoutParamForEditOrSpinner.weight = 1; }
			 * layoutParamForSpin2.weight = 1; if (adjustForSpinner) {
			 * ln.addView(spinner3, 0, layoutParamForEditOrSpinner); }
			 */

			/*
			 * if (!qName.equalsIgnoreCase("p87b")) ln.addView(spinner2, 0,
			 * layoutParamForSpin2);
			 */

			// if (adjustForEdit) {
			et1.setRawInputType(InputType.TYPE_CLASS_TEXT);
			ln.addView(et1, 0, layoutParamForEditOrSpinner1);

			et2.setRawInputType(InputType.TYPE_CLASS_TEXT);
			ln.addView(et2, 0, layoutParamForEditOrSpinner2);

			/*
			 * et3.setRawInputType(InputType.TYPE_CLASS_TEXT); ln.addView(et3,
			 * 2, layoutParamForEditOrSpinner3);
			 */

			// }

			// ln.addView(spinner1, 0, layoutParamForSpin1);

			ln.addView(checkButton, 0, layoutParamForcheck);

			// ArrayAdapter adapter1, adapter2, adapter3 = null;

			/*
			 * if (CommonStaticClass.langBng) { adapter1 = new SpinAdapter(this,
			 * optionList1, true); adapter2 = new SpinAdapter(this, optionList2,
			 * true); if (adjustForSpinner) { adapter3 = new SpinAdapter(this,
			 * optionList3, true); } } else { adapter1 = new ArrayAdapter(this,
			 * android.R.layout.simple_spinner_item, optionList1); adapter2 =
			 * new ArrayAdapter(this, android.R.layout.simple_spinner_item,
			 * optionList2); if (adjustForSpinner) { adapter3 = new
			 * ArrayAdapter(this, android.R.layout.simple_spinner_item,
			 * optionList3); } }
			 * 
			 * adapter1.setDropDownViewResource(CommonStaticClass.langBng ?
			 * R.layout.checkedspintextview :
			 * android.R.layout.simple_spinner_dropdown_item);
			 * 
			 * adapter2.setDropDownViewResource(CommonStaticClass.langBng ?
			 * R.layout.checkedspintextview :
			 * android.R.layout.simple_spinner_dropdown_item); if
			 * (adjustForSpinner) {
			 * adapter3.setDropDownViewResource(CommonStaticClass.langBng ?
			 * R.layout.checkedspintextview :
			 * android.R.layout.simple_spinner_dropdown_item); }
			 * 
			 * spinner1.setAdapter(adapter1);
			 * spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
			 * 
			 * public void onItemSelected(AdapterView<?> parent, View view, int
			 * pos, long id) { // TODO Auto-generated method stub if
			 * (optionCodeList1.size() > pos) aaa1.set(checkButton.getId(),
			 * optionCodeList1.get(pos));
			 * 
			 * }
			 * 
			 * public void onNothingSelected(AdapterView<?> arg0) { // TODO
			 * Auto-generated method stub // aaa.set(checkButton.getId(), -1); }
			 * 
			 * });
			 */

			/*
			 * if (spinner2.getVisibility() == View.VISIBLE) {
			 * spinner2.setAdapter(adapter2);
			 * spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
			 * 
			 * public void onItemSelected(AdapterView<?> parent, View view, int
			 * pos, long id) { // TODO Auto-generated method stub if
			 * (optionCodeList2.size() > pos) aaa2.set(checkButton.getId(),
			 * optionCodeList2.get(pos));
			 * 
			 * }
			 * 
			 * public void onNothingSelected(AdapterView<?> arg0) { // TODO
			 * Auto-generated method stub // aaa.set(checkButton.getId(), -1); }
			 * 
			 * }); }
			 */
			/*
			 * if (adjustForSpinner) { spinner3.setAdapter(adapter3);
			 * spinner3.setOnItemSelectedListener(new OnItemSelectedListener() {
			 * 
			 * public void onItemSelected(AdapterView<?> parent, View view, int
			 * pos, long id) { // TODO Auto-generated method stub if
			 * (optionCodeList3.size() > pos) aaa3.set(checkButton.getId(),
			 * optionCodeList3.get(pos));
			 * 
			 * }
			 * 
			 * public void onNothingSelected(AdapterView<?> arg0) { // TODO
			 * Auto-generated method stub // aaa.set(checkButton.getId(), -1); }
			 * 
			 * }); }
			 */
			// if (adjustForEdit) {
			et1.addTextChangedListener(new TextWatcher() {

				public void onTextChanged(CharSequence arg0, int arg1,
						int arg2, int arg3) {
					// TODO Auto-generated method stub

				}

				public void beforeTextChanged(CharSequence arg0, int arg1,
						int arg2, int arg3) {
					// TODO Auto-generated method stub

				}

				public void afterTextChanged(Editable arg0) {
					// TODO Auto-generated method stub
					mEditStrings.set((Integer) et1.getTag(), arg0.toString());
				}
			});

			et2.addTextChangedListener(new TextWatcher() {

				public void onTextChanged(CharSequence arg0, int arg1,
						int arg2, int arg3) {
					// TODO Auto-generated method stub

				}

				public void beforeTextChanged(CharSequence arg0, int arg1,
						int arg2, int arg3) {
					// TODO Auto-generated method stub

				}

				public void afterTextChanged(Editable arg0) {
					// TODO Auto-generated method stub
					mEditStrings2.set((Integer) et2.getTag(), arg0.toString());
				}
			});

			/*
			 * et3.addTextChangedListener(new TextWatcher() {
			 * 
			 * public void onTextChanged(CharSequence arg0, int arg1, int arg2,
			 * int arg3) { // TODO Auto-generated method stub
			 * 
			 * }
			 * 
			 * public void beforeTextChanged(CharSequence arg0, int arg1, int
			 * arg2, int arg3) { // TODO Auto-generated method stub
			 * 
			 * }
			 * 
			 * public void afterTextChanged(Editable arg0) { // TODO
			 * Auto-generated method stub mEditStrings3.set((Integer)
			 * et3.getTag(), arg0.toString()); } });
			 */
			// }

			checkBoxHolder.addView(ln, 0, lnlParams);

			checkButton
					.setOnCheckedChangeListener(new OnCheckedChangeListener() {

						public void onCheckedChanged(CompoundButton buttonView,
								boolean isChecked) {
							// TODO Auto-generated method stub
							if (isChecked) {
								Log.e("id :", "" + checkButton.getId());
								aaachecklist.set(checkButton.getId(), 1);
								// allchecked = allchecked+1;
								/*
								 * spinner1.setVisibility(View.VISIBLE); if
								 * (!qName.equalsIgnoreCase("p87b")) {
								 * spinner2.setVisibility(View.VISIBLE); }
								 * 
								 * if (adjustForSpinner) {
								 * spinner3.setVisibility(View.VISIBLE); } if
								 * (adjustForEdit) {
								 */
								et1.setVisibility(View.VISIBLE);
								mEditStrings.set((Integer) et1.getTag(), "::");

								et2.setVisibility(View.VISIBLE);

								mEditStrings2.set((Integer) et2.getTag(), "::");

								// et3.setVisibility(View.VISIBLE);
								/*
								 * mEditStrings3.set( (Integer) et3.getTag(),
								 * "::");
								 */
								// }

							} else {
								aaachecklist.set(checkButton.getId(), -1);
								/*
								 * spinner1.setVisibility(View.INVISIBLE); if
								 * (!qName.equalsIgnoreCase("p87b")) {
								 * spinner2.setVisibility(View.INVISIBLE); } if
								 * (adjustForSpinner) {
								 * spinner3.setVisibility(View.INVISIBLE); } if
								 * (adjustForEdit) {
								 */
								et1.setVisibility(View.INVISIBLE);
								mEditStrings.set((Integer) et1.getTag(), "-1");

								et2.setVisibility(View.INVISIBLE);
								mEditStrings2.set((Integer) et2.getTag(), "-1");

								/*
								 * et3.setVisibility(View.INVISIBLE);
								 * mEditStrings3.set((Integer) et3.getTag(),
								 * "-1"); }
								 */
							}
						}
					});

			/*
			 * spinner1.setVisibility(View.INVISIBLE); if
			 * (!qName.equalsIgnoreCase("p87b")) {
			 * spinner2.setVisibility(View.INVISIBLE); } if (adjustForSpinner) {
			 * spinner3.setVisibility(View.INVISIBLE); }
			 */
			// if (adjustForEdit) {
			et1.setVisibility(View.INVISIBLE);
			et2.setVisibility(View.INVISIBLE);
			// et1.setVisibility(View.INVISIBLE);
			// }
			// if (adjustForEdit) {
			selectCheckMultipleCheckTextTwo(op.qidList.get(i), checkButton,
					et1, et2);
			// }

			/*
			 * else { if (adjustForSpinner) {
			 * selectCheckAndCombo(op.qidList.get(i), checkButton, spinner1,
			 * spinner2, spinner3); } else {
			 * selectCheckAndCombo(op.qidList.get(i), checkButton, spinner1,
			 * spinner2); } }
			 */

		}

		prevButton = (Button) v.findViewById(R.id.prevButton);
		prevButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vvv) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		saveNxtButton = (Button) v.findViewById(R.id.saveNxtButton);

		saveNxtButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vvv) {
				// TODO Auto-generated method stub
				updateTableMultipleCheckTextTwo(checkBoxHolder);

			}

		});
		clButton = (Button) v.findViewById(R.id.clButton);
		clButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vvv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) v.findViewById(R.id.rootView));
			}

		});
		notesButton = (Button) v.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View vvv) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});
	}

	private void spinnerVisibleButNotSeleted(ViewGroup viewGroup) {
		int nrOfChildren = viewGroup.getChildCount();
		for (int i = 0; i < nrOfChildren; i++) {
			View view = viewGroup.getChildAt(i);

			if (view instanceof Spinner
					&& (view.getVisibility() == View.VISIBLE)) {
				if (((Spinner) view).getSelectedItemPosition() == 0) {

					spinnerOK = false;

				}
			}
			if (view instanceof ViewGroup) {
				spinnerVisibleButNotSeleted((ViewGroup) view);
			}
		}
	}

	private void EditBoxVisibleButNotEntered(ViewGroup viewGroup) {
		int nrOfChildren = viewGroup.getChildCount();
		for (int i = 0; i < nrOfChildren; i++) {
			View view = viewGroup.getChildAt(i);

			if (view instanceof EditText
					&& (view.getVisibility() == View.VISIBLE)) {
				if (((EditText) view).getText().toString().length() == 0) {

					spinnerOK = false;

				}
				if (qName.equalsIgnoreCase("qownedassets")) {

					if (((EditText) view).getText().toString().length() == 0) {

						spinnerOK = false;

					} else if (Integer.parseInt(((EditText) view).getText()
							.toString()) > 100) {

						spinnerOK = false;

					}

				}
			}
			if (view instanceof ViewGroup) {
				EditBoxVisibleButNotEntered((ViewGroup) view);
			}
		}
	}

	// private boolean checkIfSingleOptionIsChecked() {
	// for (int i = 0; i < aaachecklist.size(); i++) {
	// if (!(aaachecklist.get(i) == -1)) {
	// return true;
	// }
	// }
	// return false;
	// }
	private boolean checkIfAllOptionIsChecked() {
		// for (int i = 0; i < aaachecklist.size(); i++) {
		// if ((aaachecklist.get(i) == -1)) {
		// Log.e("aaachecklist.get(i)","aaachecklist.get(i): "+aaachecklist.get(i));
		// }
		// }
		// return false;
		/*
		 * if (aaachecklist.contains(-1)) { return false; } else {
		 */
		return true;
		// }
	}

	// private Boolean CheckBoxNotSeletedFrmMultipleCheckCombotwo() {
	// if(aaachecklist.size()!=allchecked)
	// {
	// return spinnerOK = false;
	// }
	// return spinnerOK;
	// /*for (int i = 0; i < aaachecklist.size(); i++) {
	// if (aaachecklist.get(i) == -1) {
	// return spinnerOK = false;
	//
	// }
	// }
	// return spinnerOK;*/
	//
	// }

	private void updateTableMultipleCheckComboTwo(ViewGroup checkBoxHolder,
			boolean adjustEdit, boolean adjustSpin) {
		// TODO Auto-generated method stub
		spinnerOK = true;

		spinnerVisibleButNotSeleted(checkBoxHolder);
		EditBoxVisibleButNotEntered(checkBoxHolder);
		if (adjustEdit) {
			if (checkIfSingleEditIsBlank()) {
				CommonStaticClass
						.showMyAlert(con, "Please enter value",
								"Blank value is not accepted, please put some value to proceed");
				return;
			}
		}
		/*
		 * if (CheckBoxNotSeletedFrmMultipleCheckCombotwo() == false) {
		 * CommonStaticClass.showMyAlert(con, "Please Select",
		 * "Please select all checkbox to proceed"); return; }
		 */

		if (spinnerOK) {
			if (checkeditboxValueisvalid()) {

			}
			// if (checkIfSingleOptionIsChecked()) {
			if (checkIfAllOptionIsChecked()) {
				String sql = "UPDATE "
						+ CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getTablename()
						+ " SET ";
				for (int i = 0; i < op.codeList.size(); i++) {
					if (op.qidList.get(i).contains("_Options")) {
						continue;
					}
					if (op.qidList.get(i + 1).contains("_Options")) {
						if (adjustEdit) {
							sql += op.qidList.get(i) + "_1 = '"
									+ (aaachecklist.get(i) == -1 ? 0 : 1)
									+ "',";
							sql += op.qidList.get(i) + "_2 = '"
									+ mEditStrings.get(i) + "',";

							sql += op.qidList.get(i)
									+ "_3 = '"
									+ ((aaachecklist.get(i) == -1 || aaachecklist
											.get(i) == 0) ? "" : aaa1.get(i))
									+ "',";

							sql += op.qidList.get(i)
									+ "_4 = '"
									+ ((aaachecklist.get(i) == -1 || aaachecklist
											.get(i) == 0) ? "" : aaa2.get(i))
									+ "' ";
						} else {
							if (adjustSpin) {
								sql += op.qidList.get(i) + "_1 = '"
										+ (aaachecklist.get(i) == -1 ? 0 : 1)
										+ "',";
								sql += op.qidList.get(i)
										+ "_2 = '"
										+ ((aaachecklist.get(i) == -1 || aaachecklist
												.get(i) == 0) ? "" : aaa1
												.get(i)) + "',";
								sql += op.qidList.get(i)
										+ "_3 = '"
										+ ((aaachecklist.get(i) == -1 || aaachecklist
												.get(i) == 0) ? "" : aaa2
												.get(i)) + "',";
								sql += op.qidList.get(i)
										+ "_4 = '"
										+ ((aaachecklist.get(i) == -1 || aaachecklist
												.get(i) == 0) ? "" : aaa3
												.get(i)) + "' ";
							} else {
								sql += op.qidList.get(i) + "_1 = '"
										+ (aaachecklist.get(i) == -1 ? 0 : 1)
										+ "',";
								sql += op.qidList.get(i)
										+ "_2 = '"
										+ ((aaachecklist.get(i) == -1 || aaachecklist
												.get(i) == 0) ? "" : aaa1
												.get(i)) + "',";
								sql += op.qidList.get(i)
										+ "_3 = '"
										+ ((aaachecklist.get(i) == -1 || aaachecklist
												.get(i) == 0) ? "" : aaa2
												.get(i)) + "' ";
							}
						}

						break;
					}
					if (adjustEdit) {
						sql += op.qidList.get(i) + "_1 = '"
								+ (aaachecklist.get(i) == -1 ? 0 : 1) + "',";
						sql += op.qidList.get(i) + "_2 = '"
								+ mEditStrings.get(i) + "',";
						sql += op.qidList.get(i)
								+ "_3 = '"
								+ ((aaachecklist.get(i) == -1 || aaachecklist
										.get(i) == 0) ? "" : aaa1.get(i))
								+ "',";
						sql += op.qidList.get(i)
								+ "_4 = '"
								+ ((aaachecklist.get(i) == -1 || aaachecklist
										.get(i) == 0) ? "" : aaa2.get(i))
								+ "',";
					} else {
						if (adjustSpin) {
							sql += op.qidList.get(i) + "_1 = '"
									+ (aaachecklist.get(i) == -1 ? 0 : 1)
									+ "',";
							sql += op.qidList.get(i)
									+ "_2 = '"
									+ ((aaachecklist.get(i) == -1 || aaachecklist
											.get(i) == 0) ? "" : aaa1.get(i))
									+ "',";
							sql += op.qidList.get(i)
									+ "_3 = '"
									+ ((aaachecklist.get(i) == -1 || aaachecklist
											.get(i) == 0) ? "" : aaa2.get(i))
									+ "',";
							sql += op.qidList.get(i)
									+ "_4 = '"
									+ ((aaachecklist.get(i) == -1 || aaachecklist
											.get(i) == 0) ? "" : aaa3.get(i))
									+ "',";
						} else {
							sql += op.qidList.get(i) + "_1 = '"
									+ (aaachecklist.get(i) == -1 ? 0 : 1)
									+ "',";
							sql += op.qidList.get(i)
									+ "_2 = '"
									+ ((aaachecklist.get(i) == -1 || aaachecklist
											.get(i) == 0) ? "" : aaa1.get(i))
									+ "',";
							sql += op.qidList.get(i)
									+ "_3 = '"
									+ ((aaachecklist.get(i) == -1 || aaachecklist
											.get(i) == 0) ? "" : aaa2.get(i))
									+ "',";
						}

					}
				}
				sql += "where dataid='" + CommonStaticClass.dataId + "'";

				if (dbHelper.executeDMLQuery(sql)) {
					if (!gotoskip()) {
						CommonStaticClass.findOutNextSLNo(
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQvar(),
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQnext1());
						CommonStaticClass.nextQuestion(ParentActivity.this);
					}
				}
			} else {
				CommonStaticClass
						.showMyAlert(con, "Please check one!!!",
								"You didn't check any answer please select one to preceed");
			}
		} else {
			CommonStaticClass
					.showMyAlert(con, "Please select item!!!",
							"You didn't put valid data, Please select and fill to proceed");
		}

	}

	private void updateTableMultipleCheckTextTwo(ViewGroup checkBoxHolder) {
		// TODO Auto-generated method stub
		spinnerOK = true;
		String sql = "";
		// spinnerVisibleButNotSeleted(checkBoxHolder);
		// if (adjustEdit) {
		if (checkIfSingleEditIsBlankMultipleText()) {
			CommonStaticClass
					.showMyAlert(con, "Please enter value",
							"Blank value is not accepted, please put some value to proceed");
			return;
		}
		// }
		/*
		 * if (CheckBoxNotSeletedFrmMultipleCheckCombotwo() == false) {
		 * CommonStaticClass.showMyAlert(con, "Please Select",
		 * "Please select all checkbox to proceed"); return; }
		 */

		// if (spinnerOK) {
		// if (checkIfSingleOptionIsChecked()) {
		if (checkIfAllOptionIsChecked()) {
			sql = "UPDATE "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " SET ";
			for (int i = 0; i < op.codeList.size(); i++) {
				/*
				 * if (op.qidList.get(i).contains("_Options")) { continue; }
				 */
				// if (op.qidList.get(i + 1).contains("_Options")) {
				// if (adjustEdit) {
				sql += op.qidList.get(i) + "_1 = '"
						+ (aaachecklist.get(i) == -1 ? 0 : 1) + "',";
				sql += op.qidList.get(i) + "_2 = '" + mEditStrings.get(i)
						+ "',";

				sql += op.qidList.get(i) + "_3 = '" + mEditStrings2.get(i)
						+ "',";

				/*
				 * sql += op.qidList.get(i) + "_4 = '" + ((aaachecklist.get(i)
				 * == -1 || aaachecklist .get(i) == 0) ? "" : aaa2.get(i)) +
				 * "' ";
				 * 
				 * sql += op.qidList.get(i) + "_5 = '" + mEditStrings2.get(i) +
				 * "',";
				 * 
				 * sql += op.qidList.get(i) + "_6 = '" + mEditStrings3.get(i) +
				 * "',";
				 */
			} /*
			 * else { if (adjustSpin) { sql += op.qidList.get(i) + "_1 = '" +
			 * (aaachecklist.get(i) == -1 ? 0 : 1) + "',"; sql +=
			 * op.qidList.get(i) + "_2 = '" + ((aaachecklist.get(i) == -1 ||
			 * aaachecklist .get(i) == 0) ? "" : aaa1 .get(i)) + "',"; sql +=
			 * op.qidList.get(i) + "_3 = '" + ((aaachecklist.get(i) == -1 ||
			 * aaachecklist .get(i) == 0) ? "" : aaa2 .get(i)) + "',"; sql +=
			 * op.qidList.get(i) + "_4 = '" + ((aaachecklist.get(i) == -1 ||
			 * aaachecklist .get(i) == 0) ? "" : aaa3 .get(i)) + "' "; } else {
			 * sql += op.qidList.get(i) + "_1 = '" + (aaachecklist.get(i) == -1
			 * ? 0 : 1) + "',"; sql += op.qidList.get(i) + "_2 = '" +
			 * ((aaachecklist.get(i) == -1 || aaachecklist .get(i) == 0) ? "" :
			 * aaa1 .get(i)) + "',"; sql += op.qidList.get(i) + "_3 = '" +
			 * ((aaachecklist.get(i) == -1 || aaachecklist .get(i) == 0) ? "" :
			 * aaa2 .get(i)) + "' "; }
			 */
			// }

			// break;
		}
		/*
		 * if (adjustEdit) { sql += op.qidList.get(i) + "_1 = '" +
		 * (aaachecklist.get(i) == -1 ? 0 : 1) + "',"; sql += op.qidList.get(i)
		 * + "_2 = '" + mEditStrings.get(i) + "',"; sql += op.qidList.get(i) +
		 * "_2 = '" + mEditStrings2.get(i) + "'," + "',"; sql +=
		 * op.qidList.get(i) + "_4 = '" + ((aaachecklist.get(i) == -1 ||
		 * aaachecklist .get(i) == 0) ? "" : aaa2.get(i)) + "',";
		 * 
		 * sql += op.qidList.get(i) + "_5 = '" + mEditStrings2.get(i) + "',";
		 * 
		 * sql += op.qidList.get(i) + "_6 = '" + mEditStrings3.get(i) + "',";
		 * 
		 * }
		 */
		// }

		sql = (String) sql.subSequence(0, sql.length() - 1);
		sql += " where dataid='" + CommonStaticClass.dataId + "'";

		if (dbHelper.executeDMLQuery(sql)) {
			if (!gotoskip()) {
				CommonStaticClass.findOutNextSLNo(
						CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getQvar(),
						CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getQnext1());
				CommonStaticClass.nextQuestion(ParentActivity.this);
			}
		}
		// } /*else {
		/*
		 * CommonStaticClass .showMyAlert(con, "Please check one!!!",
		 * "You didn't check any answer please select one to preceed");
		 */
		// }*/
		// } /*else {
		/*
		 * CommonStaticClass .showMyAlert(con, "Please select item!!!",
		 * "You didn't select any item from list, Please select one to proceed"
		 * );
		 */
		// }*/

	}

	private boolean gotoskip() {

		// q37
		if (qName.equalsIgnoreCase("q37a")) {
			CommonStaticClass.qskipList.remove("q37c1");
			CommonStaticClass.qskipList.remove("q37c1_other");
			CommonStaticClass.qskipList.add("q37c1_other_num");
			CommonStaticClass.qskipList.remove("q37c2");
			CommonStaticClass.qskipList.remove("q37c2_other");
			CommonStaticClass.qskipList.add("q37c2_other_num");
			CommonStaticClass.qskipList.remove("q37c3");
			CommonStaticClass.qskipList.remove("q37c3_other");
			CommonStaticClass.qskipList.add("q37c3_other_num");
			CommonStaticClass.qskipList.remove("q37c4");
			CommonStaticClass.qskipList.remove("q37c4_other");
			CommonStaticClass.qskipList.add("q37c4_other_num");
			CommonStaticClass.qskipList.remove("q37c5");
			CommonStaticClass.qskipList.remove("q37c5_other");
			CommonStaticClass.qskipList.add("q37c5_other_num");
			CommonStaticClass.qskipList.remove("q37c6");
			CommonStaticClass.qskipList.remove("q37c6_other");
			CommonStaticClass.qskipList.add("q37c6_other_num");
			CommonStaticClass.qskipList.remove("q37c7");
			CommonStaticClass.qskipList.remove("q37c7_other");
			CommonStaticClass.qskipList.add("q37c7_other_num");

			if (!getSkip("q37a_1", "tblMainQues").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q37c1");
				CommonStaticClass.qskipList.add("q37c1_other");
				CommonStaticClass.qskipList.add("q37c1_other_num");

			}

			if (!getSkip("q37a_2", "tblMainQues").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q37c2");
				CommonStaticClass.qskipList.add("q37c2_other");
				CommonStaticClass.qskipList.add("q37c2_other_num");

			}
			if (!getSkip("q37a_3", "tblMainQues").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q37c3");
				CommonStaticClass.qskipList.add("q37c3_other");
				CommonStaticClass.qskipList.add("q37c3_other_num");

			}

			if (!getSkip("q37a_4", "tblMainQues").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q37c4");
				CommonStaticClass.qskipList.add("q37c4_other");
				CommonStaticClass.qskipList.add("q37c4_other_num");

			}

			if (!getSkip("q37a_5", "tblMainQues").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q37c5");
				CommonStaticClass.qskipList.add("q37c5_other");
				CommonStaticClass.qskipList.add("q37c5_other_num");

			}

			if (!getSkip("q37a_6", "tblMainQues").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q37c6");
				CommonStaticClass.qskipList.add("q37c6_other");
				CommonStaticClass.qskipList.add("q37c6_other_num");

			}

			if (!getSkip("q37a_7", "tblMainQues").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q37c7");
				CommonStaticClass.qskipList.add("q37c7_other");
				CommonStaticClass.qskipList.add("q37c7_other_num");

			}
		}

		if (qName.equalsIgnoreCase("q42a")) {

			CommonStaticClass.qskipList.remove("q42c1");
			CommonStaticClass.qskipList.remove("q42c1_other");
			CommonStaticClass.qskipList.remove("q42c1_other_num");
			CommonStaticClass.qskipList.remove("q42c2");
			CommonStaticClass.qskipList.remove("q42c2_other");
			CommonStaticClass.qskipList.remove("q42c2_other_num");
			CommonStaticClass.qskipList.remove("q42c3");
			CommonStaticClass.qskipList.remove("q42c3_other");
			CommonStaticClass.qskipList.remove("q42c3_other_num");
			CommonStaticClass.qskipList.remove("q42c4");
			CommonStaticClass.qskipList.remove("q42c4_other");
			CommonStaticClass.qskipList.remove("q42c4_other_num");
			CommonStaticClass.qskipList.remove("q42c5");
			CommonStaticClass.qskipList.remove("q42c5_other");
			CommonStaticClass.qskipList.remove("q42c5_other_num");
			CommonStaticClass.qskipList.remove("q42c6");
			CommonStaticClass.qskipList.remove("q42c6_other");
			CommonStaticClass.qskipList.remove("q42c6_other_num");
			CommonStaticClass.qskipList.remove("q42c7");
			CommonStaticClass.qskipList.remove("q42c7_other");
			CommonStaticClass.qskipList.remove("q42c7_other_num");
			CommonStaticClass.qskipList.remove("q42c8");
			CommonStaticClass.qskipList.remove("q42c8_other");
			CommonStaticClass.qskipList.remove("q42c8_other_num");

			if (!getSkip("q42a_1", "tblMainQues").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q42c1");
				CommonStaticClass.qskipList.add("q42c1_other");
				CommonStaticClass.qskipList.add("q42c1_other_num");

			}

			if (!getSkip("q42a_2", "tblMainQues").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q42c2");
				CommonStaticClass.qskipList.add("q42c2_other");
				CommonStaticClass.qskipList.add("q42c2_other_num");

			}
			if (!getSkip("q42a_3", "tblMainQues").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q42c3");
				CommonStaticClass.qskipList.add("q42c3_other");
				CommonStaticClass.qskipList.add("q42c3_other_num");

			}

			if (!getSkip("q42a_4", "tblMainQues").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q42c4");
				CommonStaticClass.qskipList.add("q42c4_other");
				CommonStaticClass.qskipList.add("q42c4_other_num");

			}

			if (!getSkip("q42a_5", "tblMainQues").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q42c5");
				CommonStaticClass.qskipList.add("q42c5_other");
				CommonStaticClass.qskipList.add("q42c5_other_num");

			}

			if (!getSkip("q42a_6", "tblMainQues").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q42c6");
				CommonStaticClass.qskipList.add("q42c6_other");
				CommonStaticClass.qskipList.add("q42c6_other_num");

			}

			if (!getSkip("q42a_7", "tblMainQues").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q42c7");
				CommonStaticClass.qskipList.add("q42c7_other");
				CommonStaticClass.qskipList.add("q42c7_other_num");

			}
			if (!getSkip("q42a_8", "tblMainQues").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q42c8");
				CommonStaticClass.qskipList.add("q42c8_other");
				CommonStaticClass.qskipList.add("q42c8_other_num");

			}
		}

		if (qName.equalsIgnoreCase("p118")) {

			CommonStaticClass.qskipList.remove("q118R1C2");
			CommonStaticClass.qskipList.remove("q118R1C3");
			CommonStaticClass.qskipList.remove("q118R2C2");
			CommonStaticClass.qskipList.remove("q118R2C3");
			CommonStaticClass.qskipList.remove("q118R3C2");
			CommonStaticClass.qskipList.remove("q118R3C3");
			CommonStaticClass.qskipList.remove("q118R4C2");
			CommonStaticClass.qskipList.remove("q118R4C3");
			CommonStaticClass.qskipList.remove("q118R5C2");
			CommonStaticClass.qskipList.remove("q118R5C3");
			CommonStaticClass.qskipList.remove("q118R6C2");
			CommonStaticClass.qskipList.remove("q118R6C3");
			CommonStaticClass.qskipList.remove("q118R7C2");
			CommonStaticClass.qskipList.remove("q118R7C3");

			if (!getSkip("p118_1", "tblMainQuesMc").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q118R1C2");
				CommonStaticClass.qskipList.add("q118R1C3");
			}

			if (!getSkip("p118_2", "tblMainQuesMc").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q118R2C2");
				CommonStaticClass.qskipList.add("q118R2C3");
			}

			if (!getSkip("p118_3", "tblMainQuesMc").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q118R3C2");
				CommonStaticClass.qskipList.add("q118R3C3");
			}

			if (!getSkip("p118_4", "tblMainQuesMc").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q118R4C2");
				CommonStaticClass.qskipList.add("q118R4C3");
			}

			if (!getSkip("p118_5", "tblMainQuesMc").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q118R5C2");
				CommonStaticClass.qskipList.add("q118R5C3");
			}

			if (!getSkip("p118_6", "tblMainQuesMc").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q118R6C2");
				CommonStaticClass.qskipList.add("q118R6C3");
			}

			if (!getSkip("p118_7", "tblMainQuesMc").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q118R7C2");
				CommonStaticClass.qskipList.add("q118R7C3");
			}

		}

		if (qName.equalsIgnoreCase("p114")) {
			CommonStaticClass.qskipList.remove("p114_other");
			CommonStaticClass.qskipList.remove("q114R0C2");
			CommonStaticClass.qskipList.remove("q114R0C3");
			CommonStaticClass.qskipList.remove("q114R1C2");
			CommonStaticClass.qskipList.remove("q114R1C3");
			CommonStaticClass.qskipList.remove("q114R2C2");
			CommonStaticClass.qskipList.remove("q114R2C3");
			CommonStaticClass.qskipList.remove("q114R3C2");
			CommonStaticClass.qskipList.remove("q114R3C3");
			CommonStaticClass.qskipList.remove("q114R4C2");
			CommonStaticClass.qskipList.remove("q114R4C3");
			CommonStaticClass.qskipList.remove("q114R5C2");
			CommonStaticClass.qskipList.remove("q114R5C3");
			CommonStaticClass.qskipList.remove("q114R6C2");
			CommonStaticClass.qskipList.remove("q114R6C3");
			CommonStaticClass.qskipList.remove("q114R7C2");
			CommonStaticClass.qskipList.remove("q114R7C3");
			CommonStaticClass.qskipList.remove("q114R8C2");
			CommonStaticClass.qskipList.remove("q114R8C3");
			CommonStaticClass.qskipList.remove("q114R9C2");
			CommonStaticClass.qskipList.remove("q114R9C3");
			CommonStaticClass.qskipList.remove("q114R10C2");
			CommonStaticClass.qskipList.remove("q114R10C3");
			CommonStaticClass.qskipList.remove("q114R11C2");
			CommonStaticClass.qskipList.remove("q114R11C3");
			CommonStaticClass.qskipList.remove("q114R12C2");
			CommonStaticClass.qskipList.remove("q114R12C3");
			CommonStaticClass.qskipList.remove("q114R13C2");
			CommonStaticClass.qskipList.remove("q114R13C3");
			CommonStaticClass.qskipList.remove("q114R14C2");
			CommonStaticClass.qskipList.remove("q114R14C3");

			CommonStaticClass.qskipList.remove("p114_other");
			CommonStaticClass.qskipList.remove("q114R0C2");
			CommonStaticClass.qskipList.remove("q114R0C3");

			if (!getSkip("p114_15", "tblMainQuesMc").equalsIgnoreCase("1")) {
				// if (Integer.parseInt(getSkip("q114R0C2", "tblMainQuesMc")) <=
				// 0) {
				CommonStaticClass.qskipList.add("q114R0C2");
				CommonStaticClass.qskipList.add("q114R0C3");
				CommonStaticClass.qskipList.add("p114_other");
				// }

			}

			if (!getSkip("p114_1", "tblMainQuesMc").equalsIgnoreCase("1")) {
				// if (Integer.parseInt(getSkip("q114R1C2", "tblMainQuesMc")) <=
				// 0) {
				CommonStaticClass.qskipList.add("q114R1C2");
				CommonStaticClass.qskipList.add("q114R1C3");
				// }
			}
			if (!getSkip("p114_2", "tblMainQuesMc").equalsIgnoreCase("1")) {
				// if (Integer.parseInt(getSkip("q114R2C2", "tblMainQuesMc")) <=
				// 0) {
				CommonStaticClass.qskipList.add("q114R2C2");
				CommonStaticClass.qskipList.add("q114R2C3");
				// }
			}
			if (!getSkip("p114_3", "tblMainQuesMc").equalsIgnoreCase("1")) {
				// if (Integer.parseInt(getSkip("q114R3C2", "tblMainQuesMc")) <=
				// 0) {
				CommonStaticClass.qskipList.add("q114R3C2");
				CommonStaticClass.qskipList.add("q114R3C3");
				// }
			}
			if (!getSkip("p114_4", "tblMainQuesMc").equalsIgnoreCase("1")) {
				// if (Integer.parseInt(getSkip("q114R4C2", "tblMainQuesMc")) <=
				// 0) {
				CommonStaticClass.qskipList.add("q114R4C2");
				CommonStaticClass.qskipList.add("q114R4C3");
				// }
			}

			if (!getSkip("p114_5", "tblMainQuesMc").equalsIgnoreCase("1")) {
				// if (Integer.parseInt(getSkip("q114R5C2", "tblMainQuesMc")) <=
				// 0) {
				CommonStaticClass.qskipList.add("q114R5C2");
				CommonStaticClass.qskipList.add("q114R5C3");
				// }
			}

			if (!getSkip("p114_6", "tblMainQuesMc").equalsIgnoreCase("1")) {
				// if (Integer.parseInt(getSkip("q114R6C2", "tblMainQuesMc")) <=
				// 0) {
				CommonStaticClass.qskipList.add("q114R6C2");
				CommonStaticClass.qskipList.add("q114R6C3");
				// }
			}

			if (!getSkip("p114_7", "tblMainQuesMc").equalsIgnoreCase("1")) {
				// if (Integer.parseInt(getSkip("q114R7C2", "tblMainQuesMc")) <=
				// 0) {
				CommonStaticClass.qskipList.add("q114R7C2");
				CommonStaticClass.qskipList.add("q114R7C3");
				// }
			}

			if (!getSkip("p114_8", "tblMainQuesMc").equalsIgnoreCase("1")) {
				// if (Integer.parseInt(getSkip("q114R8C2", "tblMainQuesMc")) <=
				// 0) {
				CommonStaticClass.qskipList.add("q114R8C2");
				CommonStaticClass.qskipList.add("q114R8C3");
				// }
			}

			if (!getSkip("p114_9", "tblMainQuesMc").equalsIgnoreCase("1")) {
				// if (Integer.parseInt(getSkip("q114R9C2", "tblMainQuesMc")) <=
				// 0) {
				CommonStaticClass.qskipList.add("q114R9C2");
				CommonStaticClass.qskipList.add("q114R9C3");
				// }
			}

			if (!getSkip("p114_10", "tblMainQuesMc").equalsIgnoreCase("1")) {
				// if (Integer.parseInt(getSkip("q114R10C2", "tblMainQuesMc"))
				// <= 0) {
				CommonStaticClass.qskipList.add("q114R10C2");
				CommonStaticClass.qskipList.add("q114R10C3");
				// }
			}

			if (!getSkip("p114_11", "tblMainQuesMc").equalsIgnoreCase("1")) {
				// if (Integer.parseInt(getSkip("q114R11C2", "tblMainQuesMc"))
				// <= 0) {
				CommonStaticClass.qskipList.add("q114R11C2");
				CommonStaticClass.qskipList.add("q114R11C3");
				// }
			}

			if (!getSkip("p114_12", "tblMainQuesMc").equalsIgnoreCase("1")) {
				// if (Integer.parseInt(getSkip("q114R12C2", "tblMainQuesMc"))
				// <= 0) {
				CommonStaticClass.qskipList.add("q114R12C2");
				CommonStaticClass.qskipList.add("q114R12C3");
				// }
			}

			if (!getSkip("p114_13", "tblMainQuesMc").equalsIgnoreCase("1")) {
				// if (Integer.parseInt(getSkip("q114R13C2", "tblMainQuesMc"))
				// <= 0) {
				CommonStaticClass.qskipList.add("q114R13C2");
				CommonStaticClass.qskipList.add("q114R13C3");
				// }
			}

			if (!getSkip("p114_14", "tblMainQuesMc").equalsIgnoreCase("1")) {
				// if (Integer.parseInt(getSkip("q114R14C2", "tblMainQuesMc"))
				// <= 0) {
				CommonStaticClass.qskipList.add("q114R14C2");
				CommonStaticClass.qskipList.add("q114R14C3");
				// }

			}
		}
		if (qName.equalsIgnoreCase("q89a")) {
			CommonStaticClass.qskipList.remove("q89a_other");
			CommonStaticClass.qskipList.remove("q89o");
			CommonStaticClass.qskipList.remove("q89o_other");
			CommonStaticClass.qskipList.remove("q89oCount");

			CommonStaticClass.qskipList.remove("q89R1");
			CommonStaticClass.qskipList.remove("q89R1_other");
			CommonStaticClass.qskipList.remove("q89R1Count");
			CommonStaticClass.qskipList.remove("q89R2");
			CommonStaticClass.qskipList.remove("q89R2_other");
			CommonStaticClass.qskipList.remove("q89R2Count");
			CommonStaticClass.qskipList.remove("q89R3");
			CommonStaticClass.qskipList.remove("q89R3_other");
			CommonStaticClass.qskipList.remove("q89R3Count");
			CommonStaticClass.qskipList.remove("q89R4");
			CommonStaticClass.qskipList.remove("q89R4_other");
			CommonStaticClass.qskipList.remove("q89R4Count");
			CommonStaticClass.qskipList.remove("q89R5");
			CommonStaticClass.qskipList.remove("q89R5_other");
			CommonStaticClass.qskipList.remove("q89R5Count");
			CommonStaticClass.qskipList.remove("q89R6");
			CommonStaticClass.qskipList.remove("q89R6_other");
			CommonStaticClass.qskipList.remove("q89R6Count");
			CommonStaticClass.qskipList.remove("q89R7");
			CommonStaticClass.qskipList.remove("q89R7_other");
			CommonStaticClass.qskipList.remove("q89R7a");
			CommonStaticClass.qskipList.remove("q89R7aCount");
			CommonStaticClass.qskipList.remove("q89R8");

			CommonStaticClass.qskipList.remove("q89R8_other");
			CommonStaticClass.qskipList.remove("q89R8Count");

			CommonStaticClass.qskipList.remove("q89R9");
			CommonStaticClass.qskipList.remove("q89R9_other");
			CommonStaticClass.qskipList.remove("q89R9Count");

			if (!getSkip("q89a_1", "tblMainQuesMc").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q89R1");
				CommonStaticClass.qskipList.add("q89R1Count");
				CommonStaticClass.qskipList.add("q89R1_other");

			}
			if (!getSkip("q89a_2", "tblMainQuesMc").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q89R2");
				CommonStaticClass.qskipList.add("q89R2Count");
				CommonStaticClass.qskipList.add("q89R2_other");

			}
			if (!getSkip("q89a_3", "tblMainQuesMc").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q89R3");
				CommonStaticClass.qskipList.add("q89R3Count");
				CommonStaticClass.qskipList.add("q89R3_other");

			}
			if (!getSkip("q89a_4", "tblMainQuesMc").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q89R4");
				CommonStaticClass.qskipList.add("q89R4Count");
				CommonStaticClass.qskipList.add("q89R4_other");

			}
			if (!getSkip("q89a_5", "tblMainQuesMc").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q89R5");
				CommonStaticClass.qskipList.add("q89R5Count");
				CommonStaticClass.qskipList.add("q89R5_other");

			}
			if (!getSkip("q89a_6", "tblMainQuesMc").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q89R6");
				CommonStaticClass.qskipList.add("q89R6Count");
				CommonStaticClass.qskipList.add("q89R6_other");

			}
			if (!getSkip("q89a_7", "tblMainQuesMc").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q89R7");
				CommonStaticClass.qskipList.add("q89R7Count");
				CommonStaticClass.qskipList.add("q89R7_other");
				CommonStaticClass.qskipList.add("q89R7a");
				CommonStaticClass.qskipList.add("q89R7aCount");

			}

			if (!getSkip("q89a_8", "tblMainQuesMc").equalsIgnoreCase("1")) {
				/*
				 * CommonStaticClass.qskipList.add("q89R8");
				 * CommonStaticClass.qskipList.add("q89R8Count");
				 * CommonStaticClass.qskipList.add("q89R8_other");
				 */

				CommonStaticClass.qskipList.add("q89R8");
				CommonStaticClass.qskipList.add("q89R8_other");
				CommonStaticClass.qskipList.add("q89R8Count");

			}

			if (!getSkip("q89a_9", "tblMainQuesMc").equalsIgnoreCase("1")) {

				CommonStaticClass.qskipList.add("q89R9");
				CommonStaticClass.qskipList.add("q89R9Count");
				CommonStaticClass.qskipList.add("q89R9_other");

			}

		}

		if (qName.equalsIgnoreCase("p87a")) {
			CommonStaticClass.qskipList.remove("p87b");
			CommonStaticClass.qskipList.remove("p87bcount");
			CommonStaticClass.qskipList.remove("p87b_other");

			CommonStaticClass.qskipList.remove("p87c");
			CommonStaticClass.qskipList.remove("p87ccount");
			CommonStaticClass.qskipList.remove("p87c_other");

			CommonStaticClass.qskipList.remove("p87d");
			CommonStaticClass.qskipList.remove("p87dcount");
			CommonStaticClass.qskipList.remove("p87d_other");

			CommonStaticClass.qskipList.remove("p87e");
			CommonStaticClass.qskipList.remove("p87ecount");
			CommonStaticClass.qskipList.remove("p87e_other");

			CommonStaticClass.qskipList.remove("p87f");
			CommonStaticClass.qskipList.remove("p87fcount");
			CommonStaticClass.qskipList.remove("p87f_other");

			if (!getSkip("p87a_1", "tblMainQuesMc").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("p87b");
				CommonStaticClass.qskipList.add("p87bcount");
				CommonStaticClass.qskipList.add("p87b_other");

			}

			if (!getSkip("p87a_2", "tblMainQuesMc").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("p87c");
				CommonStaticClass.qskipList.add("p87ccount");
				CommonStaticClass.qskipList.add("p87c_other");

			}

			if (!getSkip("p87a_3", "tblMainQuesMc").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("p87d");
				CommonStaticClass.qskipList.add("p87dcount");
				CommonStaticClass.qskipList.add("p87d_other");

			}

			if (!getSkip("p87a_4", "tblMainQuesMc").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("p87e");
				CommonStaticClass.qskipList.add("p87ecount");
				CommonStaticClass.qskipList.add("p87e_other");

			}

			if (!getSkip("p87a_5", "tblMainQuesMc").equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("p87f");
				CommonStaticClass.qskipList.add("p87fcount");
				CommonStaticClass.qskipList.add("p87f_other");

			}

			return false;

		}

		if (qName.equalsIgnoreCase("q6_2")) {
			String s = "SELECT * from tblMainQuesMc WHERE (q6_2_15 ='1' OR q6_2_16='1') AND dataid='"
					+ CommonStaticClass.dataId + "'";
			if (dbHelper.IsDataExists(s)) {
				CommonStaticClass.findOutNextSLNo(qName, "q6_3");
				CommonStaticClass.nextQuestion(ParentActivity.this);
				return true;
			}
		}

		if (qName.equalsIgnoreCase("q5_2")) {
			String s = "SELECT * from tblMainQuesMc WHERE (q5_2_1 ='1' OR q5_2_4='1') AND dataid='"
					+ CommonStaticClass.dataId + "'";
			if (dbHelper.IsDataExists(s)) {
				CommonStaticClass.findOutNextSLNo(qName, "q5_5");
				CommonStaticClass.nextQuestion(ParentActivity.this);
				return true;
			}
		}

		if (qName.equalsIgnoreCase("q54")) {

			String s = "SELECT * from tblMainQuesMc WHERE (q54_6 ='1') AND dataid='"
					+ CommonStaticClass.dataId + "'";
			if (dbHelper.IsDataExists(s)) {
				CommonStaticClass.findOutNextSLNo(qName, "q55");
				CommonStaticClass.nextQuestion(ParentActivity.this);
				return true;
			}

			s = "SELECT * from tblMainQuesMc WHERE (q54_1 ='1' OR q54_2 ='1' OR q54_3 ='1' OR q54_4 ='1' OR q54_5 ='1' OR q54_7 ='1') AND dataid='"
					+ CommonStaticClass.dataId + "'";
			if (dbHelper.IsDataExists(s)) {
				CommonStaticClass.findOutNextSLNo(qName, "q56");
				CommonStaticClass.nextQuestion(ParentActivity.this);
				return true;
			}
		}

		/*
		 * if (qName.equalsIgnoreCase("q87_R1_C1")) { String s =
		 * "SELECT * from tblMainQuesMc WHERE (q87_R1_C1_11 ='1') AND dataid='"
		 * + CommonStaticClass.dataId + "'"; if (dbHelper.IsDataExists(s)) {
		 * CommonStaticClass.findOutNextSLNo(qName, "q87_R2_C1");
		 * CommonStaticClass.nextQuestion(ParentActivity.this); return true; } }
		 * 
		 * if (qName.equalsIgnoreCase("q87_R2_C1")) { String s =
		 * "SELECT * from tblMainQuesMc WHERE (q87_R2_C1_11 ='1') AND dataid='"
		 * + CommonStaticClass.dataId + "'"; if (dbHelper.IsDataExists(s)) {
		 * CommonStaticClass.findOutNextSLNo(qName, "q87_R3_C1");
		 * CommonStaticClass.nextQuestion(ParentActivity.this); return true; } }
		 * 
		 * if (qName.equalsIgnoreCase("q87_R3_C1")) { String s =
		 * "SELECT * from tblMainQuesMc WHERE (q87_R3_C1_11 ='1') AND dataid='"
		 * + CommonStaticClass.dataId + "'"; if (dbHelper.IsDataExists(s)) {
		 * CommonStaticClass.findOutNextSLNo(qName, "q87_R4_C1");
		 * CommonStaticClass.nextQuestion(ParentActivity.this); return true; } }
		 * 
		 * if (qName.equalsIgnoreCase("q87_R4_C1")) { String s =
		 * "SELECT * from tblMainQuesMc WHERE (q87_R4_C1_11 ='1') AND dataid='"
		 * + CommonStaticClass.dataId + "'"; if (dbHelper.IsDataExists(s)) {
		 * CommonStaticClass.findOutNextSLNo(qName, "q87_R5_C1");
		 * CommonStaticClass.nextQuestion(ParentActivity.this); return true; } }
		 * 
		 * if (qName.equalsIgnoreCase("q87_R5_C1")) { String s =
		 * "SELECT * from tblMainQuesMc WHERE (q87_R5_C1_11 ='1') AND dataid='"
		 * + CommonStaticClass.dataId + "'"; if (dbHelper.IsDataExists(s)) {
		 * CommonStaticClass.findOutNextSLNo(qName, "q88");
		 * CommonStaticClass.nextQuestion(ParentActivity.this); return true; } }
		 */

		// q89
		/*
		 * if (qName.equalsIgnoreCase("q89_R1_C1")) { String s =
		 * "SELECT * from tblMainQuesMc WHERE (q89_R1_C1_11 ='1') AND dataid='"
		 * + CommonStaticClass.dataId + "'"; if (dbHelper.IsDataExists(s)) {
		 * CommonStaticClass.findOutNextSLNo(qName, "q89_R2_C1");
		 * CommonStaticClass.nextQuestion(ParentActivity.this); return true; } }
		 * 
		 * if (qName.equalsIgnoreCase("q89_R2_C1")) { String s =
		 * "SELECT * from tblMainQuesMc WHERE (q89_R2_C1_11 ='1') AND dataid='"
		 * + CommonStaticClass.dataId + "'"; if (dbHelper.IsDataExists(s)) {
		 * CommonStaticClass.findOutNextSLNo(qName, "q89_R3_C1");
		 * CommonStaticClass.nextQuestion(ParentActivity.this); return true; } }
		 * 
		 * if (qName.equalsIgnoreCase("q89_R3_C1")) { String s =
		 * "SELECT * from tblMainQuesMc WHERE (q89_R3_C1_11 ='1') AND dataid='"
		 * + CommonStaticClass.dataId + "'"; if (dbHelper.IsDataExists(s)) {
		 * CommonStaticClass.findOutNextSLNo(qName, "q89_R4_C1");
		 * CommonStaticClass.nextQuestion(ParentActivity.this); return true; } }
		 * 
		 * if (qName.equalsIgnoreCase("q89_R4_C1")) { String s =
		 * "SELECT * from tblMainQuesMc WHERE (q89_R4_C1_11 ='1') AND dataid='"
		 * + CommonStaticClass.dataId + "'"; if (dbHelper.IsDataExists(s)) {
		 * CommonStaticClass.findOutNextSLNo(qName, "q89_R5_C1");
		 * CommonStaticClass.nextQuestion(ParentActivity.this); return true; } }
		 * 
		 * if (qName.equalsIgnoreCase("q89_R5_C1")) { String s =
		 * "SELECT * from tblMainQuesMc WHERE (q89_R5_C1_11 ='1') AND dataid='"
		 * + CommonStaticClass.dataId + "'"; if (dbHelper.IsDataExists(s)) {
		 * CommonStaticClass.findOutNextSLNo(qName, "q89_R6_C1");
		 * CommonStaticClass.nextQuestion(ParentActivity.this); return true; } }
		 * 
		 * if (qName.equalsIgnoreCase("q89_R6_C1")) { String s =
		 * "SELECT * from tblMainQuesMc WHERE (q89_R6_C1_11 ='1') AND dataid='"
		 * + CommonStaticClass.dataId + "'"; if (dbHelper.IsDataExists(s)) {
		 * CommonStaticClass.findOutNextSLNo(qName, "q90");
		 * CommonStaticClass.nextQuestion(ParentActivity.this); return true; } }
		 */
		//
		if (CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo)
				.getQnext1().equalsIgnoreCase("SecP2")) {
			if (CommonStaticClass.qskipList.contains("SecP2")
					&& CommonStaticClass.qskipList.contains("SecP3")) {

				if (IfCompletedAllMembersFrmMultipleChoice()) {
					showUserFinishDialogFrmMultipleChoice();
					return true;
				} else {
					CommonStaticClass.currentSLNo = 31;
					CommonStaticClass.nextQuestion(ParentActivity.this);
					return true;
				}

			}
		}
		if (CommonStaticClass.questionMap.get(CommonStaticClass.currentSLNo)
				.getQnext1().equalsIgnoreCase("END")) {

			showUserFinishDialogFrmMultipleChoice();
			return true;
		}

		/*
		 * else {
		 * 
		 * CommonStaticClass.findOutNextSLNo( qName,
		 * CommonStaticClass.questionMap.get(
		 * CommonStaticClass.currentSLNo).getQnext1());
		 * CommonStaticClass.nextQuestion(ParentActivity.this); }
		 */

		if (qName.equalsIgnoreCase("q61")) {
			String v1 = getSkip("q61_7", "tblMainQuesMc");
			if (v1 != null) {
				if (v1.length() > 0) {
					if (v1.equalsIgnoreCase("1") || v1.equalsIgnoreCase("2")
							|| v1.equalsIgnoreCase("3")
							|| v1.equalsIgnoreCase("5")
							|| v1.equalsIgnoreCase("6")) {
						CommonStaticClass.findOutNextSLNo(
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQvar(), "q61_other");
						CommonStaticClass.nextQuestion(ParentActivity.this);
						return false;
					}
				}
			}
		}
		if (qName.equalsIgnoreCase("q2_6")) {
			// String s =
			// "SELECT q2_6_12 FROM tblMainques WHERE dataid = '" +
			// CommonStaticClass.dataId +"'";
			String v1 = dbHelper.GetSingleColumnData("q2_6_12");

			if (v1.equalsIgnoreCase("2") || v1.equalsIgnoreCase("3")) {
				CommonStaticClass.findOutNextSLNo(CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar(),
						"q2_6_other");

				CommonStaticClass.nextQuestion(ParentActivity.this);
				return false;
			}

		}

		if (qName.equalsIgnoreCase("q61"))

		{

			String GtSkip = getSkip("q61_7", "tblMainQuesMc");

			if (GtSkip.equalsIgnoreCase("1"))

			{

				CommonStaticClass.findOutNextSLNo(qName, "q61_other");

				CommonStaticClass.nextQuestion(ParentActivity.this);
				return false;
			}

		}

		if (qName.equalsIgnoreCase("q7_18_1"))

		{

			String GtSkip = getSkip("q7_18_1_c", "tblMainQuesMc");

			if (GtSkip.equalsIgnoreCase("1"))

			{

				CommonStaticClass.findOutNextSLNo(qName, "q7_18_1_other");

				CommonStaticClass.nextQuestion(ParentActivity.this);
				return false;
			}

		}

		if (qName.equalsIgnoreCase("q7_18_2"))

		{

			String GtSkip = getSkip("q7_18_2_c", "tblMainQuesMc");

			if (GtSkip.equalsIgnoreCase("1"))

			{

				CommonStaticClass.findOutNextSLNo(qName, "q7_18_2_other");

				CommonStaticClass.nextQuestion(ParentActivity.this);
				return false;
			}

		}
		if (qName.equalsIgnoreCase("q7_18_3"))

		{

			String GtSkip = getSkip("q7_18_3_c", "tblMainQuesMc");

			if (GtSkip.equalsIgnoreCase("1"))

			{

				CommonStaticClass.findOutNextSLNo(qName, "q7_18_3_other");

				CommonStaticClass.nextQuestion(ParentActivity.this);
				return false;
			}

		}
		if (qName.equalsIgnoreCase("q7_18_4"))

		{

			String GtSkip = getSkip("q7_18_4_c", "tblMainQuesMc");

			if (GtSkip.equalsIgnoreCase("1"))

			{

				CommonStaticClass.findOutNextSLNo(qName, "q7_18_4_other");

				CommonStaticClass.nextQuestion(ParentActivity.this);
				return false;
			}

		}
		if (qName.equalsIgnoreCase("q7_18_5"))

		{

			String GtSkip = getSkip("q7_18_5_c", "tblMainQuesMc");

			if (GtSkip.equalsIgnoreCase("1"))

			{

				CommonStaticClass.findOutNextSLNo(qName, "q7_18_5_other");

				CommonStaticClass.nextQuestion(ParentActivity.this);

				return false;
			}

		}

		if (qName.equalsIgnoreCase("q7_18_6"))

		{

			String GtSkip = getSkip("q7_18_6_c", "tblMainQuesMc");

			if (GtSkip.equalsIgnoreCase("1"))

			{

				CommonStaticClass.findOutNextSLNo(qName, "q7_18_6_other");

				CommonStaticClass.nextQuestion(ParentActivity.this);

				return false;

			}
		}

		if (qName.equalsIgnoreCase("q65")) {
			String v1 = getSkip("q65_9_1", "tblMainQuesMc");
			if (v1 != null) {
				if (v1.length() > 0) {
					if (v1.equalsIgnoreCase("1")) {
						CommonStaticClass.findOutNextSLNo(
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQvar(), "q65_other");
						CommonStaticClass.nextQuestion(ParentActivity.this);
						return true;
					}
				}
			}
		}

		// q47
		if (qName.equalsIgnoreCase("q47")) {
			String v1 = getSkip("q47_23", "tblMainQuesMc");
			if (v1 != null) {
				if (v1.length() > 0) {
					if (v1.equalsIgnoreCase("1")) {
						CommonStaticClass.findOutNextSLNo(
								CommonStaticClass.questionMap.get(
										CommonStaticClass.currentSLNo)
										.getQvar(), "q47_other");
						CommonStaticClass.nextQuestion(ParentActivity.this);
						return true;
					}
				}
			}
		}

		return false;
	}

	private boolean checkIfSingleEditIsBlank() {
		if (mEditStrings.contains("::")) {
			return true;
		} else
			return false;
	}

	private boolean checkIfSingleEditIsBlankMultipleText() {
		if (mEditStrings.contains("::") || mEditStrings2.contains("::")) {

			return true;
		} else
			return false;
	}

	private boolean checkeditboxValueisvalid() {

		for (int i = 0; i < mEditStrings3.size(); i++) {
			/*
			 * if (Integer.parseInt(mEditStrings.get(i).toString()) >= 0 ||
			 * Integer.parseInt(mEditStrings.get(i).toString()) < 100) {
			 */
			if (Integer.parseInt(mEditStrings3.get(i).toString()) >= 101) {
				return false;

			} else {
				return true;
			}
		}

		return true;
	}

	private void selectCheckAndCombo(String inColumn, CheckBox checkButton,
			Spinner spinner1, EditText ed, Spinner spinner2) {
		// TODO Auto-generated method stub
		Log.e("inColumn: ", "" + inColumn);
		String sql = "";

		// if (!CommonStaticClass.isMember)
		// sql = "Select "
		// + inColumn
		// + ","
		// + inColumn
		// + " from "
		// + CommonStaticClass.questionMap.get(
		// CommonStaticClass.currentSLNo).getTablename()
		// + " where dataid='" + CommonStaticClass.dataId + "'";
		// else
		// sql = "Select "
		// + inColumn
		// + "_1,"
		// + inColumn
		// + "_2 from "
		// + CommonStaticClass.questionMap.get(
		// CommonStaticClass.currentSLNo).getTablename()
		// + " where dataid='" + CommonStaticClass.dataId
		// + "' and memberid=" + CommonStaticClass.memberID;
		sql = "Select * "
				+ " from "
				+ CommonStaticClass.questionMap.get(
						CommonStaticClass.currentSLNo).getTablename()
				+ " where dataid='" + CommonStaticClass.dataId + "'";

		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {

				doFillpos(mCursor1, inColumn, checkButton, spinner1, ed,
						spinner2);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}

	}

	private void selectCheckMultipleCheckTextTwo(String inColumn,
			CheckBox checkButton, EditText ed, EditText ed2) {
		// TODO Auto-generated method stub
		Log.e("inColumn: ", "" + inColumn);
		String sql = "";

		sql = "Select * "
				+ " from "
				+ CommonStaticClass.questionMap.get(
						CommonStaticClass.currentSLNo).getTablename()
				+ " where dataid='" + CommonStaticClass.dataId + "'";

		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				doFillposMultipleCheckTextTwo(mCursor1, inColumn, checkButton,
						ed, ed2);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}

	}

	private void selectCheckAndCombo(String inColumn, CheckBox checkButton,
			Spinner spinner1, Spinner spinner2, Spinner spinner3) {
		// TODO Auto-generated method stub
		Log.e("inColumn: ", "" + inColumn);
		String sql = "";

		sql = "Select * "
				+ " from "
				+ CommonStaticClass.questionMap.get(
						CommonStaticClass.currentSLNo).getTablename()
				+ " where dataid='" + CommonStaticClass.dataId + "'";

		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				doFillpos(mCursor1, inColumn, checkButton, spinner1, spinner2,
						spinner3);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}

	}

	private void selectCheckAndCombo(String inColumn, CheckBox checkButton,
			Spinner spinner1, Spinner spinner2) {
		// TODO Auto-generated method stub
		Log.e("inColumn: ", "" + inColumn);
		String sql = "";

		// if (!CommonStaticClass.isMember)
		// sql = "Select "
		// + inColumn
		// + ","
		// + inColumn
		// + " from "
		// + CommonStaticClass.questionMap.get(
		// CommonStaticClass.currentSLNo).getTablename()
		// + " where dataid='" + CommonStaticClass.dataId + "'";
		// else
		// sql = "Select "
		// + inColumn
		// + "_1,"
		// + inColumn
		// + "_2 from "
		// + CommonStaticClass.questionMap.get(
		// CommonStaticClass.currentSLNo).getTablename()
		// + " where dataid='" + CommonStaticClass.dataId
		// + "' and memberid=" + CommonStaticClass.memberID;
		sql = "Select * "
				+ " from "
				+ CommonStaticClass.questionMap.get(
						CommonStaticClass.currentSLNo).getTablename()
				+ " where dataid='" + CommonStaticClass.dataId + "'";

		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.getCount() > 0) {
				doFillpos(mCursor1, inColumn, checkButton, spinner1, spinner2);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}

	}

	private boolean doFillpos(Cursor mCursor1, String columnPrefix,
			CheckBox checkButton, Spinner spinner1, Spinner spinner2,
			Spinner spinner3) {
		boolean dataOk = false;
		String column1 = columnPrefix + "_1";
		String column2 = columnPrefix + "_2";
		String column3 = columnPrefix + "_3";
		String column4 = columnPrefix + "_4";
		if (mCursor1.moveToFirst()) {
			do {
				if (mCursor1.getColumnIndexOrThrow(column1) != -1
						&& mCursor1.getColumnIndexOrThrow(column2) != -1
						&& mCursor1.getColumnIndexOrThrow(column3) != -1
						&& mCursor1.getColumnIndexOrThrow(column4) != -1) {
					try {

						String a = mCursor1.getString(mCursor1
								.getColumnIndex(column1));
						String b = mCursor1.getString(mCursor1
								.getColumnIndex(column2));
						String c = mCursor1.getString(mCursor1
								.getColumnIndex(column3));
						String d = mCursor1.getString(mCursor1
								.getColumnIndex(column4));
						if (Integer.parseInt(a) == 1) {
							checkButton.setChecked(true);
						} else if (Integer.parseInt(a) == 0) {
							checkButton.setChecked(false);
						}
						if (optionCodeList1.contains(Integer.parseInt(b))) {
							int pos = optionCodeList1.indexOf(Integer
									.parseInt(b));

							spinner1.setSelection(pos);
							dataOk = true;
						}
						if (optionCodeList2.contains(Integer.parseInt(c))) {
							int pos = optionCodeList2.indexOf(Integer
									.parseInt(c));

							spinner2.setSelection(pos);
							dataOk = true;
						}
						if (optionCodeList3.contains(Integer.parseInt(d))) {
							int pos = optionCodeList3.indexOf(Integer
									.parseInt(d));

							spinner3.setSelection(pos);
							dataOk = true;
						}

					} catch (Exception e) {
						// TODO: handle exception
					}

				}

			} while (mCursor1.moveToNext());
		}

		return dataOk;
	}

	private boolean doFillpos(Cursor mCursor1, String columnPrefix,
			CheckBox checkButton, Spinner spinner1, EditText ed,
			Spinner spinner2) {
		boolean dataOk = false;
		String column1 = columnPrefix + "_1";
		String column2 = columnPrefix + "_2";
		String column3 = columnPrefix + "_3";
		String column4 = columnPrefix + "_4";
		if (mCursor1.moveToFirst()) {
			do {
				if (mCursor1.getColumnIndexOrThrow(column1) != -1
						&& mCursor1.getColumnIndexOrThrow(column2) != -1
						&& mCursor1.getColumnIndexOrThrow(column3) != -1
						&& mCursor1.getColumnIndexOrThrow(column4) != -1) {
					try {

						String a = mCursor1.getString(mCursor1
								.getColumnIndex(column1));
						String b = mCursor1.getString(mCursor1
								.getColumnIndex(column2));
						String c = mCursor1.getString(mCursor1
								.getColumnIndex(column3));
						String d = mCursor1.getString(mCursor1
								.getColumnIndex(column4));
						if (Integer.parseInt(a) == 1) {
							checkButton.setChecked(true);
						} else if (Integer.parseInt(a) == 0) {
							checkButton.setChecked(false);
						}
						if (b != null && b.length() > 0
								&& !b.equalsIgnoreCase("-1")) {
							ed.setText(b);
						}
						if (optionCodeList1.contains(Integer.parseInt(c))) {
							int pos = optionCodeList1.indexOf(Integer
									.parseInt(c));

							spinner1.setSelection(pos);
							dataOk = true;
						}
						if (optionCodeList2.contains(Integer.parseInt(d))) {
							int pos = optionCodeList2.indexOf(Integer
									.parseInt(d));

							spinner2.setSelection(pos);
							dataOk = true;
						}

					} catch (Exception e) {
						// TODO: handle exception
					}

				}

			} while (mCursor1.moveToNext());
		}

		return dataOk;
	}

	private boolean doFillposMultipleCheckTextTwo(Cursor mCursor1,
			String columnPrefix, CheckBox checkButton, EditText ed, EditText ed2) {
		boolean dataOk = false;
		String column1 = columnPrefix + "_1";
		String column2 = columnPrefix + "_2";
		String column3 = columnPrefix + "_3";

		if (mCursor1.moveToFirst()) {
			do {
				if (mCursor1.getColumnIndexOrThrow(column1) != -1
						&& mCursor1.getColumnIndexOrThrow(column2) != -1
						&& mCursor1.getColumnIndexOrThrow(column3) != -1
				/*
				 * && mCursor1.getColumnIndexOrThrow(column4) != -1 &&
				 * mCursor1.getColumnIndexOrThrow(column5) != -1 &&
				 * mCursor1.getColumnIndexOrThrow(column6) != -1
				 */) {
					try {

						String a = mCursor1.getString(mCursor1
								.getColumnIndex(column1));
						String b = mCursor1.getString(mCursor1
								.getColumnIndex(column2));
						String c = mCursor1.getString(mCursor1
								.getColumnIndex(column3));
						/*
						 * String d = mCursor1.getString(mCursor1
						 * .getColumnIndex(column4));
						 * 
						 * String e = mCursor1.getString(mCursor1
						 * .getColumnIndex(column5)); String f =
						 * mCursor1.getString(mCursor1 .getColumnIndex(column6)
						 */// );

						if (Integer.parseInt(a) == 1) {
							checkButton.setChecked(true);
						} else if (Integer.parseInt(a) == 0) {
							checkButton.setChecked(false);
						}
						if (b != null && b.length() > 0
								&& !b.equalsIgnoreCase("-1")) {
							ed.setText(b);
						}

						if (c != null && c.length() > 0
								&& !c.equalsIgnoreCase("-1")) {
							ed2.setText(c);
						}

						/*
						 * if (f != null && f.length() > 0 &&
						 * !f.equalsIgnoreCase("-1")) { ed3.setText(f); }
						 * 
						 * if (optionCodeList1.contains(Integer.parseInt(c))) {
						 * int pos = optionCodeList1.indexOf(Integer
						 * .parseInt(c));
						 * 
						 * spinner1.setSelection(pos); dataOk = true; } if
						 * (optionCodeList2.contains(Integer.parseInt(d))) { int
						 * pos = optionCodeList2.indexOf(Integer .parseInt(d));
						 * 
						 * spinner2.setSelection(pos); dataOk = true; }
						 */
						dataOk = true;

					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			} while (mCursor1.moveToNext());
		}

		return dataOk;
	}

	private boolean doFillpos(Cursor mCursor1, String columnPrefix,
			CheckBox checkButton, Spinner spinner1, Spinner spinner2) {
		boolean dataOk = false;
		String column1 = columnPrefix + "_1";
		String column2 = columnPrefix + "_2";
		String column3 = columnPrefix + "_3";
		if (mCursor1.moveToFirst()) {
			do {
				if (mCursor1.getColumnIndexOrThrow(column1) != -1
						&& mCursor1.getColumnIndexOrThrow(column2) != -1
						&& mCursor1.getColumnIndexOrThrow(column3) != -1) {
					try {

						String a = mCursor1.getString(mCursor1
								.getColumnIndex(column1));
						String b = mCursor1.getString(mCursor1
								.getColumnIndex(column2));
						String c = mCursor1.getString(mCursor1
								.getColumnIndex(column3));
						if (Integer.parseInt(a) == 1) {
							checkButton.setChecked(true);
						} else if (Integer.parseInt(a) == 0) {
							checkButton.setChecked(false);
						}
						if (optionCodeList1.contains(Integer.parseInt(b))) {
							int pos = optionCodeList1.indexOf(Integer
									.parseInt(b));

							spinner1.setSelection(pos);
							dataOk = true;
						}
						if (optionCodeList2.contains(Integer.parseInt(c))) {
							int pos = optionCodeList2.indexOf(Integer
									.parseInt(c));

							spinner2.setSelection(pos);
							dataOk = true;
						}

					} catch (Exception e) {
						// TODO: handle exception
					}

				}

			} while (mCursor1.moveToNext());
		}

		return dataOk;
	}

	private boolean doFillpos(Cursor mCursor1, String columnPrefix,
			CheckBox checkButton, Spinner spinner1) {
		boolean dataOk = false;
		String column1 = columnPrefix + "_1";
		String column2 = columnPrefix + "_2";
		String column3 = columnPrefix + "_3";
		if (mCursor1.moveToFirst()) {
			do {
				if (mCursor1.getColumnIndexOrThrow(column1) != -1
						&& mCursor1.getColumnIndexOrThrow(column2) != -1
				/*
				 * && mCursor1.getColumnIndexOrThrow(column3) != -1 &&
				 * mCursor1.getColumnIndexOrThrow(column4) != -1
				 */
				) {
					try {

						String a = mCursor1.getString(mCursor1
								.getColumnIndex(column1));
						String b = mCursor1.getString(mCursor1
								.getColumnIndex(column2));
						String c = mCursor1.getString(mCursor1
								.getColumnIndex(column3));
						/*
						 * String d = mCursor1.getString(mCursor1
						 * .getColumnIndex(column4));
						 */
						if (Integer.parseInt(a) == 1) {
							checkButton.setChecked(true);
						} else if (Integer.parseInt(a) == 0) {
							checkButton.setChecked(false);
						}
						if (optionCodeList1.contains(Integer.parseInt(b))) {
							int pos = optionCodeList1.indexOf(Integer
									.parseInt(b));

							spinner1.setSelection(pos);
							dataOk = true;
						}

						if (optionCodeList2.contains(Integer.parseInt(c))) {
							optionCodeList2.indexOf(Integer.parseInt(c));

							// spinner2.setSelection(pos); dataOk = true; }
							// if
							// (optionCodeList3.contains(Integer.parseInt(d))) {
							// int
							// pos = optionCodeList3.indexOf(Integer
							// .parseInt(d));

							// spinner3.setSelection(pos); dataOk = true;
						}

					} catch (Exception e) {
						// TODO: handle exception
					}

				}

			} while (mCursor1.moveToNext());
		}

		return dataOk;
	}

	public int getFormIndex(String formname) {
		int index = 0;
		if (formname.equalsIgnoreCase("FrmHHID")) {
			index = 0;
		}
		if (formname.equalsIgnoreCase("FrmComboBox")) {
			index = 2;
		}
		if (formname.equalsIgnoreCase("FrmDate")) {
			index = 3;
		}
		if (formname.equalsIgnoreCase("FrmFamilyMember")) {
			index = 4;
		}
		if (formname.equalsIgnoreCase("FrmMessage")) {
			index = 6;
		}
		if (formname.equalsIgnoreCase("FrmMultipleCheckCombo")) {
			index = 7;
		}
		if (formname.equalsIgnoreCase("FrmMultipleChoice")) {
			index = 8;
		}
		if (formname.equalsIgnoreCase("FrmMultipleCombo")) {
			index = 9;
		}
		if (formname.equalsIgnoreCase("FrmNotes")) {
			index = 10;
		}
		if (formname.equalsIgnoreCase("FrmNumeric")) {
			index = 11;
		}
		if (formname.equalsIgnoreCase("FrmNumericOption")) {
			index = 12;
		}
		if (formname.equalsIgnoreCase("FrmReasoning")) {
			index = 13;
		}
		if (formname.equalsIgnoreCase("FrmSingleChoice")) {
			index = 14;
		}
		if (formname.equalsIgnoreCase("FrmText")) {
			index = 15;
		}
		if (formname.equalsIgnoreCase("FrmTime")) {
			index = 16;
		}
		if (formname.equalsIgnoreCase("FrmYearToMin")) {
			index = 17;
		}
		if (formname.equalsIgnoreCase("gpsdatacollection")) {
			index = 18;
		}
		if (formname.equalsIgnoreCase("FrmNumericTwo")) {
			index = 19;
		}
		if (formname.equalsIgnoreCase("FrmNumericwithunknownDecline")) {
			index = 20;
		}

		if (formname.equalsIgnoreCase("frmcomboswitheditspiner")) {
			index = 21;
		}
		if (formname.equalsIgnoreCase("frmmultiplecheckcombotwo")) {
			index = 22;
		}
		if (formname.equalsIgnoreCase("frmmultiplechoiceradio")) {
			index = 23;
		}

		if (formname.equalsIgnoreCase("frmmultiple"))
		// || formname.equalsIgnoreCase("frmmultiplebangla"))
		{
			index = 24;
		}
		if (formname.equalsIgnoreCase("frmq124")) {
			index = 25;
		}

		if (formname.equalsIgnoreCase("frmmultiplechecknumeric")) {
			index = 26;
		}
		if (formname.equalsIgnoreCase("frmmultiplecheckdate")) {
			index = 27;
		}
		if (formname.equalsIgnoreCase("frmpatientdetail")) {
			index = 28;
		}

		if (formname.equalsIgnoreCase("frmweight")) {
			index = 29;
		}
		if (formname.equalsIgnoreCase("frmdiarrhea")) {
			index = 30;
		}
		if (formname.equalsIgnoreCase("frmvomiting")) {
			index = 31;
		}
		if (formname.equalsIgnoreCase("frmors")) {
			index = 32;
		}

		if (formname.equalsIgnoreCase("frmchildren")) {
			index = 33;
		}
		if (formname.equalsIgnoreCase("frmhouseholdfoodconsumption")) {
			index = 34;
		}
		if (formname.equalsIgnoreCase("frmmultiplechecktexttwo")) {
			index = 35;
		}
		if (formname.equalsIgnoreCase("frmlandused")) {
			index = 36;
		}
		if (formname.equalsIgnoreCase("frmcropproduction")) {
			index = 37;
		}

		if (formname.equalsIgnoreCase("frmfishproduction")) {
			index = 38;
		}
		if (formname.equalsIgnoreCase("frmcropfishproductioncost")) {
			index = 39;
		}
		if (formname.equalsIgnoreCase("frmcropcultivationreserve")) {
			index = 40;
		}
		if (formname.equalsIgnoreCase("frmwatermanagementproblem")) {
			index = 41;
		}
		if (formname.equalsIgnoreCase("frmproductionmarketinglivestock")) {
			index = 42;
		}
		if (formname.equalsIgnoreCase("frmlivestockproducts")) {
			index = 43;
		}
		if (formname.equalsIgnoreCase("frmvulnarable")) {
			index = 44;
		}

		return index;
	}

	public void gotoForm(String formname) {
		// TODO Auto-generated method stub
		if (CommonStaticClass.dataId.length() > 0) {
			dataidViewer.setText("HH ID: " + CommonStaticClass.dataId);
		}
		lastIndexBeforeFraNotes = formFlipper.getDisplayedChild();
		formFlipper.setDisplayedChild(getFormIndex(formname));
		formFlipper.setInAnimation(this, android.R.anim.slide_in_left);
		formFlipper.setOutAnimation(this, android.R.anim.slide_out_right);

		/*
		 * formFlipper.setInAnimation(this, R.anim.slide_in_up);
		 * formFlipper.setOutAnimation(this, R.anim.slide_out_up);
		 */

		switch (getFormIndex(formname)) {
		case 0:

			loadGuiFrmHHID(frmdataid);
			break;
		case 1:

			break;
		case 2:
			Load_UIFrmComboBox(frmcombobox);
			break;
		case 3:
			loadGuiFrmDate(frmdate);
			break;
		case 4:
			loadGuiFrmFamilyMember(frmfamilymember);
			break;
		case 5:
			loadGuiFrmHHID(frmhhid);
			break;
		case 6:
			loadGuiFrmMessage(frmmessage);
			break;
		case 7:
			loadGuiFrmMultipleCheckCombo(frmmultiplecheckcombo);
			break;
		case 8:
			loadGuiFrmMultipleChoice(frmmultiplechoice);
			break;
		case 9:
			Load_UIFrmComboBox(frmcombobox);
			break;
		case 10:
			loadGuiFrmNotes(frmnotes);
			break;
		case 11:
			loadGuiFrmNumeric(frmnumeric);
			break;
		case 12:
			loadGuiFrmNumeric(frmnumeric);
			break;
		case 13:
			Load_UIFrmReasoning(frmreasoning);
			break;
		case 14:
			Load_UIFrmSingleChoice(frmsinglechoice);
			break;
		case 15:
			loadGuiFrmText(frmtext);
			break;
		case 16:
			loadGuiFrmTime(frmtime);
			break;
		case 17:
			loadGuiFrmYearToMin(frmyeartomin);
			break;
		case 18:
			Load_UIFrmGPSDataCollection(gpsdatacollection);
			break;
		case 19:
			loadGuiFrmNumericTwo(frmnumerictwo);
			break;
		case 20:
			loadGuiFrmNumericWithUnknowDecline(frmnumericwithunknowndecline);
			break;

		case 21:
			// loadGuiFrmCombosWithEditSpinner(20, frmcomboswitheditspiner);
			break;

		case 22:

			loadGuiMultipleCheckCombotwo(frmmultiplecheckcombotwo);

			break;

		case 23:
			loadGuiFrmMultipleChoiceRadio(frmmultiplechoiceradio);
			break;

		case 24:
			loadGuiFrmMultiple(frmmultiple);
			break;

		case 25:
			loadGuiFrmq124(frmq124);
			break;

		case 26:
			loadGuiFrmMultipleCheckNumeric(frmmultiplechecknumeric);
			break;

		case 27:
			loadguifrmmultiplecheckdate(frmmultiplecheckdate);
			break;

		case 28:
			loadguifrmpatientdetail(frmpatientdetail);
			break;

		case 29:
			loadguifrmweight(frmweight);
			break;

		case 30:
			loadguifrmdiarrhea(frmdiarrhea);
			break;

		case 31:
			loadguifrmvomiting(frmvomiting);
			break;

		case 32:
			loadguifrmors(frmors);
			break;

		case 33:
			loadguifrmchildren(frmchildren);
			break;

		case 34:
			loadGuiFrmHouseholdFoodCompumption(frmhouseholdfoodconsumption);
			break;

		case 35:
			loadGuiMultipleChecktexttwo(frmmultiplechecktexttwo);
			break;

		case 36:
			loadGuiFrmLandUsed(frmlandused);
			break;

		case 37:
			loadGuiFrmCropProduction(frmcropproduction);
			break;

		case 38:
			loadGuiFrmFishProduction(frmfishproduction);
			break;

		case 39:
			loadGuiFrmCropFishProductionCost(frmcropfishproductioncost);
			break;

		case 40:
			loadGuiFrmCropCultivationReserve(frmcropcultivationreserve);
			break;

		case 41:
			loadGuiFrmWaterManagementProblem(frmwatermanagementproblem);
			break;

		case 42:
			loadGuiFrmproductionmarketinglivestock(frmproductionmarketinglivestock);
			break;

		case 43:
			loadGuifrmlivestockproducts(frmlivestockproducts);
			break;

		case 44:
			loadGuiFrmVulnarable(frmvulnarable);
			break;
		default:

			break;
		}

	}

	private ArrayList<String> optionList = null;
	private ArrayList<Integer> optionCodeList = null;
	private EditText touchedBox;

	private void loadguifrmmultiplecheckdate(final ViewGroup v) {
		// TODO Auto-generated method stub
		qqq = (TextView) v.findViewById(R.id.qqq);
		optionList = new ArrayList<String>();
		optionCodeList = new ArrayList<Integer>();
		listvalues = new ArrayList<String>();
		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();

		op = new Options();
		if (listvalues != null && listvalues.size() > 0) {
			listvalues.clear();
		}
		// Load Question
		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		checkBoxHolder = (LinearLayout) v.findViewById(R.id.checkBoxHolder);
		checkBoxHolder.removeAllViews();
		op = CommonStaticClass.findOptionsForThisQuestion(dbHelper,
				CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar());

		LinearLayout.LayoutParams lnlParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		LinearLayout.LayoutParams layoutParamForcheck = new LinearLayout.LayoutParams(
				(dm.widthPixels / 3) * 2,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		LinearLayout.LayoutParams layoutParamForSpin = new LinearLayout.LayoutParams(
				(dm.widthPixels / 3), LinearLayout.LayoutParams.WRAP_CONTENT);

		optionList.add("");
		optionCodeList.add(-1);

		for (int i = 0; i < op.codeList.size(); i++) {
			/*
			 * if (op.qidList.get(i).contains("Options")) {
			 * Log.e("op.qidList.get(i)", op.qidList.get(i)); if
			 * (CommonStaticClass.langBng) {
			 * optionList.add(op.capBngList.get(i)); } else {
			 * optionList.add(op.capEngList.get(i)); }
			 * optionCodeList.add(op.codeList.get(i)); continue; }
			 */
			listvalues.add("-1");
		}
		for (int i = 0; i < op.codeList.size(); i++) {

			Log.e("op.qidList.get(i)", op.qidList.get(i));
			/*
			 * if (op.qidList.get(i).contains("Options")) { continue; }
			 */
			LinearLayout ln = new LinearLayout(this);
			ln.setOrientation(LinearLayout.HORIZONTAL);
			final CheckBox checkButton = new CheckBox(this);
			if (CommonStaticClass.langBng) {
				checkButton.setTypeface(font);
				checkButton
						.setText(op.capBngList.get(i).length() > 0 ? op.capBngList
								.get(i) : op.capEngList.get(i));
			} else {
				checkButton.setTypeface(null);
				checkButton.setText(op.capEngList.get(i));
			}
			checkButton.setId(i);
			final EditText spinner = new EditText(this);
			layoutParamForSpin.weight = 1;
			ln.addView(spinner, 0, layoutParamForSpin);
			spinner.setId(i);
			spinner.setVisibility(View.INVISIBLE);
			ln.addView(checkButton, 0, layoutParamForcheck);

			// if (!(spinner.getText().toString().length() > 0))
			updateDisplay("date");

			spinner.setOnTouchListener(new View.OnTouchListener() {

				public boolean onTouch(View v, MotionEvent event) {
					// TODO Auto-generated method stub
					final Calendar c = Calendar.getInstance();
					dateYear = c.get(Calendar.YEAR);
					dateMonth = c.get(Calendar.MONTH);
					dateDay = c.get(Calendar.DAY_OF_MONTH);
					touchedBox = (EditText) v;
					showDialog(DATE_DIALOG);
					return false;
				}
			});

			/*
			 * if (listvalues != null && listvalues.size() > 0) {
			 * listvalues.clear(); } optionList1 = new ArrayList<String>();
			 * optionCodeList1 = new ArrayList<Integer>(); qqq = (TextView)
			 * v.findViewById(R.id.qqq); qName = CommonStaticClass.questionMap
			 * .get(CommonStaticClass.currentSLNo).getQvar();
			 * 
			 * if (CommonStaticClass.langBng) { if
			 * (CommonStaticClass.questionMap
			 * .get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
			 * qqq.setTypeface(font); } ;
			 * qqq.setText(CommonStaticClass.questionMap
			 * .get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ?
			 * CommonStaticClass.questionMap
			 * .get(CommonStaticClass.currentSLNo).getQdescbng() :
			 * CommonStaticClass.questionMap.get(
			 * CommonStaticClass.currentSLNo).getQdesceng()); } else {
			 * qqq.setTypeface(null);
			 * qqq.setText(CommonStaticClass.questionMap.get(
			 * CommonStaticClass.currentSLNo).getQdesceng()); }
			 * 
			 * checkBoxHolder = (LinearLayout)
			 * v.findViewById(R.id.checkBoxHolder);
			 * checkBoxHolder.removeAllViews(); op =
			 * CommonStaticClass.findOptionsForThisQuestion(dbHelper,
			 * CommonStaticClass.questionMap
			 * .get(CommonStaticClass.currentSLNo).getQvar());
			 * 
			 * LinearLayout.LayoutParams lnlParams = new
			 * LinearLayout.LayoutParams( LinearLayout.LayoutParams.FILL_PARENT,
			 * LinearLayout.LayoutParams.WRAP_CONTENT);
			 * LinearLayout.LayoutParams layoutParamForcheck = new
			 * LinearLayout.LayoutParams( ((dm.widthPixels - 65) / 3) * 2,
			 * LinearLayout.LayoutParams.WRAP_CONTENT);
			 * LinearLayout.LayoutParams layoutParamForSpin = new
			 * LinearLayout.LayoutParams( ((dm.widthPixels + 65) / 3),
			 * LinearLayout.LayoutParams.WRAP_CONTENT);
			 * 
			 * for (int i = 0; i < op.codeList.size(); i++) {
			 * 
			 * listvalues.add("-1"); }
			 * 
			 * for (int i = 0; i < op.codeList.size(); i++) {
			 * 
			 * Log.e("op.qidList.get(i)", op.qidList.get(i));
			 * 
			 * LinearLayout ln = new LinearLayout(this);
			 * ln.setOrientation(LinearLayout.HORIZONTAL); final CheckBox
			 * checkButton = new CheckBox(this); if (CommonStaticClass.langBng)
			 * { checkButton.setTypeface(font); checkButton
			 * .setText(op.capBngList.get(i).length() > 0 ? op.capBngList
			 * .get(i) : op.capEngList.get(i)); } else {
			 * checkButton.setTypeface(null);
			 * checkButton.setText(op.capEngList.get(i)); }
			 * checkButton.setId(i);
			 * 
			 * final EditText spinner = new EditText(this); spinner.setId(i);
			 * 
			 * spinner.setInputType(InputType.TYPE_CLASS_DATETIME);
			 * 
			 * layoutParamForSpin.weight = 1; ln.addView(spinner, 0,
			 * layoutParamForSpin); spinner.setVisibility(View.INVISIBLE);
			 * ln.addView(checkButton, 0, layoutParamForcheck);
			 * 
			 * if (!(spinner.getText().toString().length() > 0))
			 * updateDisplay("date");
			 * 
			 * spinner.setOnTouchListener(new View.OnTouchListener() {
			 * 
			 * public boolean onTouch(View v, MotionEvent event) { // TODO
			 * Auto-generated method stub etpickdate = (EditText) v;
			 * showDialog(DATE_DIALOG); return false; } });
			 */

			/*
			 * spinner.setOnTouchListener(new OnTouchListener() {
			 * 
			 * public boolean onTouch(View arg0, MotionEvent arg1) { // TODO
			 * Auto-generated method stub if (checkButton.isChecked()) {
			 * showDialog(DATE_DIALOG); // if (s.toString().length() > 0) {
			 * 
			 * if (!(spinner.getText().toString().length() > 0)) { etpickdate =
			 * spinner; updateDisplay("date"); }
			 * 
			 * listvalues.set(checkButton.getId(), spinner.getText()
			 * .toString()); } return false; }
			 * 
			 * });
			 */

			/*
			 * et.addTextChangedListener(new TextWatcher() {
			 * 
			 * public void onTextChanged(CharSequence s, int start, int before,
			 * int count) { // TODO Auto-generated method stub
			 * 
			 * }
			 * 
			 * public void beforeTextChanged(CharSequence s, int start, int
			 * count, int after) { // TODO Auto-generated method stub
			 * 
			 * }
			 * 
			 * public void afterTextChanged(Editable s) {
			 * 
			 * if (checkButton.isChecked()) { if (s.toString().length() > 0) {
			 * aaa.set(checkButton.getId(), Integer.parseInt(s.toString())); } }
			 * } });
			 */

			checkBoxHolder.addView(ln, 0, lnlParams);

			checkButton
					.setOnCheckedChangeListener(new OnCheckedChangeListener() {

						public void onCheckedChanged(CompoundButton buttonView,
								boolean isChecked) {
							// TODO Auto-generated method stub
							if (isChecked) {
								Log.e("id :", "" + checkButton.getId());
								listvalues.set(checkButton.getId(), "-1");
								spinner.setVisibility(View.VISIBLE);

							} else {
								listvalues.set(checkButton.getId(), "-1");
								spinner.setVisibility(View.INVISIBLE);
							}
						}
					});

			selectCheckAndDateFrmMultipleCheckDate(op.qidList.get(i),
					checkButton, spinner);

		}

		saveNxtButton = (Button) v.findViewById(R.id.saveNxtButton);

		saveNxtButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateTableDataFrmMultipleCheckDate();
				// preserveState();
			}

		});
		clButton = (Button) v.findViewById(R.id.clButton);
		clButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) v);
			}

		});
		notesButton = (Button) v.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});
		prevButton = (Button) v.findViewById(R.id.prevButton);
		prevButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});

	}

	private boolean doFillFrmMultipleCheckDate(Cursor mCursor1,
			String inColumn, CheckBox checkButton, EditText spinner) {
		boolean dataOk = false;
		if (mCursor1.moveToFirst()) {
			do {
				if (mCursor1.getColumnIndexOrThrow(inColumn) != -1) {
					Log.e("column", "exist column:" + inColumn);
					try {
						String a = mCursor1.getString(mCursor1
								.getColumnIndex(inColumn));
						Log.e("a", a + "   lklklk");
						if (!a.equalsIgnoreCase("-1")
								&& !a.equalsIgnoreCase(null)) {

							// if(a!=null&&a.length()>0){
							checkButton.setChecked(true);
							spinner.setText(a);
							listvalues.set(checkButton.getId(), a);
							dataOk = true;
							// }
						} else {
							listvalues.set(checkButton.getId(), "-1");
						}

					} catch (Exception e) {
						// TODO: handle exception
					}

				}

			} while (mCursor1.moveToNext());
		}

		return dataOk;
	}

	private void spinnerVisibleButNotSeletedFrmMultipleCheckDate(
			ViewGroup viewGroup) {
		int nrOfChildren = viewGroup.getChildCount();
		for (int i = 0; i < nrOfChildren; i++) {
			View view = viewGroup.getChildAt(i);

			if (view instanceof Spinner
					&& (view.getVisibility() == View.VISIBLE)) {
				if (((Spinner) view).getSelectedItemPosition() == 0) {
					spinnerOK = false;
				}
			}
			if (view instanceof ViewGroup) {
				spinnerVisibleButNotSeletedFrmMultipleCheckDate((ViewGroup) view);
			}
		}
	}

	private boolean checkIfSingleOptionIsCheckedFrmMultipleCheckDate() {
		for (int i = 0; i < listvalues.size(); i++) {
			if (!(listvalues.get(i).equalsIgnoreCase("-1"))) {
				return true;
			}

		}
		return false;
	}

	/*
	 * private void selectCheckAndDateFrmMultipleCheckDate(String inColumn,
	 * CheckBox checkButton, EditText spinner) { // TODO Auto-generated method
	 * stub String sql = String.format("Select " + inColumn +
	 * " from '%s' where dataid='%s'", CommonStaticClass.questionMap
	 * .get(CommonStaticClass.currentSLNo).getTablename(),
	 * CommonStaticClass.dataId); Cursor mCursor1 = null; try { mCursor1 =
	 * dbHelper.getQueryCursor(sql); boolean a = false; if (mCursor1.getCount()
	 * > 0) { a = doFillFrmMultipleCheckDate(mCursor1, inColumn, checkButton,
	 * spinner); } if (!a) { if (CommonStaticClass.previousDataFound) { if
	 * (CommonStaticClass.previousqlist.contains(qName)) {
	 * 
	 * sql = String.format( "Select " + inColumn +
	 * " from '%s' where dataid='%s'", CommonStaticClass.questionMap.get(
	 * CommonStaticClass.currentSLNo) .getTablename(),
	 * CommonStaticClass.dataId);
	 * 
	 * mCursor1 = dbHelper.getQueryCursor(sql); if (mCursor1.getCount() > 0) {
	 * doFillFrmMultipleCheckDate(mCursor1, inColumn, checkButton, spinner); } }
	 * } }
	 * 
	 * } catch (Exception e) { // TODO: handle exception e.printStackTrace(); }
	 * finally { if (mCursor1 != null) mCursor1.close(); }
	 * 
	 * }
	 */

	private void selectCheckAndDateFrmMultipleCheckDate(String inColumn,
			CheckBox checkButton, EditText et) {
		// TODO Auto-generated method stub
		String sql = "";
		if (!CommonStaticClass.isMember)
			sql = "Select "
					+ inColumn
					+ " from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId + "'";
		else
			sql = "Select "
					+ inColumn
					+ " from "
					+ CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getTablename()
					+ " where dataid='" + CommonStaticClass.dataId
					+ "' and memberid=" + CommonStaticClass.memberID;

		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			boolean a = false;
			if (mCursor1.getCount() > 0) {
				doFillFrmMultipleCheckDate(mCursor1, inColumn, checkButton, et);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mCursor1 != null)
				mCursor1.close();
		}

	}

	private void updateTableDataFrmMultipleCheckDate() {
		// TODO Auto-generated method stub
		spinnerOK = true;
		spinnerVisibleButNotSeletedFrmMultipleCheckDate((ViewGroup) findViewById(R.id.rootView));
		if (spinnerOK) {
			if (checkIfSingleOptionIsCheckedFrmMultipleCheckDate()) {
				String sql = "UPDATE "
						+ CommonStaticClass.questionMap.get(
								CommonStaticClass.currentSLNo).getTablename()
						+ " SET ";
				for (int i = 0; i < op.codeList.size(); i++) {
					if (i == (op.codeList.size() - 1)) {
						sql += op.qidList.get(i) + " = '" + listvalues.get(i)
								+ "' ";
						break;
					}
					sql += op.qidList.get(i) + " = '" + listvalues.get(i)
							+ "',";
				}
				sql += "where dataid='" + CommonStaticClass.dataId + "'";

				if (dbHelper.executeDMLQuery(sql)) {
					listvalues.clear();
					CommonStaticClass.findOutNextSLNo(
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQvar(),
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQnext1());
					CommonStaticClass.nextQuestion(ParentActivity.this);

					/*
					 * preserveState();
					 * CommonStaticClass.findOutNextSLNo(CommonStaticClass
					 * .questionMap
					 * .get(CommonStaticClass.currentSLNo).getQvar(),
					 * CommonStaticClass
					 * .questionMap.get(CommonStaticClass.currentSLNo
					 * ).getQnext1()); CommonStaticClass.nextQuestion(con);
					 */
				}
			} else {
				CommonStaticClass
						.showMyAlert(con, "Please check one!!!",
								"You didn't checked any answer please select one to preceed");
			}
		} else {
			CommonStaticClass
					.showMyAlert(con, "Please select item!!!",
							"You didn't select any item from list, Please select one to proceed");
		}

	}

	TextView Slno;
	Spinner spinnerc1;
	TextView lblc2;
	Spinner spinnerc2;
	TextView lblc3;
	EditText etc3;
	TextView lblc4;
	EditText etc4;
	TextView lblc5;
	TextView lblc5village;
	EditText etc5;
	TextView lblc5_2;
	EditText etc5_2;
	TextView lblc5_3;
	EditText etc5_3;
	TextView tvc5_4;
	EditText etc5_4;
	TextView lblc6;
	EditText etc6;
	EditText etother;

	private void loadGuiFrmq124(ViewGroup vg) {

		qqq = (TextView) vg.findViewById(R.id.qqq);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		Slno = (TextView) vg.findViewById(R.id.Slno);
		spinnerc1 = (Spinner) vg.findViewById(R.id.c1);
		lblc2 = (TextView) vg.findViewById(R.id.lblc2);
		spinnerc2 = (Spinner) vg.findViewById(R.id.c2);
		lblc3 = (TextView) vg.findViewById(R.id.lblc3);
		etc3 = (EditText) vg.findViewById(R.id.c3);
		lblc4 = (TextView) vg.findViewById(R.id.lblc4);
		etc4 = (EditText) vg.findViewById(R.id.c4);
		lblc5 = (TextView) vg.findViewById(R.id.lblc5);
		lblc5village = (TextView) vg.findViewById(R.id.lblc5village);
		etc5 = (EditText) vg.findViewById(R.id.c5);
		lblc5_2 = (TextView) vg.findViewById(R.id.lblc5_2);
		etc5_2 = (EditText) vg.findViewById(R.id.c5_2);
		lblc5_3 = (TextView) vg.findViewById(R.id.lblc5_3);
		etc5_3 = (EditText) vg.findViewById(R.id.c5_3);
		tvc5_4 = (TextView) vg.findViewById(R.id.lblc5_4);
		etc5_4 = (EditText) vg.findViewById(R.id.c5_4);
		lblc6 = (TextView) vg.findViewById(R.id.lblc6);
		etc6 = (EditText) vg.findViewById(R.id.c6);
		etother = (EditText) vg.findViewById(R.id.etother);

		if (CommonStaticClass.langBng) {

			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				qqq.setTypeface(font);
			}

			Slno.setTypeface(font);
			lblc2.setTypeface(font);
			lblc3.setTypeface(font);
			lblc4.setTypeface(font);
			lblc5.setTypeface(font);
			lblc5village.setTypeface(font);
			lblc5_2.setTypeface(font);
			lblc5_3.setTypeface(font);
			tvc5_4.setTypeface(font);
			lblc6.setTypeface(font);

			Slno.setText("µwgK bs");
			lblc2.setText("åg‡bi D‡�?k¨,(1=mvgvwRK cwi`k©b,2=‡ivMxi ïk«ylvKvix wn‡m‡e,3=  Ab¨vb¨ (wbw`©ó Kiæb)");
			lblc3.setText("Avcbvi Lvbv‡Z AwZevwnZ mgq (N›Uvq D‡jøL Kiæb hw` AwZevwnZ mgq 3 iv‡Zi Kg  nq)");
			lblc4.setText("Avcbvi Lvbv‡Z AwZevwnZ iv‡Zi msL¨v (hw` AwZevwnZ mgq 3 iv‡Zi †ekx  nq)");
			lblc5.setText("‡Kv_v n‡Z wZwb/Zviv G‡mwQ‡jb?");
			lblc5village.setText("MÖvg/cvov (gnjøv)");
			lblc5_2.setText("BDwbqb");
			lblc5_3.setText("Dc‡Rjv");
			tvc5_4.setText("‡Rjv");
			lblc6.setText("`~iZ¡ wKtwgt/gvBj (DËi`vZvi D‡jjLK„Z GKK wbw`©ó Kiæb)");

			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {

			Slno.setTypeface(null);
			lblc2.setTypeface(null);
			lblc3.setTypeface(null);
			lblc4.setTypeface(null);
			lblc5.setTypeface(null);
			lblc5village.setTypeface(null);
			lblc5_2.setTypeface(null);
			lblc5_3.setTypeface(null);
			tvc5_4.setTypeface(null);
			lblc6.setTypeface(null);

			Slno.setText("Sl. No.");
			lblc2.setText("Purpose of visit (1=Social visit, 2=As a care giver of a patient 3=Others)");
			lblc3.setText("Time spent in your household (mention in hours if spent <3nights)");
			lblc4.setText("Number of nights spent in your household (if spent > 3 nights)");
			lblc5.setText("From where he/she/they came");
			lblc5village.setText("Village (rural)/ Para (Urban)");
			lblc5_2.setText("Union");
			lblc5_3.setText("Upazilla/ Thana");
			tvc5_4.setText("District");
			lblc6.setText("Distance in km or mile (specify the unit as the respondent mentions)");

			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());

		}

		memberIDs = new ArrayList<String>();

		// loading all options
		opSex = CommonStaticClass.findOptionsForThisQuestion(dbHelper, "q124");

		filllAllSpinnerDataq124();

		btnPrev = (Button) vg.findViewById(R.id.prevButton);
		btnPrev.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});
		btnsaveNxt = (Button) vg.findViewById(R.id.saveNxtButton);
		btnsaveNxt.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateTableDataq124();
			}

		});
		btnClear = (Button) vg.findViewById(R.id.clButton);
		btnClear.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) vv);
			}

		});
		notesButton = (Button) vg.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});

	}

	private void setupazilla(String districtCode, ViewGroup v) {
		ArrayList<String> upzlist = new ArrayList<String>();
		PatientDetail p = new PatientDetail();

		upzlist = p.GetUpazilla(dbHelper, districtCode);

		adapterForCombo = new ArrayAdapter(this,
				android.R.layout.simple_spinner_item, upzlist);
		adapterForCombo
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		(((Spinner) v.findViewById(R.id.txtUPZ))).setAdapter(adapterForCombo);

	}

	private void loadguifrmpatientdetail(ViewGroup vg) {

		final ViewGroup group = vg;

		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();

		qqq = (TextView) vg.findViewById(R.id.qqq);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		PatientDetail pd = new PatientDetail();
		pd = pd.GetPatientdetail(dbHelper);

		ArrayList<String> districtlist = new ArrayList<String>();
		districtlist = pd.GetDistrict(dbHelper);

		adapterForCombo = new ArrayAdapter(this,
				android.R.layout.simple_spinner_item, districtlist);
		adapterForCombo
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		(((Spinner) vg.findViewById(R.id.txtDist))).setAdapter(adapterForCombo);

		setupazilla(sResCode, group);

		(((Spinner) vg.findViewById(R.id.txtDist)))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> parent,
							View view, int pos, long id) {

						if (parent.getItemAtPosition(pos).toString().length() > 0) {

							sResCode = parent.getItemAtPosition(pos).toString();
							setupazilla(sResCode, group);
							String upz = CommonStaticClass.getSkip("UPZ",
									"SCVBDS", dbHelper);
							if (upz != null) {
								if (upz.length() > 0) {
									for (int i = 0; i < ((Spinner) group
											.findViewById(R.id.txtUPZ))
											.getCount(); i++) {
										if (upz.trim()
												.equalsIgnoreCase(
														((Spinner) group
																.findViewById(R.id.txtUPZ))
																.getItemAtPosition(
																		i)
																.toString()
																.trim())) {
											((Spinner) group
													.findViewById(R.id.txtUPZ))
													.setSelection(i);
										}

									}
								}
							}
							/*
							 * if (pd.getUPZ() != null) { if
							 * (pd.getUPZ().length() > 0) {
							 * 
							 * for (int i = 0; i < ((Spinner)
							 * group.findViewById(R.id.txtUPZ)) .getCount();
							 * i++) { if
							 * (pd.getUPZ().trim().equalsIgnoreCase(((Spinner)
							 * group.findViewById(R.id.txtUPZ))
							 * .getItemAtPosition(i).toString().trim())) {
							 * ((Spinner) group.findViewById(R.id.txtUPZ))
							 * .setSelection(i); }
							 * 
							 * }
							 * 
							 * } }
							 */

						}
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

		// setupazilla(sResCode, group);

		((EditText) vg.findViewById(R.id.txtPatientID)).setText(pd
				.getPatientID());

		if (pd.getPatientTY() > 0) {
			if (pd.getPatientTY() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupPatientTY))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getPatientTY() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupPatientTY))
						.findViewById(R.id.radio1)).setChecked(true);

		}
		etyearmonth = ((EditText) vg.findViewById(R.id.txtRegDate));
		etyearmonth.setText(pd.getRegDate());

		etyearmonth.setOnTouchListener(new View.OnTouchListener() {

			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub

				final Calendar c = Calendar.getInstance();
				dateYear = c.get(Calendar.YEAR);
				dateMonth = c.get(Calendar.MONTH);
				dateDay = c.get(Calendar.DAY_OF_MONTH);

				showDialog(DATE_DIALOG);
				return false;
			}
		});

		etyearmonth.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				final Calendar c = Calendar.getInstance();
				dateYear = c.get(Calendar.YEAR);
				dateMonth = c.get(Calendar.MONTH);
				dateDay = c.get(Calendar.DAY_OF_MONTH);

				showDialog(DATE_DIALOG);

			}
		});

		etyearmonth.setOnFocusChangeListener(new OnFocusChangeListener() {

			public void onFocusChange(View arg0, boolean arg1) {

				final Calendar c = Calendar.getInstance();
				dateYear = c.get(Calendar.YEAR);
				dateMonth = c.get(Calendar.MONTH);
				dateDay = c.get(Calendar.DAY_OF_MONTH);

				showDialog(DATE_DIALOG);

			}
		});

		ettime = ((EditText) vg.findViewById(R.id.txtRegTime));
		ettime.setText(pd.getRegTime());

		ettime.setOnTouchListener(new View.OnTouchListener() {

			public boolean onTouch(View v, MotionEvent event) {
				showDialog(TIME_DIALOG);
				return false;
			}
		});

		((EditText) vg.findViewById(R.id.txtName)).setText(pd.getName());

		pickDate = ((EditText) vg.findViewById(R.id.txtBDate));
		pickDate.setText(pd.getBDate());

		pickDate.setOnTouchListener(new View.OnTouchListener() {

			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub

				final Calendar c = Calendar.getInstance();
				dobYear = c.get(Calendar.YEAR);
				dobMonth = c.get(Calendar.MONTH);
				dobDay = c.get(Calendar.DAY_OF_MONTH);

				showDialog(DATE_DIALOG);
				return false;
			}
		});

		if (pd.getSex() > 0) {
			if (pd.getSex() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupSex))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getSex() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupSex))
						.findViewById(R.id.radio1)).setChecked(true);

		}

		((EditText) vg.findViewById(R.id.txtAgeYr)).setText(String.valueOf(pd
				.getAgeYr()));
		((EditText) vg.findViewById(R.id.txtAgeMo)).setText(String.valueOf(pd
				.getAgeMo()));
		((EditText) vg.findViewById(R.id.txtAgeDa)).setText(String.valueOf(pd
				.getAgeDa()));

		if (pd.getBDType() > 0) {
			if (pd.getBDType() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupBDType))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getBDType() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupBDType))
						.findViewById(R.id.radio1)).setChecked(true);

		}

		((EditText) vg.findViewById(R.id.txtFaSpName))
				.setText(pd.getFaSpName());
		((EditText) vg.findViewById(R.id.txtWard)).setText(pd.getWard());
		((EditText) vg.findViewById(R.id.txtArea)).setText(pd.getArea());
		((EditText) vg.findViewById(R.id.txtSecBlock))
				.setText(pd.getSecBlock());
		((EditText) vg.findViewById(R.id.txtRoad)).setText(pd.getRoad());
		((EditText) vg.findViewById(R.id.txtHouse)).setText(pd.getHouse());
		((EditText) vg.findViewById(R.id.txtHH)).setText(pd.getHH());
		((EditText) vg.findViewById(R.id.txtSL)).setText(pd.getSL());
		((EditText) vg.findViewById(R.id.txtPID)).setText(pd.getPID());

		((EditText) vg.findViewById(R.id.txtPhone)).setText(pd.getPhone());
		((EditText) vg.findViewById(R.id.txtPhone2)).setText(pd.getPhone2());

		((EditText) vg.findViewById(R.id.txtVill)).setText(pd.getVill());
		// ((EditText) vg.findViewById(R.id.txtUPZ)).setText(pd.getUPZ());

		if (pd.getDist() != null) {
			if (pd.getDist().length() > 0) {

				for (int i = 0; i < ((Spinner) vg.findViewById(R.id.txtDist))
						.getCount(); i++) {
					if (pd.getDist()
							.trim()
							.equalsIgnoreCase(
									((Spinner) vg.findViewById(R.id.txtDist))
											.getItemAtPosition(i).toString()
											.trim())) {
						((Spinner) vg.findViewById(R.id.txtDist))
								.setSelection(i);
					}

				}

			}
		}
		/*
		 * if (pd.getUPZ() != null) { if (pd.getUPZ().length() > 0) {
		 * 
		 * for (int i = 0; i < ((Spinner) vg.findViewById(R.id.txtUPZ))
		 * .getCount(); i++) { if
		 * (pd.getUPZ().trim().equalsIgnoreCase(((Spinner)
		 * vg.findViewById(R.id.txtUPZ))
		 * .getItemAtPosition(i).toString().trim())) { ((Spinner)
		 * vg.findViewById(R.id.txtUPZ)) .setSelection(i); }
		 * 
		 * }
		 * 
		 * } }
		 */

		btnsaveNxt = (Button) vg.findViewById(R.id.saveNxtButton);
		btnsaveNxt.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				PatientDetail pd = new PatientDetail();
				if (pd.SavePatientDetail(dbHelper, group)) {
					CommonStaticClass.findOutNextSLNo(
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQvar(),
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQnext1());
					CommonStaticClass.nextQuestion(ParentActivity.this);
				} else {
					CommonStaticClass.showMyAlert(con, "Save Failed",
							"Save Failed. Please fill fields!");
				}
			}

		});
		btnClear = (Button) vg.findViewById(R.id.clButton);
		btnClear.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) vv);
			}

		});
		((Button) vg.findViewById(R.id.clButton)).setVisibility(View.GONE);
		notesButton = (Button) vg.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});
	}

	private void loadguifrmweight(ViewGroup vg) {
		final ViewGroup group = vg;

		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();

		qqq = (TextView) vg.findViewById(R.id.qqq);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		PatientDetail pd = new PatientDetail();
		pd = pd.GetPatientdetail(dbHelper);

		((EditText) vg.findViewById(R.id.txtweight)).setText(pd.getWT());

		((EditText) vg.findViewById(R.id.txtheight)).setText(pd.getHT());

		((EditText) vg.findViewById(R.id.txtmuac)).setText(pd.getMUAC());

		btnPrev = (Button) vg.findViewById(R.id.prevButton);
		btnPrev.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});

		btnsaveNxt = (Button) vg.findViewById(R.id.saveNxtButton);
		btnsaveNxt.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				PatientDetail pd = new PatientDetail();
				if (pd.SavePatientWeight(dbHelper, group)) {
					CommonStaticClass.findOutNextSLNo(
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQvar(),
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQnext1());
					CommonStaticClass.nextQuestion(ParentActivity.this);
				} else {
					CommonStaticClass.showMyAlert(con, "Save Failed",
							"Save Failed. Please fill all fields!");
				}

			}

		});
		btnClear = (Button) vg.findViewById(R.id.clButton);
		btnClear.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) vv);
			}

		});
		((Button) vg.findViewById(R.id.clButton)).setVisibility(View.GONE);
		notesButton = (Button) vg.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});

	}

	private void loadguifrmdiarrhea(ViewGroup vg) {
		final ViewGroup group = vg;

		resetViewGroup(vg);

		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();

		qqq = (TextView) vg.findViewById(R.id.qqq);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		PatientDetail pd = new PatientDetail();
		pd = pd.GetPatientdetail(dbHelper);
		etyearmonth = ((EditText) vg.findViewById(R.id.DS26a));
		ettime = ((EditText) vg.findViewById(R.id.DS26b));

		ettime.setText("");
		etyearmonth.setText("");

		((RadioGroup) vg.findViewById(R.id.radioGroupDS26))
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup g, int checkedId) {
						if (((RadioButton) (g.findViewById(R.id.radioGroupDS26))
								.findViewById(R.id.radio1)).isChecked()
								|| ((RadioButton) (g
										.findViewById(R.id.radioGroupDS26))
										.findViewById(R.id.radio2)).isChecked()) {

							ettime.setVisibility(View.VISIBLE);
							etyearmonth.setVisibility(View.VISIBLE);
							((TextView) group.findViewById(R.id.lbl26a))
									.setVisibility(View.VISIBLE);
							((TextView) group.findViewById(R.id.lbl26b))
									.setVisibility(View.VISIBLE);
						} else {
							ettime.setText("");
							etyearmonth.setText("");

							ettime.setVisibility(View.GONE);
							etyearmonth.setVisibility(View.GONE);

							((TextView) group.findViewById(R.id.lbl26a))
									.setVisibility(View.GONE);
							((TextView) group.findViewById(R.id.lbl26b))
									.setVisibility(View.GONE);
						}

					}
				});

		((RadioGroup) vg.findViewById(R.id.radioGroupDS17))
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup g, int checkedId) {
						if (((RadioButton) (g.findViewById(R.id.radioGroupDS17))
								.findViewById(R.id.radio0)).isChecked()) {

							((EditText) group.findViewById(R.id.DS18D))
									.setVisibility(View.GONE);
							((RadioGroup) group
									.findViewById(R.id.radioGroupDS18H))
									.setVisibility(View.GONE);
							((RadioGroup) group
									.findViewById(R.id.radioGroupDS19))
									.setVisibility(View.GONE);
							((EditText) group.findViewById(R.id.DS20))
									.setVisibility(View.GONE);

							((EditText) group.findViewById(R.id.DS21))
									.setVisibility(View.GONE);
							((RadioGroup) group
									.findViewById(R.id.radioGroupDS22))
									.setVisibility(View.GONE);
							((RadioGroup) group
									.findViewById(R.id.radioGroupDS23))
									.setVisibility(View.GONE);
							((RadioGroup) group
									.findViewById(R.id.radioGroupDS24))
									.setVisibility(View.GONE);
							((RadioGroup) group
									.findViewById(R.id.radioGroupDS25))
									.setVisibility(View.GONE);

							((TextView) group.findViewById(R.id.lbl2))
									.setVisibility(View.GONE);
							((TextView) group.findViewById(R.id.lbl3))
									.setVisibility(View.GONE);
							((TextView) group.findViewById(R.id.lbl5))
									.setVisibility(View.GONE);
							((TextView) group.findViewById(R.id.lbl8))
									.setVisibility(View.GONE);
							((TextView) group.findViewById(R.id.lbl9))
									.setVisibility(View.GONE);
							((TextView) group.findViewById(R.id.lbl11))
									.setVisibility(View.GONE);
							((TextView) group.findViewById(R.id.lbl13))
									.setVisibility(View.GONE);
							((TextView) group.findViewById(R.id.lbl15))
									.setVisibility(View.GONE);
							((TextView) group.findViewById(R.id.lbl16))
									.setVisibility(View.GONE);

						} else {
							((EditText) group.findViewById(R.id.DS18D))
									.setVisibility(View.VISIBLE);
							((RadioGroup) group
									.findViewById(R.id.radioGroupDS18H))
									.setVisibility(View.VISIBLE);
							((RadioGroup) group
									.findViewById(R.id.radioGroupDS19))
									.setVisibility(View.VISIBLE);
							((EditText) group.findViewById(R.id.DS20))
									.setVisibility(View.VISIBLE);
							((EditText) group.findViewById(R.id.DS21))
									.setVisibility(View.VISIBLE);
							((RadioGroup) group
									.findViewById(R.id.radioGroupDS22))
									.setVisibility(View.VISIBLE);
							((RadioGroup) group
									.findViewById(R.id.radioGroupDS23))
									.setVisibility(View.VISIBLE);
							((RadioGroup) group
									.findViewById(R.id.radioGroupDS24))
									.setVisibility(View.VISIBLE);
							((RadioGroup) group
									.findViewById(R.id.radioGroupDS25))
									.setVisibility(View.VISIBLE);

							((TextView) group.findViewById(R.id.lbl2))
									.setVisibility(View.VISIBLE);
							((TextView) group.findViewById(R.id.lbl3))
									.setVisibility(View.VISIBLE);
							((TextView) group.findViewById(R.id.lbl5))
									.setVisibility(View.VISIBLE);
							((TextView) group.findViewById(R.id.lbl8))
									.setVisibility(View.VISIBLE);
							((TextView) group.findViewById(R.id.lbl9))
									.setVisibility(View.VISIBLE);
							((TextView) group.findViewById(R.id.lbl11))
									.setVisibility(View.VISIBLE);
							((TextView) group.findViewById(R.id.lbl13))
									.setVisibility(View.VISIBLE);
							((TextView) group.findViewById(R.id.lbl15))
									.setVisibility(View.VISIBLE);
							((TextView) group.findViewById(R.id.lbl16))
									.setVisibility(View.VISIBLE);

						}

					}
				});

		if (pd.getDS17() > 0) {
			if (pd.getDS17() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS17))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS17() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS17))
						.findViewById(R.id.radio1)).setChecked(true);

		}
		((EditText) vg.findViewById(R.id.DS18D)).setText(String.valueOf(pd
				.getDS18D()));

		if (pd.getDS18H() > 0) {
			if (pd.getDS18H() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS18H))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS18H() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS18H))
						.findViewById(R.id.radio1)).setChecked(true);

		}

		if (pd.getDS19() > 0) {
			if (pd.getDS19() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS19))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS19() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS19))
						.findViewById(R.id.radio1)).setChecked(true);

			else if (pd.getDS19() == 3)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS19))
						.findViewById(R.id.radio2)).setChecked(true);

		}

		((EditText) vg.findViewById(R.id.DS20)).setText(String.valueOf(pd
				.getDS20()));

		((EditText) vg.findViewById(R.id.DS21)).setText(String.valueOf(pd
				.getDS21()));

		if (pd.getDS22() > 0) {
			if (pd.getDS22() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS22))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS22() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS22))
						.findViewById(R.id.radio1)).setChecked(true);

			else if (pd.getDS22() == 3)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS22))
						.findViewById(R.id.radio2)).setChecked(true);

		}

		if (pd.getDS23() > 0) {
			if (pd.getDS23() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS23))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS23() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS23))
						.findViewById(R.id.radio1)).setChecked(true);

		}

		if (pd.getDS24() > 0) {
			if (pd.getDS24() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS24))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS24() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS24))
						.findViewById(R.id.radio1)).setChecked(true);

		}

		if (pd.getDS25() > 0) {
			if (pd.getDS25() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS25))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS25() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS25))
						.findViewById(R.id.radio1)).setChecked(true);

		}

		if (pd.getDS26() > 0) {
			if (pd.getDS26() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS26))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS26() == 2) {
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS26))
						.findViewById(R.id.radio1)).setChecked(true);

				// etyearmonth = ((EditText)vg.findViewById(R.id.DS26a));
				// ettime = ((EditText)vg.findViewById(R.id.DS26b));

				etyearmonth.setText(pd.getDS26a());
				ettime.setText(pd.getDS26b());
			} else if (pd.getDS26() == 3) {
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS26))
						.findViewById(R.id.radio2)).setChecked(true);
				etyearmonth.setText(pd.getDS26a());
				ettime.setText(pd.getDS26b());
			}

		}

		ettime.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				showDialog(TIME_DIALOG);
				return false;

			}
		});

		etyearmonth.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				showDialog(DATE_DIALOG);
				return false;

			}
		});

		final Calendar c = Calendar.getInstance();
		dateYear = c.get(Calendar.YEAR);
		dateMonth = c.get(Calendar.MONTH);
		dateDay = c.get(Calendar.DAY_OF_MONTH);

		if (!(etyearmonth.getText().toString().length() > 0))
			updateDisplay("date");

		/*
		 * final Calendar d = Calendar.getInstance(); TimeHour =
		 * d.get(Calendar.HOUR_OF_DAY); TimeMinute = d.get(Calendar.MINUTE);
		 * 
		 * 
		 * 
		 * if (!(ettime.getText().toString().length() > 0))
		 * updateDisplay("time");
		 */

		btnPrev = (Button) vg.findViewById(R.id.prevButton);
		btnPrev.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});

		btnsaveNxt = (Button) vg.findViewById(R.id.saveNxtButton);
		btnsaveNxt.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				PatientDetail pd = new PatientDetail();
				if (pd.SavePatientDiarrhea(dbHelper, group)) {
					CommonStaticClass.findOutNextSLNo(
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQvar(),
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQnext1());
					CommonStaticClass.nextQuestion(ParentActivity.this);
				} else {
					CommonStaticClass.showMyAlert(con, "Save Failed",
							"Save Failed. Please fill all fields!");
				}

			}

		});
		btnClear = (Button) vg.findViewById(R.id.clButton);
		btnClear.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) vv);
			}

		});
		notesButton = (Button) vg.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});

	}

	private void loadguifrmvomiting(ViewGroup vg) {
		final ViewGroup group = vg;

		resetViewGroup(vg);
		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();

		qqq = (TextView) vg.findViewById(R.id.qqq);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		PatientDetail pd = new PatientDetail();
		pd = pd.GetPatientdetail(dbHelper);

		((EditText) vg.findViewById(R.id.DS27))
				.addTextChangedListener(new TextWatcher() {

					@Override
					public void onTextChanged(CharSequence s, int start,
							int before, int count) {
						// TODO Auto-generated method stub

					}

					@Override
					public void beforeTextChanged(CharSequence s, int start,
							int count, int after) {
						// TODO Auto-generated method stub

					}

					@Override
					public void afterTextChanged(Editable s) {
						if (s.toString().length() > 0) {
							if (s.toString().equalsIgnoreCase("0")) {
								((TextView) group.findViewById(R.id.lblDS28D))
										.setVisibility(View.GONE);
								((TextView) group.findViewById(R.id.lblDS28H))
										.setVisibility(View.GONE);
								((TextView) group.findViewById(R.id.DS28D))
										.setVisibility(View.GONE);
								((RadioGroup) group
										.findViewById(R.id.radioGroupDS28H))
										.setVisibility(View.GONE);

							} else {
								((TextView) group.findViewById(R.id.lblDS28D))
										.setVisibility(View.VISIBLE);
								((TextView) group.findViewById(R.id.lblDS28H))
										.setVisibility(View.VISIBLE);
								((TextView) group.findViewById(R.id.DS28D))
										.setVisibility(View.VISIBLE);
								((RadioGroup) group
										.findViewById(R.id.radioGroupDS28H))
										.setVisibility(View.VISIBLE);
							}
						}

					}
				});

		((EditText) vg.findViewById(R.id.DS28D)).setText(String.valueOf(pd
				.getDS28D()));

		if (pd.getDS28H() > 0) {
			if (pd.getDS28H() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS28H))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS28H() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS28H))
						.findViewById(R.id.radio1)).setChecked(true);

			else if (pd.getDS28H() == 3)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS28H))
						.findViewById(R.id.radio2)).setChecked(true);

		}

		((EditText) vg.findViewById(R.id.DS27)).setText(String.valueOf(pd
				.getDS27()));

		if (pd.getDS29() > 0) {
			if (pd.getDS29() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS29))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS29() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS29))
						.findViewById(R.id.radio1)).setChecked(true);

		}

		if (pd.getDS30() > 0) {
			if (pd.getDS30() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS30))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS30() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS30))
						.findViewById(R.id.radio1)).setChecked(true);

		}

		((RadioGroup) vg.findViewById(R.id.radioGroupDS31))
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup g, int checkedId) {
						if (((RadioButton) (g.findViewById(R.id.radioGroupDS31))
								.findViewById(R.id.radio0)).isChecked()) {

							((EditText) group.findViewById(R.id.DS32D))
									.setVisibility(View.GONE);
							((RadioGroup) group
									.findViewById(R.id.radioGroupDS32H))
									.setVisibility(View.GONE);

							((TextView) group.findViewById(R.id.lblDS32D))
									.setVisibility(View.GONE);
							((TextView) group.findViewById(R.id.lblDS32H))
									.setVisibility(View.GONE);

						} else {
							((EditText) group.findViewById(R.id.DS32D))
									.setVisibility(View.VISIBLE);
							((RadioGroup) group
									.findViewById(R.id.radioGroupDS32H))
									.setVisibility(View.VISIBLE);

							((TextView) group.findViewById(R.id.lblDS32D))
									.setVisibility(View.VISIBLE);
							((TextView) group.findViewById(R.id.lblDS32H))
									.setVisibility(View.VISIBLE);

						}

					}
				});

		((EditText) vg.findViewById(R.id.DS32D)).setText(String.valueOf(pd
				.getDS32D()));

		if (pd.getDS32H() > 0) {
			if (pd.getDS32H() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS32H))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS32H() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS32H))
						.findViewById(R.id.radio1)).setChecked(true);

		}

		if (pd.getDS31() > 0) {
			if (pd.getDS31() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS31))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS31() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS31))
						.findViewById(R.id.radio1)).setChecked(true);

		}

		((EditText) vg.findViewById(R.id.DS33)).setText(String.valueOf(pd
				.getDS33()));

		((RadioGroup) vg.findViewById(R.id.radioGroupDS34))
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup g, int checkedId) {
						if (((RadioButton) (g.findViewById(R.id.radioGroupDS34))
								.findViewById(R.id.radio0)).isChecked()) {

							((EditText) group.findViewById(R.id.DS35D))
									.setVisibility(View.GONE);
							((RadioGroup) group
									.findViewById(R.id.radioGroupDS35H))
									.setVisibility(View.GONE);

							((TextView) group.findViewById(R.id.lblDS35D))
									.setVisibility(View.GONE);
							((TextView) group.findViewById(R.id.lblDS35H))
									.setVisibility(View.GONE);

						} else {
							((EditText) group.findViewById(R.id.DS35D))
									.setVisibility(View.VISIBLE);
							((RadioGroup) group
									.findViewById(R.id.radioGroupDS35H))
									.setVisibility(View.VISIBLE);

							((TextView) group.findViewById(R.id.lblDS35D))
									.setVisibility(View.VISIBLE);
							((TextView) group.findViewById(R.id.lblDS35H))
									.setVisibility(View.VISIBLE);

						}

					}
				});
		if (pd.getDS34() > 0) {
			if (pd.getDS34() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS34))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS34() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS34))
						.findViewById(R.id.radio1)).setChecked(true);

		}

		((EditText) vg.findViewById(R.id.DS35D)).setText(String.valueOf(pd
				.getDS35D()));

		if (pd.getDS35H() > 0) {
			if (pd.getDS35H() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS35H))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS35H() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS35H))
						.findViewById(R.id.radio1)).setChecked(true);

		}

		btnPrev = (Button) vg.findViewById(R.id.prevButton);
		btnPrev.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});

		btnsaveNxt = (Button) vg.findViewById(R.id.saveNxtButton);
		btnsaveNxt.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				PatientDetail pd = new PatientDetail();
				if (pd.SavePatientVomiting(dbHelper, group)) {
					CommonStaticClass.findOutNextSLNo(
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQvar(),
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQnext1());
					CommonStaticClass.nextQuestion(ParentActivity.this);
				} else {
					CommonStaticClass.showMyAlert(con, "Save Failed",
							"Save Failed. Please fill all fields properly!");
				}

			}

		});
		btnClear = (Button) vg.findViewById(R.id.clButton);
		btnClear.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) vv);
			}

		});
		((Button) vg.findViewById(R.id.clButton)).setVisibility(View.GONE);
		notesButton = (Button) vg.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});

	}

	private void loadguifrmors(ViewGroup vg) {
		final ViewGroup group = vg;

		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();

		qqq = (TextView) vg.findViewById(R.id.qqq);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		PatientDetail pd = new PatientDetail();
		pd = pd.GetPatientdetail(dbHelper);

		(((RadioGroup) vg.findViewById(R.id.radioGroupDS56)))
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup g, int checkedId) {
						if (((RadioButton) (g.findViewById(R.id.radioGroupDS56))
								.findViewById(R.id.radio4)).isChecked()) {

							((TextView) group.findViewById(R.id.textViewDS59P))
									.setVisibility(View.VISIBLE);
							((EditText) group.findViewById(R.id.DS59C))
									.setText("");
							((TextView) group.findViewById(R.id.textViewDS59C))
									.setVisibility(View.VISIBLE);
							((EditText) group.findViewById(R.id.DS59P))
									.setVisibility(View.VISIBLE);
							((EditText) group.findViewById(R.id.DS59C))
									.setVisibility(View.VISIBLE);

						} else {

							((TextView) group.findViewById(R.id.textViewDS59P))
									.setVisibility(View.GONE);
							((EditText) group.findViewById(R.id.DS59C))
									.setText("");
							((TextView) group.findViewById(R.id.textViewDS59C))
									.setVisibility(View.GONE);
							((EditText) group.findViewById(R.id.DS59P))
									.setVisibility(View.GONE);
							((EditText) group.findViewById(R.id.DS59C))
									.setVisibility(View.GONE);

						}

					}
				});

		((EditText) vg.findViewById(R.id.DS36)).setText(String.valueOf(pd
				.getDS36()));

		// IfZeroThenClear(((EditText) vg.findViewById(R.id.DS36)));

		((EditText) vg.findViewById(R.id.DS37)).setText(String.valueOf(pd
				.getDS37()));
		// IfZeroThenClear(((EditText) vg.findViewById(R.id.DS37)));

		((EditText) vg.findViewById(R.id.DS38)).setText(String.valueOf(pd
				.getDS38()));

		// IfZeroThenClear(((EditText) vg.findViewById(R.id.DS38)));

		((EditText) vg.findViewById(R.id.DS39)).setText(String.valueOf(pd
				.getDS39()));

		// IfZeroThenClear(((EditText) vg.findViewById(R.id.DS39)));

		if (pd.getDS40() > 0) {
			if (pd.getDS40() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS40))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS40() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS40))
						.findViewById(R.id.radio1)).setChecked(true);

			else if (pd.getDS40() == 3)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS40))
						.findViewById(R.id.radio2)).setChecked(true);

			else if (pd.getDS40() == 4)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS40))
						.findViewById(R.id.radio3)).setChecked(true);

			else if (pd.getDS40() == 5)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS40))
						.findViewById(R.id.radio4)).setChecked(true);
		}

		((EditText) vg.findViewById(R.id.DS42)).setText(String.valueOf(pd
				.getDS42()));

		((EditText) vg.findViewById(R.id.DS43)).setText(String.valueOf(pd
				.getDS43()));

		if (pd.getDS44() > 0) {
			if (pd.getDS44() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS44))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS44() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS44))
						.findViewById(R.id.radio1)).setChecked(true);

			else if (pd.getDS44() == 3)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS44))
						.findViewById(R.id.radio2)).setChecked(true);

			else if (pd.getDS44() == 4)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS44))
						.findViewById(R.id.radio3)).setChecked(true);

		}

		if (pd.getDS45() > 0) {
			if (pd.getDS45() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS45))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS45() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS45))
						.findViewById(R.id.radio1)).setChecked(true);
		}

		if (pd.getDS46() > 0) {
			if (pd.getDS46() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS46))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS46() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS46))
						.findViewById(R.id.radio1)).setChecked(true);

		}

		if (pd.getDS47() > 0) {
			if (pd.getDS47() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS47))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS47() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS47))
						.findViewById(R.id.radio1)).setChecked(true);

		}

		if (pd.getDS48() > 0) {
			if (pd.getDS48() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS48))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS48() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS48))
						.findViewById(R.id.radio1)).setChecked(true);

			else if (pd.getDS48() == 3)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS48))
						.findViewById(R.id.radio2)).setChecked(true);

			else if (pd.getDS48() == 4)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS48))
						.findViewById(R.id.radio3)).setChecked(true);

			else if (pd.getDS48() == 5)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS48))
						.findViewById(R.id.radio4)).setChecked(true);

		}

		if (pd.getDS49() > 0) {
			if (pd.getDS49() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS49))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS49() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS49))
						.findViewById(R.id.radio1)).setChecked(true);

		}
		if (pd.getDS50() > 0) {
			if (pd.getDS50() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS50))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS50() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS50))
						.findViewById(R.id.radio1)).setChecked(true);

		}

		if (pd.getDS51() > 0) {
			if (pd.getDS51() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS51))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS51() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS51))
						.findViewById(R.id.radio1)).setChecked(true);
			else if (pd.getDS51() == 3)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS51))
						.findViewById(R.id.radio2)).setChecked(true);
		}

		if (pd.getDS52() > 0) {
			if (pd.getDS52() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS52))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS52() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS52))
						.findViewById(R.id.radio1)).setChecked(true);

		}

		if (pd.getDS53() > 0) {
			if (pd.getDS53() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS53))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS53() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS53))
						.findViewById(R.id.radio1)).setChecked(true);

		}

		if (pd.getDS54() > 0) {
			if (pd.getDS54() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS54))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS54() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS54))
						.findViewById(R.id.radio1)).setChecked(true);
			else if (pd.getDS54() == 3)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS54))
						.findViewById(R.id.radio2)).setChecked(true);
		}

		((EditText) vg.findViewById(R.id.DS55)).setText(String.valueOf(pd
				.getDS55()));

		if (pd.getDS56() > 0) {
			if (pd.getDS56() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS56))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS56() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS56))
						.findViewById(R.id.radio1)).setChecked(true);
			else if (pd.getDS56() == 3)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS56))
						.findViewById(R.id.radio2)).setChecked(true);

			else if (pd.getDS56() == 4)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS56))
						.findViewById(R.id.radio3)).setChecked(true);

			else if (pd.getDS56() == 5)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS56))
						.findViewById(R.id.radio4)).setChecked(true);
		}

		etyearmonth = ((EditText) vg.findViewById(R.id.DS57));
		// etyearmonth = ((EditText) vg.findViewById(R.id.txtRegDate));
		etyearmonth.setText(pd.getDS57());

		etyearmonth.setOnTouchListener(new View.OnTouchListener() {

			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub

				final Calendar c = Calendar.getInstance();
				dateYear = c.get(Calendar.YEAR);
				dateMonth = c.get(Calendar.MONTH);
				dateDay = c.get(Calendar.DAY_OF_MONTH);

				showDialog(DATE_DIALOG);
				return false;
			}
		});

		etyearmonth.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				final Calendar c = Calendar.getInstance();
				dateYear = c.get(Calendar.YEAR);
				dateMonth = c.get(Calendar.MONTH);
				dateDay = c.get(Calendar.DAY_OF_MONTH);

				showDialog(DATE_DIALOG);

			}
		});

		etyearmonth.setOnFocusChangeListener(new OnFocusChangeListener() {

			public void onFocusChange(View arg0, boolean arg1) {

				final Calendar c = Calendar.getInstance();
				dateYear = c.get(Calendar.YEAR);
				dateMonth = c.get(Calendar.MONTH);
				dateDay = c.get(Calendar.DAY_OF_MONTH);

				showDialog(DATE_DIALOG);

			}
		});

		/*
		 * pickDate.setOnTouchListener(new OnTouchListener() {
		 * 
		 * @Override public boolean onTouch(View v, MotionEvent event) { final
		 * Calendar c = Calendar.getInstance(); dateYear = c.get(Calendar.YEAR);
		 * dateMonth = c.get(Calendar.MONTH); dateDay =
		 * c.get(Calendar.DAY_OF_MONTH); showDialog(DATE_DIALOG); return false;
		 * } });
		 */

		ettime = ((EditText) vg.findViewById(R.id.DS58));
		ettime.setText(pd.getDS58());
		ettime.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				showDialog(TIME_DIALOG);
				return false;

			}
		});

		/*
		 * ((EditText) vg.findViewById(R.id.DS57)).setText(String.valueOf(pd
		 * .getDS57()));
		 */

		/*
		 * ((EditText) vg.findViewById(R.id.DS58)).setText(String.valueOf(pd
		 * .getDS58()));
		 */

		((EditText) vg.findViewById(R.id.DS59P)).setText(String.valueOf(pd
				.getDS59P()));

		((EditText) vg.findViewById(R.id.DS59C)).setText(String.valueOf(pd
				.getDS59C()));

		btnPrev = (Button) vg.findViewById(R.id.prevButton);
		btnPrev.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});

		btnsaveNxt = (Button) vg.findViewById(R.id.saveNxtButton);
		btnsaveNxt.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				PatientDetail pd = new PatientDetail();

				if (pd.SavePatientORS(dbHelper, group)) {
					CommonStaticClass.findOutNextSLNo(
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQvar(),
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQnext1());
					CommonStaticClass.nextQuestion(ParentActivity.this);
				} else {
					CommonStaticClass.showMyAlert(con, "Save Failed",
							"Save Failed. Please fill all fields!");
				}

			}

		});
		btnClear = (Button) vg.findViewById(R.id.clButton);
		btnClear.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) vv);
			}

		});
		((Button) vg.findViewById(R.id.clButton)).setVisibility(View.GONE);
		notesButton = (Button) vg.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});

		((RadioGroup) vg.findViewById(R.id.radioGroupDS41))
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup g, int checkedId) {
						if (((RadioButton) (g.findViewById(R.id.radioGroupDS41))
								.findViewById(R.id.radio0)).isChecked()) {

							((TextView) group.findViewById(R.id.lblDS42))
									.setVisibility(View.GONE);
							((EditText) group.findViewById(R.id.DS42))
									.setText("");
							((EditText) group.findViewById(R.id.DS42))
									.setVisibility(View.GONE);

						} else {
							((TextView) group.findViewById(R.id.lblDS42))
									.setVisibility(View.VISIBLE);
							((EditText) group.findViewById(R.id.DS42))
									.setVisibility(View.VISIBLE);

						}

					}
				});

		if (pd.getDS41() > 0) {
			if (pd.getDS41() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS41))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS41() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS41))
						.findViewById(R.id.radio1)).setChecked(true);

		}

	}

	private void loadguifrmchildren(ViewGroup vg) {
		final ViewGroup group = vg;

		String v = getSkip("AgeYr", "SCVBDS");
		if (v.length() > 0 && !v.equalsIgnoreCase("null")) {
			if (Integer.parseInt(v) > 5) {
				CommonStaticClass.findOutNextSLNo(CommonStaticClass.questionMap
						.get(CommonStaticClass.currentSLNo).getQvar(), "END");
				CommonStaticClass.nextQuestion(ParentActivity.this);
				return;
			}
		}

		qName = CommonStaticClass.questionMap
				.get(CommonStaticClass.currentSLNo).getQvar();

		qqq = (TextView) vg.findViewById(R.id.qqq);

		if (CommonStaticClass.langBng) {
			if (CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0) {
				Typeface font = Typeface.createFromAsset(getAssets(),
						"Siyam Rupali ANSI.ttf");
				qqq.setTypeface(font);
			}
			;
			qqq.setText(CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng().length() > 0 ? CommonStaticClass.questionMap
					.get(CommonStaticClass.currentSLNo).getQdescbng()
					: CommonStaticClass.questionMap.get(
							CommonStaticClass.currentSLNo).getQdesceng());
		} else {
			qqq.setTypeface(null);
			qqq.setText(CommonStaticClass.questionMap.get(
					CommonStaticClass.currentSLNo).getQdesceng());
		}

		((TextView) findViewById(R.id.lbl17)).setVisibility(View.GONE);
		((EditText) findViewById(R.id.GISID)).setVisibility(View.GONE);

		PatientDetail pd = new PatientDetail();
		pd = pd.GetPatientdetail(dbHelper);

		((EditText) vg.findViewById(R.id.DS61)).setText(String.valueOf(pd
				.getDS61()));

		((RadioGroup) vg.findViewById(R.id.radioGroupDS60))
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup g, int checkedId) {
						if (((RadioButton) (g.findViewById(R.id.radioGroupDS60))
								.findViewById(R.id.radio1)).isChecked()) {

							((TextView) group.findViewById(R.id.lbl2))
									.setVisibility(View.VISIBLE);
							((EditText) group.findViewById(R.id.DS61))
									.setVisibility(View.VISIBLE);

						} else {

							((EditText) group.findViewById(R.id.DS61))
									.setText("");
							((TextView) group.findViewById(R.id.lbl2))
									.setVisibility(View.GONE);
							((EditText) group.findViewById(R.id.DS61))
									.setVisibility(View.GONE);

						}

					}
				});

		if (pd.getDS60() > 0) {
			if (pd.getDS60() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS60))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS60() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS60))
						.findViewById(R.id.radio1)).setChecked(true);

			else if (pd.getDS60() == 3)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS60))
						.findViewById(R.id.radio2)).setChecked(true);

			else if (pd.getDS60() == 4)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS60))
						.findViewById(R.id.radio3)).setChecked(true);

		}
		if (pd.getDS62() > 0) {
			if (pd.getDS62() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS62))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS62() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS62))
						.findViewById(R.id.radio1)).setChecked(true);

			else if (pd.getDS62() == 4)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS62))
						.findViewById(R.id.radio2)).setChecked(true);

		}

		if (pd.getDS63() > 0) {
			if (pd.getDS63() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS63))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS63() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS63))
						.findViewById(R.id.radio1)).setChecked(true);

			else if (pd.getDS63() == 3)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS63))
						.findViewById(R.id.radio1)).setChecked(true);

		}

		if (pd.getDS64() > 0) {
			if (pd.getDS64() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS64))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS64() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS64))
						.findViewById(R.id.radio1)).setChecked(true);
			else if (pd.getDS64() == 3)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS64))
						.findViewById(R.id.radio2)).setChecked(true);
			else if (pd.getDS64() == 4)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS64))
						.findViewById(R.id.radio3)).setChecked(true);
			else if (pd.getDS64() == 5)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS64))
						.findViewById(R.id.radio4)).setChecked(true);
			else if (pd.getDS64() == 6)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS64))
						.findViewById(R.id.radio5)).setChecked(true);

		}

		if (pd.getDS65() > 0) {
			if (pd.getDS65() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS65))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS65() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS65))
						.findViewById(R.id.radio1)).setChecked(true);
			else if (pd.getDS65() == 3)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS65))
						.findViewById(R.id.radio2)).setChecked(true);
			else if (pd.getDS65() == 4)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS65))
						.findViewById(R.id.radio3)).setChecked(true);
			else if (pd.getDS65() == 5)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS65))
						.findViewById(R.id.radio4)).setChecked(true);
			else if (pd.getDS65() == 6)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS65))
						.findViewById(R.id.radio5)).setChecked(true);

			else if (pd.getDS65() == 7)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS65))
						.findViewById(R.id.radio5)).setChecked(true);

		}

		if (pd.getDS66() > 0) {
			if (pd.getDS66() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS66))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS66() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS66))
						.findViewById(R.id.radio1)).setChecked(true);

			else if (pd.getDS66() == 3)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS66))
						.findViewById(R.id.radio2)).setChecked(true);

			else if (pd.getDS66() == 4)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS66))
						.findViewById(R.id.radio3)).setChecked(true);

		}

		if (pd.getDS67() > 0) {
			if (pd.getDS67() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS67))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS67() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS67))
						.findViewById(R.id.radio1)).setChecked(true);

			else if (pd.getDS67() == 3)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS67))
						.findViewById(R.id.radio2)).setChecked(true);

			else if (pd.getDS67() == 4)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS67))
						.findViewById(R.id.radio3)).setChecked(true);

			else if (pd.getDS67() == 5)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS67))
						.findViewById(R.id.radio4)).setChecked(true);

			else if (pd.getDS67() == 6)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS67))
						.findViewById(R.id.radio5)).setChecked(true);

		}

		if (pd.getDS68() > 0) {
			if (pd.getDS68() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS68))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS68() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS68))
						.findViewById(R.id.radio1)).setChecked(true);

			else if (pd.getDS68() == 3)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS68))
						.findViewById(R.id.radio2)).setChecked(true);

			else if (pd.getDS68() == 4)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS68))
						.findViewById(R.id.radio3)).setChecked(true);

			else if (pd.getDS68() == 5)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS68))
						.findViewById(R.id.radio4)).setChecked(true);

			else if (pd.getDS68() == 6)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS68))
						.findViewById(R.id.radio5)).setChecked(true);

		}

		if (pd.getDS69() > 0) {
			if (pd.getDS69() == 1)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS69))
						.findViewById(R.id.radio0)).setChecked(true);
			else if (pd.getDS69() == 2)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS69))
						.findViewById(R.id.radio1)).setChecked(true);
			else if (pd.getDS69() == 3)
				((RadioButton) ((RadioGroup) vg
						.findViewById(R.id.radioGroupDS69))
						.findViewById(R.id.radio2)).setChecked(true);

		}
		((EditText) vg.findViewById(R.id.GISID)).setText(String.valueOf(pd
				.getGISID()));

		btnPrev = (Button) vg.findViewById(R.id.prevButton);
		btnPrev.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				userPressedPrevious(ParentActivity.this);
			}

		});

		btnsaveNxt = (Button) vg.findViewById(R.id.saveNxtButton);
		btnsaveNxt.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				PatientDetail pd = new PatientDetail();
				if (pd.SavePatientChildren(dbHelper, group)) {
					CommonStaticClass.findOutNextSLNo(
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQvar(),
							CommonStaticClass.questionMap.get(
									CommonStaticClass.currentSLNo).getQnext1());
					CommonStaticClass.nextQuestion(ParentActivity.this);
				} else {
					CommonStaticClass.showMyAlert(con, "Save Failed",
							"Save Failed. Please fill all fields!");
				}

			}

		});
		btnClear = (Button) vg.findViewById(R.id.clButton);
		btnClear.setOnClickListener(new View.OnClickListener() {

			public void onClick(View vv) {
				// TODO Auto-generated method stub
				resetViewGroup((ViewGroup) vv);
			}

		});
		((Button) vg.findViewById(R.id.clButton)).setVisibility(View.GONE);

		notesButton = (Button) vg.findViewById(R.id.btnNote);
		notesButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				FraNotes();

			}

		});

	}

	private void IfZeroThenClear(EditText editText) {
		if (editText.getText().toString().equalsIgnoreCase("0")) {
			editText.setText("");
		}

	}

	@Override
	public void onBackPressed() {
		// if(formFlipper.getDisplayedChild()!=5){
		userPressedPrevious(this);
		// }
	}
}
