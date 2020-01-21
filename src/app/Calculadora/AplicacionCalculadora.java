package app.Calculadora;
import app.Calculadora.View.VentanaCalculadora;
import app.Calculadora.View.Interfaces.VistaCalculadora;
import app.Calculadora.Model.Calculadora;
import app.Calculadora.Model.Interfaces.ModeloCalculadora;
import app.Calculadora.Controller.ControladorCalculadora;


public class AplicacionCalculadora
{
    public static void main(String[] args) throws Exception {
        VistaCalculadora vista = new VentanaCalculadora();
        ModeloCalculadora modelo = new Calculadora();
        ControladorCalculadora controlador = new ControladorCalculadora(modelo, vista);
        // vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setVisible(true);
    }
}