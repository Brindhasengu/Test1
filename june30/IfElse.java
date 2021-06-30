package june30;

public class IfElse 
{

	public IfElse()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int testscore=86;
		char grade;
		if (testscore >=90)
		{
			grade ='A';
		}
		else if(testscore >= 80)
		{
			grade ='B';
		}
		else if(testscore >=70)
		{
			grade = 'c';
			
		}
		else if(testscore>=60)
		{
			grade = 'D';
			
		}
		else
		{
			grade ='f';
		}
		
		System.out.println("Grade =" +grade);
	}

}
