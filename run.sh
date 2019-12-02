#!/bin/sh

java -agentlib:jdwp=transport=dt_socket,address=14096,suspend=n,server=y -jar example.jar