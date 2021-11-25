package in.purabtech.hooks;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AppListner
 *
 */
@WebListener
public class AppListner implements ServletContextListener {



    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  {
        System.out.println("Listner destroy method");
        EntityManagerFactory emf= (EntityManagerFactory) sce.getServletContext().getAttribute("emf");
        emf.close();

    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {
        //This code will create tables through hibernate and execute scmTest-> migration schema - setting in persistence.xml
        System.out.println("Listner init method");
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("scmTest");
        sce.getServletContext().setAttribute("emf", emf);

    }

}