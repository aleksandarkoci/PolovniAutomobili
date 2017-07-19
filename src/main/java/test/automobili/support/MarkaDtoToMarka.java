package test.automobili.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.automobili.model.Marka;
import test.automobili.web.dto.MarkaDTO;

@Component
public class MarkaDtoToMarka implements Converter<MarkaDTO, Marka> {

	@Override
	public Marka convert(MarkaDTO dto) {
		
		Marka marka = new Marka(dto.getId(), dto.getNaziv());
		
		return marka;
	}

}
