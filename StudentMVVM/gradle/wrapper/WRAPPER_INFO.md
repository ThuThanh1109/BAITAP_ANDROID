The included `gradle-wrapper.jar` is a small Java 8-compatible bootstrapper, NOT the official Gradle Wrapper binary.
It downloads Gradle 8.4 from the official URL specified in gradle-wrapper.properties and starts Gradle from the user's local cache.
This is provided because the archive-generation environment did not have the original Gradle wrapper binary.
You may replace it with the standard Gradle wrapper by running `gradle wrapper --gradle-version 8.4` on a machine with Gradle installed.
