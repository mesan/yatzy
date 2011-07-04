package no.mesan.workmanship.yatzy.brett.spill;

import org.junit.Test;

import no.mesan.workmanship.yatzy.brett.spill.Bonus;
import no.mesan.workmanship.yatzy.brett.spill.InteraktivPlassering;
import no.mesan.workmanship.yatzy.domene.TestKast;
import no.mesan.workmanship.yatzy.domene.YatzyBrett;

import static no.mesan.workmanship.yatzy.domene.TestTerning._2;

import static org.junit.Assert.*;

public class InteraktivPlasseringTest {
    private static final TestKast TESTYATZY= new TestKast(_2, _2, _2, _2, _2);

    @Test
    public void skrem_cobertura_til_å_holde_kjeft() {
        assertNull(new InteraktivPlassering().velgPlassering(new YatzyBrett(Bonus.ORDINAR), TESTYATZY));
    }

}
