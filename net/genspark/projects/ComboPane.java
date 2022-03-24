package net.genspark.projects;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

class ComboPane extends ComponentPane {

    private final JComboBox<String> box = new JComboBox<>();

    ComboPane(JLabel label) {
        super(label);
        add(box);
    }

    String getText() {
        return box.getItemAt(box.getSelectedIndex());
    }

    void reset() {
        box.setSelectedIndex(0);
    }

    void focus() {
        box.grabFocus();
    }

    void setModel(String[] arr) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(arr);
        box.setModel(model);
    }

    int getIndex(){
        return box.getSelectedIndex();
    }

    @Override
    String getNumbers() {
        return box.getItemAt(box.getSelectedIndex());
    }
}
