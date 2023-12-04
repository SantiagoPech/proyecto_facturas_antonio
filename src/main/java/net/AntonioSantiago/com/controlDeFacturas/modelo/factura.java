package net.AntonioSantiago.com.controlDeFacturas.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "factura")
public class factura {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long folio;

    private String descripcion;

    private String observacion;

    private LocalDate fecha;

    private BigDecimal calcularTotal;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFolio() {
		return folio;
	}

	public void setFolio(Long folio) {
		this.folio = folio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getCalcularTotal() {
		return calcularTotal;
	}

	public void setCalcularTotal(BigDecimal calcularTotal) {
		this.calcularTotal = calcularTotal;
	}

	public usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", folio=" + folio + ", descripcion=" + descripcion + ", observacion="
				+ observacion + ", fecha=" + fecha + ", calcularTotal=" + calcularTotal + ", usuario=" + usuario + "]";
	}
	
}
