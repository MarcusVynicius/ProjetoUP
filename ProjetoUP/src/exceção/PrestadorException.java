package exceção;

public class PrestadorException extends Exception{    
	private static final long serialVersionUID = 1L;

	public PrestadorException(String erro) {
    	   super(erro);
       }
}
