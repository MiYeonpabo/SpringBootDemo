package com;

import com.Mail.MailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {

    @Autowired
    private MailServiceImpl mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void mailTest() throws Exception {
        mailService.sendSimpleMail("1746556696@qq.com", "test simple mail", "hello this is simple mail");
    }


    @Test
    public void mailTest1() throws Exception {
        String content = "<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("1746556696@qq.com", "test simple mail", content);
    }

    @Test
    public void mailTest2() throws Exception {
        String filePath = "D:\\index2.js";
        mailService.sendAttachmentsMail("1746556696@qq.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }

    @Test
    public void mailTest3() throws Exception {
        String rscId = "neo006";
        String content = "<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "D:\\img\\123.jpg";
        mailService.sendInlineResourceMail("1746556696@qq.com", "主题：带附件的邮件", content, imgPath, rscId);
    }

    //模板邮件
    @Test
    public void mailTest4() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("emailTemplate", context);
        mailService.sendHtmlMail("1746556696@qq.com", "主题：这是模板邮件", emailContent);
    }

}
