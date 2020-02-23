package com.shop.cache;

import com.shop.dao.ProductDAO;
import com.shop.exception.ShopFileException;
import com.shop.model.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ProductCache {
    ProductDAO productDAO = new ProductDAO();
    private static ProductCache instance = null;

    static {
        try {
            instance = new ProductCache();
        } catch (ShopFileException e) {
            e.printStackTrace();
        }
    }

    public HashMap<Integer, Product> cache = new HashMap<>();

    public ProductCache() throws ShopFileException {
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

    // TODO - call it when you write in DAO
    public void reload() throws ShopFileException {
        load();
    }

}
