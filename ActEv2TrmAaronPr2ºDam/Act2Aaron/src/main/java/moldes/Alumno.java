package moldes;

public class Alumno {
	private int idAlumno;
	private String nombre;
	private String apellido;
	private String contrasenia;
	//genero constructor sin id es automatico en la bbdd
	public Alumno(int idAlumno, String contrasenia) {
		super();
		this.idAlumno = idAlumno;
		this.contrasenia = contrasenia;
	}
	
	//constructor vacio
	public Alumno() {
		super();
	}
	//get y set 
	public int getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
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
