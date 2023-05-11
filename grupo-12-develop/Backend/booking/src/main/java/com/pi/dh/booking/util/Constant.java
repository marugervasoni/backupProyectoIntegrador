package com.pi.dh.booking.util;

public class Constant {

    public class SuccessResponse{
        public static final String CATEGORY_CREATED = "Category created successfully";
        public static final String CATEGORY_UPDATED = "Category updated successfully";
        public static final String GET_ALL_CATEGORIES = "Get all categories successfully";
        public static final String DELETE_CATEGORY_BY_ID  = "Category delete successfully";
        public static final String FIND_PRODUCT_BY_ID = "Products by id found  successfully";
        public static final String GET_ALL_PRODUCTS = "Get all products successfully";
        public static final String GET_PRODUCTS_BY_CITY = "Get products by city successfully";
        public static final String GET_RANDOM_PRODUCTS = "Get random products successfully";
        public static final String PRODUCT_CREATED = "Product created successfully";
        public static final String GET_PRODUCTS_BY_CATEGORY = "Products by category found succesfully";
        public static final String GET_ALL_CITIES = "Get all cities successfully";
        public static final String GET_RESERVATION_BY_ID = "Get Reservation successfully";
        public static final String USER_CREATED = "user created successfully";
        public static final String RESERVATION_CREATED = "Reservation created successfully";
        public static final String GET_PRODUCTS_BY_CITY_AND_DATES = "Get products by city and dates successfully";
    }

    public class ErrorResponse {
        public static final String CATEGORY_NOT_FOUND = "Category not found";
        public static final String CATEGORY_ID_DOESNT_EXIST = "Can not delete category";
        public static final String CATEGORY_EMPTY_DATA = "There are not categories";
        public static final String IMAGE_FIELD_NULL = "Image field can not be null or empty";
        public static final String DESCRIPTION_FIELD_NULL = "Description field can not be null or empty";
        public static final String TITLE_FIELD_NULL = "Title field can not be null or empty";
        public static final String PRODUCT_NOT_FOUND = "Product not found";
        public static final String PRODUCT_NOT_FOUND_BY_CITY = "There are no products for city selected";
        public static final String RULE_TITLE_FIELD_NULL = "Rule title can not be null or empty";
        public static final String RULE_DESCRIPTION_FIELD_NULL = "Rule description can not be null or empty";
        public static final String SECURITY_TITLE_FIELD_NULL = "Security title can not be null or empty";
        public static final String SECURITY_DESCRIPTION_FIELD_NULL = "Security description can not be null or empty";
        public static final String CANCELLATION_TITLE_FIELD_NULL = "Cancellation title can not be null or empty";
        public static final String CANCELLATION_DESCRIPTION_FIELD_NULL = "Cancellation description can not be null or empty";
        public static final String PRODUCT_TITLE_FIELD_NULL = "Product title can not be null or empty";
        public static final String PRODUCT_AVAILABILITY_FIELD_NULL = "Product availability can not be null or empty";
        public static final String PRODUCT_DESCRIPTION_FIELD_NULL = "Product description can not be null or empty";
        public static final String CITY_NAME_FIELD_NULL = "City name can not be null or empty";
        public static final String CATEGORY_ID_FIELD_NULL = "Category id can not be null or empty";
        public static final String PRODUCT_IMAGE_URL_FIELD_NULL = "Product image url can not be null or empty";
        public static final String PRODUCT_IMAGE_NAME_FIELD_NULL = "Product image name can not be null or empty";
        public static final String CITY_NOT_FOUND = "City name not found";
        public static final String RESERVATION_NOT_FOUND = "Reservation not found";
    }

    public class Endpoints {
        public static final String CATEGORIES="/categories";
        public static final String GET_CATEGORY = "/{id}";
        public static final String CREATE_CATEGORY = "/create";
        public static final String UPDATE_CATEGORY = "/update/{id}";
        public static final String DELETE_CATEGORY = "/delete/{id}";
        public static final String PRODUCTS = "/products";
        public static final String GET_PRODUCT_BY_ID = "/{id}";
        public static final String GET_PRODUCTS_BY_CITY = "/city/{id}";
        public static final String GET_PRODUCTS_RANDOMLY = "/random";
        public static final String CREATE_PRODUCT = "/create";
        public static final String GET_PRODUCTS_BY_CATEGORY = "/category/{id}";
        public static final String CITIES = "/cities";
        public static final String RESERVATION = "/reservation";
        public static final String GET_RESERVATION_BY_ID = "/{id}";
        public static final String CREATE_RESERVATION = "/create";
        public static final String USER = "/user";
        public static final String CREATE_USER = "/create";
        public static final String GET_PRODUCTS_BY_CITY_DATE = "/dates";
    }

}

