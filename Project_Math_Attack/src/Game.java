import java.util.Random;
/**
 * This class represents Math Attack.
 *
 * @author Keith Tramm
 */
public class Game {
    /**
     * 1D array containing the problem data.
     * [0] = term 1
     * [1] = term 2
     * [2] = answer
     * [3] = sign
     */
    private int[] myOperationData;
    /**
     * The first term in the problem.
     */
    private int myFirstTerm;
    /**
     * The second term in the problem.
     */
    private int mySecondTerm;
    /**
     * The operator in the problem.
     */
    private String mySign;

    /**
     * The name of the player.
     */
    private String myName;

    /**
     * The score of the player.
     */
    private int myScore;

    /**
     * The current streak of the player.
     */
    private int myStreak;

    /**
     * The number of lives of the player.
     */
    private int myLives;

    /**
     * The difficulty of the game.
     */
    private EDifficulty myDifficulty;

    /**
     * A flag indicating whether the game is running or not.
     */
    private boolean isRunning = true;
    /**
     * A flag indicating whether the question is submitted.
     */
    private boolean isQuestionSubmitted = false;
    /**
     * Random number generator
     */
    final private Random myRandom;
    /**
     * Answer to the question displayed.
     */
    private String myAnswer;
    private GameWindow myWindow;
    /**
     * Constructs a game with the given name and difficulty.
     *
     * @param theName     the name of the player
     * @param theDifficulty  the difficulty of the game
     */
    public Game(String theName, EDifficulty theDifficulty) {
        myName = theName;
        myScore = 0;
        myStreak = 0;
        myLives = 3;
        myDifficulty = theDifficulty;
        myRandom = new Random();
        myOperationData = MathGenerator.randomAddition(20, 1, myRandom);
        mySign = "+";
        myFirstTerm = myOperationData[0];
        mySecondTerm = myOperationData[1];
        myAnswer = Integer.toString(myOperationData[2]);

    }
    public void resetGameValues() {
        myScore = 0;
        myStreak = 0;
        myLives = 3;
        myOperationData = MathGenerator.randomAddition(20, 1, myRandom);
        mySign = "+";
        myFirstTerm = myOperationData[0];
        mySecondTerm = myOperationData[1];
        myAnswer = Integer.toString(myOperationData[2]);
        isRunning = true;
        isQuestionSubmitted = false;
    }
    public void run() {
        update();
        while (isRunning) {
            System.out.println("Tried");
            if (isQuestionSubmitted) {
                int[] lastOperationData = myOperationData;
                selectOperationData(myOperationData);
                selectOperationSign();
                update();
                isQuestionSubmitted = false;
            }
        }
    }

    public void update() {
        if (myLives > 0) {
            updateGameValues();
        } else {
            gameOverScreen();
        }
    }

    public void gameOverScreen() {
        myWindow.getQuestionLabel().setText("Game Over");
        myWindow.getScoreLabel().setVisible(false);
        myWindow.getStreakLabel().setVisible(false);
        myWindow.getLivesLabel().setVisible(false);
        myWindow.getAnswerField().setVisible(false);
        myWindow.getSubmitButton().setVisible(false);
        myWindow.getExitButton().setVisible(true);
        myWindow.getPlayAgainButton().setVisible(true);
    }
    public void resetScreen() {
        myWindow.getScoreLabel().setVisible(true);
        myWindow.getStreakLabel().setVisible(true);
        myWindow.getLivesLabel().setVisible(true);
        myWindow.getAnswerField().setVisible(true);
        myWindow.getSubmitButton().setVisible(true);
        myWindow.getExitButton().setVisible(false);
        myWindow.getPlayAgainButton().setVisible(false);
    }
    public void newGame() {
        resetScreen();
        resetGameValues();
        update();

    }

