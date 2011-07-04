package no.mesan.workmanship.yatzy.brett.spill;

import no.mesan.workmanship.yatzy.brett.Plassering;
import no.mesan.workmanship.yatzy.domene.Kast;
import no.mesan.workmanship.yatzy.domene.YatzyBrett;
import no.mesan.workmanship.yatzy.domene.Yatzykombinasjon;

public class TvungenPlassering implements Plassering {

    @Override
    public Yatzykombinasjon velgPlassering(final YatzyBrett yatzyBrett, final Kast kast) {
        for (final Yatzykombinasjon yatzykombinasjon : Yatzykombinasjon.values()) {
            if ( !yatzyBrett.har(yatzykombinasjon) ) return yatzykombinasjon;
        }
        return null;
    }
}
