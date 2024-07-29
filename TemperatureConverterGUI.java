import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterGUI {
    private JFrame frame;
    private JTextField celsiusField;
    private JTextField fahrenheitField;
    private JTextField kelvinField;

    public TemperatureConverterGUI() {
        frame = new JFrame("Temperature Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2));

        JLabel celsiusLabel = new JLabel("Celsius:");
        celsiusField = new JTextField();
        JLabel fahrenheitLabel = new JLabel("Fahrenheit:");
        fahrenheitField = new JTextField();
        JLabel kelvinLabel = new JLabel("Kelvin:");
        kelvinField = new JTextField();

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double celsius = Double.parseDouble(celsiusField.getText());
                    double fahrenheit = C_F(celsius);
                    double kelvin = C_K(celsius);
                    fahrenheitField.setText(String.format("%.2f", fahrenheit));
                    kelvinField.setText(String.format("%.2f", kelvin));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number in the Celsius field.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.add(celsiusLabel);
        frame.add(celsiusField);
        frame.add(fahrenheitLabel);
        frame.add(fahrenheitField);
        frame.add(kelvinLabel);
        frame.add(kelvinField);
        frame.add(convertButton);
        frame.add(exitButton);

        frame.pack();
        frame.setVisible(true);
    }

    // Conversion methods
    static double C_F(double C) {
        return (C * 9/5) + 32;
    }

    static double C_K(double C) {
        return C + 273.15;
    }

    static double F_C(double F) {
        return (F - 32) * 5/9;
    }

    static double F_K(double F) {
        return (F - 32) * 5/9 + 273.15;
    }

    static double K_C(double K) {
        return K - 273.15;
    }

    static double K_F(double K) {
        return (K - 273.15) * 9/5 + 32;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TemperatureConverterGUI());
    }
}
