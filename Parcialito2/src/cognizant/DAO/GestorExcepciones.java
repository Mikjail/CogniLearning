package cognizant.DAO;

@SuppressWarnings("serial")
public class GestorExcepciones extends Exception {
	
	public GestorExcepciones(String msje) {
		// TODO Auto-generated constructor stub
		super(msje);
	}

	public GestorExcepciones (String msje, Throwable e){
		super(msje,e.getCause());
	}
}
