package com.pluralsight;

public class House extends Asset{
    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;


    public House(String description, String dateAcquired, double originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    @Override
    public double getValue() {

        if (getOriginalCost()/squareFoot >= 180.00) {
            condition = 1;
        } else if (getOriginalCost()/squareFoot >= 130.00) {
            condition = 2;
        } else if (getOriginalCost()/squareFoot >= 90.00) {
            condition = 3;
        } else  {
            condition = 4;
        }


        return super.getValue() + (lotSize * 0.25);
    }

    @Override
    public String toString() {
        return "House{" +
                "description='" + getDescription() + '\'' +
                ", dateAcquired='" + getDateAcquired() + '\'' +
                ", originalCost=" + getOriginalCost() +
                ", address='" + address + '\'' +
                ", condition=" + condition +
                ", squareFoot=" + squareFoot +
                ", lotSize=" + lotSize +
                ", value=" + getValue() +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }
}
