package test.automobili.service;

import java.util.List;

import test.automobili.model.Model;

public interface ModelService {

	List<Model> findAll();
	Model findOne(Long id);
	Model save(Model model);
	void delete(Long id);
	List<Model> findByMarkaId(Long markaId);
}
