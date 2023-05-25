package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdminService {
    private String adminName;
    private String adminEmail;
    private ArrayList<Product> beheerdeProducten;
    public void addProduct(Product product) {
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }
}