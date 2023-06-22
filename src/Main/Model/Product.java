package Main.Model;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private static List<Product> allProducts = new ArrayList<>();
    private int productId;
    private String name;
    private String description;
    private String brand;
    private double price;
    private String color;
    private String size;
    private String[] images;
    private AdminService productBeheerder;
    private List<ProductRule> allProducttRules;

    public Product(int pI, String nm, String desc, String bd, double pr, String cr, String si, String[] im) {
        productId = pI;
        name = nm;
        description = desc;
        brand = bd;
        price = pr;
        color = cr;
        size = si;
        images = im;
    }

    public static List<Product> getAllProducts() {
        return allProducts;
    }

    public static void addProducts(Product product) {
        allProducts.add(product);
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isValid() {
        if (name == null || name.isEmpty()) {
            return false;
        }
        if (description == null || description.isEmpty()) {
            return false;
        }
        if (brand == null || brand.isEmpty()) {
            return false;
        }
        if (price <= 0) {
            return false;
        }
        if (color == null || color.isEmpty()) {
            return false;
        }
        if (size == null || size.isEmpty()) {
            return false;
        }

        return true;
    }

    public static Product getProductById(int productId) {
        for (Product product : allProducts) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }
}