package com.chemicalmanagement.app;

import com.chemicalmanagement.domain.*;
import com.chemicalmanagement.domain.QualityTestResult;
import com.chemicalmanagement.service.QualityControlService;

import java.sql.Array;
import java.time.LocalDate;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        try {
            // Create a Chemical
            Chemical chemical = new Chemical(
                    "CHEM-001",
                    "Industrial Solvent X ",
                    "Litres",
                    180);

            // Create a production Batch
            ProductionBatch batch = new ProductionBatch(
                    "BATCH-001",
                    chemical,
                    LocalDate.of(2026,10,24),
                    500.0
                    );

//            batch.setQuantity(450.0);
//            batch.setQualityStatus(QualityStatus.PASSED);

            //Define required quality tests
            QualityTest purityTest = new QualityTest(
                    "TEST-001",
                    "Purity",
                    95.0,
                    100.0,"%");

            QualityTest viscosityTest = new QualityTest(
                    "TEST-002",
                    "viscosity",
                    10.0,
                    20.0,"%");

            QualityTest densityTest = new QualityTest(
                    "TEST-003",
                    "density",
                    1.0,
                    2.0,"%");

            // record test results
            QualityTestResult result1 = new QualityTestResult(
                    "QTR-001",
                    batch,
                    purityTest,
                    99
                    );

            QualityTestResult result2 = new QualityTestResult(
                    "QTR-002",
                    batch,
                    viscosityTest,
                    12
            );

            QualityTestResult result3 = new QualityTestResult(
                    "QTR-003",
                    batch,
                    densityTest,
                    2
            );

//            System.out.println("-------------------------------------");
//            for (int i=0; i<=result.size(); i++){
//                System.out.println(result.get(i).getResultId());
//                System.out.println(result.get(i).getBatch().getBatchNumber());
//                System.out.println(result.get(i).getQualityTest().getTestName());
//                System.out.println(result.get(i).getMeasuredValue());
//                System.out.println(result.get(i).isPassed());
//
//                System.out.println("--------");
//            }
//            System.out.println(result.size());

            // Store all required tests
            List<QualityTest> requiredTests = new ArrayList<>();
            requiredTests.add(purityTest);
            requiredTests.add(viscosityTest);
            requiredTests.add(densityTest);

            // Store all recorded results
           List<QualityTestResult> results = new ArrayList<>();
            results.add(result1);
            results.add(result2);
            results.add(result3);

            // Evaluate the batch quality
            QualityControlService service = new QualityControlService();
            service.evaluateBatch(batch, requiredTests, results);

            // Display the final quality status
            System.out.println(batch.getqualityStatus());






        } catch (IllegalArgumentException e){
            System.out.println("Registration Fails " + e.getMessage());

        }
        System.out.println("Application Continues.....");







    }


}
