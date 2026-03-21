package guistate;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private Model model;
    private Gui gui;
    private List<IMemento> history;
    private int currentIndex;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();

        history.add(model.createMemento());
        currentIndex = 0;
    }

    public void setOption(int optionNumber, int choice) {
        model.setOption(optionNumber, choice);
        saveToHistory();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        model.setIsSelected(isSelected);
        saveToHistory();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public List<IMemento> getHistory() {
        return history;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void undo() {
        if (currentIndex > 0) {
            currentIndex--;
            model.restoreState(history.get(currentIndex));
            gui.updateGui();
        }
    }

    public void redo() {
        if (currentIndex < history.size() - 1) {
            currentIndex++;
            model.restoreState(history.get(currentIndex));
            gui.updateGui();
        }
    }

    public void goToHistory(int index) {
        if (index >= 0 && index < history.size()) {
            currentIndex = index;
            model.restoreState(history.get(currentIndex));
            gui.updateGui();
        }
    }

    private void saveToHistory() {
        while (history.size() > currentIndex + 1) {
            history.remove(history.size() - 1);
        }

        history.add(model.createMemento());
        currentIndex++;
        gui.updateGui();
    }
}
