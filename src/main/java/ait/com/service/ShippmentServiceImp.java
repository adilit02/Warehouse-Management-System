package ait.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ait.com.entity.Shippment;
import ait.com.exception.ShippmentNotFoundException;
import ait.com.repo.ShippmentRepo;

@Service
public class ShippmentServiceImp implements ShippmentService {

	
	@Autowired
	private ShippmentRepo shippmentrepo;
	
	@Override
	public boolean saveShippment(Shippment shippment) {
		
		return shippmentrepo.save(shippment).getsId()!= null;
	}

	@Override
	public List<Shippment> getAllShippment() {
		
		return shippmentrepo.findAll();
	}

	@Override
	public Shippment getShippmentByid(Integer sid) {
		
Optional<Shippment> optional = shippmentrepo.findById(sid);
		
Shippment shippment=null;

		if(optional.isPresent())
		{
			shippment=optional.get();
			return shippment;
		}
		else
		{
			throw new ShippmentNotFoundException("Shippment Is Not Exist !");
		}
		
	}

	@Override
	public void UpdateShippment(Shippment shippment) {

		shippmentrepo.save(shippment);
	}

	@Override
	public void deleteShippment(Integer sid) {
		
		
		shippmentrepo.deleteById(sid);
	}

	
	
}
