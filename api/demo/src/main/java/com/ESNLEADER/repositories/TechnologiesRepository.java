package com.ESNLEADER.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ESNLEADER.model.Technologies;
@Repository
public interface TechnologiesRepository extends JpaRepository<Technologies, Long> {

}
