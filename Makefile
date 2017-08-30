all: labs tps projects tictactoe nim

labs:
	javac labs/*.java

tps:
	javac tps/*.java

projects:
	javac projects/*.java

tictactoe:
	javac projects/tictactoe/*.java

nim:
	javac projects/nim/*.java
	jar cf Nim.jar projects/nim/*.class

clean:
	rm */*.class
	rm */*/*.class
	rm *.jar

.PHONY: tps projects labs
