package com.ask.feastfreedom.repos;

import com.ask.feastfreedom.entities.Kitchen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KitchenRepo extends CrudRepository<Kitchen, Long> {
}
