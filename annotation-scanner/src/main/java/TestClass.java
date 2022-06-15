class Boo {
    @Marked(name = "Recursive-Boo-int")
    public int b1 = 2;

    @Marked(name = "Recursive-Boo-String")
    public String b2 = "It's Morbin' Time";

    @Marked(name = "Recursive-Boo")
    public Boo b3;

    public int b4 = 22;
}


class Foo {
    @Marked(name = "Level-1-Boo")
    public Boo f1;

    @Marked(name = "Level-1-String")
    public String f2 = "Saul Goodman 3D";

    @Marked(name = "Level-1-int")
    public int f3 = 16;

    public Boo f4;
}

public class TestClass {
    @Marked(name = "Level-0-int")
    private int t1 = 47;

    public Foo t2;

    @Marked(name = "Level-0-Foo")
    private Foo t3;

    @Marked(name = "Level-0-int")
    private int t4 = 34;

    @Marked(name = "Level-0-String")
    private String t5 = "Dr. Michael Morbius";
}
