
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SomaDiferenca extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JPanel pnlBotoes = null;
    private JButton btnCalcular = null;
    private JPanel pnlEntrada = null;
    private JLabel lblPrimeiroNumero = null;
    private JTextField txtPrimeiroNumero = null;
    private JLabel lblSegundoNumero = null;
    private JTextField txtSegundoNumero = null;   
    private JLabel lblResultado = null;
     
    
    private JPanel getPnlBotoes() {
        if (pnlBotoes == null) {
            lblResultado = new JLabel();
            lblResultado.setText("Resultado da soma = ");
            pnlBotoes = new JPanel();
            pnlBotoes.setLayout(new BoxLayout(pnlBotoes, BoxLayout.Y_AXIS));
            pnlBotoes.add(getBtnCalcular(), null);
            pnlBotoes.add(lblResultado, null);
        }
        return pnlBotoes;
    }

    private JButton getBtnCalcular() {
        if (btnCalcular == null) {
            btnCalcular = new JButton();
            btnCalcular.setText("Somar");
            btnCalcular.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    try {
                        int n1 = Integer.parseInt(getTxtPrimeiroNumero().getText());
                        int n2 = Integer.parseInt(getTxtSegundoNumero().getText());
                        int resultado = 0;
                        
                        resultado = n1 + n2;
                       
                        lblResultado.setText("Resultado da soma = " + resultado);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(SomaDif.this, ex.getMessage(),
                            "Erro na conversão para int - formato inválido", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        }
        return btnCalcular;
    }    
      	     	
  
    private JPanel getPnlEntrada() {
        if (pnlEntrada == null) {
            lblSegundoNumero = new JLabel();
            lblSegundoNumero.setText("Número 2 ");
            lblPrimeiroNumero = new JLabel();
            lblPrimeiroNumero.setText("Número 1 ");
            GridLayout gridLayout = new GridLayout();
            gridLayout.setRows(2);
            gridLayout.setColumns(2);
            pnlEntrada = new JPanel();
            pnlEntrada.setLayout(gridLayout);
            pnlEntrada.add(lblPrimeiroNumero, null);
            pnlEntrada.add(getTxtPrimeiroNumero(), null);
            pnlEntrada.add(lblSegundoNumero, null);
            pnlEntrada.add(getTxtSegundoNumero(), null);
        }
        return pnlEntrada;
    }

    private JTextField getTxtPrimeiroNumero() {
        if (txtPrimeiroNumero == null) {
            txtPrimeiroNumero = new JTextField();
        }
        return txtPrimeiroNumero;
    }

    private JTextField getTxtSegundoNumero() {
        if (txtSegundoNumero == null) {
            txtSegundoNumero = new JTextField();
        }
        return txtSegundoNumero;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	SomaDif thisClass = new SomaDif();
                thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                thisClass.setVisible(true);
            }
        });
    }

    public Soma() {
        super();
        initialize();
    }

    private void initialize() {
        this.setSize(300, 200);
        this.setContentPane(getJContentPane());
        this.setTitle("Calculadora");
    }

    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(new BorderLayout());
            jContentPane.add(getPnlEntrada(), BorderLayout.NORTH);
            jContentPane.add(getPnlBotoes(), BorderLayout.SOUTH);
        }
        return jContentPane;
    }

}
