package com.icddrb.app.demographicses;

import java.io.Serializable;
import java.util.ArrayList;

public class Options implements Serializable {
	public String q = "";
	public ArrayList<String> qidList = new ArrayList<String>();
	public ArrayList<Integer> codeList = new ArrayList<Integer>();
	public ArrayList<String> capEngList = new ArrayList<String>();
	public ArrayList<String> capBngList = new ArrayList<String>();
	public ArrayList<String> qnList = new ArrayList<String>();
}
