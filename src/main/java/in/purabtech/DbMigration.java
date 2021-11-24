package in.purabtech;

import in.purabtech.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DbMigration {

    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        User u1=new User();
        u1.setId(101);
        u1.setFullName("purab");
        u1.setUsername("admin");
        u1.setEmail("admin@admin.com");
        u1.setPassword("password");
        u1.setPhone("222222222222");



        session.save(u1);
        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();
    }
}
