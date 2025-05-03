package exception;

public class DeptNotFoundException extends Exception {
	public DeptNotFoundException()
	{
		super("DEP Not Found");
	}
	public DeptNotFoundException(String message) //--exception
	{
		super(message);
	}

}
