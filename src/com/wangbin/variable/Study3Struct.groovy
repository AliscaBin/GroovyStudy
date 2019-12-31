package com.wangbin.variable

def x = 1.23
def result
switch (x) {
    case 'foo':
        result = 'found foo'
        break
    case 'bar':
        result = 'found bar'
        break
    case [4,5,6,'inlist']:
        result = 'found list'
        break
    case 12..30:
        result = 'found range'
        break
    case Integer:
        result = 'found integer'
        break
    case BigDecimal:
        result = 'found bigdecimal'
        break
    default:
        result = 'fount nothing'
}

println result

//对范围的for循环
def sum = 0
for (i in 0..9) {
    sum +=i
}
println(sum)
//对list的循环
sum = 0
for (i in [0,1,2,3,4,5,6,7,8,9]) {
    sum += i
}
println sum
sum = 0
//对map进行循环
for (i in ['lili': 4, 'luck': 4, 'xiao': 4]) {
    sum += i.value
}
println sum
