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
        c.insets = new Insets(3, 3, 3, 3);
        c.anchor = GridBagConstraints.CENTER;
        c.gridy = 0; c.gridx = 0;
        campoResultado = new JTextField("Resultado");
        campoResultado.setEditable(false);
        campoResultado.setForeground(Color.gray);
        campoResultado.setPreferredSize(new Dimension(300,50));
        campoResultado.setFont(new Font("Arial",Font.BOLD,18));
        contenedor.add(campoResultado,c);
        
        cero = new JButton("0");
        cero.setPreferredSize(new Dimension(70,70));
        uno = new JButton("1");
        uno.setPreferredSize(new Dimension(70,70));
        dos = new JButton("2");
        dos.setPreferredSize(new Dimension(70,70));
        tres = new JButton("3");
        tres.setPreferredSize(new Dimension(70,70));
        cuatro = new JButton("4");
        cuatro.setPreferredSize(new Dimension(70,70));
        cinco = new JButton("5");
        cinco.setPreferredSize(new Dimension(70,70));
        seis = new JButton("6");
        seis.setPreferredSize(new Dimension(70,70));
        siete = new JButton("7");
        siete.setPreferredSize(new Dimension(70,70));
        ocho = new JButton("8");
        ocho.setPreferredSize(new Dimension(70,70));
        nueve = new JButton("9");
        nueve.setPreferredSize(new Dimension(70,70));
        division = new JButton("/");
        division.setPreferredSize(new Dimension(70,70));
        multiplicacion = new JButton("x");
        multiplicacion.setPreferredSize(new Dimension(70,70));
        resta = new JButton("-");
        resta.setPreferredSize(new Dimension(70,70));
        suma = new JButton("+");
        suma.setPreferredSize(new Dimension(70,70));
        igual = new JButton("=");
        igual.setPreferredSize(new Dimension(70,70));
        punto = new JButton(".");
        punto.setPreferredSize(new Dimension(70,70));
        
        eliminar = new JButton("C");
        retroceder = new JButton("<x");
        eliminar.addActionListener(this);
        retroceder.addActionListener(this);
        eliminar.setPreferredSize(new Dimension(146,30));
        retroceder.setPreferredSize(new Dimension(146,30));
        
        
        cero.addActionListener(this);
        uno.addActionListener(this);
        dos.addActionListener(this);
        tres.addActionListener(this);
        cuatro.addActionListener(this);
        cinco.addActionListener(this);
        seis.addActionListener(this);
        siete.addActionListener(this);
        ocho.addActionListener(this);
        nueve.addActionListener(this);
        division.addActionListener(this);
        multiplicacion.addActionListener(this);
        resta.addActionListener(this);
        suma.addActionListener(this);
        igual.addActionListener(this);
        punto.addActionListener(this);
        
        JPanel panelBF1 = new JPanel();
        JPanel panelBF2 = new JPanel();
        JPanel panelBF3 = new JPanel();
        JPanel panelBF4 = new JPanel();
        JPanel panelBF5 = new JPanel();
        
        panelBF1.add(siete);
        panelBF1.add(ocho);
        panelBF1.add(nueve);
        panelBF1.add(division);
        
        panelBF2.add(cuatro);
        panelBF2.add(cinco);
        panelBF2.add(seis);
        panelBF2.add(multiplicacion);
        
        panelBF3.add(uno);
        panelBF3.add(dos);
        panelBF3.add(tres);
        panelBF3.add(resta);
        
        panelBF4.add(cero);
        panelBF4.add(punto);
        panelBF4.add(igual);
        panelBF4.add(suma);
        
        panelBF5.add(eliminar);
        panelBF5.add(retroceder);
        
        c.gridy = 1;
        contenedor.add(panelBF1,c);
        c.gridy = 2;
        contenedor.add(panelBF2,c);
        c.gridy = 3;
        contenedor.add(panelBF3,c);
        c.gridy = 4;
        contenedor.add(panelBF4,c);
        c.gridy = 5;
        contenedor.add(panelBF5,c);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object fuente = e.getSource();
        
        if(campoResultado.getText().equals("Resultado") || campoResultado.getText().equals("Error") || nuevaOperacion){
            campoResultado.setForeground(Color.black);
            campoResultado.setText("");
            nuevaOperacion = false;
        }
        
        String actual = campoResultado.getText();
        
        
        if (fuente == cero || fuente == uno || fuente == dos || fuente == tres || fuente == cuatro ||
            fuente == cinco || fuente == seis || fuente == siete || fuente == ocho || fuente == nueve || fuente == punto) {

            JButton boton = (JButton) fuente;
            campoResultado.setText(actual + boton.getText());
        }
        
        if (fuente == suma || fuente == resta || fuente == multiplicacion || fuente == division) {
            try {
                primerNumero = Double.parseDouble(campoResultado.getText());
                JButton boton = (JButton) fuente;
                operacion = boton.getText();
                nuevaOperacion = true;
            } catch (NumberFormatException ex) {
                campoResultado.setForeground(Color.gray);
                campoResultado.setText("Error");
            }
        }
        
        if (fuente == igual) {
            try {
                segundoNumero = Double.parseDouble(campoResultado.getText());

                switch (operacion) {
                    case "+": resultado = primerNumero + segundoNumero; break;
                    case "-": resultado = primerNumero - segundoNumero; break;
                    case "x": resultado = primerNumero * segundoNumero; break;
                    case "/": 
                        if (segundoNumero == 0) {
                            campoResultado.setText("No se puede dividir entre 0");
                            return;
                        }
                        resultado = primerNumero / segundoNumero;
                        break;
                }

                
                campoResultado.setText(String.valueOf(resultado));
                nuevaOperacion = true;
            } catch (Exception ex) {
                campoResultado.setForeground(Color.gray);
                campoResultado.setText("Error");
            }
            resultado = 0;
            primerNumero = 0;
            segundoNumero = 0;
        }
        
        if(e.getSource() == eliminar){
            primerNumero = 0;
            segundoNumero = 0;
            resultado = 0;
            operacion = "";
            nuevaOperacion = true;
            
            campoResultado.setForeground(Color.gray);
            campoResultado.setText("Resultado");
        }else if(e.getSource() == retroceder){
            actual = campoResultado.getText();
            
            if(actual.equals("Resultado") || actual.length() == 0){
                return;
            }
            
            if(actual.length() == 1){
                campoResultado.setForeground(Color.gray);
                campoResultado.setText("Resultado");
                nuevaOperacion = true;
                return;
            }
            
            String nuevoTexto = actual.substring(0,actual.length() - 1);
            campoResultado.setText(nuevoTexto);
        }
    }
    
    public static void main(String[] args) {
        calculadora cal = new calculadora();
        cal.setVisible(true);
    }
}
