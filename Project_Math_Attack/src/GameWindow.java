import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow {
    private JFrame myFrame;
    private JPanel myHeaderPanel;
    private JPanel myMainPanel;
    private JPanel myBottomPanel;
    private JLabel myQuestionLabel;
    private JLabel myScoreLabel;
    private JLabel myStreakLabel;
    private JLabel myLivesLabel;
    private JTextField myAnswerField;
    private JButton mySubmitButton;
    private JButton myExitButton;
    private JButton myPlayAgainButton;
    private Game myGame;

    public GameWindow(Game theGame) {
        myGame = theGame;
        init();
        initializePanels();
        initializeComponents();
    }
    private void init() {
        myFrame = new JFrame();
        myFrame.setSize(new Dimension(800, 700));
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setResizable(false);
        myFrame.setLocationRelativeTo(null);

        myFrame.setVisible(true);

    }
    public void initializeComponents() {
        createTextField();
        createLivesText();
        createScoreText();
        createStreakText();
        createButtons();
        createTitle();
        createQuestion();

    }

    private void createStreakText() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(120, 500, 0, 0);
        myStreakLabel = ComponentBuilder.createLabel("Streak: " + myGame.getStreak(), SwingConstants.CENTER,
                SwingConstants.CENTER, new Font("Arial", Font.PLAIN, 30), 0);
        myMainPanel.add(myStreakLabel, gbc);
    }

    private void createScoreText() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(120, 0, 0, 0);
        myScoreLabel = ComponentBuilder.createLabel("Score: " + myGame.getScore(), SwingConstants.CENTER,
                SwingConstants.CENTER, new Font("Arial", Font.PLAIN, 30), 0);
        myMainPanel.add(myScoreLabel, gbc);
    }

    private void createLivesText() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(120, 0, 0, 500);
        myLivesLabel = ComponentBuilder.createLabel("Lives: " + myGame.getLives(), SwingConstants.CENTER,
                SwingConstants.CENTER, new Font("Arial", Font.PLAIN, 30), 0);
        myMainPanel.add(myLivesLabel, gbc);

    }

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
    public void createTitle() {
        JLabel myTitleLabel = ComponentBuilder.createLabel("Math Attack",
                SwingConstants.CENTER, SwingConstants.BOTTOM, new Font("Arial",
                        Font.BOLD, 40), 10);
        myHeaderPanel.add(myTitleLabel, BorderLayout.CENTER);
        myTitleLabel.setIcon(new ImageIcon("src/Deus_mathematics.png"));
    }
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

    public void initializeButtonActionListeners(JButton theSubmitButton, JButton theExitButton, JButton thePlayAgainButton) {
        theSubmitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(myAnswerField.getText());
                if(myAnswerField.getText().equals(myGame.getAnswer())) {
                    myGame.increaseScore(10);
                    myGame.incrementStreak();
                    myGame.setIsQuestionSubmitted(true);
                } else {
                    myGame.decrementLives();
                    myGame.setStreak(0);
                    myGame.setIsQuestionSubmitted(true);
                }
            }
        });

        theExitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myGame.setIsRunning(false);
                System.exit(0);
            }
        });

        thePlayAgainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myGame.newGame();
            }
        });


    }
    public JLabel getQuestionLabel() {
        return myQuestionLabel;
    }
    public JLabel getScoreLabel() {
        return myScoreLabel;
    }
    public JLabel getStreakLabel() {
        return myStreakLabel;
    }
    public JLabel getLivesLabel() {
        return myLivesLabel;
    }
    public JTextField getAnswerField() {
        return myAnswerField;
    }
    public JButton getSubmitButton() {
        return mySubmitButton;
    }
    public JButton getExitButton() {
        return myExitButton;
    }
    public JButton getPlayAgainButton() {
        return myPlayAgainButton;
    }
}
