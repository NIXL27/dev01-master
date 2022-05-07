package com.fc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@SpringBootTest
public class MailTest {
    // java的邮件发送器
    @Autowired
    private JavaMailSender sender;

    @Test
    void testHtmlMail() {
        String content = "<h1>想屁吃！</h1>";

        // html类型邮件
        MimeMessage mimeMessage = sender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        try {
            helper.setFrom("2904937506@qq.com");

            helper.setTo("412790423@qq.com");

            helper.setCc("1977331678@qq.com");
            helper.setBcc("635702657@qq.com");

            helper.setSubject("简历邀请");

            helper.setText(content, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        sender.send(mimeMessage);
    }

    @Test
    void testSimpleMail() {
        // 创建一个简单邮件对象
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        // 设置发件人
        simpleMailMessage.setFrom("2904937506" +
                "@qq.com");

        // 设置收件人
        simpleMailMessage.setTo("412790423@qq.com");

        // 设置邮件的主题
        simpleMailMessage.setSubject("面试通知");

        // 设置邮件的内容
        simpleMailMessage.setText("尊敬的面试者你好，未来富婆培训室诚挚邀请您于周三晚上来9-640面试");

        simpleMailMessage.setCc("1977331678@qq.com");
        simpleMailMessage.setBcc("635702657@qq.com");

        sender.send(simpleMailMessage);
    }
}
