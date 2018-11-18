package Model;

public class ShoppingCart {
    private String PartNumber;
    private String ModelDescription;
    private double UnitCost;
    private int iQuantity;
    private double TotalCost;

    public String getPartNumber() {
        return PartNumber;
    }

    public void setPartNumber(String partNumber) {
        PartNumber = partNumber;
    }

    public String getModelDescription() {
        return ModelDescription;
    }

    public void setModelDescription(String modelDescription) {
        ModelDescription = modelDescription;
    }

    public double getUnitCost() {
        return UnitCost;
    }

    public void setUnitCost(double unitCost) {
        UnitCost = unitCost;
    }

    public int getiQuantity() {
        return iQuantity;
    }

    public void setiQuantity(int iQuantity) {
        this.iQuantity = iQuantity;
    }

    public double getTotalCost() {
        return TotalCost;
    }

    public void setTotalCost(double totalCost) {
        TotalCost = totalCost;
    }
}
