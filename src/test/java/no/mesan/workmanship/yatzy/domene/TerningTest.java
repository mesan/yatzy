package no.mesan.workmanship.yatzy.domene;

import org.junit.Test;

import static no.mesan.workmanship.yatzy.domene.TestTerning.*;
import static org.junit.Assert.assertEquals;

public class TerningTest {
    @Test
    public void terningTarVarePaVerdi()  {
        assertEquals(1, _1.verdi().score);
        assertEquals(3, _3.verdi().score);
    }

}
