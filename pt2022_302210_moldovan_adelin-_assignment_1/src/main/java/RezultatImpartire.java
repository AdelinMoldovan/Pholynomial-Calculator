
public class RezultatImpartire {
    Polinom catul;
    Polinom restul;

    public RezultatImpartire() {
        super();
        this.catul = new Polinom();
        this.restul = new Polinom();
    }

   /* public Polinom getCatul() {
        return catul;
    }
    public void setCatul(Polinom catul) {
        this.catul = catul;
    }
    public Polinom getRestul() {
        return restul;
    }*/
    public void setRestul(Polinom restul) {

        this.restul = restul;
    }

    @Override
    public String toString() {
        return "Câtul împărțirii este: " + catul.toString() + "; Restul împărțirii este: " + restul.toString();
    }
}
