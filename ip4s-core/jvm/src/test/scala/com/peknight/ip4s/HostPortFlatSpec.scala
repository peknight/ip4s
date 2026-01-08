package com.peknight.ip4s

import com.comcast.ip4s.{host, port}
import org.scalatest.flatspec.AnyFlatSpec

class HostPortFlatSpec extends AnyFlatSpec:
  "HostPort" should "pass for fromString" in {
    assert(HostPort.fromString("www.peknight.com:443") === Some(HostPort(host"www.peknight.com", Some(port"443"))))
  }
end HostPortFlatSpec
