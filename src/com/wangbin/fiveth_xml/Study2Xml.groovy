package com.wangbin.fiveth_xml

import groovy.xml.MarkupBuilder

/**
 * 生成xml格式数据
 */
def xml = '''\
<langs type='current' count='3' mainstream='true'>
    <language flavor='static' version='1.5'>Java</language>
    <language flavor='dynamic' version='1.6.0'>Groovy</language>
    <language flavor='dynamic' version='1.9'>JavaScript</language>
</langs>'''

def sw = new StringWriter()
//用来生成xml的核心类
def gxml = new MarkupBuilder(sw)
//创建根节点langs
gxml.langs(type:'current', count:'3', mainstream:'true') {
    //创建language节点
    language(flavor:'static', verison:'1.5','Java')
    language(flavor:'dynamic', verison:'1.6.0','Groovy')
    language(flavor:'dynamic', verison:'1.9','JavaScript')
}
println sw


//动态生成xml文档
//对应xml中的langs节点
class Langs {
    String type = 'current'
    int count = 3
    boolean mainstream = true
    def languages = [
            new Language(flavor: 'static',version: '1.5',value: 'Java'),
            new Language(flavor: 'dynamic',version: '1.6.0',value: 'Groovy'),
            new Language(flavor: 'dynamic',version: '1.9',value: 'JavaScript')
    ]
}
//对应xml中的language节点
class Language {
    String flavor
    String version
    String value
}

def strwriter = new StringWriter()
def xmlBuilder = new MarkupBuilder(strwriter)
def langs = new Langs()
xmlBuilder.langs(type: langs.type,count: langs.count,mainstream: langs.mainstream) {
    langs.languages.each {
        lang ->
            language(flavor: lang.flavor,version: lang.version,lang.value)
    }
}
println strwriter



