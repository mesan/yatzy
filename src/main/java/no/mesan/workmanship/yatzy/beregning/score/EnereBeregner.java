package no.mesan.workmanship.yatzy.beregning.score;

import no.mesan.workmanship.yatzy.beregning.KastBeregner;
import no.mesan.workmanship.yatzy.domene.Kast;
import no.mesan.workmanship.yatzy.domene.Poeng;

public class EnereBeregner implements KastBeregner {

    @Override
    public Poeng beregnPoengForKast(final Kast kast) {
        return new Poeng(0);
    }
}
