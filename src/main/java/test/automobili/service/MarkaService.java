package test.automobili.service;

import java.util.List;

import test.automobili.model.Marka;

public interface MarkaService {

	List<Marka> findAll();
	Marka findOne(Long id);
	Marka save(Marka marka);
	void delete(Long id);
}
