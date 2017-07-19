package test.automobili.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.automobili.model.Automobil;
import test.automobili.service.AutomobilService;
import test.automobili.service.ModelService;
import test.automobili.web.dto.AutomobilDTO;

@Component
public class AutomobilDtoToAutomobil implements Converter<AutomobilDTO, Automobil> {

	@Autowired
	private AutomobilService automobilService;
	
	@Autowired
	private ModelService modelService;
	
	@Override
	public Automobil convert(AutomobilDTO dto) {
		
		Automobil automobil;
		
		if(dto.getId() == null) {
			automobil = new Automobil();
			automobil.setModel(modelService.findOne(dto.getModel().getId()));
		} else {
			automobil = automobilService.findOne(dto.getId());
			automobil.setModel(modelService.findOne(dto.getModel().getId()));
		}
		
		automobil.setId(dto.getId());
		automobil.setGodiste(dto.getGodiste());
		automobil.setKilometraza(dto.getKilometraza());
		automobil.setCena(dto.getCena());
		
		return automobil;
	}

}
