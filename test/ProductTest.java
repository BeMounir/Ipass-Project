import Main.Model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductTest {
    private Product product;

    @Test
    public void testIsValid() {
        Product validProduct = new Product(1, "testschoen1", "schoen description", "nike", 159.99, "Rood", "Large", new String[]{"image1.jpg"});
        assertTrue(validProduct.isValid());

        Product invalidProductEmptyName = new Product(2, "", "schoen description", "nike", 159.99, "Rood", "Large", new String[]{"image1.jpg"});
        assertFalse(invalidProductEmptyName.isValid());

        Product invalidProductEmptyDescription = new Product(3, "testschoen1", "", "nike", 159.99, "Rood", "Large", new String[]{"image1.jpg"});
        assertFalse(invalidProductEmptyDescription.isValid());

        Product invalidProductEmptyBrand = new Product(4, "testschoen1", "schoen description", "", 159.99, "Rood", "Large", new String[]{"image1.jpg"});
        assertFalse(invalidProductEmptyBrand.isValid());

        Product invalidProductZeroPrice = new Product(5, "testschoen1", "schoen description", "nike", 0, "Rood", "Large", new String[]{"image1.jpg"});
        assertFalse(invalidProductZeroPrice.isValid());

        Product invalidProductEmptyColor = new Product(6, "testschoen1", "schoen description", "nike", 159.99, "", "Large", new String[]{"image1.jpg"});
        assertFalse(invalidProductEmptyColor.isValid());

        Product invalidProductEmptySize = new Product(7, "testschoen1", "schoen description", "nike", 159.99, "Rood", "", new String[]{"image1.jpg"});
        assertFalse(invalidProductEmptySize.isValid());
    }

    @Test
    public void testGetAllProducts() {
        // Create test products
        Product product1 = new Product(1, "Schoen 1", "Description 1", "Brand 1", 99.99, "Black", "Medium", new String[]{"image1.jpg"});
        Product product2 = new Product(2, "Schoen 2", "Description 2", "Brand 2", 199.99, "White", "Large", new String[]{"image2.jpg"});
        Product product3 = new Product(3, "Schoen 3", "Description 3", "Brand 3", 299.99, "Blue", "Small", new String[]{"image3.jpg"});

        Product.addProducts(product1);
        Product.addProducts(product2);
        Product.addProducts(product3);

        List<Product> allProducts = Product.getAllProducts();

        assertTrue(allProducts.contains(product1));
        assertTrue(allProducts.contains(product2));
        assertTrue(allProducts.contains(product3));
    }
}

