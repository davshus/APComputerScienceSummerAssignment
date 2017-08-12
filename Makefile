all: nim tps projects

nim:
	javac projects/nim/*.java
	jar cf Nim.jar projects/nim/*.java

tps:
	javac tps/*.java

projects:
	javac projects/*.java

.PHONY: tps projects
