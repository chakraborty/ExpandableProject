package com.icddrb.app.demographicses.adapters;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

import com.icddrb.app.demographicses.CommonStaticClass;
import com.icddrb.app.demographicses.GroupChild;

import com.icddrb.app.demographicses.Grouping;

//import com.debugrelease.android.expandablelistviewtutorial.Country;

public class GroupAdapter extends BaseExpandableListAdapter {
	
	boolean bn = false;
	Typeface font ;
	Activity context;
	List<String> qlist;
	List<String> qdescbng;
	List<String> qdesceng;
	
	
    private List<Grouping> groups;
    private LayoutInflater inflater;

    public GroupAdapter(Activity context, List<String> qobjects,List<String> objectsbng,List<String> objectseng, List<Grouping> gr) {
       // this.countries = countries;
        font = Typeface.createFromAsset(context.getAssets(),
        		"Siyam Rupali ANSI.ttf");
        		this.bn = CommonStaticClass.langBng;
        		
        		this.context = context;
        		this.qlist  = qobjects;
        		this.qdescbng  = objectsbng;
        		this.qdesceng  = objectseng;
        		this.groups = gr;
        		
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
    	if(groups.get(groupPosition).getChild()==null)
    		return groupPosition;
    	else
    		return groups.get(groupPosition).getChild().size();
    }

    @Override
    public String getGroup(int groupPosition) {
        return groups.get(groupPosition).getName();
    }

    @Override
    public GroupChild getChild(int groupPosition, int childPosition) {
    	
    	if(groups.get(groupPosition).getChild()==null)
    		return null;
    	else
    		return groups.get(groupPosition).getChild().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.simple_expandable_list_item_1, parent, false);
        }
        
        if(bn)
        	{((TextView) convertView).setTypeface(font);}
        
		
        ((TextView) convertView).setText(getGroup(groupPosition).toString());
        
        final ViewGroup.LayoutParams lp = new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        ((TextView) convertView).setLayoutParams(lp);
       ((TextView) convertView).setGravity(Gravity.LEFT);
        ((TextView) convertView).setPadding(5, 10, 0, 10);
        
        ((TextView) convertView).setBackgroundColor(Color.rgb(0, 153, 204));
        
        
       
       
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.simple_list_item_1, parent, false);
        }

        
        if(bn)
    	{
        	((TextView) convertView).setTypeface(font);
        }
    
	    if(getChild(groupPosition,childPosition)==null)
	    {
	    	
	    }
	    else
	    {
	    	((TextView)convertView).setText(getChild(groupPosition,childPosition).getChildName().toString());
	    	((TextView) convertView).setPadding(20, 10, 0, 10);
	    }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }
}
