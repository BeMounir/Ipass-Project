package Main.Model;

import java.util.ArrayList;

public class ProductRule {
    private int aantal;
    private double ruleTotal;
    private ArrayList<Product> deProduct;
    private Order deProductRule;

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public double getRuleTotal() {
        return ruleTotal;
    }

    public void setRuleTotal(double ruleTotal) {
        this.ruleTotal = ruleTotal;
    }
}