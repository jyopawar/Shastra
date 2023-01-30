package com.shastra.shastra.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shastra.shastra.model.Batch;

@Service
public interface Batchservice {

	Batch addBatch(Batch batch);


	List<Batch> getAllbatches();

}
