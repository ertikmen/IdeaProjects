package com.ertikmen.repository;

import com.ertikmen.repository.entity.Category;
import com.ertikmen.repository.enums.ECategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category,Long> {


    List<Category> findAllByCategoryType(ECategoryType categoryType);




}
