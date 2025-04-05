import networkx as nx
import matplotlib.pyplot as plt

G = nx.Graph()
# G = nx.DiGraph() --- Para um grafo direcionado (setas)
# G = nx.MultiGraph() --- Para um grafo com arestas múltiplas (várias arestas entre os mesmos nós)
# G = nx.MultiDiGraph() --- Para um grafo direcionado com arestas múltiplas
G.add_edge(1, 2)
G.add_edge(1, 1)
G.add_edge(2, 3, weigth=0.4)

edge_list = [(1, 2), (1, 3), (2, 3), (3, 4)]
G.add_edges_from(edge_list)

nx.draw_spring(G, with_labels=True)
plt.show(block=True)
nx.draw_spectral(G, with_labels=True)
plt.show(block=True)