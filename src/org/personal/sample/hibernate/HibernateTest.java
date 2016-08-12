package org.personal.sample.hibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.personal.sample.domain.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by jitin on 3/6/16.
 */
public class HibernateTest {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    public static void createSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure();

        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static void main(String[] args){
        /*
        //Address address1 = new Address("SN", "ND", "Delhi", "110065");
        //Address address2 = new Address("MX", "DL", "Delhi", "110069");
        //Address address3 = new Address("VM", "KD", "Delhi", "110022");

        //User user1 = new User("Shah", new Date());
        //User user2 = new User("Rukh", new Date());
        //User user3 = new User("Khan", new Date());

        //Vehicle vehicle = new Vehicle("Vehicle");
        //TwoWheeler bike = new TwoWheeler("Bike", "Handle");
        //FourWheeler car = new FourWheeler("Car", "Steering Wheel");


        //user1.getVehicles().add(vehicle2);
        //user1.getVehicles().add(vehicle3);
        //user2.getVehicles().add(vehicle1);
        //user2.getVehicles().add(vehicle3);
        //user3.getVehicles().add(vehicle1);
        //user3.getVehicles().add(vehicle2);

        vehicle1.getUsers().add(user2);
        vehicle1.getUsers().add(user3);
        vehicle2.getUsers().add(user1);
        vehicle2.getUsers().add(user3);
        vehicle3.getUsers().add(user1);
        vehicle3.getUsers().add(user2);

        Transaction transaction = null;
        Session session = null;

        /*user1.getAddresses().add(address1);
        user1.getAddresses().add(address2);
        user2.getAddresses().add(address1);
        user2.getAddresses().add(address3);
        user3.getAddresses().add(address2);
        user3.getAddresses().add(address3);

        try{
            createSessionFactory();
            //session = sessionFactory.openSession();
            //transaction = session.beginTransaction();
            //session.save(vehicle);
            //session.save(car);
            //session.save(bike);

            for(int i = 0; i < 10; i++){
                User user = new User("User" + (i + 1), new Date());
                //session.save(user);
            }

            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.gt("userId", 5));
            criteria.setProjection(Projections.property("userName"));


            //Query query = session.createQuery("from User where userId > ?");
            //query.setInteger(0, 3);

            //query.setFirstResult(2);
            //query.setMaxResults(4);

            //List<User> users=  query.list();

            //List<User> users = criteria.list();
            List<String> users = criteria.list();

            //for(User u : users){
            for(String u : users){
                System.out.println(u);
            }

            //session.save(vehicle1);
            //session.save(vehicle2);
            //session.save(vehicle3);

            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                System.out.println("Transaction could not commit successfully!");
                transaction.rollback();
            }
        }finally {
            if(session != null)
               session.close();
        }

        */

        Transaction transaction = null;
        Session session = null;


        // Creating organizations
        Organization organization1 = new Organization("TTND", "Noida Sec - 127");
        Organization organization2 = new Organization("Nagarro", "Gurgaon");

        // Creating employees
        Employee employee1 = new Employee("JD", "9899188368", new Date());
        Employee employee2 = new Employee("Bishnu", "1234567890", new Date());
        Employee employee3 = new Employee("Sharma", "9191919191", new Date());
        Employee employee4 = new Employee("Deb", "9192949595", new Date());


        // Creating licences
        Licence licence1 = new Licence("DL-123456789", new Date());
        Licence licence2 = new Licence("DL-156783339", new Date());
        Licence licence3 = new Licence("DL-178900010", new Date());
        Licence licence4 = new Licence("DL-123453339", new Date());


        // Creating teams
        Team team1 = new Team("Infra");
        Team team2 = new Team("Bootcamp");
        Team team3 = new Team("Intellimeet");


        // Setting employee licences
        employee1.setLicence(licence1);
        employee2.setLicence(licence2);
        employee3.setLicence(licence3);
        employee4.setLicence(licence4);


        // Assigning employees to teams
        employee1.getTeams().add(team1);
        employee1.getTeams().add(team3);
        employee2.getTeams().add(team2);
        employee3.getTeams().add(team3);
        employee4.getTeams().add(team1);
        employee4.getTeams().add(team2);
        employee4.getTeams().add(team3);


        // Assigning employees to organizations
        organization1.getEmployees().add(employee1);
        organization1.getEmployees().add(employee2);
        organization2.getEmployees().add(employee3);
        organization2.getEmployees().add(employee4);


        // Assigning organization to employees
        employee1.setOrganization(organization1);
        employee2.setOrganization(organization1);
        employee3.setOrganization(organization2);
        employee4.setOrganization(organization2);



        // Inheritance in hibernate
        Vehicle vehicle = new Vehicle("Vehicle");
        TwoWheeler bike = new TwoWheeler("Bike", "Handle");
        FourWheeler car = new FourWheeler("Car", "Steering Wheel");

        try{
            createSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(organization1);
            session.save(organization2);
            session.save(vehicle);
            session.save(bike);
            session.save(car);

            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                System.out.println("Transaction could not commit successfully!");
                transaction.rollback();
            }
            else{
                System.out.println("Transaction completed successfully.");
            }
        }finally {
            if(session != null)
                session.close();
        }



    }
}
