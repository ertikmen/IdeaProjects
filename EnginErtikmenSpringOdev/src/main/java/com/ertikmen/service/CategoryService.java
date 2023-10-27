package com.ertikmen.service;


import com.ertikmen.dto.response.CategoryResponseDto;
import com.ertikmen.mapper.ICategoryMapper;
import com.ertikmen.repository.ICategoryRepository;
import com.ertikmen.repository.entity.Category;
import com.ertikmen.repository.enums.ECategoryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;


    public List<Category> getCategories() {

        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> category=categoryRepository.findById(id);
        if (category.isEmpty()){
            throw new RuntimeException("Kategori Bulunamadı.");
        }
        return category.get();
    }

    public Category createCategory(Category category) {

        return categoryRepository.save(category);

    }

    public Category updateCategory(Category categoryInfo) {
        return categoryRepository.save(categoryInfo);
    }

    public String deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        return "Kategori silindi.";
    }

    public List<CategoryResponseDto> findAllByCategoryType(ECategoryType categoryType) {

        List<Category> categoryList=categoryRepository.findAllByCategoryType(categoryType);
        return ICategoryMapper.INSTANCE.toCategoryResponseDtos(categoryList);

    }
}
