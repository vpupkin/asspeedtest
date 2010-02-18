import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class SpeedTest extends HttpServlet implements SingleThreadModel{
             
	 //=======================================================================
	  // Init
	  //=======================================================================
	  public void init(ServletConfig config) throws ServletException {
		super.init(config);
	  }
	  //=======================================================================
	  // Clean up resources - destroy
	  //=======================================================================
	  public void destroy() {
		super.destroy();
	  }

	  //=======================================================================
	  // Process the HTTP Get request*/
	  //=======================================================================
	  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Steuerung(request,response);
	  }
	  
	  //=======================================================================
	  // Process the HTTP Post request*/
	  //=======================================================================
	  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Steuerung(request,response);
	  }
	  
	  public void Steuerung(HttpServletRequest request,HttpServletResponse response)
	  {
		 try
		 {
			 PrintWriter out = response.getWriter();
			 response.setHeader( "Pragma", "no-cache" );
			 response.addHeader( "Cache-Control", "must-revalidate" );
			 response.addHeader( "Cache-Control", "no-cache" );
			 response.addHeader( "Cache-Control", "no-store" );
			 response.setDateHeader("Expires", 0);
			 response.setContentType("text/html;charset=utf-8");

			 String cmd=request.getParameter("cmd");
			 byte b=1;
			 if(cmd.equals("1"))
			 {
				 char[] t=new char[32*1024];
		//		 out.write(t);
				 out.write(t, 0, t.length);
			 }
			 else if(cmd.equals("2"))
			 {
				 char[] t=new char[64*1024];
				 out.write(t, 0, t.length); 
			 }
			 else if(cmd.equals("3"))
			 {
				 char[] t=new char[128*1024];
				 out.write(t, 0, t.length); 
			 }
			 else if(cmd.equals("4"))
			 {
				 char[] t=new char[256*1024];
				 out.write(t, 0, t.length); 
			 }
			 else if(cmd.equals("5"))
			 {
				 char[] t=new char[512*1024];
				 out.write(t, 0, t.length); 
			 }
			 else if(cmd.equals("6"))
			 {
				 char[] t=new char[1*1024*1024];
				 out.write(t, 0, t.length); 
			 }
			 else if(cmd.equals("7"))  
			 {
				 char[] t=new char[2*1024*1024];
				 out.write(t, 0, t.length);   
			 }
			 else if(cmd.equals("8"))  
			 {
				 char[] t=new char[4*1024*1024];
				 out.write(t, 0, t.length);   
			 }
			
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	  }
	 
}
