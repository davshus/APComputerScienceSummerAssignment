all:
	javac */*.java

nim:
	javac projects/nim/*.java
	jar cf Nim.jar projects/nim/*.java
