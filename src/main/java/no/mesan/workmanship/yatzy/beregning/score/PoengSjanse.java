package no.mesan.workmanship.yatzy.beregning.score;

import no.mesan.workmanship.yatzy.beregning.KastBeregner;
import no.mesan.workmanship.yatzy.domene.Kast;
import no.mesan.workmanship.yatzy.domene.Poeng;
import no.mesan.workmanship.yatzy.domene.Terning;
import no.mesan.workmanship.yatzy.domene.TerningPoeng;

public final class PoengSjanse implements KastBeregner {
    private PoengSjanse() { /*EMPTY*/ }

    public static final KastBeregner P_SJANSE= new PoengSjanse();

    @Override
    public Poeng beregnPoengForKast(final Kast kast) {
        int poeng= 0;
        for (final Terning terning : kast) {
            final TerningPoeng verdi= terning.verdi();
            poeng+= verdi.score;
        }
        return new Poeng(poeng);
    }
}
