/*********************************************************************
 Purpose/Description: Returns every possible sum within an array of 
 numbers.
 Author’s Panther ID: 5540930
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 ********************************************************************/ 

public class FirstProblem {
	public void findSum(int[] numbersArray, int indexStart, int sum) 
	{
	    if(numbersArray.length == indexStart) //If the end of the array is reached
	    {
	        System.out.println(sum); //print out all possible sums.
	        return;
	    }

	    int value = sum + numbersArray[indexStart]; //redefine this value every recursive step
	    									        //to equal the value of the previous value
	    findSum(numbersArray, indexStart + 1, value);//in the last recursive step for that number,  
	    											//the value of the following index in the array.
	    findSum(numbersArray, indexStart + 1, sum); //goes to the next index and adds that value to all other values.
	}
	
	public static void main(String[] args)
	{
		FirstProblem sums = new FirstProblem();
	    sums.findSum(new int[] {3, 2, 4, 7}, 0, 0); // The array
	}
	}


