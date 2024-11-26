.PHONEY : format build run
build:
	mvn clean package

run:
	mvn exec:java

format: src/main/java/timeTableSchedulinev2/*.java
	clang-format -i src/main/java/timeTableSchedulinev2/*.java
