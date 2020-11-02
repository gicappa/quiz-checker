package gk.quiz;

import static java.lang.System.exit;

public class QuizArgs {

    private final String[] args;

    public QuizArgs(String... args) {
        this.args = args;
    }

    public String getFileName() {
        if (args.length != 1)
            printUsageAndExit();

        return args[0];
    }

    private void printUsageAndExit() {
        System.out.println("ERROR: checker needs one and only one parameter\n");
        System.out.println("Usage: checker file");
        exit(1);
    }
}
