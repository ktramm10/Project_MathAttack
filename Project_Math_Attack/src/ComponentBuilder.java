import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ComponentBuilder {
    public static JPanel createPanel(Dimension theSize, Color theColor, Border theBorder, LayoutManager theLayoutManager) {
        JPanel panel = new JPanel();
        panel.setLayout(theLayoutManager);
        panel.setBorder(theBorder);
        panel.setPreferredSize(theSize);
        panel.setBackground(theColor);
        return panel;
    }
    public static JPanel createPanel(Dimension theSize, Color theColor, LayoutManager theLayoutManager) {
        JPanel panel = new JPanel();
        panel.setLayout(theLayoutManager);
        panel.setPreferredSize(theSize);
        panel.setBackground(theColor);
        return panel;
    }
    public static JPanel createPanel(Color theColor, LayoutManager theLayoutManager) {
        JPanel panel = new JPanel();
        panel.setLayout(theLayoutManager);
        panel.setBackground(theColor);
        return panel;
    }
    public static JPanel createPanel(Color theColor, Border theBorder, LayoutManager theLayoutManager) {
        JPanel panel = new JPanel();
        panel.setLayout(theLayoutManager);
        panel.setBorder(theBorder);
        panel.setBackground(theColor);
        return panel;
    }
    public static JLabel createLabel(String theText, int theHorizontalAlignment,
        int theVerticalAlignment, Font theFont, int setIconTextGap) {
        JLabel label = new JLabel(theText);
        label.setHorizontalAlignment(theHorizontalAlignment);
        label.setVerticalAlignment(theVerticalAlignment);
        label.setIconTextGap(setIconTextGap);
        label.setFont(theFont);
        return label;
    }
    public static JButton createButton(String theText, Font theFont, boolean theFocusable) {
        JButton button = new JButton(theText);
        button.setFont(theFont);
        button.setFocusable(theFocusable);
        return button;
    }
}
