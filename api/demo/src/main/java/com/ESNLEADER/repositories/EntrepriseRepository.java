package com.ESNLEADER.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ESNLEADER.model.Entreprise;
@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long>{

}
