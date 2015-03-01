package demo.app.utilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class AppHelper {

  private static Configuration config;
  private static SessionFactory factory;
  static AppHelper helper;
  
  private AppHelper() {
    config = new Configuration();
    config.configure("hibernate.cfg.xml");
    factory = config.buildSessionFactory();
  }

  public static AppHelper getInstance(){
    if(helper == null)
        helper = new AppHelper();
    return helper;
  }
  
  public Session getAppSession() {    
    Session session = factory.openSession();
    return session;
  }
}
