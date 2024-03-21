import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class that handles the game window and input events.
 *
 * @author Keith Tramm
 *
 * @version 3/20/2024
 */
public class GameWindow {
    /**
     * top level window
     */
    private JFrame myFrame;
    /**
     * panel for the header
     */
    private JPanel myHeaderPanel;
    /**
     * main panel
     */
    private JPanel myMainPanel;
    /**
     * bottom most panel
     */
    private JPanel myBottomPanel;
    /**
     * label for the question
     */
    private JLabel myQuestionLabel;
    /**
     * label for the score
     */
    private JLabel myScoreLabel;
    /**
     * label for the answer streak
     */
    private JLabel myStreakLabel;
    /**
     * label for the lives count
     */
    private JLabel myLivesLabel;
    /**
     * text field for the player input
     */
    private JTextField myAnswerField;
    /**
     * button for submitting answers
     */
    private JButton mySubmitButton;
    /**
     * button to exit the window
     */
    private JButton myExitButton;
    /**
     * button to restart the game;
     */
    private JButton myPlayAgainButton;
    /**
     * reference to the game instance
     */
    private Game myGame;

    /**
     * Constructor to initialize window
     * @param theGame reference to the game instance
     */

    public GameWindow(Game theGame) {
        myGame = theGame;
        init();
    }

    /**
     * initialize the window and its components
     */
    private void init() {
        myFrame = new JFrame();
        myFrame.setSize(new Dimension(800, 700));
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setResizable(false);
        myFrame.setLocationRelativeTo(null);

        myFrame.setVisible(true);
        initializePanels();
        initializeComponents();

    }

    /**
     * initializes the window components
     */
    public void initializeComponents() {
        createTextField();
        createLivesText();
        createScoreText();
        createStreakText();
        createButtons();
        createTitle();
        createQuestion();

    }

