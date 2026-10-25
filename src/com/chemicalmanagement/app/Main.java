package com.chemicalmanagement.app;

import com.chemicalmanagement.domain.*;
import com.chemicalmanagement.domain.QualityTestResult;
import java.time.LocalDate;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {


        try {
            // Chemical
            Chemical chemical = new Chemical(
                    "CHEM-001",
                    "Industrial Solvent X ",
                    "Litres",
                    180);

            System.out.println("------------");
            System.out.println(chemical.getchemicalId());
            System.out.println(chemical.getName());
            System.out.println(chemical.getUnit());
            System.out.println(chemical.getshelfLifeDays());

            System.out.println("Chemical registered successfully");

            // Batch
            ProductionBatch batch = new ProductionBatch(
                    "BATCH-001",
                    chemical,
                    LocalDate.of(2026,10,24),
                    500.0
                    );

            System.out.println("------------");
            System.out.println("Batch Number - " + batch.getBatchNumber());
            System.out.println("Chemical - " + batch.getchemical().getName());
            System.out.println("manufacturing Date - " + batch.getManufacturingDate());
            System.out.println("Quantity - " + batch.getQuantity());
            System.out.println("Quality Status - " + batch.getqualityStatus());
            System.out.println("Expiry Date - " + batch.getExpirydate());

            batch.setQuantity(450.0);
            batch.setQualityStatus(QualityStatus.PASSED);

            System.out.println("After Updation");
            System.out.println("Quantity - " + batch.getQuantity());
            System.out.println("Quality Status - " + batch.getqualityStatus());

            System.out.println("Production Batch Created Successfully");

            // Quality Test
            QualityTest test = new QualityTest(
                    "TEST-001",
                    "Purity",
                    95.0,
                    100.0,"%");

            System.out.println("---------------------------");
            System.out.println("TestID - " + test.getTestID());
            System.out.println("Test Name - " + test.getTestName());
            System.out.println("Maximum Acceptable Value - " + test.getMaximumAcceptableValue());
            System.out.println("Minimum Acceptable Value - " + test.getMinimumAcceptableValue());
            System.out.println("Unit - " + test.getUnit());

            // purity test -- testing
            System.out.println("88% " + test.isWithinAcceptableLimit(88));
            System.out.println("91% " + test.isWithinAcceptableLimit(91));
            System.out.println("95 " + test.isWithinAcceptableLimit(95));
            System.out.println("98% " + test.isWithinAcceptableLimit(98));
            System.out.println("100% " + test.isWithinAcceptableLimit(100));
            System.out.println("110% " + test.isWithinAcceptableLimit(110));
            System.out.println("-88% " + test.isWithinAcceptableLimit(-88));



            //test -- result
            QualityTestResult result1 = new QualityTestResult(
                    "QTR-001",
                    batch,
                    test,
                    Double.NEGATIVE_INFINITY
                    );
            System.out.println("---------------------------");
            System.out.println("resultID: " + result1.getResultId());
            System.out.println("ProductionBatch Name: " + result1.getBatch().getBatchNumber());
            System.out.println("Quality Test Name: " + result1.getQualityTest().getTestName());
            System.out.println("Measured Value: " + result1.getMeasuredValue());
            System.out.println("Passed 0r Failed: " + result1.isPassed());


        } catch (IllegalArgumentException e){
            System.out.println("Registration Fails " + e.getMessage());

        }
        System.out.println("Application Continues.....");







    }}
