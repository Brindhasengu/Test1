package june30;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class EBTariff
{
	//Properties
	String name;
	int minimumUnit;
	int maximumUnit;
	float fixedCharge;
	float subsidy;
	
	RangeTariff[] rangeTariff;

	public EBTariff(String name,int minimumUnit,int maximumUnit,float fixedCharge,float subsidy) 
	{
		this.name=name;
		this.minimumUnit=minimumUnit;
		this.maximumUnit=maximumUnit;
		this.fixedCharge=fixedCharge;
		this.subsidy=subsidy;
		rangeTariff = new RangeTariff[3];
	}
	
	public void Print()
	{
		System.out.println(name + " From " + this.minimumUnit + " To " + this.maximumUnit);
	}

	public static void main(String[] args) 
	{
		EBTariff[] tariff = new EBTariff[4];
		tariff[0] = new EBTariff("Band 1",0,100,0,150);
		tariff[0].rangeTariff[0] = new RangeTariff(1,100,1.50f);

		tariff[1] = new EBTariff("Band 2",101,200,20,150);
		tariff[1].rangeTariff[0] = new RangeTariff(1, 200, 1.50f);
		
		tariff[2] = new EBTariff("Band 3",201,500,30,150);
		tariff[2].rangeTariff[0] = new RangeTariff(1, 100, 1.50f);
		tariff[2].rangeTariff[1] = new RangeTariff(101, 200, 2.00f);
		tariff[2].rangeTariff[2] = new RangeTariff(201, 500, 3.00f);
		
		tariff[3]= new EBTariff("Band 4",501,1000,30,150);
		tariff[3].rangeTariff[0] = new RangeTariff(1, 100, 1.50f);
		tariff[3].rangeTariff[1] = new RangeTariff(101, 200, 2.00f);
		tariff[3].rangeTariff[2] = new RangeTariff(201, 300, 3.00f);
		
		// Get the unit consumed for a month
		float units = 0;
		while(true)
		{
			System.out.println("**************************************************");
			System.out.println("Enter monthly unit consumed : ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				String unitsInput = reader.readLine();
				if (unitsInput == "x" || unitsInput == "X")
				{
					break;
				}
				units = Integer.parseInt(unitsInput);
			} catch (IOException e) {
	
				System.out.println("Invalid input");
				continue;
			}
			
			
			// Get the correct tariff band
			EBTariff selectedTariff = null;
			for(int i=0 ; i<=3; i++ )
			{
				if(units >= tariff[i].minimumUnit && units <= tariff[i].maximumUnit)
				{
					selectedTariff = tariff[i];
				}
			}
		
			if(selectedTariff == null)
			{
				System.out.println("No matching tariff band for " + units);
				continue;
			}
			
			// Calculate the net tariff using the selected Band tariff
			float amountToPay = 0;
			for(int i=0;i<=2;i++)
			{
				if(selectedTariff.rangeTariff[i] != null && units > selectedTariff.rangeTariff[i].fromUnit)
				{
					float bandTariff = 0;
					if(units > selectedTariff.rangeTariff[i].toUnit)
					{
						bandTariff = (selectedTariff.rangeTariff[i].toUnit - selectedTariff.rangeTariff[i].fromUnit) * selectedTariff.rangeTariff[i].tariff;
					}
					else
					{
						bandTariff = (units - selectedTariff.rangeTariff[i].fromUnit) * selectedTariff.rangeTariff[i].tariff;
					}
					
					System.out.println("Band " + i + " charge : " + bandTariff);
					amountToPay += bandTariff;
				}
			}
			
			System.out.println("Charge : " + amountToPay);
			System.out.println("Fixed Charge : " + selectedTariff.fixedCharge);
			System.out.println("Subsidy : -" + selectedTariff.subsidy);
			
			amountToPay += selectedTariff.fixedCharge;
			amountToPay -= selectedTariff.subsidy;
			
			if (amountToPay < 0)
			{
				amountToPay = 0;
			}
			
			
		    System.out.println("Amount to pay : " + amountToPay);
		}
	}
}


