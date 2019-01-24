package main.course.oop.tictactoe.util;

import java.util.HashMap;

/**
 * You must implement the following methods to accept the expected 
 * parameters and return accurate results.
 * You are allowed and expected to add any class attributes and methods 
 * needed to complete this assignment. 
 * 
 */
public class TwoDArray {
	private int TwoDArray [][];
	private int df_val;
	
	public TwoDArray(int rows, int cols, int defaultVal){
		/*TODO - Create a 2D integer array consisting of 
		 * the number of rows and columns given. Initialize 
		 * the array by setting each int to be the defaulVal. 
		 * */
		this.TwoDArray = new int [rows][cols];
		this.df_val = defaultVal;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				this.TwoDArray[i][j] = defaultVal;
			}
		}
		
	}
	
	public void initArray(int defaultVal) {
		/*TODO - (Re)Initialize the array by 
		 * setting each int to be the defaulVal 
		 */
		this.df_val = defaultVal;
		for(int i = 0; i< this.TwoDArray.length; i++) {
			for(int j = 0; j< this.TwoDArray[i].length; j++) {
				this.TwoDArray[i][j]=defaultVal;
				
			}
		}
		
	}
	
	public String insertInt(int row, int col, int val) {
		/*TODO - "Insert" based on the following conditions:
		 * 1. The location [row][col] is still set to the default value
		 * 		-return "Success! (val) was inserted.
		 * 
		 * 2. The location [row][col] is no longer the default value
		 * 		-return "Failure: (row), (col) is not empty.
		 * 
		 * 3. val is not the default value; 
		 * 		-return "Failure: (val) is not allowed."
		 * 
		 * Note: Print the int value in place of (). 
		 * e.g., replace (val) with val.
		 */
		String res = "";
		if(val == this.df_val) {
			res = "Failure: "+val+" is not allowed.";
			
		}
		if(this.TwoDArray[row][col] == this.df_val) {
			this.TwoDArray[row][col] = val;
			res = "Success! " + val +" was inserted.";
		
		}
		else {
			res = "Failure: " + row + col +" is not empty.";
		}

		return res;
	}
	
	public int getInt(int row, int col) {
		/*TODO - Return the value at the specified row, col
		 * 
		 */
		
		
		return this.TwoDArray[row][col];
	}
	
	public String getArrayDisplay() {
		/*TODO - Create a 2D display of the Array
		 * e.g. 
		 * 	1	0	1
		 *  0	1	0
		 *  0	1	1
		 * 
		 */
		String display = "";
		for(int i = 0; i< this.TwoDArray.length; i++) {
			for(int j = 0; j< this.TwoDArray[i].length; j++) {
				display += (j < this.TwoDArray[i].length-1)? 
						this.TwoDArray[i][j]+ "\t" : this.TwoDArray[i][j];
				
			}
			display += "\n";
		}
		
		
		return display;
	}
	
	public String getArrayDetails() {
		/*TODO - List the following:
		 * # rows
		 * # columns
		 * How many unique values (in the above example, this would be 2
		 * Value and count of each (e.g. 
		 * 			value:1 count:5
		 * 			value:0 count:4
		 * 
		 * 			)
		 * 
		 */
		String value = "";
		value += "# "+ this.TwoDArray.length +"\n" + "# "+ this.TwoDArray[0].length +"\n";
		HashMap <Integer, Integer> value_count = new HashMap <Integer, Integer>();
		for(int i = 0; i < this.TwoDArray.length; i++){
			for(int j=0; j < this.TwoDArray[i].length; j++){
				if(value_count.containsKey(this.TwoDArray[i][j])) {
					int temp = value_count.get(this.TwoDArray[i][j]);
					temp ++;
					value_count.replace(this.TwoDArray[i][j],temp);
				}
				else value_count.put(this.TwoDArray[i][j], 1);
			}
		}
		value += value_count.keySet().size() + " unique value \n";
		for(Integer i: value_count.keySet()) {
			value += "value: " + i + " count: " + value_count.get(i) + "\n";
		}
	
		return value;
	}		

}
