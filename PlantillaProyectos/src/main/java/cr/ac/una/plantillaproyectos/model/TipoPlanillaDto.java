/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.plantillaproyectos.model;

import java.util.List;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TipoPlanillaDto {

    private StringProperty tplaId;
    private StringProperty tplaCodigo;
    private StringProperty tplaDescripcion;
    private StringProperty tplaPlaxmes;
    private LongProperty tplaAnoultpla;
    private LongProperty tplaMesultpla;
    private LongProperty tplaNumultpla;
    private Long tplaVersion;
    private BooleanProperty tplaEstado;
    private List<EmpleadoDto> empleados;

    public TipoPlanillaDto() {
        this.tplaId = new SimpleStringProperty("");
        this.tplaCodigo = new SimpleStringProperty("");
        this.tplaDescripcion = new SimpleStringProperty("");
        this.tplaPlaxmes = new SimpleStringProperty("");
        this.tplaEstado = new SimpleBooleanProperty(true);
    }

    public TipoPlanillaDto(Tipoplanilla planilla) {
        this();
        this.tplaId.set(planilla.getId().toString());
        this.tplaCodigo.set(planilla.getCodigo());
        this.tplaDescripcion.set(planilla.getDescripcion());
        this.tplaPlaxmes.set(planilla.getPlaxmes().toString());
        this.tplaEstado.set(planilla.getEstado().equals("A"));
    }

    public Long getid() {
        if (this.tplaId.get() != null && !this.tplaId.get().isBlank()) {
            return Long.valueOf(this.tplaId.get());
        } else {
            return null;
        }
    }

    public void setid(Long tplaId) {
        this.tplaId.set(tplaId.toString());
    }

    public Long getPlaxmes() {
        if (this.tplaPlaxmes.get() != null && !this.tplaPlaxmes.get().isBlank()) {
            return Long.valueOf(this.tplaPlaxmes.get());
        } else {
            return null;
        }
    }

    public void setPlaxmes(Long tplaPlaxmes) {
        this.tplaPlaxmes.set(tplaPlaxmes.toString());
    }

    public String getCodigo() {
        return tplaCodigo.get();
    }

    public void setCodigo(String codigo) {
        this.tplaCodigo.set(codigo);
    }

    public String getDescripcion() {
        return tplaDescripcion.get();
    }

    public void setDescripcion(String descripcion) {
        this.tplaDescripcion.set(descripcion);
    }

    public Long getVersion() {
        return tplaVersion;
    }

    public void setVersion(Long version) {
        this.tplaVersion = version;
    }

    public Boolean getActivo() {
        return tplaEstado.get();
    }

    public void setActivo(Boolean activo) {
        this.tplaEstado.set(activo);
    }

    public List<EmpleadoDto> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<EmpleadoDto> empleados) {
        this.empleados = empleados;
    }

    public StringProperty getIdProperty() {
        return tplaId;
    }

    public void setIdProperty(StringProperty id) {
        this.tplaId = id;
    }

    public StringProperty getCodigoProperty() {
        return tplaCodigo;
    }

    public void setCodigoProperty(StringProperty codigo) {
        this.tplaCodigo = codigo;
    }

    public StringProperty getDescripcionProperty() {
        return tplaDescripcion;
    }

    public void setDescripcionProperty(StringProperty descripcion) {
        this.tplaDescripcion = descripcion;
    }

    public StringProperty getPlaxmesProperty() {
        return tplaPlaxmes;
    }

    public void setPlaxmesProperty(StringProperty plaxmes) {
        this.tplaPlaxmes = plaxmes;
    }

    public Long getVersionProperty() {
        return tplaVersion;
    }

    public void setVersionProperty(Long version) {
        this.tplaVersion = version;
    }

    public BooleanProperty getActivoProperty() {
        return tplaEstado;
    }

    public void setActivoProperty(BooleanProperty activo) {
        this.tplaEstado = activo;
    }

}
