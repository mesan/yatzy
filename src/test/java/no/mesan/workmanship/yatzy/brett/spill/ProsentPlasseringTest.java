package no.mesan.workmanship.yatzy.brett.spill;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import no.mesan.workmanship.yatzy.brett.spill.Bonus;
import no.mesan.workmanship.yatzy.brett.spill.ProsentPlassering;
import no.mesan.workmanship.yatzy.domene.TestKast;
import no.mesan.workmanship.yatzy.domene.YatzyBrett;
import no.mesan.workmanship.yatzy.domene.Yatzykombinasjon;

import static org.junit.Assert.*;

import static no.mesan.workmanship.yatzy.domene.TestTerning.*;
import static no.mesan.workmanship.yatzy.domene.Yatzykombinasjon.*;

public class ProsentPlasseringTest extends FlestPoengPlasseringTest {

    @Override
    @Before
    public void setup() {
        this.plassering= new ProsentPlassering();
        this.yatzyBrett= new YatzyBrett(Bonus.ORDINAR);
    }

    private static final TestKast TESTYATZY= new TestKast(_2, _2, _2, _2, _2);
    @Override
    @Test
    public void valg_for_yatzy() {
        final Yatzykombinasjon type0= this.plassering.velgPlassering(this.yatzyBrett, TESTYATZY);
        assertEquals(YATZY, type0);
        this.yatzyBrett.settPoeng(YATZY, TESTYATZY);
        final Set<Yatzykombinasjon> mulige= new HashSet<Yatzykombinasjon>();
        // 10 poeng
        final Yatzykombinasjon type1= this.plassering.velgPlassering(this.yatzyBrett, TESTYATZY);
        assertEquals(TOERE, type1);
        this.yatzyBrett.settPoeng(TOERE, TESTYATZY);
        for (int i= 0; i < 2; i++) {
            final Yatzykombinasjon yatzykombinasjon= this.plassering.velgPlassering(this.yatzyBrett, TESTYATZY);
            mulige.add(yatzykombinasjon);
            this.yatzyBrett.settPoeng(yatzykombinasjon, TESTYATZY);
        }
        assertTrue(HUS.toString(), mulige.contains(HUS));
        assertTrue(SJANSE.toString(), mulige.contains(SJANSE));
        // 8 poeng
        mulige.clear();
        for (int i= 0; i < 2; i++) {
            final Yatzykombinasjon yatzykombinasjon= this.plassering.velgPlassering(this.yatzyBrett, TESTYATZY);
            mulige.add(yatzykombinasjon);
            this.yatzyBrett.settPoeng(yatzykombinasjon, TESTYATZY);
        }
        assertTrue(TO_PAR.toString(), mulige.contains(TO_PAR));
        assertTrue(FIRE_LIKE.toString(), mulige.contains(FIRE_LIKE));
        // 6 poeng
        final Yatzykombinasjon type2= this.plassering.velgPlassering(this.yatzyBrett, TESTYATZY);
        assertEquals(TRE_LIKE, type2);
        this.yatzyBrett.settPoeng(TRE_LIKE, TESTYATZY);
        // 4 poeng
        final Yatzykombinasjon type3= this.plassering.velgPlassering(this.yatzyBrett, TESTYATZY);
        assertEquals(PAR, type3);
        this.yatzyBrett.settPoeng(PAR, TESTYATZY);
    }
}
