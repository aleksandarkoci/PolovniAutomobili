package test.automobili.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.automobili.model.Automobil;
import test.automobili.repository.AutomobilRepository;
import test.automobili.service.AutomobilService;

@Service
@Transactional
public class JpaAutomobilServiceImpl implements AutomobilService {

	@Autowired
	private AutomobilRepository automobilRepository;
	
	@Override
	public Page<Automobil> findAll(int pageNum) {
		
		return automobilRepository.findAll(new PageRequest(pageNum, 4));
	}

	@Override
	public Automobil findOne(Long id) {
		
		return automobilRepository.findOne(id);
	}

	@Override
	public Automobil save(Automobil automobil) {
		
		return automobilRepository.save(automobil);
	}

	@Override
	public void delete(Long id) {
		
		automobilRepository.delete(id);
	}

	@Override
	public Page<Automobil> pretrag(Long idMin, Long idMax, Double cenaOd, Double cenaDo, Integer godOd, Integer godDo,
			int page) {
		
		return automobilRepository.pretrag(idMin, idMax, cenaOd, cenaDo, godOd, godDo, new PageRequest(page, 4));
	}

}
