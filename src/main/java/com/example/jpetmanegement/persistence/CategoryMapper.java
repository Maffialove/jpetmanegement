package com.example.jpetmanegement.persistence;

import com.example.jpetmanegement.domain.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CategoryMapper {
    List<Category> getCategoryList();

    void deleteCategory(String categoryId);
    void deleteCategoryProduct(String categoryId);
    void deleteCategoryProductItem(String categoryId);

    void addCategory(String categoryId ,String name,String description);

    Category getCategory(String categoryId);

    void updateCategory(String categoryId,String newCategoryId ,String name ,String description);

    List<Category> searchCategoryList(String keywords);


}
