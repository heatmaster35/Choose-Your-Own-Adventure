###########################################
# Name: Anthony Lampi && Leo Gomez        #
# CruzID: alampi && legomez               #
# Class: CMPS-12B                         #
# Date: Dec 8, 2014                       #
# filename: Makefile                      #
# Details: Makefile for Programming       #
#   assignment 4                          #
###########################################

# Makefile for Programming Assignment 4

JAVASRC    = cyoa.java Tree.java Stack.java Room.java RoomTest.java
SOURCES    = ${JAVASRC} Makefile README design.txt demo.adventure
MAINCLASS  = cyoa
CLASSES    = ${JAVASRC:.java=.class}
JARCLASSES = ${CLASSES} Room\$$*.class
JARFILE    = cyoa
SUBMITDIR  = cmps12b-nojw.f14 asg4
TESTCLASS  = Room
CLASSPATH  = "junit-4.12-beta-1.jar:hamcrest-core-1.3.jar:."

all : ${JARFILE}

${JARFILE} : ${CLASSES}
	echo "Main-class: ${MAINCLASS}" >Manifest
	jar cvfm ${JARFILE} Manifest ${JARCLASSES}
	chmod +x ${JARFILE}
	rm Manifest

%.class : %.java
	javac -cp ${CLASSPATH} $<

test2 : ${TESTCLASS}Test.class ${TESTCLASS}.class
	java -cp ${CLASSPATH} org.junit.runner.JUnitCore ${TESTCLASS}Test

test : 	${CLASSES}
	java cyoa demo.adventure

clean :
	rm -f *.class Manifest

spotless : clean
	rm -f ${JARFILE}

submit : ${SOURCES}
	submit ${SUBMITDIR} ${SOURCES}

.PHONY:all test clean test2 spotless submit
