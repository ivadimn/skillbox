package ui;

import main.UIResources;

import javax.swing.*;
import java.awt.*;

public class NamePanel extends JPanel {

    private String name;
    private Color background;
    private Color foreground;

    private JLabel lblName;
    private FacePanel pnlFace;
    private Font font;


    public NamePanel(String name, Color background, Color foreground, int mask, int heightParent) {
        this.name = name;
        this.background = background;
        this.foreground = foreground;
        setOpaque(false);
        font = UIResources.getFont(UIResources.OPEN_SANS_LIGHT);
        lblName = new JLabel(name);
        lblName.setFont(font.deriveFont(14.0F));
        lblName.setForeground(foreground);
        pnlFace = new FacePanel(mask);
        setActualSize(new Dimension(calculateWidth(), heightParent));
        FlowLayout layout = new FlowLayout();
        layout.setVgap((heightParent - pnlFace.getActualSize().height) / 2);
        setLayout(layout);
        add(pnlFace);
        add(lblName);
    }


    @Override
    public void setName(String name) {
        this.name = name;
        lblName.setText(name);
        setActualSize(new Dimension(calculateWidth(), pnlFace.getActualSize().height));
        revalidate();
    }

    @Override
    public void setBackground(Color background) {
        this.background = background;
    }

    @Override
    public void setForeground(Color foreground) {
        this.foreground = foreground;
    }

    public void setActualSize(Dimension size) {
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
    }

    private int calculateWidth() {
        int widthFacePanel = pnlFace.getActualSize().width;
        FontMetrics fontMetrics = getFontMetrics(font.deriveFont(14.0F));
        int widthName =  fontMetrics.stringWidth(name);
        return widthFacePanel + widthName + 10;
    }


}
