package test.automobili.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.automobili.model.Marka;
import test.automobili.web.dto.MarkaDTO;

@Component
public class MarkaToMarkaDto implements Converter<Marka, MarkaDTO> {

	@Override
	public MarkaDTO convert(Marka source) {
		
		MarkaDTO dto = new MarkaDTO(source.getId(), source.getNaziv());
		
		return dto;
	}

	public List<MarkaDTO> convert(List<Marka> marke) {
		List<MarkaDTO> dtos = new ArrayList<>();
		
		for(Marka m : marke)
			dtos.add(convert(m));
		
		return dtos;
	}
}
