package com.hjortsholm.main

import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val graph = Graph<Int,Any>()
    graph.set("lorem",1)
    graph.set("ipsum",2)
    graph.set("dolor",3)



    graph.connect("lorem","ipsum")
    graph.connect("lorem","dolor", directional = true)

    for (node in graph)
        println(node.key)

    println("\nlorem")
    for (edge in graph.get("lorem")?.edges!!)
        println("Connected to: ${edge.node}")

    println("\ndolor")
    for (edge in graph.get("dolor")?.edges!!)
        println("Connected to: ${edge.node}")

}