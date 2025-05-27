/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.plantillaproyectos.service;

import cr.ac.una.plantillaproyectos.model.TipoPlanillaDto;
import cr.ac.una.plantillaproyectos.model.Tipoplanilla;
import cr.ac.una.plantillaproyectos.util.EntityManagerHelper;
import cr.ac.una.plantillaproyectos.util.Respuesta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.Query;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO PZ UNA
 */
public class PlanillaService {
    private EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;

    public Respuesta getTipoplanilla(Long id) {
        try {
            Query qryEmpleado = em.createNamedQuery("Tipoplanilla.findById", Tipoplanilla.class);
            qryEmpleado.setParameter("id", id);
            TipoPlanillaDto tipoPlanillaDto = new TipoPlanillaDto((Tipoplanilla) qryEmpleado.getSingleResult());
            return new Respuesta(true, "", "", "Tipoplanilla", tipoPlanillaDto);
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe un empleado con el id ingresado.", "getEmpleado NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(PlanillaService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el empleado.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar el empleado.", "getEmpleado NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, "Error obteniendo el empleado [" + id + "]", ex);
            return new Respuesta(false, "Error obteniendo el empleado.", "getEmpleado " + ex.getMessage());
        }
    }

    public Respuesta guardarTipoplanilla(TipoPlanillaDto tipoPlanillaDto) {
        try {
            et = em.getTransaction();
            et.begin();
            Tipoplanilla tipoplanilla;
            if (tipoPlanillaDto.getid() != null && tipoPlanillaDto.getid() > 0) {
                tipoplanilla = em.find(Tipoplanilla.class, tipoPlanillaDto.getid());
                if (tipoplanilla == null) {
                    return new Respuesta(false, "No se encontro el empleado a modificar.", "guardarEmpleado NoResultException");
                }
                tipoplanilla.actualizar(tipoPlanillaDto);
                tipoplanilla = em.merge(tipoplanilla);
            } else {
                tipoplanilla = new Tipoplanilla(tipoPlanillaDto);
                em.persist(tipoplanilla);
            }
            et.commit();
            return new Respuesta(true, "", "", "Empleado", new TipoPlanillaDto(tipoplanilla));
        } catch (Exception ex) {
            et.rollback();
            Logger.getLogger(PlanillaService.class.getName()).log(Level.SEVERE, "Error guardado el empleado.", ex);
            return new Respuesta(false, "Error guardado el empleado.", "guardarEmpleado" + ex.getMessage());
        }
    }

    public Respuesta eliminarTipoplanilla(Long tplaId) {
        try {
            et = em.getTransaction();
            et.begin();
            Tipoplanilla tipoplanilla;
            if (tplaId != null && tplaId > 0) {
                tipoplanilla = em.find(Tipoplanilla.class, tplaId);
                if (tipoplanilla == null) {
                    return new Respuesta(false, "No se encontro el empleado a eliminar.", "eliminarEmpleado NoResultException");
                }
                em.remove(tipoplanilla);
            } else {
                return new Respuesta(false, "Favor consultar el empleado a eliminar.", "");
            }
            et.commit();
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            et.rollback();
            Logger.getLogger(PlanillaService.class.getName()).log(Level.SEVERE, "Error eliminando el empleado.["+tplaId+"]", ex);
            return new Respuesta(false, "Error eliminando el empleado.", "eliminarEmpleado" + ex.getMessage());
        }
    }
    
}
