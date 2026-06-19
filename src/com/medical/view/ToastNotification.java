package com.medical.view;

// src/com/medical/view/ToastNotification.java


import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ToastNotification {

    public static void show(Stage owner, String message, String type) {
        Popup popup = new Popup();

        HBox container = new HBox(12);
        container.setAlignment(Pos.CENTER_LEFT);
        container.setPadding(new Insets(14, 24, 14, 24));

        String bgColor;
        String icon;
        String iconColor;

        switch(type) {
            case "success":
                bgColor = "#0f766e";
                icon = "✓";
                iconColor = "#ffffff";
                break;
            case "error":
                bgColor = "#dc2626";
                icon = "✕";
                iconColor = "#ffffff";
                break;
            case "warning":
                bgColor = "#d97706";
                icon = "⚠";
                iconColor = "#ffffff";
                break;
            default:
                bgColor = "#1e293b";
                icon = "ℹ";
                iconColor = "#ffffff";
        }

        container.setStyle(
                "-fx-background-color: " + bgColor + ";" +
                        "-fx-background-radius: 12px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.25), 20, 0, 0, 8);"
        );

        Label iconLabel = new Label(icon);
        iconLabel.setStyle("-fx-text-fill: " + iconColor + "; -fx-font-size: 18px; -fx-font-weight: bold;");

        Label textLabel = new Label(message);
        textLabel.setStyle("-fx-text-fill: white; -fx-font-size: 13px; -fx-font-weight: 500;");

        container.getChildren().addAll(iconLabel, textLabel);
        popup.getContent().add(container);

        // Position at bottom right
        double x = owner.getX() + owner.getWidth() - 420;
        double y = owner.getY() + owner.getHeight() - 80;
        popup.show(owner, x, y);

        // Auto hide after 3 seconds with fade out
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(2.5), container);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setOnFinished(e -> popup.hide());
        fadeOut.play();
    }
}
