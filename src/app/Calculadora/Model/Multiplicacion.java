package app.Calculadora.Model;
import app.Calculadora.Model.Interfaces.OperadorBinario;


public class Multiplicacion implements OperadorBinario
{
    @Override
    public double ejecutar(double x, double y)
    {
        return x * y;
    }
}