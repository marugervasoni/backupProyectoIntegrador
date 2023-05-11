package com.pi.dh.booking.repository;

import com.pi.dh.booking.model.ProductsEntity;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface IProductsRepository extends JpaRepository<ProductsEntity, Integer> {

    List<ProductsEntity> findByCityId(int id);

    @Query(value = "SELECT * FROM products ORDER BY rand()",
            nativeQuery = true)
    List<ProductsEntity> findRandomProducts();

    List<ProductsEntity> findByCategoryId(int id);

    @Query(value="SELECT pr.id, pr.city_id, pr.politic_id, " +
            "pr.categoryid, " +
            "pr.characteristic_id, " +
            "pr.title, " +
            "pr.description, " +
            "pr.availability " +
            "FROM products pr " +
            "INNER JOIN reservation rs " +
            "ON pr.id=rs.products_id " +
            "WHERE rs.start_date_reservation =:startDate " +
            "AND rs.end_date_reservation =:endDate " +
            "AND pr.city_id =:cityId",
    nativeQuery = true)
    List<ProductsEntity> findProductsByDatesAndCity(int cityId, String startDate, String endDate);
}
