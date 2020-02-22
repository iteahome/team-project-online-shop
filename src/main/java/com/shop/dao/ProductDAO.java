package com.shop.dao;

import com.shop.exception.ShopFileException;
import com.shop.exception.ShopTechnicalException;
import com.shop.model.Product;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.lang.Integer.parseInt;

public class ProductDAO {

    private FileUtil<Product> productReader = new FileUtil<>();
    private FileEdit<Product> productEditor = new FileEdit<>();

    public int getNextId() {

        return 0;
    }

    // TODO - instance methods
    public void createProduct(Product product) throws ShopTechnicalException {
        productEditor.write("products.txt", product);
    }

    public List<Product> findAllProducts() throws ShopFileException {
        return productReader.readEntities("products.txt", lines -> new Product(lines[0], lines[1], lines[2], lines[4], parseInt(lines[3])));
    }

}