#!/usr/bin/env bash

mvn -q package

java -jar ./target/primes-generator-1.0-SNAPSHOT.jar