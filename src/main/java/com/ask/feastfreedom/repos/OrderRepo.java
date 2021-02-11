package com.ask.feastfreedom.repos;

import com.ask.feastfreedom.entities.Order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends CrudRepository<Order, Long> {

    List<Order> findByUserId(Long user_id);

}
