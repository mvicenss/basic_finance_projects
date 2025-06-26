import java.util.ArrayList;
import java.util.HashMap;
import java.util.AbstractMap.SimpleEntry;


public class Manager {
    HashMap<String, Double> productList = new HashMap<String, Double>(); //Map for each kind of product

    //Arrays for tax type differentiation
    ArrayList<SimpleEntry<String, Double>> supereduced = new ArrayList<>();
    ArrayList<SimpleEntry<String, Double>> reduced = new ArrayList<>();
    ArrayList<SimpleEntry<String, Double>> general = new ArrayList<>();

    //1. ADD A PRODUCT
    public void addProduct(Products product) {
        if(!productList.containsKey(product.getName())) {
            productList.put(product.getName(), product.getTaxType());
        }
        // "Object" of SimpleEntry == Product that will be added to the corresponding ArrayList
        SimpleEntry<String, Double> entry = new SimpleEntry<>(product.getName(), product.getTaxType());

        double taxType = product.getTaxType();
        if(taxType == 0.04){
            supereduced.add(entry);
        }else if(taxType == 0.10){
            reduced.add(entry);
        }else{
            general.add(entry);
        }
    }

    //2. REMOVE A PRODUCT
    public void removeProduct(Products product){
        if(supereduced.contains(new SimpleEntry<>(product.getName(), product.getTaxType()))){
            supereduced.remove(new SimpleEntry<>(product.getName(), product.getTaxType())); //Removing from supereduced
        }else if(reduced.contains(new SimpleEntry<>(product.getName(), product.getTaxType()))){
            reduced.remove(new SimpleEntry<>(product.getName(), product.getTaxType())); //Remove from reduce
        }else{
            general.remove(new SimpleEntry<>(product.getName(), product.getTaxType())); //Remove from general
        }
    }
}
