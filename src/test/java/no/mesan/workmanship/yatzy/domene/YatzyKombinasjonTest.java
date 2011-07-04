package no.mesan.workmanship.yatzy.domene;

import org.junit.Test;

import no.mesan.workmanship.yatzy.poeng.SpesialPoeng;

import static no.mesan.workmanship.yatzy.domene.TestTerning._1;
import static no.mesan.workmanship.yatzy.domene.TestTerning._2;
import static no.mesan.workmanship.yatzy.domene.TestTerning._3;
import static no.mesan.workmanship.yatzy.domene.TestTerning._4;
import static no.mesan.workmanship.yatzy.domene.TestTerning._5;
import static no.mesan.workmanship.yatzy.domene.TestTerning._6;

import static org.junit.Assert.assertEquals;

public class YatzykombinasjonTest {
    private static final TestKast LITEN_STRAIGHT= new TestKast(_1, _2, _3, _4, _5);
    private static final TestKast STOR_STRAIGHT= new TestKast(_6, _2, _3, _4, _5);
    private static final TestKast STRAIGHT= LITEN_STRAIGHT;
    private static final TestKast HUS= new TestKast(_2, _3, _3, _2, _2);
    private static final TestKast YATZY= new TestKast(_2, _2, _2, _2, _2);
    private static final TestKast TOERE= YATZY;
    private static final TestKast BLANDINGS= new TestKast(_2, _5, _2, _5, _2);

    @Test
    public void riktigVisningsnavn() throws Exception {
        assertEquals("Liten straight", Yatzykombinasjon.LITEN_STRAIGHT.toString());
    }

    @Test
    public void yatzy_2_gir_4_i_par() {
        assertEquals(new Poeng(4), Yatzykombinasjon.PAR.beregnPoengForKast(TOERE));
    }

    @Test
    public void yatzy_2_gir_6_i_3_like() {
        assertEquals(new Poeng(6), Yatzykombinasjon.TRE_LIKE.beregnPoengForKast(TOERE));
    }

    @Test
    public void yatzy_2_gir_8_i_4_like() {
        assertEquals(new Poeng(8), Yatzykombinasjon.FIRE_LIKE.beregnPoengForKast(TOERE));
    }

    @Test
    public void yatzy_2_gir_8_i_2_par() {
        assertEquals(new Poeng(8), Yatzykombinasjon.TO_PAR.beregnPoengForKast(TOERE));
    }

    @Test
    public void yatzy_2_gir_50_poeng() {
        assertEquals(SpesialPoeng.YATZY_POENG.poeng,
                     Yatzykombinasjon.YATZY.beregnPoengForKast(TOERE));
    }

    @Test
    public void velger_hoyeste_par() {
        assertEquals(new Poeng(10), Yatzykombinasjon.PAR.beregnPoengForKast(BLANDINGS));
    }

    @Test
    public void ikke_4_like_eller_yatzy() {
        assertEquals(Poeng.NULL_POENG, Yatzykombinasjon.FIRE_LIKE.beregnPoengForKast(BLANDINGS));
        assertEquals(Poeng.NULL_POENG, Yatzykombinasjon.YATZY.beregnPoengForKast(BLANDINGS));
    }

    @Test
    public void ingen_enere_gir_0() {
        assertEquals(Poeng.NULL_POENG, Yatzykombinasjon.ENERE.beregnPoengForKast(TOERE));
    }

    @Test
    public void bare_toere_gir_10() {
        assertEquals(new Poeng(10), Yatzykombinasjon.TOERE.beregnPoengForKast(TOERE));
    }

    @Test
    public void blandings_gir_10() {
        assertEquals(new Poeng(10), Yatzykombinasjon.FEMMERE.beregnPoengForKast(BLANDINGS));
    }

    @Test
    public void testLitt() {
        assertEquals(new Poeng(15), Yatzykombinasjon.SJANSE.beregnPoengForKast(STRAIGHT));
        assertEquals(new Poeng(12), Yatzykombinasjon.SJANSE.beregnPoengForKast(HUS));
        assertEquals(new Poeng(10), Yatzykombinasjon.SJANSE.beregnPoengForKast(YATZY));
    }

    @Test
    public void liten()  {
        assertEquals(SpesialPoeng.LITEN_STRAIGHT_POENG.poeng,
                     Yatzykombinasjon.LITEN_STRAIGHT.beregnPoengForKast(LITEN_STRAIGHT));
    }

    @Test
    public void stor() {
        assertEquals(SpesialPoeng.STOR_STRAIGHT_POENG.poeng,
                     Yatzykombinasjon.STOR_STRAIGHT.beregnPoengForKast(STOR_STRAIGHT));
    }

    @Test
    public void ikke_stor_eller_liten()  {
        assertEquals(Poeng.NULL_POENG, Yatzykombinasjon.STOR_STRAIGHT.beregnPoengForKast(HUS));
        assertEquals(Poeng.NULL_POENG, Yatzykombinasjon.LITEN_STRAIGHT.beregnPoengForKast(HUS));
    }

    @Test
    public void ikke_omvendt()  {
        assertEquals(Poeng.NULL_POENG, Yatzykombinasjon.STOR_STRAIGHT.beregnPoengForKast(LITEN_STRAIGHT));
        assertEquals(Poeng.NULL_POENG, Yatzykombinasjon.LITEN_STRAIGHT.beregnPoengForKast(STOR_STRAIGHT));
    }

//    @Test
//    public void enereSkalBrukeEnereBeregner() {
//        final KastBeregner enereBeregner = Yatzykombinasjon.ENERE.kastBeregner;
//        assertTrue(enereBeregner instanceof EnereBeregner);
//    }

//    @Test
//    public void kombinasjonSkalDelegereTilFaktiskBeregner() {
//        final Kast kast = mock(Kast.class);
//        final KastBeregner beregner = mock(KastBeregner.class);
//        when(beregner.beregnPoengForKast(kast)).thenReturn(new Poeng(5));
//
//        final Yatzykombinasjon enere = Yatzykombinasjon.ENERE;
//        enere.setFaktiskBeregner(beregner);
//
//        final int beregnetVerdi = enere.beregnPoengForKast(kast);
//
//        assertEquals(5, beregnetVerdi);
//        verify(beregner).beregnPoengForKast(kast);
//    }
}
