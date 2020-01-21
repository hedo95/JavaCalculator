package app.Calculadora.Model.Interfaces;

public interface ModeloCalculadora 
{
    public void clear();
    public double getResultado();
    public void nuevaOperacion(OperadorBinario operacion);
    public void nuevoOperando(double operando);
}