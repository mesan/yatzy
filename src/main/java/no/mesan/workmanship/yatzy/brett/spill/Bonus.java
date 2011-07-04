package no.mesan.workmanship.yatzy.brett.spill;

import no.mesan.workmanship.yatzy.annotations.Immutable;
import no.mesan.workmanship.yatzy.brett.BonusBeregner;
import no.mesan.workmanship.yatzy.domene.Poeng;
import no.mesan.workmanship.yatzy.domene.YatzyBrett;

import static no.mesan.workmanship.yatzy.domene.Yatzykombinasjon.*;
import static no.mesan.workmanship.yatzy.poeng.SpesialPoeng.*;

@Immutable
public class Bonus implements BonusBeregner {
    public static final Bonus ORDINAR= new Bonus(ORDINAR_BONUS.poeng);
    public static final Bonus TVUNGEN= new Bonus(TVUNGEN_BONUS.poeng);

    private final Poeng bonuskrav;
    private Bonus(final Poeng poeng) { this.bonuskrav= poeng; }

    @Override
    public Poeng beregn(final YatzyBrett yatzyBrett) {
        return bonusOk(yatzyBrett)? BONUS_POENG.poeng : Poeng.NULL_POENG;
    }

    private boolean bonusOk(final YatzyBrett yatzyBrett) {
        return poeng(yatzyBrett).compareTo(this.bonuskrav) >= 0;
    }

    private Poeng poeng(final YatzyBrett yatzyBrett) {
        return yatzyBrett.poeng(ENERE)
              .add(yatzyBrett.poeng(TOERE))
              .add(yatzyBrett.poeng(TREERE))
              .add(yatzyBrett.poeng(FIRERE))
              .add(yatzyBrett.poeng(FEMMERE))
              .add(yatzyBrett.poeng(SEKSERE));
    }
}
