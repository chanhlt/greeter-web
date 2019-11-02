package org.bhn.training.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.bhn.training.api.Greeter;

@Component(name = "Greeter Web", immediate = true)
@Service(value = javax.servlet.Servlet.class)
@Properties({ @Property(name = "servlet-name", value = "Greeter Web"),
		@Property(name = "alias", value = "/greeter-web") })
public class GreeterServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3330870013919653842L;

	@Reference
	private Greeter greeter;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (greeter != null) {
			resp.getWriter().write(greeter.greet());
		} else {
			resp.getWriter().write("Servlet Is Bound!");
		}
	}
}
