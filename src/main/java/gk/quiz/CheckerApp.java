package gk.quiz;

/**
 * This is the entry point of the application that takes the
 * quiz file name as an argument and display the result
 * in standard output
 */
public class CheckerApp implements Runnable {

    private final QuizFile quizFile;
    private final QuizResult quizResult;
    private final QuizChecker quizChecker;
    private final QuizArgs quizArgs;

    /**
     * @param args in the first argument it holds the filename
     */
    public static void main(String... args) {
        new CheckerApp(args).run();
    }

    public CheckerApp(String... args) {
        this.quizFile = new QuizFile();
        this.quizResult = new QuizResultDefault();
        this.quizChecker = new QuizChecker();
        this.quizArgs = new QuizArgs(args);
    }

    /**
     * Launches the application to:
     * - load data
     * - run the checker
     * - display the result
     */
    public void run() {
        try {

            quizResult.display(quizChecker.check(quizFile.loadData(quizArgs.getFileName())));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
