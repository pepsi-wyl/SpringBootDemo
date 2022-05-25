package com.wyl;

import com.wyl.mail.MailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MailApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MailApplication.class, args);
        MailService service = run.getBean("mailService", MailService.class);
        String[] str = {"C:\\Users\\Lenovo\\Desktop\\82953346.jpg"};
        while (true){
            System.out.println(service.sendMail("2932364636@qq.com", "title", "Test", true, str));
        }
    }
}
