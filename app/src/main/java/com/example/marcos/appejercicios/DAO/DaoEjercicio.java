package com.example.marcos.appejercicios.DAO;

import android.net.Uri;

import com.example.marcos.appejercicios.Model.Aparato;
import com.example.marcos.appejercicios.Model.Ejercicio;
import com.example.marcos.appejercicios.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcos on 24-Jan-18.
 */

public class DaoEjercicio {
    List<Ejercicio> ejercicioList = new ArrayList<>();

    // TODO -- Borrar cuando se use Json


    //Buscar Ejercicios por Aparato
    public List<Ejercicio> listaEjsAparato(Aparato aparato){

        return ejercicioList;
    }

    //Buscar todos los Ejercicios
    public List<Ejercicio> buscarEjercicios( ){
        ejercicioList.add(ejercicio1);
        ejercicioList.add(ejercicio2);
        ejercicioList.add(ejercicio3);
        ejercicioList.add(ejercicio4);
        ejercicioList.add(ejercicio5);
        ejercicioList.add(ejercicio6);
        ejercicioList.add(ejercicio7);
        ejercicioList.add(ejercicio8);
        ejercicioList.add(ejercicio9);
        ejercicioList.add(ejercicio10);
        ejercicioList.add(ejercicio11);
        ejercicioList.add(ejercicio12);
        ejercicioList.add(ejercicio13);
        ejercicioList.add(ejercicio14);
        ejercicioList.add(ejercicio15);
        ejercicioList.add(ejercicio16);
        ejercicioList.add(ejercicio17);
        ejercicioList.add(ejercicio18);
        ejercicioList.add(ejercicio19);
        ejercicioList.add(ejercicio20);
        ejercicioList.add(ejercicio21);
        ejercicioList.add(ejercicio22);
        ejercicioList.add(ejercicio30);
        ejercicioList.add(ejercicio31);
        ejercicioList.add(ejercicio32);
        ejercicioList.add(ejercicio33);
        ejercicioList.add(ejercicio34);
        ejercicioList.add(ejercicio35);
        ejercicioList.add(ejercicio36);
        ejercicioList.add(ejercicio37);
        ejercicioList.add(ejercicio38);
        ejercicioList.add(ejercicio40);
        ejercicioList.add(ejercicio41);
        ejercicioList.add(ejercicio42);
        ejercicioList.add(ejercicio43);
        ejercicioList.add(ejercicio44);
        ejercicioList.add(ejercicio45);
        ejercicioList.add(ejercicio46);
        ejercicioList.add(ejercicio47);
        ejercicioList.add(ejercicio48);
        ejercicioList.add(ejercicio50);
        ejercicioList.add(ejercicio51);
        ejercicioList.add(ejercicio52);
        ejercicioList.add(ejercicio53);
        ejercicioList.add(ejercicio54);
        ejercicioList.add(ejercicio55);
        ejercicioList.add(ejercicio56);
        ejercicioList.add(ejercicio57);
        ejercicioList.add(ejercicio58);
        ejercicioList.add(ejercicio60);
        ejercicioList.add(ejercicio61);
        ejercicioList.add(ejercicio62);
        ejercicioList.add(ejercicio63);
        ejercicioList.add(ejercicio64);
        ejercicioList.add(ejercicio65);
        ejercicioList.add(ejercicio66);
        ejercicioList.add(ejercicio67);
        ejercicioList.add(ejercicio68);
        ejercicioList.add(ejercicio70);
        ejercicioList.add(ejercicio71);
        ejercicioList.add(ejercicio72);
        ejercicioList.add(ejercicio73);
        ejercicioList.add(ejercicio74);
        ejercicioList.add(ejercicio75);
        ejercicioList.add(ejercicio76);
        ejercicioList.add(ejercicio77);
        ejercicioList.add(ejercicio78);
        ejercicioList.add(ejercicio80);
        ejercicioList.add(ejercicio81);
        ejercicioList.add(ejercicio82);
        ejercicioList.add(ejercicio83);
        ejercicioList.add(ejercicio84);
        ejercicioList.add(ejercicio85);
        ejercicioList.add(ejercicio86);
        ejercicioList.add(ejercicio87);
        ejercicioList.add(ejercicio88);
        ejercicioList.add(ejercicio90);
        ejercicioList.add(ejercicio91);
        ejercicioList.add(ejercicio92);
        ejercicioList.add(ejercicio93);
        ejercicioList.add(ejercicio94);
        ejercicioList.add(ejercicio95);
        ejercicioList.add(ejercicio96);
        ejercicioList.add(ejercicio97);
        ejercicioList.add(ejercicio98);
        ejercicioList.add(ejercicio100);
        ejercicioList.add(ejercicio101);
        ejercicioList.add(ejercicio102);
        ejercicioList.add(ejercicio103);
        ejercicioList.add(ejercicio104);
        ejercicioList.add(ejercicio105);
        ejercicioList.add(ejercicio106);
        ejercicioList.add(ejercicio107);
        ejercicioList.add(ejercicio108);
        return ejercicioList;
    }



