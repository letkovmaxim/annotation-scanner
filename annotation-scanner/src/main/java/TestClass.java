class Moo {
    @Marked(name = "Recursive-Level-1-Moo-int")
    private int m1; // = 0

    @Marked(name = "Recursive-Level-1-Moo-String")
    protected String m2;
}

class Boo {
    @Marked(name = "Recursive-Boo-int")
    public int b1 = 2;

    @Marked(name = "Recursive-Boo-String")
    public String b2 = "b2 string value";

    @Marked(name = "Recursive-Boo")
    public Boo b3;

    public int b4 = 22;

    @Marked(name = "Recursive-Moo")
    public Moo b5 = new Moo();
}


class Foo {
    @Marked(name = "Level-1-Boo")
    public Boo f1 = new Boo();

    @Marked(name = "Level-1-String")
    public String f2 = "f2 string value";

    @Marked(name = "Level-1-int")
    public int f3 = 16;

    public Boo f4;
}


public class TestClass {
    @Marked(name = "Level-0-int")
    private int t1 = 47;

    public Foo t2;

    @Marked(name = "Level-0-Foo")
    private Foo t3 = new Foo();

    @Marked(name = "Level-0-int")
    private int t4 = 34;

    @Marked(name = "Level-0-String")
    private String t5 = "t5 string value";
}
