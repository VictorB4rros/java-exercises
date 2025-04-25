package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.CompanyTaxPayer;
import entities.IndividualTaxPayer;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of tax payers: ");
		Integer n = sc.nextInt();
		sc.nextLine();
		
		List<TaxPayer> list = new ArrayList<>();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char option = sc.next().charAt(0);
			sc.nextLine();
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			Double anualIncome = sc.nextDouble();
			
			if (option == 'i') {
				System.out.print("Health expenses: ");
				Double healthExpenses = sc.nextDouble();
				list.add(new IndividualTaxPayer(name, anualIncome, healthExpenses));
			}
			else {
				System.out.print("Number of employees: ");
				Integer numberOfEmployees = sc.nextInt();
				list.add(new CompanyTaxPayer(name, anualIncome, numberOfEmployees));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		Double totalTaxes = 0.0;
		for (TaxPayer taxPayer : list) {
			System.out.printf("%s: $ %.2f\n", taxPayer.getName(), taxPayer.taxCalculation());
			totalTaxes += taxPayer.taxCalculation();
		}
		
		System.out.println();
		System.out.printf("TOTAL TAXES: $ %.2f", totalTaxes);
		
		sc.close();
	}

}
