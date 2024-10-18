.PHONEY : format
format: src/*.java
	clang-format -i src/*.java
