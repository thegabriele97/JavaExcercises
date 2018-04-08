
public enum BobAnswers {
    QUESTION("Sure."),
    YELL("Whoa, chill out!"),
    YELL_A_QUESTION("Calm down, I know what I'm doing!"),
    ADDRESS_HIM("Fine. Be that way!"),
    IDK("Whatever.");

    private String answer;

    private BobAnswers(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}