package no.mesan.workmanship.yatzy.domene;

import org.junit.Before;
import org.junit.Test;

import no.mesan.workmanship.yatzy.domene.YatzyBrettPoeng;
import no.mesan.workmanship.yatzy.domene.Yatzykombinasjon;

import static no.mesan.workmanship.yatzy.domene.TestTerning.*;

import static org.junit.Assert.*;

public class YatzyBrettPoengTest {
    private static final TestKast HUS= new TestKast(_2, _3, _3, _2, _2);
    private static final TestKast YATZY= new TestKast(_2, _2, _2, _2, _2);
    private YatzyBrettPoeng yatzyBrettPoeng;

    @Before
    public void setup() {
        this.yatzyBrettPoeng= new YatzyBrettPoeng();
    }

    @Test
    public void endrer_status_ved_registrering_uten_poeng() {
        assertFalse(this.yatzyBrettPoeng.har(Yatzykombinasjon.YATZY));
        this.yatzyBrettPoeng.settPoeng(Yatzykombinasjon.YATZY, HUS);
        assertTrue(this.yatzyBrettPoeng.har(Yatzykombinasjon.YATZY));
    }

    @Test
    public void endrer_status_ved_registrering_med_poeng() {
        assertFalse(this.yatzyBrettPoeng.har(Yatzykombinasjon.YATZY));
        this.yatzyBrettPoeng.settPoeng(Yatzykombinasjon.YATZY, YATZY);
        assertTrue(this.yatzyBrettPoeng.har(Yatzykombinasjon.YATZY));
    }

    @Test(expected=IllegalArgumentException.class)
    public void feiler_ved_gjentatt_poeng_setting() {
        this.yatzyBrettPoeng.settPoeng(Yatzykombinasjon.YATZY, HUS);
        this.yatzyBrettPoeng.settPoeng(Yatzykombinasjon.YATZY, YATZY);
    }

    @Test
    public void riktig_poeng_for_hus() {
        assertEquals(new Poeng(12), this.yatzyBrettPoeng.settPoeng(Yatzykombinasjon.HUS, HUS));
        assertEquals(Poeng.NULL_POENG, this.yatzyBrettPoeng.settPoeng(Yatzykombinasjon.YATZY, HUS));
    }
}
