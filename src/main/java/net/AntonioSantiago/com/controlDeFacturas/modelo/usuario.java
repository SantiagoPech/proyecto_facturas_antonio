package net.AntonioSantiago.com.controlDeFacturas.modelo;

import java.sql.Date;
import java.util.Collection;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "imagen")
	private String imagen="no-image.png";

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	private String email;
	
	private Date fecha;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<factura> facturas;
	
	
	
	@PrePersist
    protected void onCreate() {
        this.fecha = new Date(System.currentTimeMillis());
    }
	
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
			name = "usuarios_roles",
			joinColumns = @JoinColumn(name = "usuario_id",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "rol_id",referencedColumnName = "id")
			)
	private Collection<rol> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public void reset() {
		this.imagen = null;
	}

	public Collection<rol> getRoles() {
		return roles;
	}

	public void setRoles(Collection<rol> roles) {
		this.roles = roles;
	}

	public usuario(Long id, String imagen, String nombre, String apellido, String email, String password, Collection<rol> roles) {
		super();
		this.imagen = imagen;
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public usuario(String imagen, String nombre, String apellido, String email, Date fecha, String password, Collection<rol> roles) {
		super();
		this.imagen = imagen;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fecha = fecha;
		this.password = password;
		this.roles = roles;
	}

	public usuario() {
		
	}

}
