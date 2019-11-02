package org.bhn.training.web;

import java.io.IOException;
import java.util.Locale;

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
import org.bhn.training.web.models.Customer;
import org.bhn.training.web.models.LastProduct;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

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

	static Configuration cfg;
	static {
		cfg = new Configuration();

		// Where do we load the templates from:
		cfg.setClassForTemplateLoading(GreeterServlet.class, "/templates");

		// Some other recommended settings:
		cfg.setIncompatibleImprovements(new Version(2, 3, 20));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setLocale(Locale.US);
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Template template = cfg.getTemplate("index.ftl");

//		if (greeter != null) {
//			resp.getWriter().write(greeter.greet());
//		} else {
//			resp.getWriter().write("Servlet Is Bound!");
//		}
		Customer data = new Customer();
		data.setUser("Chanh");
		LastProduct latestProduct = new LastProduct();
		latestProduct.setName("Tooth paste");
		latestProduct.setUrl("http://amazon.com/tooth-paste");
		data.setLatestProduct(latestProduct);
		try {
			template.process(data, resp.getWriter());
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
}
