//Doing a mock of our product database
package com.pentagon.product;

import com.pentagon.exceptions.ProductException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Purpose of the ProductDatabase:

public class ProductDatabase {

    private Map<String, Product> mockProducts;

    public ProductDatabase() {
        mockProducts = new HashMap<>();

        Product plantainChips = new Product("Adunni Chips", "Savoury plantain chips", new BigDecimal(50));
        plantainChips.setProductId("AD001");
        mockProducts.put(plantainChips.getProductId(),plantainChips);

        Product noseMask = new Product();
        noseMask.setProductId("AD002");
        noseMask.setName("Bomu e Nose Mask");
        noseMask.setDescription("Best in class Nose Mask");
        noseMask.setPrice(new BigDecimal(4500));
        mockProducts.put(noseMask.getProductId(),noseMask);

        Product shirt = new Product("Vintage Shirt", "Vintage Versace shirt", new BigDecimal(5000));
        shirt.setProductId("AD003");
        mockProducts.put(shirt.getProductId(),shirt);
    }

    public Map<String, Product> getMockProducts() {
        return mockProducts;
    }

    public void setMockProducts(Map<String, Product> mockProducts) {
        this.mockProducts = mockProducts;
    }

    public Product getProductById(String id) throws ProductException {
        /* if(mockProducts.containsKey(id)) {
                mockProducts.get(id);
         */
        Product result = mockProducts.get(id);
        if(result == null) {
            StringBuilder message = new StringBuilder("Product with id");
            message.append(id);
            message.append(" not found.");
            throw new ProductException(message.toString());
        }
        return result;
    }
}
