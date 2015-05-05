#JPA-Servlet

##Configuration de la BDD
Le fichier du choix de la base se fait dans le fichier persistence.xml

     Path : JPA-Servlet\src\main\resources\META-INF\persistence.xml
La base de donnée utilisée durant le développement était hébergé en locale, par conséquent prenez le temps de configurer le fichier de persistance.
###Structure
		-- jpa
    		-- istic.sir.jpa
    		    -- Device
    		    -- ElectronicDevice
    		    -- Heater
    		    -- Home
    		    -- Person
    		    -- JpaTest
    		    -- GenerateData
    	    -- istic.sir.rest : http://localhost:8080/rest/
    	        -- REST_Device 
    	        -- REST_Home
    	        -- REST_Person
        -- webapp
            -- servlet
                -- AddPerson : http://localhost:8080/person/add
                -- AllDevices : http://localhost:8080/devices
                -- AllHomes : http://localhost:8080/homes
                -- AllPersons : http://localhost:8080/persons
                -- PrintHTML 
            -- index.html

Pour peupler la base :
     `run JpaTest.java`

Pour lancer l'application : 
     `tomcat7:run`

Une fois démarrer, l'application est disponible à l'adresse  `http://localhost:8080/`
