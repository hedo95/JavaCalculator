package app.Calculadora.Controller;

import app.Calculadora.View.Interfaces.VistaCalculadora;
import app.Calculadora.Model.Interfaces.ModeloCalculadora;
import app.Calculadora.Model.*;
import java.awt.event.*;

public class ControladorCalculadora {
    ModeloCalculadora modelo;
    VistaCalculadora vista;

    boolean decimal = false, editando = true;

    public ControladorCalculadora(ModeloCalculadora modelo, VistaCalculadora vista) {
        this.modelo = modelo;
        this.vista = vista;

        this.vista.addOyenteTeclaClear(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                teclaClearPulsada();
            }
        });

        this.vista.addOyenteTeclaMas(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                teclaMasPulsada();
            }
        });

        this.vista.addOyenteTeclaMenos(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                teclaMenosPulsada();
            }
        });

        this.vista.addOyenteTeclaPor(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                teclaPorPulsada();
            }
        });

        this.vista.addOyenteTeclaDiv(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                teclaDivPulsada();
            }
        });

        this.vista.addOyenteTeclaIgual(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                teclaIgualPulsada();
            }
        });

        for (int n = 0; n < 10; n++) {
            int digit = n;
            this.vista.addOyenteTeclaDigito(digit, new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    teclaDigitoPulsada(String.valueOf(digit));
                }
            });
        }

        this.vista.addOyenteTeclaDecimal(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                teclaDecimalPulsada();
            }
        });
    }

    protected void teclaMasPulsada() {
        editando = false;
        decimal = true;
        Suma suma = new Suma();
        String display = vista.getDisplay();
        double digit = new Double(display);
        modelo.nuevoOperando(digit);
        modelo.nuevaOperacion(suma);
    }

    protected void teclaMenosPulsada() {
        editando = false;
        decimal = true;
        Resta resta = new Resta();
        String display = vista.getDisplay();
        double digit = new Double(display);
        modelo.nuevoOperando(digit);
        modelo.nuevaOperacion(resta);
    }

    protected void teclaPorPulsada() {
        editando = false;
        decimal = true;
        Multiplicacion multiplicacion = new Multiplicacion();
        String display = vista.getDisplay();
        double digit = new Double(display);
        modelo.nuevoOperando(digit);
        modelo.nuevaOperacion(multiplicacion);
    }

    protected void teclaDivPulsada() {
        editando = false;
        decimal = true;
        Division division = new Division();
        String display = vista.getDisplay();
        double digit = new Double(display);
        modelo.nuevoOperando(digit);
        modelo.nuevaOperacion(division);
    }

    protected void teclaIgualPulsada() {
        modelo.nuevoOperando(Double.valueOf(vista.getDisplay()));
        double result = modelo.getResultado();
        if(result % 1 == 0){
            vista.setDisplay(String.valueOf((int)result));
        } else {
            vista.setDisplay(String.valueOf(result));
        }
        decimal = true;
        editando = false;
        modelo.clear();
    }

    protected void teclaClearPulsada() {
        modelo.clear();
        decimal = false;
        vista.setDisplay(String.valueOf((int)modelo.getResultado()));
    }

    protected void teclaDigitoPulsada(String digito) {
        if (editando) {
            if (vista.getDisplay().equals("0")) {
                vista.setDisplay(digito);
            } else {
                vista.setDisplay(vista.getDisplay() + digito);
            }
        } else {
            vista.setDisplay(digito);
            editando = true;
        }
        checkingDecimal(vista.getDisplay());
    }

    protected void teclaDecimalPulsada() {
        if (!decimal) {
            String digit = vista.getDisplay();
            digit += ".";
            vista.setDisplay(digit);
            decimal = true;
        }
    }

    protected void checkingDecimal(String display){
        if(display.contains(".")){
            decimal = true;
        } else {
            decimal = false;
        }
    }

}