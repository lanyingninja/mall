package servlets;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.util.MailSSLSocketFactory;



@WebServlet("/sendMail")
public class SendMail extends HttpServlet {
	 
    /**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Properties props = new Properties();
            String dstaddress=(String) request.getAttribute("dst");
            String cont=(String) request.getAttribute("cont");
 
            // 开启debug调试
            props.setProperty("mail.debug", "true");
            // 发送服务器需要身份验证
            props.setProperty("mail.smtp.auth", "true");
            // 设置邮件服务器主机名
            props.setProperty("mail.host", "smtp.163.com");
            // props.setProperty("mail.port", "465");
            // 发送邮件协议名称
            props.setProperty("mail.transport.protocol", "smtp");
 
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.socketFactory", sf);
 
            Session session = Session.getInstance(props);
 
            Message msg = new MimeMessage(session);
            msg.setSubject("skylake商城");
            StringBuilder builder = new StringBuilder();
            //            builder.append("url = " + "http://blog.csdn.net/never_cxb/article/details/50524571");
            builder.append("\nhello");
            builder.append("\n"+cont);
            builder.append("\n时间 " + new Date());
            msg.setText(builder.toString());
            msg.setFrom(new InternetAddress("lanyingninja@163.com"));
 
            Transport transport = session.getTransport();
            transport.connect("smtp.163.com", "lanyingninja@163.com", "ljc1634");
            
            
            transport.sendMessage(msg, new Address[] { new InternetAddress(dstaddress) });
 
            transport.close();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
 
        request.setAttribute("message", "购买成功,请注意查收邮件");
        request.getServletContext().getRequestDispatcher("/mailsucc.jsp").forward(request, response);
 
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}

