package com.wyl.mail;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author by wyl
 * @date 2021/11/23.19点34分
 */

@Slf4j
@Service(value = "mailService")
public class MailServiceImpl implements MailService {

    @Resource
    private MailProperties mailProperties;

    @Resource
    private JavaMailSender mailSender;

    /**
     * 发送邮件
     * @param target   目标
     * @param title    标题
     * @param Content  内容
     * @param isHtml   包含HTML
     * @param enclosurePaths  附件路径
     * @return  true 成功
     */
    @SneakyThrows
    @Override
    public boolean sendMail(String target, String title, String Content, boolean isHtml, String[] enclosurePaths) {
        log.info("## Ready to send mail ...");
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(mailProperties.getUsername());   //邮件发送来源
        mimeMessageHelper.setTo(target);                           //邮件发送目标
        mimeMessageHelper.setSubject(title);                       //设置标题
        mimeMessageHelper.setText(Content, isHtml);                //设置内容 true 支持HTML false 不支持HTML
        if (enclosurePaths != null) {                              //添加附件
            for (int i = 0; i < enclosurePaths.length; i++) {
                FileSystemResource file = new FileSystemResource(enclosurePaths[i]);
                String attachmentsFileName = (i + 1) + new File(enclosurePaths[i]).getName();
                mimeMessageHelper.addAttachment(attachmentsFileName, file);
            }
        }
        mailSender.send(mimeMessage);
        log.info("## Send the mail success ...");
        return true;
    }

}
