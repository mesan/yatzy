package no.mesan.workmanship.yatzy.beregning.score;

import no.mesan.workmanship.yatzy.annotations.Immutable;
import no.mesan.workmanship.yatzy.domene.Poeng;
import no.mesan.workmanship.yatzy.domene.TerningPoeng;

@Immutable
abstract class ResultatPar {
    protected final TerningPoeng maksimalVerdi;
    protected final TerningPoeng minimumsVerdi;

    protected ResultatPar(final TerningPoeng minimum,
                          final TerningPoeng maksimum) {
        this.maksimalVerdi= maksimum;
        this.minimumsVerdi= minimum;
    }
}

class HusResultat extends ResultatPar  {
    HusResultat(final TerningPoeng dobbel, final TerningPoeng trippel) {
        super(dobbel, trippel);
    }
    Poeng sum() { return new Poeng(2*this.minimumsVerdi.score + 3*this.maksimalVerdi.score); }
}


class Par2Resultat extends ResultatPar  {
    Par2Resultat(final TerningPoeng par1, final TerningPoeng par2) {
        super(par1, par2);
    }
    Poeng sum() { return new Poeng(2*this.minimumsVerdi.score + 2*this.maksimalVerdi.score); }
}