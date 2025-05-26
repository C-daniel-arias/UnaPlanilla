/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.plantillaproyectos.controller;

import cr.ac.una.plantillaproyectos.model.EmpleadoDto;
import cr.ac.una.plantillaproyectos.service.EmpleadoService;
import cr.ac.una.plantillaproyectos.util.BindingUtils;
import cr.ac.una.plantillaproyectos.util.Formato;
import cr.ac.una.plantillaproyectos.util.Mensaje;
import cr.ac.una.plantillaproyectos.util.Respuesta;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXRadioButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author cdani
 */
public class EmpleadosViewController extends Controller implements Initializable {
      
    @FXML
    private AnchorPane fondoPrin;
    @FXML
    private VBox fondoSec;
    @FXML
    private Label lbControlEmpleados;
    @FXML
    private MFXTextField txfId;
    @FXML
    private MFXTextField txfNombre;
    @FXML
    private MFXTextField txfPrimerApellido;
    @FXML
    private MFXTextField txfSegundoApellido;
    @FXML
    private MFXTextField txfCedula;
    @FXML
    private MFXRadioButton rbutMasculino;
    @FXML
    private ToggleGroup Genero;
    @FXML
    private MFXRadioButton rbutFemenino;
    @FXML
    private MFXCheckbox cboxAdministrador;
    @FXML
    private MFXCheckbox cboxActivo;
    @FXML
    private MFXDatePicker dpFechaIngreso;
    @FXML
    private MFXDatePicker dpFechaSalida;
    @FXML
    private MFXTextField txfCorreo;
    @FXML
    private MFXTextField txfUsuario;
    @FXML
    private MFXPasswordField pasfClave;
    @FXML
    private MFXButton btnNuevo;
    @FXML
    private MFXButton btnBuscar;
    @FXML
    private MFXButton btnEleminar;
    @FXML
    private MFXButton btnGuardar;
    
    private EmpleadoDto empleado;
    
    private ObjectProperty<EmpleadoDto> empleadoProperty = new SimpleObjectProperty<>();
    
