#!/bin/sh
cd /home/pedro/NetBeansProjects/PontoWebApplet/dist/
jarsigner -keystore /home/pedro/devel/signjar_applet/mystore/mystore.jks -storepass miltec123 -keypass miltec123 PontoWebApplet.jar milkey
rm /home/pedro/devel/projetos/ponto_web/public/PontoWebApplet.jar
cp PontoWebApplet.jar /home/pedro/devel/projetos/ponto_web/public/
