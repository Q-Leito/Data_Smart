import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.Constants;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        showScene(primaryStage, Constants.LOGIN_FXML_PATH, Constants.LOGIN_SCENE_HEADER);
    }

    private void showScene(Stage primaryStage, String fxmlPath, String header) {
        URL navigationUrl = getClass().getResource(fxmlPath);

        Parent root = null;

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(navigationUrl);

        try {
            loader.load();
            root = loader.getRoot();
        } catch (IOException e) {
            System.out.printf("\n--- %s ---\n", e.getMessage());
            e.printStackTrace();
        }

        if (root != null) {
            Scene rootScene = new Scene(root, Constants.APP_WIDTH, Constants.APP_HEIGHT);
            String title = String.format("%s - %s", header, Constants.APP_NAME);

            primaryStage.setTitle(title);
            primaryStage.setScene(rootScene);
            primaryStage.setResizable(false);

            primaryStage.show();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
