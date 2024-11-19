.PHONEY : format
format: src/main/java/timeTableSchedulinev2/*.java
	clang-format -i src/main/java/timeTableSchedulinev2/*.java
