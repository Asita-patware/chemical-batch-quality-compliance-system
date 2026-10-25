package com.chemicalmanagement.domain;

public class Chemical {
     private String chemicalId;
     private String name;
     private String unit;
    private int shelfLifeDays;

    public Chemical(String chemicalId, String name, String unit, int shelfLifeDays){

        if (chemicalId == null || chemicalId.isBlank()){
            throw new IllegalArgumentException("ChemicalId cannot be empty or blank");
        }
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be empty or blank");
        }
        if (unit == null || unit.isBlank()){
            throw new IllegalArgumentException("Unit cannot be empty or blank");
        }
        if (shelfLifeDays <= 0){
            throw new IllegalArgumentException("shelfLife cannot be less than 1");
        }



        this.chemicalId = chemicalId;
        this.name = name;
        this.unit = unit;
        this.shelfLifeDays = shelfLifeDays;
    }

    public String getchemicalId() {
        return chemicalId;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public int getshelfLifeDays() {
        return shelfLifeDays;
    }


}


