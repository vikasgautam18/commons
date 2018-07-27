package com.wordpress.technicado.commons.datagen

import java.io._
import java.net._

import scala.io.Source

class WriteToSerialPort(host: String, port: Int) {

  val socket: Socket = new Socket(host, port)
  val out: PrintWriter = new PrintWriter(socket.getOutputStream(), true)

   def writeSocket(message: String) = {
    out.println(message)
  }
   def readFileToSocket(location: String, delay: Long) = {
     val bufferedSource = Source.fromFile(location)
     for (line <- bufferedSource.getLines) {
       println(line)
       Thread.sleep(delay)
       writeSocket(line)
     }

     bufferedSource.close
   }
}
