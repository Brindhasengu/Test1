package HowToUseInheritance;

public class ABCD
{
public ABCD()
{
	this("Roja");
System.out.println("I am zero"); 
}
public ABCD(String s)
{
//this(); 
System.out.println("I am " + s); 
}

public void Test()
{
System.out.println("Inside  test"); 
}


public static void main(String[] args)
{
ABCD a = new ABCD(); 
ABCD b = new ABCD("One"); 
a.Test();
b.Test();
}

}
