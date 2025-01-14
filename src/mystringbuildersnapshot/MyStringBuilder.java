package mystringbuildersnapshot;

import java.util.Arrays;
//Originator (Создатель)
class MyStringBuilder {
    private char[] value;
    private int length;

    public MyStringBuilder() {
        value = new char[16]; //capacity
        length = 0;
    }

    public MyStringBuilder(String str) {
        if(str == null || str.isEmpty()){
            value = new char[16];
            length = 0;
        } else {
            value = new char[str.length() + 16];
            for (int i = 0; i < str.length(); i++) {
                value[i] = str.charAt(i);
            }
            length = str.length();
        }
    }

    public MyStringBuilder append(String str) {
        ensureCapacity(length + str.length());
        for (int i = 0; i < str.length(); i++) {
            value[length++] = str.charAt(i);
        }
        return this;
    }

    public MyStringBuilder append(char c) {
        ensureCapacity(length + 1);
        value[length++] = c;
        return this;
    }

    public MyStringBuilder insert(int offset, String str) {
        if (offset < 0 || offset > length) {
            throw new IndexOutOfBoundsException("Index: " + offset + ", Length: " + length);
        }
        ensureCapacity(length + str.length());
        System.arraycopy(value, offset, value, offset + str.length(), length - offset);
        for (int i = 0; i < str.length(); i++) {
            value[offset + i] = str.charAt(i);
        }
        length += str.length();
        return this;
    }

    public MyStringBuilder delete(int start, int end) {
        if (start < 0 || end > length || start > end) {
            throw new IndexOutOfBoundsException("Start: " + start + ", End: " + end + ", Length: " + length);
        }
        if(start != end) {
            int numMoved = length - end;
            if(numMoved > 0) {
                System.arraycopy(value, end, value, start, numMoved);
            }
            length -= (end - start);
        }
        return this;
    }

    private void ensureCapacity(int minCapacity) {

        if (minCapacity > value.length) {
            int newCapacity = Math.max(value.length * 2, minCapacity);
            value = Arrays.copyOf(value, newCapacity);
        }
    }

    // Создание снимка
    public StringBuilderMemento save() {
        return new StringBuilderMemento(value, length);
    }

    // Восстановление из снимка
    public void restore(StringBuilderMemento memento) {
        this.value = memento.getState();
        this.length = memento.getLength();
    }


    @Override
    public String toString() {
        return new String(value, 0, length);
    }

    public int length() {
        return length;
    }
}
