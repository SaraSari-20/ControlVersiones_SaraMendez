/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 *
 * @author practicante
 */
public class calculadora extends JFrame implements ActionListener{
    private double primerNumero = 0, segundoNumero = 0;
    private String operacion = "";
    private boolean nuevaOperacion = true;
    private double resultado = 0;
    
    private Container contenedor;
    private JTextField campoResultado;
    private JButton cero,uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,division, multiplicacion,resta,suma,punto,igual
            ,eliminar,retroceder;
    
    
    private calculadora(){
        setSize(450, 600);
        setTitle("Calculadora");
        setLocationRelativeTo(null);
        setResizable(false);
        inicio();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void inicio(){
        contenedor = getContentPane();
        contenedor.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
    }
}
