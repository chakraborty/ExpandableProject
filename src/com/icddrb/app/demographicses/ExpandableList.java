/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.icddrb.app.demographicses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ExpandableListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ListView;
import android.widget.SimpleExpandableListAdapter;


/**
 * Demonstrates expandable lists backed by a Simple Map-based adapter
 */


public class ExpandableList extends ExpandableListActivity {
	
	private ListView listentries;
	private Context con;
	private ArrayList<String> dID;
	private ArrayAdapter<String> myAdapter;
	protected static final int ALLQUESTIONLOADED = 1;
	protected static final int QUESTIONCANTLODED = 2;
	protected static final int DELETEDONE = 3;
	protected static final int DELETEFAILED = 4;
	private ProgressDialog progressDialog;
	private static final int CONTEXTMENU_DELETE = 11;
    private static final String NAME = "NAME";
    private static final String IS_EVEN = "IS_EVEN";
	private ArrayList<String> qs;
	private ArrayList<String> qdescbng;
	private ArrayList<String> qdesceng;
	private ArrayList<Integer> qslno;
    private ExpandableListAdapter mAdapter;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        
        if(CommonStaticClass.questionMap.size()==0){
			/*progressDialog = ProgressDialog.show(con, "Questions", "Please wait while loading questioniare");
			new Thread() 
			{
				
				public void run() 
				{*/
					
					
					
					loadQuestions();
			/*	}
			}.start();	*/			
		}
    }
    
    private void loadQuestions() {

		String sql = "Select * from tblQuestion";
		
		
		
		 List<Map<String, String>> groupData = new ArrayList<Map<String, String>>();
		 
	        List<List<Map<String, String>>> childData = new ArrayList<List<Map<String, String>>>();
	        
	        qslno = new ArrayList<Integer>();
			qs = new ArrayList<String>();
			qdescbng = new ArrayList<String>();
			qdesceng = new ArrayList<String>();
	       
	        
	        
	        
	        
	        
		Cursor mCursor = null;
		try{			
			mCursor = BaseActivity.dbHelper.getQueryCursor(sql);
			if(mCursor.moveToFirst()){
				do{		
					QuestionData qd = new QuestionData(mCursor.getInt(mCursor.getColumnIndex("SLNo")), mCursor.getString((mCursor.getColumnIndex("Qvar"))), mCursor.getString((mCursor.getColumnIndex("Formname"))), mCursor.getString((mCursor.getColumnIndex("Qdescbng"))), mCursor.getString((mCursor.getColumnIndex("Qdesceng"))), mCursor.getString((mCursor.getColumnIndex("QType"))), mCursor.getString((mCursor.getColumnIndex("Qnext1"))), mCursor.getString((mCursor.getColumnIndex("Qnext2"))), mCursor.getString((mCursor.getColumnIndex("Qnext3"))), mCursor.getString((mCursor.getColumnIndex("Qnext4"))), mCursor.getString((mCursor.getColumnIndex("Qchoice1eng"))), mCursor.getString((mCursor.getColumnIndex("Qchoice2eng"))), mCursor.getString((mCursor.getColumnIndex("Qchoice3eng"))), mCursor.getString((mCursor.getColumnIndex("Qchoice1bng"))), mCursor.getString((mCursor.getColumnIndex("Qchoice2bng"))), mCursor.getString((mCursor.getColumnIndex("Qchoice3bng"))), mCursor.getString((mCursor.getColumnIndex("Qrange1"))), mCursor.getString((mCursor.getColumnIndex("Qrange2"))), mCursor.getString((mCursor.getColumnIndex("DataType"))), mCursor.getString((mCursor.getColumnIndex("Tablename"))));
					if(!CommonStaticClass.dataId.substring(0,2).equalsIgnoreCase("00") && (mCursor.getString((mCursor.getColumnIndex("Qvar"))).equalsIgnoreCase("q15") || mCursor.getString(mCursor.getColumnIndex("Qvar")).equalsIgnoreCase("q15family")))
					{
						
					}
						
					else 
					{
						
					    Map<String, String> curGroupMap = new HashMap<String, String>();
					    
					    if(mCursor.getString((mCursor.getColumnIndex("Formname"))).equalsIgnoreCase("frmMessage"))
					    {
					    	
					    	//curGroupMap.put(mCursor.getString((mCursor.getColumnIndex("Qdesceng"))),String.valueOf(mCursor.getInt(mCursor.getColumnIndex("SLNo"))));
					    	curGroupMap.put(NAME, mCursor.getString((mCursor.getColumnIndex("Qdesceng"))));
					         curGroupMap.put(IS_EVEN, String.valueOf(mCursor.getInt(mCursor.getColumnIndex("SLNo"))));
					    	groupData.add(curGroupMap);
					    }
					    else
					    {
					    	if(groupData.size()==0)
					    	{
					    		
						    	//curGroupMap.put(mCursor.getString((mCursor.getColumnIndex("Qdesceng"))),String.valueOf(mCursor.getInt(mCursor.getColumnIndex("SLNo"))));
						    	 curGroupMap.put(NAME, mCursor.getString((mCursor.getColumnIndex("Qdesceng"))));
						         curGroupMap.put(IS_EVEN, String.valueOf(mCursor.getInt(mCursor.getColumnIndex("SLNo"))));
						            groupData.add(curGroupMap);
					    	}
					    	 List<Map<String, String>> children = new ArrayList<Map<String, String>>();
					            
					            //for (int j = 0; j < 15; j++) {
					                Map<String, String> curChildMap = new HashMap<String, String>();
					                curChildMap.put(NAME,mCursor.getString(mCursor.getColumnIndex("Qvar")));
					                //curChildMap.put(mCursor.getString((mCursor.getColumnIndex("Qdesceng"))), String.valueOf(mCursor.getInt(mCursor.getColumnIndex("SLNo"))));
					                curGroupMap.put(IS_EVEN, String.valueOf(mCursor.getInt(mCursor.getColumnIndex("SLNo"))));
					               // curChildMap.put(IS_EVEN, (j % 2 == 0) ? "This child is even" : "This child is odd");
					                children.add(curChildMap);
					            //}
					            childData.add(children);
					    }
					    
			           
			            //curGroupMap.put(IS_EVEN, (i % 2 == 0) ? "This group is even" : "This group is odd");
			            
			           
			        
			        
			        // Set up our adapter
			       
			        	//setListAdapter(mAdapter);
					    qslno.add(mCursor.getInt((mCursor.getColumnIndex("SLNo"))));
						qs.add(mCursor.getString((mCursor.getColumnIndex("Qvar"))));
						qdescbng.add(mCursor.getString((mCursor
								.getColumnIndex("Qdescbng"))));
						qdesceng.add(mCursor.getString((mCursor
								.getColumnIndex("Qdesceng"))));
						CommonStaticClass.questionMap.put(mCursor.getInt(mCursor.getColumnIndex("SLNo")), qd);
					}

				}while(mCursor.moveToNext());
				
				 
				  mAdapter = new SimpleExpandableListAdapter(
			                this,
			                groupData,
			                android.R.layout.simple_expandable_list_item_1,
			                new String[] { NAME, IS_EVEN },
			                new int[] { android.R.id.text1, android.R.id.text2 },
			                childData,
			                android.R.layout.simple_expandable_list_item_2,
			                new String[] { NAME, IS_EVEN },
			                new int[] { android.R.id.text1, android.R.id.text2 }
			                );
			        setListAdapter(mAdapter);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally{
			if(mCursor!=null)
			mCursor.close();
			
			/*String sqlForSec = "Select SLNo,Qvar from tblQuestion where Qvar like 'sec%' order by SLNo";
			
			Cursor mCursor1 = null;
			try{			
				mCursor1 = dbHelper.getQueryCursor(sqlForSec);
				if(mCursor1.moveToFirst()){
					do{		
						Log.e("secMap1 ",mCursor1.getString((mCursor1.getColumnIndex("Qvar"))));
						CommonStaticClass.secMap1.add(mCursor1.getString((mCursor1.getColumnIndex("Qvar"))));
						Log.e("secMap2 ",mCursor1.getInt(mCursor1.getColumnIndex("SLNo"))+"");
						CommonStaticClass.secMap2.add(mCursor1.getInt(mCursor1.getColumnIndex("SLNo")));

					}while(mCursor1.moveToNext());
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}finally{
				if(mCursor1!=null)
					mCursor1.close();
				}
			*/
			/*Message msg = new Message();
			msg.what = ALLQUESTIONLOADED;
			handler.sendMessage(msg);*/
		}

		
	}
    
private Handler handler = new Handler() {
		
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case ALLQUESTIONLOADED:
				progressDialog.dismiss();
				CommonStaticClass.isChecked = false;
				/*Intent i = new Intent(EditEntry.this, QListScreenForEdit.class);
				startActivity(i);*/
				break;
			case QUESTIONCANTLODED:
				progressDialog.dismiss();
				CommonStaticClass.showFinalAlert(con,"A problem occured question loading");
				break;
			case DELETEDONE:
				if(progressDialog!=null && progressDialog.isShowing()){
					progressDialog.dismiss();	
				}
				CommonStaticClass.showMyAlert(con, "Completed", "Deleted successfully");

				if(dID!=null & !dID.isEmpty()){
					dID.clear();
					//loadDataToList();
				}
				
				break;
			case DELETEFAILED:
				if(progressDialog!=null && progressDialog.isShowing()){
					progressDialog.dismiss();	
				}
				CommonStaticClass.showMyAlert(con, "InComplete", "ID can not be deleted");

				break;
			}

		}
	};

}
