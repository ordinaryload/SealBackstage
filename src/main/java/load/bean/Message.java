package load.bean;

import java.util.Date;

public class Message {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.id
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.putrole
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    private String putrole;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.getrole
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    private String getrole;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.text
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    private String text;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.images
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    private String images;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.date
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    private Date date;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.id
     *
     * @return the value of message.id
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.id
     *
     * @param id the value for message.id
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.putrole
     *
     * @return the value of message.putrole
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public String getPutrole() {
        return putrole;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.putrole
     *
     * @param putrole the value for message.putrole
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public void setPutrole(String putrole) {
        this.putrole = putrole == null ? null : putrole.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.getrole
     *
     * @return the value of message.getrole
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public String getGetrole() {
        return getrole;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.getrole
     *
     * @param getrole the value for message.getrole
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public void setGetrole(String getrole) {
        this.getrole = getrole == null ? null : getrole.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.text
     *
     * @return the value of message.text
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public String getText() {
        return text;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.text
     *
     * @param text the value for message.text
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.images
     *
     * @return the value of message.images
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public String getImages() {
        return images;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.images
     *
     * @param images the value for message.images
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.date
     *
     * @return the value of message.date
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.date
     *
     * @param date the value for message.date
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    public void setDate(Date date) {
        this.date = date;
    }
}