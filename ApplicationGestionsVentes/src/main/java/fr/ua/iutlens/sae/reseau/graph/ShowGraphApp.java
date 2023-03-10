package fr.ua.iutlens.sae.reseau.graph;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.swing.mxGraphComponent;
import fr.ua.iutlens.sae.reseau.Arete;
import fr.ua.iutlens.sae.reseau.Point;
import fr.ua.iutlens.sae.reseau.ReseauRoutier;
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.Graphs;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.tour.RandomTourTSP;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultUndirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import javax.swing.*;
import java.awt.*;

public class ShowGraphApp extends Application {

    private JGraphXAdapter<Point, DefaultWeightedEdge> jgxAdapter;

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param stage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception if something goes wrong
     */
    @Override
    public void start(Stage stage) throws Exception {
        final SwingNode swingNode = new SwingNode();
        createSwingContent(swingNode);
        StackPane pane = new StackPane();
        pane.getChildren().add(swingNode);

        Scene scene = new Scene(pane, 800, 600);

        stage.setScene(scene);
        stage.setTitle("Graphe dans javaFX");
        stage.show();

    }

    private void createSwingContent(final SwingNode swingNode) {
        SwingUtilities.invokeLater(() -> {
            jgxAdapter = new JGraphXAdapter<>(createGraph());
            mxGraphComponent component = new mxGraphComponent(jgxAdapter);
            component.setConnectable(false);
            component.getGraph().setAllowDanglingEdges(false);
            mxCircleLayout layout = new mxCircleLayout(jgxAdapter);

            // center the circle
            int radius = 100;
            layout.setX0((800 / 2.0) - radius);
            layout.setY0((600 / 2.0) - radius);
            layout.setRadius(radius);
            layout.setMoveCircle(true);

            layout.execute(jgxAdapter.getDefaultParent());
            swingNode.setContent(component);
        });
    }

    private Graph<Point, DefaultWeightedEdge> createGraph() {
        // cr????ation d'une instance de la classe ReseauRoutier
        ReseauRoutier reseau = new ReseauRoutier();
        // Lecture du fichier contenant la description du r????seau routier
        reseau.lireCarte("reseau.txt");

        // Cr????ation d'une repr????sentation du r????seau routier sous la forme d'une classe de la librairie JGraphT
        Graph<Point, DefaultWeightedEdge> g = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
        
        //Graph<Point, DefaultWeightedEdge> g2 = new DefaultUndirectedWeightedGraph<>(DefaultWeightedEdge.class);
        
        // Stockage des points et des ar????tes du r????seau routier dans le graphe de la librairie JGraphT.
        for (Point p : reseau.getPoints()) {
            g.addVertex(p);
        //	g2.addVertex(p);
        }
        for (Arete a : reseau.getRoutes()) {
            // Ajout d'une ar????te : 2 points et une pond????ration
            Graphs.addEdge(g,reseau.getPointById(a.getIdP1()), reseau.getPointById(a.getIdP2()), a.getPoids()) ;
        //    Graphs.addEdge(g2,reseau.getPointById(a.getIdP1()), reseau.getPointById(a.getIdP2()), a.getPoids()) ;

        }

        //RandomTourTSP<Point, DefaultWeightedEdge> generateurDeTour = new RandomTourTSP<Point, DefaultWeightedEdge>();
        //GraphPath<Point, DefaultWeightedEdge> path = generateurDeTour.getTour(g2);
        
        //java.util.List<DefaultWeightedEdge> listeAretes = path.getEdgeList();
        //for (int i = 0; i<listeAretes.size(); i++) {
        //	System.out.println(listeAretes.get(i));
        //}
        
        return g;
    }
    


}
