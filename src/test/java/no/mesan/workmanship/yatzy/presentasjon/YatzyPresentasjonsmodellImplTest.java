package no.mesan.workmanship.yatzy.presentasjon;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class YatzyPresentasjonsmodellImplTest {
    private YatzyPresentasjonsmodellImpl presMod;


    @Before
    public void settOpp() {
        this.presMod = new YatzyPresentasjonsmodellImpl((yatzykombinasjon, terninger) -> 0);
    }

    @Test
    public void vedStartSkalNyRundeVaereAv() {
        Assert.assertFalse(this.presMod.nyRundeAction().isEnabled());
    }

    @Test
    public void vedStartSkalKastVaerePaa() {
        Assert.assertTrue(this.presMod.kastAction().isEnabled());
    }

    @Test
    public void etterTreKastSkalKastVaereAvOgNyRundePaa() {
        this.presMod.kastAction().actionPerformed(null);
        this.presMod.kastAction().actionPerformed(null);
        this.presMod.kastAction().actionPerformed(null);
        Assert.assertFalse(this.presMod.kastAction().isEnabled());
        Assert.assertTrue(this.presMod.nyRundeAction().isEnabled());
    }

    @Test @Ignore("Nei, det skal den ikke")
    public void holdtTerningSkalLaasesVedKast() {
        this.presMod.kastAction().actionPerformed(null);
        this.presMod.holdTerningModeller()[0].setValue(true);
        this.presMod.kastAction().actionPerformed(null);
        Assert.assertFalse(this.presMod.holdTerningModeller()[0].isEnabled());
    }

    /** TODO **/
}
