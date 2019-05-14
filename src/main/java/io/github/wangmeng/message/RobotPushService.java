package io.github.wangmeng.message;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import io.github.wangmeng.config.RobotProperties;
import io.github.wangmeng.entity.MsgTypeEnum;
import io.github.wangmeng.exception.DingDingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.Arrays;

@Slf4j
public class RobotPushService {

    @Autowired
    private RobotProperties robotProperties;

    /**
    * 发送信息
    * @author RedWall walkmanlucas@gmail.com
    * @param textMsg 消息内容
    * @param atMobiles @who
    * @param message_url link type下 指定的跳转地址
    * @param pic_url link type下 指定的显示的图片url
    * @param title link | markdown type下 指定的显示的title
    * @param msgType 消息类型 text | link | markdown
    * @return Boolean
    **/
    public Boolean sendMsg(String textMsg, String msgType,
                           String[] atMobiles, String message_url,
                           String pic_url, String title){
        if (!MsgTypeEnum.listAllType().contains(msgType)){
            log.error("illegal msgType when dingding robot send message");
            throw new DingDingException("illegal msgType");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient
                    ("https://oapi.dingtalk.com/robot/send?access_token=" + robotProperties.getAccess_token());
            OapiRobotSendRequest request = new OapiRobotSendRequest();
            request.setMsgtype(msgType);
            if (MsgTypeEnum.DING_MSG_TYPE_TEXT.getMsgType().equals(msgType)){
                OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
                text.setContent(StringUtils.isEmpty(textMsg) ? robotProperties.getContent() : textMsg);
                request.setText(text);
                OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
                if (atMobiles.length > 0){
                    at.setAtMobiles(Arrays.asList(atMobiles));
                }else {
                    log.warn("Not specified @who");
                }
                request.setAt(at);
            }else if (MsgTypeEnum.DING_MSG_TYPE_LINK.getMsgType().equals(msgType)){
                OapiRobotSendRequest.Link link = new OapiRobotSendRequest.Link();
                link.setMessageUrl(StringUtils.isEmpty(message_url) ? robotProperties.getMessage_url() : message_url);
                link.setPicUrl(StringUtils.isEmpty(pic_url) ? robotProperties.getPic_url() : pic_url);
                link.setTitle(StringUtils.isEmpty(title) ? robotProperties.getTitle() : title);
                link.setText(StringUtils.isEmpty(textMsg) ? robotProperties.getText() : textMsg);
                request.setLink(link);
            }else {
                OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
                markdown.setTitle(StringUtils.isEmpty(title) ? robotProperties.getTitle() : title);
                markdown.setText(StringUtils.isEmpty(textMsg) ? robotProperties.getText() : textMsg);
                request.setMarkdown(markdown);
            }
            OapiRobotSendResponse response = client.execute(request);
            return response.isSuccess();
        }catch (ApiException e){
            log.error(e.getErrMsg());
        }
        return false;
    }
}
