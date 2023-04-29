import java.io.BufferedReader;
import java.time.LocalDateTime;  
import java.io.IOException;
import java.io.InputStreamReader;
public class Dec10

{
	public static void main (String[] args)
			 throws IOException
	{
		System.out.println("What is your Name");
		// Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
		String name = reader.readLine();
		System.out.println(" Hello "   +   name);
		LocalDateTime now = LocalDateTime.now();  
		if(now.getHour()<11)
		{
		System.out.println("good Morning ");
		}
		else
		{
			System.out.println("Good evening");
		}
		}
	}

