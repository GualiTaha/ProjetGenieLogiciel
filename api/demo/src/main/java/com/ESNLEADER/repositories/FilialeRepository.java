package com.ESNLEADER.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ESNLEADER.model.Filiale;
@Repository
public interface FilialeRepository extends JpaRepository<Filiale, Long>{

}
