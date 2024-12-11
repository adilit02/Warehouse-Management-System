package ait.com.exception;

public class UomNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	UomNotFoundException()
	{
		
	}
	
	public UomNotFoundException(String msg)
	{
		super(msg);
	}
}
