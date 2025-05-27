/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.plantillaproyectos.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author cdani
 */
@Entity
@Table(name = "PLAM_TIPOPLANILLAS")
@NamedQueries({
    @NamedQuery(name = "Tipoplanilla.findAll", query = "SELECT t FROM Tipoplanilla t"),
    @NamedQuery(name = "Tipoplanilla.findById", query = "SELECT t FROM Tipoplanilla t WHERE t.id = :id"),/*
    @NamedQuery(name = "Tipoplanilla.findByTplaCodigo", query = "SELECT t FROM Tipoplanilla t WHERE t.tplaCodigo = :tplaCodigo"),
    @NamedQuery(name = "Tipoplanilla.findByTplaDescripcion", query = "SELECT t FROM Tipoplanilla t WHERE t.tplaDescripcion = :tplaDescripcion"),
    @NamedQuery(name = "Tipoplanilla.findByTplaPlaxmes", query = "SELECT t FROM Tipoplanilla t WHERE t.tplaPlaxmes = :tplaPlaxmes"),
    @NamedQuery(name = "Tipoplanilla.findByTplaAnoultpla", query = "SELECT t FROM Tipoplanilla t WHERE t.tplaAnoultpla = :tplaAnoultpla"),
    @NamedQuery(name = "Tipoplanilla.findByTplaMesultpla", query = "SELECT t FROM Tipoplanilla t WHERE t.tplaMesultpla = :tplaMesultpla"),
    @NamedQuery(name = "Tipoplanilla.findByTplaNumultpla", query = "SELECT t FROM Tipoplanilla t WHERE t.tplaNumultpla = :tplaNumultpla"),
    @NamedQuery(name = "Tipoplanilla.findByTplaEstado", query = "SELECT t FROM Tipoplanilla t WHERE t.tplaEstado = :tplaEstado"),
    @NamedQuery(name = "Tipoplanilla.findByTplaVersion", query = "SELECT t FROM Tipoplanilla t WHERE t.tplaVersion = :tplaVersion")*/})

public class Tipoplanilla implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "TPLA_ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "TPLA_CODIGO")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "TPLA_DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "TPLA_PLAXMES")
    private Long plaxmes;
    @Column(name = "TPLA_ANOULTPLA")
    private Long anoultpla;
    @Column(name = "TPLA_MESULTPLA")
    private Long mesultpla;
    @Column(name = "TPLA_NUMULTPLA")
    private Long numultpla;
    @Basic(optional = false)
    @Column(name = "TPLA_ESTADO")
    private String estado;
    @Basic(optional = false)
    @Column(name = "TPLA_VERSION")
    private Long version;
    @JoinTable(name = "PLAM_EMPLEADOSPLANILLA", joinColumns = {
        @JoinColumn(name = "EXP_IDTPLA", referencedColumnName = "TPLA_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "EXP_IDEMP", referencedColumnName = "EMP_ID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Empleado> empleados;

    public Tipoplanilla() {
    }

    public Tipoplanilla(Long tplaId) {
        this.id = tplaId;
    }
    public Tipoplanilla(TipoPlanillaDto tipoPlanillaDto) {
        this.id = tipoPlanillaDto.getid();
        actualizar(tipoPlanillaDto);
    }
   public void actualizar(TipoPlanillaDto tipoPlanillaDto) {
        this.id = tipoPlanillaDto.getid();
        this.codigo = tipoPlanillaDto.getCodigo();
        this.descripcion = tipoPlanillaDto.getDescripcion();
        this.plaxmes = tipoPlanillaDto.getPlaxmes();

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getPlaxmes() {
        return plaxmes;
    }

    public void setPlaxmes(Long plaxmes) {
        this.plaxmes = plaxmes;
    }

    public Long getAnoultpla() {
        return anoultpla;
    }

    public void setAnoultpla(Long anoultpla) {
        this.anoultpla = anoultpla;
    }

    public Long getMesultpla() {
        return mesultpla;
    }

    public void setMesultpla(Long mesultpla) {
        this.mesultpla = mesultpla;
    }

    public Long getNumultpla() {
        return numultpla;
    }

    public void setNumultpla(Long numultpla) {
        this.numultpla = numultpla;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
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
        if (!(object instanceof Tipoplanilla)) {
            return false;
        }
        Tipoplanilla other = (Tipoplanilla) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.plantillaproyectos.model.Tipoplanilla[ tplaId=" + id + " ]";
    }
    
}
