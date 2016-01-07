package no.mesan.workmanship.yatzy.domene;

import java.util.Random;

import no.mesan.workmanship.yatzy.annotations.Immutable;
import no.mesan.workmanship.yatzy.annotations.Mangel;

@Immutable
public enum TerningPoeng {
    INGEN(0), EN(1), TO(2), TRE(3), FIRE(4), FEM(5), SEKS(6);

    public final int score;
    private static final Random seed = new Random();

    TerningPoeng(final int score) { this.score= score; }

    public static TerningPoeng kast() {
        final TerningPoeng[] val= TerningPoeng.values();
        return val[seed.nextInt(val.length)];
    }

    @Mangel("static")
    public static TerningPoeng int2terning(final int i) {
        switch (i) {
            case 1: return TerningPoeng.EN;
            case 2: return TerningPoeng.TO;
            case 3: return TerningPoeng.TRE;
            case 4: return TerningPoeng.FIRE;
            case 5: return TerningPoeng.FEM;
            case 6: return TerningPoeng.SEKS;
        }
        return TerningPoeng.INGEN;
    }

    public boolean harVerdi() { return this.score != 0; }
}
