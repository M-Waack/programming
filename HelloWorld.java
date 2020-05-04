import java.text.NumberFormat;
import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final byte MONTHS_IN_YEAR = 12;
		final byte PERCENT = 100;
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		
		
		System.out.println("Hello!");
		Scanner scanner = new Scanner(System.in);
		int principal;
		float interestannual;
		byte periodyears;
		
		while (true) {
			System.out.print("Enter principal ($1K - $1M): ");
			principal = scanner.nextInt();
			if (principal < 1_000 || principal > 1000_000) {
				System.out.println("Enter a value between $1,000 and $1,000,000.");
				continue;
			}
			break;
		}
		
		while (true) {
			System.out.print("Enter annual interest rate (1% - 30%): ");
			interestannual = scanner.nextFloat();
			if (interestannual <= 0 || interestannual > 30) {
				System.out.println("Enter a value between 1 and 30.");
				continue;
			}
			break;
		}
		
		while (true) {
			System.out.print("Enter the period in years (1 - 30): ");
			periodyears = scanner.nextByte();
			if (periodyears <= 0 || periodyears > 30) {
				System.out.println("Enter a value between 1 and 30.");
				continue;
			}
			break;
		}
		
		
		// pre-calculations
		double interestmonthly = interestannual / MONTHS_IN_YEAR / PERCENT;
		double months = periodyears * MONTHS_IN_YEAR;
		
		
		
		double mortgage = principal * (interestmonthly * Math.pow((1 + interestmonthly), months) / (Math.pow((1 + interestmonthly), months)-1));
		String result = currency.format(mortgage);
		System.out.println("Your mortgage is: " + result);
	}

}
