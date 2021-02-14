package com.ask.feastfreedom.repos;

import com.ask.feastfreedom.entities.Kitchen;
import com.ask.feastfreedom.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KitchenRepo extends CrudRepository<Kitchen, Long> {

    @Query("from Kitchen k where k.email = :email and k.password = :password")
    Kitchen kitchenLogin(@Param("email") String email, @Param("password") String password);
}
