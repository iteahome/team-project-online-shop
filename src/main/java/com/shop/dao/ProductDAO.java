package com.shop.dao;

import com.shop.exception.ShopFileException;
import com.shop.exception.ShopTechnicalException;
import com.shop.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ProductDAO {

    private FileUtil<Product> productReader = new FileUtil<>();
    private FileEdit<Product> productEditor = new FileEdit<>();
    private FileUtil<String> sequenceReader = new FileUtil<>();
    public void getNextId() throws ShopFileException {
        List<String> sequence = new ArrayList<>();
//        List<Integer> ids = new ArrayList<>();
        List<String[]> ids = new ArrayList<>();
        sequenceReader.readEntities("product_seq.txt", entity-> String.valueOf(ids.add(Collections.max(entity))));
    }

    // TODO - instance methods
    public void createProduct(Product product) throws ShopTechnicalException {
        productEditor.write("products.txt", product);
    }

    public List<Product> findAllProducts() throws ShopFileException {
        return productReader.readEntities("products.txt", lines -> new Product(lines[0], lines[1], lines[2], lines[4], parseInt(lines[3])));
    }

}