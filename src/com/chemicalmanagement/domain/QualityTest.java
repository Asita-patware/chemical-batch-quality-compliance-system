package com.chemicalmanagement.domain;

public class QualityTest {

    private final String testId;
    private final String testName;
    private final double minimumAcceptableValue;
    private final double maximumAcceptableValue;
    private final String unit;

    // constructor
    public QualityTest(
            String testId,
            String testName,
            double minimumAcceptableValue,
            double maximumAcceptableValue, String unit){
        if (testId == null && testId.isBlank()){
            throw new IllegalArgumentException("Test ID cannot be empty or blank");
        }
        if (testName == null || testId.isBlank()){
            throw new IllegalArgumentException("Test name ID cannot be empty or blank");
        }
        if (unit == null || unit.isBlank()){
            throw new IllegalArgumentException("Unit cannot be empty or blank");
        }
        if (!Double.isFinite(maximumAcceptableValue) || !Double.isFinite(minimumAcceptableValue)){
            throw new IllegalArgumentException("Acceptable limit must be finite number");
        }

        if (minimumAcceptableValue > maximumAcceptableValue){
            throw new IllegalArgumentException("Minimum acceptable value cannot exceed maximum");
        }

        this.testId = testId;
        this.testName = testName;
        this.minimumAcceptableValue = minimumAcceptableValue;
        this.maximumAcceptableValue = maximumAcceptableValue;
        this.unit = unit;
    }

    // getters
    public String getTestID(){
        return testId;
    }
    public String getTestName(){
        return testName;
    }
    public double getMaximumAcceptableValue(){
        return maximumAcceptableValue;
    }
    public double getMinimumAcceptableValue(){
        return minimumAcceptableValue;
    }
    public String getUnit(){
        return unit;
    }

    public boolean isWithinAcceptableLimit(double measuredValue){
        if (!Double.isFinite(measuredValue)){
            throw new IllegalArgumentException("measured Value must be a finite number");
        }
        return measuredValue >= minimumAcceptableValue
                && measuredValue <= maximumAcceptableValue;
    }


}

