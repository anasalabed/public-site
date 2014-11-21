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
sudo cp ./target/*.war /var/lib/tomcat7/webapps/ROOT.war
sudo rm -r /var/lib/tomcat7/webapps/ROOT
echo "---------------------------------------------------------------------------------------------------------------------"
echo "Restarting TOMCAT"
echo "---------------------------------------------------------------------------------------------------------------------"
sudo killall java
sudo service tomcat7 start
sudo tail -f /var/log/tomcat7/catalina.out 