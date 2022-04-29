
public class Monom implements Comparable{
    private int puterea;
    private double coeficientul;

    public Monom(int puterea, double coeficientul) {
        super();
        this.puterea = puterea;
        this.coeficientul = coeficientul;
    }

    public int getPuterea() {
        return puterea;
    }
    public void setPuterea(int puterea) {
        this.puterea = puterea;
    }
    public double getCoefificentul() {
        return coeficientul;
    }
    public void setCoeficientul(double coeficientul) {
        this.coeficientul = coeficientul;
    }

    @Override
    public String toString() {
        if(coeficientul != -1 && coeficientul != 1 && coeficientul != 0) {
            if(puterea == 0){
                return " " + coeficientul + "";
            }
            else if(puterea == 1) {
                return coeficientul + "x";
            }
            else {
                return coeficientul + "x^" + puterea;
            }
        }else if(coeficientul == -1) {
            if(puterea == 0){
                return "- 1.0";
            }
            else if(puterea == 1) {
                return "- x";
            }
            else {
                return "- x^" + puterea;
            }
        }else if(coeficientul == 1) {
            if(puterea == 0) {
                return " 1.0";
            }
            else if(puterea == 1){
                return "x";
            }
            else {
                return "x^" + puterea;
            }
        }else {
            return "";
        }
    }
    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        return -Integer.compare(puterea, ((Monom) o).puterea);
    }
    /* public void display() {
        System.out.println(this.getCoefificentul() + "x^" + this.getPuterea());
    }*/
}
