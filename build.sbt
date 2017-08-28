name := "fakenewsbot-scala"

version := "1.0"

scalaVersion := "2.12.3"

libraryDependencies += "org.twitter4j"%"twitter4j-core"%"4.0.6"
libraryDependencies += "ch.qos.logback"%"logback-classic"%"1.2.3"
libraryDependencies += "com.mashape.unirest"%"unirest-java"%"1.4.9"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
libraryDependencies += "junit" % "junit" % "4.12" % "test"
libraryDependencies += "com.ibm.watson.developer_cloud" % "java-sdk" % "3.3.1"
libraryDependencies += "org.json4s" %% "json4s-native" % "3.5.3"