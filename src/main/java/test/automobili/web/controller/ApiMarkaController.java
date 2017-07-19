package test.automobili.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.automobili.model.Marka;
import test.automobili.model.Model;
import test.automobili.service.MarkaService;
import test.automobili.service.ModelService;
import test.automobili.support.MarkaToMarkaDto;
import test.automobili.support.ModelToModelDto;
import test.automobili.web.dto.MarkaDTO;
import test.automobili.web.dto.ModelDTO;

@RestController
@RequestMapping(value = "/api/marke")
public class ApiMarkaController {

	@Autowired
	private MarkaService markaService;
	
	@Autowired
	private MarkaToMarkaDto toDto;
	
	@Autowired
	private ModelToModelDto modelToModelDto;
	
	@Autowired
	private ModelService modelService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MarkaDTO>> getAll() {
		
		List<Marka> marke = markaService.findAll();
		
		if(marke == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<MarkaDTO>>(toDto.convert(marke), HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<MarkaDTO> getById (@PathVariable Long id) {
		
		Marka marka = markaService.findOne(id);
		
		if(marka == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<MarkaDTO>(toDto.convert(marka), HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{markaId}/modeli")
	public ResponseEntity<List<ModelDTO>> getByMarkaId (@PathVariable Long markaId) {
		
		List<Model> modeliPoIdMarke = modelService.findByMarkaId(markaId);
		return new ResponseEntity<>(modelToModelDto.convert(modeliPoIdMarke), HttpStatus.OK);
	}
}
