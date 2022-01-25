package com.chiranjeet.catalog_service.service;

import java.sql.SQLException;
import java.util.Optional;

import com.chiranjeet.catalog_service.bean.Product;
import com.chiranjeet.catalog_service.bean.ProductList;

public interface ProductService {
	boolean createProduct(Product pro) throws SQLException, ClassNotFoundException;
	boolean deleteProduct(int id) throws SQLException, ClassNotFoundException;
	boolean updateProduct(Product pro) throws SQLException, ClassNotFoundException;
	ProductList findProduct() throws ClassNotFoundException, SQLException;
	Optional<Product> findProduct(String code) throws SQLException, ClassNotFoundException;
	Optional<Product> findProduct(Long product_id) throws SQLException, ClassNotFoundException;
}
