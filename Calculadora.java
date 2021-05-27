
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Calculadora extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JPanel pnlBotoes = null;
    private JButton btnCalcular = null;
    private JPanel pnlEntrada = null;
    private JLabel lblPrimeiroNumero = null;
    private JTextField txtPrimeiroNumero = null;
    private JLabel lblSegundoNumero = null;
    private JTextField txtSegundoNumero = null;
    private JPanel pnlCheckBoxes = null;
    private JRadioButton rdoAdicao = null;
    private JRadioButton rdoSubtracao = null;
    private JRadioButton rdoMultiplicacao = null;
    private JRadioButton rdoDivisao = null;
    private JLabel lblResultado = null;
    private ButtonGroup btgOperacoes = null;

    
    private JPanel getPnlBotoes() {
        if (pnlBotoes == null) {
            lblResultado = new JLabel();
            lblResultado.setText("Resultado:");
            pnlBotoes = new JPanel();
            pnlBotoes.setLayout(new FlowLayout());
            pnlBotoes.add(getBtnCalcular(), null);
            pnlBotoes.add(lblResultado, null);
        }
        return pnlBotoes;
    }

  
    private JButton getBtnCalcular() {
        if (btnCalcular == null) {
            btnCalcular = new JButton();
            btnCalcular.setText("Calcular");
            btnCalcular.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    try {
                        int n1 = Integer.parseInt(getTxtPrimeiroNumero().getText());
                        int n2 = Integer.parseInt(getTxtSegundoNumero().getText());
                        int resultado = 0;
                        if (getRdoAdicao().isSelected()) {
                            resultado = n1 + n2;
                        } else if (getRdoSubtracao().isSelected()) {
                            resultado = n1 - n2;
                        } else if (getRdoMultiplicacao().isSelected()) {
                            resultado = n1 * n2;
                        } else if (getRdoDivisao().isSelected()) {
                            resultado = n1 / n2;
                        }
                        lblResultado.setText("Resultado: " + resultado);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(CalculadoraFrame.this, ex.getMessage(),
                            "Erro na conversão para int - formato inválido", JOptionPane.ERROR_MESSAGE);
                    } catch (ArithmeticException ex) {
                        JOptionPane.showMessageDialog(CalculadoraFrame.this, ex.getMessage(), "Divisão por zero",
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        }
        return btnCalcular;
    }

  
    private JPanel getPnlEntrada() {
        if (pnlEntrada == null) {
            lblSegundoNumero = new JLabel();
            lblSegundoNumero.setText("Segundo número inteiro:");
            lblPrimeiroNumero = new JLabel();
            lblPrimeiroNumero.setText("Primeiro número inteiro:");
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

   
    private JPanel getPnlCheckBoxes() {
        if (pnlCheckBoxes == null) {
            pnlCheckBoxes = new JPanel();
            pnlCheckBoxes.setLayout(new BoxLayout(getPnlCheckBoxes(), BoxLayout.Y_AXIS));
            pnlCheckBoxes.add(getRdoAdicao(), null);
            pnlCheckBoxes.add(getRdoSubtracao(), null);
            pnlCheckBoxes.add(getRdoMultiplicacao(), null);
            pnlCheckBoxes.add(getRdoDivisao(), null);
            btgOperacoes = new ButtonGroup();
            btgOperacoes.add(getRdoAdicao());
            btgOperacoes.add(getRdoSubtracao());
            btgOperacoes.add(getRdoMultiplicacao());
            btgOperacoes.add(getRdoDivisao());
        }
        return pnlCheckBoxes;
    }

    private JRadioButton getRdoAdicao() {
        if (rdoAdicao == null) {
            rdoAdicao = new JRadioButton();
            rdoAdicao.setText("+ Adição");
        }
        return rdoAdicao;
    }


    private JRadioButton getRdoSubtracao() {
        if (rdoSubtracao == null) {
            rdoSubtracao = new JRadioButton();
            rdoSubtracao.setText("- Subtração");
        }
        return rdoSubtracao;
    }

  
    private JRadioButton getRdoMultiplicacao() {
        if (rdoMultiplicacao == null) {
            rdoMultiplicacao = new JRadioButton();
            rdoMultiplicacao.setText("X Multiplicação");
        }
        return rdoMultiplicacao;
    }

  
    private JRadioButton getRdoDivisao() {
        if (rdoDivisao == null) {
            rdoDivisao = new JRadioButton();
            rdoDivisao.setText("/ Divisão");
        }
        return rdoDivisao;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CalculadoraFrame thisClass = new CalculadoraFrame();
                thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                thisClass.setVisible(true);
            }
        });
    }

    public CalculadoraFrame() {
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
            jContentPane.add(getPnlCheckBoxes(), BorderLayout.CENTER);
            jContentPane.add(getPnlBotoes(), BorderLayout.SOUTH);
        }
        return jContentPane;
    }

}