package com.wangbin.second_variable

def closer = {println 'hello groovy'}
//closer.call()
closer()  //hello groovy
//默认参数
def closer1 = {println "hello ${it}"}
closer1()  //hello null
def closure = {String name,int age -> println "hello ${name},age is ${age}"}
closure("wangbin",18)  //hello wangbin,age is 18

def closure1 = {String name -> return "hello ${name}"}
def result = closure1("wangbin")
println result  //hello wangbin
println closer()  //null

/*Closure的使用*/
//求取阶乘
int x = 5

int fab(int number) {
    int result = 1
    1.upto(number,{num -> result *= num})
    return result
}

int fab2(int number){
    int result = 1
    number.downto(1,{num -> result *= num})
    return result
}

println "${x}! is ${fab2(x)}"

//累计求和
def cal(int number) {
    int result = 0
    number.times {
        num -> result += num
    }
    return result
}
x = 101
println "${x-1}累计求和 is ${cal(x)}"
//println 5.times {println it}

/**
 * 字符串与闭包的使用
 */
String str = "the 2 and 3 is 5"
str.each {
    String temp -> print temp.multiply(2)
//    String temp -> print temp
        //each 方法返回值为str本身
}
println()
println str.find {
    String temp -> temp.isNumber()
}

/**
 * 闭包中的三个变量：this,owner,delegate
 */
def scriptClosure =  {
    println "scriptClosure:"+this  //scriptClosure:com.wangbin.variable.CloserStudy4@76a4ebf2 代表闭包定义处的类
    println "scriptClosure:"+owner  //scriptClosure:com.wangbin.variable.CloserStudy4@76a4ebf2 代表闭包定义处的类或对象
    println "scriptClosure:"+delegate  //scriptClosure:com.wangbin.variable.CloserStudy4@76a4ebf2 代表任意对象 默认与owner一致
}
scriptClosure.call()

//定义了一个内部类
class Person {
    def static classClosure = {
        println "classClosure:"+this
        println "classClosure:"+owner
        println "classClosure:"+delegate
    }

    def static say() {
        def classClosure ={
            println "methodClosure:"+this
            println "methodClosure:"+owner
            println "methodClosure:"+delegate
        }
        classClosure.call()
    }
}
Person.classClosure.call()
Person.say()
//classClosure:class com.wangbin.variable.Person  静态的指向类本身

//Person p = new Person()
//p.classClosure.call()
//p.say()
//classClosure:com.wangbin.variable.Person@2af004b  非静态的指向对象

/**
 * this会指向离自己最近的对象
 * 在闭包中定义一个闭包  ：
 * 在类中定义闭包，this,owner,delegate一致；
 * 在闭包中定义闭包，this指向script对象，owner，delegate指向闭包体
 */
println "闭包中定义闭包".center(30,'-')
def nestClosure = {
    def innerClosure = {
        println "innerClosure:"+this  //innerClosure:com.wangbin.variable.CloserStudy4@4b741d6d
        println "innerClosure:"+owner  //innerClosure:com.wangbin.variable.CloserStudy4$_run_closure8@663c9e7a
        println "innerClosure:"+delegate  //innerClosure:com.wangbin.variable.CloserStudy4$_run_closure8@663c9e7a
    }
    innerClosure.call()
}
nestClosure.call()

/**
 * 闭包的委托策略
 */
class Student {
    String name
    def pretty = {"My name is ${name}"}

    String toString() {
        pretty.call()
    }
}

class Teacher {
    String name
}

def stu = new Student(name: 'Sarash')
def tea = new Teacher(name: 'Android')
println stu.toString()  //My name is Sarash
//修改委托策略
stu.pretty.delegate = tea
stu.pretty.resolveStrategy = Closure.DELEGATE_FIRST
println stu.toString()  //My name is Android




