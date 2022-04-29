import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OperatiiTest {
        public Operatii operatia=new Operatii();
        public Polinom pol1;
        public Polinom pol2;


        @BeforeEach
        public void setare() {

                this.pol1=new Polinom();
                pol1.insertMonom((new Monom(2, 3.0)));
                pol1.insertMonom((new Monom(1,4.0)));
                //polinomul 1 este: 3x^2+4x

                this.pol2=new Polinom();
                pol2.insertMonom((new Monom(1,2.0)));
                pol2.insertMonom((new Monom(0,8.0)));
                //polinomul 2 este: 2x+8

        }
        @Test
        public void testAdunare() {
                Polinom rezultat= new Polinom();
                rezultat.insertMonom(new Monom(2,3));
                rezultat.insertMonom(new Monom(1,6));
                rezultat.insertMonom((new Monom(0,8)));
                assertEquals(0, operatia.adunare(pol1, pol2).toString().compareTo(rezultat.toString()),
                        "Rezultatul adunării celor două polinoame este: 3.0x^2 + 6.0x + 8.0");

        }
        @Test
        public void testScadere() {
                Polinom rezultat= new Polinom();
                rezultat.insertMonom(new Monom(2,3.0));
                rezultat.insertMonom(new Monom(1,2.0));
                rezultat.insertMonom(new Monom(0,-8.0));
                assertEquals(0, operatia.scadere(pol1, pol2).toString().compareTo(rezultat.toString()),
                        "Rezultatul scăderii celor două polinoame este: 3.0x^2 + 2.0x - 8.0");

        }
        @Test
        public void testInmultire() {
                Polinom rezultat= new Polinom();
                rezultat.insertMonom(new Monom(3,6.0));
                rezultat.insertMonom(new Monom(2,32.0));
                rezultat.insertMonom(new Monom(1,32.0));
                assertEquals(0, operatia.inmultire(pol1, pol2).toString().compareTo(rezultat.toString()),
                        "Rezultatul înmulțirii celor două polinoame este: 6.0x^3 + 32.0x^2 + 32.0x");

        }
        @Test
        public void testDerivare() {
                Polinom rezultat= new Polinom();
                rezultat.insertMonom(new Monom(1,6.0));
                rezultat.insertMonom(new Monom(0,4.0));
                assertEquals(0, operatia.derivare(pol1).toString().compareTo(rezultat.toString()),
                        "Rezultatul derivării primului polinom este: 6.0x + 4.0");

        }
        @Test
        public void testIntegrare() {
                Polinom rezultat= new Polinom();
                rezultat.insertMonom(new Monom(3,1.0));
                rezultat.insertMonom(new Monom(2,2.0));
                assertEquals(0, operatia.integrare(pol1).toString().compareTo(rezultat.toString()),
                        "Rezultatul integrării primului polinom este: x^3 + 2.0x^2 + C ");

        }

}
