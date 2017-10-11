package org.key.sample.appstatus;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import net.sf.appstatus.web.StatusServlet;

@WebServlet(value = "/status", initParams = @WebInitParam(name = "bean", value = "appstatus"))
public class AppstatusServlet extends StatusServlet {
    private static final long serialVersionUID = 1L;

}
