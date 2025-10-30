package it.unibo.generics.graph.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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
    public void addNode(final N node) {
        if (!this.nodes.contains(node) && node != null) {
            this.nodes.add(node);
            this.edges.putIfAbsent(node, new HashSet<>());
        }
    }

    @Override
    public void addEdge(final N source, final N target) {
        if (source != null && target != null && nodes.contains(source) && nodes.contains(source)) {
            edges.get(source).add(target);
        }
    }

    @Override
    public Set<N> nodeSet() {
        return Set.copyOf(nodes);
    }

    @Override
    public Set<N> linkedNodes(final N node) {
        return edges.get(node);
    }

    @Override
    public List<N> getPath(final N source, final N target, final boolean choice) {
        if (choice) {
            return bfs(source, target);
        }

        return dfs(source, target);
    }

    private List<N> bfs(final N source, final N target) {
        /* BFS implementation */
        final Map<N, N> predecessors = new HashMap<>();
        final Queue<N> queue = new LinkedList<>();

        queue.add(source);
        predecessors.put(source, null);

        while (!queue.isEmpty()) {
            final N current = queue.poll();
            if (current.equals(target)) {
                return buildPath(predecessors, target);
            }
            for (final N neighbour : edges.get(current)) {
                if (!predecessors.containsKey(neighbour)) {
                    predecessors.put(neighbour, current);
                    queue.add(neighbour);
                }
            }
        }
        return List.of();
    }

    private List<N> dfs(final N source, final N target) {
        final Map<N, N> predecessors = new HashMap<>();
        final Set<N> visited = new HashSet<>();

        if (dfsVisit(source, target, visited, predecessors)) {
            return buildPath(predecessors, target);
        }

        return List.of();
    }

    private boolean dfsVisit(final N current, final N target, final Set<N> visited, final Map<N, N> predecessors) {
        visited.add(current);
        if (current.equals(target)) {
            return true;
        }

        for (final N adj : edges.get(current)) {
            if (!visited.contains(adj)) {
                predecessors.put(adj, current);
                if (dfsVisit(adj, target, visited, predecessors)) {
                    return true;
                }
            }
        }
        return false;
    }

    private List<N> buildPath(final Map<N, N> predecessors, final N target) {
        final List<N> path = new ArrayList<>();
        for (N step = target; step != null; step = predecessors.get(step)) {
            path.add(step);
        }
        Collections.reverse(path);
        return path;
    }

}
