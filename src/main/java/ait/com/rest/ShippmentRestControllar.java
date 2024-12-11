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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ait.com.entity.Shippment;
import ait.com.service.ShippmentService;

@RestController
@RequestMapping("/shippment")
public class ShippmentRestControllar {
	@Autowired
	public ShippmentService Shippmentsevice;

	@GetMapping(value = "/all")
	public ResponseEntity<?> getAllUom() {
		ResponseEntity<?> response = null;
		try {
			java.util.List<Shippment> list = Shippmentsevice.getAllShippment();

			response = new ResponseEntity<java.util.List<Shippment>>(list, HttpStatus.OK);
		} catch (Exception e) {

			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
//___________________________________________________________________________

	@PostMapping(value = "/save")
	public ResponseEntity<String> SaveData(@RequestBody Shippment shippment) {
		ResponseEntity<String> response = null;

		try {
			// System.out.println(shippment);Check Data Object
			Shippmentsevice.saveShippment(shippment);
			response = new ResponseEntity<String>("Save Sucsess......", HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

//___________________________________________________________________________
	@GetMapping(value = "/edit/{sid}")
	public ResponseEntity<?> EditData(@PathVariable("sid") Integer sid) {
		ResponseEntity<?> response = null;

		try {
			Shippment shippment = Shippmentsevice.getShippmentByid(sid);

			response = new ResponseEntity<Shippment>(shippment, HttpStatus.OK);

		} catch (Exception e) {
			response = new ResponseEntity<String>("Not Exist !", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	// _________________________________________________________________________
	@PutMapping(value = "/update/{sId}")
	public ResponseEntity<?> Update(@PathVariable("sId") Integer sid, @RequestBody Shippment shippment) {
		ResponseEntity<?> response = null;
		try {
			Shippment newuom = Shippmentsevice.getShippmentByid(shippment.getsId());
			// Uom uomByid = getUomByid(uom.getUomid());
			BeanUtils.copyProperties(shippment, newuom);

			Shippmentsevice.UpdateShippment(newuom);
			response = new ResponseEntity<String>("Updated Sucsess......!", HttpStatus.OK);

		} catch (Exception e) {

			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	// _________________________________________________________________________
	
	@GetMapping(value = "/delete/{sid}")
	public ResponseEntity<?> Delete(@PathVariable("sid") Integer sid) {
		ResponseEntity<?> response = null;
		try {
			Shippmentsevice.deleteShippment(sid);
			response = new ResponseEntity<String>("Delete Sucsess.... !", HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
