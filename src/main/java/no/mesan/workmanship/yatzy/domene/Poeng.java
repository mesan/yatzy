package no.mesan.workmanship.yatzy.domene;

import no.mesan.workmanship.yatzy.annotations.Immutable;

@Immutable
public final class Poeng implements Comparable<Poeng> {
    public static final Poeng NULL_POENG= new Poeng(0);
    public static final int HASH_MAGIC = 31;

    private final int score;
    public Poeng(final int score) { this.score= score; }

    public Poeng add(final Poeng leggTil) {
        return new Poeng(this.score + leggTil.score);
    }

    @Override
    public String toString() {
        return Integer.toString(this.score);
    }

    @Override public int hashCode() { return HASH_MAGIC *this.score; }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if ((obj == null) || !(obj instanceof Poeng) ) return false;
        return compareTo((Poeng)obj)==0;
    }

    @Override public int compareTo(final Poeng other) {
        final Integer thisInt = Integer.valueOf(this.score);
        final Integer otherInt = Integer.valueOf(other.score);
        return thisInt.compareTo(otherInt);
    }

    public int asInt() { return this.score; }
}
