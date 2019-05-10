package load.bean;

import java.util.Date;

public class Reply {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reply.id
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reply.msgid
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    private Integer msgid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reply.type
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reply.text
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    private String text;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reply.images
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    private String images;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reply.date
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    private Date date;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reply.read
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    private String read;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reply.id
     *
     * @return the value of reply.id
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reply.id
     *
     * @param id the value for reply.id
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reply.msgid
     *
     * @return the value of reply.msgid
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public Integer getMsgid() {
        return msgid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reply.msgid
     *
     * @param msgid the value for reply.msgid
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public void setMsgid(Integer msgid) {
        this.msgid = msgid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reply.type
     *
     * @return the value of reply.type
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reply.type
     *
     * @param type the value for reply.type
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reply.text
     *
     * @return the value of reply.text
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public String getText() {
        return text;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reply.text
     *
     * @param text the value for reply.text
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reply.images
     *
     * @return the value of reply.images
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public String getImages() {
        return images;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reply.images
     *
     * @param images the value for reply.images
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reply.date
     *
     * @return the value of reply.date
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reply.date
     *
     * @param date the value for reply.date
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reply.read
     *
     * @return the value of reply.read
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public String getRead() {
        return read;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reply.read
     *
     * @param read the value for reply.read
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public void setRead(String read) {
        this.read = read == null ? null : read.trim();
    }
}