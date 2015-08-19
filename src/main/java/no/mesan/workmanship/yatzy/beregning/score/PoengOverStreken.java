package no.mesan.workmanship.yatzy.beregning.score;

import no.mesan.workmanship.yatzy.beregning.KastBeregner;
import no.mesan.workmanship.yatzy.domene.Kast;
import no.mesan.workmanship.yatzy.domene.Poeng;
import no.mesan.workmanship.yatzy.domene.Terning;
import no.mesan.workmanship.yatzy.domene.TerningPoeng;

public class PoengOverStreken implements KastBeregner {
    private final TerningPoeng verdi;

    private PoengOverStreken(final TerningPoeng verdi) { this.verdi=verdi; }

    public static final KastBeregner P_1= new PoengOverStreken(TerningPoeng.EN);
    public static final KastBeregner P_2= new PoengOverStreken(TerningPoeng.TO);
    public static final KastBeregner P_3= new PoengOverStreken(TerningPoeng.TRE);
    public static final KastBeregner P_4= new PoengOverStreken(TerningPoeng.FIRE);
    public static final KastBeregner P_5= new PoengOverStreken(TerningPoeng.FEM);
    public static final KastBeregner P_6= new PoengOverStreken(TerningPoeng.SEKS);

    @Override
    public Poeng beregnPoengForKast(final Kast kast) {
        int poeng= 0;
        for (final Terning terning : kast) {
            poeng += plukkPoeng(terning.verdi());
        }
        return new Poeng(poeng);
    }

    private int plukkPoeng(final TerningPoeng verdi) {
        return verdi.equals(this.verdi)? this.verdi.score : 0;
    }
}
