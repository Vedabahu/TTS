.PHONEY : format
format: src/oop/veda/*.java
	clang-format -i src/oop/veda/*.java
