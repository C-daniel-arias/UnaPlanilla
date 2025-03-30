/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.plantillaproyectos.controller;

import cr.ac.una.plantillaproyectos.model.EmpleadoDto;
import cr.ac.una.plantillaproyectos.util.Mensaje;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXRadioButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      bindEmpleado();
    }    
    @Override
    public void initialize() {
     
    }
    
    private void bindEmpleados(){
        try {
            empleadoProperty.addListener((obs,oldVal,newVal)->{
                if(oldVal != null){
                    txfNombre.textProperty().unbindBidirectional((oldVal.getNombreProperty()));
                }
                if(newVal != null){
                    txfNombre.textProperty().bindBidirectional(newVal.getNombreProperty());
                }
            });
        }catch(Exception ex){
            new Mensaje().showModal(Alert.AlertType.ERROR,"Error al realizar el bindeo",getStage(),"Ocurrio un error al realizar el bindeo.");
        }
    }
    @FXML
    private void onActionNuevo(ActionEvent event) {
    }

    @FXML
    private void onActionBuscar(ActionEvent event) {
    }

    @FXML
    private void onActionEliminar(ActionEvent event) {
    }

    @FXML
    private void onActionGuardar(ActionEvent event) {
    }

    private void bindEmpleado() {
    }


}
