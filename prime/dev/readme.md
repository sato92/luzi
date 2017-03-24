
## Database ersttellen


CREATE DATABASE IF NOT EXISTS luziDB;

GRANT SELECT, INSERT, UPDATE, DELETE ON luziDB TO 'root'@'localhost';


## JDBC Modul erstellen


module add --name=com.mysql --resources=/Users/Sato/Documents/source/GeneralJSF2-2/prime/dev/db/mysql-connector-java-5.1.41-bin.jar --dependencies=javax.api,javax.transaction.api


## Datasource erstellen

data-source add --name=luziDS --jndi-name=java:jboss/datasources/luiDS --driver-name=com.mysql --connection-url=jdbc:mysql://localhost:3306/luziDB

https://docs.jboss.org/author/display/AS7/Securing+the+Management+Interfaces
Um den Benutzer zu repräsentieren, fügen Sie die folgende server-identities-Definition <secret value="MTF6aVNjaDEwIw==" /> 