package no.mesan.workmanship.yatzy.beregning.score;

import org.junit.Test;

import no.mesan.workmanship.yatzy.beregning.score.ResultatSett;
import no.mesan.workmanship.yatzy.domene.TerningPoeng;
import no.mesan.workmanship.yatzy.domene.TestKast;

import static no.mesan.workmanship.yatzy.domene.TestTerning.*;

import static org.junit.Assert.*;

public class ResultatSettTest {
    private static final TestKast STRAIGHT= new TestKast(_1, _2, _3, _4, _5);
    private static final TestKast TOERE= new TestKast(_2, _2, _2, _2, _2);

    @Test
    public void straight_gir_1_hver() {
        final ResultatSett res= new ResultatSett(STRAIGHT);
        for (final TerningPoeng tp : TerningPoeng.values()) {
            if ( tp.equals(_6.verdi()) ) continue;
            assertEquals(tp+"...", 1, res.count(tp));
        }
    }

    @Test
    public void yatzy2() {
        final ResultatSett res= new ResultatSett(TOERE);
        assertEquals(0, res.count(_1.verdi()));
        assertEquals(5, res.count(_2.verdi()));
    }

    @Test
    public void bruk_reduserer_med_1() {
        final ResultatSett res= new ResultatSett(STRAIGHT).bruk(_1.verdi(), 1);
        assertEquals(0, res.count(_1.verdi()));
    }

    @Test
    public void bruk_reduserer_med_2() {
        final ResultatSett res= new ResultatSett(STRAIGHT).bruk(_1.verdi(), 2);
        assertEquals(-1, res.count(_1.verdi()));
    }

    @Test
    public void bruk_reduserer_ubrukt_med_2() {
        final ResultatSett res= new ResultatSett(STRAIGHT).bruk(_6.verdi(), 2);
        assertEquals(-2, res.count(_6.verdi()));
    }
}
