package test.automobili.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.automobili.model.Model;
import test.automobili.service.ModelService;
import test.automobili.support.ModelToModelDto;
import test.automobili.web.dto.ModelDTO;



@RestController
@RequestMapping(value = "/api/modeli")
public class ApiModelController {

	@Autowired
	private ModelService modelService;
	
	@Autowired
	private ModelToModelDto toDto;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ModelDTO>> getAll() {
		
		List<Model> modeli = modelService.findAll();
		
		if(modeli == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<List<ModelDTO>>(toDto.convert(modeli), HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<ModelDTO> getById (@PathVariable Long id) {
		
		Model model = modelService.findOne(id);
		
		if(model == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<ModelDTO>(toDto.convert(model), HttpStatus.OK);
		}
	}
}
