import java.util.Arrays;

import hydraulic.*;

public class MainClass {

    private static HSystem system;

    public static void main(String[] args) throws Exception {
        
        test4();

        System.out.println(Arrays.toString(system.getElements()));
        System.out.println(system.layout());

    }

    public static void test4() throws Exception {

        system = new HSystem();

        Source src = new Source("src");
        
        Sink sink1 = new Sink("sink 1");
        Sink sink2 = new Sink("Sink 2");
        Sink sink3 = new Sink("Sink 3");
        Sink sink4 = new Sink("Sink 4");
        Sink sink5 = new Sink("Sink 5");
        Sink sink6 = new Sink("Sink 6");

        Tap tap1 = new Tap("tap1");
        Tap tap2 = new Tap("tap2");
        Tap tap3 = new Tap("tap3");
        Tap tap4 = new Tap("Tap4");

        Split split1 = new Split("split 1");
        Split split2 = new Split("Split 2");
        Split split3 = new Split("Split 3");
        Split split4 = new Split("Split 4");

        system.addElement(src);
        system.addElement(sink1);
        system.addElement(sink2);
        system.addElement(sink3);
        system.addElement(tap1);
        system.addElement(tap2);
        system.addElement(tap3);
        system.addElement(tap4);

        src.connect(split3);
        split3.connect(tap1, 0);
        split3.connect(sink4, 1);
        tap1.connect(split1);
        split1.connect(sink1, 0);
        split1.connect(tap2, 1);
        tap2.connect(split2);
        split2.connect(sink2, 0);
        split2.connect(split4, 1);
        split4.connect(sink5, 0);
        split4.connect(sink6, 1);
        tap4.connect(sink1);

        src.setFlow(50);
        tap1.setOpen(true);
        tap2.setOpen(true);
        tap4.setOpen(false);
        tap3.setOpen(true);

        system.simulate();
    }

    public static void test3() throws Exception {

        system = new HSystem();

        Source src = new Source("src");
        
        Sink sink1 = new Sink("sink 1");
        Sink sink2 = new Sink("Sink 2");

        Tap tap1 = new Tap("tap1");
        Tap tap2 = new Tap("tap2");

        Split split1 = new Split("split 1");

        system.addElement(src);
        system.addElement(sink1);
        system.addElement(sink2);
        system.addElement(tap1);
        system.addElement(tap2);

        src.connect(tap1);
        tap1.connect(split1);
        split1.connect(sink1, 0);
        split1.connect(tap2, 1);
        tap2.connect(sink2);

        src.setFlow(50);
        tap1.setOpen(true);
        tap2.setOpen(true);

        system.simulate();
    }

    public static void test2() throws Exception {

        system = new HSystem();

        Source src = new Source("src");
        Sink sink = new Sink("sink");
        Tap tap1 = new Tap("tap1");
        Tap tap2 = new Tap("tap2");

        system.addElement(src);
        system.addElement(sink);
        system.addElement(tap1);
        system.addElement(tap2);

        src.connect(tap1);
        tap1.connect(tap2);
        tap2.connect(sink);

        src.setFlow(50);
        tap1.setOpen(true);
        tap2.setOpen(true);

        system.simulate();
    }

    public static void test1() throws Exception {

        system = new HSystem();

        Source src = new Source("src");
        Sink sink = new Sink("sink");

        system.addElement(src);
        system.addElement(sink);

        src.connect(sink);

        src.setFlow(50);

        system.simulate();
    }
}