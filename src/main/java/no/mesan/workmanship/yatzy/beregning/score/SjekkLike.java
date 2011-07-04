package no.mesan.workmanship.yatzy.beregning.score;

import java.util.*;

import no.mesan.workmanship.yatzy.domene.Kast;
import no.mesan.workmanship.yatzy.domene.TerningPoeng;

final class SjekkLike {
    private static final List<TerningPoeng> REVERSE= Arrays.asList(TerningPoeng.values());
    static { Collections.reverse(REVERSE); }

    private static ResultatGruppe beste(final int antall, final ResultatSett kast,
                                        final List<TerningPoeng> list) {
        if ( list.size()==0 ) return new ResultatGruppe(null, kast);
        final TerningPoeng poeng= list.get(0);
        if ( kast.count(poeng)>= antall ) {
            return new ResultatGruppe(poeng, kast.bruk(poeng, antall));
        }
        return beste(antall, kast, list.subList(1, list.size()));
    }

    private static ResultatGruppe beste(final int antall, final Kast kast) {
        return beste(antall, new ResultatSett(kast), REVERSE);
    }

    static TerningPoeng bestePar(final Kast kast) { return beste(2, kast).beste; }
    static TerningPoeng trippel(final Kast kast) { return beste(3, kast).beste; }
    static TerningPoeng kvadruppel(final Kast kast) { return beste(4, kast).beste; }
    static TerningPoeng yatzy(final Kast kast) { return beste(5, kast).beste; }

    static HusResultat hus(final Kast kast) {
        final ResultatGruppe trippel= beste(3, kast);
        if ( trippel.beste==null ) return null;
        final ResultatGruppe dobbel= beste(2, trippel.rest, REVERSE);
        if ( dobbel.beste==null ) return null;
        return new HusResultat(dobbel.beste, trippel.beste);
    }

    static Par2Resultat toPar(final Kast kast) {
        final ResultatGruppe par1= beste(2, kast);
        if ( par1.beste==null ) return null;
        final ResultatGruppe par2= beste(2, par1.rest, REVERSE);
        if ( par2.beste==null ) return null;
        return new Par2Resultat(par2.beste, par1.beste);
    }
}
