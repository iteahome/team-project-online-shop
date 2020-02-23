package com.shop.service;

import com.shop.cache.ProductCache;
import com.shop.dao.ProductDAO;
import com.shop.exception.ProductNotFoundException;
import com.shop.exception.ShopFileException;
import com.shop.exception.ShopTechnicalException;
import com.shop.model.Product;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;


public class ProductService {

    private ProductDAO productDAO = new ProductDAO();
    private ProductCache productCache = ProductCache.get();

    public void addProduct(String inputProdName, String inputProdCategory, String inputProdQuantity, String inputProductPrice) throws ShopTechnicalException {
        // TODO - change this with sequence no
//        List<Integer> productIds = new ArrayList<>();
//        for (Product product : productDAO.findAllProducts()) {
//            productIds.add(product.getUniqueProdId());
//        }
        productDAO.createProduct(new Product(productDAO.getNextId(), inputProdName, inputProdCategory, inputProdQuantity, inputProductPrice));
        ProductCache.get().reload();
    }

    public List<Product> getProductsByCategoryAndName(String categoryName, String ProductName) throws ShopFileException {
//    TODO - rread from     ProductCache.get()
        return productDAO.findAllProducts().stream()
                .filter(product -> matchesCategoryAndName(categoryName, ProductName, product))
                .collect(Collectors.toList());
    }

    public Product getProductByID(String id) throws ShopFileException, ProductNotFoundException {
        return productCache.cache.get(id);
    }
//    public Product getProductByID(String id) throws ShopFileException, ProductNotFoundException {
//        return productDAO.findAllProducts().stream()
//                .filter(product -> parseInt(id)==(product.getId()))
//                .findFirst()
//                .orElseThrow(ProductNotFoundException::new)
//    }

    private boolean matchesCategoryAndName(String categoryName, String ProductName, Product product) {
        return product.getCategory().toLowerCase().matches(".*" + categoryName.toLowerCase() + ".*") && product.getName().toLowerCase().matches(".*" + ProductName.toLowerCase() + ".*");
    }
}