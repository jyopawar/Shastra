package com.shastra.shastra.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shastra.shastra.model.Batch;

@Repository
public interface Batchrepository extends JpaRepository<Batch, Long>{

}
