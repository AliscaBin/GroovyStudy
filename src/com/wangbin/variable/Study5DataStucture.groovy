package com.wangbin.variable

/**
 * list
 */
//def list = new ArrayList()  //java define
//def list1 = [1, 2, 3, 4, 5]  //groovy define
//println list1.class  //class java.util.ArrayList
//println list1.size()  //5
//def array = [1, 2, 3, 4, 5] as int[]  //groovy array define
//int[] array1 = [1, 2, 3, 4, 5]  //groovy array define
//
////list sort
//def sortList = [6, -3, 9, 2, -7, 1, 5]
//Comparator mc = { a, b -> a == b ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1 }
////Collections.sort(sortList)
////按照自定义的排序规则排序
//Collections.sort(sortList,mc)
//println sortList  //[1, 2, -3, 5, 6, -7, 9]
//
//sortList.sort()
//println sortList  //[-7, -3, 1, 2, 5, 6, 9]
//
////传入闭包进行排序
//sortList.sort {
//    a,b ->
//        a == b ? 0 : Math.abs(a) < Math.abs(b) ? 1: -1
//}
//println sortList  //[9, -7, 6, 5, -3, 2, 1]
//
////字符串排序
//def sortStringList = ['abc','z','Hello','groovy','java']
//sortStringList.sort {it -> return it.size()}
//println sortStringList

//list find
//def findlist = [-3,9,6,2,-7,1,5]
//def result = findlist.find {
//    return it % 2 ==0
//}
//println result
//result = findlist.findAll {
//    return it % 2 !=0
//}
//println result
////有一个符合条件就返回true
//result = findlist.any { return it % 2 == 1}
//println result  //true
////所有都符合条件就返回true
//result = findlist.every {return it % 2 == 0}
//println result  //false
////查询最值
//println findlist.min()  //-7
//println findlist.max()  //9
//
//println findlist.min{return Math.abs(it)}  //1
//println findlist.max{return Math.abs(it)}  //9
////计算符合条件的数量
//println findlist.count {return it % 2 == 0}  //2


/**
 * map
 */
//def map = new HashMap()  //java define
def colors = [red: 'ff00000', green: '00ff00', blue: '0000ff']  //groovy define
println colors.getClass()  //class java.util.LinkedHashMap
//获取key对应的值
println colors['red']
println colors.red
//添加元素
colors.yellow = 'ffff00'
//添加一个map
colors.complex = [a: 1, b: 2]
println colors
//delete element
colors.remove('complex')
println colors

/*map 遍历*/
def students = [
        1: [number: '0001', name: 'aob', score: 15, sex: 'male'],
        2: [number: '0002', name: 'bob', score: 25, sex: 'female'],
        3: [number: '0003', name: 'cob', score: 35, sex: 'male'],
        4: [number: '0004', name: 'dob', score: 45, sex: 'female']
]

//students.each {def student -> println "student name is ${student.value.name}, score is ${student.value.score},sex is ${student.value.sex}"}
//students.eachWithIndex {def student,int index -> println "index is ${index}, key is ${student.key}, value is ${student.value}"}
//students.each {key,value -> println key +"-----"+ value}
//students.eachWithIndex {key,value,index -> println index +"----"+ key +"----"+ value}

/*map 查找*/
def entry = students.find { def student -> return student.value.score >= 25 }
entry = students.findAll { def student -> return student.value.score >= 25 }
println entry

/*count*/
def count = students.count { def student -> return student.value.score >= 25 && student.value.sex == 'female' }
println count
def names = students.findAll { def student -> return student.value.score >= 25 }.collect { return it.value.name }
println names  //[bob, cob, dob]
println names.getClass()  //class java.util.ArrayList

/*分组 groupBy*/
def group = students.groupBy { def student -> return student.value.score >= 25 ? '及格' : '不及格' }
println group

/*map 排序*/
def sort = students.sort { def student1, def student2 ->
    Number score1 = student1.value.score
    Number score2 = student2.value.score
    return score1 == score2 ? 0 : score1 < score2 ? 1 : -1
}
println sort
















