package no.mesan.workmanship.yatzy.brett.spill;

import no.mesan.workmanship.yatzy.annotations.Mangel;
import no.mesan.workmanship.yatzy.brett.Plassering;
import no.mesan.workmanship.yatzy.domene.Kast;
import no.mesan.workmanship.yatzy.domene.YatzyBrett;
import no.mesan.workmanship.yatzy.domene.Yatzykombinasjon;

public final class TvungenPlassering implements Plassering {

    private static final String SKULLE_IKKE_HAVNET_HER_VI_ER_JO_FERDIGE =
            "Skulle ikke havnet her, vi er jo ferdige!!!!";

    @Mangel("2 nivåer innrykk")
    @Override
    public final Yatzykombinasjon velgPlassering(final YatzyBrett yatzyBrett, final Kast kast) {
        for (final Yatzykombinasjon yatzykombinasjon : Yatzykombinasjon.values()) {
            if ( !yatzyBrett.har(yatzykombinasjon) ) return yatzykombinasjon;
        }
        throw new RuntimeException(SKULLE_IKKE_HAVNET_HER_VI_ER_JO_FERDIGE);
    }
}
