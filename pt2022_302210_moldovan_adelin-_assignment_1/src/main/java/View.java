import javax.swing.*;
import java.io.Serial;


public class View extends JFrame{

    @Serial
    private static final long serialVersionUID = 1L;
    private final JButton butonOperatieAdunare = new JButton("Adunare " + "+");
    private final JButton butonOperatieScadere = new JButton("Scădere " + "-");
    private final JButton butonOperatieInmultire = new JButton("înmulțire " + "*");
    private final JButton butonOperatieImpartire = new JButton("Împărțire " + "/");
    private final JButton butonOperatieDerivare = new JButton("Derivare " + "(polinom)' ");
    private final JButton butonOperatieIntegrare = new JButton("Integrare " + "f ( )dx");
    private final JTextField polinomul1 = new JTextField(50);
    private final JTextField polinomul2 = new JTextField(50);
    private final JTextField polinomFinal = new JTextField(50);

    Controller control= new Controller(this);

    public View(String nume) {
        super(nume);
        butonOperatieAdunare.addActionListener(control);
        butonOperatieScadere.addActionListener(control);
        butonOperatieInmultire.addActionListener(control);
        butonOperatieImpartire.addActionListener(control);
        butonOperatieDerivare.addActionListener(control);
        butonOperatieIntegrare.addActionListener(control);
        polinomul1.setEditable(true);
        polinomul2.setEditable(true);
        polinomFinal.setEditable(false);

        JPanel Panel1 = new JPanel();
        JLabel label1 = new JLabel("Polinomul 1: ");
        Panel1.add(label1);
        Panel1.add(polinomul1);

        JPanel Panel2 = new JPanel();
        JLabel label2 = new JLabel("Polinomul 2: ");
        Panel2.add(label2);
        Panel2.add(polinomul2);

        JPanel Panel3 =new JPanel();
        Panel3.add(butonOperatieAdunare);
        Panel3.add(butonOperatieScadere);
        Panel3.add(butonOperatieInmultire);
        Panel3.add(butonOperatieImpartire);
        Panel3.add(butonOperatieDerivare);
        Panel3.add(butonOperatieIntegrare);

        JPanel Panel4 = new JPanel();
        JLabel label3 = new JLabel("Rezultatul Operației: ");
        Panel4.add(label3);
        Panel4.add(polinomFinal);

        JPanel panel = new JPanel();
        panel.add(Panel1);
        panel.add(Panel2);
        panel.add(Panel3);
        panel.add(Panel4);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.add(panel);
    }

    public JTextField getPolinomul1() {
        return polinomul1;
    }
    public JTextField getPolinomul2() {
        return polinomul2;
    }
    public  JTextField getPolinomFinal() {
        return polinomFinal;
    }
    public JButton getButonOperatieAdunare() {
        return butonOperatieAdunare;
    }
    public JButton getButonOperatieScadere() {
        return butonOperatieScadere;
    }
    public JButton getButonOperatieInmultire() {
        return butonOperatieInmultire;
    }
   /* public JButton getButonOperatieImpartire() {

        return butonOperatieImpartire;
    }*/
    public JButton getButonOperatieDerivare() {
        return butonOperatieDerivare;
    }
    public JButton getButonOperatieIntegrare() {
        return butonOperatieIntegrare;
    }

}
