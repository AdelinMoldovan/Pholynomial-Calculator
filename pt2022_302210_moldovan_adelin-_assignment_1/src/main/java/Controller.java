
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller implements ActionListener{


    private final View view;
    public Controller(View v){
        this.view = v;
    }

    public Polinom extrageValoarePolinom(int label) {
        String polinom = "";
        if(label == 1) {
            polinom = view.getPolinomul1().getText();
        }
        else if(label == 2) {
            polinom = view.getPolinomul2().getText();
        }
        if(((polinom.lastIndexOf('x') != polinom.lastIndexOf('^') - 1) && (polinom.contains("x"))) || (polinom.charAt(polinom.lastIndexOf('^')+1) == ' ') || ((polinom.contains("x")) && !polinom.contains("^"))){
            polinom = polinom.substring(0, polinom.lastIndexOf('x')+1) + "1x" + polinom.substring(polinom.lastIndexOf('x')+1);
        }
        if(polinom.charAt(0) == 'x') {
            polinom = '1' + polinom;
        }
        for(int i = 0; i < polinom.length(); i++){
            if(polinom.charAt(i) == ' ' && polinom.charAt(i+1) == 'x') {
                polinom = polinom.substring(0, i+1) + '1' + polinom.substring(i+1);
            }
        }
        for(int i = 0; i < polinom.length(); i++) {
            if(polinom.charAt(i) == '-' && polinom.charAt(i+1) == ' ') {
                polinom = polinom.substring(0, i + 1) + polinom.substring(i + 2);
            }
        }
        if(polinom.charAt(polinom.length() - 1) <= '9' && polinom.charAt(polinom.length() - 1) >= '0') {
            polinom = polinom + " 0";
        }
        String[] aux1 = polinom.split("[^0-9-]+");
        Polinom pol = new Polinom();
        Monom mon = new Monom(0, 0.0);

        boolean ok = false;
        for(String sirMon: aux1) {
            if(!ok) {
                mon.setCoeficientul(Integer.parseInt(sirMon));
                ok = true;
            }else {
                mon.setPuterea(Integer.parseInt(sirMon));
                ok = false;
                Monom auxM = new Monom(mon.getPuterea(), mon.getCoefificentul());
                pol.insertMonom(auxM);
            }
        }
        return pol ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object sursa = e.getSource();
        Operatii operatii = new Operatii();
        if(sursa == view.getButonOperatieAdunare()) {
            Polinom pol1 = extrageValoarePolinom(1);
            Polinom pol2 = extrageValoarePolinom(2);
            Polinom aux = operatii.adunare(pol1, pol2);
            this.view.getPolinomFinal().setText(aux.toString());
        }
        if(sursa == view.getButonOperatieScadere()) {
            Polinom pol1 = extrageValoarePolinom(1);
            Polinom pol2 = extrageValoarePolinom(2);
            Polinom aux = operatii.scadere(pol1, pol2);
            this.view.getPolinomFinal().setText(aux.toString());
        }
        if(sursa == view.getButonOperatieInmultire()) {
            Polinom pol1 = extrageValoarePolinom(1);
            Polinom pol2 = extrageValoarePolinom(2);
            Polinom aux = operatii.inmultire(pol1, pol2);
            this.view.getPolinomFinal().setText(aux.toString());
        }
       /* if(sursa == view.getButonOperatieImpartire()) {
            Polinom pol1 = extrageValoare(1);
            Polinom pol2 = extrageValoare(2);
            Impartirea rez = operatii.impartire(pol1, pol2);
            this.view.getPolinomFinal().setText(rez.toString());
        }*/
        if(sursa == view.getButonOperatieDerivare()) {
            Polinom pol = extrageValoarePolinom(1);
            Polinom aux = operatii.derivare(pol);
            this.view.getPolinomFinal().setText(aux.toString());
        }
        if(sursa == view.getButonOperatieIntegrare()) {
            Polinom pol = extrageValoarePolinom(1);
            Polinom aux = operatii.integrare(pol);
            this.view.getPolinomFinal().setText(aux.toString() + " + C");
        }
    }

}
