package no.mesan.workmanship.yatzy.poeng;

import no.mesan.workmanship.yatzy.domene.Poeng;

public enum SpesialPoeng {
    YATZY_POENG(50),
    BONUS_POENG(50),
    STOR_STRAIGHT_POENG(20),
    LITEN_STRAIGHT_POENG(15),
    ORDINAR_BONUS(63),
    TVUNGEN_BONUS(42);

    public final Poeng poeng;

    private SpesialPoeng(final int poeng) {
        this.poeng= new Poeng(poeng);
    }
}
