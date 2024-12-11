package ait.com.service;

import ait.com.entity.Shippment;

public interface ShippmentService {

	public boolean saveShippment(Shippment shippment);

	public java.util.List<Shippment> getAllShippment();

	public Shippment getShippmentByid(Integer sid);

	public void UpdateShippment(Shippment shippment);

	public void deleteShippment(Integer sid);
}
