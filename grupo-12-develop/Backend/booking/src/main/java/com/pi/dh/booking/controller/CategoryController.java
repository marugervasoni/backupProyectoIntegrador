package com.pi.dh.booking.controller;


import com.pi.dh.booking.dto.CategoryDTO;
import com.pi.dh.booking.dto.ResponseDTO;
import com.pi.dh.booking.util.Constant;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.pi.dh.booking.service.interfaces.ICategoryService;

import java.util.List;

@RestController
@RequestMapping(Constant.Endpoints.CATEGORIES)
public class CategoryController {

    private ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseDTO<List<CategoryDTO>> getCategories(){

        List<CategoryDTO> response = categoryService.listCategories();

        return new ResponseDTO<>(HttpStatus.OK.value(),
                Constant.SuccessResponse.GET_ALL_CATEGORIES, response);
    }

    @GetMapping(value= Constant.Endpoints.GET_CATEGORY, produces="application/json")
    public ResponseDTO<CategoryDTO> getCategoryById(@PathVariable("id") int id) {

        CategoryDTO category = categoryService.findCategoryById(id);

        return new ResponseDTO<>(HttpStatus.OK.value(),
                Constant.SuccessResponse.CATEGORY_CREATED, category);
    }

    @PostMapping(value=Constant.Endpoints.CREATE_CATEGORY, produces = "application/json")
    public ResponseDTO<String> createCategory(@RequestBody CategoryDTO categoryDTO){

        String message = categoryService.createCategory(categoryDTO);

        return new ResponseDTO<>(HttpStatus.OK.value(), message);
    }

    @PutMapping(value = Constant.Endpoints.UPDATE_CATEGORY, produces = "application/json")
    public ResponseDTO<String> updateCategory(@PathVariable("id") int id,
                                              @RequestBody CategoryDTO category){

        String response = categoryService.updateCategory(id, category);

        return new ResponseDTO<>(HttpStatus.OK.value(), response);
    }

    @DeleteMapping(value =Constant.Endpoints.DELETE_CATEGORY, produces = "application/json")
    public ResponseDTO<String> deleteCategory(@PathVariable("id") int id){

        String response = categoryService.deleteById(id);

        return new ResponseDTO<>(HttpStatus.OK.value(), response);
    }
}
