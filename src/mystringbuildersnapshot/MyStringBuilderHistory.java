package mystringbuildersnapshot;

import java.util.ArrayList;
import java.util.List;

//Caretaker (Хранитель)
class MyStringBuilderHistory {
    private final List<StringBuilderMemento> history = new ArrayList<>();

    public void save(MyStringBuilder editor) {
        history.add(editor.save());
    }

    public StringBuilderMemento undo() {
        if (!history.isEmpty()) {
            return history.removeLast();
        }
        return null;
    }
}



