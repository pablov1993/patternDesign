package ar.edu.unq.po2.tpIntegrador;

public class Organizacion implements Iorganizacion{
	
	private Ubicacion ubicacion;
	private String tipo;
	private int empleados;
	private IfuncionalidadExterna funcionalidadParaNuevaMuestra;
	private IfuncionalidadExterna funcionalidadParaNuevaVerificacion;


	public Organizacion(Ubicacion ubicacion, String tipo, int empleados, IfuncionalidadExterna funcionalidadParaNuevaMuestra,
			IfuncionalidadExterna funcionalidadParaNuevaVerificacion) {
		
		this.ubicacion = ubicacion;
		this.tipo = tipo;
		this.empleados = empleados;
		this.funcionalidadParaNuevaMuestra = funcionalidadParaNuevaMuestra;
		this.funcionalidadParaNuevaVerificacion = funcionalidadParaNuevaVerificacion;
	}

	
	public IfuncionalidadExterna getFuncionalidadMuestra() {
		return funcionalidadParaNuevaMuestra;
	}

	public void setFuncionalidadMuestra(IfuncionalidadExterna funcionalidadEx) {
		this.funcionalidadParaNuevaMuestra = funcionalidadEx;
	}

	public IfuncionalidadExterna getFuncionalidadVerificacion() {
		return funcionalidadParaNuevaVerificacion;
	}

	public void setFuncionalidadVerificacion(IfuncionalidadExterna funcionalidadEx) {
		this.funcionalidadParaNuevaVerificacion = funcionalidadEx;
	}
	
	@Override
	public void registrarNuevaPublicacion(Muestra muestra, ZonaDeCobertura zona) {
		
		this.getFuncionalidadMuestra().nuevoEvento(this, zona, muestra);
	}

	@Override
	public void registrarNuevaVerificacion(Muestra muestra, ZonaDeCobertura zona) {
		this.getFuncionalidadVerificacion().nuevoEvento(this, zona, muestra);

	}

}