    //Buscar Ejercicio por tipo (Musculacion, aerobicos)
    public List<Ejercicio> buscarEjsTipo(String tipoEj){
        List<Ejercicio> listaEjTipo = new ArrayList<>();
        List<Ejercicio> listaglobal = buscarEjercicios();
        for(Ejercicio ejercicio: listaglobal){
            if(ejercicio.getTipoEjercicio().equals(tipoEj)){
                listaEjTipo.add(ejercicio);
            }
        }
        return listaEjTipo;
    }

    //Buscar Ejercicio por aparato
    public List<Ejercicio> buscarEjAparato(String aparato){
        List<Ejercicio> listaEjercicioAparato = new ArrayList<>();
        List<Ejercicio> listaglobal = buscarEjercicios();
        for(Ejercicio ejercicio: listaglobal){
            if(ejercicio.getAparato().equals(aparato)){
                listaEjercicioAparato.add(ejercicio);
            }
        }
        return listaEjercicioAparato;
    }

    //Buscar EjercicioS por id
    public List<Ejercicio> buscarEjsPorId(List<Integer> idList){
        List<Ejercicio> listaEjercicioId = new ArrayList<>();
        List<Ejercicio> listaglobal = buscarEjercicios();
        for(Integer id: idList){
            for(Ejercicio ejercicio: listaglobal){
                if(ejercicio.getId().equals(id)){
                    listaEjercicioId.add(ejercicio);
                }
            }
        }

        return listaEjercicioId;
    }

    //Buscar Ejercicio por id
    public Ejercicio buscarEjPorId(Integer id){
        Ejercicio ejercicioBuscado = null;
        List<Ejercicio> listaglobal = buscarEjercicios();
        for(Ejercicio ejercicio: listaglobal){
            if(ejercicio.getId().equals(id)){
                ejercicioBuscado = ejercicio;
                break;
            }
        }
        return ejercicioBuscado;
    }


    //Variables para videos
    String videoAbdominales = "android.resource://com.example.marcos.appejercicios/"+ R.raw.abdominales;
    String videoBurpees = "android.resource://com.example.marcos.appejercicios/"+ R.raw.burpees;
    String videoCaderas = "android.resource://com.example.marcos.appejercicios/"+ R.raw.caderas;
    String videoEliptica = "android.resource://com.example.marcos.appejercicios/"+ R.raw.eliptica;
    String videoPecho = "android.resource://com.example.marcos.appejercicios/"+ R.raw.pecho_1;
    String videoJumping = "android.resource://com.example.marcos.appejercicios/"+ R.raw.jumping_jacks;
    String videoRodillas = "android.resource://com.example.marcos.appejercicios/"+ R.raw.rodillas_arriba;
    String videoEstiramientoUno = "android.resource://com.example.marcos.appejercicios/"+ R.raw.estiramiento_1;
    String videoEstiramientoAb = "android.resource://com.example.marcos.appejercicios/"+ R.raw.estiramiento_abdominales;
    String videoPiernas = "android.resource://com.example.marcos.appejercicios/"+ R.raw.piernas;
    String videoRemo = "android.resource://com.example.marcos.appejercicios/"+ R.raw.remo;
    String videoSaltos = "android.resource://com.example.marcos.appejercicios/"+ R.raw.saltos_cortos;
    String videoBarras = "android.resource://com.example.marcos.appejercicios/"+ R.raw.barras;

