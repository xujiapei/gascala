package com.ruozedata.utils

import java.util.UUID

/**
  * Created by xujiapei on 2018/8/20.
  */
trait RandomUtils {
  def randomValue = Math.abs(UUID.randomUUID.hashCode);

  def random(max: Int) = randomValue % max
}
