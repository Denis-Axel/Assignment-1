package SecondProblem;

/*********************************************************************
Purpose/Description: Find a specific number in a square matrix 
efficiently.
Author’s Panther ID: 5540930
Certification:
I hereby certify that this work is my own and none of it is the work of
any other person.
********************************************************************/ 

//a) This algorithm searches by first eliminating the rows and columns 
// smaller than the number to find. The program does this by comparing 
// the number to find to the max value of each row and column (leftmost
// and topmost, respectively). If the number has not been found already,
// then the Search method will look down all columns that were not eliminated.
// This means that before the search even begins, every row and column
// where the number to find cannot be located has already been removed,
// shrinking the matrix and making the algorithm very efficient.
// The first method checks whether or not the value is in the matrix at all,
// doing so by comparing the number to the highest and lowest values in the matrix,
// which are the top left and bottom right values, respectively.

//b) The efficiency of my algorithm is linear: O(2n). This is because the small
// amount of searching that the algorithm does is much smaller than N X N, and so
// for Big-O notation this is discarded. The 2n comes from the beginning of the 
// program, where the code recursively checks whether each topmost or leftmost
// value is less than the number to find.  Omega(1) is the lower
// bound, when the number to find is on the topmost value, leftmost value, or is not in the array
// (Big-Omega).

public class SecondProblem {
	int columncutOff = 3; //decreases when a row is cancelled.
	int rowcutOff = 3; //decreases according to the columns cancelled.
	
	public void missingNum(int[][] matrix, int findNum, int indexColumn, int indexRow){
		//check to see if the value is in the matrix.
		if(matrix[0][0] < findNum){ //if the top left (highest number) is smaller than
			System.out.println("The number is not in the matrix..."); //the number to find,
			System.exit(0); 		//the number is not in the matrix.
		} else if(matrix[indexColumn][indexRow] > findNum){ //if the bottom right (lowest number) 
			System.out.println("The number is not in the matrix..."); //is smaller than the number
			System.exit(0); 								//to find, the number is not in the matrix.
		}
	}
	
	public void shrinkMatrix(int[][] matrix, int findNum, int indexColumn, int indexRow){
		if(matrix[indexColumn][0] == findNum){ //if the leftmost numbers have the number to find.
			System.out.println("Number found!");
			System.exit(0);
		} else if(matrix[0][indexRow] == findNum){ //if the top numbers have the number to find.
			System.out.println("Number found!");
			System.exit(0);
		}
		
		
		if(matrix[0][indexRow] < findNum){ //If the number on the top row is smaller than findNum.
			
				rowcutOff--;
				shrinkMatrix(matrix, findNum, indexColumn, indexRow - 1); //Go to the next row left.
			
			
			
			} else if(matrix[indexColumn][0] < findNum){ //If the number on the left is smaller than findNum.
				
					columncutOff--;
					shrinkMatrix(matrix, findNum, indexColumn - 1, indexRow); //Go to the next column above.
				
			
			}
		indexRow = rowcutOff; //have to row number equal to where the columns were cut off, ignores the
							  //columns with the highest number < the number to find.
	
		
	}
	
	public void Search(int[][] matrix, int findNum, int indexColumn, int indexRow){
		
		if(matrix[indexColumn][indexRow] == findNum){ //If the number to find is in the current position in the array.
			System.out.println("Number found!"); 
			System.exit(0);
		} else if (indexColumn >= columncutOff){ //If the end of the column is reached (stops where the rows were
												 //previously cancelled).
			
			indexColumn = 0;					//go back to the top number.
			Search(matrix, findNum, indexColumn, indexRow - 1); //go to the next row left.
		} else {
			
			//Continue going down the column if the end of columncutOff has not been reached.
			Search(matrix, findNum, indexColumn + 1, indexRow);
			
		}	
	}
	
	
	public static void main(String[] args){
		int[][] matrix = new int[][]{ //The array
			{26, 22, 17, 10},
			{19, 16, 12, 7},
			{12, 10, 7, 4},
			{5, 4, 2, 1}
			
		};
		int indexColumn = 3; //column size
		int findNum = 28; //number to find
		int indexRow = 3; //row size
		
		
		
		SecondProblem thisMatrix = new SecondProblem();
		
		thisMatrix.missingNum(matrix, findNum, indexColumn, indexRow);
		thisMatrix.shrinkMatrix(matrix, findNum, indexColumn, indexRow);
		thisMatrix.Search(matrix, findNum, indexColumn, indexRow);
		
	}
}
