package in.technexus.listener;

import in.technexus.utility.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;

public class DBConnectionListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public DBConnectionListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        String url = sc.getInitParameter("url");
        String username = sc.getInitParameter("username");
        String password = sc.getInitParameter("password");
        DBUtil.openConnection(url, username, password);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DBUtil.closeConnection();
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}