    //Hardcore
    Ejercicio ejercicio1 = new Ejercicio(1,"Abdominales", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_abdominales, videoAbdominales, "x12", "Abdominales", "aerobico", "Andador");
    Ejercicio ejercicio2 = new Ejercicio(2,"Burpees", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_flexiones, videoBurpees, "x12", "Piernas", "musculacion", "Remo" );
    Ejercicio ejercicio3 = new Ejercicio(3,"Laterales", R.drawable.dificultad_dos, 15, R.drawable.ejercicio_caderas, videoCaderas, "x12", "Caderas", "aerobico", "nu");
    Ejercicio ejercicio4 = new Ejercicio(4,"Eliptica", R.drawable.dificultad_tres, 25, R.drawable.ejercicio_eliptica, videoEliptica, "x12", "Piernas", "aerobico", "Andador");
    Ejercicio ejercicio5 = new Ejercicio(5,"Estiramiento Brazos", R.drawable.dificultad_tres, 15, R.drawable.estiramiento_brazos, videoEstiramientoUno, "x12", "Torso", "aerobico", "Andador");
    Ejercicio ejercicio6 = new Ejercicio(6,"Oblicuos", R.drawable.dificultad_tres, 15, R.drawable.estiramiento_gluteos, videoEstiramientoAb, "x12", "Piernas", "funcional", "Andador");
    Ejercicio ejercicio7 = new Ejercicio(7,"Jumping Jacks", R.drawable.dificultad_dos, 15, R.drawable.ejercicios_jumping_jacks, videoJumping, "x12", "Torso", "funcional", "Remo");
    Ejercicio ejercicio8 = new Ejercicio(8,"Pectorales", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_brazos_3, videoPecho, "x12", "Pectorales", "funcional", "Remo");
    Ejercicio ejercicio9 = new Ejercicio(9,"Isquiotibiales", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_piernas, videoPiernas, "x12", "Piernas", "funcional", "Remo");
    Ejercicio ejercicio10 = new Ejercicio(10,"Remo", R.drawable.dificultad_dos, 15, R.drawable.ejercicio_remo, videoRemo, "x12", "Espalda", "funcional", "Remo");
    Ejercicio ejercicio11 = new Ejercicio(11,"Rodillas Arriba", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_rodillas_arriba, videoRodillas, "x12", "Piernas", "funcional", "Remo");
    Ejercicio ejercicio12 = new Ejercicio(12,"Multi Salto", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_pasadas_2, videoSaltos, "x12", "Piernas", "funcional", "Remo");
    Ejercicio ejercicio13 = new Ejercicio(13,"Remo", R.drawable.dificultad_dos, 15, R.drawable.ejercicio_remo, videoRemo, "x12", "Espalda", "musculacion", "Remo");
    Ejercicio ejercicio14 = new Ejercicio(14,"Rodillas Arriba", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_rodillas_arriba, videoRodillas, "x12", "Piernas", "aerobico", "Remo");
    Ejercicio ejercicio15= new Ejercicio(15,"Multi Salto", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_pasadas_2, videoSaltos, "x12", "Piernas", "aerobico", "Remo");
    Ejercicio ejercicio16 = new Ejercicio(16,"Burpees", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_flexiones, videoBurpees, "x12", "Piernas", "aerobico", "Remo" );
    Ejercicio ejercicio17 = new Ejercicio(17,"Isquiotibiales", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_piernas, videoPiernas, "x12", "Piernas", "musculacion", "Remo");
    Ejercicio ejercicio18 = new Ejercicio(18,"Abdominales", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_abdominales, videoAbdominales, "x12", "Abdominales", "musculacion", "Andador");
    Ejercicio ejercicio19 = new Ejercicio(19,"Multi Salto", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_pasadas_2, videoSaltos, "x12", "Piernas", "musculacion", "Remo");
    Ejercicio ejercicio20 = new Ejercicio(20,"Oblicuos", R.drawable.dificultad_tres, 15, R.drawable.estiramiento_gluteos, videoEstiramientoAb, "x12", "Piernas", "musculacion", "Andador");
    Ejercicio ejercicio21 = new Ejercicio(21,"Jumping Jacks", R.drawable.dificultad_dos, 15, R.drawable.ejercicios_jumping_jacks, videoJumping, "x12", "Torso", "musculacion", "Remo");
    Ejercicio ejercicio22 = new Ejercicio(22,"Rodillas Arriba", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_rodillas_arriba, videoRodillas, "x12", "Piernas", "musculacion", "Remo");

