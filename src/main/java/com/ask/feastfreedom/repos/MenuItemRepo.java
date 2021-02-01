package com.ask.feastfreedom.repos;

import com.ask.feastfreedom.entities.MenuItem;
import org.springframework.data.repository.CrudRepository;

public interface MenuItemRepo extends CrudRepository<MenuItem, Long> {
}
