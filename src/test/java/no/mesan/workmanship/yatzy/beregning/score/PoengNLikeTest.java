package no.mesan.workmanship.yatzy.beregning.score;

import org.junit.Test;

import no.mesan.workmanship.yatzy.beregning.score.PoengNLike;
import no.mesan.workmanship.yatzy.domene.Poeng;
import no.mesan.workmanship.yatzy.domene.TestKast;
import no.mesan.workmanship.yatzy.poeng.SpesialPoeng;

import static no.mesan.workmanship.yatzy.domene.TestTerning._1;
import static no.mesan.workmanship.yatzy.domene.TestTerning._2;
import static no.mesan.workmanship.yatzy.domene.TestTerning._3;
import static no.mesan.workmanship.yatzy.domene.TestTerning._4;
import static no.mesan.workmanship.yatzy.domene.TestTerning._5;

import static org.junit.Assert.assertEquals;

public class PoengNLikeTest {
    private static final TestKast TOERE= new TestKast(_2, _2, _2, _2, _2);
    private static final TestKast BLANDINGS= new TestKast(_2, _5, _2, _5, _2);
    private static final TestKast STRAIGHT= new TestKast(_1, _2, _3, _4, _5);

    @Test
    public void yatzy_2_gir_4_i_par() {
        assertEquals(new Poeng(4), PoengNLike.P_PAR.beregnPoengForKast(TOERE));
    }

    @Test
    public void yatzy_2_gir_6_i_3_like() {
        assertEquals(new Poeng(6), PoengNLike.P_3_LIKE.beregnPoengForKast(TOERE));
    }

    @Test
    public void yatzy_2_gir_8_i_4_like() {
        assertEquals(new Poeng(8), PoengNLike.P_4_LIKE.beregnPoengForKast(TOERE));
    }

    @Test
    public void yatzy_2_gir_8_i_2_par() {
        assertEquals(new Poeng(8), PoengNLike.P_2_PAR.beregnPoengForKast(TOERE));
    }

    @Test
    public void straight_gir_0_i_2_par_og_hus() {
        assertEquals(Poeng.NULL_POENG, PoengNLike.P_2_PAR.beregnPoengForKast(STRAIGHT));
        assertEquals(Poeng.NULL_POENG, PoengNLike.P_HUS.beregnPoengForKast(STRAIGHT));
    }

    @Test
    public void yatzy_2_gir_50_poeng() {
        assertEquals(SpesialPoeng.YATZY_POENG.poeng,
                     PoengNLike.P_YATZY.beregnPoengForKast(TOERE));
    }

    @Test
    public void velger_hoyeste_par() {
        assertEquals(new Poeng(10), PoengNLike.P_PAR.beregnPoengForKast(BLANDINGS));
    }

    @Test
    public void ikke_4_like_eller_yatzy() {
        assertEquals(Poeng.NULL_POENG, PoengNLike.P_4_LIKE.beregnPoengForKast(BLANDINGS));
        assertEquals(Poeng.NULL_POENG, PoengNLike.P_YATZY.beregnPoengForKast(BLANDINGS));
    }
}
