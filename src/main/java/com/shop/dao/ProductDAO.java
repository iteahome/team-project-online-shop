package com.shop.dao;

import com.shop.exception.ShopFileException;
import com.shop.exception.ShopTechnicalException;
import com.shop.model.Product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.lang.Integer.parseInt;

public class ProductDAO {

    private FileReader<Product> productReader = new FileReader<>();

    public int getNextId() {
        // Read from product_seq
        // Increment it
        // Write it to product_seq
        // return incremented value
        return 0;
    }

    // TODO - instance methods
    public static void createProduct(Product product) throws ShopTechnicalException {
        FileEdit.write("products.txt", product.dbPrint());
    }

    public List<Product> findAllProducts() throws ShopFileException {
//        return productReader.readEntities("products.txt", new ProductLambda());
        return productReader.readEntities("products.txt", lines -> new Product(lines[0], lines[1], lines[2], lines[4], parseInt(lines[3])));
    }

    // The sama as the above Lambda
    class ProductLambda implements Function<String[], Product> {

        @Override
        public Product apply(String[] lines) {
            return  new Product(lines[0], lines[1], lines[2], lines[4], parseInt(lines[3]));
        }
    }

    class FileReader<T> {

        public List<T> readEntities(String filename, Function<String[], T> function) throws ShopFileException {
            List<T> entityList = new ArrayList<>();
            try {
                File productFile = new File("./src/main/resources/" + filename);
                Scanner productScanner = new Scanner(productFile);
                while (productScanner.hasNextLine()) {
                    String line = productScanner.nextLine();
                    if (line.length() != 0) {
                        T entity = function.apply(line.split("\\|"));
                        entityList.add(entity);
                    }
                }
            } catch (IOException e) {
                throw new ShopFileException("Products File not found", e);
            }

            return entityList;
        }
    }
}