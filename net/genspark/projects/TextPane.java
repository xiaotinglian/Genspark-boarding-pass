package net.genspark.projects;

import javax.swing.JLabel;
import javax.swing.JTextField;

class TextPane extends ComponentPane {

    private final JTextField field = new JTextField(20);

    TextPane(JLabel label) {
        super(label);
        add(field);
    }

    String getText() {
        return field.getText();
    }

    String getNumbers() {
        String str;
        str = field.getText().trim().replaceAll("[\\W\\s]", "");
        return str;
    }

    void reset() {
        field.setText(null);
    }

    void focus() {
        field.grabFocus();
    }
}
