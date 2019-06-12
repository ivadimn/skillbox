package ui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;

public class FormFIOCompact extends BasePanel {
    private JPanel rootPanel;
    private JLabel lblFio;
    private JTextField txtFio;
    private JButton btnChange;
    private JProgressBar pbLenght;



    @Override
    public String[] getData() {
        return new String[] { txtFio.getText() };
    }

    @Override
    public void setData(String[] data) {
        txtFio.setText(String.format("%s %s %s", data[0], data[1], data[2]));
    }

    public interface ChangeListenerCompact {
        public void changePanel(String lname, String fname, String mname);
    }



    public FormFIOCompact() {
        add(rootPanel);
        txtFio.setDocument(new BasePanel.TextFilter());
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
