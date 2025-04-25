package entities;

public class IndividualTaxPayer extends TaxPayer {
	
	private Double healthExpenses;
	
	public IndividualTaxPayer() {
		super();
	}
	
	public IndividualTaxPayer(String name, Double anualIncome, Double healthExpenses) {
		super(name, anualIncome);
		this.healthExpenses = healthExpenses;
	}
	
	public Double getHealthExpenses() {
		return healthExpenses;
	}
	
	public void setHealthExpenses(Double healthExpenses) {
		this.healthExpenses = healthExpenses;
	}
	
	@Override
	public Double taxCalculation() {
		Double tax = 0.0;
		if (anualIncome < 20000.0) {
			tax += anualIncome * 0.15;
		}
		else {
			tax += anualIncome * 0.25;
		}
		
		tax -= healthExpenses * 0.5;
		
		return tax;
	}

}
