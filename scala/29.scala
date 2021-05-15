object Solution {
    def divide(dividend: Int, divisor: Int): Int = {
      if (dividend == Int.MinValue && divisor == -1) return Int.MaxValue
      val sign = if (dividend > 0 && divisor <0 || dividend < 0 && divisor > 0) -1 else 1
      val _divid = dividend.toLong.abs
      val _divis = divisor.toLong.abs
      if (_divis > _divid ) 0
      else {
        var temp = _divis.toLong
        var res = 1.toLong
        while (temp <= _divid) {temp <<= 1; res <<= 1}
        temp >>= 1
        res >>= 1
        sign * (res.toInt + divide((_divid - temp).toInt, _divis.toInt))
      }
    }
}
