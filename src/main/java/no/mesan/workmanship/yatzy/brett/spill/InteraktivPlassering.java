package no.mesan.workmanship.yatzy.brett.spill;

import no.mesan.workmanship.yatzy.annotations.Mangel;
import no.mesan.workmanship.yatzy.brett.Plassering;
import no.mesan.workmanship.yatzy.domene.Kast;
import no.mesan.workmanship.yatzy.domene.YatzyBrett;
import no.mesan.workmanship.yatzy.domene.Yatzykombinasjon;

public class InteraktivPlassering implements Plassering {

    private static final String TRAPPED = "Ingen steder å gå";

    @Mangel("2 nivåer innrykk")
    @Override
    public Yatzykombinasjon velgPlassering(final YatzyBrett yatzyBrett, final Kast kast) {
        for (final Yatzykombinasjon yatzykombinasjon : Yatzykombinasjon.values()) {
            if ( !yatzyBrett.har(yatzykombinasjon) ) return yatzykombinasjon;
        }
        throw new RuntimeException(TRAPPED);
    }
}
