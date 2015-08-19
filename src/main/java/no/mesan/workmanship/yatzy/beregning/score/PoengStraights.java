package no.mesan.workmanship.yatzy.beregning.score;

import no.mesan.workmanship.yatzy.annotations.Mangel;
import no.mesan.workmanship.yatzy.beregning.KastBeregner;
import no.mesan.workmanship.yatzy.domene.Kast;
import no.mesan.workmanship.yatzy.domene.Poeng;
import no.mesan.workmanship.yatzy.domene.Straights;
import no.mesan.workmanship.yatzy.domene.TerningPoeng;
import no.mesan.workmanship.yatzy.poeng.SpesialPoeng;

import static no.mesan.workmanship.yatzy.domene.TerningPoeng.*;
import static no.mesan.workmanship.yatzy.domene.TerningPoeng.EN;
import static no.mesan.workmanship.yatzy.domene.TerningPoeng.SEKS;

@Mangel("statics")
public abstract class PoengStraights {

    static boolean sjekk(final Straights type, final Kast kast) {
        final ResultatSett res= new ResultatSett(kast);
        return har1av(res, TO)
            && har1av(res, TRE)
            && har1av(res, FIRE)
            && har1av(res, FEM)
            && (  ( type.equals(Straights.LITEN) && har1av(res, EN) )
                    || ( type.equals(Straights.STOR) && har1av(res, SEKS) ) );
    }

    private static boolean har1av(final ResultatSett resultatSett,
                                  final TerningPoeng terningPoeng) {
        return resultatSett.count(terningPoeng)==1;
    }

    public static final KastBeregner P_LITEN_STRAIGHT=
            kast -> sjekk(Straights.LITEN, kast)? SpesialPoeng.LITEN_STRAIGHT_POENG.poeng
                                                              : Poeng.NULL_POENG;

    public static final KastBeregner P_STOR_STRAIGHT=
            kast -> sjekk(Straights.STOR, kast)? SpesialPoeng.STOR_STRAIGHT_POENG.poeng
                                                             : Poeng.NULL_POENG;
}
