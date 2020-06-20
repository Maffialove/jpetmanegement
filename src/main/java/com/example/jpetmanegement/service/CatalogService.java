package com.example.jpetmanegement.service;

import com.example.jpetmanegement.domain.Category;
import com.example.jpetmanegement.domain.Item;
import com.example.jpetmanegement.domain.Product;
import com.example.jpetmanegement.persistence.CategoryMapper;
import com.example.jpetmanegement.persistence.ItemMapper;
import com.example.jpetmanegement.persistence.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CatalogService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ItemMapper itemMapper;
    //category series
    public List<Category> getCategoryList() {
        return categoryMapper.getCategoryList();
    }
    public Category getCategory(String categoryId) {
        return categoryMapper.getCategory(categoryId);
    }
    public void deleteCategory(String categoryId){
        categoryMapper.deleteCategoryProductItem(categoryId);
        categoryMapper.deleteCategoryProduct(categoryId);
        categoryMapper.deleteCategory(categoryId);
    }
    public void addCategory(String categoryId ,String name,String description){
        categoryMapper.addCategory(categoryId,name,description);
    }
    public void updateCategory(String categoryId,String newCategoryId,String name,String description){
        categoryMapper.updateCategory(categoryId,newCategoryId,name,description);
    }
    public List<Category> searchCategoryList(String keyword) {
        return categoryMapper.searchCategoryList("%" + keyword.toLowerCase() + "%");
    }


    //product series
    public Product getProduct(String productId) {
        return productMapper.getProduct(productId);
    }
    public String getProductGround(String productId) {
        return productMapper.getProductGround(productId);
    }
    public List<Product> getProductList() {
        return productMapper.getProductList();
    }
    public List<Product> searchProductList(String keyword) {
        return productMapper.searchProductList("%" + keyword.toLowerCase() + "%");
    }
    public void updateProductGround(String productId , String ground){
        productMapper.updateProductGround(productId,ground);
    }
    public void addProduct(String productId,String categoryId ,String name,String description){
        productMapper.addProduct(productId,categoryId,name,description);
    }
    public void deleteProduct(String productId){
        productMapper.deleteProductItem(productId);
        productMapper.deleteProduct(productId);
    }
    public void updateProduct(String productId,String newProductId,String categoryId,String name,String description){
        productMapper.updateProduct(productId,newProductId,categoryId,name,description);
    }

    //item series
    public Item getItem(String itemId){
        return itemMapper.getItem(itemId);
    }
    public List<Item> getItemList(){
        return itemMapper.getItemList();
    }
    public boolean isItemInStock(String itemId) {
        return itemMapper.getInventoryQuantity(itemId) > 0;
    }
    public List<Item> searchItemList(String keyword) {
        return itemMapper.searchItemList("%" + keyword.toLowerCase() + "%");
    }
    public void addItem(String itemId, String productId , String listPrice, String unitCost, int supplierId, String status, String attribute1){
        itemMapper.addItem(itemId,productId,listPrice,unitCost,supplierId,status,attribute1);
    }

    public void deleteItem(String itemId) {
        itemMapper.deleteItem(itemId);
    }

    public void updateItem(String itemId, String newItemId, String productId, String listPrice, String unitCost, int i, String status, String attribute1) {
        itemMapper.updateItem(itemId,newItemId,productId,listPrice,unitCost,1,status,attribute1);
    }
}
