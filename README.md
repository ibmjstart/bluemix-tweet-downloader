# Tweet Downloader #

This is a simple program that will grab tweets via the Twitter Search API and write them to a file.

This might be useful to you if:

1. You are looking for some test data
2. You want to see if your keys are working
3. BlueMix can't reach the Twitter API for some reason

## License ##
Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

## How to use ##

Before running, you must supply your Twitter keys/tokens in the twitter4j.properties file.
For more information, [see here](registerTwitter.md).

You only need the TweetDownloader.jar and twitter4j.properties files to run it, but the source is provided if you would like to build it yourself.

If you just run the JAR, it will search for "IBM" and write the resulting tweets to a file called "tweets.txt".
You can use this file with the [PostgreSQL Example](https://github.com/ibmjstart/bluemix-java-postgresql-upload) and [MySQL Example](https://github.com/ibmjstart/bluemix-node-mysql-upload).

You can also give it a search term to search for something other than "IBM":

    > TweetDownloader.jar "cloud platform"
