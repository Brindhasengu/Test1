
package Interface;

public class ABCEmployee implements EmployeeRules
{
public static void main(String[] args)
{
ABCEmployee abc = new ABCEmployee(); 
abc.maintainHours(); 
abc.relocate(); 
}
public void maintainHours()
{
System.out.println("40 Hours");
}

public void relocate()
{
System.out.println("Other City");
}
  
public void report()
{
System.out.println("Manager");
}
  
public void dress()
{
System.out.println("Neatly");
}

}
