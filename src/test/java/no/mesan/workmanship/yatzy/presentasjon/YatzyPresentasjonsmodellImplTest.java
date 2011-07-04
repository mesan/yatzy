package no.mesan.workmanship.yatzy.presentasjon;

import junit.framework.Assert;

import no.mesan.workmanship.yatzy.beregning.YatzyBeregner;
import no.mesan.workmanship.yatzy.domene.Kast;
import no.mesan.workmanship.yatzy.domene.Yatzykombinasjon;
import no.mesan.workmanship.yatzy.presentasjon.YatzyPresentasjonsmodellImpl;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class YatzyPresentasjonsmodellImplTest {
	private YatzyPresentasjonsmodellImpl presMod;


	@Before
	public void settOpp() {
		this.presMod = new YatzyPresentasjonsmodellImpl(new YatzyBeregner() {
			@Override
			public Integer beregnPoengsum(final Yatzykombinasjon yatzykombinasjon, final Kast terninger) {
				return 0;
			}
		});
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
