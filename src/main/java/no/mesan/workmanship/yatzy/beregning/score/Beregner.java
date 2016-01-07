package no.mesan.workmanship.yatzy.beregning.score;

import no.mesan.workmanship.yatzy.annotations.Immutable;
import no.mesan.workmanship.yatzy.annotations.Unntak;
import no.mesan.workmanship.yatzy.beregning.YatzyBeregner;
import no.mesan.workmanship.yatzy.domene.Kast;
import no.mesan.workmanship.yatzy.domene.Poeng;
import no.mesan.workmanship.yatzy.domene.Yatzykombinasjon;

@Unntak("Interfacet bruker Integer -- evt endre oppgaven...")
@Immutable
public final class Beregner implements YatzyBeregner {
    @Override
    public final Integer beregnPoengsum(final Yatzykombinasjon yatzykombinasjon, final Kast terninger) {
        final Poeng poeng= yatzykombinasjon.beregnPoengForKast(terninger);
        return poeng.asInt();
    }
}
