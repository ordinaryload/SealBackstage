package load.entity.param;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MessageParam {
    private Integer id;

    private String putrole;

    private String getrole;

    private String text;

    private String images;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPutrole() {
        return putrole;
    }

    public void setPutrole(String putrole) {
        this.putrole = putrole;
    }

    public String getGetrole() {
        return getrole;
    }

    public void setGetrole(String getrole) {
        this.getrole = getrole;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
