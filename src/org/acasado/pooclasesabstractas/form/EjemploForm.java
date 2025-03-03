package org.acasado.pooclasesabstractas.form;

import org.acasado.pooclasesabstractas.form.elementos.ElementoForm;
import org.acasado.pooclasesabstractas.form.elementos.InputForm;
import org.acasado.pooclasesabstractas.form.elementos.SelectForm;
import org.acasado.pooclasesabstractas.form.elementos.TextareaForm;
import org.acasado.pooclasesabstractas.form.elementos.select.Opcion;
import org.acasado.pooclasesabstractas.form.validador.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploForm {

    public static void main(String[] args) {

        InputForm username = new InputForm("username");
        username.addValidador(new RequeridoValidador());
        InputForm passsword= new InputForm("Clave","Password");
        passsword.addValidador(new RequeridoValidador())
        .addValidador(new LargoValidador(6,12));
        InputForm email= new InputForm("email","email");
        email.addValidador(new RequeridoValidador()).addValidador(new EmailValidador());
        InputForm edad = new InputForm("edad","number");
        edad.addValidador(new NumeroValidador());


        TextareaForm experiencia = new TextareaForm("exp",5,9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidaor());
        Opcion java = new Opcion("1","Java");
        lenguaje.addOpcion(java)

        .addOpcion(new Opcion("2","Phyton"))
        .addOpcion(new Opcion("3","Javasript"))
        .addOpcion(new Opcion("4","TypeScript").setSelected(true))
        .addOpcion(new Opcion("5","PHP"));

        ElementoForm saludar = new ElementoForm("Saludar") {
            @Override
            public String dibujarHtml() {
                return "<input disabled name = '" + this.nombre + "' value=\"" + this.valor + "\">";
            }
        };
        saludar.setValor("Hola que tal este campo esá deshabilitado");
        username.setValor("John.doe");
        passsword.setValor("a123b");
        email.setValor("sofsf@ggmailcom");
        edad.setValor("25");
        experiencia.setValor("..mas de 10 años de experiencia");


      //  java.setSelected(true);
        // Una forma más ordenada de escribir el código.
        List<ElementoForm> elementos = Arrays.asList(username,passsword,email,edad,experiencia,lenguaje,saludar);
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
        elementos.forEach(e->{
            if(!e.esValido()){
                e.getErrores().forEach(System.out::println);


            }


        });

    }
}
