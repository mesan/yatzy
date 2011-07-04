package no.mesan.workmanship.yatzy.brett.spill;

import no.mesan.workmanship.yatzy.domene.Poeng;
import no.mesan.workmanship.yatzy.domene.Yatzykombinasjon;

public class ProsentPlassering extends FlestPoengPlassering {
    @Override
    protected void rescore() {
        for (final Yatzykombinasjon yatzykombinasjon : this.poeng.keySet()) {
            final Poeng antallPoeng= this.poeng.get(yatzykombinasjon);
            final int asInt= antallPoeng.asInt();
            final int ekstra= 100*asInt/yatzykombinasjon.maxPoeng().asInt();
            this.poeng.put(yatzykombinasjon, new Poeng(asInt*10000+ekstra));
        }
    }
}
