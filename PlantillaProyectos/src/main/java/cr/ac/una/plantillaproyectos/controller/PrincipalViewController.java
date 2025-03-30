/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.plantillaproyectos.controller;

import cr.ac.una.plantillaproyectos.util.FlowController;
import io.github.palexdev.materialfx.controls.MFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author cdani
 */
public class PrincipalViewController extends Controller implements Initializable {

    @FXML
    private MFXButton btnEmpleados;
    @FXML
    private MFXButton btnTiposPlanilla;
    @FXML
    private MFXButton btnCerrarSesion;
    @FXML
    private MFXButton btnSalir;
    @FXML
    private BorderPane root;

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
    private void onActionEmpleados(ActionEvent event) {
      FlowController.getInstance().goView("empleadosView");
    }

    @FXML
    private void onActionTiposPlanilla(ActionEvent event) {
     FlowController.getInstance().goView("tiposPlanillaView");
    }

    @FXML
    private void onActionCerrarSesion(ActionEvent event) {
    }

    @FXML
    private void onActionSalir(ActionEvent event) {
        FlowController.getInstance().salir();
    }


    
}
