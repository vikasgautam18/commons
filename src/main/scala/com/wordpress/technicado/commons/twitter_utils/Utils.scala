package com.wordpress.technicado.commons.twitter_utils

import com.wordpress.technicado.commons.configuration.ConfigReader
import com.wordpress.technicado.commons.configuration.Constants._
import org.apache.spark.SparkContext
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.twitter._
import twitter4j.Status

object Utils {
  def setUpTwitter(hdfs_prop_file: String, sparkContext: SparkContext) = {
    ConfigReader.readConfig(hdfs_prop_file, sparkContext)

    System.setProperty("twitter4j.oauth.consumerKey", ConfigReader.getString(TWITTER_CONSUMER_KEY))
    System.setProperty("twitter4j.oauth.consumerSecret", ConfigReader.getString(TWITTER_CONSUMER_SECRET))
    System.setProperty("twitter4j.oauth.accessToken", ConfigReader.getString(TWITTER_ACCESS_TOKEN))
    System.setProperty("twitter4j.oauth.accessTokenSecret", ConfigReader.getString(TWITTER_ACCESS_SECRET))
  }

  def createTwitterStream(ssc: StreamingContext): ReceiverInputDStream[Status] = {
    TwitterUtils.createStream(ssc, None)
  }

}
