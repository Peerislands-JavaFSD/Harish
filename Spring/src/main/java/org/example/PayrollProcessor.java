package org.example;

public class PayrollProcessor {
    private IncomeTaxCalculator calculator;    //constructor injection
    private String companyName;
    private int fiscalYear;

    public PayrollProcessor(IncomeTaxCalculator calculator, String companyName, int fiscalYear) {
        this.calculator = calculator;
        this.companyName = companyName;
        this.fiscalYear = fiscalYear;
    }

    public void processSalary(String employeeName,double grossSalary){
        double tax=calculator.calculateTax(grossSalary);
        double netSalary=grossSalary-tax;
        System.out.println("Company Name:"+companyName);
        System.out.println("Employee Name:"+employeeName);
        System.out.println("Gross Salary"+grossSalary);
        System.out.println("Tax"+tax);
        System.out.println("Net Salary"+netSalary);
    }

    private PerformanceBonus bonusScheme;    //setter injection
    public void setBonusScheme(PerformanceBonus bonusScheme){
        this.bonusScheme=bonusScheme;
    }

    public void processWithBonus(String employeeName, double grossSalary){
        processSalary(employeeName,grossSalary);

        if(bonusScheme!=null){
            double bonus=bonusScheme.calculateBonus(grossSalary);
            System.out.println("Bonus:"+bonus);
        } else {
            System.out.println("No bonus scheme");
        }
    }
}
