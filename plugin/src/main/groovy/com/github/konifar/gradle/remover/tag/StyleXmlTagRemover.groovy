package com.github.konifar.gradle.remover.tag

class StyleXmlTagRemover extends AbstractXmlTagRemover {

    @Override
    String getFileType() {
        return "style"
    }

    @Override
    GString createPattern(String attrName) {
        // Considered style override
        def pattern = /(@${resourceName}\/${attrName}")|(R\.${resourceName}\.${toCamelCaseWithUnderscore(attrName)})|(${attrName}\.)|(parent="${attrName}")/
        return pattern
    }

    static String toCamelCaseWithUnderscore(String name) {
        return name.replaceAll("(\\.)([A-Za-z0-9])", { Object[] it -> "_${it[2].toUpperCase()}" })
    }

}