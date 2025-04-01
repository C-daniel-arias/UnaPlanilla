/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.plantillaproyectos.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.image.ImageView;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void initialize() {
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
