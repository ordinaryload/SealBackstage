package load.bean.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ReplyVo {
    private Integer id;

    private Integer msgid;

    private String type;

    private String text;

    private String images;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String rea;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMsgid() {
        return msgid;
    }

    public void setMsgid(Integer msgid) {
        this.msgid = msgid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRea() {
        return rea;
    }

    public void setRea(String rea) {
        this.rea = rea == null ? null : rea.trim();
    }
}
