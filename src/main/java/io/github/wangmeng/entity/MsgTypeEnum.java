package io.github.wangmeng.entity;

import java.util.ArrayList;
import java.util.List;

/**
* 消息类型
* @author RedWall
* @mail walkmanlucas@gmail.com
* @date 2019/5/9
* @since JDK 1.8
**/
public enum MsgTypeEnum {

    DING_MSG_TYPE_TEXT("text"),

    DING_MSG_TYPE_LINK("link"),

    DING_MSG_TYPE_MARKDOWN("markdown");

    protected String msgType;

    MsgTypeEnum(String msgType){
        this.msgType = msgType;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public static List<String> listAllType(){
        MsgTypeEnum[] msgTypeEnums = MsgTypeEnum.values();
        List<String> msgTypes = new ArrayList<String>();
        for (int i = 0; i < msgTypeEnums.length; i++) {
            msgTypes.add(msgTypeEnums[i].getMsgType());
        }
        return msgTypes;
    }
}
