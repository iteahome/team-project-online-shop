package com.shop.cache;

import com.shop.model.Product;

import java.util.Map;

public class ProductCache {

    private static final ProductCache instance = new ProductCache();

    private Map<Integer, Product> cache;

    private ProductCache() {
        load();
    }

    private void load() {
        // read from file and put in cache;
    }

    public static ProductCache get() {
        return instance;
    }

    // TODO - call it when you write in DAO
    public void reload() {
        load();
    }

}
