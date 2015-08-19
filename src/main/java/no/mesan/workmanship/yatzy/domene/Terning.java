package no.mesan.workmanship.yatzy.domene;

import no.mesan.workmanship.yatzy.annotations.Immutable;
import no.mesan.workmanship.yatzy.annotations.Unntak;

@Immutable
public class Terning {
    private final TerningPoeng verdi;

    public Terning() { this(TerningPoeng.kast()); }

    public Terning(final TerningPoeng kast) {
        this.verdi= kast;
    }

    public TerningPoeng verdi() { return this.verdi; }

    @Override
    @Unntak("Gidder ikke lage konstanter for hakeparenteser...")
    public String toString() {
        return "[" + this.verdi() + "]";
    }
}
