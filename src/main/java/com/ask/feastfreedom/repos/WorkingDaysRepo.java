package com.ask.feastfreedom.repos;

import com.ask.feastfreedom.entities.WorkingDays;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingDaysRepo extends CrudRepository<WorkingDays, Long> {
}
