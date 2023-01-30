package com.shastra.shastra.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shastra.shastra.model.Batch;
import com.shastra.shastra.repo.Batchrepository;
import com.shastra.shastra.service.Batchservice;

@Service
public class BatchserviceImp implements Batchservice{
	@Autowired
	Batchrepository Batchrepo;

	@Override
	public Batch addBatch(Batch batch) {
		return Batchrepo.save(batch);
	}


	@Override
	public List<Batch> getAllbatches() {
		return Batchrepo.findAll();

	}

}
