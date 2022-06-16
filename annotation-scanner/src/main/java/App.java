public class App {
    public static void main(String[] args) {
        MarkScanner markScanner = new MarkScanner();

        try {
            TestClass test = new TestClass();
            Class<?> cls = test.getClass();
            markScanner.scan(cls);

        } catch (StackOverflowError e) {
            System.out.println("Stack Overflow");
        }
    }
}

/* MarkScanner() OUTPUT:
Level-0-int: 47
Level-0-Foo: Foo@46f7f36a
\__ Level-1-Boo: Boo@25f38edc
    \__ Recursive-Boo-int: 2
    \__ Recursive-Boo-String: b2 string value
    \__ Recursive-Boo: null
    \__ Recursive-Moo: Moo@3eb07fd3
        \__ Recursive-Level-1-Moo-int: 0
        \__ Recursive-Level-1-Moo-String: null
\__ Level-1-String: f2 string value
\__ Level-1-int: 16
Level-0-int: 34
Level-0-String: t5 string value
 */

/* MarkScanner(2) OUTPUT:
Level-0-int: 47
Level-0-Foo: Foo@46f7f36a
\__ Level-1-Boo: Boo@25f38edc
    \__ Recursive-Boo-int: 2
    \__ Recursive-Boo-String: b2 string value
    \__ Recursive-Boo: null
    \__ Recursive-Moo: Moo@3eb07fd3
        \__ ...
\__ Level-1-String: f2 string value
\__ Level-1-int: 16
Level-0-int: 34
Level-0-String: t5 string value
 */

/* MarkScanner(1) OUTPUT:
Level-0-int: 47
Level-0-Foo: Foo@46f7f36a
\__ Level-1-Boo: Boo@25f38edc
    \__ ...
\__ Level-1-String: f2 string value
\__ Level-1-int: 16
Level-0-int: 34
Level-0-String: t5 string value
 */

/* MarkScanner(0) OUTPUT:
Level-0-int: 47
Level-0-Foo: Foo@46f7f36a
\__ ...
Level-0-int: 34
Level-0-String: t5 string value
 */