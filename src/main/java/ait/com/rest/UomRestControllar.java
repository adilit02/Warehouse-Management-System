package ait.com.rest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ait.com.entity.Uom;
import ait.com.service.UomService;

@RestController
public class UomRestControllar {

	@Autowired
	public UomService uomsevice;

	@GetMapping(value = "/all")
	public ResponseEntity<?> getAllUom() {
		ResponseEntity<?> response = null;

		try {

			java.util.List<Uom> list = uomsevice.getAllUom();

			response = new ResponseEntity<java.util.List<Uom>>(list, HttpStatus.OK);
		} catch (Exception e) {

			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}
//___________________________________________________________________________

	@PostMapping(value = "/save")
	public ResponseEntity<String> SaveData(@RequestBody Uom uom) {
		ResponseEntity<String> response = null;

		try {

			uomsevice.saveUom(uom);
			response = new ResponseEntity<String>("Save Sucsess......", HttpStatus.OK);

		} catch (Exception e) {

			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

//___________________________________________________________________________

	@GetMapping(value = "/edit/{id}")
	public ResponseEntity<?> EditData(@PathVariable("id") Integer id)

	{
		ResponseEntity<?> response = null;

		try {
			Uom uom = uomsevice.getUomByid(id);

			response = new ResponseEntity<Uom>(uom, HttpStatus.OK);

		} catch (Exception e) {
			response = new ResponseEntity<String>("Not Exist !", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	// _________________________________________________________________________

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<?> Update(@PathVariable("id") Integer id, @RequestBody Uom uom) {
		ResponseEntity<?> response = null;

		try {

			Uom newuom = uomsevice.getUomByid(uom.getUomid());
			// Uom uomByid = getUomByid(uom.getUomid());
			BeanUtils.copyProperties(uom, newuom);

			uomsevice.UpdateUom(newuom);
			response = new ResponseEntity<String>("Updated Sucsess......!", HttpStatus.OK);

		} catch (Exception e) {

			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

	}

	// _________________________________________________________________________

	@GetMapping(value = "/delete/{id}")

	public ResponseEntity<?> Delete(@PathVariable("id") Integer id)

	{
		ResponseEntity<?> response = null;

		try {

			uomsevice.deleteUom(id);

			response = new ResponseEntity<String>("Delete Sucsess.... !", HttpStatus.OK);

		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
