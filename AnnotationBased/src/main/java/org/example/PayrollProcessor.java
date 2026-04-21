package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PayrollProcessor {
    private TaxCalculator calculator;    //constructor injection
    private String companyName;
    private int fiscalYear;

    @Autowired
    public PayrollProcessor(TaxCalculator calculator, @Value("TechCorp Solutions") String companyName,@Value("2026") int fiscalYear) {
        this.calculator = calculator;
        this.companyName=companyName;
        this.fiscalYear=fiscalYear;
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

    private BonusScheme bonusScheme;    //setter injection
    @Autowired
    public void setBonusScheme(BonusScheme bonusScheme){
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
