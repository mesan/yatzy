package no.mesan.workmanship.yatzy.beregning.score;

import no.mesan.workmanship.yatzy.annotations.Unntak;
import no.mesan.workmanship.yatzy.beregning.YatzyBeregner;
import no.mesan.workmanship.yatzy.domene.Kast;
import no.mesan.workmanship.yatzy.domene.Terning;
import no.mesan.workmanship.yatzy.domene.Yatzykombinasjon;

@Unntak
public class AntallOyneBeregner implements YatzyBeregner {

	@Override
	public Integer beregnPoengsum(final Yatzykombinasjon yatzykombinasjon, final Kast terninger) {
		int antallOyne = 0;
		for(final Terning terning : terninger) {
			antallOyne += terning.verdi().score;
		}
		return antallOyne;
	}
}
