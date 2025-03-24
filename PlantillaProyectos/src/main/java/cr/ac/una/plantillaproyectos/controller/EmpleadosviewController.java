/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.plantillaproyectos.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXRadioButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author cdani
 */
public class EmpleadosviewController implements Initializable {

    @FXML
    private ToggleGroup Genero;
    @FXML
    private AnchorPane fondoPrin;
    @FXML
    private AnchorPane fondoSec;
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
    private MFXRadioButton rbutFemenino;
    @FXML
    private MFXCheckbox cboxAdministrador;
    @FXML
    private MFXCheckbox cboxActivo;
    @FXML
    private MFXDatePicker dpFechaIngreso;
    @FXML
    private MFXTextField txfCorreo;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
}
