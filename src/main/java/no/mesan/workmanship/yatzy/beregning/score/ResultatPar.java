package no.mesan.workmanship.yatzy.beregning.score;

import no.mesan.workmanship.yatzy.annotations.Immutable;
import no.mesan.workmanship.yatzy.annotations.Mangel;
import no.mesan.workmanship.yatzy.domene.Poeng;
import no.mesan.workmanship.yatzy.domene.TerningPoeng;

@Mangel("1 static metode")
@Immutable
abstract class ResultatPar {
    static final int TO_AV = 2;
    static final int TRE_AV = 3;

    final TerningPoeng maksimalVerdi;
    final TerningPoeng minimumsVerdi;

    private static class IngenResultat extends ResultatPar {
        IngenResultat() { super(TerningPoeng.INGEN, TerningPoeng.INGEN); }
    }

    private static final ResultatPar INGEN= new IngenResultat();

    ResultatPar(final TerningPoeng minimum,
                final TerningPoeng maksimum) {
        this.maksimalVerdi= maksimum;
        this.minimumsVerdi= minimum;
    }

    Poeng sum() { return Poeng.NULL_POENG; }

    static ResultatPar ingen() { return INGEN; }
}

@Immutable final class HusResultat extends ResultatPar  {
    HusResultat(final TerningPoeng dobbel, final TerningPoeng trippel) {
        super(dobbel, trippel);
    }
    @Override final Poeng sum() { return new Poeng((TO_AV * this.minimumsVerdi.score) + (TRE_AV * this.maksimalVerdi.score)); }
}

@Immutable final class Par2Resultat extends ResultatPar  {
    Par2Resultat(final TerningPoeng par1, final TerningPoeng par2) {
        super(par1, par2);
    }
    @Override final Poeng sum() { return new Poeng((TO_AV * this.minimumsVerdi.score) + (TO_AV * this.maksimalVerdi.score)); }
}