package com.shop.cache;

import com.shop.dao.ProductDAO;
import com.shop.exception.ShopFileException;
import com.shop.model.Product;

import java.util.HashMap;

public class ProductCache {
    private ProductDAO productDAO = new ProductDAO();
    private static ProductCache instance = null;

    static {
        try {
            instance = new ProductCache();
        } catch (ShopFileException e) {
            e.printStackTrace();
        }
    }

    public HashMap<Integer, Product> cache = new HashMap<>();

    private ProductCache() throws ShopFileException {
            load();
    }

    private void load() throws ShopFileException {
            for (Product product: productDAO.findAllProducts()
                 ) {
                cache.put(product.getId(), product);
            }
    }

    public static ProductCache get() {
        return instance;
    }

    public void reload() throws ShopFileException {
        load();
    }

}
