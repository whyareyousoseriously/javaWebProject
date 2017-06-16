package servlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.po.Users;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//指定request字符集防止中文乱码
				request.setCharacterEncoding("utf-8");
		Users u = new Users();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		u.setUsername(username);
		u.setPassword(password);
		//控制台显示从表单中得到的username,password
		System.out.println("从表单中得到的用户名和密码信息");
		System.out.println("用户名"+u.getUsername()+"长度: "+u.getUsername().length());
		System.out.println("密码"+u.getPassword()+"长度:"+u.getPassword().length());
		//从数据库中读取用户名和密码
		
		try {
			final String url="jdbc:mysql://localhost:3306/web";
			final String user="root";
			final String pwd="123456";
			int mark=0;//查找成功的标志
			//1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//2.获得数据库的连接
			Connection conn=(Connection) DriverManager.getConnection(url,user,pwd);
			//3.操作数据库
			Statement stmt=(Statement) conn.createStatement();
			ResultSet rs=stmt.executeQuery("select userName,passWord,nickName  from userData");
			while(rs.next()){
				//控制台显示从文件中得到的用户名和密码信息
				System.out.println(rs.getString("userName")+","+rs.getString("passWord"));
				//判断用户名和密码是否合法
				if(u.getUsername().equals(rs.getString("userName").trim())&&u.getPassword().equals(rs.getString("passWord").trim()))
				{
					mark=1;
					
					//把成功登陆的用户昵称对象保存在session中
					request.getSession().setAttribute("loginUser",rs.getString("nickName"));
					
					response.sendRedirect(request.getContextPath()+"/login_success.jsp");
				}
			}
			if(mark==0){
				//查找失败
				response.sendRedirect(request.getContextPath()+"/login_failure.jsp");
			}
			stmt.close();
			conn.close();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
/*	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Users u = new Users();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		u.setUsername(username);
		u.setPassword(password);
		//控制台显示从表单中得到的username,password
		System.out.println("从表单中得到的用户名和密码信息");
		System.out.println("用户名"+u.getUsername()+"长度: "+u.getUsername().length());
		System.out.println("密码"+u.getPassword()+"长度:"+u.getPassword().length());
		
		//从文件中读取用户名和密码
		InputStream in=new FileInputStream("C:/Users/cz826/Workspaces/MyEclipse 2016 CI/login/WebRoot/test.txt");
		//采用默认字符集读取文件
		InputStreamReader reader=new InputStreamReader(in,"Unicode");
		BufferedReader br=new BufferedReader(reader);
		String fileName;
		String filePassword;
		int mark=0;//查找成功的标志
		
		//控制台提示登陆查询中
		System.out.println("登陆查询中......");
		
		while((fileName=(br.readLine()))!=null){
			filePassword=(br.readLine());
			//截取fileName从第一个字符到最后一个字符的子字符串
			//原因是在registerServlet中向文件中写入字符串的时候，不知道为何会在字符串起始位置加上65279非法字符
			//因此手动向txt文件中添加用户名的密码的时候要在用户名第1个字符开始写用户名
			fileName=fileName.substring(1);
			//控制台显示从文件中得到的用户名和密码信息
			System.out.println("从文件中得到的用户名和密码信息");
			System.out.println("用户名"+fileName+"长度: "+fileName.length());
			System.out.println("密码"+filePassword+"长度:"+filePassword.length());
			//判断用户名和密码是否合法
			if(u.getUsername().equals(fileName.trim())&&u.getPassword().equals(filePassword.trim()))
			{
				mark=1;
				//把成功登陆的用户对象保存在session中
				request.getSession().setAttribute("loginUser", u.getUsername());
				
				response.sendRedirect(request.getContextPath()+"/login_success.jsp");
			}
		}
		if(mark==0){
			//查找失败
			response.sendRedirect(request.getContextPath()+"/login_failure.jsp");
		}
		
		//关闭文件
			br.close();
			reader.close();
			in.close();
		
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
