package mystringbuildersnapshot;

public class Main {
    public static void main(String[] args) {
        MyStringBuilder builder = new MyStringBuilder("Hello ");
        MyStringBuilderHistory history = new MyStringBuilderHistory();

        System.out.println("Initial: " + builder);  // Hello

        builder.append("world!");
        System.out.println("After append: " + builder); // Hello world!
        history.save(builder);

        builder.insert(6, "great ");
        System.out.println("After insert: " + builder);  // Hello great world!
        history.save(builder);

        builder.delete(6, 11);
        System.out.println("After delete: " + builder); // Hello world!

        builder.restore(history.undo());
        System.out.println("After undo: " + builder); // Hello great world!

        builder.restore(history.undo());
        System.out.println("After second undo: " + builder); // Hello world!


        builder.append('!');
        System.out.println("After append char: " + builder); // Hello world!!


        MyStringBuilder builder1 = new MyStringBuilder();
        System.out.println("Empty builder:" + builder1);


        builder1.append("test");
        System.out.println("After append string to empty builder:" + builder1); // test
    }
}