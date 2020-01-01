package com.wangbin.fiveth_xml

final String xml = '''\
<response version-api="2.0">
    <value>
        <books id="1" classification="android">
            <book available="20" id="1">
                <title>疯狂Android讲义</title>
                <author id="1">李刚</author>
            </book>
            <book available="14" id="2">
                <title>第一行代码</title>
                <author id="2">郭林</author>
            </book>
            <book available="13" id="3">
                <title>Android开发艺术探索</title>
                <author id="3">任玉刚</author>
            </book>
            <book available="5" id="4">
                <title>Android源码设计模式</title>
                <author id="4">任红辉</author>
            </book>
        </books>
        <books id="2" classification="web">
            <book available="10" id="1">
                <title>Vue从入门到精通</title>
                <author id="4">李刚</author>
            </book>
        </books>
    </value>
</response>
'''
//开始解析xml数据
def xmlslurper = new XmlSlurper()
def response = xmlslurper.parseText(xml)
//输出节点的值
println response.value.books[0].book[0].title.text()
//输出节点属性
println response.value.books[1].book[0].@available

//找到book作者为李刚的书名
def list = []
response.value.books.each { books ->
    books.book.each { book ->
        //对所有的book进行遍历
        def author = book.author.text()
        if (author.equals('李刚')) {
            list.add(book.title.text())
        }
    }
}
println list  //[疯狂Android讲义, Vue从入门到精通]

//深度遍历
def titles = response.depthFirst().findAll { book ->
    return book.author.text() == '李刚' ? true : false
}
println titles  //[疯狂Android讲义李刚, Vue从入门到精通李刚]

//广度遍历
def name = response.value.books.children().findAll {
    node -> node.name() == 'book' && node.@id == '1'
}.collect {
    node -> return node.title.text()
}

println name





