package net.genspark.projects;

import javax.swing.JLabel;
import javax.swing.JTextField;

class TextPane extends ComponentPane {

    private final JTextField field = new JTextField(20);

    TextPane(JLabel label) {
        super(label);
        add(field);
    }

    JTextField getField() {
        return this.field;
    }

    int getLength() {
        return this.getText().length();
    }

    String getNumbers() {
        String str;
        str = field.getText().trim().replaceAll("[\\W\\s]", "");
        return str;
    }

    String getText() {
        return field.getText();
    }

    void reset() {
        field.setText(null);
    }

    void focus() {
        field.grabFocus();
    }
}
