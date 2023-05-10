import java.awt.GridLayout;

import javax.swing.JPanel;

public class KeypadPanel extends JPanel {
    Keypad keypad = new Keypad();

    KeypadPanel() {
        setBounds(50, 420, 230, 300);
        setLayout(new GridLayout(4, 3, 10, 10));

        add(keypad.numButtons[1]);
        add(keypad.numButtons[2]);
        add(keypad.numButtons[3]);

        add(keypad.numButtons[4]);
        add(keypad.numButtons[5]);
        add(keypad.numButtons[6]);

        add(keypad.numButtons[7]);
        add(keypad.numButtons[8]);
        add(keypad.numButtons[9]);

        add(keypad.decButton);
        add(keypad.numButtons[0]);
        add(keypad.delButton);
    }
}
