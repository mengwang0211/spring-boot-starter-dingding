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

import java.util.Arrays;

@Slf4j
public class RobotPushService {

    @Autowired
    private RobotProperties robotProperties;

    /**
    * 发送信息
    * @author RedWall
    * @mail walkmanlucas@gmail.com
    * @param textMsg 消息内容
    * @param msgType 消息类型 text | link | markdown
    * @date 2019/5/9
    * @return 
    **/
    public Boolean sendMsg(String textMsg, String msgType){
        if (!MsgTypeEnum.listAllType().contains(msgType)){
            throw new DingDingException("illegal msgType");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient
                    ("https://oapi.dingtalk.com/robot/send?access_token=" + robotProperties.getAccess_token());
            OapiRobotSendRequest request = new OapiRobotSendRequest();
            request.setMsgtype(msgType);
            if (MsgTypeEnum.DING_MSG_TYPE_TEXT.getMsgType().equals(msgType)){
                OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
                text.setContent(textMsg);
                request.setText(text);
                OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
                at.setAtMobiles(Arrays.asList(robotProperties.getAtMobiles().split(",")));
                request.setAt(at);
            }else if (MsgTypeEnum.DING_MSG_TYPE_LINK.getMsgType().equals(msgType)){
                OapiRobotSendRequest.Link link = new OapiRobotSendRequest.Link();
                link.setMessageUrl(robotProperties.getMessage_url());
                link.setPicUrl(robotProperties.getPic_url());
                link.setTitle(robotProperties.getTitle());
                link.setText(textMsg);
                request.setLink(link);
            }else {
                OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
                markdown.setTitle(robotProperties.getTitle());
                markdown.setText(textMsg);
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
