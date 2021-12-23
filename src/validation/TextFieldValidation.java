/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author abdul
 */
public class TextFieldValidation {
    public static boolean isValidEmail(TextField tf) {
        boolean b = false;
        String pattern = "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        if (tf.getText().matches(pattern)) {
            b = true;
        }
        return b;
    }
    public static boolean isValidEmail(TextField tf, Label lb, String errorMessage) {
        boolean b = true;
        String msg = null;
        tf.getStyleClass().remove("error");
        if (!isValidEmail(tf)) {
            b = false;
            msg = errorMessage;
            tf.getStyleClass().add("error");
        }
        lb.setText(msg);
        return b;

    }
    public static boolean isTextFieldNotEmpty(TextField tf) {
        boolean b = false;
        if (tf.getText().length() != 0 || !tf.getText().isEmpty()) {
            b = true;
        }
        return b;

    }

    public static boolean isTextFieldNotEmpty(TextField tf, Label lb, String errorMessage) {
        boolean b = true;
        String msg = null;
        if (!isTextFieldNotEmpty(tf)) {
            b = false;
            msg = errorMessage;
        }
        lb.setText(msg);
        return b;

    }
}
