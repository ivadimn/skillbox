package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class CodeForm {

    private final String welcomInput = "На данный номер телефона было отправлено\n" +
            "SMS - сообщение с кодом подтверждения.\n" +
            "Пожалуйства, введите этот код в поле ниже:";

    private JPanel rootPanel;
    private JPanel pnlMain;
    private JPanel pnlLogo;
    private JPanel pnlCode;
    private JPanel pnlNext;
    private JButton btnNext;
    private JPasswordField txtCode;
    private JTextPane panePhone;
    private JTextPane paneWelcom;


    private ChangePanel changePanel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        pnlMain = new MainPanel(MainPanel.MINI);
        pnlLogo = new LogoPanel(LogoPanel.MINI);
        panePhone = new WelcomPane(new Dimension(380, 40));
        paneWelcom = new WelcomPane(new Dimension(380, 140));
    }

    public CodeForm() {
        $$$setupUI$$$();
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/OpenSansLight.ttf"));
            panePhone.setFont(font.deriveFont(32.0F));
            paneWelcom.setFont(font.deriveFont(16.0F));

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        btnNext.setBackground(new Color(21, 61, 242));
        paneWelcom.setText(welcomInput);
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (changePanel != null) {
                    changePanel.next(txtCode.getPassword().toString());
                }
            }
        });
    }

    public void setPhoneNumber(String number) {
        panePhone.setText(number);
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
        createUIComponents();
        rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout(0, 0));
        rootPanel.setMaximumSize(new Dimension(905, 596));
        pnlMain.setLayout(new FlowLayout(FlowLayout.CENTER, 450, 20));
        pnlMain.setMaximumSize(new Dimension(905, 596));
        pnlMain.setMinimumSize(new Dimension(905, 596));
        pnlMain.setPreferredSize(new Dimension(905, 596));
        rootPanel.add(pnlMain, BorderLayout.CENTER);
        pnlLogo.setMaximumSize(new Dimension(124, 98));
        pnlLogo.setMinimumSize(new Dimension(124, 98));
        pnlLogo.setOpaque(false);
        pnlLogo.setPreferredSize(new Dimension(124, 98));
        pnlMain.add(pnlLogo);
        panePhone.setForeground(new Color(-1));
        panePhone.setMargin(new Insets(10, 10, 10, 10));
        panePhone.setOpaque(false);
        panePhone.setText("+7 999 2125549");
        pnlMain.add(panePhone);
        paneWelcom.setForeground(new Color(-1));
        paneWelcom.setMargin(new Insets(10, 10, 10, 10));
        paneWelcom.setOpaque(false);
        paneWelcom.setText("На данный номер телефона было отправлено");
        pnlMain.add(paneWelcom);
        pnlCode = new JPanel();
        pnlCode.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnlCode.setMaximumSize(new Dimension(200, 40));
        pnlCode.setMinimumSize(new Dimension(150, 40));
        pnlCode.setPreferredSize(new Dimension(150, 40));
        pnlMain.add(pnlCode);
        txtCode = new JPasswordField();
        txtCode.setMaximumSize(new Dimension(150, 150));
        txtCode.setMinimumSize(new Dimension(150, 30));
        txtCode.setPreferredSize(new Dimension(150, 30));
        pnlCode.add(txtCode);
        pnlNext = new JPanel();
        pnlNext.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
        pnlNext.setMaximumSize(new Dimension(150, 60));
        pnlNext.setMinimumSize(new Dimension(150, 60));
        pnlNext.setPreferredSize(new Dimension(150, 60));
        pnlNext.putClientProperty("html.disable", Boolean.FALSE);
        pnlMain.add(pnlNext);
        btnNext = new JButton();
        btnNext.setForeground(new Color(-2363905));
        btnNext.setText("ПРОДОЛЖИТЬ");
        pnlNext.add(btnNext);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }


}
