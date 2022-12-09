#! /bin/sh

rm -f /Users/Guest/Robocode/robots/engineero/*.class

for file in /Users/Guest/Robocode/robots/engineero/*.java; do
	javac -encoding UTF-8 -classpath /Users/Guest/Robocode/libs/robocode.jar:/Users/Guest/Robocode/robots $file
done
