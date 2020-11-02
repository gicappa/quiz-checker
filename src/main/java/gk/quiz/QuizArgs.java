package gk.quiz;

public class QuizArgs {

    private final String[] args;

    public QuizArgs(String... args) {
        this.args = args;
    }

    public String getFileName() {
        if (args.length != 1)
            throw new CheckerException();

        return args[0];
    }
}
