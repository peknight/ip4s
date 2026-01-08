package com.peknight.ip4s

import com.comcast.ip4s.{Host, Port}

case class HostPort(host: Host, port: Option[Port])
object HostPort:
  def fromString(value: String): Option[HostPort] =
    val index = value.lastIndexOf(':')
    if index >= 0 && index < value.length - 1 then
      Port.fromString(value.substring(index + 1))
        .flatMap(port => Host.fromString(value.substring(0, index)).map(host => HostPort(host, Some(port))))
        .orElse(Host.fromString(value).map(host => HostPort(host, None)))
    else Host.fromString(value).map(host => HostPort(host, None))
end HostPort
