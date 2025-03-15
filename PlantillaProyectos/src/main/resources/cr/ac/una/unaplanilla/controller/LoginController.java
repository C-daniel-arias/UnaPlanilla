/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.unaplanilla.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author cdani
 */
public class LoginController implements Initializable {

    @FXML
    private StackPane root;
    @FXML
    private AnchorPane FondoLogin;
    @FXML
    private MFXTextField txtUsuario;
    @FXML
    private MFXPasswordField txtContraseña;
    @FXML
    private MFXButton btnRegresar;
    @FXML
    private MFXButton btnCrearUsuario;
    @FXML
    private MFXButton btnIngresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onActionRegresar(ActionEvent event) {
    }

    @FXML
    private void onActionCrearUsuario(ActionEvent event) {
    }

    @FXML
    private void onActionIngresar(ActionEvent event) {
    }
    
}
