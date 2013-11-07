/*-------------------------------------------------------------------*/
/*                                                                   */
/* Copyright IBM Corp. 2013 All Rights Reserved                      */
/*                                                                   */
/*-------------------------------------------------------------------*/
/*                                                                   */
/*        NOTICE TO USERS OF THE SOURCE CODE EXAMPLES                */
/*                                                                   */
/* The source code examples provided by IBM are only intended to     */
/* assist in the development of a working software program.          */
/*                                                                   */
/* International Business Machines Corporation provides the source   */
/* code examples, both individually and as one or more groups,       */
/* "as is" without warranty of any kind, either expressed or         */
/* implied, including, but not limited to the warranty of            */
/* non-infringement and the implied warranties of merchantability    */
/* and fitness for a particular purpose. The entire risk             */
/* as to the quality and performance of the source code              */
/* examples, both individually and as one or more groups, is with    */
/* you. Should any part of the source code examples prove defective, */
/* you (and not IBM or an authorized dealer) assume the entire cost  */
/* of all necessary servicing, repair or correction.                 */
/*                                                                   */
/* IBM does not warrant that the contents of the source code         */
/* examples, whether individually or as one or more groups, will     */
/* meet your requirements or that the source code examples are       */
/* error-free.                                                       */
/*                                                                   */
/* IBM may make improvements and/or changes in the source code       */
/* examples at any time.                                             */
/*                                                                   */
/* Changes may be made periodically to the information in the        */
/* source code examples; these changes may be reported, for the      */
/* sample code included herein, in new editions of the examples.     */
/*                                                                   */
/* References in the source code examples to IBM products, programs, */
/* or services do not imply that IBM intends to make these           */
/* available in all countries in which IBM operates. Any reference   */
/* to the IBM licensed program in the source code examples is not    */
/* intended to state or imply that IBM's licensed program must be    */
/* used. Any functionally equivalent program may be used.            */
/*-------------------------------------------------------------------*/


import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TwitterClient {
	
	static Twitter twitter = TwitterFactory.getSingleton();
	
	/**
	 * Grab the most recent 100 search results with a given search term
	 * @param search String to search
	 * 
	 * @return JSONArray of Strings from twitter's search results
	 * @throws Exception 
	 */
	public static List<String> search(String search) throws Exception {
	    Query query = new Query(search);
	    query.setResultType(Query.RECENT);
	    query.setLang("en");
	    query.setCount(100);
	    
		try {
		    List<Status> tweets = twitter.search(query).getTweets();
		    List<String> texts = new ArrayList<String>(tweets.size());
		    
		    for (Status tweet : tweets) {
		    	texts.add(tweet.getText());
		    }
		    
		    return texts;
		} catch (TwitterException e) {
			if (e.getMessage().toLowerCase().contains("authentication")) {
				String msg = "Twitter Error: Problem authenticating with Twitter. "
						   + "Make sure you have included correct keys and tokens.";
				throw new Exception(msg, e);
			}
			
			throw e;
		}
	}
}
