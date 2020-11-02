package gk.quiz;

/**
 * This is the entry point of the application that takes the
 * quiz file name as an argument and display the result
 * in standard output
 */
public class CheckerApp implements Runnable {

    private final String fileName;
    private final QuizFile fileQuiz;
    private final QuizResult quizResult;
    private final QuizChecker quizChecker;

    /**
     * @param args in the first argument it holds the filename
     */
    public static void main(String[] args) {
        new CheckerApp(args[0]).run();
    }

    public CheckerApp(String fileName) {
        this.fileName = fileName;
        this.fileQuiz = new QuizFile();
        this.quizResult = new QuizResultDefault();
        this.quizChecker = new QuizChecker();
    }

    /**
     * Launches the application to:
     * - load data
     * - run the checker
     * - display the result
     */
    public void run() {
        try {

            quizResult.display(quizChecker.check(fileQuiz.loadData(fileName)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
