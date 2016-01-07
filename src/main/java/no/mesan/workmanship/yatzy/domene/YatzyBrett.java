package no.mesan.workmanship.yatzy.domene;

import no.mesan.workmanship.yatzy.brett.BonusBeregner;

public class YatzyBrett {
    private static final int ANTALL_OVER= 6;

    private final BonusBeregner bonusBeregner;
    private final YatzyBrettPoeng yatzyBrettPoeng = new YatzyBrettPoeng();
    private int antallOverStreken= 0;
    private Poeng totalt= Poeng.NULL_POENG;
    private Poeng bonus;

    public YatzyBrett(final BonusBeregner beregner) {
        this.bonusBeregner= beregner;
    }

    public void settPoeng(final Yatzykombinasjon yatzykombinasjon, final Kast kast) {
        this.totalt= this.totalt.add(this.yatzyBrettPoeng.settPoeng(yatzykombinasjon, kast));
        if ( skalBeregneBonus(yatzykombinasjon) ) beregnBonus();
    }

    private void beregnBonus() {
        this.bonus= this.bonusBeregner.beregn(this);
        this.totalt= this.totalt.add(this.bonus);
    }

    public Poeng poeng(final Yatzykombinasjon yatzykombinasjon) {
        if ( this.yatzyBrettPoeng.har(yatzykombinasjon)) return this.yatzyBrettPoeng.verdi(yatzykombinasjon);
        return Poeng.NULL_POENG;
    }

    public Poeng poeng() { return this.totalt; }
    public boolean har(final Yatzykombinasjon yatzykombinasjon) { return this.yatzyBrettPoeng.har(yatzykombinasjon); }

    private boolean skalBeregneBonus(final Yatzykombinasjon yatzykombinasjon) {
        return yatzykombinasjon.overStreken()
                       && (++this.antallOverStreken == ANTALL_OVER)
                       && (this.bonus == null);
    }
}
