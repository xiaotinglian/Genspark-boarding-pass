package net.genspark.projects;

import javax.swing.*;
import java.awt.FlowLayout;

abstract class ComponentPane extends JPanel {

    JLabel label;

    ComponentPane(JLabel label) {
        this.label = label;
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(label);
    }

    abstract String getNumbers();

    abstract void focus();

    abstract void reset();

    abstract String getText();

}
