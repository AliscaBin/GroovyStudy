package com.wangbin.second_variable

//public interface Range<T extends Comparable> extends List<T>
def range = 1..10
println range.class  //class groovy.lang.IntRange
println range  //1..10
println range[0]  //1
println range.from +"--------"+ range.to

//遍历
range.each { print it +" "}
println()
for (i in range) {
    print i +" "
}
println()

def getGrade(Number number) {
    def result
    switch (number) {
        case 0..<60:
            return "不及格"
            break
        case 60..<80:
            return "及格,加油哦"
            break
        case 80..100:
            return "优秀,很棒哦"
            break
        default:
            "太高了，不支持！"
    }
}

println getGrade(100)









