package com.ask.feastfreedom.repos;

import com.ask.feastfreedom.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    @Query("from User u where u.email = :email and u.password = :password")
    User userLogin(@Param("email") String email, @Param("password") String password);

//    @Query("select c from Customer c where c.email = :email")
//    Stream<Customer> findByEmailReturnStream(@Param("email") String email);
}
