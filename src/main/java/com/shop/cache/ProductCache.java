package com.shop.cache;

import com.shop.dao.ProductDAO;
import com.shop.exception.ShopFileException;
import com.shop.model.Product;

import java.util.Map;

public class ProductCache {

    private static final ProductCache instance;

    static {
        try {
            instance = new ProductCache();
        } catch (ShopFileException e) {
            e.printStackTrace();
        }
    }

    ProductDAO productDAO = new ProductDAO();

    private Map<Integer, Product> cache;

    private ProductCache() throws ShopFileException {
        load(); {

        }
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
