# quiz-checker

Checks in a text files for duplicated lines reporting the line numbers

# Usage
Given an input file with some repeated lines:
```bash
my first line
a repeated line
my third line
a repeated line
my fifth line
```
lanuching the checker it will detect all the repeated lines and their line number sorting the input alphabetically
```bash
$ ./checker input.txt
a repeated line[2, 4]
```

# Building from sources

## Prerequisites
The checker is compiled in a native application using GraalVM and Java programming language. 
To build the checker it is needed to 
- install a GraalVM 20.2.0 (JDK 11) 
- install maven 3.2.x

## How to build
To build the checker just launch:
```bash 
$ mvn package
```

When the build completes the executable is compiled in the target directory and can be used.
