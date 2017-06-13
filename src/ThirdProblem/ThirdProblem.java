/*********************************************************************
Purpose/Description: Divide an array by 3 to find a value with 
efficiently.
Author’s Panther ID: 5540930
Certification:
I hereby certify that this work is my own and none of it is the work of
any other person.
********************************************************************/ 
//The running time complexity of this algorithm is O(log(N)).
//The running time complexity is shared with the binary search.
//The reason for this is because the numbers to look through in 
//the array is being reduced by a factor of 3, resulting in N = 3^N
//This can be rewritten as log3(N). The 3 is ignored, however, since it
//is simply a constant factor multiplying by log(N). This is simplified to
//O(log(N)). This is why the binary search of O(log2(N)) is also O(log(N)).
package ThirdProblem;

import java.util.Arrays;

public class ThirdProblem {
	int arrayMax = 5; //the maximum length of the array.
	int d1;
	int d2;
	public int terSearch(int arr[], int l, int r, int x) { //recursive method.
		if(d2 >= arrayMax){ //if the upper bound has reached the 
							//maximum array length, return -1.	
			return -1;
		}
		
		d1 = l + (r - l) / 3; //dividers
		d2 = d1 + (r - l) / 3;
		
		if(arr[d1] == x){ //if the lower divider landed on the number to find,
			return d1;    //return the index.
			
		} else if(arr[d2] == x){ //if the upper divider landed on the number to find,
			return d2;	         //return the index.
		}
		
		if(arr[d1] > x){ //if x is smaller than the first third (lower divider)
			return terSearch(arr, l, d1 - 1, x); //make upper bound equal to d1 -1. Call method.
			
			
		} else if(arr[d2] < x){ //if x is larger than the last third (upper divider), make the lower
								//bound equal to the upper divider d2 + 1. Call method.
			
			
			return terSearch(arr, d2 + 1, r, x);
		} else { //else means the only other option - between d1 and d2 dividers.
			return terSearch(arr, d1, d2, x); // replace the lower and upper bound with d1 and d2 respectively.
		}
		
			
	}

	
	public static void main(String[] args) {
		
		int x = 4; //number to find.
		int r = 6;
		int l = 0;
		int [] arr = {0, 5, 4, 3, 2, 8}; //array
		Arrays.sort(arr); //sort the array
		
		ThirdProblem list = new ThirdProblem();
		list.terSearch(arr, l, r, x);
		
		

	}

}
