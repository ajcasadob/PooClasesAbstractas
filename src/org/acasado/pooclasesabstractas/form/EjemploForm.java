package org.acasado.pooclasesabstractas.form;

import org.acasado.pooclasesabstractas.form.elementos.ElementoForm;
import org.acasado.pooclasesabstractas.form.elementos.InputForm;
import org.acasado.pooclasesabstractas.form.elementos.SelectForm;
import org.acasado.pooclasesabstractas.form.elementos.TextareaForm;
import org.acasado.pooclasesabstractas.form.elementos.select.Opcion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploForm {

    public static void main(String[] args) {

        InputForm username = new InputForm("username");
        InputForm passsword= new InputForm("Clave","Password");
        InputForm email= new InputForm("email","email");
        InputForm edad = new InputForm("edad","number");


        TextareaForm experiencia = new TextareaForm("exp",5,9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        Opcion java = new Opcion("1","Java");
        lenguaje.addOpcion(java)

        .addOpcion(new Opcion("2","Phyton"))
        .addOpcion(new Opcion("3","Javasript"))
        .addOpcion(new Opcion("4","TypeScript"))
        .addOpcion(new Opcion("5","PHP"));

        username.setValor("John.doe");
        passsword.setValor("a123b");
        email.setValor("sofsfg@gmailcom");
        edad.setValor("25");
        experiencia.setValor("..mas de 10 años de experiencia");


        java.setSelected(true);
        // Una forma más ordenada de escribir el código.
        List<ElementoForm> elementos = Arrays.asList(username,passsword,email,edad,experiencia,lenguaje);
        //List<ElementoForm> elementos = new ArrayList<>();
        /*
        elementos.add(username);
        elementos.add(passsword);
        elementos.add(email);
        elementos.add(edad);
        elementos.add(experiencia);
        elementos.add(lenguaje);*/
    /*
        for (ElementoForm e : elementos){
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        }*/
        //Expresión lambda para abreviar más el código.
    elementos.forEach(e ->{
        System.out.println(e.dibujarHtml());
        System.out.println("<br>");
        });

    }
}
