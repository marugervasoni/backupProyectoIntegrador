package com.pi.dh.booking.service.interfaces;

import java.util.List;

import com.pi.dh.booking.dto.CategoryDTO;

public interface ICategoryService {
    String createCategory(CategoryDTO categoryDto);
    List<CategoryDTO> listCategories();
    CategoryDTO findCategoryById(int id);
    String updateCategory(int id, CategoryDTO categoryDto);
    String deleteById(Integer id);
}
