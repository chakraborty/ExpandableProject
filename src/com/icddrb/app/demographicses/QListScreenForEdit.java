package com.icddrb.app.demographicses;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ListView;
import com.icddrb.app.demographicses.adapters.GroupAdapter;


public class QListScreenForEdit extends BaseActivity {
	private ListView listentries;
	private static List<Grouping> Groupings;
	private Context con;
	private ArrayList<String> qs;
	private ArrayList<String> qdescbng;
	private ArrayList<String> qdesceng;
	private ArrayList<Integer> qslno;
	private ArrayList<Grouping> groupheader = new ArrayList<Grouping>();
	private ArrayList<GroupChild> groupchild = new ArrayList<GroupChild>();
	

	

	
	
	private ExpandableListView expandableListView;
	private GroupAdapter adapter;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.qeditlist);
		con = this;
		
		//c = this;
		//LoadCountries();
		
		qslno = new ArrayList<Integer>();
		qs = new ArrayList<String>();
		qdescbng = new ArrayList<String>();
		qdesceng = new ArrayList<String>();
		groupheader = new ArrayList<Grouping>();
		loadGui();
		
		loadDataToList();

		
		
		
		// setSkipper(); have to work on it
	}

	private void loadGui() {
		// TODO Auto-generated method stub
		qslno = new ArrayList<Integer>();
		qs = new ArrayList<String>();
		qdescbng = new ArrayList<String>();
		qdesceng = new ArrayList<String>();
		groupheader = new ArrayList<Grouping>();
		// filterText = (EditText) findViewById(R.id.search_box);
		// filterText.addTextChangedListener(filterTextWatcher);

		expandableListView = (ExpandableListView) findViewById(R.id.listentries);
		adapter = new GroupAdapter(this, qs, qdescbng, qdesceng,groupheader);
		expandableListView.setAdapter(adapter);
		
		
	/*	expandableListView.setOnGroupClickListener(new OnGroupClickListener() {
			
			public boolean onGroupClick(ExpandableListView parent, View v,
					int groupPosition, long id) {
				
				String c = adapter.getGroup(groupPosition);
				
				CommonStaticClass.currentSLNo = qslno.get(Integer.parseInt(CommonStaticClass.GetQValue(c))-1);
				if (CommonStaticClass.currentSLNo != 1) {
					
					CommonStaticClass.mode = CommonStaticClass.EDITMODE;

						startQuestion();

				} else {
					CommonStaticClass.showMyAlert(con, "Warning!!!",
							"You can not edit this question");
				}
						
				
				return false;
			}
		});*/
		
		expandableListView.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {

				//adapter.getgr
				GroupChild c = adapter.getChild(groupPosition, childPosition);
				
				CommonStaticClass.currentSLNo = qslno.get(Integer.parseInt(CommonStaticClass.GetQValue(c.getChildName()))-1);
				if (CommonStaticClass.currentSLNo != 1) {
					
					CommonStaticClass.mode = CommonStaticClass.EDITMODE;

						startQuestion();

				} else {
					CommonStaticClass.showMyAlert(con, "Warning!!!",
							"You can not edit this question");
				}
						
				
				return false;
			}
		
		});
				// TODO Auto-generated method stub
				// addtoskip();
				
	
		

	}
	
	

	
	private boolean addtoskip() {

		try {

			if (!CommonStaticClass.getSkip("p118_1", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q118R1C2");
				CommonStaticClass.qskipList.add("q118R1C3");
			}

			if (!CommonStaticClass.getSkip("p118_2", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q118R2C2");
				CommonStaticClass.qskipList.add("q118R2C3");
			}

			if (!CommonStaticClass.getSkip("p118_3", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q118R3C2");
				CommonStaticClass.qskipList.add("q118R3C3");
			}

			if (!CommonStaticClass.getSkip("p118_4", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q118R4C2");
				CommonStaticClass.qskipList.add("q118R4C3");
			}

			if (!CommonStaticClass.getSkip("p118_5", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q118R5C2");
				CommonStaticClass.qskipList.add("q118R5C3");
			}

			if (!CommonStaticClass.getSkip("p118_6", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q118R6C2");
				CommonStaticClass.qskipList.add("q118R6C3");
			}

			if (!CommonStaticClass.getSkip("p118_7", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q118R7C2");
				CommonStaticClass.qskipList.add("q118R7C3");
			}

			if (!CommonStaticClass
					.getSkip("p114_15", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {

				CommonStaticClass.qskipList.add("q114R0C2");
				CommonStaticClass.qskipList.add("q114R0C3");
				CommonStaticClass.qskipList.add("p114_other");

			}

			if (!CommonStaticClass.getSkip("p114_1", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {

				CommonStaticClass.qskipList.add("q114R1C2");
				CommonStaticClass.qskipList.add("q114R1C3");

			}
			if (!CommonStaticClass.getSkip("p114_2", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {

				CommonStaticClass.qskipList.add("q114R2C2");
				CommonStaticClass.qskipList.add("q114R2C3");

			}
			if (!CommonStaticClass.getSkip("p114_3", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {

				CommonStaticClass.qskipList.add("q114R3C2");
				CommonStaticClass.qskipList.add("q114R3C3");

			}
			if (!CommonStaticClass.getSkip("p114_4", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {

				CommonStaticClass.qskipList.add("q114R4C2");
				CommonStaticClass.qskipList.add("q114R4C3");

			}

			if (!CommonStaticClass.getSkip("p114_5", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {

				CommonStaticClass.qskipList.add("q114R5C2");
				CommonStaticClass.qskipList.add("q114R5C3");

			}

			if (!CommonStaticClass.getSkip("p114_6", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {

				CommonStaticClass.qskipList.add("q114R6C2");
				CommonStaticClass.qskipList.add("q114R6C3");

			}

			if (!CommonStaticClass.getSkip("p114_7", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {

				CommonStaticClass.qskipList.add("q114R7C2");
				CommonStaticClass.qskipList.add("q114R7C3");

			}

			if (!CommonStaticClass.getSkip("p114_8", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {

				CommonStaticClass.qskipList.add("q114R8C2");
				CommonStaticClass.qskipList.add("q114R8C3");

			}

			if (!CommonStaticClass.getSkip("p114_9", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {

				CommonStaticClass.qskipList.add("q114R9C2");
				CommonStaticClass.qskipList.add("q114R9C3");

			}

			if (!CommonStaticClass
					.getSkip("p114_10", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {

				CommonStaticClass.qskipList.add("q114R10C2");
				CommonStaticClass.qskipList.add("q114R10C3");

			}

			if (!CommonStaticClass
					.getSkip("p114_11", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {

				CommonStaticClass.qskipList.add("q114R11C2");
				CommonStaticClass.qskipList.add("q114R11C3");

			}

			if (!CommonStaticClass
					.getSkip("p114_12", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {

				CommonStaticClass.qskipList.add("q114R12C2");
				CommonStaticClass.qskipList.add("q114R12C3");

			}

			if (!CommonStaticClass
					.getSkip("p114_13", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {

				CommonStaticClass.qskipList.add("q114R13C2");
				CommonStaticClass.qskipList.add("q114R13C3");

			}

			if (!CommonStaticClass
					.getSkip("p114_14", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {

				CommonStaticClass.qskipList.add("q114R14C2");
				CommonStaticClass.qskipList.add("q114R14C3");

			}

			if (!CommonStaticClass.getSkip("q89a_1", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q89R1");
				CommonStaticClass.qskipList.add("q89R1Count");
				CommonStaticClass.qskipList.add("q89R1_other");

			}
			if (!CommonStaticClass.getSkip("q89a_2", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q89R2");
				CommonStaticClass.qskipList.add("q89R2Count");
				CommonStaticClass.qskipList.add("q89R2_other");

			}
			if (!CommonStaticClass.getSkip("q89a_3", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q89R3");
				CommonStaticClass.qskipList.add("q89R3Count");
				CommonStaticClass.qskipList.add("q89R3_other");

			}
			if (!CommonStaticClass.getSkip("q89a_4", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q89R4");
				CommonStaticClass.qskipList.add("q89R4Count");
				CommonStaticClass.qskipList.add("q89R4_other");

			}
			if (!CommonStaticClass.getSkip("q89a_5", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q89R5");
				CommonStaticClass.qskipList.add("q89R5Count");
				CommonStaticClass.qskipList.add("q89R5_other");

			}
			if (!CommonStaticClass.getSkip("q89a_6", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q89R6");
				CommonStaticClass.qskipList.add("q89R6Count");
				CommonStaticClass.qskipList.add("q89R6_other");

			}
			if (!CommonStaticClass.getSkip("q89a_7", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("q89R7");
				CommonStaticClass.qskipList.add("q89R7Count");
				CommonStaticClass.qskipList.add("q89R7_other");
				CommonStaticClass.qskipList.add("q89R7a");
				CommonStaticClass.qskipList.add("q89R7aCount");

			}

			if (!CommonStaticClass.getSkip("q89a_8", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {

				CommonStaticClass.qskipList.add("q89R8");
				CommonStaticClass.qskipList.add("q89R8_other");
				CommonStaticClass.qskipList.add("q89R8Count");

			}

			if (!CommonStaticClass.getSkip("q89a_9", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {

				CommonStaticClass.qskipList.add("q89R9");
				CommonStaticClass.qskipList.add("q89R9Count");
				CommonStaticClass.qskipList.add("q89R9_other");

			}

			if (!CommonStaticClass.getSkip("p87a_1", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("p87b");
				CommonStaticClass.qskipList.add("p87bcount");
				CommonStaticClass.qskipList.add("p87b_other");

			}

			if (!CommonStaticClass.getSkip("p87a_2", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("p87c");
				CommonStaticClass.qskipList.add("p87ccount");
				CommonStaticClass.qskipList.add("p87c_other");

			}

			if (!CommonStaticClass.getSkip("p87a_3", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("p87d");
				CommonStaticClass.qskipList.add("p87dcount");
				CommonStaticClass.qskipList.add("p87d_other");

			}

			if (!CommonStaticClass.getSkip("p87a_4", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("p87e");
				CommonStaticClass.qskipList.add("p87ecount");
				CommonStaticClass.qskipList.add("p87e_other");

			}

			if (!CommonStaticClass.getSkip("p87a_5", "tblMainQuesMc", dbHelper)
					.equalsIgnoreCase("1")) {
				CommonStaticClass.qskipList.add("p87f");
				CommonStaticClass.qskipList.add("p87fcount");
				CommonStaticClass.qskipList.add("p87f_other");

			}
			return true;

		} catch (Exception e) {
			// CommonStaticClass.showMyAlert(con, "Empty",
			// "Can not edit this question because there was no data.");
			return false;
		}

	}

/*	private TextWatcher filterTextWatcher = new TextWatcher() {

		public void afterTextChanged(Editable s) {
		}

		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			adapter.getFilter().filter(s);
		}

	};*/

	//
	// protected void onDestroy() {
	// super.onDestroy();
	// filterText.removeTextChangedListener(filterTextWatcher);
	// }

	protected boolean checkSelectionHasDataOrNot(String qvar, String tablename) {
		if(qvar.contains("sec")){
			return true;
		}
		String sqlCheck = "";
		if(!CommonStaticClass.isMember)
			sqlCheck = "Select "+qvar+" from "+tablename+" where dataid='"+CommonStaticClass.dataId+"'";
		else
			sqlCheck = "Select "+qvar+" from "+tablename+" where dataid='"+CommonStaticClass.dataId+"' and memberid="+CommonStaticClass.memberID;
		
		Cursor mCursor1 = null;
		try{			
			mCursor1 = dbHelper.getQueryCursor(sqlCheck);
			mCursor1.moveToFirst();
			if(mCursor1.getCount()>0){
				String  a = mCursor1.getString((mCursor1.getColumnIndex(qvar)))+"";
				Log.e("aaaa",""+a);
				if(a.length()>0 && !a.contains("-1") && !a.equalsIgnoreCase("null")){
					return true;
				}else{
					return false;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			if(mCursor1!=null)
			mCursor1.close();
		}	
		return false;
	}

	private void loadDataToList() {

		
		String sql = "";
		if (!CommonStaticClass.isMember)
			sql = "Select SLNo,Qvar,Qdescbng,Qdesceng, Qnext1 from tblQuestion  order by SLNo asc";
		else
			sql = "Select SLNo,Qvar,Qdescbng,Qdesceng, Qnext1 from tblQuestion  order by SLNo asc";

		Cursor mCursor = null;
		
		
		try {
			mCursor = dbHelper.getQueryCursor(sql);
			
			
			int x = 0;
			boolean hasfoundmessage = false;
			Grouping ga = new Grouping();
			ArrayList<GroupChild> child = new ArrayList<GroupChild>();
			if (mCursor.moveToFirst()) {
				do {
					
					
					qslno.add(mCursor.getInt((mCursor.getColumnIndex("SLNo"))));
					qs.add(mCursor.getString((mCursor.getColumnIndex("Qvar"))));
					qdescbng.add(mCursor.getString((mCursor
							.getColumnIndex("Qdescbng"))));
					qdesceng.add(mCursor.getString((mCursor
							.getColumnIndex("Qdesceng"))));
					
					
					if(hasfoundmessage==false && !mCursor.getString((mCursor.getColumnIndex("Qvar"))).toLowerCase().contains("message"))
					{
						
						GroupChild gchild = new GroupChild();
						ArrayList<GroupChild> gchilds = new ArrayList<GroupChild>();
						
						if(!CommonStaticClass.langBng)
							gchild.setChildName(String.valueOf(mCursor.getInt((mCursor.getColumnIndex("SLNo")))) + " + " +  mCursor.getString((mCursor.getColumnIndex("Qdesceng"))));
						else
							gchild.setChildName(String.valueOf(mCursor.getInt((mCursor.getColumnIndex("SLNo")))) + " + " +  mCursor.getString((mCursor.getColumnIndex("Qdescbng"))));
						
						gchilds.add(gchild);
						
						
						if(!CommonStaticClass.langBng)
							ga.setGroupName(String.valueOf(mCursor.getInt((mCursor.getColumnIndex("SLNo")))) + " + " +  mCursor.getString((mCursor.getColumnIndex("Qdesceng"))));
						else
							ga.setGroupName(String.valueOf(mCursor.getInt((mCursor.getColumnIndex("SLNo")))) + " + " +  mCursor.getString((mCursor.getColumnIndex("Qdescbng"))));
						
						ga.setChild(gchilds);
						
						groupheader.add(ga);
						ga = new Grouping();
					
					}
					else
					{
						if(String.valueOf(mCursor.getString((mCursor.getColumnIndex("Qnext1")))).equalsIgnoreCase("END"))
						{
							ga.setChild(groupchild);
							groupheader.add(ga);
							ga = new Grouping();
							//break;
						}
						
						
						
						if(mCursor.getString((mCursor.getColumnIndex("Qvar"))).toLowerCase().contains("message"))
						{
							if(ga.getName()!=null)
							{
								ga.setChild(groupchild);
								groupheader.add(ga);
								ga = new Grouping();
							}
							if(!CommonStaticClass.langBng)
								ga.setGroupName(String.valueOf(mCursor.getInt((mCursor.getColumnIndex("SLNo")))) + " + " +  mCursor.getString((mCursor.getColumnIndex("Qdesceng"))));
							else
								ga.setGroupName(String.valueOf(mCursor.getInt((mCursor.getColumnIndex("SLNo")))) + " + " +  mCursor.getString((mCursor.getColumnIndex("Qdescbng"))));
							
							groupchild = new ArrayList<GroupChild>();
							
							hasfoundmessage = true;
						}
						else
						{
							GroupChild gchild = new GroupChild();
							
							if(!CommonStaticClass.langBng)
								gchild.setChildName(String.valueOf(mCursor.getInt((mCursor.getColumnIndex("SLNo")))) + " + " +  mCursor.getString((mCursor.getColumnIndex("Qdesceng"))));
							else
								gchild.setChildName(String.valueOf(mCursor.getInt((mCursor.getColumnIndex("SLNo")))) + " + " +  mCursor.getString((mCursor.getColumnIndex("Qdescbng"))));
								
							groupchild.add(gchild);
							//ga.AddChild(x)
						}
						
						
						
						
					}
					
					/*if(!mCursor.getString((mCursor.getColumnIndex("Qvar"))).toLowerCase().contains("message"))
					{
						
						if(!CommonStaticClass.langBng)
							child.add(String.valueOf(mCursor.getInt((mCursor.getColumnIndex("SLNo")))) + " + " +  mCursor.getString((mCursor.getColumnIndex("Qdesceng"))));
						else
							child.add(String.valueOf(mCursor.getInt((mCursor.getColumnIndex("SLNo")))) + " + " +  mCursor.getString((mCursor.getColumnIndex("Qdescbng"))));
					}
					else
					{
						Grouping g = null;
						if(!CommonStaticClass.langBng)
							g = new Grouping(mCursor.getString((mCursor.getColumnIndex("Qdesceng"))), child);
						else
							g = new Grouping(mCursor.getString((mCursor.getColumnIndex("Qdescbng"))), child);
						
						groupheader.add(g);
						child = new ArrayList<String>();
						hasfoundmessage = true;
					}*/
					
					
				} while (mCursor.moveToNext());
			}
		} catch (Exception e) {
			// TODO: handle exception
			CommonStaticClass.showFinalAlert(con,
					"A problem occured please try later");
		} finally {
			if (mCursor != null)
				mCursor.close();

			adapter.notifyDataSetChanged();
		}
	}

	// Added By Angsuman
	public boolean onCreateOptionsMenu(final Menu menu) {
		final MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.lang_menu, menu);
		return true;
	}

	public boolean onOptionsItemSelected(final MenuItem item) {
		switch (item.getItemId()) {
		case R.id.BNGMenuItem:
			CommonStaticClass.langBng = true;
			loadGui();
			loadDataToList();
			return true;
		case R.id.ENGMenuItem:
			CommonStaticClass.langBng = false;
			loadGui();
			loadDataToList();
			return true;
		case R.id.GotoHomeItem:
			CommonStaticClass.mode = "";
			finish();
			// Intent i = new Intent();
			// i.setClassName(CommonStaticClass.pName,
			// CommonStaticClass.pName+".MenuScreen");
			// startActivity(i);

			return true;
			
		 case R.id.ExitItem:
			
			CommonStaticClass.mode = "";
			finish();
			
			/*Intent i1 = new Intent();
			i1.setClassName(CommonStaticClass.pName, CommonStaticClass.pName+".LoginActivity");
			startActivity(i1);*/
			return true;
			
		 /*case R.id.search:
				CommonStaticClass.mode = "";
				Intent int_b = new Intent(getApplicationContext(), SearchLayout.class);
				startActivity(int_b);
				return true;
				
		 case R.id.viewall:

				CommonStaticClass.mode = "";
				int_b = new Intent(getApplicationContext(),
						Viewall.class);
				startActivity(int_b);
				return true;*/
				
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	//
	private void startQuestion() {
		// TODO Auto-generated method stub
		CommonStaticClass.SLNOSTACK.add(CommonStaticClass.currentSLNo);
		Intent i = new Intent();
		i.setClassName(CommonStaticClass.pName, CommonStaticClass.pName
				+ ".questions.ParentActivity");
		startActivity(i);
	}

	private void setSkipper() {
		String sq = "Select q12 from tblMainQuesSC where dataid='"
				+ CommonStaticClass.dataId + "'";
		Cursor mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sq);
			if (mCursor1.moveToFirst()) {
				do {
					String val = mCursor1.getString((mCursor1
							.getColumnIndex("q12"))) + "";
					if (val.length() > 0 && !val.contains("-1")
							&& !val.equalsIgnoreCase("null")) {
						int a = Integer.parseInt(val);
						if (a == 1) {
							CommonStaticClass.qskipList.add("q1005");
							CommonStaticClass.qskipList.add("q1012");
							CommonStaticClass.qskipList.add("sec8");
							CommonStaticClass.qskipList.add("sec9");
						} else if (a == 2) {
							CommonStaticClass.qskipList.add("q1005");
							CommonStaticClass.qskipList.add("sec8");
							CommonStaticClass.qskipList.add("sec9");
						} else if (a == 3) {
							CommonStaticClass.qskipList.add("q1003");
							CommonStaticClass.qskipList.add("q1006");
							CommonStaticClass.qskipList.add("q1007");
							CommonStaticClass.qskipList.add("q1008");
							CommonStaticClass.qskipList.add("q1009");
							CommonStaticClass.qskipList.add("q1010");
							CommonStaticClass.qskipList.add("q1014");

							CommonStaticClass.qskipList.add("q1015");

							CommonStaticClass.qskipList.add("sec2");
							CommonStaticClass.qskipList.add("sec2_1");
							CommonStaticClass.qskipList.add("sec3");
							CommonStaticClass.qskipList.add("sec4");
							CommonStaticClass.qskipList.add("sec9");

						} else if (a == 4) {
							CommonStaticClass.qskipList.add("q1003");
							CommonStaticClass.qskipList.add("q1006");
							CommonStaticClass.qskipList.add("q1007");
							CommonStaticClass.qskipList.add("q1008");
							CommonStaticClass.qskipList.add("q1009");
							CommonStaticClass.qskipList.add("q1010");
							CommonStaticClass.qskipList.add("q1014");

							CommonStaticClass.qskipList.add("q1015");

							CommonStaticClass.qskipList.add("sec2");
							CommonStaticClass.qskipList.add("sec2_1");
							CommonStaticClass.qskipList.add("sec3");
							CommonStaticClass.qskipList.add("sec4");
							CommonStaticClass.qskipList.add("sec8");
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
		String sql = "Select q204a from tblMainQues where dataid='"
				+ CommonStaticClass.dataId + "'";
		mCursor1 = null;
		try {
			mCursor1 = dbHelper.getQueryCursor(sql);
			if (mCursor1.moveToFirst()) {
				do {
					String val = mCursor1.getString((mCursor1
							.getColumnIndex("q204a"))) + "";
					if (val.length() > 0 && !val.contains("-1")
							&& !val.equalsIgnoreCase("null")) {
						int a = Integer.parseInt(val);
						if (a >= 6 && a < 12) {
							CommonStaticClass.qskipList.add("q301");
						}

						if (a < 6) {
							CommonStaticClass.qskipList.add("q301");
							CommonStaticClass.qskipList.add("q302");
							CommonStaticClass.qskipList.add("q406");
							CommonStaticClass.qskipList.add("q407");
							CommonStaticClass.qskipList.add("q408");
							CommonStaticClass.qskipList.add("q409");
							CommonStaticClass.qskipList.add("q412");
							CommonStaticClass.qskipList.add("q413");
							CommonStaticClass.qskipList.add("q414");
							CommonStaticClass.qskipList.add("q415");
							CommonStaticClass.qskipList.add("q416");
							CommonStaticClass.qskipList.add("q416a");
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

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed(true);
	}
}
