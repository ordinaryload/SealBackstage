package load.enumcollection;

public enum ReplyTypeEnum {
    COMMENT_REPLY("message"),REPLY_REPLY("communicate");

    private String reply;

    ReplyTypeEnum(String reply) {
        this.reply = reply;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
