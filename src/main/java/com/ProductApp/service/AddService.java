package com.ProductApp.service;

import com.ProductApp.dao.ProductDao;
import com.ProductApp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddService {

    @Autowired
    private ProductDao productDao;

    public int addserv(Product product) {
        return productDao.addProduct(product);
    }
}
