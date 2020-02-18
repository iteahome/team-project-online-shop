package com.shop.service;

import com.shop.dao.ProductDAO;
import com.shop.exception.ShopFileException;
import com.shop.exception.ShopTechnicalException;
import com.shop.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService {

    private ProductDAO productDAO = new ProductDAO();

    public void addProduct(String inputProdName, String inputProdCategory, String inputProdQuantity, String inputProducPrice) throws ShopTechnicalException {
        List<Integer> productIds = new ArrayList<>();
        for (Product product: ProductDAO.findAllProducts()){
            productIds.add(Integer.parseInt((product.getUniqueProdId())));
        }
        String productData = inputProdName + "|" + inputProdCategory + "|" + inputProdQuantity + "|" + inputProducPrice + "|" + (Collections.max(productIds)+1);
        productDAO.createProduct(productData);
    }

    //    }
//    public void displayProductsByCategoryAndName (String categoryName, String ProductName) throws ShopFileException {
//        for (Product product : ProductDAO.findAllProducts()
//        ) {
//            if (product.getCategory().matches(".*"+ categoryName + ".*") && product.getProductName().matches(".*"+ ProductName + ".*")) {
//                System.out.println(product.toString());
//            }
//        }
//    }

/// UI is responsiple for system.out.println()

    public List<Product> getProductsByCategoryAndName (String categoryName, String ProductName) throws ShopFileException {
        return ProductDAO.findAllProducts().stream()
                .filter(product -> matchesCategoryAndName(categoryName, ProductName, product))
                .collect(Collectors.toList());
    }

    private boolean matchesCategoryAndName(String categoryName, String ProductName, Product product) {
        return product.getCategory().matches(".*"+ categoryName + ".*") && product.getProductName().matches(".*"+ ProductName + ".*");
    }

    /// REMOVE STATIC
    /// Service & DAO

}