package app.Calculadora.Model.Interfaces;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public interface ModeloCalculadora 
{
    public void clear();
    public double getResultado();
    public void nuevaOperacion(OperadorBinario operacion);
    public void nuevoOperando(double operando);
}