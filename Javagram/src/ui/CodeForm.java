package ui;

import com.sun.org.apache.bcel.internal.classfile.Code;

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
    private MainPanel pnlMain;
    private BigButton btnNext;
    private CodeInput txtCode;
    private WelcomPane panePhone;
    private WelcomPane paneWelcom;


    private ChangePanel changePanel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        pnlMain = new MainPanel(MainPanel.MINI);
        panePhone = new WelcomPane(new Dimension(380, 40), "");
        paneWelcom = new WelcomPane(new Dimension(380, 60), welcomInput);
    }

    public CodeForm() {
        $$$setupUI$$$();

        panePhone.setFontSize(32.0F);
        paneWelcom.setFontSize(16.0F);
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
        rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout(0, 0));
        rootPanel.setMaximumSize(new Dimension(905, 596));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }


}
