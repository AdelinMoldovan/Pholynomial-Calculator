
import java.util.ArrayList;

public class Polinom {
    private ArrayList<Monom> lista;

    public Polinom() {
        this.lista = new ArrayList<Monom>();
    }

    public ArrayList<Monom> getLista() {
        return lista;
    }

    public void insertMonom(Monom m) {
        this.lista.add(m);
    }

    public Polinom inmultireCuUnMonom(Monom m) {
        Polinom P = new Polinom();
        for(Monom mon: this.lista) {
            P.insertMonom(new Monom(mon.getPuterea() + m.getPuterea(), mon.getCoefificentul() * m.getCoefificentul()));
        }
        return P;
    }
    @Override
    public String toString() {
        if(this.lista.isEmpty()) return "0";
        String s = "";
        int ok = 0;
        for (Monom aux : this.lista) {
            if (aux.getCoefificentul() != 0) {
                if (aux.getCoefificentul() < 0.0) {
                    s += aux + " ";
                }
                if (aux.getCoefificentul() > 0.0) {
                    if (ok == 1) s += "+ " + aux + " ";
                    else s += aux + " ";
                }
            }
            ok = 1;
        }
        return s;
    }
}
