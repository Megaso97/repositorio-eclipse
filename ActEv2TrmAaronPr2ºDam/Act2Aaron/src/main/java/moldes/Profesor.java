package moldes;

public class Profesor {
	private int IdProfesor;
	private String nombre;
	private String apellido;
	private String contrasenia;
	public Profesor(int idUsuario, String contrasenia) {
		super();
		this.IdProfesor = idUsuario;
		this.contrasenia = contrasenia;
	}
	public int getIdProfesor() {
		return IdProfesor;
	}
	public void setIdProfesor(int idProfesor) {
		IdProfesor = idProfesor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

}

