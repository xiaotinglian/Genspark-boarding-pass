package net.genspark.projects;

import javax.swing.*;
import java.awt.FlowLayout;

abstract class ComponentPane extends JPanel {

    ComponentPane(String str) {
        add(new JLabel(str));
        setLayout(new FlowLayout(FlowLayout.RIGHT));
    }

    abstract String getNumbers();

    abstract void focus();

    abstract void reset();

    abstract String getText();

}