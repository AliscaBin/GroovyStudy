package com.wangbin.variable

int x = 10
println x.class  //class java.lang.Integer

double y = 10.0
println y.class  //class java.lang.Double

//不声明类型，def自动推断变量类型
def x1 = 10
def x2 = 10.0
println x1.class  //class java.lang.Integer
println x2.class  //class java.math.BigDecimal
x1 = "hello groovy"
println x1.class  //class java.lang.String