    //Ejercicios para aparatos -------------------------------------------------
    //Plancha
    Ejercicio ejercicio30 = new Ejercicio(30,"Abdominales inferiores", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_abdominales, videoAbdominales, "x12", "Abdominales", "aerobico", "Andador");
    Ejercicio ejercicio31 = new Ejercicio(31,"Abdominales superiores", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_abdominales, videoAbdominales, "x12", "Abdominales", "aerobico", "Andador");
    Ejercicio ejercicio32 = new Ejercicio(32,"Abdominales laterales", R.drawable.dificultad_dos, 15, R.drawable.ejercicio_abdominales, videoAbdominales, "x12", "Abdominales", "aerobico", "Andador");
    Ejercicio ejercicio33 = new Ejercicio(33,"Oblicuos inferior", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_abdominales, videoAbdominales, "x12", "Abdominales", "aerobico", "Andador");
    Ejercicio ejercicio34 = new Ejercicio(34,"Oblicuo superior", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_abdominales, videoAbdominales, "x12", "Abdominales", "aerobico", "Andador");
    Ejercicio ejercicio35 = new Ejercicio(35,"Barca", R.drawable.dificultad_dos, 15, R.drawable.ejercicio_abdominales, videoAbdominales, "x12", "Abdominales", "aerobico", "Andador");
    Ejercicio ejercicio36 = new Ejercicio(36,"Lumbares", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_abdominales, videoAbdominales, "x12", "Abdominales", "aerobico", "Andador");
    Ejercicio ejercicio37 = new Ejercicio(37,"Transverso", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_abdominales, videoAbdominales, "x12", "Abdominales", "aerobico", "Andador");
    Ejercicio ejercicio38 = new Ejercicio(38,"Piramidal", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_abdominales, videoAbdominales, "x12", "Abdominales", "aerobico", "Andador");

    //Barra
    Ejercicio ejercicio40 = new Ejercicio(40,"Dominadas estrictas", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_barra, videoBarras, "x12", "Trapecio", "aerobico", "Andador");
    Ejercicio ejercicio41 = new Ejercicio(41,"Agarre abierto", R.drawable.dificultad_dos, 15, R.drawable.ejercicio_barra, videoBarras, "x12", "Dorsal ", "aerobico", "Andador");
    Ejercicio ejercicio42 = new Ejercicio(42,"Agarre neutro", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_barra, videoBarras, "x12", "Romboides", "aerobico", "Andador");
    Ejercicio ejercicio43 = new Ejercicio(43,"Kipping", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_barra, videoBarras, "x12", "Trapecio", "aerobico", "Andador");
    Ejercicio ejercicio44 = new Ejercicio(44,"Dominadas supinas", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_barra, videoBarras, "x12", "Dorsal ", "aerobico", "Andador");
    Ejercicio ejercicio45 = new Ejercicio(45,"Pies a la barra", R.drawable.dificultad_dos, 15, R.drawable.ejercicio_barra, videoBarras, "x12", "Romboides", "aerobico", "Andador");
    Ejercicio ejercicio46 = new Ejercicio(46,"Rodillas a los codos", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_barra, videoBarras, "x12", "Escápula", "aerobico", "Andador");
    Ejercicio ejercicio47 = new Ejercicio(47,"Isométricas", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_barra, videoBarras, "x12", "Trapecio", "aerobico", "Andador");
    Ejercicio ejercicio48 = new Ejercicio(48,"Excéntricas", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_barra, videoBarras, "x12", "Dorsal ", "aerobico", "Andador");

    //Ascensor
    Ejercicio ejercicio50 = new Ejercicio(50,"Pectorales extendidos", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_brazos_1, videoPecho, "x12", "Pectoral mayor", "aerobico", "Andador");
    Ejercicio ejercicio51 = new Ejercicio(51,"Pectorales inferiroes", R.drawable.dificultad_dos, 15, R.drawable.ejercicio_brazos_2, videoPecho, "x12", "Pectoral menor", "aerobico", "Andador");
    Ejercicio ejercicio52 = new Ejercicio(52,"Pectorales Superiores", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_brazos_3, videoPecho, "x12", "Serrato anterior", "aerobico", "Andador");
    Ejercicio ejercicio53 = new Ejercicio(53,"Pectorales laterales", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_brazos_4, videoPecho, "x12", "Pectoral mayor", "aerobico", "Andador");
    Ejercicio ejercicio54 = new Ejercicio(54,"Triceps", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_brazos_1, videoPecho, "x12", "Biceps", "aerobico", "Andador");
    Ejercicio ejercicio55 = new Ejercicio(55,"Apertura estrictas", R.drawable.dificultad_dos, 15, R.drawable.ejercicio_brazos_1, videoPecho, "x12", "Pectoral menor", "aerobico", "Andador");
    Ejercicio ejercicio56 = new Ejercicio(56,"Agarre abierto", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_brazos_1, videoPecho, "x12", "Hombros", "aerobico", "Andador");
    Ejercicio ejercicio57 = new Ejercicio(57,"Agarre neutro", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_brazos_2, videoPecho, "x12", "Serrato anterior", "aerobico", "Andador");
    Ejercicio ejercicio58 = new Ejercicio(58,"Kipping", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_brazos_3, videoPecho, "x12", "Pectoral mayor", "aerobico", "Andador");

