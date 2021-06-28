PT1	= /home/ycy/.m2/repository/org/projectlombok/lombok/1.18.10/lombok-1.18.10.jar
PT2	= /home/ycy/.m2/repository/com/alibaba/fastjson/1.2.54/fastjson-1.2.54.jar
PT3	= /home/ycy/.m2/repository/org/slf4j/slf4j-api/1.7.7/slf4j-api-1.7.7.jar
PT4	= /home/ycy/.m2/repository/ch/qos/logback/logback-core/1.1.7/logback-core-1.1.7.jar
PT5	= /home/ycy/.m2/repository/ch/qos/logback/logback-access/1.1.7/logback-access-1.1.7.jar
PT6	= /home/ycy/.m2/repository/ch/qos/logback/logback-classic/1.1.7/logback-classic-1.1.7.jar
CLASSPATH = easy-util-python/target/classes:$(PT1):$(PT2):$(PT3):$(PT4):$(PT5):$(PT6)
FILE = easy-util-python/src/main/java/zju/edu/als/MainWorker.java
JAVAC = javac -classpath $(CLASSPATH) $(FILE)
JAVA  = java -classpath $(CLASSPATH) zju.edu.als.MainWorker

default:
	mvn clean compile
	$(JAVAC)
	$(JAVA)