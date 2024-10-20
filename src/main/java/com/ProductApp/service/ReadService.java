package com.ProductApp.service;

import com.ProductApp.dao.ProductDao;
import com.ProductApp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadService {
    @Autowired
    private ProductDao productDao;

    public Product readServ(int id) {
        return this.productDao.getProduct(id);
    }

    public List<Product> readServAll() {
        return this.productDao.getAllProducts();
    }
}
