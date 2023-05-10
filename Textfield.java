import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Textfield extends JTextField {

    JTextField inputField, outputField;
    String inputPlaceHolder, outputPlaceHolder;

    Textfield() {
        inputPlaceHolder = "Enter amount to convert";
        inputField = new JTextField(inputPlaceHolder);
        inputField.setBounds(110, 150, 200, 50);
        inputField.setHorizontalAlignment(SwingConstants.CENTER);
        inputField.setBorder(new LineBorder(Color.BLACK, 3));
        inputField.setEditable(false);

        outputPlaceHolder = "Converted amount is";
        outputField = new JTextField(outputPlaceHolder);
        outputField.setBounds(110, 330, 200, 50);
        outputField.setHorizontalAlignment(SwingConstants.CENTER);
        outputField.setBorder(new LineBorder(Color.BLACK, 3));
        outputField.setEditable(false);

    }
}
