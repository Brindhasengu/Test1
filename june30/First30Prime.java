package june30;

public class First30Prime {

	public First30Prime() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int no = 2;
	    int countOfPrimeNos = 0;
	    while (true) {
	      int i = 2;
	      int count = 0;
	      while (i < no) {
	        if (no % i == 0) {
	          count++;
	        }
	        i++;
	      }
	      if (count == 0) {
	        System.out.println(no + " is Prime Number");
	        countOfPrimeNos++;
	        if(countOfPrimeNos==30)
	          break; 
	      }
	      no++;
	    }
	    System.out.println("No. Of Prime Numbers is " + countOfPrimeNos);
	}

}
