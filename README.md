# CommonLib
## Description
Utility library for all services.
This library is designed to free the services workspace from a large number of utility classes and provide access to all these classes for all services.

## How to use this library
Access to the library is implemented using Nexus Repository.
1. The first thing to do is to connect your nexus to the project by specifying it as a repository in pom.xml:

	`
	<repositories>
		<repository>
		
			<id>nexus</id>
			
			<url>http://158.160.6.130:8081/nexus/content/repositories/snapshots/</url>
			
		</repository>
	</repositories>
	`
	
In order to connect this library to your project, just specify it as dependency in pom.xml and pull up this new dependency.
