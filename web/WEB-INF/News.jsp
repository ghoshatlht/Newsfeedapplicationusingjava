<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="com.sun.syndication.feed.synd.SyndFeed" %>
<%@ page import="com.sun.syndication.feed.synd.SyndEntry" %>
<%@ page import="java.util.Iterator" %>
<jsp:useBean id="syndFeed" scope="request" type="SyndFeed" />
<html>
   <head>
      <title>NewsReader</title>

      <meta name="google-translate-customization" content="a648e4b2b9009c0f-ca96432aba1106ac-gb7380bc44e8f6cea-10"></meta>

   </head>


   <body>

   
      <h1>Yahoo News for Today</h1>




      <div id="google_translate_element"></div><script type="text/javascript">
function googleTranslateElementInit() {
  new google.translate.TranslateElement({pageLanguage: 'en', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');
}
</script><script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>







      <h2><%=syndFeed.getTitle()%></h2>
      <ul>
         <%
           Iterator it = syndFeed.getEntries().iterator();
           while (it.hasNext())
           {
              SyndEntry entry = (SyndEntry) it.next();
         %>
            <li>
               <a href="<%=entry.getLink()%>"><%=entry.getTitle()%></a>
            </li>
         <% } %>
      </ul>
   </body>
</html>