    /**
     * initializes the streak label component
     */
    private void createStreakText() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(120, 500, 0, 0);
        myStreakLabel = ComponentBuilder.createLabel("Streak: " + myGame.getStreak(), SwingConstants.CENTER,
                SwingConstants.CENTER, new Font("Arial", Font.PLAIN, 30), 0);
        myMainPanel.add(myStreakLabel, gbc);
    }

    /**
     * initializes the score label component
     */
    private void createScoreText() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(120, 0, 0, 0);
        myScoreLabel = ComponentBuilder.createLabel("Score: " + myGame.getScore(), SwingConstants.CENTER,
                SwingConstants.CENTER, new Font("Arial", Font.PLAIN, 30), 0);
        myMainPanel.add(myScoreLabel, gbc);
    }

    /**
     * creates the lives counter label component
     */
    private void createLivesText() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(120, 0, 0, 500);
        myLivesLabel = ComponentBuilder.createLabel("Lives: " + myGame.getLives(), SwingConstants.CENTER,
                SwingConstants.CENTER, new Font("Arial", Font.PLAIN, 30), 0);
        myMainPanel.add(myLivesLabel, gbc);

    }

    /**
     * creates the text field component
     */
    private void createTextField() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(30, 0, 0, 0);

        myAnswerField = new JTextField();
        myAnswerField.setEditable(true);
        myAnswerField.setColumns(10);
        myAnswerField.setForeground(Color.BLACK);
        myAnswerField.setPreferredSize(new Dimension(25,50));
        myAnswerField.setFont(new Font("Arial", Font.PLAIN, 20));
        myAnswerField.setToolTipText("Enter you answer here.");
        myMainPanel.add(myAnswerField, gbc);

    }

    /**
     * initializes and adds all three panels to the JFrame
     */
    public void initializePanels() {
        myHeaderPanel = ComponentBuilder.createPanel(Color.WHITE,
                BorderFactory.createMatteBorder(4, 4, 2, 4,
                        Color.BLACK), new BorderLayout(10, 20));
        myMainPanel = ComponentBuilder.createPanel(Color.WHITE,
                BorderFactory.createMatteBorder(2, 4, 2, 4,
                        Color.BLACK), new GridBagLayout());
        myBottomPanel = ComponentBuilder.createPanel(Color.WHITE, new BorderLayout());


        myFrame.add(myHeaderPanel, BorderLayout.NORTH);
        myFrame.add(myMainPanel, BorderLayout.CENTER);
        myFrame.add(myBottomPanel, BorderLayout.SOUTH);

    }
    /**
     * create the title label text component
     */
    public void createTitle() {
        JLabel myTitleLabel = ComponentBuilder.createLabel("Math Attack",
                SwingConstants.CENTER, SwingConstants.BOTTOM, new Font("Arial",
                        Font.BOLD, 40), 10);
        myHeaderPanel.add(myTitleLabel, BorderLayout.CENTER);
        myTitleLabel.setIcon(new ImageIcon("src/Deus_mathematics.png"));
    }

    /**
     * creates the question label component
     */
    public void createQuestion() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 30, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        myQuestionLabel = ComponentBuilder.createLabel("1 + 1 = ?",
                SwingConstants.CENTER, SwingConstants.CENTER, new Font("Arial",
                        Font.BOLD, 40), 0);
        myMainPanel.add(myQuestionLabel, gbc);
    }

    /**
     * creates the submit, exit, amd play again buttons
     */
    public void createButtons() {
        mySubmitButton = ComponentBuilder.createButton("Submit",
                new Font("Arial", Font.BOLD,20), false);
        myBottomPanel.add(mySubmitButton, BorderLayout.CENTER);

            myExitButton = ComponentBuilder.createButton("Exit Game",
                new Font("Arial", Font.BOLD,20), false);
            myExitButton.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.insets = new Insets(0, 200, 0, 0);
            myExitButton.setVisible(false);
            myMainPanel.add(myExitButton, gbc);

            myPlayAgainButton = ComponentBuilder.createButton("Play Again",
                new Font("Arial", Font.BOLD,20), false);
            myExitButton.setLayout(new GridBagLayout());
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.insets = new Insets(0, 0, 0, 200);
            myPlayAgainButton.setVisible(false);
            myMainPanel.add(myPlayAgainButton, gbc);

            initializeButtonActionListeners(mySubmitButton, myExitButton, myPlayAgainButton);

    }
    /**
     * implements each of the buttons functionality
     * @param theSubmitButton submits and grades the input alters score, lives,
     *        and streak
     * @param theExitButton exits the game
     * @param thePlayAgainButton resets game values and begins the game
     */
    public void initializeButtonActionListeners(JButton theSubmitButton, JButton theExitButton, JButton thePlayAgainButton) {
        theSubmitButton.addActionListener(new ActionListener() {
            /**
             * Called when the submit button is clicked
             * @param e the event to be processed
             */
            public void actionPerformed(ActionEvent e) {
                System.out.println(myAnswerField.getText());
                if(myAnswerField.getText().equals(myGame.getAnswer())) {
                    AudioPlayer.playAudio("src/Yippee.wav");
                    myGame.increaseScore(10);
                    myGame.incrementStreak();
                    myGame.setIsQuestionSubmitted(true);
                } else {
                    AudioPlayer.playAudio("src/WompWomp.wav");
                    myGame.decrementLives();
                    myGame.setStreak(0);
                    myGame.setIsQuestionSubmitted(true);
                }
            }
        });
        theExitButton.addActionListener(new ActionListener() {
            /**
             * called when the exit button is clicked
             * @param e the event to be processed
             */
            public void actionPerformed(ActionEvent e) {
                myGame.setIsRunning(false);
                System.exit(0);
            }
        });

        thePlayAgainButton.addActionListener(new ActionListener() {
            /**
             * called when the play again button is clicked
             * @param e the event to be processed
             */
            public void actionPerformed(ActionEvent e) {
                myGame.newGame();
            }
        });


    }

    /**
     * gets the question label
     * @return question label
     */
    public JLabel getQuestionLabel() {
        return myQuestionLabel;
    }

    /**
     * gets the score label
     * @return Score label
     */
    public JLabel getScoreLabel() {
        return myScoreLabel;
    }

    /**
     * gets the streak label
     * @return streak label
     */
    public JLabel getStreakLabel() {
        return myStreakLabel;
    }

    /**
     * gets the lives label
     * @return lives label
     */
    public JLabel getLivesLabel() {
        return myLivesLabel;
    }

    /**
     * gets the input text field
     * @return input text field
     */
    public JTextField getAnswerField() {
        return myAnswerField;
    }

    /**
     * gets the submit button
     * @return submit button
     */
    public JButton getSubmitButton() {
        return mySubmitButton;
    }

    /**
     * gets the exit button
     * @return exit button
     */
    public JButton getExitButton() {
        return myExitButton;
    }

    /**
     * gets the play again button
     * @return play again button
     */
    public JButton getPlayAgainButton() {
        return myPlayAgainButton;
    }
}
