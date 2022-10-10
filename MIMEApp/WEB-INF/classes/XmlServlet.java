//XmlServlet.java
package com.nt.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class XmlServlet extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		//set the content type
		res.setContentType("text/xml");
		//get printwriter
		PrintWriter pw = res.getWriter();
		//write the output to res obj
		pw.println("<table border='1' align='center' >");
		pw.println("<tr> <th>Player Name</th> <th>category</th> <th>medal</th></tr>");
		pw.println("<tr> <td>Neraj chopra</td> <td>javelin</td> <td>gold</td></tr>");
		pw.println("<tr> <td>Meera Bai Chanu</td> <td>weight lifting</td> <td>silver</td></tr>");
		pw.println("<tr> <td>RaviKumar</td> <td>wrestling</td> <td>silver</td></tr>");
		pw.println("<tr> <td>P.V sindhu</td> <td>badminton</td> <td>bronze</td></tr>");
		pw.println("<tr> <td>Lovlina</td> <td>boxing</td> <td>bronze</td></tr>");
		pw.println("<tr> <td>Hokey</td> <td>Hokey</td> <td>bronze</td></tr>");
		pw.println("<tr> <td>Bajarang</td> <td>wrestling</td> <td>bronze</td></tr>");
		pw.println("</table>");
		//close Steams
		pw.close();
		}//service
	}//class
		
		
		
		
		