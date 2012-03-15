# Saucier

A wrapper for Sauce Lab's `sauceconnect` client.

Starts up a `sauceconnect` instance and translates each request from the tool to a `Request` object in a `RequestBuffer`. Think of it as a poor man's Charles Proxy.

# Usage

	$ java -jar Saucier.jar [USERNAME] [PASSWORD]

# Building the JAR

Run the handy dandy ANT script. 
	$ ant build/build.xml

Also available in the downloads section if you don't want to DIY.

# Notes

Saucier will block the calling thread until a connection is successfully started.