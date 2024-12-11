package ait.com.service;

import org.hibernate.mapping.List;

import ait.com.entity.Uom;

public interface UomService {

	public boolean saveUom(Uom uom);
	
	public java.util.List<Uom> getAllUom();
	
	public Uom getUomByid(Integer uomId);
	
	public void UpdateUom(Uom uom);
	public  void deleteUom(Integer uomId);
}
