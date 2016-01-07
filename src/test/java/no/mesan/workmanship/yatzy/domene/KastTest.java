package no.mesan.workmanship.yatzy.domene;

import org.junit.Ignore;
import org.junit.Test;

import static no.mesan.workmanship.yatzy.domene.TestTerning.*;
import static org.junit.Assert.assertEquals;

public class KastTest {

    @Test @Ignore
    public void dummy()  {
        for (int i= 0; i < 30; i++) {
            System.out.println(new Kast());
        }
    }

    @Test
    public void kastIterator_gir_5_terninger()  {
        final Kast kast= new Kast();
        int ant=0;
        for (@SuppressWarnings("unused") final Terning terning : kast) {
            ant++;
        }
        assertEquals(5, ant);
    }

    @Test
    public void holder_alle_gir_uendret_innhold_ved_nytt_kast() {
        final Kast kast= new Kast();
        final String foer= kast.toString();
        for (final Posisjon pos : Posisjon.values()) {
            kast.hold(true, pos);
        }
        kast.kast();
        assertEquals(foer, kast.toString());
    }

    @Test
    public void nyttKastSkalTaVarePaTerninger() throws Exception {
        final int[] verdier = {5, 2, 3, 1, 4};
        final Kast kast = new TestKast(_5,_2,_3,_1,_4);

        int i = 0;
        for (final Terning terning : kast) {
            assertEquals(verdier[i], terning.verdi().score);
            i++;
        }
    }
}
