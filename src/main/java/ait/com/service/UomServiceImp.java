package ait.com.service;

import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import ait.com.entity.Uom;
import ait.com.exception.UomNotFoundException;
import ait.com.repo.UomRepositry;

@Service
public class UomServiceImp implements UomService {

	@Autowired
	private UomRepositry uomrepositry;

	@Override
	public boolean saveUom(Uom uom) {

		return uomrepositry.save(uom).getUomid() != null;
	}

	@Override
	public java.util.List<Uom> getAllUom() {

		return uomrepositry.findAll();
	}

	@Override
	public Uom getUomByid(Integer uomId) {
		
		Optional<Uom> optional = uomrepositry.findById(uomId);
		
		Uom uom=null;

		if(optional.isPresent())
		{
			uom=optional.get();
			return uom;
		}
		else
		{
			throw new UomNotFoundException("Uom Is Not Exist !");
		}
		
	}

	@Override
	public void UpdateUom(Uom uom) {
		
	//	Uom uomByid = getUomByid(uom.getUomid());
	//	BeanUtils.copyProperties(uom, uomByid);

		uomrepositry.save(uom);
	}

	@Override
	public void deleteUom(Integer uomId) {
		
		uomrepositry.deleteById(uomId);

	}

}
