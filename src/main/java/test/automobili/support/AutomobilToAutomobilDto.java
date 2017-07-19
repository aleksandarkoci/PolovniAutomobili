package test.automobili.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.automobili.model.Automobil;
import test.automobili.web.dto.AutomobilDTO;

@Component
public class AutomobilToAutomobilDto implements Converter<Automobil, AutomobilDTO> {

	@Autowired
	private ModelToModelDto modelToModelDto;
	
	@Override
	public AutomobilDTO convert(Automobil source) {
		
		AutomobilDTO dto = new AutomobilDTO(source.getId(), source.getGodiste(), source.getKilometraza(), source.getCena(), modelToModelDto.convert(source.getModel()));
		
		return dto;
	}
	
	public List<AutomobilDTO> convert(List<Automobil> automobili){
		List<AutomobilDTO> dtos = new ArrayList<>();
		
		for(Automobil a : automobili)
			dtos.add(convert(a));
		
		return dtos;
	}

}
