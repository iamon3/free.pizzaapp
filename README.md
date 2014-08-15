Spring3HibernateMaven
=====================

I am very thankful to Viral Patel for sharing this useful tutorial. For explanation and working,

   Refer : http://viralpatel.net/blogs/spring3-mvc-hibernate-maven-tutorial-eclipse-example/

Although, this blog is bit older, as it was written 4 yrs back, but still it's good to start and develop the project. Soon, I will try to update this project or will create new project, with new trends in Spring MVC, Hibernate. 

Pre-Requisite:

    - Maven              (I tested with Apache Maven 3.0.3)
    - Apache Tomcat      (I tested with apache-tomcat-7.0.52)
    - MySQL              ( I tested with Server version: 5.5.36 MySQL Community Server (GPL))
    - Create ContactManager database in MySQL from the dbuser login
      $ mysql -u {db user}  -p {db user password}                   (Enter)
      mysql> CREATE DATABASE ContactManager;
      
      Please note : You can configure db user and password in the following file,
      src/main/webapp/WEB-INF/jdbc.properties
      

Set up project :
  
  1) Clone the project
  
       $ git clone https://github.com/iamon3/free.pizzaapp.git
      
  2) Install the project
      
       $ sudo mvn clean; sudo mvn install
  
  3) Copy Spring3HibernateMaven.war to tomcat's webapps directory
  
       $ sudo cp target/Spring3HibernateMaven.war {tomcat install dir}/webapps
      
  4) Start the tomcat server
     
       $ cd {tomcat install dir}/bin
       $ sudo sh ./catalina.sh start        (To stop : sudo sh ./catalina.sh stop)
     
     Optional - If you want to see Server logs

       $ sudo vi tail -f ../logs/catalina.out
     
     
  5)  Test the web app
      Open your favorite browser and enter following URL
      
       http://localhost:8080/freepizzaapp/index
  
