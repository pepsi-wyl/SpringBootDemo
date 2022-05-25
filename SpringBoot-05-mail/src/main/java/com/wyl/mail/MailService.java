package com.wyl.mail;

/**
 * @author by wyl
 * @date 2021/11/23.19点56分
 */

public interface MailService {

    /**
     * 发送邮件
     *
     * @param target         目标
     * @param title          标题
     * @param Content        内容
     * @param isHtml         包含HTML
     * @param enclosurePaths 附件路径
     * @return true 成功
     */
    boolean sendMail(String target, String title, String Content, boolean isHtml, String[] enclosurePaths);


}
