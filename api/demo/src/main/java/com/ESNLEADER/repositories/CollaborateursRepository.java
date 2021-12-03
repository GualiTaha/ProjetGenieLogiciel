package com.ESNLEADER.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ESNLEADER.model.Collaborateurs;
@Repository
public interface CollaborateursRepository extends CrudRepository<Collaborateurs, Long> {

}
