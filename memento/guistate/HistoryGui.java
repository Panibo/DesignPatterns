package guistate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HistoryGui {

    private Controller controller;
    private ListView<Integer> historyList;

    public HistoryGui(Controller controller) {
        this.controller = controller;
    }

    public void start(Stage stage) {
        stage.setTitle("History");

        historyList = new ListView<>();
        refreshHistoryList();

        historyList.setCellFactory(list -> new ListCell<>() {
            @Override
            protected void updateItem(Integer index, boolean empty) {
                super.updateItem(index, empty);

                if (empty || index == null) {
                    setText(null);
                } else {
                    String current = (index == controller.getCurrentIndex()) ? " ←" : "";
                    setText("State " + index + current);
                }
            }
        });

        historyList.setOnMouseClicked(event -> {
            Integer selected = historyList.getSelectionModel().getSelectedItem();
            if (selected != null) {
                controller.goToHistory(selected);
                refreshHistoryList();
            }
        });

        Button undoButton = new Button("Undo");
        undoButton.setOnAction(e -> {
            controller.undo();
            refreshHistoryList();
        });

        Button redoButton = new Button("Redo");
        redoButton.setOnAction(e -> {
            controller.redo();
            refreshHistoryList();
        });

        HBox buttonBar = new HBox(10, undoButton, redoButton);
        buttonBar.setPadding(new Insets(10));

        BorderPane root = new BorderPane();
        root.setCenter(historyList);
        root.setBottom(buttonBar);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 250, 300);
        stage.setScene(scene);
        stage.show();
    }

    public void refreshHistoryList() {
        if (historyList == null) {
            return;
        }

        ObservableList<Integer> items = FXCollections.observableArrayList();
        for (int i = 0; i < controller.getHistory().size(); i++) {
            items.add(i);
        }

        historyList.setItems(items);
        historyList.getSelectionModel().select(controller.getCurrentIndex());
        historyList.refresh();
    }
}
