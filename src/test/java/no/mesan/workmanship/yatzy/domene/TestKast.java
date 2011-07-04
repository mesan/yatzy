package no.mesan.workmanship.yatzy.domene;

import no.mesan.workmanship.yatzy.domene.Kast;
import no.mesan.workmanship.yatzy.domene.Terning;

public class TestKast extends Kast {
    public TestKast(final Terning... verdier) {
        int idx= 0;
        for (final Terning terning : verdier) {
            this.terninger[idx++]= terning;
        }
        if ( idx!=5 ) throw new IllegalArgumentException("Ugyldig antall terninger");
    }
}
