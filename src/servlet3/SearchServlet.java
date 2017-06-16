package servlet3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class SearchServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public SearchServlet() {
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
		final String url="jdbc:mysql://localhost:3306/web";
		final String user="root";
		final String pwd="123456";
		int mark=0;
		//1.加载驱动程序
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2.获得数据库的连接
		try {
			Connection conn = (Connection) DriverManager.getConnection(url,user,pwd);
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs=stmt.executeQuery("select word,meaning  from wordsData");
			while(rs.next()){
				if(request.getParameter("word").equals(rs.getString("word"))){
					//把单词和单词的意思保存在session中
					request.getSession().setAttribute("word",rs.getString("word"));
					request.getSession().setAttribute("meaning",rs.getString("meaning"));
					request.getSession().setAttribute("mark","成功");
					mark=1;
				}
			}
			if(mark==0){
				request.getSession().setAttribute("word","null");
				request.getSession().setAttribute("meaning","null");
				request.getSession().setAttribute("mark","失败");
			}
			response.sendRedirect(request.getContextPath()+"/search.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
