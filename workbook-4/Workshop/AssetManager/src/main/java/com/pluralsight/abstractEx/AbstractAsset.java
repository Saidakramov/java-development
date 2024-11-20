package com.pluralsight.abstractEx;

public abstract class AbstractAsset {
    protected String description;
    protected int yearAcquired;
    protected double originalCost;

    public AbstractAsset(String description, int yearAcquired, double originalCost) {
            this.description = description;
            this.yearAcquired = yearAcquired;
            this.originalCost = originalCost;
    }

    public String getDescription() {
        return description;
    }

    public int getYearAcquired() {
        return yearAcquired;
    }
        // now child classes *MUST* override this method
    public abstract double getValue();

}

