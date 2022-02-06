package person;

import java.util.Objects;

public class Moral {

    private byte n1;
    private byte n2;
    private byte n3;
    private byte n4;
    private byte n5;
    private byte n6;

    public byte getN1() {
        return n1;
    }

    public byte getN2() {
        return n2;
    }

    public byte getN3() {
        return n3;
    }

    public byte getN4() {
        return n4;
    }

    public byte getN5() {
        return n5;
    }

    public byte getN6() {
        return n6;
    }

    public void setN1(byte n1) {
        this.n1 = n1;
    }

    public void setN2(byte n2) {
        this.n2 = n2;
    }

    public void setN3(byte n3) {
        this.n3 = n3;
    }

    public void setN4(byte n4) {
        this.n4 = n4;
    }

    public void setN5(byte n5) {
        this.n5 = n5;
    }

    public void setN6(byte n6) {
        this.n6 = n6;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Moral moral = (Moral) o;
        return n1 == moral.n1 || n2 == moral.n2 || n3 == moral.n3 || n4 == moral.n4 || n5 == moral.n5 || n6 == moral.n6;
    }

    @Override
    public int hashCode() {
        return Objects.hash(n1, n2, n3, n4, n5, n6);
    }

    @Override
    public String toString() {
        return "Moral{" +
                "n1=" + n1 +
                ", n2=" + n2 +
                ", n3=" + n3 +
                ", n4=" + n4 +
                ", n5=" + n5 +
                ", n6=" + n6 +
                '}';
    }
}
