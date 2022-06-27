import "strings"

func multiply(num1 string, num2 string) string {
	if num1 == "0" || num2 == "0" {
		return "0"
	}
	rn1 := reverse(num1)
	rn2 := reverse(num2)
	res := ""
	for i, ch := range rn2 {
		res = add(res, mul(rn1, byte(ch), i), '0')
	}
	return reverse(res)
}

/*
     1   2   3

x    4   5   6

----------------
     7   3   8
  6  1   5
4 9  2

-------------------
5 6  0   8   8
*/

func reverse(s string) (result string) {
	for _, v := range s {
		result = string(v) + result
	}
	return
}

func byteAdd(b1, b2, b3 byte) int {
	return int(b1) + int(b2) + int(b3) - 3*int('0')
}

func digitToByte(d int) byte {
	return byte(d - 0 + int('0'))
}

func add(num1 string, num2 string, carry byte) string {
	if len(num1) == 0 && len(num2) == 0 && carry == '0' {
		return ""
	}
	d1 := byte('0')
	nextNum1 := ""
	d2 := byte('0')
	nextNum2 := ""
	if len(num1) != 0 {
		d1 = byte(num1[0])
		nextNum1 = num1[1:]
	}
	if len(num2) != 0 {
		d2 = byte(num2[0])
		nextNum2 = num2[1:]
	}

	res := byteAdd(d1, d2, carry)
	c := res / 10

	return string(digitToByte(res%10)) + add(nextNum1, nextNum2, digitToByte(c))
}

func digit(d byte) int {
	return int(d) - int('0')
}

func mul(n string, d byte, left int) string {
	res := ""
	carry := 0
	for _, b := range n {
		v := digit(byte(b))*digit(d) + carry
		carry = v / 10
		v = v % 10
		res += string(digitToByte(v))
	}
	if carry != 0 {
		res += string(digitToByte(carry))
	}
	return strings.Repeat("0", left) + res
}
