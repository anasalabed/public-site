#!/bin/bash
sudo export CATLINA_HOME=/opt/tomcat/
echo "---------------------------------------------------------------------------------------------------------------------"
echo "Start building PROD  ENV"
echo "---------------------------------------------------------------------------------------------------------------------"
sudo git checkout . 
sudo git pull origin master
sudo mvn clean
sudo mvn install
echo "---------------------------------------------------------------------------------------------------------------------"
echo "Copying to TOMCAT "
echo "---------------------------------------------------------------------------------------------------------------------"
sudo cp ./target/*.war /opt/tomcat/webapps/public.war
sudo rm -r /opt/tomcat/webapps/public
echo "---------------------------------------------------------------------------------------------------------------------"
echo "Restarting TOMCAT"
echo "---------------------------------------------------------------------------------------------------------------------"
sudo killall java
sudo service tomcat8 start
sudo tail -f /opt/tomcat/logs/catalina.out