public class App {
    public static void main(String[] args) {
        MarkScanner markScanner = new MarkScanner();

        TestClass test = new TestClass();
        Class<?> cls = test.getClass();

        markScanner.scan(cls);
    }
}

/* OUTPUT:
Level-0-int: 47
Level-0-Foo: Foo
\__ Level-1-Boo: Boo
	\__ Recursive-Boo-int: 2
	\__ Recursive-Boo-String: It's Morbin' Time
	\__ Recursive-Boo: Boo
		\__ Recursive-Boo-int: 2
		\__ Recursive-Boo-String: It's Morbin' Time
		\__ Recursive-Boo: Boo
			\__ Recursive-Boo-int: 2
			\__ Recursive-Boo-String: It's Morbin' Time
			\__ Recursive-Boo: Boo
				\__ ...
\__ Level-1-String: Saul Goodman 3D
\__ Level-1-int: 16
Level-0-int: 34
Level-0-String: Dr. Michael Morbius
 */