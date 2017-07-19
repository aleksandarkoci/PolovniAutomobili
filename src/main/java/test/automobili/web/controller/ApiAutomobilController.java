package test.automobili.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import test.automobili.model.Automobil;
import test.automobili.service.AutomobilService;
import test.automobili.support.AutomobilDtoToAutomobil;
import test.automobili.support.AutomobilToAutomobilDto;
import test.automobili.web.dto.AutomobilDTO;

@RestController
@RequestMapping(value = "/api/automobili")
public class ApiAutomobilController {

	@Autowired
	private AutomobilService automobilService;
	
	@Autowired
	private AutomobilToAutomobilDto toDto;
	
	@Autowired
	private AutomobilDtoToAutomobil toAutomobil;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AutomobilDTO>> get (@RequestParam(required = false) Long model,
											 @RequestParam(required = false) Double cenaOd,
											 @RequestParam(required = false) Double cenaDo,
											 @RequestParam(required = false) Integer godOd,
											 @RequestParam(required = false) Integer godDo,
											 @RequestParam(defaultValue = "0") int pageNum) {
		
		Long idMax = model;
		Long idMin = model;
		
		Page<Automobil> automobil;
		
		if(idMin != null || idMax != null || cenaOd != null || cenaDo != null || godOd != null || godDo != null) {
			automobil = automobilService.pretrag(idMin, idMax, cenaOd, cenaDo, godOd, godDo, pageNum);
		} else {
			automobil = automobilService.findAll(pageNum);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(automobil.getTotalPages()));
		return new ResponseEntity<>(toDto.convert(automobil.getContent()), headers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<AutomobilDTO> getById (@PathVariable Long id) {
		
		Automobil automobil = automobilService.findOne(id);
		
		if(automobil == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		
		return new ResponseEntity<>(toDto.convert(automobil), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<AutomobilDTO> add (@RequestBody AutomobilDTO newAutomobil) {
		
		Automobil automobil = toAutomobil.convert(newAutomobil);
		automobilService.save(automobil);
		
		return new ResponseEntity<>(toDto.convert(automobil), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<AutomobilDTO> edit (@PathVariable Long id, @RequestBody AutomobilDTO izmenjen) {
		
		if(!id.equals(izmenjen.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Automobil automobil = toAutomobil.convert(izmenjen);
		automobilService.save(automobil);
		
		return new ResponseEntity<>(toDto.convert(automobil), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<AutomobilDTO> delete(@PathVariable Long id) {
		automobilService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}