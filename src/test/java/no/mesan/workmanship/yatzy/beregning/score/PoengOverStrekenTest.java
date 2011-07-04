package no.mesan.workmanship.yatzy.beregning.score;

import org.junit.Test;

import no.mesan.workmanship.yatzy.beregning.score.PoengOverStreken;
import no.mesan.workmanship.yatzy.domene.Poeng;
import no.mesan.workmanship.yatzy.domene.TestKast;

import static no.mesan.workmanship.yatzy.domene.TestTerning._2;
import static no.mesan.workmanship.yatzy.domene.TestTerning._5;

import static org.junit.Assert.assertEquals;

public class PoengOverStrekenTest {
    private static final TestKast TOERE= new TestKast(_2, _2, _2, _2, _2);
    private static final TestKast BLANDINGS= new TestKast(_2, _5, _2, _5, _2);

    @Test
    public void ingen_enere_gir_0() {
        assertEquals(Poeng.NULL_POENG, PoengOverStreken.P_1.beregnPoengForKast(TOERE));
    }

    @Test
    public void bare_toere_gir_10() {
        assertEquals(new Poeng(10), PoengOverStreken.P_2.beregnPoengForKast(TOERE));
    }

    @Test
    public void blandings_gir_10() {
        assertEquals(new Poeng(10), PoengOverStreken.P_5.beregnPoengForKast(BLANDINGS));
    }
}
