package com.example.jpetmanegement.controller;


import com.example.jpetmanegement.domain.Category;
import com.example.jpetmanegement.domain.Item;
import com.example.jpetmanegement.domain.Product;
import com.example.jpetmanegement.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/catalog/")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;


    @GetMapping("view")
    public String view(Model model) {
        //boolean authenticated = false;
        //model.addAttribute("authenticated",authenticated);
        return "catalog/main";
    }

    @GetMapping("viewGoods")
    public String viewGoods(Model model) {
        //boolean authenticated = false;
        //model.addAttribute("authenticated",authenticated);
        return "catalog/GoodsManagement";
    }
    @GetMapping("viewCategory")
    public String viewCategory(Model model){
        List<Category> categoryList = catalogService.getCategoryList();
        model.addAttribute("categoryList",categoryList);
        return "catalog/category";
    }
    @GetMapping("deleteCategory")
    public String deleteCategory(String categoryId ,Model model){

        if(categoryId != null ){
            catalogService.deleteCategory(categoryId);
        }
        List<Category> categoryList = catalogService.getCategoryList();
        model.addAttribute("categoryList",categoryList);
        return "catalog/category";
    }

    @GetMapping("updateCategory")
    public String updateCategory(String categoryId ,Model model){
        Category category = catalogService.getCategory(categoryId);
        model.addAttribute("category",category);
        return "catalog/updateCategory";
    }
    @GetMapping("updateCategoryInfo")
    public String updateCategoryInfo(String categoryId,String newCategoryId,String name,String description,Model model){
        if(catalogService.getCategory(categoryId) !=null){
            catalogService.updateCategory(categoryId,newCategoryId,name,description);
        }
        List<Category> categoryList = catalogService.getCategoryList();
        model.addAttribute("categoryList",categoryList);
        return "catalog/category";
    }

    @GetMapping("addCategory")
    public String addCategory(String categoryId,String name,String description,Model model){
        if(categoryId != null){
            catalogService.addCategory(categoryId,name,description);
        }else{
            String msg = "Please enter a category id , then press the add button.";
            model.addAttribute("msg", msg);
            return "common/error";}
        List<Category> categoryList = catalogService.getCategoryList();
        model.addAttribute("categoryList",categoryList);
        return "catalog/category";
    }

    @GetMapping("searchCategory")
    public  String searchCategory(String name , Model model){
        if(name != null){
            List<Category> categoryList = catalogService.searchCategoryList(name.toLowerCase());
            // catalogService.processProductDescription(productList);
            model.addAttribute("categoryList", categoryList);
        }else{
            List<Category> categoryList = catalogService.getCategoryList();
            model.addAttribute("categoryList",categoryList);
        }
        return "catalog/category";
    }

    @GetMapping("viewProduct")
    public String viewProduct(Model model){
        List<Product> productList = catalogService.getProductList();
        model.addAttribute("productList",productList);
        return "catalog/product";
    }

    @GetMapping("groundProduct")
    public  String groundProduct(String productId,Model model){
        if(catalogService.getProductGround(productId).equals("grounding")){
            catalogService.updateProductGround(productId,"grounded");
        }else {
            catalogService.updateProductGround(productId,"grounding");
        }
        List<Product> productList = catalogService.getProductList();
        model.addAttribute("productList",productList);
        return "catalog/product";
    }

    @GetMapping("searchProduct")
    public  String searchProduct(String name , Model model){
        if(name != null){
            List<Product> productList = catalogService.searchProductList(name.toLowerCase());
            // catalogService.processProductDescription(productList);
            model.addAttribute("productList", productList);
        }else{
            List<Product> productList = catalogService.getProductList();
            model.addAttribute("productList",productList);
        }
        return "catalog/product";
    }

    @GetMapping("addProduct")
    public String addProduct(String productId , String categoryId,String name,String description,Model model){
        if(catalogService.getCategory(categoryId)!= null){
            catalogService.addProduct(productId,categoryId,name,description);
        }else{
            String msg = "Please enter a  right category id , then press the add button.";
            model.addAttribute("msg", msg);
            return "common/error";}
        List<Product> productList = catalogService.getProductList();
        model.addAttribute("productList",productList);
        return "catalog/product";
    }

    @GetMapping("deleteProduct")
    public String deleteProduct(String productId ,Model model){

//        if(productId != null ){
            catalogService.deleteProduct(productId);
//        }
        List<Product> productList = catalogService.getProductList();
        model.addAttribute("productList",productList);
        return "catalog/product";
    }

    @GetMapping("updateProduct")
    public String updateProduct(String productId ,Model model){
        Product product = catalogService.getProduct(productId);
        model.addAttribute("product",product);
        return "catalog/updateProduct";
    }
    @GetMapping("updateProductInfo")
    public String updateProductInfo(String productId,String newProductId,String categoryId,String name,String description,Model model){
        if(catalogService.getCategory(categoryId) !=null){
            catalogService.updateProduct(productId,newProductId,categoryId,name,description);
        }else{
            String msg = "Please enter a  right category id , then press the update button.";
            model.addAttribute("msg", msg);
            return "common/error";}
        List<Product> productList = catalogService.getProductList();
        model.addAttribute("productList",productList);
        return "catalog/product";
    }


    @GetMapping("viewItem")
    public String viewItem(Model model){
        List<Item> itemList = catalogService.getItemList();
        model.addAttribute("itemList",itemList);
        return "catalog/item";
    }

    @GetMapping("searchItem")
    public  String searchItem(String name , Model model){
        if(name != null){
            List<Item> itemList = catalogService.searchItemList(name.toLowerCase());
            // catalogService.processProductDescription(productList);
            model.addAttribute("itemList", itemList);
        }else{
            List<Item> itemList = catalogService.getItemList();
            model.addAttribute("itemList",itemList);
        }
        return "catalog/item";
    }

    @GetMapping("addItem")
    public String addItem(String itemId, String productId , String listPrice, String unitCost, String supplierId, String status, String attribute1, Model model){
//        BigDecimal newListPrice = new BigDecimal(listPrice);
//        BigDecimal newUnitCost = new BigDecimal(unitCost);
//        int newSupplierId =  Integer.parseInt(supplierId);

        if(catalogService.getProduct(productId)!= null){
            catalogService.addItem(itemId,productId,listPrice,unitCost,1,status,attribute1);
        }else{
            String msg = "Please enter a  right productId id , then press the add button.";
            model.addAttribute("msg", msg);
            return "common/error";}
        List<Item> itemList = catalogService.getItemList();
        model.addAttribute("itemList",itemList);
        return "catalog/item";
    }

    @GetMapping("deleteItem")
    public String deleteItem(String itemId ,Model model){

//        if(productId != null ){
        catalogService.deleteItem(itemId);
//        }
        List<Item> itemList = catalogService.getItemList();
        model.addAttribute("itemList",itemList);
        return "catalog/item";
    }

    @GetMapping("updateItem")
    public String updateItem(String itemId ,Model model){
        Item item = catalogService.getItem(itemId);
        model.addAttribute("item",item);
        return "catalog/updateItem";
    }
//    @GetMapping("updateProduct")
//    public String updateProduct(String productId ,Model model){
//        Product product = catalogService.getProduct(productId);
//        model.addAttribute("product",product);
//        return "catalog/updateProduct";
//    }




    @GetMapping("updateItemInfo")
    public String updateItemInfo(String itemId,String newItemId,String productId,String listPrice, String unitCost, String supplierId, String status, String attribute1,Model model){
        if(catalogService.getItem(itemId) !=null){
            catalogService.updateItem(itemId,newItemId,productId,listPrice,unitCost,1,status,attribute1);
        }else{
            String msg = "Please enter a  right itemId  , then press the update button.";
            model.addAttribute("msg", msg);
            return "common/error";}
        List<Item> itemList = catalogService.getItemList();
        model.addAttribute("itemList",itemList);
        return "catalog/item";
    }
}
