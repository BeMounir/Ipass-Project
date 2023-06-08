package Main.Model;

import java.util.ArrayList;

public class AdminService {
    private int adminId;
    private String adminName;
    private String adminEmail;
    private ArrayList<Product> beheerdeProducten;

    public void addProduct(Product product) {
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
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