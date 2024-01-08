package com.example;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class App 
{
    public static void main( String[] args ) throws Exception
    {     
        Alunno a = new Alunno("Charles", "Leclerc", new Date(2004,05,4));
        Alunno b = new Alunno("Steph", "Curry", new Date(2002,12,01));
        Alunno c = new Alunno("Giannis", "Antetokounmpo", new Date(2001,01,13));
        Alunno d = new Alunno("Max", "Verstappen", new Date(2000,05,17));

        ArrayList <Alunno> arrayAlunni = new ArrayList<Alunno>();
        arrayAlunni.add(a);
        arrayAlunni.add(b);
        arrayAlunni.add(c);
        arrayAlunni.add(d);

        Classe c1 = new Classe(5, "BIA", "18-TW", arrayAlunni);

        System.out.println("------- XML -------");
        XmlMapper xmlMapper = new XmlMapper();

        xmlMapper.writeValue(new File("prova.xml"), c1);

        Classe c2 = xmlMapper.readValue(new File("prova.xml"), Classe.class);
        System.out.println("Numero classe: " + c2.getNumero());
        System.out.println("Sezione classe: " + c2.getSezione());
        System.out.println("Aula classe: " + c2.getAula() + "\n");

        for(int i = 0; i < c2.getAlunni().size(); i ++){
            System.out.println("Nome alunno " + (i + 1) + ": " + c2.getAlunni().get(i).getNome());
        }
    }
}