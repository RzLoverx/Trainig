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
		//Interest Rate
		System.out.print("Enter Annum Interest Rate : ");
		input=s1.nextLine();
		while(!t1.Validaten(input)) {
			System.out.print("Enter Annum Interest Rate : ");
			input=s1.nextLine();
		}
		//convert to percentage
		t1.intrestRate=Double.parseDouble(input)/100;
		s1.close();
		t1.rental=(t1.loanAmount*t1.intrestRate/12)/(1-(1/Math.pow((1+t1.intrestRate/12), t1.noOfPeriods)));
		
		//output
		System.out.println("");
		System.out.println("Loan Amount : Rs."+t1.loanAmount);
		System.out.println("Repayment Period : "+t1.noOfPeriods+" months");
		System.out.println("Annum Interest Rate : "+t1.intrestRate*100+"%");
		System.out.println("Rental Value : Rs."+Math.round(t1.rental*100)/100.00);
		t1.Printtable(t1.loanAmount, t1.noOfPeriods, t1.intrestRate,Math.round(t1.rental*100)/100.00);
		
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
	
	public void Printtable(double loanA, int numberOfPeriods , double interestRate  ,double rentalValue) {
		System.out.println("_________________________________________________________________________________________");
		System.out.println("| Rental No \t | Rental Value  | Interest Amount | Capital Amount | Capital Balance   |");
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("| 0 \t\t |\t\t | \t\t   | \t\t    | "+loanA+"\t\t|");
		for(int x=1;x<=numberOfPeriods;x++) {
			double ia=Math.round((loanA*interestRate/12)*100)/100.00;
			double ca=Math.round((rentalValue-ia)*100)/100.00;
			loanA=Math.round((loanA-ca)*100)/100.00;
			if(loanA<0) {
				loanA=0;
				System.out.println("| "+x+" \t \t | Rs."+rentalValue+"\t | "+ia+"\t   | "+ca+"\t    | "+loanA+" \t\t|");
			}
			else {
				System.out.println("| "+x+" \t \t | Rs."+rentalValue+"\t | "+ia+"\t   | "+ca+"\t    | "+loanA+"\t\t|");
			}
				
		}
		System.out.println("_________________________________________________________________________________________");
		
	}
}
