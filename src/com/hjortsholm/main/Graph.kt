package com.hjortsholm.main

import java.util.*

class Graph<V,C>: Iterable<MutableMap.MutableEntry<String, Node<V,C>>> {

    override fun iterator(): Iterator<MutableMap.MutableEntry<String, Node<V,C>>> = graph.iterator().iterator()

    val size: Int
        get() = graph.size

    var graph: HashMap<String, Node<V,C>> = hashMapOf()

    fun get(node: String) = graph.get(node)

    fun set(node: String, value: V) {
        val edge = graph.getOrDefault(node,Node(value))
        graph[node] = edge
    }

    fun containsNode(node: String) = graph.containsKey(node)

    fun isConnected(a: String, b: String): Boolean = (get(a)?.edges?.count { node ->
        node.node == b
    }!! > 0 )

    fun connect(a: String, b: String, ab: C? = null, ba: C? = null, directional: Boolean = false) {
        get(a)?.edges?.add(Edge(b,ab))
        if (!directional )
            get(b)?.edges?.add(Edge(a, ba))
    }

    override fun toString(): String = "Graph[${graph.values}]"
}


class Edge<C>(val node: String, val cost: C? = null) {
    override fun toString(): String = "Edge[$node:$cost]"

}

class Node<V,C>(val value: V, val edges: ArrayList<Edge<C>> = arrayListOf()) {
    override fun toString(): String = "Node[$value: ${Arrays.toString(edges.toArray())}]"
}
