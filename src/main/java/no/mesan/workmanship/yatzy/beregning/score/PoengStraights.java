package no.mesan.workmanship.yatzy.beregning.score;

import no.mesan.workmanship.yatzy.beregning.KastBeregner;
import no.mesan.workmanship.yatzy.domene.Kast;
import no.mesan.workmanship.yatzy.domene.Poeng;
import no.mesan.workmanship.yatzy.domene.Straights;
import no.mesan.workmanship.yatzy.poeng.SpesialPoeng;

public abstract class PoengStraights implements KastBeregner {
    private final Poeng poeng;
    private PoengStraights(final Poeng poeng) {
        this.poeng= poeng;
    }

    public static final KastBeregner P_LITEN_STRAIGHT=
        new PoengStraights(SpesialPoeng.LITEN_STRAIGHT_POENG.poeng) {
            @Override
            protected boolean match(final Kast kast) {
                return SjekkStraight.sjekk(Straights.LITEN, kast);
            }
    };

    public static final KastBeregner P_STOR_STRAIGHT=
        new PoengStraights(SpesialPoeng.STOR_STRAIGHT_POENG.poeng) {
            @Override
            protected boolean match(final Kast kast) {
                return SjekkStraight.sjekk(Straights.STOR, kast);
            }
    };

    protected abstract boolean match(Kast kast);

    @Override
    public Poeng beregnPoengForKast(final Kast kast) {
        if ( !match(kast) ) return Poeng.NULL_POENG;
        return this.poeng;
    }

}
