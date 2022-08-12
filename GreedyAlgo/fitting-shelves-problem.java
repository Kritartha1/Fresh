/*package whatever //do not write package name here */

//https://www.geeksforgeeks.org/fitting-shelves-problem/

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		int[] ans=new int[2];
		ans=func(29,9,3);
	    System.out.println(Arrays.toString(ans));
	}
	static int[] func(int w,int m,int n){
	    int M=w/m;
	    int N=0;
	    int min=Integer.MAX_VALUE;
	    int minM=0;
	    int minN=0;
	    while(M>=0){
	        int temp=w-M*m-N*n;
	        if(temp<min){
	            min=temp;
	            minM=M;
	            minN=N;
	        }
	        M-=1;
	        N=(w-M*m)/n;
	    }
	    return new int[]{minM,minN};
	    
	    
	}
}
