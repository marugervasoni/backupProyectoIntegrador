package com.pi.dh.booking.service.implementations;

import com.pi.dh.booking.exceptions.CategoryNotFoundException;
import com.pi.dh.booking.service.components.ComponentCategory;
import com.pi.dh.booking.util.Constant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pi.dh.booking.dto.CategoryDTO;
import com.pi.dh.booking.model.CategoryEntity;
import com.pi.dh.booking.repository.ICategoryRepository;
import com.pi.dh.booking.service.interfaces.ICategoryService;

import java.util.*;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {

    private ICategoryRepository categoryRepository;
    private ComponentCategory componentCategory;

    public CategoryServiceImpl(ICategoryRepository categoryRepository,
                               ComponentCategory componentCategory){
        this.categoryRepository = categoryRepository;
        this.componentCategory = componentCategory;
    }

    @Override
    public List<CategoryDTO> listCategories() {

        List<CategoryEntity> category = categoryRepository.findAll();

        if(categoryRepository.findAll().isEmpty()){
            throw new CategoryNotFoundException(Constant.ErrorResponse.CATEGORY_EMPTY_DATA);
        }

        List<CategoryDTO> listCategories = new ArrayList<>();
        for(CategoryEntity entity: category){

            CategoryDTO categoryDto = new CategoryDTO();
            categoryDto.setId(entity.getId());
            categoryDto.setTitle(entity.getTitle());
            categoryDto.setDescription(entity.getDescription());
            categoryDto.setImageUrl(entity.getImageUrl());

            listCategories.add(categoryDto);
        }

        return listCategories;
    }

    @Override
    public CategoryDTO findCategoryById(int id) {

        CategoryEntity category = categoryRepository.findById(id).
                orElseThrow(() -> new CategoryNotFoundException(
                        Constant.ErrorResponse.CATEGORY_NOT_FOUND));

        CategoryDTO response = new CategoryDTO();
        response.setId(category.getId());
        response.setTitle(category.getTitle());
        response.setDescription(category.getDescription());
        response.setImageUrl(category.getImageUrl());

        return response;
    }

    @Override
    public String createCategory(CategoryDTO categoryDto) {

        componentCategory.validateFields(categoryDto);

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setTitle(categoryDto.getTitle());
        categoryEntity.setDescription(categoryDto.getDescription());
        categoryEntity.setImageUrl(categoryDto.getImageUrl());
        categoryRepository.save(categoryEntity);

        return Constant.SuccessResponse.CATEGORY_CREATED;
    }

    @Override
    public String updateCategory(int id, CategoryDTO categoryDto) {

        CategoryEntity categoryEntity = categoryRepository.findById(id).orElseThrow(
                () -> new CategoryNotFoundException(Constant.ErrorResponse.CATEGORY_NOT_FOUND));

        componentCategory.validateFields(categoryDto);

        categoryEntity.setTitle(categoryDto.getTitle());
        categoryEntity.setDescription(categoryDto.getDescription());
        categoryEntity.setImageUrl(categoryDto.getImageUrl());

        categoryRepository.save(categoryEntity);

        return Constant.SuccessResponse.CATEGORY_UPDATED;
    }

    @Override
    public String deleteById(Integer id) {

        if(!categoryRepository.existsById(id)){
            throw new CategoryNotFoundException(Constant.ErrorResponse.CATEGORY_ID_DOESNT_EXIST);
        }

        categoryRepository.deleteById(id);

        return Constant.SuccessResponse.DELETE_CATEGORY_BY_ID;
    }
}
