package no.mesan.workmanship.yatzy.beregning.score;

import no.mesan.workmanship.yatzy.beregning.KastBeregner;
import no.mesan.workmanship.yatzy.domene.Kast;
import no.mesan.workmanship.yatzy.domene.Poeng;
import no.mesan.workmanship.yatzy.domene.Straights;
import no.mesan.workmanship.yatzy.domene.TerningPoeng;
import no.mesan.workmanship.yatzy.poeng.SpesialPoeng;

import static no.mesan.workmanship.yatzy.domene.TerningPoeng.*;

public final class PoengStraights implements KastBeregner {

    private static final int AKKURAT_1 = 1;

    private final Straights avType;
    private final SpesialPoeng poengSum;

    PoengStraights(final Straights avType, final SpesialPoeng poengSum) {
        this.avType = avType;
        this.poengSum= poengSum;
    }

    @Override
    public final Poeng beregnPoengForKast(final Kast kast) {
        return sjekk(this.avType, kast)? this.poengSum.poeng : Poeng.NULL_POENG;
    }

    private boolean sjekk(final Straights type, final Kast kast) {
        final ResultatSett res= new ResultatSett(kast);
        return har1av(res, TO)
            && har1av(res, TRE)
            && har1av(res, FIRE)
            && har1av(res, FEM)
            && (  ( type.equals(Straights.LITEN) && har1av(res, EN) )
                    || ( type.equals(Straights.STOR) && har1av(res, SEKS) ) );
    }

    private boolean har1av(final ResultatSett resultatSett, final TerningPoeng terningPoeng) {
        return resultatSett.count(terningPoeng)== AKKURAT_1;
    }
}
