package com.ProductApp.service;

import com.ProductApp.dao.ProductDao;
import com.ProductApp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateService {
    @Autowired
    private ProductDao productDao;

    public int updateServ(int uid, Product product){
        return this.productDao.updateProduct(uid,product);
    }
}
