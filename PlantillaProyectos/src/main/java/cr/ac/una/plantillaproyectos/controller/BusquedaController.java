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
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author USUARIO PZ UNA
 */
public class BusquedaController implements Initializable {

    @FXML
    private MFXTextField txfNombre;
    @FXML
    private MFXTextField txfCedula;
    @FXML
    private MFXButton btnFiltrar;
    @FXML
    private MFXButton btnAceptar;
    @FXML
    private TableView<?> tbvInfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void onAactionFiltrar(ActionEvent event) {
    }

    @FXML
    private void onAactionAceptar(ActionEvent event) {
    }
    
}
