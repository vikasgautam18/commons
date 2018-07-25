package com.wordpress.technicado.commons.logging

import org.apache.log4j.{Level, Logger}

object Utils {
  def enableErrorLoggingOnly = {
    Logger.getLogger("org").setLevel(Level.ERROR)
  }

}
