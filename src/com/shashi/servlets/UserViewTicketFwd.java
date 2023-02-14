package com.shashi.servlets;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.shashi.utility.DBConnection;
@SuppressWarnings("serial")
public class UserViewTicketFwd extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		Cookie ck[] = req.getCookies();
		if(ck!=null) {
			String uName = ck[0].getValue();
			if(!uName.equals("")||uName!=null) {
				try {
					Connection con = DBConnection.getCon();
					PreparedStatement ps = con.prepareStatement("Select * from ticket2");
					ResultSet rs = ps.executeQuery();
					if(rs.next()) 
					{
						RequestDispatcher rd = req.getRequestDispatcher("UserViewTicket.html");
						rd.include(req, res);
						pw.println("<div class='tab'>" + 
								"		<p1 class='menu'>" + 
								"	Hello "+uName+" ! ! Welcome to our new TIMRS Website" + 
								"		</p1>" + 
								"	</div>");
						pw.println("<div class='main'><p1 class='menu'>Your Tickets</p1></div>");
						pw.println("<div class='tab'><table><tr><th>PNR</th><th>Train Name</th><th>Train Number</th>"
								+ "<th>From Station</th><th>To Station</th><th>Seats Booked</th>");
						String pnr;
						long trainNo;
						String trainName;
						String fromStn;
						String toStn;
						String seat;
						do {
							 pnr = rs.getString("pnr");
							 trainName = rs.getString("tr_name");
							 trainNo = rs.getLong("tr_number");
							 fromStn = rs.getString("from_stn");
							 toStn = rs.getString("to_stn");
							 seat = rs.getString("seat");
								pw.println(""
								+ "<tr> "
								+ ""
								+ "<td>"+pnr+"</td>"
								+ "<td>"+trainName+"</td>"
								+ "<td>"+trainNo+"</td>"
								+ "<td>"+fromStn+"</td>"
								+ "<td>"+toStn+"</td>"
								+ "<td>"+seat+"</td>"
							);
						}while(rs.next());
						pw.println("</table></div>");
					}
					else {
						RequestDispatcher rd = req.getRequestDispatcher("UserViewTicket.html");
						rd.include(req, res);
						
					}
				}
				catch(Exception e) {}
			}
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("UserLogin.html");
			rd.include(req, res);
			pw.println("<div class='tab'><p1 class='menu'>Please Login first !</p1></div>");
		}
	}

}
