package ui;

import core.Chat;
import core.Contact;
import core.UserProfile;
import main.App;
import main.UIResources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddContactForm {
    private JPanel rootPanel;

    private final String addContact = "Добавление контакта";
    private final String welcomInput = "Введите код страны и номер\nмобильного телефона пользователя";

    private BlackPanel blackPanel;
    private BottomBlackPanel bottomBlackPanel;
    private TextPane addContactPane;
    private TextPane welcomPane;
    private TextInput txtPhoneInput;
    private TextInput txtFirstName;
    private TextInput txtLastName;
    private BigButton btnAdd;
    private IconPanel textFieldIcon;
    private EditPanel editPanel;

    private ActionListener btnAddListener = (e) -> {
        String name = txtFirstName.getText() + " " + txtLastName.getText();
        Contact contact = new Contact(name, txtPhoneInput.getText());
        Chat chat = new Chat(contact);
        chat.setOnline(true);
        App.getInstance().getChatList().add(chat);
        bottomBlackPanel.getBackButton().doClick();
    };

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        blackPanel = new BlackPanel();
        bottomBlackPanel = new BottomBlackPanel();
        addContactPane = new TextPane(new Dimension(450, 50), addContact);
        welcomPane = new TextPane(new Dimension(380, 60), welcomInput);
        txtPhoneInput = new TextInput(350, TextInput.PHONE_INPUT, "");
        textFieldIcon = new IconPanel(IconPanel.ICON_PHONE);
        editPanel = new EditPanel(txtPhoneInput.getWidth() + IconPanel.WIDTH);
        txtFirstName = new TextInput(txtPhoneInput.getWidth() + IconPanel.WIDTH, TextInput.NAME_INPUT, "Имя");
        txtLastName = new TextInput(txtPhoneInput.getWidth() + IconPanel.WIDTH, TextInput.NAME_INPUT, "Фамилия");
        btnAdd = new BigButton("ДОБАВИТЬ");


    }

    public AddContactForm() {
        $$$setupUI$$$();
        createUIComponents();
        addContactPane.setForeground(UIResources.LIGHT_BLUE_COLOR);
        addContactPane.setFontSize(42.0F);
        welcomPane.setForeground(Color.WHITE);
        welcomPane.setFontSize(16.0F);
        txtFirstName.setHorizontalAlignment(JTextField.CENTER);
        txtLastName.setHorizontalAlignment(JTextField.CENTER);
        blackPanel.addComponent(addContactPane, 60);
        blackPanel.addComponent(welcomPane, 40);
        editPanel.addIcon(textFieldIcon);
        editPanel.addTextField(txtPhoneInput);
        blackPanel.addComponent(editPanel, 10);
        blackPanel.addComponent(txtFirstName, 20);
        blackPanel.addComponent(txtLastName, 20);
        blackPanel.addComponent(btnAdd, 40);
        rootPanel.add(blackPanel, BorderLayout.CENTER);
        rootPanel.add(bottomBlackPanel, BorderLayout.SOUTH);
        btnAdd.addActionListener(btnAddListener);
    }

    public void setBackListener(ActionListener l) {
        bottomBlackPanel.setBackListener(l);
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
        rootPanel.setLayout(new BorderLayout(20, 0));
        rootPanel.setMaximumSize(new Dimension(905, 630));
        rootPanel.setMinimumSize(new Dimension(905, 630));
        rootPanel.setPreferredSize(new Dimension(905, 630));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }


}
