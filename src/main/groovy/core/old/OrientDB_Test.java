package core.old;

import com.orientechnologies.orient.core.record.OVertex;
import core.application.gui.graphFxComponent.odb.GraphDb;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrientDB_Test {
    String dirIn = "D:\\temp\\in\\";
    String dirOut = "D:\\temp\\out\\";
    //    String imageFile = "star3.png";
    //    String edgesFile = "edges.edg";
    //    String vertexesFile = "vertexes.edg";
    String asciiFile1 = "1mlnascii.txt";
    String asciiFile2 = "10symbols.txt";
    String asciiFile3 = "10k.txt";
    String asciiFile4 = "1k.txt";

    String ascii = new String("Кластер (англ. cluster — скопление, кисть, рой) — объединение нескольких однородных элементов, которое может рассматриваться как самостоятельная единица, обладающая определёнными свойствами.\n" +
            "\n" +
            "В информационных технологиях:\n" +
            "\n" +
            "Кластер как подмножество результатов поиска, связанных единством темы;\n" +
            "Кластер — единица хранения данных на гибких и жёстких дисках компьютеров;\n" +
            "Кластер — группа компьютеров, объединённых высокоскоростными каналами связи и представляющая с точки зрения пользователя единый аппаратный ресурс;\n" +
            "также — группа серверов, объединённых логически, способных обрабатывать идентичные запросы и использующихся как единый ресурс;\n" +
            "Кластер — объект, обеспечивающий физически объединённое хранение данных из различных таблиц для ускорения выполнения сложных запросов, используемый в Oracle Database.\n" +
            "В математике:\n" +
            "\n" +
            "Кластер — класс родственных элементов статистической совокупности.\n" +
            "В астрономии:\n" +
            "\n" +
            "Звёздный кластер (звёздное скопление) — группа звёзд, связанных друг с другом силами гравитации;\n" +
            "Галактический кластер — суперструктура, состоящая из нескольких галактик.");
    String ascii2 = new String(" and now I add more different data clusters. Кластер (англ. cluster");
    String ascii3 = new String("Кластер (нгл. cluster — скопление, кисть, рой) cluster");

    GraphDb graphDb;

    @Before
    public void beforTest() {
        this.graphDb = new GraphDb("remote:localhost", "ai", "root", "12345678");
        graphDb.connect();
    }

    @After
    public void afterTest() {
        graphDb.disconnect();
    }

    @Test
    public void strToGraphDb() {
        String str = "dogs and cats live together.";
//        String str = "dogs";
        OVertex parentV = this.graphDb.strToGraph(str);
        System.out.println(parentV.getIdentity());
    }

    @Test
    public void deleteAllEdgesAndVertes() {
        this.graphDb.deleteAllEdges(GraphDb.oClassEPrevNext);
        this.graphDb.deleteAllEdges(GraphDb.oClassEParent);
        this.graphDb.deleteAllEdges(GraphDb.oClassELink);

        this.graphDb.deleteAllVertexes(GraphDb.oClassVLink);
        this.graphDb.deleteAllVertexes(GraphDb.oClassVParent);
        this.graphDb.deleteAllVertexes(GraphDb.oClassVDataChar);
    }

//    @Test
//    public void createClusterSequenceFromTxtFileUtf8() {
//        Cluster clSeq = this.graph.txtFileUtf8ToClusterSequence(new File(dirIn + asciiFile4));
//        this.graph.save(clSeq);
//    }

}

