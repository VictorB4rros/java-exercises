package entities;

public class CompanyTaxPayer extends TaxPayer {
	
	private Integer numberOfEmployees;
	
	public CompanyTaxPayer() {
		super();
	}
	
	public CompanyTaxPayer(String name, Double anualIncome, Integer numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}
	
	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}
	
	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}
	
	@Override
	public Double taxCalculation() {
		Double tax = 0.0;
		if (numberOfEmployees <= 10) {
			tax += anualIncome * 0.16;
		}
		else {
			tax += anualIncome * 0.14;
		}
		
		return tax;
	}

}
