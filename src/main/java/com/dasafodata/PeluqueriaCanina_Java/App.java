package com.dasafodata.PeluqueriaCanina_Java;

import com.dasafodata.PeluqueriaCanina_Java.igu.Principal;


public class App {
    public static void main(String[] args) {
    	//Creamos una instancia de la pagina principal que arranque con el main/app
    	Principal princ = new Principal();
    	//la hacemos visible
    	princ.setVisible(true);
    	princ.setLocationRelativeTo(null);

    }
}
