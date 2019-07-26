package collections;

import java.util.Objects;

public class MyKey {

    private String val;
    private Integer num;

    public MyKey(final String val, final Integer num) {
        this.val = val;
        this.num = num;
    }

    public String getVal() {
        return val;
    }

    public void setVal(final String val) {
        this.val = val;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(final Integer num) {
        this.num = num;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof MyKey)) return false;
        final MyKey myKey = (MyKey) o;
        return Objects.equals(val, myKey.val) &&
                Objects.equals(num, myKey.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, num);
    }
}
