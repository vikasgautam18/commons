package com.wordpress.technicado.commons.datagen

case class ApacheServerLogRecord(
    ipAddress: String,
    rfcIdentitiy: String,
    remoteUser: String,
    dateTime: String,
    requestType: String,
    statusCode: String,
    bytes: String,
    referer: String,
    userAgent: String
    )
