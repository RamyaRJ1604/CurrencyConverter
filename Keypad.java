import javax.swing.JButton;

public class Keypad {
    JButton[] numButtons;
    JButton[] funButtons;
    JButton decButton, delButton, clrButton, emptyButton;

    Keypad() {
        numButtons = new JButton[10];
        funButtons = new JButton[3];

        decButton = new JButton(".");
        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");

        clrButton.setBounds(290, 495, 70, 150);

        funButtons[0] = decButton;
        funButtons[1] = delButton;
        funButtons[2] = clrButton;

        for (int i = 0; i < 3; i++) {
            funButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].setFocusable(false);
        }
    }
}
