package load.entity.param;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class OrderParam {
    private Integer id;
    private Integer goodsid;
    private String buyer;
    private Integer counts;
    /**
     * yyyy-MM-dd
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
