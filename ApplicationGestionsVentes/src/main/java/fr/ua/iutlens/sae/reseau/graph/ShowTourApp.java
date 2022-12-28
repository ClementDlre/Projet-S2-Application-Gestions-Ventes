package fr.ua.iutlens.sae.reseau.graph;

import javax.swing.SwingUtilities;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.Graphs;
import org.jgrapht.alg.tour.RandomTourTSP;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

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

public class ShowTourApp extends Application {
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
        	Graph<Point, DefaultWeightedEdge> g = createGraph();
            jgxAdapter = new JGraphXAdapter<>(getRandomTour(g));
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
        // crÃ©ation d'une instance de la classe ReseauRoutier
        ReseauRoutier reseau = new ReseauRoutier();
        // Lecture du fichier contenant la description du rÃ©seau routier
        reseau.lireCarte("reseau.txt");

        // CrÃ©ation d'une reprÃ©sentation du rÃ©seau routier sous la forme d'une classe de la librairie JGraphT
        Graph<Point, DefaultWeightedEdge> g = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        
        
        
        
       
        // Stockage des points et des arÃªtes du rÃ©seau routier dans le graphe de la librairie JGraphT.
        for (Point p : reseau.getPoints())
            g.addVertex(p);
        
       
        
        for (Arete a : reseau.getRoutes()) {
            // Ajout d'une arÃªte : 2 points et une pondÃ©ration
            Graphs.addEdge(g,reseau.getPointById(a.getIdP1()), reseau.getPointById(a.getIdP2()), a.getPoids()) ;
        }

        Graphs.addEdge(g,reseau.getPointById(4), reseau.getPointById(2), 10) ;
        
        

        return g;
    }
    
    
    private Graph<Point, DefaultWeightedEdge> getRandomTour(Graph<Point, DefaultWeightedEdge> g){
    	// crÃ©ation d'une instance de la classe ReseauRoutier
        ReseauRoutier reseau = new ReseauRoutier();
        // Lecture du fichier contenant la description du rÃ©seau routier
        reseau.lireCarte("reseau.txt");
        
    	RandomTourTSP<Point, DefaultWeightedEdge> generateurDeTour = new RandomTourTSP<Point, DefaultWeightedEdge>();
        GraphPath<Point, DefaultWeightedEdge> path = generateurDeTour.getTour(g);
        
        
        java.util.List<DefaultWeightedEdge> listeAretes = path.getEdgeList();
        
        
        Graph<Point, DefaultWeightedEdge> g2 = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);


     // Stockage des points et des arÃªtes du rÃ©seau routier dans le graphe de la librairie JGraphT.
        for (Point p : reseau.getPoints())
            g2.addVertex(p);
        
       
        System.out.println(listeAretes);
        
        
        for (Arete a : reseau.getRoutes()) {
        	System.out.println("a : "+a.getIdP1() + " " + a.getIdP2());
        	for (DefaultWeightedEdge a2 : listeAretes) {
        		System.out.println(a2.toString().substring(10, 11));

        		System.out.println(a2.toString().substring(34, 35));
        		
        		if ((Integer.toString(a.getIdP1()).equals(a2.toString().substring(10, 11))) && (Integer.toString(a.getIdP2()).equals(a2.toString().substring(34, 35)))){
        			System.out.println("TESTESTSETSTS");
        			// Ajout d'une arÃªte : 2 points et une pondÃ©ration
                    Graphs.addEdge(g2,reseau.getPointById(a.getIdP1()), reseau.getPointById(a.getIdP2()), a.getPoids()) ;
        		}
        		System.out.println("a2 : "+a2.toString());
        		
        	}
            
        }
 
    	return g2;
    }


}
