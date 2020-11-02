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

## Windows Setup
Building a native image for Microsoft Windows is not a pleasant experience. 

### Prerequisites
* __chocolatey__ - package manager for Windows
* __Git Bash__ - we’re not even interested that much in git as we are in bash

### Install Java 11 based GraalVM
All bash snippets are supposed to be run from Git Bash unless I specifically note any other one:
```bash
choco install zip unzip
choco install visualstudio2017-workload-vctools
curl -sL https://get.sdkman.io | bash
mkdir -p "$HOME/.sdkman/etc/"
echo sdkman_auto_answer=true > "$HOME/.sdkman/etc/config"
echo sdkman_auto_selfupdate=true >> "$HOME/.sdkman/etc/config"
"source $HOME/.sdkman/bin/sdkman-init.sh"
sdk install java 20.2.0.r11-grl
```
