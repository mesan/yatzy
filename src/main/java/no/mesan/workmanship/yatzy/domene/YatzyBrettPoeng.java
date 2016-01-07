package no.mesan.workmanship.yatzy.domene;

import java.util.HashMap;
import java.util.Map;

import no.mesan.workmanship.yatzy.annotations.Mangel;

final class YatzyBrettPoeng {
    private final Map<Yatzykombinasjon, Poeng> resultater= new HashMap<>();

    Poeng settPoeng(final Yatzykombinasjon yatzykombinasjon, final Kast kast) {
        if ( har(yatzykombinasjon) ) throw new IllegalArgumentException("Kan ikke sette nye poeng på " + yatzykombinasjon);
        final Poeng poeng= yatzykombinasjon.beregnPoengForKast(kast);
        this.resultater.put(yatzykombinasjon, poeng);
        return poeng;
    }

    @Mangel("Har null")
    boolean har(final Yatzykombinasjon yatzykombinasjon) {
        return this.resultater.get(yatzykombinasjon) != null;
    }

    Poeng verdi(final Yatzykombinasjon yatzykombinasjon) {
        return this.resultater.get(yatzykombinasjon);
    }
}
