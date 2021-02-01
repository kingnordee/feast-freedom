package com.ask.feastfreedom.repos;

import com.ask.feastfreedom.entities.MenuItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepo extends CrudRepository<MenuItem, Long> {
}
