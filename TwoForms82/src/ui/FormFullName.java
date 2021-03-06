package ui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class FormFullName extends BasePanel {
    private JLabel lblFio;
    private JTextField txtFio;
    private JProgressBar pbLenght;
    private JButton btnChange;
    private JPanel rootPanel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    @Override
    public String[] getData() {
        return new String[]{txtFio.getText()};
    }

    @Override
    public void setData(String[] data) {
        txtFio.setText(String.format("%s %s %s", data[0], data[1], data[2]));
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
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
        rootPanel.setLayout(new GridBagLayout());
        rootPanel.setMaximumSize(new Dimension(273, 100));
        rootPanel.setMinimumSize(new Dimension(273, 100));
        rootPanel.setPreferredSize(new Dimension(273, 100));
        lblFio = new JLabel();
        lblFio.setText("Ф.И.О.");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        rootPanel.add(lblFio, gbc);
        txtFio = new JTextField();
        txtFio.setMaximumSize(new Dimension(200, 30));
        txtFio.setMinimumSize(new Dimension(200, 30));
        txtFio.setPreferredSize(new Dimension(200, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rootPanel.add(txtFio, gbc);
        pbLenght = new JProgressBar();
        pbLenght.setPreferredSize(new Dimension(146, 20));
        pbLenght.setString("0");
        pbLenght.setStringPainted(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rootPanel.add(pbLenght, gbc);
        btnChange = new JButton();
        btnChange.setText("Сменить панель");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rootPanel.add(btnChange, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }

    public interface ChangeListenerCompact {
        public void changePanel(String lname, String fname, String mname);
    }


    public FormFullName() {
        add(rootPanel);
        txtFio.setDocument(new TextFilter());
        txtFio.setColumns(100);
        txtFio.requestFocusInWindow();

        txtFio.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateProgressBar(txtFio.getText().length());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateProgressBar(txtFio.getText().length());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateProgressBar(txtFio.getText().length());
            }
        });

    }

    public void addChangeListener(ActionListener listener) {
        btnChange.addActionListener(listener);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setData(String fio) {
        txtFio.setText(fio);
        updateProgressBar(fio.length());
    }

    private void updateProgressBar(int length) {
        pbLenght.setString(Integer.toString(length));
        pbLenght.setValue(length);
    }
}
