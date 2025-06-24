public class Products {
    String name;
    double grossAmount;
    double taxType;

    //Constructor: Initializing
    public Products (String name, double grossAmount, double taxType) {
        this.name = name;
        this.grossAmount = grossAmount;
        this.taxType = taxType;
    }

    //Setters and getters
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public double getGrossAmount(){return grossAmount;}
    public void setGrossAmount(double grossAmount){this.grossAmount = grossAmount;}
    public double getTaxType() {return taxType;}
    public void setTaxType(double taxType) {this.taxType = taxType;}

    @Override
    public String toString(){
        return name + " - Gross value: " + grossAmount + "€, Tax type: " + taxType + "%";
    }
}
