package com.shop.cache;

import com.shop.dao.ProductDAO;
import com.shop.exception.ShopFileException;
import com.shop.model.Product;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ProductCache {

    private static ProductCache instance = null;

    static {
        try {
            instance = new ProductCache();
        } catch (ShopFileException e) {
            e.printStackTrace();
        }
    }

    ProductDAO productDAO = new ProductDAO();

    public Map<Integer, Product> cache = new Map<Integer, Product>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object o) {
            return false;
        }

        @Override
        public boolean containsValue(Object o) {
            return false;
        }

        @Override
        public Product get(Object o) {
            return null;
        }

        @Override
        public Product put(Integer integer, Product product) {
            return null;
        }

        @Override
        public Product remove(Object o) {
            return null;
        }

        @Override
        public void putAll(Map<? extends Integer, ? extends Product> map) {

        }

        @Override
        public void clear() {

        }

        @Override
        public Set<Integer> keySet() {
            return null;
        }

        @Override
        public Collection<Product> values() {
            return null;
        }

        @Override
        public Set<Entry<Integer, Product>> entrySet() {
            return null;
        }
    };

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
