package test.automobili.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.automobili.model.Model;
import test.automobili.repository.ModelRepository;
import test.automobili.service.ModelService;

@Service
@Transactional
public class JpaModelServiceImpl implements ModelService {

	@Autowired
	private ModelRepository modelRepository;
	
	@Override
	public List<Model> findAll() {
		
		return modelRepository.findAll();
	}

	@Override
	public Model findOne(Long id) {
		
		return modelRepository.findOne(id);
	}

	@Override
	public Model save(Model model) {
		
		return modelRepository.save(model);
	}

	@Override
	public void delete(Long id) {
		
		modelRepository.delete(id);
	}

	@Override
	public List<Model> findByMarkaId(Long markaId) {
		
		return modelRepository.findByMarkaId(markaId);
	}

}
