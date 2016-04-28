package cn.dwd.mail.notpattern;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.sohu.sendcloud.Message;
import com.sohu.sendcloud.SendCloud;

public class SendCloudUtil {

    /**
     * @param host sendCloud发信域名下的帐号和密码
     * @param pwd sendCloud发信域名下的密码
     * @param fromAddress 发信人地址，后缀统一@sendcloud.com
     * @param fromName 发信人名称
     * @param subject 标题
     * @param content 内容(html)
     * @param recipients 接收人，多个之间用;拼接
     * @param cc 抄送，多个之间用;拼接
     * @param bcc 暗抄送，多个之间用;拼接
     * @param relay 回复人(仅支持一个地址)
     * @param fileArr 附件，路径+文件名称
     */
    public static void sendMail(String host, String pwd, String fromAddress, String fromName, String subject,
            String content, String recipients, String cc, String bcc, String relay, String[] fileArr) throws Exception {
        Message message = new Message(fromAddress, fromName);
        message.setSubject(subject);
        message.setBody(content);
        message.addRecipients(convertStr2List(recipients));
        List<String> bccList = convertStr2List(bcc);
        List<String> ccList = convertStr2List(cc);
        if (bccList != null && bccList.size() > 0) {
            message.setBcc(bccList);
        }
        if (ccList != null && ccList.size() > 0) {
            message.setCc(ccList);
        }
        if (StringUtils.isNotBlank(relay)) {
            message.setReplyAddress(relay);
        }
        List<Map<String, String>> list = getFileList(fileArr);
        if (list != null && list.size() > 0) {
            message.setAttachments(list);
        }
        // SendCloud sendCloud = new SendCloud("postmaster@focus-dc.sendcloud.org", "u5nZFHIK");
        SendCloud sendCloud = new SendCloud(host, pwd);
        sendCloud.setMessage(message);
        sendCloud.send();
    }

    private static List<Map<String, String>> getFileList(String[] fileArr) {
        if (fileArr == null || fileArr.length == 0) {
            return null;
        }
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (String str : fileArr) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("name", getFileName(str));
            map.put("file", str);
            list.add(map);
        }
        return list;
    }

    private static String getFileName(String filePath) {
        int index = filePath.lastIndexOf(File.separator);
        return filePath.substring(index + 1);
    }

    private static List<String> convertStr2List(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        String[] arr = StringUtils.split(str, ";");
        if (arr.length == 0) {
            return null;
        }
        return Arrays.asList(arr);
    }

}