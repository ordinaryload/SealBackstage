package load.entity.po;

import load.bean.Reply;

import java.util.Date;
import java.util.List;

public class CommunicatePo {
    private Integer id;

    private String username;

    private String type;

    private String text;

    private String images;

    private Date date;

    List<ReplyPo> replyList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public List<ReplyPo> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<ReplyPo> replyList) {
        this.replyList = replyList;
    }
}
