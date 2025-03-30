/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.plantillaproyectos.controller;

import cr.ac.una.plantillaproyectos.util.FlowController;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cdani
 */
public class LoginController extends Controller implements Initializable {

    @FXML
    private StackPane root;
    @FXML
    private ImageView imgFondo;
    @FXML
    private MFXTextField txfUsuario;
    @FXML
    private MFXPasswordField txfPassword;
    @FXML
    private MFXButton btnCancelar;
    @FXML
    private MFXButton btnIngresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       imgFondo.fitHeightProperty().bind(root.heightProperty());
        imgFondo.fitWidthProperty().bind(root.widthProperty());
    }    

    @FXML
    private void onActionCancelar(ActionEvent event) {
        ((Stage)btnCancelar.getScene().getWindow()).close();
    }

    @FXML
    private void onActionIngresar(ActionEvent event) {
       //AppConte
       FlowController.getInstance().goView("principalView");
    }

    @Override
    public void initialize() {
    }
    
}
