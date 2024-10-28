.PHONEY : format
format: src/oop/veda/*.java courses.json
	clang-format -i src/oop/veda/*.java
	clang-format -i courses.json
