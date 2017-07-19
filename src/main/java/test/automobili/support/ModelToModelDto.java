package test.automobili.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.automobili.model.Model;
import test.automobili.web.dto.ModelDTO;

@Component
public class ModelToModelDto implements Converter<Model, ModelDTO>{

	@Autowired
	private MarkaToMarkaDto markaToMarkaDto;
	
	@Override
	public ModelDTO convert(Model source) {
		
		ModelDTO dto = new ModelDTO(source.getId(), source.getNaziv(), markaToMarkaDto.convert(source.getMarka()));
		
		return dto;
	}
	
	public List<ModelDTO> convert(List<Model> modeli){
		List<ModelDTO> dtos = new ArrayList<>();
		
		for(Model m : modeli)
			dtos.add(convert(m));
		
		return dtos;
	}

}
