package cr.ac.una.plantillaproyectos.controller;

import cr.ac.una.plantillaproyectos.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
