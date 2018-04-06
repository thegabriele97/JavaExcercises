
public class UnsolvablePuzzleException extends Exception {
    private static final String EXCEPTION_MSG = "Unable to resolve this puzzle.";    

    public UnsolvablePuzzleException(boolean doYouWantTheMessage) {
        super(EXCEPTION_MSG);
    }
}