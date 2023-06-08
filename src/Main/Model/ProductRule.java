package Main.Model;

import java.util.ArrayList;

public class ProductRule {
    private int aantal;
    private double ruleTotal;
    private ArrayList<Product> alleProductRules;
    private ArrayList<Order> alleOrders;

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