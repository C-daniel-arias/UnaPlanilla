package cr.ac.una.plantillaproyectos;

import cr.ac.una.plantillaproyectos.util.FlowController;
import io.github.palexdev.materialfx.css.themes.MFXThemeManager;
import io.github.palexdev.materialfx.css.themes.Themes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
       FlowController.getInstance().InitializeFlow(stage, null);
       FlowController.getInstance().goViewInWindow("loginView"); 
//     scene = new Scene(loadFXML("loginView"), 640, 480);
//     MFXThemeManager.setOn(scene, Themes.DEFAULT,Themes.LEGACY);
//     stage.setScene(scene);
//     stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/"+fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}