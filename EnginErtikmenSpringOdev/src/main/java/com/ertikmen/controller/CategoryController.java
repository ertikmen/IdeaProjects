package com.ertikmen.controller;


import com.ertikmen.dto.response.CategoryResponseDto;
import com.ertikmen.repository.entity.Category;
import com.ertikmen.repository.enums.ECategoryType;
import com.ertikmen.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ertikmen.constant.RestApiUrl.*;

@RestController
@RequestMapping(CATEGORY)
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/get_categories")
    public ResponseEntity<List<Category>> categoryList(){
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @GetMapping("/find_category_by_id/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PostMapping("/category_save")
    public ResponseEntity<?> createCategory(ECategoryType categoryType,String description){
        Category category=Category.builder().categoryType(categoryType).description(description).build();

        try{
            categoryService.createCategory(category);
            return ResponseEntity.ok(category);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Kategori Oluşturulamadı.");
        }

    }
    @PutMapping("/update_category_by_id/{id}")
    public Category updateCategory(@PathVariable Long id,@RequestBody Category category){
        Category categoryInfo=categoryService.findById(id);
        if (categoryInfo!=null){
            categoryInfo.setId(id);
            categoryInfo.setCategoryType(category.getCategoryType());
            categoryInfo.setDescription(category.getDescription());
            return categoryService.updateCategory(categoryInfo);
        }
        return null;
    }

    @DeleteMapping("/delete_category_by_id/{id}")
    public String deleteCategory(@PathVariable Long id){
        Category categoryInfo=categoryService.findById(id);
        if (categoryInfo!=null){
            return categoryService.deleteCategory(id);
        }
        return null;
    }

    @GetMapping("/category_type_description")
    public ResponseEntity<List<CategoryResponseDto>> findAllByCategoryType(ECategoryType categoryType){
        return ResponseEntity.ok(categoryService.findAllByCategoryType(categoryType));
    }





}