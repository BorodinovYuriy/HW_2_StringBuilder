package mystringbuildersnapshot;

import java.util.Arrays;
//Memento (Снимок)
public class StringBuilderMemento {
    private final char[] state;
    private final int length;

    public StringBuilderMemento(char[] state, int length) {
        this.state = Arrays.copyOf(state, state.length);
        this.length = length;
    }

    public char[] getState() {
        return state;
    }
    public int getLength(){
        return length;
    }
}


