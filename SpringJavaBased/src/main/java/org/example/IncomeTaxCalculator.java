package org.example.EmployeePayRoll;


public class IncomeTaxCalculator implements TaxCalculator{

    public double calculateTax(double salary) {
        return salary*0.2;
    }
}
