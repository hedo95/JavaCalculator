package app.Calculadora.Model;
import app.Calculadora.Model.Interfaces.OperadorBinario;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Multiplicacion implements OperadorBinario
{
    @Override
    public double ejecutar(double x, double y)
    {
        return x * y;
    }
}