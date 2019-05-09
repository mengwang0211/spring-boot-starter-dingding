package io.github.wangmeng.config;

public class RobotConfiguration {


    /**
     *  机器人 token
     */
    private String access_token = "access_token";

    /**
     *  消息类型 text link markdown [Default ==> text ]
     */
    private String msg_type = "text";



    /*----------------------------------------------分割线------------------------------------------------------------*/


    /**
     *  当msg_type == text 消息内容
     */
    private String content = "content";



    /**
     *  当msg_type == text @who [手机号]
     */
    private String atMobiles = "atMobiles";


    /*----------------------------------------------分割线------------------------------------------------------------*/


    /**
     *  当msg_type == link or markdown title
     */
    private String title = "This is title";


    /**
     *  当msg_type == link or markdown  text
     */
    private String text = "This is text";


    /*----------------------------------------------分割线------------------------------------------------------------*/


    /**
     *  当msg_type == link  message_url
     */
    private String message_url = "https://www.baidu.com";


    /**
     *  当msg_type == link  pic_url
     */
    private String pic_url = "https://f11.baidu.com/it/u=3015675601,699552073&fm=72";



    /*----------------------------------------------分割线------------------------------------------------------------*/


    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getMsg_type() {
        return msg_type;
    }

    public void setMsg_type(String msg_type) {
        this.msg_type = msg_type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAtMobiles() {
        return atMobiles;
    }

    public void setAtMobiles(String atMobiles) {
        this.atMobiles = atMobiles;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMessage_url() {
        return message_url;
    }

    public void setMessage_url(String message_url) {
        this.message_url = message_url;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

}
