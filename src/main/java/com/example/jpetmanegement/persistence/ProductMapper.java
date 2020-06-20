package com.example.jpetmanegement.persistence;

import com.example.jpetmanegement.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {

    List<Product> getProductList();

    Product getProduct(String productId);

    List<Product> searchProductList(String keywords);

    String getProductGround(String productId);

    void updateProductGround(String productId ,String ground);

    void addProduct(String productId,String categoryId ,String name,String description);

    void deleteProduct(String productId);
    void deleteProductItem(String productId);


    void updateProduct(String productId,String newProductId,String categoryId,String name ,String description);

}
