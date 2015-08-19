package no.mesan.workmanship.yatzy.domene;

public class TestTerning extends Terning {

    public static final Terning _0= new TestTerning(TerningPoeng.INGEN);
    public static final Terning _1= new TestTerning(TerningPoeng.EN);
    public static final Terning _2= new TestTerning(TerningPoeng.TO);
    public static final Terning _3= new TestTerning(TerningPoeng.TRE);
    public static final Terning _4= new TestTerning(TerningPoeng.FIRE);
    public static final Terning _5= new TestTerning(TerningPoeng.FEM);
    public static final Terning _6= new TestTerning(TerningPoeng.SEKS);

    private TestTerning(final TerningPoeng tp) {
        super(tp);
    }
}
