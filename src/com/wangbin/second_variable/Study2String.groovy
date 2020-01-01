package com.wangbin.second_variable

/*****************字符串的定义******************/
def name = 'a \'single\' string'
println name  //a 'single' string
println name.class  //class java.lang.String

def trupleName = '''three single string'''
println trupleName  //three single string
println trupleName.class  //class java.lang.String

def content = '''\
line one
line second
line third'''
println content

def doubleName = "this a common string"
println doubleName.class  //class java.lang.String
def name1 = "Android"
def sayHello = "hello ${name1}"
println sayHello
println sayHello.class  //class org.codehaus.groovy.runtime.GStringImpl
def sum = "the sum of 2 and 3 equals ${2 + 3}"
println sum

String echo(String msg) {
    return msg
}

println echo(sum)


/*****************字符串的方法******************/
def str = "hello groovy"
println str.center(20)
println str.center(20,"-")
println str.padLeft(20,"-")
println str.padRight(20,"-")

def str1 = 'hello groovy'
def str2 = 'groovy'
println str1 > str2
println str1.compareTo(str2)

def firstchar = str1.getAt(0)
println firstchar  //h
firstchar = str2[0]
println firstchar  //g
firstchar = str1[1..3]
println firstchar  //ell

println str1.minus(str2)  //hello
println str1 - str2  //hello

println str1.reverse()
println str1.capitalize()
println str1.isNumber()



