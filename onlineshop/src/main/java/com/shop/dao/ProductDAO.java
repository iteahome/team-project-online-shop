package com.shop.dao;

import com.shop.exception.ShopTechnicalException;
import com.shop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public static void createProduct(String productData) throws ShopTechnicalException {
        FileEdit.write("products.txt", productData);
    }

    public static void findAllProducts() {
        List<String> ProductData = new ArrayList<>();
        String line = "";
        while ( (line = FileEdit.findLine("products.txt", "")) != null) {
            ProductData.add(line);
            System.out.println(line);
        }
        List<Product> ProdList = new ArrayList<>();
        for (String prod : ProductData) {
            String[] prodValues = prod.split("\\|");
            ProdList.add(new Product(prodValues[0], prodValues[1], prodValues[2], prodValues[3]));
            System.out.println(ProdList);
        }
    }

}