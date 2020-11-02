package gk.quiz;

public class QuizArgs {

    private final String[] args;

    public QuizArgs(String... args) {
        this.args = args;
    }

    public String getFileName() {
        if (args.length != 1) {
            throw new IllegalArgumentException(usage());
        }

        return args[0];
    }

    public String usage() {
        return "ERROR: checker needs one and only one parameter\n" +
                "Usage: checker file";
    }
}
