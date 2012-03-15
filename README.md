# Saucier

A wrapper for Sauce Lab's `sauceconnect` client.

Starts up a `sauceconnect` instance and translates each request from the tool to a `Request` object in a `RequestBuffer`. Think of it as a poor man's Charles Proxy.

# Usage

	$ java -jar Saucier.jar [USERNAME] [PASSWORD]

# Notes

Saucier will block the calling thread until a connection is successfully started.