/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.plantillaproyectos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author USUARIO PZ UNA
 */
@Entity
@Table(name = "PLA_EMPLEADOS")
@NamedQueries({
    @NamedQuery(name = "Empleado_Consultas.findAll", query = "SELECT e FROM Empleado_Consultas e"),
    @NamedQuery(name = "Empleado_Consultas.findById", query = "SELECT e FROM Empleado_Consultas e WHERE e.id = :id"),
    @NamedQuery(name = "Empleado_Consultas.findByEmpNombre", query = "SELECT e FROM Empleado_Consultas e WHERE e.empNombre = :empNombre"),
    @NamedQuery(name = "Empleado_Consultas.findByEmpApellidos", query = "SELECT e FROM Empleado_Consultas e WHERE e.empApellidos = :empApellidos"),
    @NamedQuery(name = "Empleado_Consultas.findByEmpFechaing", query = "SELECT e FROM Empleado_Consultas e WHERE e.empFechaing = :empFechaing"),
    @NamedQuery(name = "Empleado_Consultas.findByEmpEstado", query = "SELECT e FROM Empleado_Consultas e WHERE e.empEstado = :empEstado"),
    @NamedQuery(name = "Empleado_Consultas.findByEmpVersion", query = "SELECT e FROM Empleado_Consultas e WHERE e.empVersion = :empVersion")})
public class Empleado_Consultas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "EMP_NOMBRE")
    private String empNombre;
    @Basic(optional = false)
    @Column(name = "EMP_APELLIDOS")
    private String empApellidos;
    @Basic(optional = false)
    @Column(name = "EMP_FECHAING")
    @Temporal(TemporalType.TIMESTAMP)
    private Date empFechaing;
    @Basic(optional = false)
    @Column(name = "EMP_ESTADO")
    private String empEstado;
    @Basic(optional = false)
    @Column(name = "EMP_VERSION")
    private BigInteger empVersion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salEmpid", fetch = FetchType.LAZY)
    private List<Salario> salarioList;

    public Empleado_Consultas() {
    }

    public Empleado_Consultas(BigDecimal id) {
        this.id = id;
    }

    public Empleado_Consultas(BigDecimal id, String empNombre, String empApellidos, Date empFechaing, String empEstado, BigInteger empVersion) {
        this.id = id;
        this.empNombre = empNombre;
        this.empApellidos = empApellidos;
        this.empFechaing = empFechaing;
        this.empEstado = empEstado;
        this.empVersion = empVersion;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getEmpNombre() {
        return empNombre;
    }

    public void setEmpNombre(String empNombre) {
        this.empNombre = empNombre;
    }

    public String getEmpApellidos() {
        return empApellidos;
    }

    public void setEmpApellidos(String empApellidos) {
        this.empApellidos = empApellidos;
    }

    public Date getEmpFechaing() {
        return empFechaing;
    }

    public void setEmpFechaing(Date empFechaing) {
        this.empFechaing = empFechaing;
    }

    public String getEmpEstado() {
        return empEstado;
    }

    public void setEmpEstado(String empEstado) {
        this.empEstado = empEstado;
    }

    public BigInteger getEmpVersion() {
        return empVersion;
    }

    public void setEmpVersion(BigInteger empVersion) {
        this.empVersion = empVersion;
    }

    public List<Salario> getSalarioList() {
        return salarioList;
    }

    public void setSalarioList(List<Salario> salarioList) {
        this.salarioList = salarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado_Consultas)) {
            return false;
        }
        Empleado_Consultas other = (Empleado_Consultas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.plantillaproyectos.model.Empleado[ id=" + id + " ]";
    }
    
}
