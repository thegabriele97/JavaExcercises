Contains the classes that implement a software system for the definition
and simulation of an hydraulic system.

The first step consists in creating the system:

            HSystem s = new HSystem();

Then (1) one can define the elements:

            Source src = new Source("Src");
            s.addElement(src);
            Tap r = new Tap("R");
            s.addElement(r);
            Sink sink = new Sink("Sink");
            s.addElement(sink);

After that (2) the elements can be connected to each other:

            src.connect(r);
            r.connect(sink);

At this stage (3) we define the parameter:

            src.setFlow(20);
            r.setOpen(true);

Eventually (4) the simulation can be started:

            s.simulate();
