package com.ask.feastfreedom.repos;

import com.ask.feastfreedom.entities.Kitchen;
import com.ask.feastfreedom.entities.User;
import com.ask.feastfreedom.entities.WorkingDays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface WorkingDaysRepo extends JpaRepository<WorkingDays, Long> {

//    @Query("from User u where u.email = :email and u.password = :password")
//    void deleteByKitchenId(@Param("email") String email, @Param("password") String password);

    @Transactional
    @Modifying
    @Query("delete from WorkingDays wk where wk.kitchen = :kitchen")
    void deleteByKitchen(@Param("kitchen") Kitchen kitchen);


}
