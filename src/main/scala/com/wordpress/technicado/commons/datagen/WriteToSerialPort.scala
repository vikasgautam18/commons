package com.wordpress.technicado.commons.datagen

import java.io._
import java.net._

import scala.io.Source

object WriteToSerialPort {

  val socket: Socket = new Socket("127.0.0.1", 9999)
  val out: PrintWriter = new PrintWriter(socket.getOutputStream(), true)

   def writeSocket(host: String, port: Int, message: String) = {
    out.println(message)
  }
   def readFileToSocket(host:String, port: Int, location: String, delay: Long) = {
     val bufferedSource = Source.fromFile(location)
     for (line <- bufferedSource.getLines) {
       println(line)
       Thread.sleep(delay)
       writeSocket(host, port, line)
     }

     bufferedSource.close
   }
}