    public void selectOperationData(int[] theLastOperationData) {
        while (myOperationData == theLastOperationData) {
            switch (getRandomInteger(4, 1)) {
                case 0:
                    myOperationData = MathGenerator.randomAddition(20,
                            1, myRandom);

                    break;

                case 1:
                    myOperationData = MathGenerator.randomDifference(20,
                            1, myRandom);
                    break;

                case 2:
                    myOperationData = MathGenerator.randomMultiplication(20,
                            1, myRandom);
                    break;

                case 3:
                    myOperationData = MathGenerator.randomDivision(20,
                            1, myRandom);
                    break;
            }
        }
    }

    public void selectOperationSign() {
        if (myOperationData != null) {
            myFirstTerm = myOperationData[0];
            mySecondTerm = myOperationData[1];
            myAnswer = Integer.toString(myOperationData[2]);
            switch (myOperationData[3]) {
                case 1:
                    mySign = ("+");
                    break;
                case 2:
                    mySign = ("-");
                    break;
                case 3:
                    mySign = ("*");
                    break;
                case 4:
                    mySign = ("/");
                    break;
            }
        }
    }
    public void updateGameValues() {
        myWindow.getQuestionLabel().setText( myFirstTerm +
                " " + mySign + " " + mySecondTerm + " = ?");
        myWindow.getScoreLabel().setText("Score: " + myScore);
        myWindow.getStreakLabel().setText("Streak: " + myStreak);
        myWindow.getLivesLabel().setText("Lives: " + myLives);
        myWindow.getAnswerField().setText("");
    }
    /**
    * Returns the name of the player.
     *
    * @return the name of the player
     */
    public String getName() {
    return myName;
}

    /**
    * Returns the score of the player.
    *
    * @return the score of the player
    */
    public int getScore() {
    return myScore;
}

    /**
    * Returns the current streak of the player.
    *
    * @return the current streak of the player
    */
    public int getStreak() {
    return myStreak;
}

    /**
    * Returns the number of lives of the player.
    *
    * @return the number of lives of the player
    */
    public int getLives() {
    return myLives;
}

    /**
    * Returns the difficulty of the game.
    *
    * @return the difficulty of the game
    */
    public EDifficulty getDifficulty() {
    return myDifficulty;
}

    /**
    * Returns a flag indicating whether the game is over or not.
    *
    * @return true if the game is over, false otherwise
    */
    public boolean getIsRunning() {
    return isRunning;
}
    /**
    * Sets the name of the player.
    *
    * @param theName the name of the player
    */
    public void setName(String theName) {
    myName = theName;
}

    /**
    * Sets the score of the player.
    *
    * @param theScore the score of the player
    */
    public void setScore(int theScore) {
    myScore = theScore;
}

    /**
    * Sets the current streak of the player.
    *
    * @param theStreak the current streak of the player
    */
    public void setStreak(int theStreak) {
    myStreak = theStreak;
}

    /**
    * Sets the number of lives of the player.
    *
    * @param theLives the number of lives of the player
    */
    public void setLives(int theLives) {
        myLives = theLives;
}

    /**
    * Sets the difficulty of the game.
    *
    * @param theDifficulty the difficulty of the game
    */
    public void setDifficulty(EDifficulty theDifficulty) {
        myDifficulty = theDifficulty;
    }

    /**
    * Toggles a flag indicating whether the game is over or not.
    *
    */
    public void decrementLives() {
        myLives--;
    }
    public int getRandomInteger(int theUpperBound, int theLowerBound) {
        return myRandom.nextInt(theUpperBound) + theLowerBound;
    }
    public void increaseScore(int theScoreAmount) {
        myScore += theScoreAmount;
    }
    public void incrementStreak() {
        myStreak++;
    }
    public void setIsQuestionSubmitted(boolean isQuestionSubmitted) {
        this.isQuestionSubmitted = isQuestionSubmitted;
    }
    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }
    public String getAnswer() {
        return myAnswer;
    }

    public void setWindow(GameWindow theWindow) {
        myWindow = theWindow;
    }
}

