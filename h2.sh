#!/usr/bin/env bash

java -cp /c/Users/Anne-Laure/.m2/repository/com/h2database/h2/1.4.200/h2-1.4.200.jar \
    org.h2.tools.Server \
    -web -webAllowOthers \
    -tcp -tcpAllowOthers \
    -ifNotExists \
    -baseDir /c/Users/Anne-Laure/.clickandcollect

#java -cp C:\Users\Anne-Laure\.m2\repository\com\h2database\h2\1.4.200\h2-1.4.200.jar org.h2.tools.Server -web -webAllowOthers -tcp -tcpAllowOthers -ifNotExists -baseDir C:\Users\Anne-Laure\.clickandcollect