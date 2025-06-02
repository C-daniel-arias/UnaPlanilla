/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.plantillaproyectos.controller;

import cr.ac.una.plantillaproyectos.model.EmpleadoDto;
import cr.ac.una.plantillaproyectos.model.TipoPlanillaDto;
import cr.ac.una.plantillaproyectos.service.EmpleadoService;
import cr.ac.una.plantillaproyectos.service.PlanillaService;
import cr.ac.una.plantillaproyectos.util.BindingUtils;
import cr.ac.una.plantillaproyectos.util.Formato;
import cr.ac.una.plantillaproyectos.util.Mensaje;
import cr.ac.una.plantillaproyectos.util.Respuesta;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
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
import javafx.scene.control.TableColumn;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author cdani
 */
public class TiposPlanillaViewController extends Controller implements Initializable {

    @FXML
    private AnchorPane fondoPrin;
    @FXML
    private VBox fondoSec;
    @FXML
    private MFXTextField btnId;
    @FXML
    private MFXTextField btnCodigo;
    @FXML
    private MFXTextField btnDescripcion;
    @FXML
    private MFXTextField btnPlantillaXMes;
    @FXML
    private MFXTextField btnIdEmpleado;
    @FXML
    private MFXTextField btnNombre;
    @FXML
    private ImageView imgMas;
    @FXML
    private TableColumn<?, ?> tbcmId;
    @FXML
    private TableColumn<?, ?> tbcmNombre;
    @FXML
    private TableColumn<?, ?> tbcmEliminar;
    @FXML
    private MFXButton btnNuevo;
    @FXML
    private MFXButton btnBuscar;
    @FXML
    private MFXButton btnEleminar;
    @FXML
    private MFXButton btnGuardar;

    private TipoPlanillaDto tipoplanilla;

    private ObjectProperty<TipoPlanillaDto> tipoplanillaProperty = new SimpleObjectProperty<>();

    private List<Node> requeridos = new ArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnId.delegateSetTextFormatter(Formato.getInstance().integerFormat());
        btnCodigo.delegateSetTextFormatter(Formato.getInstance().letrasFormat(4));
        btnDescripcion.delegateSetTextFormatter(Formato.getInstance().letrasFormat(40));
        btnPlantillaXMes.delegateSetTextFormatter(Formato.getInstance().integerFormat());
        bindPlanilla();
        cargarValoresDefecto();
    }

    @Override
    public void initialize() {
    }

    @FXML
    private void onKeyPressedTxtId(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER && !btnId.getText().isBlank()) {
            cargarEmpleado(Long.valueOf(btnId.getText()));
        }
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
            if (this.tipoplanilla.getid() == null) {
                new Mensaje().showModal(Alert.AlertType.WARNING, "Eliminar Empleado", getStage(), "Por favor consultar el empleado a eliminar");
            } else {
                EmpleadoService empleadoService = new EmpleadoService();
                Respuesta respuesta = empleadoService.eliminarEmpleado(this.tipoplanilla.getid());
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
                PlanillaService planillaService = new PlanillaService();
                Respuesta respuesta = planillaService.guardarTipoplanilla(tipoplanilla);
                if (respuesta.getEstado()) {
                    this.tipoplanilla = (TipoPlanillaDto) respuesta.getResultado("Empleado");
                    this.tipoplanillaProperty.set(this.tipoplanilla);
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

    private void bindPlanilla() {
        try {
            tipoplanillaProperty.addListener((obs, oldVal, newVal) -> {
                if (oldVal != null) {
                    btnId.textProperty().unbind();
                    btnCodigo.textProperty().unbindBidirectional(oldVal.getCodigoProperty());
                    btnDescripcion.textProperty().unbindBidirectional(oldVal.getDescripcionProperty());
                    btnPlantillaXMes.textProperty().unbindBidirectional(oldVal.getPlaxmesProperty());
                }
                if (newVal != null) {
                    if (newVal.getIdProperty().get() != null && !newVal.getIdProperty().get().isBlank()) {
                        btnId.textProperty().bindBidirectional(newVal.getIdProperty());
                    }
                    btnCodigo.textProperty().bindBidirectional(newVal.getCodigoProperty());
                    btnDescripcion.textProperty().bindBidirectional(newVal.getDescripcionProperty());
                    btnPlantillaXMes.textProperty().bindBidirectional(newVal.getPlaxmesProperty());
                }
            });

        } catch (Exception ex) {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Error al realizar el biendeo", getStage(), "Ocurrio un error al realizar el bindeo");
        }
    }

    private void cargarValoresDefecto() {
        tipoplanilla = new TipoPlanillaDto();
        tipoplanilla.setActivo(Boolean.TRUE);
        tipoplanillaProperty.setValue(tipoplanilla);
        btnId.clear();
        btnId.requestFocus();
    }

    private void cargarEmpleado(Long id) {
        try {
            PlanillaService planillaService = new PlanillaService();
            Respuesta respuesta = planillaService.getTipoplanilla(id);
            if (respuesta.getEstado()) {
                this.tipoplanilla = (TipoPlanillaDto) respuesta.getResultado("Tipoplanilla");
                this.tipoplanillaProperty.set(this.tipoplanilla);
            } else {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Buscar Empleado", getStage(), respuesta.getMensaje());
            }
        } catch (Exception ex) {
            Logger.getLogger(EmpleadosViewController.class.getName()).log(Level.SEVERE, "Error guardando el empleado.", ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar Empleado", getStage(), "Ocurrió un error guardando el empleado.");
        }
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
            }
        }
        if (validos) {
            return "";
        } else {
            return "Campos requeridos o con problemas de formato [" + invalidos + "].";
        }
    }

}
