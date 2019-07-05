package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PhoneNumberFrom {

    private final String welcomInput = "Введите код страны и номер\nвашего мобильного телефона";
    private JPanel rootPanel;
    private MainPanel mainPanel;
    private WelcomPane paneWelcom;
    private TextInput txtPhone;
    private BigButton btnNext;
    private IconPanel textFieldIcon;
    private EditPanel editPanel;


    private ChangePanel changePanel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        mainPanel = new MainPanel(MainPanel.LARGE);
        paneWelcom = new WelcomPane(new Dimension(380, 60), welcomInput);
        txtPhone = new TextInput(TextInput.PHONE_INPUT);
        btnNext = new BigButton("ПРОДОЛЖИТЬ");
        textFieldIcon = new IconPanel(IconPanel.ICON_PHONE);
        editPanel = new EditPanel(TextInput.WIDTH + IconPanel.WIDTH);
    }

    public PhoneNumberFrom() {


        $$$setupUI$$$();
        createUIComponents();
        paneWelcom.setFontSize(18.0F);
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (changePanel != null) {
                    changePanel.next(txtPhone.getText());
                }
            }
        });

        mainPanel.addComponent(paneWelcom, 270);
        editPanel.addIcon(textFieldIcon);
        editPanel.addTextField(txtPhone);
        mainPanel.addComponent(editPanel, 10);
        mainPanel.addComponent(btnNext, 35);
        rootPanel.add(mainPanel, BorderLayout.CENTER);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setChangePanel(ChangePanel changePanel) {
        this.changePanel = changePanel;
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout(0, 0));
        rootPanel.setMaximumSize(new Dimension(905, 622));
        rootPanel.setMinimumSize(new Dimension(905, 622));
        rootPanel.setPreferredSize(new Dimension(905, 622));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }

}
