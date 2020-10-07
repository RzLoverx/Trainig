import java.util.Scanner;
public class TrailCalculation {
	double rental;
	double loanAmount;
	double intrestRate;
	int noOfPeriods;
	boolean verify;
	public static void main(String[] args) {
		String input;
		TrailCalculation t1= new TrailCalculation();
		Scanner s1= new Scanner(System.in);
		//Loan amount
		System.out.print("Enter Loan Amount : Rs.");
		input=s1.nextLine();
		while(!t1.Validaten(input)) {
			System.out.print("Enter Loan Amount : Rs.");
			input=s1.nextLine();
		}
		t1.loanAmount=Double.parseDouble(input);
		//no of periods
		System.out.print("Enter Repayment Period in months: ");
		input=s1.nextLine();
		while(!t1.Validaten(input)) {
			System.out.print("Enter Repayment Period in months: ");
			input=s1.nextLine();
		}
		t1.noOfPeriods=Integer.parseInt(input);
		System.out.print("Enter Annum Interest Rate : ");
		input=s1.nextLine();
		while(!t1.Validaten(input)) {
			System.out.print("Enter Annum Interest Rate : ");
			input=s1.nextLine();
		}
		t1.intrestRate=Double.parseDouble(input)/100;
		System.out.println(t1.intrestRate);
		s1.close();
		t1.rental=(t1.loanAmount*t1.intrestRate/12)/(1-(1/Math.pow((1+t1.intrestRate/12), t1.noOfPeriods)));
		
		
		System.out.println("");
		System.out.println("");
		System.out.println("Lorn Amount : Rs."+t1.loanAmount);
		System.out.println("Repayment Period : "+t1.noOfPeriods+" months");
		System.out.println("Annum Interest Rate : "+t1.intrestRate*100+"%");
		System.out.println("Rental Value : Rs."+Math.round(t1.rental*100)/100.00);
		
	}
	
	public boolean Validaten(String number) {
		boolean validate=true;
		int size =number.length();
		for(int index=0;index<size;index++) {
			char numberchar=number.charAt(index);
			if (numberchar=='0'||numberchar=='1'||numberchar=='2'||numberchar=='3'||numberchar=='4'||numberchar=='5'||numberchar=='6'||numberchar=='7'||numberchar=='8'||numberchar=='9'||numberchar=='.') {
				
			}
			else {
				validate=false;
				System.out.println("Wrong input");
				break;
			}
		}
		
		return validate;
	}

}
