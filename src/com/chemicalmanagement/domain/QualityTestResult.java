package com.chemicalmanagement.domain;

public class QualityTestResult {
    private final String resultId;
    private final ProductionBatch batch;
    private final QualityTest qualityTest;
    private final double measuredValue;
    private final boolean passed;

    public QualityTestResult(
            String resultId,
            ProductionBatch batch,
            QualityTest qualityTest,
            double measuredValue){
        if (resultId == null || resultId.isBlank()){
            throw new IllegalArgumentException("resultID cannot be empty or blank");
        }
        if (batch == null){
            throw new IllegalArgumentException("batch cannot be null");
        }
        if (qualityTest == null){
            throw new IllegalArgumentException("qualityTest cannot be null");
        }
        if (!Double.isFinite(measuredValue)){
            throw new IllegalArgumentException("measuredValue must be a finite number");
        }

        this.resultId = resultId;
        this.batch = batch;
        this.qualityTest = qualityTest;
        this.measuredValue = measuredValue;
        this.passed = qualityTest.isWithinAcceptableLimit(measuredValue);
    }


    public String getResultId(){
        return resultId;
    }
    public QualityTest getQualityTest() {
        return qualityTest;
    }
    public ProductionBatch getBatch() {
        return batch;
    }
    public double getMeasuredValue() {
        return measuredValue;
    }
    public boolean isPassed() {
        return passed;
    }
}
