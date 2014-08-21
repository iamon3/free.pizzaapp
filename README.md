Free Pizza App
=====================
This is the application server, also, the client of the free pizza API server (refer link mentioned below)

      https://github.com/iamon3/free.apis

For complete end to end working, API server must be up. Please set up (follow README of the project at the mentioned link) and boot up API server before booting up the APP server.

Pre-Requisite:

    - Maven              (I tested with Apache Maven 3.0.3)
    - Apache Tomcat      (I tested with apache-tomcat-7.0.52)
    - Free Pizza API server 
    
Set up project :
  
  1) Clone the project
  
       $ git clone https://github.com/iamon3/free.pizzaapp.git
       
  2) Configure the API server end-point "apiserver.endpoint" property in the file src/main/webapp/WEB-INF/config.properties. 
  
       e.g. apiserver.endpoint=localhost:9090
      
  3) Build the project
      
       $ sudo mvn clean; sudo mvn package
  
  4) Copy freepizzaapp.war to tomcat's webapps directory
  
       $ sudo cp target/freepizzaapp.war {tomcat install dir}/webapps
      
  5) Start the tomcat server
     
       $ cd {tomcat install dir}/bin
       $ sudo sh ./catalina.sh start        (To stop : sudo sh ./catalina.sh stop)
     
     Optional - If you want to see Server logs

       $ sudo vi tail -f ../logs/catalina.out
     
     
  6)  Test the web app
      Open your favorite browser and enter following URL
      
       http://localhost:8080/freepizzaapp
  
