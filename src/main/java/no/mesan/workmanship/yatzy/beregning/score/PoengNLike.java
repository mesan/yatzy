package no.mesan.workmanship.yatzy.beregning.score;

import no.mesan.workmanship.yatzy.annotations.Mangel;
import no.mesan.workmanship.yatzy.beregning.KastBeregner;
import no.mesan.workmanship.yatzy.domene.Poeng;
import no.mesan.workmanship.yatzy.domene.TerningPoeng;
import no.mesan.workmanship.yatzy.poeng.SpesialPoeng;

@Mangel("1 static")
public abstract class PoengNLike implements KastBeregner {

    public static final KastBeregner P_PAR= kast -> kalkuler(2, SjekkLike.bestePar(kast));
    public static final KastBeregner P_3_LIKE= kast -> kalkuler(3, SjekkLike.trippel(kast));
    public static final KastBeregner P_4_LIKE= kast -> kalkuler(4, SjekkLike.kvadruppel(kast));
    public static final KastBeregner P_YATZY= kast -> {
        final TerningPoeng yatzy= SjekkLike.yatzy(kast);
        return yatzy.harVerdi()? SpesialPoeng.YATZY_POENG.poeng : Poeng.NULL_POENG;
    };
    public static final KastBeregner P_2_PAR= kast -> {
        final ResultatPar par2= SjekkLike.toPar(kast);
        return par2.sum();
    };
    public static final KastBeregner P_HUS= kast -> {
        final ResultatPar hus= SjekkLike.hus(kast);
        return hus.sum();
    };

    private static Poeng kalkuler(final int n, final TerningPoeng verdi) {
        if ( !verdi.harVerdi() ) return Poeng.NULL_POENG;
        return new Poeng(verdi.score*n);
    }
}
