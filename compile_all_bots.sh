#! /bin/sh

for file in ./*.java; do
	javac -encoding UTF-8 -classpath ../../libs/robocode.jar:/Users/Guest/Robocode/robots $file
done
