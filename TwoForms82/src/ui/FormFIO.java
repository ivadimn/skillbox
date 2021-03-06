package ui;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FormFIO extends BasePanel {

    private JPanel rootPanel;
    private JTextField txtLname;
    private JTextField txtFname;
    private JTextField txtMname;
    private JButton btnChange;
    private JLabel lblFamilia;
    private JLabel lblName;
    private JLabel lblOtchestvo;

    @Override
    public String[] getData() {
        return new String[]{txtLname.getText(), txtFname.getText(), txtMname.getText()};
    }

    @Override
    public void setData(String[] data) {
        txtLname.setText(data[0]);
        txtFname.setText(data[1]);
        txtMname.setText(data[2]);
    }

    public FormFIO() {
        txtLname.setDocument(new TextFilter());
        txtFname.setDocument(new TextFilter());
        txtMname.setDocument(new TextFilter());
        txtLname.requestFocusInWindow();
        add(rootPanel);
    }

    public void addChangeListener(ActionListener listener) {
        btnChange.addActionListener(listener);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public JPanel getRootPanel() {
        return rootPanel;
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
        lblFamilia = new JLabel();
        lblFamilia.setText("Фамилия:");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 0.1;
        gbc.anchor = GridBagConstraints.EAST;
        rootPanel.add(lblFamilia, gbc);
        txtLname = new JTextField();
        txtLname.setMinimumSize(new Dimension(150, 30));
        txtLname.setPreferredSize(new Dimension(150, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 0.6;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rootPanel.add(txtLname, gbc);
        txtFname = new JTextField();
        txtFname.setMaximumSize(new Dimension(23647, 2147483647));
        txtFname.setMinimumSize(new Dimension(150, 30));
        txtFname.setPreferredSize(new Dimension(150, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.weightx = 0.6;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rootPanel.add(txtFname, gbc);
        lblName = new JLabel();
        lblName.setText("Имя:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        rootPanel.add(lblName, gbc);
        lblOtchestvo = new JLabel();
        lblOtchestvo.setAlignmentX(0.5f);
        lblOtchestvo.setText("Отчество:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.EAST;
        rootPanel.add(lblOtchestvo, gbc);
        txtMname = new JTextField();
        txtMname.setMinimumSize(new Dimension(150, 30));
        txtMname.setPreferredSize(new Dimension(150, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.weightx = 0.6;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rootPanel.add(txtMname, gbc);
        btnChange = new JButton();
        btnChange.setText("Сменить панель");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 6;
        rootPanel.add(btnChange, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        rootPanel.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rootPanel.add(spacer2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rootPanel.add(spacer3, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rootPanel.add(spacer4, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        rootPanel.add(spacer5, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.VERTICAL;
        rootPanel.add(spacer6, gbc);
        lblFamilia.setLabelFor(txtLname);
        lblName.setLabelFor(txtFname);
        lblOtchestvo.setLabelFor(txtMname);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }
}
