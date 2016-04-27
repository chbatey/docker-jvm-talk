#!/bin/bash -x

function usage() {
    echo 'Set JAVA_OPTIONS to override parameters passed to java. Excluding any GC related options.'
    echo 'Set GC_OPTIONS for any GC related parameters.'
    echo 'Usage: start_java.sh -c [command e.g -jar /data/app.jar server config.yml]'
    exit 1
}

#Separated GC because if multiple GCs are passed to the JVM G1 is picked regardless of order
gc=${GC_OPTIONS:-"-XX:+UseG1GC -XX:+PrintGC -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps"}
java_options=${JAVA_OPTIONS:-"-Xmx256m -Xms256m"}
other=${CORE_OPTIONS:-"-XX:NativeMemoryTracking=summary -XX:+UnlockDiagnosticVMOptions -XX:+AlwaysPreTouch"}

while getopts ":c:h" OPTION; do
    case $OPTION in
        c)
            command=$OPTARG
            ;;
        h)
            usage
            ;;
        :)
            echo "Option -$OPTARG requires an argument." >&2
            exit 1
            ;;
    esac
done

if [ -z "$command" ]
then
    usage
fi

java $other $gc $java_options $command

