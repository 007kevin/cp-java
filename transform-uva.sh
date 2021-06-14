#!/bin/bash
if [ -z "$1" ]
then
    echo "No argument supplied"
    exit 0
fi
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
FILEPATH=$1
FILENAME="${FILEPATH##*/}"
CLASSNAME="${FILENAME%%.*}"
cat $FILEPATH | sed "s/public class $CLASSNAME/class Main/g" | sed "s/$CLASSNAME/Main/g" > $DIR/src/Main.java


