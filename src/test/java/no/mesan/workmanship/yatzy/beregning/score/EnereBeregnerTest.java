package no.mesan.workmanship.yatzy.beregning.score;

import no.mesan.workmanship.yatzy.beregning.KastBeregner;
import org.junit.Test;

import no.mesan.workmanship.yatzy.domene.Poeng;
import no.mesan.workmanship.yatzy.domene.TestKast;

import static no.mesan.workmanship.yatzy.domene.TestTerning.*;

import static org.junit.Assert.assertEquals;

public class EnereBeregnerTest {
    @Test
    public void skalGiNullPoengForKastUtenEnere() throws Exception {
        final KastBeregner beregner = PoengOverStreken.P_1;

        final TestKast kastUtenEnere= new TestKast(_2, _5, _2, _5, _2);
        final Poeng kastVerdi = beregner.beregnPoengForKast(kastUtenEnere);
        assertEquals(0, kastVerdi.asInt());
    }
}
