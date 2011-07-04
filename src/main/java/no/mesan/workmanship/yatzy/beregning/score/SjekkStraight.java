package no.mesan.workmanship.yatzy.beregning.score;

import no.mesan.workmanship.yatzy.domene.Kast;
import no.mesan.workmanship.yatzy.domene.Straights;
import no.mesan.workmanship.yatzy.domene.TerningPoeng;

import static no.mesan.workmanship.yatzy.domene.TerningPoeng.*;

final class SjekkStraight {

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
}
