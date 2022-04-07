
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author Komorebi
 * @since 2021.12.01.22:40
 */

public class JavaMailDemo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String USEREMAIL="";
        String PASSWORD="";
        final Properties props = new Properties();

        int choose=0;
        System.out.println("----------选择发件邮箱----------");
        System.out.println("---1 outlook邮箱    2 QQ邮箱---");
        choose = sc.nextInt();

        switch(choose){
            case 1:
                USEREMAIL = Password.outlookMail(); // 发件人称号，同邮箱地址
                PASSWORD = Password.outlookPassword(); // 可以使户端授权码
                props.put("mail.smtp.starttls.enable","true");
                props.put("mail.smtp.host", "smtp-mail.outlook.com");
                break;
            case 2:
                USEREMAIL = Password.QQMail(); // 发件人称号，同邮箱地址
                PASSWORD = Password.QQPassword(); // 可以使户端授权码
                props.put("mail.smtp.host", "smtp.qq.com");
                break;
            default:
                System.out.println("选择无效");
                return;
        }
        props.put("mail.smtp.auth", "true");
        props.put("mail.user", USEREMAIL);
        props.put("mail.password", PASSWORD);


        System.out.println("请输入收件方邮箱账号:");
        String to = sc.next();
        System.out.println("请输入邮件主题:");
        String title = sc.next();
        System.out.println("请输入发送内容:");
        String text = "";
        while(!sc.hasNext("...")){
            text+=sc.next();
        }
        sc.next();
        try{
        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        //使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
            // 创建邮件消息
            MimeMessage message = new MimeMessage(mailSession);

            // 设置发件人
            String username = props.getProperty("mail.user");
            InternetAddress form = new InternetAddress(username);
            message.setFrom(form);

            // 设置收件人
            InternetAddress toAddress = new InternetAddress(to);
            message.setRecipient(Message.RecipientType.TO, toAddress);

            // 设置邮件标题
            message.setSubject(title);
            //"text/html;charset=UTF-8"
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(text);

            //创建多重消息
            Multipart multipart = new MimeMultipart();

            //设置文本消息部分
            multipart.addBodyPart(messageBodyPart);

            //附件部分
            System.out.println("是否发送附件? 1 or 0");
            int bool = sc.nextInt();
            if (bool==1) {
                System.out.println("请输入附件的路径:");
                String filepath = sc.next();
                messageBodyPart = new MimeBodyPart();
                FileDataSource source = new FileDataSource(filepath);
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(filepath);
                multipart.addBodyPart(messageBodyPart);
            }
            // 设置邮件的内容体
            message.setContent(multipart);

            // 发送邮件
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
// E:\IDEA-java\mail\src\JavaMailDemo.java

