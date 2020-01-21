package app.Calculadora.View;

import javax.swing.*;
import javax.swing.border.*;
import app.Calculadora.View.Interfaces.VistaCalculadora;
import java.awt.*;
import java.awt.event.*;

public class VentanaCalculadora extends JFrame implements VistaCalculadora {
    int height, width;
    String title;
    boolean resizable, visible;
    private JTextField boxText = new JTextField("0", 10);
    private JButton clearButton = new JButton("C");
    private JButton[] digitsButtons = new JButton[10];
    private JButton decimalButton = new JButton(".");
    private JButton equalButton = new JButton("=");
    private JButton[] operationsButtons = new JButton[4];

    public void inicializar() {
        this.height = 230;
        this.width = 250;
        this.title = "Calculadora";
        this.resizable = false;
        this.digitsButtons = digitsButtonsMaker();
        this.operationsButtons = operationsButtonsMaker();
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(crearPanelDisplay(), BorderLayout.NORTH);
        getContentPane().add(crearPanelClear(), BorderLayout.CENTER);
        getContentPane().add(crearPanelTeclas(), BorderLayout.SOUTH);
    }

    public VentanaCalculadora() {
        super();
        inicializar();
        setTitle(this.title);
        setSize(this.width, this.height);
        setResizable(this.resizable);

    }

    private JPanel crearPanelDisplay() {
        JPanel panelContenido = new JPanel();

        this.boxText.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
        this.boxText.setBackground(Color.WHITE);
        this.boxText.setFont(new Font("Arial", 1, 25));
        this.boxText.setHorizontalAlignment(SwingConstants.RIGHT);
        this.boxText.setEditable(false);

        panelContenido.add(this.boxText);

        return panelContenido;
    }

    private JButton[] digitsButtonsMaker() {
        for (int n = 0; n < this.digitsButtons.length; n++) {
            this.digitsButtons[n] = new JButton(String.valueOf(n));
        }

        return this.digitsButtons;
    }

    private JButton[] operationsButtonsMaker() {
        this.operationsButtons[0] = new JButton("+");
        this.operationsButtons[1] = new JButton("-");
        this.operationsButtons[2] = new JButton("x");
        this.operationsButtons[3] = new JButton("÷");

        return this.operationsButtons;
    }

    private JPanel crearPanelClear() {
        JPanel panelContenido = new JPanel();
        panelContenido.setLayout(new FlowLayout(FlowLayout.RIGHT));

        //this.clearButton.setBorderPainted(false);
        //this.clearButton.setBackground(Color.red);
        this.clearButton.setForeground(Color.red);
        //this.clearButton.setOpaque(true);
        panelContenido.add(this.clearButton);

        return panelContenido;
    }

    private JPanel crearPanelTeclas() {
        JPanel panelContenido = new JPanel();

        panelContenido.setLayout(new GridLayout(4, 4, 0, 0));

        panelContenido.add(this.digitsButtons[7]);
        panelContenido.add(this.digitsButtons[8]);
        panelContenido.add(this.digitsButtons[9]);
        panelContenido.add(this.operationsButtons[3]);
        panelContenido.add(this.digitsButtons[4]);
        panelContenido.add(this.digitsButtons[5]);
        panelContenido.add(this.digitsButtons[6]);
        panelContenido.add(this.operationsButtons[2]);
        panelContenido.add(this.digitsButtons[1]);
        panelContenido.add(this.digitsButtons[2]);
        panelContenido.add(this.digitsButtons[3]);
        panelContenido.add(this.operationsButtons[1]);
        panelContenido.add(this.digitsButtons[0]);
        panelContenido.add(this.decimalButton);
        panelContenido.add(this.equalButton);
        panelContenido.add(this.operationsButtons[0]);

        return panelContenido;

    }

    @Override
    public void setDisplay(String s) {
        this.boxText.setText(s);
    }

    @Override
    public String getDisplay() {
        return this.boxText.getText();
    }

    @Override
    public void addOyenteTeclaDigito(int digito, ActionListener l) {
        this.digitsButtons[digito].addActionListener(l);
    }

    @Override
    public void addOyenteTeclaDecimal(ActionListener l) {
        this.decimalButton.addActionListener(l);
    }

    @Override
    public void addOyenteTeclaMas(ActionListener l) {
        for (JButton item : this.operationsButtons) {
            if (item.getText() == "+") {
                item.addActionListener(l);
            }
        }
    }

    @Override
    public void addOyenteTeclaMenos(ActionListener l) {
        for (JButton item : this.operationsButtons) {
            if (item.getText() == "-") {
                item.addActionListener(l);
            }
        }
    }

    @Override
    public void addOyenteTeclaPor(ActionListener l) {
        for (JButton item : this.operationsButtons) {
            if (item.getText() == "x") {
                item.addActionListener(l);
            }
        }
    }

    @Override
    public void addOyenteTeclaDiv(ActionListener l) {
        for (JButton item : this.operationsButtons) {
            if (item.getText() == "÷") {
                item.addActionListener(l);
            }
        }
    }

    @Override
    public void addOyenteTeclaIgual(ActionListener l) {
        this.equalButton.addActionListener(l);
    }

    @Override
    public void addOyenteTeclaClear(ActionListener l) {
        this.clearButton.addActionListener(l);
    }
}