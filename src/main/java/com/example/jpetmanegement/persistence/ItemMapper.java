package com.example.jpetmanegement.persistence;

import com.example.jpetmanegement.domain.Item;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Repository
public interface ItemMapper {

    void updateInventoryQuantity(Map<String,Object> param);

    int getInventoryQuantity(String itemId);

    List<Item> getItemList();

    Item getItem(String itemId);

    List<Item> searchItemList(String keywords);

    void addItem(String itemId, String productId , String listPrice, String unitCost, int supplierId, String status, String attribute1);

    void deleteItem(String itemId);

    void updateItem(String itemId, String newItemId, String productId, String listPrice, String unitCost, int supplierId, String status, String attribute1);

//    void addItem(String itemId,String productId);

}