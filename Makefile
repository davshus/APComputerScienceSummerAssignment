all: tps projects tictactoe nim

tps:
	javac tps/*.java

projects:
	javac projects/*.java

tictactoe:
	javac projects/tictactoe/*.java

nim:
	javac projects/nim/*.java
	jar cf Nim.jar projects/nim/*.java

.PHONY: tps projects
