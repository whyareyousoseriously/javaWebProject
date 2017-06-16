package servlet2;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.po.Users;

public class registerServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public registerServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//指定request字符集防止中文乱码
		request.setCharacterEncoding("utf-8");
		Users u = new Users();
		String username = request.getParameter("UserName");
		String password = request.getParameter("UserPassword");
		String nickName=request.getParameter("NickName");
		String sex=request.getParameter("Sex");
		String email=request.getParameter("Email");
		u.setUsername(username);
		u.setPassword(password);
		System.out.println(username+"\t"+u.getPassword());
		//向web库中userData表中插入数据
		try {
			final String url="jdbc:mysql://localhost:3306/web";
			final String user="root";
			final String pwd="123456";
			
			//1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//2.获得数据库的连接
			Connection conn=(Connection) DriverManager.getConnection(url,user,pwd);
			//3.操作数据库插入注册的数据
			PreparedStatement pstmt=(PreparedStatement) conn.prepareStatement("insert userData values(?,?,?,?,?)");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, nickName);
			if(sex=="1")
				pstmt.setString(4, "男");
			else
				pstmt.setString(4, "女");
			pstmt.setString(5, email);
			pstmt.execute();
			pstmt.close();
			conn.close();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/register_success.jsp");
	}
	/*public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Users u = new Users();
		String username = request.getParameter("UserName");
		String password = request.getParameter("UserPassword");
		u.setUsername(username);
		u.setPassword(password);
		System.out.println(username+"\t"+u.getPassword());
		//向文件中写入用户名和密码
		OutputStream out=new FileOutputStream("C:/Users/cz826/Workspaces/MyEclipse 2016 CI/login/WebRoot/test.txt",true);
		OutputStreamWriter writer=new OutputStreamWriter(out,"Unicode");
		BufferedWriter bw=new BufferedWriter(writer);
		PrintWriter pw=new PrintWriter(bw);
		pw.print(u.getUsername()+"\n");
		pw.print(u.getPassword()+"\n");
		pw.close();
		bw.close();
		writer.close();
		out.close();
		response.sendRedirect(request.getContextPath()+"/register_success.jsp");
	}*/

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
