package com.samya.news;

import java.io.IOException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import javax.servlet.annotation.WebServlet;


/**
 *
 * @author Samya
 */

@WebServlet(name="NewsServlet", urlPatterns={"/NewsServlet"})
public class NewsServlet extends HttpServlet {

	private Logger logger = Logger.getLogger(this.getClass());
	private RequestDispatcher newsJsp;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		newsJsp = context.getRequestDispatcher("/WEB-INF/News.jsp");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		logger.debug("Yahoo News");
		URL url = new URL("http://news.yahoo.com/rss/topstories");
		SyndFeedInput syndFeedInput = new SyndFeedInput();
		SyndFeed syndFeed = null;

		XmlReader xmlReader = new XmlReader(url);

		try {
			syndFeed = syndFeedInput.build(xmlReader);
		}
		catch (IllegalArgumentException e)
		{
			logger.error("", e);
		}
		catch (FeedException e)
		{
			logger.error("", e);
		}
		logger.debug("Forwarding to News.jsp");
		req.setAttribute("syndFeed", syndFeed);
		newsJsp.forward(req, resp);
	}
}
