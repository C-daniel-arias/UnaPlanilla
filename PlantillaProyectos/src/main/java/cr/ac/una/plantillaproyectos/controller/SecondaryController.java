package cr.ac.una.plantillaproyectos.controller;

import cr.ac.una.plantillaproyectos.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}