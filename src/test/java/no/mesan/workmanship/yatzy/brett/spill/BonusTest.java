package no.mesan.workmanship.yatzy.brett.spill;

import org.junit.Before;
import org.junit.Test;

import no.mesan.workmanship.yatzy.brett.spill.Bonus;
import no.mesan.workmanship.yatzy.domene.Poeng;
import no.mesan.workmanship.yatzy.domene.TestKast;
import no.mesan.workmanship.yatzy.domene.YatzyBrett;
import no.mesan.workmanship.yatzy.poeng.SpesialPoeng;

import static no.mesan.workmanship.yatzy.domene.TestTerning.*;
import static no.mesan.workmanship.yatzy.domene.Yatzykombinasjon.*;

import static org.junit.Assert.assertEquals;

public class BonusTest {
    private static final Poeng BONUS= SpesialPoeng.BONUS_POENG.poeng;
    private static final TestKast[][] EN_TIL_TRE = {
            {new TestKast(_2, _1, _3, _2, _2),
             new TestKast(_1, _1, _3, _2, _2),
             new TestKast(_1, _1, _3, _2, _1)},
            {new TestKast(_2, _1, _3, _1, _1),
             new TestKast(_1, _1, _3, _2, _2),
             new TestKast(_2, _1, _3, _2, _2)},
            {new TestKast(_2, _1, _3, _2, _2),
             new TestKast(_1, _3, _3, _2, _2),
             new TestKast(_1, _3, _3, _3, _1)},
            {new TestKast(_2, _4, _3, _2, _2),
             new TestKast(_1, _1, _4, _4, _2),
             new TestKast(_4, _1, _3, _4, _4)},
            {new TestKast(_5, _1, _3, _2, _2),
             new TestKast(_5, _1, _5, _2, _2),
             new TestKast(_1, _1, _5, _5, _5)},
            {new TestKast(_2, _1, _3, _2, _6),
             new TestKast(_1, _1, _6, _6, _2),
             new TestKast(_6, _1, _6, _6, _1)}};

    private YatzyBrett ordinar;
    private YatzyBrett tvungen;

    @Before
    public void setUp() throws Exception {
        this.ordinar= new YatzyBrett(Bonus.ORDINAR);
        this.tvungen= new YatzyBrett(Bonus.TVUNGEN);
    }

    @Test
    public void akkurat_for_lite_til_tvungen_bonus() {
        this.tvungen.settPoeng(ENERE, EN_TIL_TRE[0][0]);
        this.tvungen.settPoeng(TOERE, EN_TIL_TRE[1][1]);
        this.tvungen.settPoeng(TREERE, EN_TIL_TRE[2][1]);
        this.tvungen.settPoeng(FIRERE, EN_TIL_TRE[3][1]);
        this.tvungen.settPoeng(FEMMERE, EN_TIL_TRE[4][1]);
        this.tvungen.settPoeng(SEKSERE, EN_TIL_TRE[5][1]);
        assertEquals(Poeng.NULL_POENG,  Bonus.TVUNGEN.beregn(this.tvungen));
        assertEquals(SpesialPoeng.TVUNGEN_BONUS.poeng.add(new Poeng(-1)),
                     this.tvungen.poeng());
    }

    @Test
    public void akkurat_nok_til_tvungen_bonus() {
        this.tvungen.settPoeng(ENERE, EN_TIL_TRE[0][1]);
        this.tvungen.settPoeng(TOERE, EN_TIL_TRE[1][1]);
        this.tvungen.settPoeng(TREERE, EN_TIL_TRE[2][1]);
        this.tvungen.settPoeng(FIRERE, EN_TIL_TRE[3][1]);
        this.tvungen.settPoeng(FEMMERE, EN_TIL_TRE[4][1]);
        this.tvungen.settPoeng(SEKSERE, EN_TIL_TRE[5][1]);
        assertEquals(BONUS, Bonus.TVUNGEN.beregn(this.tvungen));
        assertEquals(SpesialPoeng.TVUNGEN_BONUS.poeng.add(BONUS),
                     this.tvungen.poeng());
    }

    @Test
    public void for_lite_til_ordinar_bonus() {
        this.ordinar.settPoeng(ENERE, EN_TIL_TRE[0][2]);
        this.ordinar.settPoeng(TOERE, EN_TIL_TRE[1][2]);
        this.ordinar.settPoeng(TREERE, EN_TIL_TRE[2][2]);
        this.ordinar.settPoeng(FIRERE, EN_TIL_TRE[3][0]);
        this.ordinar.settPoeng(FEMMERE, EN_TIL_TRE[4][2]);
        this.ordinar.settPoeng(SEKSERE, EN_TIL_TRE[5][2]);
        assertEquals(Poeng.NULL_POENG, Bonus.ORDINAR.beregn(this.ordinar));
        assertEquals(SpesialPoeng.ORDINAR_BONUS.poeng.add(new Poeng(-8)),
                     this.ordinar.poeng());
    }

    @Test
    public void akkurat_nok_til_ordinar_bonus() {
        this.ordinar.settPoeng(ENERE, EN_TIL_TRE[0][2]);
        this.ordinar.settPoeng(TOERE, EN_TIL_TRE[1][2]);
        this.ordinar.settPoeng(TREERE, EN_TIL_TRE[2][2]);
        this.ordinar.settPoeng(FIRERE, EN_TIL_TRE[3][2]);
        this.ordinar.settPoeng(FEMMERE, EN_TIL_TRE[4][2]);
        this.ordinar.settPoeng(SEKSERE, EN_TIL_TRE[5][2]);
        assertEquals(BONUS, Bonus.ORDINAR.beregn(this.ordinar));
        assertEquals(SpesialPoeng.ORDINAR_BONUS.poeng.add(BONUS),
                     this.ordinar.poeng());
    }
}
