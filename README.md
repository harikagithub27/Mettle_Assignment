# Getting Started
#### Reference Documentation
* [GITHUB URL of this project](https://github.com/harikagithub27/Mettle_Assignment)
* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.2/gradle-plugin/reference/html/)

#### Features

1. As a Admin User, one would be able to create a feature which defaults to disabled.
2. As a Admin User, one would be able to switch on a feature for a user.
3. As a User, one would be able to get all the enabled features.

#### Supported versions
1. Java 8
2. Spring Boot 2.6.2

#### Building and Running the Project
From the Command Line, Navigate to the Project's Folder
1. To build the project from command line, execute the below command:
	*  gradleW build 
2. To run the project from the command line, execute the below command:
	*  gradleW bootRun


#### Testing
This Project can be tested from PostMan <br/>
Below are the URLs:

1.	Create Feature: <br/>
http://localhost:9090/featureDemo/createFeature/admin

2.	Switch Feature: <br/>
http://localhost:9090/featureDemo/switchFeature/admin/user1/flag1

3.	Get Enabled Features: <br/>
http://localhost:9090/featureDemo/getEnabledFeatures/user1

