package com.ProductApp.service;

import com.ProductApp.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteService {
    @Autowired
    private ProductDao productDao;

    public int deleteServ(int id){
        return productDao.deleteProduct(id);
    }
}
