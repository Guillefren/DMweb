<%-- 
    Document   : pruebadatepicker
    Created on : 14/09/2014, 05:42:26 PM
    Author     : Guilleeu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.*,java.text.*" %>
 
<head>
    <title></title>
  <meta name="version"
</head>
<body bgcolor="white">

 
<%  // First get the month and year from the form.
  boolean yyok = false;  // -1 is a valid year, use boolean
  int yy = 0, mm = 0, dd=0;
  String yyString = request.getParameter("year");
  if (yyString != null && yyString.length(  ) > 0) {
    try {
      yy = Integer.parseInt(yyString);
      yyok = true;
    } catch (NumberFormatException e) {
      out.println("Year " + yyString + " invalid");
    }
  }
  Calendar c = Calendar.getInstance(  );
  if (!yyok)
    yy = c.get(Calendar.YEAR);
 
  String ddString = request.getParameter("day");
  if (ddString == null) {
    mm = c.get(Calendar.DAY_OF_MONTH);
  } else {
    for (int i=0; i<dias.length; i++)
      if (dias[i].equals(ddString)) {
        dd = i;
        break;
      }
  }
  
  String mmString = request.getParameter("month");
  if (mmString == null) {
    mm = c.get(Calendar.MONTH);
  } else {
    for (int i=0; i<months.length; i++)
      if (months[i].equals(mmString)) {
        mm = i;
        break;
      }
  }
%>
 
<form method=post action="pruebadatepicker.jsp">
    Dia: <select name = day>
        <% for (int i=0; i<dias.length; i++) {
            if (i==dd)
              out.print("<option selected>");
            else
              out.print("<option>");
            out.print(dias[i]);
            out.println("</option>");
  }
  %>
    </select>
  Mes: <select name=month>
  <% for (int i=0; i<months.length; i++) {
    if (i==mm)
      out.print("<option selected>");
    else
      out.print("<option>");
    out.print(months[i]);
    out.println("</option>");
  }
  %>
  </select>
  Año (4-digit): 
    <input type="text" size="5" name="year"
      value="<%= yy %>"></input>
  <input type=submit value="Display">
  
  
  
</form>
      
<%!
  /** The names of the months */
  String[] months = {
    "Enero", "Febrero", "Marzo", "Abril",
    "Mayo", "Junio", "Julio", "Agosto",
    "Septiembre", "Octubre", "Noviembre", "Deciembre"
  };
 
  String[] dias = {
    "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19",
      "20","21","22","23","24","25","26","27","28","29","30","31"
  };
  /** The days in each month. */
  int dom[] = {
      31, 28, 31, 30,  /* jan feb mar apr */
      31, 30, 31, 31, /* may jun jul aug */
      30, 31, 30, 31  /* sep oct nov dec */
  };
%>
 
<%
  /** The number of days to leave blank at the start of this month */
  int leadGap = 0;
%>




<%--
<table border=1>
<tr><th colspan=7><%= months[mm] %>  <%= yy %></tr>
 
<%    GregorianCalendar calendar = new GregorianCalendar(yy, mm, 1); %>
 
<tr><td>Dom<td>Lu<td>Ma<td>Mie<td>Ju<td>Vi<td>Sa</tr>
 
<%
    // Compute how much to leave before the first.
    // getDay(  ) returns 0 for Sunday, which is just right.
    leadGap = calendar.get(Calendar.DAY_OF_WEEK)-1;
 
    int daysInMonth = dom[mm];
    if (calendar.isLeapYear(calendar.get(Calendar.YEAR)) && mm == 1)
      ++daysInMonth;
 
    out.print("<tr>");
 
    // Blank out the labels before 1st day of month
    for (int i = 0; i < leadGap; i++) {
      out.print("<td>&nbsp;");
    }
 
    // Fill in numbers for the day of month.
    for (int i = 1; i <= daysInMonth; i++) {
 
      out.print("<td>");
      out.print(i);
      out.print("</td>");
 
      if ((leadGap + i) % 7 == 0) {    // wrap if end of line.
        out.println("</tr>");
        out.print("<tr>");
      }
    }
%>
</tr>
</table>

--%>


