
public class Operatii {
    public Polinom adunare(Polinom pol1, Polinom pol2) {
        Polinom pol3 = new Polinom();
        for(Monom m1: pol1.getLista()) {
            boolean ok = false;
            for(Monom m2: pol2.getLista()) {
                if(m1.getPuterea() == m2.getPuterea()) {
                    ok = true;
                    if(m1.getCoefificentul() + m2.getCoefificentul() != 0)pol3.insertMonom(new Monom(m1.getPuterea(), m1.getCoefificentul() + m2.getCoefificentul()));
                }
            }
            if(!ok) pol3.insertMonom(m1);
        }
        for(Monom m2: pol2.getLista()) {
            boolean ok = false;
            for(Monom m1: pol1.getLista()) {
                if (m2.getPuterea() == m1.getPuterea()) {
                    ok = true;
                    break;
                }
            }
            if(!ok) pol3.insertMonom(m2);
        }
        return pol3;
    }
    public Polinom scadere(Polinom pol1, Polinom pol2) {
        Polinom pol3 = new Polinom();
        for(Monom m1: pol1.getLista()) {
            boolean ok = false;
            for(Monom m2: pol2.getLista()) {
                if(m1.getPuterea() == m2.getPuterea()) {
                    ok = true;
                    if(m1.getCoefificentul() - m2.getCoefificentul() != 0)pol3.insertMonom(new Monom(m1.getPuterea(), m1.getCoefificentul() - m2.getCoefificentul()));
                }
            }
            if(!ok) pol3.insertMonom(m1);
        }
        for(Monom m2: pol2.getLista()) {
            boolean ok = false;
            for(Monom m1: pol1.getLista()) {
                if (m2.getPuterea() == m1.getPuterea()) {
                    ok = true;
                    break;
                }
            }
            if(!ok) pol3.insertMonom(new Monom(m2.getPuterea(),  -1*m2.getCoefificentul()));
        }
        return pol3;
    }
    public Polinom inmultire(Polinom pol1, Polinom pol2) {
        Polinom pol3 = new Polinom();
        boolean firstIn = false;
        for(Monom m: pol1.getLista()) {
            Polinom aux = pol2.inmultireCuUnMonom(m);
            if(!firstIn) {
                pol3 = aux;
                firstIn = true;
            }else pol3 = adunare(pol3, aux);
        }
        return pol3;
    }
   // public Impartirea impartire(Polinom pol1, Polinom pol2)

    public Polinom derivare(Polinom pol) {
        for (Monom aux : pol.getLista()) {
            aux.setCoeficientul(aux.getCoefificentul() * aux.getPuterea());
            aux.setPuterea(aux.getPuterea() - 1);
        }
        return pol;
    }
    public Polinom integrare(Polinom pol) {
        for (Monom aux : pol.getLista()) {
            aux.setCoeficientul(aux.getCoefificentul() / (aux.getPuterea()+ 1));
            aux.setPuterea(aux.getPuterea() + 1);
        }
        return pol;
    }

}
