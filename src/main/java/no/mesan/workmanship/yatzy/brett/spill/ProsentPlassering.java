package no.mesan.workmanship.yatzy.brett.spill;

import no.mesan.workmanship.yatzy.domene.Poeng;
import no.mesan.workmanship.yatzy.domene.Yatzykombinasjon;

public final class ProsentPlassering extends FlestPoengPlassering {

    private static final int PROSENT_ER_100 = 100;
    private static final int STORT_TALL = 10000;

    @Override
    protected final void rescore() {
        for (final Yatzykombinasjon yatzykombinasjon : this.poeng.keySet()) {
            final Poeng antallPoeng= this.poeng.get(yatzykombinasjon);
            final int asInt= antallPoeng.asInt();
            final Poeng maxForKombinasjon = yatzykombinasjon.maxPoeng();
            final int ekstra= PROSENT_ER_100 *asInt/ maxForKombinasjon.asInt();
            this.poeng.put(yatzykombinasjon, new Poeng(asInt* STORT_TALL +ekstra));
        }
    }
}
