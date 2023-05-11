package com.pi.dh.booking.service.components;

import com.pi.dh.booking.dto.CategoryDTO;
import com.pi.dh.booking.exceptions.GeneralCategoryFieldNullException;
import com.pi.dh.booking.util.Constant;
import org.springframework.stereotype.Component;

@Component
public class ComponentCategory {

    public void validateFields(CategoryDTO categoryDto){
        if(categoryDto.getTitle().isBlank()){
            throw new GeneralCategoryFieldNullException(Constant.
                    ErrorResponse.TITLE_FIELD_NULL);
        }
        if(categoryDto.getDescription().isBlank()){
            throw new GeneralCategoryFieldNullException(Constant.
                    ErrorResponse.DESCRIPTION_FIELD_NULL);
        }
        if(categoryDto.getImageUrl().isBlank()){
            throw new GeneralCategoryFieldNullException(Constant.
                    ErrorResponse.IMAGE_FIELD_NULL);
        }
    }
}
