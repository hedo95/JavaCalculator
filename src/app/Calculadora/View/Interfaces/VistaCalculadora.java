package app.Calculadora.View.Interfaces;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public interface VistaCalculadora
{
    public void setDisplay(String s);
    public String getDisplay();
    public void setVisible(boolean v);
    public void addOyenteTeclaDigito(int digito,ActionListener l);
    public void addOyenteTeclaDecimal(ActionListener l);
    public void addOyenteTeclaMas(ActionListener l);
    public void addOyenteTeclaMenos(ActionListener l);
    public void addOyenteTeclaPor(ActionListener l);
    public void addOyenteTeclaDiv(ActionListener l);
    public void addOyenteTeclaIgual(ActionListener l);
    public void addOyenteTeclaClear(ActionListener l);
}