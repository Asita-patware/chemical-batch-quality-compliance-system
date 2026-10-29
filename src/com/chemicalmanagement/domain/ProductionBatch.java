package com.chemicalmanagement.domain;

import java.time.LocalDate;

public class ProductionBatch {
    private final String batchNumber;
    private final Chemical chemical;
    private final LocalDate manufacturingDate;
    private double quantity;
    private QualityStatus qualityStatus;


    // constructor
    public ProductionBatch(
            String batchNumber,
            Chemical chemical,
            LocalDate manufacturingDate,
            double quantity) {

        if (batchNumber == null || batchNumber.isBlank()) {
            throw new IllegalArgumentException("Batch number cannot be empty or blank ");
        }
        if (chemical == null) {
            throw new IllegalArgumentException("Chemical cannot be Null");
        }
        if (manufacturingDate == null || manufacturingDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Manufacturing Date cannot be null or in the Future ");
        }
        if (quantity <= 0 || !Double.isFinite(quantity)) {
            throw new IllegalArgumentException("Quantity must be a finite number or greater than zero");
        }



        this.batchNumber = batchNumber;
        this.chemical = chemical;
        this.manufacturingDate = manufacturingDate;
        this.quantity = quantity;
        this.qualityStatus = QualityStatus.PENDING;

    }


    // getters
    public String getBatchNumber() {
        return batchNumber;
    }

    public Chemical getchemical() {
        return chemical;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public double getQuantity() {
        return quantity;
    }

    public QualityStatus getqualityStatus() {
        return qualityStatus;
    }

    public LocalDate getExpirydate() {
        return manufacturingDate.plusDays(chemical.getshelfLifeDays());
    }

    //setters
    public void setQuantity(double quantity){
        if (quantity <= 0 || !Double.isFinite(quantity)){
            throw new IllegalArgumentException("Quantity must be a finite number or greater than zero");
        }
        this.quantity = quantity;
    }

    public void setQualityStatus(QualityStatus qualityStatus){
        if (qualityStatus == null){
            throw new IllegalArgumentException("Quality status can not be null");
        }
        this.qualityStatus = qualityStatus;
    }



}


