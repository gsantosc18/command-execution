package com.gedalias.commandexecution.utils;

import javax.swing.JOptionPane;

public class NotificationUtil {
    public static void showMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
    public static boolean confirm(final String message) {
        return JOptionPane.showConfirmDialog(null, message) == JOptionPane.YES_OPTION;
    }
}