    private List<Node> requeridos = new ArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rbutFemenino.setUserData("F");
        rbutMasculino.setUserData("M");
        txfId.delegateSetTextFormatter(Formato.getInstance().integerFormat());
        txfNombre.delegateSetTextFormatter(Formato.getInstance().letrasFormat(30));
        txfPrimerApellido.delegateSetTextFormatter(Formato.getInstance().letrasFormat(15));
        txfSegundoApellido.delegateSetTextFormatter(Formato.getInstance().letrasFormat(15));
        txfCedula.delegateSetTextFormatter(Formato.getInstance().cedulaFormat(40));
        txfCorreo.delegateSetTextFormatter(Formato.getInstance().maxLengthFormat(80));
        txfUsuario.delegateSetTextFormatter(Formato.getInstance().letrasFormat(15));
        pasfClave.delegateSetTextFormatter(Formato.getInstance().maxLengthFormat(8));
        empleado = new EmpleadoDto();
        bindEmpleado();
        cargarValoresDefecto();
        indicarRequeridos();
    }    
    @Override
    public void initialize() {
     
    }
    
    @FXML
    private void onKeyPressedTxtId(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER && !txfId.getText().isBlank()) {
            cargarEmpleado(Long.valueOf(txfId.getText()));
        }
    }

    @FXML
    private void onActionChkAdministrador(ActionEvent event) {
        validarAdministrador();
    }

    @FXML
    private void onActionNuevo(ActionEvent event) {
            if (new Mensaje().showConfirmation("Limpiar Empleado", getStage(), "¿Esta seguro de que desea limpiar el registro?")) {
            cargarValoresDefecto();
        }
    }

    @FXML
    private void onActionBuscar(ActionEvent event) {
           try {
            String invalidar = validarRequeridos();
            if (invalidar.isBlank()) {
                new Mensaje().showModal(Alert.AlertType.WARNING, "Buscar Empleado", getStage(), invalidar);

            } else {
                new Mensaje().showModal(Alert.AlertType.INFORMATION, "Buscar Empleado", getStage(), "El empleado se buscando correctamente");
            }
        } catch (Exception ex) {
            Logger.getLogger(EmpleadosViewController.class.getName()).log(Level.SEVERE, "Error buscando el empleado.", ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Buscar Empleado", getStage(), "Ocurrió un error buscando el empleado.");
        }

    }

    @FXML
    private void onActionEliminar(ActionEvent event) {
         try {
            if (this.empleado.getId() == null) {
                new Mensaje().showModal(Alert.AlertType.WARNING, "Eliminar Empleado", getStage(), "Por favor consultar el empleado a eliminar");
            } else {
                EmpleadoService empleadoService = new EmpleadoService();
                Respuesta respuesta = empleadoService.eliminarEmpleado(this.empleado.getId());
                if (respuesta.getEstado()) {
                    cargarValoresDefecto();
                    new Mensaje().showModal(Alert.AlertType.INFORMATION, "Eliminar Empleado", getStage(), "El empleado se elimino correctamente");
                } else {
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Eliminar Empleado", getStage(), respuesta.getMensaje());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(EmpleadosViewController.class.getName()).log(Level.SEVERE, "Error eliminando el empleado.", ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Eliminar Empleado", getStage(), "Ocurrió un error eliminando el empleado.");
        }

    }

    @FXML
    private void onActionGuardar(ActionEvent event) {
                try {
            String invalidar = validarRequeridos();
            if (!invalidar.isBlank()) {
                new Mensaje().showModal(Alert.AlertType.WARNING, "Guardar Empleado", getStage(), invalidar);
            } else {
                EmpleadoService empleadoService = new EmpleadoService();
                Respuesta respuesta = empleadoService.guardarEmpleado(this.empleado);
                if (respuesta.getEstado()) {
                    this.empleado = (EmpleadoDto) respuesta.getResultado("Empleado");
                    this.empleadoProperty.set(this.empleado);
                    validarAdministrador();
                    validarRequeridos();
                    new Mensaje().showModal(Alert.AlertType.INFORMATION, "Guardar Empleado", getStage(), "El empleado se guardo correctamente");
                } else {
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar Empleado", getStage(), respuesta.getMensaje());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(EmpleadosViewController.class.getName()).log(Level.SEVERE, "Error guardando el empleado.", ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar Empleado", getStage(), "Ocurrió un error guardando el empleado.");
        }

    }
    
    private void bindEmpleado() {
        try 
        {
            empleadoProperty.addListener((obs, oldVal, newVal) -> {
                if (oldVal != null) {
                    txfId.textProperty().unbind();
                    txfNombre.textProperty().unbindBidirectional(oldVal.getNombreProperty());
                    txfPrimerApellido.textProperty().unbindBidirectional(oldVal.getPrimerApellidoProperty());
                    txfSegundoApellido.textProperty().unbindBidirectional(oldVal.getSegundoApellidoProperty());
                    txfCedula.textProperty().unbindBidirectional(oldVal.getCedulaProperty());
                    txfCorreo.textProperty().unbindBidirectional(oldVal.getCorreoProperty());
                    txfUsuario.textProperty().unbindBidirectional(oldVal.getUsuarioProperty());
                    pasfClave.textProperty().unbindBidirectional(oldVal.getClaveProperty());
                    //dpFechaIngreso.textProperty().unbindBidirectional(oldVal.getFechaIngresoProperty());
                    dpFechaIngreso.valueProperty().unbindBidirectional(oldVal.getFechaIngresoProperty());
                    dpFechaSalida.valueProperty().unbindBidirectional(oldVal.getFechaSalidaProperty());
                    pasfClave.textProperty().unbindBidirectional(oldVal.getClaveProperty());
                    BindingUtils.unbindToggleGroupToProperty(Genero, oldVal.getGeneroProperty());
                    cboxAdministrador.selectedProperty().unbindBidirectional(oldVal.getAdministradorProperty());
                    cboxActivo.selectedProperty().unbindBidirectional(oldVal.getActivoProperty());
                }
                if (newVal != null) {
                    if ((newVal.getIdProperty().get() != null) && (!newVal.getIdProperty().get().isBlank())) {
                        txfId.textProperty().bindBidirectional(newVal.getIdProperty());
                    }
                    txfNombre.textProperty().bindBidirectional(newVal.getNombreProperty());
                    txfPrimerApellido.textProperty().bindBidirectional(newVal.getPrimerApellidoProperty());
                    txfSegundoApellido.textProperty().bindBidirectional(newVal.getSegundoApellidoProperty());
                    txfCedula.textProperty().bindBidirectional(newVal.getCedulaProperty());
                    txfCorreo.textProperty().bindBidirectional(newVal.getCorreoProperty());
                    txfUsuario.textProperty().bindBidirectional(newVal.getUsuarioProperty());
                    pasfClave.textProperty().bindBidirectional(newVal.getClaveProperty());
                    BindingUtils.bindToggleGroupToProperty(Genero, newVal.getGeneroProperty());
                    cboxAdministrador.selectedProperty().bindBidirectional(newVal.getAdministradorProperty());
                    cboxAdministrador.selectedProperty().bindBidirectional(newVal.getActivoProperty());
                    dpFechaIngreso.valueProperty().bindBidirectional(newVal.getFechaIngresoProperty());
                    dpFechaSalida.valueProperty().bindBidirectional(newVal.getFechaSalidaProperty());
                }
            });
        } catch (Exception ex) {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Error al realizar el bindeo", getStage(), "Ocurrio un error al realizar el bindeo");
            }
    }
    
    private void cargarValoresDefecto() {
        empleado = new EmpleadoDto();
        empleado.setActivo(Boolean.TRUE);
        empleado.setAdministrador(Boolean.FALSE);
        empleado.setFechaIngreso(LocalDate.now());
        empleado.setGenero("M");
        empleadoProperty.setValue(empleado);
        validarAdministrador();
        txfId.clear();
        txfId.requestFocus();
    }

    private void validarAdministrador() {
        if (cboxAdministrador.isSelected()) {
            //requeridos.addAll(Arrays.asList(txtUsuario, txpClave));
            txfUsuario.setDisable(false);
            pasfClave.setDisable(false);
        } else {
            //requeridos.removeAll(Arrays.asList(txtUsuario, txpClave));
            txfUsuario.clear();
            txfUsuario.setDisable(true);
            pasfClave.clear();
            pasfClave.setDisable(true);
        }
    }

    private void indicarRequeridos() {
        requeridos.clear();
        requeridos.addAll(Arrays.asList(txfCedula, txfNombre, txfPrimerApellido, dpFechaSalida));
    }

    public String validarRequeridos() {
        Boolean validos = true;
        String invalidos = "";
        for (Node node : requeridos) {
            if (node instanceof MFXTextField && (((MFXTextField) node).getText() == null || ((MFXTextField) node).getText().isBlank())) {
                if (validos) {
                    invalidos += ((MFXTextField) node).getFloatingText();
                } else {
                    invalidos += "," + ((MFXTextField) node).getFloatingText();
                }
                validos = false;
            } else if (node instanceof MFXPasswordField && (((MFXPasswordField) node).getText() == null || ((MFXPasswordField) node).getText().isBlank())) {
                if (validos) {
                    invalidos += ((MFXPasswordField) node).getFloatingText();
                } else {
                    invalidos += "," + ((MFXPasswordField) node).getFloatingText();
                }
                validos = false;
            } else if (node instanceof MFXDatePicker && ((MFXDatePicker) node).getValue() == null) {
                if (validos) {
                    invalidos += ((MFXDatePicker) node).getFloatingText();
                } else {
                    invalidos += "," + ((MFXDatePicker) node).getFloatingText();
                }
                validos = false;
            } else if (node instanceof MFXComboBox && ((MFXComboBox) node).getSelectionModel().getSelectedIndex() < 0) {
                if (validos) {
                    invalidos += ((MFXComboBox) node).getFloatingText();
                } else {
                    invalidos += "," + ((MFXComboBox) node).getFloatingText();
                }
                validos = false;
            }
        }
        if (validos) {
            return "";
        } else {
            return "Campos requeridos o con problemas de formato [" + invalidos + "].";
        }
    }

    private void cargarEmpleado(Long id) {
        try {
            EmpleadoService empleadoService = new EmpleadoService();
            Respuesta respuesta = empleadoService.getEmpleado(id);
            if (respuesta.getEstado()) {
                this.empleado = (EmpleadoDto) respuesta.getResultado("Empleado");
                this.empleadoProperty.set(this.empleado);
                validarAdministrador();
                validarRequeridos();
            } else {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Buscar Empleado", getStage(), respuesta.getMensaje());
            }
        } catch (Exception ex) {
            Logger.getLogger(EmpleadosViewController.class.getName()).log(Level.SEVERE, "Error guardando el empleado.", ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar Empleado", getStage(), "Ocurrió un error guardando el empleado.");
        }
    }

}
