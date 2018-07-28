package com.wordpress.technicado.commons.datagen

import java.util.regex.{Matcher, Pattern}

/** read more about the approach here
  * http://www.java2s.com/Code/Java/Development-Class/ParseanApachelogfilewithRegularExpressions.htm
  */
class ApacheServerLogParser extends Serializable {
  private val ipByte = "\\d{1,3}"
  private val ip = s"($ipByte\\.$ipByte\\.$ipByte\\.$ipByte)?"
  private val client = "(\\S+)"
  private val user = "(\\S+)"
  private val dateTime = "(\\[.+?\\])"
  private val request = "\"(.*?)\""
  private val status = "(\\d{3})"
  private val bytes = "(\\S+)"
  private val referer = "\"(.*?)\""
  private val agent = "\"(.*?)\""
  private val reg = s"$ip $client $user $dateTime $request $status $bytes $referer $agent"
  private val parser = Pattern.compile(reg)


  def parseRecord(record: String): Option[ApacheServerLogRecord] = {
    val matchedRec: Matcher = parser.matcher(record)
    matchedRec.find match {
      case true => Some(makeAccessLogRecord(matchedRec))
      case false => None
    }
  }

  private def makeAccessLogRecord(matcher: Matcher) = {
    ApacheServerLogRecord(
      matcher.group(1),
      matcher.group(2),
      matcher.group(3),
      matcher.group(4),
      matcher.group(5),
      matcher.group(6),
      matcher.group(7),
      matcher.group(8),
      matcher.group(9))
  }

}
