package com.ask.feastfreedom.repos;

import com.ask.feastfreedom.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
}