    //Barras paralelas
    Ejercicio ejercicio60 = new Ejercicio(60,"Triceps extendidos", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_piernas, videoPiernas, "x12", "Biceps", "aerobico", "Andador");
    Ejercicio ejercicio61 = new Ejercicio(61,"Triceps inferiroes", R.drawable.dificultad_dos, 15, R.drawable.ejercicio_piernas, videoPiernas, "x12", "Triceps", "aerobico", "Andador");
    Ejercicio ejercicio62 = new Ejercicio(62,"Izquiotibiales", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_piernas, videoPiernas, "x12", "Deltoides anterior", "aerobico", "Andador");
    Ejercicio ejercicio63 = new Ejercicio(63,"Cuadriceps", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_piernas, videoPiernas, "x12", "Deltoides posterior", "aerobico", "Andador");
    Ejercicio ejercicio64 = new Ejercicio(64,"Abdominales bajos", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_piernas, videoPiernas, "x12", "Deltoides medio", "aerobico", "Andador");
    Ejercicio ejercicio65 = new Ejercicio(65,"Espalda", R.drawable.dificultad_dos, 15, R.drawable.ejercicio_piernas, videoPiernas, "x12", "Triceps", "aerobico", "Andador");
    Ejercicio ejercicio66 = new Ejercicio(66,"Agarre abierto", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_piernas, videoPiernas, "x12", "Lateral", "aerobico", "Andador");
    Ejercicio ejercicio67 = new Ejercicio(67,"Agarre neutro", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_piernas, videoPiernas, "x12", "Oblicuo", "aerobico", "Andador");
    Ejercicio ejercicio68 = new Ejercicio(68,"Hombros", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_piernas, videoPiernas, "x12", "Hombros", "aerobico", "Andador");

    //Pasadas
    Ejercicio ejercicio70 = new Ejercicio(70,"Saltos", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_pasadas, videoSaltos, "x12", "Aductores", "aerobico", "Andador");
    Ejercicio ejercicio71 = new Ejercicio(71,"Saltos extendidos", R.drawable.dificultad_dos, 15, R.drawable.ejercicio_pasadas_2, videoSaltos, "x12", "Izquiotibiales", "aerobico", "Andador");
    Ejercicio ejercicio72 = new Ejercicio(72,"Cohete", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_pasadas, videoSaltos, "x12", "Sóleos", "aerobico", "Andador");
    Ejercicio ejercicio73 = new Ejercicio(73,"Cuadriceps", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_pasadas_2, videoSaltos, "x12", "Sóleos", "aerobico", "Andador");
    Ejercicio ejercicio74 = new Ejercicio(74,"Zancadas", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_pasadas, videoSaltos, "x12", "Abdominales", "aerobico", "Andador");
    Ejercicio ejercicio75 = new Ejercicio(75,"Bridge", R.drawable.dificultad_dos, 15, R.drawable.ejercicio_pasadas_2, videoSaltos, "x12", "Aductores", "aerobico", "Andador");
    Ejercicio ejercicio76 = new Ejercicio(76,"Glúteos mayor", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_pasadas, videoSaltos, "x12", "Izquiotibiales", "aerobico", "Andador");
    Ejercicio ejercicio77 = new Ejercicio(77,"Glúteos menor", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_pasadas_2, videoSaltos, "x12", "Abdominales", "aerobico", "Andador");
    Ejercicio ejercicio78 = new Ejercicio(78,"Gemelos", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_pasadas, videoSaltos, "x12", "Abdominales", "aerobico", "Andador");

