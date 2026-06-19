package com.medical;

import com.medical.dao.Database;
import com.medical.view.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class MedicalTreatmentApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Database.initialiserBase();

        // Créer la vue normale
        MainView mainView = new MainView();
        Scene scene = mainView.buildScene(primaryStage);

        // 🔥 FORCER la taille compacte
        primaryStage.setWidth(1000);
        primaryStage.setHeight(680);
        primaryStage.setMinWidth(900);
        primaryStage.setMinHeight(600);

        // 🔥 FORCER le CSS compact (même si MainView utilise un autre)
        URL compactTheme = getClass().getResource("/com/medical/view/medical-theme-compact.css");
        if (compactTheme != null) {
            scene.getStylesheets().clear();
            scene.getStylesheets().add(compactTheme.toExternalForm());
        }

        primaryStage.setTitle("Suivi de Traitements Médicaux");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() {
        Database.fermer();
    }

    public static void main(String[] args) {
        launch(args);
    }
}