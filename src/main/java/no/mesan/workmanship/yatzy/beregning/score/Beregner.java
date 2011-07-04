package no.mesan.workmanship.yatzy.beregning.score;

import no.mesan.workmanship.yatzy.annotations.Unntak;
import no.mesan.workmanship.yatzy.beregning.YatzyBeregner;
import no.mesan.workmanship.yatzy.domene.Kast;
import no.mesan.workmanship.yatzy.domene.Poeng;
import no.mesan.workmanship.yatzy.domene.Yatzykombinasjon;

@Unntak
public class Beregner implements YatzyBeregner {
	@Override
	public Integer beregnPoengsum(final Yatzykombinasjon yatzykombinasjon, final Kast terninger) {
	    final Poeng poeng= yatzykombinasjon.beregnPoengForKast(terninger);
	    return Integer.valueOf(poeng.asInt());
	}
}
