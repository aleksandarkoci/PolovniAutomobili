package test.automobili.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.automobili.model.Marka;
import test.automobili.repository.MarkaRepository;
import test.automobili.service.MarkaService;

@Service
@Transactional
public class JpaMarkaServiceImpl implements MarkaService {

	@Autowired
	private MarkaRepository markaRepository;
	
	@Override
	public List<Marka> findAll() {

		return markaRepository.findAll();
	}

	@Override
	public Marka findOne(Long id) {

		return markaRepository.findOne(id);
	}

	@Override
	public Marka save(Marka marka) {

		return markaRepository.save(marka);
	}

	@Override
	public void delete(Long id) {

		markaRepository.delete(id);
	}

}
