# Tweet Downloader #

This is a simple program that will grab tweets via the Twitter Search API and write them to a file.

This might be useful to you if:

1. You are looking for some test data
2. You want to see if your keys are working
3. BlueMix can't reach the Twitter API for some reason

## How to use ##

Before running, you must supply your Twitter keys/tokens in the twitter4j.properties file.
For more information, [see here](registerTwitter.md).

You only need the TweetDownloader.jar and twitter4j.properties files to run it, but the source is provided if you would like to build it yourself.

If you just run the JAR, it will search for "IBM" and write the resulting tweets to a file called "tweets.txt".
You can use this file with the [PostgreSQL Example](https://github.com/ibmjstart/bluemix-java-postgresql-upload) and [MySQL Example](https://github.com/ibmjstart/bluemix-node-mysql-upload).

You can also give it a search term to search for something other than "IBM":

    > TweetDownloader.jar "cloud platform"