    //Eliptica
    Ejercicio ejercicio80 = new Ejercicio(80,"Eliptica", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_eliptica, videoEliptica, "x12", "Aductores", "aerobico", "Andador");
    Ejercicio ejercicio81 = new Ejercicio(81,"Eliptica inversa", R.drawable.dificultad_dos, 15, R.drawable.ejercicio_eliptica, videoEliptica, "x12", "Sóleos", "aerobico", "Andador");
    Ejercicio ejercicio82 = new Ejercicio(82,"Glúteos mayor", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_eliptica, videoEliptica, "x12", "Izquiotibiales", "aerobico", "Andador");
    Ejercicio ejercicio83 = new Ejercicio(83,"Cuadriceps", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_eliptica, videoEliptica, "x12", "Aductores", "aerobico", "Andador");
    Ejercicio ejercicio84 = new Ejercicio(84,"Glúteos menor", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_eliptica, videoEliptica, "x12", "Aductores", "aerobico", "Andador");
    Ejercicio ejercicio85 = new Ejercicio(85,"Aductores", R.drawable.dificultad_dos, 15, R.drawable.ejercicio_eliptica, videoEliptica, "x12", "Izquiotibiales", "aerobico", "Andador");
    Ejercicio ejercicio86 = new Ejercicio(86,"Izquiotibiales", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_eliptica, videoEliptica, "x12", "Izquiotibiales", "aerobico", "Andador");
    Ejercicio ejercicio87 = new Ejercicio(87,"Sóleos", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_eliptica, videoEliptica, "x12", "Aductores", "aerobico", "Andador");
    Ejercicio ejercicio88 = new Ejercicio(88,"Gemelos", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_eliptica, videoEliptica, "x12", "Sóleos", "aerobico", "Andador");

    //Surf
    Ejercicio ejercicio90 = new Ejercicio(90,"Laterales", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_caderas, videoCaderas, "x12", "Abdominales", "aerobico", "Andador");
    Ejercicio ejercicio91 = new Ejercicio(91,"Oblicuos", R.drawable.dificultad_dos, 15, R.drawable.ejercicio_caderas, videoCaderas, "x12", "Abdominales", "aerobico", "Andador");
    Ejercicio ejercicio92 = new Ejercicio(92,"Abdominales superior", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_caderas, videoCaderas, "x12", "Abdominales", "aerobico", "Andador");
    Ejercicio ejercicio93 = new Ejercicio(93,"Abdominales inferior", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_caderas, videoCaderas, "x12", "Abdominales", "aerobico", "Andador");
    Ejercicio ejercicio94 = new Ejercicio(94,"Cuádriceps", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_caderas, videoCaderas, "x12", "Abdominales", "aerobico", "Andador");
    Ejercicio ejercicio95 = new Ejercicio(95,"Aductores", R.drawable.dificultad_dos, 15, R.drawable.ejercicio_caderas, videoCaderas, "x12", "Abdominales", "aerobico", "Andador");
    Ejercicio ejercicio96 = new Ejercicio(96,"Izquiotibiales", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_caderas, videoCaderas, "x12", "Abdominales", "aerobico", "Andador");
    Ejercicio ejercicio97 = new Ejercicio(97,"Sóleos", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_caderas, videoCaderas, "x12", "Abdominales", "aerobico", "Andador");
    Ejercicio ejercicio98 = new Ejercicio(98,"Gemelos", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_caderas, videoCaderas, "x12", "Abdominales", "aerobico", "Andador");

    //Remo
    Ejercicio ejercicio100 = new Ejercicio(100,"Laterales", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_remo, videoRemo, "x12", "Laterales", "aerobico", "Andador");
    Ejercicio ejercicio101 = new Ejercicio(101,"Oblicuos", R.drawable.dificultad_dos, 15, R.drawable.ejercicio_remo_2, videoRemo, "x12", "Oblicuos", "aerobico", "Andador");
    Ejercicio ejercicio102 = new Ejercicio(102,"Abdominales superior", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_remo, videoRemo, "x12", "Abdominales", "aerobico", "Andador");
    Ejercicio ejercicio103 = new Ejercicio(103,"Abdominales inferior", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_remo_2, videoRemo, "x12", "Izquiotibiales", "aerobico", "Andador");
    Ejercicio ejercicio104 = new Ejercicio(104,"Cuádriceps", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_remo, videoRemo, "x12", "Laterales", "aerobico", "Andador");
    Ejercicio ejercicio105 = new Ejercicio(105,"Aductores", R.drawable.dificultad_dos, 15, R.drawable.ejercicio_remo_2, videoRemo, "x12", "Abdominales", "aerobico", "Andador");
    Ejercicio ejercicio106 = new Ejercicio(106,"Izquiotibiales", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_remo, videoRemo, "x12", "Izquiotibiales", "aerobico", "Andador");
    Ejercicio ejercicio107 = new Ejercicio(107,"Sóleos", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_remo_2, videoRemo, "x12", "Laterales", "aerobico", "Andador");
    Ejercicio ejercicio108 = new Ejercicio(108,"Gemelos", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_remo, videoRemo, "x12", "Abdominales", "aerobico", "Andador");


}
