package Thread;

/**
 * Created by lyx on 2019/4/12.
 */
public class Ticket {
    private String star;
    private String end;
    private Integer price;

    public Ticket() {
    }

    public Ticket(String star, String end, Integer price) {
        this.star = star;
        this.end = end;
        this.price = price;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
