import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextField txtAnio;
    private JComboBox cboMarcaModelo;
    private JButton btnAgregar;
    private JTextArea txtListado;
    private JButton btnPagar;
    ListadoAutos coleccion=new ListadoAutos();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Ventana() {

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int anio = Integer.parseInt(txtAnio.getText());
                //String modelo= cboMarcaModelo.getSelectedItem().toString();
                // Y en Auto() poner modelo, anio
                if (anio < 1900 || anio > 2024) {
                    JOptionPane.showMessageDialog(null, "Ingrese un año entre 1991 y 2024");
                } else {
                    coleccion.encolar(new Auto(cboMarcaModelo.getSelectedItem().toString(), anio));
                    txtListado.setText(coleccion.listarAutos());
                }
            }
        });
        btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    JOptionPane.showMessageDialog(null, "Valor a pagar: "+ coleccion.desencolar().valorPago());
                    txtListado.setText(coleccion.listarAutos());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });


    }
}
