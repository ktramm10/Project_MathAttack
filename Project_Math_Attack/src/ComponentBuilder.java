import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Class that handles building java swing components
 * @author Keith Tramm
 * @version 3/20/2024
 */
public class ComponentBuilder {
    /**
     * Creates a new JPanel with specified properties
     * @param theSize Dimensions of the JPanel
     * @param theColor background color of the JPanel
     * @param theBorder Border of the JPanel
     * @param theLayoutManager Layout manager of the JPanel
     * @return new JPanel
     */
    public static JPanel createPanel(Dimension theSize, Color theColor, Border theBorder, LayoutManager theLayoutManager) {
        JPanel panel = new JPanel();
        panel.setLayout(theLayoutManager);
        panel.setBorder(theBorder);
        panel.setPreferredSize(theSize);
        panel.setBackground(theColor);
        return panel;
    }

    /**
     * Creates a new JPanel with specified properties
     * @param theSize Dimensions of the JPanel
     * @param theColor background color of the JPanel
     * @param theLayoutManager Layout manager of the JPanel
     * @return new JPanel
     */
    public static JPanel createPanel(Dimension theSize, Color theColor, LayoutManager theLayoutManager) {
        JPanel panel = new JPanel();
        panel.setLayout(theLayoutManager);
        panel.setPreferredSize(theSize);
        panel.setBackground(theColor);
        return panel;
    }

    /**
     * creates a new JPanel with the specified properties
     * @param theColor background color of the JPanel
     * @param theLayoutManager Layout manager of the JPanel
     * @return new JPanel
     */
    public static JPanel createPanel(Color theColor, LayoutManager theLayoutManager) {
        JPanel panel = new JPanel();
        panel.setLayout(theLayoutManager);
        panel.setBackground(theColor);
        return panel;
    }

    /**
     * creates a new JPanel with the specified properties
     * @param theColor background color of the JPanel
     * @param theBorder border of the JPanel
     * @param  theLayoutManager LayoutManager of the JPanel
     * @return new JPanel
     */
    public static JPanel createPanel(Color theColor, Border theBorder, LayoutManager theLayoutManager) {
        JPanel panel = new JPanel();
        panel.setLayout(theLayoutManager);
        panel.setBorder(theBorder);
        panel.setBackground(theColor);
        return panel;
    }

    /**
     * creates a label with the specified properties
     * @param theText text that the label will display
     * @param theHorizontalAlignment horizontal alignment of the label
     * @param theVerticalAlignment vertical alignment of the label
     * @param theFont the font that will be used
     * @param setIconTextGap the gap between text and images
     * @return new label
     */
    public static JLabel createLabel(String theText, int theHorizontalAlignment,
        int theVerticalAlignment, Font theFont, int setIconTextGap) {
        JLabel label = new JLabel(theText);
        label.setHorizontalAlignment(theHorizontalAlignment);
        label.setVerticalAlignment(theVerticalAlignment);
        label.setIconTextGap(setIconTextGap);
        label.setFont(theFont);
        return label;
    }

    /**
     * creates a new button with the specified properties
     * @param theText the text on the button
     * @param theFont the font to be used
     * @param theFocusable if the button is focusable
     * @return new button
     */
    public static JButton createButton(String theText, Font theFont, boolean theFocusable) {
        JButton button = new JButton(theText);
        button.setFont(theFont);
        button.setFocusable(theFocusable);
        return button;
    }
}
