package com.ask.feastfreedom.repos;

import com.ask.feastfreedom.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order, Long> {
}
