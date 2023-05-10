import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;

public class ConverterFrame extends JFrame {

    KeypadPanel keypadPanel = new KeypadPanel();
    Dropdown dropdown = new Dropdown();
    Textfield textField = new Textfield();
    Button convert = new Button();
    Keypad keypad = new Keypad();

    ConverterFrame() {
        setTitle("Currency Converter");
        setSize(420, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        add(dropdown.fromComboBox);
        add(dropdown.toComboBox);
        add(textField.inputField);
        add(textField.outputField);
        add(convert);
        add(keypadPanel);
        add(keypad.clrButton);
        setVisible(true);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.inputField.getText().equals(textField.inputPlaceHolder)) {
                    textField.inputField.setText("");
                }

                for (int i = 0; i < 10; i++) {
                    if (e.getSource() == keypadPanel.keypad.numButtons[i]) {
                        textField.inputField.setText(textField.inputField.getText().concat(String.valueOf(i)));
                    }
                }
                if (e.getSource() == keypad.clrButton) {
                    textField.inputField.setText(textField.inputPlaceHolder);
                    textField.outputField.setText(textField.outputPlaceHolder);
                    dropdown.fromComboBox.setSelectedItem(dropdown.currencies[0]);
                    dropdown.toComboBox.setSelectedItem(dropdown.currencies[0]);
                }

                if (e.getSource() == keypadPanel.keypad.delButton) {
                    String string = textField.inputField.getText();
                    if (string.isEmpty())
                        textField.inputField.setText(textField.inputPlaceHolder);
                    else
                        textField.inputField.setText(string.substring(0, string.length() - 1));
                    textField.outputField.setText(textField.outputPlaceHolder);
                }

                if (e.getSource() == keypadPanel.keypad.decButton) {
                    if (textField.inputField.getText().indexOf(".") == -1) {
                        textField.inputField.setText(textField.inputField.getText().concat("."));
                    }
                }

                if (e.getSource() == convert) {
                    String currencyFrom = dropdown.fromComboBox.getSelectedItem().toString();
                    String currencyTo = dropdown.toComboBox.getSelectedItem().toString();
                    double currencyAmount = 0, currencyConverted = 0;
                    if (!textField.inputField.getText().equals(textField.inputPlaceHolder))
                        currencyAmount = Double.parseDouble(textField.inputField.getText());
                    try {
                        currencyConverted = new APICon(currencyFrom, currencyTo, currencyAmount).makeConnection();
                        textField.outputField.setText(String.valueOf(currencyConverted));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        };
        for (int i = 0; i < 10; i++) {
            keypadPanel.keypad.numButtons[i].addActionListener(listener);
        }
        keypadPanel.keypad.delButton.addActionListener(listener);
        keypadPanel.keypad.decButton.addActionListener(listener);
        keypad.clrButton.addActionListener(listener);
        convert.addActionListener(listener);
    }
}
