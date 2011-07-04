package no.mesan.workmanship.yatzy.brett;

import no.mesan.workmanship.yatzy.domene.Kast;
import no.mesan.workmanship.yatzy.domene.YatzyBrett;
import no.mesan.workmanship.yatzy.domene.Yatzykombinasjon;

public interface Plassering {
    Yatzykombinasjon velgPlassering(YatzyBrett yatzyBrett, Kast kast);
}
