package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.CartDaoImpl;
import dao.impl.UserDaoImpl;
import entity.User;



/**
 * Servlet implementation class BuyServlet
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		double total=Double.parseDouble(request.getParameter("total"));
		String username=(String) request.getSession().getAttribute("username");
		UserDaoImpl dao=new UserDaoImpl();
		User user=(User) dao.findUserByUsername(username);
		double result=0;
		String cont=null;
		result=user.getMoney()-total;
		if(result<0)
		{
			//cont="金钱不足，请充值";
			out.print("<script>alert('金钱不足，请充值');location.href='index.jsp';</script>");
			
			return;
		}
		user.setMoney(result);
		UserDaoImpl udao=new UserDaoImpl();
		udao.update(user);
		CartDaoImpl cdao = new CartDaoImpl();
		cdao.delByUsername(username);
		cont=user.getUsername()+"你好,"
				+ "你已经成功购买指定商品,花费"+total+"元，"
				+ "请等待发货。"
				+ "账户当前余额为"+user.getMoney();
		//SendMailUtil util=new SendMailUtil();
		//util.send(cont);
		
//		
//		SendEmailUtils utils=new SendEmailUtils();
//		utils.myEmailAccount="lanyingninja@163.com";
//		utils.myEmailPassword="j13676163882";
		//out.print("<script>alert('购买成功');location.href='index.jsp';</script>");
		request.setAttribute("dst", user.getEmail());
		request.setAttribute("cont", cont);
		request.getRequestDispatcher("/sendMail").forward(request, response);
		 
		return;
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
