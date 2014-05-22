package com.icddrb.app.demographicses;

import java.util.ArrayList;
import java.util.List;

public class Grouping {
    private String Grouping;
    //private List<String> child;
    private List<GroupChild> child;
    
    public Grouping(String group, List<String> c) {
        //setGrouping(group);
        //child = c;
    }

    
    public String getName() {
        return getGrouping();
    }
    
    

    /*public List<String> getChild() {
        return child;
    }*/
    
    /*public void AddChild(String x)
    {
    	this.child.add(x);
    }*/
    
    public Grouping() {
    	Grouping = "";
    	child = new ArrayList<GroupChild>();
    }


	public String getGrouping() {
		return Grouping;
	}


	public void setGroupName(String grouping) {
		Grouping = grouping;
	}


	public List<GroupChild> getChild() {
		return this.child;
	}


	public void setChild(List<GroupChild> child) {
		this.child = child;
	}
    
}


