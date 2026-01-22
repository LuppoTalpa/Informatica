package talpa.gestione_cartellino;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("cartellino.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 240);
        stage.setTitle("Timbro cartellino");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
