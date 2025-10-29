package it.unibo.generics.graph.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {
    /*Node set */
    private final Set<N> nodes;
    
    /*Adjacency map: for each node, the set of all the reacheble nodes */
    private final Map<N, Set<N>> edges;

    public GraphImpl() {
        this.nodes = new HashSet<>();
        this.edges = new HashMap<>();
    }

    @Override
    public void addNode(N node) {
        if (!this.nodes.contains(node) && node != null) {
            this.nodes.add(node);
            this.edges.putIfAbsent(node, new HashSet<>());
        }
    }

    @Override
    public void addEdge(N source, N target) {
        if (source != null && target != null && nodes.contains(source) && nodes.contains(source)) {
            edges.get(source).add(target);
        }
    }

    @Override
    public Set<N> nodeSet() {
        return Set.copyOf(nodes);
    }

    @Override
    public Set<N> linkedNodes(N node) {
        return edges.get(node);
    }

    @Override
    public List<N> getPath(N source, N target) {
        return null;
    }

}
