package app.Calculadora.Model;

import app.Calculadora.Model.Interfaces.ModeloCalculadora;
import app.Calculadora.Model.Interfaces.OperadorBinario;


public class Calculadora implements ModeloCalculadora {
    double result;
    OperadorBinario operation;

    public Calculadora() {
        clear();
    }

    @Override
    public void clear() {
        this.result = 0;
        this.operation = null;
    }

    @Override
    public double getResultado() {
        return this.result;
    }

    @Override
    public void nuevaOperacion(OperadorBinario operacion) {
        this.operation = operacion;
    }

    @Override
    public void nuevoOperando(double operando) {
        if (this.result == 0) {
            this.result = operando;
        } else {
            this.result = this.operation.ejecutar(this.result, operando);
        }
    }
}